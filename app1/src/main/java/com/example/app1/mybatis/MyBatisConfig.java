package com.example.app1.mybatis;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.io.IOException;

//@Configuration이라는게 붙어있으면 각각의 메소드들이 전부다 spring에 등록이 되어야 사용가능하다. -> 클래스는 @Component로 등록하고, 필드들은 @Bean객체로 등록해줘야한다.
@Configuration //이걸 붙이면 springboot가 설정파일이라고 인식, 최초실행시 딱한번 작업해준다.
@RequiredArgsConstructor//생성자 주입
public class MyBatisConfig {
    private final ApplicationContext applicationContext;

    @ConfigurationProperties(prefix = "spring.datasource.hikari") //prefix로 application.properties에 있는 datasource.hikari 설정들을 갖고온다.
    //(application.properties은 외부설정이기떄문에 이런식으로 갖고온다)
    @Bean
    public HikariConfig hikariConfig() {
        return new HikariConfig(); //spring.datasource.hikari 안에 있는 경로들이 자동으로 여기로 들어오게된다.(경로들은 데이터베이스 연결시키는것들이 있다)
    }

    @Bean
    public DataSource dataSource() {
        return new HikariDataSource(hikariConfig());
    } //위에있는 hikariConfig()메소드를 안에 넣으면 연결객체를 가져올수 있게된다.

    @Bean
    public SqlSessionFactory sqlSessionFactory() throws IOException {

        //아래 Bean은 팩토리를 지을때 여러가지 설정을 할수있는 객체
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource()); //위에 있는 dataSource()하면 이 데이터베이스 설정으로 팩토리가 지어진다.
        sqlSessionFactoryBean.setMapperLocations(applicationContext.getResources("classpath*:/mapper/*.xml"));
        //MapperLocations()은 mapper파일의 경로를 잡아준다. 이제 뒤에 mapper로 끝나면 걔네는 모두 매퍼로 경로를 인식해준다.
        sqlSessionFactoryBean.setConfigLocation(applicationContext.getResource("classpath:/config/config.xml"));
        //mapper는 여러개니까 locations,resources 등 복수로 썻는데 config파일은 하나니까 복수가아니다, 이렇게 config 파일 등록시킨다.

        try {
            SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBean.getObject();
            sqlSessionFactory.getConfiguration().setMapUnderscoreToCamelCase(true);
            //언더바표기법을 -> 카맬표기법으로 바꿔줌으로써 디비에 있는 컬럼명과 필드에 있는 컬럼명이 동일하게 매핑이된다.
            return sqlSessionFactory;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}



