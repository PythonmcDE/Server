package me.bluenitrox.school.listener;

import me.bluenitrox.school.managers.ExpManager;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.scheduler.GroupedThreadFactory;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.plugin.messaging.PluginMessageListener;

public class AsyncPlayerChatEvent implements Listener {

    @EventHandler
    public void onChat(final org.bukkit.event.player.AsyncPlayerChatEvent e){
        e.setFormat("§8[§7" + ExpManager.getLevel(e.getPlayer().getUniqueId()) + "§8] " + e.getPlayer().getDisplayName() + " §8» §7" + e.getMessage());
    }

}
