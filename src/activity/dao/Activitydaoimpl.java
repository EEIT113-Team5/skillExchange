package activity.dao;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.classic.Lifecycle;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.buffer.LimitedDataBufferList;
import org.springframework.stereotype.Repository;

import activity.bean.ActivityBean;
import activity.bean.Activitylike;
import comment.bean.CommentBean;

@Repository
public class Activitydaoimpl implements ActivityDao {

	
	@Autowired
	SessionFactory factory;
	
	@Autowired
	ServletContext ctx;


	public Session getSession() {
		return factory.getCurrentSession();
	}
	
    @Override
	public List<Integer> getTrueOrfalse(String activityid){
    	List<Integer> list = new ArrayList<Integer>();
    	
    	String hql="select a.memberid from Activitylike a where a.activityid=:activityid and a.interest = :interest";
		Query query = getSession().createQuery(hql);
		query.setParameter("activityid", Integer.valueOf(activityid));
		query.setParameter("interest", "會參加");
		 List<Object> list2 = query.list();
		 for(int i=0; i<list2.size();i++) {
			 list.add((Integer)list2.get(i));		 
		 }
		 return list;
    }
    
    @Override
	public List<Integer> getTrueOrfalseInterest(String activityid){
    	List<Integer> list = new ArrayList<Integer>();
    	
    	String hql="select a.memberid from Activitylike a where a.activityid=:activityid and a.interest = :interest";
		Query query = getSession().createQuery(hql);
		query.setParameter("activityid", Integer.valueOf(activityid));
		query.setParameter("interest", "有興趣");
		 List<Object> list2 = query.list();
		 for(int i=0; i<list2.size();i++) {
			 list.add((Integer)list2.get(i));		 
		 }
		 return list;
    }
	@Override
	public Long getInterestNumber(String activityid) {
		String hql="select count(*) from Activitylike a where a.activityid=:activityid and a.interest = :interest";
		Query query = getSession().createQuery(hql);
		query.setParameter("activityid", Integer.valueOf(activityid));
		query.setParameter("interest", "有興趣");
		List<Object> result = query.list();
		return (Long) result.get(0);
    }

	@Override
	public Long getAttendNumber(String activityid) {
	
		String hql="select count(*) from Activitylike a where a.activityid=:activityid and a.interest = :attend";
		Query query = getSession().createQuery(hql);
		query.setParameter("activityid", Integer.valueOf(activityid));
		query.setParameter("attend", "會參加");
		List<Object> result = query.list();
		return (Long) result.get(0);
    }
	
	@Override
	public boolean insertLike(Activitylike al) {
		Activitylike ac = getSession().get(Activitylike.class, al.getActivityid());
		if(ac==null) {
			getSession().save(al);
			return true;
		}
		return false;
	}

	@Override
	public boolean insert(ActivityBean ab) {
		ActivityBean result = getSession().get(ActivityBean.class, ab.getActivityid());
		if (result == null) {
			getSession().save(ab);
			return true;
		}
		return false;
	}

	@Override
	public List<ActivityBean> getAllActivity() {
		String hql = "from ActivityBean";
		Query query = getSession().createQuery(hql);
		List<ActivityBean> list = query.list();
		return list;
	}

	@Override
	public List<ActivityBean> getActivityClass(String name) {
		String hql = "from ActivityBean p where p.category= :category";
		Query query = getSession().createQuery(hql);
		query.setParameter("category", name);
		List<ActivityBean> list = query.list();
		return list;
	}
	

	@Override
	public List<ActivityBean> selectMyOwnActivity(String memberid) {
		String hql = "from ActivityBean p where p.memberid= :memberid";
		Query query = getSession().createQuery(hql);
		query.setParameter("memberid", Integer.valueOf(memberid));
		List<ActivityBean> list = query.list();
		return list;
	}
	
	@Override
	public List<ActivityBean> selectMyOwnSpecificActivity(String memberid, String activityid) {
		String hql = "from ActivityBean p where p.memberid= :memberid and p.activityid= :activityid";
		Query query = getSession().createQuery(hql);
		query.setParameter("memberid", Integer.valueOf(memberid));
		query.setParameter("activityid", Integer.valueOf(activityid));
		List<ActivityBean> list = query.list();
		return list;
	}
	
