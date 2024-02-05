package com.ohgiraffers.section01.statement;

import java.sql.Connection;

import static com.ohgiraffers.common.JDBCTemplate.getConnection;

public class Application1 {
    public static void main(String[] args) {
        Connection con = getConnection();

        System.out.println("con = " + con);
    }
}
