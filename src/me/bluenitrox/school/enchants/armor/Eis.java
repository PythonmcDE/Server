package me.bluenitrox.school.enchants.armor;

import me.bluenitrox.school.enchants.function.EnchantAPI;
import me.bluenitrox.school.enchants.function.EnchantManager;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class Eis extends EnchantAPI {

    public static void eisAuslösen(Player damager, Player entity, ItemStack i) {
        if (hasEnchant(i, EnchantManager.Eis)) {
            if (makeOrNot20(stringToNumber(i, EnchantManager.Eis))) {
                damager.playSound(damager.getLocation(), Sound.LEVEL_UP, 1L, 1L);
                entity.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 20*3, 0));
            }
        }
    }
}

