package skillClass.model; 

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;
import javax.persistence.*;


@Entity
@Table(name = "Publish")
public class Publish implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer PublishNo;		
	private Integer MemberRegNo;	
	private String PublishTitle;  	
	private String PublishDetail; 	
	private String PublishArea;	
	private String City;
	private String District;
	private String Road;
	private String PublishPlace;	
	private String PublishPic;
	private String OwnSkill; 	
	private String WantSkill;  	
	private Date UpdateTime; 	
	private Integer PublishCTR; 	
	private String PublishMark;
	private String Status;
	private String skillType;
	private Member member;
	
	public Publish(){
		
	}
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getPublishNo() {
		return PublishNo;
	}
	public void setPublishNo(Integer publishNo) {
		PublishNo = publishNo;
	}

	public Integer getMemberRegNo() {
		return MemberRegNo;
	}
	public void setMemberRegNo(Integer memberRegNo) {
		MemberRegNo = memberRegNo;
	}
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "MemberRegNo")
	public Member getMember() {
		return member;
	}
	public void setMember(Member member) {
		this.member = member;
	}
	
	public String getPublishTitle() {
		return PublishTitle;
	}
	public void setPublishTitle(String publishTitle) {
		PublishTitle = publishTitle;
	}

	public String getPublishDetail() {
		return PublishDetail;
	}
	public void setPublishDetail(String publishDetail) {
		PublishDetail = publishDetail;
	}

	public String getPublishArea() {
		return PublishArea;
	}
	public void setPublishArea(String publishArea) {
		PublishArea = publishArea;
	}

	public String getCity() {
		return City;
	}
	public void setCity(String city) {
		City = city;
	}

	public String getDistrict() {
		return District;
	}
	public void setDistrict(String district) {
		District = district;
	}

	public String getRoad() {
		return Road;
	}
	public void setRoad(String road) {
		Road = road;
	}

	public String getPublishPlace() {
		return PublishPlace;
	}
	public void setPublishPlace(String publishPlace) {
		PublishPlace = publishPlace;
	}

	public String getPublishPic() {
		return PublishPic;
	}
	public void setPublishPic(String publishPic) {
		PublishPic = publishPic;
	}

	public String getOwnSkill() {
		return OwnSkill;
	}
	public void setOwnSkill(String ownSkill) {
		OwnSkill = ownSkill;
	}

	public String getWantSkill() {
		return WantSkill;
	}
	public void setWantSkill(String wantSkill) {
		WantSkill = wantSkill;
	}

	public Date getUpdateTime() {
		return UpdateTime;
	}
	public void setUpdateTime(Date updateTime) {
		UpdateTime = updateTime;
	}

	public Integer getPublishCTR() {
		return PublishCTR;
	}
	public void setPublishCTR(Integer publishCTR) {
		PublishCTR = publishCTR;
	}

	public String getPublishMark() {
		return PublishMark;
	}
	public void setPublishMark(String publishMark) {
		PublishMark = publishMark;
	}

	public String getStatus() {
		return Status;
	}
	public void setStatus(String status) {
		Status = status;
	}

	public String getSkillType() {
		return skillType;
	}
	public void setSkillType(String skillType) {
		this.skillType = skillType;
	}
	
	
	
}