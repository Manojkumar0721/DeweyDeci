package com.deweydeci.design;

import java.util.Scanner;

import com.deweydeci.model.User;
import com.deweydeci.service.UserService;
import com.deweydeci.service.implementation.UserServiceImpl;
import com.deweydeci.service.validation.UserValidations;

public class LoginManagement {
	
	UserService userService = new UserServiceImpl();
	UserValidations userValidation = new UserValidations();
	LogoManagement logoManagement = new LogoManagement();
	
	private Scanner sc = new Scanner(System.in);
	
	// Color Constants
    private final String RESET = "\u001B[0m";
    private final String CYAN = "\u001B[36m";
    private final String RED = "\u001B[31m";
    private final String GREEN = "\u001B[32m";
    private final String YELLOW = "\u001B[33m";
    private final String WHITE_BOLD = "\u001B[1;37m";
	
	public void startLoginProcess() {
        String email = "";
        String password = "";
        

        // --- PHASE 1: IDENTIFIER ---
        clearScreen();
        drawLoginHeader("ENCRYPTED", "(WAITING...)", "");
        System.out.print("  [SYSTEM] Enter Email: ");
        email = sc.nextLine().trim();

        // --- PHASE 2: ACCESS KEY ---
        clearScreen();
        drawLoginHeader("ENCRYPTED", email, "(WAITING...)");
        System.out.print("  [SYSTEM] Enter Password: ");
        password = sc.nextLine().trim();
        
        User userByEamilAndPassword = userService.findByEamilAndPassword(email, password);


        if (userByEamilAndPassword != null) {
        	if( userByEamilAndPassword.getEmail().equals(email) && userByEamilAndPassword.getPassword().equals(password))	
        	showAccessGranted(userByEamilAndPassword.getFirstName() + userByEamilAndPassword.getLastName());
        } else {
            showAccessDenied();
        }
    }

    private void drawLoginHeader(String status, String em, String pw) {
        System.out.println(CYAN + "\n  DEWEYDECI // AUTHENTICATION GATEWAY" + RESET);
        System.out.println("  ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
        System.out.println("  [VAULT STATUS] " + GREEN + status + RESET);
        
        System.out.println("\n  " + WHITE_BOLD + "CREDENTIALS CHECK:" + RESET);
        System.out.println("  > Identifier : " + (em.contains("WAITING") ? YELLOW + em : GREEN + em) + RESET);
        
        // Hide password once entered
        String passDisplay = pw.contains("WAITING") ? YELLOW + pw : "********";
        System.out.println("  > Access Key : " + passDisplay + RESET);
        
        System.out.println("\n  ─────────────────────────────────────────────────────────────");
        System.out.println("  [!] Restricted access. Unauthorized attempts are logged.");
    }
    private void showAccessGranted(String user) {
        clearScreen();
        System.out.println(GREEN + "\n  [ ✓ ] ACCESS GRANTED" + RESET);
        System.out.println("  ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
        System.out.println("\n  Identity Verified: " + user.toUpperCase());
        System.out.println("  Decrypting Member Portal...");
        System.out.println("\n  Press [ENTER] to open Dashboard.");
        sc.nextLine();
    }

    private void showAccessDenied() {
        System.out.println(RED + "\n  [ ✘ ] ACCESS DENIED" + RESET);
        System.out.println("  Invalid credentials. Security lock in 3 attempts.");
        System.out.print("\n  Press [ENTER] to retry...");
        sc.nextLine();
        startLoginProcess(); // Restarts the loop
    }
    
    private void clearScreen() {
        // Clear screen command for most terminals
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

}
