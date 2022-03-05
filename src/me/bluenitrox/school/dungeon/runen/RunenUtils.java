package me.bluenitrox.school.dungeon.runen;

import com.mojang.authlib.GameProfile;
import com.mojang.authlib.properties.Property;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.UUID;

public class RunenUtils {

    /**
     *
     * @param type value from{@link RunenHeads}
     * @return the rune item
     */
    public ItemStack getRune(String type) {

        ItemStack typeRune = null;
        for(RunenHeads head : RunenHeads.values()) {
            switch (type) {
                case "fire_rune":
                    if(head.getName().equalsIgnoreCase("fire_rune")) {
                        ItemStack rune = head.getItem();
                        ItemMeta runenMeta = rune.getItemMeta();
                        runenMeta.setDisplayName("§cRune der Jagd");
                        runenMeta.setLore(Arrays.asList("§6▶ §7Rechtsklicke dieses §eItem§7, §7um §610 Minuten §7lang", "§6▶ doppelten Schaden §7im §c§lDungeon §7zu verursachen."));
                        rune.setItemMeta(runenMeta);
                        typeRune = rune;
                    }
                    break;
                case "water_rune":
                    if(head.getName().equalsIgnoreCase("water_rune")) {
                        ItemStack rune = head.getItem();
                        ItemMeta runenMeta = rune.getItemMeta();
                        runenMeta.setDisplayName("§fRune der Beschleunigung");
                        runenMeta.setLore(Arrays.asList("§6▶ §7Rechtsklicke dieses §eItem§7, damit sich sämtliche", "§6▶ §7deiner §fKit-Cooldowns§7, ab jetzt, §7bis zum §6nächsten Serverrestart §ahalbieren§7."));
                        rune.setItemMeta(runenMeta);
                        typeRune = rune;
                    }
                    break;
                case "engels_rune":
                    if(head.getName().equalsIgnoreCase("engels_rune")) {
                        ItemStack rune = head.getItem();
                        ItemMeta runenMeta = rune.getItemMeta();
                        runenMeta.setDisplayName("§6Engelsrune");
                        runenMeta.setLore(Arrays.asList("§6▶ §7Rechtsklicke dieses §eItem§7, um dich komplett", "§6▶ §7zu §aregenerieren §7und für §620 Sekunden", "§6▶ §7lang §6Absorbtion V §7zu erhalten."));
                        rune.setItemMeta(runenMeta);
                        typeRune = rune;
                    }
                    break;
                case "fastmine_rune":
                    if(head.getName().equalsIgnoreCase("fastmine_rune")) {
                        ItemStack rune = head.getItem();
                        ItemMeta runenMeta = rune.getItemMeta();
                        runenMeta.setDisplayName("§eRune der Eile");
                        runenMeta.setLore(Arrays.asList("§6▶ §7Rechtsklicke dieses §eItem§7, um §65 Minuten", "§6▶ §7lang §aEile III §7zu erhalten."));
                        rune.setItemMeta(runenMeta);
                        typeRune = rune;
                    }
                    break;
                case "earth_rune":
                    if(head.getName().equalsIgnoreCase("earth_rune")) {
                        ItemStack rune = head.getItem();
                        ItemMeta runenMeta = rune.getItemMeta();
                        runenMeta.setDisplayName("§2Rune der Weisheit");
                        runenMeta.setLore(Arrays.asList("§6▶ §7Rechtsklicke dieses §eItem§7, um §615 Minuten §7lang", "§6▶ §7pro §6geöffneter Kiste §7ein §azusätzliches", "§6▶ §6§lMagisches Buch §7dazu zu erhalten."));
                        rune.setItemMeta(runenMeta);
                        typeRune = rune;
                    }
                    break;
                case "strenght_rune":
                    if(head.getName().equalsIgnoreCase("strenght_rune")) {
                        ItemStack rune = head.getItem();
                        ItemMeta runenMeta = rune.getItemMeta();
                        runenMeta.setDisplayName("§6Rune der Stärke");
                        runenMeta.setLore(Arrays.asList("§6▶ §7Rechtsklicke dieses §eItem§7, um §65 Minuten", "§6▶ §7lang §aStärke II §7zu erhalten."));
                        rune.setItemMeta(runenMeta);
                        typeRune = rune;
                    }
                    break;
                case "speed_rune":
                    if(head.getName().equalsIgnoreCase("speed_rune")) {
                        ItemStack rune = head.getItem();
                        ItemMeta runenMeta = rune.getItemMeta();
                        runenMeta.setDisplayName("§fRune der Geschwindigkeit");
                        runenMeta.setLore(Arrays.asList("§6▶ §7Rechtsklicke dieses §eItem§7, um §61 Minute", "§6▶ §7lang §aSchnelligkeit II §7zu erhalten."));
                        rune.setItemMeta(runenMeta);
                        typeRune = rune;
                    }
                    break;
                case "darkness_rune":
                    if(head.getName().equalsIgnoreCase("darkness_rune")) {
                        ItemStack rune = head.getItem();
                        ItemMeta runenMeta = rune.getItemMeta();
                        runenMeta.setDisplayName("§8Rune der Todesaura");
                        runenMeta.setLore(Arrays.asList("§6▶ §7Rechtsklicke dieses §eItem§7, um §610 Minuten", "§6▶ §7lang §cGegner §7 in der §c§lWarzone §7für ganze", "§6▶ §630§7, statt §625 Sekunden §7im §cCombat §7zu halten."));
                        rune.setItemMeta(runenMeta);
                        typeRune = rune;
                    }
                    break;
                case "regeneration_rune":
                    if(head.getName().equalsIgnoreCase("regeneration_rune")) {
                        ItemStack rune = head.getItem();
                        ItemMeta runenMeta = rune.getItemMeta();
                        runenMeta.setDisplayName("§aRune der Regeneration");
                        runenMeta.setLore(Arrays.asList("§6▶ §7Rechtsklicke dieses §eItem§7, um §65 Minuten", "§6▶ §7lang §aRegeneration II §7zu erhalten."));
                        rune.setItemMeta(runenMeta);
                        typeRune = rune;
                    }
                    break;
            }
        }
        return typeRune;
    }

    /**
     *
     * @param url skin url from{@link RunenHeads} prefix + skinid
     * @return the skull Item
     */
    public ItemStack createSkull(String url, String name) {

        ItemStack head = new ItemStack(Material.SKULL_ITEM, 1, (short)3);
        if (url.isEmpty()) return head;

        SkullMeta headMeta = (SkullMeta) head.getItemMeta();
        GameProfile profile = new GameProfile(UUID.randomUUID(), null);

        profile.getProperties().put("textures", new Property("textures", url));

        try
        {
            Field profileField = headMeta.getClass().getDeclaredField("profile");
            profileField.setAccessible(true);
            profileField.set(headMeta, profile);

        }
        catch (IllegalArgumentException|NoSuchFieldException|SecurityException | IllegalAccessException error)
        {
            error.printStackTrace();
        }
        head.setItemMeta(headMeta);
        return head;
    }

}
