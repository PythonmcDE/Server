package me.bluenitrox.school.utils;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

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

    public ItemBuilder addEnchantment(Enchantment enchantment, int level, boolean b){
        this.itemStack.addEnchantment(enchantment, level);
        return this;
    }
/*	public ItemBuilder addStoredEnchant(Enchantment enchant, int level, boolean toderf){
		EnchantmentStorageMeta esm = (EnchantmentStorageMeta) this.itemMeta;
		esm.addStoredEnchant(enchant, level, toderf);
		this.ItemMeta(esm);
		return this;
	}*/

    public static Rareness getRareness(ItemStack item){
        if(NBTTags.hasTag("Rareness", item)){
            NBTTags nbt = new NBTTags(item);
            String[] test = nbt.getNBTTag("Rareness").toString().split("\"");
            String rareness = test[1];
            if(Objects.equals(rareness, "Legendär")){
                return Rareness.LEGENDÄR;
            }else if(Objects.equals(rareness, "Episch")){
                return Rareness.EPISCH;
            }else if(Objects.equals(rareness, "Mysthisch")){
                return Rareness.MYSTHISCH;
            }else if(Objects.equals(rareness, "Selten")){
                return Rareness.SELTEN;
            }else if(Objects.equals(rareness, "Gewöhnlich")){
                return Rareness.GEWÖHNLICH;
            }
        }
        return Rareness.GEWÖHNLICH;
    }

    public static String getColorByRareness(Rareness rareness){
        if(rareness == Rareness.MYSTHISCH){
            return "§6";
        }else if(rareness == Rareness.LEGENDÄR){
            return "§6";
        }else if(rareness == Rareness.EPISCH){
            return "§5";
        }else if(rareness == Rareness.SELTEN){
            return "§e";
        }else if(rareness == Rareness.GEWÖHNLICH){
            return "§7";
        }else {
            return "§7";
        }
    }

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

    public ItemStack build(String nbt) {
        this.itemStack.setItemMeta(this.itemMeta);
        NBTTags nbttags = new NBTTags(this.itemStack);
        nbttags.setNBTTag("invsafeid", nbt);
        return this.itemStack;
    }

    public ItemStack build(Rareness rareness) {
        this.itemStack.setItemMeta(this.itemMeta);
        if(rareness.equals(Rareness.MYSTHISCH)){
            NBTTags nbttags = new NBTTags(itemStack);
            nbttags.setNBTTag("Rareness", "Mysthisch");
        }else if(rareness.equals(Rareness.LEGENDÄR)){
            NBTTags nbttags = new NBTTags(itemStack);
            nbttags.setNBTTag("Rareness", "Legendär");
        }else if(rareness.equals(Rareness.EPISCH)){
            NBTTags nbttags = new NBTTags(itemStack);
            nbttags.setNBTTag("Rareness", "Episch");
        }else if(rareness.equals(Rareness.SELTEN)){
            NBTTags nbttags = new NBTTags(itemStack);
            nbttags.setNBTTag("Rareness", "Selten");
        }else{
            NBTTags nbttags = new NBTTags(itemStack);
            nbttags.setNBTTag("Rareness", "Gewöhnlich");
        }
        return this.itemStack;
    }

    public ItemStack build() {
        this.itemStack.setItemMeta(this.itemMeta);
        return this.itemStack;
    }

}


