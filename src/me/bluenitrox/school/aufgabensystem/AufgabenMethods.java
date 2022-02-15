package me.bluenitrox.school.aufgabensystem;

import de.Herbystar.TTA.TTA_Methods;
import me.bluenitrox.school.SchoolMode;
import me.bluenitrox.school.commands.Mine;
import me.bluenitrox.school.commands.School;
import me.bluenitrox.school.commands.Stats;
import me.bluenitrox.school.features.KitAPI;
import me.bluenitrox.school.features.KitItems;
import me.bluenitrox.school.features.StatsAPI;
import me.bluenitrox.school.listener.ActionBarMessageEvent;
import me.bluenitrox.school.mine.manager.MinenManager;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerKickEvent;
import org.bukkit.scheduler.BukkitRunnable;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;

public class AufgabenMethods {

    private static String nmsver;
    private static boolean useOldMethods = false;
    private static HashMap<Player, String> messageblock = new HashMap<>();
    StatsAPI statsAPI = new StatsAPI();

    public static void onTaskCommand(PlayerCommandPreprocessEvent event) {
        String msg = event.getMessage();

        if(msg.equalsIgnoreCase("/school") && AufgabenManager.getTask(event.getPlayer().getUniqueId()) == 1) {
            AufgabenManager.onComplete(event.getPlayer().getUniqueId(), 1);
        } else if(msg.equalsIgnoreCase("/xp") && AufgabenManager.getTask(event.getPlayer().getUniqueId()) == 2) {
            AufgabenManager.onComplete(event.getPlayer().getUniqueId(), 2);
        } else if(msg.equalsIgnoreCase("/clan") && AufgabenManager.getTask(event.getPlayer().getUniqueId()) == 7) {
            AufgabenManager.onComplete(event.getPlayer().getUniqueId(), 7);
        } else if(msg.equalsIgnoreCase("/plotworld") && AufgabenManager.getTask(event.getPlayer().getUniqueId()) == 11) {
            AufgabenManager.onComplete(event.getPlayer().getUniqueId(), 11);
        } else if(msg.equalsIgnoreCase("/stats") && AufgabenManager.getTask(event.getPlayer().getUniqueId()) == 18) {
            AufgabenManager.onComplete(event.getPlayer().getUniqueId(), 18);
        }
    }

    public static void onCLick(InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked();
        if(AufgabenManager.getTask(player.getUniqueId())  == 3) {
            if (!KitAPI.holz.containsKey(player.getUniqueId())) {
                if(event.getClickedInventory() != null) {
                    if (event.getClickedInventory().getName().equalsIgnoreCase(KitAPI.guiname) && event.getCurrentItem() != null) {
                        if (event.getCurrentItem().getType() == Material.WOOD_SWORD) {
                            AufgabenManager.getPrice(player, 3);
                        }
                    }
                }
            }
        } else if(AufgabenManager.getTask(player.getUniqueId())== 4) {
            if(event.getClickedInventory().getName().equalsIgnoreCase(Mine.guiname) && event.getCurrentItem() != null) {
                if(event.getCurrentItem().getType() == Material.STONE) {
                    AufgabenManager.getPrice(player, 4);
                }
            }
        }
    }

    public void onBlockBreak(BlockBreakEvent event) {
        Player player = event.getPlayer();

        if(AufgabenManager.getTask(player.getUniqueId()) == 5) {
            if(SchoolMode.getPlayerBlocks(player.getUniqueId()) >= 50) {
                AufgabenManager.getPrice(player, 5);
            }
        }
    }

    public void sendTTAActionbar(Player player, String message) {
        TTA_Methods.sendActionBar(player, message);
    }

