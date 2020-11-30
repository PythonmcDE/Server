package me.bluenitrox.school.commands;

import me.bluenitrox.school.features.KitAPI;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Kit implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender cs, Command cmd, String s, String[] args) {
        Player p = (Player)cs;
        if(!(cs instanceof Player)){
            cs.sendMessage("Dazu musst du ein Spieler sein!");
            return true;
        }
        if(args.length == 0){
            KitAPI api = new KitAPI();
            api.openKitMenu(p);
        }
        return false;
    }
}
