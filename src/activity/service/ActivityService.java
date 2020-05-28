package activity.service;

import java.util.List;

import org.hibernate.Session;

import activity.bean.ActivityBean;
import activity.bean.Activitylike;
import activity.bean.CombinedBean;

public interface ActivityService {

	Session getSession();

	boolean insertLike(Activitylike al);

	boolean insert(ActivityBean ab);

	List<CombinedBean> getCombinedActivityClass(String name, String memberid);

	// all activity
	List<CombinedBean> selectCominedResult(String memberid);

	int deleteAcWithAclikeId(Integer activityid);

	int updateMyOwnSpecificActivity(ActivityBean ab);

	List<ActivityBean> getAllActivity();

	List<ActivityBean> getActivityClass(String name);

	List<ActivityBean> selectMyOwnActivity(String memberid);

	List<CombinedBean> selectMyOwnCombinedActivity(String memberid);

	List<ActivityBean> selectMyOwnSpecificActivity(String memberid, String activityid);

	List<CombinedBean> selectOneCombinedActivity(String memberid, String activityid);

	Long getInterestNumber(String activityid);

	Long getAttendNumber(String activityid);

	ActivityBean selectOneSpecificActivity(String activityid);

	int deletelike(Integer memberid, Integer activityid, String interest);

	List<CombinedBean> CombinedBeanService(List<ActivityBean> bean, String memberid);

}