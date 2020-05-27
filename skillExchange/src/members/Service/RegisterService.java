package members.Service;

import java.sql.SQLException;
import java.text.ParseException;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import members.Model.MemberBean;
import members.Model.MemberDao;

@Service
@Transactional
@EnableTransactionManagement
public class RegisterService {
	
	@Autowired
	private MemberDao mbDao;
	
	public MemberBean saveMember(MemberBean mbean) throws SQLException, ParseException{
		return mbDao.saveMember(mbean);
	}
	
	public boolean emailIsRegistered(String memberMail) {
		/*
		MemberBean bean = mbDao.selectMail(memberMail);
		boolean isRegistered = (bean != null);
		return isRegistered;
		*/
		
		boolean isRegistered = false;
		
		MemberBean bean = mbDao.selectMail(memberMail);
		if (bean != null) {
			isRegistered = true;
		} 
		
		return isRegistered;
		
	}
}
	
	




/*	
	public boolean idExists(String id) {
		MemberDao dao = new MemberDao(session);
		return dao.idExists(id);
	}
	
	public int saveMember(MemberBean mb) {
		MemberDao dao = new MemberDao();
		return dao.insertMember(mb);
	}


*/