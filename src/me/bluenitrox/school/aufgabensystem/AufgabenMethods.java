package me.bluenitrox.school.aufgabensystem;

import de.Herbystar.TTA.TTA_Methods;
import me.bluenitrox.school.SchoolMode;
import me.bluenitrox.school.commands.Mine;
import me.bluenitrox.school.features.kit.KitAPI;
import me.bluenitrox.school.features.stats.StatsAPI;
import me.bluenitrox.school.managers.MessageManager;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.scheduler.BukkitRunnable;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;

public class AufgabenMethods {

    private static String nmsver;
    private static boolean useOldMethods = false;
    private static HashMap<Player, String> messageblock = new HashMap<>();
    StatsAPI statsAPI = new StatsAPI();

    public static void onTaskCommand(PlayerCommandPreprocessEvent event) {
        String msg = event.getMessage();

        if(msg.equalsIgnoreCase("/school") && AufgabenManager.getTask(event.getPlayer().getUniqueId()) == 1) {
            AufgabenManager.onComplete(event.getPlayer().getUniqueId(), 1);
        } else if(msg.equalsIgnoreCase("/xp") && AufgabenManager.getTask(event.getPlayer().getUniqueId()) == 2) {
            AufgabenManager.onComplete(event.getPlayer().getUniqueId(), 2);
        } else if(msg.equalsIgnoreCase("/seasonpass") && AufgabenManager.getTask(event.getPlayer().getUniqueId()) == 7) {
            AufgabenManager.onComplete(event.getPlayer().getUniqueId(), 7);
        } else if(msg.equalsIgnoreCase("/plotworld") && AufgabenManager.getTask(event.getPlayer().getUniqueId()) == 11) {
            AufgabenManager.onComplete(event.getPlayer().getUniqueId(), 11);
        } else if(msg.equalsIgnoreCase("/stats") && AufgabenManager.getTask(event.getPlayer().getUniqueId()) == 18) {
            AufgabenManager.onComplete(event.getPlayer().getUniqueId(), 18);
        }
    }

    public static void onCLick(InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked();
        if(AufgabenManager.getTask(player.getUniqueId())  == 3) {
            if (!KitAPI.holz.containsKey(player.getUniqueId())) {
                if(event.getClickedInventory() != null) {
                    if (event.getClickedInventory().getName().equalsIgnoreCase(KitAPI.guiname) && event.getCurrentItem() != null) {
                        if (event.getCurrentItem().getType() == Material.WOOD_SWORD) {
                            AufgabenManager.onComplete(player.getUniqueId(), 3);
                        }
                    }
                }
            }
        } else if(AufgabenManager.getTask(player.getUniqueId())== 4) {
            if(event.getClickedInventory() == null) return;
            if(event.getClickedInventory().getName().equalsIgnoreCase(Mine.guiname) && event.getCurrentItem() != null) {
                if(event.getCurrentItem().getType() == Material.STONE) {
                    AufgabenManager.onComplete(player.getUniqueId(), 4);
                }
            }
        }
    }

    public void onBlockBreak(BlockBreakEvent event) {
        Player player = event.getPlayer();

        if(AufgabenManager.getTask(player.getUniqueId()) == 5) {
            if(SchoolMode.getPlayerBlocks(player.getUniqueId()) >= 50) {
                AufgabenManager.onComplete(player.getUniqueId(), 5);
            }
        }
    }
    public static void onJoin(final PlayerJoinEvent e){
        if(AufgabenManager.getToggle(e.getPlayer().getUniqueId()) == 0){
            TTA_Methods.sendTitle(e.getPlayer(), "§6Aufgabe", 20, 20, 20,"§b» §7Eine Aufgabe ist bereit", 20, 20, 20);
            e.getPlayer().sendMessage(MessageManager.PREFIX + "§7Du hast eine offene §6Aufgabe§7. Nutze §6/aufgabe §7um deine Aufgabe zu sehen!");
            e.getPlayer().playSound(e.getPlayer().getLocation(), Sound.NOTE_BASS, 1L, 1L);
        }
    }

}
