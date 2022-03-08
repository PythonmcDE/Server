package me.bluenitrox.school.enchants.bow;

import me.bluenitrox.school.enchants.function.EnchantAPI;
import me.bluenitrox.school.enchants.function.EnchantManager;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

public class Dynamite extends EnchantAPI {

    public static void dynamiteAuslösen(Player damager, Player p) {
        if (hasEnchant(damager.getItemInHand(), EnchantManager.Dynamite)) {
            if (makeOrNot80(stringToNumber(damager.getItemInHand(), EnchantManager.Dynamite))) {
                damager.playSound(damager.getLocation(), Sound.LEVEL_UP, 1L, 1L);
                p.getWorld().createExplosion(p.getLocation(),1F,false);
            }
        }
    }

}
