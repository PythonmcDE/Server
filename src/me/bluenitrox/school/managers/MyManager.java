package me.casper.manager;

import me.casper.mysql.MySQL;
import org.bukkit.Bukkit;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.UUID;

public class DatabaseManager {

    public void updateDatabaseValue(String table, String value, UUID uuid, long amount){
        if(isUserExist(table, uuid)) {
            try (Connection connection = MySQL.getHikariDataSource().getConnection(); PreparedStatement ps = connection.prepareStatement("UPDATE " + table + " SET " + value + " = ? WHERE spieleruuid = ?")) {
                ps.setLong(1, amount);
                ps.setString(2, uuid.toString());
                ps.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public long getDatabaseValue(String table, String value, UUID uuid){
        long amount = 0;
        if(isUserExist(table, uuid)) {
            try (Connection connection = MySQL.getHikariDataSource().getConnection(); PreparedStatement ps = connection.prepareStatement("SELECT " + value + " FROM " + table + " WHERE spieleruuid = ?")) {
                ps.setString(1, uuid.toString());

                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    amount = rs.getLong(value);
                    return amount;
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
            return amount;
        }
        return amount;
    }

    public boolean isUserExist(String table, UUID uuid){
        try(Connection connection = MySQL.getHikariDataSource().getConnection(); PreparedStatement ps = connection.prepareStatement("SELECT spieleruuid FROM " + table + " WHERE spieleruuid = ?")){
            ps.setString(1, uuid.toString());
            ResultSet rs = ps.getResultSet();
            return rs.next();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }

    public void configurateUser(String table, String[] subtable, UUID uuid){
        StringBuilder subtablesstring = new StringBuilder();
        StringBuilder questionmark = new StringBuilder();
        subtablesstring.append(subtable[0]);
        questionmark.append("?");
        for(int i = 1; i<= (subtable.length -1); i++){
            subtablesstring.append(", ").append(subtable[i]);
            questionmark.append(",?");
        }

        try(Connection connection = MySQL.getHikariDataSource().getConnection(); PreparedStatement ps = connection.prepareStatement("INSERT INTO " + table + "(" + subtablesstring.toString() + ") VALUES ("+ questionmark.toString() + ")")){
            ps.setString(1, uuid.toString());
            for(int i = 2; i<= subtable.length; i++){
                ps.setLong(i, 0);
            }
            ps.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }


}
