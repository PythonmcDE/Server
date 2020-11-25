package me.bluenitrox.school.listener;

import me.bluenitrox.school.managers.MessageManager;
import me.bluenitrox.school.managers.PermissionsManager;
import me.bluenitrox.school.managers.PlayerJoinManager;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import java.util.ArrayList;

public class PlayerCommandPreprocessEvent implements Listener {

    public static ArrayList<String> normal;

    @EventHandler
    public void onCommandSend(final org.bukkit.event.player.PlayerCommandPreprocessEvent e){
        Player p = (Player)e.getPlayer();

        registerNormalCommand();

        normal = new ArrayList<>();
        if(!p.hasPermission(PermissionsManager.COMMANDBLOCK)) {
            if (normal.contains(e.getMessage())) {
                e.setCancelled(true);
                p.sendMessage(MessageManager.FALSECOMMAND(PlayerJoinManager.language));
                return;
            }
        }
    }

    private void registerNormalCommand(){
        normal.add("acc");
        normal.add("me");
        normal.add("tell");
        normal.add("boosterinv");
        normal.add("op");
    }

}
