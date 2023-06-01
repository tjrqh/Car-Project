package com.kk.carApp;

import com.kk.carApp.control.CarMgr;
import com.kk.carApp.control.MemberMgr;
import com.kk.carApp.view.DeleteCarMenu;
import com.kk.carApp.view.InsertCarMenu;
import com.kk.carApp.view.InsertMemberMenu;
import com.kk.carApp.view.LoginMenu;
import com.kk.carApp.view.MainMenu;
import com.kk.carApp.view.ModifyCarMenu;
import com.kk.carApp.view.SearchCarMenu;

public class CarMain {
	public static void main(String[] args) { // Main Start
		LoginMenu loginMenu = new LoginMenu(); // Login Menu Object
		MainMenu maMenu = new MainMenu(); // MainMenu Object
		InsertCarMenu insertCarMenu = new InsertCarMenu(); // Insert Car Menu Object
		InsertMemberMenu insertMemberMenu = new InsertMemberMenu(); // Insert Member Menu Object
		SearchCarMenu searchCarMenu = new SearchCarMenu(); // Search Car Menu Object
		ModifyCarMenu modifyCarMenu = new ModifyCarMenu(); // Modify Car Menu Object
		DeleteCarMenu deleteCarMenu = new DeleteCarMenu(); // Delete Car Menu Object
		CarMgr carMgr = new CarMgr(); // Car Controller = Manager Object
		MemberMgr memberMgr = new MemberMgr(); // Member Controller = Manager Object

		while (true) { // Loop Start
			switch (loginMenu.menu()) { // Return Login Menu Number (Integer)
				case LoginMenu.LOGIN_MENU_LOGIN:
					boolean isMemberEmpty = memberMgr.isMemberEmpty(); // Return
					if (isMemberEmpty) { // if ArrayList Empty => Not Run Login
						continue;
					} else { // ArrayList not Empty => Do Login
						boolean isLogin = memberMgr.doLoginMain(); // isLogin : Login Available(Boolean)
						if (!isLogin) // isLogin == False
							System.exit(0); // Program Exit
						else { // Login Success => Run Car Program
							while (true) { // Car Program Loop
								int maMenuNum = maMenu.menu();
								if (maMenuNum == MainMenu.MAIN_MENU_VIEW_ALL) { // Car Info View All
									carMgr.carView();
								} else if (maMenuNum == MainMenu.MAIN_MENU_VIEW_SEARCH) { // Car Search Menu
									while (true) {
										int searchCarMenuValue = searchCarMenu.selectMenu();
										if (searchCarMenuValue == SearchCarMenu.SEARCH_MENU_VIEW_ALL) // View All Car Info
											carMgr.carView();
										else if (searchCarMenuValue == SearchCarMenu.SEARCH_MENU_PREV) { // Go Previous
											carMgr.carPrintPrev();
											break;
										} else // One Point Search Car Info
											carMgr.carSearch(searchCarMenuValue);
									}
								} else if (maMenuNum == MainMenu.MAIN_MENU_INSERT) // Car Insert
									carMgr.carInsert(insertCarMenu.insertData());

								else if (maMenuNum == MainMenu.MAIN_MENU_MODIFY) { // Car Modify
									while (true) {
										int modifyCarMenuValue = modifyCarMenu.modifyMenu();
										if (modifyCarMenuValue == ModifyCarMenu.MODIFY_MENU_VIEW_ALL) // View All Car Info
											// because of
											// modified
											carMgr.carView();
										else if (modifyCarMenuValue == ModifyCarMenu.MODIFY_MENU_PREV) { // Go Previous
											carMgr.carPrintPrev();
											break;
										} else {
											while (true) {
												int modifyCarSelectMod = modifyCarMenu.modifyModSelect();
												if (modifyCarSelectMod == ModifyCarMenu.MODIFY_MOD_PREV) { // Go Previous
													carMgr.carPrintPrev();
													break;
												} else {
													carMgr.carModify(modifyCarSelectMod); // Do One Point or All Car Info
													// Modify
													break;
												}
											}
											break;
										}
									}
								} else if (maMenuNum == MainMenu.MAIN_MENU_DELETE) { // Car Delete
									while (true) {
										int deleteCarMenuValue = deleteCarMenu.deleteMenu();
										if (deleteCarMenuValue == DeleteCarMenu.DELETE_MENU_VIEW_ALL) // View All Car Info
											carMgr.carView();
										else if (deleteCarMenuValue == DeleteCarMenu.DELETE_MENU_DO) // Do Delete Car Info
											carMgr.carDelete();
										else if (deleteCarMenuValue == DeleteCarMenu.DELETE_MENU_PREV) { // Go Previous
											carMgr.carPrintPrev();
											break;
										}
									}
								}
								if (maMenuNum == MainMenu.MAIN_MENU_EXIT) { // Program Exit
									System.out.println("프로그램을 종료합니다.");
									System.exit(0);
								}

							}
						}
					}
					break;
				case LoginMenu.LOGIN_MENU_REGISTER: // Member Register
					memberMgr.memberInsert(insertMemberMenu.insertData());
					break;
				case LoginMenu.LOGIN_MENU_MODIFY: // Member Modify
					isMemberEmpty = memberMgr.isMemberEmpty();
					if (isMemberEmpty) {
						continue;
					} else {
						memberMgr.doLoginModify();
					}
					break;
				case LoginMenu.LOGIN_MENU_DELETE: // Member Delete
					isMemberEmpty = memberMgr.isMemberEmpty();
					if (isMemberEmpty) {
						continue;
					} else {
						memberMgr.doLoginQuit();
					}
					break;
				case LoginMenu.LOGIN_MENU_VIEW: // Member View
					isMemberEmpty = memberMgr.isMemberEmpty();
					if (isMemberEmpty) {
						continue;
					} else {
						memberMgr.memberView();
					}
					break;
				case LoginMenu.LOGIN_MENU_EXIT: // Program Exit
					System.out.println("프로그램을 종료합니다.");
					System.exit(0);
					break;
			}
		}

	}
}
