package com.kk.carApp.DAO;

import java.util.ArrayList;
import java.util.Scanner;

import com.kk.carApp.DTO.Car;
import com.kk.carApp.view.ModifyCarMenu;
import com.kk.carApp.view.SearchCarMenu;

public class CarDAO {
	private ArrayList<Car> carList;

	Scanner sc = new Scanner(System.in);

	public CarDAO() {
		carList = new ArrayList<Car>();
		carList.add(new Car("�ڳ�", "����", "���", "2020-01-01", "2021-01-01", 1500, "�����", 2200, 5000, "����", "����"));
		carList.add(new Car("�ҳ�Ÿ", "����", "����", "2020-02-01", "2021-01-01", 1300, "�����", 1800, 10000, "����", "����"));
		carList.add(new Car("����", "����", "������", "2020-03-01", "2021-01-01", 3500, "�����", 2500, 2500, "����", "����"));
		carList.add(new Car("�ƹݶ�", "����", "�Ķ���", "2020-04-01", "2021-01-01", 1200, "�����", 1800, 2000, "����", "����"));
		carList.add(new Car("�׷���", "����", "���", "2020-05-01", "2021-01-01", 3200, "�����", 2400, 6000, "����", "����"));
		carList.add(new Car("����3", "����", "���", "2020-06-01", "2021-01-01", 3000, "�����", 2000, 15000, "����", "����"));
		carList.add(new Car("SM3", "����Ｚ", "���", "2019-01-01", "2021-01-01", 2000, "�����", 2000, 16000, "���ָ�,����", "����"));
		carList.add(new Car("SM5", "����Ｚ", "���", "2019-05-01", "2021-01-01", 2200, "�����", 2000, 5000, "���ָ�,����", "����"));
		carList.add(new Car("SM7", "����Ｚ", "���", "2019-09-01", "2021-01-01", 2300, "���", 2000, 3000, "LPG,����", "����"));
		carList.add(new Car("Ƽ����", "�ֿ�", "������", "2020-12-01", "2021-03-01", 3000, "�����", 3000, 6000, "���ָ�", "����"));
		carList.add(new Car("������", "�ֿ�", "���", "2021-06-01", "2021-03-01", 2000, "���", 2600, 20000, "���ָ�", "����"));
		carList.add(new Car("�ڶ���", "�ֿ�", "�Ķ���", "2021-09-01", "2021-03-01", 2400, "�����", 2800, 4000, "���ָ�", "����"));
	}

	// Print Method
	public void printIsEmpty() {
		System.out.println("���� ������ �����ϴ�. ���� ���� �Է��� ���ּ���.");
	}

	public void printSearchNothings() {
		System.out.println("��ġ�ϴ� ������ �����ϴ�.");
	}

	// �˻� Method Area
	public void searchAll() {
		if (carList.isEmpty())
			printIsEmpty();
		else {
			for (int i = 0; i < carList.size(); i++) {
				System.out.println((i + 1) + "��° ���� ����");
				carList.get(i).printCarInfo();
			}
		}
	}

	public void searchByOneByIndex(int i) {
		if (carList.isEmpty())
			printIsEmpty();
		else {
			System.out.println("������ " + (i + 1) + "��° ���� ����");
			carList.get(i).printCarInfo();
		}

	}

