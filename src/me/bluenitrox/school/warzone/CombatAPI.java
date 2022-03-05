package me.bluenitrox.school.warzone;

import de.Herbystar.TTA.TTA_Methods;
import me.bluenitrox.school.aufgabensystem.AufgabenManager;
import me.bluenitrox.school.enchants.bow.Käfig;
import me.bluenitrox.school.managers.LocationManager;
import me.bluenitrox.school.managers.WorldManager;
import net.minecraft.server.v1_8_R3.IChatBaseComponent;
import net.minecraft.server.v1_8_R3.PacketPlayOutChat;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerMoveEvent;

import java.util.*;

public class CombatAPI {

    private final int maxwarzone = 2;
    private final int startcoord1 = -149;
    private final int startcoord2 = -158;
    private final int endcord1 = -159;
    private final int endcord2 = -173;

    public static HashMap<Player, Integer> fight = new HashMap<>();
    public static HashMap<Player, Integer> fightwarzone = new HashMap<>();
    public static HashMap<UUID, String> playerinwarzone = new HashMap<>(); // On wz join

    public void onhitCombat(EntityDamageByEntityEvent e) {
        if (e.getEntity().getWorld().getName().equalsIgnoreCase(WorldManager.warzone)) {
            if (e.getDamager() instanceof Player && e.getEntity() instanceof Player) {
                if (getWarzoneByLocation(e.getEntity().getLocation()) != null) {
                    Player p = (Player) e.getEntity();
                    Player d = (Player) e.getDamager();
                    if (!fightwarzone.containsKey(p)) {
                        fightwarzone.put(p, Integer.parseInt(Objects.requireNonNull(getWarzoneByLocation(p.getLocation()))));
                        AufgabenManager.setToggle(p.getUniqueId(), 1);
                    }
                    if (!fightwarzone.containsKey(d)) {
                        fightwarzone.put(d, Integer.parseInt(Objects.requireNonNull(getWarzoneByLocation(d.getLocation()))));
                        AufgabenManager.setToggle(d.getUniqueId(), 1);
                    }
                    fight.put(p, 25);
                    fight.put(d, 25);
                    updateTimeBar();
                }
            }else if(e.getDamager() instanceof Projectile && e.getEntity() instanceof Player){
                if (getWarzoneByLocation(e.getEntity().getLocation()) != null) {
                    Player p = (Player) e.getEntity();
                    Projectile projectile = (Projectile)e.getDamager();
                    Player d = (Player) projectile.getShooter();
                    if (!fightwarzone.containsKey(p)) {
                        fightwarzone.put(p, Integer.parseInt(Objects.requireNonNull(getWarzoneByLocation(p.getLocation()))));
                        AufgabenManager.setToggle(p.getUniqueId(), 1);
                    }
                    if (!fightwarzone.containsKey(d)) {
                        fightwarzone.put(d, Integer.parseInt(Objects.requireNonNull(getWarzoneByLocation(d.getLocation()))));
                        AufgabenManager.setToggle(d.getUniqueId(), 1);
                    }
                    fight.put(p, 25);
                    fight.put(d, 25);
                    updateTimeBar();
                }
            }
        }
    }

    public static void onQuit(Player p){
        if(fight.containsKey(p)){
            p.damage(100);
        }
    }

