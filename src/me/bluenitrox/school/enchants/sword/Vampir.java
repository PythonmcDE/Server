package me.bluenitrox.school.enchants.sword;

import me.bluenitrox.school.enchants.function.EnchantAPI;
import me.bluenitrox.school.enchants.function.EnchantManager;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class Vampir extends EnchantAPI {

    public static void vampirAuslösen(Player damager, Player player, EntityDamageByEntityEvent e) {
        if (hasEnchant(damager.getItemInHand(), EnchantManager.Vampir)) {
            if (makeOrNot80(stringToNumber(damager.getItemInHand(), EnchantManager.Vampir))) {
                damager.playSound(damager.getLocation(), Sound.LEVEL_UP, 1L, 1L);
                damager.setHealth(damager.getHealth() + e.getDamage());
            }
        }
    }
}
