package publishPage.Model;

import java.util.List;

public interface iPublishPageDao {

	List<publishSelectBean> Skill();

	List<publishAreaBean> Area();

	List<publishCityBean> City();

}