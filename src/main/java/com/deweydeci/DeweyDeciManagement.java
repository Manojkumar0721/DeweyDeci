package com.deweydeci;

import java.util.Scanner;

import com.deweydeci.design.EntryPointManagement;
import com.deweydeci.design.GateWayManagement;
import com.deweydeci.design.LoginManagement;
import com.deweydeci.design.LogoManagement;
import com.deweydeci.design.MemberPortal;
import com.deweydeci.design.RegistrationManagement;
import com.mysql.cj.jdbc.AbandonedConnectionCleanupThread;

public class DeweyDeciManagement {
	
//	mvn exec:java "-Dexec.mainClass=com.library.LibraryManagement"
	 

	public static void main(String[] args) throws InterruptedException {
		
		
		Scanner sc = new Scanner(System.in);
		
		clearScreen();
		
		EntryPointManagement.entryPoint();
		
		
		boolean isEnterd = false;
		
		while(!isEnterd) {
			
			String entry = sc.nextLine();
			
			if(entry.isEmpty()) {
				clearScreen();
				startGateWayProcess();
				isEnterd = true;
			}else {
				System.out.println("You entered '" + entry + "'. You are supposed to just press Enter.");
	            Thread.sleep(1500); 
	            System.out.print("\033[1A\033[2K"); 
	            System.out.print("\033[1A\033[2K");
			}
			
		}
		
		clearScreen();
		LogoManagement.logo();
		String username = "ALEX ";
        int borrowed = 2;
        int due = 1;
		MemberPortal.userDashBoard(username, borrowed, due);
		
		sc.close();
		AbandonedConnectionCleanupThread.checkedShutdown();
	}
	
	public static void startGateWayProcess() throws InterruptedException {
		GateWayManagement gateWayMangement = new GateWayManagement();
		RegistrationManagement registrManagement = new RegistrationManagement();
		LoginManagement loginManagement = new LoginManagement();
		Scanner sc = new Scanner(System.in);
		boolean isValid = false;
		gateWayMangement.gateWay();
		while (!isValid) {
		System.out.print("  Selection > ");
		String selection = sc.nextLine().trim().toUpperCase();

		if (selection.equals("R")) {
			System.out.println("\n[SYSTEM] Initializing Registration Protocol...");
			registrManagement.startRegistrationProcess();
			isValid = true;

		} else if (selection.equals("L")) {
			System.out.println("\n[SYSTEM] Accessing Login Terminal...");
			loginManagement.startLoginProcess();
			isValid = true;

		} else {
			System.out.println("  [ERROR] Invalid input. Please enter 'R' or 'L'.\n");
            Thread.sleep(1500); 
            System.out.print("\033[1A\033[2K"); 
            System.out.print("\033[1A\033[2K");
            System.out.print("\033[1A\033[2K"); 
		}
	}
		
	}

	
	public static void clearScreen() {
		try {
			if (System.getProperty("os.name").contains("Windows")) {
				new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
			} else {
				System.out.print("\033[H\033[2J");
				System.out.flush();
			}
		} catch (Exception e) {
			// Do nothing
		}
	}
		
}



















//		clearScreen();
//
//		Scanner sc = new Scanner(System.in);
//
//		Design design = new Design();
//
//		design.logo();
//
//		boolean enter = false;
//
//		while (!enter) {
//			String authentication = sc.nextLine();
//
//			if (authentication.isEmpty()) {
//				boolean isValid = false;
//				design.gateWay();
//				// Loop until the user enters a valid option
//				while (!isValid) {
//					System.out.print("  Selection > ");
//
//					// Read input, remove extra spaces, and convert to uppercase
//					String selection = sc.nextLine().trim().toUpperCase();
//
//					if (selection.equals("R")) {
//						System.out.println("\n[SYSTEM] Initializing Registration Protocol...");
//						// TODO: Add your registration logic here
//						
//						design.startRegistrationProcess();
//
//						isValid = true; // Break the loop
//
//					} else if (selection.equals("L")) {
//						System.out.println("\n[SYSTEM] Accessing Login Terminal...");
//						design.startLoginProcess();
//
//						isValid = true; // Break the loop
//
//					} else {
//						// If they typed anything other than R or L
//						System.out.println("  [ERROR] Invalid input. Please enter 'R' or 'L'.\n");
//						// 2. Pause for 1.5 seconds so the user can read it
//			            Thread.sleep(1500); 
//			            
//			            // 3. Move cursor UP 1 line (to the error message) and clear it
//			            System.out.print("\033[1A\033[2K"); 
//			            
//			            // 4. Move cursor UP 1 MORE line (to the user's bad input) and clear it
//			            System.out.print("\033[1A\033[2K");
//			            
//			            System.out.print("\033[1A\033[2K"); 
//					}
//				}
//
//				enter = true;
//
//			} else {
//				System.out.println("You entered '" + authentication + "'. You are supposed to just press Enter.");
//				// 2. Pause for 1.5 seconds so the user can read it
//	            Thread.sleep(1500); 
//	            
//	            // 3. Move cursor UP 1 line (to the error message) and clear it
//	            System.out.print("\033[1A\033[2K"); 
//	            
//	            // 4. Move cursor UP 1 MORE line (to the user's bad input) and clear it
//	            System.out.print("\033[1A\033[2K");
//			}
//
//		}
//
//	}
//

//
//}

//boolean isValid = false;
//
// while (!isValid) {
//        // 1. Clear the screen at the start of every loop
//        clearScreen();
//
//        System.out.print("Enter: ");
//        String input = sc.nextLine();
//
//        if (input.isEmpty()) {
//            System.out.println("You successfully entered.");
//            isValid = true;
//        } else {
//            // 2. Give feedback, then wait a moment so they can read it
//            System.out.println("You entered something! Please just press Enter.");
//            try { Thread.sleep(1500); } catch (Exception e) {} 
//        }
//}

//	User user = new User("ManojKuamr Y","Vijayanagara","7019234429","manu07y@gamil.com","Manoj@123");
//	
//	boolean save = userService.save(user);
//	
//	System.out.println(save);

//	User user = userService.findByEamilAndPassword("manu07y@gamil.com", "Manoj@123");
//	
//	System.out.println(user);
