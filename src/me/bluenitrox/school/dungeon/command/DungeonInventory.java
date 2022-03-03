package me.bluenitrox.school.dungeon.command;

import me.bluenitrox.school.dungeon.manager.DungeonManager;
import me.bluenitrox.school.managers.ExpManager;
import me.bluenitrox.school.managers.LocationManager;
import me.bluenitrox.school.managers.MessageManager;
import me.bluenitrox.school.mine.angelmine.AngelminenManager;
import me.bluenitrox.school.utils.ItemBuilder;
import me.bluenitrox.school.warzone.CombatAPI;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class DungeonInventory implements CommandExecutor {

    private static String GUI_NAME = "§6§lDungeons";

    /*
    dungeon1spawn
    dungeon2spawn
    dungeon3spawn
    Dungeonspawn

    spawn1dungeon1
    spawn2dungeon1

    spawn1dungeon2
    spawn2dungeon3
    usw.



     */

    @Override
    public boolean onCommand(CommandSender cs, Command command, String s, String[] args) {
        Player p = (Player)cs;
        if(CombatAPI.fight != null) {
            if (CombatAPI.fight.containsKey(p)) {
                p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1L, 1L);
                p.sendMessage(MessageManager.CANTDOINFIGHT);
                return true;
            }
        }
        if(args.length == 0){
            Inventory inv = Bukkit.createInventory(null, 9*5, GUI_NAME);

            ItemStack glas = new ItemBuilder(Material.STAINED_GLASS_PANE).setDisplayname(" ").build();
            ItemStack sword = new ItemBuilder(Material.IRON_SWORD).setDisplayname("§6§lDungeons").setLore("§6§l▶ §7In den §6Dungeons §7kannst du", "§6§l▶ §7Monster töten um §6XP§7,§6Gems §7und", "§6§l▶ §6spezielle Items §7zu bekommen.").build();

            ItemStack dungeon1 = new ItemBuilder(Material.BONE).setDisplayname("§c§lDungeon 1").setLore("§6§l▶ §7Klicke, um dich in dieses Dungeon zu teleportieren.").build();
            ItemStack dungeon2 = new ItemBuilder(Material.ROTTEN_FLESH).setDisplayname("§c§lDungeon 2").setLore("§6§l▶ §7Klicke, um dich in dieses Dungeon zu teleportieren.").build();
            ItemStack dungeon3 = new ItemBuilder(Material.SPIDER_EYE).setDisplayname("§c§lDungeon 3").setLore("§6§l▶ §7Klicke, um dich in dieses Dungeon zu teleportieren.").build();

            ItemStack barrier = new ItemBuilder(Material.BARRIER).setDisplayname("§c§lDungeon 2").setLore("§6§l▶ §7Dieses Dungeon hast du nicht freigeschalten.").build();
            ItemStack barrier1 = new ItemBuilder(Material.BARRIER).setDisplayname("§c§lDungeon 3").setLore("§6§l▶ §7Dieses Dungeon hast du nicht freigeschalten.").build();

            for(int i = 0; i <= 8; i++){
                inv.setItem(i, glas);
            }
            for(int i = 36; i <= 44; i++){
                inv.setItem(i, glas);
            }
            inv.setItem(4, sword);

            if(ExpManager.getPrestige(p.getUniqueId()) >= 0){
                inv.setItem(9,dungeon1);
            }
            if(ExpManager.getPrestige(p.getUniqueId()) >= 1){
                inv.setItem(10,dungeon2);
            }else {
                inv.setItem(10, barrier);
            }
            if(ExpManager.getPrestige(p.getUniqueId()) >= 2){
                inv.setItem(11,dungeon3);
            }else {
                inv.setItem(11, barrier1);
            }

            p.openInventory(inv);
        }
        return false;
    }

    public static void onClick(final InventoryClickEvent e){
        Player p = (Player)e.getWhoClicked();
        if(e.getClickedInventory().getName().equalsIgnoreCase(GUI_NAME)){
            if(e.getCurrentItem() != null){
                e.setCancelled(true);
                if(e.getCurrentItem().getType() == Material.BONE){
                    if(new LocationManager("dungeon1spawn").getLocation() != null) {
                        p.teleport(new LocationManager("dungeon1spawn").getLocation());
                        DungeonManager.startMonsterSpawn(1, p);
                        AngelminenManager.quitAngelmine(p);
                    }
                    p.sendMessage(MessageManager.PREFIX + "§7Du wurdest in §6Dungeon 1 §7teleportiert.");
                    p.playSound(p.getLocation(), Sound.NOTE_PLING, 1L, 1L);
                }else if(e.getCurrentItem().getType() == Material.ROTTEN_FLESH){
                    if(new LocationManager("dungeon2spawn").getLocation() != null) {
                        p.teleport(new LocationManager("dungeon2spawn").getLocation());
                        DungeonManager.startMonsterSpawn(2, p);
                        AngelminenManager.quitAngelmine(p);
                    }
                    p.sendMessage(MessageManager.PREFIX + "§7Du wurdest in §6Dungeon 2 §7teleportiert.");
                    p.playSound(p.getLocation(), Sound.NOTE_PLING, 1L, 1L);
                }else if(e.getCurrentItem().getType() == Material.SPIDER_EYE){
                    if(new LocationManager("dungeon3spawn").getLocation() != null) {
                        p.teleport(new LocationManager("dungeon3spawn").getLocation());
                        DungeonManager.startMonsterSpawn(3, p);
                        AngelminenManager.quitAngelmine(p);
                    }
                    p.sendMessage(MessageManager.PREFIX + "§7Du wurdest in §6Dungeon 3 §7teleportiert.");
                    p.playSound(p.getLocation(), Sound.NOTE_PLING, 1L, 1L);
                }
            }
        }
    }

}
