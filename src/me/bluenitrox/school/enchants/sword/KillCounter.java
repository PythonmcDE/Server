package me.bluenitrox.school.enchants.sword;

import me.bluenitrox.school.enchants.EnchantAPI;
import me.bluenitrox.school.enchants.EnchantManager;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;

public class KillCounter extends EnchantAPI {

    private ItemStack item;
    private ItemMeta itemMeta;
    private String killstracker;

    /**
     * @param item Item in hand from player
     */
    public KillCounter(ItemStack item) {
        this.item = item;
        this.itemMeta = item.getItemMeta();
        this.killstracker = "§8» §7Kills: §e";
    }

    public void activateKillTracker() {

        if(!hasEnchant(item, EnchantManager.KILL_COUNTER)) return;

        List<String> lore = itemMeta.getLore();
        if(this.getKills() == 0) {
            lore.add(killstracker + "1");
        } else {
            String kills = String.valueOf(this.getKills());
            String newKills = String.valueOf(this.getKills() + 1);
            lore.remove(killstracker + kills);
            lore.add(killstracker + newKills);
        }
        itemMeta.setLore(lore);
        item.setItemMeta(itemMeta);
    }


    /**
     * Select all Kills from an item and check if this item have kills already
     * @return player kills from Item (0 if no Lore is set)
     */
    private int getKills() {
        int i = 0;
        if(item.getItemMeta().getLore() != null) {
            for (String line : item.getItemMeta().getLore()) {
                if(line.startsWith(killstracker)) {
                    String killsLine = line.replace(killstracker, "");
                    i = Integer.parseInt(killsLine);
                }
            }
        }
        return i;
    }

}
