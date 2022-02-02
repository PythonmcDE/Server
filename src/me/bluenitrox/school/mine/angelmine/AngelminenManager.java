package me.bluenitrox.school.mine.angelmine;

import me.bluenitrox.school.SchoolMode;
import me.bluenitrox.school.mysql.MySQL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

public class AngelminenManager {

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

}
