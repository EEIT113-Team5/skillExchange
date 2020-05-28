package publishCheckPage.Service;

import java.sql.SQLException;
import java.text.ParseException;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import publishCheckPage.Model.PublishBean;
import publishCheckPage.Model.iPublishDao;


@Service
@Transactional
@EnableTransactionManagement
public class PublishService implements iPublishService {
	
	@Autowired
	iPublishDao pDao;
	
	@Override
	public PublishBean insertPublish(PublishBean bean) throws SQLException, ParseException {
		return pDao.insertPublish(bean);
	}
}

