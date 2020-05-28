package activity.service;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.itextpdf.text.pdf.PdfStructTreeController.returnType;

import activity.bean.ActivityBean;
import activity.bean.Activitylike;
import activity.bean.CombinedBean;
import activity.dao.ActivityDao;
import activity.dao.Activitydaoimpl;
import comment.bean.CommentBean;
import members.Model.MemberBean;
import messageboard.dao.MessageBoard;
@Service
@Transactional
@EnableTransactionManagement
public class ActivityServiceimpl implements ActivityService {
	@Autowired 
	ActivityDao ac;
    
	@Autowired 
	MessageBoard msb;

	@Override
	public boolean insertLike(Activitylike al) {
		return ac.insertLike(al);

	}

	@Override
	public boolean insert(ActivityBean ab) {
		return ac.insert(ab);
	}

	@Override
	public List<CombinedBean> getCombinedActivityClass(String name, String memberid) {
		List<ActivityBean> cb1 = ac.getActivityClass(name);
		return CombinedBeanService( cb1  , memberid);
		
	}

	// all activity
	@Override
	public List<CombinedBean> selectCominedResult(String memberid) {
		List<ActivityBean> activ = ac.getAllActivity();
		
		return CombinedBeanService( activ , memberid);
	}

	@Override
	public int deleteAcWithAclikeId(Integer activityid) {
		int deleteActivityid = ac.deleteActivityid(activityid);
		int deleteAclikeid = ac.deleteActivitylikeid(activityid);
		return deleteAclikeid + deleteActivityid;
	}

	@Override
	public int updateMyOwnSpecificActivity(ActivityBean ab) {
		return ac.updateMyOwnSpecificActivity(ab);
	}

	@Override
	public List<ActivityBean> getAllActivity() {
		// TODO Auto-generated method stub
		return ac.getAllActivity();
	}

	@Override
	public List<ActivityBean> getActivityClass(String name) {
		return ac.getActivityClass(name);
	}

	@Override
	public List<ActivityBean> selectMyOwnActivity(String memberid) {
		return ac.selectMyOwnActivity(memberid);
	}

	@Override
	public List<CombinedBean> selectMyOwnCombinedActivity(String memberid) {
		List<ActivityBean> activity = selectMyOwnActivity(memberid);
		return CombinedBeanService(activity, memberid);
	}

	@Override
	public List<ActivityBean> selectMyOwnSpecificActivity(String memberid, String activityid) {
		return ac.selectMyOwnSpecificActivity(memberid, activityid);
	}

	@Override
	public List<CombinedBean> selectOneCombinedActivity(String memberid, String activityid) {
		List<ActivityBean> sos = ac.selectOneSpecificActivity(activityid);

		return CombinedBeanService(sos, memberid);
	}

	@Override
	public Long getInterestNumber(String activityid) {

		return ac.getInterestNumber(activityid);
	}

	@Override
	public Long getAttendNumber(String activityid) {

		return ac.getAttendNumber(activityid);
	}
	@Override
	public ActivityBean selectOneSpecificActivity(String activityid) {
		return ac.selectOneSpecificActivity(activityid).get(0);
	}

	@Override
	public int deletelike(Integer memberid, Integer activityid, String interest) {

		return ac.deletelike(memberid, activityid, interest);

	}

	@Override
	public List<CombinedBean> CombinedBeanService(List<ActivityBean> bean, String memberid) {
		List<CombinedBean> list = new ArrayList<CombinedBean>();

		Integer integer = null;
		Integer integer2 = null;
		for (int i = 0; i < bean.size(); i++) {
			ActivityBean ab = bean.get(i);
			String activityid1 = String.valueOf(ab.getActivityid());
			Long in = ac.getInterestNumber(activityid1);
			Long an = ac.getAttendNumber(activityid1);
			List<Integer> ifcontain = ac.getTrueOrfalse(activityid1);//針對參加與否
			List<Integer> ifcontain2 = ac.getTrueOrfalseInterest(activityid1);//針對興趣與否
			int hostid = ab.getMemberid();
			MemberBean memberbean = msb.getMemberPic(hostid);//取出主辦人id的其他內容
			System.out.println(ifcontain);
			System.out.println(ifcontain2);
			boolean result = ifcontain.contains(Integer.valueOf(memberid));// 未來放使用者id
			boolean result2 = ifcontain2.contains(Integer.valueOf(memberid));// 未來放使用者id
			System.out.println(result);
			System.out.println(result2);
           
			if (result) {
				integer = 1;
			} else {
				integer = 0;
			}
			if (result2) {
				integer2 = 1;
			} else {
				integer2 = 0;
			}
			CombinedBean cb = new CombinedBean(ab.getActivityid(), hostid, ab.getTitle(), ab.getCategory(),
					ab.getDescript(), ab.getBeginDay(), ab.getBeginTime(), ab.getEndDay(), ab.getEndTime(),
					ab.getPosition(), ab.getLat(), ab.getLong1(), ab.getDialog(), ab.getGroup1(), ab.getGroup2(),
					ab.getFileimg(), ab.getStat(), ab.getPublishCTR(), ab.getInsertime(), in, an, integer, integer2, memberbean);
			list.add(cb);
		}
		return list;
	}

	@Override
	public Session getSession() {
		// TODO Auto-generated method stub
		return null;
	}
}
