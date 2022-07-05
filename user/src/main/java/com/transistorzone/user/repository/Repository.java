package com.transistorzone.user.repository;

import java.util.HashMap;
import java.util.Map;

public class Repository {

    public static Map<Integer, String> users = new HashMap<>();

    public static void init(){
        users.put(1,"Dinura Seneviratne");
        users.put(2, "Loyd Forger");
        users.put(3, "Misato Katsuragi");
        users.put(4, "Takumi Fujiwara");
        users.put(5, "Toshino Kyoko");
    }

}
