package me.bluenitrox.school.itemspawner;

import me.bluenitrox.school.utils.ItemBuilder;
import net.minecraft.server.v1_8_R3.*;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.v1_8_R3.CraftWorld;
import org.bukkit.craftbukkit.v1_8_R3.inventory.CraftItemStack;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.HashSet;

public class ItemSpawner implements CommandExecutor {


    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {

        if(!(commandSender instanceof Player)) {
            return true;
        }
        Player player = (Player) commandSender;
        Block targetBlock = player.getTargetBlock((HashSet<Byte>) null, 200);
        BlockPosition blockPos = new BlockPosition(targetBlock.getX(), targetBlock.getY(), targetBlock.getZ());
        if(targetBlock.getType() == Material.MOB_SPAWNER && targetBlock != null) {
            TileEntityMobSpawner spawner = (TileEntityMobSpawner) ((CraftWorld) targetBlock.getWorld()).getHandle().getTileEntity(blockPos);

            NBTTagCompound spawnerTag = new NBTTagCompound();
            spawner.b(spawnerTag);
            spawnerTag.remove("SpawnPotentials");
            spawnerTag.setString("spawnername", "Diamondspawner");
            spawnerTag.setString("owner123", player.getName());
            Bukkit.broadcastMessage(String.valueOf(targetBlock.getX()));
            Bukkit.broadcastMessage(String.valueOf(targetBlock.getY()));
            Bukkit.broadcastMessage(String.valueOf(targetBlock.getZ()));
            Bukkit.broadcastMessage(String.valueOf(targetBlock.getWorld()));
            Bukkit.broadcastMessage(spawnerTag.getString("owner123"));
            spawner.a(spawnerTag);
            commandSender.sendMessage(ChatColor.GREEN + "Properties were successfully edited!");
        } else {
            commandSender.sendMessage("Falsch");
        }
        return true;
    }
}
