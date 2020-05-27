package skillClass.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Skill2")
public class Skill2 {
	private String TypeCN;
	private Integer TypeCTR;
	
	public Skill2() {
	} 
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	public String getTypeCN() {
		return TypeCN;
	}
	public void setTypeCN(String typeCN) {
		TypeCN = typeCN;
	}
	public Integer getTypeCTR() {
		return TypeCTR;
	}
	public void setTypeCTR(Integer typeCTR) {
		TypeCTR = typeCTR;
	}
	
}
