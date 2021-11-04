package dev.fringe.config;

import javax.sql.DataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.*;
import org.mybatis.spring.annotation.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.context.annotation.*;
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
    	HikariConfig config = new HikariConfig();
    	config.setDriverClassName(driverClassName);
    	config.setJdbcUrl(url);
        config.setUsername(username);
        config.setPassword(password);
        return new HikariDataSource(config);
    }
    
    @Bean
    public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
        SqlSessionFactoryBean sqlSessionFactory = new SqlSessionFactoryBean();
        sqlSessionFactory.setDataSource(dataSource);
        sqlSessionFactory.setTypeAliasesPackage("dev.fringe.model");
        return sqlSessionFactory.getObject();
    }

    @Bean
    public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
