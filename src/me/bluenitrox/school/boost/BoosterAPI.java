package me.bluenitrox.school.boost;

import de.Herbystar.TTA.TTA_Methods;
import me.bluenitrox.school.SchoolMode;
import me.bluenitrox.school.boost.booster.*;
import me.bluenitrox.school.managers.*;
import me.bluenitrox.school.mysql.MySQL;
import me.bluenitrox.school.utils.Firework;
import me.bluenitrox.school.utils.GetDisplayColor;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.UUID;

public class BoosterAPI implements CommandExecutor {

    public static HashMap<String, Integer> boost = new HashMap<>();
    public static boolean xp1;
    public static boolean money1;
    public static boolean angel1;
    public static boolean dungeon1;
    public static String gemBooster = "gem";
    public static String xpBooster = "xp";
    public static String chestBooster = "chest";
    public static String angelBooster = "angel";
    public static String dungeonBooster = "dungeon";


    @Override
    public boolean onCommand(CommandSender cs, Command cmd, String label, String[] args) {
        Player p = (Player) cs;
        if(args.length == 0) {
            Inventory inv = Bukkit.createInventory(null, 9*6, BoostInv.GUI_NAME);

            BoostInv.setBoostContent(inv, p);

            p.openInventory(inv);
        }else if(args.length == 1) {

            if(args[0].equalsIgnoreCase("help")) {
                p.sendMessage(MessageManager.PREFIX + "§6[]-----------Booster-----------[]");
                p.sendMessage("§6/booster ->§f Hiermit kannst du sehen welche booster du besitzt");
                p.sendMessage("§6/booster <Boostername> -> §fHiermit aktivierst du einen booster");
                p.sendMessage("§6/booster info -> §fHier mit siehst du welche booster aktiv sind");
                if(p.hasPermission(PermissionsManager.ADDBOOSTER)) {
                    p.sendMessage("§6/booster <add/remove> <Spieler> <Boostername> <anzahl> -> §7Hier mit kannst du Spielern booster geben und wieder wegnehmen!");
                }
                p.sendMessage(MessageManager.PREFIX + "§6[]-----------Booster-----------[]");
            }else if(args[0].equalsIgnoreCase("xp")) {
                Xpbooster xp = new Xpbooster();
                if(hasEnoughBooster(p.getUniqueId(), xpBooster)) {
                    if(!SchoolMode.getInstance().getBoostermanager().getAktivboost().stream().anyMatch((b -> b.getName().equals(xp.getName())))) {

                        Bukkit.broadcastMessage(MessageManager.PREFIX + GetDisplayColor.getRankColor(GetDisplayColor.getIPermissionPlayer(p.getUniqueId())) + "§7 hat einen: " + xp.getName() + "§7 für " + xp.getLenth() + " §7Minuten gezündet");
                        for(Player all : Bukkit.getOnlinePlayers()) {
                            TTA_Methods.sendTitle(all,"§6XP-Booster",20,20,20 ,"§7von " + GetDisplayColor.getRankColor(GetDisplayColor.getIPermissionPlayer(p.getUniqueId())),20,20,20);
                            all.playSound(all.getLocation(), Sound.AMBIENCE_THUNDER, 1L , 1L);
                            all.playSound(all.getLocation(), Sound.AMBIENCE_THUNDER, 1L , 1L);
                            all.playSound(all.getLocation(), Sound.AMBIENCE_THUNDER, 1L , 1L);
                        }
                        boost.put("xp", 3600);
                        xp1 = true;

                        SchoolMode.getInstance().getBoostermanager().startBoost(new Xpbooster());

                        Firework.Firework(p);

                        /*
                        TODO update booster status in Mysql for server connectivity
                         */


                        updateBooster(p.getUniqueId(), xpBooster, 1, true);
                        return true;
                    }else {
                        p.sendMessage(MessageManager.PREFIX + "§7Du kannst keinen §d" + xp.getName() + " §7aktivieren, da bereits einer aktiv ist!");
                    }
                }else {
                    p.sendMessage(MessageManager.PREFIX + "§7Du besitzt keinen Xp-Booster.");
                }
            }else if(args[0].equalsIgnoreCase("gem")) {
                Gembooster money = new Gembooster();
                if(hasEnoughBooster(p.getUniqueId() , gemBooster)) {
                    if(!SchoolMode.getInstance().getBoostermanager().getAktivboost().stream().anyMatch((b -> b.getName().equals(money.getName())))) {

                        Bukkit.broadcastMessage(MessageManager.PREFIX + GetDisplayColor.getRankColor(GetDisplayColor.getIPermissionPlayer(p.getUniqueId())) + "§7 hat einen: " + money.getName() + "§7 für " + money.getLenth() + " §7Minuten gezündet");

                        for(Player all : Bukkit.getOnlinePlayers()) {
                            TTA_Methods.sendTitle(all,"§6Gem-Booster",20,20,20 ,"§7von " + GetDisplayColor.getRankColor(GetDisplayColor.getIPermissionPlayer(p.getUniqueId())),20,20,20);
                            all.playSound(all.getLocation(), Sound.AMBIENCE_THUNDER, 1L , 1L);
                            all.playSound(all.getLocation(), Sound.AMBIENCE_THUNDER, 1L , 1L);
                            all.playSound(all.getLocation(), Sound.AMBIENCE_THUNDER, 1L , 1L);
                        }
                        boost.put("gem", 3600);
                        money1 = true;
                        SchoolMode.getInstance().getBoostermanager().startBoost(new Gembooster());

                        Firework.Firework(p);

                        updateBooster(p.getUniqueId(), gemBooster, 1, true);
                        return true;
                    }else {
                        p.sendMessage(MessageManager.PREFIX + "§7Du kannst keinen §d" + money.getName() + " §7aktivieren, da bereits einer aktiv ist!");
                    }
                }else {
                    p.sendMessage(MessageManager.PREFIX + "§7Du besitzt keinen Gem-Booster.");
                }
            }else if(args[0].equalsIgnoreCase("angel")) {
                Angelbooster angelbooster = new Angelbooster();
                if(hasEnoughBooster(p.getUniqueId(), angelBooster)) {
                    if(!SchoolMode.getInstance().getBoostermanager().getAktivboost().stream().anyMatch((b -> b.getName().equals(angelbooster.getName())))) {

                        Bukkit.broadcastMessage(MessageManager.PREFIX + GetDisplayColor.getRankColor(GetDisplayColor.getIPermissionPlayer(p.getUniqueId())) + "§7 hat einen: " + angelbooster.getName() + "§7 für " + angelbooster.getLenth() + " §7Minuten gezündet");

                        for(Player all : Bukkit.getOnlinePlayers()) {
                            TTA_Methods.sendTitle(all,"§6Angel-Booster",20,20,20 ,"§7von " + GetDisplayColor.getRankColor(GetDisplayColor.getIPermissionPlayer(p.getUniqueId())),20,20,20);
                            all.playSound(all.getLocation(), Sound.AMBIENCE_THUNDER, 1L , 1L);
                            all.playSound(all.getLocation(), Sound.AMBIENCE_THUNDER, 1L , 1L);
                            all.playSound(all.getLocation(), Sound.AMBIENCE_THUNDER, 1L , 1L);
                        }
                        boost.put("angel", 3600);
                        angel1 = true;
                        SchoolMode.getInstance().getBoostermanager().startBoost(new Angelbooster());

                        Firework.Firework(p);


                        updateBooster(p.getUniqueId(), angelBooster, 1, true);
                        return true;
                    }else {
                        p.sendMessage(MessageManager.PREFIX + "§7Du kannst keinen §d" + angelbooster.getName() + " §7aktivieren, da bereits einer aktiv ist!");
                    }
                }else {
                    p.sendMessage(MessageManager.PREFIX + "§7Du besitzt keinen Angel-Booster.");
                }
            }else if(args[0].equalsIgnoreCase("dungeon")) {
                Dungeonbooster dungeonbooster = new Dungeonbooster();
                if(hasEnoughBooster(p.getUniqueId(), dungeonBooster)) {
                    if(!SchoolMode.getInstance().getBoostermanager().getAktivboost().stream().anyMatch((b -> b.getName().equals(dungeonbooster.getName())))) {

                        Bukkit.broadcastMessage(MessageManager.PREFIX + GetDisplayColor.getRankColor(GetDisplayColor.getIPermissionPlayer(p.getUniqueId())) + "§7 hat einen: " + dungeonbooster.getName() + "§7 für " + dungeonbooster.getLenth() + " §7Minuten gezündet");

                        for(Player all : Bukkit.getOnlinePlayers()) {
                            TTA_Methods.sendTitle(all,"§6Dungeon-Booster",20,20,20 ,"§7von " + GetDisplayColor.getRankColor(GetDisplayColor.getIPermissionPlayer(p.getUniqueId())),20,20,20);
                            all.playSound(all.getLocation(), Sound.AMBIENCE_THUNDER, 1L , 1L);
                            all.playSound(all.getLocation(), Sound.AMBIENCE_THUNDER, 1L , 1L);
                            all.playSound(all.getLocation(), Sound.AMBIENCE_THUNDER, 1L , 1L);
                        }
                        boost.put("dungeon", 3600);
                        dungeon1 = true;
                        SchoolMode.getInstance().getBoostermanager().startBoost(new Dungeonbooster());

                        Firework.Firework(p);


                        updateBooster(p.getUniqueId(), dungeonBooster, 1, true);
                        return true;
                    }else {
                        p.sendMessage(MessageManager.PREFIX + "§7Du kannst keinen §d" + dungeonbooster.getName() + " §7aktivieren, da bereits einer aktiv ist!");
                    }
                }else {
                    p.sendMessage(MessageManager.PREFIX + "§7Du besitzt keinen Angel-Booster.");
                }
            }else if(args[0].equalsIgnoreCase("chest")) {
                if(hasEnoughBooster(p.getUniqueId(), chestBooster)) {
                    Chestbooster chest = new Chestbooster();
                    Bukkit.broadcastMessage(MessageManager.PREFIX + GetDisplayColor.getRankColor(GetDisplayColor.getIPermissionPlayer(p.getUniqueId())) + "§7 hat einen: " + chest.getName() + "§7 mit " + chest.getLenth() + " §7Kisten gezündet");
                    for(Player all : Bukkit.getOnlinePlayers()) {
                        TTA_Methods.sendTitle(all,"§6Chest-Booster",20,20,20 ,"§7von " + GetDisplayColor.getRankColor(GetDisplayColor.getIPermissionPlayer(p.getUniqueId())),20,20,20);
                        all.playSound(all.getLocation(), Sound.AMBIENCE_THUNDER, 1L , 1L);
                        all.playSound(all.getLocation(), Sound.AMBIENCE_THUNDER, 1L , 1L);
                        all.playSound(all.getLocation(), Sound.AMBIENCE_THUNDER, 1L , 1L);
                    }

                    Firework.Firework(p);

                    updateBooster(p.getUniqueId(), chestBooster, 1, true);

                }else {
                    p.sendMessage(MessageManager.PREFIX + "§7Du besitzt keinen Chest-Booster.");
                }
            }else if(args[0].equalsIgnoreCase("info")) {
                p.sendMessage(MessageManager.PREFIX + "§7Hier siehst du die derzeit Aktiven Booster:");

                Xpbooster xp = new Xpbooster();
                if(SchoolMode.getInstance().getBoostermanager().getAktivboost().stream().anyMatch((b -> b.getName().equals(xp.getName())))) {
                    p.sendMessage(MessageManager.PREFIX + "§bXp-Booster: §aan");
                }else {
                    p.sendMessage(MessageManager.PREFIX + "§bXp-Booster §4aus");
                }
                Gembooster money = new Gembooster();
                if(SchoolMode.getInstance().getBoostermanager().getAktivboost().stream().anyMatch((b -> b.getName().equals(money.getName())))) {
                    p.sendMessage(MessageManager.PREFIX + "§bGem-Booster: §aan");
                }else {
                    p.sendMessage(MessageManager.PREFIX + "§bGem-Booster: §4aus");
                }
                Angelbooster angel = new Angelbooster();
                if(SchoolMode.getInstance().getBoostermanager().getAktivboost().stream().anyMatch((b -> b.getName().equals(angel.getName())))) {
                    p.sendMessage(MessageManager.PREFIX + "§bAngel-Booster: §aan");
                }else {
                    p.sendMessage(MessageManager.PREFIX + "§bAngel-Booster: §4aus");
                }
                Dungeonbooster dungeon = new Dungeonbooster();
                if(SchoolMode.getInstance().getBoostermanager().getAktivboost().stream().anyMatch((b -> b.getName().equals(dungeon.getName())))) {
                    p.sendMessage(MessageManager.PREFIX + "§bDungeon-Booster: §aan");
                }else {
                    p.sendMessage(MessageManager.PREFIX + "§bDungeon-Booster: §4aus");
                }

            }else {
                p.sendMessage(MessageManager.PREFIX + "§cFalsche Eingabe des Commands. Bitte benutze §6/booster help §c");
            }
        }else if (args.length == 4) {
            if (p.hasPermission(PermissionsManager.ADDBOOSTER)) {
                if (args[0].equalsIgnoreCase("add")) {
                    Player target = Bukkit.getPlayer(args[1]);
                    String name = args[2];
                    Integer amount = Integer.valueOf(args[3]);
                    if (name.equalsIgnoreCase("xp")) {
                        updateBooster(target.getUniqueId(), xpBooster, amount, false);
                        p.sendMessage(MessageManager.PREFIX + "§7" + target.getPlayer().getName() + " §7hat §a" + amount + "x §bXp-Booster §7bekommen");
                    } else if (name.equalsIgnoreCase("gem")) {
                        updateBooster(target.getUniqueId(), gemBooster, amount, false);
                        p.sendMessage(MessageManager.PREFIX + "§7" + target.getPlayer().getName() + " §7hat §a" + amount + "x §bGem-Booster §7bekommen");
                    }else if (name.equalsIgnoreCase("chest")) {
                        updateBooster(target.getUniqueId(), chestBooster, amount, false);
                        p.sendMessage(MessageManager.PREFIX + "§7" + target.getPlayer().getName() + " §7hat §a" + amount + "x §bChest-Booster §7bekommen");
                    }else if (name.equalsIgnoreCase("angel")) {
                        updateBooster(target.getUniqueId(), angelBooster, amount, false);
                        p.sendMessage(MessageManager.PREFIX + "§7" + target.getPlayer().getName() + " §7hat §a" + amount + "x §bAngel-Booster §7bekommen");
                    }else if (name.equalsIgnoreCase("dungeon")) {
                        updateBooster(target.getUniqueId(), dungeonBooster, amount, false);
                        p.sendMessage(MessageManager.PREFIX + "§7" + target.getPlayer().getName() + " §7hat §a" + amount + "x §bDungeon-Booster §7bekommen");
                    }  else {
                        p.sendMessage(MessageManager.FALSECOMMAND(PlayerJoinManager.language));
                    }
                } else if (args[0].equalsIgnoreCase("remove")) {
                    Player target = Bukkit.getPlayer(args[1]);
                    String name = args[2];
                    Integer amount = Integer.valueOf(args[3]);
                    if (name.equalsIgnoreCase("xp")) {
                        updateBooster(target.getUniqueId(), xpBooster, amount, true);
                        p.sendMessage(MessageManager.PREFIX + "§7Du hast §e" + target.getPlayer().getName() + "§a " + amount + "x §bXp-Booster §7removt");
                    } else if (name.equalsIgnoreCase("gem")) {
                        updateBooster(target.getUniqueId(), gemBooster, amount, true);
                        p.sendMessage(MessageManager.PREFIX + "§7Du hast §e" + target.getPlayer().getName() + "§a " + amount + "x §bMoney-Booster §7removt");
                    } else if (name.equalsIgnoreCase("chest")) {
                        updateBooster(target.getUniqueId(), chestBooster, amount, true);
                        p.sendMessage(MessageManager.PREFIX + "§7Du hast §e" + target.getPlayer().getName() + "§a " + amount + "x §bChest-Booster §7removt");
                    }else if (name.equalsIgnoreCase("angel")) {
                        updateBooster(target.getUniqueId(), angelBooster, amount, true);
                        p.sendMessage(MessageManager.PREFIX + "§7Du hast §e" + target.getPlayer().getName() + "§a " + amount + "x §bAngel-Booster §7removt");
                    }else if (name.equalsIgnoreCase("dungeon")) {
                        updateBooster(target.getUniqueId(), dungeonBooster, amount, true);
                        p.sendMessage(MessageManager.PREFIX + "§7Du hast §e" + target.getPlayer().getName() + "§a " + amount + "x §bDungeon-Booster §7removt");
                    }
                }

            } else {
                p.sendMessage(MessageManager.NOPERMISSIONS(PlayerJoinManager.language));
            }
        } else {
            p.sendMessage(MessageManager.BOOSTERARGS);
            return true;
        }
        return false;

    }

