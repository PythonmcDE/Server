package me.bluenitrox.school.itemspawner;

import net.minecraft.server.v1_8_R3.*;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import java.util.Collections;
import java.util.HashSet;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.craftbukkit.v1_8_R3.CraftWorld;
import org.bukkit.craftbukkit.v1_8_R3.inventory.CraftItemStack;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class ItemSpawnerManager implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("itemspawner")) {
            if (sender instanceof ConsoleCommandSender) {
                sender.sendMessage("You need to be a player to use this command!");
                return true;
            } else if (!sender.hasPermission("itemspawner.use")) {
                sender.sendMessage(ChatColor.DARK_GRAY + "You're not allowed to use this command!");
                return true;
            } else if (args.length > 1) {
                sender.sendMessage(ChatColor.DARK_RED + "Usage: /is <delay>");
                return true;
            } else {
                int delay = -1;
                if (args.length == 1) {
                    try {
                        delay = Integer.parseInt(args[0]);
                    } catch (Exception var15) {
                        sender.sendMessage(ChatColor.RED + "Usage: /is <delay>");
                        return true;
                    }
                }

                Player player = (Player)sender;
                if (player.getItemInHand().getType() == Material.AIR) {
                    sender.sendMessage(ChatColor.RED + "You need to be holding an item to use this command!");
                    return true;
                } else {
                    //Block target = player.getTargetBlock((HashSet)null, 200);
                    Block target = player.getTargetBlock((HashSet<Byte>) null, 200);
                    //net.minecraft.server.v1_8_R3.Block target1 = player.getTargetBlock((HashSet) null, 200);
                    if (target != null && target.getType() == Material.MOB_SPAWNER) {
                        World world = ((CraftWorld)target.getWorld()).getHandle();
                       // TileEntity tileEntity = world.getTileEntity((BlockPosition) target.getWorld().getBlockAt(target.getX(), target.getY(), target.getZ()));
                        LivingEntity tileEntity = (LivingEntity) world.getTileEntity((BlockPosition) target.getWorld().getBlockAt(target.getX(), target.getY(), target.getZ()));
                        if (tileEntity instanceof TileEntityMobSpawner) {
                            TileEntityMobSpawner mobSpawner = (TileEntityMobSpawner)tileEntity;
                            NBTTagCompound spawnerTag = new NBTTagCompound();
                            mobSpawner.b(spawnerTag);
                            if (delay == -1) {
                                spawnerTag.remove("SpawnPotentials");
                                spawnerTag.setString("EntityId", "Item");
                                NBTTagCompound itemTag = new NBTTagCompound();
                                itemTag.setShort("Health", (short)5);
                                itemTag.setShort("Age", (short)0);
                                ItemStack itemStack = CraftItemStack.asNMSCopy((CraftItemStack)player.getItemInHand());
                                NBTTagCompound itemStackTag = new NBTTagCompound();
                                itemStack.save(itemStackTag);
                                itemStackTag.setByte("Count", (byte)1);
                                itemTag.set("Item", itemStackTag);
                                spawnerTag.set("SpawnData", itemTag);
                                spawnerTag.setShort("SpawnCount", (short)itemStack.count);
                                spawnerTag.setShort("SpawnRange", (short)((int)player.getLocation().distance(target.getLocation())));
                            } else {
                                spawnerTag.setShort("Delay", (short)0);
                                spawnerTag.setShort("MinSpawnDelay", (short)(delay * 20));
                                spawnerTag.setShort("MaxSpawnDelay", (short)(delay * 20));
                                spawnerTag.setShort("MaxNearbyEntities", (short)player.getItemInHand().getAmount());
                                spawnerTag.setShort("RequiredPlayerRange", (short)((int)player.getLocation().distance(target.getLocation())));
                            }

                            mobSpawner.a(spawnerTag);
                            sender.sendMessage(ChatColor.GREEN + "Properties were successfully edited!");
                        } else {
                            sender.sendMessage(ChatColor.RED + "Something went wrong!");
                        }

                        return true;
                    } else {
                        sender.sendMessage(ChatColor.RED + "You need to be looking at a spawner to use this command!");
                        return true;
                    }
                }
            }
        } else {
            return false;
        }
    }
}
