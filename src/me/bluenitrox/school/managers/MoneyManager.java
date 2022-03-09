package me.bluenitrox.school.managers;

import me.bluenitrox.school.SchoolMode;
import me.bluenitrox.school.boost.booster.Gembooster;
import me.bluenitrox.school.managers.gemlimit.GemLimit;
import me.bluenitrox.school.mysql.MySQL;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.UUID;

public class MoneyManager {

    private static ArrayList<Player> sendChatMSG = new ArrayList<>();

    public static boolean updateMoney(UUID uuid, float amount, boolean remove, boolean beachtungVonDoubleGemBooster, boolean ignoreGemlimit) {
        if (remove) {
            if (SchoolMode.getPlayerMoney(uuid) >= amount) {
                float newAmount = SchoolMode.getPlayerMoney(uuid) - amount;
                SchoolMode.setPlayerMoney(uuid, newAmount);
                ScoreboardManager.setBoard(Bukkit.getPlayer(uuid));
            }
        } else {
            if(ignoreGemlimit == true){
                if (!beachtungVonDoubleGemBooster) {
                    float newAmount = SchoolMode.getPlayerMoney(uuid) + amount;
                    SchoolMode.setPlayerMoney(uuid, newAmount);
                    ScoreboardManager.setBoard(Bukkit.getPlayer(uuid));
                    return true;
                } else {
                    Gembooster money = new Gembooster();
                    if (SchoolMode.getInstance().getBoostermanager().getAktivboost().stream().anyMatch((b -> b.getName().equals(money.getName())))) {
                        float newAmount = SchoolMode.getPlayerMoney(uuid) + (amount* MessageManager.MONEY_BOOSTER_BOOST);
                        SchoolMode.setPlayerMoney(uuid, newAmount);
                        ScoreboardManager.setBoard(Bukkit.getPlayer(uuid));
                        return true;
                    }
                    float newAmount = SchoolMode.getPlayerMoney(uuid) + amount;
                    SchoolMode.setPlayerMoney(uuid, newAmount);
                    ScoreboardManager.setBoard(Bukkit.getPlayer(uuid));
                    return true;
                }
            }
            GemLimit gemLimit = new GemLimit(uuid);
            if(gemLimit.getRestGemLimit() > amount) {
                if (!beachtungVonDoubleGemBooster) {
                    float newAmount = SchoolMode.getPlayerMoney(uuid) + amount;
                    SchoolMode.setPlayerMoney(uuid, newAmount);
                    ScoreboardManager.setBoard(Bukkit.getPlayer(uuid));
                    //updateGemlimit(uuid,amount, true);
                    return true;
                } else {
                    Gembooster money = new Gembooster();
                    if (SchoolMode.getInstance().getBoostermanager().getAktivboost().stream().anyMatch((b -> b.getName().equals(money.getName())))) {
                        float newAmount = SchoolMode.getPlayerMoney(uuid) + (amount* MessageManager.MONEY_BOOSTER_BOOST);
                        SchoolMode.setPlayerMoney(uuid, newAmount);
                        ScoreboardManager.setBoard(Bukkit.getPlayer(uuid));
                        //updateGemlimit(uuid,amount, true);
                        return true;
                    }
                    float newAmount = SchoolMode.getPlayerMoney(uuid) + amount;
                    SchoolMode.setPlayerMoney(uuid, newAmount);
                    ScoreboardManager.setBoard(Bukkit.getPlayer(uuid));
                    //updateGemlimit(uuid,amount, true);
                    return true;
                }
            }
            if(!sendChatMSG.contains(Bukkit.getPlayer(uuid))) {
                sendChatMSG.add(Bukkit.getPlayer(uuid));
                Bukkit.getPlayer(uuid).sendMessage(MessageManager.PREFIX + "§7Dein Gemlimit ist §cvoll§7, steige im §6§lLeveln §7auf, damit es  höher wird.");
                Bukkit.getPlayer(uuid).playSound(Bukkit.getPlayer(uuid).getLocation(), Sound.VILLAGER_NO, 1L, 1L);
                new BukkitRunnable(){
                    @Override
                    public void run() {
                        sendChatMSG.remove(Bukkit.getPlayer(uuid));
                    }
                }.runTaskLaterAsynchronously(SchoolMode.getInstance(), 30);
            }
            return false;
        }
        return true;
    }

