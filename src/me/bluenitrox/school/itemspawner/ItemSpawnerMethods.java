package me.bluenitrox.school.itemspawner;

import net.minecraft.server.v1_8_R3.*;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.craftbukkit.v1_8_R3.CraftWorld;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class ItemSpawnerMethods {

    public void checkOwner(PlayerInteractEvent event) {

        if(event.getAction() == Action.RIGHT_CLICK_BLOCK) {
            if(event.getClickedBlock().getType() == Material.MOB_SPAWNER) {
                NBTTagCompound nbt = getNBT(event.getClickedBlock().getX(), event.getClickedBlock().getY(), event.getClickedBlock().getZ(), event.getClickedBlock().getWorld());
                Bukkit.broadcastMessage(nbt.getString("owner"));
                Bukkit.broadcastMessage(String.valueOf(event.getClickedBlock().getX()));
                Bukkit.broadcastMessage(String.valueOf(event.getClickedBlock().getY()));
                Bukkit.broadcastMessage(String.valueOf(event.getClickedBlock().getZ()));
                Bukkit.broadcastMessage(String.valueOf(event.getClickedBlock() .getWorld()));
                if(nbt.getString("owner123").equalsIgnoreCase(event.getPlayer().getName())) {
                    Bukkit.broadcastMessage("abc FUNKTIONIERT");
                } else {
                    Bukkit.broadcastMessage("KEIN OWNER");
                }
            } else {
                Bukkit.broadcastMessage("KEIN SPAWNER");
            }
        } else {
            Bukkit.broadcastMessage("KEIN INTERACT");
        }

    }
    public NBTTagCompound getNBT(int x, int y, int z, World world) {
        WorldServer nmsWorld = ((CraftWorld) world).getHandle();
        TileEntity tile = nmsWorld.getTileEntity(new BlockPosition(x, y, z));
        NBTTagCompound nbt = new NBTTagCompound();
        if (tile != null) {
            tile.b(nbt);
        }
        return nbt;
    }

    private boolean isOwner(Player player, Block block) {
        boolean b = false;
        BlockPosition blockPos = new BlockPosition(block.getX(), block.getY(), block.getZ());
        TileEntityMobSpawner spawner = (TileEntityMobSpawner) ((CraftWorld) block.getWorld()).getHandle().getTileEntity(blockPos);

        NBTTagCompound spawnerTag = new NBTTagCompound();
        spawner.b(spawnerTag);
        if(spawnerTag.getString("owner").equalsIgnoreCase(player.getUniqueId().toString())) {
            return true;
        }
        spawner.a(spawnerTag);
        return b;
    }

    private String getName(Player player, Block block) {
        String owner = "";
        BlockPosition blockPos = new BlockPosition(block.getX(), block.getY(), block.getZ());
        TileEntityMobSpawner spawner = (TileEntityMobSpawner) ((CraftWorld) block.getWorld()).getHandle().getTileEntity(blockPos);

        NBTTagCompound spawnerTag = new NBTTagCompound();
        spawner.b(spawnerTag);
        if(spawnerTag != null) {
            owner = spawnerTag.getString("name");
        }
        spawner.a(spawnerTag);

        return owner;
    }


}
