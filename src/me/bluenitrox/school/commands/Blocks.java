package me.bluenitrox.school.commands;

import me.bluenitrox.school.managers.MessageManager;
import me.bluenitrox.school.managers.PermissionsManager;
import me.bluenitrox.school.managers.PlayerJoinManager;
import me.bluenitrox.school.utils.ItemBuilder;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class Blocks implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {

        if(!(sender instanceof Player)) return true;
        Player player = (Player) sender;

        if(!player.hasPermission(PermissionsManager.kingqueen)) {
            MessageManager.NOPERMISSIONS(PlayerJoinManager.language);
            return true;
        }
        if(!hasEnoughMaterials(player)) {
            player.sendMessage(MessageManager.PREFIX + "§7Du hast §ckeine §6§lItems §7zum zusammencraften.");
        }

        this.setOreToBlocks(player);


        return false;
    }

    private int hasItem(Material item, Player p) {
        int amountitems = 0;
        for (int i = 0; i < p.getInventory().getSize(); i++) {
            if (p.getInventory().getItem(i) != null) {
                if (p.getInventory().getItem(i).getType() == item) {
                    amountitems += p.getInventory().getItem(i).getAmount();
                }
            }
        }
        return amountitems;
    }

    private int hasItem(ItemStack item, Player p) {
        int amountitems = 0;
        for (int i = 0; i < p.getInventory().getSize(); i++) {
            if (p.getInventory().getItem(i) != null) {
                if (p.getInventory().getItem(i) == item) {
                    amountitems += p.getInventory().getItem(i).getAmount();
                }
            }
        }
        return amountitems;
    }


    private boolean hasEnoughMaterials(Player player) {
        boolean a = false;
        if(this.hasItem(Material.COAL, player) <= 9
                || this.hasItem(Material.IRON_INGOT, player) <= 9
                || this.hasItem(Material.QUARTZ, player) <= 9
                || this.hasItem(Material.REDSTONE, player) <= 9
                || this.hasItem(Material.GOLD_INGOT, player) <= 9
                || this.hasItem(Material.DIAMOND, player) <= 9
                || this.hasItem(Material.EMERALD, player) <= 9
                || this.hasItem(new ItemStack(Material.INK_SACK, (short) 4), player) <= 9
        ) {
            a = true;

        }
        return a;
    }

    public void setOreToBlocks(Player p) {
        ItemStack[] var2 = p.getInventory().getContents();
        int var3 = var2.length;

        for (int var4 = 0; var4 < var3; ++var4) {
            ItemStack i = var2[var4];
            if (i != null) {
                if (i.getType().equals(Material.IRON_INGOT)) {
                    if (i.getAmount() >= 9 && i.getAmount() < 18) {
                        i.setAmount(i.getAmount() - 9);
                        p.getInventory().addItem(new ItemStack[]{new ItemStack(Material.IRON_BLOCK, 1)});
                    }

                    if (i.getAmount() >= 18 && i.getAmount() < 27) {
                        i.setAmount(i.getAmount() - 18);
                        p.getInventory().addItem(new ItemStack[]{new ItemStack(Material.IRON_BLOCK, 2)});
                    }

                    if (i.getAmount() >= 27 && i.getAmount() < 36) {
                        i.setAmount(i.getAmount() - 27);
                        p.getInventory().addItem(new ItemStack[]{new ItemStack(Material.IRON_BLOCK, 3)});
                    }

                    if (i.getAmount() >= 36 && i.getAmount() < 45) {
                        i.setAmount(i.getAmount() - 36);
                        p.getInventory().addItem(new ItemStack[]{new ItemStack(Material.IRON_BLOCK, 4)});
                    }

                    if (i.getAmount() >= 45 && i.getAmount() < 54) {
                        i.setAmount(i.getAmount() - 45);
                        p.getInventory().addItem(new ItemStack[]{new ItemStack(Material.IRON_BLOCK, 5)});
                    }

                    if (i.getAmount() >= 54 && i.getAmount() < 63) {
                        i.setAmount(i.getAmount() - 54);
                        p.getInventory().addItem(new ItemStack[]{new ItemStack(Material.IRON_BLOCK, 6)});
                    }

                    if (i.getAmount() >= 63 && i.getAmount() < 64) {
                        i.setAmount(i.getAmount() - 63);
                        p.getInventory().addItem(new ItemStack[]{new ItemStack(Material.IRON_BLOCK, 7)});
                    }

                    if (i.getAmount() == 64) {
                        i.setAmount(i.getAmount() - 63);
                        p.getInventory().addItem(new ItemStack[]{new ItemStack(Material.IRON_BLOCK, 7)});
                    }
                }

                if (i.getType().equals(Material.DIAMOND)) {
                    if (i.getAmount() >= 9 && i.getAmount() < 18) {
                        i.setAmount(i.getAmount() - 9);
                        p.getInventory().addItem(new ItemStack[]{new ItemStack(Material.DIAMOND_BLOCK, 1)});
                    }

                    if (i.getAmount() >= 18 && i.getAmount() < 27) {
                        i.setAmount(i.getAmount() - 18);
                        p.getInventory().addItem(new ItemStack[]{new ItemStack(Material.DIAMOND_BLOCK, 2)});
                    }

                    if (i.getAmount() >= 27 && i.getAmount() < 36) {
                        i.setAmount(i.getAmount() - 27);
                        p.getInventory().addItem(new ItemStack[]{new ItemStack(Material.DIAMOND_BLOCK, 3)});
                    }

                    if (i.getAmount() >= 36 && i.getAmount() < 45) {
                        i.setAmount(i.getAmount() - 36);
                        p.getInventory().addItem(new ItemStack[]{new ItemStack(Material.DIAMOND_BLOCK, 4)});
                    }

                    if (i.getAmount() >= 45 && i.getAmount() < 54) {
                        i.setAmount(i.getAmount() - 45);
                        p.getInventory().addItem(new ItemStack[]{new ItemStack(Material.DIAMOND_BLOCK, 5)});
                    }

                    if (i.getAmount() >= 54 && i.getAmount() < 63) {
                        i.setAmount(i.getAmount() - 54);
                        p.getInventory().addItem(new ItemStack[]{new ItemStack(Material.DIAMOND_BLOCK, 6)});
                    }

                    if (i.getAmount() >= 63 && i.getAmount() < 64) {
                        i.setAmount(i.getAmount() - 63);
                        p.getInventory().addItem(new ItemStack[]{new ItemStack(Material.DIAMOND_BLOCK, 7)});
                    }

                    if (i.getAmount() == 64) {
                        i.setAmount(i.getAmount() - 63);
                        p.getInventory().addItem(new ItemStack[]{new ItemStack(Material.DIAMOND_BLOCK, 7)});
                    }
                }

                if (i.getType().equals(Material.GOLD_INGOT)) {
                    if (i.getAmount() >= 9 && i.getAmount() < 18) {
                        i.setAmount(i.getAmount() - 9);
                        p.getInventory().addItem(new ItemStack[]{new ItemStack(Material.GOLD_BLOCK, 1)});
                    }

                    if (i.getAmount() >= 18 && i.getAmount() < 27) {
                        i.setAmount(i.getAmount() - 18);
                        p.getInventory().addItem(new ItemStack[]{new ItemStack(Material.GOLD_BLOCK, 2)});
                    }

                    if (i.getAmount() >= 27 && i.getAmount() < 36) {
                        i.setAmount(i.getAmount() - 27);
                        p.getInventory().addItem(new ItemStack[]{new ItemStack(Material.GOLD_BLOCK, 3)});
                    }

                    if (i.getAmount() >= 36 && i.getAmount() < 45) {
                        i.setAmount(i.getAmount() - 36);
                        p.getInventory().addItem(new ItemStack[]{new ItemStack(Material.GOLD_BLOCK, 4)});
                    }

                    if (i.getAmount() >= 45 && i.getAmount() < 54) {
                        i.setAmount(i.getAmount() - 45);
                        p.getInventory().addItem(new ItemStack[]{new ItemStack(Material.GOLD_BLOCK, 5)});
                    }

                    if (i.getAmount() >= 54 && i.getAmount() < 63) {
                        i.setAmount(i.getAmount() - 54);
                        p.getInventory().addItem(new ItemStack[]{new ItemStack(Material.GOLD_BLOCK, 6)});
                    }

                    if (i.getAmount() >= 63 && i.getAmount() < 64) {
                        i.setAmount(i.getAmount() - 63);
                        p.getInventory().addItem(new ItemStack[]{new ItemStack(Material.GOLD_BLOCK, 7)});
                    }

                    if (i.getAmount() == 64) {
                        i.setAmount(i.getAmount() - 63);
                        p.getInventory().addItem(new ItemStack[]{new ItemStack(Material.GOLD_BLOCK, 7)});
                    }
                }

                if (i.getType().equals(Material.COAL)) {
                    if (i.getAmount() >= 9 && i.getAmount() < 18) {
                        i.setAmount(i.getAmount() - 9);
                        p.getInventory().addItem(new ItemStack[]{new ItemStack(Material.COAL_BLOCK, 1)});
                    }

                    if (i.getAmount() >= 18 && i.getAmount() < 27) {
                        i.setAmount(i.getAmount() - 18);
                        p.getInventory().addItem(new ItemStack[]{new ItemStack(Material.COAL_BLOCK, 2)});
                    }

                    if (i.getAmount() >= 27 && i.getAmount() < 36) {
                        i.setAmount(i.getAmount() - 27);
                        p.getInventory().addItem(new ItemStack[]{new ItemStack(Material.COAL_BLOCK, 3)});
                    }

                    if (i.getAmount() >= 36 && i.getAmount() < 45) {
                        i.setAmount(i.getAmount() - 36);
                        p.getInventory().addItem(new ItemStack[]{new ItemStack(Material.COAL_BLOCK, 4)});
                    }

                    if (i.getAmount() >= 45 && i.getAmount() < 54) {
                        i.setAmount(i.getAmount() - 45);
                        p.getInventory().addItem(new ItemStack[]{new ItemStack(Material.COAL_BLOCK, 5)});
                    }

                    if (i.getAmount() >= 54 && i.getAmount() < 63) {
                        i.setAmount(i.getAmount() - 54);
                        p.getInventory().addItem(new ItemStack[]{new ItemStack(Material.COAL_BLOCK, 6)});
                    }

                    if (i.getAmount() >= 63 && i.getAmount() < 64) {
                        i.setAmount(i.getAmount() - 63);
                        p.getInventory().addItem(new ItemStack[]{new ItemStack(Material.COAL_BLOCK, 7)});
                    }

                    if (i.getAmount() == 64) {
                        i.setAmount(i.getAmount() - 63);
                        p.getInventory().addItem(new ItemStack[]{new ItemStack(Material.COAL_BLOCK, 7)});
                    }
                }

                if (i.getType().equals(Material.EMERALD)) {
                    if (i.getAmount() >= 9 && i.getAmount() < 18) {
                        i.setAmount(i.getAmount() - 9);
                        p.getInventory().addItem(new ItemStack[]{new ItemStack(Material.EMERALD_BLOCK, 1)});
                    }

                    if (i.getAmount() >= 18 && i.getAmount() < 27) {
                        i.setAmount(i.getAmount() - 18);
                        p.getInventory().addItem(new ItemStack[]{new ItemStack(Material.EMERALD_BLOCK, 2)});
                    }

                    if (i.getAmount() >= 27 && i.getAmount() < 36) {
                        i.setAmount(i.getAmount() - 27);
                        p.getInventory().addItem(new ItemStack[]{new ItemStack(Material.EMERALD_BLOCK, 3)});
                    }

                    if (i.getAmount() >= 36 && i.getAmount() < 45) {
                        i.setAmount(i.getAmount() - 36);
                        p.getInventory().addItem(new ItemStack[]{new ItemStack(Material.EMERALD_BLOCK, 4)});
                    }

                    if (i.getAmount() >= 45 && i.getAmount() < 54) {
                        i.setAmount(i.getAmount() - 45);
                        p.getInventory().addItem(new ItemStack[]{new ItemStack(Material.EMERALD_BLOCK, 5)});
                    }

                    if (i.getAmount() >= 54 && i.getAmount() < 63) {
                        i.setAmount(i.getAmount() - 54);
                        p.getInventory().addItem(new ItemStack[]{new ItemStack(Material.EMERALD_BLOCK, 6)});
                    }

                    if (i.getAmount() >= 63 && i.getAmount() < 64) {
                        i.setAmount(i.getAmount() - 63);
                        p.getInventory().addItem(new ItemStack[]{new ItemStack(Material.EMERALD_BLOCK, 7)});
                    }

                    if (i.getAmount() == 64) {
                        i.setAmount(i.getAmount() - 63);
                        p.getInventory().addItem(new ItemStack[]{new ItemStack(Material.EMERALD_BLOCK, 7)});
                    }
                }

                if (i.getType().equals(Material.REDSTONE)) {
                    if (i.getAmount() >= 9 && i.getAmount() < 18) {
                        i.setAmount(i.getAmount() - 9);
                        p.getInventory().addItem(new ItemStack[]{new ItemStack(Material.REDSTONE_BLOCK, 1)});
                    }

                    if (i.getAmount() >= 18 && i.getAmount() < 27) {
                        i.setAmount(i.getAmount() - 18);
                        p.getInventory().addItem(new ItemStack[]{new ItemStack(Material.REDSTONE_BLOCK, 2)});
                    }

                    if (i.getAmount() >= 27 && i.getAmount() < 36) {
                        i.setAmount(i.getAmount() - 27);
                        p.getInventory().addItem(new ItemStack[]{new ItemStack(Material.REDSTONE_BLOCK, 3)});
                    }

                    if (i.getAmount() >= 36 && i.getAmount() < 45) {
                        i.setAmount(i.getAmount() - 36);
                        p.getInventory().addItem(new ItemStack[]{new ItemStack(Material.REDSTONE_BLOCK, 4)});
                    }

                    if (i.getAmount() >= 45 && i.getAmount() < 54) {
                        i.setAmount(i.getAmount() - 45);
                        p.getInventory().addItem(new ItemStack[]{new ItemStack(Material.REDSTONE_BLOCK, 5)});
                    }

                    if (i.getAmount() >= 54 && i.getAmount() < 63) {
                        i.setAmount(i.getAmount() - 54);
                        p.getInventory().addItem(new ItemStack[]{new ItemStack(Material.REDSTONE_BLOCK, 6)});
                    }

                    if (i.getAmount() >= 63 && i.getAmount() < 64) {
                        i.setAmount(i.getAmount() - 63);
                        p.getInventory().addItem(new ItemStack[]{new ItemStack(Material.REDSTONE_BLOCK, 7)});
                    }

                    if (i.getAmount() == 64) {
                        i.setAmount(i.getAmount() - 63);
                        p.getInventory().addItem(new ItemStack[]{new ItemStack(Material.REDSTONE_BLOCK, 7)});
                    }
                }

                if (i.equals(new ItemStack(Material.INK_SACK, i.getAmount(), (short) 4))) {
                    if (i.getAmount() >= 9 && i.getAmount() < 18) {
                        i.setAmount(i.getAmount() - 9);
                        p.getInventory().addItem(new ItemStack[]{new ItemStack(Material.LAPIS_BLOCK, 1)});
                    }

                    if (i.getAmount() >= 18 && i.getAmount() < 27) {
                        i.setAmount(i.getAmount() - 18);
                        p.getInventory().addItem(new ItemStack[]{new ItemStack(Material.LAPIS_BLOCK, 2)});
                    }

                    if (i.getAmount() >= 27 && i.getAmount() < 36) {
                        i.setAmount(i.getAmount() - 27);
                        p.getInventory().addItem(new ItemStack[]{new ItemStack(Material.LAPIS_BLOCK, 3)});
                    }

                    if (i.getAmount() >= 36 && i.getAmount() < 45) {
                        i.setAmount(i.getAmount() - 36);
                        p.getInventory().addItem(new ItemStack[]{new ItemStack(Material.LAPIS_BLOCK, 4)});
                    }

                    if (i.getAmount() >= 45 && i.getAmount() < 54) {
                        i.setAmount(i.getAmount() - 45);
                        p.getInventory().addItem(new ItemStack[]{new ItemStack(Material.LAPIS_BLOCK, 5)});
                    }

                    if (i.getAmount() >= 54 && i.getAmount() < 63) {
                        i.setAmount(i.getAmount() - 54);
                        p.getInventory().addItem(new ItemStack[]{new ItemStack(Material.LAPIS_BLOCK, 6)});
                    }

                    if (i.getAmount() >= 63 && i.getAmount() < 64) {
                        i.setAmount(i.getAmount() - 63);
                        p.getInventory().addItem(new ItemStack[]{new ItemStack(Material.LAPIS_BLOCK, 7)});
                    }

                    if (i.getAmount() == 64) {
                        i.setAmount(i.getAmount() - 63);
                        p.getInventory().addItem(new ItemStack[]{new ItemStack(Material.LAPIS_BLOCK, 7)});
                    }
                }

                if (i.getType().equals(Material.QUARTZ)) {
                    if (i.getAmount() >= 9 && i.getAmount() < 18) {
                        i.setAmount(i.getAmount() - 9);
                        p.getInventory().addItem(new ItemStack[]{new ItemStack(Material.QUARTZ_BLOCK, 1)});
                    }

                    if (i.getAmount() >= 18 && i.getAmount() < 27) {
                        i.setAmount(i.getAmount() - 18);
                        p.getInventory().addItem(new ItemStack[]{new ItemStack(Material.QUARTZ_BLOCK, 2)});
                    }

                    if (i.getAmount() >= 27 && i.getAmount() < 36) {
                        i.setAmount(i.getAmount() - 27);
                        p.getInventory().addItem(new ItemStack[]{new ItemStack(Material.QUARTZ_BLOCK, 3)});
                    }

                    if (i.getAmount() >= 36 && i.getAmount() < 45) {
                        i.setAmount(i.getAmount() - 36);
                        p.getInventory().addItem(new ItemStack[]{new ItemStack(Material.QUARTZ_BLOCK, 4)});
                    }

                    if (i.getAmount() >= 45 && i.getAmount() < 54) {
                        i.setAmount(i.getAmount() - 45);
                        p.getInventory().addItem(new ItemStack[]{new ItemStack(Material.QUARTZ_BLOCK, 5)});
                    }

                    if (i.getAmount() >= 54 && i.getAmount() < 63) {
                        i.setAmount(i.getAmount() - 54);
                        p.getInventory().addItem(new ItemStack[]{new ItemStack(Material.QUARTZ_BLOCK, 6)});
                    }

                    if (i.getAmount() >= 63 && i.getAmount() < 64) {
                        i.setAmount(i.getAmount() - 63);
                        p.getInventory().addItem(new ItemStack[]{new ItemStack(Material.QUARTZ_BLOCK, 7)});
                    }

                    if (i.getAmount() == 64) {
                        i.setAmount(i.getAmount() - 63);
                        p.getInventory().addItem(new ItemStack(Material.QUARTZ_BLOCK, 7));
                    }
                    p.sendMessage(MessageManager.PREFIX + "§7Du hast alle §6§lErze §azusammengecraftet§7.");
                }
            }
        }
    }
}
