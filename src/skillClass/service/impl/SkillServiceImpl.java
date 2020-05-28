package skillClass.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import skillClass.dao.SkillDao;
import skillClass.model.Publish;
import skillClass.service.SkillService;

@Transactional
@Service
public class SkillServiceImpl implements SkillService {
	SkillDao skillDao;
	
	@Autowired
	public void setSkillDao(SkillDao skillDao) {
		this.skillDao=skillDao;		
	}
	
	@Override
	public List<Publish> QuerySkills(String skillType) {
		return skillDao.skillQuery(skillType);
	}
	@Override
	public List<Publish> allskill() {
		return skillDao.allskill();
	}
	@Override
	public List<Publish> detailQuery(Integer PublishNo) {
		return skillDao.detailQuery(PublishNo);
	}
	@Override
	public boolean CTRUpdate(Integer PublishNo) {
		return skillDao.CTRUpdate(PublishNo);
	}
	
}
