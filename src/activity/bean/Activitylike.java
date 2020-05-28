package activity.bean;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Activitylike")
public class Activitylike {
	@Id
	@Column(name="likeid")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int likeid;
	@Column(name="activityid")
	private int activityid;
	@Column(name="memberid")
	private int memberid;
	@Column(name="interest")
	private String interest;
	@Column(name="updatetime")
	private java.sql.Timestamp updatetime;

	public Activitylike(int activityid, int memberid, String interest, Timestamp updatetime) {
		super();
		this.activityid = activityid;
		this.memberid = memberid;
		this.interest = interest;
		this.updatetime = updatetime;
	}

	public Activitylike() {
		// TODO Auto-generated constructor stub
	}

	public int getLikeid() {
		return likeid;
	}

	public void setLikeid(int likeid) {
		this.likeid = likeid;
	}

	public int getActivityid() {
		return activityid;
	}

	public void setActivityid(int activityid) {
		this.activityid = activityid;
	}

	public int getMemberid() {
		return memberid;
	}

	public void setMemberid(int memberid) {
		this.memberid = memberid;
	}

	public String getInterest() {
		return interest;
	}

	public void setInterest(String interest) {
		this.interest = interest;
	}

	public java.sql.Timestamp getUpdatetime() {
		return updatetime;
	}

	public void setUpdatetime(java.sql.Timestamp updatetime) {
		this.updatetime = updatetime;
	}

}
