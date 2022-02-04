package me.bluenitrox.school.listener;

import me.bluenitrox.school.SchoolMode;
import me.bluenitrox.school.ah.AhManager;
import me.bluenitrox.school.mine.angelmine.AngelminenManager;
import me.bluenitrox.school.mysql.MySQL;
import me.bluenitrox.school.warzone.CombatAPI;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.scheduler.BukkitRunnable;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PlayerQuitListener implements Listener {

    @EventHandler
    public void onQuit(PlayerQuitEvent e) {
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
        if(SchoolMode.playerMoney.containsKey(p.getUniqueId()) && SchoolMode.playerExp.containsKey(p.getUniqueId()) && SchoolMode.playerMine.containsKey(p.getUniqueId()) && SchoolMode.playerBlocks.containsKey(p.getUniqueId()) && SchoolMode.playerlevel.containsKey(p.getUniqueId()) && SchoolMode.playercase.containsKey(p.getUniqueId())) {
            try(PreparedStatement ps = MySQL.getConnection().prepareStatement("UPDATE spielerdaten SET money = ?, exp = ?, mine = ?, bloecke = ?, level = ?, chests = ?, cases = ?,mob = ?, prestige = ?, angelmine = ? WHERE spieleruuid = ?")) {
                ps.setFloat(1, SchoolMode.getPlayerMoney(p.getUniqueId()));
                ps.setFloat(2, SchoolMode.getPlayerExp(p.getUniqueId()));
                ps.setInt(3, SchoolMode.getPlayerMine(p.getUniqueId()));
                ps.setInt(4, SchoolMode.getPlayerBlocks(p.getUniqueId()));
                ps.setInt(5, SchoolMode.playerlevel.get(p.getUniqueId()));
                ps.setInt(6, (int) SchoolMode.getPlayerChest(p.getUniqueId()));
                ps.setInt(7, SchoolMode.getPlayerCases(p.getUniqueId()));
                ps.setInt(8, SchoolMode.getPlayerMob(p.getUniqueId()));
                ps.setInt(9, SchoolMode.getPrestige(p.getUniqueId()));
                ps.setString(10, p.getUniqueId().toString());
                ps.setInt(11, SchoolMode.getPlayerAngelMine(p.getUniqueId()));
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
        if(SchoolMode.playergemlimit.containsKey(p.getUniqueId())){
            try(PreparedStatement ps = MySQL.getConnection().prepareStatement("UPDATE DailyReward SET GemLimit = ? WHERE UUID = ?")) {
                ps.setInt(1, SchoolMode.getGemLimit(p.getUniqueId()));
                ps.setString(2, p.getUniqueId().toString());
                ps.executeUpdate();

                SchoolMode.playergemlimit.remove(p.getUniqueId());
            }catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        new BukkitRunnable(){

            @Override
            public void run() {
                if(SchoolMode.playerskillpunkte.containsKey(p.getUniqueId())&&SchoolMode.playerangriff.containsKey(p.getUniqueId())&&SchoolMode.playerverteidigung.containsKey(p.getUniqueId())&&SchoolMode.playerextraenergie.containsKey(p.getUniqueId())&&SchoolMode.playerscharfschütze.containsKey(p.getUniqueId())&&SchoolMode.playermining.containsKey(p.getUniqueId())&&SchoolMode.playerhandler.containsKey(p.getUniqueId())&&SchoolMode.playeralchemist.containsKey(p.getUniqueId())){
                    try(PreparedStatement ps = MySQL.getConnection().prepareStatement("UPDATE skills SET skillpunkte = ?, angriff = ?, verteidigung = ?, extraenergie = ?, scharfschütze = ?, mining = ?, handler = ?, alchemist = ?, bonusloot = ?, gluckspilz = ? WHERE UUID = ?")) {
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
            try (PreparedStatement ps = MySQL.getConnection().prepareStatement("SELECT * FROM AhItems WHERE spieleruuid = ?")) {
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
