package com.kk.carApp.control;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.kk.carApp.DAO.CarDAO;
import com.kk.carApp.DTO.Car;
import com.kk.carApp.view.ModifyCarMenu;
import com.kk.carApp.view.SearchCarMenu;

public class CarMgr {
	CarDAO cDao = new CarDAO(); // Car DAO Object

	Scanner sc = new Scanner(System.in); // Scanner

	public void carView() { // View All Car Member
		cDao.searchAll();
	}

	public void carViewOneObj(int inputIndex) { // One Object
		cDao.searchByOneByIndex(inputIndex - 1);
	}

	// car search Member
	public void carSearch(int searchMenuNumber) {
		if (cDao.getCarListSize() == 0) {
			cDao.printIsEmpty();
			return;
		}
		// search By String Start
		if (searchMenuNumber == SearchCarMenu.SEARCH_MENU_NAME) {
			System.out.print("차종 검색 : ");
			String searchByString = inputString();
			cDao.searchByOneKeyWordsString(searchByString, searchMenuNumber);
		} else if (searchMenuNumber == SearchCarMenu.SEARCH_MENU_PROVIDER) {
			System.out.print("제조사 검색 : ");
			String searchByString = inputString();
			cDao.searchByOneKeyWordsString(searchByString, searchMenuNumber);
		} else if (searchMenuNumber == SearchCarMenu.SEARCH_MENU_COLOR) {
			System.out.print("색상 검색 : ");
			String searchByString = inputString();
			cDao.searchByOneKeyWordsString(searchByString, searchMenuNumber);
		} else if (searchMenuNumber == SearchCarMenu.SEARCH_MENU_PRODUCE_DATE) {
			System.out.print("생산 일자 검색 : ");
			String searchByString = inputString();
			cDao.searchByOneKeyWordsString(searchByString, searchMenuNumber);
		} else if (searchMenuNumber == SearchCarMenu.SEARCH_MENU_RECEIVE_DATE) {
			System.out.print("입고 일자 검색 : ");
			String searchByString = inputString();
			cDao.searchByOneKeyWordsString(searchByString, searchMenuNumber);
		} else if (searchMenuNumber == SearchCarMenu.SEARCH_MENU_ACCIDENT) {
			System.out.print("사고여부 검색 : ");
			String searchByString = inputString();
			cDao.searchByOneKeyWordsString(searchByString, searchMenuNumber);
		} else if (searchMenuNumber == SearchCarMenu.SEARCH_MENU_FUEL) { // Fuel은 문자열 포함 여부로 contains 사용
			System.out.print("사용 연료 검색 : ");
			String searchByString = inputString();
			cDao.searchByOneKeyWordsString(searchByString, searchMenuNumber);
		} else if (searchMenuNumber == SearchCarMenu.SEARCH_MENU_TRANSMISSION) {
			System.out.print("조작(수동/오토) 검색 : ");
			String searchByString = inputString();
			cDao.searchByOneKeyWordsString(searchByString, searchMenuNumber);
		}

		// search by Integer Start
		else if (searchMenuNumber == SearchCarMenu.SEARCH_MENU_PRICE) {
			System.out.print("가격 검색 : ");
			int searchByInteger = inputInteger();
			cDao.searchByOneKeyWordsInteger(searchByInteger, searchMenuNumber);
		}

		else if (searchMenuNumber == SearchCarMenu.SEARCH_MENU_DISPLACEMENT) {
			System.out.print("배기량 검색 : ");
			int searchByInteger = inputInteger();
			cDao.searchByOneKeyWordsInteger(searchByInteger, searchMenuNumber);
		}

		else if (searchMenuNumber == SearchCarMenu.SEARCH_MENU_DISTANCE_DRIVEN) {
			System.out.print("주행거리 검색 : ");
			int searchByInteger = inputInteger();
			cDao.searchByOneKeyWordsInteger(searchByInteger, searchMenuNumber);
		}

		else {

		}

	}

