package myPublish.Service;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import myPublish.Model.MyPublishBean;
import myPublish.Model.MyPublishDao;
import myPublish.Model.iMyPublishDao;

@Service
@Transactional
@EnableTransactionManagement
public class myPublishService implements imyPublishService {

	@Autowired
	iMyPublishDao myDao;
	
//	private iMyPublishDao mlDao;
//	private Session session;
//
//	public myPublishService(Session session) {
//		this.session = session;
//		mlDao = new MyPublishDao(session);
//	}

	@Override
	public List<MyPublishBean> myPublish(int memberRegNo) {
		List<MyPublishBean> publishList = myDao.myPublish(memberRegNo);
		return publishList;
	}

	@Override
	public boolean myPubDele(int myPubNo) {
		return myDao.myPubDele(myPubNo);
	}

	@Override
	public MyPublishBean selUpdatePublish(int myPubNo) {
		System.out.println("service:" + myPubNo);
		return myDao.selUpdatePublish(myPubNo);
	}
	@Override
	public MyPublishBean datePublish(MyPublishBean bean) {
		return myDao.datePublish(bean);
	}
	@Override
	public List<MyPublishBean> myPublishImformation(int publishNo){
		List<MyPublishBean> myPublishImfor = myDao.myPublishImformation(publishNo);
		return myPublishImfor;
	}
	
//		public upPubBean datePublish(upPubBean bean) {
//			return mlDao.datePublish(bean);
//		}
//		public List<MyPublishBean> myPublishimf(int myPubNo){
//			return mlDao.myPublishimf(myPubNo);
//		}
}

