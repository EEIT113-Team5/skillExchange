package search.model;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name = "Keyword")
public class KeywordBean implements Serializable{
	private static final long serialVersionUID = 1L;
	private String keyWord;
	private Timestamp createDate;
	
	public KeywordBean(String keyWord, Timestamp createDate) {
		this.keyWord = keyWord;
		this.createDate = createDate;
	}
	
	public KeywordBean() {
	}

	@Column(name = "keyWord")
	public String getKeyWord() {
		return keyWord;
	}

	public void setKeyWord(String keyWord) {
		this.keyWord = keyWord;
	}

	@Id @Column(name = "createDate")
	public Timestamp getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}
}