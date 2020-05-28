package myCollection.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import members.Model.MemberBean;
import myCollection.model.CollectionBean;
import myCollection.service.MyCollectionService;

@Controller
@SessionAttributes({ "MsgOK", "collectionsMap", "collectionGroupsMap" })
public class CollectionsServlet {

	@Autowired
	MyCollectionService service;

	@GetMapping(value = "/mycollection")
	public String findMyColletion(@SessionAttribute("memberBean") MemberBean member, Model model) {
		Map<Long, String> collectionGroupsMap = service.queryCollectionGroups(member.getMemberRegNo());
		Map<Integer, List<CollectionBean>> collectionsMap = service.queryCollections(member.getMemberRegNo());
		model.addAttribute("collectionsMap", collectionsMap);
		model.addAttribute("collectionGroupsMap", collectionGroupsMap);
		return "collection/mycollection";
	}

	@GetMapping(value = "/QueryCollections")
	public String queryCollections(@SessionAttribute("memberBean") MemberBean member, Model model) {
		Integer memberRegNo = member.getMemberRegNo();

		Map<Long, String> collectionGroupsMap = service.queryCollectionGroups(memberRegNo);
		Map<Integer, List<CollectionBean>> collectionsMap = service.queryCollections(memberRegNo);
		model.addAttribute("collectionsMap", collectionsMap);
		model.addAttribute("collectionGroupsMap", collectionGroupsMap);
		
		return "collection/mycollection";
	}

	@PostMapping(value = "/InsertColletionGroup")
	public String insertCollectionGroup(@SessionAttribute("memberBean") MemberBean member,
			@RequestParam("groupNameText") String newCollectGName, Model model) {
		Map<String, String> errorMsg = new HashMap<String, String>();
		Map<String, String> msgOK = new HashMap<String, String>();
		model.addAttribute("MsgMap", errorMsg);
		model.addAttribute("MsgOK", msgOK);

		Integer memberRegNo = member.getMemberRegNo();
		try {
			service.insertCollectionGroup(memberRegNo, newCollectGName);
			msgOK.put("insertOK", "新增成功");
		} catch (Exception e) {
			errorMsg.put("updateError", e.getMessage());
		}

		if (!errorMsg.isEmpty()) {
			return "collection/mycollection";
		}
		return "redirect:/mycollection";
	}

	@RequestMapping(value = "InsertColletion")
	
	public ResponseEntity<List<Integer>> insertCollection(@RequestParam("publishNo") String publishNoStr,
			@SessionAttribute("memberBean") MemberBean member, Model model) {
		Map<String, String> errorMsg = new HashMap<String, String>();
		Map<String, String> msgOK = new HashMap<String, String>();
		List<Integer> list = new ArrayList();
		model.addAttribute("ErrMsg", errorMsg);
		model.addAttribute("OKMsg", msgOK);

		Integer publishNo = Integer.parseInt(publishNoStr);
		Integer memberRegNo = member.getMemberRegNo();
		list.add(memberRegNo);
		try {
			service.insertCollection(memberRegNo, publishNo);
			msgOK.put("insertOK", "新增成功");
			
		} catch (Exception e) {
			e.printStackTrace();
			errorMsg.put("updateError", e.getMessage());
		}
		ResponseEntity<List<Integer>> re = new ResponseEntity<>(list, HttpStatus.OK);
//		if (!errorMsg.isEmpty()) {
//			return "collection/mycollection";
//		}
		
		return re;
	}
@RequestMapping(value = "delColletion")
	
	public ResponseEntity<List<Integer>> delCollection(@RequestParam("publishNo") String publishNoStr,
			@SessionAttribute("memberBean") MemberBean member, Model model) {
		Map<String, String> errorMsg = new HashMap<String, String>();
		Map<String, String> msgOK = new HashMap<String, String>();
		List<Integer> list = new ArrayList();
		model.addAttribute("ErrMsg", errorMsg);
		model.addAttribute("OKMsg", msgOK);

		Integer publishNo = Integer.parseInt(publishNoStr);
		Integer memberRegNo = member.getMemberRegNo();
		list.add(memberRegNo);
		try {
			service.delCollectionDetailBySkill(memberRegNo, publishNo);
			msgOK.put("updateOK", "取消成功");
			
		} catch (Exception e) {
			e.printStackTrace();
			errorMsg.put("updateError", e.getMessage());
		}
		ResponseEntity<List<Integer>> re = new ResponseEntity<>(list, HttpStatus.OK);
//		if (!errorMsg.isEmpty()) {
//			return "collection/mycollection";
//		}
		
		return re;
	}

