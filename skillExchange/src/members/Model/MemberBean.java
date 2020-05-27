package members.Model;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import skillClass.model.Publish;

import java.sql.Date;

@Entity
@Table(name = "member")
public class MemberBean implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer memberRegNo;
	private String memberAcc;
	private String memberPwd;
	private String accStatus;
	private Integer errorCount; 
	private String memberName; 
	private String memberNic; 
	private String memberSex;
	private Date memberBirth;
	private String memberPhone;
	private String memberCountry;
	private String memberAddr;
	private String memberMail;
	private String memberPic;
	private java.sql.Timestamp memberRegTime;
	private java.sql.Timestamp memberModTime;
	private java.sql.Timestamp memberLastTime;
	private String memberInSkill;
	private Integer memberChgFrequency;
	private String infoSource;

	@JsonIgnore
	private Set<Publish> publish = new LinkedHashSet<>();
	
	@OneToMany(mappedBy = "member")
	public Set<Publish> getPublish() {
		return publish;
	}

	public void setPublish(Set<Publish> publish) {
		this.publish = publish;
	}

	public MemberBean() {
	}

	public MemberBean(String memberAcc, String memberPwd, String memberName,String memberNic, String memberMail, java.sql.Timestamp memberRegTime, String memberPic) {
		super();
		this.memberAcc = memberAcc;
		this.memberPwd = memberPwd;
		this.memberName = memberName;
		this.memberMail = memberMail;
		this.memberPic = memberPic;
		this.memberNic=memberNic;
		this.memberRegTime=memberRegTime;
	}

	
	public MemberBean(Integer memberRegNo, String memberAcc, String memberPwd,
						String accStatus, Integer errorCount , 
						String memberName , String memberNic , String memberSex, 
						Date memberBirth, String memberPhone, String memberCountry, 
						String memberAddr, String memberMail, String memberPic,
						java.sql.Timestamp memberRegTime, java.sql.Timestamp memberModTime,
						java.sql.Timestamp memberLastTime, String memberInSkill,
						Integer memberChgFrequency, String infoSource) {
		super();
		this.memberRegNo = memberRegNo;
		this.memberAcc = memberAcc;
		this.memberPwd = memberPwd;
		this.accStatus = accStatus;
		this.errorCount = errorCount; 
		this.memberName = memberName; 
		this.memberNic = memberNic; 
		this.memberSex = memberSex;
		this.memberBirth = memberBirth;
		this.memberPhone = memberPhone;
		this.memberCountry = memberCountry;
		this.memberAddr = memberAddr;
		this.memberMail = memberMail;
		this.memberPic = memberPic;
		this.memberRegTime = memberRegTime;
		this.memberModTime = memberModTime;
		this.memberLastTime = memberLastTime;
		this.memberInSkill = memberInSkill;
		this.memberChgFrequency = memberChgFrequency;
		this.infoSource = infoSource;
	}
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

	public static java.util.Date convertDate(String temp){
		java.util.Date result = new java.util.Date();
		try {
			result=sdf.parse(temp);
		} catch (ParseException e) {
			result = null ; 
			e.printStackTrace();
		}
		return result;
	}
	
	public String toString() {
		return "["+memberRegNo+", "+memberAcc+", "+memberPwd +", "+accStatus +", "+errorCount +", "
				  +memberName +", "+memberNic +", "+memberSex +", "+memberBirth+", "+memberPhone +", "
				  +memberCountry+", "+memberAddr+", "+memberMail+", "+memberPic+", "+memberRegTime+", "
				  +memberModTime+", "+memberLastTime+", "+memberInSkill+", "+memberChgFrequency+", "
				  +infoSource+"]";
	}

	@Id
	@Column(name = "memberRegNo")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getMemberRegNo() {
		return memberRegNo;
	}

	public void setMemberRegNo(Integer memberRegNo) {
		this.memberRegNo = memberRegNo;
	}
	
	@Column(name = "memberAcc")
	public String getMemberAcc() {
		return memberAcc;
	}

	public void setMemberAcc(String memberAcc) {
		this.memberAcc = memberAcc;
	}

	@Column(name = "memberPwd")
	public String getMemberPwd() {
		return memberPwd;
	}

	public void setMemberPwd(String memberPwd) {
		this.memberPwd = memberPwd;
	}

	@Column(name = "accStatus")
	public String getAccStatus() {
		return accStatus;
	}

	public void setAccStatus(String accStatus) {
		this.accStatus = accStatus;
	}

	@Column(name = "errorCount")
	public Integer getErrorCount() {
		return errorCount;
	}

	public void setErrorCount(Integer errorCount) {
		this.errorCount = errorCount;
	}

	@Column(name = "memberName")
	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	@Column(name = "memberNic")
	public String getMemberNic() {
		return memberNic;
	}

	public void setMemberNic(String memberNic) {
		this.memberNic = memberNic;
	}

	@Column(name = "memberSex")
	public String getMemberSex() {
		return memberSex;
	}

	public void setMemberSex(String memberSex) {
		this.memberSex = memberSex;
	}

	@Column(name = "memberBirth")
	public Date getMemberBirth() {
		return memberBirth;
	}

	public void setMemberBirth(Date memberBirth) {
		this.memberBirth = memberBirth;
	}

	@Column(name = "memberPhone")
	public String getMemberPhone() {
		return memberPhone;
	}

	public void setMemberPhone(String memberPhone) {
		this.memberPhone = memberPhone;
	}

	@Column(name = "memberCountry")
	public String getMemberCountry() {
		return memberCountry;
	}

	public void setMemberCountry(String memberCountry) {
		this.memberCountry = memberCountry;
	}

	@Column(name = "memberAddr")
	public String getMemberAddr() {
		return memberAddr;
	}

	public void setMemberAddr(String memberAddr) {
		this.memberAddr = memberAddr;
	}

	@Column(name = "memberMail")
	public String getMemberMail() {
		return memberMail;
	}

	public void setMemberMail(String memberMail) {
		this.memberMail = memberMail;
	}

	@Column(name = "memberPic")
	public String getMemberPic() {
		return memberPic;
	}

	public void setMemberPic(String memberPic) {
		this.memberPic = memberPic;
	}

	@Column(name = "memberRegTime")
	public java.sql.Timestamp getMemberRegTime() {
		return memberRegTime;
	}

	public void setMemberRegTime(java.sql.Timestamp memberRegTime) {
		this.memberRegTime = memberRegTime;
	}

	@Column(name = "memberModTime")
	public java.sql.Timestamp getMemberModTime() {
		return memberModTime;
	}

	public void setMemberModTime(java.sql.Timestamp memberModTime) {
		this.memberModTime = memberModTime;
	}

	@Column(name = "memberLastTime")
	public java.sql.Timestamp getMemberLastTime() {
		return memberLastTime;
	}

	public void setMemberLastTime(java.sql.Timestamp memberLastTime) {
		this.memberLastTime = memberLastTime;
	}

	@Column(name = "memberInSkill")
	public String getMemberInSkill() {
		return memberInSkill;
	}

	public void setMemberInSkill(String memberInSkill) {
		this.memberInSkill = memberInSkill;
	}

	@Column(name = "memberChgFrequency")
	public Integer getMemberChgFrequency() {
		return memberChgFrequency;
	}

	public void setMemberChgFrequency(Integer memberChgFrequency) {
		this.memberChgFrequency = memberChgFrequency;
	}

	@Column(name = "infoSource")
	public String getInfoSource() {
		return infoSource;
	}

	public void setInfoSource(String infoSource) {
		this.infoSource = infoSource;
	}

}