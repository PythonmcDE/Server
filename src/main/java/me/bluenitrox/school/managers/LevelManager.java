package me.bluenitrox.school.managers;

import java.util.HashMap;

public class LevelManager {

    public static HashMap<Integer, Float> level = new HashMap<>();

    public static void registerLevel(){
        level.put(1,1000F);
        level.put(2, 3000F);
        level.put(3, 7000F);
        level.put(4, 10000F);
        level.put(5, 12000F);
    }

}
