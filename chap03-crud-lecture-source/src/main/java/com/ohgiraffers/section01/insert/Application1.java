package com.ohgiraffers.section01.insert;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static com.ohgiraffers.common.JDBCTemplate.close;
import static com.ohgiraffers.common.JDBCTemplate.getConnection;

public class Application1 {
    public static void main(String[] args) {
        Connection con = getConnection();
        PreparedStatement pstmt = null;

        /* 설명.
         *   DML(insert, update, delete) 작업 시에는 반환 결과가 int값이 된다. (ResultSet을 쓰지 않는다.)
         *   그리고 기존의 조회일 때는 executeQuery()를 사용했지만 DML 작업 시에는 executeUpdate()를 사용함
         * */
        int result = 0;

        String query = "INSERT INTO TBL_MENU (MENU_NAME, MENU_PRICE, CATEGORY_CODE, ORDERABLE_STATUS) "
                + "VALUES (?, ?, ?, ?)";
        try {
            pstmt = con.prepareStatement(query);
            pstmt.setString(1, "봉골레청국장");
            pstmt.setInt(2, 5000);
            pstmt.setInt(3, 4);
            pstmt.setString(4, "Y");

            result = pstmt.executeUpdate();     // 자동 커밋 상태에서는 executeUpadate 하면 자동 커밋된다. (feat, 수동 커밋 변환)

            if (result > 0) {
                System.out.println("insert 결과: " + result + ", 수동 커밋하기!");
                con.commit();
            } else
                con.rollback();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close(pstmt);
            close(con);
        }


    }
}
