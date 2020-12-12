package me.bluenitrox.school.crafting;

import de.Herbystar.TTA.TTA_Methods;
import me.bluenitrox.school.SchoolMode;
import me.bluenitrox.school.managers.MoneyManager;
import me.bluenitrox.school.utils.ItemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.ArrayList;
import java.util.Random;

public class Enchanter {

    private static String GUI_NAME = "§8» §5Zaubertisch";
    private static ArrayList<Enchantment> enchantments;

    public static void openZaubertisch(Player p){
        Inventory inv = Bukkit.createInventory(null, 9*5, GUI_NAME);

        setZaubertischContent(inv);

        p.openInventory(inv);
    }

    private static void setZaubertischContent(Inventory inv){
        ItemStack glas = new ItemBuilder(Material.STAINED_GLASS_PANE).setDisplayname(" ").build("isInInv");
        ItemStack tisch = new ItemBuilder(Material.ENCHANTMENT_TABLE).setDisplayname("§8» §6§lZaubertisch").setLore("§6§l▶ §7Unser §5Verzauberungs-System §7funktioniert", "§6§l▶ §7ein wenig anders, als das normale.", " ", "§cInfo:", "§8● §7Wenn du mehr erfahren willst, besuche", "§8● §7doch unsere Website §8(§fDemonMC.eu§8)").build("isInInv");
        ItemStack notokay = new ItemBuilder(Material.BARRIER).setDisplayname("§8» §cUngültige Verzauberung").setLore("§8● §7Entweder liegt kein Item auf dem freien Slot,", "§8● §7oder dieses kann nicht verzaubert werden.").build("isInInv");
        ItemStack glasblack = new ItemBuilder(Material.STAINED_GLASS_PANE, (short)15).setDisplayname(" ").build("isInInv");

        for(int i = 0; i<= 8; i++){
            inv.setItem(i, glas);
        }
        for(int i = 9; i<= 21; i++){
            inv.setItem(i, glasblack);
        }
        for(int i = 23; i<= 35; i++){
            inv.setItem(i, glasblack);
        }
        for(int i = 36; i<= 44; i++){
            inv.setItem(i, glas);
        }
        inv.setItem(25,notokay);
        inv.setItem(31,tisch);
    }

    public static void inventoryClicK(final InventoryClickEvent e){
        if(e.getClickedInventory().getName().equalsIgnoreCase(GUI_NAME)){
            if(e.getCurrentItem() != null){
                if(e.getCurrentItem().getType() == Material.SLIME_BALL || e.getCurrentItem().getType() == Material.STAINED_GLASS_PANE || e.getCurrentItem().getType() == Material.ENCHANTMENT_TABLE){
                    e.setCancelled(true);
                }
            }
            new BukkitRunnable(){
                @Override
                public void run() {
                    if (e.getClickedInventory().getItem(22).getType() == Material.BOOK) {
                        ItemStack verzaubern = new ItemBuilder(Material.SLIME_BALL).setDisplayname("§8» §aVerzaubere das Item").setLore("§6§l▶ §7Klicke hier um ein Random Buch zu verzaubern,", "§6§l▶ §7dies kostet dich §65 Level §7und §615 Tsd §7Gems.").build("isInInv");
                        e.getClickedInventory().setItem(25, verzaubern);
                    }
                }
            }.runTaskLaterAsynchronously(SchoolMode.getInstance(), 5);
            if(e.getCurrentItem() != null){
                if(e.getCurrentItem().getItemMeta() != null){
                    if(e.getCurrentItem().getItemMeta().getDisplayName() != null){
                        if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§8» §aVerzaubere das Item")){
                            Player p = (Player)e.getWhoClicked();
                            if(p.getLevel() >= 5){
                                if(MoneyManager.getMoney(p.getUniqueId()) >= 15000){
                                    enchantments = new ArrayList<>();
                                    registerArray();
                                    e.getClickedInventory().setItem(22, new ItemBuilder(Material.AIR).build());
                                    p.setLevel(p.getLevel()-5);
                                    MoneyManager.updateMoney(p.getUniqueId(), 15000, true, false);
                                    p.closeInventory();
                                    int r = new Random().nextInt(97);
                                    p.getInventory().addItem(new ItemBuilder(Material.ENCHANTED_BOOK).setDisplayname("§5Verzaubertes Buch").addEnchant(enchantments.get(r),1,false).build());
                                    p.playSound(p.getLocation(), Sound.ANVIL_USE, 1L, 1L);
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public static void onInventoryClose(final InventoryCloseEvent e){
        if(e.getInventory().getName().equalsIgnoreCase(GUI_NAME)){
            Player p = (Player) e.getPlayer();
            if(e.getInventory().getItem(22) != null){
                p.getInventory().addItem(e.getInventory().getItem(22));
                TTA_Methods.sendActionBar(p, "§7» §aDeine Items wurden in dein Inventar gelegt.", 20 * 5);
            }
        }
    }

    private static void registerArray(){
        enchantments.add(Enchantment.FIRE_ASPECT);

        for(int i = 0; i<= 9; i++){
            enchantments.add(Enchantment.DAMAGE_ALL);
        }
        for(int i = 0; i<= 9; i++){
            enchantments.add(Enchantment.PROTECTION_ENVIRONMENTAL);
        }
        for(int i = 0; i<= 9; i++){
            enchantments.add(Enchantment.ARROW_DAMAGE);
        }
        for(int i = 0; i<= 9; i++){
            enchantments.add(Enchantment.DIG_SPEED);
        }
        for(int i = 0; i<= 9; i++){
            enchantments.add(Enchantment.DURABILITY);
        }

        for(int i = 0; i<= 5; i++){
            enchantments.add(Enchantment.PROTECTION_EXPLOSIONS);
        }
        for(int i = 0; i<= 5; i++){
            enchantments.add(Enchantment.PROTECTION_PROJECTILE);
        }
        for(int i = 0; i<= 5; i++){
            enchantments.add(Enchantment.PROTECTION_FIRE);
        }
        for(int i = 0; i<= 5; i++){
            enchantments.add(Enchantment.DAMAGE_UNDEAD);
        }
        for(int i = 0; i<= 5; i++){
            enchantments.add(Enchantment.DAMAGE_ARTHROPODS);
        }

        for(int i = 0; i<= 2; i++){
            enchantments.add(Enchantment.WATER_WORKER);
        }
        for(int i = 0; i<= 2; i++){
            enchantments.add(Enchantment.KNOCKBACK);
        }
        for(int i = 0; i<= 2; i++){
            enchantments.add(Enchantment.DEPTH_STRIDER);
        }
        for(int i = 0; i<= 2; i++){
            enchantments.add(Enchantment.OXYGEN);
        }
        for(int i = 0; i<= 2; i++){
            enchantments.add(Enchantment.THORNS);
        }

        for(int i = 0; i<= 1; i++){
            enchantments.add(Enchantment.LURE);
        }
    }

}
