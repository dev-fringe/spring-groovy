package dev.fringe.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.*;
import org.mybatis.spring.annotation.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.context.annotation.*;
import org.springframework.core.io.ClassPathResource
import org.springframework.jdbc.datasource.init.DataSourceInitializer
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator
import org.springframework.orm.hibernate5.LocalSessionFactoryBean
import org.springframework.transaction.annotation.*;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
@MapperScan(basePackages = 'dev.fringe.persistence')
@PropertySource('classpath:database.properties')
@EnableTransactionManagement
public class MainConfig {

    @Value('${db.driverClassName}')
    private String driverClassName;
    @Value('${db.url}')
    private String url;
    @Value('${db.username}')
    private String username;
    @Value('${db.password}')
    private String password;

    @Bean
    public DataSource dataSource() {
    	HikariConfig c = new HikariConfig();
    	c.setDriverClassName(driverClassName);
    	c.setJdbcUrl(url);
        c.setUsername(username);
        c.setPassword(password);
        return new HikariDataSource(c);
    }
    
    @Bean
    public SqlSessionFactory sqlSessionFactory(@Qualifier('dataSource') DataSource d) throws Exception {
        SqlSessionFactoryBean s = new SqlSessionFactoryBean();
        s.setDataSource(d);
        s.setTypeAliasesPackage('dev.fringe.model');
        return s.getObject();
    }

    @Bean
    public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory s) {
        return new SqlSessionTemplate(s);
    }
	
	@Bean
	public DataSourceInitializer dataSourceInitializer(@Qualifier('dataSource') DataSource d) {
	    ResourceDatabasePopulator p = new ResourceDatabasePopulator();
	    p.addScript(new ClassPathResource('/data.sql'));
	    DataSourceInitializer i = new DataSourceInitializer();
	    i.setDataSource(d);
	    i.setDatabasePopulator(p);
	    return i;
	}
	@Bean
	public LocalSessionFactoryBean localSessionFactoryBean() {
		LocalSessionFactoryBean localSessionFactoryBean = new LocalSessionFactoryBean();
		localSessionFactoryBean.setDataSource(dataSource());
		localSessionFactoryBean.setPackagesToScan("dev.fringe.model");
		Properties properties = new Properties();
		properties.put("hibernate.dialect", "org.hibernate.dialect.HSQLDialect");
		properties.put("hibernate.hbm2ddl.auto", "create");
		localSessionFactoryBean.setHibernateProperties(properties);
		return localSessionFactoryBean;
	}
}
