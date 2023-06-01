package com.kk.carApp.view;

import java.util.InputMismatchException;
import java.util.Scanner;

public class DeleteCarMenu {
	public static final int DELETE_MENU_VIEW_ALL = 1;
	public static final int DELETE_MENU_DO = 2;
	public static final int DELETE_MENU_PREV = 0;

	Scanner sc = new Scanner(System.in);

	public int deleteMenu() {
		System.out.println("---------------------");
		System.out.println("    차량 정보 삭제");
		System.out.println("---------------------");
		System.out.println(" 1. 전체 데이터 보기");
		System.out.println(" 2. 삭제하기");
		System.out.println(" 0. 이전으로");
		System.out.println("---------------------");
		System.out.print("메뉴를 선택하세요 : ");
		int menu = -1;
		while (true) {
			try {
				menu = sc.nextInt();
				if (menu >= DeleteCarMenu.DELETE_MENU_PREV && menu <= DeleteCarMenu.DELETE_MENU_DO)
					break;
				else
					System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
			} catch (InputMismatchException e) {
				sc = new Scanner(System.in);
				System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
			}
		}
		return menu;

	}
}
