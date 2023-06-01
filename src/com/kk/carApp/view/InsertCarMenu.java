package com.kk.carApp.view;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.kk.carApp.DTO.Car;

public class InsertCarMenu {
	Scanner sc = new Scanner(System.in);

	public Car insertData() {
		System.out.println("-----------------");
		System.out.println("차량 정보 입력을 시작합니다.");
		System.out.print("차량 이름 : ");
		String iCarName = sc.nextLine();
		System.out.print("제조사 : ");
		String iCarProvider = sc.nextLine();
		System.out.print("색상 : ");
		String iCarColor = sc.nextLine();
		System.out.print("생산일 : ");
		String iCarProduceDate = sc.nextLine();
		System.out.print("입고일 : ");
		String iCarReceiveDate = sc.nextLine();
		System.out.print("가격 : ");
		int iCarPrice = 0;
		while (true) {
			try {
				iCarPrice = sc.nextInt();
				break;
			} catch (InputMismatchException e) {
				sc = new Scanner(System.in);
				System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
				System.out.print("가격 : ");
			}
		}
		sc.nextLine();
		System.out.print("사고유무(사고 or 무사고) : ");
		String iCarAccident = sc.nextLine();
		System.out.print("배기량 : ");
		int iCarDisplacement = 0;
		while (true) {
			try {
				iCarDisplacement = sc.nextInt();
				break;
			} catch (InputMismatchException e) {
				sc = new Scanner(System.in);
				System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
				System.out.print("배기량 : ");
			}
		}
		sc.nextLine();
		System.out.print("주행거리 : ");
		int iCarDistanceDriven = 0;
		while (true) {
			try {
				iCarDistanceDriven = sc.nextInt();
				break;
			} catch (InputMismatchException e) {
				sc = new Scanner(System.in);
				System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
				System.out.print("주행거리 : ");
			}
		}
		sc.nextLine();
		System.out.print("연료 : ");
		String iCarFuel = sc.nextLine();
		System.out.print("수동/오토 : ");
		String iCarTransmission = sc.nextLine();
		return new Car(iCarName, iCarProvider, iCarColor, iCarProduceDate, iCarReceiveDate, iCarPrice, iCarAccident,
				iCarDisplacement, iCarDistanceDriven, iCarFuel, iCarTransmission);
	}
}
