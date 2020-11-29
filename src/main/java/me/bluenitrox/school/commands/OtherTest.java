package me.bluenitrox.school.commands;

import me.bluenitrox.school.features.CaseAPI;
import me.bluenitrox.school.features.Pet;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

public class OtherTest implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender cs, Command command, String s, String[] strings) {
        Player p = (Player)cs;
        new Pet().createPet(p, EntityType.IRON_GOLEM);
        return false;
    }
}
