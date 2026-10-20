package com.scc;

import com.scc.dao.DataBaseinitializer;
import com.scc.dao.UsersDao;
import com.scc.ui.Authentication;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {

        DataBaseinitializer.initializer();

        Scanner scanner = new Scanner(System.in);
        UsersDao UsersDao = new UsersDao();

        Authentication auth = new Authentication(UsersDao, scanner);
        auth.start();
        scanner.close();
    }



}