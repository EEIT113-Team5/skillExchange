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
@Table(name = "Skill")
public class SkillBean implements Serializable{
	private static final long serialVersionUID = 1L;
	private int skillNo;
	private String skillNameCN;
	private String skillNameEN;
	private String typeCN;
	private String typeEN;
	
	public SkillBean(String skillNameCN) {
		this.skillNameCN = skillNameCN;
	}

	public SkillBean(int skillNo, String skillNameCN, String skillNameEN, String typeCN, String typeEN) {
		this.skillNo = skillNo;
		this.skillNameCN = skillNameCN;
		this.skillNameEN = skillNameEN;
		this.typeCN = typeCN;
		this.typeEN = typeEN;
	}
	
	public SkillBean() {
	}

	@Id @Column(name = "skillNo")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getSkillNo() {
		return skillNo;
	}

	public void setSkillNo(int skillNo) {
		this.skillNo = skillNo;
	}

	@Column(name = "skillNameCN")
	public String getSkillNameCN() {
		return skillNameCN;
	}

	public void setSkillNameCN(String skillNameCN) {
		this.skillNameCN = skillNameCN;
	}

	@Column(name = "skillNameEN")
	public String getSkillNameEN() {
		return skillNameEN;
	}

	public void setSkillNameEN(String skillNameEN) {
		this.skillNameEN = skillNameEN;
	}

	@Column(name = "typeCN")
	public String getTypeCN() {
		return typeCN;
	}

	public void setTypeCN(String typeCN) {
		this.typeCN = typeCN;
	}

	@Column(name = "typeEN")
	public String getTypeEN() {
		return typeEN;
	}

	public void setTypeEN(String typeEN) {
		this.typeEN = typeEN;
	}	
}