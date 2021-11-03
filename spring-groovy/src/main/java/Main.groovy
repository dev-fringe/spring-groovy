import org.springframework.beans.factory.InitializingBean
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.AnnotationConfigApplicationContext
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Import

import config.MainConfig
import dev.fringe.persistence.TestMapper

@Configuration
@Import(value = MainConfig.class)
public class Main implements InitializingBean {
	
	@Autowired TestMapper mapper;
	static void main(String[] args) {
		new AnnotationConfigApplicationContext(Main.class)
	}
	public void afterPropertiesSet() throws Exception {
		println"ss"
		println mapper.select();
	}
}