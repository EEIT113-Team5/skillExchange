package publishCheckPage.Model;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name = "publish")
public class PublishBean implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int publishNo;
	private int memberRegNo;
	private String publishTitle;
    private String publishDetail;
    private String publishArea;
    private String city;
    private String district;
    private String road;
    private String publishPlace;
    private String publishPic;
    private String ownSkill;
    private String wantSkill;
    private Timestamp updateTime;
    private int publishCTR;
    private String publishMark;
    private int status;
    private String skillType;
    
    public PublishBean() {
    	
    }
    
    public PublishBean(String publishTitle,int memberRegNo,String publishDetail,String publishArea,String city
    		,String district,String road,String publishPlace,String publishPic
    		,String ownSkill,String wantSkill,Timestamp updateTime, String publishMark,String skillType) {
    	
    	super();
    	this.publishTitle = publishTitle;
    	this.memberRegNo = memberRegNo;
    	this.publishDetail = publishDetail;
    	this.publishArea = publishArea;
    	this.city = city;
    	this.district = district;
    	this.road = road;
    	this.publishPlace = publishPlace;
    	this.publishPic = publishPic;
    	this.ownSkill = ownSkill;
    	this.wantSkill = wantSkill;  
    	this.updateTime = updateTime;
    	this.publishMark = publishMark;
    	this.skillType = skillType;
    }
    
    public String toString() {
    	return "["+publishTitle+","+memberRegNo+","+publishDetail+","+publishArea+","+city+","
    			+ ""+district+","+road+","+publishPlace+","+publishPic+","+ownSkill+","
    					+ ""+wantSkill+","+publishCTR+","+publishMark+","+status+","+skillType+"]";
    }
	
    @Id @Column(name = "publishno")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getPublishNo() {
		return publishNo;
	}
    
	public void setPublishNo(int publishNo) {
		this.publishNo = publishNo;
	}
	
	@Column(name = "memberregno")
	public int getMemberRegNo() {
		return memberRegNo;
//		return 2;
	}
	
	public void setMemberRegNo(int memberRegNo) {
		this.memberRegNo = memberRegNo;
	}
	
	@Column(name = "skilltype")
	public String getSkillType() {
		return skillType;
	}
	
	public void setSkillType(String skillType) {
		this.skillType = skillType;
	}
	
	@Column(name = "publishtitle")
	public String getPublishTitle() {
		return publishTitle;
	}
	
	public void setPublishTitle(String publishTitle) {
		this.publishTitle = publishTitle;
	}
	
	@Column(name = "publishdetail")
	public String getPublishDetail() {
		return publishDetail;
	}
	
	public void setPublishDetail(String publishDetail) {
		this.publishDetail = publishDetail;
	}
	
	@Column(name = "publisharea")
	public String getPublishArea() {
		return publishArea;
	}
	
	public void setPublishArea(String publishArea) {
		this.publishArea = publishArea;
	}
	
	@Column(name = "city")
	public String getCity() {
		return city;
	}
	
	public void setCity(String city) {
		this.city = city;
	}
	
	@Column(name = "district")
	public String getDistrict() {
		return district;
	}
	
	public void setDistrict(String district) {
		this.district = district;
	}
	
	@Column(name = "road")
	public String getRoad() {
		return road;
	}
	
	public void setRoad(String road) {
		this.road = road;
	}
	
	@Column(name = "publishplace")
	public String getPublishPlace() {
		return publishPlace;
	}
	
	public void setPublishPlace(String publishPlace) {
		this.publishPlace = publishPlace;
	}
	
	@Column(name = "publishpic")
	public String getPublishPic() {
		return publishPic;
	}
	
	public void setPublishPic(String publishPic) {
		this.publishPic = publishPic;
	}
	
	@Column(name = "ownskill")
	public String getOwnSkill() {
		return ownSkill;
	}
	
	public void setOwnSkill(String ownSkill) {
		this.ownSkill = ownSkill;
	}
	
	@Column(name = "wantskill")
	public String getWantSkill() {
		return wantSkill;
	}
	
	public void setWantSkill(String wantSkill) {
		this.wantSkill = wantSkill;
	}
	
	@Column(name = "updatetime")
	public Timestamp getUpdateTime() {
		return updateTime;
	}
	
	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}
	
	@Column(name = "publishctr")
	public int getPublishCTR() {
		return publishCTR;
	}
	
	public void setPublishCTR(int publishCTR) {
		this.publishCTR = publishCTR;
	}
	
	@Column(name = "publishmark")
	public String getPublishMark() {
		return publishMark;
	}
	
	public void setPublishMark(String publishMark) {
		this.publishMark = publishMark;
	}
	
	@Column(name = "status")
	public int getStatus() {
//		return status;
		return 1;
	}
	public void setStatus(int status) {
		this.status = status;
	}
}

