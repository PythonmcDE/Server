package me.bluenitrox.school.enchants.pickaxe;

import me.bluenitrox.school.enchants.Enchant;
import me.bluenitrox.school.enchants.EnchantAPI;
import me.bluenitrox.school.managers.EnchantManager;
import me.bluenitrox.school.utils.KopfUtil;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class Zorn extends EnchantAPI {

    public static void ZornAuslöser(Player p){
        if(p.getItemInHand() != null){
            if(p.getItemInHand().getItemMeta() != null){
                if(p.getItemInHand().getItemMeta().getLore() != null){
                    if(hasEnchant(p.getItemInHand(), EnchantManager.Zorn)){
                        if(makeOrNot10(stringToNumber(p.getItemInHand(), EnchantManager.Zorn))){
                            p.addPotionEffect(new PotionEffect(PotionEffectType.FAST_DIGGING, 20*3, 1));
                        }
                    }
                }
            }
        }
    }

}
