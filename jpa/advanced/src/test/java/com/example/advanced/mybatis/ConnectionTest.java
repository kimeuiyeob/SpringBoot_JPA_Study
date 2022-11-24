package com.example.advanced.mybatis;

import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Connection;

@SpringBootTest
@Slf4j
public class ConnectionTest {
    @Autowired
    private SqlSessionFactory sqlSessionFactory;

    @Test
    public void sqlSessionTest(){
        try(Connection connection = sqlSessionFactory.openSession(true).getConnection()){
            log.info("sqlSession connection: " + connection);
        }catch (Exception e){
            log.info(e.getMessage());
        }
    }
}
