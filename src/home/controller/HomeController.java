package home.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import comment.bean.CommentBean;
import comment.service.CommentService;

@Controller
@SessionAttributes(names = { "publish" })// 可以撈前五筆使用者的心得分享
public class HomeController {

	@Autowired
	CommentService commentServiceIMPL;
	

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(Model model) {
		List<CommentBean> comments = commentServiceIMPL.publishComment();
		model.addAttribute("publish", comments);
		return "index";
	}
	@GetMapping(value = "/Promotion")
	public String Promotion(Model model) {
		return "promotion/catalogmulti";
	}
}
