package com.kk.carApp.DAO;

import java.util.ArrayList;
import java.util.Scanner;

import com.kk.carApp.DTO.Member;

public class MemberDAO {
	private ArrayList<Member> memberList;
	Scanner sc = new Scanner(System.in);

	public MemberDAO() {
		memberList = new ArrayList<Member>();
		memberList.add(new Member("admin", "1234", "������", "�ּ� ����"));
		memberList.add(new Member("member", "asdf1234", "asdf4321", "��ö��", "�뱸������ ���� ���絿"));
		memberList.add(new Member("manager", "qwer1234", "qwer4321", "��ö��", "�뱸������ ���� ���絿"));
		memberList.add(new Member("member", "rtyu1234", "rtyu4321", "��ö��", "�뱸������ �ϱ� ���絿"));
		memberList.add(new Member("manager", "zxcv1234", "zxcv4321", "��ö��", "�뱸������ �߱� ���絿"));
		memberList.add(new Member("uiop1234", "uiop4321", "��ö��", "�뱸������ �߱� ���絿"));

	}

	// Print Method
	public void printIsEmpty() {
		System.out.println("ȸ���� �Ѹ� �����ϴ�. ȸ�� ������ ���ּ���.");
	}

	public void printSearchNothings() {
		System.out.println("��ġ�ϴ� ������ �����ϴ�.");
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
							System.out.print("�α��� ���Դϴ�.");
							Thread.sleep(100);
							System.out.print(".");
							Thread.sleep(100);
							System.out.print(".");
							Thread.sleep(100);
							System.out.print(".");
							Thread.sleep(100);
							System.out.println(".");
							Thread.sleep(100);
							System.out.println("�α��� ����!");
							return true;
						} else {
							Thread.sleep(100);
							System.out.print("�α��� ���Դϴ�.");
							Thread.sleep(100);
							System.out.print(".");
							Thread.sleep(100);
							System.out.print(".");
							Thread.sleep(100);
							System.out.print(".");
							Thread.sleep(100);
							System.out.println(".");
							Thread.sleep(100);
							System.out.println("������ �����մϴ�.");
							Thread.sleep(100);
							System.out.println("�α��� ����!");
							return false;
						}
					}
				}
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("ȸ�������� ��ġ���� �ʽ��ϴ�.");
		return false;

	}

	// ����
	public void insertUserInfo(String id, String password, String userName, String address) {
		memberList.add(new Member(id, password, userName, address));
	}

	public void insertUserInfo(Member m) {
		memberList.add(m);
	}

	// ����
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
						System.out.print("�α��� ���Դϴ�.");
						Thread.sleep(100);
						System.out.print(".");
						Thread.sleep(100);
						System.out.print(".");
						Thread.sleep(100);
						System.out.print(".");
						Thread.sleep(100);
						System.out.println(".");
						Thread.sleep(100);
						System.out.println("�α��� ����!");
						return true;
					}
				}
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("ȸ�������� ��ġ���� �ʽ��ϴ�.");
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

	// ����
	// remove
	public void deleteMemberInfo(int deleteInputIndex) {
		if (!memberList.isEmpty()) {
			memberList.remove(deleteInputIndex);
			System.out.println("ȸ�� Ż�� �Ϸ�Ǿ����ϴ�.");
		} else
			printIsEmpty();
	}

	public int getMemberListSize() {
		return memberList.size();
	}

}