	public void searchByOneKeyWordsString(String searchString, int searchNum) {
		if (carList.isEmpty())
			printIsEmpty();
		else {
			boolean isFind = false;
			if (searchNum == SearchCarMenu.SEARCH_MENU_NAME) {
				for (int i = 0; i < carList.size(); i++) {
					if (carList.get(i).getName().equals(searchString)) {
						if (!isFind)
							isFind = true;
						System.out.println((i + 1) + "��° ���� ����");
						carList.get(i).printCarInfo();
					}
				}
			} else if (searchNum == SearchCarMenu.SEARCH_MENU_PROVIDER) {
				for (int i = 0; i < carList.size(); i++) {
					if (carList.get(i).getProvider().equals(searchString)) {
						if (!isFind)
							isFind = true;
						System.out.println((i + 1) + "��° ���� ����");
						carList.get(i).printCarInfo();
					}
				}
			} else if (searchNum == SearchCarMenu.SEARCH_MENU_COLOR) {
				for (int i = 0; i < carList.size(); i++) {
					if (carList.get(i).getColor().equals(searchString)) {
						if (!isFind)
							isFind = true;
						System.out.println((i + 1) + "��° ���� ����");
						carList.get(i).printCarInfo();
					}
				}
			} else if (searchNum == SearchCarMenu.SEARCH_MENU_PRODUCE_DATE) {
				for (int i = 0; i < carList.size(); i++) {
					if (carList.get(i).getProduceDate().equals(searchString)) {
						if (!isFind)
							isFind = true;
						System.out.println((i + 1) + "��° ���� ����");
						carList.get(i).printCarInfo();
					}
				}
			} else if (searchNum == SearchCarMenu.SEARCH_MENU_RECEIVE_DATE) {
				for (int i = 0; i < carList.size(); i++) {
					if (carList.get(i).getReceiveDate().equals(searchString)) {
						if (!isFind)
							isFind = true;
						System.out.println((i + 1) + "��° ���� ����");
						carList.get(i).printCarInfo();
					}
				}
			} else if (searchNum == SearchCarMenu.SEARCH_MENU_ACCIDENT) {
				for (int i = 0; i < carList.size(); i++) {
					if (carList.get(i).getAccident().equals(searchString)) {
						if (!isFind)
							isFind = true;
						System.out.println((i + 1) + "��° ���� ����");
						carList.get(i).printCarInfo();
					}
				}
			} else if (searchNum == SearchCarMenu.SEARCH_MENU_FUEL) {
				for (int i = 0; i < carList.size(); i++) {
					if (carList.get(i).getFuel().contains(searchString)) { // use contains
						if (!isFind)
							isFind = true;
						System.out.println((i + 1) + "��° ���� ����");
						carList.get(i).printCarInfo();
					}
				}
			} else if (searchNum == SearchCarMenu.SEARCH_MENU_TRANSMISSION) {
				for (int i = 0; i < carList.size(); i++) {
					if (carList.get(i).getTransmission().equals(searchString)) {
						if (!isFind)
							isFind = true;
						System.out.println((i + 1) + "��° ���� ����");
						carList.get(i).printCarInfo();
					}
				}
			} else {
				System.out.println("�߸��� �˻���ȣ�� �Ѿ�Խ��ϴ�.");
			}
			if (!isFind)
				printSearchNothings();
		}
	}

	public void searchByOneKeyWordsInteger(int searchInteger, int searchNum) {
		if (carList.isEmpty())
			printIsEmpty();
		else {
			boolean isFind = false;
			if (searchNum == SearchCarMenu.SEARCH_MENU_PRICE) {
				for (int i = 0; i < carList.size(); i++) {
					if (carList.get(i).getPrice() == searchInteger) {
						if (!isFind)
							isFind = true;
						System.out.println((i + 1) + "��° ���� ����");
						carList.get(i).printCarInfo();
					}
				}
			}

			else if (searchNum == SearchCarMenu.SEARCH_MENU_DISPLACEMENT) {
				for (int i = 0; i < carList.size(); i++) {
					if (carList.get(i).getDisplacement() == searchInteger) {
						if (!isFind)
							isFind = true;
						System.out.println((i + 1) + "��° ���� ����");
						carList.get(i).printCarInfo();
					}
				}
			} else if (searchNum == SearchCarMenu.SEARCH_MENU_DISTANCE_DRIVEN) {
				for (int i = 0; i < carList.size(); i++) {
					if (carList.get(i).getDistanceDriven() == searchInteger) {
						if (!isFind)
							isFind = true;
						System.out.println((i + 1) + "��° ���� ����");
						carList.get(i).printCarInfo();
					}
				}

			} else {
				System.out.println("�߸��� �˻���ȣ�� �Ѿ�Խ��ϴ�.");
			}

			if (!isFind)
				printSearchNothings();
		}
	}

	// ���� Method Area
	public void insertCarInfo(Car c) { // Car ��ü ����
		carList.add(c);
	}

	public void insertCarInfo(String name, String provider, String color, String produceDate, String receiveDate,
							  int price, String accident, int displacement, int distanceDriven, String fuel, String transmission) {
		carList.add(new Car(name, provider, color, produceDate, receiveDate, price, accident, displacement,
				distanceDriven, fuel, transmission));
	}

