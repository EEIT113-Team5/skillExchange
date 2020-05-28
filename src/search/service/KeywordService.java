package search.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import search.dao.KeywordDao;
import search.model.KeywordBean;
import search.model.SearchBean;

@Service
@Transactional
@EnableTransactionManagement
public class KeywordService {
	@Autowired
	KeywordDao kDao;
	
	public boolean insertKeyword(KeywordBean kbean) {
		return kDao.insertKeyword(kbean);
	}	
	
	public List<SearchBean> queryResult(String keyword, String area, String skill){
		return kDao.queryResult(keyword, area, skill);
	}
}