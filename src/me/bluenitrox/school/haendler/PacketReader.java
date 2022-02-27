package me.bluenitrox.school.haendler;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageDecoder;

import java.lang.reflect.Field;
import java.util.LinkedList;
import java.util.List;

import me.bluenitrox.school.SchoolMode;
import me.bluenitrox.school.commands.NBTTagtest;
import me.bluenitrox.school.commands.School;
import me.bluenitrox.school.features.DailyReward;
import me.bluenitrox.school.haendler.commands.Taxi;
import me.bluenitrox.school.managers.MessageManager;
import net.minecraft.server.v1_8_R3.Packet;

import org.bukkit.Bukkit;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import sun.plugin2.message.Message;

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
