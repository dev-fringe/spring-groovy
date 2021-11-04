package dev.fringe
import org.springframework.beans.factory.*
import org.springframework.beans.factory.annotation.*
import org.springframework.context.annotation.*

import dev.fringe.config.MainConfig
import dev.fringe.model.MainModel
import dev.fringe.persistence.MainMapper

@Configuration
@Import(value = MainConfig.class)
public class Main implements InitializingBean {
	
	@Autowired MainMapper mapper;
	
	static void main(String[] args) {
		new AnnotationConfigApplicationContext(Main.class)
	}
	
	public void afterPropertiesSet() throws Exception {
		MainModel main = new MainModel(model: 'ss', type: 'sdsd');
		println main
		println mapper.select(main);
	}
}