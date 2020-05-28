package contactUs.dao;

import java.util.List;

import contactUs.model.ContactUsBean;
import myCollection.model.UpdateCollectionsException;

public interface ContactUsDao {

	boolean insertContactUs(ContactUsBean cntUs);
	List<ContactUsBean> queryContactUs();
	ContactUsBean queryContactUsDetail(Integer contactNo);
	ContactUsBean updateReplyContent(Integer contactNo,String replyContent) throws UpdateCollectionsException;

}