package me.bluenitrox.school.commands;

import me.bluenitrox.school.managers.LocationManager;
import me.bluenitrox.school.managers.MessageManager;
import me.bluenitrox.school.managers.PermissionsManager;
import me.bluenitrox.school.managers.PlayerJoinManager;
import me.bluenitrox.school.mine.manager.MinenManager;
import me.bluenitrox.school.mysql.MySQL;
import me.bluenitrox.school.utils.UUIDFetcher;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Mine implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender cs, Command c, String label, String[] args) {
        if(cs instanceof Player) {
            Player p = (Player) cs;
            if(args.length == 0) {
                //TODO: minen GUI öffnen
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
                if(p.hasPermission(PermissionsManager.ALLPERMS) || p.hasPermission(PermissionsManager.TP_MINE)) {
                    try {
                        String mine = "mine";
                        int number = Integer.parseInt(args[0]);
                        if(number > MessageManager.MAX_MINE || number < 1) {
                            p.sendMessage(MessageManager.PREFIX + "§7Deine angegebene Mine §cexistiert nicht");
                            return false;
                        }

                        String mineToTp = mine + number;
                        p.teleport(new LocationManager(mineToTp).getLocation());

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
                        try (PreparedStatement ps = MySQL.getConnection().prepareStatement("INSERT INTO minen (name, eckpoint1, eckpoint2, blocksforreset) VALUES (?, ?, ?, ?)")) {
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
}