package me.bluenitrox.school.enchants.armor;

import me.bluenitrox.school.enchants.EnchantAPI;
import me.bluenitrox.school.managers.EnchantManager;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class Heilzauber extends EnchantAPI {

    public static void heilzauberAuslösen(Player damager, ItemStack i) {
        if (hasEnchant(i, EnchantManager.Heilzauber)) {
            if (makeOrNot20(stringToNumber(i, EnchantManager.Heilzauber))) {
                damager.playSound(damager.getLocation(), Sound.LEVEL_UP, 1L, 1L);
                damager.setHealth(damager.getHealth() + 3);
            }
        }
    }
}