package me.bluenitrox.school.haendler.npc;

import me.bluenitrox.school.commands.Mine;
import me.bluenitrox.school.dungeon.manager.DungeonManager;
import me.bluenitrox.school.features.dailyreward.DailyReward;
import me.bluenitrox.school.haendler.commands.*;
import me.bluenitrox.school.managers.LocationManager;
import me.bluenitrox.school.mine.angelmine.Angelmine;
import me.bluenitrox.school.mine.angelmine.AngelminenManager;
import me.bluenitrox.school.seasonpass.SeasonpassInventorys;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class NpcCommandConsole implements CommandExecutor {


    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {

        if(!command.getName().equalsIgnoreCase("haendlerconsole")) return true;
        if(!(sender instanceof ConsoleCommandSender)) return true;

        /*
        0 = playername
        1 = type
         */
        System.out.println(args[0]);
        Player player = Bukkit.getPlayer(args[0]);
        if(player == null) return true;

        if(args.length != 2) return true;

        switch (args[1]) {
            case "abenteurer":
                Abenteurer.onCommand(player);
                break;
            case "bauarbeiter":
                Bauarbeiter.onCommand(player);
                break;
            case "bergmann":
                Bergmann.onCommand(player);
                break;
            case "förster":
                Förster.onCommand(player);
                break;
            case "gärtner":
                Gärtner.onCommand(player);
                break;
            case "jäger":
                Jäger.onInteract(player);
                break;
            case "koch":
                Koch.onCommand(player);
                break;
            case "künstlerin":
                Künstlerin.onCommand(player);
                break;
            case "landwirt":
                Landwirt.onCommand(player);
                break;
            case "magier":
                Magier.onCommand(player);
                break;
            case "schmied":
                Schmied.onCommand(player);
                break;
            case "taxi":
                Taxi.onInteract(player);
                break;
            case "techniker":
                Techniker.onCommand(player);
                break;
            case "dailyreward":
                DailyReward dailyReward = new DailyReward();
                dailyReward.onOpeninv(player);
                break;
            case "mine":
                Inventory inv = Bukkit.createInventory(null, 9*6, Mine.guiname);
                Mine.setMinenContent(inv, player.getUniqueId());
                player.openInventory(inv);
                break;
            case "angelmine":
                Inventory inv2 = Bukkit.createInventory(null, 9*6, Angelmine.guiname);
                Angelmine.setInventoryContent(inv2, player);
                player.openInventory(inv2);
                break;
            case "dungeon":
                player.teleport(new LocationManager("Dungeonspawn").getLocation());
                DungeonManager dm = new DungeonManager();
                dm.onJoinDungeon(player);
                AngelminenManager.quitAngelmine(player);
                break;
            case "seasonpass":
                SeasonpassInventorys inventorys = new SeasonpassInventorys(player);
                player.openInventory(inventorys.normalPage());
                break;
        }

        return false;
    }
}
