package me.bluenitrox.school.enchants.bow;

import me.bluenitrox.school.enchants.EnchantAPI;
import me.bluenitrox.school.managers.EnchantManager;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class Dynamite extends EnchantAPI {

    public static void dynamiteAuslösen(Player damager, Player p) {
        if (hasEnchant(damager.getItemInHand(), EnchantManager.Blackout)) {
            if (makeOrNot100(stringToNumber(damager.getItemInHand(), EnchantManager.Blackout))) {
                damager.playSound(damager.getLocation(), Sound.LEVEL_UP, 1L, 1L);
                p.getWorld().createExplosion(p.getLocation(),7F,false);
            }
        }
    }

}
