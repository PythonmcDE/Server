package me.bluenitrox.school.listener;

import me.bluenitrox.school.cases.CaseAPI;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.inventory.ItemStack;

public class PlayerInteractEvent implements Listener {

    @EventHandler
    public void onInteract(final org.bukkit.event.player.PlayerInteractEvent e){
        Player p = (Player)e.getPlayer();
        if(e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) {
            if (p.getItemInHand() != null) {
                if (p.getItemInHand().getItemMeta() != null) {
                    interactCase(p,e);
                }
            }
        }
    }

    private void interactCase(Player p, org.bukkit.event.player.PlayerInteractEvent e){
        if((p.getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase(CaseAPI.daily)
                || p.getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase(CaseAPI.gewöhnlich)
                || p.getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase(CaseAPI.selten)
                || p.getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase(CaseAPI.episch)
                || p.getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase(CaseAPI.legendär)
                || p.getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase(CaseAPI.mysthische)
                || p.getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase(CaseAPI.tier))){
            if(CaseAPI.opencase.contains(p.getUniqueId())){
                return;
            }
            e.setCancelled(true);
            CaseAPI caseapi = new CaseAPI();
            if(p.getItemInHand().getAmount() > 1) {
                p.getItemInHand().setAmount(p.getItemInHand().getAmount() -1);
            }else if(p.getItemInHand().getAmount() == 1) {
                ItemStack air = new ItemStack(Material.AIR);
                p.setItemInHand(air);
            }
            caseapi.openCase(p,caseapi.fromCase(p.getItemInHand().getItemMeta().getDisplayName()));
        }
    }

}
