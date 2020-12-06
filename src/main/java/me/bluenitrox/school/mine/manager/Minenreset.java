package me.bluenitrox.school.mine.manager;

import me.bluenitrox.school.managers.LocationManager;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.Random;


public class Minenreset {

    private ArrayList<Material> hashmine;

    public static void fillMineServerStart(){
        try {
            for (int i = 1; i <= 25; i++) {
                Minenreset mr = new Minenreset();
                mr.fillMine("mine" + i);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void fillMine(String mine){
        hashmine = new ArrayList<>();
        registerHash(mine);
        String temp = "eckpoint1" + mine;
        String temp2 = "eckpoint2" + mine;
        Location eckpoint1 = new LocationManager(temp).getLocation();
        Location eckpoint2 = new LocationManager(temp2).getLocation();
        World w = eckpoint1.getWorld();

        int minX = Math.min(eckpoint1.getBlockX(), eckpoint2.getBlockX());
        int minY = Math.min(eckpoint1.getBlockY(), eckpoint2.getBlockY());
        int minZ = Math.min(eckpoint1.getBlockZ(), eckpoint2.getBlockZ());
        int maxX = Math.max(eckpoint1.getBlockX(), eckpoint2.getBlockX());
        int maxY = Math.max(eckpoint1.getBlockY(), eckpoint2.getBlockY());
        int maxZ = Math.max(eckpoint1.getBlockZ(), eckpoint2.getBlockZ());

        for(int x3 = minX; x3 <= maxX; x3++) {
            for (int y3 = minY; y3 <= maxY; y3++) {
                for (int z3 = minZ; z3 <= maxZ; z3++) {
                    Block block = w.getBlockAt(x3, y3, z3);

                    int r = new Random().nextInt(100);
                    block.setType(hashmine.get(r));
                }
            }
        }
        for(Player all: Bukkit.getOnlinePlayers()) {
            if (all.getLocation().getBlockX() >= eckpoint1.getBlockX() && all.getLocation().getBlockX() <= eckpoint2.getBlockX()) {
                if (all.getLocation().getBlockY() >= eckpoint1.getBlockY() && all.getLocation().getBlockY() <= eckpoint2.getBlockY()) {
                    if (all.getLocation().getBlockZ() >= eckpoint1.getBlockZ() && all.getLocation().getBlockZ() <= eckpoint2.getBlockZ()) {
                        all.teleport(new LocationManager(mine).getLocation());
                    }
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
            for(int i = 0; i< 5; i++){
                hashmine.add(Material.COAL_ORE);
            }
        }else if(mine.equalsIgnoreCase("mine3")){
            for(int i = 0; i< 95; i++){
                hashmine.add(Material.STONE);
            }
            for(int i = 0; i< 8; i++){
                hashmine.add(Material.COAL_ORE);
            }
        }else if(mine.equalsIgnoreCase("mine4")){
            for(int i = 0; i< 90; i++){
                hashmine.add(Material.STONE);
            }
            for(int i = 0; i< 10; i++){
                hashmine.add(Material.COAL_ORE);
            }
            for(int i = 0; i< 5; i++){
                hashmine.add(Material.IRON_ORE);
            }
        }else if(mine.equalsIgnoreCase("mine5")){
            for(int i = 0; i< 90; i++){
                hashmine.add(Material.STONE);
            }
            for(int i = 0; i< 10; i++){
                hashmine.add(Material.COAL_ORE);
            }
            for(int i = 0; i< 10; i++){
                hashmine.add(Material.IRON_ORE);
            }
        }else if(mine.equalsIgnoreCase("mine6")){
            for(int i = 0; i< 80; i++){
                hashmine.add(Material.STONE);
            }
            for(int i = 0; i< 10; i++){
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
            for(int i = 0; i< 10; i++){
                hashmine.add(Material.COAL_ORE);
            }
            for(int i = 0; i< 10; i++){
                hashmine.add(Material.IRON_ORE);
            }
            for(int i = 0; i< 5; i++){
                hashmine.add(Material.QUARTZ_ORE);
            }
        }else if(mine.equalsIgnoreCase("mine8")){
            for(int i = 0; i< 75; i++){
                hashmine.add(Material.STONE);
            }
            for(int i = 0; i< 10; i++){
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
        }
    }

}