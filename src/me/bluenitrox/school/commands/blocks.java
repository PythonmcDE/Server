package me.bluenitrox.school.commands;

import me.bluenitrox.school.managers.MessageManager;
import me.bluenitrox.school.managers.PermissionsManager;
import me.bluenitrox.school.managers.PlayerJoinManager;
import me.bluenitrox.school.utils.ItemBuilder;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class blocks implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {

        if(!(sender instanceof Player)) return true;
        Player player = (Player) sender;

        if(!player.hasPermission(PermissionsManager.kingqueen)) {
            MessageManager.NOPERMISSIONS(PlayerJoinManager.language);
            return true;
        }

        if(this.hasEnoughMaterials(player)) {
            player.sendMessage(MessageManager.PREFIX + "§7Du hast keine §6§lMaterialien §7zum zusammencraften.");
            return true;
        }





        return false;
    }

    private int hasItem(Material item, Player p) {
        int amountitems = 0;
        for (int i = 0; i < p.getInventory().getSize(); i++) {
            if (p.getInventory().getItem(i) != null) {
                if (p.getInventory().getItem(i).getType() == item) {
                    amountitems += p.getInventory().getItem(i).getAmount();
                }
            }
        }
        return amountitems;
    }

    private int hasItem(ItemStack item, Player p) {
        int amountitems = 0;
        for (int i = 0; i < p.getInventory().getSize(); i++) {
            if (p.getInventory().getItem(i) != null) {
                if (p.getInventory().getItem(i) == item) {
                    amountitems += p.getInventory().getItem(i).getAmount();
                }
            }
        }
        return amountitems;
    }

    private void removeItem(Material item, Player p, Integer amount){
        for(int i = 0; i< p.getInventory().getSize(); i++){
            if(p.getInventory().getItem(i)!= null) {
                if (p.getInventory().getItem(i).getType() == item) {
                    if (amount >= p.getInventory().getItem(i).getAmount()) {
                        amount -= p.getInventory().getItem(i).getMaxStackSize();
                        p.getInventory().setItem(i, new ItemBuilder(Material.AIR).build());
                    } else {
                        p.getInventory().getItem(i).setAmount(p.getInventory().getItem(i).getAmount() - amount);
                        amount = 0;
                    }
                }
            }
        }
    }

    private void removeItem(ItemStack item, Player p, Integer amount){
        for(int i = 0; i< p.getInventory().getSize(); i++){
            if(p.getInventory().getItem(i)!= null) {
                if (p.getInventory().getItem(i) == item) {
                    if (amount >= p.getInventory().getItem(i).getAmount()) {
                        amount -= p.getInventory().getItem(i).getMaxStackSize();
                        p.getInventory().setItem(i, new ItemBuilder(Material.AIR).build());
                    } else {
                        p.getInventory().getItem(i).setAmount(p.getInventory().getItem(i).getAmount() - amount);
                        amount = 0;
                    }
                }
            }
        }
    }

    private boolean hasEnoughMaterials(Player player) {
        boolean a = false;
        if(this.hasItem(Material.COAL, player) <= 9
                || this.hasItem(Material.IRON_INGOT, player) <= 9
                || this.hasItem(Material.QUARTZ, player) <= 9
                || this.hasItem(Material.REDSTONE, player) <= 9
                || this.hasItem(Material.GOLD_INGOT, player) <= 9
                || this.hasItem(Material.DIAMOND, player) <= 9
                || this.hasItem(Material.EMERALD, player) <= 9
                || this.hasItem(new ItemStack(Material.INK_SACK, (short) 4), player) <= 9
        ) {
            a = true;

        }
        return a;
    }

    private void craftItems(Player player) {

    }
}
