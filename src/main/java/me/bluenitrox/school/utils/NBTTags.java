package me.bluenitrox.school.utils;

import net.minecraft.server.v1_8_R3.NBTBase;
import net.minecraft.server.v1_8_R3.NBTTagCompound;
import net.minecraft.server.v1_8_R3.NBTTagList;
import net.minecraft.server.v1_8_R3.NBTTagString;
import org.bukkit.craftbukkit.v1_8_R3.inventory.CraftItemStack;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class NBTTags {
    private ItemStack item;
    private ItemMeta meta;

    public NBTTags(ItemStack item){
        this.item = item;
        this.meta = item.getItemMeta();
    }

    public void setNBTTag(String key, NBTBase value) {
        String stored = "";
        if (meta.getDisplayName() != null) {
            stored = meta.getDisplayName();
        } else {
            meta.setDisplayName(item.getType().toString());
            item.setItemMeta(meta);
        }

        net.minecraft.server.v1_8_R3.ItemStack nmsItem = CraftItemStack.asNMSCopy(item);

        NBTTagCompound comp = nmsItem.getTag();
        comp.set(key, value);

        nmsItem.setTag(comp);
        meta.setDisplayName(stored);
        meta = CraftItemStack.getItemMeta(nmsItem);
        item.setItemMeta(meta);
    }

    public void setNBTTag(String key, String value){
        setNBTTag(key, new NBTTagString(value));
    }

    public void removeNBTTag(String key){
        String stored = "";
        if(meta.getDisplayName() != null){
            stored = meta.getDisplayName();
        }
        meta.setDisplayName(item.getType().toString());
        item.setItemMeta(meta);

        net.minecraft.server.v1_8_R3.ItemStack nmsItem = CraftItemStack.asNMSCopy(item);

        NBTTagCompound comp = nmsItem.getTag();
        comp.remove(key);

        nmsItem.setTag(comp);
        meta.setDisplayName(stored);
        meta = CraftItemStack.getItemMeta(nmsItem);
        item.setItemMeta(meta);
    }

    public NBTBase getNBTTag(String key) {
        try {
            net.minecraft.server.v1_8_R3.ItemStack nmsItem = CraftItemStack.asNMSCopy(item);

            NBTTagCompound comp = nmsItem.getTag();
            return comp.get(key);
        } catch (Exception e) {
            System.out.println(e.toString());
            e.printStackTrace();
            return null;
        }
    }

    public static Object getNMSCompound(Object nmsItem) {
        return (((net.minecraft.server.v1_8_R3.ItemStack) nmsItem)
                .hasTag()) ? ((net.minecraft.server.v1_8_R3.ItemStack) nmsItem)
                .getTag() : new net.minecraft.server.v1_8_R3.NBTTagCompound();
    }

    public static Object getNMSItem(ItemStack itemStack) {
        return org.bukkit.craftbukkit.v1_8_R3.inventory.CraftItemStack.asNMSCopy(itemStack);
    }

    public static boolean hasTag(String key, ItemStack itemStack) {
        return ((net.minecraft.server.v1_8_R3.NBTTagCompound) getNMSCompound(getNMSItem(itemStack))).hasKey(key);
    }

    public String getNBTTagString(String key){
        try{
            net.minecraft.server.v1_8_R3.ItemStack nmsItem = CraftItemStack.asNMSCopy(item);
            NBTTagCompound comp = nmsItem.getTag();
            String value = comp.getString(key);
            return value.isEmpty() ? null : value;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public int getNBTTagInt(String key, int defaultvalue){
        try{
            net.minecraft.server.v1_8_R3.ItemStack nmsItem = CraftItemStack.asNMSCopy(item);
            NBTTagCompound comp = nmsItem.getTag();
            return comp.getInt(key);
        }catch (Exception e){
            return defaultvalue;
        }
    }

    public NBTTagList getNBTTagList(String key, int type){
        try{
            net.minecraft.server.v1_8_R3.ItemStack nmsItem = CraftItemStack.asNMSCopy(item);
            NBTTagCompound comp = nmsItem.getTag();
            return comp.getList(key, type);
        }catch (Exception e){
            return null;
        }
    }

    public NBTTagList getNBTTagList(String key){
        return getNBTTagList(key, 10);
    }
}

