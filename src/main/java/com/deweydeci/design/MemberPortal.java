package com.deweydeci.design;

public class MemberPortal {
	
	public static void userDashBoard(String username, int borrowed, int due) {
        // 1. Header
        System.out.println("\n DEWEYDECI // MEMBER PORTAL                          STATUS: ONLINE");
        System.out.println(" ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");

        // 2. Top Outer Border
        System.out.println(" ╔═════════════════════════════════════════════════════════════════════╗");
        
        // 3. Welcome Row (53 spaces total inside)
        System.out.printf("    WELCOME BACK, %-51s                                                 \n",username);
        
        // 4. Internal Divider (Connects perfectly)
        System.out.println(" ╠══════════════════════════════╦══════════════════════════════════════╣");
        
        // 5. Activity & Announcements Headers
        System.out.println(" ║  YOUR ACTIVITY               ║  LIBRARY ANNOUNCEMENTS               ║");
        
        // 6. Data Rows (Ensuring widths match the 30-char and 38-char columns)
        System.out.printf(" ║  - Books Borrowed : %02d       ║  - New Arrivals: Project Hail Mary   ║\n", borrowed);
        System.out.printf(" ║  - Due This Week  : %02d       ║  - System Maintenance: Sunday 2AM    ║\n", due);
        
        // 7. Middle Divider (Note the ╩ to close the vertical line from above)
        System.out.println(" ╠══════════════════════════════╩══════════════════════════════════════╣");
        
        // 8. Navigation Section
        System.out.println(" ║  [ NAVIGATION MENU ]                                                ║");
        System.out.println(" ║                                                                     ║");
        System.out.println(" ║  (1) SEARCH CATALOG                     (4) RETURN A BOOK           ║");
        System.out.println(" ║  (2) BORROW NEW ITEM                    (5) ACCOUNT SETTINGS        ║");
        System.out.println(" ║  (3) VIEW MY BOOKSHELF                  (Q) LOGOUT SESSION          ║");
        
        // 9. Bottom Outer Border
        System.out.println(" ╚═════════════════════════════════════════════════════════════════════╝");
        
        // 10. Shading (Matches width of the box)
        System.out.println("  ▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒\n");
        
        System.out.print(" Selection > _ ");
    }
}
