package me.bluenitrox.school.managers;

import me.bluenitrox.school.SchoolMode;
import me.bluenitrox.school.boost.Moneybooster;
import me.bluenitrox.school.boost.Xpbooster;
import me.bluenitrox.school.features.SkillAPI;
import me.bluenitrox.school.mysql.MySQL;
import me.bluenitrox.school.utils.Firework;
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
        return SchoolMode.playerlevel.get(uuid);
    }

    public static boolean checkLevelUp(float exp, float neededfornextlevel){
        if(exp >= neededfornextlevel){
            return true;
        }else {
            return false;
        }
    }

    public static float neededExp(UUID uuid){
        float xp = getExp(uuid);
        float needed = LevelManager.level.get(getLevel(uuid));
        return needed - xp;
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

    public static int getLevelDatabase(UUID uuid) {
        int xp = 0;

        try (PreparedStatement ps = MySQL.getConnection().prepareStatement("SELECT level FROM spielerdaten WHERE spieleruuid = ?")) {
            ps.setString(1, uuid.toString());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                xp = rs.getInt("level");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return xp;
    }

    public static int getPrestigeDatabase(UUID uuid) {
        int xp = 0;

        try (PreparedStatement ps = MySQL.getConnection().prepareStatement("SELECT prestige FROM spielerdaten WHERE spieleruuid = ?")) {
            ps.setString(1, uuid.toString());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                xp = rs.getInt("prestige");
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
            Xpbooster xp = new Xpbooster();
            if(SchoolMode.getInstance().getBoostermanager().getAktivboost().stream().anyMatch((b -> b.getName().equals(xp.getName())))) {
                float newAmount = getExp(uuid) + (amount*2);
                SchoolMode.setPlayerExp(uuid, newAmount);
            }else {
                float newAmount = getExp(uuid) + amount;
                SchoolMode.setPlayerExp(uuid, newAmount);
            }
        }
        for(int i = 0; i != 50; i++) {
            if (checkLevelUp(getExp(uuid), LevelManager.level.get(SchoolMode.playerlevel.get(uuid)))) {
                SchoolMode.playerlevel.put(uuid, SchoolMode.playerlevel.get(uuid) + 1);
                Bukkit.getPlayer(uuid).sendMessage(MessageManager.PREFIX + "§7Du bist im §cLevel §7aufgestiegen!");
                SkillAPI api = new SkillAPI();
                api.updateSkillpunkte(uuid, 1, false);
                Firework.Firework(Bukkit.getPlayer(uuid));
                ScoreboardManager.setBoard(Bukkit.getPlayer(uuid));
            }
        }
    }

    public static void updateLevelDatabase(UUID uuid, float amount, boolean remove) {
        float currMoney = getLevelDatabase(uuid);
        float newAmount;
        if (remove) {
            newAmount = currMoney - amount;
        } else {
            newAmount = (currMoney + amount);
        }

        try (PreparedStatement ps = MySQL.getConnection().prepareStatement("UPDATE spielerdaten SET level = ? WHERE spieleruuid = ?")) {
            ps.setFloat(1, newAmount);
            ps.setString(2, uuid.toString());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void updatePrestigeDatabase(UUID uuid, float amount, boolean remove) {
        float currMoney = getPrestigeDatabase(uuid);
        float newAmount;
        if (remove) {
            newAmount = currMoney - amount;
        } else {
            newAmount = (currMoney + amount);
        }

        try (PreparedStatement ps = MySQL.getConnection().prepareStatement("UPDATE spielerdaten SET prestige = ? WHERE spieleruuid = ?")) {
            ps.setFloat(1, newAmount);
            ps.setString(2, uuid.toString());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

