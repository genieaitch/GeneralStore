package edu.store.kh.GeneralStore.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

@Configuration
@PropertySource("classpath:/config.properties") //MYSQL 아이디 비밀번호 데이터베이스저장소명칭
public class DBConfig {

    @Autowired
    private ApplicationContext applicationContext; // 현재 프로젝트

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.hikari")
    public HikariConfig hikariConfig() {

        return new HikariConfig();
    }


    @Bean
    public DataSource dataSource(HikariConfig config) {

        //지역 변수 'dataSource'이(가) 중복됩니다.
        // → dto ~ controller 까지 데이터 중복되거나 문제 있을 때 발생하는 에러
        DataSource dataSource = new HikariDataSource(config);
        return dataSource;
    }
    @Bean
    public SqlSessionFactory sessionFactory(DataSource dataSource) throws Exception{

        SqlSessionFactoryBean sessionFactoryBean = new SqlSessionFactoryBean();


        sessionFactoryBean.setDataSource(dataSource);


        sessionFactoryBean.setMapperLocations(
                applicationContext.getResources("classpath:/mappers/**.xml")  );

        sessionFactoryBean.setTypeAliasesPackage("edu.store.kh.GeneralStore.dto");

        sessionFactoryBean.setConfigLocation(
                applicationContext.getResource("classpath:mybatis-config.xml"));

        return sessionFactoryBean.getObject();
    }

    @Bean
    public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory factory) {
        return new SqlSessionTemplate(factory);
    }


    @Bean
    public DataSourceTransactionManager
    dataSourceTransactionManager(DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }


}