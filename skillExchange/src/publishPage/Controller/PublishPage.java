package publishPage.Controller;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;

import members.Model.MemberBean;
import publishCheckPage.Model.PublishBean;
import publishPage.Model.publishAreaBean;
import publishPage.Model.publishCityBean;
import publishPage.Model.publishSelectBean;
import publishPage.Service.iPublishPageService;

@Controller
@SessionAttributes(names= {"publishbean","prePicName"})
public class PublishPage {
	
	@Autowired
	iPublishPageService ipps;
	
	@PostMapping(value = "/publishPage")
	public String publishPage(
			@RequestParam(value="publishPic",required=false) MultipartFile file,
			HttpServletRequest request,
			@RequestParam("publishTitle") String publishTitle,
//			@RequestParam("publishPic") String publishPic,
			@RequestParam("publishDetail") String publishDetail,
			@RequestParam("ownSkill") String ownSkill,
			@RequestParam("wantSkill") String wantSkill,
			@RequestParam("publishArea") String publishArea,
			@RequestParam("City") String City,
			@RequestParam("district") String district,
			@RequestParam("road") String road,
			@RequestParam("publishPlace") String publishPlace,
			@RequestParam("publishMark") String publishMark,
			@RequestParam("skillType") String skillType,
			@SessionAttribute("memberBean") MemberBean mBean,
			Model model
			) throws IllegalStateException, IOException{
		Date date = new Date();
		Timestamp updateTime = new java.sql.Timestamp(date.getTime());
		int memberRegNo = mBean.getMemberRegNo();  
		
//		//當下時間
//		long time = date.getTime();
//		
//		//圖片處理
////		String name = UUID.randomUUID().toString().replaceAll("-", "");
//		String imageName = file.getOriginalFilename();
//		String ext = FilenameUtils.getExtension(file.getOriginalFilename());
//		//上傳路徑
//		String filePath = request.getSession().getServletContext().getRealPath("images/");
//		System.out.println(filePath);
//		
//		//重新命名
//		file.transferTo(new File(filePath+time+imageName+"."+ext));
//		
//		String picNameString = "images/"+time+imageName+"."+ext;
//		model.addAttribute("prePicName",picNameString);
		String imageName = file.getOriginalFilename();
		PublishBean pBean = new PublishBean();
		if (imageName == "" || imageName == null) {
			
			String string = (String)model.getAttribute("prePicName");
			System.out.println(string);
			
			pBean = new PublishBean(publishTitle,memberRegNo,publishDetail,publishArea,City,
					district,road,publishPlace,string,ownSkill,wantSkill,updateTime,publishMark,skillType);
			model.addAttribute("picNameString",string);
			
		}else {
			//當下時間
			long time = date.getTime();
			
			//圖片處理
//			String name = UUID.randomUUID().toString().replaceAll("-", "");
			
			String ext = FilenameUtils.getExtension(file.getOriginalFilename());
			//上傳路徑
			String filePath = request.getSession().getServletContext().getRealPath("images/");
			System.out.println(filePath);
			
			//重新命名
			file.transferTo(new File(filePath+time+imageName+"."+ext));
			
			String picNameString = "images/"+time+imageName+"."+ext;
			model.addAttribute("prePicName",picNameString);
			
			pBean = new PublishBean(publishTitle,memberRegNo,publishDetail,publishArea,City,
					district,road,publishPlace,picNameString,ownSkill,wantSkill,updateTime,publishMark,skillType);			
			model.addAttribute("picNameString",picNameString);
		}
		model.addAttribute("publishbean",pBean);
		model.addAttribute("publishTitle", publishTitle);
		model.addAttribute("publishPic", imageName);
		model.addAttribute("publishDetail", publishDetail);
		model.addAttribute("ownSkill", ownSkill);
		model.addAttribute("wantSkill", wantSkill);
		model.addAttribute("publishArea", publishArea);
		model.addAttribute("City", City);
		model.addAttribute("district", district);
		model.addAttribute("road", road);
		model.addAttribute("publishPlace", publishPlace);
		model.addAttribute("publishMark", publishMark);
		model.addAttribute("skillType", skillType);
		
//		model.addAttribute("picNameString",picNameString);
//		System.out.println(picNameString);
		
		return "publish/PublishCheckPage";
	}
	
	@PostMapping(value = "/publishPrev")
	public String publishPrev(
			@SessionAttribute("publishbean") PublishBean pBean,
			Model model) {
		
		model.addAttribute("publishTitle", pBean.getPublishTitle());
		model.addAttribute("publishPic", pBean.getPublishPic());
		model.addAttribute("publishDetail", pBean.getPublishDetail());
		model.addAttribute("ownSkill", pBean.getOwnSkill());
		model.addAttribute("wantSkill", pBean.getWantSkill());
		model.addAttribute("publishArea", pBean.getPublishArea());
		model.addAttribute("City", pBean.getCity());
		model.addAttribute("district", pBean.getDistrict());
		model.addAttribute("road", pBean.getRoad());
		model.addAttribute("publishPlace", pBean.getPublishPlace());
		model.addAttribute("publishMark", pBean.getPublishMark());
		model.addAttribute("skillType", pBean.getSkillType());
		model.addAttribute("publishPic",pBean.getPublishPic());
		

		
		List<publishSelectBean> list = ipps.Skill();
		List<publishAreaBean> area = ipps.Area();
		List<publishCityBean> city = ipps.City();
		
		model.addAttribute("skill", list);
		model.addAttribute("area", area);
		model.addAttribute("city", city);
		
		
		return "publish/PublishRrev";
	}
}
