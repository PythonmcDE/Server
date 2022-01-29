package me.bluenitrox.school.commands;

import me.bluenitrox.school.SchoolMode;
import me.bluenitrox.school.managers.MessageManager;
import me.bluenitrox.school.managers.MoneyManager;
import me.bluenitrox.school.managers.PermissionsManager;
import me.bluenitrox.school.managers.PlayerJoinManager;
import me.bluenitrox.school.utils.NameFetcher;
import me.bluenitrox.school.utils.UUIDFetcher;
import me.bluenitrox.school.utils.ValuetoString;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Money implements CommandExecutor {

    private SchoolMode SchoolMode;

    @Override
    public boolean onCommand(CommandSender cs, Command cmd, String s, String[] args) {
        Player p = (Player)cs;
        if(args.length == 0){
            // /money
            p.sendMessage(MessageManager.KONTOSTAND(PlayerJoinManager.language) + SchoolMode.getPlayerMoneyString(p.getUniqueId()) + "$");
            return false;
        }else if(args.length == 1){
            // /money <Spielername>
            if(p.hasPermission(PermissionsManager.GETMONEYOTHER) || p.hasPermission(PermissionsManager.ALLPERMS)) {
                try {
                    Player t = Bukkit.getPlayer(args[0]);
                    if(t != null) {
                        p.sendMessage(MessageManager.KONTOSTANDOFOTHER + NameFetcher.getName(t.getUniqueId()) + "§7 beträgt: §6§l" + SchoolMode.getPlayerMoneyString(t.getUniqueId()) + "$");
                    }else {
                        p.sendMessage(MessageManager.KONTOSTANDOFOTHER + NameFetcher.getName(UUIDFetcher.getUUID(args[0])) + "§7 beträgt: §6§l" + ValuetoString.valueToString(MoneyManager.getMoneyDatabase(UUIDFetcher.getUUID(args[0]))) + "$");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    p.sendMessage(MessageManager.ERROR);
                }
            }else {
                p.sendMessage(MessageManager.KONTOSTAND(PlayerJoinManager.language) + SchoolMode.getPlayerMoneyString(p.getUniqueId()) + "$");
            }
            return false;
        }else if(args.length == 3){
            if(p.hasPermission(PermissionsManager.ALLPERMS) || p.hasPermission(PermissionsManager.CHANGEMONEY))
                try {
                    float amount = Float.parseFloat(args[2]);
                    Player t = Bukkit.getPlayer(args[1]);
                    if(amount > 1000000000) {
                        p.sendMessage(MessageManager.PREFIX + "§7Du kannst dem Spieler §cnicht §7so viel Geld auf einmal abziehen oder adden");
                        return false;
                    }
                    if (args[0].equalsIgnoreCase("remove")) {
                        if(t != null){
                            if(MoneyManager.getMoney(t.getUniqueId()) < amount) {
                                p.sendMessage(MessageManager.PREFIX + "§7Das Geld von dem Spieler wurde auf §c0$ §7gesetzt");
                                SchoolMode.setPlayerMoney(t.getUniqueId(), 0);
                                return false;
                            }
                            MoneyManager.updateMoney(t.getUniqueId(), amount, true, false, false);
                            t.sendMessage(MessageManager.UPDATE_KONTOSTAND(PlayerJoinManager.language));
                            if(t != p) {
                                p.sendMessage(MessageManager.UPDATE_KONTOSTAND_OTHER);
                            }
                        }else {
                            try {
                                if(MoneyManager.getMoneyDatabase(UUIDFetcher.getUUID(args[1])) < amount) {
                                    p.sendMessage(MessageManager.PREFIX + "§7Das Geld von dem Spieler wurde auf §c0$ §7gesetzt");
                                    MoneyManager.updateMoneyDatabase(UUIDFetcher.getUUID(args[1]), MoneyManager.getMoneyDatabase(UUIDFetcher.getUUID(args[1])), true);
                                    return false;
                                }
                                MoneyManager.updateMoneyDatabase(UUIDFetcher.getUUID(args[1]), amount, true);
                                p.sendMessage(MessageManager.UPDATE_KONTOSTAND_OTHER);
                            }catch (Exception e) {
                                e.printStackTrace();
                                p.sendMessage(MessageManager.ERROR);
                            }
                        }
                    } else if (args[0].equalsIgnoreCase("add")) {
                        if(t != null){
                            MoneyManager.updateMoney(t.getUniqueId(), amount, false, false, false);
                            t.sendMessage(MessageManager.UPDATE_KONTOSTAND(PlayerJoinManager.language));
                            if(t != p) {
                                p.sendMessage(MessageManager.UPDATE_KONTOSTAND_OTHER);
                            }
                        }else {
                            try {
                                MoneyManager.updateMoneyDatabase(UUIDFetcher.getUUID(args[1]), amount, false);
                                p.sendMessage(MessageManager.UPDATE_KONTOSTAND_OTHER);
                            }catch (Exception e) {
                                e.printStackTrace();
                                p.sendMessage(MessageManager.ERROR);
                            }
                        }
                    }else {
                        p.sendMessage(MessageManager.ERROR);
                    }

                }catch (Exception e){
                    e.printStackTrace();
                    p.sendMessage(MessageManager.ERROR);
                }
        }else {
            p.sendMessage(MessageManager.FALSECOMMAND(PlayerJoinManager.language));
        }
        return false;
    }
}

