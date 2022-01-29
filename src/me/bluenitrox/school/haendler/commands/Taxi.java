package me.bluenitrox.school.haendler.commands;

import de.Herbystar.TTA.TTA_Methods;
import me.bluenitrox.school.SchoolMode;
import me.bluenitrox.school.dungeon.manager.DungeonManager;
import me.bluenitrox.school.managers.LocationManager;
import me.bluenitrox.school.managers.MessageManager;
import me.bluenitrox.school.managers.MoneyManager;
import me.bluenitrox.school.managers.PlayerJoinManager;
import me.bluenitrox.school.utils.ItemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.Random;
import java.util.UUID;

public class Taxi {
    public static String GUI_NAME = "§6§lTaxi";
    private static int kostenwz1 = 7500;
    private static int kostenwz2 = 15000;
    private static int kostenwz3 = 30000;
    private static int kostenwzrandom = 10000;

    public static void onCommand(CommandSender cs, Command cmd, String s, String[] args) {
        Player p = (Player)cs;
        if(cs == null){
            cs.sendMessage(MessageManager.NOPLAYER);
            return;
        }
        Inventory inv = Bukkit.createInventory(null, 9*5, GUI_NAME);

        ItemStack glas = new ItemBuilder(Material.STAINED_GLASS_PANE).setDisplayname(" ").build();
        ItemStack glasblack = new ItemBuilder(Material.STAINED_GLASS_PANE, (short)15).setDisplayname(" ").build();
        ItemStack pickaxe = new ItemBuilder(Material.IRON_PICKAXE).setDisplayname("§8» §6§lTaxi").setLore("§6§l▶ §7Mit dem §9§lTaxi §7kannst du dich", "§6§l▶ §7für eine kleine Gebühr in die Warzone teleportieren.").build();

        ItemStack warzone1 = new ItemBuilder(Material.EMPTY_MAP).setDisplayname("§8» §9§lWarzone 1").setLore("§6§l▶ §7Der Teleport kostet dich: §c" + kostenwz1).build();
        ItemStack warzone2 = new ItemBuilder(Material.EMPTY_MAP).setDisplayname("§8» §9§lWarzone 2").setLore("§6§l▶ §7Der Teleport kostet dich: §c" + kostenwz2).build();
        ItemStack warzone3 = new ItemBuilder(Material.EMPTY_MAP).setDisplayname("§8» §9§lWarzone 3").setLore("§6§l▶ §7Der Teleport kostet dich: §c"  + kostenwz3).build();

        ItemStack book = new ItemBuilder(Material.BOOK).setDisplayname("§8» §9§lRandom Teleport").setLore("§6§l▶ §7Dieser Teleport kostet dich: §c" + kostenwzrandom).build();

        for(int i = 0; i<= 8; i++){
            inv.setItem(i, glasblack);
        }
        for(int i = 9; i<= 35; i++){
            inv.setItem(i, glas);
        }
        for(int i = 36; i<=44;i++){
            inv.setItem(i,glasblack);
        }

        inv.setItem(14,pickaxe);
        inv.setItem(19,warzone1);
        inv.setItem(20,warzone2);
        inv.setItem(21,warzone3);
        inv.setItem(25,book);


        p.openInventory(inv);

        return;
    }

