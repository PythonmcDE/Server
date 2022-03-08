package me.bluenitrox.school.enchants.sword;

import me.bluenitrox.school.enchants.function.EnchantAPI;
import me.bluenitrox.school.enchants.function.EnchantManager;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;

public class MobCounter extends EnchantAPI {

    private ItemStack item;
    private ItemMeta itemMeta;
    private String mobCounter;

    /**
     * @param item Item in hand from player
     */
    public MobCounter(ItemStack item) {
        this.item = item;
        this.itemMeta = item.getItemMeta();
        this.mobCounter = "§8» §7Mob-Kills: §e";
    }

    public void activateMobCounter() {

        if(!hasEnchant(item, EnchantManager.Mob_Counter)) return;

        List<String> lore = itemMeta.getLore();
        if(this.getMobKills() == 0) {
            lore.add(mobCounter + "1");
        } else {
            String kills = String.valueOf(this.getMobKills());
            String newKills = String.valueOf(this.getMobKills() + 1);
            lore.remove(mobCounter + kills);
            lore.add(mobCounter + newKills);
        }
        itemMeta.setLore(lore);
        item.setItemMeta(itemMeta);
    }


    /**
     * Select all Mob-Kills from an item or check if this item already have Mob-Kills
     * @return player Mob-Kills from Item (0 if no Lore is set)
     */
    private int getMobKills() {
        int i = 0;
        if(item.getItemMeta().getLore() != null) {
            for (String line : item.getItemMeta().getLore()) {
                if(line.startsWith(mobCounter)) {
                    String mobKillsLine = line.replace(mobCounter, "");
                    i = Integer.parseInt(mobKillsLine);
                }
            }
        }
        return i;
    }

}
