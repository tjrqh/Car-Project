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
			System.out.print("���� �˻� : ");
			String searchByString = inputString();
			cDao.searchByOneKeyWordsString(searchByString, searchMenuNumber);
		} else if (searchMenuNumber == SearchCarMenu.SEARCH_MENU_PROVIDER) {
			System.out.print("������ �˻� : ");
			String searchByString = inputString();
			cDao.searchByOneKeyWordsString(searchByString, searchMenuNumber);
		} else if (searchMenuNumber == SearchCarMenu.SEARCH_MENU_COLOR) {
			System.out.print("���� �˻� : ");
			String searchByString = inputString();
			cDao.searchByOneKeyWordsString(searchByString, searchMenuNumber);
		} else if (searchMenuNumber == SearchCarMenu.SEARCH_MENU_PRODUCE_DATE) {
			System.out.print("���� ���� �˻� : ");
			String searchByString = inputString();
			cDao.searchByOneKeyWordsString(searchByString, searchMenuNumber);
		} else if (searchMenuNumber == SearchCarMenu.SEARCH_MENU_RECEIVE_DATE) {
			System.out.print("�԰� ���� �˻� : ");
			String searchByString = inputString();
			cDao.searchByOneKeyWordsString(searchByString, searchMenuNumber);
		} else if (searchMenuNumber == SearchCarMenu.SEARCH_MENU_ACCIDENT) {
			System.out.print("����� �˻� : ");
			String searchByString = inputString();
			cDao.searchByOneKeyWordsString(searchByString, searchMenuNumber);
		} else if (searchMenuNumber == SearchCarMenu.SEARCH_MENU_FUEL) { // Fuel�� ���ڿ� ���� ���η� contains ���
			System.out.print("��� ���� �˻� : ");
			String searchByString = inputString();
			cDao.searchByOneKeyWordsString(searchByString, searchMenuNumber);
		} else if (searchMenuNumber == SearchCarMenu.SEARCH_MENU_TRANSMISSION) {
			System.out.print("����(����/����) �˻� : ");
			String searchByString = inputString();
			cDao.searchByOneKeyWordsString(searchByString, searchMenuNumber);
		}

		// search by Integer Start
		else if (searchMenuNumber == SearchCarMenu.SEARCH_MENU_PRICE) {
			System.out.print("���� �˻� : ");
			int searchByInteger = inputInteger();
			cDao.searchByOneKeyWordsInteger(searchByInteger, searchMenuNumber);
		}

		else if (searchMenuNumber == SearchCarMenu.SEARCH_MENU_DISPLACEMENT) {
			System.out.print("��ⷮ �˻� : ");
			int searchByInteger = inputInteger();
			cDao.searchByOneKeyWordsInteger(searchByInteger, searchMenuNumber);
		}

		else if (searchMenuNumber == SearchCarMenu.SEARCH_MENU_DISTANCE_DRIVEN) {
			System.out.print("����Ÿ� �˻� : ");
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
			System.out.print("������ ������ �� ���Դϱ�?(���� ���� ����Ʈ ���� (0 ~ " + cDao.getCarListSize() + ")) : ");

			while (true) {
				try {
					modifyCarListIndex = sc.nextInt();
					sc.nextLine();
					if (modifyCarListIndex >= 0 && modifyCarListIndex <= cDao.getCarListSize())
						break;
					else
						System.out.println("�߸��� �Է��Դϴ�. �ٽ� �Է����ּ���.");
				} catch (InputMismatchException e) {
					sc = new Scanner(System.in);
					System.out.println("�߸��� �Է��Դϴ�. �ٽ� �Է����ּ���.");
				}
			}

			// setter value input area
			if (modifyMenuNumber == ModifyCarMenu.MODIFY_MOD_NAME) {
				carViewOneObj(modifyCarListIndex);
				System.out.print(" ���� ���� : ");
				String modifyInputString = inputString();
				cDao.modifyCarInfoString(modifyCarListIndex, modifyMenuNumber, modifyInputString);
			} else if (modifyMenuNumber == ModifyCarMenu.MODIFY_MOD_PROVIDER) {
				carViewOneObj(modifyCarListIndex);
				System.out.print(" ������ ���� : ");
				String modifyInputString = inputString();
				cDao.modifyCarInfoString(modifyCarListIndex, modifyMenuNumber, modifyInputString);
			} else if (modifyMenuNumber == ModifyCarMenu.MODIFY_MOD_COLOR) {
				carViewOneObj(modifyCarListIndex);
				System.out.print(" ���� ���� : ");
				String modifyInputString = inputString();
				cDao.modifyCarInfoString(modifyCarListIndex, modifyMenuNumber, modifyInputString);
			} else if (modifyMenuNumber == ModifyCarMenu.MODIFY_MOD_PRODUCE_DATE) {
				carViewOneObj(modifyCarListIndex);
				System.out.print(" �������� ���� : ");
				String modifyInputString = inputString();
				cDao.modifyCarInfoString(modifyCarListIndex, modifyMenuNumber, modifyInputString);
			} else if (modifyMenuNumber == ModifyCarMenu.MODIFY_MOD_RECEIVE_DATE) {
				carViewOneObj(modifyCarListIndex);
				System.out.print(" �԰����� ���� : ");
				String modifyInputString = inputString();
				cDao.modifyCarInfoString(modifyCarListIndex, modifyMenuNumber, modifyInputString);
			} else if (modifyMenuNumber == ModifyCarMenu.MODIFY_MOD_ACCIDENT) {
				carViewOneObj(modifyCarListIndex);
				System.out.print(" ����� ���� : ");
				String modifyInputString = inputString();
				cDao.modifyCarInfoString(modifyCarListIndex, modifyMenuNumber, modifyInputString);
			} else if (modifyMenuNumber == ModifyCarMenu.MODIFY_MOD_FUEL) {
				carViewOneObj(modifyCarListIndex);
				System.out.print(" �������� ���� : ");
				String modifyInputString = inputString();
				cDao.modifyCarInfoString(modifyCarListIndex, modifyMenuNumber, modifyInputString);
			} else if (modifyMenuNumber == ModifyCarMenu.MODIFY_MOD_TRANSMISSION) {
				carViewOneObj(modifyCarListIndex);
				System.out.print(" ����(����/����) ���� : ");
				String modifyInputString = inputString();
				cDao.modifyCarInfoString(modifyCarListIndex, modifyMenuNumber, modifyInputString);
			} else if (modifyMenuNumber == ModifyCarMenu.MODIFY_MOD_PRICE) {
				carViewOneObj(modifyCarListIndex);
				System.out.print(" ���� ���� : ");
				int modifyInputInteger = inputInteger();
				cDao.modifyCarInfoInt(modifyCarListIndex, modifyMenuNumber, modifyInputInteger);
			} else if (modifyMenuNumber == ModifyCarMenu.MODIFY_MOD_DISPLACEMENT) {
				carViewOneObj(modifyCarListIndex);
				System.out.print(" ��ⷮ ���� : ");
				int modifyInputInteger = inputInteger();
				cDao.modifyCarInfoInt(modifyCarListIndex, modifyMenuNumber, modifyInputInteger);
			} else if (modifyMenuNumber == ModifyCarMenu.MODIFY_MOD_DISTANCE_DRIVEN) {
				carViewOneObj(modifyCarListIndex);
				System.out.print(" ���� �Ÿ� ���� : ");
				int modifyInputInteger = inputInteger();
				cDao.modifyCarInfoInt(modifyCarListIndex, modifyMenuNumber, modifyInputInteger);
			} else if (modifyMenuNumber == ModifyCarMenu.MODIFY_MOD_ALL) {
				carViewOneObj(modifyCarListIndex);
				System.out.print(" ���� ���� : ");
				String modifyInputName = inputString();
				System.out.print(" ������ ���� : ");
				String modifyInputProvider = inputString();
				System.out.print(" ���� ���� : ");
				String modifyInputColor = inputString();
				System.out.print(" �������� ���� : ");
				String modifyInputProduceDate = inputString();
				System.out.print(" �԰����� ���� : ");
				String modifyInputReceiveDate = inputString(); // �԰���
				System.out.print(" ���� ���� : ");
				int modifyInputPrice = inputInteger(); // ����
				System.out.print(" ����� ���� : ");
				String modifyInputAccident = inputString(); // �����
				System.out.print(" ��ⷮ ���� : ");
				int modifyInputDisplacement = inputInteger(); // ��ⷮ
				System.out.print(" ���� �Ÿ� ���� : ");
				int modifyInputDistanceDriven = inputInteger(); // �Ÿ�
				System.out.print(" �������� ���� : ");
				String modifyInputFuel = inputString(); // ���� ����
				System.out.print(" ����(����/����) ���� : ");
				String modifyinputTransmission = inputString(); // ����, ����

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
			System.out.print("���� ������ ���°�Դϱ�?(���� ���� ����Ʈ ���� (1 ~ " + cDao.getCarListSize() + ")) : ");

			while (true) {
				try {
					deleteCarListIndex = sc.nextInt();
					if (deleteCarListIndex >= 1 && deleteCarListIndex <= cDao.getCarListSize())
						break;
					else
						System.out.println("�߸��� �Է��Դϴ�. �ٽ� �Է����ּ���.1");
				} catch (InputMismatchException e) {
					sc = new Scanner(System.in);
					System.out.println("�߸��� �Է��Դϴ�. �ٽ� �Է����ּ���.2");
				}
			}
			cDao.deleteCarInfo(deleteCarListIndex);
		}
	}

	public void carPrintPrev() {
		System.out.println("�������� ���ư��ϴ�.");
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
				System.out.println("�߸��� �Է��Դϴ�. �ٽ� �Է����ּ���.");
			}
		}
		return inputInteger;
	}

}
