package me.bluenitrox.school.listener;

import me.bluenitrox.school.crafting.WerkbankGUIRegister;
import me.bluenitrox.school.enchants.CraftAPI;
import me.bluenitrox.school.enchants.sword.Schatzmeister;
import me.bluenitrox.school.features.CaseAPI;
import me.bluenitrox.school.features.Pet;
import me.bluenitrox.school.managers.ExpManager;
import me.bluenitrox.school.managers.MessageManager;
import me.bluenitrox.school.managers.PlayerJoinManager;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class PlayerInteractEvent implements Listener {

    @EventHandler
    public void onInteract(final org.bukkit.event.player.PlayerInteractEvent e){
        Player p = (Player)e.getPlayer();
        Pet pet = new Pet();

        if(e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) {
            if (p.getItemInHand() != null) {
                if (p.getItemInHand().getItemMeta() != null) {
                    if(p.getItemInHand().getItemMeta().getDisplayName() != null) {
                        interactCase(p, e);
                        interactSchoolXP(p, e);
                        Schatzmeister.openInventory(p, e);
                        pet.petEinlösen(p,e);
                    }
                }
            }
        }
        if(e.getAction() == Action.RIGHT_CLICK_BLOCK){
            interactEnderchest(p, e);
            interactCraftingtable(p, e);
            interactAnvil(p, e);
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
            e.setCancelled(true);
            if(CaseAPI.caseöffnen != null) {
                if (CaseAPI.caseöffnen.contains(p)) {
                    return;
                }
            }
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

    private void interactSchoolXP(Player p, org.bukkit.event.player.PlayerInteractEvent e){
        /*
           Beispiel
        "§8» §7Beinhaltet:§6§l 3000 XP"
         */
        if(p.getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase("§6§lSchool XP")){
            e.setCancelled(true);
            String[] lore = p.getItemInHand().getItemMeta().getLore().get(0).split(" ");
            int anzahl = Integer.parseInt(lore[2]);
            ExpManager.updateXP(p.getUniqueId(), anzahl, false);
            if(p.getItemInHand().getAmount() > 1) {
                p.getItemInHand().setAmount(p.getItemInHand().getAmount() -1);
            }else if(p.getItemInHand().getAmount() == 1) {
                ItemStack air = new ItemStack(Material.AIR);
                p.setItemInHand(air);
            }
            p.playSound(p.getLocation(), Sound.LEVEL_UP, 1L, 1L);
            p.sendMessage(MessageManager.SCHOOLXP(PlayerJoinManager.language) + anzahl);
        }
    }

    private void interactEnderchest(Player p, org.bukkit.event.player.PlayerInteractEvent e){
        if(e.getClickedBlock().getType() == Material.ENDER_CHEST){
            e.setCancelled(true);
            p.sendMessage(MessageManager.ENDERCHEST);
        }
    }

    private void interactCraftingtable(Player p, org.bukkit.event.player.PlayerInteractEvent e){
        if(e.getClickedBlock().getType() == Material.WORKBENCH){
            e.setCancelled(true);
            WerkbankGUIRegister wgr = new WerkbankGUIRegister();
            p.openInventory(wgr.mainMenu());
        }
    }

    private void interactAnvil(Player p, org.bukkit.event.player.PlayerInteractEvent e){
        if(e.getClickedBlock().getType() == Material.ANVIL){
            e.setCancelled(true);
            CraftAPI api = new CraftAPI();
            p.openInventory(api.openCraftInv(p));
        }
    }
}
