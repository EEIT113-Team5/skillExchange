package activity.dao;

import java.util.List;

import org.hibernate.Session;

import activity.bean.ActivityBean;
import activity.bean.Activitylike;

public interface ActivityDao {

	Session getSession();

	List<Integer> getTrueOrfalse(String activityid);
	List<Integer> getTrueOrfalseInterest(String activityid);

	Long getInterestNumber(String activityid);

	Long getAttendNumber(String activityid);

	boolean insertLike(Activitylike al);

	boolean insert(ActivityBean ab);

	List<ActivityBean> getAllActivity();

	List<ActivityBean> getActivityClass(String name);

	List<ActivityBean> selectMyOwnActivity(String memberid);

	List<ActivityBean> selectMyOwnSpecificActivity(String memberid, String activityid);

	List<ActivityBean> selectOneSpecificActivity(String activityid);

	int updateMyOwnSpecificActivity(ActivityBean ab);

	int deleteActivitylikeid(Integer activityid);

	int deleteActivityid(Integer activityid);

	int deletelike(Integer memberid, Integer activityid, String interest);

}