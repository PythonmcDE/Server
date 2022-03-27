package me.bluenitrox.school.listener;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemDamageEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.LinkedList;
import java.util.List;

public class ItemDmg implements Listener {

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onItemDamage(PlayerItemDamageEvent event) {

        Player player = event.getPlayer();

        Bukkit.broadcastMessage("0");
        if(!hasEnchant(event.getItem())) return;
        Bukkit.broadcastMessage("1");
        if(getRestDurability(event.getItem()) == 0) return;
        Bukkit.broadcastMessage("2");

        event.setCancelled(true);
        Bukkit.broadcastMessage("3");
        this.setDura(event.getItem(), event.getDamage());
        Bukkit.broadcastMessage("4");
    }

    private void setDura(ItemStack item, int removedura) {

        ItemMeta meta = item.getItemMeta();

        List<String> lore = meta.getLore();
        List<String> newlore = new LinkedList<>();

        int maxDura = getMaxDurability(getEnchantLevelInt(getEnchantLevel(item)));
        int itemdura = getRestDurability(item) - removedura;

        for(int i = 0; i < lore.size(); i++) {
            if(lore.get(i).contains("Bonus-Haltbarkeit")) {
                lore.remove(i);
            }
        }

        newlore.add("§8Bonus-Haltbarkeit: " + itemdura + "/" + maxDura);
        newlore.addAll(lore);

        meta.setLore(newlore);
        item.setItemMeta(meta);
    }

    private boolean hasEnchant(ItemStack item) {

        if(item == null) return false;
        if(item.getItemMeta() == null) return false;
        if(item.getItemMeta().getLore() == null) return false;

        List<String> lore = item.getItemMeta().getLore();

        for (String string : lore) {
            if(string.contains("Verhärtung")) {
                return true;
            }
        }

        return false;
    }

    public int getMaxDurability(int enchantlevel) {

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

    private int getRestDurability(ItemStack item) {

        List<String> lore = item.getItemMeta().getLore();

        for (String s : lore) {

            if(s.contains("Bonus-Haltbarkeit: ")) {
                String fi = s.replace("§8Bonus-Haltbarkeit: ", "").replace("/" + getMaxDurability(getEnchantLevelInt(getEnchantLevel(item))), "");
                return Integer.parseInt(fi);
            }
        }
        return 0;
    }
}
