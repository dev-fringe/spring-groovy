package dev.fringe.persistence

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;

public interface TestMapper {

	@Select('''
			select * 
			  from public.sample
		''')
	public List<Map> select();
}
