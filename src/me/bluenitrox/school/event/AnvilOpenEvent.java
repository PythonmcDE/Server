package me.bluenitrox.school.event;

import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.UUID;

public class AnvilOpenEvent extends Event implements Cancellable {

    private static final HandlerList handlers = new HandlerList();
    private final Player player;
    private final UUID uuid;
    private ItemStack item1;
    private ItemStack item2;
    private Inventory inventory;
    private boolean cancel;

    public AnvilOpenEvent(Player player, ItemStack item1, ItemStack item2, Inventory inventory) {
        this.player = player;
        this.uuid = player.getUniqueId();
        this.item1 = item1;
        this.item2 = item2;
        this.inventory = inventory;
        this.cancel = false;
    }

    public ItemStack getItem1() {
        return item1;
    }

    public ItemStack getItem2() {
        return item2;
    }

    public Inventory getInventory() {
        return this.inventory;
    }

    public UUID getUuid() {
        return uuid;
    }

    public Player getPlayer() {
        return player;
    }

    public boolean isCancelled() {
        return this.cancel;
    }

    public void setCancelled(boolean b) {
        this.cancel = b;
    }

    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }
}
