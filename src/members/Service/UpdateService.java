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
public class UpdateService {
	
	@Autowired
	private MemberDao mbDao;
	
	public void update(MemberBean mbean) {
		mbDao.updateMember(mbean);
	}



}
