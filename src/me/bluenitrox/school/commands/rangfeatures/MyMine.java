package me.bluenitrox.school.commands.rangfeatures;

import me.bluenitrox.school.dungeon.manager.DungeonManager;
import me.bluenitrox.school.managers.LocationManager;
import me.bluenitrox.school.managers.MessageManager;
import me.bluenitrox.school.managers.PermissionsManager;
import me.bluenitrox.school.managers.PlayerJoinManager;
import me.bluenitrox.school.mine.angelmine.AngelminenManager;
import me.bluenitrox.school.mine.manager.MinenManager;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class MyMine implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {


        if(!(sender instanceof Player)) return true;
        Player player = (Player) sender;
        if(!player.hasPermission(PermissionsManager.kingqueen)) {
            player.sendMessage(MessageManager.NOPERMISSIONS(PlayerJoinManager.language));
            return true;
        }

        int mine = MinenManager.getMine(player.getUniqueId());
        Location location = new LocationManager("mine" + mine).getLocation();

        player.teleport(location);
        player.sendMessage(MessageManager.PREFIX + "§7Du hast dich zu deiner §6§lbesten Mine §7teleportiert.");

        DungeonManager dm = new DungeonManager();
        dm.onQuitDungeon(player);
        AngelminenManager.quitAngelmine(player);

        return false;
    }
}
