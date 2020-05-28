package comment.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.itextpdf.text.pdf.PdfStructTreeController.returnType;

import comment.bean.BarcharBean;
import comment.bean.CommentBean;
import comment.bean.LChartBean;
import comment.dao.CommentDAO;
import comment.service.CommentService;
import members.Model.MemberBean;
import messageboard.dao.MessageBoard;

@Service
@Transactional
@EnableTransactionManagement
public class CommentServiceIMPL implements CommentService {

	@Autowired
	CommentDAO uDao;

	@Autowired
	MessageBoard mb;

	@Override
	public List<CommentBean> getAllUserComments() {
		// TODO Auto-generated method stub
		return uDao.getAllUserComments();
	}

//
	@Override
	public int updateUserComm(int CommentNo, int stat) {

		return uDao.updateUserComm(CommentNo, stat);
	}

	@Override
	public List<CommentBean> getAllWebComments() {
		// TODO Auto-generated method stub
		return uDao.getAllWebComments();
	}

//
	@Override
	public void insertComm(CommentBean wb) {
		uDao.insertComm(wb);

	}

	@Override
	public int deleteComm(int wb) {
		return uDao.deleteComm(wb);
	}

	@Override
	public BarcharBean getWebCommentAvg(String year, String mon) {
		return uDao.getWebCommentAvg(year, mon);
	}

//
	@Override
	public List<LChartBean> getLineChart(String year) {
		return uDao.getLineChart(year);
	}

//
	@Override
	public List<CommentBean> publishComment() {
		return uDao.publishComment();
	}

	@Override
	public List<BarcharBean> watchingList(int grade) {

		List<BarcharBean> watchingList = uDao.watchingList(grade);
		for (int i = 0; i < watchingList.size(); i++) {
			Integer memidCommented = watchingList.get(i).getMemCommented();
			MemberBean member = mb.getMemberPic(memidCommented);
			if (member != null) {

				String accstatus = member.getAccStatus();
				if (accstatus != null) {
					watchingList.get(i).setMember(member);
				} else {
					member.setAccStatus("1");
					watchingList.get(i).setMember(member);
				}
			} else {
				MemberBean member1 = new MemberBean();
				member1.setAccStatus("1");
				watchingList.get(i).setMember(member1);
			}

		}
		return watchingList;
	}

	@Override
	public Integer UpdateMemberStat(Integer memberid, String action) {
		return uDao.UpdateMemberStat(memberid, action);
	}

	public List<Long> SelectExgrading() {
		List<Long> arr = new ArrayList<Long>();
		for (int i = 1; i < 11; i++) {
			Long grade = uDao.SelectExgrading(i);
			arr.add(grade);
		}
		return arr;
	}
}
