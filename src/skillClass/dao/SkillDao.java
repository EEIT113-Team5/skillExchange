package skillClass.dao;

import java.util.List;
import skillClass.model.Publish;

public interface SkillDao {

	List<Publish> skillQuery(String skillType);
	List<Publish> allskill();
	List<Publish> detailQuery(Integer PublishNo);
	boolean CTRUpdate(Integer PublishNo);
}