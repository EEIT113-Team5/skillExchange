package contactUs.service;

import java.util.List;

import javax.mail.MessagingException;

import contactUs.model.ContactUsBean;
import myCollection.model.UpdateCollectionsException;

public interface ContactUsService {
	boolean insertContactUs(ContactUsBean cntUs);
	List<ContactUsBean> queryContactUs();
	ContactUsBean queryContactUsDetail(Integer contactNo);
	public void sendEmail(ContactUsBean cntUs) throws MessagingException;
	ContactUsBean updateReplyContent(Integer contactNo,String replyContent) throws UpdateCollectionsException;

}