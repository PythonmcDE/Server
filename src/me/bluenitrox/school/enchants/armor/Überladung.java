package me.bluenitrox.school.enchants.armor;

import me.bluenitrox.school.enchants.EnchantAPI;
import me.bluenitrox.school.enchants.EnchantManager;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class Überladung extends EnchantAPI {

    public static void überladungAuslösen(Player damager, ItemStack i) {
        if (hasEnchant(i, EnchantManager.Überladung)) {
            if (makeOrNot20(stringToNumber(i, EnchantManager.Überladung))) {
                damager.playSound(damager.getLocation(), Sound.LEVEL_UP, 1L, 1L);
                damager.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 20*3, 2));
            }
        }
    }
}