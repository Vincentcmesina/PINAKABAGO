package com.scc.ui;

import com.scc.dao.UsersDao;
import com.scc.model.Users;

import java.util.List;
import java.util.Scanner;

public class AdminMenu {
    private final UsersDao usersDao;
    private final Scanner scanner;

    public AdminMenu(UsersDao userDao, Scanner scanner) {
        this.usersDao = userDao;
        this.scanner = scanner;
    }

    public void display(Users admin) {
        boolean loggedIn = true;
        while (loggedIn) {
            System.out.println("\n========================================");
            System.out.println("            ADMIN DASHBOARD             ");
            System.out.println("========================================");
            System.out.println("1. View All Users");
            System.out.println("2. View Pending User Approvals");
            System.out.println("3. Approve User Registration");
            System.out.println("4. Add New User");
            System.out.println("5. Update User Role / Status");
            System.out.println("6. Delete User Account");
            System.out.println("7. Logout");
            System.out.print("Choose an option (1-7): ");

            String choice = scanner.nextLine().trim();

            switch (choice){
                case "1" -> viewAllUsers();
                case "2" ->
                default -> System.out.println(" -> [ERROR] invalid Options,");
            }


        }
    }

    private void displayUserTable(List<Users> Users, String title){
        System.out.println("\n================================" +title+ "==================================");
        if(Users.isEmpty()){
            System.out.println("-> No RECORDS FOUND");
            return;
        }
        System.out.println("+-----+-----------------+------------+------------+");
        System.out.printf("| %-3s | %-15s | %-10s | %-10s |\n", "ID", "Username", "Role", "Status");
        System.out.println("+-----+-----------------+------------+------------+");
        for(Users u : Users){
            System.out.printf("| %-3s | %-15s | %-10s | %-10s |\n",
            u.id(), u.username(), u.role(), u.status());
        }
        System.out.println("+-----+-----------------+------------+------------+");
    }

    private void viewAllUsers(){
        displayUserTable(usersDao.getAllUser(), "ALL REGISTERED USER");
    }

    private void viewPendingUsers(){
        displayUserTable(usersDao.getPendingUser(), "PENDING APPROVALS");
    }
}

