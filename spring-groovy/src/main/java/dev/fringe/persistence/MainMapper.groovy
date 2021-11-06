package dev.fringe.persistence

import org.apache.ibatis.annotations.Select;

import dev.fringe.model.MainModel

public interface MainMapper {

	@Select('''
<<<<<<< HEAD
			select *
=======
			select distinct(#{model}) as test 
>>>>>>> branch 'master' of https://github.com/dev-fringe/spring-groovy.git
			  from public.sample
            
		''')
	public List<Map> select(MainModel main);
}
