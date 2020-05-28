package search.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import search.dao.AreaDao;
import search.model.AreaBean;

@Service
@Transactional
@EnableTransactionManagement
public class AreaService {
	@Autowired
	AreaDao aDao;
	
	public List<AreaBean> queryArea() {
		return aDao.queryArea();		
	}
}