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
        p.sendMessage(MessageManager.PREFIX + "§7Das §6§lXp System");
        p.sendMessage("§b» §7Hier siehst du dein §6Level§7, dein §6Prestige Level §7und deine §6benötigten Xp §7für ein Level-UP.");
        p.sendMessage("§b» §7Du kannst dich mit §6/prestige §7prestigen, dabei wirst du auf Level 1 zurückgesetzt.");
        p.sendMessage("§b» §7Damit schaltest du ein §6neues Dungeon §7frei und deine §6Level Farbe §7ändern sich.");
        return false;
    }
}
