package me.bluenitrox.school.managers;

import me.bluenitrox.school.SchoolMode;
import me.bluenitrox.school.mysql.MySQL;
import me.bluenitrox.school.utils.ValuetoString;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;


public class ExpManager {

    public static int getLevel(UUID uuid) {
        float xp = getExp(uuid);

        double level = Math.sqrt((xp / 1000));
        return (int) Math.floor(level);
    }

    public static int getLevelByXp(float xp) {
        double level = Math.sqrt((xp / 1000));
        return (int) Math.floor(level);
    }

    public static float getExpDatabase(UUID uuid) {
        float xp = 0;

        try (PreparedStatement ps = MySQL.getConnection().prepareStatement("SELECT exp FROM spielerdaten WHERE spieleruuid = ?")) {
            ps.setString(1, uuid.toString());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                xp = rs.getFloat("exp");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return xp;
    }

    public static float getExp(UUID uuid) {
        return SchoolMode.getPlayerExp(uuid);
    }

    public static void updateXP(UUID uuid, int amount, boolean remove) {
        if (remove) {
            if (getExp(uuid) >= amount) {
                float newAmount = getExp(uuid) - amount;
                SchoolMode.setPlayerExp(uuid, newAmount);
            }
        } else {
            float newAmount = getExp(uuid) + amount;
            SchoolMode.setPlayerExp(uuid, newAmount);
        }
    }

    public static boolean checkLevelUp(UUID uuid, float oldXp, float newXp) {
        double oldlevel = getLevelByXp(oldXp);
        double newLevel = getLevelByXp(newXp);
        return newLevel > oldlevel;
    }


    public static float getExpToNextLevel(UUID uuid) {
        float aktuelleXpAusDemLevel = (float)((getExp(uuid) - (1000 * Math.pow(getLevel(uuid), 2))));
        float xpZumNaechstenLevel = (float)((1000 * Math.pow((getLevel(uuid) + 1), 2)) - (1000 * Math.pow((getLevel(uuid)), 2)));

        return xpZumNaechstenLevel - aktuelleXpAusDemLevel;
    }

    public static String getExpToNextLevelString(UUID uuid) {
        float exp = getExpToNextLevel(uuid);
        return ValuetoString.valueToString(exp);
    }
}