    public static void sendActionBar(Player player, String message) {
        nmsver = Bukkit.getServer().getClass().getPackage().getName();
        nmsver = nmsver.substring(nmsver.lastIndexOf(".") + 1);
        AufgabenManager am = new AufgabenManager();
        if (!player.isOnline()) {
            return; // Player may have logged out
        }

        // Call the event, if cancelled don't send Action Bar
        ActionBarMessageEvent actionBarMessageEvent = new ActionBarMessageEvent(player, message);
        Bukkit.getPluginManager().callEvent(actionBarMessageEvent);

        if(AufgabenManager.shouldcancle != null){
            if(AufgabenManager.shouldcancle.contains(player)){

                actionBarMessageEvent.setCancelled(true);
                messageblock.put(player, am.getCurrentCompleteTaskMessage(player.getUniqueId()));
                AufgabenManager.shouldcancle.remove(player);
            }
        }
        if(messageblock != null){
            if(messageblock.containsKey(player)){
                if(!messageblock.get(player).equalsIgnoreCase(message)){
                    actionBarMessageEvent.setCancelled(true);
                }
            }
        }

        if (actionBarMessageEvent.isCancelled())
            return;

        try {
            Class<?> craftPlayerClass = Class.forName("org.bukkit.craftbukkit." + nmsver + ".entity.CraftPlayer");
            Object craftPlayer = craftPlayerClass.cast(player);
            Object packet;
            Class<?> packetPlayOutChatClass = Class.forName("net.minecraft.server." + nmsver + ".PacketPlayOutChat");
            Class<?> packetClass = Class.forName("net.minecraft.server." + nmsver + ".Packet");
            if (useOldMethods) {
                Class<?> chatSerializerClass = Class.forName("net.minecraft.server." + nmsver + ".ChatSerializer");
                Class<?> iChatBaseComponentClass = Class.forName("net.minecraft.server." + nmsver + ".IChatBaseComponent");
                Method m3 = chatSerializerClass.getDeclaredMethod("a", String.class);
                Object cbc = iChatBaseComponentClass.cast(m3.invoke(chatSerializerClass, "{\"text\": \"" + message + "\"}"));
                packet = packetPlayOutChatClass.getConstructor(new Class<?>[]{iChatBaseComponentClass, byte.class}).newInstance(cbc, (byte) 2);
            } else {
                Class<?> chatComponentTextClass = Class.forName("net.minecraft.server." + nmsver + ".ChatComponentText");
                Class<?> iChatBaseComponentClass = Class.forName("net.minecraft.server." + nmsver + ".IChatBaseComponent");
                try {
                    Class<?> chatMessageTypeClass = Class.forName("net.minecraft.server." + nmsver + ".ChatMessageType");
                    Object[] chatMessageTypes = chatMessageTypeClass.getEnumConstants();
                    Object chatMessageType = null;
                    for (Object obj : chatMessageTypes) {
                        if (obj.toString().equals("GAME_INFO")) {
                            chatMessageType = obj;
                        }
                    }
                    Object chatCompontentText = chatComponentTextClass.getConstructor(new Class<?>[]{String.class}).newInstance(message);
                    packet = packetPlayOutChatClass.getConstructor(new Class<?>[]{iChatBaseComponentClass, chatMessageTypeClass}).newInstance(chatCompontentText, chatMessageType);
                } catch (ClassNotFoundException cnfe) {
                    Object chatCompontentText = chatComponentTextClass.getConstructor(new Class<?>[]{String.class}).newInstance(message);
                    packet = packetPlayOutChatClass.getConstructor(new Class<?>[]{iChatBaseComponentClass, byte.class}).newInstance(chatCompontentText, (byte) 2);
                }
            }
            Method craftPlayerHandleMethod = craftPlayerClass.getDeclaredMethod("getHandle");
            Object craftPlayerHandle = craftPlayerHandleMethod.invoke(craftPlayer);
            Field playerConnectionField = craftPlayerHandle.getClass().getDeclaredField("playerConnection");
            Object playerConnection = playerConnectionField.get(craftPlayerHandle);
            Method sendPacketMethod = playerConnection.getClass().getDeclaredMethod("sendPacket", packetClass);
            sendPacketMethod.invoke(playerConnection, packet);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void sendActionBar(final Player player, final String message, int duration) {
        if (player != null) {
            sendActionBar(player, message);

            if (duration >= 0) {
                // Sends empty message at the end of the duration. Allows messages shorter than 3 seconds, ensures precision.
                new BukkitRunnable() {
                    @Override
                    public void run() {
                        sendActionBar(player, "");
                    }
                }.runTaskLater(SchoolMode.getInstance(), duration + 1);
            }

            // Re-sends the messages every 3 seconds so it doesn't go away from the player's screen.
            while (duration > 40) {
                duration -= 40;
                new BukkitRunnable() {
                    @Override
                    public void run() {
                        if(SchoolMode.playertoggletask.containsKey(player.getUniqueId())) {
                            if (AufgabenManager.getToggle(player.getUniqueId()) == 0) {
                                sendActionBar(player, message);
                            }
                        }
                    }
                }.runTaskLater(SchoolMode.getInstance(), (long) duration);
            }
            Bukkit.broadcastMessage("exit arg confirmed");
        }
    }

}