	public void carInsert(Car c) {
		cDao.insertCarInfo(c);
	}

	public void carModify(int modifyMenuNumber) {
		if (cDao.getCarListSize() == 0) {
			cDao.printIsEmpty();
			return;
		} else {
			carView();
			// index input area
			int modifyCarListIndex = 0;
			System.out.print("수정할 차량은 몇 번입니까?(현재 차량 리스트 범위 (0 ~ " + cDao.getCarListSize() + ")) : ");

			while (true) {
				try {
					modifyCarListIndex = sc.nextInt();
					sc.nextLine();
					if (modifyCarListIndex >= 0 && modifyCarListIndex <= cDao.getCarListSize())
						break;
					else
						System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
				} catch (InputMismatchException e) {
					sc = new Scanner(System.in);
					System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
				}
			}

			// setter value input area
			if (modifyMenuNumber == ModifyCarMenu.MODIFY_MOD_NAME) {
				carViewOneObj(modifyCarListIndex);
				System.out.print(" 차종 수정 : ");
				String modifyInputString = inputString();
				cDao.modifyCarInfoString(modifyCarListIndex, modifyMenuNumber, modifyInputString);
			} else if (modifyMenuNumber == ModifyCarMenu.MODIFY_MOD_PROVIDER) {
				carViewOneObj(modifyCarListIndex);
				System.out.print(" 제조사 수정 : ");
				String modifyInputString = inputString();
				cDao.modifyCarInfoString(modifyCarListIndex, modifyMenuNumber, modifyInputString);
			} else if (modifyMenuNumber == ModifyCarMenu.MODIFY_MOD_COLOR) {
				carViewOneObj(modifyCarListIndex);
				System.out.print(" 색상 수정 : ");
				String modifyInputString = inputString();
				cDao.modifyCarInfoString(modifyCarListIndex, modifyMenuNumber, modifyInputString);
			} else if (modifyMenuNumber == ModifyCarMenu.MODIFY_MOD_PRODUCE_DATE) {
				carViewOneObj(modifyCarListIndex);
				System.out.print(" 생산일자 수정 : ");
				String modifyInputString = inputString();
				cDao.modifyCarInfoString(modifyCarListIndex, modifyMenuNumber, modifyInputString);
			} else if (modifyMenuNumber == ModifyCarMenu.MODIFY_MOD_RECEIVE_DATE) {
				carViewOneObj(modifyCarListIndex);
				System.out.print(" 입고일자 수정 : ");
				String modifyInputString = inputString();
				cDao.modifyCarInfoString(modifyCarListIndex, modifyMenuNumber, modifyInputString);
			} else if (modifyMenuNumber == ModifyCarMenu.MODIFY_MOD_ACCIDENT) {
				carViewOneObj(modifyCarListIndex);
				System.out.print(" 사고여부 수정 : ");
				String modifyInputString = inputString();
				cDao.modifyCarInfoString(modifyCarListIndex, modifyMenuNumber, modifyInputString);
			} else if (modifyMenuNumber == ModifyCarMenu.MODIFY_MOD_FUEL) {
				carViewOneObj(modifyCarListIndex);
				System.out.print(" 연료정보 수정 : ");
				String modifyInputString = inputString();
				cDao.modifyCarInfoString(modifyCarListIndex, modifyMenuNumber, modifyInputString);
			} else if (modifyMenuNumber == ModifyCarMenu.MODIFY_MOD_TRANSMISSION) {
				carViewOneObj(modifyCarListIndex);
				System.out.print(" 조작(오토/수동) 수정 : ");
				String modifyInputString = inputString();
				cDao.modifyCarInfoString(modifyCarListIndex, modifyMenuNumber, modifyInputString);
			} else if (modifyMenuNumber == ModifyCarMenu.MODIFY_MOD_PRICE) {
				carViewOneObj(modifyCarListIndex);
				System.out.print(" 가격 수정 : ");
				int modifyInputInteger = inputInteger();
				cDao.modifyCarInfoInt(modifyCarListIndex, modifyMenuNumber, modifyInputInteger);
			} else if (modifyMenuNumber == ModifyCarMenu.MODIFY_MOD_DISPLACEMENT) {
				carViewOneObj(modifyCarListIndex);
				System.out.print(" 배기량 수정 : ");
				int modifyInputInteger = inputInteger();
				cDao.modifyCarInfoInt(modifyCarListIndex, modifyMenuNumber, modifyInputInteger);
			} else if (modifyMenuNumber == ModifyCarMenu.MODIFY_MOD_DISTANCE_DRIVEN) {
				carViewOneObj(modifyCarListIndex);
				System.out.print(" 주행 거리 수정 : ");
				int modifyInputInteger = inputInteger();
				cDao.modifyCarInfoInt(modifyCarListIndex, modifyMenuNumber, modifyInputInteger);
			} else if (modifyMenuNumber == ModifyCarMenu.MODIFY_MOD_ALL) {
				carViewOneObj(modifyCarListIndex);
				System.out.print(" 차종 수정 : ");
				String modifyInputName = inputString();
				System.out.print(" 제조사 수정 : ");
				String modifyInputProvider = inputString();
				System.out.print(" 색상 수정 : ");
				String modifyInputColor = inputString();
				System.out.print(" 생산일자 수정 : ");
				String modifyInputProduceDate = inputString();
				System.out.print(" 입고일자 수정 : ");
				String modifyInputReceiveDate = inputString(); // 입고일
				System.out.print(" 가격 수정 : ");
				int modifyInputPrice = inputInteger(); // 가격
				System.out.print(" 사고여부 수정 : ");
				String modifyInputAccident = inputString(); // 사고여부
				System.out.print(" 배기량 수정 : ");
				int modifyInputDisplacement = inputInteger(); // 배기량
				System.out.print(" 주행 거리 수정 : ");
				int modifyInputDistanceDriven = inputInteger(); // 거리
				System.out.print(" 연료정보 수정 : ");
				String modifyInputFuel = inputString(); // 연료 정보
				System.out.print(" 조작(오토/수동) 수정 : ");
				String modifyinputTransmission = inputString(); // 오토, 수동

				Car inputCarObj = new Car(modifyInputName, modifyInputProvider, modifyInputColor,
						modifyInputProduceDate, modifyInputReceiveDate, modifyInputPrice, modifyInputAccident,
						modifyInputDisplacement, modifyInputDistanceDriven, modifyInputFuel, modifyinputTransmission);
				cDao.modifyCarInfoAll(inputCarObj, modifyCarListIndex);
			}

		}
	}

