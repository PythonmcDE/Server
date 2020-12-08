package me.bluenitrox.school.mine.manager;

import de.Herbystar.TTA.TTA_Methods;
import me.bluenitrox.school.SchoolMode;
import me.bluenitrox.school.managers.*;
import me.bluenitrox.school.listener.BreakBlockEvent;
import me.bluenitrox.school.mine.reward.RewardAPI;
import me.bluenitrox.school.mysql.MySQL;
import me.bluenitrox.school.utils.ValuetoString;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

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
        if(remove) {
            if(mine != 1) {
                mine = mine - 1;
            }else {
                return false;
            }
        }else {
            mine = mine + 1;
        }
        SchoolMode.setPlayerMine(uuid, mine);
        ScoreboardManager.setBoard(Bukkit.getPlayer(uuid));
        return true;
    }

    public static void updateMineDatabase(UUID uuid, boolean remove) {
        int mine = getMine(uuid);
        if(remove) {
            if(mine <= 1) {
                mine = mine - 1;
            }else {
                return;
            }
        }else {
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

    public void refillMine(String mine) {
        List<Location> locs = getEckPoints(mine);
        //ArrayList<HashMap<Material, Integer>> blocks = getblocksForMine(mine);
    }

    public void refillMine(Location loc1, Location loc2, ArrayList<HashMap<Material, Integer>> blocks) {

    }

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
                RewardAPI api = new RewardAPI();
                api.checkToAddReward(p);
                PlayerBreakBlockManager.updateBlocks(p.getUniqueId(), false);
                int amount = 1;
                ExpManager.updateXP(p.getUniqueId(), amount, false);
                BreakBlockEvent.minen.put(mine, BreakBlockEvent.minen.getOrDefault(mine, 0) + 1);
                double abgebauteBloeckeInProzent = 0.0051 * BreakBlockEvent.minen.getOrDefault(mine, 0);
                abgebauteBloeckeInProzent = ValuetoString.round(abgebauteBloeckeInProzent, 2);

                TTA_Methods.sendActionBar(p, "§8» §6" + abgebauteBloeckeInProzent + "% §7der Mine ist abgebaut");
                if(BreakBlockEvent.minen.get(mine) >= MessageManager.blocksforreset.get("mine" + mine)) {
                    Minenreset mr = new Minenreset();
                    mr.fillMine("mine" + mine);
                    BreakBlockEvent.minen.put(mine, 0);
                    return true;
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

        if(loc1.getBlockY() >= loc2.getBlockY()) {
            yTop = loc1.getBlockY();
            yBottom = loc2.getBlockY();
        }else {
            yTop = loc2.getBlockY();
            yBottom = loc1.getBlockY();
        }

        if(loc1.getBlockX() >= loc2.getBlockX()) {
            xTop = loc1.getBlockX();
            xBottom = loc2.getBlockX();
        }else {
            xTop = loc2.getBlockX();
            xBottom = loc1.getBlockX();
        }
        if(loc1.getBlockZ() >= loc2.getBlockZ()) {
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
