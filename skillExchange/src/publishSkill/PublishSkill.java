package publishSkill;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import publishPage.Model.publishAreaBean;
import publishPage.Model.publishCityBean;
import publishPage.Model.publishSelectBean;
import publishPage.Service.iPublishPageService;
//import skillexchange.HibernateUtil;

//@WebServlet("/PublishSkill")

@Controller
public class PublishSkill {
	
	@Autowired
	iPublishPageService ipps;
	
	@GetMapping(value = "/publishSkill")
	public String publishSkill(Model model) {
		List<publishSelectBean> list = ipps.Skill();
		List<publishAreaBean> area = ipps.Area();
		List<publishCityBean> city = ipps.City();
		
		model.addAttribute("skill", list);
		model.addAttribute("area", area);
		model.addAttribute("city", city);
		
		return "publish/PublishPage";
	}
	
//	protected void doGet(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//
//		request.setCharacterEncoding("utf-8");
//		HttpSession httpSession = request.getSession();
//		try {
//			factory = HibernateUtil.getSessionFactory();
//			session = factory.getCurrentSession();
//			iPublishPageService service = new PublishPageService(session);
//			List<publishSelectBean> list = service.Skill();
////		for(publishSelectBean pBean :list) {
////			 System.out.println(pBean.getSkillNameCN());
////		}
//			List<publishAreaBean> area = service.Area();
//			List<publishCityBean> city = service.City();
//
//			httpSession.setAttribute("skill", list);
//			httpSession.setAttribute("area", area);
//			httpSession.setAttribute("city", city);
//
//			response.sendRedirect(request.getContextPath() + "/PublishPage.jsp");
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//
//	}

}
