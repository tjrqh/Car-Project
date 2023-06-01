package com.kk.carApp.control;

import java.util.Scanner;

import com.kk.carApp.DAO.MemberDAO;
import com.kk.carApp.DTO.Member;
import com.kk.carApp.view.ModifyMemberMenu;

public class MemberMgr {
	MemberDAO mDao = new MemberDAO();
	ModifyMemberMenu modifyMemberMenu = new ModifyMemberMenu();
	Scanner sc = new Scanner(System.in);

	// View All Member
	public void memberView() {
		mDao.selectAll();
	}

	public boolean isMemberEmpty() {
		if (mDao.getMemberListSize() == 0) {
			mDao.printIsEmpty();
			return true;
		} else
			return false;
	}

	public boolean doLoginMain() {
		boolean isLogin = false;
		int loginCount = 0;
		while (true) {
			if (loginCount >= 3) {
				System.out.println("�α��� Ƚ���� �ʰ��߽��ϴ�.");
				System.out.println("���� ���� Ȥ�� �����ڿ��� �������ּ���.");
				System.out.println("���α׷��� �����մϴ�.");
				System.exit(0);
			}
			String inputID = "";
			String inputPW = "";
			System.out.print("ID       : ");
			inputID = sc.nextLine();
			System.out.print("PASSWORD : ");
			inputPW = sc.nextLine();
			isLogin = mDao.doLoginMain(inputID, inputPW);
			if (isLogin)
				break;

			if (!isLogin) {
				loginCount++;
				if (loginCount < 3) {
					System.out.println("�α��ο� " + loginCount + "ȸ �����߽��ϴ�.");
					System.out.println((3 - loginCount) + "ȸ�� �� �����ϸ� ���α׷��� ����˴ϴ�.");
				}
			}

		}
		return isLogin;
	}

	public void memberInsert(Member m) {
		mDao.insertUserInfo(m);
	}

	public void doLoginModify() {
		boolean isLogin = false;
		int loginCount = 0;
		while (true) {
			if (loginCount >= 3) {
				System.out.println("�α��� Ƚ���� �ʰ��߽��ϴ�.");
				System.out.println("���� ���� Ȥ�� �����ڿ��� �������ּ���.");
				System.out.println("���α׷��� �����մϴ�.");
				System.exit(0);
			}
			String inputID = "";
			String inputPW = "";
			System.out.print("ID       : ");
			inputID = sc.nextLine();
			System.out.print("PASSWORD : ");
			inputPW = sc.nextLine();
			isLogin = mDao.doLoginModQuit(inputID, inputPW);
			if (isLogin) {
				while (true) {
					int getIdx = mDao.doLoginIdx(inputID, inputPW);
					int modNum = modifyMemberMenu.modifyMember();
					if (modNum == ModifyMemberMenu.MEMBER_MODIFY_ALL_INFO) {
						System.out.print("������ ��й�ȣ�� �Է����ּ��� : ");
						String afterPW = sc.nextLine();
						mDao.modifyMemberInfoPW(getIdx, afterPW);
						System.out.print("������ �̸��� �Է����ּ��� : ");
						String afterMemberName = sc.nextLine();
						mDao.modifyMemberInfoName(getIdx, afterMemberName);
						System.out.print("������ �ּҸ� �Է����ּ��� : ");
						String afterMemberAddress = sc.nextLine();
						mDao.modifyMemberInfoAddress(getIdx, afterMemberAddress);
						System.out.println("ȸ�� ���� ������ �Ϸ�Ǿ����ϴ�.");
						return;
					} else if (modNum == ModifyMemberMenu.MEMBER_MODIFY_PASSWORD) {
						System.out.print("������ ��й�ȣ�� �Է����ּ��� : ");
						String afterPW = sc.nextLine();
						mDao.modifyMemberInfoPW(getIdx, afterPW);
						System.out.println("ȸ�� ���� ������ �Ϸ�Ǿ����ϴ�.");
						return;
					} else if (modNum == ModifyMemberMenu.MEMBER_MODIFY_NAME) {
						System.out.print("������ �̸��� �Է����ּ��� : ");
						String afterMName = sc.nextLine();
						mDao.modifyMemberInfoName(getIdx, afterMName);
						System.out.println("ȸ�� ���� ������ �Ϸ�Ǿ����ϴ�.");
						return;
					} else if (modNum == ModifyMemberMenu.MEMBER_MODIFY_ADDRESS) {
						System.out.print("������ �ּҸ� �Է����ּ��� : ");
						String afterMAddress = sc.nextLine();
						mDao.modifyMemberInfoAddress(getIdx, afterMAddress);
						System.out.println("ȸ�� ���� ������ �Ϸ�Ǿ����ϴ�.");
						break;
					}

					else if (modNum == ModifyMemberMenu.MEMBER_PREV) {
						System.out.println("�������� ���ư��ϴ�.");
						return;
					}

				}
			}
			if (!isLogin) {
				loginCount++;
				if (loginCount < 3) {
					System.out.println("�α��ο� " + loginCount + "ȸ �����߽��ϴ�.");
					System.out.println((3 - loginCount) + "ȸ�� �� �����ϸ� ���α׷��� ����˴ϴ�.");
				}
			}
		}
	}

	public void doLoginQuit() {
		boolean isLogin = false;
		int loginCount = 0;
		while (true) {
			if (loginCount >= 3) {
				System.out.println("�α��� Ƚ���� �ʰ��߽��ϴ�.");
				System.out.println("���� ���� Ȥ�� �����ڿ��� �������ּ���.");
				System.out.println("���α׷��� �����մϴ�.");
				System.exit(0);
			}
			String inputID = "";
			String inputPW = "";
			System.out.print("ID       : ");
			inputID = sc.nextLine();
			System.out.print("PASSWORD : ");
			inputPW = sc.nextLine();
			isLogin = mDao.doLoginModQuit(inputID, inputPW);
			if (isLogin) {
				int getIdx = mDao.doLoginIdx(inputID, inputPW);
				mDao.deleteMemberInfo(getIdx);
				break;
			}

			if (!isLogin) {
				loginCount++;
				if (loginCount < 3) {
					System.out.println("�α��ο� " + loginCount + "ȸ �����߽��ϴ�.");
					System.out.println((3 - loginCount) + "ȸ�� �� �����ϸ� ���α׷��� ����˴ϴ�.");
				}
			}
		}
	}
}
