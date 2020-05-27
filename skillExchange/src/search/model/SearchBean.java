package search.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "Publish")
public class SearchBean implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String memberNic;
	private String keyword;
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
	private Date updateTime;
	private int publishCTR;
	private String publishMark;
	private String status;

	public SearchBean(String memberNic,int publishNo, int memberRegNo, String publishTitle,
			String publishDetail, String publishArea, String city, String district, String road, String publishPlace,
			String publishPic, String ownSkill, String wantSkill, Date updateTime, int publishCTR, String publishMark,
			String status) {
		this.memberNic = memberNic;
		this.publishNo = publishNo;
		this.memberRegNo = memberRegNo;
		this.publishTitle = publishTitle;
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
		this.publishCTR = publishCTR;
		this.publishMark = publishMark;
		this.status = status;
	}

	public SearchBean(String keyword, String publishArea, String ownSkill) {
		this.keyword = keyword;
		this.publishArea = publishArea;
		this.ownSkill = ownSkill;
	}

	public SearchBean() {
	}

	@Transient
	public String getMemberNic() {
		return memberNic;
	}

	public void setMemberNic(String memberNic) {
		this.memberNic = memberNic;
	}
	
	@Transient
	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	@Id @Column(name = "publishno")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getPublishNo() {
		return publishNo;
	}

	public void setPublishNo(int publishNo) {
		this.publishNo = publishNo;
	}
	
	@Column(name = "memberRegNo")
	public int getMemberRegNo() {
		return memberRegNo;
	}

	public void setMemberRegNo(int memberRegNo) {
		this.memberRegNo = memberRegNo;
	}

	@Column(name = "publishTitle")
	public String getPublishTitle() {
		return publishTitle;
	}

	public void setPublishTitle(String publishTitle) {
		this.publishTitle = publishTitle;
	}

	@Column(name = "publishDetail")
	public String getPublishDetail() {
		return publishDetail;
	}

	public void setPublishDetail(String publishDetail) {
		this.publishDetail = publishDetail;
	}

	@Column(name = "publishArea")
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

	@Column(name = "publishPic")
	public String getPublishPic() {
		return publishPic;
	}

	public void setPublishPic(String publishPic) {
		this.publishPic = publishPic;
	}

	@Column(name = "ownSkill")
	public String getOwnSkill() {
		return ownSkill;
	}

	public void setOwnSkill(String ownSkill) {
		this.ownSkill = ownSkill;
	}

	@Column(name = "wantSkill")
	public String getWantSkill() {
		return wantSkill;
	}

	public void setWantSkill(String wantSkill) {
		this.wantSkill = wantSkill;
	}

	@Column(name = "updateTime")
	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	@Column(name = "status")
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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

	@Column(name = "publishPlace")
	public String getPublishPlace() {
		return publishPlace;
	}

	public void setPublishPlace(String publishPlace) {
		this.publishPlace = publishPlace;
	}

	@Column(name = "publishCTR")
	public int getPublishCTR() {
		return publishCTR;
	}

	public void setPublishCTR(int publishCTR) {
		this.publishCTR = publishCTR;
	}

	@Column(name = "publishMark")
	public String getPublishMark() {
		return publishMark;
	}

	public void setPublishMark(String publishMark) {
		this.publishMark = publishMark;
	}
}