package me.bluenitrox.school.listener;

import de.Herbystar.TTA.TTA_Methods;
import me.bluenitrox.school.aufgabensystem.AufgabenMethods;
import me.bluenitrox.school.commands.Build;
import me.bluenitrox.school.enchants.pickaxe.Duplizierung;
import me.bluenitrox.school.enchants.pickaxe.Rausch;
import me.bluenitrox.school.managers.MessageManager;
import me.bluenitrox.school.managers.PlayerBreakBlockManager;
import me.bluenitrox.school.managers.WorldManager;
import me.bluenitrox.school.mine.manager.MinenSettings;
import me.bluenitrox.school.utils.InventoryUtil;
import me.bluenitrox.school.utils.ItemBuilder;
import org.bukkit.Bukkit;
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
import java.util.HashMap;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class BreakBlockEvent implements Listener {

    public ArrayList<String> allowedWorldToBuild = new ArrayList<>();

    public static ConcurrentHashMap<String, Integer> minen = new ConcurrentHashMap<>();
    AufgabenMethods aufgaben = new AufgabenMethods();

    public BreakBlockEvent() {
        allowedWorldToBuild.add("plotworld");
    }

    @EventHandler
    public void onBreak(BlockBreakEvent e) {
        Player p = e.getPlayer();
        tooldown(p);
        if(Build.build.contains(p)) {
            return;
        }
        if(p.getWorld().getName().equalsIgnoreCase(WorldManager.plotworld)) return;

        if(p.getWorld().getName().equalsIgnoreCase(WorldManager.mine)) {
            if ((PlayerBreakBlockManager.breakBlock(p, e.getBlock().getLocation()))) {
                addItemToInv(p, e.getBlock(), Duplizierung.Dupliauslöser(p));
                aufgaben.onBlockBreak(e);
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
        if(e.getBlock().getWorld().getName().equalsIgnoreCase(WorldManager.plotworld)){
            return;
        }
        if (!allowedWorldToBuild.contains(p.getLocation().getWorld().getName())) {
            e.setCancelled(true);
        }
        placeenderchest(e);
    }

    private void addItemToInv(Player p, Block b, int multiplier){
        ItemStack item;
        UUID uuid = p.getUniqueId();
        HashMap<Material, Boolean> value = MinenSettings.getMiningSettings().getMinenSettings().get(uuid);
        if(b.getType() == Material.STONE){
            if(value.get(Material.STONE)) {
                item = new ItemBuilder(Material.STONE).setDisplayname("§7Stein").build();
            } else {
                item = new ItemBuilder(Material.AIR).build();
            }
        }else if(b.getType() == Material.COAL_ORE){
            if(value.get(Material.COAL_ORE)) {
                item = new ItemBuilder(Material.COAL).setDisplayname("§7Kohle").build();
            } else {
                item = new ItemBuilder(Material.AIR).build();
            }
        }else if(b.getType() == Material.IRON_ORE){
            if(value.get(Material.IRON_ORE)) {
                item = new ItemBuilder(Material.IRON_INGOT).setDisplayname("§7Eisen").build();
            } else {
                item = new ItemBuilder(Material.AIR).build();
            }
        }else if(b.getType() == Material.GOLD_ORE){
            if(value.get(Material.GOLD_ORE)) {
                item = new ItemBuilder(Material.GOLD_INGOT).setDisplayname("§7Gold").build();
            }else {
                item = new ItemBuilder(Material.AIR).build();
            }
        }else if(b.getType() == Material.DIAMOND_ORE){
            if(value.get(Material.DIAMOND_ORE)) {
                item = new ItemBuilder(Material.DIAMOND).setDisplayname("§7Diamant").build();
            }else {
                item = new ItemBuilder(Material.AIR).build();
            }
        }else if(b.getType() == Material.EMERALD_ORE){
            if(value.get(Material.EMERALD_ORE)) {
                item = new ItemBuilder(Material.EMERALD).setDisplayname("§7Smaragd").build();
            }else {
                item = new ItemBuilder(Material.AIR).build();
            }
        }else if(b.getType() == Material.QUARTZ_ORE){
            if(value.get(Material.QUARTZ_ORE)) {
                item = new ItemBuilder(Material.EMERALD).setDisplayname("§7Quarz").build();
            }else {
                item = new ItemBuilder(Material.AIR).build();
            }
        }else if(b.getType() == Material.COAL_BLOCK){
            if(value.get(Material.COAL_BLOCK)) {
                item = new ItemBuilder(Material.COAL_BLOCK).setDisplayname("§7Kohleblock").build();
            }else {
                item = new ItemBuilder(Material.AIR).build();
            }
        }else if(b.getType() == Material.IRON_BLOCK){
            if(value.get(Material.IRON_BLOCK)) {
                item = new ItemBuilder(Material.IRON_BLOCK).setDisplayname("§7Eisenblock").build();
            }else {
                item = new ItemBuilder(Material.AIR).build();
            }
        }else if(b.getType() == Material.GOLD_BLOCK){
            if(value.get(Material.GOLD_BLOCK)) {
                item = new ItemBuilder(Material.GOLD_BLOCK).setDisplayname("§7Goldblock").build();
            }else {
                item = new ItemBuilder(Material.AIR).build();
            }
        }else if(b.getType() == Material.DIAMOND_BLOCK){
            if(value.get(Material.DIAMOND_BLOCK)) {
                item = new ItemBuilder(Material.DIAMOND_BLOCK).setDisplayname("§7Diamantblock").build();
            }else {
                item = new ItemBuilder(Material.AIR).build();
            }
        }else if(b.getType() == Material.EMERALD_BLOCK){
            if(value.get(Material.EMERALD_BLOCK)) {
                item = new ItemBuilder(Material.EMERALD_BLOCK).setDisplayname("§7Smaragdblock").build();
            }else {
                item = new ItemBuilder(Material.AIR).build();
            }
        }else if(b.getType() == Material.REDSTONE_ORE){
            if(value.get(Material.REDSTONE_ORE)) {
                item = new ItemBuilder(Material.REDSTONE).setDisplayname("§7Redstone").build();
            }else {
                item = new ItemBuilder(Material.AIR).build();
            }
        }else if(b.getType() == Material.LAPIS_ORE){
            if(value.get(Material.LAPIS_ORE)) {
                item = new ItemBuilder(Material.INK_SACK, (short)4).setDisplayname("§7Lapis").build();
            }else {
                item = new ItemBuilder(Material.AIR).build();
            }
        }else if(b.getType() == Material.LAPIS_BLOCK){
            if(value.get(Material.LAPIS_BLOCK)) {
                item = new ItemBuilder(Material.LAPIS_BLOCK).setDisplayname("§7Lapisblock").build();
            }else {
                item = new ItemBuilder(Material.AIR).build();
            }
        }else if(b.getType() == Material.REDSTONE_BLOCK){
            if(value.get(Material.REDSTONE_BLOCK)) {
                item = new ItemBuilder(Material.REDSTONE_BLOCK).setDisplayname("§7Redstoneblock").build();
            }else {
                item = new ItemBuilder(Material.AIR).build();
            }
        }else if(b.getType() == Material.QUARTZ_BLOCK){
            if(value.get(Material.QUARTZ_BLOCK)) {
                item = new ItemBuilder(Material.QUARTZ_BLOCK).setDisplayname("§7Quarzblock").build();
            }else {
                item = new ItemBuilder(Material.AIR).build();
            }
        }else if(b.getType() == Material.GRAVEL){
            if(value.get(Material.GRAVEL)) {
                item = new ItemBuilder(Material.GRAVEL).setDisplayname("§7Kies").build();
            }else {
                item = new ItemBuilder(Material.AIR).build();
            }
        }else if(b.getType() == Material.BRICK){
            if(value.get(Material.BRICK)) {
                item = new ItemBuilder(Material.BRICK).setDisplayname("§7Ziegel").build();
            }else {
                item = new ItemBuilder(Material.AIR).build();
            }
        }else if(b.getType() == Material.PRISMARINE){
            if(value.get(Material.PRISMARINE)) {
                 item = new ItemBuilder(Material.PRISMARINE).setDisplayname("§7Prismarin").build();
            }else {
                item = new ItemBuilder(Material.AIR).build();
            }
        }else if(b.getType() == Material.NETHER_BRICK){
            if(value.get(Material.NETHER_BRICK)) {
                item = new ItemBuilder(Material.NETHER_BRICK).setDisplayname("§7Netherziegel").build();
            }else {
                item = new ItemBuilder(Material.AIR).build();
            }
        }else if(b.getType() == Material.RED_SANDSTONE){
            if(value.get(Material.RED_SANDSTONE)) {
                item = new ItemBuilder(Material.RED_SANDSTONE).setDisplayname("§7roter Sandstein").build();
            }else {
                item = new ItemBuilder(Material.AIR).build();
            }
        } else if(b.getType() == Material.ICE){
            if(value.get(Material.ICE)) {
                item = new ItemBuilder(Material.ICE).setDisplayname("§7Eis").build();
            }else {
                item = new ItemBuilder(Material.AIR).build();
            }
        }else if(b.getType() == Material.NETHERRACK){
            if(value.get(Material.NETHERRACK)) {
                 item = new ItemBuilder(Material.NETHERRACK).setDisplayname("§7Netherstein").build();
            }else {
                item = new ItemBuilder(Material.AIR).build();
            }
        } else if(b.getType() == Material.PACKED_ICE){
            if(value.get(Material.PACKED_ICE)) {
                item = new ItemBuilder(Material.PACKED_ICE).setDisplayname("§7Packeis").build();
            }else {
                item = new ItemBuilder(Material.AIR).build();
            }
        } else if(b.getType() == Material.SEA_LANTERN){
            if(value.get(Material.SEA_LANTERN)) {
                item = new ItemBuilder(Material.SEA_LANTERN).setDisplayname("§7Seelaterne").build();
            }else {
                item = new ItemBuilder(Material.AIR).build();
            }
        }else if(b.getType() == Material.ENDER_STONE){
            if(value.get(Material.ENDER_STONE)) {
                item = new ItemBuilder(Material.ENDER_STONE).setDisplayname("§7Endstein").build();
            }else {
                item = new ItemBuilder(Material.AIR).build();
            }
        }else {
            item = new ItemBuilder(Material.AIR).build();
        }
        if(!InventoryUtil.isInvFull(p)){
            if(item != null){
                if(multiplier == 1) {
                    p.getInventory().addItem(item);
                }else if(multiplier == 2){
                    p.getInventory().addItem(item);
                    p.getInventory().addItem(item);
                }
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

    private void placeenderchest(BlockPlaceEvent e){
        if(e.getBlock().getType() == Material.ENDER_CHEST){
            e.setCancelled(true);
            e.getPlayer().playSound(e.getPlayer().getLocation(), Sound.VILLAGER_NO, 1L, 1L);
            e.getPlayer().sendMessage(MessageManager.PREFIX + "§7Du kannst keine §cEnderkisten §7platzieren!");
        }
    }
    private void tooldown(Player p){
        ItemStack item = p.getItemInHand();
        int max = item.getType().getMaxDurability();
        int uses = item.getDurability();
        int durability = max-uses;
        if(p.getItemInHand() != null){
            if(p.getItemInHand().getType() == Material.DIAMOND_PICKAXE || p.getItemInHand().getType() == Material.IRON_PICKAXE ||p.getItemInHand().getType() == Material.GOLD_PICKAXE ||p.getItemInHand().getType() == Material.STONE_PICKAXE ||p.getItemInHand().getType() == Material.WOOD_PICKAXE) {
                if (durability <= 30) {
                    Bukkit.broadcastMessage("Your item is nearly dead contact felix if you see this!");
                }
            }
        }
    }
}