    public void joinwarzone(PlayerMoveEvent e){
        if(e.getPlayer().getWorld().getName().equalsIgnoreCase(WorldManager.warzone)){
            if(getWarzoneByLocation(e.getPlayer().getLocation()) != null){
                if(playerinwarzone != null) {
                    if (!playerinwarzone.containsKey(e.getPlayer().getUniqueId())) {
                        Bukkit.broadcastMessage(getWarzoneByLocation(e.getPlayer().getLocation()));
                        playerinwarzone.put(e.getPlayer().getUniqueId(), getWarzoneByLocation(e.getPlayer().getLocation()));
                        Bukkit.broadcastMessage("wz join");
                        TTA_Methods.sendActionBar(e.getPlayer(), "§b» §7Warzone betreten: §6Levelunterschied: " + getLevelunterschied(Integer.parseInt(getWarzoneByLocation(e.getPlayer().getLocation()))));
                        e.getPlayer().playSound(e.getPlayer().getLocation(), Sound.NOTE_PLING, 1L, 1L);
                    }
                }
            }else if(playerinwarzone != null) {
                if (playerinwarzone.containsKey(e.getPlayer().getUniqueId())) {
                    playerinwarzone.remove(e.getPlayer().getUniqueId());
                    Bukkit.broadcastMessage("wz leave");
                    Bukkit.broadcastMessage(getWarzoneByLocation(e.getPlayer().getLocation()));
                    return;
                }
            }
            if(fight != null){
                if(fight.containsKey(e.getPlayer())){
                    if((e.getPlayer().getLocation().getX() <= startcoord1 && e.getPlayer().getLocation().getX() >= startcoord1 -3) || (e.getPlayer().getLocation().getX() <= startcoord2 && e.getPlayer().getLocation().getX() >= startcoord2 -5)){
                        Player t = e.getPlayer();
                        t.setVelocity(t.getVelocity().setX(-0.5D));
                        t.playSound(t.getLocation(), Sound.PISTON_EXTEND, 1L, 1L);
                    }
                    if((e.getPlayer().getLocation().getX() >= endcord1 && e.getPlayer().getLocation().getX() <= endcord1 +3) || (e.getPlayer().getLocation().getX() >= endcord2 && e.getPlayer().getLocation().getX() <= endcord2 +3)){
                        Player t = e.getPlayer();
                        t.setVelocity(t.getVelocity().setX(0.5D));
                        t.playSound(t.getLocation(), Sound.PISTON_RETRACT, 1L, 1L);
                    }
                }
            }
        }
    }

    private String getLevelunterschied(int warzone){
        if(warzone == 1){
            return 15 +" Level";
        }else if(warzone == 2){
            return 30 +" Level";
        }else return "unendlich";
    }

    public String getWarzoneByLocation(Location loc) {
        for (int i = 1; i <= maxwarzone; i++) {
            String curr = String.valueOf(i);
            loc.setPitch(0);
            loc.setYaw(0);
            loc.setX(Math.round(loc.getX()));
            loc.setZ(Math.round(loc.getZ()));
            loc.setY(Math.round(loc.getY()));
            if(getBlocks(curr) != null) {
                if (getBlocks(curr).contains(loc)) {
                    return curr;
                }
            }
        }
        return null;
    }

    private LinkedList<Location> getBlocks(String warzone){
        LinkedList<Location> locs = getEckPoints("warzone" + warzone);
        Location loc1 = locs.get(0);
        Location loc2 = locs.get(1);
        if(loc1 == null){
            return null;
        }else if(loc2 == null){
            return null;
        }

        return getAllLocationsInside(loc1, loc2);
    }

    private LinkedList<Location> getEckPoints(String warzone){
        Location loc1;
        Location loc2;
        LinkedList<Location> templist = new LinkedList<>();

        String temp = "warzonepoint1" + warzone;
        String temp2 = "warzonepoint2" + warzone;
        loc1 = new LocationManager(temp).getLocation();
        loc2 = new LocationManager(temp2).getLocation();
        templist.add(loc1);
        templist.add(loc2);
        return templist;
    }

    private LinkedList<Location> getAllLocationsInside(Location loc1, Location loc2){
        int yTop = 0;
        int yBottom = 0;
        int xTop = 0;
        int xBottom = 0;
        int zTop = 0;
        int zBottom = 0;

        if(loc1 == null){
            return null;
        }
        if(loc2 == null){
            return null;
        }
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

    public static void updateTimeBar(){
        Bukkit.getOnlinePlayers().forEach(players ->{
            final String msg = "§8« §c§lIm Kampf §7- §6§l" + fight.get(players) +" Sekunden §8»";
            if(fight.containsKey(players)) {
                sendActionbar(players, msg);
            }
        });
    }

    private static void sendActionbar(final Player player, final String message) {
        final IChatBaseComponent iChatBaseComponent = IChatBaseComponent.ChatSerializer
                .a("{\"text\": \"" + ChatColor.translateAlternateColorCodes('&', message) + "\"}");
        final PacketPlayOutChat packet = new PacketPlayOutChat(iChatBaseComponent, (byte) 2);
        ((CraftPlayer) player).getHandle().playerConnection.sendPacket(packet);
    }

}
