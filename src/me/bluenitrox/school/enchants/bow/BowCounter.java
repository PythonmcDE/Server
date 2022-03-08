package me.bluenitrox.school.enchants.bow;

import me.bluenitrox.school.enchants.function.EnchantAPI;
import me.bluenitrox.school.enchants.function.EnchantManager;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;

public class BowCounter extends EnchantAPI {

    private ItemStack item;
    private ItemMeta itemMeta;
    private String killcounter;

    /**
     * @param item Item in hand from player
     */
    public BowCounter(ItemStack item) {
        this.item = item;
        this.itemMeta = item.getItemMeta();
        this.killcounter = "§8» §7Kills: §e";
    }

    public void activateKillCounter() {

        if(!hasEnchant(item, EnchantManager.BowCounter)) return;

        List<String> lore = itemMeta.getLore();
        if(this.getKills() == 0) {
            lore.add(killcounter + "1");
        } else {
            String kills = String.valueOf(this.getKills());
            String newKills = String.valueOf(this.getKills() + 1);
            lore.remove(killcounter + kills);
            lore.add(killcounter + newKills);
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
                if(line.startsWith(killcounter)) {
                    String killsLine = line.replace(killcounter, "");
                    i = Integer.parseInt(killsLine);
                }
            }
        }
        return i;
    }

}