	@Override
	public List<ActivityBean> selectOneSpecificActivity(String activityid) {
		String hql = "from ActivityBean p where p.activityid= :activityid";
		Query query = getSession().createQuery(hql);
		query.setParameter("activityid", Integer.valueOf(activityid));
		List<ActivityBean> list = query.list();
		return list;
	}
	
	
	@Override
	public int updateMyOwnSpecificActivity(ActivityBean ab) {
		int updateNum = 0;
		String hql1 = "update ActivityBean p set p.title = :title, p.category = :category, p.descript = :descript, p.beginDay = :beginDay, p.beginTime = :beginTime, p.endDay = :endDay, p.endTime = :endTime, p.position = :position, p.lat = :lat, p.long1 = :long1, p.dialog = :dialog, p.group1 = :group1, p.group2 = :group2, p.fileimg = :fileimg, p.insertime = :insertime where p.activityid = :activityid";
		String hql2 = "update ActivityBean p set p.title = :title, p.category = :category, p.descript = :descript, p.beginDay = :beginDay, p.beginTime = :beginTime, p.endDay = :endDay, p.endTime = :endTime, p.position = :position, p.lat = :lat, p.long1 = :long1, p.dialog = :dialog, p.group1 = :group1, p.group2 = :group2, p.insertime = :insertime where p.activityid = :activityid";
//		String hql3 = "update ActivityBean p set p.title = :title and p.category = :category and p.descript = :descript and p.beginDay = :beginDay and p.beginTime = :beginTime and p.endDay = :endDay and p.endTime = :endTime and p.position = :position and p.lat = :lat and p.long1 = :long1 and p.dialog = :dialog and p.group1 = :group1 and p.group2 = :group2  and p.insertime = :insertime where p.activityid = :activityid";
		if(ab.getFileimg()==null) {
			Query query = getSession().createQuery(hql2);
			query.setParameter("title", ab.getTitle());
			query.setParameter("category", ab.getCategory());
			query.setParameter("descript", ab.getDescript());
			query.setParameter("beginDay", ab.getBeginDay());
			query.setParameter("beginTime", ab.getBeginTime());
			query.setParameter("endTime", ab.getEndTime());
			query.setParameter("endDay", ab.getEndDay());
			query.setParameter("position", ab.getPosition());
			query.setParameter("lat", ab.getLat());
			query.setParameter("long1", ab.getLong1());
			query.setParameter("dialog", ab.getDialog());
			query.setParameter("group1", ab.getGroup1());
			query.setParameter("group2", ab.getGroup2());
			query.setParameter("insertime", ab.getInsertime());
			query.setParameter("activityid", ab.getActivityid());
			int updatenum = query.executeUpdate();
			return updatenum;
		}else {
			Query query = getSession().createQuery(hql1);
			query.setParameter("title", ab.getTitle());
			query.setParameter("category", ab.getCategory());
			query.setParameter("descript", ab.getDescript());
			query.setParameter("beginDay", ab.getBeginDay());
			query.setParameter("beginTime", ab.getBeginTime());
			query.setParameter("endTime", ab.getEndTime());
			query.setParameter("endDay", ab.getEndDay());
			query.setParameter("position", ab.getPosition());
			query.setParameter("lat", ab.getLat());
			query.setParameter("long1", ab.getLong1());
			query.setParameter("dialog", ab.getDialog());
			query.setParameter("group1", ab.getGroup1());
			query.setParameter("group2", ab.getGroup2());
			query.setParameter("fileimg", ab.getFileimg());
			query.setParameter("insertime", ab.getInsertime());
			query.setParameter("activityid", ab.getActivityid());
			int updatenum = query.executeUpdate();
			return updatenum;
			
		}
	}
	
	@Override
	public int deleteActivitylikeid (Integer activityid) {
		String hql="delete from Activitylike a where a.activityid=:activityid";
		Query query = getSession().createQuery(hql);
		query.setParameter("activityid", activityid);
		int result = query.executeUpdate();
		return result;
	}
	@Override
	public int deleteActivityid (Integer activityid) {
		String hql="delete from ActivityBean a where a.activityid=:activityid";
		Query query = getSession().createQuery(hql);
		query.setParameter("activityid", activityid);
		int result = query.executeUpdate();
		return result;
	}
	@Override
	public int deletelike(Integer memberid, Integer activityid, String interest) {
		String hql="delete from Activitylike a where a.memberid=:memberid and a.activityid=:activityid and a.interest =:interest ";
		Query query = getSession().createQuery(hql);
		query.setParameter("memberid", memberid);
		query.setParameter("activityid", activityid);
		query.setParameter("interest",  interest);
		System.out.println(memberid+" "+activityid);
		int result = query.executeUpdate();
		
//		System.out.println(result);
		return result;
		
	}
}