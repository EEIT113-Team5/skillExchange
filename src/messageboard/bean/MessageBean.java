package messageboard.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.stereotype.Component;

import com.itextpdf.text.pdf.PdfStructTreeController.returnType;

import members.Model.MemberBean;

@Entity
@Table(name = "MessageBoard")
@Component
public class MessageBean implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "Messageid")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer Messageid;
	@Column(name = "activityid")
	private Integer activityid;
	@Column(name = "hostid")
	private Integer hostid;
	@Column(name = "memberid")
	private Integer memberid;
	@Column(name = "nickname")
	private String nickname;
	@Column(name = "msgContent")
	private String msgContent;
	@Column(name = "msgtime")
	private java.sql.Timestamp msgtime;
	@Column(name = "hostContent")
	private String hostContent;
	@Column(name = "hostmsgtime")
	private java.sql.Timestamp hostmsgtime;
	@Transient
	private MemberBean member;
	@Transient
	private String msgtime1;

	public String getMsgtime1() {
		return msgtime.toString();
	}

	public void setMsgtime1(String msgtime1) {
		this.msgtime1 = msgtime1;
	}

	public String getHostmsgtime1() {
		if (hostmsgtime != null) {
			return hostmsgtime.toString();
		}
		return "0";
	}

	public void setHostmsgtime1(String hostmsgtime1) {
		this.hostmsgtime1 = hostmsgtime1;
	}

	@Transient
	private String hostmsgtime1;

	public MemberBean getMember() {
		return member;
	}

	public void setMember(MemberBean member) {
		this.member = member;
	}

	public Integer getMessageid() {
		return Messageid;
	}

	public void setMessageid(Integer messageid) {
		Messageid = messageid;
	}

	public Integer getActivityid() {
		return activityid;
	}

	public void setActivityid(Integer activityid) {
		this.activityid = activityid;
	}

	public Integer getHostid() {
		return hostid;
	}

	public void setHostid(Integer hostid) {
		this.hostid = hostid;
	}

	public Integer getMemberid() {
		return memberid;
	}

	public void setMemberid(Integer memberid) {
		this.memberid = memberid;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getMsgContent() {
		return msgContent;
	}

	public void setMsgContent(String msgContent) {
		this.msgContent = msgContent;
	}

	public java.sql.Timestamp getMsgtime() {
		return msgtime;
	}

	public void setMsgtime(java.sql.Timestamp msgtime) {
		this.msgtime = msgtime;
	}

	public String getHostContent() {
		return hostContent;
	}

	public void setHostContent(String hostContent) {
		this.hostContent = hostContent;
	}

	public java.sql.Timestamp getHostmsgtime() {
		return hostmsgtime;
	}

	public void setHostmsgtime(java.sql.Timestamp hostmsgtime) {
		this.hostmsgtime = hostmsgtime;
	}
}
