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

public class Erhalt extends EnchantAPI {

    public static HashMap<Player, ArrayList<ItemStack>> items = new HashMap<>();

    private static ArrayList<ItemStack> itemStacks;

    public static void giveItem(Player owner){
        itemStacks = new ArrayList<>();
        for(int i = 0; i< owner.getInventory().getSize();i++) {
            Inventory inv = owner.getInventory();
            if (inv.getItem(i) != null) {
                if (inv.getItem(i).getItemMeta() != null) {
                    if (inv.getItem(i).getItemMeta().getLore() != null) {
                        if (hasEnchant(inv.getItem(i), EnchantManager.Erhalt)) {
                            if (makeOrNot80(stringToNumber(inv.getItem(i), EnchantManager.Erhalt))) {
                                itemStacks.add(inv.getItem(i));
                                inv.setItem(i, new ItemBuilder(Material.AIR).build());
                            }
                        }
                    }
                }
            }
        }
        items.put(owner,itemStacks);
    }

}
