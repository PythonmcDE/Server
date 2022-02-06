package me.bluenitrox.school.managers;

import com.mysql.jdbc.Buffer;
import me.bluenitrox.school.warzone.CombatAPI;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageEvent;

public class WorldManager {

    public static final String spawn = "FISCHMC";
    public static final String plotworld = "PlotWelt";
    public static final String warzone = "FISCHMC";
    public static final String arena = "Arena";
    public static final String mine = "FISCHMC";
    public static final String dungeon = "Dungeon";

    public static void turnDamageOff(EntityDamageEvent e) {
        if(e.getEntity() instanceof Player) {
            if (e.getEntity().getWorld().getName().equalsIgnoreCase(spawn)) {
                CombatAPI api = new CombatAPI();
                if (CombatAPI.playerinwarzone != null) {
                    if(CombatAPI.playerinwarzone.containsKey((e.getEntity()).getUniqueId())){
                     return;
                    }
                }
                e.setCancelled(true);
            }
        }
    }

}
