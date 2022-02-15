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

    public static DataSource con;

    public static void connect() {
       /* HikariConfig config = new HikariConfig();
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
        } */
        if (con == null) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            Properties properties = new Properties();
            properties.setProperty("dataSourceClassName", "com.mysql.jdbc.Driver");
            properties.setProperty("dataSource.serverName", host);
            properties.setProperty("dataSource.portNumber", String.valueOf(port));
            properties.setProperty("dataSource.user", username);
            properties.setProperty("dataSource.password", password);
            properties.setProperty("dataSource.databaseName", database);

            HikariConfig hikariConfig = new HikariConfig(properties);
            hikariConfig.setMaximumPoolSize(10);
            hikariConfig.addDataSourceProperty("cachePrepStmts", "true");
            hikariConfig.addDataSourceProperty("prepStmtCacheSize", "250");
            hikariConfig.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");
            con = new HikariDataSource(hikariConfig);
        }
    }

    public static void disconnect() {
        if(isConnected()) {
            try {
                //con.close();
                con.getConnection().close();
                Bukkit.getConsoleSender().sendMessage("§eVerbindung §7mit §eMySQL §cgeschlossen");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static boolean isConnected() {
        return (con == null ? false : true);
    }

    public static Connection getConnection() throws SQLException {
        return con.getConnection();
    }
}

