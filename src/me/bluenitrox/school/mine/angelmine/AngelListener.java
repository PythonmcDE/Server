package me.bluenitrox.school.mine.angelmine;

import com.sun.xml.internal.ws.wsdl.writer.document.Part;
import me.bluenitrox.school.listener.PlayerInteractEvent;
import me.bluenitrox.school.utils.ItemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerFishEvent;
import org.bukkit.inventory.ItemStack;

public class AngelListener implements Listener {

    @EventHandler
    public void onInteract(final PlayerFishEvent e){
        if(e.getState() == PlayerFishEvent.State.FAILED_ATTEMPT){
            int line = 0;
            int spins = 0;
            for(int i = 0; i<PartikelManager.locations.size(); i++){
                if(spins == 0) {
                    if (e.getHook().getLocation().distanceSquared(PartikelManager.locations.get(i)) <= 3 ||
                            e.getHook().getLocation().add(0, 1, 0).distanceSquared(PartikelManager.locations.get(i)) <= 3 ||
                            e.getHook().getLocation().subtract(0, 1, 0).distanceSquared(PartikelManager.locations.get(i)) <= 3 ||
                            e.getHook().getLocation().subtract(0, 2, 0).distanceSquared(PartikelManager.locations.get(i)) <= 3 ||
                            e.getHook().getLocation().subtract(0, 3, 0).distanceSquared(PartikelManager.locations.get(i)) <= 3 ||
                            e.getHook().getLocation().subtract(0, 4, 0).distanceSquared(PartikelManager.locations.get(i)) <= 3 ||
                            e.getHook().getLocation().subtract(0, 5, 0).distanceSquared(PartikelManager.locations.get(i)) <= 3 ||
                            e.getHook().getLocation().subtract(0, 6, 0).distanceSquared(PartikelManager.locations.get(i)) <= 3 ||
                            e.getHook().getLocation().add(0, 2, 0).distanceSquared(PartikelManager.locations.get(i)) <= 3 ||
                            e.getHook().getLocation().add(0, 3, 0).distanceSquared(PartikelManager.locations.get(i)) <= 3 ||
                            e.getHook().getLocation().add(0, 4, 0).distanceSquared(PartikelManager.locations.get(i)) <= 3 ||
                            e.getHook().getLocation().add(0, 5, 0).distanceSquared(PartikelManager.locations.get(i)) <= 3 ||
                            e.getHook().getLocation().add(0, 6, 0).distanceSquared(PartikelManager.locations.get(i)) <= 3) {
                        line = i;
                        spins += 10;
                        addPlayerItem(e.getPlayer());
                        e.getPlayer().playSound(e.getPlayer().getLocation(), Sound.NOTE_BASS, 1L, 1L);
                    } else {
                    }
                }
            }
            PartikelManager.locations.remove(line);
        }
    }

    public void addPlayerItem(Player p){
        int angelmine = AngelminenManager.playerangelmine.get(p);
        p.getInventory().addItem();
    }
    private ItemStack getItemforMine(){
        ItemStack is = null;
        return is;
    }
}
