package com.ohgiraffers.section02.update;


import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("변경할 메뉴 번호를 입력하세요: ");
        int menuCode = sc.nextInt();
        System.out.print("변경할 메뉴 이름을 입력하세요: ");
        sc.nextLine();
        String menuName = sc.nextLine();
        System.out.print("변경할 메뉴 가격을 입력하세요: ");
        int menuPrice = sc.nextInt();

        Menu modifyMenu = new Menu(menuCode, menuName, menuPrice);
        MenuService service = new MenuService();
        service.modifyMenu(modifyMenu);
    }
}
