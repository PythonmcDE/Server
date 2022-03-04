package me.bluenitrox.school.dungeon.runen;

import org.bukkit.inventory.ItemStack;

public enum RunenHeads {

    DARKNESS_RUNE("OWMxZmU4MzlhOTA4YTA3MWNjNjNmMjY2ZmQ2MTQyYTEwNjA3M2ZkMjY5ZWRhMTJjMzJjMjM5ZjRkYmQwMzIyZiJ9fX0=", "darkness_rune"), //Rune der Todesaura
    ENGELS_RUNE("NTU3NTJjOGY0MjIwZTJiM2UzOTc1NTU2ODQ1NDYwNjEzYWFlYjRkYjBjNjRiYTFjZTk2ZmFiZjNkNmVjMzVkYyJ9fX0=", "engels_rune"),
    REGENRATION_RUNE("ZmUzZjhjY2NlMzMxZGM0Mjg3NWY3OGY4YjUyMjNkZWNmNDg3ZTY4YTE4OTExMjJkZGYyZjEyZGJkNzMxODdjYSJ9fX0=", "regeneration_rune"),
    STRENGHT_RUNE("Y2E3ZDU3ODM2Y2FkNzc1ZDFmMzBmMGVlYmFmMDQwZjg5Y2VkYzMwN2E5ZGZlYTBiNDgzNjMxYmI1Zjc1YjI1YSJ9fX0=", "strenght_rune"),
    FASTMINE_RUNE("NDI2N2Y3MTE4ZDJlMjk1NDYxY2M5OTA0YjI5ODdiZjljNjE1M2I5OGVmMTg1YjMzMTE4NWIyNDk3NTU0ZDNjZSJ9fX0=", "fastmine_rune"),
    EARTH_RUNE("ZGZiODAyMmM5ZDlhMDVlMDgzMTZkYTg3NDU3YmNhYjI3ODVjM2JhN2E1OTBkNDk0N2NlZjY4ODQzYjRkMDdhZCJ9fX0=", "earth_rune"), //Weisheit
    SPEED_RUNE("ZjI0N2ZlMjU3ZDBiYzJiNDU0NmJlM2E0MWJjZTEyMTIxZmUxNjU0OTQ1MjVhNzA2MWYzNTc2YTdhYWIzYzVjMSJ9fX0=", "speed_rune"),
    FIRE_RUNE("Y2E3ZDU3ODM2Y2FkNzc1ZDFmMzBmMGVlYmFmMDQwZjg5Y2VkYzMwN2E5ZGZlYTBiNDgzNjMxYmI1Zjc1YjI1YSJ9fX0=", "fire_rune"), //Jagd
    WATER_RUNE("MzUxZDVhMWFjMTE0YTgyZmE2NTJmYzIzN2IzZTc4ZjIyZmU5ZDU4ZGU5N2M1MzdiZDVlZjk5YzM4ZmI2NmIyIn19fQ==", "water_rune"); //Beschleunigung

    private ItemStack item;
    private String idTag;
    private String prefix = "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUv";

    private RunenHeads(String texture, String id) {

        RunenUtils utils = new RunenUtils();
        item = utils.createSkull(prefix + texture, id);
        idTag = id;

    }

    public ItemStack getItem() {
        return item;
    }
    public String getName() {
        return idTag;
    }
}
