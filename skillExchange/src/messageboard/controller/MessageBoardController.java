package messageboard.controller;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

import activity.bean.ActivityBean;
import members.Model.MemberBean;
import messageboard.bean.MessageBean;
import messageboard.service.MessageBoardService;

@Controller
public class MessageBoardController {
	@Autowired
	MessageBoardService mbs;

	@Autowired
	MessageBean mb;

//	@Autowired 
//	CommentBean cb;

	@GetMapping(value = "/SendMessage", produces = { "application/json" })
	public ResponseEntity<List<MessageBean>> SendAndInsertMessage(@RequestParam("nickname") String nickname,
			@RequestParam("message") String massage, @RequestParam("hostid") Integer hostid,
			@RequestParam("activityid") Integer activityid, @SessionAttribute("memberBean") MemberBean member,
			Model model) {
		// 先將message吋入資料庫
		mb.setActivityid(activityid);
		mb.setHostid(hostid);
		mb.setMemberid(member.getMemberRegNo());
		mb.setNickname(nickname);
		mb.setMsgContent(massage);
		java.sql.Timestamp dateTime = new Timestamp(System.currentTimeMillis());
		mb.setMsgtime(dateTime);
		mbs.insertMessage(mb);

		// 將message選取出來
		List<MessageBean> message = mbs.getMessage(activityid);
		ResponseEntity<List<MessageBean>> re = new ResponseEntity<>(message, HttpStatus.OK);
		return re;

	}

	@GetMapping(value = "/SelectMessage", produces = { "application/json" })
	public ResponseEntity<List<MessageBean>> SelectMessage(@RequestParam("activityid") Integer activityid,
			@SessionAttribute("memberBean") MemberBean member, Model model) {
		// 將message選取出來
		List<MessageBean> message = mbs.getMessage(activityid);
		ResponseEntity<List<MessageBean>> re = new ResponseEntity<>(message, HttpStatus.OK);
		return re;

	}

	@GetMapping(value = "/UpdateHostMessage", produces = { "application/json" })
	public ResponseEntity<List<MessageBean>> UpdateHostMessage(@RequestParam("hostContent") String hostContent,
			@RequestParam("Messageid") Integer Messageid, @RequestParam("activityid") Integer activityid,
			@SessionAttribute("memberBean") MemberBean member, Model model) {
		// update
		int result = mbs.UpdateHostMessage(Messageid, hostContent);

		// 將message選取出來
		List<MessageBean> message = mbs.getMessage(activityid);
		ResponseEntity<List<MessageBean>> re = new ResponseEntity<>(message, HttpStatus.OK);
		return re;

	}
	
	
	@GetMapping(value = "/UpdateMemMessage", produces = { "application/json" })
	public ResponseEntity<List<MessageBean>> UpdateMemMessage( @RequestParam("message") String Message,
			@RequestParam("Messageid") Integer Messageid, @RequestParam("activityid") Integer activityid,
			@SessionAttribute("memberBean") MemberBean member, Model model) {
		// update
		int result = mbs.UpdateMemMessage(Messageid, Message);

		// 將message選取出來
		List<MessageBean> message = mbs.getMessage(activityid);
		ResponseEntity<List<MessageBean>> re = new ResponseEntity<>(message, HttpStatus.OK);
		return re;

	}
	
	@GetMapping(value = "/DelMessage", produces = { "application/json" })
	public ResponseEntity<List<MessageBean>> DelMessage(@RequestParam("Messageid") Integer Messageid,  @RequestParam("activityid") Integer activityid,
			@SessionAttribute("memberBean") MemberBean member, Model model) {
		//delete
		int delnum = mbs.DelMessage(Messageid);
		System.out.println("刪除:"+delnum+"筆資料");
		// 將message選取出來
		List<MessageBean> message = mbs.getMessage(activityid);
		ResponseEntity<List<MessageBean>> re = new ResponseEntity<>(message, HttpStatus.OK);
		return re;

	}
	
	
}
