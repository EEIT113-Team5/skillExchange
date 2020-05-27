package contactUs.service;

import java.util.List;

import javax.mail.MessagingException;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import contactUs.dao.ContactUsDao;
import contactUs.dao.ContactUsDaoImpl;
import contactUs.model.ContactUsBean;
import myCollection.model.UpdateCollectionsException;

@Service
@Transactional
@EnableTransactionManagement
public class ContactUsServiceImpl implements ContactUsService {
	
	@Autowired
	ContactUsDao cntUsDao;


	@Override
	public boolean insertContactUs(ContactUsBean cntUs) {
		return cntUsDao.insertContactUs(cntUs);
	}

	@Override
	public void sendEmail(ContactUsBean cntUs) throws MessagingException {
		cntUs.senEmail(cntUs);
	}

	@Override
	public List<ContactUsBean> queryContactUs() {
		return cntUsDao.queryContactUs();
	}

	@Override
	public ContactUsBean queryContactUsDetail(Integer contactNo) {
		return cntUsDao.queryContactUsDetail(contactNo);
	}

	@Override
	public ContactUsBean updateReplyContent(Integer contactNo, String replyContent) throws UpdateCollectionsException {
		return cntUsDao.updateReplyContent(contactNo, replyContent);
	}
	

}
