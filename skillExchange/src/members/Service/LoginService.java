package members.Service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import members.Model.MemberBean;
import members.Model.MemberDao;


@Service
@Transactional
@EnableTransactionManagement
public class LoginService {
	@Autowired
	private MemberDao mbDao;
	
	public MemberBean checkIDPassword(String id, String password) {
		
		MemberBean mb = mbDao.selectAcc(id);
		
		if ( mb != null && password.equals(mb.getMemberPwd())) {
			return mb;
		}
		return null; 
	}
	
}

/*
public MemberBean checkIDPassword(String id, String password) {
	
	MemberDao dao = new MemberDao();
	
	MemberBean mb = dao.select(id);
	
	if ( mb != null && password.equals(mb.getMemberPwd())) {
		
		return mb;
	}
	return null; 
}
*/