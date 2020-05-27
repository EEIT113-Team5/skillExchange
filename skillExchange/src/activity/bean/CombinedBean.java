package activity.bean;

import java.io.Serializable;
import java.sql.Blob;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Base64;

import members.Model.MemberBean;

public class CombinedBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private int activityid;
	private int memberid;
	private String title;
	private String category;
	private String descript;
	private String beginDay;
	private String beginTime;
	private String endDay;
	private String endTime;
	private String position;
	private String lat;
	private String long1;
	private String dialog;
	private Integer group1;
	private Integer group2;
	private Blob fileimg;
	private String stat;
	private Integer publishCTR;
	private java.sql.Timestamp insertime;
	private String imgB64;
	private Long interest;
	private Long attendency;
	private Integer result;
	private Integer result2;
	private MemberBean member;
	
	public MemberBean getMember() {
		return member;
	}


	public void setMember(MemberBean member) {
		this.member = member;
	}


	public CombinedBean(int activityid, int memberid, String title, String category, String descript, String beginDay,
			String beginTime, String endDay, String endTime, String position, String lat, String long1, String dialog,
			Integer group1, Integer group2, Blob fileimg, String stat, Integer publishCTR, Timestamp insertime,
			Long interest, Long attendency, Integer result, Integer result2,MemberBean member ) {
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
		this.interest = interest;
		this.attendency = attendency;
		this.result = result;
		this.result2 = result2;
		this.member=member;
	}


	public Integer getResult2() {
		return result2;
	}


	public void setResult2(Integer result2) {
		this.result2 = result2;
	}


	public CombinedBean(int activityid, int memberid, String title, String category, String descript, String beginDay,
			String beginTime, String endDay, String endTime, String position, String lat, String long1, String dialog,
			Integer group1, Integer group2, Blob fileimg, String stat, Integer publishCTR, Timestamp insertime,
			Long interest, Long attendency, Integer result) {
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
		this.interest = interest;
		this.attendency = attendency;
		this.result = result;
	}

	public CombinedBean() {

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
		if (fileimg != null) {
			try {
				blobLength = (int) this.fileimg.length();
				blobAsBytes = this.fileimg.getBytes(1, blobLength);
			} catch (SQLException e1) {
				System.out.println("blob cannot tranfer to byte[]");
				e1.printStackTrace();
			}
			String imageB64 = Base64.getEncoder().encodeToString(blobAsBytes);
			return imageB64;
		}

		return null;
//release the blob and free up memory. (since JDBC 4.0)
//		blob.free();
	}

	public Long getInterest() {
		return interest;
	}

	public void setInterest(Long interest) {
		this.interest = interest;
	}

	public Long getAttendency() {
		return attendency;
	}

	public void setAttendency(Long attendency) {
		this.attendency = attendency;
	}

	public Integer getResult() {
		return result;
	}

	public void setResult(Integer result) {
		this.result = result;
	}

}
