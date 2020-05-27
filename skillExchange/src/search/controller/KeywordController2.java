package search.controller;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import search.model.KeywordBean;
import search.model.SearchBean;
import search.service.KeywordService;

@Controller
@SessionAttributes(names = { "searchList", "keyword2", "area2", "skill2" })
public class KeywordController2 {
	@Autowired
	KeywordService kService;

	@Autowired
	KeywordBean kBean;
	
	@GetMapping("/InsertKeyword2.do")
	public String insertKeyword(@RequestParam("keyword2") String keyword,
			@RequestParam(value = "area2", required = false) String area,
			@RequestParam(value = "skill2", required = false) String skill, Model m) {
		Timestamp ts = new java.sql.Timestamp(System.currentTimeMillis());
		if (keyword != "") {
			kBean.setKeyWord(keyword);
			kBean.setCreateDate(ts);
			boolean x = kService.insertKeyword(kBean);
			if (x) {
				System.out.println("關鍵字新增成功");
			} else {
				System.out.println("關鍵字新增失敗");
			}
		} else {
			System.out.println("不須新增關鍵字");
		}

		List<SearchBean> list = kService.queryResult(keyword, area, skill);

		m.addAttribute("searchList", list);

		m.addAttribute("keyword2", keyword);
		m.addAttribute("area2", area);
		m.addAttribute("skill2", skill);
		
		return "redirect:/searchadvanced";
	}
}