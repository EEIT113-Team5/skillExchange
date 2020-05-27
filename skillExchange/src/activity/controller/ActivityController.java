package activity.controller;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.URL;
import java.sql.Blob;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.net.ssl.HttpsURLConnection;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.sql.rowset.serial.SerialBlob;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;

import com.google.gson.JsonObject;
import com.google.gson.stream.JsonReader;
import com.itextpdf.text.pdf.PdfStructTreeController.returnType;

import activity.bean.ActivityBean;
import activity.bean.Activitylike;
import activity.bean.CombinedBean;
import activity.service.ActivityService;
import activity.validator.ActivityValidator;
import members.Model.MemberBean;

@Controller
@MultipartConfig(location = "", fileSizeThreshold = 5 * 1024 * 1024, maxFileSize = 1024 * 1024
		* 500, maxRequestSize = 1024 * 1024 * 500 * 5)
@SessionAttributes(value = { "MsgOK", "search" })
public class ActivityController {

	@Autowired
	ActivityService as;
	
	public static final String url = "https://www.google.com/recaptcha/api/siteverify";
	public static final String secret = "6LcVo_sUAAAAAKGXZlJjqcnn6PhDo0N-2tAXJmLw";
//	private final static String USER_AGENT = "Mozilla/5.0";

	@GetMapping(value = "/SelectActivityNo")
	public String SelectActivity(@RequestParam("name") String name, Model model) {

		if (name == null) {
			name = "全部";
		}
		if (name.equals("全部")) {
//			List<ActivityBean> allActivity = asi.getAllActivity();

			List<CombinedBean> combinedResult = as.selectCominedResult("50");
			model.addAttribute("searchList", combinedResult);

		} else {

			List<CombinedBean> activity = as.getCombinedActivityClass(name, "50");
			System.out.println();
			model.addAttribute("searchList", activity);

		}
		return "activity/FindActivity";
	}

	@PostMapping(value = "/VerifyRecaptcha", produces = { "application/json" })
	public ResponseEntity<String> verify(@RequestParam("token") String token) throws IOException {
		if (token== null || "".equals(token)) {
			ResponseEntity<String> re = new ResponseEntity<>("false", HttpStatus.OK);
			return re;
		}

		try {
			URL obj = new URL(url);
			HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();

			// add reuqest header
			con.setRequestMethod("POST");
//			con.setRequestProperty("User-Agent", USER_AGENT);
//			con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");

			String postParams = "secret=" + secret + "&response=" + token;

			// Send post request
			con.setDoOutput(true);
			DataOutputStream wr = new DataOutputStream(con.getOutputStream());
			wr.writeBytes(postParams);
			wr.flush();
			wr.close();

			int responseCode = con.getResponseCode();
			System.out.println("\nSending 'POST' request to URL : " + url);
			System.out.println("Post parameters : " + postParams);
			System.out.println("Response Code : " + responseCode);

			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();

			// print result
			System.out.println(response.toString());

//			// parse JSON response and return 'success' value
//			JsonReader jsonReader = Json.createReader(new StringReader(response.toString()));
//			JsonObject jsonObject = jsonReader.readObject();
//			jsonReader.close();
			ResponseEntity<String> re = new ResponseEntity<>(response.toString(), HttpStatus.OK);
//			jsonObject.getBoolean("success");
			return re;
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>("false", HttpStatus.OK);
		}
	}

	@GetMapping(value = "/SelectActivity")
	public String SelectActivity(@RequestParam("name") String name, @SessionAttribute("memberBean") MemberBean member,
			Model model) {

		if (name == null) {
			name = "全部";
		}
		if (name.equals("全部")) {
//			List<ActivityBean> allActivity = asi.getAllActivity();

			List<CombinedBean> combinedResult = as.selectCominedResult(String.valueOf(member.getMemberRegNo()));
			model.addAttribute("searchList", combinedResult);

		} else {

			List<CombinedBean> activity = as.getCombinedActivityClass(name, String.valueOf(member.getMemberRegNo()));
			System.out.println();
			model.addAttribute("searchList", activity);

		}
		return "activity/FindActivity";
	}

