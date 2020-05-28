package search.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import search.model.KeywordBean;
import search.model.SearchBean;

@Repository
public class KeywordDao {
	@Autowired
	SessionFactory factory;

	public Session getSession() {
		return factory.getCurrentSession();
	}

	public boolean insertKeyword(KeywordBean kbean) {
		getSession().save(kbean);
		if (kbean != null) {
			return true;
		}
		return false;
	}

	public List<SearchBean> queryResult(String keyword, String area, String skill) {
		String hql1, hql2, hql3;
		String s1 = area;
		String s2 = skill;
		String s3 = keyword;

		if (s1 != null) {
			hql1 = " and S.publishArea = :publishArea";
		} else {
			hql1 = "";
		}

		if (s2 != null) {
			hql2 = " and S.ownSkill = :ownSkill";
		} else {
			hql2 = "";
		}

		if (s3 != "") {
			hql3 = " and S.publishTitle like :publishTitle";
		} else {
			hql3 = "";
		}
		
		String hql = "select new SearchBean(M.memberNic, S.publishNo, S.memberRegNo, S.publishTitle, S.publishDetail, S.publishArea, S.city, S.district, S.road, S.publishPlace, S.publishPic, S.ownSkill, S.wantSkill, S.updateTime, S.publishCTR, S.publishMark, S.status) from SearchBean S, MemberBean M where S.memberRegNo = M.memberRegNo and S.status='1'"
				+ hql1 + hql2 + hql3;
		
//		System.out.println("s1=" + s1 + ", s2=" + s2 + ", s3=" + s3);
//		System.out.println(hql);

		@SuppressWarnings("unchecked")
		Query<SearchBean> query = getSession().createQuery(hql);
		if (s1 != null) {
			query.setParameter("publishArea", s1);
		}

		if (s2 != null) {
			query.setParameter("ownSkill", s2);
		}

		if (s3 != "") {
			query.setParameter("publishTitle", "%" + s3 + "%");
		}

		List<SearchBean> allSearch = query.list();
		
		return allSearch;

//		String sql = "select M.memberNic, P.* from Publish as P "
//				+ "left join Member AS M ON P.MemberRegNo = M.memberRegNo " + "WHERE P.Status='1'" + hql1 + hql2 + hql3;
	}
}