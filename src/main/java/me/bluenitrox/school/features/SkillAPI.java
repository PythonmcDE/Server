package me.bluenitrox.school.features;

import me.bluenitrox.school.mysql.MySQL;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

public class SkillAPI {

    public int get(UUID uuid, String skill) {
        int xp = 0;

        try (PreparedStatement ps = MySQL.getConnection().prepareStatement("SELECT " + skill +" FROM skills WHERE UUID = ?")) {
            ps.setString(1, uuid.toString());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                xp = rs.getInt(skill);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return xp;
    }
    public int getSkillpunkte(UUID uuid) {
        int xp = 0;
        String skill = "skillpunkte";

        try (PreparedStatement ps = MySQL.getConnection().prepareStatement("SELECT " + skill +" FROM skills WHERE UUID = ?")) {
            ps.setString(1, uuid.toString());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                xp = rs.getInt(skill);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return xp;
    }

    public void update(UUID uuid, float amount, boolean remove, String skill) {
        float currMoney = get(uuid,skill);
        float newAmount;
        if (remove) {
            newAmount = currMoney - amount;
        } else {
            newAmount = (currMoney + amount);
        }
        try (PreparedStatement ps = MySQL.getConnection().prepareStatement("UPDATE skills SET " + skill +" = ? WHERE UUID = ?")) {
            ps.setFloat(1, newAmount);
            ps.setString(2, uuid.toString());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void updateSkillpunkte(UUID uuid, float amount, boolean remove) {
        String skill = "skillpunkte";
        float currMoney = getSkillpunkte(uuid);
        float newAmount;
        if (remove) {
            newAmount = currMoney - amount;
        } else {
            newAmount = (currMoney + amount);
        }
        try (PreparedStatement ps = MySQL.getConnection().prepareStatement("UPDATE skills SET " + skill +" = ? WHERE UUID = ?")) {
            ps.setFloat(1, newAmount);
            ps.setString(2, uuid.toString());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
