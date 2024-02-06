package com.ohgiraffers.section02.update;

import java.sql.Connection;

import static com.ohgiraffers.common.JDBCTemplate.*;

public class MenuService {
    public void modifyMenu(Menu modifyMenu) {
        Connection con = getConnection();

        MenuRepository repository = new MenuRepository();
        int result = repository.modifyMenu(con, modifyMenu);

        if (result > 0){
            System.out.print("Commit...");
            commit(con);
            System.out.println("완료...!!");
        }else {
            System.out.println("오류 발생! rollback 시행...");
            rollback(con);
        }
        close(con);
    }
}
