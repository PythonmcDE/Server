package me.bluenitrox.school.enchants.pickaxe;

import me.bluenitrox.school.enchants.EnchantAPI;
import me.bluenitrox.school.managers.EnchantManager;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class Ausgrabung extends EnchantAPI {

    public static boolean ausgrabung(Player p){
        if(p.getItemInHand() != null){
            if(p.getItemInHand().getItemMeta() != null){
                if(p.getItemInHand().getItemMeta().getLore() != null){
                    if(hasEnchant(p.getItemInHand(), EnchantManager.Ausgrabung)){
                        if(makeOrNot50(stringToNumber(p.getItemInHand(), EnchantManager.Ausgrabung))){
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

}
