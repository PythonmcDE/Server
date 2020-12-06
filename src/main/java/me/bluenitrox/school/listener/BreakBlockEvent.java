package me.bluenitrox.school.listener;

import me.bluenitrox.school.commands.Build;
import me.bluenitrox.school.managers.PlayerBreakBlockManager;
import me.bluenitrox.school.utils.ItemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;

import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;

public class BreakBlockEvent implements Listener {

    public int dropBonus;
    public ArrayList<String> allowedWorldToBuild = new ArrayList<>();
    public String plotworld = "plotworld";

    public static ConcurrentHashMap<String, Integer> minen = new ConcurrentHashMap<>();

    public BreakBlockEvent() {
        allowedWorldToBuild.add("plotworld");
    }

    @EventHandler
    public void onBreak(BlockBreakEvent e) {
        dropBonus = 1;
        Player p = e.getPlayer();
        if(Build.build.contains(p)) {
            return;
        }
        if(p.getWorld().getName().equalsIgnoreCase(plotworld)) return;

        if((PlayerBreakBlockManager.breakBlock(p, e.getBlock().getLocation(), dropBonus))) {
            addItemToInv(p,e.getBlock());
            PlayerBreakBlockManager.updateBlocks(p.getUniqueId(),false);
        }else {
            e.setCancelled(true);
            e.setExpToDrop(0);
        }
    }

    @EventHandler
    public void onPlace(BlockPlaceEvent e) {
        Player p = e.getPlayer();
        if(Build.build.contains(p)){
            return;
        }
        if (!allowedWorldToBuild.contains(p.getLocation().getWorld().getName())) {
            e.setCancelled(true);
        }
    }

    private void addItemToInv(Player p, Block b){
        if(b.getType() == Material.STONE){
            p.getInventory().addItem(new ItemBuilder(Material.STONE).setDisplayname("§7Stein").build());
        }else if(b.getType() == Material.COAL_ORE){
            p.getInventory().addItem(new ItemBuilder(Material.COAL).setDisplayname("§7Kohle").build());
        }else if(b.getType() == Material.IRON_ORE){
            p.getInventory().addItem(new ItemBuilder(Material.IRON_INGOT).setDisplayname("§7Eisen").build());
        }else if(b.getType() == Material.GOLD_ORE){
            p.getInventory().addItem(new ItemBuilder(Material.GOLD_INGOT).setDisplayname("§7Gold").build());
        }else if(b.getType() == Material.DIAMOND){
            p.getInventory().addItem(new ItemBuilder(Material.DIAMOND_ORE).setDisplayname("§7Diamant").build());
        }else if(b.getType() == Material.EMERALD){
            p.getInventory().addItem(new ItemBuilder(Material.EMERALD_ORE).setDisplayname("§7Smaragd").build());
        }else if(b.getType() == Material.QUARTZ_ORE){
            p.getInventory().addItem(new ItemBuilder(Material.EMERALD).setDisplayname("§7Quarz").build());
        }else if(b.getType() == Material.COAL_BLOCK){
            p.getInventory().addItem(new ItemBuilder(Material.COAL_BLOCK).setDisplayname("§7Kohle Block").build());
        }else if(b.getType() == Material.IRON_BLOCK){
            p.getInventory().addItem(new ItemBuilder(Material.IRON_BLOCK).setDisplayname("§7Eisen Block").build());
        }else if(b.getType() == Material.GOLD_BLOCK){
            p.getInventory().addItem(new ItemBuilder(Material.GOLD_BLOCK).setDisplayname("§7Gold Block").build());
        }else if(b.getType() == Material.DIAMOND_BLOCK){
            p.getInventory().addItem(new ItemBuilder(Material.DIAMOND_BLOCK).setDisplayname("§7Diamant Block").build());
        }else if(b.getType() == Material.EMERALD_BLOCK){
            p.getInventory().addItem(new ItemBuilder(Material.EMERALD_BLOCK).setDisplayname("§7Emerald Block").build());
        }else if(b.getType() == Material.REDSTONE_ORE){
            p.getInventory().addItem(new ItemBuilder(Material.REDSTONE).setDisplayname("§7Redstone").build());
        }else if(b.getType() == Material.LAPIS_ORE){
            p.getInventory().addItem(new ItemBuilder(Material.INK_SACK, (short)4).setDisplayname("§7Lapis Lazuli").build());
        }else if(b.getType() == Material.LAPIS_BLOCK){
            p.getInventory().addItem(new ItemBuilder(Material.LAPIS_BLOCK).setDisplayname("§7Lapis Lazuli Block").build());
        }else if(b.getType() == Material.REDSTONE_BLOCK){
            p.getInventory().addItem(new ItemBuilder(Material.REDSTONE_BLOCK).setDisplayname("§7Redstone Block").build());
        }else if(b.getType() == Material.QUARTZ_BLOCK){
            p.getInventory().addItem(new ItemBuilder(Material.QUARTZ_BLOCK).setDisplayname("§7Quarz Block").build());
        }
        b.setType(Material.AIR);
    }
}
