package me.bluenitrox.school.aufgabensystem;

import me.bluenitrox.school.listener.PlayerJoinListener;
import me.bluenitrox.school.managers.MessageManager;
import me.bluenitrox.school.managers.PlayerJoinManager;
import me.bluenitrox.school.utils.ItemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.lang.reflect.Member;

public class AufgabeCMD implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender cs, Command command, String s, String[] args) {

        if(!(cs instanceof Player)) return true;

        Player p = (Player)cs;
        //p.sendMessage(Aufgaben.getTask(p));
        p.openInventory(aufgabenInv(p));
        p.playSound(p.getLocation(), Sound.NOTE_STICKS, 1L, 1L);
        return false;
    }

    private Inventory aufgabenInv(Player player) {

        Inventory inventory = Bukkit.createInventory(null, 9*3, "§8» §8Aufgaben");
        ItemStack glass = new ItemBuilder(Material.STAINED_GLASS_PANE, (short) 15).setDisplayname(" ").build();
        ItemStack currentTask = new ItemBuilder(Material.PAPER).setDisplayname("§8» §6§lDeine Aufgabe:").setLore(Aufgaben.getTask(player)).build();

        for (int i = 0; i < inventory.getSize(); i++) {
            inventory.setItem(i, glass);
        }

        inventory.setItem(13, currentTask);
        return inventory;
    }

    public static void onClick(InventoryClickEvent event) {

        if(event.getClickedInventory() == null) return;
        if(!event.getClickedInventory().getName().equalsIgnoreCase("§8» §8Aufgaben")) return;
        if(event.getCurrentItem() == null) return;
        event.setCancelled(true);
    }
}
