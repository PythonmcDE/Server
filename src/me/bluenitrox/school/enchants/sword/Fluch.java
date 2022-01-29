package me.bluenitrox.school.enchants.sword;

import me.bluenitrox.school.enchants.EnchantAPI;
import me.bluenitrox.school.managers.EnchantManager;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class Fluch extends EnchantAPI {

    public static void fluchAuslösen(Player damager, Player player) {
        if (hasEnchant(damager.getItemInHand(), EnchantManager.Fluch)) {
            if (makeOrNot80(stringToNumber(damager.getItemInHand(), EnchantManager.Fluch))) {
                damager.playSound(damager.getLocation(), Sound.LEVEL_UP, 1L, 1L);
                player.addPotionEffect(new PotionEffect(PotionEffectType.WITHER, 20 * 3, 0));
            }
        }
    }

}
