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
@Table(name = "City")
public class CityBean implements Serializable {
	private static final long serialVersionUID = 1L;
	private int num;
	private String cityCN;
	private String publishAreaID;

	public CityBean() {
	}

	public CityBean(int num, String cityCN, String publishAreaID) {
		this.num = num;
		this.cityCN = cityCN;
		this.publishAreaID = publishAreaID;
	}

	@Id	@Column(name = "no")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	@Column(name = "cityCN")
	public String getCityCN() {
		return cityCN;
	}

	public void setCityCN(String cityCN) {
		this.cityCN = cityCN;
	}

	@Column(name = "publishAreaID")
	public String getPublishAreaID() {
		return publishAreaID;
	}

	public void setPublishAreaID(String publishAreaID) {
		this.publishAreaID = publishAreaID;
	}
}