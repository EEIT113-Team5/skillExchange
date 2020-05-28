package messageboard.dao;

import java.sql.Timestamp;
import java.util.List;

import javax.servlet.ServletContext;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import comment.bean.CommentBean;
import members.Model.MemberBean;
import messageboard.bean.MessageBean;

@Repository
public class MessageBoardDaoimpl implements MessageBoard {
	@Autowired
	SessionFactory factory;
	
	@Autowired
	ServletContext ctx;


	public Session getSession() {
		return factory.getCurrentSession();
	}
	@Override
	public int UpdateHostMessage(Integer Messageid, String hostContent) {
        String hql="update MessageBean m set m.hostContent=:hostContent, m.hostmsgtime=:hostmsgtime where m.Messageid= :Messageid";
		Query query = getSession().createQuery(hql);
		query.setParameter("hostContent",hostContent );
		java.sql.Timestamp dateTime = new Timestamp(System.currentTimeMillis());
		query.setParameter("hostmsgtime",dateTime );
		query.setParameter("Messageid",Messageid );
		int updatenum = query.executeUpdate();
		return updatenum;
	}
	
	
	@Override
	public int UpdateMemMessage(Integer Messageid, String Message) {
        String hql="update MessageBean m set m.msgContent=:msgContent, m.msgtime=:msgtime where m.Messageid= :Messageid";
		Query query = getSession().createQuery(hql);
		query.setParameter("msgContent", Message );
		java.sql.Timestamp dateTime = new Timestamp(System.currentTimeMillis());
		query.setParameter("msgtime",dateTime );
		query.setParameter("Messageid",Messageid );
		int updatenum = query.executeUpdate();
		return updatenum;
	}
	@Override
	public List<MessageBean> getMessage(Integer activityid) {
        String hql="from MessageBean m where m.activityid= :activityid order by m.msgtime asc";
		Query query = getSession().createQuery(hql);
		query.setParameter("activityid",activityid );
		List<MessageBean> list = query.list();
		return list;
	}
	
	public MemberBean getMemberPic(Integer memberid) {
        MemberBean result = getSession().get(MemberBean.class,  memberid);
		return result;
	}

	@Override
	public void insertMessage(MessageBean mb) {
		getSession().save(mb);
	}
	
	
	@Override
	public int DelMessage(Integer Messageid) {
		String hql="delete from MessageBean m where m.Messageid= :Messageid";
		Query query = getSession().createQuery(hql);
		query.setParameter("Messageid", Messageid);
		int result = query.executeUpdate();
		return result;
	}
	
	
}
