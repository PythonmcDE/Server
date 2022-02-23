package me.bluenitrox.school.features;

import me.bluenitrox.school.SchoolMode;
import me.bluenitrox.school.mysql.MySQL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

public class SkillAPI {

    public int get(UUID uuid, String skill){
        if(SchoolMode.playerangriff.get(uuid) != null) {
            if (skill.equalsIgnoreCase("angriff")) {
                return SchoolMode.playerangriff.get(uuid);
            } else if (skill.equalsIgnoreCase("verteidigung")) {
                return SchoolMode.playerverteidigung.get(uuid);
            } else if (skill.equalsIgnoreCase("extraenergie")) {
                return SchoolMode.playerextraenergie.get(uuid);
            } else if (skill.equalsIgnoreCase("scharfschütze")) {
                return SchoolMode.playerscharfschütze.get(uuid);
            } else if (skill.equalsIgnoreCase("mining")) {
                return SchoolMode.playermining.get(uuid);
            } else if (skill.equalsIgnoreCase("handler")) {
                return SchoolMode.playerhandler.get(uuid);
            } else if (skill.equalsIgnoreCase("alchemist")) {
                return SchoolMode.playeralchemist.get(uuid);
            } else if (skill.equalsIgnoreCase("bonusloot")) {
                return SchoolMode.playerbonusloot.get(uuid);
            } else if (skill.equalsIgnoreCase("gluckspilz")) {
                return SchoolMode.playergluckspilz.get(uuid);
            }
        }
        return 0;
    }

    public int getDatabase(UUID uuid, String skill) {
        int xp = 0;

        try (Connection connection = MySQL.getHikariDataSource().getConnection(); PreparedStatement ps = connection.prepareStatement("SELECT " + skill +" FROM skills WHERE UUID = ?")) {
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
        if(SchoolMode.playerskillpunkte.get(uuid) != null) {
            return SchoolMode.playerskillpunkte.get(uuid);
        }
        return 0;
    }
    public int getSkillpunkteDatabase(UUID uuid) {
        int xp = 0;
        String skill = "skillpunkte";

        try (Connection connection = MySQL.getHikariDataSource().getConnection(); PreparedStatement ps = connection.prepareStatement("SELECT " + skill +" FROM skills WHERE UUID = ?")) {
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

    public void update(UUID uuid, int amount, boolean remove, String skill) {
        int currMoney = get(uuid,skill);
        int newAmount;
        if (remove) {
            newAmount = currMoney - amount;
        } else {
            newAmount = (currMoney + amount);
        }
        if(skill.equalsIgnoreCase("angriff")){
            SchoolMode.playerangriff.put(uuid, newAmount);
        }else if(skill.equalsIgnoreCase("verteidigung")){
            SchoolMode.playerverteidigung.put(uuid, newAmount);
        }else if(skill.equalsIgnoreCase("extraenergie")){
            SchoolMode.playerextraenergie.put(uuid, newAmount);
        }else if(skill.equalsIgnoreCase("scharfschütze")){
            SchoolMode.playerscharfschütze.put(uuid, newAmount);
        }else if(skill.equalsIgnoreCase("mining")){
            SchoolMode.playermining.put(uuid, newAmount);
        }else if(skill.equalsIgnoreCase("handler")){
            SchoolMode.playerhandler.put(uuid, newAmount);
        }else if(skill.equalsIgnoreCase("alchemist")){
            SchoolMode.playeralchemist.put(uuid, newAmount);
        }else if(skill.equalsIgnoreCase("bonusloot")){
            SchoolMode.playerbonusloot.put(uuid, newAmount);
        }else if(skill.equalsIgnoreCase("gluckspilz")){
            SchoolMode.playergluckspilz.put(uuid, newAmount);
        }
    }
    public void updateDatabase(UUID uuid, float amount, boolean remove, String skill) {
        float currMoney = getDatabase(uuid,skill);
        float newAmount;
        if (remove) {
            newAmount = currMoney - amount;
        } else {
            newAmount = (currMoney + amount);
        }
        try (Connection connection = MySQL.getHikariDataSource().getConnection(); PreparedStatement ps = connection.prepareStatement("UPDATE skills SET " + skill +" = ? WHERE UUID = ?")) {
            ps.setFloat(1, newAmount);
            ps.setString(2, uuid.toString());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateSkillpunkte(UUID uuid, int amount, boolean remove) {
        int currMoney = getSkillpunkte(uuid);
        int newAmount;
        if (remove) {
            newAmount = currMoney - amount;
        } else {
            newAmount = (currMoney + amount);
        }
        SchoolMode.playerskillpunkte.put(uuid, newAmount);

    }



}
