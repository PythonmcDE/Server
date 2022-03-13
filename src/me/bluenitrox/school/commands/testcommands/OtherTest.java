package me.bluenitrox.school.commands.testcommands;

import me.bluenitrox.school.enchants.EnchantManager;
import me.bluenitrox.school.seasonpass.SeasonpassManager;
import me.bluenitrox.school.utils.ItemBuilder;
import me.bluenitrox.school.utils.NBTTags;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class OtherTest implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender cs, Command command, String s, String[] strings) {
        SeasonpassManager seasonpassManager = new SeasonpassManager();
        Player player = (Player)cs;
        seasonpassManager.addXP(player.getUniqueId(), 50);
        return false;
    }
}
