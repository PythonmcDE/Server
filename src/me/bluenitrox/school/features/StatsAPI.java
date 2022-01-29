package me.bluenitrox.school.features;

import me.bluenitrox.school.SchoolMode;
import me.bluenitrox.school.mysql.MySQL;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

public class StatsAPI {

    public int getChest(UUID uuid){
        return (int) SchoolMode.getPlayerChest(uuid);
    }
    public int getCase(UUID uuid){
        return (int) SchoolMode.getPlayerCases(uuid);
    }
    public int getMob(UUID uuid){
        return (int) SchoolMode.getPlayerMob(uuid);
    }

    public void updateChest(UUID uuid, float amount, boolean remove) {
        if (remove) {
            if (SchoolMode.getPlayerChest(uuid) >= amount) {
                float newAmount = SchoolMode.getPlayerChest(uuid) - amount;
                SchoolMode.setPlayerChest(uuid, (int) newAmount);
            }
        } else {
            float newAmount = SchoolMode.getPlayerChest(uuid) + amount;
            SchoolMode.setPlayerChest(uuid, (int) newAmount);
            return;
        }
    }
    public void updateCase(UUID uuid, float amount, boolean remove) {
        if (remove) {
            if (SchoolMode.getPlayerCases(uuid) >= amount) {
                float newAmount = SchoolMode.getPlayerCases(uuid) - amount;
                SchoolMode.setPlayerCase(uuid, (int) newAmount);
            }
        } else {
            float newAmount = SchoolMode.getPlayerCases(uuid) + amount;
            SchoolMode.setPlayerCase(uuid, (int) newAmount);
            return;
        }
    }
    public void updateMob(UUID uuid, float amount, boolean remove) {
        if (remove) {
            if (SchoolMode.getPlayerMob(uuid) >= amount) {
                float newAmount = SchoolMode.getPlayerMob(uuid) - amount;
                SchoolMode.setPlayerMob(uuid, (int) newAmount);
            }
        } else {
            float newAmount = SchoolMode.getPlayerMob(uuid) + amount;
            SchoolMode.setPlayerMob(uuid, (int) newAmount);
            return;
        }
    }

    public int getKillsDatabase(UUID uuid){
        int xp = 0;

        try (PreparedStatement ps = MySQL.getConnection().prepareStatement("SELECT kills FROM spielerdaten WHERE spieleruuid = ?")) {
            ps.setString(1, uuid.toString());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                xp = rs.getInt("kills");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return xp;
    }
    public int getDeathsDatabase(UUID uuid){
        int xp = 0;

        try (PreparedStatement ps = MySQL.getConnection().prepareStatement("SELECT deaths FROM spielerdaten WHERE spieleruuid = ?")) {
            ps.setString(1, uuid.toString());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                xp = rs.getInt("deaths");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return xp;
    }
    public int getCasesDatabase(UUID uuid){
        int xp = 0;

        try (PreparedStatement ps = MySQL.getConnection().prepareStatement("SELECT cases FROM spielerdaten WHERE spieleruuid = ?")) {
            ps.setString(1, uuid.toString());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                xp = rs.getInt("cases");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return xp;
    }
    public static int getMobDatabase(UUID uuid){
        int xp = 0;

        try (PreparedStatement ps = MySQL.getConnection().prepareStatement("SELECT mob FROM spielerdaten WHERE spieleruuid = ?")) {
            ps.setString(1, uuid.toString());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                xp = rs.getInt("mob");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return xp;
    }
    public int getChestsDatabase(UUID uuid){
        int xp = 0;

        try (PreparedStatement ps = MySQL.getConnection().prepareStatement("SELECT kills FROM spielerdaten WHERE spieleruuid = ?")) {
            ps.setString(1, uuid.toString());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                xp = rs.getInt("kills");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return xp;
    }

    public void updateKillsDatabase(UUID uuid, float amount, boolean remove) {
        float currMoney = getKillsDatabase(uuid);
        float newAmount;
        if (remove) {
            newAmount = currMoney - amount;
        } else {
            newAmount = (currMoney + amount);
        }
        try (PreparedStatement ps = MySQL.getConnection().prepareStatement("UPDATE spielerdaten SET kills = ? WHERE spieleruuid = ?")) {
            ps.setFloat(1, newAmount);
            ps.setString(2, uuid.toString());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void updateDeathsDatabase(UUID uuid, float amount, boolean remove) {
        float currMoney = getDeathsDatabase(uuid);
        float newAmount;
        if (remove) {
            newAmount = currMoney - amount;
        } else {
            newAmount = (currMoney + amount);
        }
        try (PreparedStatement ps = MySQL.getConnection().prepareStatement("UPDATE spielerdaten SET deaths = ? WHERE spieleruuid = ?")) {
            ps.setFloat(1, newAmount);
            ps.setString(2, uuid.toString());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void updateCasesDatabase(UUID uuid, float amount, boolean remove) {
        float currMoney = getCasesDatabase(uuid);
        float newAmount;
        if (remove) {
            newAmount = currMoney - amount;
        } else {
            newAmount = (currMoney + amount);
        }
        try (PreparedStatement ps = MySQL.getConnection().prepareStatement("UPDATE spielerdaten SET cases = ? WHERE spieleruuid = ?")) {
            ps.setFloat(1, newAmount);
            ps.setString(2, uuid.toString());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void updateMobDatabase(UUID uuid, float amount, boolean remove) {
        float currMoney = getMobDatabase(uuid);
        float newAmount;
        if (remove) {
            newAmount = currMoney - amount;
        } else {
            newAmount = (currMoney + amount);
        }
        try (PreparedStatement ps = MySQL.getConnection().prepareStatement("UPDATE spielerdaten SET mob = ? WHERE spieleruuid = ?")) {
            ps.setFloat(1, newAmount);
            ps.setString(2, uuid.toString());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void updateChestDatabase(UUID uuid, float amount, boolean remove) {
        float currMoney = getChestsDatabase(uuid);
        float newAmount;
        if (remove) {
            newAmount = currMoney - amount;
        } else {
            newAmount = (currMoney + amount);
        }
        try (PreparedStatement ps = MySQL.getConnection().prepareStatement("UPDATE spielerdaten SET chests = ? WHERE spieleruuid = ?")) {
            ps.setFloat(1, newAmount);
            ps.setString(2, uuid.toString());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
