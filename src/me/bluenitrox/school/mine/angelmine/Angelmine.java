package me.bluenitrox.school.mine.angelmine;

import me.bluenitrox.school.managers.MessageManager;
import me.bluenitrox.school.utils.ItemBuilder;
import me.bluenitrox.school.utils.KopfUtil;
import me.bluenitrox.school.utils.NBTTags;
import me.bluenitrox.school.utils.ValuetoString;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

public class Angelmine implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender cs, Command cmd, String s, String[] args) {
        /*
        Code following
         */
        Player p = (Player)cs;
        setInventoryContent(p.getInventory(), p);
        return false;
    }

    private void setInventoryContent(Inventory inv, Player p){
        ItemStack glas = new ItemBuilder(Material.STAINED_GLASS_PANE).setDisplayname(" ").build();
        ItemStack angel = new ItemBuilder(Material.FISHING_ROD).setDisplayname("§8§l» §6§lAngelminen").setLore("§6§l▶ §7Schalte hier neue §6§lAngelminen §7frei, um bessere",
                "§6§l▶ Items §7angeln zu können.e").build();

        ItemStack gfish = KopfUtil.createSkull("AgentPerry1337", "§8§l» §6§lAngelmine 9");
        ItemMeta meta = gfish.getItemMeta();
        meta.addEnchant(Enchantment.ARROW_INFINITE, 10, false);
        meta.setLore(Arrays.asList("§6§l▶ §7Du besitzt diese §6§lAngelmine§7, klicke", "§6§l▶ §7hier zum §6§lTeleportieren§7."));
        gfish.setItemMeta(meta);

        ItemStack gfish2 = KopfUtil.createSkull("AgentPerry1337", "§8§l» §6§lAngelmine 9");
        ItemMeta meta2 = gfish2.getItemMeta();
        meta2.setLore(Arrays.asList("§6§l▶ §aKlicke hier§7, um die Angelmine zu §6kaufen§7.", "", "§8§l● §7Neues: §bGroßer Fisch","  ", "§6§l▶ §7Kaufspreis: §6" + ValuetoString.valueToString(MessageManager.ANGELMINE_9_PREIS)+ " §7Gems"));
        gfish.setItemMeta(meta2);

        ItemStack gfish3 = KopfUtil.createSkull("AgentPerry1337", "§8§l» §6§lAngelmine 9");
        ItemMeta meta3 = gfish3.getItemMeta();
        meta3.setLore(Arrays.asList("§6§l▶ §7Bevor du diese §6§lAngelmine §7kaufen kannst,", "§6§l▶ §7musst du §6§lalle anderen §7davor freischalten.", " ", "§8§l● §7Neues: §bGroßer Fisch"));
        gfish.setItemMeta(meta3);

        ItemStack angelmine1 = new ItemBuilder(Material.RAW_FISH).addEnchant(Enchantment.ARROW_INFINITE, 10, false).setDisplayname("§8§l» §6§lAngelmine 1").setLore("§6§l▶ §7Du besitzt diese §6§lAngelmine§7, klicke", "§6§l▶ §7hier zum §6§lTeleportieren§7.").build();
        ItemStack angelmine2 = new ItemBuilder(Material.RAW_FISH, (short) 1).addEnchant(Enchantment.ARROW_INFINITE, 10, false).setDisplayname("§8§l» §6§lAngelmine 2").setLore("§6§l▶ §7Du besitzt diese §6§lAngelmine§7, klicke", "§6§l▶ §7hier zum §6§lTeleportieren§7.").build();
        ItemStack angelmine3 = new ItemBuilder(Material.RAW_FISH, (short) 3).addEnchant(Enchantment.ARROW_INFINITE, 10, false).setDisplayname("§8§l» §6§lAngelmine 3").setLore("§6§l▶ §7Du besitzt diese §6§lAngelmine§7, klicke", "§6§l▶ §7hier zum §6§lTeleportieren§7.").build();
        ItemStack angelmine4 = new ItemBuilder(Material.RAW_FISH, (short) 2).addEnchant(Enchantment.ARROW_INFINITE, 10, false).setDisplayname("§8§l» §6§lAngelmine 4").setLore("§6§l▶ §7Du besitzt diese §6§lAngelmine§7, klicke", "§6§l▶ §7hier zum §6§lTeleportieren§7.").build();
        ItemStack angelmine5 = new ItemBuilder(Material.VINE).addEnchant(Enchantment.ARROW_INFINITE, 10, false).setDisplayname("§8§l» §6§lAngelmine 5").setLore("§6§l▶ §7Du besitzt diese §6§lAngelmine§7, klicke", "§6§l▶ §7hier zum §6§lTeleportieren§7.").build();
        ItemStack angelmine6 = new ItemBuilder(Material.INK_SACK).addEnchant(Enchantment.ARROW_INFINITE, 10, false).setDisplayname("§8§l» §6§lAngelmine 6").setLore("§6§l▶ §7Du besitzt diese §6§lAngelmine§7, klicke", "§6§l▶ §7hier zum §6§lTeleportieren§7.").build();
        ItemStack angelmine7 = new ItemBuilder(Material.WATER_LILY).addEnchant(Enchantment.ARROW_INFINITE, 10, false).setDisplayname("§8§l» §6§lAngelmine 7").setLore("§6§l▶ §7Du besitzt diese §6§lAngelmine§7, klicke", "§6§l▶ §7hier zum §6§lTeleportieren§7.").build();
        ItemStack angelmine8 = new ItemBuilder(Material.EYE_OF_ENDER).addEnchant(Enchantment.ARROW_INFINITE, 10, false).setDisplayname("§8§l» §6§lAngelmine 8").setLore("§6§l▶ §7Du besitzt diese §6§lAngelmine§7, klicke", "§6§l▶ §7hier zum §6§lTeleportieren§7.").build();
        ItemStack angelmine9 = gfish;
        ItemStack angelmine10 = new ItemBuilder(Material.ENDER_CHEST).addEnchant(Enchantment.ARROW_INFINITE, 10, false).setDisplayname("§8§l» §6§lAngelmine 10").setLore("§6§l▶ §7Du besitzt diese §6§lAngelmine§7, klicke", "§6§l▶ §7hier zum §6§lTeleportieren§7.").build();

        ItemStack angelmine22 = new ItemBuilder(Material.RAW_FISH, (short) 1).setDisplayname("§8§l» §6§lAngelmine 2").setLore("§6§l▶ §aKlicke hier§7, um die Angelmine zu §6kaufen§7.", "", "§8§l● §7Neues: Roher Lachs","  ", "§6§l▶ §7Kaufspreis: §6" + ValuetoString.valueToString(MessageManager.ANGELMINE_2_PREIS)+ " §7Gems").build();
        ItemStack angelmine32 = new ItemBuilder(Material.RAW_FISH, (short) 3).setDisplayname("§8§l» §6§lAngelmine 3").setLore("§6§l▶ §aKlicke hier§7, um die Angelmine zu §6kaufen§7.", "", "§8§l● §7Neues: Kugelfisch","  ", "§6§l▶ §7Kaufspreis: §6" + ValuetoString.valueToString(MessageManager.ANGELMINE_2_PREIS)+ " §7Gems").build();
        ItemStack angelmine42 = new ItemBuilder(Material.RAW_FISH, (short) 2).setDisplayname("§8§l» §6§lAngelmine 4").setLore("§6§l▶ §aKlicke hier§7, um die Angelmine zu §6kaufen§7.", "", "§8§l● §7Neues: Clownfisch","  ", "§6§l▶ §7Kaufspreis: §6" + ValuetoString.valueToString(MessageManager.ANGELMINE_2_PREIS)+ " §7Gems").build();
        ItemStack angelmine52 = new ItemBuilder(Material.VINE).setDisplayname("§8§l» §6§lAngelmine 5").setLore("§6§l▶ §aKlicke hier§7, um die Angelmine zu §6kaufen§7.", "", "§8§l● §7Neues: Alge","  ", "§6§l▶ §7Kaufspreis: §6" + ValuetoString.valueToString(MessageManager.ANGELMINE_2_PREIS)+ " §7Gems").build();
        ItemStack angelmine62 = new ItemBuilder(Material.INK_SACK).setDisplayname("§8§l» §6§lAngelmine 6").setLore("§6§l▶ §aKlicke hier§7, um die Angelmine zu §6kaufen§7.", "", "§8§l● §7Neues: Tintenbeuteul","  ", "§6§l▶ §7Kaufspreis: §6" + ValuetoString.valueToString(MessageManager.ANGELMINE_2_PREIS)+ " §7Gems").build();
        ItemStack angelmine72 = new ItemBuilder(Material.WATER_LILY).setDisplayname("§8§l» §6§lAngelmine 7").setLore("§6§l▶ §aKlicke hier§7, um die Angelmine zu §6kaufen§7.", "", "§8§l● §7Neues: Seerose","  ", "§6§l▶ §7Kaufspreis: §6" + ValuetoString.valueToString(MessageManager.ANGELMINE_2_PREIS)+ " §7Gems").build();
        ItemStack angelmine82 = new ItemBuilder(Material.EYE_OF_ENDER).setDisplayname("§8§l» §6§lAngelmine 8").setLore("§6§l▶ §aKlicke hier§7, um die Angelmine zu §6kaufen§7.", "", "§8§l● §7Neues: Wächterauge","  ", "§6§l▶ §7Kaufspreis: §6" + ValuetoString.valueToString(MessageManager.ANGELMINE_2_PREIS)+ " §7Gems").build();
        ItemStack angelmine92 = gfish2;
        ItemStack angelmine102 = new ItemBuilder(Material.ENDER_CHEST).setDisplayname("§8§l» §6§lAngelmine 10").setLore("§6§l▶ §aKlicke hier§7, um die Angelmine zu §6kaufen§7.", "", "§8§l● §7Neues: §bSchatzkiste","  ", "§6§l▶ §7Kaufspreis: §6" + ValuetoString.valueToString(MessageManager.ANGELMINE_2_PREIS)+ " §7Gems").build();

        ItemStack angelmine33 = new ItemBuilder(Material.RAW_FISH, (short) 3).setDisplayname("§8§l» §6§lAngelmine 3").setLore("§6§l▶ §7Bevor du diese §6§lAngelmine §7kaufen kannst,", "§6§l▶ §7musst du §6§lalle anderen §7davor freischalten.", " ", "§8§l● §7Neues: Kugelfisch").build();
        ItemStack angelmine43 = new ItemBuilder(Material.RAW_FISH, (short) 2).setDisplayname("§8§l» §6§lAngelmine 4").setLore("§6§l▶ §7Bevor du diese §6§lAngelmine §7kaufen kannst,", "§6§l▶ §7musst du §6§lalle anderen §7davor freischalten.", " ", "§8§l● §7Neues: Clownfisch").build();
        ItemStack angelmine53 = new ItemBuilder(Material.VINE).setDisplayname("§8§l» §6§lAngelmine 5").setLore("§6§l▶ §7Bevor du diese §6§lAngelmine §7kaufen kannst,", "§6§l▶ §7musst du §6§lalle anderen §7davor freischalten.", " ", "§8§l● §7Neues: Alge").build();
        ItemStack angelmine63 = new ItemBuilder(Material.INK_SACK).setDisplayname("§8§l» §6§lAngelmine 6").setLore("§6§l▶ §7Bevor du diese §6§lAngelmine §7kaufen kannst,", "§6§l▶ §7musst du §6§lalle anderen §7davor freischalten.", " ", "§8§l● §7Neues: Tintenbeuteul").build();
        ItemStack angelmine73 = new ItemBuilder(Material.WATER_LILY).setDisplayname("§8§l» §6§lAngelmine 7").setLore("§6§l▶ §7Bevor du diese §6§lAngelmine §7kaufen kannst,", "§6§l▶ §7musst du §6§lalle anderen §7davor freischalten.", " ", "§8§l● §7Neues: Seerose").build();
        ItemStack angelmine83 = new ItemBuilder(Material.EYE_OF_ENDER).setDisplayname("§8§l» §6§lAngelmine 8").setLore("§6§l▶ §7Bevor du diese §6§lAngelmine §7kaufen kannst,", "§6§l▶ §7musst du §6§lalle anderen §7davor freischalten.", " ", "§8§l● §7Neues: Wächterauge").build();
        ItemStack angelmine93 = gfish3;
        ItemStack angelmine103 = new ItemBuilder(Material.ENDER_CHEST).setDisplayname("§8§l» §6§lAngelmine 10").setLore("§6§l▶ §7Bevor du diese §6§lAngelmine §7kaufen kannst,", "§6§l▶ §7musst du §6§lalle anderen §7davor freischalten.", " ", "§8§l● §7Neues: §bSchatzkiste").build();

        for(int i = 0; i <= 8; i++) {
            if (i != 4) {
                inv.setItem(i, glas);
            }
        }
        for(int i = 45; i <= 53; i++){
            inv.setItem(i,glas);
        }

        inv.setItem(4, angel);
    }
}
