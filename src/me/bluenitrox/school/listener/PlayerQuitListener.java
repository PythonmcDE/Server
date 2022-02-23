package me.bluenitrox.school.listener;

import me.bluenitrox.school.SchoolMode;
import me.bluenitrox.school.ah.AhManager;
import me.bluenitrox.school.mine.angelmine.AngelminenManager;
import me.bluenitrox.school.mine.manager.MinenSettings;
import me.bluenitrox.school.mysql.MySQL;
import me.bluenitrox.school.warzone.CombatAPI;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.scheduler.BukkitRunnable;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PlayerQuitListener implements Listener {

    @EventHandler
    public void onQuit(PlayerQuitEvent e) {
        MinenSettings minenSettings = new MinenSettings();
        minenSettings.savePlayer(e);
        Player p = e.getPlayer();
        e.setQuitMessage(null);
        updateDatabase(p);
        removeAhItems(e.getPlayer());
        if(SchoolMode.Pets.containsKey(p.getName())){
            SchoolMode.Pets.get(p.getName()).remove();
        }
        CombatAPI.onQuit(p);
        AngelminenManager.quitAngelmine(p);
    }

    private void updateDatabase(Player p){
        if(SchoolMode.playerMoney.containsKey(p.getUniqueId()) && SchoolMode.playerExp.containsKey(p.getUniqueId()) && SchoolMode.playerMine.containsKey(p.getUniqueId()) && SchoolMode.playerBlocks.containsKey(p.getUniqueId()) && SchoolMode.playerlevel.containsKey(p.getUniqueId()) && SchoolMode.playercase.containsKey(p.getUniqueId()) && SchoolMode.playerangelmine.containsKey(p.getUniqueId())) {
            try(Connection connection = MySQL.getHikariDataSource().getConnection(); PreparedStatement ps = connection.prepareStatement("UPDATE spielerdaten SET money = ?, exp = ?, mine = ?, bloecke = ?, level = ?, chests = ?, cases = ?,mob = ?, prestige = ?, angelmine = ? WHERE spieleruuid = ?")) {
                ps.setFloat(1, SchoolMode.getPlayerMoney(p.getUniqueId()));
                ps.setFloat(2, SchoolMode.getPlayerExp(p.getUniqueId()));
                ps.setInt(3, SchoolMode.getPlayerMine(p.getUniqueId()));
                ps.setInt(4, SchoolMode.getPlayerBlocks(p.getUniqueId()));
                ps.setInt(5, SchoolMode.playerlevel.get(p.getUniqueId()));
                ps.setInt(6, (int) SchoolMode.getPlayerChest(p.getUniqueId()));
                ps.setInt(7, SchoolMode.getPlayerCases(p.getUniqueId()));
                ps.setInt(8, SchoolMode.getPlayerMob(p.getUniqueId()));
                ps.setInt(9, SchoolMode.getPrestige(p.getUniqueId()));
                ps.setInt(10, SchoolMode.getPlayerAngelMine(p.getUniqueId()));
                ps.setString(11, p.getUniqueId().toString());
                ps.executeUpdate();

                SchoolMode.playerBlocks.remove(p.getUniqueId());
                SchoolMode.playerExp.remove(p.getUniqueId());
                SchoolMode.playerMine.remove(p.getUniqueId());
                SchoolMode.playerlevel.remove(p.getUniqueId());
                SchoolMode.playerMoney.remove(p.getUniqueId());
                SchoolMode.playercase.remove(p.getUniqueId());
                SchoolMode.playerprestige.remove(p.getUniqueId());
                SchoolMode.playerangelmine.remove(p.getUniqueId());
            }catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        if(SchoolMode.playertask.containsKey(p.getUniqueId()) && SchoolMode.playertoggletask.containsKey(p.getUniqueId())){
            try(Connection connection = MySQL.getHikariDataSource().getConnection(); PreparedStatement ps = connection.prepareStatement("UPDATE aufgaben SET aufgabenfortschritt = ? WHERE spieleruuid = ?")) {
                ps.setInt(1, SchoolMode.getPlayerTask(p.getUniqueId()));
                ps.setString(2, p.getUniqueId().toString());
                ps.executeUpdate();

                SchoolMode.playertask.remove(p.getUniqueId());
            }catch (SQLException ex) {
                ex.printStackTrace();
            }
        }

        if(SchoolMode.playertoggletask.containsKey(p.getUniqueId())){
            try(Connection connection = MySQL.getHikariDataSource().getConnection(); PreparedStatement ps = connection.prepareStatement("UPDATE aufgaben SET toggle = ? WHERE spieleruuid = ?")) {
                ps.setInt(1, SchoolMode.getPlayerToggleTask(p.getUniqueId()));
                ps.setString(2, p.getUniqueId().toString());
                ps.executeUpdate();

                SchoolMode.playertoggletask.remove(p.getUniqueId());
            }catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        if(SchoolMode.playergemlimit.containsKey(p.getUniqueId())){
            try(Connection connection = MySQL.getHikariDataSource().getConnection(); PreparedStatement ps = connection.prepareStatement("UPDATE DailyReward SET GemLimit = ? WHERE UUID = ?")) {
                ps.setInt(1, SchoolMode.getGemLimit(p.getUniqueId()));
                ps.setString(2, p.getUniqueId().toString());
                ps.executeUpdate();

                SchoolMode.playergemlimit.remove(p.getUniqueId());
            }catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        if(SchoolMode.chestBooster.containsKey(p.getUniqueId())){
            try(Connection connection = MySQL.getHikariDataSource().getConnection(); PreparedStatement ps = connection.prepareStatement("UPDATE booster SET chest = ? WHERE spieleruuid = ?")) {
                ps.setInt(1, SchoolMode.getPlayerChestBooster(p.getUniqueId()));
                ps.setString(2, p.getUniqueId().toString());
                ps.executeUpdate();
                ps.close();

                SchoolMode.chestBooster.remove(p.getUniqueId());
            }catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        if(SchoolMode.gemBooster.containsKey(p.getUniqueId())){
            try(Connection connection = MySQL.getHikariDataSource().getConnection(); PreparedStatement ps = connection.prepareStatement("UPDATE booster SET gem = ? WHERE spieleruuid = ?")) {
                ps.setInt(1, SchoolMode.getPlayerGemBooster(p.getUniqueId()));
                ps.setString(2, p.getUniqueId().toString());
                ps.executeUpdate();
                ps.close();

                SchoolMode.gemBooster.remove(p.getUniqueId());
            }catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        if(SchoolMode.xpBooster.containsKey(p.getUniqueId())){
            try(Connection connection = MySQL.getHikariDataSource().getConnection(); PreparedStatement ps = connection.prepareStatement("UPDATE booster SET xp = ? WHERE spieleruuid = ?")) {
                ps.setInt(1, SchoolMode.getPlayerXPBooster(p.getUniqueId()));
                ps.setString(2, p.getUniqueId().toString());
                ps.executeUpdate();
                ps.close();

                SchoolMode.xpBooster.remove(p.getUniqueId());
            }catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        if(SchoolMode.angelBooster.containsKey(p.getUniqueId())){
            try(Connection connection = MySQL.getHikariDataSource().getConnection(); PreparedStatement ps = connection.prepareStatement("UPDATE booster SET angel = ? WHERE spieleruuid = ?")) {
                ps.setInt(1, SchoolMode.getPlayerAngelBooster(p.getUniqueId()));
                ps.setString(2, p.getUniqueId().toString());
                ps.executeUpdate();
                ps.close();

                SchoolMode.angelBooster.remove(p.getUniqueId());
            }catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        if(SchoolMode.dungeonBooster.containsKey(p.getUniqueId())){
            try(Connection connection = MySQL.getHikariDataSource().getConnection(); PreparedStatement ps = connection.prepareStatement("UPDATE booster SET dungeon = ? WHERE spieleruuid = ?")) {
                ps.setInt(1, SchoolMode.getPlayerDungeonBooster(p.getUniqueId()));
                ps.setString(2, p.getUniqueId().toString());
                ps.executeUpdate();
                ps.close();

                SchoolMode.dungeonBooster.remove(p.getUniqueId());
            }catch (SQLException ex) {
                ex.printStackTrace();
            }
        }


        new BukkitRunnable(){

            @Override
            public void run() {
                if(SchoolMode.playerskillpunkte.containsKey(p.getUniqueId())&&SchoolMode.playerangriff.containsKey(p.getUniqueId())&&SchoolMode.playerverteidigung.containsKey(p.getUniqueId())&&SchoolMode.playerextraenergie.containsKey(p.getUniqueId())&&SchoolMode.playerscharfschütze.containsKey(p.getUniqueId())&&SchoolMode.playermining.containsKey(p.getUniqueId())&&SchoolMode.playerhandler.containsKey(p.getUniqueId())&&SchoolMode.playeralchemist.containsKey(p.getUniqueId())){
                    try(Connection connection = MySQL.getHikariDataSource().getConnection(); PreparedStatement ps = connection.prepareStatement("UPDATE skills SET skillpunkte = ?, angriff = ?, verteidigung = ?, extraenergie = ?, scharfschütze = ?, mining = ?, handler = ?, alchemist = ?, bonusloot = ?, gluckspilz = ? WHERE UUID = ?")) {
                        ps.setInt(1, SchoolMode.playerskillpunkte.get(p.getUniqueId()));
                        ps.setInt(2, SchoolMode.playerangriff.get(p.getUniqueId()));
                        ps.setInt(3, SchoolMode.playerverteidigung.get(p.getUniqueId()));
                        ps.setInt(4, SchoolMode.playerextraenergie.get(p.getUniqueId()));
                        ps.setInt(5, SchoolMode.playerscharfschütze.get(p.getUniqueId()));
                        ps.setInt(6, SchoolMode.playermining.get(p.getUniqueId()));
                        ps.setInt(7, SchoolMode.playerhandler.get(p.getUniqueId()));
                        ps.setInt(8, SchoolMode.playeralchemist.get(p.getUniqueId()));
                        ps.setInt(9, SchoolMode.playerbonusloot.get(p.getUniqueId()));
                        ps.setInt(10, SchoolMode.playergluckspilz.get(p.getUniqueId()));
                        ps.setString(11, p.getUniqueId().toString());
                        ps.executeUpdate();

                        SchoolMode.playerskillpunkte.remove(p.getUniqueId());
                        SchoolMode.playerangriff.remove(p.getUniqueId());
                        SchoolMode.playerverteidigung.remove(p.getUniqueId());
                        SchoolMode.playerextraenergie.remove(p.getUniqueId());
                        SchoolMode.playerscharfschütze.remove(p.getUniqueId());
                        SchoolMode.playermining.remove(p.getUniqueId());
                        SchoolMode.playerhandler.remove(p.getUniqueId());
                        SchoolMode.playeralchemist.remove(p.getUniqueId());
                        SchoolMode.playerbonusloot.remove(p.getUniqueId());
                        SchoolMode.playergluckspilz.remove(p.getUniqueId());
                    }catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        }.runTaskLater(SchoolMode.getInstance(), 20*10);
    }

    private void removeAhItems(Player e){
        if (AhManager.getAhItems(e.getPlayer()) != 0) {
            try (Connection connection = MySQL.getHikariDataSource().getConnection(); PreparedStatement ps = connection.prepareStatement("SELECT * FROM AhItems WHERE spieleruuid = ?")) {
                ps.setString(1, e.getPlayer().getUniqueId().toString());
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    AhManager.removeItem(rs.getInt(1));
                }
            } catch (SQLException ee) {
                ee.printStackTrace();
            }
        }
    }
}
