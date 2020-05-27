package search.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import search.model.SkillBean;
import search.service.SkillService;

@Controller
@SessionAttributes(names = { "skillList" })
public class SkillController {
	@Autowired
	SkillService sService;

	@Autowired
	SkillBean sBean;
	
	@GetMapping("/index")
	public String findIndex() {
		return "/index";
	}

	@GetMapping("/GetSkill.do")
	public ModelAndView getSkill(Model m) {
		List<SkillBean> list = sService.querySkill();
		m.addAttribute("skillList", list);
		return new ModelAndView("redirect:/index");
	}

	@PostMapping("/SetSkill.do")
	public void setSkill(@RequestParam("skill") String skill, Model m) {
		m.addAttribute("selectedSkill", skill);
	}
}