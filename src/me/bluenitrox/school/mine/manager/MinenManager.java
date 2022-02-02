package me.bluenitrox.school.mine.manager;

import de.Herbystar.TTA.TTA_Methods;
import me.bluenitrox.school.SchoolMode;
import me.bluenitrox.school.enchants.pickaxe.Erfahrung;
import me.bluenitrox.school.managers.*;
import me.bluenitrox.school.listener.BreakBlockEvent;
import me.bluenitrox.school.mine.reward.RewardAPI;
import me.bluenitrox.school.mysql.MySQL;
import me.bluenitrox.school.utils.ValuetoString;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class MinenManager {

    public static int getMine(UUID uuid) {
        return SchoolMode.getPlayerMine(uuid);
    }

    public static int getMineDatabase(UUID uuid) {
        int mine = 0;

        try (PreparedStatement ps = MySQL.getConnection().prepareStatement("SELECT mine FROM spielerdaten WHERE spieleruuid = ?")) {
            ps.setString(1, uuid.toString());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                mine = rs.getInt("mine");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return mine;
    }

    public static boolean updateMine(UUID uuid, boolean remove) {
        int mine = getMine(uuid);
        if (remove) {
            if (mine != 1) {
                mine = mine - 1;
            } else {
                return false;
            }
        } else {
            mine = mine + 1;
        }
        SchoolMode.setPlayerMine(uuid, mine);
        ScoreboardManager.setBoard(Bukkit.getPlayer(uuid));
        return true;
    }

    public static void updateMineDatabase(UUID uuid, boolean remove) {
        int mine = getMine(uuid);
        if (remove) {
            if (mine <= 1) {
                mine = mine - 1;
            } else {
                return;
            }
        } else {
            mine = mine + 1;
        }

        try (PreparedStatement ps = MySQL.getConnection().prepareStatement("UPDATE spielerdaten SET mine = ? WHERE spieleruuid = ?")) {
            ps.setFloat(1, mine);
            ps.setString(2, uuid.toString());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void setMine(UUID uuid, int mine) {
        SchoolMode.setPlayerMine(uuid, mine);
        ScoreboardManager.setBoard(Bukkit.getPlayer(uuid));
    }

    public static void setMineDatabase(UUID uuid, int mine) {
        try (PreparedStatement ps = MySQL.getConnection().prepareStatement("UPDATE spielerdaten SET mine = ? WHERE spieleruuid = ?")) {
            ps.setFloat(1, mine);
            ps.setString(2, uuid.toString());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean updateMinenMap(Player p, Location loc) {
        Block block = loc.getBlock();
        if (isAllowedToMine(block, p)) {
            String mine = String.valueOf(isAllowedToMineInt(block, p));
            RewardAPI api = new RewardAPI();
            api.checkToAddReward(p);
            int amount = Erfahrung.getErfahrungMultiplyer(p);
            ExpManager.updateXP(p.getUniqueId(), amount, false);
            BreakBlockEvent.minen.put(mine, BreakBlockEvent.minen.getOrDefault(mine, 0) + 1);
            double abgebauteBloeckeInProzent = 0.0052 * BreakBlockEvent.minen.getOrDefault(mine, 0);
            abgebauteBloeckeInProzent = ValuetoString.round2(abgebauteBloeckeInProzent, 2);
            if (String.valueOf(abgebauteBloeckeInProzent).length() <= 5) {
                TTA_Methods.sendActionBar(p, "§8» §6" + abgebauteBloeckeInProzent + "% §7der Mine ist abgebaut");
            }
            return true;
        }
        return false;
    }


    private boolean isAllowedToMine(Block block, Player p) {
        for (int i = 1; i <= MessageManager.MAX_MINE; i++) {
            if (getBlocks(i, block)) {
                return true;
            }
        }
        return false;
    }

    private int isAllowedToMineInt(Block block, Player p) {
        for (int i = 1; i <= MessageManager.MAX_MINE; i++) {
            if (getBlocks(i, block)) {
                return i;
            }
        }
        return 1;
    }

    public static boolean getBlocks(int i, Block block) {
        Location from = new LocationManager("eckpoint1mine" + i).getLocation();
        Location to = new LocationManager("eckpoint2mine" + i).getLocation();
        double x = block.getX();
        double y = block.getY();
        double z = block.getZ();
        double topBlockX = (double) (from.getBlockX() < to.getBlockX() ? to.getBlockX() : from.getBlockX());
        double bottomBlockX = (double) (from.getBlockX() > to.getBlockX() ? to.getBlockX() : from.getBlockX());
        double topBlockY = (double) (from.getBlockY() < to.getBlockY() ? to.getBlockY() : from.getBlockY());
        double bottomBlockY = (double) (from.getBlockY() > to.getBlockY() ? to.getBlockY() : from.getBlockY());
        double topBlockZ = (double) (from.getBlockZ() < to.getBlockZ() ? to.getBlockZ() : from.getBlockZ());
        double bottomBlockZ = (double) (from.getBlockZ() > to.getBlockZ() ? to.getBlockZ() : from.getBlockZ());
        if (x <= topBlockX && x >= bottomBlockX && y <= topBlockY && y >= bottomBlockY && z <= topBlockZ && z >= bottomBlockZ) {
            return true;
        }
        return false;
    }
}

