package me.bluenitrox.school.enchants.bow;

import me.bluenitrox.school.enchants.EnchantAPI;
import me.bluenitrox.school.managers.EnchantManager;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class Tod extends EnchantAPI {

    public static void todAuslösen(Player damager, Player p) {
        if (hasEnchant(damager.getItemInHand(), EnchantManager.Tod)) {
            if (makeOrNot80(stringToNumber(damager.getItemInHand(), EnchantManager.Tod))) {
                damager.playSound(damager.getLocation(), Sound.LEVEL_UP, 1L, 1L);
                p.addPotionEffect(new PotionEffect(PotionEffectType.WITHER,20*3,1));
            }
        }
    }

}
