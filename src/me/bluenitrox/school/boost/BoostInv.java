package me.bluenitrox.school.boost;

import me.bluenitrox.school.SchoolMode;
import me.bluenitrox.school.utils.ItemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class BoostInv {

    public static String GUI_NAME = "§bBooster";

    public static void setBoostContent(Inventory inv, Player p){
        BoosterAPI api = new BoosterAPI();
        ItemStack glass = new ItemBuilder(Material.STAINED_GLASS_PANE).setDisplayname(" ").build();
        ItemStack glass1 = new ItemBuilder(Material.STAINED_GLASS_PANE,(short) 15).setDisplayname(" ").build();
        ItemStack sign = new ItemBuilder(Material.SIGN).setDisplayname("§8§l» §6§lBooster Informationen").setLore("§6§l▶ §6Booster §7können auf unserer §6Website","§6§l▶ §7erworben werden und bringen während ihrer","§6§l▶ §fLaufzeit §7einen §6Vorteil §7 für §aalle Spieler§7!").build();
        ItemStack chest = new ItemBuilder(Material.CHEST).setDisplayname("§8§l» §6§lChest-Booster").setLore("§6§l▶ §7Wenn dieser Booster aktiviert ist, §6spawnen",
                "§6§l▶ §625 Kisten in der §6Warzone§7.").build();
        ItemStack xp = new ItemBuilder(Material.EXP_BOTTLE).setDisplayname("§8§l» §6§lXP-Booster").setLore("§6§l▶ §7Wenn dieser Booster aktiviert ist, §6bekommen",
                "§6§l▶ §7alle Spieler §6doppelt so viel School §7und §6Vanilla XP§7.").build();
        ItemStack gem = new ItemBuilder(Material.EMERALD).setDisplayname("§8§l» §6§lGem-Booster").setLore("§6§l▶ §7Wenn dieser Booster aktiviert ist, §6bekommen",
                "§6§l▶ §7alle Spieler §6doppelt so viele Gems§7.").build();
        ItemStack angel = new ItemBuilder(Material.FISHING_ROD).setDisplayname("§8§l» §6§lAngel-Booster").setLore("§6§l▶ §7Wenn dieser Booster aktiviert ist, §6bekommen",
                "§6§l▶ §7alle Spieler §6doppelt so viele Items §7beim Angeln.").build();

        ItemStack chesthave = new ItemBuilder(Material.INK_SACK, (short)10).setDisplayname("§8§l» §6§lChest-Booster").setLore("§6§l▶ §7Du besitzt aktuell: §a" + api.getBooster(p.getUniqueId(), api.chestBooster) + " §6Chest Booster", "§6§l▶ §aKlicke§7, um einen §6Chest Booster §7zu aktivieren!").build();
        ItemStack xphave = new ItemBuilder(Material.INK_SACK, (short)10).setDisplayname("§8§l» §6§lXP-Booster").setLore("§6§l▶ §7Du besitzt aktuell: §a" + api.getBooster(p.getUniqueId(), api.xpBooster) + " §6XP Booster", "§6§l▶ §aKlicke§7, um einen §6XP Booster §7zu aktivieren!").build();
        ItemStack gemhave = new ItemBuilder(Material.INK_SACK, (short)10).setDisplayname("§8§l» §6§lGem-Booster").setLore("§6§l▶ §7Du besitzt aktuell: §a" + api.getBooster(p.getUniqueId(), api.gemBooster) + " §6Gem Booster", "§6§l▶ §aKlicke§7, um einen §6Gem Booster §7zu aktivieren!").build();
        ItemStack angelhave = new ItemBuilder(Material.INK_SACK, (short)10).setDisplayname("§8§l» §6§lAngel-Booster").setLore("§6§l▶ §7Du besitzt aktuell: §a" + api.getBooster(p.getUniqueId(), api.angelBooster) + " §6Angel Booster", "§6§l▶ §aKlicke§7, um einen §6Angel Booster §7zu aktivieren!").build();

        ItemStack chesthavenot = new ItemBuilder(Material.INK_SACK, (short)8).setDisplayname("§8§l» §6§lChest-Booster").setLore("§6§l▶ §7Du besitzt aktuell: §c§l0 §6Chest Booster", "§6§l▶ §7Jetzt erwerben: §fPythonmc.de/booster").build();
        ItemStack xphavenot = new ItemBuilder(Material.INK_SACK, (short)8).setDisplayname("§8§l» §6§lXP-Booster").setLore("§6§l▶ §7Du besitzt aktuell: §c§l0 §6XP Booster", "§6§l▶ §7Jetzt erwerben: §fPythonmc.de/booster").build();
        ItemStack gemhavenot = new ItemBuilder(Material.INK_SACK, (short)8).setDisplayname("§8§l» §6§lGem-Booster").setLore("§6§l▶ §7Du besitzt aktuell: §c§l0 §6Gem Booster", "§6§l▶ §7Jetzt erwerben: §fPythonmc.de/booster").build();
        ItemStack angelhavenot = new ItemBuilder(Material.INK_SACK, (short)8).setDisplayname("§8§l» §6§lAngel-Booster").setLore("§6§l▶ §7Du besitzt aktuell: §c§l0 §6Angel Booster", "§6§l▶ §7Jetzt erwerben: §fPythonmc.de/booster").build();

        ItemStack chestnoton = new ItemBuilder(Material.BARRIER).setDisplayname("§8§l» §6§lChest-Booster").setLore("§6§l▶ §7Aktuell ist §ckein §6Chest Booster §7aktiv!").build();
        ItemStack xpnoton = new ItemBuilder(Material.BARRIER).setDisplayname("§8§l» §6§lXP-Booster").setLore("§6§l▶ §7Aktuell ist §ckein §6XP Booster §7aktiv!").build();
        ItemStack gemnoton = new ItemBuilder(Material.BARRIER).setDisplayname("§8§l» §6§lGem-Booster").setLore("§6§l▶ §7Aktuell ist §ckein §6Gem Booster §7aktiv!").build();
        ItemStack angelnoton = new ItemBuilder(Material.BARRIER).setDisplayname("§8§l» §6§lAngel-Booster").setLore("§6§l▶ §7Aktuell ist §ckein §6Angel Booster §7aktiv!").build();
        for(int i = 0; i <= 8; i++){
            inv.setItem(i, glass);
        }
        for(int i = 36; i <= 44; i++){
            inv.setItem(i, glass);
        }
        for(int i = 45; i <= 53; i++){
            inv.setItem(i, glass1);
        }
        inv.setItem(10, chest);
        inv.setItem(12, xp);
        inv.setItem(14, gem);
        inv.setItem(16, angel);
        inv.setItem(28, chestnoton);

        Xpbooster xpboost = new Xpbooster();
        if(SchoolMode.getInstance().getBoostermanager().getAktivboost().stream().anyMatch((b -> b.getName().equals(xpboost.getName())))) {
            ItemStack xpon = new ItemBuilder(Material.WATCH).setDisplayname("§8§l» §6§lXP-Booster").setLore("§6§l▶ §7Aktuell ist ein §6XP Booster §7aktiv!","§6§l▶ §7Verbleibende Zeit: §6" + getTimeFromItem(BoosterAPI.boost.get("xp")) + " Minuten").build();
            inv.setItem(30, xpon);
        }else {
            inv.setItem(30, xpnoton);
        }

        Gembooster moneyboost = new Gembooster();
        if(SchoolMode.getInstance().getBoostermanager().getAktivboost().stream().anyMatch((b -> b.getName().equals(moneyboost.getName())))) {
            ItemStack gemon = new ItemBuilder(Material.WATCH).setDisplayname("§8§l» §6§lGem-Booster").setLore("§6§l▶ §7Aktuell ist ein §6Gem Booster §7aktiv!","§6§l▶ §7Verbleibende Zeit: §6" + getTimeFromItem(BoosterAPI.boost.get("money")) + " Minuten").build();
            inv.setItem(32, gemon);
        }else {
            inv.setItem(32, gemnoton);
        }

        Angelbooster angelboost = new Angelbooster();
        if(SchoolMode.getInstance().getBoostermanager().getAktivboost().stream().anyMatch((b -> b.getName().equals(angelboost.getName())))) {
            ItemStack angelon = new ItemBuilder(Material.WATCH).setDisplayname("§8§l» §6§lAngel-Booster").setLore("§6§l▶ §7Aktuellt ist ein §6Angel Booster §7aktiv!","§6§l▶ §7Verbleibende Zeit: §6" + getTimeFromItem(BoosterAPI.boost.get("angel")) + " Minuten").build();
            inv.setItem(34, angelon);
        }else {
            inv.setItem(34, angelnoton);
        }

        if(api.getBooster(p.getUniqueId(), api.chestBooster) > 0){
            inv.setItem(19, chesthave);
        }else {
            inv.setItem(19, chesthavenot);
        }

        if(api.getBooster(p.getUniqueId(), api.xpBooster) > 0){
            inv.setItem(21, xphave);
        }else {
            inv.setItem(21, xphavenot);
        }

        if(api.getBooster(p.getUniqueId(), api.gemBooster) > 0){
            inv.setItem(23, gemhave);
        }else {
            inv.setItem(23, gemhavenot);
        }

        if(api.getBooster(p.getUniqueId(), api.angelBooster) > 0){
            inv.setItem(25, angelhave);
        }else {
            inv.setItem(25, angelhavenot);
        }
        inv.setItem(49, sign);
    }

    public static void inventoryClick(InventoryClickEvent e, Player p){
        BoosterAPI api = new BoosterAPI();
        if(e.getClickedInventory().getName().equalsIgnoreCase(GUI_NAME) && e.getCurrentItem() != null) {
            e.setCancelled(true);
            ItemStack chesthave = new ItemBuilder(Material.INK_SACK, (short)10).setDisplayname("§8§l» §6§lChest-Booster").setLore("§6§l▶ §7Du besitzt aktuell: §a" + api.getBooster(p.getUniqueId(), api.chestBooster) + " §6Chest Booster", "§6§l▶ §aKlicke§7, um einen §6Chest Booster §7zu aktivieren!").build();
            ItemStack xphave = new ItemBuilder(Material.INK_SACK, (short)10).setDisplayname("§8§l» §6§lXP-Booster").setLore("§6§l▶ §7Du besitzt aktuell: §a" + api.getBooster(p.getUniqueId(), api.xpBooster) + " §6XP Booster", "§6§l▶ §aKlicke§7, um einen §6XP Booster §7zu aktivieren!").build();
            ItemStack gemhave = new ItemBuilder(Material.INK_SACK, (short)10).setDisplayname("§8§l» §6§lGem-Booster").setLore("§6§l▶ §7Du besitzt aktuell: §a" + api.getBooster(p.getUniqueId(), api.gemBooster) + " §6Gem Booster", "§6§l▶ §aKlicke§7, um einen §6Gem Booster §7zu aktivieren!").build();
            ItemStack angelhave = new ItemBuilder(Material.INK_SACK, (short)10).setDisplayname("§8§l» §6§lAngel-Booster").setLore("§6§l▶ §7Du besitzt aktuell: §a" + api.getBooster(p.getUniqueId(), api.angelBooster) + " §6Angel Booster", "§6§l▶ §aKlicke§7, um einen §6Angel Booster §7zu aktivieren!").build();

            if(e.getCurrentItem() != null){
                if(e.getCurrentItem().getItemMeta() != null) {
                    if (e.getCurrentItem().getItemMeta().getDisplayName() != null) {
                        if (e.getCurrentItem().getItemMeta().getDisplayName().equals(chesthave.getItemMeta().getDisplayName())) {
                            p.performCommand("boost chest");
                            p.closeInventory();
                        } else if (e.getCurrentItem().getItemMeta().getDisplayName().equals(xphave.getItemMeta().getDisplayName())) {
                            p.performCommand("boost xp");
                            p.closeInventory();
                        } else if (e.getCurrentItem().getItemMeta().getDisplayName().equals(gemhave.getItemMeta().getDisplayName())) {
                            p.performCommand("boost money");
                            p.closeInventory();
                        } else if (e.getCurrentItem().getItemMeta().getDisplayName().equals(angelhave.getItemMeta().getDisplayName())) {
                            p.performCommand("boost angel");
                            p.closeInventory();
                        }
                    }
                }
            }
        }
    }

    public static String getTimeFromItem(int time){
        try {
            int sek = time;
            int min = 0;
            while(sek > 60){
                min ++;
                sek-=60;
            }
            if(sek < 10){
                return min + "";
            }
            return min + "";
        }catch (Exception e){
            Bukkit.broadcastMessage(e.getMessage());
            return "0";
        }
    }

}
