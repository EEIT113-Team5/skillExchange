package members.Model;

//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import javax.servlet.ServletContext;

//import javax.naming.Context;
//import javax.naming.InitialContext;
//import javax.naming.NamingException;
//import javax.sql.DataSource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDao {
	
	@Autowired
	SessionFactory factory;
	
	@Autowired
	ServletContext ctx;
	
	public Session getSession() {
		return factory.getCurrentSession();
	}
	
	@SuppressWarnings("unchecked")
	public MemberBean selectAcc(String memberAcc) {
		Query<MemberBean> query = getSession()
				.createQuery("select m from MemberBean m where m.memberAcc = :memberAcc");
		query.setParameter("memberAcc", memberAcc);
		
		List<MemberBean> memberBeanList = query.list();
		
		MemberBean memberBean = null;
		
		if (memberBeanList != null) {
			if (memberBeanList.size() > 0) {
				memberBean = memberBeanList.get(0);
			}
		}
		
		return memberBean;
	}
	
	public MemberBean selectMail(String memberMail) {
		@SuppressWarnings("unchecked")
		Query<MemberBean> query = getSession()
		.createQuery("select m from MemberBean m where m.memberMail = :memberMail");
		query.setParameter("memberMail", memberMail);
		
		List<MemberBean> memberBeanList = query.list();
		
		MemberBean memberBean = null;
		
		if (memberBeanList != null) {
			if (memberBeanList.size() > 0) {
				memberBean = memberBeanList.get(0);
			}
		}
		
		return memberBean;
	}
	
	public MemberBean saveMember(MemberBean mbean) throws SQLException, ParseException {
			
		MemberBean result = selectAcc(mbean.getMemberAcc());
		
		if(result == null) {
			this.getSession().save(mbean);
			return mbean;
		}
		
		return null;
	}
		
	
	
	public void updateMember(MemberBean mbean) {
		if (mbean != null && mbean.getMemberAcc() != null) 	{
			Session session = getSession();
			session.saveOrUpdate(mbean);
		}
	}
}


	
	
/*
	連線到資料庫取資料
	DataSource ds = null;
	public MemberDao() {
		try {
			Context context = new InitialContext();
			ds = (DataSource) context.lookup("java:comp/env/jdbc/dataBase");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	private static final String SELECT_BY_ACC 
		= "SELECT memberRegNo, memberAcc, memberPwd, accStatus, errorCount, "
				+ "memberName, memberNic, memberSex, memberBirth, memberPhone, "
				+ "memberCountry, memberAddr, memberMail, memberPic, memberRegTime, "
				+ "memberModTime, memberLastTime, memberInSkill, memberChgFrequency, infoSource "
		+ "FROM Member "
		+ "WHERE memberAcc = ?";

	public MemberBean select(String memberAcc) {
		MemberBean result = null;

		try (
			Connection conn = ds.getConnection(); 
			PreparedStatement stmt = conn.prepareStatement(SELECT_BY_ACC);
		) {
			stmt.setString(1, memberAcc);
			try (
				ResultSet rset = stmt.executeQuery();
			) {
				if (rset.next()) {
					result = new MemberBean();
					result.setMemberRegNo(rset.getInt("memberRegNo"));
					result.setMemberAcc(rset.getString("memberAcc"));
					result.setMemberPwd(rset.getString("memberPwd"));
					result.setAccStatus(rset.getString("accStatus"));
					result.setErrorCount(rset.getInt("errorCount"));
					result.setMemberName(rset.getString("memberName"));
					result.setMemberNic(rset.getString("memberNic"));
					result.setMemberSex(rset.getString("memberSex"));
					result.setMemberBirth(rset.getDate("memberBirth"));
					result.setMemberPhone(rset.getString("memberPhone"));
					result.setMemberCountry(rset.getString("memberCountry"));
					result.setMemberAddr(rset.getString("memberAddr"));
					result.setMemberMail(rset.getString("memberMail"));
					result.setMemberPic(rset.getString("memberPic"));
					result.setMemberRegTime(rset.getTimestamp("memberRegTime"));
					result.setMemberModTime(rset.getTimestamp("memberModTime"));
					result.setMemberLastTime(rset.getTimestamp("memberLastTime"));
					result.setMemberInSkill(rset.getString("memberInSkill"));
					result.setMemberChgFrequency(rset.getInt("memberChgFrequency"));
					result.setInfoSource(rset.getString("infoSource"));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();

		}
		return result;
	}
	
	// 判斷參數id(會員帳號)是否已經被現有客戶使用，如果是，傳回true，表示此id不能使用，
	// 否則傳回false，表示此id可使用。
	public boolean idExists(String id) {
		boolean exist = false;
		
		String sql = "SELECT * FROM Member WHERE memberAcc = ?";
		
		try (
			Connection connection = ds.getConnection(); 
			PreparedStatement ps = connection.prepareStatement(sql);
		) {
			ps.setString(1, id);
			
			try (ResultSet rs = ps.executeQuery();) {
				if (rs.next()) {
					exist = true;
				}
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
			throw new RuntimeException("MemberDaoImpl_Jdbc類別#idExists()發生例外: " 
					+ ex.getMessage());
		}
		
		return exist;
	}
	
	 */
	
	/*
	 
	public int insertMember(MemberBean mb) {
		String sql = "Insert Into Member " 
				+ " (memberAcc, memberPwd, memberName, memberNic, "
				+ " memberSex, memberBirth, memberPhone, memberMail, memberAddr) "
				+ " values (?, ?, ?, ?, ?, ?, ?, ?, ?)";
		int n = 0;
		try (
			Connection con = ds.getConnection(); 
			PreparedStatement ps = con.prepareStatement(sql);
		) {
			ps.setString(1, mb.getMemberAcc());
			ps.setString(2, mb.getMemberPwd());
			ps.setString(3, mb.getMemberName());
			ps.setString(4, mb.getMemberNic());
			ps.setString(5, mb.getMemberSex());
			ps.setDate(6, mb.getMemberBirth());
			ps.setString(7, mb.getMemberPhone());
			
			ps.setString(8, mb.getMemberMail());
			ps.setString(9, mb.getMemberAddr());

			n = ps.executeUpdate();
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new RuntimeException("MemberDaoImpl_Jdbc類別#saveMember()發生例外: " 
										+ ex.getMessage());
		}
		return n;
	}
	

	*/
