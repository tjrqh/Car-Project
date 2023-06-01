package com.kk.carApp.view;

import java.util.InputMismatchException;
import java.util.Scanner;

public class SearchCarMenu {
	public static final int SEARCH_MENU_VIEW_ALL = 1;
	public static final int SEARCH_MENU_NAME = 2;
	public static final int SEARCH_MENU_PROVIDER = 3;
	public static final int SEARCH_MENU_COLOR = 4;
	public static final int SEARCH_MENU_PRODUCE_DATE = 5;
	public static final int SEARCH_MENU_RECEIVE_DATE = 6;
	public static final int SEARCH_MENU_PRICE = 7;
	public static final int SEARCH_MENU_ACCIDENT = 8;
	public static final int SEARCH_MENU_DISPLACEMENT = 9;
	public static final int SEARCH_MENU_DISTANCE_DRIVEN = 10;
	public static final int SEARCH_MENU_FUEL = 11;
	public static final int SEARCH_MENU_TRANSMISSION = 12;
	public static final int SEARCH_MENU_PREV = 0;
	Scanner sc = new Scanner(System.in);

	public int selectMenu() {
		System.out.println("---------------------------------------------");
		System.out.println(">>\t\t고객 차량 정보 보기\t\t   <<");
		System.out.println("---------------------------------------------");
		System.out.print(" 1. 전체 데이터 보기");
		System.out.print(" 2. 차종 검색\t"); // Equal
		System.out.println(" 3. 제조사 검색"); // Equal
		System.out.print(" 4. 색상 검색\t"); // Equal
		System.out.print(" 5. 생산일 검색\t"); // up down?
		System.out.println(" 6. 입고일 검색"); // up down?
		System.out.print(" 7. 가격 검색\t"); // Equal? Up Down?
		System.out.print(" 8. 사고여부 검색\t"); // Equal
		System.out.println(" 9. 배기량 검색"); // ?
		System.out.print("10. 주행거리 검색\t"); // ?
		System.out.print("11. 연료 검색\t"); // ?
		System.out.println("12. 조작 검색 "); // Equal
		System.out.println(" 0. 이전으로"); // Prev
		System.out.println("---------------------------------------------");
		System.out.print("메뉴를 선택하세요 : ");
		int menu = -1;
		while (true) {
			try {
				menu = sc.nextInt();
				if (menu >= SearchCarMenu.SEARCH_MENU_PREV && menu <= SearchCarMenu.SEARCH_MENU_TRANSMISSION)
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
