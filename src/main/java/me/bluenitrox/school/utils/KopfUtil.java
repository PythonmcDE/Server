package me.bluenitrox.school.utils;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

public class KopfUtil {

    public static ItemStack createSkull(String owner, String displayName) {
        final ItemStack is = new ItemStack(Material.SKULL_ITEM, 1, (short)3);
        final SkullMeta sm = (SkullMeta)is.getItemMeta();
        sm.setOwner(owner);
        sm.setDisplayName(displayName);
        is.setItemMeta((ItemMeta)sm);
        return is;
    }

}
