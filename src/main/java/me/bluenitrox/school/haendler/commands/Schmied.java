package me.bluenitrox.school.haendler.commands;

import me.bluenitrox.school.managers.MessageManager;
import me.bluenitrox.school.managers.MoneyManager;
import me.bluenitrox.school.managers.PlayerJoinManager;
import me.bluenitrox.school.utils.ItemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class Schmied {

    public static String GUI_NAME = "§7§lSchmied";

    public static void onCommand(CommandSender cs, Command cmd, String s, String[] args) {
        Player p = (Player)cs;
        if(cs == null){
            cs.sendMessage(MessageManager.NOPLAYER);
            return;
        }
        Inventory inv = Bukkit.createInventory(null, 9*6, GUI_NAME);


        ItemStack glas = new ItemBuilder(Material.STAINED_GLASS_PANE).setDisplayname(" ").build();
        ItemStack glasblack = new ItemBuilder(Material.STAINED_GLASS_PANE, (short) 15).setDisplayname(" ").build();
        ItemStack sign = new ItemBuilder(Material.SIGN).setDisplayname("§8» §6§lItems reparieren").setLore("§6§l▶ §7Dein Item ist §cbeschädigt§7?", "§6§l▶ §7Kein Problem, §frepariere §7es hier beim §9§lSchmied","§6§l▶ §7für einen geringen Gem-Betrag.").build();
        ItemStack barrier = new ItemBuilder(Material.BARRIER).setDisplayname("§8» §cNicht möglich!").setLore("§6§l▶ §7Entweder liegt kein Item auf dem freien Slot,","§6§l▶ §7oder dieses Item kann repariert werden").build();
        ItemStack dye = new ItemBuilder(Material.INK_SACK, (short)10).setDisplayname("§8» §aKlicke hier, zum Reparieren!").setLore("§6§l▶ §7Kosten: §615 Tsd Gems").build();

        for(int i = 0; i<= 8; i++){
            inv.setItem(i, glas);
        }
        for(int i = 9; i<=21; i++){
            inv.setItem(i, glasblack);
        }
        for(int i = 23; i<= 35; i++){
            inv.setItem(i, glasblack);
        }
        for(int i = 36; i<= 44; i++){
            inv.setItem(i, glas);
        }
        for(int i = 45; i<= 53; i++){
            inv.setItem(i, glasblack);
        }

        inv.setItem(49,sign);
        inv.setItem(25,barrier);
        inv.setItem(53,dye);

        p.openInventory(inv);

        return;
    }

    public static void onClickSchmied(InventoryClickEvent e){
        Player p = (Player) e.getWhoClicked();
        if(e.getClickedInventory().getName().equals(GUI_NAME) && e.getCurrentItem() != null){
            if(e.getCurrentItem().getType() == Material.STAINED_GLASS_PANE || e.getCurrentItem().getType() == Material.BARRIER || e.getCurrentItem().getType() == Material.SIGN){
                e.setCancelled(true);
            }
            if(e.getCurrentItem().getType() == Material.INK_SACK){
                e.setCancelled(true);
                if(MoneyManager.getMoney(p.getUniqueId()) >= 15000) {
                    if (e.getClickedInventory().getItem(22) != null) {
                        if (e.getClickedInventory().getItem(22).getDurability() != 0) {

                            MoneyManager.updateMoney(p.getUniqueId(), 15000, true, false);
                            e.getClickedInventory().getItem(22).setDurability((short) 0);


                            p.getInventory().addItem(e.getClickedInventory().getItem(22));

                            ItemStack air = new ItemStack(Material.AIR);
                            e.getClickedInventory().setItem(22, air);

                            p.closeInventory();
                            p.playSound(p.getLocation(), Sound.ANVIL_USE, 1L , 1L);
                            return;
                        }
                    }
                }else {
                    p.sendMessage(MessageManager.NOTMONEY(PlayerJoinManager.language));
                    p.closeInventory();
                    p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1L,1L);
                }
            }
        }
    }

}
