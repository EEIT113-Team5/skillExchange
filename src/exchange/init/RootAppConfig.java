package exchange.init;

import java.beans.PropertyVetoException;
import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import activity.function.GlobalService;

@Configuration
@EnableTransactionManagement
public class RootAppConfig {
//	@Bean
//	public DataSource mySQLDataSource() {
//		ComboPooledDataSource ds = new ComboPooledDataSource();
//		ds.setUser("SkillExchange");
//		ds.setPassword("1qazxsw2");
//		try {
//			ds.setDriverClass("com.mysql.cj.jdbc.Driver");
//		} catch (PropertyVetoException e) {
//			e.printStackTrace();
//		}
//		ds.setJdbcUrl("jdbc:mysql://127.0.0.1:3306/jspdb?serverTimezone=Asia/Taipei&useSSL=false&useUnicode=true&characterEncoding=utf-8");
//		ds.setInitialPoolSize(4);
//		ds.setMaxPoolSize(8);
//		return ds;
//	}
	@Bean
	public DataSource sqlServerDataSource() {
		ComboPooledDataSource ds = new ComboPooledDataSource();
		ds.setUser("SkillExchange");
		ds.setPassword("1qazxsw2");
		try {
			ds.setDriverClass("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		} catch (PropertyVetoException e) {
			e.printStackTrace();
		}
		ds.setJdbcUrl("jdbc:sqlserver://localhost:1433;databaseName=SkillExchange");
		ds.setInitialPoolSize(4);
		ds.setMaxPoolSize(8);
		return ds;
	}

	@Bean
	public LocalSessionFactoryBean sessionFactory() {
		LocalSessionFactoryBean factory = new LocalSessionFactoryBean();
		// hibernate找sessionFactory掃描的package
		factory.setPackagesToScan(new String[] { "activity.bean", "comment.bean", "myPublish.Model",
				"publishCheckPage.Model", "publishPage.Model", "skillClass.model", "contactUs.model", "myCollection",
				"skillClass.model", "members.Model", "messageboard", "search.model" });
//		if (GlobalService.DB_TYPE == GlobalService.DB_TYPE_SQLSERVER) {
		factory.setDataSource(sqlServerDataSource());
		factory.setHibernateProperties(additionalPropertiesMsSQL());
//	    } else {
//	    	factory.setDataSource(mySQLDataSource());   
//			factory.setHibernateProperties(additionalPropertiesMySQL());
//	    }
		return factory;
	}

	@Bean(name = "transactionManager")
	@Autowired
	public HibernateTransactionManager transactionManager(SessionFactory sessionFactory) {
		HibernateTransactionManager txManager = new HibernateTransactionManager();
		txManager.setSessionFactory(sessionFactory);
		return txManager;
	}

//	private Properties additionalPropertiesMySQL() {
//		Properties properties=new Properties(); 
//		properties.put("hibernate.dialect", org.hibernate.dialect.MySQL8Dialect.class);
//		properties.put("hibernate.show_sql", Boolean.TRUE);
//		properties.put("hibernate.format_sql", Boolean.TRUE);
//		properties.put("default_batch_fetch_size", 10);
//		properties.put("hibernate.hbm2ddl.auto", "update");
//		return properties;
//	}
	private Properties additionalPropertiesMsSQL() {
		Properties properties = new Properties();
		properties.put("hibernate.dialect", org.hibernate.dialect.SQLServer2012Dialect.class);
		properties.put("hibernate.show_sql", Boolean.TRUE);
		properties.put("hibernate.format_sql", Boolean.TRUE);
		properties.put("default_batch_fetch_size", 10);
//		properties.put("hibernate.hbm2ddl.auto", "update");
		return properties;
	}

}
