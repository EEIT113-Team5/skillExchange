package myPublish.Model;

import java.util.List;

import javax.servlet.ServletContext;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MyPublishDao implements iMyPublishDao {

	@Autowired
	SessionFactory factory;
	
	@Autowired
	ServletContext ctx;
	
	public Session getSession() {
		return factory.getCurrentSession();
	}

	@Override
	public List<MyPublishBean> myPublish(int memberRegNo) {
		@SuppressWarnings("unchecked")
		Query<MyPublishBean> query = getSession()
				.createQuery("select p from MyPublishBean p where p.memberRegNo = :memberRegNo");
		query.setParameter("memberRegNo", memberRegNo);
		List<MyPublishBean> myPublishBeans = query.list();
		return myPublishBeans;
	}

	@Override
	public boolean myPubDele(int myPubNo) {

		MyPublishBean publishBean = getSession().get(MyPublishBean.class, myPubNo);

		if (publishBean != null) {
			getSession().delete(publishBean);
			return true;
		}

		return false;

	}

	@Override
	public MyPublishBean selUpdatePublish(int myPubNo) {

//		System.out.println(a);

		String hql = "Select PublishTitle,PublishDetail,PublishArea,City"
				+ ",District,Road,PublishPlace,OwnSkill,WantSkill,PublishMark from Publish p where p.PublishNo = ? ";
		System.out.println("dao:" + myPubNo);
		System.out.println(getSession().get(MyPublishBean.class, myPubNo));
		return getSession().get(MyPublishBean.class, myPubNo);

	}
	@Override
	public MyPublishBean datePublish(MyPublishBean bean) {
		
		if (bean.getPublishPic() == null) {
			String hql = "Update MyPublishBean p set p.myTitle = :myTitle , p.myDetail = :myDetail , p.myArea = :myArea "
					+ ", p.myCity = :myCity , p.myDistrict = :myDistrict , p.myRoad = :myRoad , p.myPlace = :myPlace ,p.myOwnSkill = :myOwnSkill , p.myWantSkill = :myWantSkill , p.myMark = :myMark , p.skillType = :skillType "
					+ "where p.publishNo = :publishNo";
			Query query = getSession().createQuery(hql);
			query.setParameter("myTitle", bean.getMyTitle());
			query.setParameter("myDetail", bean.getMyDetail());
			query.setParameter("myArea", bean.getMyArea());
			query.setParameter("myCity", bean.getMyCity());
			query.setParameter("myDistrict", bean.getMyDistrict());
			query.setParameter("myRoad", bean.getMyRoad());
			query.setParameter("myPlace", bean.getMyPlace());
			query.setParameter("myOwnSkill", bean.getMyOwnSkill());
			query.setParameter("myWantSkill", bean.getMyWantSkill());		
			query.setParameter("myMark", bean.getMyMark());
			query.setParameter("skillType", bean.getSkillType());
			query.setParameter("publishNo", bean.getPublishNo());
			query.executeUpdate();
			return null;
		}else {
			String hql = "Update MyPublishBean p set p.myTitle = :myTitle , p.myDetail = :myDetail , p.myArea = :myArea "
					+ ", p.myCity = :myCity , p.myDistrict = :myDistrict , p.myRoad = :myRoad , p.myPlace = :myPlace , p.publishPic = :publishPic, p.myOwnSkill = :myOwnSkill , p.myWantSkill = :myWantSkill , p.myMark = :myMark , p.skillType = :skillType "
					+ "where p.publishNo = :publishNo";
			Query query = getSession().createQuery(hql);
			query.setParameter("myTitle", bean.getMyTitle());
			query.setParameter("myDetail", bean.getMyDetail());
			query.setParameter("myArea", bean.getMyArea());
			query.setParameter("myCity", bean.getMyCity());
			query.setParameter("myDistrict", bean.getMyDistrict());
			query.setParameter("myRoad", bean.getMyRoad());
			query.setParameter("myPlace", bean.getMyPlace());
			query.setParameter("publishPic", bean.getPublishPic());
			query.setParameter("myOwnSkill", bean.getMyOwnSkill());
			query.setParameter("myWantSkill", bean.getMyWantSkill());		
			query.setParameter("myMark", bean.getMyMark());
			query.setParameter("skillType", bean.getSkillType());
			query.setParameter("publishNo", bean.getPublishNo());
			query.executeUpdate();
			return null;
		}
	}
	@Override
	public List<MyPublishBean> myPublishImformation(int publishNo) {
		Query<MyPublishBean> query = getSession().createQuery("from MyPublishBean where PublishNo = :PublishNo",MyPublishBean.class);
		query.setParameter("PublishNo", publishNo);
		List<MyPublishBean> myPublishBeans = query.list();
		return myPublishBeans;
	}
	
//	public upPubBean datePublish(upPubBean bean) {
//		String UPDTAE = "Update Publish set PublishTitle = ? , PublishDetail = ? , PublishArea = ? "
//				+ ", City = ? , District = ? , Road = ? , PublishPlace = ? , OwnSkill = ? , WantSkill = ? , PublishMark = ? "
//				+ "where PublishNo = ?"; 
//		upPubBean result= null;
//		
//		try (
//			Connection conn = ds.getConnection();
//			PreparedStatement pstmt = conn.prepareStatement(UPDTAE);				
//		){
//			int pubNo = Integer.parseInt(bean.getPublishNo());
////			System.out.println(pubNo);
////			System.out.println(bean.getMyTitle());
//			
//			pstmt.setString(1, bean.getMyTitle());
//			pstmt.setString(2, bean.getMyDetail());
//			pstmt.setString(3, bean.getMyArea());
//			pstmt.setString(4, bean.getMyCity());
//			pstmt.setString(5, bean.getMyDistrict());
//			pstmt.setString(6, bean.getMyRoad());
//			pstmt.setString(7, bean.getMyPlace());
//			pstmt.setString(8, bean.getMyOwnSkill());
//			pstmt.setString(9, bean.getMyWantSkill());
//			pstmt.setString(10, bean.getMyMark());
//			pstmt.setInt(11, pubNo);
//			
//			pstmt.executeUpdate();
//			
//		} catch (Exception e) {
//			
//		}
//		return result;
//	}
//	public List<MyPublishBean> myPublishimf(int myPubNo){
//
//		String myPublish = "Select PublishNo,PublishTitle,PublishDetail,PublishArea,City"
//				+ ",District,Road,PublishPlace,OwnSkill,WantSkill,PublishMark from Publish where PublishNo = ? ";
//		
//		List<MyPublishBean> myPublishBeans = new ArrayList<MyPublishBean>();
//		try (
//			Connection conn = ds.getConnection();
//			PreparedStatement pstmt = conn.prepareStatement(myPublish);	
//		){
//			pstmt.setInt(1, myPubNo);
//			ResultSet rs = pstmt.executeQuery();
//			
//			while(rs.next()) {
//				MyPublishBean mpb = new MyPublishBean(rs.getInt("PublishNo"),rs.getString("PublishTitle"),rs.getString("PublishDetail"),rs.getString("PublishArea")
//						,rs.getString("City"),rs.getString("District"),rs.getString("Road"),rs.getString("PublishPlace")
//						,rs.getString("OwnSkill"),rs.getString("WantSkill"),rs.getString("PublishMark"));
//				myPublishBeans.add(mpb);
//			}
//			rs.close();
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return myPublishBeans;
//		
//	}
}

