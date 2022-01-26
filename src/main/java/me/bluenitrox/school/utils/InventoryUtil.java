package me.bluenitrox.school.utils;

import org.bukkit.entity.Player;

public class InventoryUtil {

    public static boolean isInvFull(Player p){
        for(int i = 0; i< p.getInventory().getSize(); i++){
            if(p.getInventory().getItem(i) == null){
                return false;
            }
        }
        return true;
    }

}
