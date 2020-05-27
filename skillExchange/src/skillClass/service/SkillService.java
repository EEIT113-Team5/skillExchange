package skillClass.service;

import java.util.List;

import skillClass.model.Publish;

public interface SkillService {

	List<Publish> QuerySkills(String skillType);
	List<Publish> allskill();
	List<Publish> detailQuery(Integer PublishNo);
	boolean CTRUpdate(Integer PublishNo);
}