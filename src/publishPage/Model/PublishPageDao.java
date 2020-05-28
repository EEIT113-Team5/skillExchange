package publishPage.Model;

import java.util.List;

import javax.servlet.ServletContext;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class PublishPageDao implements iPublishPageDao {

	@Autowired
	SessionFactory factory;
	
	@Autowired
	ServletContext ctx;
	
	public Session getSession() {
		return factory.getCurrentSession();
	}

	@Override
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<publishSelectBean> Skill() {

//		String selSkill = "Select SkillNameCN from Skill";

		Query query = getSession().createQuery("from publishSelectBean");
		List<publishSelectBean> skillBeans = query.list();
		return skillBeans;
	}

	@Override
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<publishAreaBean> Area() {

//		String Area = "Select PublishAreaCN,PublishAreaID from PublishArea";

		
		Query query = getSession().createQuery("from publishAreaBean");
		List<publishAreaBean> areaBeans = query.list();
		return areaBeans;
	}

	@Override
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<publishCityBean> City() {

//		String City = "Select CityCN,PublishAreaID from City";

		
		Query query = getSession().createQuery("from publishCityBean order by NO");
		List<publishCityBean> cityBeans = query.list();
		return cityBeans;
	}
}
