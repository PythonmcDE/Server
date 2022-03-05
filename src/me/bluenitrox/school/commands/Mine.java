package me.bluenitrox.school.commands;

import me.bluenitrox.school.dungeon.manager.DungeonManager;
import me.bluenitrox.school.haendler.NPCAPI;
import me.bluenitrox.school.managers.*;
import me.bluenitrox.school.mine.angelmine.AngelminenManager;
import me.bluenitrox.school.mine.manager.MinenManager;
import me.bluenitrox.school.mysql.MySQL;
import me.bluenitrox.school.utils.ItemBuilder;
import me.bluenitrox.school.utils.UUIDFetcher;
import me.bluenitrox.school.utils.ValuetoString;
import me.bluenitrox.school.warzone.CombatAPI;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.UUID;

public class Mine implements CommandExecutor {

    public static final String guiname = "§6§lMinen";

    @Override
    public boolean onCommand(CommandSender cs, Command c, String label, String[] args) {
        if(cs instanceof Player) {
            Player p = (Player) cs;
            if(CombatAPI.fight != null) {
                if (CombatAPI.fight.containsKey(p)) {
                    p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1L, 1L);
                    p.sendMessage(MessageManager.CANTDOINFIGHT);
                    return true;
                }
            }
            if(args.length == 0) {
                Inventory inv = Bukkit.createInventory(null, 9*6, guiname);

                setMinenContent(inv, p.getUniqueId());

                p.openInventory(inv);
            }else if(args.length == 1) {
                if(args[0].equalsIgnoreCase("help")) {
                    if(p.hasPermission(PermissionsManager.ALLPERMS) || p.hasPermission(PermissionsManager.MINE_HELP)) {
                        p.sendMessage(MessageManager.MINE_HELP_DESCRIPTION);
                        return false;
                    }else {
                        p.sendMessage(MessageManager.NOPERMISSIONS(PlayerJoinManager.language));
                        return false;
                    }
                }
                if(p.hasPermission(PermissionsManager.ALLPERMS) || p.hasPermission(PermissionsManager.kingqueen)) {
                    try {
                        String mine = "mine";
                        int number = Integer.parseInt(args[0]);
                        if(number > MessageManager.MAX_MINE || number < 1) {
                            p.sendMessage(MessageManager.PREFIX + "§7Deine angegebene Mine §cexistiert nicht");
                            return false;
                        }

                        String mineToTp = mine + number;
                        DungeonManager dm = new DungeonManager();
                        dm.onQuitDungeon(p);
                        if(new LocationManager(mineToTp).getLocation() != null) {
                            p.teleport(new LocationManager(mineToTp).getLocation());
                            AngelminenManager.quitAngelmine(p);
                        }

                    }catch (NumberFormatException e) {
                        e.printStackTrace();
                        p.sendMessage(MessageManager.ERROR);
                        return false;
                    }
                }else {
                    p.sendMessage(MessageManager.NOPERMISSIONS(PlayerJoinManager.language));
                    return false;
                }
            }else if(args.length == 3) {
                Player target = Bukkit.getPlayer(args[1]);
                if (args[0].equalsIgnoreCase("set")) {
                    if (p.hasPermission(PermissionsManager.ALLPERMS) || p.hasPermission(PermissionsManager.SET_MINE)) {
                        try {
                            int newMine = Integer.parseInt(args[2]);
                            if(target != null) {
                                MinenManager.setMine(target.getUniqueId(), newMine);
                                if(target != p) {
                                    target.sendMessage(MessageManager.SUCCESS_MINE_CHANGE_OTHER);
                                }
                                p.sendMessage(MessageManager.SUCCESS_MINE_CHANGE);
                            }else {
                                MinenManager.setMineDatabase(UUIDFetcher.getUUID(args[1]), newMine);
                                p.sendMessage(MessageManager.SUCCESS_MINE_CHANGE);
                            }
                        } catch (Exception e) {
                            p.sendMessage(MessageManager.SUCCESS_MINE_CHANGE_OTHER);
                            return false;
                        }
                    } else {
                        p.sendMessage(MessageManager.NOPERMISSIONS(PlayerJoinManager.language));
                    }
                } else {
                    p.sendMessage(MessageManager.FALSECOMMAND(PlayerJoinManager.language));
                }

                if (args[0].equalsIgnoreCase("update")) {
                    if (p.hasPermission(PermissionsManager.ALLPERMS) || p.hasPermission(PermissionsManager.UPDATE_MINE)) {
                        try {
                            boolean remove = Boolean.getBoolean(args[2]);
                            if(target != null) {
                                MinenManager.updateMineDatabase(target.getUniqueId(), remove);
                                if(target != p) {
                                    target.sendMessage(MessageManager.SUCCESS_MINE_CHANGE_OTHER);
                                }
                                p.sendMessage(MessageManager.SUCCESS_MINE_CHANGE);
                            }else {
                                MinenManager.updateMineDatabase(UUIDFetcher.getUUID(args[1]), remove);
                                p.sendMessage(MessageManager.SUCCESS_MINE_CHANGE);
                            }
                        } catch (Exception e) {
                            p.sendMessage(MessageManager.ERROR_MINE_CHANGE);
                            return false;
                        }
                    } else {
                        p.sendMessage(MessageManager.NOPERMISSIONS(PlayerJoinManager.language));
                    }
                } else {
                    p.sendMessage(MessageManager.FALSECOMMAND(PlayerJoinManager.language));
                }
            }else if(args.length == 5) {
                //    /mine create "1" "eckpoint1" "eckpoint2"
                if(args[0].equalsIgnoreCase("create")) {
                    try {
                        String name = args[1];
                        String eckpoint1 = args[2];
                        String eckpoint2 = args[3];
                        int blockforreset = Integer.parseInt(args[4]);
                        try (Connection connection = MySQL.getHikariDataSource().getConnection(); PreparedStatement ps = connection.prepareStatement("INSERT INTO minen (name, eckpoint1, eckpoint2, blocksforreset) VALUES (?, ?, ?, ?)")) {
                            ps.setString(1, name);
                            ps.setString(2, eckpoint1);
                            ps.setString(3, eckpoint2);
                            ps.setInt(4, blockforreset);
                            ps.executeUpdate();
                            p.sendMessage(MessageManager.PREFIX + "§7Mine §6" + name + " §7wurde §aerfolgreich §7gesetzt");
                        }catch (SQLException e){
                            e.printStackTrace();
                            p.sendMessage(MessageManager.ERROR);
                        }
                    }catch (Exception e){
                        e.printStackTrace();
                        p.sendMessage(MessageManager.ERROR);
                    }
                }else {
                    p.sendMessage(MessageManager.FALSECOMMAND(PlayerJoinManager.language));
                }
            } else{
                p.sendMessage(MessageManager.FALSECOMMAND(PlayerJoinManager.language));
            }
        }else {
            cs.sendMessage(MessageManager.NOPLAYER);
        }
        return false;
    }

    public static void onMinenClick(InventoryClickEvent e) {
        if (e.getClickedInventory().getName().equalsIgnoreCase(guiname)) {
            if (e.getCurrentItem() != null) {
                e.setCancelled(true);
                if (e.getCurrentItem().getType() != Material.STAINED_GLASS_PANE && e.getCurrentItem().getType() != Material.IRON_PICKAXE) {
                    if (e.getCurrentItem().getItemMeta() != null) {
                        if (e.getCurrentItem().getItemMeta().getLore() != null) {
                            if (e.getCurrentItem().getItemMeta().getLore().size() != 2) {
                                String[] mine = e.getCurrentItem().getItemMeta().getDisplayName().split(" ");
                                buyMine(Integer.parseInt(mine[2]), e.getWhoClicked().getUniqueId(), PlayerJoinManager.language);
                            } else {
                                String[] name = e.getCurrentItem().getItemMeta().getDisplayName().split(" ");
                                if(new LocationManager("mine" + name[2]).getLocation() != null) {
                                    e.getWhoClicked().teleport(new LocationManager("mine" + name[2]).getLocation());
                                    AngelminenManager.quitAngelmine((Player) e.getWhoClicked());
                                }
                                e.getWhoClicked().sendMessage(MessageManager.TPTOMINE);
                            }
                        }
                    }
                }
            }
        }
    }


    private static void buyMine(int mine, UUID uuid, int lang){
        Player p = Bukkit.getPlayer(uuid);
        if(mine == 2){
            if(MoneyManager.getMoney(uuid) >= MessageManager.MINE_2_PREIS){
                MoneyManager.updateMoney(uuid,MessageManager.MINE_2_PREIS, true, false, false);
                MinenManager.updateMine(uuid, false);
                p.sendMessage(MessageManager.MINEBUYED);
                p.playSound(p.getLocation(), Sound.LEVEL_UP, 1L, 1L);
                p.closeInventory();
            }else {
                p.sendMessage(MessageManager.NOTMONEY(lang));
                p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1L, 1L);
            }
        }else if(mine == 3){
            if(MoneyManager.getMoney(uuid) >= MessageManager.MINE_3_PREIS){
                if(MinenManager.getMine(uuid) == 2) {
                    MoneyManager.updateMoney(uuid,MessageManager.MINE_3_PREIS, true, false, false);
                    MinenManager.updateMine(uuid, false);
                    p.sendMessage(MessageManager.MINEBUYED);
                    p.playSound(p.getLocation(), Sound.LEVEL_UP, 1L, 1L);
                    p.closeInventory();
                }else {
                    p.sendMessage(MessageManager.OTHERMINES);
                    p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1L, 1L);
                }
            }else {
                p.sendMessage(MessageManager.NOTMONEY(lang));
                p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1L, 1L);
            }
        }else if(mine == 4){
            if(MoneyManager.getMoney(uuid) >= MessageManager.MINE_4_PREIS){
                if(MinenManager.getMine(uuid) == 3) {
                    MoneyManager.updateMoney(uuid,MessageManager.MINE_4_PREIS, true, false, false);
                    MinenManager.updateMine(uuid, false);
                    p.sendMessage(MessageManager.MINEBUYED);
                    p.playSound(p.getLocation(), Sound.LEVEL_UP, 1L, 1L);
                    p.closeInventory();
                }else {
                    p.sendMessage(MessageManager.OTHERMINES);
                    p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1L, 1L);
                }
            }else {
                p.sendMessage(MessageManager.NOTMONEY(lang));
                p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1L, 1L);
            }
        }else if(mine == 5){
            if(MoneyManager.getMoney(uuid) >= MessageManager.MINE_5_PREIS){
                if(MinenManager.getMine(uuid) == 4) {
                    MoneyManager.updateMoney(uuid,MessageManager.MINE_5_PREIS, true, false, false);
                    MinenManager.updateMine(uuid, false);
                    p.sendMessage(MessageManager.MINEBUYED);
                    p.playSound(p.getLocation(), Sound.LEVEL_UP, 1L, 1L);
                    p.closeInventory();
                }else {
                    p.sendMessage(MessageManager.OTHERMINES);
                    p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1L, 1L);
                }
            }else {
                p.sendMessage(MessageManager.NOTMONEY(lang));
                p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1L, 1L);
            }
        }else if(mine == 6){
            if(MoneyManager.getMoney(uuid) >= MessageManager.MINE_6_PREIS){
                if(MinenManager.getMine(uuid) == 5) {
                    MoneyManager.updateMoney(uuid,MessageManager.MINE_6_PREIS, true, false, false);
                    MinenManager.updateMine(uuid, false);
                    p.sendMessage(MessageManager.MINEBUYED);
                    p.playSound(p.getLocation(), Sound.LEVEL_UP, 1L, 1L);
                    p.closeInventory();
                }else {
                    p.sendMessage(MessageManager.OTHERMINES);
                    p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1L, 1L);
                }
            }else {
                p.sendMessage(MessageManager.NOTMONEY(lang));
                p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1L, 1L);
            }
        }else if(mine == 7){
            if(MoneyManager.getMoney(uuid) >= MessageManager.MINE_7_PREIS){
                if(MinenManager.getMine(uuid) == 6) {
                    MoneyManager.updateMoney(uuid,MessageManager.MINE_7_PREIS, true, false, false);
                    MinenManager.updateMine(uuid, false);
                    p.sendMessage(MessageManager.MINEBUYED);
                    p.playSound(p.getLocation(), Sound.LEVEL_UP, 1L, 1L);
                    p.closeInventory();
                }else {
                    p.sendMessage(MessageManager.OTHERMINES);
                    p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1L, 1L);
                }
            }else {
                p.sendMessage(MessageManager.NOTMONEY(lang));
                p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1L, 1L);
            }
        }else if(mine == 8){
            if(MoneyManager.getMoney(uuid) >= MessageManager.MINE_8_PREIS){
                if(MinenManager.getMine(uuid) == 7) {
                    MoneyManager.updateMoney(uuid,MessageManager.MINE_8_PREIS, true, false, false);
                    MinenManager.updateMine(uuid, false);
                    p.sendMessage(MessageManager.MINEBUYED);
                    p.playSound(p.getLocation(), Sound.LEVEL_UP, 1L, 1L);
                    p.closeInventory();
                }else {
                    p.sendMessage(MessageManager.OTHERMINES);
                    p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1L, 1L);
                }
            }else {
                p.sendMessage(MessageManager.NOTMONEY(lang));
                p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1L, 1L);
            }
        }else if(mine == 9){
            if(MoneyManager.getMoney(uuid) >= MessageManager.MINE_9_PREIS){
                if(MinenManager.getMine(uuid) == 8) {
                    MoneyManager.updateMoney(uuid,MessageManager.MINE_9_PREIS, true, false, false);
                    MinenManager.updateMine(uuid, false);
                    p.sendMessage(MessageManager.MINEBUYED);
                    p.playSound(p.getLocation(), Sound.LEVEL_UP, 1L, 1L);
                    p.closeInventory();
                }else {
                    p.sendMessage(MessageManager.OTHERMINES);
                    p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1L, 1L);
                }
            }else {
                p.sendMessage(MessageManager.NOTMONEY(lang));
                p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1L, 1L);
            }
        }else if(mine == 10){
            if(MoneyManager.getMoney(uuid) >= MessageManager.MINE_10_PREIS){
                if(MinenManager.getMine(uuid) == 9) {
                    MoneyManager.updateMoney(uuid,MessageManager.MINE_10_PREIS, true, false, false);
                    MinenManager.updateMine(uuid, false);
                    p.sendMessage(MessageManager.MINEBUYED);
                    p.playSound(p.getLocation(), Sound.LEVEL_UP, 1L, 1L);
                    p.closeInventory();
                }else {
                    p.sendMessage(MessageManager.OTHERMINES);
                    p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1L, 1L);
                }
            }else {
                p.sendMessage(MessageManager.NOTMONEY(lang));
                p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1L, 1L);
            }
        }else if(mine == 11){
            if(MoneyManager.getMoney(uuid) >= MessageManager.MINE_11_PREIS){
                if(MinenManager.getMine(uuid) == 10) {
                    MoneyManager.updateMoney(uuid,MessageManager.MINE_11_PREIS, true, false, false);
                    MinenManager.updateMine(uuid, false);
                    p.sendMessage(MessageManager.MINEBUYED);
                    p.playSound(p.getLocation(), Sound.LEVEL_UP, 1L, 1L);
                    p.closeInventory();
                }else {
                    p.sendMessage(MessageManager.OTHERMINES);
                    p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1L, 1L);
                }
            }else {
                p.sendMessage(MessageManager.NOTMONEY(lang));
                p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1L, 1L);
            }
        }else if(mine == 12){
            if(MoneyManager.getMoney(uuid) >= MessageManager.MINE_12_PREIS){
                if(MinenManager.getMine(uuid) == 11) {
                    MoneyManager.updateMoney(uuid,MessageManager.MINE_12_PREIS, true, false, false);
                    MinenManager.updateMine(uuid, false);
                    p.sendMessage(MessageManager.MINEBUYED);
                    p.playSound(p.getLocation(), Sound.LEVEL_UP, 1L, 1L);
                    p.closeInventory();
                }else {
                    p.sendMessage(MessageManager.OTHERMINES);
                    p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1L, 1L);
                }
            }else {
                p.sendMessage(MessageManager.NOTMONEY(lang));
                p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1L, 1L);
            }
        }else if(mine == 13){
            if(MoneyManager.getMoney(uuid) >= MessageManager.MINE_13_PREIS){
                if(MinenManager.getMine(uuid) == 12) {
                    MoneyManager.updateMoney(uuid,MessageManager.MINE_13_PREIS, true, false, false);
                    MinenManager.updateMine(uuid, false);
                    p.sendMessage(MessageManager.MINEBUYED);
                    p.playSound(p.getLocation(), Sound.LEVEL_UP, 1L, 1L);
                    p.closeInventory();
                }else {
                    p.sendMessage(MessageManager.OTHERMINES);
                    p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1L, 1L);
                }
            }else {
                p.sendMessage(MessageManager.NOTMONEY(lang));
                p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1L, 1L);
            }
        }else if(mine == 14){
            if(MoneyManager.getMoney(uuid) >= MessageManager.MINE_14_PREIS){
                if(MinenManager.getMine(uuid) == 13) {
                    MoneyManager.updateMoney(uuid,MessageManager.MINE_14_PREIS, true, false, false);
                    MinenManager.updateMine(uuid, false);
                    p.sendMessage(MessageManager.MINEBUYED);
                    p.playSound(p.getLocation(), Sound.LEVEL_UP, 1L, 1L);
                    p.closeInventory();
                }else {
                    p.sendMessage(MessageManager.OTHERMINES);
                    p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1L, 1L);
                }
            }else {
                p.sendMessage(MessageManager.NOTMONEY(lang));
                p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1L, 1L);
            }
        }else if(mine == 15){
            if(MoneyManager.getMoney(uuid) >= MessageManager.MINE_15_PREIS){
                if(MinenManager.getMine(uuid) == 14) {
                    MoneyManager.updateMoney(uuid,MessageManager.MINE_15_PREIS, true, false, false);
                    MinenManager.updateMine(uuid, false);
                    p.sendMessage(MessageManager.MINEBUYED);
                    p.playSound(p.getLocation(), Sound.LEVEL_UP, 1L, 1L);
                    p.closeInventory();
                }else {
                    p.sendMessage(MessageManager.OTHERMINES);
                    p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1L, 1L);
                }
            }else {
                p.sendMessage(MessageManager.NOTMONEY(lang));
                p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1L, 1L);
            }
        }else if(mine == 16){
            if(MoneyManager.getMoney(uuid) >= MessageManager.MINE_16_PREIS){
                if(MinenManager.getMine(uuid) == 15) {
                    MoneyManager.updateMoney(uuid,MessageManager.MINE_16_PREIS, true, false, false);
                    MinenManager.updateMine(uuid, false);
                    p.sendMessage(MessageManager.MINEBUYED);
                    p.playSound(p.getLocation(), Sound.LEVEL_UP, 1L, 1L);
                    p.closeInventory();
                }else {
                    p.sendMessage(MessageManager.OTHERMINES);
                    p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1L, 1L);
                }
            }else {
                p.sendMessage(MessageManager.NOTMONEY(lang));
                p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1L, 1L);
            }
        }else if(mine == 17){
            if(MoneyManager.getMoney(uuid) >= MessageManager.MINE_17_PREIS){
                if(MinenManager.getMine(uuid) == 16) {
                    MoneyManager.updateMoney(uuid,MessageManager.MINE_17_PREIS, true, false, false);
                    MinenManager.updateMine(uuid, false);
                    p.sendMessage(MessageManager.MINEBUYED);
                    p.playSound(p.getLocation(), Sound.LEVEL_UP, 1L, 1L);
                    p.closeInventory();
                }else {
                    p.sendMessage(MessageManager.OTHERMINES);
                    p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1L, 1L);
                }
            }else {
                p.sendMessage(MessageManager.NOTMONEY(lang));
                p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1L, 1L);
            }
        }else if(mine == 18){
            if(MoneyManager.getMoney(uuid) >= MessageManager.MINE_18_PREIS){
                if(MinenManager.getMine(uuid) == 17) {
                    MoneyManager.updateMoney(uuid,MessageManager.MINE_18_PREIS, true, false, false);
                    MinenManager.updateMine(uuid, false);
                    p.sendMessage(MessageManager.MINEBUYED);
                    p.playSound(p.getLocation(), Sound.LEVEL_UP, 1L, 1L);
                    p.closeInventory();
                }else {
                    p.sendMessage(MessageManager.OTHERMINES);
                    p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1L, 1L);
                }
            }else {
                p.sendMessage(MessageManager.NOTMONEY(lang));
                p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1L, 1L);
            }
        }else if(mine == 19){
            if(MoneyManager.getMoney(uuid) >= MessageManager.MINE_19_PREIS){
                if(MinenManager.getMine(uuid) == 18) {
                    MoneyManager.updateMoney(uuid,MessageManager.MINE_19_PREIS, true, false, false);
                    MinenManager.updateMine(uuid, false);
                    p.sendMessage(MessageManager.MINEBUYED);
                    p.playSound(p.getLocation(), Sound.LEVEL_UP, 1L, 1L);
                    p.closeInventory();
                }else {
                    p.sendMessage(MessageManager.OTHERMINES);
                    p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1L, 1L);
                }
            }else {
                p.sendMessage(MessageManager.NOTMONEY(lang));
                p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1L, 1L);
            }
        }else if(mine == 20){
            if(MoneyManager.getMoney(uuid) >= MessageManager.MINE_20_PREIS){
                if(MinenManager.getMine(uuid) == 19) {
                    MoneyManager.updateMoney(uuid,MessageManager.MINE_20_PREIS, true, false, false);
                    MinenManager.updateMine(uuid, false);
                    p.sendMessage(MessageManager.MINEBUYED);
                    p.playSound(p.getLocation(), Sound.LEVEL_UP, 1L, 1L);
                    p.closeInventory();
                }else {
                    p.sendMessage(MessageManager.OTHERMINES);
                    p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1L, 1L);
                }
            }else {
                p.sendMessage(MessageManager.NOTMONEY(lang));
                p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1L, 1L);
            }
        }else if(mine == 21){
            if(MoneyManager.getMoney(uuid) >= MessageManager.MINE_21_PREIS){
                if(MinenManager.getMine(uuid) == 20) {
                    MoneyManager.updateMoney(uuid,MessageManager.MINE_21_PREIS, true, false, false);
                    MinenManager.updateMine(uuid, false);
                    p.sendMessage(MessageManager.MINEBUYED);
                    p.playSound(p.getLocation(), Sound.LEVEL_UP, 1L, 1L);
                    p.closeInventory();
                }else {
                    p.sendMessage(MessageManager.OTHERMINES);
                    p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1L, 1L);
                }
            }else {
                p.sendMessage(MessageManager.NOTMONEY(lang));
                p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1L, 1L);
            }
        }else if(mine == 22){
            if(MoneyManager.getMoney(uuid) >= MessageManager.MINE_22_PREIS){
                if(MinenManager.getMine(uuid) == 21) {
                    MoneyManager.updateMoney(uuid,MessageManager.MINE_22_PREIS, true, false, false);
                    MinenManager.updateMine(uuid, false);
                    p.sendMessage(MessageManager.MINEBUYED);
                    p.playSound(p.getLocation(), Sound.LEVEL_UP, 1L, 1L);
                    p.closeInventory();
                }else {
                    p.sendMessage(MessageManager.OTHERMINES);
                    p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1L, 1L);
                }
            }else {
                p.sendMessage(MessageManager.NOTMONEY(lang));
                p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1L, 1L);
            }
        }else if(mine == 23){
            if(MoneyManager.getMoney(uuid) >= MessageManager.MINE_23_PREIS){
                if(MinenManager.getMine(uuid) == 22) {
                    MoneyManager.updateMoney(uuid,MessageManager.MINE_23_PREIS, true, false, false);
                    MinenManager.updateMine(uuid, false);
                    p.sendMessage(MessageManager.MINEBUYED);
                    p.playSound(p.getLocation(), Sound.LEVEL_UP, 1L, 1L);
                    p.closeInventory();
                }else {
                    p.sendMessage(MessageManager.OTHERMINES);
                    p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1L, 1L);
                }
            }else {
                p.sendMessage(MessageManager.NOTMONEY(lang));
                p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1L, 1L);
            }
        }else if(mine == 24){
            if(MoneyManager.getMoney(uuid) >= MessageManager.MINE_24_PREIS){
                if(MinenManager.getMine(uuid) == 23) {
                    MoneyManager.updateMoney(uuid,MessageManager.MINE_24_PREIS, true, false, false);
                    MinenManager.updateMine(uuid, false);
                    p.sendMessage(MessageManager.MINEBUYED);
                    p.playSound(p.getLocation(), Sound.LEVEL_UP, 1L, 1L);
                    p.closeInventory();
                }else {
                    p.sendMessage(MessageManager.OTHERMINES);
                    p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1L, 1L);
                }
            }else {
                p.sendMessage(MessageManager.NOTMONEY(lang));
                p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1L, 1L);
            }
        }else if(mine == 25){
            if(MoneyManager.getMoney(uuid) >= MessageManager.MINE_25_PREIS){
                if(MinenManager.getMine(uuid) == 24) {
                    MoneyManager.updateMoney(uuid,MessageManager.MINE_25_PREIS, true, false, false);
                    MinenManager.updateMine(uuid, false);
                    p.sendMessage(MessageManager.MINEBUYED);
                    p.playSound(p.getLocation(), Sound.LEVEL_UP, 1L, 1L);
                    p.closeInventory();
                }else {
                    p.sendMessage(MessageManager.OTHERMINES);
                    p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1L, 1L);
                }
            }else {
                p.sendMessage(MessageManager.NOTMONEY(lang));
                p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1L, 1L);
            }
        } else if(mine == 26){
            if(MoneyManager.getMoney(uuid) >= MessageManager.MINE_26_PREIS){
                if(MinenManager.getMine(uuid) == 25) {
                    MoneyManager.updateMoney(uuid,MessageManager.MINE_26_PREIS, true, false, false);
                    MinenManager.updateMine(uuid, false);
                    p.sendMessage(MessageManager.MINEBUYED);
                    p.playSound(p.getLocation(), Sound.LEVEL_UP, 1L, 1L);
                    p.closeInventory();
                }else {
                    p.sendMessage(MessageManager.OTHERMINES);
                    p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1L, 1L);
                }
            }else {
                p.sendMessage(MessageManager.NOTMONEY(lang));
                p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1L, 1L);
            }
        }
    }

    public static void setMinenContent(Inventory inv, UUID uuid){
        ItemStack glas = new ItemBuilder(Material.STAINED_GLASS_PANE).setDisplayname(" ").build();
        ItemStack picke = new ItemBuilder(Material.IRON_PICKAXE).setDisplayname("§8§l» §6§lMinen").setLore("§6§l▶ §7Schalte hier neue §6§lMinen §7frei, um somit",
                "§6§l▶ mehr Gems §7zu verdienen.").build();

        ItemStack mine11 = new ItemBuilder(Material.STONE).addEnchant(Enchantment.ARROW_INFINITE, 10, false).setDisplayname("§8§l» §6§lMine 1").setLore("§6§l▶ §7Du besitzt diese §6§lMine§7, klicke",
                "§6§l▶ §7hier zum §6§lTeleportieren§7.").build();
        ItemStack mine21 = new ItemBuilder(Material.COAL_ORE).addEnchant(Enchantment.ARROW_INFINITE, 10, false).setDisplayname("§8§l» §6§lMine 2").setLore("§6§l▶ §7Du besitzt diese §6§lMine§7, klicke",
                "§6§l▶ §7hier zum §6§lTeleportieren§7.").build();
        ItemStack mine31 = new ItemBuilder(Material.COAL).addEnchant(Enchantment.ARROW_INFINITE, 10, false).setDisplayname("§8§l» §6§lMine 3").setLore("§6§l▶ §7Du besitzt diese §6§lMine§7, klicke",
                "§6§l▶ §7hier zum §6§lTeleportieren§7.").build();
        ItemStack mine41 = new ItemBuilder(Material.IRON_ORE).addEnchant(Enchantment.ARROW_INFINITE, 10, false).setDisplayname("§8§l» §6§lMine 4").setLore("§6§l▶ §7Du besitzt diese §6§lMine§7, klicke",
                "§6§l▶ §7hier zum §6§lTeleportieren§7.").build();
        ItemStack mine51 = new ItemBuilder(Material.IRON_INGOT).addEnchant(Enchantment.ARROW_INFINITE, 10, false).setDisplayname("§8§l» §6§lMine 5").setLore("§6§l▶ §7Du besitzt diese §6§lMine§7, klicke",
                "§6§l▶ §7hier zum §6§lTeleportieren§7.").build();
        ItemStack mine61 = new ItemBuilder(Material.QUARTZ_ORE).addEnchant(Enchantment.ARROW_INFINITE, 10, false).setDisplayname("§8§l» §6§lMine 6").setLore("§6§l▶ §7Du besitzt diese §6§lMine§7, klicke",
                "§6§l▶ §7hier zum §6§lTeleportieren§7.").build();
        ItemStack mine71 = new ItemBuilder(Material.QUARTZ).addEnchant(Enchantment.ARROW_INFINITE, 10, false).setDisplayname("§8§l» §6§lMine 7").setLore("§6§l▶ §7Du besitzt diese §6§lMine§7, klicke",
                "§6§l▶ §7hier zum §6§lTeleportieren§7.").build();
        ItemStack mine81 = new ItemBuilder(Material.REDSTONE_ORE).addEnchant(Enchantment.ARROW_INFINITE, 10, false).setDisplayname("§8§l» §6§lMine 8").setLore("§6§l▶ §7Du besitzt diese §6§lMine§7, klicke",
                "§6§l▶ §7hier zum §6§lTeleportieren§7.").build();
        ItemStack mine91 = new ItemBuilder(Material.REDSTONE).addEnchant(Enchantment.ARROW_INFINITE, 10, false).setDisplayname("§8§l» §6§lMine 9").setLore("§6§l▶ §7Du besitzt diese §6§lMine§7, klicke",
                "§6§l▶ §7hier zum §6§lTeleportieren§7.").build();
        ItemStack mine101 = new ItemBuilder(Material.LAPIS_ORE).addEnchant(Enchantment.ARROW_INFINITE, 10, false).setDisplayname("§8§l» §6§lMine 10").setLore("§6§l▶ §7Du besitzt diese §6§lMine§7, klicke",
                "§6§l▶ §7hier zum §6§lTeleportieren§7.").build();
        ItemStack mine111 = new ItemBuilder(Material.INK_SACK,(short)4).addEnchant(Enchantment.ARROW_INFINITE, 10, false).setDisplayname("§8§l» §6§lMine 11").setLore("§6§l▶ §7Du besitzt diese §6§lMine§7, klicke",
                "§6§l▶ §7hier zum §6§lTeleportieren§7.").build();
        ItemStack mine121 = new ItemBuilder(Material.GOLD_ORE).addEnchant(Enchantment.ARROW_INFINITE, 10, false).setDisplayname("§8§l» §6§lMine 12").setLore("§6§l▶ §7Du besitzt diese §6§lMine§7, klicke",
                "§6§l▶ §7hier zum §6§lTeleportieren§7.").build();
        ItemStack mine131 = new ItemBuilder(Material.GOLD_INGOT).addEnchant(Enchantment.ARROW_INFINITE, 10, false).setDisplayname("§8§l» §6§lMine 13").setLore("§6§l▶ §7Du besitzt diese §6§lMine§7, klicke",
                "§6§l▶ §7hier zum §6§lTeleportieren§7.").build();
        ItemStack mine141 = new ItemBuilder(Material.DIAMOND_ORE).addEnchant(Enchantment.ARROW_INFINITE, 10, false).setDisplayname("§8§l» §6§lMine 14").setLore("§6§l▶ §7Du besitzt diese §6§lMine§7, klicke",
                "§6§l▶ §7hier zum §6§lTeleportieren§7.").build();
        ItemStack mine151 = new ItemBuilder(Material.DIAMOND).addEnchant(Enchantment.ARROW_INFINITE, 10, false).setDisplayname("§8§l» §6§lMine 15").setLore("§6§l▶ §7Du besitzt diese §6§lMine§7, klicke",
                "§6§l▶ §7hier zum §6§lTeleportieren§7.").build();
        ItemStack mine161 = new ItemBuilder(Material.EMERALD_ORE).addEnchant(Enchantment.ARROW_INFINITE, 10, false).setDisplayname("§8§l» §6§lMine 16").setLore("§6§l▶ §7Du besitzt diese §6§lMine§7, klicke",
                "§6§l▶ §7hier zum §6§lTeleportieren§7.").build();
        ItemStack mine171 = new ItemBuilder(Material.EMERALD).addEnchant(Enchantment.ARROW_INFINITE, 10, false).setDisplayname("§8§l» §6§lMine 17").setLore("§6§l▶ §7Du besitzt diese §6§lMine§7, klicke",
                "§6§l▶ §7hier zum §6§lTeleportieren§7.").build();
        ItemStack mine181 = new ItemBuilder(Material.QUARTZ_BLOCK).addEnchant(Enchantment.ARROW_INFINITE, 10, false).setDisplayname("§8§l» §6§lMine 18").setLore("§6§l▶ §7Du besitzt diese §6§lMine§7, klicke",
                "§6§l▶ §7hier zum §6§lTeleportieren§7.").build();
        ItemStack mine191 = new ItemBuilder(Material.COAL_BLOCK).addEnchant(Enchantment.ARROW_INFINITE, 10, false).setDisplayname("§8§l» §6§lMine 19").setLore("§6§l▶ §7Du besitzt diese §6§lMine§7, klicke",
                "§6§l▶ §7hier zum §6§lTeleportieren§7.").build();
        ItemStack mine201 = new ItemBuilder(Material.IRON_BLOCK).addEnchant(Enchantment.ARROW_INFINITE, 10, false).setDisplayname("§8§l» §6§lMine 20").setLore("§6§l▶ §7Du besitzt diese §6§lMine§7, klicke",
                "§6§l▶ §7hier zum §6§lTeleportieren§7.").build();
        ItemStack mine211 = new ItemBuilder(Material.REDSTONE_BLOCK).addEnchant(Enchantment.ARROW_INFINITE, 10, false).setDisplayname("§8§l» §6§lMine 21").setLore("§6§l▶ §7Du besitzt diese §6§lMine§7, klicke",
                "§6§l▶ §7hier zum §6§lTeleportieren§7.").build();
        ItemStack mine221 = new ItemBuilder(Material.LAPIS_BLOCK).addEnchant(Enchantment.ARROW_INFINITE, 10, false).setDisplayname("§8§l» §6§lMine 22").setLore("§6§l▶ §7Du besitzt diese §6§lMine§7, klicke",
                "§6§l▶ §7hier zum §6§lTeleportieren§7.").build();
        ItemStack mine231 = new ItemBuilder(Material.GOLD_BLOCK).addEnchant(Enchantment.ARROW_INFINITE, 10, false).setDisplayname("§8§l» §6§lMine 23").setLore("§6§l▶ §7Du besitzt diese §6§lMine§7, klicke",
                "§6§l▶ §7hier zum §6§lTeleportieren§7.").build();
        ItemStack mine241 = new ItemBuilder(Material.DIAMOND_BLOCK).addEnchant(Enchantment.ARROW_INFINITE, 10, false).setDisplayname("§8§l» §6§lMine 24").setLore("§6§l▶ §7Du besitzt diese §6§lMine§7, klicke",
                "§6§l▶ §7hier zum §6§lTeleportieren§7.").build();
        ItemStack mine251 = new ItemBuilder(Material.EMERALD_BLOCK).addEnchant(Enchantment.ARROW_INFINITE, 10, false).setDisplayname("§8§l» §6§lMine 25").setLore("§6§l▶ §7Du besitzt diese §6§lMine§7, klicke",
                "§6§l▶ §7hier zum §6§lTeleportieren§7.").build();
        ItemStack mine261 = new ItemBuilder(Material.OBSIDIAN).addEnchant(Enchantment.ARROW_INFINITE, 10, false).setDisplayname("§8§l» §6§lMine 26").setLore("§6§l▶ §7Du besitzt diese §6§lMine§7, klicke",
                "§6§l▶ §7hier zum §6§lTeleportieren§7.").build();

        ItemStack mine22 = new ItemBuilder(Material.COAL_ORE).setDisplayname("§8§l» §6§lMine 2").setLore("§6§l▶ §aKlicke hier§7, um die Mine zu §6kaufen§7.",
                "", "§8§l● §7Neues: Kohle","  ", "§6§l▶ §7Kaufspreis: §6" + ValuetoString.valueToString(MessageManager.MINE_2_PREIS)+ " §7Gems").build();
        ItemStack mine32 = new ItemBuilder(Material.COAL).setDisplayname("§8§l» §6§lMine 3").setLore("§6§l▶ §aKlicke hier§7, um die Mine zu §6kaufen§7.",
                "", "§8§l● §7Neues: Mehr Kohle","  ", "§6§l▶ §7Kaufspreis: §6" + ValuetoString.valueToString(MessageManager.MINE_3_PREIS)+ " §7Gems").build();
        ItemStack mine42 = new ItemBuilder(Material.IRON_ORE).setDisplayname("§8§l» §6§lMine 4").setLore("§6§l▶ §aKlicke hier§7, um die Mine zu §6kaufen§7.",
                "", "§8§l● §7Neues: Eisen","  ", "§6§l▶ §7Kaufspreis: §6" + ValuetoString.valueToString(MessageManager.MINE_4_PREIS)+ " §7Gems").build();
        ItemStack mine52 = new ItemBuilder(Material.IRON_INGOT).setDisplayname("§8§l» §6§lMine 5").setLore("§6§l▶ §aKlicke hier§7, um die Mine zu §6kaufen§7.",
                "", "§8§l● §7Neues: Mehr Eisen","  ", "§6§l▶ §7Kaufspreis: §6" + ValuetoString.valueToString(MessageManager.MINE_5_PREIS)+ " §7Gems").build();
        ItemStack mine62 = new ItemBuilder(Material.QUARTZ_ORE).setDisplayname("§8§l» §6§lMine 6").setLore("§6§l▶ §aKlicke hier§7, um die Mine zu §6kaufen§7.",
                "", "§8§l● §7Neues: Quarz","  ", "§6§l▶ §7Kaufspreis: §6" + ValuetoString.valueToString(MessageManager.MINE_6_PREIS)+ " §7Gems").build();
        ItemStack mine72 = new ItemBuilder(Material.QUARTZ).setDisplayname("§8§l» §6§lMine 7").setLore("§6§l▶ §aKlicke hier§7, um die Mine zu §6kaufen§7.",
                "", "§8§l● §7Neues: Mehr Quarz","  ", "§6§l▶ §7Kaufspreis: §6" + ValuetoString.valueToString(MessageManager.MINE_7_PREIS)+ " §7Gems").build();
        ItemStack mine82 = new ItemBuilder(Material.REDSTONE_ORE).setDisplayname("§8§l» §6§lMine 8").setLore("§6§l▶ §aKlicke hier§7, um die Mine zu §6kaufen§7.",
                "", "§8§l● §7Neues: Redstone","  ", "§6§l▶ §7Kaufspreis: §6" + ValuetoString.valueToString(MessageManager.MINE_8_PREIS)+ " §7Gems").build();
        ItemStack mine92 = new ItemBuilder(Material.REDSTONE).setDisplayname("§8§l» §6§lMine 9").setLore("§6§l▶ §aKlicke hier§7, um die Mine zu §6kaufen§7.",
                "", "§8§l● §7Neues: Mehr Redstone","  ", "§6§l▶ §7Kaufspreis: §6" + ValuetoString.valueToString(MessageManager.MINE_9_PREIS)+ " §7Gems").build();
        ItemStack mine102 = new ItemBuilder(Material.LAPIS_ORE).setDisplayname("§8§l» §6§lMine 10").setLore("§6§l▶ §aKlicke hier§7, um die Mine zu §6kaufen§7.",
                "", "§8§l● §7Neues: Lapis","  ", "§6§l▶ §7Kaufspreis: §6" + ValuetoString.valueToString(MessageManager.MINE_10_PREIS)+ " §7Gems").build();
        ItemStack mine112 = new ItemBuilder(Material.INK_SACK, (short)4).setDisplayname("§8§l» §6§lMine 11").setLore("§6§l▶ §aKlicke hier§7, um die Mine zu §6kaufen§7.",
                "", "§8§l● §7Neues: Mehr Lapis","  ", "§6§l▶ §7Kaufspreis: §6" + ValuetoString.valueToString(MessageManager.MINE_11_PREIS)+ " §7Gems").build();
        ItemStack mine122 = new ItemBuilder(Material.GOLD_ORE).setDisplayname("§8§l» §6§lMine 12").setLore("§6§l▶ §aKlicke hier§7, um die Mine zu §6kaufen§7.",
                "", "§8§l● §7Neues: Gold","  ", "§6§l▶ §7Kaufspreis: §6" + ValuetoString.valueToString(MessageManager.MINE_12_PREIS)+ " §7Gems").build();
        ItemStack mine132 = new ItemBuilder(Material.GOLD_INGOT).setDisplayname("§8§l» §6§lMine 13").setLore("§6§l▶ §aKlicke hier§7, um die Mine zu §6kaufen§7.",
                "", "§8§l● §7Neues: Mehr Gold","  ", "§6§l▶ §7Kaufspreis: §6" + ValuetoString.valueToString(MessageManager.MINE_13_PREIS)+ " §7Gems").build();
        ItemStack mine142 = new ItemBuilder(Material.DIAMOND_ORE).setDisplayname("§8§l» §6§lMine 14").setLore("§6§l▶ §aKlicke hier§7, um die Mine zu §6kaufen§7.",
                "", "§8§l● §7Neues: Diamanten","  ", "§6§l▶ §7Kaufspreis: §6" + ValuetoString.valueToString(MessageManager.MINE_14_PREIS)+ " §7Gems").build();
        ItemStack mine152 = new ItemBuilder(Material.DIAMOND).setDisplayname("§8§l» §6§lMine 15").setLore("§6§l▶ §aKlicke hier§7, um die Mine zu §6kaufen§7.",
                "", "§8§l● §7Neues: Mehr Diamanten","  ", "§6§l▶ §7Kaufspreis: §6" + ValuetoString.valueToString(MessageManager.MINE_15_PREIS)+ " §7Gems").build();
        ItemStack mine162 = new ItemBuilder(Material.EMERALD_ORE).setDisplayname("§8§l» §6§lMine 16").setLore("§6§l▶ §aKlicke hier§7, um die Mine zu §6kaufen§7.",
                "", "§8§l● §7Neues: Smaragde","  ", "§6§l▶ §7Kaufspreis: §6" + ValuetoString.valueToString(MessageManager.MINE_16_PREIS)+ " §7Gems").build();
        ItemStack mine172 = new ItemBuilder(Material.EMERALD).setDisplayname("§8§l» §6§lMine 17").setLore("§6§l▶ §aKlicke hier§7, um die Mine zu §6kaufen§7.",
                "", "§8§l● §7Neues: Mehr Smaragde","  ", "§6§l▶ §7Kaufspreis: §6" + ValuetoString.valueToString(MessageManager.MINE_17_PREIS)+ " §7Gems").build();
        ItemStack mine182 = new ItemBuilder(Material.QUARTZ_BLOCK).setDisplayname("§8§l» §6§lMine 18").setLore("§6§l▶ §aKlicke hier§7, um die Mine zu §6kaufen§7.",
                "", "§8§l● §7Neues: Quarz Blöcke","  ", "§6§l▶ §7Kaufspreis: §6" + ValuetoString.valueToString(MessageManager.MINE_18_PREIS)+ " §7Gems").build();
        ItemStack mine192 = new ItemBuilder(Material.COAL_BLOCK).setDisplayname("§8§l» §6§lMine 19").setLore("§6§l▶ §aKlicke hier§7, um die Mine zu §6kaufen§7.",
                "", "§8§l● §7Neues: Kohle Blöcke","  ", "§6§l▶ §7Kaufspreis: §6" + ValuetoString.valueToString(MessageManager.MINE_19_PREIS)+ " §7Gems").build();
        ItemStack mine202 = new ItemBuilder(Material.IRON_BLOCK).setDisplayname("§8§l» §6§lMine 20").setLore("§6§l▶ §aKlicke hier§7, um die Mine zu §6kaufen§7.",
                "", "§8§l● §7Neues: Eisen Blöcke","  ", "§6§l▶ §7Kaufspreis: §6" + ValuetoString.valueToString(MessageManager.MINE_20_PREIS)+ " §7Gems").build();
        ItemStack mine212 = new ItemBuilder(Material.REDSTONE_BLOCK).setDisplayname("§8§l» §6§lMine 21").setLore("§6§l▶ §aKlicke hier§7, um die Mine zu §6kaufen§7.",
                "", "§8§l● §7Neues: Redstone Blöcke","  ", "§6§l▶ §7Kaufspreis: §6" + ValuetoString.valueToString(MessageManager.MINE_21_PREIS)+ " §7Gems").build();
        ItemStack mine222 = new ItemBuilder(Material.LAPIS_BLOCK).setDisplayname("§8§l» §6§lMine 22").setLore("§6§l▶ §aKlicke hier§7, um die Mine zu §6kaufen§7.",
                "", "§8§l● §7Neues: Lapis Blöcke","  ", "§6§l▶ §7Kaufspreis: §6" + ValuetoString.valueToString(MessageManager.MINE_22_PREIS)+ " §7Gems").build();
        ItemStack mine232 = new ItemBuilder(Material.GOLD_BLOCK).setDisplayname("§8§l» §6§lMine 23").setLore("§6§l▶ §aKlicke hier§7, um die Mine zu §6kaufen§7.",
                "", "§8§l● §7Neues: Gold Blöcke","  ", "§6§l▶ §7Kaufspreis: §6" + ValuetoString.valueToString(MessageManager.MINE_23_PREIS)+ " §7Gems").build();
        ItemStack mine242 = new ItemBuilder(Material.DIAMOND_BLOCK).setDisplayname("§8§l» §6§lMine 24").setLore("§6§l▶ §aKlicke hier§7, um die Mine zu §6kaufen§7.",
                "", "§8§l● §7Neues: Diamant Blöcke","  ", "§6§l▶ §7Kaufspreis: §6" + ValuetoString.valueToString(MessageManager.MINE_24_PREIS)+ " §7Gems").build();
        ItemStack mine252 = new ItemBuilder(Material.EMERALD_BLOCK).setDisplayname("§8§l» §6§lMine 25").setLore("§6§l▶ §aKlicke hier§7, um die Mine zu §6kaufen§7.",
                "", "§8§l● §7Neues: Smaragd Blöcke","  ", "§6§l▶ §7Kaufspreis: §6" + ValuetoString.valueToString(MessageManager.MINE_25_PREIS)+ " §7Gems").build();
        ItemStack mine262 = new ItemBuilder(Material.OBSIDIAN).setDisplayname("§8§l» §6§lMine 26").setLore("§6§l▶ §aKlicke hier§7, um die Mine zu §6kaufen§7.",
                "", "§8§l● §7Neues: Obsidian","  ", "§6§l▶ §7Kaufspreis: §6" + ValuetoString.valueToString(MessageManager.MINE_26_PREIS)+ " §7Gems").build();

        for(int i = 0; i <= 8; i++) {
            if (i != 4) {
                inv.setItem(i, glas);
            }
        }
        for(int i = 45; i <= 53; i++){
            inv.setItem(i,glas);
        }

        inv.setItem(4, picke);
        inv.setItem(9, mine11);

        int wert = 2;

        if(MinenManager.getMine(uuid) >= wert){
            inv.setItem(wert+8, mine21);
        }else {
            inv.setItem(wert+8, mine22);
        }

        wert++;

        if(MinenManager.getMine(uuid) >= wert){
            inv.setItem(wert+8, mine31);
        }else {
            inv.setItem(wert+8, mine32);
        }

        wert++;

        if(MinenManager.getMine(uuid) >= wert){
            inv.setItem(wert+8, mine41);
        }else {
            inv.setItem(wert+8, mine42);
        }

        wert++;

        if(MinenManager.getMine(uuid) >= wert){
            inv.setItem(wert+8, mine51);
        }else {
            inv.setItem(wert+8, mine52);
        }

        wert++;

        if(MinenManager.getMine(uuid) >= wert){
            inv.setItem(wert+8, mine61);
        }else {
            inv.setItem(wert+8, mine62);
        }

        wert++;

        if(MinenManager.getMine(uuid) >= wert){
            inv.setItem(wert+8, mine71);
        }else {
            inv.setItem(wert+8, mine72);
        }

        wert++;

        if(MinenManager.getMine(uuid) >= wert){
            inv.setItem(wert+8, mine81);
        }else {
            inv.setItem(wert+8, mine82);
        }

        wert++;

        if(MinenManager.getMine(uuid) >= wert){
            inv.setItem(wert+8, mine91);
        }else {
            inv.setItem(wert+8, mine92);
        }

        wert++;

        if(MinenManager.getMine(uuid) >= wert){
            inv.setItem(wert+8, mine101);
        }else {
            inv.setItem(wert+8, mine102);
        }

        wert++;

        if(MinenManager.getMine(uuid) >= wert){
            inv.setItem(wert+8, mine111);
        }else {
            inv.setItem(wert+8, mine112);
        }

        wert++;

        if(MinenManager.getMine(uuid) >= wert){
            inv.setItem(wert+8, mine121);
        }else {
            inv.setItem(wert+8, mine122);
        }

        wert++;

        if(MinenManager.getMine(uuid) >= wert){
            inv.setItem(wert+8, mine131);
        }else {
            inv.setItem(wert+8, mine132);
        }

        wert++;

        if(MinenManager.getMine(uuid) >= wert){
            inv.setItem(wert+8, mine141);
        }else {
            inv.setItem(wert+8, mine142);
        }

        wert++;

        if(MinenManager.getMine(uuid) >= wert){
            inv.setItem(wert+8, mine151);
        }else {
            inv.setItem(wert+8, mine152);
        }

        wert++;

        if(MinenManager.getMine(uuid) >= wert){
            inv.setItem(wert+8, mine161);
        }else {
            inv.setItem(wert+8, mine162);
        }

        wert++;

        if(MinenManager.getMine(uuid) >= wert){
            inv.setItem(wert+8, mine171);
        }else {
            inv.setItem(wert+8, mine172);
        }

        wert++;

        if(MinenManager.getMine(uuid) >= wert){
            inv.setItem(wert+8, mine181);
        }else {
            inv.setItem(wert+8, mine182);
        }

        wert++;

        if(MinenManager.getMine(uuid) >= wert){
            inv.setItem(wert+8, mine191);
        }else {
            inv.setItem(wert+8, mine192);
        }

        wert++;

        if(MinenManager.getMine(uuid) >= wert){
            inv.setItem(wert+8, mine201);
        }else {
            inv.setItem(wert+8, mine202);
        }

        wert++;

        if(MinenManager.getMine(uuid) >= wert){
            inv.setItem(wert+8, mine211);
        }else {
            inv.setItem(wert+8, mine212);
        }

        wert++;

        if(MinenManager.getMine(uuid) >= wert){
            inv.setItem(wert+8, mine221);
        }else {
            inv.setItem(wert+8, mine222);
        }

        wert++;

        if(MinenManager.getMine(uuid) >= wert){
            inv.setItem(wert+8, mine231);
        }else {
            inv.setItem(wert+8, mine232);
        }

        wert++;

        if(MinenManager.getMine(uuid) >= wert){
            inv.setItem(wert+8, mine241);
        }else {
            inv.setItem(wert+8, mine242);
        }

        wert++;

        if(MinenManager.getMine(uuid) >= wert){
            inv.setItem(wert+8, mine251);
        }else {
            inv.setItem(wert+8, mine252);
        }

        wert++;

        if(MinenManager.getMine(uuid) >= wert){
            inv.setItem(wert+8, mine261);
        }else {
            inv.setItem(wert+8, mine262);
        }


    }

}