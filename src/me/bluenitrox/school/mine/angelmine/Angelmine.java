package me.bluenitrox.school.mine.angelmine;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class Angelmine implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender cs, Command cmd, String s, String[] args) {
        /*
        Code following
         */
        Player p = (Player)cs;
        setInventoryContent(p.getInventory(), p);
        return false;
    }

    private void setInventoryContent(Inventory inv, Player p){

    }
}
