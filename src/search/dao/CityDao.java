package search.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import search.model.CityBean;

@Repository
public class CityDao {
	@Autowired
	SessionFactory factory;
	
	public Session getSession() {
		return factory.getCurrentSession();
	}
	
	public List<CityBean> queryCity(){
		@SuppressWarnings("unchecked")
		Query<CityBean> query = getSession().createQuery("from CityBean");
		List<CityBean> allcities = query.list();
		
		return allcities;
	}
}