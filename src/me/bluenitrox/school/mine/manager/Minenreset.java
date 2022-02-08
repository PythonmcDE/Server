package me.bluenitrox.school.mine.manager;

import de.Herbystar.TTA.TTA_Methods;
import me.bluenitrox.school.SchoolMode;
import me.bluenitrox.school.commands.School;
import me.bluenitrox.school.managers.LocationManager;
import me.bluenitrox.school.managers.MessageManager;
import me.bluenitrox.school.managers.WorldManager;
import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.LinkedList;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;


public class Minenreset {

    private LinkedList<Material> hashmine;

    public static void fillMineServerStart() {
        for (int i = 1; i <= MessageManager.MAX_MINE; i++) {
            String mine = "mine" + i;
            Minenreset mr = new Minenreset();
            mr.fillMine(mine);
        }
    }


    public void fillMine(String mine) {
        hashmine = new LinkedList<>();
        registerHash(mine);
        String temp = "eckpoint1" + mine;
        String temp2 = "eckpoint2" + mine;
        Location eckpoint1 = new LocationManager(temp).getLocation();
        Location eckpoint2 = new LocationManager(temp2).getLocation();
        World w = Bukkit.getWorld("FISCHMC");

        if (eckpoint1 == null) {
            return;
        }
        if (eckpoint2 == null) {
            return;
        }

        int minX = Math.min(eckpoint1.getBlockX(), eckpoint2.getBlockX());
        int minY = Math.min(eckpoint1.getBlockY(), eckpoint2.getBlockY());
        int minZ = Math.min(eckpoint1.getBlockZ(), eckpoint2.getBlockZ());
        int maxX = Math.max(eckpoint1.getBlockX(), eckpoint2.getBlockX());
        int maxY = Math.max(eckpoint1.getBlockY(), eckpoint2.getBlockY()) - 1;
        int maxZ = Math.max(eckpoint1.getBlockZ(), eckpoint2.getBlockZ());

        for (int x3 = minX; x3 <= maxX; x3++) {
            for (int y3 = minY; y3 <= maxY; y3++) {
                for (int z3 = minZ; z3 <= maxZ; z3++) {
                    Block block = w.getBlockAt(x3, y3, z3);

                    int r = new Random().nextInt(100);
                    block.setType(hashmine.get(r));
                }
            }
        }
        for (Player all : Bukkit.getOnlinePlayers()) {
            if (all.getWorld().getName().equals(WorldManager.mine)) {
                if (teleportRequest(all, eckpoint1, eckpoint2, mine)) {
                    all.teleport(new LocationManager(mine).getLocation());
                    String minen = mine.replace("m", "M");
                    TTA_Methods.sendTitle(all, "§6§lMinenreset", 20, 20, 20, "§8» §7" + minen, 20, 20, 20);
                    all.playSound(all.getLocation(), Sound.NOTE_BASS, 1L, 1L);
                }
            }
        }
    }

