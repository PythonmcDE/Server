package me.bluenitrox.school.commands;

import me.bluenitrox.school.utils.ItemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.UUID;

public class MineSettings implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {

        if(!(commandSender instanceof Player)) return true;

        Player player = (Player) commandSender;
        UUID uuid = player.getUniqueId();
        player.openInventory(inventory());

        return false;
    }

    /*
    creating own InventoryClickEvent. registering in main InventoryClickEvent Class
     */
    public void onInventoryClick(InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked();
        UUID uuid = player.getUniqueId();
    }

    /*
    create Inventory, open it above
     */
    private Inventory inventory() {
        String guiname = "§8» §6§lMineneinstellungen";
        String doppelPfeil = "§8» ";
        String statusActive = "§a§laktiviert";
        String statusDeactivated = "§c§ldeaktiviert";

        /*
        create Inventory Items
         */

        //stone
        ItemStack stoneActive = new ItemBuilder(Material.STONE).setDisplayname("§7Stein").addEnchant(Enchantment.ARROW_INFINITE, 10, false).setLore(doppelPfeil + "§7Derzeitiger Status: " + statusActive).build();
        ItemStack stoneDeactivated = new ItemBuilder(Material.STONE).setDisplayname("§7Stein").setLore(doppelPfeil + "§7Derzeitiger Status: " + statusDeactivated).build();

        //gravil
        ItemStack gravilActive = new ItemBuilder(Material.GRAVEL).setDisplayname("§7Kies").addEnchant(Enchantment.ARROW_INFINITE, 10, false).setLore(doppelPfeil + "§7Derzeitiger Status: " + statusActive).build();
        ItemStack gravilDeactivated = new ItemBuilder(Material.GRAVEL).setDisplayname("§7Kies").setLore(doppelPfeil + "§7Derzeitiger Status: " + statusDeactivated).build();

        //Kohle
        ItemStack coalActive = new ItemBuilder(Material.COAL_ORE).setDisplayname("§7Kohle").addEnchant(Enchantment.ARROW_INFINITE, 10, false).setLore(doppelPfeil + "§7Derzeitiger Status: " + statusActive).build();
        ItemStack coalDeactivated = new ItemBuilder(Material.COAL_ORE).setDisplayname("§7Kohle").setLore(doppelPfeil + "§7Derzeitiger Status: " + statusDeactivated).build();

        //Brick
        ItemStack brickActive = new ItemBuilder(Material.BRICK).setDisplayname("§7Ziegel").addEnchant(Enchantment.ARROW_INFINITE, 10, false).setLore(doppelPfeil + "§7Derzeitiger Status: " + statusActive).build();
        ItemStack brickDeactivated = new ItemBuilder(Material.BRICK).setDisplayname("§7Ziegel").setLore(doppelPfeil + "§7Derzeitiger Status: " + statusDeactivated).build();

        //iron
        ItemStack ironActive = new ItemBuilder(Material.IRON_ORE).setDisplayname("§7Eisen").addEnchant(Enchantment.ARROW_INFINITE, 10, false).setLore(doppelPfeil + "§7Derzeitiger Status: " + statusActive).build();
        ItemStack ironDeactivated = new ItemBuilder(Material.IRON_ORE).setDisplayname("§7Eisen").setLore(doppelPfeil + "§7Derzeitiger Status: " + statusDeactivated).build();

        //quarz
        ItemStack quarzActive = new ItemBuilder(Material.QUARTZ_ORE).setDisplayname("§7Quarz").addEnchant(Enchantment.ARROW_INFINITE, 10, false).setLore(doppelPfeil + "§7Derzeitiger Status: " + statusActive).build();
        ItemStack quarzDeactivated = new ItemBuilder(Material.QUARTZ_ORE).setDisplayname("§7Quarz").setLore(doppelPfeil + "§7Derzeitiger Status: " + statusDeactivated).build();

        //Redstone
        ItemStack redstoneActive = new ItemBuilder(Material.REDSTONE_ORE).setDisplayname("§7Redstone").addEnchant(Enchantment.ARROW_INFINITE, 10, false).setLore(doppelPfeil + "§7Derzeitiger Status: " + statusActive).build();
        ItemStack redstoneDeactivated = new ItemBuilder(Material.REDSTONE_ORE).setDisplayname("§7Redstone").setLore(doppelPfeil + "§7Derzeitiger Status: " + statusDeactivated).build();

        //Lapis
        ItemStack lapisActive = new ItemBuilder(Material.LAPIS_ORE).setDisplayname("§7Lapis").addEnchant(Enchantment.ARROW_INFINITE, 10, false).setLore(doppelPfeil + "§7Derzeitiger Status: " + statusActive).build();
        ItemStack lapisDeactivated = new ItemBuilder(Material.LAPIS_ORE).setDisplayname("§7Lapis").setLore(doppelPfeil + "§7Derzeitiger Status: " + statusDeactivated).build();

        //Prismarin
        ItemStack prismarinActive = new ItemBuilder(Material.PRISMARINE).setDisplayname("§7Prismarin").addEnchant(Enchantment.ARROW_INFINITE, 10, false).setLore(doppelPfeil + "§7Derzeitiger Status: " + statusActive).build();
        ItemStack prismarinDeactivated = new ItemBuilder(Material.PRISMARINE).setDisplayname("§7Prismarin").setLore(doppelPfeil + "§7Derzeitiger Status: " + statusDeactivated).build();

        //Gold
        ItemStack goldActive = new ItemBuilder(Material.GOLD_ORE).setDisplayname("§7Gold").addEnchant(Enchantment.ARROW_INFINITE, 10, false).setLore(doppelPfeil + "§7Derzeitiger Status: " + statusActive).build();
        ItemStack goldDeactivated = new ItemBuilder(Material.GOLD_ORE).setDisplayname("§7Gold").setLore(doppelPfeil + "§7Derzeitiger Status: " + statusDeactivated).build();

        /*
        returning the Inventory
         */
        Inventory inventory = Bukkit.createInventory(null, 9*4, guiname);
        return inventory;
    }
}
