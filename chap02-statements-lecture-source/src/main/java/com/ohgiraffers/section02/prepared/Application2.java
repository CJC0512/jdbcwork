package com.ohgiraffers.section02.prepared;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import static com.ohgiraffers.common.JDBCTemplate.close;
import static com.ohgiraffers.common.JDBCTemplate.getConnection;

/* 설명.
*   PreparedStatement는 Statement와 달리 Placeholder(?)를 사용한 쿼리를 파싱하고 캐싱하여
*   다시 재해석하는 과정을 생략함으로 인해 불완전하게 작성된 쿼리 싱행의 경우 Statement 보다 빠르다.
* */

public class Application2 {
    public static void main(String[] args) {

        Connection con = getConnection();

        PreparedStatement pstmt = null;
        ResultSet rset = null;

        Scanner sc = new Scanner(System.in);
        System.out.print("사번을 입력하세요: ");
        String empId = sc.nextLine();

        String entYN = "N";

        /* 설명. PreparedStatement 는 Statement 때와 달리 placeholder(?) 를 활용한 하나의 문자열 형태로 쿼리 작성 가능 */
        String query = "SELECT EMP_ID, EMP_NAME FROM EMPLOYEE WHERE EMP_ID = ? AND ENT_YN = ?";

        try {
            pstmt = con.prepareStatement(query);

            pstmt.setString(1, empId);
            pstmt.setString(2, entYN);

            rset = pstmt.executeQuery();

            if (rset.next()) {
                System.out.println(rset.getString("EMP_ID")
                        + "," + rset.getString("EMP_NAME")
                );
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close(rset);
            close(pstmt);
            close(con);
        }
    }
}
