package members.Model;

import javax.persistence.Entity;
import javax.servlet.http.HttpSession;
// 登出時需要做的事寫在這裡，如session.invalidate()

public class LogoutBean {
   
	HttpSession session;
	
	public HttpSession getSession() {
		return session;
	}
	
	public void setSession(HttpSession session) {
		this.session = session;
	}

	public String getLogout() { // logout 
		session.invalidate();
		return "";
	}
}
