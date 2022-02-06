package me.bluenitrox.school.aufgabensystem;

import me.bluenitrox.school.SchoolMode;
import net.minecraft.server.v1_8_R3.IChatBaseComponent;
import net.minecraft.server.v1_8_R3.PacketPlayOutChat;
import org.bukkit.ChatColor;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.scheduler.BukkitRunnable;

public class AufgabenMethods {

    public static void onTaskCommand(PlayerCommandPreprocessEvent event) {
        String msg = event.getMessage();

        if(msg.equalsIgnoreCase("/school") && AufgabenManager.getTask(event.getPlayer().getUniqueId()) == 1) {
            AufgabenManager.onComplete(event.getPlayer().getUniqueId(), 1);
        }
    }

    public static void updateTaskBar(Player player) {
        new BukkitRunnable() {

            @Override
            public void run() {
                if (SchoolMode.getPlayerToggleTask(player.getUniqueId()) == 0) {
                    sendActionbar(player, Aufgaben.getTask(player));
                } else {
                    this.cancel();
                }
            }
        }.runTaskTimerAsynchronously(SchoolMode.getInstance(), 10, 10);
    }

    public static void sendActionbar(final Player player, final String message) {
        final IChatBaseComponent iChatBaseComponent = IChatBaseComponent.ChatSerializer
                .a("{\"text\": \"" + ChatColor.translateAlternateColorCodes('&', message) + "\"}");
        final PacketPlayOutChat packet = new PacketPlayOutChat(iChatBaseComponent, (byte) 2);
        ((CraftPlayer) player).getHandle().playerConnection.sendPacket(packet);
    }

}
