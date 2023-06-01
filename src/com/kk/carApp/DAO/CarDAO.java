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
		carList.add(new Car("코나", "현대", "흰색", "2020-01-01", "2021-01-01", 1500, "무사고", 2200, 5000, "디젤", "오토"));
		carList.add(new Car("소나타", "현대", "은색", "2020-02-01", "2021-01-01", 1300, "무사고", 1800, 10000, "디젤", "오토"));
		carList.add(new Car("에쿠스", "현대", "검은색", "2020-03-01", "2021-01-01", 3500, "무사고", 2500, 2500, "디젤", "오토"));
		carList.add(new Car("아반떼", "현대", "파란색", "2020-04-01", "2021-01-01", 1200, "무사고", 1800, 2000, "디젤", "오토"));
		carList.add(new Car("그랜저", "현대", "흰색", "2020-05-01", "2021-01-01", 3200, "무사고", 2400, 6000, "디젤", "오토"));
		carList.add(new Car("봉고3", "현대", "흰색", "2020-06-01", "2021-01-01", 3000, "무사고", 2000, 15000, "디젤", "수동"));
		carList.add(new Car("SM3", "르노삼성", "흰색", "2019-01-01", "2021-01-01", 2000, "무사고", 2000, 16000, "가솔린,디젤", "오토"));
		carList.add(new Car("SM5", "르노삼성", "흰색", "2019-05-01", "2021-01-01", 2200, "무사고", 2000, 5000, "가솔린,디젤", "오토"));
		carList.add(new Car("SM7", "르노삼성", "흰색", "2019-09-01", "2021-01-01", 2300, "사고", 2000, 3000, "LPG,디젤", "오토"));
		carList.add(new Car("티볼리", "쌍용", "검은색", "2020-12-01", "2021-03-01", 3000, "무사고", 3000, 6000, "가솔린", "오토"));
		carList.add(new Car("렉스턴", "쌍용", "흰색", "2021-06-01", "2021-03-01", 2000, "사고", 2600, 20000, "가솔린", "오토"));
		carList.add(new Car("코란도", "쌍용", "파란색", "2021-09-01", "2021-03-01", 2400, "무사고", 2800, 4000, "가솔린", "오토"));
	}

	// Print Method
	public void printIsEmpty() {
		System.out.println("차량 정보가 없습니다. 차량 정보 입력을 해주세요.");
	}

	public void printSearchNothings() {
		System.out.println("일치하는 정보가 없습니다.");
	}

	// 검색 Method Area
	public void searchAll() {
		if (carList.isEmpty())
			printIsEmpty();
		else {
			for (int i = 0; i < carList.size(); i++) {
				System.out.println((i + 1) + "번째 차량 정보");
				carList.get(i).printCarInfo();
			}
		}
	}

	public void searchByOneByIndex(int i) {
		if (carList.isEmpty())
			printIsEmpty();
		else {
			System.out.println("선택한 " + (i + 1) + "번째 차량 정보");
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
						System.out.println((i + 1) + "번째 차량 정보");
						carList.get(i).printCarInfo();
					}
				}
			} else if (searchNum == SearchCarMenu.SEARCH_MENU_PROVIDER) {
				for (int i = 0; i < carList.size(); i++) {
					if (carList.get(i).getProvider().equals(searchString)) {
						if (!isFind)
							isFind = true;
						System.out.println((i + 1) + "번째 차량 정보");
						carList.get(i).printCarInfo();
					}
				}
			} else if (searchNum == SearchCarMenu.SEARCH_MENU_COLOR) {
				for (int i = 0; i < carList.size(); i++) {
					if (carList.get(i).getColor().equals(searchString)) {
						if (!isFind)
							isFind = true;
						System.out.println((i + 1) + "번째 차량 정보");
						carList.get(i).printCarInfo();
					}
				}
			} else if (searchNum == SearchCarMenu.SEARCH_MENU_PRODUCE_DATE) {
				for (int i = 0; i < carList.size(); i++) {
					if (carList.get(i).getProduceDate().equals(searchString)) {
						if (!isFind)
							isFind = true;
						System.out.println((i + 1) + "번째 차량 정보");
						carList.get(i).printCarInfo();
					}
				}
			} else if (searchNum == SearchCarMenu.SEARCH_MENU_RECEIVE_DATE) {
				for (int i = 0; i < carList.size(); i++) {
					if (carList.get(i).getReceiveDate().equals(searchString)) {
						if (!isFind)
							isFind = true;
						System.out.println((i + 1) + "번째 차량 정보");
						carList.get(i).printCarInfo();
					}
				}
			} else if (searchNum == SearchCarMenu.SEARCH_MENU_ACCIDENT) {
				for (int i = 0; i < carList.size(); i++) {
					if (carList.get(i).getAccident().equals(searchString)) {
						if (!isFind)
							isFind = true;
						System.out.println((i + 1) + "번째 차량 정보");
						carList.get(i).printCarInfo();
					}
				}
			} else if (searchNum == SearchCarMenu.SEARCH_MENU_FUEL) {
				for (int i = 0; i < carList.size(); i++) {
					if (carList.get(i).getFuel().contains(searchString)) { // use contains
						if (!isFind)
							isFind = true;
						System.out.println((i + 1) + "번째 차량 정보");
						carList.get(i).printCarInfo();
					}
				}
			} else if (searchNum == SearchCarMenu.SEARCH_MENU_TRANSMISSION) {
				for (int i = 0; i < carList.size(); i++) {
					if (carList.get(i).getTransmission().equals(searchString)) {
						if (!isFind)
							isFind = true;
						System.out.println((i + 1) + "번째 차량 정보");
						carList.get(i).printCarInfo();
					}
				}
			} else {
				System.out.println("잘못된 검색번호가 넘어왔습니다.");
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
						System.out.println((i + 1) + "번째 차량 정보");
						carList.get(i).printCarInfo();
					}
				}
			}

			else if (searchNum == SearchCarMenu.SEARCH_MENU_DISPLACEMENT) {
				for (int i = 0; i < carList.size(); i++) {
					if (carList.get(i).getDisplacement() == searchInteger) {
						if (!isFind)
							isFind = true;
						System.out.println((i + 1) + "번째 차량 정보");
						carList.get(i).printCarInfo();
					}
				}
			} else if (searchNum == SearchCarMenu.SEARCH_MENU_DISTANCE_DRIVEN) {
				for (int i = 0; i < carList.size(); i++) {
					if (carList.get(i).getDistanceDriven() == searchInteger) {
						if (!isFind)
							isFind = true;
						System.out.println((i + 1) + "번째 차량 정보");
						carList.get(i).printCarInfo();
					}
				}

			} else {
				System.out.println("잘못된 검색번호가 넘어왔습니다.");
			}

			if (!isFind)
				printSearchNothings();
		}
	}

	// 삽입 Method Area
	public void insertCarInfo(Car c) { // Car 객체 삽입
		carList.add(c);
	}

	public void insertCarInfo(String name, String provider, String color, String produceDate, String receiveDate,
							  int price, String accident, int displacement, int distanceDriven, String fuel, String transmission) {
		carList.add(new Car(name, provider, color, produceDate, receiveDate, price, accident, displacement,
				distanceDriven, fuel, transmission));
	}

	// 수정 Method Area
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

	// 삭제 Method Area

	// ArrayListSizeCheck
	public int getCarListSize() {
		return carList.size();
	}

	// Remove
	public void deleteCarInfo(int deleteInputIndex) { // 차량 정보에서 Index + 1 값을 삭제해달라고 요청하기 때문
		if (!carList.isEmpty()) {
			carList.remove(deleteInputIndex - 1);
			System.out.println("차량 정보가 삭제되었습니다.");
		} else
			printIsEmpty();
	}

}
