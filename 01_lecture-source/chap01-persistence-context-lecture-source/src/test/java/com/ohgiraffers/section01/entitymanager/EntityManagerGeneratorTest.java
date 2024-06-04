package com.ohgiraffers.section01.entitymanager;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

public class EntityManagerGeneratorTest {

    /* All -> before : 최초 한 번 테스트 코드가 실행하기 전 동작 */
    @BeforeAll
    static void beforeAllTest() {
        System.out.println("===========BeforeAll=============");
    }
    @BeforeEach
    void beforeEachTest() {
        System.out.println("==========BeforeEach=============");
    }
    @AfterEach
    void afterEachTest() {
        System.out.println("==========AfterEach=============");
    }

    @AfterAll
    static void afterAllTest() {
        System.out.println("===========AfterAll==============");
    }

    /* 수업목표. Persistence Context 를 이해하기 위한 엔티티 매니저와 팩토리 */

    /* 필기.
    *   엔티티 매니저 팩토리
    *   엔티티 매니저를 생성할 수 있는 기능을 제공하는 팩토리 클래스이다.
    *   엔티티 매니저 팩토리는 tread-safe 하기 때문에 여러 쓰레드가
    *   동시에 접근해도 안전하기 때문에 공유해서 재사용을 한다.
    *   tread-safe 한 기능들은 매번 생성하기 에는 비용(시간 , 메모리)
    *   부담이 크기 때문에 application 스코프와 동일하게
    *   singleton 으로 생성해서 관리하는 것이 효율적이다.
    *   따라서 데이터베이스를 사용하는 어플리케이션 당 한 개의
    *   EntityManagerFactory 를 생성한다.
    *  */

}
