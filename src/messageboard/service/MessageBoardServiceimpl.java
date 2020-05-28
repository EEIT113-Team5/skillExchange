package messageboard.service;

import java.util.List;

import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.itextpdf.text.pdf.PdfStructTreeController.returnType;

import comment.dao.CommentDAO;
import members.Model.MemberBean;
import messageboard.bean.MessageBean;
import messageboard.dao.MessageBoard;
@Service
@Transactional
@EnableTransactionManagement
public class MessageBoardServiceimpl implements MessageBoardService {
   
	@Autowired 
	MessageBoard msb;
    
	
	//將memberbean裡面的資料整合進messageBean
	public List<MessageBean> getMessage(Integer activityid) {
		List<MessageBean> message = msb.getMessage(activityid);
		for(int i=0; i<message.size();i++) {
			Integer memberid = message.get(i).getMemberid();
			MemberBean memberbean = msb.getMemberPic(memberid);
			message.get(i).setMember(memberbean);			
		}
		return message;
	}
	
	public void insertMessage(MessageBean mb) {
		msb.insertMessage(mb);
	}
	public int UpdateHostMessage(Integer Messageid, String hostContent) {
		return msb.UpdateHostMessage( Messageid, hostContent);
	}
	
	public int DelMessage(Integer Messageid) {
		return msb.DelMessage(Messageid);
	}
	
	public int UpdateMemMessage(Integer Messageid, String Message) {
		
		return msb.UpdateMemMessage(Messageid, Message);
	}
}
