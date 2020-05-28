package myCollection.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import myCollection.model.CollectionBean;
import myCollection.model.CollectionDetail;
import myCollection.model.CollectionGroup;
import myCollection.model.UpdateCollectionsException;

@Repository
public class MyCollectionDaoImpl implements MyCollectionDao {
	
	@Autowired
	SessionFactory factory;
	@Autowired
	CollectionGroup collectionGroup;
	@Autowired
	CollectionDetail collectionDetail;


	public Session getSession() {
		return factory.getCurrentSession();
	}

	@Override
	public Map<Long, String> queryCollectionGroups(Integer memberRegNo) {
		Map<Long, String> collectionGroupMap = new LinkedHashMap<>();
		String hql1 = "SELECT new map(group.collectGroupNo as gNo,group.collectGroupName as gName) "
				+ "FROM CollectionGroup group  WHERE group.memberRegNo = :memberRegNo "
				+ "order by group.collectGroupNo asc";

		Long collectGroupNo = null;
		String collectGroupName = "";

		try {
			Query query = getSession().createQuery(hql1).setParameter("memberRegNo", memberRegNo);
			List<Map> data = query.list();
			for (int i = 0; i < data.size(); i++) {
				Map map = data.get(i);
				collectGroupNo = ((Number) map.get("gNo")).longValue();
				collectGroupName = (String) map.get("gName");
				collectionGroupMap.put(collectGroupNo, collectGroupName);
			}
			return collectionGroupMap;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("發生SQL例外: " + e.getMessage());
		}
	}

	@Override
	public Map<Integer, List<CollectionBean>> queryCollections(Integer memberRegNo) {

		Map<Integer, List<CollectionBean>> collectionsMap = new LinkedHashMap<>();
		String hql1 = "SELECT group.collectGroupNo FROM CollectionGroup group"
				+ "  WHERE group.memberRegNo = :memberRegNo";

		String hql2 = "SELECT new myCollection.model.CollectionBean(CD.collectDetailNo as collectNo, CG.collectGroupNo as collectGNo,"
				+ "CG.collectGroupName as collectGName," + "CG.memberRegNo as collectMNo,"
				+ "(CASE WHEN M.memberNic IS NULL THEN M.memberName ELSE M.memberNic END) as collectMName,"
				+ "M.memberPic as collectMPic," + "CD.publishNo as collectPNo,"
				+ "P.myTitle as collectPTitle) FROM CollectionDetail CD"
				+ "  LEFT JOIN MyPublishBean P on P.publishNo = CD.publishNo " 
				+ "  LEFT JOIN CD.collectionGroup CG"
				+ "  LEFT JOIN MemberBean M on P.memberRegNo = M.memberRegNo"
				+ " WHERE CG.collectGroupNo = :collectGroupNo";
		Integer collectGroupNo = null;
		List<Integer> collectionGList = new ArrayList<Integer>();
		try {
			Query query = getSession().createQuery(hql1).setParameter("memberRegNo", memberRegNo);
			List data = query.list();
			for (int i = 0; i < data.size(); i++) {
				collectGroupNo = (Integer) data.get(i);
				collectionGList.add(collectGroupNo);
			}

			for (int i = 0; i < collectionGList.size(); i++) {
				List<CollectionBean> collctions = new ArrayList<>();
				CollectionBean collection = null;

				Query query2 = getSession().createQuery(hql2).setParameter("collectGroupNo", collectionGList.get(i));
				collctions = query2.list();
				collectionsMap.put(collectionGList.get(i), collctions);
			}
			return collectionsMap;

		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("發生SQL例外: " + e.getMessage());
		}
	}

	@Override
	public void updateCollectionGroup(String newCollectGName, Integer collectGNo) throws UpdateCollectionsException {
		String hql = "UPDATE CollectionGroup CG SET CG.collectGroupName = :newCollectGName WHERE CG.collectGroupNo = :collectGNo";
		int n = 0;
		try {
			@SuppressWarnings("unchecked")
			Query<CollectionGroup> query = getSession().createQuery(hql);
			query.setParameter("newCollectGName", newCollectGName);
			query.setParameter("collectGNo", collectGNo);
			n = query.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("發生SQL例外: " + e.getMessage());
		}

		if (n < 1) {
			throw new UpdateCollectionsException("更新失敗");
		} else {
			;
		}
	}