	@PostMapping(value = "/UpdateCollections")
	public String updateCollections(@RequestParam(value = "collectGNo",required = false) String collectGNoStr,
			@RequestParam(value = "collectNo",required = false) String collectNoStr, @RequestParam("cmd") String cmd,
			@SessionAttribute("memberBean") MemberBean member, @RequestParam(value = "groupNameText",required = false) String newCollectGName,
			Model model) {
		Map<String, String> errorMsg = new HashMap<String, String>();
		Map<String, String> msgOK = new HashMap<String, String>();
		model.addAttribute("MsgMap", errorMsg);
		model.addAttribute("MsgOK", msgOK);

		if (cmd.equals("MOD")) {
			int collectGNo = Integer.parseInt(collectGNoStr);
			try {
				service.updateCollectionGroup(newCollectGName, collectGNo);
				msgOK.put("updateOK", "更新成功");
			} catch (Exception e) {
				e.printStackTrace();
				errorMsg.put("updateError", e.getMessage());
			}
		}
		if (cmd.equals("DEL")) {
			int collectGNo = Integer.parseInt(collectGNoStr);
			try {
				service.delCollectionGroup(collectGNo);
				msgOK.put("updateOK", "刪除成功");
			} catch (Exception e) {
				e.printStackTrace();
				errorMsg.put("delError", e.getMessage());
			}
		}

		if (cmd.equals("dDEL")) {
			int collectNo = Integer.parseInt(collectNoStr);
			try {
				service.delCollectionDetail(collectNo);
				msgOK.put("updateOK", "刪除成功");
			} catch (Exception e) {
				e.printStackTrace();
				errorMsg.put("delError", e.getMessage());
			}
		}

		if (!errorMsg.isEmpty()) {
			return "collection/mycollection";
		}
		return "redirect:/mycollection";
	}
	
	@PostMapping(value = "/delCollectionBySkill")
	public String delCollectionDetailBySkill(@RequestParam("publishNo") String publishNoStr,
			@RequestParam("memberRegNo") String memberRegNoStr, Model model) {
		Map<String, String> errorMsg = new HashMap<String, String>();
		Map<String, String> msgOK = new HashMap<String, String>();
		model.addAttribute("ErrMsg", errorMsg);
		model.addAttribute("OKMsg", msgOK);
		Integer publishNo = Integer.parseInt(publishNoStr);
		Integer memberRegNo = Integer.parseInt(memberRegNoStr);
		try {
			service.delCollectionDetailBySkill(memberRegNo, publishNo);
			msgOK.put("updateOK", "取消成功");
		} catch (Exception e) {
			errorMsg.put("delError", e.getMessage());
		}

		if (!errorMsg.isEmpty()) {
			return "collection/mycollection";
		}
		return "redirect:/mycollection";
	}
	@PostMapping(value = "/changeCollectionGroup")
	public String changeCollectionGroup(@RequestParam("collectNo")String collectNoStr,
			@RequestParam("newCollectGNo")String newCollectGNoStr,Model model){
		Map<String, String> errorMsg = new HashMap<String, String>();
		Map<String, String> msgOK = new HashMap<String, String>();
		model.addAttribute("MsgMap", errorMsg);
		model.addAttribute("MsgOK", msgOK);
		
		Integer collectNo = Integer.parseInt(collectNoStr);
		Integer newCollectGNo = Integer.parseInt(newCollectGNoStr);
		try {
			service.changeCollectionGroup(collectNo, newCollectGNo);
			msgOK.put("updateOK", "修改成功");
		} catch (Exception e) {
			errorMsg.put("updateError", e.getMessage());
		}

		if (!errorMsg.isEmpty()) {
			return "collection/mycollection";
		}
		return "redirect:/mycollection";
	}
	

}
