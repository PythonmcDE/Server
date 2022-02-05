package me.bluenitrox.school.aufgabensystem;

import me.bluenitrox.school.managers.MessageManager;
import me.bluenitrox.school.managers.PlayerJoinManager;
import me.bluenitrox.school.utils.ItemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.UUID;

public class AufgabenCMD implements CommandExecutor {


    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {
        Player player = (Player) commandSender;
        UUID uuid = player.getUniqueId();
        String guiname = "";

        if(!(commandSender instanceof Player)) {
            return true;
        }

        switch (args.length) {

            case 0:
                Inventory inv = Bukkit.createInventory(null, 9*6, guiname);
                setInventoryContent(inv, player);
                break;
            default:
                player.sendMessage(MessageManager.FALSECOMMAND(PlayerJoinManager.language));

        }

        return false;
    }

    private void setInventoryContent(Inventory inv, Player player) {

        ItemStack glas = new ItemBuilder(Material.STAINED_GLASS_PANE).setDisplayname(" ").build();
        player.openInventory(inv);

    }
}