    public static boolean updateMoney(UUID uuid, float amount, boolean remove, boolean beachtungVonDoubleGemBooster) {
        if (remove) {
            if (SchoolMode.getPlayerMoney(uuid) >= amount) {
                float newAmount = SchoolMode.getPlayerMoney(uuid) - amount;
                SchoolMode.setPlayerMoney(uuid, newAmount);
                ScoreboardManager.setBoard(Bukkit.getPlayer(uuid));
            }
        } else {
            GemLimit gemLimit = new GemLimit(uuid);
            if(gemLimit.getRestGemLimit() > amount) {
                if (!beachtungVonDoubleGemBooster) {
                    float newAmount = SchoolMode.getPlayerMoney(uuid) + amount;
                    SchoolMode.setPlayerMoney(uuid, newAmount);
                    ScoreboardManager.setBoard(Bukkit.getPlayer(uuid));
                   // updateGemlimit(uuid,amount, true);
                    return true;
                } else {
                    Gembooster money = new Gembooster();
                    if (SchoolMode.getInstance().getBoostermanager().getAktivboost().stream().anyMatch((b -> b.getName().equals(money.getName())))) {
                        float newAmount = SchoolMode.getPlayerMoney(uuid) + (amount* MessageManager.MONEY_BOOSTER_BOOST);
                        SchoolMode.setPlayerMoney(uuid, newAmount);
                        ScoreboardManager.setBoard(Bukkit.getPlayer(uuid));
                        //updateGemlimit(uuid,amount, true);
                        return true;
                    }
                    float newAmount = SchoolMode.getPlayerMoney(uuid) + amount;
                    SchoolMode.setPlayerMoney(uuid, newAmount);
                    ScoreboardManager.setBoard(Bukkit.getPlayer(uuid));
                    //updateGemlimit(uuid,amount, true);
                    return true;
                }
            }
            if(!sendChatMSG.contains(Bukkit.getPlayer(uuid))) {
                sendChatMSG.add(Bukkit.getPlayer(uuid));
                Bukkit.getPlayer(uuid).sendMessage(MessageManager.PREFIX + "§7Du kannst heute §ckeine §7Gems mehr verdienen.");
                Bukkit.getPlayer(uuid).playSound(Bukkit.getPlayer(uuid).getLocation(), Sound.VILLAGER_NO, 1L, 1L);
                new BukkitRunnable(){
                    @Override
                    public void run() {
                        sendChatMSG.remove(Bukkit.getPlayer(uuid));
                    }
                }.runTaskLaterAsynchronously(SchoolMode.getInstance(), 30);
            }
            return false;
        }
        return true;
    }

    public static float getMoney(UUID uuid){
        return SchoolMode.getPlayerMoney(uuid);
    }

    public static float getMoneyDatabase(UUID uuid) {
        float money = 0;

        try (Connection connection = MySQL.getHikariDataSource().getConnection(); PreparedStatement ps = connection.prepareStatement("SELECT money FROM spielerdaten WHERE spieleruuid = ?")) {
            ps.setString(1, uuid.toString());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                money = rs.getFloat("money");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return money;
    }

    public static float getGemLimitdata(UUID uuid) {
        float money = 0;

        try (Connection connection = MySQL.getHikariDataSource().getConnection(); PreparedStatement ps = connection.prepareStatement("SELECT GemLimit FROM DailyReward WHERE UUID = ?")) {
            ps.setString(1, uuid.toString());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                money = rs.getFloat("GemLimit");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return money;
    }

    public static void updateMoneyDatabase(UUID uuid, float amount, boolean remove) {
        float currMoney = getMoneyDatabase(uuid);
        float newAmount;
        if (remove) {
            newAmount = currMoney - amount;
        } else {
            newAmount = (currMoney + amount);
        }

        try (Connection connection = MySQL.getHikariDataSource().getConnection(); PreparedStatement ps = connection.prepareStatement("UPDATE spielerdaten SET money = ? WHERE spieleruuid = ?")) {
            ps.setFloat(1, newAmount);
            ps.setString(2, uuid.toString());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static float berechnungGemlimit(UUID uuid){
        int level = ExpManager.getLevel(uuid);
        float limit = 0;

        limit += 200000;
        limit += (level*200000);
        if(ExpManager.getPrestige(uuid) == 1){
            limit += 17000000;
        }else if(ExpManager.getPrestige(uuid) == 2){
            limit += 30000000;
        }else if(ExpManager.getPrestige(uuid) == 3){
            limit += 30000000;
        }

        return limit;
    }
}

