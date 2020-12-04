package me.bluenitrox.school.crafting;

import me.bluenitrox.school.utils.ItemBuilder;
import me.bluenitrox.school.utils.KopfUtil;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class WerkbankGUIRegister {

    public String guiname = "§6§lWerkbank";
    public ItemStack glas = new ItemBuilder(Material.STAINED_GLASS_PANE).setDisplayname(" ").build();
    public ItemStack glasblack = new ItemBuilder(Material.STAINED_GLASS_PANE, (short)15).setDisplayname(" ").build();
    public ItemStack paper = new ItemBuilder(Material.PAPER).setDisplayname("§8» §7Crafting-Rezepte").setLore("§aKlicke hier, um alle Crafting-Rezepte anzuzeigen.").build();
    public ItemStack craftingTable = new ItemBuilder(Material.WORKBENCH).setDisplayname("§8» §7Normale Werkbank").setLore("§aKlicke hier, um die normale Werkbank zu öffnen.").build();
    public ItemStack sign = new ItemBuilder(Material.SIGN).setDisplayname("§8» " + guiname).setLore("§6§l▶ §7Du befindest dich gerade im §6Werkbank-Menü§7.", "§6§l▶ Hier kannst du §espezielle Rezepte §7craften", "§6§l▶ §7oder auf die §fnormale Werkbank §7wechseln").build();
    public ItemStack spezial = new ItemBuilder(Material.NETHER_STAR).setDisplayname("§8» §6§lSpezielle Werkbank").setLore("§6§l▶ §7Klicke hier, um eine §6Werkbank §7für", "§6§l▶ §6spezielle Crafting-Rezepte §7zu §aöffnen§7.").build();

    public Inventory mainMenu(){
        Inventory inv = Bukkit.createInventory(null, 9*5, guiname);

        for(int i = 0; i<=8; i++){
            inv.setItem(i, glas);
        }
        for(int i = 9; i<=35; i++){
            inv.setItem(i, glasblack);
        }
        for(int i = 36; i<=45;i++){
            inv.setItem(i,glas);
        }

        inv.setItem(21,craftingTable);
        inv.setItem(23, spezial);

        return inv;
    }

    public Inventory rezeptMenu(){
        Inventory inv = Bukkit.createInventory(null, 9*6, guiname);

        ItemStack sign = new ItemBuilder(Material.SIGN).setDisplayname("§8» §6§lCrafting-Rezepte").setLore("§6§l▶ §7Hier werden dir alle §6§lbesonderen Rezepte", "§6§l▶ §aangezeigt §7und wie du sie §fcraften kannst§7.").build();
        ItemStack paper = new ItemBuilder(Material.PAPER).setDisplayname("§8» §7Seite §61&8/&61").build();

        for(int i = 0; i <= 8; i++){
            inv.setItem(i,glas);
        }
        for(int i = 36; i <= 45; i++){
            inv.setItem(i,glas);
        }
        for(int i = 45; i <= 52; i++){
            inv.setItem(i,glasblack);
        }

        inv.setItem(4, sign);
        inv.setItem(49, paper);
        inv.setItem(48, KopfUtil.createSkull("lgndryFelix", "§8» §7Vorherige Seite"));
        inv.setItem(50, KopfUtil.createSkull("DerWahreNitrox", "§8» §7Nächste Seite"));

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

        inv.setItem(31,lachs);
        inv.setItem(31+9,lachs);

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

    public Inventory runeZwei(){
        Inventory inv = Bukkit.createInventory(null, 9*6, guiname);

        ItemStack runezwei = new ItemBuilder(Material.PRISMARINE_CRYSTALS).setDisplayname("§8» §c§lItem-Rune II").addEnchant(Enchantment.ARROW_INFINITE, 10, false).setLore("§f§lRune II", " ", "§6§l▶ §7Nutze diesen §6§lGegenstand §7im §5§lAmboss§7, um §7§lTools","§6§l▶ §7oder §7§lRüstungsleile §7mit mehr §6§lHaltbarkeit §7zu versehen.").build();
        ItemStack kugelfisch = new ItemBuilder(Material.RAW_FISH,(short)3).setDisplayname("§7Kugelfisch").setAmount(12).build();
        ItemStack runeeins = new ItemBuilder(Material.PRISMARINE_CRYSTALS).setDisplayname("§8» §c§lItem-Rune I").addEnchant(Enchantment.ARROW_INFINITE, 10, false).setLore("§f§lRune I", " ", "§6§l▶ §7Nutze diesen §6§lGegenstand §7im §5§lAmboss§7, um §7§lTools","§6§l▶ §7oder §7§lRüstungsleile §7mit mehr §6§lHaltbarkeit §7zu versehen.").build();
        ItemStack tintenbeutel = new ItemBuilder(Material.INK_SACK).setDisplayname("§7Tintenbeutel").setAmount(6).build();

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
        inv.setItem(26, runezwei);
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

        inv.setItem(21,kugelfisch);
        inv.setItem(22,kugelfisch);
        inv.setItem(23,kugelfisch);

        inv.setItem(21+9,kugelfisch);
        inv.setItem(22+9,kugelfisch);
        inv.setItem(23+9,kugelfisch);

        inv.setItem(21+9+9,kugelfisch);
        inv.setItem(22+9+9,kugelfisch);
        inv.setItem(23+9+9,kugelfisch);

        for(int i = 11 ; i<=15; i++){
            inv.setItem(i, tintenbeutel);
        }

        inv.setItem(20, tintenbeutel);
        inv.setItem(20+9, tintenbeutel);
        inv.setItem(20+9+9, tintenbeutel);

        inv.setItem(24,tintenbeutel);
        inv.setItem(24+9,tintenbeutel);
        inv.setItem(24+9+9,tintenbeutel);
        inv.setItem(4, sign);
        inv.setItem(31, runeeins);

        return inv;
    }

    public Inventory runeDrei(){
        Inventory inv = Bukkit.createInventory(null, 9*6, guiname);

        ItemStack runedrei = new ItemBuilder(Material.PRISMARINE_CRYSTALS).setDisplayname("§8» §c§lItem-Rune III").addEnchant(Enchantment.ARROW_INFINITE, 10, false).setLore("§f§lRune III", " ", "§6§l▶ §7Nutze diesen §6§lGegenstand §7im §5§lAmboss§7, um §7§lTools","§6§l▶ §7oder §7§lRüstungsleile §7mit mehr §6§lHaltbarkeit §7zu versehen.").build();
        ItemStack clown = new ItemBuilder(Material.RAW_FISH,(short)2).setDisplayname("§7Clownfisch").setAmount(8).build();
        ItemStack runezwei = new ItemBuilder(Material.PRISMARINE_CRYSTALS).setDisplayname("§8» §c§lItem-Rune II").addEnchant(Enchantment.ARROW_INFINITE, 10, false).setLore("§f§lRune II", " ", "§6§l▶ §7Nutze diesen §6§lGegenstand §7im §5§lAmboss§7, um §7§lTools","§6§l▶ §7oder §7§lRüstungsleile §7mit mehr §6§lHaltbarkeit §7zu versehen.").build();
        ItemStack tintenbeutel = new ItemBuilder(Material.RAW_FISH,(short)0).setDisplayname("§7Tintenbeutel").setAmount(12).build();

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
        inv.setItem(26, runedrei);
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

        inv.setItem(21,clown);
        inv.setItem(22,clown);
        inv.setItem(23,clown);

        inv.setItem(21+9,clown);
        inv.setItem(22+9,clown);
        inv.setItem(23+9,clown);

        inv.setItem(21+9+9,clown);
        inv.setItem(22+9+9,clown);
        inv.setItem(23+9+9,clown);

        for(int i = 11 ; i<=15; i++){
            inv.setItem(i, tintenbeutel);
        }

        inv.setItem(20, tintenbeutel);
        inv.setItem(20+9, tintenbeutel);
        inv.setItem(20+9+9, tintenbeutel);

        inv.setItem(24,tintenbeutel);
        inv.setItem(24+9,tintenbeutel);
        inv.setItem(24+9+9,tintenbeutel);
        inv.setItem(4, sign);
        inv.setItem(31, runezwei);

        return inv;
    }

    public Inventory runeVier(){
        Inventory inv = Bukkit.createInventory(null, 9*6, guiname);

        ItemStack runevier = new ItemBuilder(Material.PRISMARINE_CRYSTALS).setDisplayname("§8» §c§lItem-Rune IV").addEnchant(Enchantment.ARROW_INFINITE, 10, false).setLore("§f§lRune IV", " ", "§6§l▶ §7Nutze diesen §6§lGegenstand §7im §5§lAmboss§7, um §7§lTools","§6§l▶ §7oder §7§lRüstungsleile §7mit mehr §6§lHaltbarkeit §7zu versehen.").build();
        ItemStack clown = new ItemBuilder(Material.RAW_FISH,(short)2).setDisplayname("§7Clownfisch").setAmount(16).build();
        ItemStack runedrei = new ItemBuilder(Material.PRISMARINE_CRYSTALS).setDisplayname("§8» §c§lItem-Rune III").addEnchant(Enchantment.ARROW_INFINITE, 10, false).setLore("§f§lRune III", " ", "§6§l▶ §7Nutze diesen §6§lGegenstand §7im §5§lAmboss§7, um §7§lTools","§6§l▶ §7oder §7§lRüstungsleile §7mit mehr §6§lHaltbarkeit §7zu versehen.").build();
        ItemStack alge = new ItemBuilder(Material.VINE).setDisplayname("§7Alge").setAmount(8).build();

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
        inv.setItem(26, runevier);
        inv.setItem(27, glasblack);
        inv.setItem(28, glas);
        inv.setItem(31, glas);
        inv.setItem(34, glas);
        inv.setItem(35, glasblack);
        inv.setItem(36, glas);
        inv.setItem(37, glas);
        for(int i = 43; i<= 53; i++){
            inv.setItem(i, glas);
        }
        inv.setItem(45,paper);
        inv.setItem(53, craftingTable);

        inv.setItem(21,clown);
        inv.setItem(22,clown);
        inv.setItem(23,clown);

        inv.setItem(21+9,clown);
        inv.setItem(22+9,clown);
        inv.setItem(23+9,clown);

        inv.setItem(21+9+9,clown);
        inv.setItem(22+9+9,clown);
        inv.setItem(23+9+9,clown);

        for(int i = 11 ; i<=15; i++){
            inv.setItem(i, alge);
        }

        inv.setItem(20, alge);
        inv.setItem(20+9, alge);
        inv.setItem(20+9+9, alge);

        inv.setItem(24, alge);
        inv.setItem(24+9, alge);
        inv.setItem(24+9+9, alge);
        inv.setItem(4, sign);
        inv.setItem(31,runedrei);

        return inv;
    }

    public Inventory runeFünf(){
        Inventory inv = Bukkit.createInventory(null, 9*6, guiname);

        ItemStack runefünf = new ItemBuilder(Material.PRISMARINE_CRYSTALS).setDisplayname("§8» §c§lItem-Rune V").addEnchant(Enchantment.ARROW_INFINITE, 10, false).setLore("§f§lRune V", " ", "§6§l▶ §7Nutze diesen §6§lGegenstand §7im §5§lAmboss§7, um §7§lTools","§6§l▶ §7oder §7§lRüstungsleile §7mit mehr §6§lHaltbarkeit §7zu versehen.").build();
        ItemStack wacht = new ItemBuilder(Material.EYE_OF_ENDER).setDisplayname("§7Wächterauge").setAmount(8).build();
        ItemStack runevier = new ItemBuilder(Material.PRISMARINE_CRYSTALS).setDisplayname("§8» §c§lItem-Rune IV").addEnchant(Enchantment.ARROW_INFINITE, 10, false).setLore("§f§lRune IV", " ", "§6§l▶ §7Nutze diesen §6§lGegenstand §7im §5§lAmboss§7, um §7§lTools","§6§l▶ §7oder §7§lRüstungsleile §7mit mehr §6§lHaltbarkeit §7zu versehen.").build();
        ItemStack alge = new ItemBuilder(Material.VINE).setDisplayname("§7Alge").setAmount(16).build();

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
        inv.setItem(26, runefünf);
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

        inv.setItem(21,wacht);
        inv.setItem(22,wacht);
        inv.setItem(23,wacht);

        inv.setItem(21+9,wacht);
        inv.setItem(22+9,wacht);
        inv.setItem(23+9,wacht);

        inv.setItem(21+9+9,wacht);
        inv.setItem(22+9+9,wacht);
        inv.setItem(23+9+9,wacht);

        for(int i = 11 ; i<=15; i++){
            inv.setItem(i, alge);
        }

        inv.setItem(20, alge);
        inv.setItem(20+9, alge);
        inv.setItem(20+9+9, alge);

        inv.setItem(24, alge);
        inv.setItem(24+9, alge);
        inv.setItem(24+9+9, alge);
        inv.setItem(4, sign);
        inv.setItem(31, runevier);


        return inv;
    }

    public Inventory runeSechs(){
        Inventory inv = Bukkit.createInventory(null, 9*6, guiname);

        ItemStack runesechs = new ItemBuilder(Material.PRISMARINE_CRYSTALS).setDisplayname("§8» §c§lItem-Rune VI").addEnchant(Enchantment.ARROW_INFINITE, 10, false).setLore("§f§lRune VI", " ", "§6§l▶ §7Nutze diesen §6§lGegenstand §7im §5§lAmboss§7, um §7§lTools","§6§l▶ §7oder §7§lRüstungsleile §7mit mehr §6§lHaltbarkeit §7zu versehen.").build();
        ItemStack wacht = new ItemBuilder(Material.EYE_OF_ENDER).setDisplayname("§7Wächterauge").setAmount(16).build();
        ItemStack runefünf = new ItemBuilder(Material.PRISMARINE_CRYSTALS).setDisplayname("§8» §c§lItem-Rune V").addEnchant(Enchantment.ARROW_INFINITE, 10, false).setLore("§f§lRune V", " ", "§6§l▶ §7Nutze diesen §6§lGegenstand §7im §5§lAmboss§7, um §7§lTools","§6§l▶ §7oder §7§lRüstungsleile §7mit mehr §6§lHaltbarkeit §7zu versehen.").build();
        ItemStack lili = new ItemBuilder(Material.WATER_LILY).setDisplayname("§7Seerose").setAmount(8).build();

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
        inv.setItem(26, runesechs);
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

        inv.setItem(21,wacht);
        inv.setItem(22,wacht);
        inv.setItem(23,wacht);

        inv.setItem(21+9,wacht);
        inv.setItem(22+9,wacht);
        inv.setItem(23+9,wacht);

        inv.setItem(21+9+9,wacht);
        inv.setItem(22+9+9,wacht);
        inv.setItem(23+9+9,wacht);

        for(int i = 11 ; i<=15; i++){
            inv.setItem(i, lili);
        }

        inv.setItem(20, lili);
        inv.setItem(20+9, lili);
        inv.setItem(20+9+9, lili);

        inv.setItem(24, lili);
        inv.setItem(24+9, lili);
        inv.setItem(24+9+9, lili);
        inv.setItem(4, sign);
        inv.setItem(31, runefünf);


        return inv;
    }

    public Inventory runeSieben(){
        Inventory inv = Bukkit.createInventory(null, 9*6, guiname);

        ItemStack runesieben = new ItemBuilder(Material.PRISMARINE_CRYSTALS).setDisplayname("§8» §c§lItem-Rune VII").addEnchant(Enchantment.ARROW_INFINITE, 10, false).setLore("§f§lRune VII", " ", "§6§l▶ §7Nutze diesen §6§lGegenstand §7im §5§lAmboss§7, um §7§lTools","§6§l▶ §7oder §7§lRüstungsleile §7mit mehr §6§lHaltbarkeit §7zu versehen.").build();

        ItemStack gfish = KopfUtil.createSkull("goldfiwow1", "§bGroßer Fisch");
        ItemMeta meta = gfish.getItemMeta();
        gfish.setAmount(4);
        gfish.setItemMeta(meta);
        ItemStack runesechs = new ItemBuilder(Material.PRISMARINE_CRYSTALS).setDisplayname("§8» §c§lItem-Rune VI").addEnchant(Enchantment.ARROW_INFINITE, 10, false).setLore("§f§lRune VI", " ", "§6§l▶ §7Nutze diesen §6§lGegenstand §7im §5§lAmboss§7, um §7§lTools","§6§l▶ §7oder §7§lRüstungsleile §7mit mehr §6§lHaltbarkeit §7zu versehen.").build();

        ItemStack lili = new ItemBuilder(Material.WATER_LILY).setDisplayname("§7Seerose").setAmount(24).build();

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
        inv.setItem(26, runesieben);
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

        inv.setItem(21,gfish);
        inv.setItem(22,gfish);
        inv.setItem(23,gfish);

        inv.setItem(21+9,gfish);
        inv.setItem(22+9,gfish);
        inv.setItem(23+9,gfish);

        inv.setItem(21+9+9,gfish);
        inv.setItem(22+9+9,gfish);
        inv.setItem(23+9+9,gfish);

        for(int i = 11 ; i<=15; i++){
            inv.setItem(i, lili);
        }

        inv.setItem(20, lili);
        inv.setItem(20+9, lili);
        inv.setItem(20+9+9, lili);

        inv.setItem(24, lili);
        inv.setItem(24+9, lili);
        inv.setItem(24+9+9, lili);
        inv.setItem(4, sign);
        inv.setItem(31, runesechs);


        return inv;
    }

    public Inventory runeAcht(){
        Inventory inv = Bukkit.createInventory(null, 9*6, guiname);

        ItemStack runeacht = new ItemBuilder(Material.PRISMARINE_CRYSTALS).setDisplayname("§8» §c§lItem-Rune VIII").addEnchant(Enchantment.ARROW_INFINITE, 10, false).setLore("§f§lRune VIII", " ", "§6§l▶ §7Nutze diesen §6§lGegenstand §7im §5§lAmboss§7, um §7§lTools","§6§l▶ §7oder §7§lRüstungsleile §7mit mehr §6§lHaltbarkeit §7zu versehen.").build();

        ItemStack gfish = KopfUtil.createSkull("goldfiwow1", "§bGroßer Fisch");
        ItemMeta meta = gfish.getItemMeta();
        gfish.setAmount(8);
        gfish.setItemMeta(meta);

        ItemStack lili = new ItemBuilder(Material.WATER_LILY).setDisplayname("§7Seerose").setAmount(48).build();
        ItemStack runesieben = new ItemBuilder(Material.PRISMARINE_CRYSTALS).setDisplayname("§8» §c§lItem-Rune VII").addEnchant(Enchantment.ARROW_INFINITE, 10, false).setLore("§f§lRune VII", " ", "§6§l▶ §7Nutze diesen §6§lGegenstand §7im §5§lAmboss§7, um §7§lTools","§6§l▶ §7oder §7§lRüstungsleile §7mit mehr §6§lHaltbarkeit §7zu versehen.").build();

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
        inv.setItem(26, runeacht);
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

        inv.setItem(21,gfish);
        inv.setItem(22,gfish);
        inv.setItem(23,gfish);

        inv.setItem(21+9,gfish);
        inv.setItem(22+9,gfish);
        inv.setItem(23+9,gfish);

        inv.setItem(21+9+9,gfish);
        inv.setItem(22+9+9,gfish);
        inv.setItem(23+9+9,gfish);

        for(int i = 11 ; i<=15; i++){
            inv.setItem(i, lili);
        }

        inv.setItem(20, lili);
        inv.setItem(20+9, lili);
        inv.setItem(20+9+9, lili);

        inv.setItem(24, lili);
        inv.setItem(24+9, lili);
        inv.setItem(24+9+9, lili);
        inv.setItem(4, sign);
        inv.setItem(31, runesieben);


        return inv;
    }

    public Inventory runeNeun(){
        Inventory inv = Bukkit.createInventory(null, 9*6, guiname);

        ItemStack runeneun = new ItemBuilder(Material.PRISMARINE_CRYSTALS).setDisplayname("§8» §c§lItem-Rune IX").addEnchant(Enchantment.ARROW_INFINITE, 10, false).setLore("§f§lRune IX", " ", "§6§l▶ §7Nutze diesen §6§lGegenstand §7im §5§lAmboss§7, um §7§lTools","§6§l▶ §7oder §7§lRüstungsleile §7mit mehr §6§lHaltbarkeit §7zu versehen.").build();

        ItemStack gfish = KopfUtil.createSkull("goldfiwow1", "§bGroßer Fisch");
        ItemMeta meta = gfish.getItemMeta();
        gfish.setAmount(16);
        gfish.setItemMeta(meta);

        ItemStack ec = new ItemBuilder(Material.ENDER_CHEST).setDisplayname("§bSchatzkistee").setAmount(8).build();
        ItemStack runeacht = new ItemBuilder(Material.PRISMARINE_CRYSTALS).setDisplayname("§8» §c§lItem-Rune VIII").addEnchant(Enchantment.ARROW_INFINITE, 10, false).setLore("§f§lRune VIII", " ", "§6§l▶ §7Nutze diesen §6§lGegenstand §7im §5§lAmboss§7, um §7§lTools","§6§l▶ §7oder §7§lRüstungsleile §7mit mehr §6§lHaltbarkeit §7zu versehen.").build();

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
        inv.setItem(26, runeneun);
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

        inv.setItem(21,gfish);
        inv.setItem(22,gfish);
        inv.setItem(23,gfish);

        inv.setItem(21+9,gfish);
        inv.setItem(22+9,gfish);
        inv.setItem(23+9,gfish);

        inv.setItem(21+9+9,gfish);
        inv.setItem(22+9+9,gfish);
        inv.setItem(23+9+9,gfish);

        for(int i = 11 ; i<=15; i++){
            inv.setItem(i, ec);
        }

        inv.setItem(20, ec);
        inv.setItem(20+9, ec);
        inv.setItem(20+9+9, ec);

        inv.setItem(24, ec);
        inv.setItem(24+9, ec);
        inv.setItem(24+9+9, ec);
        inv.setItem(4, sign);
        inv.setItem(31, runeacht);


        return inv;
    }

    public Inventory runeZehn(){
        Inventory inv = Bukkit.createInventory(null, 9*6, guiname);

        ItemStack runezehn = new ItemBuilder(Material.PRISMARINE_CRYSTALS).setDisplayname("§8» §c§lItem-Rune X").addEnchant(Enchantment.ARROW_INFINITE, 10, false).setLore("§f§lRune X", " ", "§6§l▶ §7Nutze diesen §6§lGegenstand §7im §5§lAmboss§7, um §7§lTools","§6§l▶ §7oder §7§lRüstungsleile §7mit mehr §6§lHaltbarkeit §7zu versehen.").build();

        ItemStack gfish = KopfUtil.createSkull("goldfiwow1", "§bGroßer Fisch");
        ItemMeta meta = gfish.getItemMeta();
        gfish.setAmount(32);
        gfish.setItemMeta(meta);

        ItemStack ec = new ItemBuilder(Material.ENDER_CHEST).setDisplayname("§bSchatzkistee").setAmount(16).build();
        ItemStack runeneun = new ItemBuilder(Material.PRISMARINE_CRYSTALS).setDisplayname("§8» §c§lItem-Rune IX").addEnchant(Enchantment.ARROW_INFINITE, 10, false).setLore("§f§lRune IX", " ", "§6§l▶ §7Nutze diesen §6§lGegenstand §7im §5§lAmboss§7, um §7§lTools","§6§l▶ §7oder §7§lRüstungsleile §7mit mehr §6§lHaltbarkeit §7zu versehen.").build();

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
        inv.setItem(26, runezehn);
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

        inv.setItem(21,gfish);
        inv.setItem(22,gfish);
        inv.setItem(23,gfish);

        inv.setItem(21+9,gfish);
        inv.setItem(22+9,gfish);
        inv.setItem(23+9,gfish);

        inv.setItem(21+9+9,gfish);
        inv.setItem(22+9+9,gfish);
        inv.setItem(23+9+9,gfish);

        for(int i = 11 ; i<=15; i++){
            inv.setItem(i, ec);
        }

        inv.setItem(20, ec);
        inv.setItem(20+9, ec);
        inv.setItem(20+9+9, ec);

        inv.setItem(24, ec);
        inv.setItem(24+9, ec);
        inv.setItem(24+9+9, ec);
        inv.setItem(4, sign);
        inv.setItem(31, runeneun);


        return inv;
    }

}