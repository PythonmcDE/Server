package me.bluenitrox.school.commands.hidedcommands;

import me.bluenitrox.school.managers.MessageManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class Plugin implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender cs, Command command, String s, String[] strings) {
        cs.sendMessage(MessageManager.PREFIX + "§7Plugin(s) auf diesem Server: §aPythonMCSchool");
        return false;
    }
}
