package myPublish.Controller;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;

import members.Model.MemberBean;
import myPublish.Model.MyPublishBean;
import myPublish.Service.imyPublishService;
import publishPage.Model.publishAreaBean;
import publishPage.Model.publishCityBean;
import publishPage.Model.publishSelectBean;
import publishPage.Service.iPublishPageService;


@Controller
@SessionAttributes("publishNo")
public class MyPublish  {
	
	@Autowired
	imyPublishService imps;
	
	@GetMapping(value = "/myPublish")
	public String myPublish(@SessionAttribute("memberBean") MemberBean member, Model model){
		List<MyPublishBean> mylist = imps.myPublish(member.getMemberRegNo());
		model.addAttribute("mypublish",mylist);
		return "mypublish/myPublish";
	}
	
	@GetMapping(value = "/myPublishImfor")
	public String myPublishImfor(@RequestParam("publishNo") String publishNo,Model model){
		int pubNo = Integer.parseInt(publishNo);
		List<MyPublishBean> publishImfor;
		publishImfor = imps.myPublishImformation(pubNo);
		model.addAttribute("publishImfor",publishImfor);
		return "mypublish/myPublishImfor";
	}
	
	@Autowired
	iPublishPageService ipps;
	
	@GetMapping(value = "/myPublishUpdate")
	public String myPublishUpdate(@RequestParam("publishNo") String publishNo,Model model) {
		int pubNo = Integer.parseInt(publishNo);
		MyPublishBean sBean = imps.selUpdatePublish(pubNo);
		model.addAttribute("myTitle",sBean.getMyTitle());
		model.addAttribute("myDetail",sBean.getMyDetail());
		model.addAttribute("myArea",sBean.getMyArea());
		model.addAttribute("myCity",sBean.getMyCity());
		model.addAttribute("myDistrict",sBean.getMyDistrict());
		model.addAttribute("myRoad",sBean.getMyRoad());
		model.addAttribute("myPlace",sBean.getMyPlace());
		model.addAttribute("myOwnSkill",sBean.getMyOwnSkill());
		model.addAttribute("myWantSkill",sBean.getMyWantSkill());
		model.addAttribute("myMark",sBean.getMyMark());
		model.addAttribute("publishPic",sBean.getPublishPic());
		model.addAttribute("skillType",sBean.getSkillType());
		
		model.addAttribute("publishNo",pubNo);
		
		List<publishSelectBean> list = ipps.Skill();
		List<publishAreaBean> area = ipps.Area();
		List<publishCityBean> city = ipps.City();
		
		model.addAttribute("skill", list);
		model.addAttribute("area", area);
		model.addAttribute("city", city);
		
		return "mypublish/UpdatePage";
	}
	
	@PostMapping(value = "/myPublishUpSucc")
	public String myPublishUpSucc(
			@RequestParam(value="updatePublishPic",required=false) MultipartFile file,
			HttpServletRequest request,
			@SessionAttribute("publishNo") int pubNo,
			@RequestParam("myTitle") String myTitle,
			@RequestParam("myDetail") String myDetail,
			@RequestParam("myArea") String myArea,
			@RequestParam("myCity") String myCity,
			@RequestParam("myDistrict") String myDistrict,
			@RequestParam("myRoad") String myRoad,
			@RequestParam("myPlace") String myPlace,
			@RequestParam("myOwnSkill") String myOwnSkill,
			@RequestParam("myWantSkill") String myWantSkill,
			@RequestParam("myMark") String myMark,
			@RequestParam("skillType") String skillType,
			Model model
			) throws IllegalStateException, IOException {
		
		Date date = new Date();
		//當下時間
		long time = date.getTime();
		
		//圖片處理
		String name = UUID.randomUUID().toString().replaceAll("-", "");
		String imageName = file.getOriginalFilename();
		String ext = FilenameUtils.getExtension(file.getOriginalFilename());
		//上傳路徑
		String filePath = request.getSession().getServletContext().getRealPath("images/");
		System.out.println(filePath);
		
		System.out.println("2222"+imageName);
		//重新命名
		file.transferTo(new File(filePath+time+imageName+"."+ext));
		String updatePublishPic;
		if (imageName == "" || imageName == null) {
			updatePublishPic = null;			
		}else {
			updatePublishPic = "images/"+time+imageName+"."+ext;
		}
		
		System.out.println("1111:"+updatePublishPic);
		
		MyPublishBean upd = new MyPublishBean(pubNo,myTitle,myDetail,myArea,myCity,myDistrict,
				myRoad,myPlace,updatePublishPic,myOwnSkill,myWantSkill,myMark,skillType);
		imps.datePublish(upd);
		
		return "mypublish/UpdateFinish";
	}
	
	@GetMapping(value = "/myPublishDel")
	public String myPublishDel(@RequestParam("publishNo") String publishNo,Model model) {
		int pubNo = Integer.parseInt(publishNo);
		imps.myPubDele(pubNo);
		return "mypublish/PublishDelSuccess";
	}
	@PostMapping(value = "/myPublishReturnHome")
	public String myPublishReturnHome() {
		return "index";
	}

}
