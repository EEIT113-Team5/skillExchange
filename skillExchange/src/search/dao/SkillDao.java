package search.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import search.model.SkillBean;

@Repository
public class SkillDao {
	@Autowired
	SessionFactory factory;
	
	public Session getSession() {
		return factory.getCurrentSession();
	}
	
	public List<SkillBean> querySkill(){
		@SuppressWarnings("unchecked")
		Query<SkillBean> query = getSession().createQuery("from SkillBean");
		List<SkillBean> allSkills = query.list();
		
		return allSkills;
	}
}