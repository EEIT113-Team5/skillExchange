package contactUs.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jboss.logging.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import contactUs.model.ContactUsBean;
import contactUs.service.ContactUsService;
import members.Model.MemberBean;

@Controller
@SessionAttributes({ "MsgOK", "cntUs" })
public class ContactUsServlet {

	@Autowired
	ContactUsService service;
	@Autowired
	ContactUsBean cntUs;

	@GetMapping(value = "/contactus")
	public String findContactUs() {
		return "contact/contactus";
	}

	@GetMapping(value = "/replycontact")
	public String findReplyContact() {
		return "contact/replycontact";
	}

	@GetMapping(value = "/replyPage")
	public String findReplyPage() {
		return "contact/replyPage";
	}

	@PostMapping(value = "/InsertContactUs")
	protected String insertContactUs(@RequestParam("name") String name, @RequestParam("email") String email,
			@RequestParam("title") String title, @RequestParam("content") String content,
			@SessionAttribute(value = "memberBean", required = false) MemberBean member, Model model) {
		Map<String, String> errorMsg = new HashMap<String, String>();
		Map<String, String> msgOK = new HashMap<String, String>();
		model.addAttribute("MsgMap", errorMsg);
		model.addAttribute("MsgOK", msgOK);
		System.out.println(name);
		System.out.println(email);
		System.out.println(title);
		System.out.println(content);

		if (name == null || name.trim().length() == 0) {
			errorMsg.put("errorNameEmpty", "姓名必須輸入");
		}
		if (email == null || email.trim().length() == 0) {
			errorMsg.put("errorEmailEmpty", "信箱必須輸入");
		}
		if (title == null || title.trim().length() == 0) {
			errorMsg.put("errorTitleEmpty", "主旨必須輸入");
		}
		if (content == null || content.trim().length() == 0) {
			errorMsg.put("errorContecntEmpty", "內容必須輸入");
		}
		if (!errorMsg.isEmpty()) {
			return "contact/contactus";
		}
		try {
			int memberNo;
			if (member != null) {
				memberNo = member.getMemberRegNo();
			} else {
				memberNo = 0;
			}
			cntUs.setMemberRegNo(memberNo);
			cntUs.setContactUser(name);
			cntUs.setEmail(email);
			cntUs.setTitle(title);
			cntUs.setContent(content);

			model.addAttribute("cntUs", cntUs);
			boolean result = service.insertContactUs(cntUs);
			if (result) {
				try {
					service.sendEmail(cntUs);
					System.out.println("send mail success!");
				} catch (Exception e) {
					e.printStackTrace();
				}
				msgOK.put("insertOK", "傳送成功！");
			} else {
				errorMsg.put("insertFail", "傳送失敗請再操作一次");
			}
		} catch (Exception e) {
			errorMsg.put("insertError", "寫入資料時發生異常,訊息:" + e.getCause());
		}
		if (!errorMsg.isEmpty()) {
			return "contact/contactus";
		}
		return "redirect:/contactus";
	}

	@GetMapping(value = "/queryContactUs")
	public String queryContactUs(Model model) {
		Map<String, String> errorMsg = new HashMap<String, String>();
		Map<String, String> msgOK = new HashMap<String, String>();
		model.addAttribute("MsgMap", errorMsg);
		model.addAttribute("MsgOK", msgOK);

		try {
			List<ContactUsBean> cntUsList = service.queryContactUs();
			model.addAttribute("cntUsList", cntUsList);
		} catch (Exception e) {
			errorMsg.put("queryError", "發生異常,訊息:" + e.getCause());
		}
		if (!errorMsg.isEmpty()) {
			return "contact/replycontact";
		}
		return "contact/replycontact";

	}

	@GetMapping(value = "/queryContactUsDetail")
	public String queryContactUsDetail(@RequestParam("contactNo") String contactNoStr,
			@RequestParam("type") String type, Model model) {
		Map<String, String> errorMsg = new HashMap<String, String>();
		Map<String, String> msgOK = new HashMap<String, String>();
		Integer contactNo = Integer.parseInt(contactNoStr);
		model.addAttribute("MsgMap", errorMsg);
		model.addAttribute("MsgOK", msgOK);
		model.addAttribute("type", type);

		try {
			ContactUsBean cntBean = service.queryContactUsDetail(contactNo);
			model.addAttribute("cntBean", cntBean);
		} catch (Exception e) {
			errorMsg.put("queryError", "發生異常,訊息:" + e.getCause());
		}
		if (!errorMsg.isEmpty()) {
			return "contact/replyPage";
		}
		return "contact/replyPage";

	}

	@PostMapping(value = "/ReplyContactUs")
	public String updateReplyContent(@RequestParam("contactNo") String contactNoStr,
			@RequestParam("replyContent") String replyContent, Model model) {
		Map<String, String> errorMsg = new HashMap<String, String>();
		Map<String, String> msgOK = new HashMap<String, String>();
		model.addAttribute("MsgMap", errorMsg);
		model.addAttribute("MsgOK", msgOK);
		Integer contactNo = Integer.parseInt(contactNoStr);
		
		try {
			ContactUsBean cntBean= service.updateReplyContent(contactNo, replyContent);
			if (cntBean !=null) {
				try {
					service.sendEmail(cntBean);
					System.out.println("send mail success!");
				} catch (Exception e) {
					e.printStackTrace();
				}
//				msgOK.put("insertOK", "傳送成功！");
				msgOK.put("updateOK", "回覆成功！");
			} else {
				errorMsg.put("insertFail", "回覆失敗請再操作一次");
			}
		} catch (Exception e) {
			errorMsg.put("updateError", "發生異常,訊息:" + e.getCause());
		}
		if (!errorMsg.isEmpty()) {
			return "contact/replyPage";
		}
		return "contact/replyPage";

	}
}
