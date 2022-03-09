package me.bluenitrox.school.enchants.armor;

import me.bluenitrox.school.enchants.EnchantAPI;
import me.bluenitrox.school.enchants.EnchantManager;
import me.bluenitrox.school.utils.ArmorUtil;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class Tank extends EnchantAPI {

    public static void setTankForAll(Player player) {
        ArmorUtil util = new ArmorUtil();
        ItemStack helm = player.getInventory().getHelmet();
        ItemStack chestplate = player.getInventory().getChestplate();
        ItemStack leggins = player.getInventory().getLeggings();
        ItemStack boots = player.getInventory().getBoots();

        int tankwert = 0;

        if(util.hasHelmetWithEnchant(player)){
            if (hasEnchant(helm, EnchantManager.Tank)) {
                tankwert = tankwert + stringToNumber(helm, EnchantManager.Tank);
            }
        }
        if(util.hasChestplateWithEnchant(player)){
            if (hasEnchant(chestplate, EnchantManager.Tank)) {
                tankwert = tankwert + stringToNumber(chestplate, EnchantManager.Tank);
            }
        }
        if(util.hasLegginsWithEnchant(player)){
            if (hasEnchant(leggins, EnchantManager.Tank)) {
                tankwert = tankwert + stringToNumber(leggins, EnchantManager.Tank);
            }
        }
        if(util.hasBootsWithEnchant(player)){
            if (hasEnchant(boots, EnchantManager.Tank)) {
                tankwert = tankwert + stringToNumber(boots, EnchantManager.Tank);
            }
        }
        player.setMaxHealth(20 + tankwert);
    }
}
