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

    /*public boolean updateMinenMap(Player p, Location loc) {
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

    }*/

    public boolean isAllowedtoMine(Player p, Location block){
        /*if(p.hasPermission(PermissionsManager.BREAK_IN_ALL_MINES)){
            return true;
        }*/

        int currMine = SchoolMode.getPlayerMine(p.getUniqueId());
        ArrayList<String> allowedMines = new ArrayList<>();

        for(int i = currMine; i >= 1; i--){
            allowedMines.add(i + "");
        }

        String mine = getMineByLocation(block);
        if(mine == null){
            return false;
        }

        if(allowedMines.contains(mine)){
            return true;
        }

        return false;
    }

    public boolean updateMinenMap(Player p, Location block){
        String mine = getMineByLocation(block);
        if(mine != null) {
            if (isAllowedtoMine(p, block)) {
                Rausch.rausch(p, block.getBlock().getType());
                RewardAPI api = new RewardAPI();
                api.checkToAddReward(p);
                int amount = Erfahrung.getErfahrungMultiplyer(p);
                ExpManager.updateXP(p.getUniqueId(), amount, false);
                BreakBlockEvent.minen.put(mine, BreakBlockEvent.minen.getOrDefault(mine, 0) + 1);
                double abgebauteBloeckeInProzent = 0.0252 * BreakBlockEvent.minen.getOrDefault(mine, 0);
                abgebauteBloeckeInProzent = ValuetoString.round(abgebauteBloeckeInProzent, 2);
                if (String.valueOf(abgebauteBloeckeInProzent).length() <= 5) {
                    TTA_Methods.sendActionBar(p, "§8» §6" + abgebauteBloeckeInProzent + "% §7der Mine ist abgebaut");
                }
                return true;
            }else {
                p.sendMessage(MessageManager.PREFIX + "§7In dieser §6Mine §7kannst du §cnoch nicht §7abbauen");
            }
        }
        return false;
    }

    public String getMineByLocation(Location loc) {
        for (int i = 1; i <= MessageManager.MAX_MINE; i++) {
            String curr = String.valueOf(i);
            if (getBlocks(curr).contains(loc)) {
                return curr;
            }
        }
        return null;
    }

    public List<Location> getBlocks(String mine){
        List<Location> locs = getEckPoints("mine" + mine);
        Location loc1 = locs.get(0);
        Location loc2 = locs.get(1);

        return getAllLocationsInside(loc1, loc2);
    }

    public List<Location> getEckPoints(String mine){
        Location loc1;
        Location loc2;
        List<Location> templist = new ArrayList<>();

        String temp = "eckpoint1" + mine;
        String temp2 = "eckpoint2" + mine;
        loc1 = new LocationManager(temp).getLocation();
        loc2 = new LocationManager(temp2).getLocation();
        templist.add(loc1);
        templist.add(loc2);
        return templist;
    }

    public List<Location> getAllLocationsInside(Location loc1, Location loc2){
        int yTop = 0;
        int yBottom = 0;
        int xTop = 0;
        int xBottom = 0;
        int zTop = 0;
        int zBottom = 0;

        List<Location> locs = new ArrayList<>();

        if(loc1.getBlockY() > loc2.getBlockY()) {
            yTop = loc1.getBlockY();
            yBottom = loc2.getBlockY();
        }else {
            yTop = loc2.getBlockY();
            yBottom = loc1.getBlockY();
        }

        if(loc1.getBlockX() > loc2.getBlockX()) {
            xTop = loc1.getBlockX();
            xBottom = loc2.getBlockX();
        }else {
            xTop = loc2.getBlockX();
            xBottom = loc1.getBlockX();
        }
        if(loc1.getBlockZ() > loc2.getBlockZ()) {
            zTop = loc1.getBlockZ();
            zBottom = loc2.getBlockZ();
        }else {
            zTop = loc2.getBlockZ();
            zBottom = loc1.getBlockZ();
        }
        for(int x = xBottom; x < xTop; x++)
            for(int y = yBottom; y < yTop; y++)
                for(int z = zBottom; z < zTop; z++)
                    locs.add(new Location(loc1.getWorld(), x, y, z));
        return locs;

    }

    public boolean isInMine(Player p, Location loc1, Location loc2){
        List<Location> getLocations = getAllLocationsInside(loc1, loc2);


        Location location = new Location(p.getLocation().getWorld(), p.getLocation().getBlockX(), p.getLocation().getBlockY(), p.getLocation().getBlockZ());

        if(getLocations.contains(location))
            return true;
        else
            return false;
    }
}

