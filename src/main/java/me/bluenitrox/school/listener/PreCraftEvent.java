package me.bluenitrox.school.listener;

import me.bluenitrox.school.managers.MessageManager;
import me.bluenitrox.school.managers.PlayerJoinManager;
import org.bukkit.Material;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.PrepareItemCraftEvent;
import org.bukkit.inventory.ItemStack;

public class PreCraftEvent implements Listener {

    @EventHandler
    public void onCraftItem(PrepareItemCraftEvent e) {
        Material itemType = e.getRecipe().getResult().getType();
        if (itemType == Material.FISHING_ROD) {
            e.getInventory().setResult(new ItemStack(Material.AIR));
            for(HumanEntity he:e.getViewers()) {
                if(he instanceof Player) {
                    he.closeInventory();
                    he.sendMessage(MessageManager.CANTCRAFTTHIS(PlayerJoinManager.language));
                }
            }
        }

        Material itemType1 = e.getRecipe().getResult().getType();
        if (itemType1 == Material.MELON_BLOCK) {
            e.getInventory().setResult(new ItemStack(Material.AIR));
            for(HumanEntity he:e.getViewers()) {
                if(he instanceof Player) {
                    he.closeInventory();
                    he.sendMessage(MessageManager.CANTCRAFTTHIS(PlayerJoinManager.language));
                }
            }
        }

        Material itemType14621 = e.getRecipe().getResult().getType();
        if (itemType14621 == Material.FIREBALL) {
            e.getInventory().setResult(new ItemStack(Material.AIR));
            for(HumanEntity he:e.getViewers()) {
                if(he instanceof Player) {
                    he.closeInventory();
                    he.sendMessage(MessageManager.CANTCRAFTTHIS(PlayerJoinManager.language));
                }
            }
        }

        Material itemType13 = e.getRecipe().getResult().getType();
        if (itemType13 == Material.ARMOR_STAND) {
            e.getInventory().setResult(new ItemStack(Material.AIR));
            for(HumanEntity he:e.getViewers()) {
                if(he instanceof Player) {
                    he.closeInventory();
                    he.sendMessage(MessageManager.CANTCRAFTTHIS(PlayerJoinManager.language));
                }
            }
        }

        Material itemType134 = e.getRecipe().getResult().getType();
        if (itemType134 == Material.HOPPER_MINECART) {
            e.getInventory().setResult(new ItemStack(Material.AIR));
            for(HumanEntity he:e.getViewers()) {
                if(he instanceof Player) {
                    he.closeInventory();
                    he.sendMessage(MessageManager.CANTCRAFTTHIS(PlayerJoinManager.language));
                }
            }
        }

        Material itemType14 = e.getRecipe().getResult().getType();
        if (itemType14 == Material.EXPLOSIVE_MINECART) {
            e.getInventory().setResult(new ItemStack(Material.AIR));
            for (HumanEntity he : e.getViewers()) {
                if (he instanceof Player) {
                    he.closeInventory();
                    he.sendMessage(MessageManager.CANTCRAFTTHIS(PlayerJoinManager.language));
                }
            }
        }

        Material itemType1462 = e.getRecipe().getResult().getType();
        if (itemType1462 == Material.FLINT_AND_STEEL) {
            e.getInventory().setResult(new ItemStack(Material.AIR));
            for(HumanEntity he:e.getViewers()) {
                if(he instanceof Player) {
                    he.closeInventory();
                    he.sendMessage(MessageManager.CANTCRAFTTHIS(PlayerJoinManager.language));
                }
            }
        }

        Material itemType12222 = e.getRecipe().getResult().getType();
        if (itemType12222 == Material.GOLDEN_APPLE && e.getRecipe().getResult().getDurability() == 1) {
            e.getInventory().setResult(new ItemStack(Material.AIR));
            for(HumanEntity he:e.getViewers()) {
                if(he instanceof Player) {
                    he.closeInventory();
                    he.sendMessage(MessageManager.CANTCRAFTTHIS(PlayerJoinManager.language));
                }
            }
        }

    }

}
