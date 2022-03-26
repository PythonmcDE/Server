package me.bluenitrox.school.commands.testcommands;

import me.bluenitrox.school.enchants.EnchantManager;
import me.bluenitrox.school.seasonpass.SeasonpassManager;
import me.bluenitrox.school.utils.ItemBuilder;
import me.bluenitrox.school.utils.NBTTags;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class OtherTest implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender cs, Command command, String s, String[] strings) {

        ItemStack is = new ItemBuilder(Material.ENCHANTED_BOOK).setDisplayname("§8» §6§lMagisches Buch").setLore(EnchantManager.Tank + "I", EnchantManager.Widerstand + "I").build();
        Player player = (Player) cs;

        ItemStack is2 = new ItemBuilder(Material.ENCHANTED_BOOK).setDisplayname("§5Verzaubertes Buch").setLore("§7Explosionsschutz III", "§7Schusssicher I").build();

        player.getInventory().addItem(is);
        player.getInventory().addItem(is2);

        return false;
    }
}
