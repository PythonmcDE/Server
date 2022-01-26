package me.bluenitrox.school.features;

import me.bluenitrox.school.managers.MessageManager;
import me.bluenitrox.school.managers.PermissionsManager;
import me.bluenitrox.school.managers.PlayerJoinManager;
import me.bluenitrox.school.utils.Antidupe;
import me.bluenitrox.school.utils.ItemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class GetCases implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender cs, Command cmd, String s, String[] args) {
        Player p = (Player)cs;
        if(p.hasPermission(PermissionsManager.ALLPERMS)){
            Inventory inv = Bukkit.createInventory(null,9, "§9§lCases");

            inv.setItem(0, Antidupe.addID(new ItemBuilder(Material.DRAGON_EGG).setDisplayname(CaseAPI.daily).setLore("§8» §7Dieser §6§lFund §7verspricht dir",
                    "§8» §5§lbesondere §6Belohnungen§7.").setAmount(64).addEnchant(Enchantment.ARROW_INFINITE, 10, false).build()));
            inv.setItem(1, Antidupe.addID(new ItemBuilder(Material.DRAGON_EGG).setDisplayname(CaseAPI.gewöhnlich).setLore("§8» §7Dieser §6§lFund §7verspricht dir",
                    "§8» §5§lbesondere §6Belohnungen§7.").setAmount(64).addEnchant(Enchantment.ARROW_INFINITE, 10, false).build()));
            inv.setItem(2, Antidupe.addID(new ItemBuilder(Material.DRAGON_EGG).setDisplayname(CaseAPI.selten).setLore("§8» §7Dieser §6§lFund §7verspricht dir",
                    "§8» §5§lbesondere §6Belohnungen§7.").setAmount(64).addEnchant(Enchantment.ARROW_INFINITE, 10, false).build()));
            inv.setItem(3, Antidupe.addID(new ItemBuilder(Material.DRAGON_EGG).setDisplayname(CaseAPI.episch).setLore("§8» §7Dieser §6§lFund §7verspricht dir",
                    "§8» §5§lbesondere §6Belohnungen§7.").setAmount(64).addEnchant(Enchantment.ARROW_INFINITE, 10, false).build()));
            inv.setItem(4, Antidupe.addID(new ItemBuilder(Material.DRAGON_EGG).setDisplayname(CaseAPI.legendär).setLore("§8» §7Dieser §6§lFund §7verspricht dir",
                    "§8» §5§lbesondere §6Belohnungen§7.").setAmount(64).addEnchant(Enchantment.ARROW_INFINITE, 10, false).build()));
            inv.setItem(5, Antidupe.addID(new ItemBuilder(Material.DRAGON_EGG).setDisplayname(CaseAPI.mysthische).setLore("§8» §7Dieser §6§lFund §7verspricht dir",
                    "§8» §5§lbesondere §6Belohnungen§7.").setAmount(64).addEnchant(Enchantment.ARROW_INFINITE, 10, false).build()));
            inv.setItem(6, Antidupe.addID(new ItemBuilder(Material.DRAGON_EGG).setDisplayname(CaseAPI.tier).setLore("§8» §7Dieser §6§lFund §7verspricht dir",
                    "§8» §5§lbesondere §6Belohnungen§7.").setAmount(64).addEnchant(Enchantment.ARROW_INFINITE, 10, false).build()));

            p.openInventory(inv);
        }else {
            p.sendMessage(MessageManager.FALSECOMMAND(PlayerJoinManager.language));
        }
        return false;
    }
}
