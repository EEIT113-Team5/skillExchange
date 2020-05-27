package myCollection.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.SecondaryTable;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
public class CollectionBean implements Serializable{
	private static final long serialVersionUID = 1L;
	private int collectNo;//收藏編號
	private int collectGNo;//收藏群組編號
	private String collectGName;//收藏群組名稱
	private int collectMNo;//收藏會員編號
	private String collectMName;//收藏會員名稱
	private String collectMPic;//收藏會員圖片
	private int collectPNo;//收藏刊登編號
	private String collectPTitle;//收藏刊登標題
	public CollectionBean() {
	}
	
	public CollectionBean(int collectNo,int collectGNo, String collectGName, int collectMNo, String collectMName,
			String collectMPic, int collectPNo, String collectPTitle) {
		this.collectNo = collectNo;
		this.collectGNo = collectGNo;
		this.collectGName = collectGName;
		this.collectMNo = collectMNo;
		this.collectMName = collectMName;
		this.collectMPic = collectMPic;
		this.collectPNo = collectPNo;
		this.collectPTitle = collectPTitle;
	}

	public int getCollectGNo() {
		return collectGNo;
	}

	public void setCollectGNo(int collectGNo) {
		this.collectGNo = collectGNo;
	}

	public String getCollectGName() {
		return collectGName;
	}

	public void setCollectGName(String collectGName) {
		this.collectGName = collectGName;
	}

	public int getCollectMNo() {
		return collectMNo;
	}

	public void setCollectMNo(int collectMNo) {
		this.collectMNo = collectMNo;
	}

	public String getCollectMName() {
		return collectMName;
	}

	public void setCollectMName(String collectMName) {
		this.collectMName = collectMName;
	}

	public String getCollectMPic() {
		return collectMPic;
	}

	public void setCollectMPic(String collectMPic) {
		this.collectMPic = collectMPic;
	}

	public int getCollectPNo() {
		return collectPNo;
	}

	public void setCollectPNo(int collectPNo) {
		this.collectPNo = collectPNo;
	}

	public String getCollectPTitle() {
		return collectPTitle;
	}

	public void setCollectPTitle(String collectPTitle) {
		this.collectPTitle = collectPTitle;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("myCollectionBean [collectGNo=");
		builder.append(collectGNo);
		builder.append(", collectGName=");
		builder.append(collectGName);
		builder.append(", collectMNo=");
		builder.append(collectMNo);
		builder.append(", collectMName=");
		builder.append(collectMName);
		builder.append(", collectMPic=");
		builder.append(collectMPic);
		builder.append(", collectPNo=");
		builder.append(collectPNo);
		builder.append(", collectPTitle=");
		builder.append(collectPTitle);
		builder.append("]");
		return builder.toString();
	}

	public int getCollectNo() {
		return collectNo;
	}

	public void setCollectNo(int collectNo) {
		this.collectNo = collectNo;
	}
	

}
