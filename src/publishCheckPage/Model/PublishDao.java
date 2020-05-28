package publishCheckPage.Model;

import java.sql.SQLException;
import java.text.ParseException;

import javax.servlet.ServletContext;
import javax.sql.DataSource;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class PublishDao implements iPublishDao {
	DataSource ds = null;
	
	
	@Autowired
	SessionFactory factory;
	
	@Autowired
	ServletContext ctx;
	
	public Session getSession() {
		return factory.getCurrentSession();
	}

	
	@Override
	public PublishBean insertPublish(PublishBean bean) throws SQLException, ParseException {
		
		PublishBean result = getSession().get(PublishBean.class, bean.getPublishNo());
		if(result == null) {
			this.getSession().save(bean);
			return bean;
		}
		return null;
	}
}

