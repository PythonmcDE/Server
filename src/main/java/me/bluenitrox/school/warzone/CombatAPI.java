package me.bluenitrox.school.warzone;

import me.bluenitrox.school.managers.LocationManager;
import me.bluenitrox.school.managers.MessageManager;
import me.bluenitrox.school.managers.WorldManager;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CombatAPI {

    private int maxwarzone = 3;

    public static HashMap<Player, Integer> fight = new HashMap<>();
    public HashMap<Player, Integer> fightwarzone = new HashMap<>();

    public void onhitCombat(EntityDamageByEntityEvent e) {
        WorldManager wm = new WorldManager();
        if (e.getEntity().getWorld().getName().equalsIgnoreCase(wm.warzone)) {
            if (e.getDamager() instanceof Player && e.getEntity() instanceof Player) {
                if (getWarzoneByLocation(e.getEntity().getLocation()) != null) {
                    Player p = (Player) e.getEntity();
                    Player d = (Player) e.getDamager();
                    if (!fightwarzone.containsKey(p)) {
                        fightwarzone.put(p, Integer.parseInt(getWarzoneByLocation(p.getLocation())));
                    }
                    if (!fightwarzone.containsKey(d)) {
                        fightwarzone.put(d, Integer.parseInt(getWarzoneByLocation(d.getLocation())));
                    }
                    fight.put(p, 30);
                    fight.put(d, 30);
                }
            }
        }
    }

    public static void onQuit(Player p){
        if(fight.containsKey(p)){
            p.damage(100);
        }
    }

    public String getWarzoneByLocation(Location loc) {
        for (int i = 1; i <= maxwarzone; i++) {
            String curr = String.valueOf(i);
            if (getBlocks(curr).contains(loc)) {
                return curr;
            }
        }
        return null;
    }

    public List<Location> getBlocks(String warzone){
        List<Location> locs = getEckPoints("warzone" + warzone);
        Location loc1 = locs.get(0);
        Location loc2 = locs.get(1);

        return getAllLocationsInside(loc1, loc2);
    }

    public List<Location> getEckPoints(String warzone){
        Location loc1;
        Location loc2;
        List<Location> templist = new ArrayList<>();

        String temp = "warzonepoint1" + warzone;
        String temp2 = "warzonepoint1" + warzone;
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

}
