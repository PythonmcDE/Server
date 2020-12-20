package me.bluenitrox.school.enchants.sword;

import me.bluenitrox.school.enchants.EnchantAPI;
import me.bluenitrox.school.managers.EnchantManager;
import me.bluenitrox.school.utils.KopfUtil;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

public class Kopfgeld extends EnchantAPI {

    public static void giveHead(Player killer, Player owner){
        if(killer.getItemInHand() != null){
            Bukkit.broadcastMessage("KOPF1");
            if(killer.getItemInHand().getItemMeta() != null){
                Bukkit.broadcastMessage("KOPF2");
                if(killer.getItemInHand().getItemMeta().getLore() != null){
                    Bukkit.broadcastMessage("KOPF3");
                    if(hasEnchant(killer.getItemInHand(), EnchantManager.Kopfgeld)){
                        Bukkit.broadcastMessage("KOPF4");
                        if(makeOrNot100(stringToNumber(killer.getItemInHand(), EnchantManager.Kopfgeld))){
                           killer.playSound(killer.getLocation(), Sound.LEVEL_UP, 1L, 1L);
                            Bukkit.broadcastMessage("KOPF5");
                           killer.getInventory().addItem(KopfUtil.createSkull(owner.getName(), "§c" + owner.getName()+ "'s Kopf"));
                            Bukkit.broadcastMessage("KOPF6");
                        }
                    }
                }
            }
        }
    }

}
