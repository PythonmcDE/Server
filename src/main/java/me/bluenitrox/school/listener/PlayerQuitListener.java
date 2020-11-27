package me.bluenitrox.school.listener;

import me.bluenitrox.school.SchoolMode;
import me.bluenitrox.school.ah.AhManager;
import me.bluenitrox.school.features.InventoryLoader;
import me.bluenitrox.school.mysql.MySQL;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.Inventory;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PlayerQuitListener implements Listener {

    @EventHandler
    public void onQuit(PlayerQuitEvent e) {
        Player p = e.getPlayer();
        e.setQuitMessage(null);

        if(SchoolMode.playerMoney.containsKey(p.getUniqueId()) && SchoolMode.playerExp.containsKey(p.getUniqueId()) && SchoolMode.playerMine.containsKey(p.getUniqueId()) && SchoolMode.playerBlocks.containsKey(p.getUniqueId()) && SchoolMode.playerlevel.containsKey(p.getUniqueId())) {
            try(PreparedStatement ps = MySQL.getConnection().prepareStatement("UPDATE spielerdaten SET money = ?, exp = ?, mine = ?, bloecke = ?, level = ? WHERE spieleruuid = ?")) {
                ps.setFloat(1, SchoolMode.getPlayerMoney(p.getUniqueId()));
                ps.setFloat(2, SchoolMode.getPlayerExp(p.getUniqueId()));
                ps.setInt(3, SchoolMode.getPlayerMine(p.getUniqueId()));
                ps.setInt(4, SchoolMode.getPlayerBlocks(p.getUniqueId()));
                ps.setInt(5, SchoolMode.playerlevel.get(p.getUniqueId()));
                ps.setString(6, p.getUniqueId().toString());
                ps.executeUpdate();

                SchoolMode.playerBlocks.remove(p.getUniqueId());
                SchoolMode.playerExp.remove(p.getUniqueId());
                SchoolMode.playerMine.remove(p.getUniqueId());
                SchoolMode.playerlevel.remove(p.getUniqueId());
                SchoolMode.playerMoney.remove(p.getUniqueId());
            }catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        removeAhItems(e.getPlayer());
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
