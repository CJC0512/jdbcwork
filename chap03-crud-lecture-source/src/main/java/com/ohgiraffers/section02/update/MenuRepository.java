package com.ohgiraffers.section02.update;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

public class MenuRepository {

    public int modifyMenu(Connection con, Menu modifyMenu) {
        int result = 0;
        Properties prop = new Properties();

        PreparedStatement pstmt = null;

        try {

            /* 설명. section01에 있는 xml 파일의 updateMenu query 가져오기*/
            prop.loadFromXML(
                    new FileInputStream("src/main/java/com/ohgiraffers/section01/insert/mapper/menu-mapper.xml"));
            String query = prop.getProperty("updateMenu");

//            System.out.println("query = " + query);

            pstmt = con.prepareStatement(query);
            pstmt.setString(1, modifyMenu.getMenuName());
            pstmt.setInt(2, modifyMenu.getMenuPrice());
            pstmt.setInt(3, modifyMenu.getMenuCode());

            /* 설명. INSERT, UPDATE, DELETE는 모두 executeUpdate()로 날린다. */
            result = pstmt.executeUpdate();

        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        return result;
    }
}
