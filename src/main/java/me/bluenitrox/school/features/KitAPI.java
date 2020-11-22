package me.bluenitrox.school.features;

import me.bluenitrox.school.utils.ItemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class KitAPI {

    private final String guiname = "§6§lDeine Kits";

    public void openKitMenu(Player p){
        Inventory inv = Bukkit.createInventory(null, 9*6,guiname);

        setKitContent(inv);

        p.openInventory(inv);
    }

    private void setKitContent(Inventory inv){
        ItemStack glas = new ItemBuilder(Material.STAINED_GLASS_PANE).setDisplayname(" ").build();
        ItemStack blackglass = new ItemBuilder(Material.STAINED_GLASS_PANE,  (short)15).setDisplayname(" ").build();

        for(int i = 0; i != 10; i++){
            inv.setItem(i,glas);
        }

        inv.setItem(9, new ItemBuilder(Material.WOOD_SWORD).setDisplayname("§6§lHolz").setLore("§8» §7Du besitzt dieses Kit, klicke", "§8» §7hier, um es §a§lAbzuholen§7.").addEnchant(Enchantment.ARROW_INFINITE, 10, false).build());
        inv.setItem(10, new ItemBuilder(Material.STONE_SWORD).setDisplayname("§c§o§lStein").setLore("§8» §7Noch §cnicht freigeschaltet§7!", "§8» §7Hole das §6vorherige Kit §7noch §6§l35 mal §7ab!").build());
        inv.setItem(11, new ItemBuilder(Material.IRON_SWORD).setDisplayname("§c§o§lEisen").setLore("§8» §7Noch §cnicht freigeschaltet§7!", "§8» §7Hole das §6vorherige Kit §7noch §6§l50 mal §7ab!").build());
        inv.setItem(12, new ItemBuilder(Material.BOW).setDisplayname("§c§o§lWarzone").setLore("§8» §7Noch §cnicht freigeschaltet§7!", "§8» §7Hole das §6vorherige Kit §7noch §6§l50 mal §7ab!").build());
        inv.setItem(13, new ItemBuilder(Material.DIAMOND_SWORD).setDisplayname("§c§o§lDiamant").setLore("§8» §7Noch §cnicht freigeschaltet§7!", "§8» §7Hole das §6vorherige Kit §7noch §6§l50 mal §7ab!").build());

        for(int in2 = 14; in2 != 17; in2++){
            inv.setItem(in2,blackglass);
        }

        inv.setItem(18, new ItemBuilder(Material.DIAMOND_PICKAXE).setDisplayname("§c§o§lBergarbeiter").setLore("§8» §7Noch §cnicht freigeschaltet§7!", "§8» §7Kaufpreis: §61 Mio Gems").build());
        inv.setItem(19, new ItemBuilder(Material.GOLD_INGOT).setDisplayname("§c§o§lGoldfinger").setLore("§8» §7Noch §cnicht freigeschaltet§7!", "§8» §7Hole das §6vorherige Kit §7noch §6§l35 mal §7ab!").build());
        inv.setItem(20, new ItemBuilder(Material.DIAMOND_SWORD).setDisplayname("§c§o§lJuwelier").setLore("§8» §7Noch §cnicht freigeschaltet§7!", "§8» §7Hole das §6vorherige Kit §7noch §6§l50 mal §7ab!").build());
        inv.setItem(21, new ItemBuilder(Material.EMERALD).setDisplayname("§c§o§lBänker").setLore("§8» §7Noch §cnicht freigeschaltet§7!", "§8» §7Hole das §6vorherige Kit §7noch §6§l50 mal §7ab!").build());

        for(int in3 = 22; in3 != 26; in3++){
            inv.setItem(in3,blackglass);
        }

        inv.setItem(27, new ItemBuilder(Material.MELON).setDisplayname("§c§o§lNinja").setLore("§8» §7Noch §cnicht freigeschaltet§7!", "§8» §7Kaufpreis: §65 Mio Gems").build());
        inv.setItem(28, new ItemBuilder(Material.SULPHUR).setDisplayname("§c§o§lSensei").setLore("§8» §7Noch §cnicht freigeschaltet§7!", "§8» §7Hole das §6vorherige Kit §7noch §6§l35 mal §7ab!").build());
        inv.setItem(29, new ItemBuilder(Material.GOLD_CHESTPLATE).setDisplayname("§c§o§lMeister").setLore("§8» §7Noch §cnicht freigeschaltet§7!", "§8» §7Hole das §6vorherige Kit §7noch §6§l50 mal §7ab!").build());

        for(int in4 = 30; in4 != 35; in4++){
            inv.setItem(in4,blackglass);
        }
        for(int in5 = 36; in5 != 45; in5++){
            inv.setItem(in5,glas);
        }
        for(int in6 = 46; in6 != 49; in6++){
            inv.setItem(in6,glas);
        }

        inv.setItem(50, new ItemBuilder(Material.PAPER).setDisplayname("§8» §6§lKit Menu").setLore("§6▶ §7Hole dir §6deine Kits §7ab!", "", "§7Kits können durch", "§8● §6das Erwerben des gewünschten Kits §7 oder", "§8● §6wiederholtes Abholen der vorherigen Kits", "§7freigeschaltet werden!").build());

        /*TODO
            inv.setItem(Slot, Item);
            for(int i = 0; i != 10; i++){
                inv.setItem(i,glas);
            }
            für jedes item
            Kit Menu bitte genau so machen wie auf euer Screenshot
            ACHTE AUF RECHTSCHREIBUNG UND RICHTIGE BENENNUNG!!
         */
    }

}