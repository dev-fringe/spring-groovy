package dev.fringe
import org.springframework.beans.factory.*
import org.springframework.beans.factory.annotation.*
import org.springframework.context.annotation.*

import dev.fringe.config.MainConfig
import dev.fringe.model.MainModel
import dev.fringe.persistence.MainMapper
import dev.fringe.service.MainService

@Configuration
@Import(value = MainConfig.class)
public class Main implements InitializingBean {
	
	@Autowired MainService mainService;
	
	static void main(String[] args) {
		new AnnotationConfigApplicationContext(Main.class)
	}
	
	public void afterPropertiesSet() throws Exception {
		MainModel main = new MainModel(model: '23', type: 'sdsd');
		mainService.save(main)
		println main
//		println mapper.select(main);
	}
}