	@GetMapping(value = "/ChooseOneActivity")
	public String ChooseOneActivity(@RequestParam("activityid") String activityid,
			@SessionAttribute("memberBean") MemberBean member, Model model) {
		List<CombinedBean> soca = as.selectOneCombinedActivity(String.valueOf(member.getMemberRegNo()), activityid);
		model.addAttribute("searchList", soca);
		return "activity/ActivityDetail";
	}

	@GetMapping(value = "/MyOwnActivity")
	public String MyOwnActivity(@SessionAttribute("memberBean") MemberBean member, Model model) {
		List<CombinedBean> sca = as.selectMyOwnCombinedActivity(String.valueOf(member.getMemberRegNo()));
		model.addAttribute("searchList", sca);
		return "activity/MyOwnActivity";
	}

	// 修改時先去資料庫選取資料顯示在表單上
	@GetMapping(value = "/UpdateActivity")
	public String UpdateActivity(@RequestParam("activityid") String activityid,
			@SessionAttribute("memberBean") MemberBean member, Model model) {
		List<ActivityBean> aosf = as.selectMyOwnSpecificActivity(String.valueOf(member.getMemberRegNo()), activityid);
		ActivityBean activityBean = aosf.get(0);
		model.addAttribute("search", activityBean);
		return "activity/Updateforms";
	}

	@PostMapping("/UpdateActivityContent")
	public String UpdateActivityContent(@RequestParam("activityid") String activityid,
			@ModelAttribute("search") ActivityBean search, BindingResult result, Model model,
			HttpServletRequest request) {
		Map<String, String> msgOK = new HashMap<String, String>();
		model.addAttribute("MsgOK", msgOK);
		ActivityValidator validator = new ActivityValidator();
		validator.validate(search, result);
		if (result.hasErrors()) {
			System.out.println("result hasErrors(), search=" + search);
			List<ObjectError> list = result.getAllErrors();
			for (ObjectError error : list) {
				System.out.println("有錯誤：" + error);
			}
			return "activity/Updateforms";
		}

		MultipartFile picture = search.getProductImage();
		if (picture.getSize() == 0) {
			Blob blob = null;
			search.setFileimg(blob);
		} else if (picture != null && !picture.isEmpty()) {
			try {
				byte[] b = picture.getBytes();
				Blob blob = new SerialBlob(b);
				search.setFileimg(blob);
			} catch (Exception e) {
				e.printStackTrace();
				throw new RuntimeException("檔案上傳發生異常: " + e.getMessage());
			}
		}
		long scm = System.currentTimeMillis();

		java.sql.Timestamp dateTime = new Timestamp(System.currentTimeMillis());
		search.setInsertime(dateTime);
		int numresult = as.updateMyOwnSpecificActivity(search);
		if (numresult == 1) {
			msgOK.put("InsertOK", "<Font color='red'>活動修改成功</Font>");
			return "redirect:Activitysuccess";
		}
		return "activity/Updateforms";
	}

	@GetMapping(value = "/Activitysuccess")
	public String Feedback() {
		return "activity/Activitysuccess";
	}

	// 新增活動空白表單
	@GetMapping(value = "/EstablishActivity")
	public String EstablishActivity(@SessionAttribute("memberBean") MemberBean member, Model model) {
		model.addAttribute("search", new ActivityBean());
		return "activity/Activityforms";
	}