	public void carDelete() {
		if (cDao.getCarListSize() == 0) {
			cDao.printIsEmpty();
			return;
		} else {
			carView();
			int deleteCarListIndex = 0;
			System.out.print("지울 차량은 몇번째입니까?(현재 차량 리스트 범위 (1 ~ " + cDao.getCarListSize() + ")) : ");

			while (true) {
				try {
					deleteCarListIndex = sc.nextInt();
					if (deleteCarListIndex >= 1 && deleteCarListIndex <= cDao.getCarListSize())
						break;
					else
						System.out.println("잘못된 입력입니다. 다시 입력해주세요.1");
				} catch (InputMismatchException e) {
					sc = new Scanner(System.in);
					System.out.println("잘못된 입력입니다. 다시 입력해주세요.2");
				}
			}
			cDao.deleteCarInfo(deleteCarListIndex);
		}
	}

	public void carPrintPrev() {
		System.out.println("이전으로 돌아갑니다.");
	}

	public String inputString() {
		return sc.nextLine();
	}

	public int inputInteger() {
		int inputInteger = 0;

		while (true) {
			try {
				inputInteger = sc.nextInt();
				sc.nextLine();
				break;
			} catch (InputMismatchException e) {
				sc = new Scanner(System.in);
				System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
			}
		}
		return inputInteger;
	}

}
