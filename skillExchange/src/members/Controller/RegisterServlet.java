package members.Controller;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import members.Model.MemberBean;
import members.Service.RegisterService;

@Controller
//@WebServlet("/register.do")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	HttpSession httpSession;
	@Autowired
	RegisterService service;
	
	@GetMapping(value = "/registerInit")
	public String registerInit(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		return "members/register";
	}

	@PostMapping(value = "/registerCheck")
	public String registerCheck(HttpServletRequest request, 
			HttpServletResponse response, Model model,
			@RequestParam(value="memberPic",required=false) MultipartFile file
			) throws ServletException, IOException {
		
		//設定收到的請求編碼UTF-8
		request.setCharacterEncoding("UTF-8");
		
		//設一個session物件(容器)放收到的請求Session
		httpSession = request.getSession();
		 
		// 準備存放錯誤訊息的Map物件
		Map<String, String> errorMsg = new HashMap<String, String>();
		 
		// 顯示錯誤訊息
		request.setAttribute("errorMsg", errorMsg);
		
		// 讀取使用者所輸入，由瀏覽器送來的 memberAcc 欄位內的資料，注意大小寫
		String memberAcc = request.getParameter("memberAcc");
		
		// 讀取使用者所輸入，由瀏覽器送來的 memberPwd 欄位內的資料，注意大小寫
		String memberPwd = request.getParameter("memberPwd");
		
		// 讀取使用者所輸入，由瀏覽器送來的 memberPwd 欄位內的資料，注意大小寫
		String checkpwd = request.getParameter("checkpwd");
		
		// 讀取使用者所輸入，由瀏覽器送來的 memberName 欄位內的資料
		String memberName = request.getParameter("memberName");
		
		// 讀取使用者所輸入，由瀏覽器送來的 memberNic 欄位內的資料
		String memberNic = request.getParameter("memberNic");
		
		// 讀取使用者所輸入，由瀏覽器送來的 memberSex 欄位內的資料
		String memberSex = request.getParameter("memberSex");
		
		// 讀取使用者所輸入，由瀏覽器送來的 memberBirth 欄位內的資料
		String memberBirth = request.getParameter("memberBirth");
		
		// 讀取使用者所輸入，由瀏覽器送來的 memberPhone 欄位內的資料
		String memberPhone = request.getParameter("memberPhone");
		
		// 讀取使用者所輸入，由瀏覽器送來的 memberMail 欄位內的資料
		String memberMail = request.getParameter("memberMail");
		
		// 讀取使用者所輸入，由瀏覽器送來的 memberAddr 欄位內的資料
		String memberAddr = request.getParameter("memberAddr");
		
		// 讀取使用者所輸入，由瀏覽器送來的 memberCountry 欄位內的資料
		String memberCountry = request.getParameter("memberCountry");
		
		// 讀取使用者所輸入，由瀏覽器送來的 memberInSkill 欄位內的資料
		String memberInSkill = request.getParameter("memberInSkill");
		
		// 讀取使用者所輸入，由瀏覽器送來的 infoSource 欄位內的資料
		String infoSource = request.getParameter("infoSource");
		
		// 讀取使用者所輸入，由瀏覽器送來的 memberPic 欄位內的資料
//		String memberPic = request.getParameter("memberPic");
		
		//進行必要的資料轉換
		java.sql.Date dateB = null;
		if (memberBirth != null && memberBirth.trim().length() > 0 ) {
			try {
				dateB = java.sql.Date.valueOf(memberBirth);
			} catch (Exception e) {
				errorMsg.put("memberBirth", "(生日格式錯誤，請重新輸入)");
			}
		}
		
		//圖片處理
//		String name = UUID.randomUUID().toString().replaceAll("-", "");
		String imageName = file.getOriginalFilename();
		String ext = FilenameUtils.getExtension(file.getOriginalFilename());
		
		//上傳路徑
		String filePath = request.getSession().getServletContext().getRealPath("images/");
		System.out.println(filePath);
		
		//重新命名
		file.transferTo(new File(filePath+imageName+"."+ext));
		String memberPic = "images/"+imageName+"."+ext;
		
		//檢查使用者輸入資料
		if (memberAcc == null || memberAcc.trim().length() == 0) {
			errorMsg.put("memberAcc", "(帳號欄必須輸入)");
		}
		if (memberPwd == null || memberPwd.trim().length() == 0) {
			errorMsg.put("memberPwd", "(密碼欄必須輸入)");
		}
		if (checkpwd == null || checkpwd.trim().length() == 0 || !checkpwd.equals(memberPwd)) {
			errorMsg.put("checkpwd", "(確認密碼欄必須輸入)");
		}
		if (memberName == null || memberName.trim().length() == 0) {
			errorMsg.put("memberName", "(姓名欄必須輸入)");
		}
		if (memberNic == null || memberNic.trim().length() == 0) {
			errorMsg.put("memberNic", "(會員暱稱必須輸入)");
		}
		if (memberMail == null || memberMail.trim().length() == 0) {
			errorMsg.put("memberMail", "(信箱欄必須輸入)");
		}
		if (memberSex == null || memberSex.trim().length() == 0) {
			errorMsg.put("memberSex", "(性別欄必須輸入)");
		}
		if (memberAddr == null || memberAddr.trim().length() == 0) {
			errorMsg.put("memberAddr", "(地址欄必須輸入)");
		}
		if (memberPhone == null || memberPhone.trim().length() == 0) {
			errorMsg.put("memberPhone", "(電話欄必須輸入)");
		}
		
		if (!errorMsg.isEmpty()) {
//			RequestDispatcher rd = request.getRequestDispatcher("/register.jsp");
//			rd.forward(request, response);
			return "members/register";
		}
		
		
		try {
			// MemberBean mbean = service.checkEmail(memberMail);
			boolean emailRegistered = service.emailIsRegistered(memberMail);
			
//			檢核資料庫有無此帳號email重複
			// if(mbean != null) {
			if(emailRegistered) {
//				RequestDispatcher rd = request.getRequestDispatcher("/register.jsp");
//				rd.forward(request, response);
				return "members/register";
			}
			
			MemberBean mbean = new MemberBean(null, memberAcc, memberPwd, 
												"1",0, 
												memberName, memberNic, memberSex, 
											   dateB, memberPhone, memberCountry, 
											   memberAddr, memberMail, memberPic, 
											   null, null, 
											   null, memberInSkill, null, infoSource);
			
			MemberBean result = service.saveMember(mbean);
			
//			檢核有無新增成功
			if(result == null) {
//				RequestDispatcher rd = request.getRequestDispatcher("/register.jsp");
//				rd.forward(request, response);
				return "members/register";
			}
			 
		}catch(SQLException e) {
			e.printStackTrace();
			
		}catch (ParseException e) {
			e.printStackTrace();
		}
//		response.sendRedirect(request.getContextPath()+"/index.jsp");
		return "index";
	}
}
		
		
		
		
/*		
		MemberDao mem = new MemberDao(null, memberAcc, memberPwd, "Y", 0, memberName, 
				memberNic, memberSex, date, memberPhone, "", memberAddr, memberMail, null, null, 
				null, null, null, 0, null);
		
		// 呼叫MemberDao的saveMember方法
		RegisterService registerService = new RegisterService();
		int n = registerService.saveMember(mem);
		if (n == 1) {
			response.sendRedirect(request.getContextPath()+"/index.jsp");
			return;
		} else {
			RequestDispatcher rd = request.getRequestDispatcher("/register.jsp");
			rd.forward(request, response);
			errorMsg.put("RegisterErrorMsg", "新增錯誤");
			return;
		}
	}
	
}

*/