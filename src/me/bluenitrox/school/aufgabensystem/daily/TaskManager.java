package me.bluenitrox.school.aufgabensystem.daily;

import jdk.nashorn.internal.objects.annotations.Getter;
import me.bluenitrox.school.mysql.MySQL;
import me.bluenitrox.school.utils.RandomGen;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TaskManager {

    private final int MaxPvpTask = 1;
    private final int MaxMiningTask = 1;
    private final int MaxAngelTask = 1;
    private final int MaxDungeonTask = 1;
    private final int MaxCraftingTask = 1;

    /**
     * Set the Tasks in the Database
     */
    public void createDailyTasks() {

        try(Connection connection = MySQL.getHikariDataSource().getConnection(); PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO dailytasks (pvp,mining,angel,dungeon,crafting) VALUES (?,?,?,?,?)")) {
            preparedStatement.setString(1, getRandomPvpTask());
            preparedStatement.setString(2, getRandomMiningTask());
            preparedStatement.setString(3, getRandomAngelTask());
            preparedStatement.setString(4, getRandomDungeonTask());
            preparedStatement.setString(5, getRandomCraftingTask());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        this.loadInHashMap();

    }

    /**
     * Load daily Tasks in the HashMap
     */
    private void loadInHashMap() {
        DailyTaskData data = new DailyTaskData();
        data.setDailytasks(1, this.getPvpTaskDatabase());
        data.setDailytasks(2, this.getMiningTaskDatabase());
        data.setDailytasks(3, this.getAngelTaskDatabase());
        data.setDailytasks(4, this.getDungeonTaskDatabase());
        data.setDailytasks(5, this.getCraftingTaskDatabase());
    }

    @Getter
    private String getPvpTaskDatabase() {
        try(Connection connection = MySQL.getHikariDataSource().getConnection(); PreparedStatement preparedStatement = connection.prepareStatement("SELECT pvp FROM dailytasks")) {
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()) {
                return resultSet.getString("pvp");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "";
    }

    @Getter
    private String getMiningTaskDatabase() {
        try(Connection connection = MySQL.getHikariDataSource().getConnection(); PreparedStatement preparedStatement = connection.prepareStatement("SELECT mining FROM dailytasks")) {
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()) {
                return resultSet.getString("mining");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "";
    }

    @Getter
    private String getAngelTaskDatabase() {
        try(Connection connection = MySQL.getHikariDataSource().getConnection(); PreparedStatement preparedStatement = connection.prepareStatement("SELECT angel FROM dailytasks")) {
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()) {
                return resultSet.getString("angel");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "";
    }

    @Getter
    private String getDungeonTaskDatabase() {
        try(Connection connection = MySQL.getHikariDataSource().getConnection(); PreparedStatement preparedStatement = connection.prepareStatement("SELECT dungeon FROM dailytasks")) {
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()) {
                return resultSet.getString("dungeon");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "";
    }

    @Getter
    private String getCraftingTaskDatabase() {
        try(Connection connection = MySQL.getHikariDataSource().getConnection(); PreparedStatement preparedStatement = connection.prepareStatement("SELECT crafting FROM dailytasks")) {
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()) {
                return resultSet.getString("crafting");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "";
    }

    @Getter
    private String getRandomPvpTask() {
        RandomGen randomGen = new RandomGen(1, MaxPvpTask);
        int taskid = randomGen.nextInt();
        Tasks tasks = new Tasks();
        return tasks.getPvpTask(taskid);
    }

    @Getter
    private String getRandomMiningTask() {
        RandomGen randomGen = new RandomGen(1, MaxMiningTask);
        int taskid = randomGen.nextInt();
        Tasks tasks = new Tasks();
        return tasks.getMiningTask(taskid);
    }

    @Getter
    private String getRandomAngelTask() {
        RandomGen randomGen = new RandomGen(1, MaxAngelTask);
        int taskid = randomGen.nextInt();
        Tasks tasks = new Tasks();
        return tasks.getAngelTask(taskid);
    }

    @Getter
    private String getRandomDungeonTask() {
        RandomGen randomGen = new RandomGen(1, MaxDungeonTask);
        int taskid = randomGen.nextInt();
        Tasks tasks = new Tasks();
        return tasks.getDungeonTask(taskid);
    }

    @Getter
    private String getRandomCraftingTask() {
        RandomGen randomGen = new RandomGen(1, MaxCraftingTask);
        int taskid = randomGen.nextInt();
        Tasks tasks = new Tasks();
        return tasks.getCraftingTask(taskid);
    }
}
