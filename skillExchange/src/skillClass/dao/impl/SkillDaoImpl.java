package skillClass.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import skillClass.dao.SkillDao;
import skillClass.model.Publish;



@Repository
public class SkillDaoImpl implements SkillDao {
	SessionFactory factory;
	
	
	@Autowired
	public void setFactory(SessionFactory factory) {
		this.factory=factory;		
	}
	
	public SkillDaoImpl() {}
	
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Publish> skillQuery(String skillType) {
		
		String hql  = "from Publish P join fetch P.member WHERE P.skillType = :skillType order by updateTime DESC";
		Session session = getSession();
		Query<Publish> query =session.createQuery(hql);
		query.setParameter("skillType",skillType);
		return query.list();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Publish> detailQuery(Integer PublishNo) {
		
		String hql  = "from Publish P join fetch P.member WHERE P.publishNo = :publishNo";
		Session session = getSession();
		Query<Publish> query =session.createQuery(hql).setParameter("publishNo",PublishNo);
		return query.list();
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<Publish> allskill() {
		
		String hql  = "from Publish P join fetch P.member order by updateTime DESC";
		Session session = getSession();
		List<Publish> list =session.createQuery(hql).getResultList();
		return list;
	}
	@Override
	@SuppressWarnings("unchecked")
	public boolean CTRUpdate(Integer PublishNo) {
		String hql=" update Publish P set P.publishCTR=publishCTR+1 where P.publishNo=:publishNo";
		Session session = getSession();
		Query query = session.createQuery(hql).setParameter("publishNo",PublishNo );
		query.executeUpdate();
		return true;
	}
	
	public Session getSession() {
        return factory.getCurrentSession();			
	}
}
