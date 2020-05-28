package search.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import search.model.AreaBean;
import search.model.SkillBean;
import search.service.AreaService;
import search.service.SkillService;

@Controller
public class IndexBtnController {

	@Autowired
	AreaService aService;

	@Autowired
	AreaBean aBean;

	@Autowired
	SkillService sService;

	@Autowired
	SkillBean sBean;

	@GetMapping(value = "/GetArea.do", produces = { "application/json" })
	public ResponseEntity<List<Object>> getPublishArea(Model m) {
		List<AreaBean> list1 = aService.queryArea();
//		m.addAttribute("areaList", list);
		List<SkillBean> list2 = sService.querySkill();
//		m.addAttribute("skillList", list);
		List<Object> list = new ArrayList<Object>();
		list.add(list1);
		list.add(list2);
		ResponseEntity<List<Object>> re = new ResponseEntity<List<Object>>(list, HttpStatus.OK);
		return re;
	}
}