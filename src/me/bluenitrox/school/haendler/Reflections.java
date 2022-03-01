package me.bluenitrox.school.haendler;

import java.lang.reflect.Field;

import me.bluenitrox.school.SchoolMode;
import me.bluenitrox.school.listener.PlayerJoinListener;
import net.minecraft.server.v1_8_R3.Packet;

import org.bukkit.Bukkit;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class Reflections {


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

    public void sendPacket(Packet<?> packet,Player player){
        ((CraftPlayer)player).getHandle().playerConnection.sendPacket(packet);
    }

}
