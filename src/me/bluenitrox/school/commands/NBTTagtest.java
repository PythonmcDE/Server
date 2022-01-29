package me.bluenitrox.school.commands;

import me.bluenitrox.school.dungeon.manager.DungeonManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class NBTTagtest implements CommandExecutor{

    @Override
    public boolean onCommand(CommandSender cs, Command cmd, String s, String[] args) {
        Player p = (Player)cs;
        DungeonManager dm = new DungeonManager();
        dm.shouldMonsterSpawn = true;
        dm.startMonsterSpawn();
        return false;
    }

}
