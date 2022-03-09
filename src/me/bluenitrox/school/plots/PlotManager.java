package me.bluenitrox.school.plots;

import me.bluenitrox.school.mysql.MySQL;
import me.bluenitrox.school.utils.UUIDFetcher;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.UUID;

public class PlotManager {

    public static boolean isUserExists(UUID uuid) {
        try (Connection connection = MySQL.getHikariDataSource().getConnection(); PreparedStatement ps = connection.prepareStatement("SELECT spieleruuid FROM plotworld WHERE spieleruuid = ?");){
            ps.setString(1, uuid.toString());
            ResultSet rs = ps.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    public static void createDatabaseuser(UUID uuid){
        try (Connection connection = MySQL.getHikariDataSource().getConnection(); PreparedStatement ps = connection.prepareStatement("INSERT INTO plotworld (spieleruuid, trust, ban) VALUES (?, ?, ?)")) {
            ps.setString(1, uuid.toString());
            ps.setString(2, "null");
            ps.setString(3, "null");
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void trustPlayer(UUID uuid, String name){
        try (Connection connection = MySQL.getHikariDataSource().getConnection(); PreparedStatement ps = connection.prepareStatement("INSERT INTO plotworld (spieleruuid, trust, ban) VALUES (?, ?, ?)")) {
            ps.setString(1, uuid.toString());
            ps.setString(2, UUIDFetcher.getUUID(name).toString());
            ps.setString(3, "null");
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void banPlayer(UUID uuid, String name){
        try (Connection connection = MySQL.getHikariDataSource().getConnection(); PreparedStatement ps = connection.prepareStatement("INSERT INTO plotworld (spieleruuid, trust, ban) VALUES (?, ?, ?)")) {
            ps.setString(1, uuid.toString());
            ps.setString(2, "null");
            ps.setString(3, UUIDFetcher.getUUID(name).toString());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void removePlayer(UUID uuid, String name){
        try (Connection connection = MySQL.getHikariDataSource().getConnection(); PreparedStatement ps = connection.prepareStatement("DELETE FROM plotworld WHERE spieleruuid = ? && ban = ?")) {
            ps.setString(1, uuid.toString());
            ps.setString(2, UUIDFetcher.getUUID(name).toString());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void removeAddPlayer(UUID uuid, String name){
        try (Connection connection = MySQL.getHikariDataSource().getConnection(); PreparedStatement ps = connection.prepareStatement("DELETE FROM plotworld WHERE spieleruuid = ? && trust = ?")) {
            ps.setString(1, uuid.toString());
            ps.setString(2, UUIDFetcher.getUUID(name).toString());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static boolean isalreadyadded(UUID uuid, String name){
        try (Connection connection = MySQL.getHikariDataSource().getConnection(); PreparedStatement ps = connection.prepareStatement("SELECT trust FROM plotworld WHERE spieleruuid = ?");){
            ps.setString(1, uuid.toString());
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                if(rs.getString("trust").equalsIgnoreCase(UUIDFetcher.getUUID(name).toString())){
                    return true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    public static boolean isalreadybanned(UUID uuid, String name){
        try (Connection connection = MySQL.getHikariDataSource().getConnection(); PreparedStatement ps = connection.prepareStatement("SELECT ban FROM plotworld WHERE spieleruuid = ?");){
            ps.setString(1, uuid.toString());
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                if(rs.getString("ban").equalsIgnoreCase(UUIDFetcher.getUUID(name).toString())){
                    return true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static LinkedList<UUID> getAlltrusted(UUID uuid){
        LinkedList<UUID> list = new LinkedList<>();
        if(isUserExists(uuid)){
            try (Connection connection = MySQL.getHikariDataSource().getConnection(); PreparedStatement ps = connection.prepareStatement("SELECT trust FROM plotworld WHERE spieleruuid = ?");){
                ps.setString(1, uuid.toString());
                ResultSet rs = ps.executeQuery();
                while (rs.next()){
                    if(!rs.getString("trust").equalsIgnoreCase("null")) {
                        list.add(UUID.fromString(rs.getString("trust")));
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return list;
    }

    public static LinkedList<UUID> getAllbanned(UUID uuid){
        LinkedList<UUID> list = new LinkedList<>();
        if(isUserExists(uuid)){
            try (Connection connection = MySQL.getHikariDataSource().getConnection(); PreparedStatement ps = connection.prepareStatement("SELECT ban FROM plotworld WHERE spieleruuid = ?");){
                ps.setString(1, uuid.toString());
                ResultSet rs = ps.executeQuery();
                while (rs.next()){
                    if(!rs.getString("ban").equalsIgnoreCase("null")) {
                        list.add(UUID.fromString(rs.getString("ban")));
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return list;
    }
}
