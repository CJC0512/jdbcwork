package com.ohgiraffers.section02.template;

import java.sql.Connection;

/* 설명. import 뒤에 static을 붙이고 메소드명까지 쓰게 되면
 *      다른 클래스의 static 메소드를 마치 내 class에 있는 것처럼 사용할 수 있다.*/
/* 필기. import static: static 메소드를 import하는 방법 */
import static com.ohgiraffers.section02.template.JDBCTemplate.close;
import static com.ohgiraffers.section02.template.JDBCTemplate.getConnection;

public class Application {
    public static void main(String[] args) {
        Connection con = getConnection();

        /* 설명. 비즈니스 로직(트랜잭션 처리) 실행 */

        System.out.println("con = " + con);

        close(con);
    }
}