    private void registerHash(String mine){
        if(mine.equalsIgnoreCase("mine1")){
            for(int i = 0; i< 95; i++){
                hashmine.add(Material.STONE);
            }
            for(int i = 0; i< 5; i++){
                hashmine.add(Material.GRAVEL);
            }
        }else if(mine.equalsIgnoreCase("mine2")){
            for(int i = 0; i< 98; i++){
                hashmine.add(Material.STONE);
            }
            for(int i = 0; i< 10; i++){
                hashmine.add(Material.COAL_ORE);
            }
        }else if(mine.equalsIgnoreCase("mine3")){
            for(int i = 0; i< 95; i++){
                hashmine.add(Material.STONE);
            }
            for(int i = 0; i< 15; i++){
                hashmine.add(Material.COAL_ORE);
            }
        }else if(mine.equalsIgnoreCase("mine4")){
            for(int i = 0; i< 90; i++){
                hashmine.add(Material.STONE);
            }
            for(int i = 0; i< 15; i++){
                hashmine.add(Material.COAL_ORE);
            }
            for(int i = 0; i< 5; i++){
                hashmine.add(Material.IRON_ORE);
            }
        }else if(mine.equalsIgnoreCase("mine5")){
            for(int i = 0; i< 90; i++){
                hashmine.add(Material.STONE);
            }
            for(int i = 0; i< 15; i++){
                hashmine.add(Material.COAL_ORE);
            }
            for(int i = 0; i< 10; i++){
                hashmine.add(Material.IRON_ORE);
            }
        }else if(mine.equalsIgnoreCase("mine6")){
            for(int i = 0; i< 80; i++){
                hashmine.add(Material.STONE);
            }
            for(int i = 0; i< 15; i++){
                hashmine.add(Material.COAL_ORE);
            }
            for(int i = 0; i< 10; i++){
                hashmine.add(Material.IRON_ORE);
            }
            for(int i = 0; i< 5; i++){
                hashmine.add(Material.QUARTZ_ORE);
            }
        }else if(mine.equalsIgnoreCase("mine7")){
            for(int i = 0; i< 80; i++){
                hashmine.add(Material.STONE);
            }
            for(int i = 0; i< 15; i++){
                hashmine.add(Material.COAL_ORE);
            }
            for(int i = 0; i< 10; i++){
                hashmine.add(Material.IRON_ORE);
            }
            for(int i = 0; i< 10; i++){
                hashmine.add(Material.QUARTZ_ORE);
            }
        }else if(mine.equalsIgnoreCase("mine8")){
            for(int i = 0; i< 75; i++){
                hashmine.add(Material.STONE);
            }
            for(int i = 0; i< 15; i++){
                hashmine.add(Material.COAL_ORE);
            }
            for(int i = 0; i< 10; i++){
                hashmine.add(Material.IRON_ORE);
            }
            for(int i = 0; i< 8; i++){
                hashmine.add(Material.QUARTZ_ORE);
            }
            for(int i = 0; i< 5; i++){
                hashmine.add(Material.REDSTONE_ORE);
            }
        }else if(mine.equalsIgnoreCase("mine9")){
            for(int i = 0; i< 75; i++){
                hashmine.add(Material.STONE);
            }
            for(int i = 0; i< 15; i++){
                hashmine.add(Material.COAL_ORE);
            }
            for(int i = 0; i< 10; i++){
                hashmine.add(Material.IRON_ORE);
            }
            for(int i = 0; i< 10; i++){
                hashmine.add(Material.QUARTZ_ORE);
            }
            for(int i = 0; i< 10; i++){
                hashmine.add(Material.REDSTONE_ORE);
            }
        }else if(mine.equalsIgnoreCase("mine10")){
            for(int i = 0; i< 73; i++){
                hashmine.add(Material.STONE);
            }
            for(int i = 0; i< 10; i++){
                hashmine.add(Material.COAL_ORE);
            }
            for(int i = 0; i< 10; i++){
                hashmine.add(Material.IRON_ORE);
            }
            for(int i = 0; i< 10; i++){
                hashmine.add(Material.QUARTZ_ORE);
            }
            for(int i = 0; i< 10; i++){
                hashmine.add(Material.REDSTONE_ORE);
            }
            for(int i = 0; i< 4; i++){
                hashmine.add(Material.LAPIS_ORE);
            }
        }else if(mine.equalsIgnoreCase("mine11")){
            for(int i = 0; i< 70; i++){
                hashmine.add(Material.STONE);
            }
            for(int i = 0; i< 10; i++){
                hashmine.add(Material.COAL_ORE);
            }
            for(int i = 0; i< 10; i++){
                hashmine.add(Material.IRON_ORE);
            }
            for(int i = 0; i< 10; i++){
                hashmine.add(Material.QUARTZ_ORE);
            }
            for(int i = 0; i< 10; i++){
                hashmine.add(Material.REDSTONE_ORE);
            }
            for(int i = 0; i< 7; i++){
                hashmine.add(Material.LAPIS_ORE);
            }
        }else if(mine.equalsIgnoreCase("mine12")){
            for(int i = 0; i< 65; i++){
                hashmine.add(Material.STONE);
            }
            for(int i = 0; i< 10; i++){
                hashmine.add(Material.COAL_ORE);
            }
            for(int i = 0; i< 10; i++){
                hashmine.add(Material.IRON_ORE);
            }
            for(int i = 0; i< 10; i++){
                hashmine.add(Material.QUARTZ_ORE);
            }
            for(int i = 0; i< 10; i++){
                hashmine.add(Material.REDSTONE_ORE);
            }
            for(int i = 0; i< 7; i++){
                hashmine.add(Material.LAPIS_ORE);
            }
            for(int i = 0; i< 3; i++){
                hashmine.add(Material.GOLD_ORE);
            }
        }else if(mine.equalsIgnoreCase("mine13")){
            for(int i = 0; i< 65; i++){
                hashmine.add(Material.STONE);
            }
            for(int i = 0; i< 10; i++){
                hashmine.add(Material.COAL_ORE);
            }
            for(int i = 0; i< 10; i++){
                hashmine.add(Material.IRON_ORE);
            }
            for(int i = 0; i< 10; i++){
                hashmine.add(Material.QUARTZ_ORE);
            }
            for(int i = 0; i< 10; i++){
                hashmine.add(Material.REDSTONE_ORE);
            }
            for(int i = 0; i< 7; i++){
                hashmine.add(Material.LAPIS_ORE);
            }
            for(int i = 0; i< 7; i++){
                hashmine.add(Material.GOLD_ORE);
            }
        }else if(mine.equalsIgnoreCase("mine14")){
            for(int i = 0; i< 60; i++){
                hashmine.add(Material.STONE);
            }
            for(int i = 0; i< 10; i++){
                hashmine.add(Material.COAL_ORE);
            }
            for(int i = 0; i< 10; i++){
                hashmine.add(Material.IRON_ORE);
            }
            for(int i = 0; i< 10; i++){
                hashmine.add(Material.QUARTZ_ORE);
            }
            for(int i = 0; i< 10; i++){
                hashmine.add(Material.REDSTONE_ORE);
            }
            for(int i = 0; i< 7; i++){
                hashmine.add(Material.LAPIS_ORE);
            }
            for(int i = 0; i< 7; i++){
                hashmine.add(Material.GOLD_ORE);
            }
            for(int i = 0; i< 3; i++){
                hashmine.add(Material.DIAMOND_ORE);
            }
        }else if(mine.equalsIgnoreCase("mine15")){
            for(int i = 0; i< 65; i++){
                hashmine.add(Material.STONE);
            }
            for(int i = 0; i< 10; i++){
                hashmine.add(Material.COAL_ORE);
            }
            for(int i = 0; i< 10; i++){
                hashmine.add(Material.IRON_ORE);
            }
            for(int i = 0; i< 10; i++){
                hashmine.add(Material.QUARTZ_ORE);
            }
            for(int i = 0; i< 10; i++){
                hashmine.add(Material.REDSTONE_ORE);
            }
            for(int i = 0; i< 7; i++){
                hashmine.add(Material.LAPIS_ORE);
            }
            for(int i = 0; i< 7; i++){
                hashmine.add(Material.GOLD_ORE);
            }
            for(int i = 0; i< 7; i++){
                hashmine.add(Material.DIAMOND_ORE);
            }
        }else if(mine.equalsIgnoreCase("mine16")){
            for(int i = 0; i< 60; i++){
                hashmine.add(Material.STONE);
            }
            for(int i = 0; i< 10; i++){
                hashmine.add(Material.COAL_ORE);
            }
            for(int i = 0; i< 10; i++){
                hashmine.add(Material.IRON_ORE);
            }
            for(int i = 0; i< 10; i++){
                hashmine.add(Material.QUARTZ_ORE);
            }
            for(int i = 0; i< 10; i++){
                hashmine.add(Material.REDSTONE_ORE);
            }
            for(int i = 0; i< 7; i++){
                hashmine.add(Material.LAPIS_ORE);
            }
            for(int i = 0; i< 7; i++){
                hashmine.add(Material.GOLD_ORE);
            }
            for(int i = 0; i< 7; i++){
                hashmine.add(Material.DIAMOND_ORE);
            }
            for(int i = 0; i< 4; i++){
                hashmine.add(Material.EMERALD_ORE);
            }
        }else if(mine.equalsIgnoreCase("mine17")){
            for(int i = 0; i< 60; i++){
                hashmine.add(Material.STONE);
            }
            for(int i = 0; i< 15; i++){
                hashmine.add(Material.COAL_ORE);
            }
            for(int i = 0; i< 10; i++){
                hashmine.add(Material.IRON_ORE);
            }
            for(int i = 0; i< 10; i++){
                hashmine.add(Material.QUARTZ_ORE);
            }
            for(int i = 0; i< 10; i++){
                hashmine.add(Material.REDSTONE_ORE);
            }
            for(int i = 0; i< 8; i++){
                hashmine.add(Material.LAPIS_ORE);
            }
            for(int i = 0; i< 8; i++){
                hashmine.add(Material.GOLD_ORE);
            }
            for(int i = 0; i< 8; i++){
                hashmine.add(Material.DIAMOND_ORE);
            }
            for(int i = 0; i< 8; i++){
                hashmine.add(Material.EMERALD_ORE);
            }
        }else if(mine.equalsIgnoreCase("mine18")){
            for(int i = 0; i< 60; i++){
                hashmine.add(Material.STONE);
            }
            for(int i = 0; i< 15; i++){
                hashmine.add(Material.COAL_ORE);
            }
            for(int i = 0; i< 10; i++){
                hashmine.add(Material.IRON_ORE);
            }
            for(int i = 0; i< 10; i++){
                hashmine.add(Material.QUARTZ_ORE);
            }
            for(int i = 0; i< 10; i++){
                hashmine.add(Material.REDSTONE_ORE);
            }
            for(int i = 0; i< 8; i++){
                hashmine.add(Material.LAPIS_ORE);
            }
            for(int i = 0; i< 8; i++){
                hashmine.add(Material.GOLD_ORE);
            }
            for(int i = 0; i< 8; i++){
                hashmine.add(Material.DIAMOND_ORE);
            }
            for(int i = 0; i< 8; i++){
                hashmine.add(Material.EMERALD_ORE);
            }
            for(int i = 0; i< 4; i++){
                hashmine.add(Material.QUARTZ_BLOCK);
            }
        }else if(mine.equalsIgnoreCase("mine19")){
            for(int i = 0; i< 60; i++){
                hashmine.add(Material.STONE);
            }
            for(int i = 0; i< 15; i++){
                hashmine.add(Material.COAL_ORE);
            }
            for(int i = 0; i< 10; i++){
                hashmine.add(Material.IRON_ORE);
            }
            for(int i = 0; i< 10; i++){
                hashmine.add(Material.QUARTZ_ORE);
            }
            for(int i = 0; i< 10; i++){
                hashmine.add(Material.REDSTONE_ORE);
            }
            for(int i = 0; i< 8; i++){
                hashmine.add(Material.LAPIS_ORE);
            }
            for(int i = 0; i< 8; i++){
                hashmine.add(Material.GOLD_ORE);
            }
            for(int i = 0; i< 8; i++){
                hashmine.add(Material.DIAMOND_ORE);
            }
            for(int i = 0; i< 8; i++){
                hashmine.add(Material.EMERALD_ORE);
            }
            for(int i = 0; i< 8; i++){
                hashmine.add(Material.QUARTZ_BLOCK);
            }
            for(int i = 0; i< 8; i++){
                hashmine.add(Material.COAL_BLOCK);
            }
        }else if(mine.equalsIgnoreCase("mine20")){
            for(int i = 0; i< 50; i++){
                hashmine.add(Material.STONE);
            }
            for(int i = 0; i< 15; i++){
                hashmine.add(Material.COAL_ORE);
            }
            for(int i = 0; i< 10; i++){
                hashmine.add(Material.IRON_ORE);
            }
            for(int i = 0; i< 10; i++){
                hashmine.add(Material.QUARTZ_ORE);
            }
            for(int i = 0; i< 10; i++){
                hashmine.add(Material.REDSTONE_ORE);
            }
            for(int i = 0; i< 8; i++){
                hashmine.add(Material.LAPIS_ORE);
            }
            for(int i = 0; i< 8; i++){
                hashmine.add(Material.GOLD_ORE);
            }
            for(int i = 0; i< 8; i++){
                hashmine.add(Material.DIAMOND_ORE);
            }
            for(int i = 0; i< 8; i++){
                hashmine.add(Material.EMERALD_ORE);
            }
            for(int i = 0; i< 8; i++){
                hashmine.add(Material.QUARTZ_BLOCK);
            }
            for(int i = 0; i< 8; i++){
                hashmine.add(Material.COAL_BLOCK);
            }
            for(int i = 0; i< 8; i++){
                hashmine.add(Material.IRON_BLOCK);
            }
        }else if(mine.equalsIgnoreCase("mine21")){
            for(int i = 0; i< 50; i++){
                hashmine.add(Material.STONE);
            }
            for(int i = 0; i< 15; i++){
                hashmine.add(Material.COAL_ORE);
            }
            for(int i = 0; i< 10; i++){
                hashmine.add(Material.IRON_ORE);
            }
            for(int i = 0; i< 10; i++){
                hashmine.add(Material.QUARTZ_ORE);
            }
            for(int i = 0; i< 10; i++){
                hashmine.add(Material.REDSTONE_ORE);
            }
            for(int i = 0; i< 8; i++){
                hashmine.add(Material.LAPIS_ORE);
            }
            for(int i = 0; i< 8; i++){
                hashmine.add(Material.GOLD_ORE);
            }
            for(int i = 0; i< 8; i++){
                hashmine.add(Material.DIAMOND_ORE);
            }
            for(int i = 0; i< 8; i++){
                hashmine.add(Material.EMERALD_ORE);
            }
            for(int i = 0; i< 8; i++){
                hashmine.add(Material.QUARTZ_BLOCK);
            }
            for(int i = 0; i< 8; i++){
                hashmine.add(Material.COAL_BLOCK);
            }
            for(int i = 0; i< 8; i++){
                hashmine.add(Material.IRON_BLOCK);
            }
            for(int i = 0; i< 5; i++){
                hashmine.add(Material.REDSTONE_BLOCK);
            }
        }else if(mine.equalsIgnoreCase("mine22")){
            for(int i = 0; i< 50; i++){
                hashmine.add(Material.STONE);
            }
            for(int i = 0; i< 10; i++){
                hashmine.add(Material.COAL_ORE);
            }
            for(int i = 0; i< 8; i++){
                hashmine.add(Material.IRON_ORE);
            }
            for(int i = 0; i< 8; i++){
                hashmine.add(Material.QUARTZ_ORE);
            }
            for(int i = 0; i< 8; i++){
                hashmine.add(Material.REDSTONE_ORE);
            }
            for(int i = 0; i< 8; i++){
                hashmine.add(Material.LAPIS_ORE);
            }
            for(int i = 0; i< 10; i++){
                hashmine.add(Material.GOLD_ORE);
            }
            for(int i = 0; i< 10; i++){
                hashmine.add(Material.DIAMOND_ORE);
            }
            for(int i = 0; i< 10; i++){
                hashmine.add(Material.EMERALD_ORE);
            }
            for(int i = 0; i< 8; i++){
                hashmine.add(Material.QUARTZ_BLOCK);
            }
            for(int i = 0; i< 8; i++){
                hashmine.add(Material.COAL_BLOCK);
            }
            for(int i = 0; i< 8; i++){
                hashmine.add(Material.IRON_BLOCK);
            }
            for(int i = 0; i< 5; i++){
                hashmine.add(Material.LAPIS_BLOCK);
            }
        }else if(mine.equalsIgnoreCase("mine23")){
            for(int i = 0; i< 45; i++){
                hashmine.add(Material.STONE);
            }
            for(int i = 0; i< 8; i++){
                hashmine.add(Material.IRON_ORE);
            }
            for(int i = 0; i< 8; i++){
                hashmine.add(Material.QUARTZ_ORE);
            }
            for(int i = 0; i< 8; i++){
                hashmine.add(Material.REDSTONE_ORE);
            }
            for(int i = 0; i< 8; i++){
                hashmine.add(Material.LAPIS_ORE);
            }
            for(int i = 0; i< 10; i++){
                hashmine.add(Material.GOLD_ORE);
            }
            for(int i = 0; i< 10; i++){
                hashmine.add(Material.DIAMOND_ORE);
            }
            for(int i = 0; i< 10; i++){
                hashmine.add(Material.EMERALD_ORE);
            }
            for(int i = 0; i< 8; i++){
                hashmine.add(Material.QUARTZ_BLOCK);
            }
            for(int i = 0; i< 8; i++){
                hashmine.add(Material.COAL_BLOCK);
            }
            for(int i = 0; i< 8; i++){
                hashmine.add(Material.IRON_BLOCK);
            }
            for(int i = 0; i< 8; i++){
                hashmine.add(Material.LAPIS_BLOCK);
            }
            for(int i = 0; i< 5; i++){
                hashmine.add(Material.GOLD_BLOCK);
            }
        }else if(mine.equalsIgnoreCase("mine24")){
            for(int i = 0; i< 45; i++){
                hashmine.add(Material.STONE);
            }
            for(int i = 0; i< 8; i++){
                hashmine.add(Material.QUARTZ_ORE);
            }
            for(int i = 0; i< 8; i++){
                hashmine.add(Material.REDSTONE_ORE);
            }
            for(int i = 0; i< 8; i++){
                hashmine.add(Material.LAPIS_ORE);
            }
            for(int i = 0; i< 10; i++){
                hashmine.add(Material.GOLD_ORE);
            }
            for(int i = 0; i< 10; i++){
                hashmine.add(Material.DIAMOND_ORE);
            }
            for(int i = 0; i< 14; i++){
                hashmine.add(Material.EMERALD_ORE);
            }
            for(int i = 0; i< 8; i++){
                hashmine.add(Material.QUARTZ_BLOCK);
            }
            for(int i = 0; i< 8; i++){
                hashmine.add(Material.COAL_BLOCK);
            }
            for(int i = 0; i< 8; i++){
                hashmine.add(Material.IRON_BLOCK);
            }
            for(int i = 0; i< 8; i++){
                hashmine.add(Material.LAPIS_BLOCK);
            }
            for(int i = 0; i< 8; i++){
                hashmine.add(Material.GOLD_BLOCK);
            }
            for(int i = 0; i< 5; i++){
                hashmine.add(Material.DIAMOND_BLOCK);
            }
        }else if(mine.equalsIgnoreCase("mine25")){
            for(int i = 0; i< 45; i++){
                hashmine.add(Material.STONE);
            }
            for(int i = 0; i< 8; i++){
                hashmine.add(Material.REDSTONE_ORE);
            }
            for(int i = 0; i< 8; i++){
                hashmine.add(Material.LAPIS_ORE);
            }
            for(int i = 0; i< 10; i++){
                hashmine.add(Material.GOLD_ORE);
            }
            for(int i = 0; i< 10; i++){
                hashmine.add(Material.DIAMOND_ORE);
            }
            for(int i = 0; i< 14; i++){
                hashmine.add(Material.EMERALD_ORE);
            }
            for(int i = 0; i< 8; i++){
                hashmine.add(Material.QUARTZ_BLOCK);
            }
            for(int i = 0; i< 8; i++){
                hashmine.add(Material.COAL_BLOCK);
            }
            for(int i = 0; i< 8; i++){
                hashmine.add(Material.IRON_BLOCK);
            }
            for(int i = 0; i< 8; i++){
                hashmine.add(Material.LAPIS_BLOCK);
            }
            for(int i = 0; i< 8; i++){
                hashmine.add(Material.GOLD_BLOCK);
            }
            for(int i = 0; i< 8; i++){
                hashmine.add(Material.DIAMOND_BLOCK);
            }
            for(int i = 0; i< 5; i++){
                hashmine.add(Material.EMERALD_BLOCK);
            }
        } else if(mine.equalsIgnoreCase("mine25")){
            for(int i = 0; i< 35; i++){
                hashmine.add(Material.STONE);
            }
            for(int i = 0; i< 8; i++){
                hashmine.add(Material.REDSTONE_ORE);
            }
            for(int i = 0; i< 8; i++){
                hashmine.add(Material.LAPIS_ORE);
            }
            for(int i = 0; i< 10; i++){
                hashmine.add(Material.GOLD_ORE);
            }
            for(int i = 0; i< 10; i++){
                hashmine.add(Material.DIAMOND_ORE);
            }
            for(int i = 0; i< 14; i++){
                hashmine.add(Material.EMERALD_ORE);
            }
            for(int i = 0; i< 8; i++){
                hashmine.add(Material.QUARTZ_BLOCK);
            }
            for(int i = 0; i< 8; i++){
                hashmine.add(Material.COAL_BLOCK);
            }
            for(int i = 0; i< 8; i++){
                hashmine.add(Material.IRON_BLOCK);
            }
            for(int i = 0; i< 8; i++){
                hashmine.add(Material.LAPIS_BLOCK);
            }
            for(int i = 0; i< 8; i++){
                hashmine.add(Material.GOLD_BLOCK);
            }
            for(int i = 0; i< 8; i++){
                hashmine.add(Material.DIAMOND_BLOCK);
            }
            for(int i = 0; i< 7; i++){
                hashmine.add(Material.EMERALD_BLOCK);
            }
            for(int i = 0; i< 8; i++){
                hashmine.add(Material.OBSIDIAN);
            }
        }
    }

