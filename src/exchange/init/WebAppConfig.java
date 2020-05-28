package exchange.init;

import javax.servlet.ServletContext;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.support.OpenSessionInViewInterceptor;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = { "activity", "comment", "myPublish", "exchange.init", "publishCheckPage", "publishPage",
		"publishSkill", "skillClass", "home.controller", "contactUs", "myCollection", "members", "messageboard",
		"search" })
public class WebAppConfig implements WebMvcConfigurer {

	@Autowired
	ServletContext context;

	@Autowired
	SessionFactory sessionFactory;

	// 配置 Spring提供的 InternalResourceViewResolver
	@Bean
	public ViewResolver jspViewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setViewClass(JstlView.class);
		viewResolver.setPrefix("/WEB-INF/"); // 結尾要寫斜線
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}

	@Bean
	public CommonsMultipartResolver multipartResolver() {
		CommonsMultipartResolver resolver = new CommonsMultipartResolver();
		resolver.setDefaultEncoding("UTF-8");
		resolver.setMaxUploadSize(81920000);
		return resolver;
	}

//分派器如果找不到資源(css, 圖檔等等)會交給此default方法來找這些資源
	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}

//    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        //將templates目錄下的CSS、JS文件映射為靜態資源，防止Spring把這些資源識別成thymeleaf模版
////        registry.addResourceHandler("/templates/**.js").addResourceLocations("classpath:/activityimg/");
//        registry.addResourceHandler("/css/**.css").addResourceLocations("classpath:/css/");
//        //其他靜態資源
////        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
//    }

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		OpenSessionInViewInterceptor openSessionInViewInterceptor = new OpenSessionInViewInterceptor();
		openSessionInViewInterceptor.setSessionFactory(sessionFactory);
		registry.addWebRequestInterceptor(openSessionInViewInterceptor).addPathPatterns("/**");
	}
}
