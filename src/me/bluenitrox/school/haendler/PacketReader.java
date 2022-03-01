package me.bluenitrox.school.haendler;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageDecoder;

import java.lang.reflect.Field;
import java.util.LinkedList;
import java.util.List;

import me.bluenitrox.school.SchoolMode;
import me.bluenitrox.school.commands.Mine;
import me.bluenitrox.school.commands.NBTTagtest;
import me.bluenitrox.school.commands.School;
import me.bluenitrox.school.dungeon.manager.DungeonManager;
import me.bluenitrox.school.features.DailyReward;
import me.bluenitrox.school.haendler.commands.*;
import me.bluenitrox.school.managers.LocationManager;
import me.bluenitrox.school.managers.MessageManager;
import me.bluenitrox.school.mine.angelmine.Angelmine;
import me.bluenitrox.school.mine.angelmine.AngelminenManager;
import net.minecraft.server.v1_8_R3.Packet;

import org.bukkit.Bukkit;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.scheduler.BukkitRunnable;

public class PacketReader {

    public static LinkedList<Player> interacted = new LinkedList<>();
    Player player;
    Channel channel;

    public PacketReader(Player player) {
        this.player = player;
    }

    public void inject(){
        CraftPlayer cPlayer = (CraftPlayer)this.player;
        channel = cPlayer.getHandle().playerConnection.networkManager.channel;
        channel.pipeline().addAfter("decoder", "PacketInjector", new MessageToMessageDecoder<Packet<?>>() {@Override protected void decode(ChannelHandlerContext arg0, Packet<?> packet,List<Object> arg2) throws Exception {arg2.add(packet);readPacket(packet);}});
    }

    public void uninject(){
        if(channel.pipeline().get("PacketInjector") != null){
            channel.pipeline().remove("PacketInjector");
        }
    }


    public void readPacket(Packet<?> packet){
        if(interacted != null){
            if(interacted.contains(player)){
                return;
            }
        }
        if(packet.getClass().getSimpleName().equalsIgnoreCase("PacketPlayInUseEntity")){
            int id = (Integer)getValue(packet, "a");

            if(NPCAPI.dailyreward.getEntityID() == id){
                if(getValue(packet, "action").toString().equalsIgnoreCase("INTERACT")){
                    DailyReward dr = new DailyReward();
                    dr.onOpeninv(player);
                    interacted(player);
                    return;
                }
            }
            if(NPCAPI.Taxi.getEntityID() == id){
                if(getValue(packet, "action").toString().equalsIgnoreCase("INTERACT")){
                    Taxi.onInteract(player);
                    interacted(player);
                    return;
                }
            }
            if(NPCAPI.Jäger.getEntityID() == id){
                if(getValue(packet, "action").toString().equalsIgnoreCase("INTERACT")){
                    Jäger.onInteract(player);
                    interacted(player);
                    return;
                }
            }
            if(NPCAPI.Techniker.getEntityID() == id){
                if(getValue(packet, "action").toString().equalsIgnoreCase("INTERACT")){
                    Techniker.onCommand(player);
                    interacted(player);
                    return;
                }
            }
            if(NPCAPI.Magier.getEntityID() == id){
                if(getValue(packet, "action").toString().equalsIgnoreCase("INTERACT")){
                    Magier.onCommand(player);
                    interacted(player);
                    return;
                }
            }
            if(NPCAPI.Künstlerin.getEntityID() == id){
                if(getValue(packet, "action").toString().equalsIgnoreCase("INTERACT")){
                    Künstlerin.onCommand(player);
                    interacted(player);
                    return;
                }
            }
            if(NPCAPI.Landwirt.getEntityID() == id){
                if(getValue(packet, "action").toString().equalsIgnoreCase("INTERACT")){
                    Landwirt.onCommand(player);
                    interacted(player);
                    return;
                }
            }
            if(NPCAPI.Gärtner.getEntityID() == id){
                if(getValue(packet, "action").toString().equalsIgnoreCase("INTERACT")){
                    Gärtner.onCommand(player);
                    interacted(player);
                    return;
                }
            }
            if(NPCAPI.Förster.getEntityID() == id){
                if(getValue(packet, "action").toString().equalsIgnoreCase("INTERACT")){
                    Förster.onCommand(player);
                    interacted(player);
                    return;
                }
            }
            if(NPCAPI.Bergmann.getEntityID() == id){
                if(getValue(packet, "action").toString().equalsIgnoreCase("INTERACT")){
                    Bergmann.onCommand(player);
                    interacted(player);
                    return;
                }
            }
            if(NPCAPI.Bauarbeiter.getEntityID() == id){
                if(getValue(packet, "action").toString().equalsIgnoreCase("INTERACT")){
                    Bauarbeiter.onCommand(player);
                    interacted(player);
                    return;
                }
            }
            if(NPCAPI.Koch.getEntityID() == id){
                if(getValue(packet, "action").toString().equalsIgnoreCase("INTERACT")){
                    Koch.onCommand(player);
                    interacted(player);
                    return;
                }
            }
            if(NPCAPI.Schmied.getEntityID() == id){
                if(getValue(packet, "action").toString().equalsIgnoreCase("INTERACT")){
                    Schmied.onCommand(player);
                    interacted(player);
                    return;
                }
            }
            if(NPCAPI.Abenteurer.getEntityID() == id){
                if(getValue(packet, "action").toString().equalsIgnoreCase("INTERACT")){
                    Abenteurer.onCommand(player);
                    interacted(player);
                    return;
                }
            }
            if(NPCAPI.Mine.getEntityID() == id){
                if(getValue(packet, "action").toString().equalsIgnoreCase("INTERACT")){
                    Inventory inv = Bukkit.createInventory(null, 9*6, Mine.guiname);

                    Mine.setMinenContent(inv, player.getUniqueId());

                    player.openInventory(inv);
                    interacted(player);
                    return;
                }
            }
            if(NPCAPI.Angelmine.getEntityID() == id){
                if(getValue(packet, "action").toString().equalsIgnoreCase("INTERACT")){
                    Inventory inv = Bukkit.createInventory(null, 9*6, Angelmine.guiname);
                    Angelmine.setInventoryContent(inv, player);
                    interacted(player);
                    return;
                }
            }
            if(NPCAPI.Dungeon.getEntityID() == id){
                if(getValue(packet, "action").toString().equalsIgnoreCase("INTERACT")){
                    player.teleport(new LocationManager("Dungeonspawn").getLocation());
                    DungeonManager dm = new DungeonManager();
                    dm.onJoinDungeon(player);
                    AngelminenManager.quitAngelmine(player);
                    interacted(player);
                    return;
                }
            }
        }
    }
    private void interacted(Player player){
        interacted.add(player);
        new BukkitRunnable() {
            @Override
            public void run() {
                interacted.remove(player);
            }
        }.runTaskLater(SchoolMode.getInstance(), 20);
    }

    public void setValue(Object obj,String name,Object value){
        try{
            Field field = obj.getClass().getDeclaredField(name);
            field.setAccessible(true);
            field.set(obj, value);
        }catch(Exception e){}
    }

    public Object getValue(Object obj,String name){
        try{
            Field field = obj.getClass().getDeclaredField(name);
            field.setAccessible(true);
            return field.get(obj);
        }catch(Exception e){}
        return null;
    }

}
