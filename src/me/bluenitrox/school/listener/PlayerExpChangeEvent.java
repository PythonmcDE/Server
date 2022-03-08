package me.bluenitrox.school.listener;

import me.bluenitrox.school.SchoolMode;
import me.bluenitrox.school.boost.booster.Xpbooster;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class PlayerExpChangeEvent implements Listener {

    @EventHandler
    public void onXp(final org.bukkit.event.player.PlayerExpChangeEvent e) {
        Player p = (Player) e.getPlayer();
        Xpbooster xp = new Xpbooster();
        if (SchoolMode.getInstance().getBoostermanager().getAktivboost().stream().anyMatch((b -> b.getName().equals(xp.getName())))) {
            p.giveExp(10);
        }
    }

}