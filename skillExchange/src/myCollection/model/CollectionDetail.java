package myCollection.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.ManyToAny;
import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name = "CollectDetail")
public class CollectionDetail {
	private int collectDetailNo;
	private int collectGroupNo;
	private int publishNo;
	private CollectionGroup collectionGroup;
	
	@Id
	@Column(name = "collectDetailNo")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getCollectDetailNo() {
		return collectDetailNo;
	}
	public void setCollectDetailNo(int collectDetailNo) {
		this.collectDetailNo = collectDetailNo;
	}
	
	@Transient
	public int getCollectGroupNo() {
		return collectGroupNo;
	}
	public void setCollectGroupNo(int collectGroupNo) {
		this.collectGroupNo = collectGroupNo;
	}
	
	@Column(name = "publishNo")
	public int getPublishNo() {
		return publishNo;
	}
	public void setPublishNo(int publishNo) {
		this.publishNo = publishNo;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "collectGroupNo")
	public CollectionGroup getCollectionGroup() {
		return collectionGroup;
	}
	public void setCollectionGroup(CollectionGroup collectionGroup) {
		this.collectionGroup = collectionGroup;
	}
	
	

}
