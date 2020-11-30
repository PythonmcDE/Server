package me.bluenitrox.school.utils;

import org.bukkit.Material;
import org.bukkit.entity.Player;

public class ArmorUtil {

    public static void setArmorNull(Player p){
        if(p.getInventory().getHelmet() != null){
            p.getInventory().setHelmet(new ItemBuilder(Material.AIR).build());
        }
        if(p.getInventory().getChestplate() != null){
            p.getInventory().setChestplate(new ItemBuilder(Material.AIR).build());
        }
        if(p.getInventory().getLeggings() != null){
            p.getInventory().setLeggings(new ItemBuilder(Material.AIR).build());
        }
        if(p.getInventory().getBoots() != null){
            p.getInventory().setBoots(new ItemBuilder(Material.AIR).build());
        }
    }

}
