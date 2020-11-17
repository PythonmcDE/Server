package me.bluenitrox.school.commands;

import me.bluenitrox.school.cases.CaseAPI;
import me.bluenitrox.school.cases.CaseItems;
import me.bluenitrox.school.utils.Antidupe;
import me.bluenitrox.school.utils.NBTTags;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class OtherTest implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender cs, Command command, String s, String[] strings) {
        Player p = (Player)cs;
        CaseAPI caseapi = new CaseAPI();
        caseapi.openCase(p,0);
        return false;
    }
}