	@Override
	public void delCollectionGroup(Integer collectGNo) throws UpdateCollectionsException {
		try {
			CollectionGroup collectionGroup = getSession().get(CollectionGroup.class, collectGNo);
			if (collectionGroup != null) {
				getSession().delete(collectionGroup);
			} else {
				throw new UpdateCollectionsException("刪除失敗");
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("發生SQL例外: " + e.getMessage());
		}
	}

	@Override
	public void insertCollectionGroup(Integer memberRegNo, String newCollectGName) {
		CollectionGroup collectionGroup = new CollectionGroup();
		collectionGroup.setMemberRegNo(memberRegNo);
		collectionGroup.setCollectGroupName(newCollectGName);
		getSession().save(collectionGroup);

	}

	@Override
	public void delCollectionDetail(Integer collectNo) throws UpdateCollectionsException {
		try {
			CollectionDetail collectionDetail = getSession().get(CollectionDetail.class, collectNo);
			if (collectionDetail != null) {
				getSession().delete(collectionDetail);
			} else {
				throw new UpdateCollectionsException("刪除失敗");
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("發生SQL例外: " + e.getMessage());
		}
	}

	@Override
	public void insertCollection(Integer memberRegNo,Integer publishNo) {
		try {
			String hql1="from CollectionGroup CG where CG.collectGroupName = '未分類' and CG.memberRegNo = :memberRegNo";
			Query<?> query=getSession().createQuery(hql1).setParameter("memberRegNo", memberRegNo);
			List<?> data =query.list();
			if(data.size()==0) {
				collectionGroup.setMemberRegNo(memberRegNo);
				collectionGroup.setCollectGroupName("未分類");
				getSession().save(collectionGroup);
				query=getSession().createQuery(hql1).setParameter("memberRegNo", memberRegNo);
				data =query.list();
			}
			
			collectionGroup = (CollectionGroup) data.get(0);
			collectionDetail.setCollectionGroup(collectionGroup);
			collectionDetail.setPublishNo(publishNo);
			getSession().save(collectionDetail);
			
		}catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("發生SQL例外: " + e.getMessage());
		}
	}

	@Override
	public void delCollectionDetailBySkill(Integer memberRegNo, Integer publishNo) {
		try {
			String hql1 = "select CD from CollectionDetail CD left join CD.collectionGroup CG "
					+ "where CG.memberRegNo = :memberRegNo and CD.publishNo = :publishNo";
			@SuppressWarnings("unchecked")
			Query<CollectionDetail> query = getSession().createQuery(hql1);
			query.setParameter("memberRegNo", memberRegNo);
			query.setParameter("publishNo", publishNo);
			List<CollectionDetail> data = query.list();
			
			if (data.size()>0) {
				collectionDetail = data.get(0);
				getSession().delete(collectionDetail);
			} else {
				throw new UpdateCollectionsException("刪除失敗");
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("發生SQL例外: " + e.getMessage());
		}
	}

	@Override
	public Integer queryUncatogryColletions(Integer memberRegNo) {
		Integer collectNo;
		Integer collectGNo;
		String hql="select new map(CD.collectDetailNo as collectNo,CG.collectGroupNo as collectGNo) from CollectionDetail CD right join CD.collectionGroup CG "
				+ "where CG.memberRegNo = :memberRegNo and CG.collectGroupName='未分類'";
		Query<?> query = getSession().createQuery(hql).setParameter("memberRegNo", memberRegNo);
		List<Map> data = (List<Map>) query.list();
		for(Map map:data) {
			collectNo=(Integer) map.get("collectNo");
			collectGNo=(Integer) map.get("collectGNo");
			if(collectNo==null) {
				return collectGNo;
			}
		}
		return 0;
	}

	@Override
	public void changeCollectionGroup(Integer collectNo, Integer newCollectGNo) throws UpdateCollectionsException {
		String hql = "update CollectionDetail CD set CD.collectionGroup = :collectionGroup where CD.collectDetailNo = :collectNo";
		int n = 0;
		try {
			CollectionGroup collectionGroup=getSession().get(CollectionGroup.class, newCollectGNo);
			@SuppressWarnings("unchecked")
			Query<CollectionDetail> query = getSession().createQuery(hql);
			query.setParameter("collectNo", collectNo);
			query.setParameter("collectionGroup", collectionGroup);
			n = query.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("發生SQL例外: " + e.getMessage());
		}
		if (n < 1) {
			throw new UpdateCollectionsException("更新失敗");
		} else {
			;
		}
	}
}
