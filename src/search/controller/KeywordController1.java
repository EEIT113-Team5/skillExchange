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
@SessionAttributes(names = { "searchList", "keyword1", "area1", "skill1" })
public class KeywordController1 {
	@Autowired
	KeywordService kService;

	@Autowired
	KeywordBean kBean;

	@GetMapping("/searchadvanced")
	public String findSearchAdvanced() {
		return "search/searchadvanced";
	}

	@GetMapping("/InsertKeyword1.do")
	public String insertKeyword(@RequestParam("keyword") String keyword,
			@RequestParam(value = "area1", required = false) String area,
			@RequestParam(value = "skill1", required = false) String skill, Model m) {
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

		List<SearchBean> list = (List<SearchBean>) kService.queryResult(keyword, area, skill);

		m.addAttribute("searchList", list);

//		System.out.println("keyword=" + keyword);
//		System.out.println("area=" + area);
//		System.out.println("skill=" + skill);

		m.addAttribute("keyword1", keyword);
		m.addAttribute("area1", area);
		m.addAttribute("skill1", skill);

		return "redirect:/searchadvanced";
	}
}
