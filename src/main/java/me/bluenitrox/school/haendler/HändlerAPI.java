package me.bluenitrox.school.haendler;

import me.bluenitrox.school.crafting.WerkbankGUIRegister;
import me.bluenitrox.school.haendler.commands.Koch;
import me.bluenitrox.school.haendler.commands.Schmied;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class HändlerAPI implements CommandExecutor {


    @Override
    public boolean onCommand(CommandSender cs, Command cmd, String s, String[] args) {
        Player p = (Player)cs;

        if(args.length == 1){
            if(args[0].equalsIgnoreCase("schmied")){
                Schmied.onCommand(cs,cmd,s,args);
            }else if(args[0].equalsIgnoreCase("koch")){
                Koch.onCommand(cs,cmd,s,args);
            }else if(args[0].equalsIgnoreCase("test")){
                WerkbankGUIRegister wgr = new WerkbankGUIRegister();
                p.openInventory(wgr.runeEins());
            }
        }

        return false;
    }
}