    private boolean teleportRequest(Player p, Location eckpoint1, Location eckpoint2, String mine){
        if(mine.equals("mine1")) {
            if (p.getLocation().getBlockX() >= eckpoint1.getBlockX() && p.getLocation().getBlockX() <= eckpoint2.getBlockX()) {
                if (p.getLocation().getBlockY() >= eckpoint1.getBlockY() && p.getLocation().getBlockY() <= eckpoint2.getBlockY()) {
                    if (p.getLocation().getBlockZ() >= eckpoint1.getBlockZ() && p.getLocation().getBlockZ() <= eckpoint2.getBlockZ()) {
                        return true;
                    }
                }
            }
        }else if(mine.equals("mine2")) {
            Bukkit.broadcastMessage("0");
            if (p.getLocation().getBlockX() <= eckpoint1.getBlockX() && p.getLocation().getBlockX() >= eckpoint2.getBlockX()) {
                Bukkit.broadcastMessage("1");
                if (p.getLocation().getBlockY() >= eckpoint1.getBlockY() && p.getLocation().getBlockY() <= eckpoint2.getBlockY()) {
                    Bukkit.broadcastMessage("2");
                    if (p.getLocation().getBlockZ() <= eckpoint1.getBlockZ() && p.getLocation().getBlockZ() >= eckpoint2.getBlockZ()) {
                        Bukkit.broadcastMessage("3");
                        return true;
                    }
                }
            }
        }/* TODO HIER DIE FUCKING MINEN FREISCHALTEN SOBALD SIE VERFÜGBAR SIND
        else if(mine.equals("mine3")) {
            if (p.getLocation().getBlockX() >= eckpoint1.getBlockX() && p.getLocation().getBlockX() <= eckpoint2.getBlockX()) {
                if (p.getLocation().getBlockY() >= eckpoint1.getBlockY() && p.getLocation().getBlockY() <= eckpoint2.getBlockY()) {
                    if (p.getLocation().getBlockZ() >= eckpoint1.getBlockZ() && p.getLocation().getBlockZ() <= eckpoint2.getBlockZ()) {
                        return true;
                    }
                }
            }
        }else if(mine.equals("mine4")) {
            if (p.getLocation().getBlockX() >= eckpoint1.getBlockX() && p.getLocation().getBlockX() <= eckpoint2.getBlockX()) {
                if (p.getLocation().getBlockY() >= eckpoint1.getBlockY() && p.getLocation().getBlockY() <= eckpoint2.getBlockY()) {
                    if (p.getLocation().getBlockZ() >= eckpoint1.getBlockZ() && p.getLocation().getBlockZ() <= eckpoint2.getBlockZ()) {
                        return true;
                    }
                }
            }
        }else if(mine.equals("mine5")) {
            if (p.getLocation().getBlockX() >= eckpoint1.getBlockX() && p.getLocation().getBlockX() <= eckpoint2.getBlockX()) {
                if (p.getLocation().getBlockY() >= eckpoint1.getBlockY() && p.getLocation().getBlockY() <= eckpoint2.getBlockY()) {
                    if (p.getLocation().getBlockZ() >= eckpoint1.getBlockZ() && p.getLocation().getBlockZ() <= eckpoint2.getBlockZ()) {
                        return true;
                    }
                }
            }
        }else if(mine.equals("mine6")) {
            if (p.getLocation().getBlockX() >= eckpoint1.getBlockX() && p.getLocation().getBlockX() <= eckpoint2.getBlockX()) {
                if (p.getLocation().getBlockY() >= eckpoint1.getBlockY() && p.getLocation().getBlockY() <= eckpoint2.getBlockY()) {
                    if (p.getLocation().getBlockZ() >= eckpoint1.getBlockZ() && p.getLocation().getBlockZ() <= eckpoint2.getBlockZ()) {
                        return true;
                    }
                }
            }
        }else if(mine.equals("mine7")) {
            if (p.getLocation().getBlockX() >= eckpoint1.getBlockX() && p.getLocation().getBlockX() <= eckpoint2.getBlockX()) {
                if (p.getLocation().getBlockY() >= eckpoint1.getBlockY() && p.getLocation().getBlockY() <= eckpoint2.getBlockY()) {
                    if (p.getLocation().getBlockZ() >= eckpoint1.getBlockZ() && p.getLocation().getBlockZ() <= eckpoint2.getBlockZ()) {
                        return true;
                    }
                }
            }
        }else if(mine.equals("mine8")) {
            if (p.getLocation().getBlockX() >= eckpoint1.getBlockX() && p.getLocation().getBlockX() <= eckpoint2.getBlockX()) {
                if (p.getLocation().getBlockY() >= eckpoint1.getBlockY() && p.getLocation().getBlockY() <= eckpoint2.getBlockY()) {
                    if (p.getLocation().getBlockZ() >= eckpoint1.getBlockZ() && p.getLocation().getBlockZ() <= eckpoint2.getBlockZ()) {
                        return true;
                    }
                }
            }
        }else if(mine.equals("mine9")) {
            if (p.getLocation().getBlockX() >= eckpoint1.getBlockX() && p.getLocation().getBlockX() <= eckpoint2.getBlockX()) {
                if (p.getLocation().getBlockY() >= eckpoint1.getBlockY() && p.getLocation().getBlockY() <= eckpoint2.getBlockY()) {
                    if (p.getLocation().getBlockZ() >= eckpoint1.getBlockZ() && p.getLocation().getBlockZ() <= eckpoint2.getBlockZ()) {
                        return true;
                    }
                }
            }
        }else if(mine.equals("mine10")) {
            if (p.getLocation().getBlockX() >= eckpoint1.getBlockX() && p.getLocation().getBlockX() <= eckpoint2.getBlockX()) {
                if (p.getLocation().getBlockY() >= eckpoint1.getBlockY() && p.getLocation().getBlockY() <= eckpoint2.getBlockY()) {
                    if (p.getLocation().getBlockZ() >= eckpoint1.getBlockZ() && p.getLocation().getBlockZ() <= eckpoint2.getBlockZ()) {
                        return true;
                    }
                }
            }
        }else if(mine.equals("mine11")) {
            if (p.getLocation().getBlockX() >= eckpoint1.getBlockX() && p.getLocation().getBlockX() <= eckpoint2.getBlockX()) {
                if (p.getLocation().getBlockY() >= eckpoint1.getBlockY() && p.getLocation().getBlockY() <= eckpoint2.getBlockY()) {
                    if (p.getLocation().getBlockZ() >= eckpoint1.getBlockZ() && p.getLocation().getBlockZ() <= eckpoint2.getBlockZ()) {
                        return true;
                    }
                }
            }
        }else if(mine.equals("mine12")) {
            if (p.getLocation().getBlockX() >= eckpoint1.getBlockX() && p.getLocation().getBlockX() <= eckpoint2.getBlockX()) {
                if (p.getLocation().getBlockY() >= eckpoint1.getBlockY() && p.getLocation().getBlockY() <= eckpoint2.getBlockY()) {
                    if (p.getLocation().getBlockZ() >= eckpoint1.getBlockZ() && p.getLocation().getBlockZ() <= eckpoint2.getBlockZ()) {
                        return true;
                    }
                }
            }
        }else if(mine.equals("mine13")) {
            if (p.getLocation().getBlockX() >= eckpoint1.getBlockX() && p.getLocation().getBlockX() <= eckpoint2.getBlockX()) {
                if (p.getLocation().getBlockY() >= eckpoint1.getBlockY() && p.getLocation().getBlockY() <= eckpoint2.getBlockY()) {
                    if (p.getLocation().getBlockZ() >= eckpoint1.getBlockZ() && p.getLocation().getBlockZ() <= eckpoint2.getBlockZ()) {
                        return true;
                    }
                }
            }
        }else if(mine.equals("mine14")) {
            if (p.getLocation().getBlockX() >= eckpoint1.getBlockX() && p.getLocation().getBlockX() <= eckpoint2.getBlockX()) {
                if (p.getLocation().getBlockY() >= eckpoint1.getBlockY() && p.getLocation().getBlockY() <= eckpoint2.getBlockY()) {
                    if (p.getLocation().getBlockZ() >= eckpoint1.getBlockZ() && p.getLocation().getBlockZ() <= eckpoint2.getBlockZ()) {
                        return true;
                    }
                }
            }
        }else if(mine.equals("mine15")) {
            if (p.getLocation().getBlockX() >= eckpoint1.getBlockX() && p.getLocation().getBlockX() <= eckpoint2.getBlockX()) {
                if (p.getLocation().getBlockY() >= eckpoint1.getBlockY() && p.getLocation().getBlockY() <= eckpoint2.getBlockY()) {
                    if (p.getLocation().getBlockZ() >= eckpoint1.getBlockZ() && p.getLocation().getBlockZ() <= eckpoint2.getBlockZ()) {
                        return true;
                    }
                }
            }
        }else if(mine.equals("mine16")) {
            if (p.getLocation().getBlockX() >= eckpoint1.getBlockX() && p.getLocation().getBlockX() <= eckpoint2.getBlockX()) {
                if (p.getLocation().getBlockY() >= eckpoint1.getBlockY() && p.getLocation().getBlockY() <= eckpoint2.getBlockY()) {
                    if (p.getLocation().getBlockZ() >= eckpoint1.getBlockZ() && p.getLocation().getBlockZ() <= eckpoint2.getBlockZ()) {
                        return true;
                    }
                }
            }
        }else if(mine.equals("mine17")) {
            if (p.getLocation().getBlockX() >= eckpoint1.getBlockX() && p.getLocation().getBlockX() <= eckpoint2.getBlockX()) {
                if (p.getLocation().getBlockY() >= eckpoint1.getBlockY() && p.getLocation().getBlockY() <= eckpoint2.getBlockY()) {
                    if (p.getLocation().getBlockZ() >= eckpoint1.getBlockZ() && p.getLocation().getBlockZ() <= eckpoint2.getBlockZ()) {
                        return true;
                    }
                }
            }
        }else if(mine.equals("mine18")) {
            if (p.getLocation().getBlockX() >= eckpoint1.getBlockX() && p.getLocation().getBlockX() <= eckpoint2.getBlockX()) {
                if (p.getLocation().getBlockY() >= eckpoint1.getBlockY() && p.getLocation().getBlockY() <= eckpoint2.getBlockY()) {
                    if (p.getLocation().getBlockZ() >= eckpoint1.getBlockZ() && p.getLocation().getBlockZ() <= eckpoint2.getBlockZ()) {
                        return true;
                    }
                }
            }
        }else if(mine.equals("mine19")) {
            if (p.getLocation().getBlockX() >= eckpoint1.getBlockX() && p.getLocation().getBlockX() <= eckpoint2.getBlockX()) {
                if (p.getLocation().getBlockY() >= eckpoint1.getBlockY() && p.getLocation().getBlockY() <= eckpoint2.getBlockY()) {
                    if (p.getLocation().getBlockZ() >= eckpoint1.getBlockZ() && p.getLocation().getBlockZ() <= eckpoint2.getBlockZ()) {
                        return true;
                    }
                }
            }
        }else if(mine.equals("mine20")) {
            if (p.getLocation().getBlockX() >= eckpoint1.getBlockX() && p.getLocation().getBlockX() <= eckpoint2.getBlockX()) {
                if (p.getLocation().getBlockY() >= eckpoint1.getBlockY() && p.getLocation().getBlockY() <= eckpoint2.getBlockY()) {
                    if (p.getLocation().getBlockZ() >= eckpoint1.getBlockZ() && p.getLocation().getBlockZ() <= eckpoint2.getBlockZ()) {
                        return true;
                    }
                }
            }
        }else if(mine.equals("mine2")) {
            if (p.getLocation().getBlockX() >= eckpoint1.getBlockX() && p.getLocation().getBlockX() <= eckpoint2.getBlockX()) {
                if (p.getLocation().getBlockY() >= eckpoint1.getBlockY() && p.getLocation().getBlockY() <= eckpoint2.getBlockY()) {
                    if (p.getLocation().getBlockZ() >= eckpoint1.getBlockZ() && p.getLocation().getBlockZ() <= eckpoint2.getBlockZ()) {
                        return true;
                    }
                }
            }
        }else if(mine.equals("mine21")) {
            if (p.getLocation().getBlockX() >= eckpoint1.getBlockX() && p.getLocation().getBlockX() <= eckpoint2.getBlockX()) {
                if (p.getLocation().getBlockY() >= eckpoint1.getBlockY() && p.getLocation().getBlockY() <= eckpoint2.getBlockY()) {
                    if (p.getLocation().getBlockZ() >= eckpoint1.getBlockZ() && p.getLocation().getBlockZ() <= eckpoint2.getBlockZ()) {
                        return true;
                    }
                }
            }
        }else if(mine.equals("mine22")) {
            if (p.getLocation().getBlockX() >= eckpoint1.getBlockX() && p.getLocation().getBlockX() <= eckpoint2.getBlockX()) {
                if (p.getLocation().getBlockY() >= eckpoint1.getBlockY() && p.getLocation().getBlockY() <= eckpoint2.getBlockY()) {
                    if (p.getLocation().getBlockZ() >= eckpoint1.getBlockZ() && p.getLocation().getBlockZ() <= eckpoint2.getBlockZ()) {
                        return true;
                    }
                }
            }
        }else if(mine.equals("mine23")) {
            if (p.getLocation().getBlockX() >= eckpoint1.getBlockX() && p.getLocation().getBlockX() <= eckpoint2.getBlockX()) {
                if (p.getLocation().getBlockY() >= eckpoint1.getBlockY() && p.getLocation().getBlockY() <= eckpoint2.getBlockY()) {
                    if (p.getLocation().getBlockZ() >= eckpoint1.getBlockZ() && p.getLocation().getBlockZ() <= eckpoint2.getBlockZ()) {
                        return true;
                    }
                }
            }
        }else if(mine.equals("mine24")) {
            if (p.getLocation().getBlockX() >= eckpoint1.getBlockX() && p.getLocation().getBlockX() <= eckpoint2.getBlockX()) {
                if (p.getLocation().getBlockY() >= eckpoint1.getBlockY() && p.getLocation().getBlockY() <= eckpoint2.getBlockY()) {
                    if (p.getLocation().getBlockZ() >= eckpoint1.getBlockZ() && p.getLocation().getBlockZ() <= eckpoint2.getBlockZ()) {
                        return true;
                    }
                }
            }
        }else if(mine.equals("mine25")) {
            if (p.getLocation().getBlockX() >= eckpoint1.getBlockX() && p.getLocation().getBlockX() <= eckpoint2.getBlockX()) {
                if (p.getLocation().getBlockY() >= eckpoint1.getBlockY() && p.getLocation().getBlockY() <= eckpoint2.getBlockY()) {
                    if (p.getLocation().getBlockZ() >= eckpoint1.getBlockZ() && p.getLocation().getBlockZ() <= eckpoint2.getBlockZ()) {
                        return true;
                    }
                }
            }
        }*/
        return false;
    }

}
