package me.bluenitrox.school.commands;

import me.bluenitrox.school.managers.MessageManager;
import me.bluenitrox.school.managers.PlayerJoinManager;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class Mülleimer implements CommandExecutor {
    private String GUI_NAME = "§8§lMülleimer";
    @Override
    public boolean onCommand(CommandSender cs, Command command, String s, String[] args) {
        Player p = (Player)cs;
        if(args.length == 0){
            Inventory inv = Bukkit.createInventory(null, 9*4, GUI_NAME);

            p.openInventory(inv);
            p.sendMessage(MessageManager.PREFIX + "§7Lege alles was du nichtmehr willst in das Inventar und schließe es anschließend.");
        }else{
            p.sendMessage(MessageManager.FALSECOMMAND(PlayerJoinManager.language));
            return true;
        }
        return false;
    }
}
