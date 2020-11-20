package me.bluenitrox.school.listener;

import me.bluenitrox.school.SchoolMode;
import me.bluenitrox.school.mysql.MySQL;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PlayerQuitListener implements Listener {

    @EventHandler
    public void onQuit(PlayerQuitEvent e) {
        Player p = e.getPlayer();
        e.setQuitMessage(null);
        if(SchoolMode.playerMoney.containsKey(p.getUniqueId()) && SchoolMode.playerExp.containsKey(p.getUniqueId()) && SchoolMode.playerMine.containsKey(p.getUniqueId()) && SchoolMode.playerBlocks.containsKey(p.getUniqueId())) {
            try(PreparedStatement ps = MySQL.getConnection().prepareStatement("UPDATE spielerdaten SET money = ?, exp = ?, mine = ?, bloecke = ? WHERE spieleruuid = ?")) {
                ps.setFloat(1, SchoolMode.getPlayerMoney(p.getUniqueId()));
                ps.setFloat(2, SchoolMode.getPlayerExp(p.getUniqueId()));
                ps.setInt(3, SchoolMode.getPlayerMine(p.getUniqueId()));
                ps.setInt(4, SchoolMode.getPlayerBlocks(p.getUniqueId()));
                ps.setString(5, p.getUniqueId().toString());
                ps.executeUpdate();

                SchoolMode.playerBlocks.remove(p.getUniqueId());
                SchoolMode.playerExp.remove(p.getUniqueId());
                SchoolMode.playerMine.remove(p.getUniqueId());
                SchoolMode.playerMoney.remove(p.getUniqueId());
            }catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        //Maps aus der Main leeren
        //Daten übertragen
    }
}
