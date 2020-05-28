package search.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import search.model.AreaBean;

@Repository
public class AreaDao {
	@Autowired
	SessionFactory factory;
	
	public Session getSession() {
		return factory.getCurrentSession();
	}

	public List<AreaBean> queryArea() {
		@SuppressWarnings("unchecked")
		Query<AreaBean> query = getSession().createQuery("from AreaBean order by no");
		List<AreaBean> allArea = query.list();
		
		return allArea;
	}
}