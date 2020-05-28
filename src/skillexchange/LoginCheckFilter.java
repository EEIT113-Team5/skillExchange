package skillexchange;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import members.Model.MemberBean;


public class LoginCheckFilter implements Filter {
	
//	用ArrayList<String>() new一個url物件
	List<String> url = new ArrayList<String>();
	
	String servletPath;
	String contextPath;
	String requestURI;
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		url.add("/index.jsp");
		url.add("/index");
		url.add("/searchadvanced");		
		url.add("/query");
		url.add("/publish");
		
		url.add("/");
		url.add("/contactus");
		url.add("/InsertContactUs.do");
		url.add("/aboutus.jsp");
		
		url.add("/GetArea.do");
		url.add("/GetSkill.do");
		url.add("/SetSkill.do");
		url.add("/InsertKeyword1.do");
		url.add("/InsertKeyword2.do");

		url.add("/login");
		url.add("/loginInit");
		url.add("/loginCheck");
		
		url.add("/register");
		url.add("/registerInit");
		url.add("/registerCheck");
		
		url.add("/SelectActivity");
		url.add("/SelectActivityNo");
		url.add("/Facebooklogin");

		
//		url.add("/login.do");
//		url.add("/login.jsp");
//		url.add("/register");
//		url.add("/register.jsp");
//		url.add("/register.do");
	}
	
	@Override
	public void destroy() {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		
		servletPath = req.getServletPath();  
		contextPath = req.getContextPath();
		requestURI  = req.getRequestURI();
		
		boolean isRequestedSessionIdValid = false;
		isRequestedSessionIdValid = req.isRequestedSessionIdValid();
		
		StringBuffer server = req.getRequestURL();
		
//		System.out.println(server.toString()); // 在console印出開啟交易的檔案(icon)們 .woff/.woff2/.ttf
		
		if(server.toString().contains(".css") 
				|| server.toString().contains(".js") 
				|| server.toString().contains(".png") || server.toString().contains(".PNG") 
				|| server.toString().contains(".jpg") || server.toString().contains(".JPG") 
				|| server.toString().contains(".woff") || server.toString().contains(".ttf")  
//				|| server.toString().contains(".do")
				) {
			chain.doFilter(request, response);
		} else if (!mustLogin()) {
			chain.doFilter(request, response);
		} else if (checkLogin(req)) {   
			chain.doFilter(request, response); //  已經登入，導向原本要去的地方
		} else {				
			// 需要登入，尚未登入，所以送回登入畫面
			HttpSession session = req.getSession();
		    
			
			if ( !isRequestedSessionIdValid ) {
				session.setAttribute("timeOut", "使用逾時，請重新登入");
			} else {
				// 記住原本的"requestURI"，稍後如果登入成功，系統可以自動轉入
				// 原本要執行的程式。
				session.setAttribute("requestURI", requestURI);	
			}
			
//			resp.sendRedirect(contextPath + "/login.jsp");
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/members/login.jsp");
			rd.forward(request, response);
			return;
		}
		
	}

	private boolean checkLogin(HttpServletRequest req) {
		HttpSession session = req.getSession();
		
		MemberBean loginToken = (MemberBean) session.getAttribute("memberBean");
		if (loginToken == null) {
			return false;
		} else {
			return true;
		}
	}
	
	private boolean mustLogin() {
		boolean login = true;
		// 假如servletPath = 那3個頁面，login=false， 其餘=true
		for(String sURL : url) {
			if(servletPath.equals(sURL)) {
				login = false;
				break;
			}
		}
		
		return login;
	}

}
