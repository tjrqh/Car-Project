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
				System.out.println("로그인 횟수를 초과했습니다.");
				System.out.println("관련 직원 혹은 관리자에게 문의해주세요.");
				System.out.println("프로그램을 종료합니다.");
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
					System.out.println("로그인에 " + loginCount + "회 실패했습니다.");
					System.out.println((3 - loginCount) + "회를 더 실패하면 프로그램이 종료됩니다.");
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
				System.out.println("로그인 횟수를 초과했습니다.");
				System.out.println("관련 직원 혹은 관리자에게 문의해주세요.");
				System.out.println("프로그램을 종료합니다.");
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
						System.out.print("변경할 비밀번호를 입력해주세요 : ");
						String afterPW = sc.nextLine();
						mDao.modifyMemberInfoPW(getIdx, afterPW);
						System.out.print("변경할 이름을 입력해주세요 : ");
						String afterMemberName = sc.nextLine();
						mDao.modifyMemberInfoName(getIdx, afterMemberName);
						System.out.print("변경할 주소를 입력해주세요 : ");
						String afterMemberAddress = sc.nextLine();
						mDao.modifyMemberInfoAddress(getIdx, afterMemberAddress);
						System.out.println("회원 정보 변경이 완료되었습니다.");
						return;
					} else if (modNum == ModifyMemberMenu.MEMBER_MODIFY_PASSWORD) {
						System.out.print("변경할 비밀번호를 입력해주세요 : ");
						String afterPW = sc.nextLine();
						mDao.modifyMemberInfoPW(getIdx, afterPW);
						System.out.println("회원 정보 변경이 완료되었습니다.");
						return;
					} else if (modNum == ModifyMemberMenu.MEMBER_MODIFY_NAME) {
						System.out.print("변경할 이름을 입력해주세요 : ");
						String afterMName = sc.nextLine();
						mDao.modifyMemberInfoName(getIdx, afterMName);
						System.out.println("회원 정보 변경이 완료되었습니다.");
						return;
					} else if (modNum == ModifyMemberMenu.MEMBER_MODIFY_ADDRESS) {
						System.out.print("변경할 주소를 입력해주세요 : ");
						String afterMAddress = sc.nextLine();
						mDao.modifyMemberInfoAddress(getIdx, afterMAddress);
						System.out.println("회원 정보 변경이 완료되었습니다.");
						break;
					}

					else if (modNum == ModifyMemberMenu.MEMBER_PREV) {
						System.out.println("이전으로 돌아갑니다.");
						return;
					}

				}
			}
			if (!isLogin) {
				loginCount++;
				if (loginCount < 3) {
					System.out.println("로그인에 " + loginCount + "회 실패했습니다.");
					System.out.println((3 - loginCount) + "회를 더 실패하면 프로그램이 종료됩니다.");
				}
			}
		}
	}

	public void doLoginQuit() {
		boolean isLogin = false;
		int loginCount = 0;
		while (true) {
			if (loginCount >= 3) {
				System.out.println("로그인 횟수를 초과했습니다.");
				System.out.println("관련 직원 혹은 관리자에게 문의해주세요.");
				System.out.println("프로그램을 종료합니다.");
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
					System.out.println("로그인에 " + loginCount + "회 실패했습니다.");
					System.out.println((3 - loginCount) + "회를 더 실패하면 프로그램이 종료됩니다.");
				}
			}
		}
	}
}
