package me.bluenitrox.school.dungeon.manager;

import me.bluenitrox.school.SchoolMode;
import me.bluenitrox.school.managers.LocationManager;
import me.bluenitrox.school.managers.WorldManager;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.*;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.LinkedList;

public class SafezoneManager {

    public static void safeZoneStart(){
        new BukkitRunnable() {
            @Override
            public void run() {
                if(DungeonManager.playerdungeon != null){
                    for(Entity all: Bukkit.getWorld(WorldManager.dungeon).getEntities()){
                        if(instanceOf(all)) {
                            if (getByLocation(all.getLocation()) != null) {
                                all.remove();
                            }
                        }
                    }
                }
            }
        }.runTaskTimer(SchoolMode.getInstance(), 10,10);
    }

    public static boolean instanceOf(Entity entity){
        if(entity instanceof Zombie){
            return true;
        }else if(entity instanceof Spider){
            return true;
        }else if(entity instanceof Skeleton){
            return true;
        }else if(entity instanceof Blaze){
            return true;
        }else if(entity instanceof Witch){
            return true;
        }
        return false;
    }

    public static int maxsafezone = 2;

    public static String getByLocation(Location loc) {
        for (int i = 1; i <= maxsafezone; i++) {
            String curr = String.valueOf(i);
            loc.setPitch(0);
            loc.setYaw(0);
            loc.setX(Math.round(loc.getX()));
            loc.setZ(Math.round(loc.getZ()));
            loc.setY(Math.round(loc.getY()));
            if (getBlocks(curr).contains(loc)) {
                return curr;
            }
        }
        return null;
    }

    private static LinkedList<Location> getBlocks(String warzone){
        LinkedList<Location> locs = getEckPoints("safezone" + warzone);
        Location loc1 = locs.get(0);
        Location loc2 = locs.get(1);

        return getAllLocationsInside(loc1, loc2);
    }

    private static LinkedList<Location> getEckPoints(String warzone){
        Location loc1;
        Location loc2;
        LinkedList<Location> templist = new LinkedList<>();

        String temp = "safezonepoint1" + warzone;
        String temp2 = "safezonepoint2" + warzone;
        loc1 = new LocationManager(temp).getLocation();
        loc2 = new LocationManager(temp2).getLocation();
        templist.add(loc1);
        templist.add(loc2);
        return templist;
    }

    private static LinkedList<Location> getAllLocationsInside(Location loc1, Location loc2){
        int yTop = 0;
        int yBottom = 0;
        int xTop = 0;
        int xBottom = 0;
        int zTop = 0;
        int zBottom = 0;

        LinkedList<Location> locs = new LinkedList<>();

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
