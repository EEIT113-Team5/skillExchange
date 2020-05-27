package search.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name = "PublishArea")
public class AreaBean implements Serializable{
	private static final long serialVersionUID = 1L;
	private int num;
	private String publishAreaCode;
	private String publishAreaCN;
	private String publishAreaEN;

	public AreaBean(Integer num, String publishAreaCode, String publishAreaCN, String publishAreaEN) {
		this.num = num;
		this.publishAreaCode = publishAreaCode;
		this.publishAreaCN = publishAreaCN;
		this.publishAreaEN = publishAreaEN;
	}

	public AreaBean() {
	}
	
	@Id @Column(name = "no")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	@Column(name = "publishAreaID")
	public String getPublishAreaCode() {
		return publishAreaCode;
	}

	public void setPublishAreaCode(String publishAreaCode) {
		this.publishAreaCode = publishAreaCode;
	}

	@Column(name = "publishAreaCN")
	public String getPublishAreaCN() {
		return publishAreaCN;
	}

	public void setPublishAreaCN(String publishAreaCN) {
		this.publishAreaCN = publishAreaCN;
	}

	@Column(name = "publishAreaEN")
	public String getPublishAreaEN() {
		return publishAreaEN;
	}

	public void setPublishAreaEN(String publishAreaEN) {
		this.publishAreaEN = publishAreaEN;
	}

}