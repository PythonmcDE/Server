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
        ItemStack glass = new ItemBuilder(Material.STAINED_GLASS_PANE).setDisplayname(" ").build();
        ItemStack paper = new ItemBuilder(Material.PAPER).setDisplayname("§6§lChest-Booster").setLore("§b» §7Dieser Booster spawnt §615 Kisten ","§b» §7zufällig in der Warzone").build();
        ItemStack paper1 = new ItemBuilder(Material.PAPER).setDisplayname("§6§lXP-Booster").setLore("§b» §7Dieser Booster gibt Doppelte §6EXP","§b» §7und §6Vanila XP").build();
        ItemStack paper2 = new ItemBuilder(Material.PAPER).setDisplayname("§6§lMoney-Booster").setLore("§b» §7Dieser Booster verdoppelt dein Geld","§b» §7bei jedem/jeder Shop oder Quest").build();

        ItemStack sign = new ItemBuilder(Material.SIGN).setDisplayname("§6Booster Menu").setLore("§b» §7Booster kannst du auf Unserer Website", "§b» §cDemonMC.de §7kaufen!").build();

        ItemStack chest1 = new ItemBuilder(Material.CHEST).setDisplayname("§6§lChest-Booster").setLore("§b» §7Klicke um einen Chest Booster zu aktivieren!", "§b» §7Deine Chest Booster: §a" + BoosterAPI.getChestBooster(p.getUniqueId())).build();
        ItemStack chest2 = new ItemBuilder(Material.CHEST).setDisplayname("§6§lXP-Booster").setLore("§b» §7Klicke um einen XP Booster zu aktivieren!", "§b» §7Deine XP Booster: §a" + BoosterAPI.getXpBooster(p.getUniqueId())).build();
        ItemStack chest3 = new ItemBuilder(Material.CHEST).setDisplayname("§6§lMoney-Booster").setLore("§b» §7Klicke um einen Money Booster zu aktivieren!", "§b» §7Deine Money Booster: §a" + BoosterAPI.getMoneyBooster(p.getUniqueId())).build();

        ItemStack dye = new ItemBuilder(Material.INK_SACK, (short)8).setDisplayname("§7Kein Booster aktiv!").setLore("§b» §7Derzeit ist §ckein §7Chest Booster aktiv!").build();
        ItemStack dye1 = new ItemBuilder(Material.INK_SACK, (short)8).setDisplayname("§7Kein Booster aktiv!").setLore("§b» §7Derzeit ist §ckein §7XP Booster aktiv!").build();
        ItemStack dye2 = new ItemBuilder(Material.INK_SACK, (short)8).setDisplayname("§7Kein Booster aktiv!").setLore("§b» §7Derzeit ist §ckein §7Money Booster aktiv!").build();

        for(int i = 0; i!= 11; i++){
            inv.setItem(i, glass);
        }
        for(int i = 25; i!= 38; i++){
            inv.setItem(i, glass);
        }
        for(int i = 43; i!= 54; i++){
            inv.setItem(i, glass);
        }

        inv.setItem(4, sign);

        inv.setItem(12, glass);
        inv.setItem(14, glass);
        inv.setItem(16, glass);
        inv.setItem(17, glass);
        inv.setItem(18, glass);
        inv.setItem(19, glass);

        inv.setItem(11,paper);
        inv.setItem(11+9, chest1);
        inv.setItem(13+9, chest2);
        inv.setItem(15+9, chest3);
        inv.setItem(11+9+18, dye);
        inv.setItem(11+9+18+1, glass);
        inv.setItem(13+9+18+1, glass);
        inv.setItem(11+9+1, glass);
        inv.setItem(13+9+1, glass);
        inv.setItem(13,paper1);
        inv.setItem(15,paper2);


        Xpbooster money1 = new Xpbooster();
        if(!SchoolMode.getInstance().getBoostermanager().getAktivboost().stream().anyMatch((b -> b.getName().equals(money1.getName())))) {
            inv.setItem(13 + 9 + 18, dye1);
        }else {
            ItemStack dye12 = new ItemBuilder(Material.INK_SACK, (short)10).setDisplayname("§7Booster §aaktiv§7!").setLore("§b» §7Derzeit ist ein XP Booster §aaktiv§7!", "§b» §7Übrige Zeit: §a" + getTimeFromItem(BoosterAPI.boost.get("xp")) + " Minuten").build();
            inv.setItem(13 + 9 + 18, dye12);
        }

        Moneybooster money2 = new Moneybooster();
        if(!SchoolMode.getInstance().getBoostermanager().getAktivboost().stream().anyMatch((b -> b.getName().equals(money2.getName())))) {
            inv.setItem(15 + 9 + 18, dye2);
        }else {
            ItemStack dye22 = new ItemBuilder(Material.INK_SACK, (short)10).setDisplayname("§7Booster §aaktiv§7!").setLore("§b» §7Derzeit ist ein Money Booster §aaktiv§7!", "§b» §7Übrige Zeit: §a" + getTimeFromItem(BoosterAPI.boost.get("money")) + " Minuten").build();
            inv.setItem(15 + 9 + 18, dye22);
        }
    }

    public static void inventoryClick(InventoryClickEvent e, Player p){
        e.setCancelled(true);
        ItemStack chest1 = new ItemBuilder(Material.CHEST).setDisplayname("§6§lChest-Booster").setLore("§b» §7Klicke um einen Chest Booster zu aktivieren!", "§b» §7Deine Chest Booster: §a" + BoosterAPI.getChestBooster(p.getUniqueId())).build();
        ItemStack chest2 = new ItemBuilder(Material.CHEST).setDisplayname("§6§lXP-Booster").setLore("§b» §7Klicke um einen XP Booster zu aktivieren!", "§b» §7Deine XP Booster: §a" + BoosterAPI.getXpBooster(p.getUniqueId())).build();
        ItemStack chest3 = new ItemBuilder(Material.CHEST).setDisplayname("§6§lMoney-Booster").setLore("§b» §7Klicke um einen Money Booster zu aktivieren!", "§b» §7Deine Money Booster: §a" + BoosterAPI.getMoneyBooster(p.getUniqueId())).build();

        if(e.getCurrentItem().getType() == Material.CHEST){
            if(e.getCurrentItem().getItemMeta().getDisplayName().equals(chest1.getItemMeta().getDisplayName())){
                p.performCommand("boost chest");
                p.closeInventory();
            }else if(e.getCurrentItem().getItemMeta().getDisplayName().equals(chest2.getItemMeta().getDisplayName())){
                p.performCommand("boost xp");
                p.closeInventory();
            }else if(e.getCurrentItem().getItemMeta().getDisplayName().equals(chest3.getItemMeta().getDisplayName())){
                p.performCommand("boost money");
                p.closeInventory();
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
