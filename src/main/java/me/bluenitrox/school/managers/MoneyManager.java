package me.bluenitrox.school.managers;

import me.bluenitrox.school.SchoolMode;
import me.bluenitrox.school.boost.Moneybooster;
import me.bluenitrox.school.mysql.MySQL;
import org.bukkit.Bukkit;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

public class MoneyManager {

    public static void updateMoney(UUID uuid, float amount, boolean remove, boolean beachtungVonDoubleGemBooster) {
        if (remove) {
            if (SchoolMode.getPlayerMoney(uuid) >= amount) {
                float newAmount = SchoolMode.getPlayerMoney(uuid) - amount;
                SchoolMode.setPlayerMoney(uuid, newAmount);
                ScoreboardManager.setBoard(Bukkit.getPlayer(uuid));
            }
        } else {
            if(!beachtungVonDoubleGemBooster) {
                float newAmount = SchoolMode.getPlayerMoney(uuid) + amount;
                SchoolMode.setPlayerMoney(uuid, newAmount);
                ScoreboardManager.setBoard(Bukkit.getPlayer(uuid));
                return;
            }else {
                Moneybooster money = new Moneybooster();
                if(SchoolMode.getInstance().getBoostermanager().getAktivboost().stream().anyMatch((b -> b.getName().equals(money.getName())))) {
                    float newAmount = SchoolMode.getPlayerMoney(uuid) + amount;
                    SchoolMode.setPlayerMoney(uuid, newAmount * MessageManager.MONEY_BOOSTER_BOOST);
                    ScoreboardManager.setBoard(Bukkit.getPlayer(uuid));
                    return;
                }
                float newAmount = SchoolMode.getPlayerMoney(uuid) + amount;
                SchoolMode.setPlayerMoney(uuid, newAmount);
                ScoreboardManager.setBoard(Bukkit.getPlayer(uuid));
                return;
            }
        }
    }

    public static float getMoney(UUID uuid){
        return SchoolMode.getPlayerMoney(uuid);
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
}

