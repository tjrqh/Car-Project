package com.kk.carApp.view;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ModifyCarMenu {
	public static final int MODIFY_MENU_VIEW_ALL = 1;
	public static final int MODIFY_MENU_DO = 2;
	public static final int MODIFY_MENU_PREV = 0;

	public static final int MODIFY_MOD_ALL = 1;
	public static final int MODIFY_MOD_NAME = 2;
	public static final int MODIFY_MOD_PROVIDER = 3;
	public static final int MODIFY_MOD_COLOR = 4;
	public static final int MODIFY_MOD_PRODUCE_DATE = 5;
	public static final int MODIFY_MOD_RECEIVE_DATE = 6;
	public static final int MODIFY_MOD_PRICE = 7;
	public static final int MODIFY_MOD_ACCIDENT = 8;
	public static final int MODIFY_MOD_DISPLACEMENT = 9;
	public static final int MODIFY_MOD_DISTANCE_DRIVEN = 10;
	public static final int MODIFY_MOD_FUEL = 11;
	public static final int MODIFY_MOD_TRANSMISSION = 12;
	public static final int MODIFY_MOD_PREV = 0;

	Scanner sc = new Scanner(System.in);

	public int modifyModSelect() {
		System.out.println("---------------------------------------------");
		System.out.println(">>\t\t고객 차량 정보 수정\t\t   <<");
		System.out.println("---------------------------------------------");
		System.out.print(" 1. 전체 데이터 수정");
		System.out.print(" 2. 차종 수정\t");
		System.out.println(" 3. 제조사 수정");
		System.out.print(" 4. 색상 수정\t");
		System.out.print(" 5. 생산일 수정\t");
		System.out.println(" 6. 입고일 수정");
		System.out.print(" 7. 가격 수정\t");
		System.out.print(" 8. 사고여부 수정\t");
		System.out.println(" 9. 배기량 수정");
		System.out.print("10. 주행거리 수정\t");
		System.out.print("11. 연료 수정\t");
		System.out.println("12. 조작 수정 ");
		System.out.println(" 0. 이전으로");
		System.out.println("---------------------------------------------");
		System.out.print("메뉴를 선택하세요 : ");
		int menu = -1;
		while (true) {
			try {
				menu = sc.nextInt();
				if (menu >= ModifyCarMenu.MODIFY_MOD_PREV && menu <= ModifyCarMenu.MODIFY_MOD_TRANSMISSION)
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

	public int modifyMenu() {
		System.out.println("---------------------");
		System.out.println("    차량 정보 수정");
		System.out.println("---------------------");
		System.out.println(" 1. 전체 데이터 보기");
		System.out.println(" 2. 수정하기");
		System.out.println(" 0. 이전으로");
		System.out.println("---------------------");
		System.out.print("메뉴를 선택하세요 : ");
		int menu = -1;
		while (true) {
			try {
				menu = sc.nextInt();
				if (menu >= ModifyCarMenu.MODIFY_MENU_PREV && menu <= ModifyCarMenu.MODIFY_MENU_DO)
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
