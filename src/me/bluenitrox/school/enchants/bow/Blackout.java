package me.bluenitrox.school.enchants.bow;

import me.bluenitrox.school.enchants.EnchantAPI;
import me.bluenitrox.school.enchants.EnchantManager;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class Blackout extends EnchantAPI {

    public static void blackoutAuslösen(Player damager,Player p) {
        if (hasEnchant(damager.getItemInHand(), EnchantManager.Blackout)) {
            if (makeOrNot50(stringToNumber(damager.getItemInHand(), EnchantManager.Blackout))) {
                damager.playSound(damager.getLocation(), Sound.LEVEL_UP, 1L, 1L);
                p.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS,20*3,1));
            }
        }
    }

}
