package myCollection.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.stereotype.Component;

import members.Model.MemberBean;

@Component
@Entity
@Table(name = "CollectGroup")
public class CollectionGroup {
	private int collectGroupNo;
	private int memberRegNo;
	private String collectGroupName;
	private Set<CollectionDetail> collectDetails = new HashSet<>();


	@Id
	@Column(name = "collectGroupNo")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getCollectGroupNo() {
		return collectGroupNo;
	}

	public void setCollectGroupNo(int collectGroupNo) {
		this.collectGroupNo = collectGroupNo;
	}

	@Column(name = "memberRegNo")
	public int getMemberRegNo() {
		return memberRegNo;
	}

	public void setMemberRegNo(int memberRegNo) {
		this.memberRegNo = memberRegNo;
	}

	@Column(name = "collectGroupName")
	public String getCollectGroupName() {
		return collectGroupName;
	}

	public void setCollectGroupName(String collectGroupName) {
		this.collectGroupName = collectGroupName;
	}

	@OneToMany(fetch = FetchType.LAZY,mappedBy = "collectionGroup",cascade = CascadeType.ALL)
	public Set<CollectionDetail> getCollectDetails() {
		return collectDetails;
	}

	public void setCollectDetails(Set<CollectionDetail> collectDetails) {
		this.collectDetails = collectDetails;
	}
	


}
