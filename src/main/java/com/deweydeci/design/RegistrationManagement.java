package com.deweydeci.design;

import java.util.Scanner;

import com.deweydeci.model.User;
import com.deweydeci.service.UserService;
import com.deweydeci.service.implementation.UserServiceImpl;

public class RegistrationManagement {
	
	UserService userService = new UserServiceImpl();
	
	private Scanner sc = new Scanner(System.in);
	
	// Color Constants
    private final String RESET = "\u001B[0m";
    private final String CYAN = "\u001B[36m";
    private final String GREEN = "\u001B[32m";
    private final String YELLOW = "\u001B[33m";
    private final String RED = "\u001B[31m";
    private final String WHITE_BOLD = "\u001B[1;37m";


	public void startRegistrationProcess() throws InterruptedException {
        // Step 1 Data
        String firstName = "", lastName = "";
        // Step 2 Data
        String address = "", phone = "";
        // Step 3 Data
        String email = "", password = "";

        // --- STEP 1: IDENTITY ---
        clearScreen();
        drawHeader("1/3", "30%", "(WAITING...)", "(WAITING...)", "", "", "", "");
        System.out.print("  [INPUT] Enter First Name: ");
        firstName = sc.nextLine().trim();

        clearScreen();
        drawHeader("1/3", "30%", firstName, "(WAITING...)", "", "", "", "");
        System.out.print("  [INPUT] Enter Last Name : ");
        lastName = sc.nextLine().trim();

        // --- STEP 2: CONTACT ---
        clearScreen();
        drawHeader("2/3", "60%", firstName, lastName, "(WAITING...)", "(WAITING...)", "", "");
        System.out.print("  [INPUT] Enter Address   : ");
        address = sc.nextLine().trim();

        clearScreen();
        drawHeader("2/3", "60%", firstName, lastName, address, "(WAITING...)", "", "");
        System.out.print("  [INPUT] Enter Phone No  : ");
        phone = sc.nextLine().trim();

        // --- STEP 3: SECURITY ---
        clearScreen();
        drawHeader("3/3", "100%", firstName, lastName, address, phone, "(WAITING...)", "(WAITING...)");
        System.out.print("  [INPUT] Enter Email     : ");
        email = sc.nextLine().trim();

        clearScreen();
        drawHeader("3/3", "100%", firstName, lastName, address, phone, email, "(WAITING...)");
        System.out.print("  [INPUT] Enter Password  : ");
        // Note: Use sc.nextLine() for now; System.console().readPassword() is better for real apps
        password = sc.nextLine().trim();

     // --- VALIDATION CHECK ---
        // If any critical field is empty, trigger the Denied state
        if (firstName.isEmpty() || email.isEmpty() || password.isEmpty()) {
            showRegistrationDenied("CRITICAL FIELDS CANNOT BE EMPTY");
            startRegistrationProcess(); // RESTART THE PROCESS
        } else {
        	User user = new User(firstName,lastName,address,phone,email,password);
        	userService.save(user);
            showSuccess(firstName);
        }
    }

    private void drawHeader(String step, String percent, String fn, String ln, String ad, String ph, String em, String pw) {
        System.out.println(CYAN + "\n  DEWEYDECI // ACCOUNT CREATION [STEP " + step + "]" + RESET);
        System.out.println("  ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
        System.out.println("  [PROGRESS] " + YELLOW + percent + " Complete" + RESET);
        
        System.out.println("\n  " + WHITE_BOLD + "IDENTITY DETAILS:" + RESET);
        System.out.println("  > First Name : " + (fn.contains("WAITING") ? YELLOW + fn : GREEN + fn) + RESET);
        System.out.println("  > Last Name  : " + (ln.contains("WAITING") ? YELLOW + ln : GREEN + ln) + RESET);
        
        if (!ad.isEmpty()) {
            System.out.println("\n  " + WHITE_BOLD + "CONTACT INFO:" + RESET);
            System.out.println("  > Address    : " + (ad.contains("WAITING") ? YELLOW + ad : GREEN + ad) + RESET);
            System.out.println("  > Phone No   : " + (ph.contains("WAITING") ? YELLOW + ph : GREEN + ph) + RESET);
        }

        if (!em.isEmpty()) {
            System.out.println("\n  " + WHITE_BOLD + "SECURITY KEYS:" + RESET);
            System.out.println("  > Email      : " + (em.contains("WAITING") ? YELLOW + em : GREEN + em) + RESET);
            System.out.println("  > Password   : " + (pw.contains("WAITING") ? YELLOW + pw : GREEN + "********") + RESET);
        }

        System.out.println("\n  ─────────────────────────────────────────────────────────────");
    }

    private void showSuccess(String name) throws InterruptedException {
        clearScreen();
        System.out.println(GREEN + "\n  [ ✓ ] REGISTRATION SUCCESSFUL" + RESET);
        System.out.println("  ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
        System.out.println("\n  Welcome, " + name.toUpperCase() + ".");
        System.out.println("  Your credentials have been locally encrypted.");
        System.out.println("\n  Press [ENTER] to return to Login Gateway...");
        LoginManagement loginManagement = new LoginManagement();
        boolean isEnterd = false;
		
		while(!isEnterd) {
			String entry = sc.nextLine();
			if(entry.isEmpty()) {
				clearScreen();
				loginManagement.startLoginProcess();
				isEnterd = true;
				
			}else {
				System.out.println("You entered '" + entry + "'. You are supposed to just press Enter.");
	            Thread.sleep(1500); 
	            System.out.print("\033[1A\033[2K"); 
	            System.out.print("\033[1A\033[2K");
			}
			
		}
    }
    
    private void showRegistrationDenied(String reason) {
        clearScreen();
        System.out.println(RED + "\n  [ ✘ ] REGISTRATION DENIED" + RESET);
        System.out.println("  ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
        System.out.println("\n  ERROR CODE: " + WHITE_BOLD + "SECURITY_VALIDATION_FAILED" + RESET);
        System.out.println("  REASON: " + reason);
        System.out.println("\n  The system could not verify your identity protocols.");
        System.out.println("  Redirecting to initialization...");
        System.out.print("\n  Press [ENTER] to try again...");
        sc.nextLine();
    }
    
 // Helper to keep the drawHeader code clean
    private String formatVal(String val) {
        if (val.isEmpty() || val.contains("WAITING")) return YELLOW + "(WAITING...)" + RESET;
        return GREEN + val + RESET;
    }

    private void clearScreen() {
        // Clear screen command for most terminals
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

}
