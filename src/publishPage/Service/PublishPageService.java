package publishPage.Service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import publishPage.Model.iPublishPageDao;
import publishPage.Model.publishAreaBean;
import publishPage.Model.publishCityBean;
import publishPage.Model.publishSelectBean;

@Service
@Transactional
@EnableTransactionManagement
public class PublishPageService implements iPublishPageService {
	
	@Autowired
	iPublishPageDao ppDao;
	
//	private iPublishPageDao ppDao;
//	private Session session;
//
//	public PublishPageService(Session session) {
//		this.session = session;
//		ppDao = new PublishPageDao(session);
//	}

	@Override
	public List<publishSelectBean> Skill() {
		return ppDao.Skill();
	}

	@Override
	public List<publishAreaBean> Area() {
		return ppDao.Area();
	}

	@Override
	public List<publishCityBean> City() {
		return ppDao.City();
	}
}
