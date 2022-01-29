package me.bluenitrox.school.listener;

import de.Herbystar.TTA.TTA_Methods;
import me.bluenitrox.school.commands.Build;
import me.bluenitrox.school.managers.PlayerBreakBlockManager;
import me.bluenitrox.school.managers.WorldManager;
import me.bluenitrox.school.utils.InventoryUtil;
import me.bluenitrox.school.utils.ItemBuilder;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;

public class BreakBlockEvent implements Listener {

    public ArrayList<String> allowedWorldToBuild = new ArrayList<>();

    public static ConcurrentHashMap<String, Integer> minen = new ConcurrentHashMap<>();

    public BreakBlockEvent() {
        allowedWorldToBuild.add("plotworld");
    }

    @EventHandler
    public void onBreak(BlockBreakEvent e) {
        Player p = e.getPlayer();
        if(Build.build.contains(p)) {
            return;
        }
        if(p.getWorld().getName().equalsIgnoreCase(WorldManager.plotworld)) return;

        if(p.getWorld().getName().equalsIgnoreCase(WorldManager.mine)) {
            if ((PlayerBreakBlockManager.breakBlock(p, e.getBlock().getLocation()))) {
                addItemToInv(p, e.getBlock());
                PlayerBreakBlockManager.updateBlocks(p.getUniqueId(), false);
            } else {
                e.setCancelled(true);
                e.setExpToDrop(0);
            }
        } else {
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
        ItemStack item;
        if(b.getType() == Material.STONE){
            item = new ItemBuilder(Material.STONE).setDisplayname("§7Stein").build();
        }else if(b.getType() == Material.COAL_ORE){
            item = new ItemBuilder(Material.COAL).setDisplayname("§7Kohle").build();
        }else if(b.getType() == Material.IRON_ORE){
            item = new ItemBuilder(Material.IRON_INGOT).setDisplayname("§7Eisen").build();
        }else if(b.getType() == Material.GOLD_ORE){
            item = new ItemBuilder(Material.GOLD_INGOT).setDisplayname("§7Gold").build();
        }else if(b.getType() == Material.DIAMOND){
            item = new ItemBuilder(Material.DIAMOND_ORE).setDisplayname("§7Diamant").build();
        }else if(b.getType() == Material.EMERALD){
            item = new ItemBuilder(Material.EMERALD_ORE).setDisplayname("§7Smaragd").build();
        }else if(b.getType() == Material.QUARTZ_ORE){
            item = new ItemBuilder(Material.EMERALD).setDisplayname("§7Quarz").build();
        }else if(b.getType() == Material.COAL_BLOCK){
            item = new ItemBuilder(Material.COAL_BLOCK).setDisplayname("§7Kohle Block").build();
        }else if(b.getType() == Material.IRON_BLOCK){
            item = new ItemBuilder(Material.IRON_BLOCK).setDisplayname("§7Eisen Block").build();
        }else if(b.getType() == Material.GOLD_BLOCK){
            item = new ItemBuilder(Material.GOLD_BLOCK).setDisplayname("§7Gold Block").build();
        }else if(b.getType() == Material.DIAMOND_BLOCK){
            item = new ItemBuilder(Material.DIAMOND_BLOCK).setDisplayname("§7Diamant Block").build();
        }else if(b.getType() == Material.EMERALD_BLOCK){
            item = new ItemBuilder(Material.EMERALD_BLOCK).setDisplayname("§7Emerald Block").build();
        }else if(b.getType() == Material.REDSTONE_ORE){
            item = new ItemBuilder(Material.REDSTONE).setDisplayname("§7Redstone").build();
        }else if(b.getType() == Material.LAPIS_ORE){
            item = new ItemBuilder(Material.INK_SACK, (short)4).setDisplayname("§7Lapis Lazuli").build();
        }else if(b.getType() == Material.LAPIS_BLOCK){
            item = new ItemBuilder(Material.LAPIS_BLOCK).setDisplayname("§7Lapis Lazuli Block").build();
        }else if(b.getType() == Material.REDSTONE_BLOCK){
            item = new ItemBuilder(Material.REDSTONE_BLOCK).setDisplayname("§7Redstone Block").build();
        }else if(b.getType() == Material.QUARTZ_BLOCK){
            item = new ItemBuilder(Material.QUARTZ_BLOCK).setDisplayname("§7Quarz Block").build();
        }else if(b.getType() == Material.GRAVEL){
            item = new ItemBuilder(Material.GRAVEL).setDisplayname("§7Kies").build();
        }else {
            item = new ItemBuilder(Material.AIR).build();
        }
        if(!InventoryUtil.isInvFull(p)){
            if(item != null){
                p.getInventory().addItem(item);
            }
        }else {
            if(item != null){
                p.getWorld().dropItem(p.getLocation(), item);
                TTA_Methods.sendTitle(p, "§cInventar Voll!", 10, 40, 10, "§cLeere dein Inventar", 10, 40, 10);
                p.playSound(p.getLocation(), Sound.EXPLODE, 1L, 1L);
            }
        }
        b.setType(Material.AIR);
    }
}
