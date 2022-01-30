package me.bluenitrox.school.commands;

import me.bluenitrox.school.SchoolMode;
import me.bluenitrox.school.managers.KopfgeldManager;
import me.bluenitrox.school.managers.MessageManager;
import me.bluenitrox.school.managers.MoneyManager;
import me.bluenitrox.school.managers.PlayerJoinManager;
import me.bluenitrox.school.utils.ItemBuilder;
import me.bluenitrox.school.utils.KopfUtil;
import org.apache.logging.log4j.message.Message;
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
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class Kopfgeld implements CommandExecutor {

    private String gui_name = "§6§lKopfgeld";

    @Override
    public boolean onCommand(CommandSender cs, Command cmd, String s, String[] args) {
        if(!(cs instanceof Player)){
            cs.sendMessage(MessageManager.NOPLAYER);
            return true;
        }
        Player player = (Player)cs;
        if(args.length == 0){
            player.sendMessage(MessageManager.PREFIX + "§7Verwende: §6/kopfgeld <Spielername> <Höhe>");
            player.playSound(player.getLocation(), Sound.VILLAGER_NO, 1L, 1L);
        }else if(args.length == 2){
            Player target = Bukkit.getPlayer(args[0]);
            if(target.isOnline()){
                if(SchoolMode.playerkopfgeld.containsKey(target.getUniqueId())){
                    player.sendMessage(MessageManager.PREFIX + "§7Dieser Spieler hat bereits ein Kopfgeld!");
                    player.playSound(player.getLocation(), Sound.VILLAGER_NO, 1L, 1L);
                    return true;
                }
                if(Integer.parseInt(args[1]) >= 1000){
                    if(MoneyManager.getMoney(player.getUniqueId()) >= Integer.parseInt(args[1])) {
                        KopfgeldManager.setKopfgeld(Bukkit.getPlayer(args[0]).getUniqueId(), Integer.parseInt(args[1]), player);
                    }else {
                        player.sendMessage(MessageManager.NOTMONEY(PlayerJoinManager.language));
                        player.playSound(player.getLocation(), Sound.VILLAGER_NO, 1L, 1L);
                    }
                }else {
                    player.sendMessage(MessageManager.PREFIX + "§7Der kleinst mögliche Betrag liegt bei 1000.");
                    player.playSound(player.getLocation(), Sound.VILLAGER_NO, 1L, 1L);
                }
            }else {
                player.sendMessage(MessageManager.PLAYERISOFFLINE(PlayerJoinManager.language));
                player.playSound(player.getLocation(), Sound.VILLAGER_NO, 1L, 1L);
            }
        }else if(args.length == 1){
            if(args[0].equalsIgnoreCase("show")){
                inventory(player);
            }
        }
        return false;
    }

    private void inventory(Player player){
        Inventory inv = Bukkit.createInventory(null, 9*6, gui_name);

        ItemStack glas = new ItemBuilder(Material.STAINED_GLASS_PANE).setDisplayname("").build();

        for(int i = 0; i<= 8; i++){
            inv.setItem(i, glas);
        }
        for(int j = 45; j<= 53; j++){
            inv.setItem(j, glas);
        }

        int slot = 9;

            for(Map.Entry<UUID, Integer> entry : SchoolMode.playerkopfgeld.entrySet()) {
                UUID key = entry.getKey();
                Integer value = entry.getValue();
                ItemStack item = KopfUtil.createSkull(Bukkit.getPlayer(key).getName(), "§6" + Bukkit.getPlayer(key).getDisplayName());
                ItemMeta im = item.getItemMeta();
                im.setLore(Arrays.asList("§7» §6Kopfgeld: §a" + value));
                item.setItemMeta(im);
                inv.setItem(slot, item);
                slot++;
            }

        player.openInventory(inv);
    }

    public void onClick(InventoryClickEvent e){
        if(e.getClickedInventory() != null) {
            if (e.getClickedInventory().getName().equalsIgnoreCase(gui_name)) {
                if (e.getCurrentItem() != null) {
                    e.setCancelled(true);
                }
            }
        }
    }

}
