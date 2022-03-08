package me.bluenitrox.school.enchants.sword;

import me.bluenitrox.school.enchants.function.EnchantAPI;
import me.bluenitrox.school.enchants.function.EnchantManager;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class Jäger extends EnchantAPI {

    public static void jägerAuslösen(Player damager, EntityDamageByEntityEvent e) {
        if (hasEnchant(damager.getItemInHand(), EnchantManager.Jäger)) {
            if (makeOrNot80(stringToNumber(damager.getItemInHand(), EnchantManager.Jäger))) {
                damager.playSound(damager.getLocation(), Sound.LEVEL_UP, 1L, 1L);
                e.setDamage(e.getDamage()*2);
            }
        }
    }

}