    public static void onClick(final InventoryClickEvent e){
        Player p = (Player)e.getWhoClicked();
        UUID uuid = p.getUniqueId();
        if(e.getClickedInventory().getName().equalsIgnoreCase(GUI_NAME)){
            e.setCancelled(true);
            if(e.getCurrentItem().getItemMeta() != null) {
                if (e.getCurrentItem().getItemMeta().getDisplayName() != null) {
                    if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§8» §9§lWarzone 1")){
                        if(MoneyManager.getMoney(uuid) >= kostenwz1){
                            MoneyManager.updateMoney(uuid, kostenwz1, true, false, false);
                            p.closeInventory();
                            DungeonManager dm = new DungeonManager();
                            dm.onQuitDungeon(p);
                            teleport(1, p);
                        }else{
                            p.sendMessage(MessageManager.NOTMONEY(PlayerJoinManager.language));
                            p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1L, 1L);
                            p.closeInventory();
                        }
                    }else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§8» §9§lWarzone 2")){
                        if(MoneyManager.getMoney(uuid) >= kostenwz2){
                            MoneyManager.updateMoney(uuid, kostenwz2, true, false, false);
                            p.closeInventory();
                            DungeonManager dm = new DungeonManager();
                            dm.onQuitDungeon(p);
                            teleport(2, p);
                        }else{
                            p.sendMessage(MessageManager.NOTMONEY(PlayerJoinManager.language));
                            p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1L, 1L);
                            p.closeInventory();
                        }
                    }else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§8» §9§lWarzone 3")){
                        if(MoneyManager.getMoney(uuid) >= kostenwz3){
                            MoneyManager.updateMoney(uuid, kostenwz3, true, false, false);
                            p.closeInventory();
                            DungeonManager dm = new DungeonManager();
                            dm.onQuitDungeon(p);
                            teleport(3, p);
                        }else{
                            p.sendMessage(MessageManager.NOTMONEY(PlayerJoinManager.language));
                            p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1L, 1L);
                            p.closeInventory();
                        }
                    }else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§8» §9§lRandom Teleport")){
                        if(MoneyManager.getMoney(uuid) >= kostenwzrandom){
                            MoneyManager.updateMoney(uuid, kostenwzrandom, true, false, false);
                            p.closeInventory();
                            DungeonManager dm = new DungeonManager();
                            dm.onQuitDungeon(p);
                            teleport(4, p);
                        }else{
                            p.sendMessage(MessageManager.NOTMONEY(PlayerJoinManager.language));
                            p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1L, 1L);
                            p.closeInventory();
                        }
                    }
                }
            }
        }
    }

    private static void teleport(Integer warzone, Player p) {
        p.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 20 * 5, 10));
        p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 20 * 5, 10));
        p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW_DIGGING, 20 * 5, 10));
        p.addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, 20 * 5, 10));
        p.playSound(p.getLocation(), Sound.NOTE_PLING, 1L, 1L);
        p.playSound(p.getLocation(), Sound.PORTAL_TRIGGER, 1L, 1L);
        TTA_Methods.sendTitle(p, "§6§lTeleport in", 20, 20, 20, "§8» §33", 20, 20, 20);
        new BukkitRunnable() {
            @Override
            public void run() {
                p.playSound(p.getLocation(), Sound.NOTE_PLING, 1L, 1L);
                TTA_Methods.sendTitle(p, "§6§lTeleport in", 20, 20, 20, "§8» §32", 20, 20, 20);
                new BukkitRunnable() {
                    @Override
                    public void run() {
                        p.playSound(p.getLocation(), Sound.NOTE_PLING, 1L, 1L);
                        TTA_Methods.sendTitle(p, "§6§lTeleport in", 20, 20, 20, "§8» §31", 20, 20, 20);
                        new BukkitRunnable() {
                            @Override
                            public void run() {
                                p.playSound(p.getLocation(), Sound.NOTE_PLING, 1L, 1L);
                                p.playSound(p.getLocation(), Sound.PORTAL_TRAVEL, 1L, 1L);
                                TTA_Methods.sendTitle(p, "§6§lTeleport in", 20, 20, 20, "§8» §3jetzt", 20, 20, 20);
                                p.removePotionEffect(PotionEffectType.SLOW);
                                p.removePotionEffect(PotionEffectType.SLOW_DIGGING);
                                p.removePotionEffect(PotionEffectType.CONFUSION);
                                p.removePotionEffect(PotionEffectType.BLINDNESS);
                                    /*



                                    TELEPORT
                                    Points immer setzen wie folgt
                                    Point1WZ1
                                    Point2WZ1
                                    Point1WZ3



                                     */

                                if(warzone == 1){
                                    int r = new Random().nextInt(30);
                                    p.teleport(new LocationManager("Point" + r + "WZ1").getLocation());
                                }else if(warzone == 2){
                                    int r = new Random().nextInt(30);
                                    p.teleport(new LocationManager("Point" + r + "WZ2").getLocation());
                                }else if(warzone == 3){
                                    int r = new Random().nextInt(30);
                                    p.teleport(new LocationManager("Point" + r + "WZ3").getLocation());
                                }else if(warzone == 4){
                                    int r = new Random().nextInt(30);
                                    int r2 = new Random().nextInt(3);
                                    p.teleport(new LocationManager("Point" + r + "WZ" + r2).getLocation());
                                }

                            }
                        }.runTaskLater(SchoolMode.getInstance(), 20);
                    }
                }.runTaskLater(SchoolMode.getInstance(), 20);
            }
        }.runTaskLater(SchoolMode.getInstance(), 20);
    }
}
