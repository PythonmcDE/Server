package me.bluenitrox.school.crafting;

import de.Herbystar.TTA.TTA_Methods;
import me.bluenitrox.school.managers.MessageManager;
import me.bluenitrox.school.managers.MoneyManager;
import me.bluenitrox.school.utils.ItemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.Random;

public class Enchanter {

    public static String GUI_NAME = "§8» §5Zaubertisch";
    private static ArrayList<String> enchantments;

    public static final int levelneeded = 3;

    public static void openZaubertisch(Player p){
        Inventory inv = Bukkit.createInventory(null, 9*5, GUI_NAME);

        setZaubertischContent(inv);

        p.openInventory(inv);
    }

    private static void setZaubertischContent(Inventory inv){
        ItemStack glas = new ItemBuilder(Material.STAINED_GLASS_PANE).setDisplayname(" ").build("isInInv");
        ItemStack tisch = new ItemBuilder(Material.ENCHANTMENT_TABLE).setDisplayname("§8» §6§lZaubertisch").setLore("§6§l▶ §7Unser §5Verzauberungs-System §7funktioniert", "§6§l▶ §7ein wenig anders, als das normale.", " ", "§cInfo:", "§8● §7Wenn du mehr erfahren willst, besuche", "§8● §7doch unsere Website §8(§fPythonMC.de§8)").build("isInInv");
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

    public static void inventoryClick(final InventoryClickEvent e){
        Player p = (Player)e.getWhoClicked();
        if(e.getClickedInventory().getName().equalsIgnoreCase(GUI_NAME)){
            if(e.getCurrentItem() != null){
                if(e.getCurrentItem().getType() == Material.SLIME_BALL || e.getCurrentItem().getType() == Material.STAINED_GLASS_PANE || e.getCurrentItem().getType() == Material.ENCHANTMENT_TABLE || e.getCurrentItem().getType() == Material.BARRIER){
                    e.setCancelled(true);
                }
                if(e.getCurrentItem().getItemMeta() != null){
                    if(e.getCurrentItem().getItemMeta().getDisplayName() != null){
                        if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§8» §aVerzaubere das Item")) {
                            if (e.getClickedInventory().getItem(22).getAmount() == 1) {
                                if (p.getLevel() >= levelneeded) {
                                    if (MoneyManager.getMoney(p.getUniqueId()) >= 15000) {
                                        enchantments = new ArrayList<>();
                                        registerArray();
                                        e.getClickedInventory().setItem(22, new ItemBuilder(Material.AIR).build());
                                        p.setLevel(p.getLevel() - levelneeded);
                                        MoneyManager.updateMoney(p.getUniqueId(), 15000, true, false, false);
                                        p.closeInventory();
                                        int r = new Random().nextInt(95);
                                        p.getInventory().addItem(new ItemBuilder(Material.ENCHANTED_BOOK).setDisplayname("§5Verzaubertes Buch").setLore("§7" + enchantments.get(r)).build());
                                        p.playSound(p.getLocation(), Sound.ANVIL_USE, 1L, 1L);
                                    }
                                }
                            }else {
                                p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1L , 1L);
                                p.closeInventory();
                                p.sendMessage(MessageManager.PREFIX + "§7Das kannst du so §cnicht §7machen!");
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
        enchantments.add("Verbrennung I");

        for(int i = 0; i<= 9; i++){
            enchantments.add("Schärfe I");
        }
        for(int i = 0; i<= 9; i++){
            enchantments.add("Schutz I");
        }
        for(int i = 0; i<= 9; i++){
            enchantments.add("Stärke I");
        }
        for(int i = 0; i<= 9; i++){
            enchantments.add("Effizienz I");
        }
        for(int i = 0; i<= 9; i++){
            enchantments.add("Haltbarkeit I");
        }

        for(int i = 0; i<= 5; i++){
            enchantments.add("Explosionsschutz I");
        }
        for(int i = 0; i<= 5; i++){
            enchantments.add("Schusssicher I");
        }
        for(int i = 0; i<= 5; i++){
            enchantments.add("Feuerschutz I");
        }
        for(int i = 0; i<= 5; i++){
            enchantments.add("Bann I");
        }
        for(int i = 0; i<= 5; i++){
            enchantments.add("Nemesis der Gliederfüßler I");
        }

        for(int i = 0; i<= 2; i++){
            enchantments.add("Wasserläufer I");
        }
        for(int i = 0; i<= 2; i++){
            enchantments.add("Rückstoß I");
        }
        for(int i = 0; i<= 2; i++){
            enchantments.add("Wasseraffinität I");
        }
        for(int i = 0; i<= 2; i++){
            enchantments.add("Atmung I");
        }
        for(int i = 0; i<= 2; i++){
            enchantments.add("Dornen I");
        }
    }

}
