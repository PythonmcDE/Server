package me.bluenitrox.school.plots;

import me.bluenitrox.school.managers.MessageManager;
import me.bluenitrox.school.managers.MoneyManager;
import me.bluenitrox.school.managers.PlayerJoinManager;
import me.bluenitrox.school.utils.ItemBuilder;
import me.bluenitrox.school.utils.KopfUtil;
import me.bluenitrox.school.utils.NameFetcher;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;
import java.util.UUID;

public class PlotInventory {

    private UUID uuid;
    private static String guiname = "§8» §6§lPlot Einstellungen";
    public PlotInventory(UUID uuid) {
        this.uuid = uuid;
    }

    public Inventory inventory() {
        Player player = Bukkit.getPlayer(uuid);
        Inventory inventory = Bukkit.createInventory(null, 9*3, guiname);

        ItemStack glas = new ItemBuilder(Material.STAINED_GLASS_PANE).build();
        ItemStack sign = new ItemBuilder(Material.SIGN).setDisplayname("§6§lPlot GUI").setLore("§b» §7Dies ist das §3Plot-Menu §7, hier kannst du dir ein plot kaufen,", "§b» §7dich dort hin teleportieren und es verwalten.").build();
        ItemStack buyplot = new ItemBuilder(Material.SLIME_BALL).setDisplayname("§aPlot kaufen").setLore("§b» §7Klicke, um dir ein Plot für", "§b» §610.000 Gems §7zu kaufen.").build();
        ItemStack haveplot = new ItemBuilder(Material.ENDER_PEARL).setDisplayname("§aTeleportieren").setLore("§b» §7Klicke, um dich zu deinem Plot zu teleportieren!").build();
        ItemStack trust = KopfUtil.createSkull(NameFetcher.getName(player.getUniqueId()), "§6Vertraute Spieler");
        ItemMeta trustmeta = trust.getItemMeta();
        trustmeta.setLore(Arrays.asList("§b» §7Klicke, um alle vertrauten Spieler zu sehen!"));
        trust.setItemMeta(trustmeta);
        ItemStack ban = new ItemBuilder(Material.BARRIER).setDisplayname("§cGebannte Spieler").setLore("§b» §7Klicke um alle gebannten Spieler zu sehen!").build();

        for(int i = 0 ; i<= 26; i++){
            inventory.setItem(i, glas);
        }
        inventory.setItem(4, sign);
        inventory.setItem(10, trust);
        inventory.setItem(16, ban);

        if(PlotManager.isUserExists(player.getUniqueId())){
            inventory.setItem(13, haveplot);
        }else {
            inventory.setItem(13, buyplot);
        }

        return inventory;
        //remove this
    }


    public static void inventoryClick(final InventoryClickEvent e){
        UUID uuid = e.getWhoClicked().getUniqueId();
        Player p = (Player)e.getWhoClicked();
        if(e.getClickedInventory() != null){
            if(e.getCurrentItem() != null){
                if(e.getClickedInventory().getName() != null){
                    if(e.getClickedInventory().getName().equalsIgnoreCase(guiname)){
                        e.setCancelled(true);
                        if(e.getCurrentItem().getType() == Material.SLIME_BALL){
                            if(!PlotManager.isUserExists(uuid)) {
                                if (MoneyManager.getMoney(uuid) >= 10000) {
                                    p.performCommand("p auto");
                                    p.sendMessage(MessageManager.PREFIX + "§7Du hast dir ein Plot für §610.000 Gems §7gekauft!");
                                    p.playSound(p.getLocation(), Sound.NOTE_PLING, 1L, 1L);
                                    MoneyManager.updateMoney(uuid, 10000, true, false, false);
                                    PlotManager.createDatabaseuser(uuid);
                                    p.closeInventory();
                                } else {
                                    p.closeInventory();
                                    p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1L, 1L);
                                    p.sendMessage(MessageManager.NOTMONEY(PlayerJoinManager.language));
                                    return;
                                }
                            }
                        }else if(e.getCurrentItem().getType() == Material.ENDER_PEARL){
                            p.performCommand("plots home");
                            p.sendMessage(MessageManager.PREFIX + "§7Du hast dich zu deinem Plot §3teleportiert§7!");
                            p.playSound(p.getLocation(), Sound.NOTE_BASS, 1L, 1L);
                            p.closeInventory();
                        }else if(e.getCurrentItem().getType() == Material.BARRIER){
                            openbaninv(p);
                        }else if(e.getCurrentItem().getType() == Material.SKULL_ITEM){
                            opentrustinv(p);
                        }
                    }
                }
            }

        }
    }

    private static void opentrustinv(Player p){
        Inventory inv = Bukkit.createInventory(null, 9*6, "§6Vertraute Spieler");

        ItemStack glas = new ItemBuilder(Material.STAINED_GLASS_PANE).build();
        ItemStack barrier = new ItemBuilder(Material.BARRIER).setDisplayname("§c§lHier ist nichts!").setLore("§b» §7Du vertraust niemandem!").build();

        for(int i = 0; i< 9; i++){
            inv.setItem(i, glas);
        }
        for(int j = 45; j<=53; j++){
            inv.setItem(j, glas);
        }
        int slot = 9;

        if(PlotManager.getAlltrusted(p.getUniqueId()) != null){
            for(int i = 0; i< PlotManager.getAlltrusted(p.getUniqueId()).size(); i++){
                String name = NameFetcher.getName(PlotManager.getAlltrusted(p.getUniqueId()).get(i));
                inv.setItem(slot, KopfUtil.createSkull(name,"§6" + name ));
                slot++;
            }
        }else {
            inv.setItem(9, barrier);
        }

        p.playSound(p.getLocation(), Sound.NOTE_PLING, 1L, 1L);
        p.openInventory(inv);
    }

    private static void openbaninv(Player p){
        Inventory inv = Bukkit.createInventory(null, 9*6, "§cGebannte Spieler");

        ItemStack glas = new ItemBuilder(Material.STAINED_GLASS_PANE).build();
        ItemStack barrier = new ItemBuilder(Material.BARRIER).setDisplayname("§c§lHier ist nichts!").setLore("§b» §7Du hast niemandem §cgebannt§7!").build();

        for(int i = 0; i< 9; i++){
            inv.setItem(i, glas);
        }
        for(int j = 45; j<=53; j++){
            inv.setItem(j, glas);
        }
        int slot = 9;

        if(PlotManager.getAllbanned(p.getUniqueId()) != null){
            for(int i = 0; i< PlotManager.getAllbanned(p.getUniqueId()).size(); i++){
                String name = NameFetcher.getName(PlotManager.getAllbanned(p.getUniqueId()).get(i));
                inv.setItem(slot, KopfUtil.createSkull(name,"§6" + name ));
                slot++;
            }
        }else {
            inv.setItem(9, barrier);
        }

        p.playSound(p.getLocation(), Sound.NOTE_PLING, 1L, 1L);
        p.openInventory(inv);
    }

}
