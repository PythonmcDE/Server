package me.bluenitrox.school.listener;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemDamageEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.LinkedList;
import java.util.List;

public class ItemDmg implements Listener {

    @EventHandler
    public void onItemDamage(PlayerItemDamageEvent event) {

        Player player = event.getPlayer();

        if(!hasEnchant(player)) return;
        if(getRestDurability(player) == 0) return;

        event.setCancelled(true);
        this.setDura(player, event.getDamage());
    }

    private void setDura(Player player, int removedura) {

        ItemStack item = player.getItemInHand();
        ItemMeta meta = item.getItemMeta();

        List<String> lore = meta.getLore();
        List<String> newlore = new LinkedList<>();

        int maxDura = getMaxDurability(getEnchantLevelInt(getEnchantLevel(item)));
        int itemdura = getRestDurability(player) - removedura;

        newlore.add("§8» §7Haltbarkeit: §6§l" + itemdura + "§7/§6§l" + maxDura);
        newlore.addAll(lore);

        meta.setLore(newlore);
        item.setItemMeta(meta);
    }

    private boolean hasEnchant(Player player) {

        if(player.getItemInHand() == null) return false;
        if(player.getItemInHand().getItemMeta() == null) return false;
        if(player.getItemInHand().getItemMeta().getDisplayName() == null) return false;
        if(player.getItemInHand().getItemMeta().getLore() == null) return false;

        List<String> lore = player.getItemInHand().getItemMeta().getLore();

        for (String string : lore) {
            if(string.contains("Verhärtung")) {
                return true;
            }
        }

        return false;
    }

    private int getMaxDurability(int enchantlevel) {

        switch (enchantlevel) {
            case 10:
                return 200;
            case 9:
                return 180;
            case 8:
                return 160;
            case 7:
                return 140;
            case 6:
                return 120;
            case 5:
                return 100;
            case 4:
                return 80;
            case 3:
                return 60;
            case 2:
                return 40;
            default:
                return 20;
        }
    }

    private String getEnchantLevel(ItemStack item) {

        List<String> lore = item.getItemMeta().getLore();

        for(String s : lore) {
            if(s.contains("Verhärtung")) {
                return s.replace("§f§lVerhärtung ", "");
            }
        }
        return "";
    }

    private int getEnchantLevelInt(String enchant) {
        switch (enchant) {
            case "X":
                return 10;
            case "IX":
                return 9;
            case "VIII":
                return 8;
            case "VII":
                return 7;
            case "VI":
                return 6;
            case "V":
                return 5;
            case "IV":
                return 4;
            case "III":
                return 3;
            case "II":
                return 2;
            default:
                return 1;
        }
    }

    private int getRestDurability(Player player) {

        ItemStack item = player.getItemInHand();

        List<String> lore = item.getItemMeta().getLore();

        for (String s : lore) {

            if(s.contains("Haltbarkeit: ")) {
                String fi = s.replace("§8» §7Haltbarkeit: §6§l", "").replace("§7/§6§l" + getMaxDurability(getEnchantLevelInt(getEnchantLevel(item))), "");
                return Integer.parseInt(fi);
            }
        }
        return 0;
    }
}
