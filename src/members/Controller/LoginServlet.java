package members.Controller;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.ParseException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.itextpdf.text.pdf.PdfStructTreeController.returnType;

import members.Model.MemberBean;
import members.Service.LoginService;
import members.Service.RegisterService;

@Controller
@SessionAttributes(names = "memberBean")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	HttpSession httpSession;
	@Autowired
	LoginService ls;

	@Autowired
	RegisterService service;

	@GetMapping(value = "/loginInit")
	public String loginInit(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		return "members/login";
	}

	@GetMapping(value = "/Facebooklogin", produces = { "application/json" })
	public ResponseEntity<Map<String, String>> FBlogin(Model model, @RequestParam("email") String email,
			@RequestParam("userid") String userid, @RequestParam("memberName") String memberName,
			@RequestParam("memberPic") String memberPic)
			throws ServletException, IOException, SQLException, ParseException, java.text.ParseException {
		System.out.println(email);
		System.out.println(userid);
		System.out.println(memberName);
		System.out.println(memberPic);
		MemberBean mbean = null;
		mbean = ls.checkIDPassword(userid, userid);
		if (mbean == null) {
			java.sql.Timestamp memberRegTime = new Timestamp(System.currentTimeMillis());
			mbean = new MemberBean(userid, userid, memberName, memberName, email, memberRegTime, memberPic);
			service.saveMember(mbean);
		}
		Map<String, String> map = new HashMap<String, String>();
		map.put("登入狀態", "登入fb成功");
		model.addAttribute("memberBean", mbean);
		System.out.println("hello");
		ResponseEntity<Map<String, String>> re = new ResponseEntity<Map<String, String>>(map, HttpStatus.OK);
		return re;
	}

	@GetMapping(value = "/Logout")
	public String Logout(HttpServletRequest request, HttpServletResponse response,
			@SessionAttribute("memberBean") MemberBean member, Model model, SessionStatus sessionStatus)
			throws ServletException, IOException {
		String memberName = member.getMemberName();
		model.addAttribute("x", memberName);
		// 因為@SessionAttributes的關係。會自動在model裡面塞入 memberBean，
		// 所以model 設回 null，以免導致頁面出問題
		model.addAttribute("memberBean", null);

		httpSession = request.getSession();
		httpSession.removeAttribute("memberBean");
		sessionStatus.setComplete(); // 因為@SessionAttributes跟HttpSession不同,所以用2種不同方式清除session
//		httpSession = request.getSession();
		return "members/logout";
	}

	@PostMapping(value = "/loginCheck")
	public String loginCheck(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		Map<String, String> errorMsg = new HashMap<String, String>();
		Map<String, String> msgOK = new HashMap<String, String>();

		httpSession = request.getSession();
		request.setAttribute("MsgMap", errorMsg);
		httpSession.setAttribute("MsgOK", msgOK);

		String userId = request.getParameter("inputAcc");
		String password = request.getParameter("inputPassword");

//to do 跳錯誤訊息alertrt

		if (userId == null || userId.trim().length() == 0) {
			errorMsg.put("AccountEmptyError", "(帳號欄必須輸入)");
		}
		if (password == null || password.trim().length() == 0) {
			errorMsg.put("PasswordEmptyError", "(密碼欄必須輸入)");
		}
		if (!errorMsg.isEmpty()) {
//			RequestDispatcher rd = request.getRequestDispatcher("/login.jsp");
//			rd.forward(request, response);
			return "members/login";
		}

		try {
			MemberBean mb = ls.checkIDPassword(userId, password);

			if (mb != null) {
				httpSession.setAttribute("memberBean", mb);
			} else {
				errorMsg.put("LoginError", "該帳號不存在或密碼錯誤");
			}

		} catch (Exception e) {
			errorMsg.put("LoginError", "查詢資料時發生異常,訊息:" + e.getMessage());
		}
		if (errorMsg.isEmpty()) {
			msgOK.put("massage", "登入成功");
			// String targetURL = (String) session.getAttribute("target");
//			response.sendRedirect(request.getContextPath()+"/index.jsp");
			if (userId.equals("eeit11321") && password.equals("eeit11321")) {
                return "comment/Webcomment";
			} else {
				return "index";
			}
		} else {
//			RequestDispatcher rd = request
//					.getRequestDispatcher("/login.jsp");
//			rd.forward(request, response);
			return "members/login";
		}
	}

//	protected void doPost(HttpServletRequest request,
//			HttpServletResponse response) throws ServletException, IOException {
//		
//		request.setCharacterEncoding("UTF-8");
//		Map<String, String> errorMsg = new HashMap<String, String>();
//		Map<String, String> msgOK = new HashMap<String, String>();
//		
//		httpSession = request.getSession();
//		request.setAttribute("MsgMap", errorMsg);
//		httpSession.setAttribute("MsgOK", msgOK);
//
//
//
//		String userId = request.getParameter("inputAcc");
//		String password = request.getParameter("inputPassword");
//		
////to do 跳錯誤訊息alertrt
//
//		if (userId == null || userId.trim().length() == 0) {
//			errorMsg.put("AccountEmptyError", "(帳號欄必須輸入)");
//		}
//		if (password == null || password.trim().length() == 0) {
//			errorMsg.put("PasswordEmptyError", "(密碼欄必須輸入)");
//		}
//		if (!errorMsg.isEmpty()) {
//			RequestDispatcher rd = request.getRequestDispatcher("/login.jsp");
//			rd.forward(request, response);
//			return;
//		}
//		
//		
//		try {
//			MemberBean mb = ls.checkIDPassword(userId, password);
//			
//			if (mb != null) {
//				httpSession.setAttribute("memberBean", mb);
//			} else {
//				errorMsg.put("LoginError", "該帳號不存在或密碼錯誤");
//			}
//			
//		} catch (Exception e) {
//			errorMsg.put("selectError", "查詢資料時發生異常,訊息:" + e.getMessage());
//		}
//		if (errorMsg.isEmpty()) {
//			// String targetURL = (String) session.getAttribute("target");
//			response.sendRedirect(request.getContextPath()+"/index.jsp");
//			return;
//		} else {
//			RequestDispatcher rd = request
//					.getRequestDispatcher("/login.jsp");
//			rd.forward(request, response);
//			return;
//		}
//	}
}
