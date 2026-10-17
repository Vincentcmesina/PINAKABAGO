package com.scc.ui;

import com.scc.dao.UsersDao;
import com.scc.model.Users;

import java.util.Scanner;

public class Authentication {

    private final UsersDao UsersDao;
    private final Scanner sc;

    public Authentication(UsersDao userDao, Scanner sc){
        this.UsersDao = userDao;
        this.sc = sc;
    }

    public void start(){
        System.out.println("\n==================================");
        System.out.println(" Teachers Data Management");
        System.out.println("==================================");
        System.out.println("1. Login");
        System.out.println("2. Register");
        System.out.println("3. Exit");
        System.out.print("Choose an option: ");
        String choice = sc.nextLine();

        switch (choice) {
            case "1":
                handleLogin();
                break;
            case "2":
                System.out.print("Enter new username: ");
                String user = sc.nextLine();
                System.out.print("Enter password: ");
                String pass = sc.nextLine();

                System.out.print("Select Role [1] TEACHER | [2] ADMIN: ");
                int roleChoice = sc.nextInt();
                String role;
                switch (roleChoice) {
                    case 1:
                        role = "TEACHER";
                        break;
                    case 2:
                        role = "ADMIN";
                        break;
                    default:
                        role = null;
                }

                if (role != null) {
                    UsersDao.registerUser(user, pass, role);

                }else{

                    System.out.println("invalid role!");

                }
                break;
        }

    }

    private void handleLogin() {
        System.out.print("Enter username: ");
        String username = sc.nextLine();
        System.out.print("Enter Password: ");
        String password = sc.nextLine();

        Users user = UsersDao.login(username, password);

        if (user != null) {
            System.out.println("\n -> Welcome " + user.username() + " | ROLE: " + user.role()+"");
            switch (user.role()) {
                case "ADMIN" -> new AdminMenu(UsersDao, sc).display(user);
                default -> System.out.println("Account roles not found");
            }
        }



    }

}