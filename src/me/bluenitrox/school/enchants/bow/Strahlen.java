package me.bluenitrox.school.enchants.bow;

import me.bluenitrox.school.enchants.function.EnchantAPI;
import me.bluenitrox.school.enchants.function.EnchantManager;
import org.bukkit.entity.Player;

public class Strahlen extends EnchantAPI {

    public static void strahlenAuslösen(Player damager, Player p) {
        if (hasEnchant(damager.getItemInHand(), EnchantManager.Strahlen)) {
            if (makeOrNot80(stringToNumber(damager.getItemInHand(), EnchantManager.Strahlen))) {
                damager.setHealth(damager.getHealth() + 1);
            }
        }
    }

}
