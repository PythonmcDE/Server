package me.bluenitrox.school.listener;

import me.bluenitrox.school.boost.BoostInv;
import me.bluenitrox.school.managers.MessageManager;
import me.bluenitrox.school.managers.PermissionsManager;
import me.bluenitrox.school.managers.PlayerJoinManager;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.inventory.Inventory;

import java.util.ArrayList;

public class PlayerCommandPreprocessEvent implements Listener {

    public static ArrayList<String> normal;

    @EventHandler
    public void onCommandSend(final org.bukkit.event.player.PlayerCommandPreprocessEvent e){
        Player p = (Player)e.getPlayer();

        if(e.getMessage().equalsIgnoreCase("/booster") || e.getMessage().equalsIgnoreCase("/boost")){
            Inventory inv = Bukkit.createInventory(null, 9*6, BoostInv.GUI_NAME);

            BoostInv.setBoostContent(inv, p);

            p.openInventory(inv);
            e.setCancelled(true);
            return;
        }

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
        normal.add("/acc");
        normal.add("/me");
        normal.add("/tell");
        normal.add("/op");
    }

}
