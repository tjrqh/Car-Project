package com.kk.carApp.DAO;

import java.util.ArrayList;
import java.util.Scanner;

import com.kk.carApp.DTO.Member;

public class MemberDAO {
	private ArrayList<Member> memberList;
	Scanner sc = new Scanner(System.in);

	public MemberDAO() {
		memberList = new ArrayList<Member>();
		memberList.add(new Member("admin", "1234", "관리자", "주소 없음"));
		memberList.add(new Member("member", "asdf1234", "asdf4321", "김철수", "대구광역시 서구 내당동"));
		memberList.add(new Member("manager", "qwer1234", "qwer4321", "박철수", "대구광역시 동구 내당동"));
		memberList.add(new Member("member", "rtyu1234", "rtyu4321", "이철수", "대구광역시 북구 내당동"));
		memberList.add(new Member("manager", "zxcv1234", "zxcv4321", "주철수", "대구광역시 중구 내당동"));
		memberList.add(new Member("uiop1234", "uiop4321", "기철수", "대구광역시 중구 내당동"));

	}

	// Print Method
	public void printIsEmpty() {
		System.out.println("회원이 한명도 없습니다. 회원 가입을 해주세요.");
	}

	public void printSearchNothings() {
		System.out.println("일치하는 정보가 없습니다.");
	}

	public void selectAll() {
		for (int i = 0; i < memberList.size(); i++) {
			memberList.get(i).printMemberInfo();
		}
	}

	public boolean doLoginMain(String id, String pw) {
		try {
			for (int i = 0; i < memberList.size(); i++) {
				if (memberList.get(i).getId().equals(id) == false) {
					continue;
				} else if (memberList.get(i).getId().equals(id) == true) { // id is equal
					if (memberList.get(i).getPassword().equals(pw) == false) {
						continue;
					}

					if (memberList.get(i).getPassword().equals(pw) == true) {
						if (memberList.get(i).getRank().equals("manager") == true) {
							Thread.sleep(100);
							System.out.print("로그인 중입니다.");
							Thread.sleep(100);
							System.out.print(".");
							Thread.sleep(100);
							System.out.print(".");
							Thread.sleep(100);
							System.out.print(".");
							Thread.sleep(100);
							System.out.println(".");
							Thread.sleep(100);
							System.out.println("로그인 성공!");
							return true;
						} else {
							Thread.sleep(100);
							System.out.print("로그인 중입니다.");
							Thread.sleep(100);
							System.out.print(".");
							Thread.sleep(100);
							System.out.print(".");
							Thread.sleep(100);
							System.out.print(".");
							Thread.sleep(100);
							System.out.println(".");
							Thread.sleep(100);
							System.out.println("권한이 부족합니다.");
							Thread.sleep(100);
							System.out.println("로그인 실패!");
							return false;
						}
					}
				}
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("회원정보가 일치하지 않습니다.");
		return false;

	}

	// 삽입
	public void insertUserInfo(String id, String password, String userName, String address) {
		memberList.add(new Member(id, password, userName, address));
	}

	public void insertUserInfo(Member m) {
		memberList.add(m);
	}

	// 수정
	public boolean doLoginModQuit(String id, String pw) {
		try {
			for (int i = 0; i < memberList.size(); i++) {
				if (memberList.get(i).getId().equals(id) == false) {
					continue;
				} else if (memberList.get(i).getId().equals(id) == true) { // id is equal
					if (memberList.get(i).getPassword().equals(pw) == false) {
						continue;
					}

					if (memberList.get(i).getPassword().equals(pw) == true) {
						Thread.sleep(100);
						System.out.print("로그인 중입니다.");
						Thread.sleep(100);
						System.out.print(".");
						Thread.sleep(100);
						System.out.print(".");
						Thread.sleep(100);
						System.out.print(".");
						Thread.sleep(100);
						System.out.println(".");
						Thread.sleep(100);
						System.out.println("로그인 성공!");
						return true;
					}
				}
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("회원정보가 일치하지 않습니다.");
		return false;

	}

	public int doLoginIdx(String id, String pw) {
		for (int i = 0; i < memberList.size(); i++) {
			if (memberList.get(i).getId().equals(id) == false) {
				continue;
			} else if (memberList.get(i).getId().equals(id) == true) { // id is equal
				if (memberList.get(i).getPassword().equals(pw) == false) {
					continue;
				}

				if (memberList.get(i).getPassword().equals(pw) == true) {
					return i;
				}
			}
		}
		return -1;

	}

	public void modifyMemberInfoPW(int getIdx, String pwdStr) {
		memberList.get(getIdx).setPassWord(pwdStr);
	}

	public void modifyMemberInfoName(int getIdx, String aMName) {
		memberList.get(getIdx).setMemberName(aMName);
	}

	public void modifyMemberInfoAddress(int getIdx, String aMAdd) {
		memberList.get(getIdx).setMemberAddress(aMAdd);
	}

	// 삭제
	// remove
	public void deleteMemberInfo(int deleteInputIndex) {
		if (!memberList.isEmpty()) {
			memberList.remove(deleteInputIndex);
			System.out.println("회원 탈퇴가 완료되었습니다.");
		} else
			printIsEmpty();
	}

	public int getMemberListSize() {
		return memberList.size();
	}

}
