package me.bluenitrox.school.utils;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;
import java.util.List;

public class ItemBuilder {
    public static ItemStack itemStack;
    private ItemMeta itemMeta;

    public ItemBuilder(Material material) {
        this.itemStack = new ItemStack(material);
        this.itemMeta = this.itemStack.getItemMeta();
    }
    public ItemBuilder(Material material, short data) {
        this.itemStack = new ItemStack(material,1, data);
        this.itemMeta = this.itemStack.getItemMeta();
    }

    public ItemBuilder setDisplayname(String displayname) {
        this.itemMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', displayname));
        return this;
    }
    public ItemBuilder addEnchant(Enchantment enchant, int level, boolean b) {
        this.itemMeta.addEnchant(enchant, level, b);
        return this;
    }

    public ItemBuilder addEnchantment(Enchantment enchantment, int level){
        this.itemStack.addEnchantment(enchantment, level);
        return this;
    }
/*	public ItemBuilder addStoredEnchant(Enchantment enchant, int level, boolean toderf){
		EnchantmentStorageMeta esm = (EnchantmentStorageMeta) this.itemMeta;
		esm.addStoredEnchant(enchant, level, toderf);
		this.ItemMeta(esm);
		return this;
	}*/

    public ItemBuilder setAmount(int amount) {
        this.itemStack.setAmount(amount);
        return this;
    }
    public ItemBuilder setDurability(short durability) {
        this.itemStack.setDurability(durability);
        return this;
    }
    public ItemBuilder setLore(List<String> lore) {
        this.itemMeta.setLore(lore);
        return this;
    }

    public ItemBuilder addItemFlag(ItemFlag flag){
        this.itemMeta.addItemFlags(flag);
        return this;

    }

    public ItemBuilder setUnbreakable(boolean b){
        this.itemMeta.spigot().setUnbreakable(b);
        return this;
    }

    public ItemBuilder setLore(String... lore) {
        return setLore(Arrays.asList(lore));
    }


    public ItemStack build() {
        this.itemStack.setItemMeta(this.itemMeta);
        return this.itemStack;
    }

    @Deprecated
    public Unsafe unsafe() {
        return new Unsafe(this);
    }

}


