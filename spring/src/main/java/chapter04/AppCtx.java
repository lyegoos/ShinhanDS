package chapter04;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "chapter04")	//	 챕터04부터 모든 하위 패키지들을 전부다 뒤진다.(스캔)
public class AppCtx {
	
	
}