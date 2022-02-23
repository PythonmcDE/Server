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
import me.bluenitrox.school.mine.manager.data.MinenSettingData;
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
        if (!allowedWorldToBuild.contains(p.getLocation().getWorld().getName())) {
            e.setCancelled(true);
        }
        placeenderchest(e);
    }

    private void addItemToInv(Player p, Block b, int multiplier){
        ItemStack item;
        UUID uuid = p.getUniqueId();
        MinenSettingData api = MinenSettingData.getInstance();
        if(b.getType() == Material.STONE){
            if(!api.getStoneSettings(uuid)) return;
            item = new ItemBuilder(Material.STONE).setDisplayname("§7Stein").build();
        }else if(b.getType() == Material.COAL_ORE){
            if(!api.getCoalSettings(uuid)) return;
            item = new ItemBuilder(Material.COAL).setDisplayname("§7Kohle").build();
        }else if(b.getType() == Material.IRON_ORE){
            if(!api.getIronSettings(uuid)) return;
            item = new ItemBuilder(Material.IRON_INGOT).setDisplayname("§7Eisen").build();
        }else if(b.getType() == Material.GOLD_ORE){
            if(!api.getGoldSettings(uuid)) return;
            item = new ItemBuilder(Material.GOLD_INGOT).setDisplayname("§7Gold").build();
        }else if(b.getType() == Material.DIAMOND){
            if(!api.getDiamondSettings(uuid)) return;
            item = new ItemBuilder(Material.DIAMOND_ORE).setDisplayname("§7Diamant").build();
        }else if(b.getType() == Material.EMERALD){
            if(!api.getEmeraldeSettings(uuid)) return;
            item = new ItemBuilder(Material.EMERALD_ORE).setDisplayname("§7Smaragd").build();
        }else if(b.getType() == Material.QUARTZ_ORE){
            if(!api.getQuarzSettings(uuid)) return;
            item = new ItemBuilder(Material.EMERALD).setDisplayname("§7Quarz").build();
        }else if(b.getType() == Material.COAL_BLOCK){
            if(!api.getCoalBlockSettings(uuid)) return;
            item = new ItemBuilder(Material.COAL_BLOCK).setDisplayname("§7Kohle Block").build();
        }else if(b.getType() == Material.IRON_BLOCK){
            if(!api.getIronBlockSettings(uuid)) return;
            item = new ItemBuilder(Material.IRON_BLOCK).setDisplayname("§7Eisen Block").build();
        }else if(b.getType() == Material.GOLD_BLOCK){
            if(!api.getGoldBlockSettings(uuid)) return;
            item = new ItemBuilder(Material.GOLD_BLOCK).setDisplayname("§7Gold Block").build();
        }else if(b.getType() == Material.DIAMOND_BLOCK){
            if(!api.getDiamondBlockSettings(uuid)) return;
            item = new ItemBuilder(Material.DIAMOND_BLOCK).setDisplayname("§7Diamant Block").build();
        }else if(b.getType() == Material.EMERALD_BLOCK){
            if(!api.getEmeraldBlockSettings(uuid)) return;
            item = new ItemBuilder(Material.EMERALD_BLOCK).setDisplayname("§7Emerald Block").build();
        }else if(b.getType() == Material.REDSTONE_ORE){
            if(!api.getRedstoneBlockSettings(uuid)) return;
            item = new ItemBuilder(Material.REDSTONE).setDisplayname("§7Redstone").build();
        }else if(b.getType() == Material.LAPIS_ORE){
            if(!api.getLapisSettings(uuid)) return;
            item = new ItemBuilder(Material.INK_SACK, (short)4).setDisplayname("§7Lapis Lazuli").build();
        }else if(b.getType() == Material.LAPIS_BLOCK){
            if(!api.getLapisBlockSettings(uuid)) return;
            item = new ItemBuilder(Material.LAPIS_BLOCK).setDisplayname("§7Lapis Lazuli Block").build();
        }else if(b.getType() == Material.REDSTONE_BLOCK){
            if(!api.getRedstoneBlockSettings(uuid)) return;
            item = new ItemBuilder(Material.REDSTONE_BLOCK).setDisplayname("§7Redstone Block").build();
        }else if(b.getType() == Material.QUARTZ_BLOCK){
            if(!api.getQuarzBlockSettings(uuid)) return;
            item = new ItemBuilder(Material.QUARTZ_BLOCK).setDisplayname("§7Quarz Block").build();
        }else if(b.getType() == Material.GRAVEL){
            if(!api.getGravelSettings(uuid)) return;
            item = new ItemBuilder(Material.GRAVEL).setDisplayname("§7Kies").build();
        }else if(b.getType() == Material.BRICK){
            if(!api.getBrickSettings(uuid)) return;
            item = new ItemBuilder(Material.BRICK).setDisplayname("§7Ziegel").build();
        }else if(b.getType() == Material.PRISMARINE){
            if(!api.getPrismarinSettings(uuid)) return;
            item = new ItemBuilder(Material.PRISMARINE).setDisplayname("§7Prismarin").build();
        }else if(b.getType() == Material.NETHER_BRICK){
            if(!api.getNetherBrickSettings(uuid)) return;
            item = new ItemBuilder(Material.NETHER_BRICK).setDisplayname("§7Netherziegel").build();
        }else if(b.getType() == Material.RED_SANDSTONE){
            if(!api.getRedSandStoneSettings(uuid)) return;
            item = new ItemBuilder(Material.RED_SANDSTONE).setDisplayname("§7roter Sandstein").build();
        } else if(b.getType() == Material.ICE){
            if(!api.getIceSettings(uuid)) return;
            item = new ItemBuilder(Material.ICE).setDisplayname("§7Eis").build();
        }else if(b.getType() == Material.NETHERRACK){
            if(!api.getNetherRackSettings(uuid)) return;
            item = new ItemBuilder(Material.NETHERRACK).setDisplayname("§7Netherstein").build();
        } else if(b.getType() == Material.PACKED_ICE){
            if(!api.getPackedIceSettings(uuid)) return;
            item = new ItemBuilder(Material.PACKED_ICE).setDisplayname("§7Packeis").build();
        } else if(b.getType() == Material.SEA_LANTERN){
            if(!api.getSeaLaternSettings(uuid)) return;
            item = new ItemBuilder(Material.SEA_LANTERN).setDisplayname("§7Seelaterne").build();
        }else if(b.getType() == Material.ENDER_STONE){
            if(!api.getEndStoneSettings(uuid)) return;
            item = new ItemBuilder(Material.ENDER_STONE).setDisplayname("§7Endstein").build();
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
            if(durability <= 30){
                Bukkit.broadcastMessage("Your item is nearly dead contact felix if you see this!");
            }
        }
    }
}
