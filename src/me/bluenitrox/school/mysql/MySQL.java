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

    private static Connection connection;
    private static HikariConfig config = new HikariConfig();
    private static HikariDataSource dataSource;

    public static void connect() {
        config.setJdbcUrl("jdbc:mysql://" + host + ":" + port + "/" + database);
        config.setUsername(username);
        config.setPassword(password);
        config.addDataSourceProperty("cachePrepStmts", "true");
        config.addDataSourceProperty("prepStmtCacheSize", "250");
        config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");
        config.setMaximumPoolSize(10);
        dataSource = new HikariDataSource(config);

    }

    public static void disconnect() {
        if(isConnected()) {
            dataSource.close();
            Bukkit.getConsoleSender().sendMessage("§eVerbindung §7mit §eMySQL §cgeschlossen");
        }
    }

    public static boolean isConnected() {
        return (connection == null ? false : true);
    }


    public static DataSource getHikariDataSource() {
        return dataSource;
    }
}

