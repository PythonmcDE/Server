package me.bluenitrox.school.managers;

import me.bluenitrox.school.SchoolMode;
import me.bluenitrox.school.boost.Moneybooster;
import me.bluenitrox.school.mysql.MySQL;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.UUID;

public class MoneyManager {

    private static ArrayList<Player> sendChatMSG = new ArrayList<>();

    public static boolean updateMoney(UUID uuid, float amount, boolean remove, boolean beachtungVonDoubleGemBooster) {
        if (remove) {
            if (SchoolMode.getPlayerMoney(uuid) >= amount) {
                float newAmount = SchoolMode.getPlayerMoney(uuid) - amount;
                SchoolMode.setPlayerMoney(uuid, newAmount);
                ScoreboardManager.setBoard(Bukkit.getPlayer(uuid));
            }
        } else {
            if(getGemlimit(uuid) > amount) {
                if (!beachtungVonDoubleGemBooster) {
                    float newAmount = SchoolMode.getPlayerMoney(uuid) + amount;
                    SchoolMode.setPlayerMoney(uuid, newAmount);
                    ScoreboardManager.setBoard(Bukkit.getPlayer(uuid));
                    updateGemlimit(uuid,amount, true);
                    return true;
                } else {
                    Moneybooster money = new Moneybooster();
                    if (SchoolMode.getInstance().getBoostermanager().getAktivboost().stream().anyMatch((b -> b.getName().equals(money.getName())))) {
                        float newAmount = SchoolMode.getPlayerMoney(uuid) + amount;
                        SchoolMode.setPlayerMoney(uuid, newAmount * MessageManager.MONEY_BOOSTER_BOOST);
                        ScoreboardManager.setBoard(Bukkit.getPlayer(uuid));
                        updateGemlimit(uuid,amount, true);
                        return true;
                    }
                    float newAmount = SchoolMode.getPlayerMoney(uuid) + amount;
                    SchoolMode.setPlayerMoney(uuid, newAmount);
                    ScoreboardManager.setBoard(Bukkit.getPlayer(uuid));
                    updateGemlimit(uuid,amount, true);
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

    public static float getGemlimit(UUID uuid){
        return SchoolMode.getGemLimit(uuid);
    }
    public static boolean updateGemlimit(UUID uuid, float amount, boolean remove) {
        if (remove) {
            if (SchoolMode.getGemLimit(uuid) >= amount) {
                int newAmount = (int) (SchoolMode.getGemLimit(uuid) - amount);
                SchoolMode.setGemLimit(uuid, newAmount);
            }
        } else {
            int newAmount = (int) (SchoolMode.getGemLimit(uuid) + amount);
            SchoolMode.setGemLimit(uuid, newAmount);
            return true;
        }
        return true;
    }

    public static float getMoneyDatabase(UUID uuid) {
        float money = 0;

        try (PreparedStatement ps = MySQL.getConnection().prepareStatement("SELECT money FROM spielerdaten WHERE spieleruuid = ?")) {
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

        try (PreparedStatement ps = MySQL.getConnection().prepareStatement("SELECT GemLimit FROM DailyReward WHERE UUID = ?")) {
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

        try (PreparedStatement ps = MySQL.getConnection().prepareStatement("UPDATE spielerdaten SET money = ? WHERE spieleruuid = ?")) {
            ps.setFloat(1, newAmount);
            ps.setString(2, uuid.toString());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void updateGemlimitDatabase(UUID uuid, float amount, boolean remove) {
        float currMoney = getGemlimit(uuid);
        float newAmount;
        if (remove) {
            newAmount = currMoney - amount;
        } else {
            newAmount = (currMoney + amount);
        }

        try (PreparedStatement ps = MySQL.getConnection().prepareStatement("UPDATE DailyReward SET GemLimit = ? WHERE spieleruuid = ?")) {
            ps.setFloat(1, newAmount);
            ps.setString(2, uuid.toString());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

