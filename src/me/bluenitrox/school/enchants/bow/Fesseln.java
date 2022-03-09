package me.bluenitrox.school.enchants.bow;

import me.bluenitrox.school.enchants.EnchantAPI;
import me.bluenitrox.school.enchants.EnchantManager;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class Fesseln extends EnchantAPI {

    public static void fesselnAuslösen(Player damager, Player p) {
        if (hasEnchant(damager.getItemInHand(), EnchantManager.Fesseln)) {
            if (makeOrNot80(stringToNumber(damager.getItemInHand(), EnchantManager.Fesseln))) {
                damager.playSound(damager.getLocation(), Sound.LEVEL_UP, 1L, 1L);
                p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW,20*3,1));
            }
        }
    }

}
