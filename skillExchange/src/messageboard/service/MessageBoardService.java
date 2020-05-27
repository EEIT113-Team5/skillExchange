package messageboard.service;

import java.util.List;

import messageboard.bean.MessageBean;

public interface MessageBoardService {
	void insertMessage(MessageBean mb);
	
	public List<MessageBean> getMessage(Integer activityid);
	
	public int UpdateHostMessage(Integer Messageid, String hostContent);
	
	public int DelMessage(Integer Messageid);
	public int UpdateMemMessage(Integer Messageid, String Message);
}