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
            if(killer.getItemInHand().getItemMeta() != null){
                if(killer.getItemInHand().getItemMeta().getLore() != null){
                    if(hasEnchant(killer.getItemInHand(), EnchantManager.Kopfgeld)){
                        if(makeOrNot100(stringToNumber(killer.getItemInHand(), EnchantManager.Kopfgeld))){
                           killer.playSound(killer.getLocation(), Sound.LEVEL_UP, 1L, 1L);
                            Bukkit.broadcastMessage("KOPF");
                           killer.getInventory().addItem(KopfUtil.createSkull(owner.getName(), "§c" + owner.getName()+ "'s Kopf"));
                            Bukkit.broadcastMessage("KOPF");
                        }
                    }
                }
            }
        }
    }

}
