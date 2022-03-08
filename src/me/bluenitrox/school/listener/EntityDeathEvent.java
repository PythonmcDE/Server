package me.bluenitrox.school.listener;

import me.bluenitrox.school.SchoolMode;
import me.bluenitrox.school.boost.booster.Xpbooster;
import me.bluenitrox.school.dungeon.manager.DungeonManager;
import me.bluenitrox.school.enchants.bow.BowCounter;
import me.bluenitrox.school.enchants.sword.MobCounter;
import me.bluenitrox.school.enchants.sword.Wilderei;
import me.bluenitrox.school.features.stats.StatsAPI;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class EntityDeathEvent implements Listener {

    @EventHandler
    public void onDeath(final org.bukkit.event.entity.EntityDeathEvent e){
        Entity entity = e.getEntity();
        if(e.getEntity().getKiller() != null){
            Player killer = e.getEntity().getKiller();
            StatsAPI api = new StatsAPI();

            api.updateMob(killer.getUniqueId(), 1, false);
            Xpbooster xp = new Xpbooster();
            MobCounter mobCounter = new MobCounter(killer.getItemInHand());
            mobCounter.activateMobCounter();
            if (SchoolMode.getInstance().getBoostermanager().getAktivboost().stream().anyMatch((b -> b.getName().equals(xp.getName())))) {

                float exp = (e.getDroppedExp() * Wilderei.getEXPMultipyer(e.getEntity().getKiller()))*2;
                e.getEntity().getKiller().setExp(e.getEntity().getKiller().getExp() + exp);
            }else {
                float exp = (e.getDroppedExp() * Wilderei.getEXPMultipyer(e.getEntity().getKiller()));
                e.getEntity().getKiller().setExp(e.getEntity().getKiller().getExp() + exp);
            }
        }
        DungeonManager dungeonManager = new DungeonManager();
        dungeonManager.entityDeathItemAdd(e);
    }

}
