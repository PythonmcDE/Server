package me.bluenitrox.school.mine.angelmine;

import me.bluenitrox.school.SchoolMode;
import me.bluenitrox.school.mysql.MySQL;
import org.bukkit.entity.Player;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.UUID;

public class AngelminenManager {

    public static HashMap<Player, Integer> playerangelmine = new HashMap<>();
    public static HashMap<String , Integer> angelminen = new HashMap<>();

    public static int getAngelmine(UUID uuid) {
        return SchoolMode.getPlayerAngelMine(uuid);
    }

    public static int getAngelmineDatabase(UUID uuid) {
        int mine = 0;

        try (PreparedStatement ps = MySQL.getConnection().prepareStatement("SELECT angelmine FROM spielerdaten WHERE spieleruuid = ?")) {
            ps.setString(1, uuid.toString());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                mine = rs.getInt("angelmine");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return mine;
    }

    public static boolean updateMine(UUID uuid, boolean remove) {
        int mine = getAngelmine(uuid);
        if (remove) {
            if (mine != 1) {
                mine = mine - 1;
            } else {
                return false;
            }
        } else {
            mine = mine + 1;
        }
        SchoolMode.setPlayerAngelmine(uuid, mine);
        return true;
    }

    public static void setMine(UUID uuid, int mine) {
        SchoolMode.setPlayerAngelmine(uuid, mine);
    }

    public static void joinAngelmine(Player p, int angelmine){
        playerangelmine.put(p, angelmine);
        if(angelminen != null){
            if(angelminen.get(angelmine + "") != null){
                angelminen.put(angelmine+"", angelminen.get(angelmine+"") + 1);
            }else {
                angelminen.put(angelmine + "", 1);
            }
        }else {
            angelminen.put(angelmine + "", 1);
        }
    }
    public static void quitAngelmine(Player p){
        if(angelminen != null){
            if(playerangelmine != null) {
                if (angelminen.get(playerangelmine.get(p) + "") != null) {
                    angelminen.put(playerangelmine.get(p) + "", angelminen.get(playerangelmine.get(p) +"") -1);
                }
            }
        }
        if(playerangelmine != null){
            if(playerangelmine.containsKey(p)){
                playerangelmine.remove(p);
            }
        }
    }

}
