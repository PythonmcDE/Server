package me.bluenitrox.school.mysql;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.bukkit.Bukkit;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class MySQL {

    public static String host;
    public static String port;
    public static String database;
    public static String username;
    public static String password;

    private static Connection con;

    public static void connect() {
       HikariConfig config = new HikariConfig();
        config.setJdbcUrl("jdbc:mysql://" + host + ":" + port + "/" + database);
        config.setUsername(username);
        config.setPassword(password);
        config.addDataSourceProperty("cachePrepStmts", "true");
        config.addDataSourceProperty("prepStmtCacheSize", "250");
        config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");
        config.setMaximumPoolSize(10);
        HikariDataSource dataSource = new HikariDataSource(config);

        try {
            con = dataSource.getConnection();
            Bukkit.getConsoleSender().sendMessage("§4Verbunden §4mit §4MySQL! (3/8)");
        } catch (SQLException var4) {
            var4.printStackTrace();
            System.out.println("[SCOOLPLUGIN] MySQL FEHLER.");
            return;
        }
    }

    public static void disconnect() {
        if(isConnected()) {
            try {
                con.close();
                Bukkit.getConsoleSender().sendMessage("§eVerbindung §7mit §eMySQL §cgeschlossen");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static boolean isConnected() {
        return (con == null ? false : true);
    }


    public static Connection getConnection() {
        return con;
    }
}