	// ���� Method Area
	public void modifyCarInfoString(int modifyCarListIndex, int modifyMenuNumber, String inputString) {
		if (carList.isEmpty())
			printIsEmpty();
		else {
			if (modifyMenuNumber == ModifyCarMenu.MODIFY_MOD_NAME)
				carList.get(modifyCarListIndex - 1).setName(inputString);
			else if (modifyMenuNumber == ModifyCarMenu.MODIFY_MOD_PROVIDER)
				carList.get(modifyCarListIndex - 1).setProvider(inputString);
			else if (modifyMenuNumber == ModifyCarMenu.MODIFY_MOD_COLOR)
				carList.get(modifyCarListIndex - 1).setColor(inputString);
			else if (modifyMenuNumber == ModifyCarMenu.MODIFY_MOD_PRODUCE_DATE)
				carList.get(modifyCarListIndex - 1).setProduceDate(inputString);
			else if (modifyMenuNumber == ModifyCarMenu.MODIFY_MOD_RECEIVE_DATE)
				carList.get(modifyCarListIndex - 1).setReceiveDate(inputString);
			else if (modifyMenuNumber == ModifyCarMenu.MODIFY_MOD_ACCIDENT)
				carList.get(modifyCarListIndex - 1).setAccident(inputString);
			else if (modifyMenuNumber == ModifyCarMenu.MODIFY_MOD_FUEL)
				carList.get(modifyCarListIndex - 1).setFuel(inputString);
			else if (modifyMenuNumber == ModifyCarMenu.MODIFY_MOD_TRANSMISSION)
				carList.get(modifyCarListIndex - 1).setTransmission(inputString);
			else {

			}
		}

	}

	public void modifyCarInfoInt(int modifyCarListIndex, int modifyMenuNumber, int inputInteger) {
		if (carList.isEmpty())
			printIsEmpty();
		else {
			if (modifyMenuNumber == ModifyCarMenu.MODIFY_MOD_PRICE)
				carList.get(modifyCarListIndex - 1).setPrice(inputInteger);
			else if (modifyMenuNumber == ModifyCarMenu.MODIFY_MOD_DISPLACEMENT)
				carList.get(modifyCarListIndex - 1).setDisplacement(inputInteger);
			else if (modifyMenuNumber == ModifyCarMenu.MODIFY_MOD_DISTANCE_DRIVEN)
				carList.get(modifyCarListIndex - 1).setDistanceDriven(inputInteger);
			else {

			}
		}

	}

	public void modifyCarInfoAll(Car cObj, int modifyCarListIndex) {
		if (carList.isEmpty())
			printIsEmpty();
		else {
			carList.get(modifyCarListIndex - 1).setName(cObj.getName());
			carList.get(modifyCarListIndex - 1).setProvider(cObj.getProvider());
			carList.get(modifyCarListIndex - 1).setColor(cObj.getColor());
			carList.get(modifyCarListIndex - 1).setProduceDate(cObj.getProduceDate());
			carList.get(modifyCarListIndex - 1).setReceiveDate(cObj.getReceiveDate());
			carList.get(modifyCarListIndex - 1).setPrice(cObj.getPrice());
			carList.get(modifyCarListIndex - 1).setAccident(cObj.getAccident());
			carList.get(modifyCarListIndex - 1).setDisplacement(cObj.getDisplacement());
			carList.get(modifyCarListIndex - 1).setDistanceDriven(cObj.getDistanceDriven());
			carList.get(modifyCarListIndex - 1).setFuel(cObj.getFuel());
			carList.get(modifyCarListIndex - 1).setTransmission(cObj.getTransmission());

			cObj = null; // Garbage Collector
		}
	}

	// ���� Method Area

	// ArrayListSizeCheck
	public int getCarListSize() {
		return carList.size();
	}

	// Remove
	public void deleteCarInfo(int deleteInputIndex) { // ���� �������� Index + 1 ���� �����ش޶�� ��û�ϱ� ����
		if (!carList.isEmpty()) {
			carList.remove(deleteInputIndex - 1);
			System.out.println("���� ������ �����Ǿ����ϴ�.");
		} else
			printIsEmpty();
	}

}
