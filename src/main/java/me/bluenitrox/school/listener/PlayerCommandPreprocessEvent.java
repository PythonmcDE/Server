package me.bluenitrox.school.listener;

import me.bluenitrox.school.boost.BoostInv;
import me.bluenitrox.school.managers.MessageManager;
import me.bluenitrox.school.managers.PermissionsManager;
import me.bluenitrox.school.managers.PlayerJoinManager;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.help.HelpTopic;
import org.bukkit.inventory.Inventory;

import java.util.ArrayList;

public class PlayerCommandPreprocessEvent implements Listener {

    public static ArrayList<String> normal;

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onCommandSend(final org.bukkit.event.player.PlayerCommandPreprocessEvent e){
        Player p = (Player)e.getPlayer();

        if(!(e.isCancelled())) {
            String msg = e.getMessage().split(" ")[0];
            HelpTopic topic = Bukkit.getServer().getHelpMap().getHelpTopic(msg);
            if(topic == null) {
                p.sendMessage(MessageManager.FALSECOMMAND(PlayerJoinManager.language));
                e.setCancelled(true);
            }
        }


        if(e.getMessage().equalsIgnoreCase("/booster") || e.getMessage().equalsIgnoreCase("/boost")){
            Inventory inv = Bukkit.createInventory(null, 9*6, BoostInv.GUI_NAME);

            BoostInv.setBoostContent(inv, p);

            p.openInventory(inv);
            e.setCancelled(true);
            return;
        }

        normal = new ArrayList<>();
        registerNormalCommand();

        if(!p.hasPermission(PermissionsManager.COMMANDBLOCK)) {
            if (normal.contains(e.getMessage())) {
                e.setCancelled(true);
                p.sendMessage(MessageManager.FALSECOMMAND(PlayerJoinManager.language));
                return;
            }
        }
    }

    private void registerNormalCommand(){
        normal.add("/acc");
        normal.add("/me");
        normal.add("/tell");
        normal.add("/op");
        normal.add("/?");
        normal.add("/!");
        normal.add("/help");
        normal.add("/abount");
        normal.add("/version");
        normal.add("/ver");
        normal.add("/pl");
        normal.add("/plugins");
        normal.add("/plugin");
        normal.add("/anticrash");
        normal.add("/händler");
    }

}
