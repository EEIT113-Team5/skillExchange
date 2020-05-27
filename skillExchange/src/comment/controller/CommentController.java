package comment.controller;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.abel533.echarts.Option;

import comment.bean.BarcharBean;
import comment.bean.CommentBean;
import comment.bean.LChartBean;
import comment.service.CommentService;


@Controller
public class CommentController {
	
	@Autowired 
	CommentService commentServiceIMPL;
	
//	@Autowired 
//	CommentBean cb;
    
	
	
	@GetMapping(value = "/FindUserComment")
	public String FindUserComment(Model model) {
		List<CommentBean> comments = commentServiceIMPL.getAllUserComments();
		model.addAttribute("usercomments", comments);
		return "comment/UserComment";
	}
	
	@GetMapping(value = "/FindWebComment")
	public String FindWebComment(Model model) {
		List<CommentBean> comments = commentServiceIMPL.getAllUserComments();
		model.addAttribute("webcomments", comments);
		return "comment/Webcomment";
	}
	
	@GetMapping(value = "/DeleteUserCommont/{commentNo}")
	public String DeleteUserComment(@PathVariable Integer commentNo) {
		commentServiceIMPL.deleteComm(commentNo);	
		return "redirect:../FindUserComment";
	}
	
	@GetMapping(value = "/DeleteWebCommont/{commentNo}")
	public String DeleteWebComment(@PathVariable Integer commentNo) {
		commentServiceIMPL.deleteComm(commentNo);	
		return "redirect:../FindWebComment";
	}
	
	@GetMapping(value = "/UpdateMemberStatus")
	public ResponseEntity<Integer> UpdateMemberStatus(@RequestParam("memberid") Integer memberid, @RequestParam("action") String action) {
		Integer updateNum = commentServiceIMPL.UpdateMemberStat(memberid, action);
		ResponseEntity<Integer> re  = new ResponseEntity<>(updateNum, HttpStatus.OK);
		return re;
	}
	
	
	@GetMapping(value = "/UpdateStatus")
	public String UpdateCommentStatus(@RequestParam("key") Integer commentNo, @RequestParam("stat") Integer stat) {
		commentServiceIMPL.updateUserComm(commentNo, stat);
		return "redirect:FindUserComment";
	}
	
	

	@GetMapping(value = "/OutputBarChart", produces= {"application/json"} )
	public ResponseEntity<Option> OutputBarChart(@RequestParam String mon,@RequestParam String year, Model model) {
		BarcharBean bb = commentServiceIMPL.getWebCommentAvg(year, mon);
		Option option = bb.getOption();
		ResponseEntity<Option> re  = new ResponseEntity<>(option, HttpStatus.OK);
		return re;
	}
	
	@GetMapping(value = "/OutputLineChart", produces= {"application/json"} )
	public ResponseEntity<List<LChartBean>> OutputLineChart(@RequestParam String yearmonths, Model model) {
		List<LChartBean> list = commentServiceIMPL.getLineChart(yearmonths);
		ResponseEntity<List<LChartBean>> re  = new ResponseEntity<>(list, HttpStatus.OK);
		return re;
	}
	
	@GetMapping(value = "/SelectPie", produces= {"application/json"} )
	public ResponseEntity<List<Long>> SelectPie( Model model) {
		List<Long> list = commentServiceIMPL.SelectExgrading();
		ResponseEntity<List<Long>> re  = new ResponseEntity<>(list, HttpStatus.OK);
		return re;
	}
	
	
	@GetMapping(value = "/WatchingList")
	public String WatchingList(@RequestParam("grade") Integer grade,Model model) {
		List<BarcharBean> wlist = commentServiceIMPL.watchingList(grade);
		model.addAttribute("watching", wlist);
		List<CommentBean> comments = commentServiceIMPL.getAllUserComments();
		model.addAttribute("usercomments", comments);
		return "comment/UserComment";
	}
	// 送回新增Member資料的空白表單
	@GetMapping("/InsertCommentForm")
	public String InsertCommentForm(Model model) {
		model.addAttribute("feedbackform", new CommentBean());
		return "comment/Form";
	}

	@PostMapping(value = "/InsertComment", consumes = "application/x-www-form-urlencoded")
	public String InsertComment(@ModelAttribute("feedbackform") CommentBean cb, BindingResult bindingResult) {
		java.sql.Timestamp dateTime =new Timestamp(System.currentTimeMillis());
		cb.setMsgTime(dateTime);
		cb.setMemCommented(10);//之後要從前端取得
		cb.setStat(0);
		System.out.println(cb);
		commentServiceIMPL.insertComm(cb);
		return "redirect:Feedback";
        
	}
	
	@GetMapping("/Feedback")
	public String RedirectToFeedback(Model model) {
		return "comment/feedback";
	}
     
}
