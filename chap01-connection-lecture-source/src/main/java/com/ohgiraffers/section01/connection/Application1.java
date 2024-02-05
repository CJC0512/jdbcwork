package com.ohgiraffers.section01.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/* 수업목표. 해당 DBMS와 계정에 맞는 Connection 객체를 생성할 수 있다. (feat. DBMS Driver 추가) */
public class Application1 {
    public static void main(String[] args) {

        Connection con = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            /* 필기.
             *  연동을 할 수 있는 통로(스트림)이 생성됨
             *  con = com.mysql.cj.jdbc.ConnectionImpl@59906517
             * */
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306", "swcamp", "swcamp");

            System.out.println("con = " + con);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                /* 필기. 스트림이 생성이 안됐거나, 스트림은 생성되었는데, 아직 안 닫혔다면 */
                if (con != null && !con.isClosed()) con.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