	@PostMapping("/EstablishActivityContent")
	public String EstablishActivityCotent(@ModelAttribute("search") ActivityBean search,
			@SessionAttribute("memberBean") MemberBean member, BindingResult result, Model model,
			HttpServletRequest request) {
		Map<String, String> msgOK = new HashMap<String, String>();
		model.addAttribute("MsgOK", msgOK);
		ActivityValidator validator = new ActivityValidator();
		validator.validate(search, result);
		if (result.hasErrors()) {
			System.out.println("result hasErrors(), search=" + search);
			List<ObjectError> list = result.getAllErrors();
			for (ObjectError error : list) {
				System.out.println("有錯誤：" + error);
			}
			return "activity/Activityforms";
		}

		MultipartFile picture = search.getProductImage();

		if (picture.getSize() == 0) {
			Blob blob = null;
			search.setFileimg(blob);
		} else if (picture != null && !picture.isEmpty()) {
			try {
				byte[] b = picture.getBytes();
				Blob blob = new SerialBlob(b);
				search.setFileimg(blob);
			} catch (Exception e) {
				e.printStackTrace();
				throw new RuntimeException("檔案上傳發生異常: " + e.getMessage());
			}
		}

		java.sql.Timestamp dateTime = new Timestamp(System.currentTimeMillis());
		search.setMemberid(member.getMemberRegNo());
		search.setInsertime(dateTime);
		search.setStat("1");
		search.setPublishCTR(0);
		boolean result1 = as.insert(search);
		if (result1) {
			msgOK.put("InsertOK", "<Font color='red'>活動新增成功</Font>");
			return "redirect:Activitysuccess";
		}
		return "activity/Activityforms";
	}

	@GetMapping(value = "/DeleteActivity/{activityid}")
	public String DeleteActivity(@PathVariable("activityid") String activityid) {
		as.deleteAcWithAclikeId(Integer.valueOf(activityid));
		return "redirect:../MyOwnActivity";
	}

	@GetMapping(value = "/FindPlace", produces = { "application/json" })
	public ResponseEntity<List<ActivityBean>> FindPlace(@RequestParam String category, Model model) {
		List<ActivityBean> activity = null;
		if (category == null) {
			category = "全部";
		}
		if (category.equals("全部")) {
			activity = as.getAllActivity();

		} else {
			activity = as.getActivityClass(category);
		}
		ResponseEntity<List<ActivityBean>> re = new ResponseEntity<>(activity, HttpStatus.OK);
		return re;
	}

	@GetMapping(value = "/OpenMap")
	public String OpenMap(@RequestParam("activityid") String activityid,
			@SessionAttribute("memberBean") MemberBean member, Model model) {
		ActivityBean one = as.selectOneSpecificActivity(activityid);
		model.addAttribute("search", one);
		return "activity/map";
	}

	@GetMapping(value = "/RetrieveNumber")
	public ResponseEntity<List<Long>> RetrieveNumber(@RequestParam("id") String activityid,
			@RequestParam("interest") String interest, @SessionAttribute("memberBean") MemberBean member, Model model) {
		java.sql.Timestamp dateTime = new Timestamp(System.currentTimeMillis());
		if (interest != null) {
			if (interest.equals("有興趣") || interest.equals("會參加")) {

				Activitylike al = new Activitylike(Integer.valueOf(activityid), member.getMemberRegNo(), interest,
						dateTime);
				boolean result = as.insertLike(al);
				System.out.println(result);
			}
			if (interest.equals("取消參加")) {
				interest = "會參加";
				int result = as.deletelike(member.getMemberRegNo(), Integer.valueOf(activityid), interest);
				System.out.println(result);
			}

			if (interest.equals("取消有興趣")) {
				interest = "有興趣";
				int result = as.deletelike(member.getMemberRegNo(), Integer.valueOf(activityid), interest);
				System.out.println(result);
			}

		}
		List<Long> list = new ArrayList();
		Long attendNumber = as.getAttendNumber(activityid);
		Long interestNumber = as.getInterestNumber(activityid);
		list.add(attendNumber);
		list.add(interestNumber);
		ResponseEntity<List<Long>> re = new ResponseEntity<>(list, HttpStatus.OK);
		return re;
	}

//

}
