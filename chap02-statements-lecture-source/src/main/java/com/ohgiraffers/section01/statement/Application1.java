package com.ohgiraffers.section01.statement;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static com.ohgiraffers.common.JDBCTemplate.close;
import static com.ohgiraffers.common.JDBCTemplate.getConnection;

public class Application1 {
    public static void main(String[] args) {
        Connection con = getConnection();
        System.out.println("con = " + con);

        Statement stmt = null;      // Query 를 운반하고 결과를 반환하는 객체
        ResultSet rset = null;      // 조회의 결과가 반환되는 객체

        try {
            stmt = con.createStatement();

            /* 설명. 쿼리의 결과인 다중행/단일행을 받은 ResultSet(현재는 다중행) */
            rset = stmt.executeQuery("SELECT * FROM EMPLOYEE");

            /* 설명. rset.next() 한 행씩 확인 */
            while(rset.next()){                 // 이 반복문의 조회의 결과 행 만큼 반복

                /* 설명. 반복문 안에서의 rset은 단일행으로 해석할 것 */
                System.out.println(rset.getString("EMP_NAME") +
                                ", " + rset.getInt("SALARY"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close(rset);
            close(stmt);
            close(con);
        }
    }
}
