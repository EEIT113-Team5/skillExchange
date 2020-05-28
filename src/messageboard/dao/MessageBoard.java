package messageboard.dao;

import java.util.List;

import members.Model.MemberBean;
import messageboard.bean.MessageBean;

public interface MessageBoard {

	void insertMessage(MessageBean mb);
	public int UpdateHostMessage(Integer Messageid, String hostContent);
	public List<MessageBean> getMessage(Integer activityid);
	public int UpdateMemMessage(Integer Messageid, String Message);
	public MemberBean getMemberPic(Integer memberid);
	public int DelMessage(Integer Messageid);
}