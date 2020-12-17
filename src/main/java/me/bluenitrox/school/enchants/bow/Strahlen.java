package me.bluenitrox.school.enchants.bow;

import me.bluenitrox.school.enchants.EnchantAPI;
import me.bluenitrox.school.managers.EnchantManager;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class Strahlen extends EnchantAPI {

    public static void strahlenAuslösen(Player damager, Player p) {
        if (hasEnchant(damager.getItemInHand(), EnchantManager.Strahlen)) {
            if (makeOrNot80(stringToNumber(damager.getItemInHand(), EnchantManager.Strahlen))) {
                damager.setHealth(damager.getHealth() + 1);
            }
        }
    }

}
