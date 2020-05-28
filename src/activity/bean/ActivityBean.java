package activity.bean;

import java.io.InputStream;
import java.io.Serializable;
import java.sql.Blob;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Base64;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "Activity")
public class ActivityBean implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "activityid")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int activityid;
	@Column(name = "memberid")
	private int memberid;
	@Column(name = "title")
	private String title;
	@Column(name = "category")
	private String category;
	@Column(name = "descript")
	private String descript;
	@Column(name = "beginDay")
	private String beginDay;
	@Column(name = "beginTime")
	private String beginTime;
	@Column(name = "endDay")
	private String endDay;
	@Column(name = "endTime")
	private String endTime;
	@Column(name = "position")
	private String position;
	@Column(name = "lat")
	private String lat;
	@Column(name = "long1")
	private String long1;
	@Column(name = "dialog")
	private String dialog;
	@Column(name = "group1")
	private Integer group1;
	@Column(name = "group2")
	private Integer group2;
	@Column(name = "fileimg")
	@JsonIgnore
	private Blob fileimg;
	@Column(name = "stat")
	private String stat;
	@Column(name = "publishCTR")
	private Integer publishCTR;
	@Column(name = "insertime")
	private java.sql.Timestamp insertime;
	@Transient
	private String imgB64;
	@Transient
	MultipartFile productImage;

	public MultipartFile getProductImage() {
		return productImage;
	}

	public void setProductImage(MultipartFile productImage) {
		this.productImage = productImage;
	}

	public ActivityBean() {

	}

	public ActivityBean(int activityid, int memberid, String title, String category, String descript, String beginDay,
			String beginTime, String endDay, String endTime, String position, String lat, String long1, String dialog,
			Integer group1, Integer group2, Blob fileimg, String stat, Integer publishCTR, Timestamp insertime) {
		super();
		this.activityid = activityid;
		this.memberid = memberid;
		this.title = title;
		this.category = category;
		this.descript = descript;
		this.beginDay = beginDay;
		this.beginTime = beginTime;
		this.endDay = endDay;
		this.endTime = endTime;
		this.position = position;
		this.lat = lat;
		this.long1 = long1;
		this.dialog = dialog;
		this.group1 = group1;
		this.group2 = group2;
		this.fileimg = fileimg;
		this.stat = stat;
		this.publishCTR = publishCTR;
		this.insertime = insertime;
	}

	public ActivityBean(int memberid, String title, String category, String descript, String beginDay, String beginTime,
			String endDay, String endTime, String position, String lat, String long1, String dialog, Integer group1,
			Integer group2, Blob fileimg, String stat, Integer publishCTR, Timestamp insertime) {
		this.memberid = memberid;
		this.title = title;
		this.category = category;
		this.descript = descript;
		this.beginDay = beginDay;
		this.beginTime = beginTime;
		this.endDay = endDay;
		this.endTime = endTime;
		this.position = position;
		this.lat = lat;
		this.long1 = long1;
		this.dialog = dialog;
		this.group1 = group1;
		this.group2 = group2;
		this.fileimg = fileimg;
		this.stat = stat;
		this.publishCTR = publishCTR;
		this.insertime = insertime;
	}

	public int getMemberid() {
		return memberid;
	}

	public void setMemberid(int memberid) {
		this.memberid = memberid;
	}

	public int getActivityid() {
		return activityid;
	}

	public void setActivityid(int activityid) {
		this.activityid = activityid;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getDescript() {
		return descript;
	}

	public void setDescript(String descript) {
		this.descript = descript;
	}

	public String getBeginDay() {
		return beginDay;
	}

	public void setBeginDay(String beginDay) {
		this.beginDay = beginDay;
	}

	public String getBeginTime() {
		return beginTime;
	}

	public void setBeginTime(String beginTime) {
		this.beginTime = beginTime;
	}

	public String getEndDay() {
		return endDay;
	}

	public void setEndDay(String endDay) {
		this.endDay = endDay;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getLat() {
		return lat;
	}

	public void setLat(String lat) {
		this.lat = lat;
	}

	public String getLong1() {
		return long1;
	}

	public void setLong1(String long1) {
		this.long1 = long1;
	}

	public String getDialog() {
		return dialog;
	}

	public void setDialog(String dialog) {
		this.dialog = dialog;
	}

	public Integer getGroup1() {
		return group1;
	}

	public void setGroup1(Integer group1) {
		this.group1 = group1;
	}

	public Integer getGroup2() {
		return group2;
	}

	public void setGroup2(Integer group2) {
		this.group2 = group2;
	}

	public Blob getFileimg() {
		return fileimg;
	}

	public void setFileimg(Blob fileimg) {
		this.fileimg = fileimg;
	}

	public String getStat() {
		return stat;
	}

	public void setStat(String stat) {
		this.stat = stat;
	}

	public Integer getPublishCTR() {
		return publishCTR;
	}

	public void setPublishCTR(Integer publishCTR) {
		this.publishCTR = publishCTR;
	}

	public java.sql.Timestamp getInsertime() {
		return insertime;
	}

	public void setInsertime(java.sql.Timestamp insertime) {
		this.insertime = insertime;
	}

	public String getImgB64() {

		int blobLength = 0;
		byte[] blobAsBytes = null;
		try {
			blobLength = (int) this.fileimg.length();
			blobAsBytes = this.fileimg.getBytes(1, blobLength);
		} catch (SQLException e1) {
			System.out.println("blob cannot tranfer to byte[]");
			e1.printStackTrace();
		}
		String imageB64 = Base64.getEncoder().encodeToString(blobAsBytes);
		return imageB64;
//release the blob and free up memory. (since JDBC 4.0)
//		blob.free();
	}



}
