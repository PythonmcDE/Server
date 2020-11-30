package me.bluenitrox.school.enchants.sword;

import me.bluenitrox.school.enchants.EnchantAPI;
import me.bluenitrox.school.managers.EnchantManager;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class Kobra extends EnchantAPI {

    public static void kobraAuslösen(Player damager, Player player) {
        if (hasEnchant(damager, EnchantManager.Kobra)) {
            if (makeOrNot80(stringToNumber(damager.getItemInHand(), EnchantManager.Kobra))) {
                damager.playSound(damager.getLocation(), Sound.LEVEL_UP, 1L, 1L);
                player.addPotionEffect(new PotionEffect(PotionEffectType.POISON, 20 * 3, 0));
            }
        }
    }
}
