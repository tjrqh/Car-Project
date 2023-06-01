package com.kk.carApp.view;

import java.util.Scanner;

import com.kk.carApp.DTO.Member;

public class InsertMemberMenu {
	Scanner sc = new Scanner(System.in);

	public Member insertData() {
		System.out.println("-----------------");
		System.out.println("회원 가입을 시작합니다.");
		System.out.print("ID : ");
		String iMemberId = sc.nextLine();
		System.out.print("Password : ");
		String iMemberPassword = sc.nextLine();
		System.out.print("이름 : ");
		String iMemberName = sc.nextLine();
		System.out.print("주소 : ");
		String iMemberAddress = sc.nextLine();
		return new Member(iMemberId, iMemberPassword, iMemberName, iMemberAddress);
	}
}
