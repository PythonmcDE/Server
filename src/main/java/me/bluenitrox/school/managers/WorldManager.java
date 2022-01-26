package me.bluenitrox.school.managers;

import de.Herbystar.TTA.TTA_Methods;
import me.bluenitrox.school.warzone.CombatAPI;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageEvent;

public class WorldManager {

    public static final String spawn = "Spawn";
    public static final String plotworld = "PlotWelt";
    public static final String warzone = "Spawn";
    public static final String arena = "Arena";
    public static final String mine = "Minen";
    public static final String dungeon = "Dungeon";

    public static void turnDamageOff(EntityDamageEvent e) {
        if(e.getEntity() instanceof Player) {
            if (e.getEntity().getWorld().getName().equalsIgnoreCase(mine)) {
                e.setCancelled(true);
            } else if (e.getEntity().getWorld().getName().equalsIgnoreCase(spawn)) {
                CombatAPI api = new CombatAPI();
                if (api.getWarzoneByLocation(e.getEntity().getLocation()) == null) {
                    e.setCancelled(true);
                }
            }
        }
    }

}
