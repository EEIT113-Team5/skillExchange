package search.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import search.dao.SkillDao;
import search.model.SkillBean;

@Service
@Transactional
@EnableTransactionManagement
public class SkillService {
	@Autowired
	SkillDao sDao;
	
	public List<SkillBean> querySkill(){
		return sDao.querySkill();
	}
}