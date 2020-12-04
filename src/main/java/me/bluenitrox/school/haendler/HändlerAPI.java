package me.bluenitrox.school.haendler;

import me.bluenitrox.school.crafting.WerkbankGUIRegister;
import me.bluenitrox.school.haendler.commands.Abenteurer;
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
        WerkbankGUIRegister wgr = new WerkbankGUIRegister();

        if(args.length == 1){
            if(args[0].equalsIgnoreCase("schmied")){
                Schmied.onCommand(cs,cmd,s,args);
            }else if(args[0].equalsIgnoreCase("koch")){
                Koch.onCommand(cs,cmd,s,args);
            }else if(args[0].equalsIgnoreCase("abenteurer")){
                Abenteurer.onCommand(cs,cmd,s,args);
            }else if(args[0].equalsIgnoreCase("test")){
                p.openInventory(wgr.runeEins());
            }else if(args[0].equalsIgnoreCase("test1")){
                p.openInventory(wgr.runeZwei());
            }else if(args[0].equalsIgnoreCase("test2")){
                p.openInventory(wgr.runeDrei());
            }else if(args[0].equalsIgnoreCase("test3")){
                p.openInventory(wgr.runeVier());
            }else if(args[0].equalsIgnoreCase("test4")){
                p.openInventory(wgr.runeFünf());
            }else if(args[0].equalsIgnoreCase("test5")){
                p.openInventory(wgr.runeSechs());
            }else if(args[0].equalsIgnoreCase("test6")){
                p.openInventory(wgr.runeSieben());
            }else if(args[0].equalsIgnoreCase("test7")){
                p.openInventory(wgr.runeAcht());
            }else if(args[0].equalsIgnoreCase("test8")){
                p.openInventory(wgr.runeNeun());
            }else if(args[0].equalsIgnoreCase("test9")){
                p.openInventory(wgr.runeZehn());
            }
        }

        return false;
    }
}
