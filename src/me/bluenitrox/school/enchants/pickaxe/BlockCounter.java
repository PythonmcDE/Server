package me.bluenitrox.school.enchants.pickaxe;

import me.bluenitrox.school.enchants.EnchantAPI;
import me.bluenitrox.school.enchants.EnchantManager;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;

public class BlockCounter extends EnchantAPI {

    private ItemStack item;
    private ItemMeta itemMeta;
    private String blockcounter;

    /**
     * @param item Item in hand from player
     */
    public BlockCounter(ItemStack item) {
        this.item = item;
        this.itemMeta = item.getItemMeta();
        this.blockcounter = "§8» §7Blöcke: §e";
    }

    public void activateBlockCounter() {

        if(!hasEnchant(item, EnchantManager.BlockCounter)) return;

        List<String> lore = itemMeta.getLore();
        if(this.getBlocks() == 0) {
            lore.add(blockcounter + "1");
        } else {
            String oldblocks = String.valueOf(this.getBlocks());
            String newblocks = String.valueOf(this.getBlocks() + 1);
            lore.remove(blockcounter + oldblocks);
            lore.add(blockcounter + newblocks);
        }
        itemMeta.setLore(lore);
        item.setItemMeta(itemMeta);
    }


    /**
     * Select all Blocks from an item and check if this item have Blocks already
     * @return player blocks from Item (0 if no Lore is set)
     */
    private int getBlocks() {
        int i = 0;
        if(item.getItemMeta().getLore() != null) {
            for (String line : item.getItemMeta().getLore()) {
                if(line.startsWith(blockcounter)) {
                    String blocksline = line.replace(blockcounter, "");
                    i = Integer.parseInt(blocksline);
                }
            }
        }
        return i;
    }

}
