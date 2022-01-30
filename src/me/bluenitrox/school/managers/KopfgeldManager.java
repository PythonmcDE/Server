package me.bluenitrox.school.managers;

import me.bluenitrox.school.SchoolMode;
import me.bluenitrox.school.enchants.bow.Strahlen;
import me.bluenitrox.school.mysql.MySQL;
import me.bluenitrox.school.utils.KopfUtil;
import me.bluenitrox.school.utils.ValuetoString;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Map;
import java.util.UUID;

public class KopfgeldManager {

    public static int getKopfgeld(UUID uuid){
        return SchoolMode.getPlayerKopfgeld(uuid);
    }
    public static void setKopfgeld(UUID uuid, Integer kopfgeld, Player player){
        if(kopfgeld <= 1000000){
            SchoolMode.setKopfgeld(uuid, kopfgeld);
            player.sendMessage(MessageManager.PREFIX + "§7Du hast ein Kopfgeld in höhe von §a" + kopfgeld +"§7 auf " + Bukkit.getPlayer(uuid).getDisplayName() + "§7 ausgesetzt!");
            Bukkit.broadcastMessage(MessageManager.PREFIX + "§7Ein Kopfgeld in höhe von §a" + ValuetoString.valueToString(kopfgeld) + " §7wurde auf " + Bukkit.getPlayer(uuid).getDisplayName() + " §7ausgesetzt!");
        } else {
            player.sendMessage(MessageManager.PREFIX + "§7Du kannst maximal §c1Mio §7 auf jemanden aussetzen!");
        }
    }

     public static void servershutdown(){
        for(Map.Entry<UUID, Integer> entry : SchoolMode.playerkopfgeld.entrySet()) {
            UUID key = entry.getKey();
            Integer value = entry.getValue();
            insertdatabase(key, value);
        }
    }

    public static void onTartgetJoin(UUID uuid){
        if(isUserExists(uuid)) {
            int money = 0;

            try (PreparedStatement ps = MySQL.getConnection().prepareStatement("SELECT kopfgeld FROM kopfgeld WHERE spieleruuid = ?")) {
                ps.setString(1, uuid.toString());
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    money = rs.getInt("kopfgeld");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

            SchoolMode.setKopfgeld(uuid, money);
            deleteUser(uuid);
        }
    }

    public void onKill(PlayerDeathEvent e){
        if(e.getEntity() != null) {
            if(e.getEntity().getKiller() != null) {
                if (e.getEntity().getKiller() instanceof Player) {
                    if (e.getEntity() instanceof Player) {
                        Player killer = e.getEntity().getKiller();
                        Player dead = e.getEntity();
                        try {
                            if (KopfgeldManager.getKopfgeld(dead.getUniqueId()) >= 1000) {
                                MoneyManager.updateMoney(killer.getUniqueId(), KopfgeldManager.getKopfgeld(dead.getUniqueId()) ,false, false, false);
                                SchoolMode.playerkopfgeld.remove(dead.getUniqueId());
                                Bukkit.broadcastMessage(MessageManager.PREFIX + killer.getDisplayName() + "§7 hat sich das Kopfgeld von " + dead.getDisplayName() + "§7 abgeholt!");
                            }
                        }catch (NullPointerException ee){
                        }
                    }
                }
            }
        }
    }

    private static void deleteUser(UUID uuid){
        try(PreparedStatement ps = MySQL.getConnection().prepareStatement("DELETE FROM kopfgeld WHERE spieleruuid = ?")){
            ps.setString(1, uuid.toString());
            ps.executeQuery();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    private static boolean isUserExists(UUID uuid) {
        try {
            PreparedStatement ps = MySQL.getConnection().prepareStatement("SELECT spieleruuid FROM kopfgeld WHERE spieleruuid = ?");
            ps.setString(1, uuid.toString());
            ResultSet rs = ps.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static void insertdatabase(UUID uuid, Integer money){
        try (PreparedStatement ps = MySQL.getConnection().prepareStatement("INSERT INTO kopfgeld (spieleruuid, kopfgeld) VALUES (?, ?)")) {
            ps.setString(1, uuid.toString());
            ps.setInt(2, money);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
