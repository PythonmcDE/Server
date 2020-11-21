package me.bluenitrox.school.managers;

import java.util.HashMap;

public class LevelManager {

    public static HashMap<Integer, Float> level = new HashMap<>();

    public static void registerLevel(){
        level.put(1,0F);
    }

}
