package me.bluenitrox.school.crafting;

import me.bluenitrox.school.managers.EnchantManager;
import me.bluenitrox.school.utils.ItemBuilder;
import me.bluenitrox.school.utils.KopfUtil;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

public class WerkbankGUIRegister {

    public String guinamerecepies = "§6§lCrafting-Rezepte";
    public String guiname = "§6§lWerkbank";
    public ItemStack glas = new ItemBuilder(Material.STAINED_GLASS_PANE).setDisplayname(" ").build();
    public ItemStack glasblack = new ItemBuilder(Material.STAINED_GLASS_PANE, (short)15).setDisplayname(" ").build();
    public ItemStack paper = new ItemBuilder(Material.PAPER).setDisplayname("§8» §7Crafting-Rezepte").setLore("§aKlicke hier, um alle Crafting-Rezepte anzuzeigen.").build();
    public ItemStack craftingTable = new ItemBuilder(Material.WORKBENCH).setDisplayname("§8» §7Normale Werkbank").setLore("§aKlicke hier, um die normale Werkbank zu öffnen.").build();
    public ItemStack sign = new ItemBuilder(Material.SIGN).setDisplayname("§8» " + guiname).setLore("§6§l▶ §7Du befindest dich gerade im §6Werkbank-Menü§7.", "§6§l▶ Hier kannst du §espezielle Rezepte §7craften", "§6§l▶ §7oder auf die §fnormale Werkbank §7wechseln").build();
    public ItemStack spezial = new ItemBuilder(Material.NETHER_STAR).setDisplayname("§8» §6§lSpezielle Werkbank").setLore("§6§l▶ §7Klicke hier, um eine §6Werkbank §7für", "§6§l▶ §6spezielle Crafting-Rezepte §7zu §aöffnen§7.").build();

