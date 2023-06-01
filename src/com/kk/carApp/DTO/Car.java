package com.kk.carApp.DTO;

public class Car {
	// 중고차 판매 프로그램
	// Member Variable
	private String name; // 차종
	private String provider; // 회사
	private String color; // 색상
	private String produceDate; // 생산일
	private String receiveDate; // 입고일
	private int price; // 가격
	private String accident; // 사고여부
	private int displacement; // 배기량
	private int distanceDriven; // 거리
	private String fuel; // 연료 정보
	private String transmission; // 오토, 수동

	// Default Construct (just use Debug) 마지막엔 삭제할 예정
	public Car() {
		super();
	}

	// Constructor
	public Car(String name, String provider, String color, String produceDate, String receiveDate, int price,
			   String accident, int displacement, int distanceDriven, String fuel, String transmission) {
		super();
		this.name = name;
		this.provider = provider;
		this.color = color;
		this.produceDate = produceDate;
		this.receiveDate = receiveDate;
		this.price = price;
		this.accident = accident;
		this.displacement = displacement;
		this.distanceDriven = distanceDriven;
		this.fuel = fuel;
		this.transmission = transmission;
	}

	// Getter , Setter
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getProvider() {
		return provider;
	}

	public void setProvider(String provider) {
		this.provider = provider;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getProduceDate() {
		return produceDate;
	}

	public void setProduceDate(String produceDate) {
		this.produceDate = produceDate;
	}

	public String getReceiveDate() {
		return receiveDate;
	}

	public void setReceiveDate(String receiveDate) {
		this.receiveDate = receiveDate;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getAccident() {
		return accident;
	}

	public void setAccident(String accident) {
		this.accident = accident;
	}

	public int getDisplacement() {
		return displacement;
	}

	public void setDisplacement(int displacement) {
		this.displacement = displacement;
	}

	public int getDistanceDriven() {
		return distanceDriven;
	}

	public void setDistanceDriven(int distanceDriven) {
		this.distanceDriven = distanceDriven;
	}

	public String getFuel() {
		return fuel;
	}

	public void setFuel(String fuel) {
		this.fuel = fuel;
	}

	public String getTransmission() {
		return transmission;
	}

	public void setTransmission(String transmission) {
		this.transmission = transmission;
	}

	// print Object
	public void printCarInfo() {
		System.out.println(" 차종 : " + name); // 이름
		System.out.println(" 회사 : " + provider); // 회사
		System.out.println(" 색상 : " + color); // 색상
		System.out.println(" 생산일 : " + produceDate); // 생산일
		System.out.println(" 접수일 : " + receiveDate); // 받는 날짜
		System.out.println(" 가격 : " + price); // 가격
		System.out.println(" 사고 : " + accident);
		System.out.println(" 배기량 : " + displacement); // 배기량
		System.out.println(" 주행거리 : " + distanceDriven); // 거리
		System.out.println(" 연료 : " + fuel); // 연료 정보
		System.out.println(" 조작 : " + transmission); // 오토, 수동
		System.out.println("-----------------------");
	}
}
