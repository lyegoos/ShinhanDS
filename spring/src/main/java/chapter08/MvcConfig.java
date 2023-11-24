package chapter08;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.zaxxer.hikari.HikariDataSource;

@Configuration
@ComponentScan(basePackages = {"kr.co.test","chapter08"})
@EnableWebMvc
@MapperScan(basePackages = {"chapter08"}, annotationClass = Mapper.class)		// 인터페이스를 스캔해주는 설정
public class MvcConfig implements WebMvcConfigurer{
	// html,css,js,img.... 컨트롤러에서 매핑되지 않은 URL을 톰캣에서 처리하기 위해
	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}
	// ViewResolver설정 (JSP 경로)
	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		registry.jsp("/WEB-INF/views/", ".jsp");
	}
	// 정적페이지 설정
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/event/index.do");
	}
	
	//HikariCP
	@Bean(destroyMethod = "close")		// db에 접속하는 bean
	public HikariDataSource dataSource() {	//데이터 소스 객체 생성, 미리 커넥션 객체를 만들어두기 위해서 히카리데이터소스를 사용
		HikariDataSource dataSource = new HikariDataSource();
//		dataSource.setDriverClassName("com.mysql.jdbc.Driver");		// dataSource라는 객체에 문자열을 주입하는 것
//		dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/test");
		dataSource.setDriverClassName("net.sf.log4jdbc.sql.jdbcapi.DriverSpy");		// dataSource라는 객체에 문자열을 주입하는 것
		dataSource.setJdbcUrl("jdbc:log4jdbc:mysql://localhost:3306/test");
		dataSource.setUsername("testuser");
		dataSource.setPassword("qwe123");							// 주입의 목적 : 바뀔수있는 내용을 주입을 통해서 정해주는 것
		return dataSource;
	}
	
	// mybatis bean에 db접속 bean을 주입해야 한다.
	
	//Mybatis
	@Bean
	public SqlSessionFactory sqlSessionFactory() throws Exception {
		SqlSessionFactoryBean ssf = new SqlSessionFactoryBean();
		ssf.setDataSource(dataSource()); // DataSource 객체 주입
		//sql(xml파일로 따로 만들기) 위치 지정
//		PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver(); // 얘를 왜 만드느냐? xml을 매퍼파일이라고 말하는데, 이거를 찾기위해 경로를 줄 때 resources 뭐시기 타입이 매개변수로 들어간다. PathMatchingResourcePatternResolver 이게 타입이 resources다.
//		ssf.setMapperLocations(resolver.getResources("classpath:/mapper/**/*.xml"));	//매퍼파일이 있는 경로를 셋해준다.
		// 이 두줄은 xml파일의 경로를 지정해주는 거라서 필요가 없다.
		// 매퍼파일의 위치(패키지)는 인터페이스와 동일하게 할거기 때문에,,
		
		return ssf.getObject();	// factorybean은 factory 안에 있으므로, getObject를 하면 SqlSessionFactory가 나온다.
	}
	
	//DAO에서 주입받을 객체(빈) 등록	// DAO 안 쓸거니까 필요없음
//	@Bean
//	public SqlSessionTemplate sqlSessionTemplate() throws Exception  {
//		return new SqlSessionTemplate(sqlSessionFactory());		// 생성자를 통해서 주입
//	}
}