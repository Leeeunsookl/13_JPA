package com.ohgiraffers.problem;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ProblemOfUsingDirectionTests {

    /* 수업목표. 테스트 코드 기반으로 JPA 를 사용하지 않았을 때 문제를 알아보자 */

    /* 필기.
    *   테스트 클래스란?
    *   @Test 라는 annotation 이 1개 이상 가지고 있는 클래스를 의미한다.
    *   테스트 메소드는 반환값을 기대하지 않으며, void 형으로 작성해야 한다.
    *   또한 접근제한자는 사용하지 않아도 되지만(default), private 는 안된다.
    *  */

    private Connection con;

    /* 우리가 작성한 테스트 메소드가 실행하기 이전에 1번씩 동작을 할 수 있는 annotation */
    @BeforeEach
    void setConnection() throws ClassNotFoundException, SQLException {
        String driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/menudb";
        String user = "ohgiraffers";
        String password = "ohgiraffers";

        Class.forName(driver);

        con = DriverManager.getConnection(url, user, password);
        con.setAutoCommit(false);

    }

    @AfterEach
    void closeConnection() throws SQLException {
        con.rollback();
        con.close();
    }

    /* 필기.
    *   JDBC 를 이용해 직접 SQL 을 다룰 때 발생할 수 있는 문제점 확인
    *
    *  */

}