    public void onClick(final InventoryClickEvent e){
        Player p =(Player)e.getWhoClicked();
        if(e.getClickedInventory().getName().equalsIgnoreCase(guiname) && e.getCurrentItem() != null) {
            e.setCancelled(true);
            if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§8» §7Normale Werkbank")) {
                Inventory inv = Bukkit.createInventory(null, InventoryType.CRAFTING, guiname);
                p.openInventory(inv);
            } else if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§8» §6§lSpezielle Werkbank") || e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§8» §7Crafting-Rezepte")) {
                p.openInventory(rezeptMenuSeite1());
            }
        }else if(e.getClickedInventory().getName().equalsIgnoreCase(guinamerecepies) && e.getCurrentItem() != null){
            e.setCancelled(true);
            if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§8» §c§lItem-Rune I")){
                p.openInventory(runeEins());
            }else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§8» §c§lItem-Rune II")){
                p.openInventory(runeZwei());
            }else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§8» §c§lItem-Rune III")){
                p.openInventory(runeDrei());
            }else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§8» §c§lItem-Rune IV")){
                p.openInventory(runeVier());
            }else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§8» §c§lItem-Rune V")){
                p.openInventory(runeFünf());
            }else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§8» §c§lItem-Rune VI")){
                p.openInventory(runeSechs());
            }else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§8» §c§lItem-Rune VII")){
                p.openInventory(runeSieben());
            }else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§8» §c§lItem-Rune VIII")){
                p.openInventory(runeAcht());
            }else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§8» §c§lItem-Rune IX")){
                p.openInventory(runeNeun());
            }else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§8» §c§lItem-Rune X")){
                p.openInventory(runeZehn());
            }else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§8» §7Nächste Seite")){
                if(e.getClickedInventory().getItem(9).getType() != Material.DIAMOND_BOOTS){
                    p.openInventory(rezeptMenuSeite2());
                }
            }else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§8» §7Vorherige Seite")){
                if(e.getClickedInventory().getItem(9).getType() == Material.DIAMOND_BOOTS){
                    p.openInventory(rezeptMenuSeite1());
                }
            }else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§8» §3§lItem-Erhalt I")){
                p.openInventory(ErhaltEins());
            }else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§8» §3§lItem-Erhalt II")){
                p.openInventory(ErhaltZwei());
            }else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§8» §3§lItem-Erhalt III")){
                p.openInventory(ErhaltDrei());
            }else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§8» §3§lItem-Erhalt IV")){
                p.openInventory(ErhaltVier());
            }else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§8» §3§lItem-Erhalt V")){
                p.openInventory(ErhaltFünf());
            }else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§8» §3§lItem-Erhalt VI")){
                p.openInventory(ErhaltSechs());
            }else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§8» §3§lItem-Erhalt VII")){
                p.openInventory(ErhaltSieben());
            }else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§8» §3§lItem-Erhalt VIII")){
                p.openInventory(ErhaltAcht());
            }else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§8» §3§lItem-Erhalt IX")){
                p.openInventory(ErhaltNeun());
            }else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§8» §3§lItem-Erhalt X")){
                p.openInventory(ErhaltZehn());
            }else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§6Haariger Körper der Tarantula")){
                p.openInventory(BrustplattedesTarantula());
            }else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aSmaragdapfel")){
                p.openInventory(VerzauberterGrün());
            }else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§cRedstoneapfel")){
                p.openInventory(VerzauberterApfelRot());
            }else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§9Flugtrank")){
                p.openInventory(FlugTrank());
            }else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§4Verzauberter Redstoneapfel")){
                p.openInventory(VerzauberterApfelRotR());
            }else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§6Harnisch des Feuerspeiers")){
                p.openInventory(HarnishdesFeuerspeiers());
            }else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§6Brustplatte eines Giganten")){
                p.openInventory(BrustplattedesGiganten());
            }
        }
    }

    public Inventory mainMenu(){
        Inventory inv = Bukkit.createInventory(null, 9*5, guiname);

        for(int i = 0; i<=8; i++){
            inv.setItem(i, glas);
        }
        for(int i = 9; i<=35; i++){
            inv.setItem(i, glasblack);
        }
        for(int i = 36; i<=44;i++){
            inv.setItem(i,glas);
        }

        inv.setItem(21,craftingTable);
        inv.setItem(23, spezial);

        return inv;
    }

    public Inventory rezeptMenuSeite1(){
        Inventory inv = Bukkit.createInventory(null, 9*6, guinamerecepies);

        ItemStack sign = new ItemBuilder(Material.SIGN).setDisplayname("§8» §6§lCrafting-Rezepte").setLore("§6§l▶ §7Hier werden dir alle §6§lbesonderen Rezepte", "§6§l▶ §aangezeigt §7und wie du sie §fcraften kannst§7.").build();
        ItemStack paper = new ItemBuilder(Material.PAPER).setDisplayname("§8» §7Seite §61&8/&62").build();
        ItemStack runeeins = new ItemBuilder(Material.PRISMARINE_CRYSTALS).setDisplayname("§8» §c§lItem-Rune I").addEnchant(Enchantment.ARROW_INFINITE, 10, false).setLore("§f§lRune I", " ", "§6§l▶ §7Nutze diesen §6§lGegenstand §7im §5§lAmboss§7, um §7§lTools","§6§l▶ §7oder §7§lRüstungsleile §7mit mehr §6§lHaltbarkeit §7zu versehen.").build("isInInv");
        ItemStack runezwei = new ItemBuilder(Material.PRISMARINE_CRYSTALS).setDisplayname("§8» §c§lItem-Rune II").addEnchant(Enchantment.ARROW_INFINITE, 10, false).setLore("§f§lRune II", " ", "§6§l▶ §7Nutze diesen §6§lGegenstand §7im §5§lAmboss§7, um §7§lTools","§6§l▶ §7oder §7§lRüstungsleile §7mit mehr §6§lHaltbarkeit §7zu versehen.").build("isInInv");
        ItemStack runedrei = new ItemBuilder(Material.PRISMARINE_CRYSTALS).setDisplayname("§8» §c§lItem-Rune III").addEnchant(Enchantment.ARROW_INFINITE, 10, false).setLore("§f§lRune III", " ", "§6§l▶ §7Nutze diesen §6§lGegenstand §7im §5§lAmboss§7, um §7§lTools","§6§l▶ §7oder §7§lRüstungsleile §7mit mehr §6§lHaltbarkeit §7zu versehen.").build("isInInv");
        ItemStack runevier = new ItemBuilder(Material.PRISMARINE_CRYSTALS).setDisplayname("§8» §c§lItem-Rune IV").addEnchant(Enchantment.ARROW_INFINITE, 10, false).setLore("§f§lRune IV", " ", "§6§l▶ §7Nutze diesen §6§lGegenstand §7im §5§lAmboss§7, um §7§lTools","§6§l▶ §7oder §7§lRüstungsleile §7mit mehr §6§lHaltbarkeit §7zu versehen.").build("isInInv");
        ItemStack runefünf = new ItemBuilder(Material.PRISMARINE_CRYSTALS).setDisplayname("§8» §c§lItem-Rune V").addEnchant(Enchantment.ARROW_INFINITE, 10, false).setLore("§f§lRune V", " ", "§6§l▶ §7Nutze diesen §6§lGegenstand §7im §5§lAmboss§7, um §7§lTools","§6§l▶ §7oder §7§lRüstungsleile §7mit mehr §6§lHaltbarkeit §7zu versehen.").build("isInInv");
        ItemStack runesechs = new ItemBuilder(Material.PRISMARINE_CRYSTALS).setDisplayname("§8» §c§lItem-Rune VI").addEnchant(Enchantment.ARROW_INFINITE, 10, false).setLore("§f§lRune VI", " ", "§6§l▶ §7Nutze diesen §6§lGegenstand §7im §5§lAmboss§7, um §7§lTools","§6§l▶ §7oder §7§lRüstungsleile §7mit mehr §6§lHaltbarkeit §7zu versehen.").build("isInInv");
        ItemStack runesieben = new ItemBuilder(Material.PRISMARINE_CRYSTALS).setDisplayname("§8» §c§lItem-Rune VII").addEnchant(Enchantment.ARROW_INFINITE, 10, false).setLore("§f§lRune VII", " ", "§6§l▶ §7Nutze diesen §6§lGegenstand §7im §5§lAmboss§7, um §7§lTools","§6§l▶ §7oder §7§lRüstungsleile §7mit mehr §6§lHaltbarkeit §7zu versehen.").build("isInInv");
        ItemStack runeacht = new ItemBuilder(Material.PRISMARINE_CRYSTALS).setDisplayname("§8» §c§lItem-Rune VIII").addEnchant(Enchantment.ARROW_INFINITE, 10, false).setLore("§f§lRune VIII", " ", "§6§l▶ §7Nutze diesen §6§lGegenstand §7im §5§lAmboss§7, um §7§lTools","§6§l▶ §7oder §7§lRüstungsleile §7mit mehr §6§lHaltbarkeit §7zu versehen.").build("isInInv");
        ItemStack runeneun = new ItemBuilder(Material.PRISMARINE_CRYSTALS).setDisplayname("§8» §c§lItem-Rune IX").addEnchant(Enchantment.ARROW_INFINITE, 10, false).setLore("§f§lRune IX", " ", "§6§l▶ §7Nutze diesen §6§lGegenstand §7im §5§lAmboss§7, um §7§lTools","§6§l▶ §7oder §7§lRüstungsleile §7mit mehr §6§lHaltbarkeit §7zu versehen.").build("isInInv");
        ItemStack runezehn = new ItemBuilder(Material.PRISMARINE_CRYSTALS).setDisplayname("§8» §c§lItem-Rune X").addEnchant(Enchantment.ARROW_INFINITE, 10, false).setLore("§f§lRune X", " ", "§6§l▶ §7Nutze diesen §6§lGegenstand §7im §5§lAmboss§7, um §7§lTools","§6§l▶ §7oder §7§lRüstungsleile §7mit mehr §6§lHaltbarkeit §7zu versehen.").build("isInInv");

        ItemStack erhalteins = new ItemBuilder(Material.NETHER_STAR).setDisplayname("§8» §3§lItem-Erhalt I").setLore("§f§lErhalt I", " ","§6§l▶ §7Nutze diesen §6§lGegenstand §7im §5§lAmboss§7, um ein Tool", "§6§l▶ §7oder Rüstungsteil §6§lprozentual §7zu §e§lversichern§7.").build("isInInv");
        ItemStack erhaltzwei = new ItemBuilder(Material.NETHER_STAR).setDisplayname("§8» §3§lItem-Erhalt II").setLore("§f§lErhalt II", " ","§6§l▶ §7Nutze diesen §6§lGegenstand §7im §5§lAmboss§7, um ein Tool", "§6§l▶ §7oder Rüstungsteil §6§lprozentual §7zu §e§lversichern§7.").build("isInInv");
        ItemStack erhaltdrei = new ItemBuilder(Material.NETHER_STAR).setDisplayname("§8» §3§lItem-Erhalt III").setLore("§f§lErhalt III", " ","§6§l▶ §7Nutze diesen §6§lGegenstand §7im §5§lAmboss§7, um ein Tool", "§6§l▶ §7oder Rüstungsteil §6§lprozentual §7zu §e§lversichern§7.").build("isInInv");
        ItemStack erhaltvier = new ItemBuilder(Material.NETHER_STAR).setDisplayname("§8» §3§lItem-Erhalt IV").setLore("§f§lErhalt IV", " ","§6§l▶ §7Nutze diesen §6§lGegenstand §7im §5§lAmboss§7, um ein Tool", "§6§l▶ §7oder Rüstungsteil §6§lprozentual §7zu §e§lversichern§7.").build("isInInv");
        ItemStack erhaltfünf = new ItemBuilder(Material.NETHER_STAR).setDisplayname("§8» §3§lItem-Erhalt V").setLore("§f§lErhalt V", " ","§6§l▶ §7Nutze diesen §6§lGegenstand §7im §5§lAmboss§7, um ein Tool", "§6§l▶ §7oder Rüstungsteil §6§lprozentual §7zu §e§lversichern§7.").build("isInInv");
        ItemStack erhaltsechs = new ItemBuilder(Material.NETHER_STAR).setDisplayname("§8» §3§lItem-Erhalt VI").setLore("§f§lErhalt VI", " ","§6§l▶ §7Nutze diesen §6§lGegenstand §7im §5§lAmboss§7, um ein Tool", "§6§l▶ §7oder Rüstungsteil §6§lprozentual §7zu §e§lversichern§7.").build("isInInv");
        ItemStack erhaltsieben = new ItemBuilder(Material.NETHER_STAR).setDisplayname("§8» §3§lItem-Erhalt VII").setLore("§f§lErhalt VII", " ","§6§l▶ §7Nutze diesen §6§lGegenstand §7im §5§lAmboss§7, um ein Tool", "§6§l▶ §7oder Rüstungsteil §6§lprozentual §7zu §e§lversichern§7.").build("isInInv");
        ItemStack erhaltacht = new ItemBuilder(Material.NETHER_STAR).setDisplayname("§8» §3§lItem-Erhalt VIII").setLore("§f§lErhalt VIII", " ","§6§l▶ §7Nutze diesen §6§lGegenstand §7im §5§lAmboss§7, um ein Tool", "§6§l▶ §7oder Rüstungsteil §6§lprozentual §7zu §e§lversichern§7.").build("isInInv");
        ItemStack erhaltneun = new ItemBuilder(Material.NETHER_STAR).setDisplayname("§8» §3§lItem-Erhalt IX").setLore("§f§lErhalt IX", " ","§6§l▶ §7Nutze diesen §6§lGegenstand §7im §5§lAmboss§7, um ein Tool", "§6§l▶ §7oder Rüstungsteil §6§lprozentual §7zu §e§lversichern§7.").build("isInInv");
        ItemStack erhaltzehn = new ItemBuilder(Material.NETHER_STAR).setDisplayname("§8» §3§lItem-Erhalt X").setLore("§f§lErhalt X", " ","§6§l▶ §7Nutze diesen §6§lGegenstand §7im §5§lAmboss§7, um ein Tool", "§6§l▶ §7oder Rüstungsteil §6§lprozentual §7zu §e§lversichern§7.").build("isInInv");

        ItemStack smaradtApple = new ItemBuilder(Material.GOLDEN_APPLE).setDisplayname("§aSmaragdapfel").setLore("§8» §6Regeneration III §8- §75 Sekunden", "§8» §6Absorption II §8- §72 Minuten").build("isInInv");
        ItemStack redstoneApple = new ItemBuilder(Material.APPLE).setDisplayname("§cRedstoneapfel").setLore("§8» §6Regeneration II §8- §712 Sekunden", "§8» §6Schnelligkeit II §8- §72 Minuten").build("isInInv");
        ItemStack flugtrank = new ItemBuilder(Material.POTION, (short) 2).setDisplayname("§9Flugtrank").setLore("§6§l▶ §6Dieser Trank §7erlaubt es dir", "§6§l▶ §7für §645 Minuten §6§lfliegen §7zu können.").build("isInInv");
        ItemStack redstoneapple2 = new ItemBuilder(Material.APPLE).setDisplayname("§4Verzauberter Redstoneapfel").setLore("§8» §6Regeneration IV §8- §720 Sekunden", "§8» §6Schnelligkeit II §8- §73Minuten").build("isInInv");

        ItemStack tarantulahelm = new ItemBuilder(Material.DIAMOND_HELMET).setDisplayname("§6Kopf der Tarantula").addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 6, true).addEnchant(Enchantment.DURABILITY, 10, true).setLore(EnchantManager.Tank + "III", EnchantManager.Magieschild + "III").build("isInInv");
        ItemStack tarantulachest = new ItemBuilder(Material.DIAMOND_CHESTPLATE).setDisplayname("§6Haariger Körper der Tarantula").addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 6, true).addEnchant(Enchantment.DURABILITY, 10, true).setLore(EnchantManager.Eis + "III", EnchantManager.Überladung + "III").build("isInInv");
        ItemStack tarantulaleggins = new ItemBuilder(Material.DIAMOND_LEGGINGS).setDisplayname("§6Spinnenbeine der Tarantula").addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 6, true).addEnchant(Enchantment.DURABILITY, 10, true).setLore(EnchantManager.Stacheln + "III", EnchantManager.Widerstand + "III").build("isInInv");


        for(int i = 0; i <= 8; i++){
            inv.setItem(i,glas);
        }
        for(int i = 36; i <= 44; i++){
            inv.setItem(i,glas);
        }
        for(int i = 45; i <= 52; i++){
            inv.setItem(i,glasblack);
        }
        inv.setItem(9,runeeins);
        inv.setItem(10,runezwei);
        inv.setItem(11,runedrei);
        inv.setItem(12,runevier);
        inv.setItem(13,runefünf);
        inv.setItem(14,runesechs);
        inv.setItem(15,runesieben);
        inv.setItem(16,runeacht);
        inv.setItem(17,runeneun);
        inv.setItem(18,runezehn);
        inv.setItem(19,erhalteins);
        inv.setItem(20,erhaltzwei);
        inv.setItem(21,erhaltdrei);
        inv.setItem(22,erhaltvier);
        inv.setItem(23,erhaltfünf);
        inv.setItem(24,erhaltsechs);
        inv.setItem(25,erhaltsieben);
        inv.setItem(26,erhaltacht);
        inv.setItem(27,erhaltneun);
        inv.setItem(28,erhaltzehn);
        inv.setItem(29,smaradtApple);
        inv.setItem(30,redstoneApple);
        inv.setItem(31,flugtrank);
        inv.setItem(32,redstoneapple2);
        inv.setItem(33,tarantulahelm);
        inv.setItem(34,tarantulachest);
        inv.setItem(35,tarantulaleggins);

        inv.setItem(4, sign);
        inv.setItem(49, paper);
        inv.setItem(48, KopfUtil.createSkull("lgndryFelix", "§8» §7Vorherige Seite"));
        inv.setItem(50, KopfUtil.createSkull("DerWahreNitrox", "§8» §7Nächste Seite"));

        return inv;
    }

    public Inventory rezeptMenuSeite2(){
        Inventory inv = Bukkit.createInventory(null, 9*6, guinamerecepies);

        ItemStack sign = new ItemBuilder(Material.SIGN).setDisplayname("§8» §6§lCrafting-Rezepte").setLore("§6§l▶ §7Hier werden dir alle §6§lbesonderen Rezepte", "§6§l▶ §aangezeigt §7und wie du sie §fcraften kannst§7.").build();
        ItemStack paper = new ItemBuilder(Material.PAPER).setDisplayname("§8» §7Seite §62&8/&62").build();
        //Seite 2

        ItemStack tarantulaboots = new ItemBuilder(Material.DIAMOND_BOOTS).setDisplayname("§6Schuhe der Tarantula").addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 6, true).addEnchant(Enchantment.DURABILITY, 10, true).setLore(EnchantManager.Tank + "III", EnchantManager.Magieschild + "III").build("isInInv");
        ItemStack gigantenhelm = new ItemBuilder(Material.DIAMOND_HELMET).setDisplayname("§6Helm eines Giganten").addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 7, true).addEnchant(Enchantment.DURABILITY, 10, true).setLore(EnchantManager.Widerstand + "IV", EnchantManager.Überladung + "IV").build("isInInv");
        ItemStack gigantenchest = new ItemBuilder(Material.DIAMOND_CHESTPLATE).setDisplayname("§6Brustplatte eines Giganten").addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 7, true).addEnchant(Enchantment.DURABILITY, 10, true).setLore(EnchantManager.Eis + "IV", EnchantManager.Tank + "IV").build("isInInv");
        ItemStack gigantenleggins = new ItemBuilder(Material.DIAMOND_LEGGINGS).setDisplayname("§6Hose eines Giganten").addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 7, true).addEnchant(Enchantment.DURABILITY, 10, true).setLore(EnchantManager.Stacheln + "IV", EnchantManager.ObsidianSchild + "IV").build("isInInv");
        ItemStack gigantenboots = new ItemBuilder(Material.DIAMOND_BOOTS).setDisplayname("§6Schuhe eines Giganten").addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 7, true).addEnchant(Enchantment.DURABILITY, 10, true).setLore(EnchantManager.Magieschild + "IV", EnchantManager.Heilzauber + "IV").build("isInInv");

        ItemStack feuerspeierhelm = new ItemBuilder(Material.DIAMOND_HELMET).setDisplayname("§6Helm des Feuerspeiers").addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 8, true).addEnchant(Enchantment.DURABILITY, 10, true).setLore(EnchantManager.ObsidianSchild + "V", EnchantManager.Widerstand + "V").build("isInInv");
        ItemStack feuerspeierchest = new ItemBuilder(Material.DIAMOND_CHESTPLATE).setDisplayname("§6Harnisch des Feuerspeiers").addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 8, true).addEnchant(Enchantment.DURABILITY, 10, true).setLore(EnchantManager.Eis + "V", EnchantManager.Stacheln + "V").build("isInInv");
        ItemStack feuerspeierleggins = new ItemBuilder(Material.DIAMOND_LEGGINGS).setDisplayname("§6Beinschutz des Feuerspeiers").addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 8, true).addEnchant(Enchantment.DURABILITY, 10, true).setLore(EnchantManager.Überladung + "V", EnchantManager.Heilzauber + "V").build("isInInv");
        ItemStack feuerspeierboots = new ItemBuilder(Material.DIAMOND_BOOTS).setDisplayname("§6Stiefel des Feuerspeiers").addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 8, true).addEnchant(Enchantment.DURABILITY, 10, true).setLore(EnchantManager.Tank + "V", EnchantManager.Magieschild + "V").build("isInInv");

        for(int i = 0; i <= 8; i++){
            inv.setItem(i,glas);
        }
        for(int i = 36; i <= 44; i++){
            inv.setItem(i,glas);
        }
        for(int i = 45; i <= 52; i++){
            inv.setItem(i,glasblack);
        }

        inv.setItem(9, tarantulaboots);
        inv.setItem(10, gigantenhelm);
        inv.setItem(11, gigantenchest);
        inv.setItem(12, gigantenleggins);
        inv.setItem(13, gigantenboots);
        inv.setItem(14, feuerspeierhelm);
        inv.setItem(15, feuerspeierchest);
        inv.setItem(16, feuerspeierleggins);
        inv.setItem(17, feuerspeierboots);

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

    public Inventory ErhaltEins(){
        Inventory inv = Bukkit.createInventory(null, 9*6, guiname);

        ItemStack erhaltEins = new ItemBuilder(Material.NETHER_STAR).setDisplayname("§8» §3§lItem-Erhalt I").addEnchant(Enchantment.ARROW_INFINITE, 10, false).setLore("§f§lErhalt I", " ", "§6§l▶ §7Nutze diesen §6§lGegenstand §7im §5§lAmboss§7, um §7§lTools","§6§l▶ §7oder §7§lRüstungsleile §6§lprozentual §7zu §e§lversichern§7.").build("isInInv");
        ItemStack zombiehaut = new ItemBuilder(Material.ROTTEN_FLESH).setDisplayname("§aZombiehaut").setAmount(8).setLore("§8» §7Dieses §6§lItem §7wurde von einem §c§lMonster §7aus", "§8» §7dem §c§lDungeon §7fallengelassen, verwende es", "§8» §7für ein §6mächtiges §6§lCrafting-Rezept§7.").build("isInInv");
        ItemStack pfeilspitze = new ItemBuilder(Material.FLINT).setDisplayname("§aAbgebrochene Pfeilspitze").setAmount(8).setLore("§8» §7Dieses §6§lItem §7wurde von einem §c§lMonster §7aus", "§8» §7dem §c§lDungeon §7fallengelassen, verwende es", "§8» §7für ein §6mächtiges §6§lCrafting-Rezept§7.").build("isInInv");

        ItemStack gfish = KopfUtil.createSkull("Daarkii", "§6Geisterkopf");
        ItemMeta meta = gfish.getItemMeta();
        meta.setLore(Arrays.asList("§8» §7Dieses §6§lItem §7wurde von einem §c§lMonster §7aus", "§8» §7dem §c§lDungeon §7fallengelassen, verwende es", "§8» §7für ein §6mächtiges §6§lCrafting-Rezept§7."));
        gfish.setItemMeta(meta);

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
        inv.setItem(26, erhaltEins);
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

        inv.setItem(21,pfeilspitze);
        inv.setItem(22,pfeilspitze);
        inv.setItem(23,pfeilspitze);

        inv.setItem(21+9,pfeilspitze);
        inv.setItem(22+9,pfeilspitze);
        inv.setItem(23+9,pfeilspitze);

        inv.setItem(21+9+9,pfeilspitze);
        inv.setItem(22+9+9,pfeilspitze);
        inv.setItem(23+9+9,pfeilspitze);

        for(int i = 11 ; i<=15; i++){
            inv.setItem(i, zombiehaut);
        }

        inv.setItem(20, zombiehaut);
        inv.setItem(20+9, zombiehaut);
        inv.setItem(20+9+9, zombiehaut);

        inv.setItem(24, zombiehaut);
        inv.setItem(24+9, zombiehaut);
        inv.setItem(24+9+9, zombiehaut);
        inv.setItem(4, sign);
        inv.setItem(31, gfish);

        return inv;
    }
    public Inventory ErhaltZwei(){
        Inventory inv = Bukkit.createInventory(null, 9*6, guiname);

        ItemStack erhaltZwei = new ItemBuilder(Material.NETHER_STAR).setDisplayname("§8» §3§lItem-Erhalt II").addEnchant(Enchantment.ARROW_INFINITE, 10, false).setLore("§f§lErhalt II", " ", "§6§l▶ §7Nutze diesen §6§lGegenstand §7im §5§lAmboss§7, um §7§lTools","§6§l▶ §7oder §7§lRüstungsleile §6§lprozentual §7zu §e§lversichern§7.").build("isInInv");
        ItemStack spider = new ItemBuilder(Material.ROTTEN_FLESH).setDisplayname("§aSpinnenfuß").setAmount(8).setLore("§8» §7Dieses §6§lItem §7wurde von einem §c§lMonster §7aus", "§8» §7dem §c§lDungeon §7fallengelassen, verwende es", "§8» §7für ein §6mächtiges §6§lCrafting-Rezept§7.").build("isInInv");
        ItemStack pfeilspitze = new ItemBuilder(Material.FLINT).setDisplayname("§aAbgebrochene Pfeilspitze").setAmount(16).setLore("§8» §7Dieses §6§lItem §7wurde von einem §c§lMonster §7aus", "§8» §7dem §c§lDungeon §7fallengelassen, verwende es", "§8» §7für ein §6mächtiges §6§lCrafting-Rezept§7.").build("isInInv");

        ItemStack erhaltEins = new ItemBuilder(Material.NETHER_STAR).setDisplayname("§8» §3§lItem-Erhalt I").addEnchant(Enchantment.ARROW_INFINITE, 10, false).setLore("§f§lErhalt I", " ", "§6§l▶ §7Nutze diesen §6§lGegenstand §7im §5§lAmboss§7, um §7§lTools","§6§l▶ §7oder §7§lRüstungsleile §6§lprozentual §7zu §e§lversichern§7.").build("isInInv");

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
        inv.setItem(26, erhaltZwei);
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

        inv.setItem(21,spider);
        inv.setItem(22,spider);
        inv.setItem(23,spider);

        inv.setItem(21+9,spider);
        inv.setItem(22+9,spider);
        inv.setItem(23+9,spider);

        inv.setItem(21+9+9,spider);
        inv.setItem(22+9+9,spider);
        inv.setItem(23+9+9,spider);

        for(int i = 11 ; i<=15; i++){
            inv.setItem(i, pfeilspitze);
        }

        inv.setItem(20, pfeilspitze);
        inv.setItem(20+9, pfeilspitze);
        inv.setItem(20+9+9, pfeilspitze);

        inv.setItem(24, pfeilspitze);
        inv.setItem(24+9, pfeilspitze);
        inv.setItem(24+9+9, pfeilspitze);
        inv.setItem(4, sign);
        inv.setItem(31, erhaltEins);

        return inv;
    }
    public Inventory ErhaltDrei(){
        Inventory inv = Bukkit.createInventory(null, 9*6, guiname);

        ItemStack erhaltdrei = new ItemBuilder(Material.NETHER_STAR).setDisplayname("§8» §3§lItem-Erhalt III").addEnchant(Enchantment.ARROW_INFINITE, 10, false).setLore("§f§lErhalt III", " ", "§6§l▶ §7Nutze diesen §6§lGegenstand §7im §5§lAmboss§7, um §7§lTools","§6§l▶ §7oder §7§lRüstungsleile §6§lprozentual §7zu §e§lversichern§7.").build("isInInv");
        ItemStack spider = new ItemBuilder(Material.ROTTEN_FLESH).setDisplayname("§aSpinnenfuß").setAmount(16).setLore("§8» §7Dieses §6§lItem §7wurde von einem §c§lMonster §7aus", "§8» §7dem §c§lDungeon §7fallengelassen, verwende es", "§8» §7für ein §6mächtiges §6§lCrafting-Rezept§7.").build("isInInv");
        ItemStack pfeilspitze = new ItemBuilder(Material.FLINT).setDisplayname("§aAbgebrochene Pfeilspitze").setAmount(16).setLore("§8» §7Dieses §6§lItem §7wurde von einem §c§lMonster §7aus", "§8» §7dem §c§lDungeon §7fallengelassen, verwende es", "§8» §7für ein §6mächtiges §6§lCrafting-Rezept§7.").build("isInInv");

        ItemStack erhaltEins = new ItemBuilder(Material.NETHER_STAR).setDisplayname("§8» §3§lItem-Erhalt II").addEnchant(Enchantment.ARROW_INFINITE, 10, false).setLore("§f§lErhalt II", " ", "§6§l▶ §7Nutze diesen §6§lGegenstand §7im §5§lAmboss§7, um §7§lTools","§6§l▶ §7oder §7§lRüstungsleile §6§lprozentual §7zu §e§lversichern§7.").build("isInInv");

        ItemStack gfish = KopfUtil.createSkull("Daarkii", "§6Geisterkopf");
        ItemMeta meta = gfish.getItemMeta();
        meta.setLore(Arrays.asList("§8» §7Dieses §6§lItem §7wurde von einem §c§lMonster §7aus", "§8» §7dem §c§lDungeon §7fallengelassen, verwende es", "§8» §7für ein §6mächtiges §6§lCrafting-Rezept§7."));
        gfish.setAmount(3);
        gfish.setItemMeta(meta);

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
        inv.setItem(26, erhaltdrei);
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
            inv.setItem(i, spider);
        }

        inv.setItem(20, spider);
        inv.setItem(20+9, spider);
        inv.setItem(20+9+9, spider);

        inv.setItem(24, spider);
        inv.setItem(24+9, spider);
        inv.setItem(24+9+9, spider);
        inv.setItem(4, sign);
        inv.setItem(31, erhaltEins);


        return inv;
    }
    public Inventory ErhaltVier(){
        Inventory inv = Bukkit.createInventory(null, 9*6, guiname);

        ItemStack erhaltZwei = new ItemBuilder(Material.NETHER_STAR).setDisplayname("§8» §3§lItem-Erhalt IV").addEnchant(Enchantment.ARROW_INFINITE, 10, false).setLore("§f§lErhalt IV", " ", "§6§l▶ §7Nutze diesen §6§lGegenstand §7im §5§lAmboss§7, um §7§lTools","§6§l▶ §7oder §7§lRüstungsleile §6§lprozentual §7zu §e§lversichern§7.").build("isInInv");
        ItemStack spider = new ItemBuilder(Material.ROTTEN_FLESH).setDisplayname("§aSpinnenfuß").setAmount(16).setLore("§8» §7Dieses §6§lItem §7wurde von einem §c§lMonster §7aus", "§8» §7dem §c§lDungeon §7fallengelassen, verwende es", "§8» §7für ein §6mächtiges §6§lCrafting-Rezept§7.").build("isInInv");
        ItemStack pfeilspitze = new ItemBuilder(Material.FLINT).setDisplayname("§aAbgebrochene Pfeilspitze").setAmount(16).setLore("§8» §7Dieses §6§lItem §7wurde von einem §c§lMonster §7aus", "§8» §7dem §c§lDungeon §7fallengelassen, verwende es", "§8» §7für ein §6mächtiges §6§lCrafting-Rezept§7.").build("isInInv");

        ItemStack erhaltEins = new ItemBuilder(Material.NETHER_STAR).setDisplayname("§8» §3§lItem-Erhalt III").addEnchant(Enchantment.ARROW_INFINITE, 10, false).setLore("§f§lErhalt III", " ", "§6§l▶ §7Nutze diesen §6§lGegenstand §7im §5§lAmboss§7, um §7§lTools","§6§l▶ §7oder §7§lRüstungsleile §6§lprozentual §7zu §e§lversichern§7.").build("isInInv");

        ItemStack gfish = KopfUtil.createSkull("1BlueNitrox", "§aGammeliger Zombiekopf");
        ItemMeta meta = gfish.getItemMeta();
        meta.setLore(Arrays.asList("§8» §7Dieses §6§lItem §7wurde von einem §c§lMonster §7aus", "§8» §7dem §c§lDungeon §7fallengelassen, verwende es", "§8» §7für ein §6mächtiges §6§lCrafting-Rezept§7."));
        gfish.setAmount(16);
        gfish.setItemMeta(meta);

        ItemStack gfish2 = KopfUtil.createSkull("DerEchtePiet", "§aZerbrechlicher Skelettschädel");
        ItemMeta meta2 = gfish2.getItemMeta();
        meta2.setLore(Arrays.asList("§8» §7Dieses §6§lItem §7wurde von einem §c§lMonster §7aus", "§8» §7dem §c§lDungeon §7fallengelassen, verwende es", "§8» §7für ein §6mächtiges §6§lCrafting-Rezept§7."));
        gfish2.setAmount(12);
        gfish2.setItemMeta(meta2);

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
        inv.setItem(26, erhaltZwei);
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

        inv.setItem(21,gfish2);
        inv.setItem(22,gfish2);
        inv.setItem(23,gfish2);

        inv.setItem(21+9,gfish2);
        inv.setItem(22+9,gfish2);
        inv.setItem(23+9,gfish2);

        inv.setItem(21+9+9,gfish2);
        inv.setItem(22+9+9,gfish2);
        inv.setItem(23+9+9,gfish2);

        for(int i = 11 ; i<=15; i++){
            inv.setItem(i, gfish);
        }

        inv.setItem(20, gfish);
        inv.setItem(20+9, gfish);
        inv.setItem(20+9+9, gfish);

        inv.setItem(24, gfish);
        inv.setItem(24+9, gfish);
        inv.setItem(24+9+9, gfish);
        inv.setItem(4, sign);
        inv.setItem(31, erhaltEins);

        return inv;
    }
    public Inventory ErhaltFünf(){
        Inventory inv = Bukkit.createInventory(null, 9*6, guiname);

        ItemStack erhaltZwei = new ItemBuilder(Material.NETHER_STAR).setDisplayname("§8» §3§lItem-Erhalt V").addEnchant(Enchantment.ARROW_INFINITE, 10, false).setLore("§f§lErhalt V", " ", "§6§l▶ §7Nutze diesen §6§lGegenstand §7im §5§lAmboss§7, um §7§lTools","§6§l▶ §7oder §7§lRüstungsleile §6§lprozentual §7zu §e§lversichern§7.").build("isInInv");
        ItemStack spider = new ItemBuilder(Material.ROTTEN_FLESH).setDisplayname("§aSpinnenfuß").setAmount(16).setLore("§8» §7Dieses §6§lItem §7wurde von einem §c§lMonster §7aus", "§8» §7dem §c§lDungeon §7fallengelassen, verwende es", "§8» §7für ein §6mächtiges §6§lCrafting-Rezept§7.").build("isInInv");
        ItemStack pfeilspitze = new ItemBuilder(Material.FLINT).setDisplayname("§aAbgebrochene Pfeilspitze").setAmount(16).setLore("§8» §7Dieses §6§lItem §7wurde von einem §c§lMonster §7aus", "§8» §7dem §c§lDungeon §7fallengelassen, verwende es", "§8» §7für ein §6mächtiges §6§lCrafting-Rezept§7.").build("isInInv");
        ItemStack wolle = new ItemBuilder(Material.FLINT).setDisplayname("§aWollenfetzen eines Hexenhuts").setAmount(16).setLore("§8» §7Dieses §6§lItem §7wurde von einem §c§lMonster §7aus", "§8» §7dem §c§lDungeon §7fallengelassen, verwende es", "§8» §7für ein §6mächtiges §6§lCrafting-Rezept§7.").build("isInInv");

        ItemStack erhaltEins = new ItemBuilder(Material.NETHER_STAR).setDisplayname("§8» §3§lItem-Erhalt IV").addEnchant(Enchantment.ARROW_INFINITE, 10, false).setLore("§f§lErhalt IV", " ", "§6§l▶ §7Nutze diesen §6§lGegenstand §7im §5§lAmboss§7, um §7§lTools","§6§l▶ §7oder §7§lRüstungsleile §6§lprozentual §7zu §e§lversichern§7.").build("isInInv");

        ItemStack gfish2 = KopfUtil.createSkull("DerEchtePiet", "§aZerbrechlicher Skelettschädel");
        ItemMeta meta2 = gfish2.getItemMeta();
        meta2.setLore(Arrays.asList("§8» §7Dieses §6§lItem §7wurde von einem §c§lMonster §7aus", "§8» §7dem §c§lDungeon §7fallengelassen, verwende es", "§8» §7für ein §6mächtiges §6§lCrafting-Rezept§7."));
        gfish2.setAmount(24);
        gfish2.setItemMeta(meta2);

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
        inv.setItem(26, erhaltZwei);
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

        inv.setItem(21,gfish2);
        inv.setItem(22,gfish2);
        inv.setItem(23,gfish2);

        inv.setItem(21+9,gfish2);
        inv.setItem(22+9,gfish2);
        inv.setItem(23+9,gfish2);

        inv.setItem(21+9+9,gfish2);
        inv.setItem(22+9+9,gfish2);
        inv.setItem(23+9+9,gfish2);

        for(int i = 11 ; i<=15; i++){
            inv.setItem(i, wolle);
        }

        inv.setItem(20, wolle);
        inv.setItem(20+9, wolle);
        inv.setItem(20+9+9, wolle);

        inv.setItem(24, wolle);
        inv.setItem(24+9, wolle);
        inv.setItem(24+9+9, wolle);
        inv.setItem(4, sign);
        inv.setItem(31, erhaltEins);

        return inv;
    }
    public Inventory ErhaltSechs(){
        Inventory inv = Bukkit.createInventory(null, 9*6, guiname);

        ItemStack erhaltZwei = new ItemBuilder(Material.NETHER_STAR).setDisplayname("§8» §3§lItem-Erhalt VI").addEnchant(Enchantment.ARROW_INFINITE, 10, false).setLore("§f§lErhalt VI", " ", "§6§l▶ §7Nutze diesen §6§lGegenstand §7im §5§lAmboss§7, um §7§lTools","§6§l▶ §7oder §7§lRüstungsleile §6§lprozentual §7zu §e§lversichern§7.").build("isInInv");
        ItemStack spider = new ItemBuilder(Material.ROTTEN_FLESH).setDisplayname("§aSpinnenfuß").setAmount(16).setLore("§8» §7Dieses §6§lItem §7wurde von einem §c§lMonster §7aus", "§8» §7dem §c§lDungeon §7fallengelassen, verwende es", "§8» §7für ein §6mächtiges §6§lCrafting-Rezept§7.").build("isInInv");
        ItemStack pfeilspitze = new ItemBuilder(Material.FLINT).setDisplayname("§aAbgebrochene Pfeilspitze").setAmount(16).setLore("§8» §7Dieses §6§lItem §7wurde von einem §c§lMonster §7aus", "§8» §7dem §c§lDungeon §7fallengelassen, verwende es", "§8» §7für ein §6mächtiges §6§lCrafting-Rezept§7.").build("isInInv");
        ItemStack wolle = new ItemBuilder(Material.FLINT).setDisplayname("§aWollenfetzen eines Hexenhuts").setAmount(24).setLore("§8» §7Dieses §6§lItem §7wurde von einem §c§lMonster §7aus", "§8» §7dem §c§lDungeon §7fallengelassen, verwende es", "§8» §7für ein §6mächtiges §6§lCrafting-Rezept§7.").build("isInInv");

        ItemStack erhaltEins = new ItemBuilder(Material.NETHER_STAR).setDisplayname("§8» §3§lItem-Erhalt V").addEnchant(Enchantment.ARROW_INFINITE, 10, false).setLore("§f§lErhalt V", " ", "§6§l▶ §7Nutze diesen §6§lGegenstand §7im §5§lAmboss§7, um §7§lTools","§6§l▶ §7oder §7§lRüstungsleile §6§lprozentual §7zu §e§lversichern§7.").build("isInInv");

        ItemStack gfish2 = KopfUtil.createSkull("_qlm", "§6Monsterkopf");
        ItemMeta meta2 = gfish2.getItemMeta();
        meta2.setLore(Arrays.asList("§8» §7Dieses §6§lItem §7wurde von einem §c§lMonster §7aus", "§8» §7dem §c§lDungeon §7fallengelassen, verwende es", "§8» §7für ein §6mächtiges §6§lCrafting-Rezept§7."));
        gfish2.setAmount(6);
        gfish2.setItemMeta(meta2);

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
        inv.setItem(26, erhaltZwei);
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

        inv.setItem(21,gfish2);
        inv.setItem(22,gfish2);
        inv.setItem(23,gfish2);

        inv.setItem(21+9,gfish2);
        inv.setItem(22+9,gfish2);
        inv.setItem(23+9,gfish2);

        inv.setItem(21+9+9,gfish2);
        inv.setItem(22+9+9,gfish2);
        inv.setItem(23+9+9,gfish2);

        for(int i = 11 ; i<=15; i++){
            inv.setItem(i, wolle);
        }

        inv.setItem(20, wolle);
        inv.setItem(20+9, wolle);
        inv.setItem(20+9+9, wolle);

        inv.setItem(24, wolle);
        inv.setItem(24+9, wolle);
        inv.setItem(24+9+9, wolle);
        inv.setItem(4, sign);
        inv.setItem(31, erhaltEins);

        return inv;
    }
    public Inventory ErhaltSieben(){
        Inventory inv = Bukkit.createInventory(null, 9*6, guiname);

        ItemStack erhaltZwei = new ItemBuilder(Material.NETHER_STAR).setDisplayname("§8» §3§lItem-Erhalt VII").addEnchant(Enchantment.ARROW_INFINITE, 10, false).setLore("§f§lErhalt VII", " ", "§6§l▶ §7Nutze diesen §6§lGegenstand §7im §5§lAmboss§7, um §7§lTools","§6§l▶ §7oder §7§lRüstungsleile §6§lprozentual §7zu §e§lversichern§7.").build("isInInv");
        ItemStack spider = new ItemBuilder(Material.ROTTEN_FLESH).setDisplayname("§aSpinnenfuß").setAmount(16).setLore("§8» §7Dieses §6§lItem §7wurde von einem §c§lMonster §7aus", "§8» §7dem §c§lDungeon §7fallengelassen, verwende es", "§8» §7für ein §6mächtiges §6§lCrafting-Rezept§7.").build("isInInv");
        ItemStack pfeilspitze = new ItemBuilder(Material.FLINT).setDisplayname("§aAbgebrochene Pfeilspitze").setAmount(16).setLore("§8» §7Dieses §6§lItem §7wurde von einem §c§lMonster §7aus", "§8» §7dem §c§lDungeon §7fallengelassen, verwende es", "§8» §7für ein §6mächtiges §6§lCrafting-Rezept§7.").build("isInInv");
        ItemStack wolle = new ItemBuilder(Material.FLINT).setDisplayname("§aWollenfetzen eines Hexenhuts").setAmount(24).setLore("§8» §7Dieses §6§lItem §7wurde von einem §c§lMonster §7aus", "§8» §7dem §c§lDungeon §7fallengelassen, verwende es", "§8» §7für ein §6mächtiges §6§lCrafting-Rezept§7.").build("isInInv");

        ItemStack lohen = new ItemBuilder(Material.BLAZE_POWDER).setDisplayname("§aHeiße Lohenglut").setAmount(24).setLore("§8» §7Dieses §6§lItem §7wurde von einem §c§lMonster §7aus", "§8» §7dem §c§lDungeon §7fallengelassen, verwende es", "§8» §7für ein §6mächtiges §6§lCrafting-Rezept§7.").build("isInInv");
        ItemStack nugget = new ItemBuilder(Material.GOLD_NUGGET).setDisplayname("§aGoldener Klumpen").setAmount(24).setLore("§8» §7Dieses §6§lItem §7wurde von einem §c§lMonster §7aus", "§8» §7dem §c§lDungeon §7fallengelassen, verwende es", "§8» §7für ein §6mächtiges §6§lCrafting-Rezept§7.").build("isInInv");

        ItemStack erhaltEins = new ItemBuilder(Material.NETHER_STAR).setDisplayname("§8» §3§lItem-Erhalt VI").addEnchant(Enchantment.ARROW_INFINITE, 10, false).setLore("§f§lErhalt VI", " ", "§6§l▶ §7Nutze diesen §6§lGegenstand §7im §5§lAmboss§7, um §7§lTools","§6§l▶ §7oder §7§lRüstungsleile §6§lprozentual §7zu §e§lversichern§7.").build("isInInv");

        ItemStack gfish2 = KopfUtil.createSkull("_qlm", "§6Monsterkopf");
        ItemMeta meta2 = gfish2.getItemMeta();
        meta2.setLore(Arrays.asList("§8» §7Dieses §6§lItem §7wurde von einem §c§lMonster §7aus", "§8» §7dem §c§lDungeon §7fallengelassen, verwende es", "§8» §7für ein §6mächtiges §6§lCrafting-Rezept§7."));
        gfish2.setAmount(6);
        gfish2.setItemMeta(meta2);

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
        inv.setItem(26, erhaltZwei);
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

        inv.setItem(21,nugget);
        inv.setItem(22,nugget);
        inv.setItem(23,nugget);

        inv.setItem(21+9,nugget);
        inv.setItem(22+9,nugget);
        inv.setItem(23+9,nugget);

        inv.setItem(21+9+9,nugget);
        inv.setItem(22+9+9,nugget);
        inv.setItem(23+9+9,nugget);

        for(int i = 11 ; i<=15; i++){
            inv.setItem(i, lohen);
        }

        inv.setItem(20, lohen);
        inv.setItem(20+9, lohen);
        inv.setItem(20+9+9, lohen);

        inv.setItem(24, lohen);
        inv.setItem(24+9, lohen);
        inv.setItem(24+9+9, lohen);
        inv.setItem(4, sign);
        inv.setItem(31, erhaltEins);

        return inv;
    }
    public Inventory ErhaltAcht(){
        Inventory inv = Bukkit.createInventory(null, 9*6, guiname);

        ItemStack erhaltZwei = new ItemBuilder(Material.NETHER_STAR).setDisplayname("§8» §3§lItem-Erhalt VIII").addEnchant(Enchantment.ARROW_INFINITE, 10, false).setLore("§f§lErhalt VIII", " ", "§6§l▶ §7Nutze diesen §6§lGegenstand §7im §5§lAmboss§7, um §7§lTools","§6§l▶ §7oder §7§lRüstungsleile §6§lprozentual §7zu §e§lversichern§7.").build("isInInv");
        ItemStack spider = new ItemBuilder(Material.ROTTEN_FLESH).setDisplayname("§aSpinnenfuß").setAmount(16).setLore("§8» §7Dieses §6§lItem §7wurde von einem §c§lMonster §7aus", "§8» §7dem §c§lDungeon §7fallengelassen, verwende es", "§8» §7für ein §6mächtiges §6§lCrafting-Rezept§7.").build("isInInv");
        ItemStack pfeilspitze = new ItemBuilder(Material.FLINT).setDisplayname("§aAbgebrochene Pfeilspitze").setAmount(16).setLore("§8» §7Dieses §6§lItem §7wurde von einem §c§lMonster §7aus", "§8» §7dem §c§lDungeon §7fallengelassen, verwende es", "§8» §7für ein §6mächtiges §6§lCrafting-Rezept§7.").build("isInInv");
        ItemStack wolle = new ItemBuilder(Material.FLINT).setDisplayname("§aWollenfetzen eines Hexenhuts").setAmount(24).setLore("§8» §7Dieses §6§lItem §7wurde von einem §c§lMonster §7aus", "§8» §7dem §c§lDungeon §7fallengelassen, verwende es", "§8» §7für ein §6mächtiges §6§lCrafting-Rezept§7.").build("isInInv");

        ItemStack lohen = new ItemBuilder(Material.BLAZE_POWDER).setDisplayname("§aHeiße Lohenglut").setAmount(24).setLore("§8» §7Dieses §6§lItem §7wurde von einem §c§lMonster §7aus", "§8» §7dem §c§lDungeon §7fallengelassen, verwende es", "§8» §7für ein §6mächtiges §6§lCrafting-Rezept§7.").build("isInInv");
        ItemStack nugget = new ItemBuilder(Material.GOLD_NUGGET).setDisplayname("§aGoldener Klumpen").setAmount(32).setLore("§8» §7Dieses §6§lItem §7wurde von einem §c§lMonster §7aus", "§8» §7dem §c§lDungeon §7fallengelassen, verwende es", "§8» §7für ein §6mächtiges §6§lCrafting-Rezept§7.").build("isInInv");

        ItemStack gfish = KopfUtil.createSkull("Cloud", "§aVerkohlter Skelettschädel");
        ItemMeta meta = gfish.getItemMeta();
        meta.setLore(Arrays.asList("§8» §7Dieses §6§lItem §7wurde von einem §c§lMonster §7aus", "§8» §7dem §c§lDungeon §7fallengelassen, verwende es", "§8» §7für ein §6mächtiges §6§lCrafting-Rezept§7."));
        gfish.setAmount(32);
        gfish.setItemMeta(meta);

        ItemStack erhaltEins = new ItemBuilder(Material.NETHER_STAR).setDisplayname("§8» §3§lItem-Erhalt VII").addEnchant(Enchantment.ARROW_INFINITE, 10, false).setLore("§f§lErhalt VII", " ", "§6§l▶ §7Nutze diesen §6§lGegenstand §7im §5§lAmboss§7, um §7§lTools","§6§l▶ §7oder §7§lRüstungsleile §6§lprozentual §7zu §e§lversichern§7.").build("isInInv");

        ItemStack gfish2 = KopfUtil.createSkull("_qlm", "§6Monsterkopf");
        ItemMeta meta2 = gfish2.getItemMeta();
        meta2.setLore(Arrays.asList("§8» §7Dieses §6§lItem §7wurde von einem §c§lMonster §7aus", "§8» §7dem §c§lDungeon §7fallengelassen, verwende es", "§8» §7für ein §6mächtiges §6§lCrafting-Rezept§7."));
        gfish2.setAmount(6);
        gfish2.setItemMeta(meta2);

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
        inv.setItem(26, erhaltZwei);
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
            inv.setItem(i, nugget);
        }

        inv.setItem(20, nugget);
        inv.setItem(20+9, nugget);
        inv.setItem(20+9+9, nugget);

        inv.setItem(24, nugget);
        inv.setItem(24+9, nugget);
        inv.setItem(24+9+9, nugget);
        inv.setItem(4, sign);
        inv.setItem(31, erhaltEins);

        return inv;
    }
    public Inventory ErhaltNeun(){
        Inventory inv = Bukkit.createInventory(null, 9*6, guiname);

        ItemStack erhaltZwei = new ItemBuilder(Material.NETHER_STAR).setDisplayname("§8» §3§lItem-Erhalt IX").addEnchant(Enchantment.ARROW_INFINITE, 10, false).setLore("§f§lErhalt IX", " ", "§6§l▶ §7Nutze diesen §6§lGegenstand §7im §5§lAmboss§7, um §7§lTools","§6§l▶ §7oder §7§lRüstungsleile §6§lprozentual §7zu §e§lversichern§7.").build();
        ItemStack spider = new ItemBuilder(Material.ROTTEN_FLESH).setDisplayname("§aSpinnenfuß").setAmount(16).setLore("§8» §7Dieses §6§lItem §7wurde von einem §c§lMonster §7aus", "§8» §7dem §c§lDungeon §7fallengelassen, verwende es", "§8» §7für ein §6mächtiges §6§lCrafting-Rezept§7.").build("isInInv");
        ItemStack pfeilspitze = new ItemBuilder(Material.FLINT).setDisplayname("§aAbgebrochene Pfeilspitze").setAmount(16).setLore("§8» §7Dieses §6§lItem §7wurde von einem §c§lMonster §7aus", "§8» §7dem §c§lDungeon §7fallengelassen, verwende es", "§8» §7für ein §6mächtiges §6§lCrafting-Rezept§7.").build("isInInv");
        ItemStack wolle = new ItemBuilder(Material.FLINT).setDisplayname("§aWollenfetzen eines Hexenhuts").setAmount(24).setLore("§8» §7Dieses §6§lItem §7wurde von einem §c§lMonster §7aus", "§8» §7dem §c§lDungeon §7fallengelassen, verwende es", "§8» §7für ein §6mächtiges §6§lCrafting-Rezept§7.").build("isInInv");

        ItemStack lohen = new ItemBuilder(Material.BLAZE_POWDER).setDisplayname("§aHeiße Lohenglut").setAmount(24).setLore("§8» §7Dieses §6§lItem §7wurde von einem §c§lMonster §7aus", "§8» §7dem §c§lDungeon §7fallengelassen, verwende es", "§8» §7für ein §6mächtiges §6§lCrafting-Rezept§7.").build("isInInv");
        ItemStack nugget = new ItemBuilder(Material.GOLD_NUGGET).setDisplayname("§aGoldener Klumpen").setAmount(32).setLore("§8» §7Dieses §6§lItem §7wurde von einem §c§lMonster §7aus", "§8» §7dem §c§lDungeon §7fallengelassen, verwende es", "§8» §7für ein §6mächtiges §6§lCrafting-Rezept§7.").build("isInInv");

        ItemStack gfish2 = KopfUtil.createSkull("Cloud", "§aVerkohlter Skelettschädel");
        ItemMeta meta2 = gfish2.getItemMeta();
        meta2.setLore(Arrays.asList("§8» §7Dieses §6§lItem §7wurde von einem §c§lMonster §7aus", "§8» §7dem §c§lDungeon §7fallengelassen, verwende es", "§8» §7für ein §6mächtiges §6§lCrafting-Rezept§7."));
        gfish2.setAmount(32);
        gfish2.setItemMeta(meta2);

        ItemStack erhaltEins = new ItemBuilder(Material.NETHER_STAR).setDisplayname("§8» §3§lItem-Erhalt VIII").addEnchant(Enchantment.ARROW_INFINITE, 10, false).setLore("§f§lErhalt VIII", " ", "§6§l▶ §7Nutze diesen §6§lGegenstand §7im §5§lAmboss§7, um §7§lTools","§6§l▶ §7oder §7§lRüstungsleile §6§lprozentual §7zu §e§lversichern§7.").build("isInInv");

        ItemStack gfish = KopfUtil.createSkull("Knecht", "§6Mumienkopf");
        ItemMeta meta = gfish.getItemMeta();
        meta.setLore(Arrays.asList("§8» §7Dieses §6§lItem §7wurde von einem §c§lMonster §7aus", "§8» §7dem §c§lDungeon §7fallengelassen, verwende es", "§8» §7für ein §6mächtiges §6§lCrafting-Rezept§7."));
        gfish.setAmount(6);
        gfish.setItemMeta(meta);

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
        inv.setItem(26, erhaltZwei);
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
            inv.setItem(i, gfish2);
        }

        inv.setItem(20, gfish2);
        inv.setItem(20+9, gfish2);
        inv.setItem(20+9+9, gfish2);

        inv.setItem(24, gfish2);
        inv.setItem(24+9, gfish2);
        inv.setItem(24+9+9, gfish2);
        inv.setItem(4, sign);
        inv.setItem(31, erhaltEins);

        return inv;
    }
    public Inventory ErhaltZehn(){
        Inventory inv = Bukkit.createInventory(null, 9*6, guiname);

        ItemStack erhaltZwei = new ItemBuilder(Material.NETHER_STAR).setDisplayname("§8» §3§lItem-Erhalt X").addEnchant(Enchantment.ARROW_INFINITE, 10, false).setLore("§f§lErhalt X", " ", "§6§l▶ §7Nutze diesen §6§lGegenstand §7im §5§lAmboss§7, um §7§lTools","§6§l▶ §7oder §7§lRüstungsleile §6§lprozentual §7zu §e§lversichern§7.").build("isInInv");
        ItemStack spider = new ItemBuilder(Material.ROTTEN_FLESH).setDisplayname("§aSpinnenfuß").setAmount(16).setLore("§8» §7Dieses §6§lItem §7wurde von einem §c§lMonster §7aus", "§8» §7dem §c§lDungeon §7fallengelassen, verwende es", "§8» §7für ein §6mächtiges §6§lCrafting-Rezept§7.").build("isInInv");
        ItemStack pfeilspitze = new ItemBuilder(Material.FLINT).setDisplayname("§aAbgebrochene Pfeilspitze").setAmount(16).setLore("§8» §7Dieses §6§lItem §7wurde von einem §c§lMonster §7aus", "§8» §7dem §c§lDungeon §7fallengelassen, verwende es", "§8» §7für ein §6mächtiges §6§lCrafting-Rezept§7.").build("isInInv");
        ItemStack wolle = new ItemBuilder(Material.FLINT).setDisplayname("§aWollenfetzen eines Hexenhuts").setAmount(24).setLore("§8» §7Dieses §6§lItem §7wurde von einem §c§lMonster §7aus", "§8» §7dem §c§lDungeon §7fallengelassen, verwende es", "§8» §7für ein §6mächtiges §6§lCrafting-Rezept§7.").build("isInInv");

        ItemStack lohen = new ItemBuilder(Material.BLAZE_POWDER).setDisplayname("§aHeiße Lohenglut").setAmount(24).setLore("§8» §7Dieses §6§lItem §7wurde von einem §c§lMonster §7aus", "§8» §7dem §c§lDungeon §7fallengelassen, verwende es", "§8» §7für ein §6mächtiges §6§lCrafting-Rezept§7.").build("isInInv");
        ItemStack augef = new ItemBuilder(Material.FERMENTED_SPIDER_EYE).setDisplayname("§cAuge der Tarantula").addEnchant(Enchantment.ARROW_INFINITE, 10, false).setLore("§8» §7Dieses §6§lItem §7wurde von einem §c§lMonster §7aus", "§8» §7dem §c§lDungeon §7fallengelassen, verwende es", "§8» §7für ein §6mächtiges §6§lCrafting-Rezept§7.").build("isInInv");

        ItemStack gfish2 = KopfUtil.createSkull("Cloud", "§aVerkohlter Skelettschädel");
        ItemMeta meta2 = gfish2.getItemMeta();
        meta2.setLore(Arrays.asList("§8» §7Dieses §6§lItem §7wurde von einem §c§lMonster §7aus", "§8» §7dem §c§lDungeon §7fallengelassen, verwende es", "§8» §7für ein §6mächtiges §6§lCrafting-Rezept§7."));
        gfish2.setAmount(32);
        gfish2.setItemMeta(meta2);

        ItemStack erhaltEins = new ItemBuilder(Material.NETHER_STAR).setDisplayname("§8» §3§lItem-Erhalt IX").addEnchant(Enchantment.ARROW_INFINITE, 10, false).setLore("§f§lErhalt IX", " ", "§6§l▶ §7Nutze diesen §6§lGegenstand §7im §5§lAmboss§7, um §7§lTools","§6§l▶ §7oder §7§lRüstungsleile §6§lprozentual §7zu §e§lversichern§7.").build("isInInv");

        ItemStack gfish = KopfUtil.createSkull("Knecht", "§6Mumienkopf");
        ItemMeta meta = gfish.getItemMeta();
        meta.setLore(Arrays.asList("§8» §7Dieses §6§lItem §7wurde von einem §c§lMonster §7aus", "§8» §7dem §c§lDungeon §7fallengelassen, verwende es", "§8» §7für ein §6mächtiges §6§lCrafting-Rezept§7."));
        gfish.setAmount(16);
        gfish.setItemMeta(meta);

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
        inv.setItem(26, erhaltZwei);
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

        inv.setItem(21,augef);
        inv.setItem(22,augef);
        inv.setItem(23,augef);

        inv.setItem(21+9,augef);
        inv.setItem(22+9,augef);
        inv.setItem(23+9,augef);

        inv.setItem(21+9+9,augef);
        inv.setItem(22+9+9,augef);
        inv.setItem(23+9+9,augef);

        for(int i = 11 ; i<=15; i++){
            inv.setItem(i, gfish2);
        }

        inv.setItem(20, gfish2);
        inv.setItem(20+9, gfish2);
        inv.setItem(20+9+9, gfish2);

        inv.setItem(24, gfish2);
        inv.setItem(24+9, gfish2);
        inv.setItem(24+9+9, gfish2);
        inv.setItem(4, sign);
        inv.setItem(31, erhaltEins);

        return inv;
    }

    public Inventory HarnishdesFeuerspeiers(){
        Inventory inv = Bukkit.createInventory(null, 9*6, guiname);

        ItemStack erhaltZwei = new ItemBuilder(Material.DIAMOND_CHESTPLATE).setDisplayname("§6Harnish des Feuerspeiers").addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 8, true).addEnchant(Enchantment.DURABILITY, 10, true).setLore("§a§lEis V", "§a§lStacheln V").build("isInInv");
        ItemStack spider = new ItemBuilder(Material.ROTTEN_FLESH).setDisplayname("§aSpinnenfuß").setAmount(16).setLore("§8» §7Dieses §6§lItem §7wurde von einem §c§lMonster §7aus", "§8» §7dem §c§lDungeon §7fallengelassen, verwende es", "§8» §7für ein §6mächtiges §6§lCrafting-Rezept§7.").build("isInInv");
        ItemStack pfeilspitze = new ItemBuilder(Material.FLINT).setDisplayname("§aAbgebrochene Pfeilspitze").setAmount(16).setLore("§8» §7Dieses §6§lItem §7wurde von einem §c§lMonster §7aus", "§8» §7dem §c§lDungeon §7fallengelassen, verwende es", "§8» §7für ein §6mächtiges §6§lCrafting-Rezept§7.").build("isInInv");
        ItemStack wolle = new ItemBuilder(Material.FLINT).setDisplayname("§aWollenfetzen eines Hexenhuts").setAmount(24).setLore("§8» §7Dieses §6§lItem §7wurde von einem §c§lMonster §7aus", "§8» §7dem §c§lDungeon §7fallengelassen, verwende es", "§8» §7für ein §6mächtiges §6§lCrafting-Rezept§7.").build("isInInv");

        ItemStack lohen = new ItemBuilder(Material.BLAZE_POWDER).setDisplayname("§aHeiße Lohenglut").setAmount(24).setLore("§8» §7Dieses §6§lItem §7wurde von einem §c§lMonster §7aus", "§8» §7dem §c§lDungeon §7fallengelassen, verwende es", "§8» §7für ein §6mächtiges §6§lCrafting-Rezept§7.").build("isInInv");
        ItemStack augef = new ItemBuilder(Material.FERMENTED_SPIDER_EYE).setDisplayname("§cAuge der Tarantula").addEnchant(Enchantment.ARROW_INFINITE, 10, false).setLore("§8» §7Dieses §6§lItem §7wurde von einem §c§lMonster §7aus", "§8» §7dem §c§lDungeon §7fallengelassen, verwende es", "§8» §7für ein §6mächtiges §6§lCrafting-Rezept§7.").build("isInInv");

        ItemStack gfish2 = KopfUtil.createSkull("Cloud", "§aVerkohlter Skelettschädel");
        ItemMeta meta2 = gfish2.getItemMeta();
        meta2.setLore(Arrays.asList("§8» §7Dieses §6§lItem §7wurde von einem §c§lMonster §7aus", "§8» §7dem §c§lDungeon §7fallengelassen, verwende es", "§8» §7für ein §6mächtiges §6§lCrafting-Rezept§7."));
        gfish2.setAmount(32);
        gfish2.setItemMeta(meta2);

        ItemStack erhaltEins = new ItemBuilder(Material.NETHER_STAR).setDisplayname("§8» §3§lItem-Erhalt IX").addEnchant(Enchantment.ARROW_INFINITE, 10, false).setLore("§f§lErhalt IX", " ", "§6§l▶ §7Nutze diesen §6§lGegenstand §7im §5§lAmboss§7, um §7§lTools","§6§l▶ §7oder §7§lRüstungsleile §6§lprozentual §7zu §e§lversichern§7.").build("isInInv");

        ItemStack gfish = KopfUtil.createSkull("Knecht", "§6Mumienkopf");
        ItemMeta meta = gfish.getItemMeta();
        meta.setLore(Arrays.asList("§8» §7Dieses §6§lItem §7wurde von einem §c§lMonster §7aus", "§8» §7dem §c§lDungeon §7fallengelassen, verwende es", "§8» §7für ein §6mächtiges §6§lCrafting-Rezept§7."));
        gfish.setAmount(3);
        gfish.setItemMeta(meta);

        ItemStack ei = new ItemBuilder(Material.DRAGON_EGG).setDisplayname("§c§lEi des Feuerspeiers").setLore("§6§l▶ §7Dieses §6§lEi §7wurde von dem §6mächtigen", "§6§l▶ Feuerspeier §7fallen gelassen, es kann nur von", "§6§l▶ §7einem §6wahren §6§lKrieger §7getragen werden.").build("isInInv");
        ItemStack chest = new ItemBuilder(Material.DIAMOND_CHESTPLATE).setDisplayname("§7Diamantbrustplatte").build("isInInv");

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
        inv.setItem(26, erhaltZwei);
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

        inv.setItem(21,ei);
        inv.setItem(22,gfish);
        inv.setItem(23,ei);
        inv.setItem(29,augef);

        inv.setItem(30,gfish);
        inv.setItem(31,augef);
        inv.setItem(32,gfish);
        inv.setItem(33,augef);
        inv.setItem(38,augef);

        inv.setItem(39,ei);
        inv.setItem(40,gfish);
        inv.setItem(41,ei);
        inv.setItem(42,augef);

        for(int i = 11 ; i<=15; i++){
            inv.setItem(i, gfish2);
        }

        inv.setItem(20, gfish2);
        inv.setItem(20+9, gfish2);
        inv.setItem(20+9+9, gfish2);

        inv.setItem(24, gfish2);
        inv.setItem(24+9, gfish2);
        inv.setItem(24+9+9, gfish2);
        inv.setItem(4, sign);
        inv.setItem(31, erhaltEins);

        return inv;
    }

    public Inventory BrustplattedesGiganten(){
        Inventory inv = Bukkit.createInventory(null, 9*6, guiname);

        ItemStack erhaltZwei = new ItemBuilder(Material.DIAMOND_CHESTPLATE).setDisplayname("§6Brustplatte eines Giganten").addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 7, true).addEnchant(Enchantment.DURABILITY, 10, true).setLore("§a§lEis IV", "§a§lStacheln IV").build("isInInv");
        ItemStack spider = new ItemBuilder(Material.ROTTEN_FLESH).setDisplayname("§aSpinnenfuß").setAmount(16).setLore("§8» §7Dieses §6§lItem §7wurde von einem §c§lMonster §7aus", "§8» §7dem §c§lDungeon §7fallengelassen, verwende es", "§8» §7für ein §6mächtiges §6§lCrafting-Rezept§7.").build("isInInv");
        ItemStack pfeilspitze = new ItemBuilder(Material.FLINT).setDisplayname("§aAbgebrochene Pfeilspitze").setAmount(16).setLore("§8» §7Dieses §6§lItem §7wurde von einem §c§lMonster §7aus", "§8» §7dem §c§lDungeon §7fallengelassen, verwende es", "§8» §7für ein §6mächtiges §6§lCrafting-Rezept§7.").build("isInInv");
        ItemStack wolle = new ItemBuilder(Material.FLINT).setDisplayname("§aWollenfetzen eines Hexenhuts").setAmount(24).setLore("§8» §7Dieses §6§lItem §7wurde von einem §c§lMonster §7aus", "§8» §7dem §c§lDungeon §7fallengelassen, verwende es", "§8» §7für ein §6mächtiges §6§lCrafting-Rezept§7.").build("isInInv");

        ItemStack lohen = new ItemBuilder(Material.BLAZE_POWDER).setDisplayname("§aHeiße Lohenglut").setAmount(24).setLore("§8» §7Dieses §6§lItem §7wurde von einem §c§lMonster §7aus", "§8» §7dem §c§lDungeon §7fallengelassen, verwende es", "§8» §7für ein §6mächtiges §6§lCrafting-Rezept§7.").build("isInInv");
        ItemStack auge = new ItemBuilder(Material.FERMENTED_SPIDER_EYE).setDisplayname("§cAuge der Tarantula").addEnchant(Enchantment.ARROW_INFINITE, 10, false).setLore("§8» §7Dieses §6§lItem §7wurde von einem §c§lMonster §7aus", "§8» §7dem §c§lDungeon §7fallengelassen, verwende es", "§8» §7für ein §6mächtiges §6§lCrafting-Rezept§7.").build("isInInv");
        ItemStack rabbit = new ItemBuilder(Material.RABBIT_HIDE).setDisplayname("§cHaut eines Giganten").addEnchant(Enchantment.ARROW_INFINITE, 10, false).setLore("§6§l▶ §7Dieses §6§lHautstück §7wurde einem §6§lGiganten", "§6§l▶ §7entnommen, es ist beinahe §6undurchdringlich §7und", "§6§l▶ §6§lschützt §7daher nicht nur vor der §7§lKälte§7.").build("isInInv");

        ItemStack gfish2 = KopfUtil.createSkull("Cloud", "§aVerkohlter Skelettschädel");
        ItemMeta meta2 = gfish2.getItemMeta();
        meta2.setLore(Arrays.asList("§8» §7Dieses §6§lItem §7wurde von einem §c§lMonster §7aus", "§8» §7dem §c§lDungeon §7fallengelassen, verwende es", "§8» §7für ein §6mächtiges §6§lCrafting-Rezept§7."));
        gfish2.setAmount(32);
        gfish2.setItemMeta(meta2);

        ItemStack gfish = KopfUtil.createSkull("1BlueNitrox", "§aGammeliger Zombiekopf");
        ItemMeta meta = gfish.getItemMeta();
        meta.setLore(Arrays.asList("§8» §7Dieses §6§lItem §7wurde von einem §c§lMonster §7aus", "§8» §7dem §c§lDungeon §7fallengelassen, verwende es", "§8» §7für ein §6mächtiges §6§lCrafting-Rezept§7."));
        gfish.setAmount(16);
        gfish.setItemMeta(meta);

        ItemStack gfish8 = KopfUtil.createSkull("_qlm", "§6Monsterkopf");
        ItemMeta meta8 = gfish8.getItemMeta();
        meta8.setLore(Arrays.asList("§8» §7Dieses §6§lItem §7wurde von einem §c§lMonster §7aus", "§8» §7dem §c§lDungeon §7fallengelassen, verwende es", "§8» §7für ein §6mächtiges §6§lCrafting-Rezept§7."));
        gfish8.setAmount(6);
        gfish8.setItemMeta(meta8);

        ItemStack gfish3 = KopfUtil.createSkull("Knecht", "§6Mumienkopf");
        ItemMeta meta3 = gfish3.getItemMeta();
        meta3.setLore(Arrays.asList("§8» §7Dieses §6§lItem §7wurde von einem §c§lMonster §7aus", "§8» §7dem §c§lDungeon §7fallengelassen, verwende es", "§8» §7für ein §6mächtiges §6§lCrafting-Rezept§7."));
        gfish3.setAmount(3);
        gfish3.setItemMeta(meta3);

        ItemStack ei = new ItemBuilder(Material.DRAGON_EGG).setDisplayname("§c§lEi des Feuerspeiers").setLore("§6§l▶ §7Dieses §6§lEi §7wurde von dem §6mächtigen", "§6§l▶ Feuerspeier §7fallen gelassen, es kann nur von", "§6§l▶ §7einem §6wahren §6§lKrieger §7getragen werden.").build("isInInv");
        ItemStack chest = new ItemBuilder(Material.DIAMOND_CHESTPLATE).setDisplayname("§7Diamantbrustplatte").build("isInInv");

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
        inv.setItem(26, erhaltZwei);
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

        inv.setItem(21,rabbit);
        inv.setItem(22,gfish8);
        inv.setItem(23,rabbit);

        inv.setItem(29,gfish8);
        inv.setItem(30,chest);
        inv.setItem(31,gfish8);

        inv.setItem(39,rabbit);
        inv.setItem(40,gfish);
        inv.setItem(41,rabbit);

        for(int i = 11 ; i<=15; i++){
            inv.setItem(i, gfish);
        }

        inv.setItem(20, gfish);
        inv.setItem(20+9, gfish);
        inv.setItem(20+9+9, gfish);

        inv.setItem(24, gfish);
        inv.setItem(24+9, gfish);
        inv.setItem(24+9+9, gfish);
        inv.setItem(4, sign);
        inv.setItem(31, chest);

        return inv;
    }

    public Inventory BrustplattedesTarantula(){
        Inventory inv = Bukkit.createInventory(null, 9*6, guiname);

        ItemStack erhaltZwei = new ItemBuilder(Material.DIAMOND_CHESTPLATE).setDisplayname("§6Haariger Körper der Tarantula").addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 6, true).addEnchant(Enchantment.DURABILITY, 10, true).setLore("§a§lEis III", "§a§lStacheln III").build("isInInv");
        ItemStack ei = new ItemBuilder(Material.DRAGON_EGG).setDisplayname("§c§lEi des Feuerspeiers").setLore("§6§l▶ §7Dieses §6§lEi §7wurde von dem §6mächtigen", "§6§l▶ Feuerspeier §7fallen gelassen, es kann nur von", "§6§l▶ §7einem §6wahren §6§lKrieger §7getragen werden.").build("isInInv");
        ItemStack chest = new ItemBuilder(Material.DIAMOND_CHESTPLATE).setDisplayname("§7Diamantbrustplatte").build("isInInv");

        ItemStack zombiehaut = new ItemBuilder(Material.ROTTEN_FLESH).setDisplayname("§aZombiehaut").setAmount(16).setLore("§8» §7Dieses §6§lItem §7wurde von einem §c§lMonster §7aus", "§8» §7dem §c§lDungeon §7fallengelassen, verwende es", "§8» §7für ein §6mächtiges §6§lCrafting-Rezept§7.").build("isInInv");

        ItemStack gfish3 = KopfUtil.createSkull("Knecht", "§6Mumienkopf");
        ItemMeta meta3 = gfish3.getItemMeta();
        meta3.setLore(Arrays.asList("§8» §7Dieses §6§lItem §7wurde von einem §c§lMonster §7aus", "§8» §7dem §c§lDungeon §7fallengelassen, verwende es", "§8» §7für ein §6mächtiges §6§lCrafting-Rezept§7."));
        gfish3.setAmount(3);
        gfish3.setItemMeta(meta3);

        ItemStack auge = new ItemBuilder(Material.FERMENTED_SPIDER_EYE).setDisplayname("§cAuge der Tarantula").addEnchant(Enchantment.ARROW_INFINITE, 10, false).setLore("§8» §7Dieses §6§lItem §7wurde von einem §c§lMonster §7aus", "§8» §7dem §c§lDungeon §7fallengelassen, verwende es", "§8» §7für ein §6mächtiges §6§lCrafting-Rezept§7.").build("isInInv");

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
        inv.setItem(26, erhaltZwei);
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

        inv.setItem(21,auge);
        inv.setItem(22,gfish3);
        inv.setItem(23,auge);

        inv.setItem(29,gfish3);
        inv.setItem(30,chest);
        inv.setItem(31,gfish3);

        inv.setItem(39,auge);
        inv.setItem(40,gfish3);
        inv.setItem(41,auge);

        for(int i = 11 ; i<=15; i++){
            inv.setItem(i, zombiehaut);
        }

        inv.setItem(20, zombiehaut);
        inv.setItem(20+9, zombiehaut);
        inv.setItem(20+9+9, zombiehaut);

        inv.setItem(24, zombiehaut);
        inv.setItem(24+9, zombiehaut);
        inv.setItem(24+9+9, zombiehaut);
        inv.setItem(4, sign);

        return inv;
    }

    public Inventory VerzauberterApfelRot() {
        Inventory inv = Bukkit.createInventory(null, 9*6, guiname);

        ItemStack rblock = new ItemBuilder(Material.REDSTONE_BLOCK).setDisplayname("§7Redstoneblock").setAmount(16).build("isInInv");
        ItemStack staubr = new ItemBuilder(Material.REDSTONE).setDisplayname("§cRedstone Staub").addEnchant(Enchantment.ARROW_INFINITE, 10, true).setLore("§6§l▶ §7Dieser §6Staub kann verwendet werden, um", "§6§l▶ §7einen §6mächtigen Apfel §7herzustellen.").build("isInInv");
        ItemStack apfel = new ItemBuilder(Material.APPLE).setDisplayname("§7Apfel").build("isInInv");
        ItemStack apfelench = new ItemBuilder(Material.APPLE).setDisplayname("§c§lRedstoneapfel").setLore("§8» §6Regeneration II §8- §78 Sekunden", "§8» §6Schnelligkeit II §8- §71 Minute").build("isInInv");

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
        inv.setItem(26, apfelench);
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

        inv.setItem(21,staubr);
        inv.setItem(22,staubr);
        inv.setItem(23,staubr);

        inv.setItem(21+9,staubr);
        inv.setItem(22+9,staubr);
        inv.setItem(23+9,staubr);

        inv.setItem(21+9+9,staubr);
        inv.setItem(22+9+9,staubr);
        inv.setItem(23+9+9,staubr);

        for(int i = 11 ; i<=15; i++){
            inv.setItem(i, rblock);
        }

        inv.setItem(20, rblock);
        inv.setItem(20+9, rblock);
        inv.setItem(20+9+9, rblock);

        inv.setItem(24, rblock);
        inv.setItem(24+9, rblock);
        inv.setItem(24+9+9, rblock);
        inv.setItem(4, sign);
        inv.setItem(4, sign);

        return inv;
    }
    public Inventory VerzauberterApfelRotR() {
        Inventory inv = Bukkit.createInventory(null, 9*6, guiname);

        ItemStack rblock = new ItemBuilder(Material.REDSTONE_BLOCK).setDisplayname("§7Redstoneblock").setAmount(64).build("isInInv");
        ItemStack staubr = new ItemBuilder(Material.NETHER_BRICK_ITEM).setDisplayname("§4Gepresster Redstonebarren").addEnchant(Enchantment.ARROW_INFINITE, 10, true).setLore("§6§l▶ §7Dieser §6Barren §7erscheint §5überaus selten§7.", "§6§l▶ §7Verwende ihn, um den §6mächtigsten Apfel", "§6§l▶ §7von allen herzustellen!").build("isInInv");
        ItemStack apfelneu = new ItemBuilder(Material.APPLE).addEnchant(Enchantment.ARROW_DAMAGE, 10, false).setDisplayname("§c§lVerzauberter Redstoneapfel").setLore("§8» §6Regeneration IV §8- §720 Sekunden", "§8» §6Schnelligkeit II §8- §73 Minuten").build("isInInv");
        ItemStack apfelench = new ItemBuilder(Material.APPLE).setDisplayname("§c§lRedstoneapfel").setLore("§8» §6Regeneration II §8- §78 Sekunden", "§8» §6Schnelligkeit II §8- §71 Minute").build("isInInv");

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
        inv.setItem(26, apfelench);
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

        inv.setItem(21,staubr);
        inv.setItem(22,staubr);
        inv.setItem(23,staubr);

        inv.setItem(21+9,staubr);
        inv.setItem(22+9,staubr);
        inv.setItem(23+9,staubr);

        inv.setItem(21+9+9,staubr);
        inv.setItem(22+9+9,staubr);
        inv.setItem(23+9+9,staubr);

        for(int i = 11 ; i<=15; i++){
            inv.setItem(i, rblock);
        }

        inv.setItem(20, rblock);
        inv.setItem(20+9, rblock);
        inv.setItem(20+9+9, rblock);

        inv.setItem(24, rblock);
        inv.setItem(24+9, rblock);
        inv.setItem(24+9+9, rblock);
        inv.setItem(4, sign);
        inv.setItem(31, apfelneu);

        return inv;
    }
    public Inventory VerzauberterGrün() {
        Inventory inv = Bukkit.createInventory(null, 9*6, guiname);

        ItemStack rblock = new ItemBuilder(Material.EMERALD_BLOCK).setDisplayname("§7Emeraldblock").setAmount(16).build("isInInv");
        ItemStack staubr = new ItemBuilder(Material.GLOWSTONE_DUST).setDisplayname("§aSmaragd Staub").addEnchant(Enchantment.ARROW_INFINITE, 10, true).setLore("§6§l▶ §7Dieser §6Staub kann verwendet werden, um", "§6§l▶ §7einen §6mächtigen Apfel §7herzustellen.").build("isInInv");
        ItemStack apfel = new ItemBuilder(Material.APPLE).setDisplayname("§7Apfel").build("isInInv");
        ItemStack apfelench = new ItemBuilder(Material.GOLDEN_APPLE).setDisplayname("§a§lSmaragdapfel").setLore("§8» §6Regeneration III §8- §74 Sekunden", "§8» §6Absorption II §8- §71 Minute").build("isInInv");

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
        inv.setItem(26, apfelench);
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

        inv.setItem(21,staubr);
        inv.setItem(22,staubr);
        inv.setItem(23,staubr);

        inv.setItem(21+9,staubr);
        inv.setItem(22+9,staubr);
        inv.setItem(23+9,staubr);

        inv.setItem(21+9+9,staubr);
        inv.setItem(22+9+9,staubr);
        inv.setItem(23+9+9,staubr);

        for(int i = 11 ; i<=15; i++){
            inv.setItem(i, rblock);
        }

        inv.setItem(20, rblock);
        inv.setItem(20+9, rblock);
        inv.setItem(20+9+9, rblock);

        inv.setItem(24, rblock);
        inv.setItem(24+9, rblock);
        inv.setItem(24+9+9, rblock);
        inv.setItem(4, sign);
        inv.setItem(31, apfel);

        return inv;
    }
    public Inventory FlugTrank() {
        Inventory inv = Bukkit.createInventory(null, 9*6, guiname);

        ItemStack glassss = new ItemBuilder(Material.GLASS_BOTTLE).setDisplayname("§7Glasflasche").build("isInInv");
        ItemStack zucker = new ItemBuilder(Material.SUGAR).setDisplayname("§7Flugpulver").addEnchant(Enchantment.ARROW_INFINITE, 10, true).setLore("§6§l▶ §7Dieses Pulver §6verleiht dir Flügel§7!", "§6§l▶ §7Verwende es um für §62 Minuten §7 zu §6§lfliegen§7,", "§6§l▶ §7oder stelle einen mächtigen §9§lFlugtrank §7her.").build("isInInv");
        ItemStack pot = new ItemBuilder(Material.POTION, (short) 2).setDisplayname("§9§lFlugtrank").setLore("§6§l▶ §6Dieser Trank §7erlaubt es dir", "§6§l▶ §7für §645 Minuten §6§lfliegen §7zu können.").build("isInInv");

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

        inv.setItem(21, glassss);
        inv.setItem(22, glassss);
        inv.setItem(23, glassss);
        inv.setItem(30, glassss);
        inv.setItem(31, glassss);
        inv.setItem(32, glassss);

        for(int i = 11 ; i<=15; i++){
            inv.setItem(i, zucker);
        }

        inv.setItem(20, zucker);
        inv.setItem(20+9, zucker);


        inv.setItem(24, zucker);
        inv.setItem(24+9, zucker);
        for(int i = 38 ; i<=42; i++){
            inv.setItem(i, zucker);
        }
        inv.setItem(4, sign);
        inv.setItem(31, pot);

        return inv;
    }

}