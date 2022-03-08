package me.bluenitrox.school.enchants.armor;

import de.Herbystar.TTA.TTA_Methods;
import me.bluenitrox.school.enchants.function.EnchantAPI;
import me.bluenitrox.school.enchants.function.EnchantManager;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class Stacheln extends EnchantAPI {

    public static void stachelnAuslösen(Player damager, Player entity, ItemStack i) {
        if (hasEnchant(i, EnchantManager.Widerstand)) {
            if (makeOrNot20(stringToNumber(i, EnchantManager.Widerstand))) {
                damager.playSound(damager.getLocation(), Sound.LEVEL_UP, 1L, 1L);
                TTA_Methods.sendActionBar(entity,"§8» §7" + damager.getName() + " hat seinen Schaden auf dich §agespiegelt§7!", 20*3);
                entity.setHealth(entity.getHealth()-1);
            }
        }
    }
}
