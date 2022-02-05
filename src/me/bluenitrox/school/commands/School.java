package me.bluenitrox.school.commands;

import me.bluenitrox.school.managers.MessageManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class School implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {
        Player p = (Player) commandSender;
        if(!(commandSender instanceof Player)) {
            return true;
        }
        p.sendMessage("§b» §7Hier kannst du dein Level sehen");
        p.sendMessage("§b» §7und siehst zusätzlich wie viele Xp für ein Level-Up fehlen.");
        p.sendMessage("§b» §7Auch siehst du dein Prestige Level, wobei dein Level eine andere Farbe erhält,");
        p.sendMessage("§b» §7und du ein neues Dungeon freischaltest.");
        p.sendMessage("§b» §7Du kannst dich mit dem Befehl /prestige prestigen,");
        p.sendMessage("§b» §7dabei wird dein Level auf 1 zurückgesetzt.");
        return false;
    }
}
