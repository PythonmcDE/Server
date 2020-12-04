package me.bluenitrox.school.crafting;

import me.bluenitrox.school.listener.InventoryClickEvent;
import me.bluenitrox.school.utils.ItemBuilder;
import me.bluenitrox.school.utils.KopfUtil;
import me.bluenitrox.school.utils.NameFetcher;
import me.bluenitrox.school.utils.UUIDFetcher;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.UUID;

public class WerkbankGUIRegister {

    public String guiname = "§6§lWerkbank";
    public ItemStack glas = new ItemBuilder(Material.STAINED_GLASS_PANE).setDisplayname(" ").build();
    public ItemStack glasblack = new ItemBuilder(Material.STAINED_GLASS_PANE, (short)15).setDisplayname(" ").build();
    public ItemStack paper = new ItemBuilder(Material.PAPER).setDisplayname("§8» §7Crafting-Rezepte").setLore("§aKlicke hier, um alle Crafting-Rezepte anzuzeigen.").build();
    public ItemStack craftingTable = new ItemBuilder(Material.WORKBENCH).setDisplayname("§8» §7Normale Werkbank").setLore("§aKlicke hier, um die normale Werkbank zu öffnen.").build();
    public ItemStack sign = new ItemBuilder(Material.SIGN).setDisplayname("§8» " + guiname).setLore("§6§l▶ §7Du befindest dich gerade im §6Werkbank-Menü§7.", "§6§l▶ Hier kannst du §espezielle Rezepte §7craften", "§6§l▶ §7oder auf die §fnormale Werkbank §7wechseln").build();

    public Inventory mainMenu(){
        Inventory inv = Bukkit.createInventory(null, 9*6, guiname);

        ItemStack sign = new ItemBuilder(Material.SIGN).setDisplayname("§8» §6§lCrafting-Rezepte").setLore("§6§l▶ §7Hier werden dir alle §6§lbesonderen Rezepte", "§6§l▶ §aangezeigt §7und wie du sie §fcraften kannst§7.").build();
        ItemStack craftingTable = new ItemBuilder(Material.WORKBENCH).setDisplayname("§8» §7Normale Werkbank").setLore("§aKlicke hier, um die normale Werkbank zu öffnen.").build();
        ItemStack paper = new ItemBuilder(Material.PAPER).setDisplayname("§8» §7Seite §61&8/&61").build();

        for(int i = 0; i <= 8; i++){
            inv.setItem(i,glas);
        }
        for(int i = 36; i <= 45; i++){
            inv.setItem(i,glas);
        }
        for(int i = 48; i <= 52; i++){
            inv.setItem(i,glasblack);
        }

        inv.setItem(53,craftingTable);
        inv.setItem(4, sign);
        inv.setItem(46, paper);
        inv.setItem(45, KopfUtil.createSkull("lgndryFelix", "§8» §7Vorherige Seite"));
        inv.setItem(47, KopfUtil.createSkull("DerWahreNitrox", "§8» §7Nächste Seite"));

        return inv;
    }

    public Inventory runeEins(){
        Inventory inv = Bukkit.createInventory(null, 9*6, guiname);

        ItemStack runeeins = new ItemBuilder(Material.PRISMARINE_CRYSTALS).setDisplayname("§8» §c§lItem-Rune I").addEnchant(Enchantment.ARROW_INFINITE, 10, false).setLore("§f§lRune I", " ", "§6§l▶ §7Nutze diesen §6§lGegenstand §7im §5§lAmboss§7, um §7§lTools","§6§l▶ §7oder §7§lRüstungsleile §7mit mehr §6§lHaltbarkeit §7zu versehen.").build();
        ItemStack lachs = new ItemBuilder(Material.RAW_FISH,(short)1).setDisplayname("§7Roher Lachs").setAmount(12).build();
        ItemStack fish = new ItemBuilder(Material.RAW_FISH,(short)0).setDisplayname("§7Roher Fisch").setAmount(16).build();

        for(int i = 0; i <= 8; i++){
            inv.setItem(i, glas);
        }
        inv.setItem(9, glasblack);
        inv.setItem(10, glas);
        inv.setItem(16, glas);
        inv.setItem(17, glasblack);
        inv.setItem(18, glasblack);
        inv.setItem(19, glas);
        inv.setItem(25, glas);
        inv.setItem(26, runeeins);
        inv.setItem(27, glasblack);
        inv.setItem(28, glas);
        inv.setItem(34, glas);
        inv.setItem(35, glasblack);
        inv.setItem(36, glas);
        inv.setItem(37, glas);
        for(int i = 43; i<= 53; i++){
            inv.setItem(i, glas);
        }
        inv.setItem(45,paper);
        inv.setItem(53, craftingTable);

        inv.setItem(21,lachs);
        inv.setItem(22,lachs);
        inv.setItem(23,lachs);

        inv.setItem(21+9,lachs);
        inv.setItem(22+9,lachs);
        inv.setItem(23+9,lachs);

        inv.setItem(21+9+9,lachs);
        inv.setItem(22+9+9,lachs);
        inv.setItem(23+9+9,lachs);

        for(int i = 11 ; i<=15; i++){
            inv.setItem(i, fish);
        }

        inv.setItem(20, fish);
        inv.setItem(20+9, fish);
        inv.setItem(20+9+9, fish);

        inv.setItem(24,fish);
        inv.setItem(24+9,fish);
        inv.setItem(24+9+9,fish);
        inv.setItem(4, sign);

        return inv;
    }

}
