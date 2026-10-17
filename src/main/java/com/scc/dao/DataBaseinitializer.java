package com.scc.dao;

public class DataBaseinitializer {
    public static void initializer(){
        new UsersDao();
        System.out.println(" -> Database tables verified");
    }
}
