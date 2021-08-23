package me.bluenitrox.school.enchants.all;

import me.bluenitrox.school.enchants.EnchantAPI;
import me.bluenitrox.school.managers.EnchantManager;
import me.bluenitrox.school.utils.ItemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

public class Erhalt extends EnchantAPI {

    public static HashMap<UUID, ItemStack> items = new HashMap<>();


    public static void giveItem(Player owner){
        for(int i = 0; i< owner.getInventory().getSize();i++) {
            Inventory inv = owner.getInventory();
            if (inv.getItem(i) != null) {
                if (inv.getItem(i).getItemMeta() != null) {
                    if (inv.getItem(i).getItemMeta().getLore() != null) {
                        if (hasEnchant(inv.getItem(i), EnchantManager.Erhalt)) {
                            Bukkit.broadcastMessage("Vor Erhalt aktivierung!");
                            if (makeOrNot80(stringToNumber(inv.getItem(i), EnchantManager.Erhalt))) {
                                Bukkit.broadcastMessage("Erhalt aktiviert!");
                                Bukkit.broadcastMessage("§6" + inv.getItem(i).toString());
                                items.put(owner.getUniqueId(), inv.getItem(i));
                                Bukkit.broadcastMessage("§a" + items.get(owner.getUniqueId()).toString());
                                inv.setItem(i, new ItemBuilder(Material.AIR).build());
                            }
                        }
                    }
                }
            }
        }
    }

}