    public int getBooster(UUID uuid, String booster) {
        int amount = 0;
        if(booster.equalsIgnoreCase("chest")) {
            amount = SchoolMode.getPlayerChestBooster(uuid);
        } else if(booster.equalsIgnoreCase("xp")) {
            amount = SchoolMode.getPlayerXPBooster(uuid);
        } else if(booster.equalsIgnoreCase("gem")) {
            amount = SchoolMode.getPlayerGemBooster(uuid);
        } else if(booster.equalsIgnoreCase("angel")) {
            amount = SchoolMode.getPlayerAngelBooster(uuid);
        } else if(booster.equalsIgnoreCase("dungeon")) {
            amount  = SchoolMode.getPlayerDungeonBooster(uuid);
        }
        return amount;
    }

    public void updateBoosterDatabase(UUID uuid, String type, int amount) {

            try(Connection connection = MySQL.getHikariDataSource().getConnection(); PreparedStatement ps = connection.prepareStatement("UPDATE booster SET " + type + " = ? WHERE spieleruuid = ?")) {
                ps.setInt(1, amount);
                ps.setString(2, uuid.toString());
                ps.executeUpdate();

            }catch (SQLException ex) {
                ex.printStackTrace();
            }
    }

    public int getBoosterDatabase(UUID uuid, String booster) {
        int amount = 0;
        PreparedStatement preparedStatement;
        if(booster.equalsIgnoreCase("chest")) {
            try(Connection connection = MySQL.getHikariDataSource().getConnection(); PreparedStatement ps = connection.prepareStatement("SELECT chest FROM booster WHERE spieleruuid = ?")) {
                ps.setString(1, uuid.toString());
                ResultSet resultSet = ps.executeQuery();
                while (resultSet.next()) {
                    amount = resultSet.getInt("chest");
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        } else if(booster.equalsIgnoreCase("xp")) {
            try(Connection connection = MySQL.getHikariDataSource().getConnection(); PreparedStatement ps = connection.prepareStatement("SELECT xp FROM booster WHERE spieleruuid = ?")) {
                ps.setString(1, uuid.toString());
                ResultSet resultSet = ps.executeQuery();
                while (resultSet.next()) {
                    amount = resultSet.getInt("xp");
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        } else if(booster.equalsIgnoreCase("gem")) {
            try(Connection connection = MySQL.getHikariDataSource().getConnection(); PreparedStatement ps = connection.prepareStatement("SELECT gem FROM booster WHERE spieleruuid = ?")) {
                ps.setString(1, uuid.toString());
                ResultSet resultSet = ps.executeQuery();
                while (resultSet.next()) {
                    amount = resultSet.getInt("gem");
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        } else if(booster.equalsIgnoreCase("angel")) {
            try(Connection connection = MySQL.getHikariDataSource().getConnection(); PreparedStatement ps = connection.prepareStatement("SELECT angel FROM booster WHERE spieleruuid = ?")) {
                ps.setString(1, uuid.toString());
                ResultSet resultSet = ps.executeQuery();
                while (resultSet.next()) {
                    amount = resultSet.getInt("angel");
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        } else if(booster.equalsIgnoreCase("dungeon")) {
            try(Connection connection = MySQL.getHikariDataSource().getConnection(); PreparedStatement ps = connection.prepareStatement("SELECT dungeon FROM booster WHERE spieleruuid = ?")) {
                ps.setString(1, uuid.toString());
                ResultSet resultSet = ps.executeQuery();
                while (resultSet.next()) {
                    amount = resultSet.getInt("dungeon");
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return amount;
    }
    public void updateBooster(UUID uuid, String booster, int amount, boolean remove) {
        if(booster.equalsIgnoreCase("gem")) {
            if (remove) {
                if (getBooster(uuid, "gem") >= amount) {
                    int newAmount = getBooster(uuid, "gem") - amount;
                    SchoolMode.setPlayerGemBooster(uuid, newAmount);
                }
            } else {
                int newAmount = getBooster(uuid, "gem") + amount;
                SchoolMode.setPlayerGemBooster(uuid, newAmount);
            }
        } else if(booster.equalsIgnoreCase("xp")) {
            if (remove) {
                if (getBooster(uuid, "xp") >= amount) {
                    int newAmount = getBooster(uuid, "xp") - amount;
                    SchoolMode.setPlayerXPBooster(uuid, newAmount);
                }
            } else {
                int newAmount = getBooster(uuid, "xp") + amount;
                SchoolMode.setPlayerXPBooster(uuid, newAmount);
            }
        } else if(booster.equalsIgnoreCase("chest")) {
            if (remove) {
                if (getBooster(uuid, "chest") >= amount) {
                    int newAmount = getBooster(uuid, "chest") - amount;
                    SchoolMode.setPlayerChestBooster(uuid, newAmount);
                }
            } else {
                int newAmount = getBooster(uuid, "chest") + amount;
                SchoolMode.setPlayerChestBooster(uuid, newAmount);
            }
        } else if(booster.equalsIgnoreCase("angel")) {
            if (remove) {
                if (getBooster(uuid, "angel") >= amount) {
                    int newAmount = getBooster(uuid, "angel") - amount;
                    SchoolMode.setPlayerAngelBooster(uuid, newAmount);
                }
            } else {
                int newAmount = getBooster(uuid, "angel") + amount;
                SchoolMode.setPlayerAngelBooster(uuid, newAmount);
            }
        } else if(booster.equalsIgnoreCase("dungeon")) {
            if (remove) {
                if (getBooster(uuid, "dungeon") >= amount) {
                    int newAmount = getBooster(uuid, "dungeon") - amount;
                    SchoolMode.setPlayerDungeonBooster(uuid, newAmount);
                }
            } else {
                int newAmount = getBooster(uuid, "dungeon") + amount;
                SchoolMode.setPlayerDungeonBooster(uuid, newAmount);
            }
        }
    }
    public boolean hasEnoughBooster(UUID uuid, String booster){
        if(getBooster(uuid, booster)>= 1) {
            return true;
        }else {
            return false;
        }
    }

}