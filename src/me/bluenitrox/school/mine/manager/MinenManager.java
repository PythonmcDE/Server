package me.bluenitrox.school.mine.manager;

import de.Herbystar.TTA.TTA_Methods;
import me.bluenitrox.school.SchoolMode;
import me.bluenitrox.school.enchants.pickaxe.Erfahrung;
import me.bluenitrox.school.enchants.pickaxe.Rausch;
import me.bluenitrox.school.managers.*;
import me.bluenitrox.school.listener.BreakBlockEvent;
import me.bluenitrox.school.mine.reward.RewardAPI;
import me.bluenitrox.school.mysql.MySQL;
import me.bluenitrox.school.utils.ValuetoString;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;

import java.sql.Connection;
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

        try (Connection connection = MySQL.getHikariDataSource().getConnection(); PreparedStatement ps = connection.prepareStatement("SELECT mine FROM spielerdaten WHERE spieleruuid = ?")) {
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

        try (Connection connection = MySQL.getHikariDataSource().getConnection(); PreparedStatement ps = connection.prepareStatement("UPDATE spielerdaten SET mine = ? WHERE spieleruuid = ?")) {
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
        try (Connection connection = MySQL.getHikariDataSource().getConnection(); PreparedStatement ps = connection.prepareStatement("UPDATE spielerdaten SET mine = ? WHERE spieleruuid = ?")) {
            ps.setFloat(1, mine);
            ps.setString(2, uuid.toString());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean updateMinenMap(Player p, Location loc) {
        Block block = loc.getBlock();
        Bukkit.broadcastMessage(isAllowedToMineInt(block) + "");
        if (isAllowedToMineInt(block) <= getMine(p.getUniqueId())) {
            Rausch.rausch(p, block.getType());
            String mine = String.valueOf(isAllowedToMineInt(block));
            RewardAPI api = new RewardAPI();
            api.checkToAddReward(p);
            int amount = Erfahrung.getErfahrungMultiplyer(p);
            ExpManager.updateXP(p.getUniqueId(), amount, false);
            BreakBlockEvent.minen.put(mine, BreakBlockEvent.minen.getOrDefault(mine, 0) + 1);
            double abgebauteBloeckeInProzent = 0.0052 * BreakBlockEvent.minen.getOrDefault(mine, 0);
            abgebauteBloeckeInProzent = ValuetoString.round(abgebauteBloeckeInProzent, 2);
            if (String.valueOf(abgebauteBloeckeInProzent).length() <= 5) {
                TTA_Methods.sendActionBar(p, "§8» §6" + abgebauteBloeckeInProzent + "% §7der Mine ist abgebaut");
            }
            return true;
        }
        p.sendMessage(MessageManager.PREFIX + "§7Du kannst hier §cnicht §7abbauen, da du diese §6Mine §cnicht§7 besitzt!");
        return false;
    }


    private int isAllowedToMineInt(Block block) {
        for (int i = 1; i <= MessageManager.MAX_MINE; i++) {
            if (getBlocks(i).contains(block)) {
                return i;
            }
        }
        return 1;
    }

    private LinkedList<Location> getBlocks(int mine){
        LinkedList<Location> locs = getEckPoints("mine" + mine);
        Location loc1 = locs.get(0);
        Location loc2 = locs.get(1);

        return getAllLocationsInside(loc1, loc2);
    }

    private LinkedList<Location> getEckPoints(String mine){
        Location loc1;
        Location loc2;
        LinkedList<Location> templist = new LinkedList<>();

        String temp = "eckpoint1" + mine;
        String temp2 = "eckpoint2" + mine;
        loc1 = new LocationManager(temp).getLocation();
        loc2 = new LocationManager(temp2).getLocation();
        templist.add(loc1);
        templist.add(loc2);
        return templist;
    }

    private LinkedList<Location> getAllLocationsInside(Location from, Location to){


        LinkedList<Location> locs = new LinkedList<>();

        double topBlockX = (double) (from.getBlockX() < to.getBlockX() ? to.getBlockX() : from.getBlockX());
        double bottomBlockX = (double) (from.getBlockX() > to.getBlockX() ? to.getBlockX() : from.getBlockX());
        double topBlockY = (double) (from.getBlockY() < to.getBlockY() ? to.getBlockY() : from.getBlockY());
        double bottomBlockY = (double) (from.getBlockY() > to.getBlockY() ? to.getBlockY() : from.getBlockY());
        double topBlockZ = (double) (from.getBlockZ() < to.getBlockZ() ? to.getBlockZ() : from.getBlockZ());
        double bottomBlockZ = (double) (from.getBlockZ() > to.getBlockZ() ? to.getBlockZ() : from.getBlockZ());
        for(double x = bottomBlockX; x < topBlockX; x++)
            for(double y = bottomBlockY; y < topBlockY; y++)
                for(double z = bottomBlockZ; z < topBlockZ; z++)
                    locs.add(new Location(from.getWorld(), x, y, z));
        return locs;

    }
}

