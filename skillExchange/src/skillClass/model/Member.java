package skillClass.model;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.LinkedHashSet;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Member")
public class Member implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private int memberRegNo;
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
	private Timestamp memberRegTime;
	private Timestamp memberModTime;
	private Timestamp memberLastTime;
	private String memberInSkill;
	private Integer memberChgFrequency;
	private String infoSource;
	private Set<Publish> publish=new LinkedHashSet<>();
	
	public Member() {
		super();
	}
	@OneToMany(mappedBy = "member")
	public Set<Publish> getPublish() {
		return publish;
	}

	public void setPublish(Set<Publish> publish) {
		this.publish = publish;
	}
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getMemberRegNo() {
		return memberRegNo;
	}
	public void setMemberRegNo(int memberRegNo) {
		this.memberRegNo = memberRegNo;
	}

	public String getMemberAcc() {
		return memberAcc;
	}
	public void setMemberAcc(String memberAcc) {
		this.memberAcc = memberAcc;
	}

	public String getMemberPwd() {
		return memberPwd;
	}

	public void setMemberPwd(String memberPwd) {
		this.memberPwd = memberPwd;
	}

	public String getAccStatus() {
		return accStatus;
	}

	public void setAccStatus(String accStatus) {
		this.accStatus = accStatus;
	}

	public Integer getErrorCount() {
		return errorCount;
	}

	public void setErrorCount(Integer errorCount) {
		this.errorCount = errorCount;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getMemberNic() {
		return memberNic;
	}

	public void setMemberNic(String memberNic) {
		this.memberNic = memberNic;
	}

	public String getMemberSex() {
		return memberSex;
	}

	public void setMemberSex(String memberSex) {
		this.memberSex = memberSex;
	}

	public Date getMemberBirth() {
		return memberBirth;
	}

	public void setMemberBirth(Date memberBirth) {
		this.memberBirth = memberBirth;
	}

	public String getMemberPhone() {
		return memberPhone;
	}

	public void setMemberPhone(String memberPhone) {
		this.memberPhone = memberPhone;
	}

	public String getMemberCountry() {
		return memberCountry;
	}

	public void setMemberCountry(String memberCountry) {
		this.memberCountry = memberCountry;
	}

	public String getMemberAddr() {
		return memberAddr;
	}

	public void setMemberAddr(String memberAddr) {
		this.memberAddr = memberAddr;
	}

	public String getMemberMail() {
		return memberMail;
	}

	public void setMemberMail(String memberMail) {
		this.memberMail = memberMail;
	}

	public String getMemberPic() {
		return memberPic;
	}

	public void setMemberPic(String memberPic) {
		this.memberPic = memberPic;
	}

	public Timestamp getMemberRegTime() {
		return memberRegTime;
	}

	public void setMemberRegTime(Timestamp memberRegTime) {
		this.memberRegTime = memberRegTime;
	}

	public Timestamp getMemberModTime() {
		return memberModTime;
	}

	public void setMemberModTime(Timestamp memberModTime) {
		this.memberModTime = memberModTime;
	}

	public Timestamp getMemberLastTime() {
		return memberLastTime;
	}

	public void setMemberLastTime(Timestamp memberLastTime) {
		this.memberLastTime = memberLastTime;
	}

	public String getMemberInSkill() {
		return memberInSkill;
	}

	public void setMemberInSkill(String memberInSkill) {
		this.memberInSkill = memberInSkill;
	}

	public Integer getMemberChgFrequency() {
		return memberChgFrequency;
	}

	public void setMemberChgFrequency(Integer memberChgFrequency) {
		this.memberChgFrequency = memberChgFrequency;
	}

	public String getInfoSource() {
		return infoSource;
	}

	public void setInfoSource(String infoSource) {
		this.infoSource = infoSource;
	}


	
}