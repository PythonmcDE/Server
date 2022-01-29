package me.bluenitrox.school.enchants.armor;

import me.bluenitrox.school.enchants.EnchantAPI;
import me.bluenitrox.school.managers.EnchantManager;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class Magieschild extends EnchantAPI {

    public static void magieschildAuslösen(Player damager, ItemStack i) {
        if (hasEnchant(i, EnchantManager.Magieschild)) {
            if (makeOrNot20(stringToNumber(i, EnchantManager.Magieschild))) {
                damager.playSound(damager.getLocation(), Sound.LEVEL_UP, 1L, 1L);
                damager.addPotionEffect(new PotionEffect(PotionEffectType.ABSORPTION, 20*30, 0));
            }
        }
    }
}
