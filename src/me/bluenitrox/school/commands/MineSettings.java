package me.bluenitrox.school.commands;

import me.bluenitrox.school.mine.manager.MinenSettings;
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

import java.util.HashMap;
import java.util.UUID;

public class MineSettings implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {

        if(!(commandSender instanceof Player)) return true;

        Player player = (Player) commandSender;
        UUID uuid = player.getUniqueId();
        player.openInventory(inventory(uuid));

        return false;
    }

    /*
    creating own InventoryClickEvent. registering in main InventoryClickEvent Class
     */
    public void onInventoryClick(InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked();
        UUID uuid = player.getUniqueId();
        HashMap<Material, Boolean> value = MinenSettings.getMiningSettings().getMinenSettings().get(uuid);
        if(event.getClickedInventory() != null && event.getCurrentItem() != null) {
            if(!event.getClickedInventory().getName().equalsIgnoreCase("§8» §6§lMineneinstellungen")) return;
            event.setCancelled(true);
            switch (event.getCurrentItem().getType()) {
                case STONE:
                    Material stone = Material.STONE;
                    if(value.get(stone)) {
                        value.replace(stone, false);
                        event.setCurrentItem(stoneDeactivated);
                    } else {
                        value.replace(stone, true);
                        event.setCurrentItem(stoneActive);
                    }
                    break;
                case GRAVEL:
                    Material material = Material.GRAVEL;
                    if(value.get(material)) {
                        value.replace(material, false);
                        event.setCurrentItem(gravilDeactivated);
                    } else {
                        value.replace(material, true);
                        event.setCurrentItem(gravilActive);
                    }
                    break;
                case COAL_ORE:
                    Material coalOre = Material.COAL_ORE;
                    if(value.get(coalOre)) {
                        value.replace(coalOre, false);
                        event.setCurrentItem(coalDeactivated);
                    } else {
                        value.replace(coalOre, true);
                        event.setCurrentItem(coalActive);
                    }
                    break;
                case BRICK:
                    Material brick = Material.BRICK;
                    if(value.get(brick)) {
                        value.replace(brick, false);
                        event.setCurrentItem(brickDeactivated);
                    } else {
                        value.replace(brick, true);
                        event.setCurrentItem(brickActive);
                    }
                    break;
                case IRON_ORE:
                    Material ironOre = Material.IRON_ORE;
                    if(value.get(ironOre)) {
                        value.replace(ironOre, false);
                        event.setCurrentItem(ironDeactivated);
                    } else {
                        value.replace(ironOre, true);
                        event.setCurrentItem(ironActive);
                    }
                    break;
                case QUARTZ_ORE:
                    Material quartzOre = Material.QUARTZ_ORE;
                    if(value.get(quartzOre)) {
                        value.replace(quartzOre, false);
                        event.setCurrentItem(quarzDeactivated);
                    } else {
                        value.replace(quartzOre, true);
                        event.setCurrentItem(quarzActive);
                    }
                    break;
                case REDSTONE_ORE:
                    Material redstoneOre = Material.REDSTONE_ORE;
                    if(value.get(redstoneOre)) {
                        value.replace(redstoneOre, false);
                        event.setCurrentItem(redstoneDeactivated);
                    } else {
                        value.replace(redstoneOre, true);
                        event.setCurrentItem(redstoneActive);
                    }
                    break;
                case LAPIS_ORE:
                    Material lapisOre = Material.LAPIS_ORE;
                    if(value.get(lapisOre)) {
                        value.replace(lapisOre, false);
                        event.setCurrentItem(lapisDeactivated);
                    } else {
                        value.replace(lapisOre, true);
                        event.setCurrentItem(lapisActive);
                    }
                    break;
                case PRISMARINE:
                    Material prismarin = Material.PRISMARINE;
                    if(value.get(prismarin)) {
                        value.replace(prismarin, false);
                        event.setCurrentItem(prismarinDeactivated);
                    } else {
                        value.replace(prismarin, true);
                        event.setCurrentItem(prismarinActive);
                    }
                    break;
                case GOLD_ORE:
                    Material goldOre = Material.GOLD_ORE;
                    if(value.get(goldOre)) {
                        value.replace(goldOre, false);
                        event.setCurrentItem(goldDeactivated);
                    } else {
                        value.replace(goldOre, true);
                        event.setCurrentItem(goldActive);
                    }
                    break;
                case DIAMOND_ORE:
                    Material diamondOre = Material.DIAMOND_ORE;
                    if(value.get(diamondOre)) {
                        value.replace(diamondOre, false);
                        event.setCurrentItem(diamondActive);
                    } else {
                        value.replace(diamondOre, true);
                        event.setCurrentItem(diamondDeactivated);
                    }
                    break;
                case NETHER_BRICK:
                    Material netherbrick = Material.NETHER_BRICK;
                    if(value.get(netherbrick)) {
                        value.replace(netherbrick, false);
                        event.setCurrentItem(netherbrickDeactivated);
                    } else {
                        value.replace(netherbrick, true);
                        event.setCurrentItem(netherbrickActive);
                    }
                    break;
                case EMERALD_ORE:
                    Material emeraldOre = Material.EMERALD_ORE;
                    if(value.get(emeraldOre)) {
                        value.replace(emeraldOre, false);
                        event.setCurrentItem(emeraldDeactivated);
                    } else {
                        value.replace(emeraldOre, true);
                        event.setCurrentItem(emeraldActive);
                    }
                    break;
                case COAL_BLOCK:
                    Material coalBlock = Material.COAL_BLOCK;
                    if(value.get(coalBlock)) {
                        value.replace(coalBlock, false);
                        event.setCurrentItem(coalblockDeactivated);
                    } else {
                        value.replace(coalBlock, true);
                        event.setCurrentItem(coalblockActive);
                    }
                    break;
                case RED_SANDSTONE:
                    Material sandStone = Material.RED_SANDSTONE;
                    if(value.get(sandStone)) {
                        value.replace(sandStone, false);
                        event.setCurrentItem(sandstoneDeactivated);
                    } else {
                        value.replace(sandStone, true);
                        event.setCurrentItem(sandstoneActive);
                    }
                    break;
                case QUARTZ_BLOCK:
                    Material quartzBlock = Material.QUARTZ_BLOCK;
                    if(value.get(quartzBlock)) {
                        value.replace(quartzBlock, false);
                        event.setCurrentItem(quarzblockDeactivated);
                    } else {
                        value.replace(quartzBlock, true);
                        event.setCurrentItem(quarzblockActive);
                    }
                    break;
                case ICE:
                    Material ice = Material.ICE;
                    if(value.get(ice)) {
                        value.replace(ice, false);
                        event.setCurrentItem(iceDeactivated);
                    } else {
                        value.replace(ice, true);
                        event.setCurrentItem(iceActive);
                    }
                    break;
                case NETHERRACK:
                    Material netherrack = Material.NETHERRACK;
                    if(value.get(netherrack)) {
                        value.replace(netherrack, false);
                        event.setCurrentItem(netherrackDeactivated);
                    } else {
                        value.replace(netherrack, true);
                        event.setCurrentItem(netherrackDeactivated);
                    }
                    break;
                case IRON_BLOCK:
                    Material ironblock = Material.IRON_BLOCK;
                    if(value.get(ironblock)) {
                        value.replace(ironblock, false);
                        event.setCurrentItem(ironblockDeactivated);
                    } else {
                        value.replace(ironblock, true);
                        event.setCurrentItem(ironblockActive);
                    }
                    break;
                case PACKED_ICE:
                    Material packeis = Material.PACKED_ICE;
                    if(value.get(packeis)) {
                        value.replace(packeis, false);
                        event.setCurrentItem(packediceDeactivated);
                    } else {
                        value.replace(packeis, true);
                        event.setCurrentItem(packediceActive);
                    }
                    break;
                case SEA_LANTERN:
                    Material seaLantern = Material.SEA_LANTERN;
                    if(value.get(seaLantern)) {
                        value.replace(seaLantern, false);
                        event.setCurrentItem(sealaternDeactivated);
                    } else {
                        value.replace(seaLantern, true);
                        event.setCurrentItem(sealaternActive);
                    }
                    break;
                case ENDER_STONE:
                    Material endstone = Material.ENDER_STONE;
                    if(value.get(endstone)) {
                        value.replace(endstone, false);
                        event.setCurrentItem(endstoneDeactivated);
                    } else {
                        value.replace(endstone, true);
                        event.setCurrentItem(endstoneActive);
                    }
                    break;
                case REDSTONE_BLOCK:
                    Material redstoneBlock = Material.REDSTONE_BLOCK;
                    if(value.get(redstoneBlock)) {
                        value.replace(redstoneBlock, false);
                        event.setCurrentItem(redstoneblockDeactivated);
                    } else {
                        value.replace(redstoneBlock, true);
                        event.setCurrentItem(redstoneblockActive);
                    }
                    break;
                case LAPIS_BLOCK:
                    Material lapisBlock = Material.LAPIS_BLOCK;
                    if(value.get(lapisBlock)) {
                        value.replace(lapisBlock, false);
                        event.setCurrentItem(lapisblockDeactivated);
                    } else {
                        value.replace(lapisBlock, true);
                        event.setCurrentItem(lapisblockActive);
                    }
                    break;
                case GOLD_BLOCK:
                    Material goldBlock = Material.GOLD_BLOCK;
                    if(value.get(goldBlock)) {
                        value.replace(goldBlock, false);
                        event.setCurrentItem(goldblockDeactivated);
                    } else {
                        value.replace(goldBlock, true);
                        event.setCurrentItem(goldblockActive);
                    }
                    break;
                case DIAMOND_BLOCK:
                    Material diablock = Material.DIAMOND_BLOCK;
                    if(value.get(diablock)) {
                        value.replace(diablock, false);
                        event.setCurrentItem(diamantblockDeactivated);
                    } else {
                        value.replace(diablock, true);
                        event.setCurrentItem(diamantblockActive);
                    }
                    break;
                case EMERALD_BLOCK:
                    Material emeraldblock = Material.EMERALD_BLOCK;
                    if(value.get(emeraldblock)) {
                        value.replace(emeraldblock, false);
                        event.setCurrentItem(emeraldblockDeactivated);
                    } else {
                        value.replace(emeraldblock, true);
                        event.setCurrentItem(emeraldblockActive);
                    }
                    break;
            }
        }
    }

    /*
    create Inventory, open it above
     */
    private Inventory inventory(UUID uuid) {
        String guiname = "§8» §6§lMineneinstellungen";

        Inventory inventory = Bukkit.createInventory(null, 9*5, guiname);

        HashMap<Material, Boolean> value = MinenSettings.getMiningSettings().getMinenSettings().get(uuid);

        for(int i = 0; i <= 8; i++){
            inventory.setItem(i, glass);
        }
        for(int i = 36; i <= 44; i++){
            inventory.setItem(i, glass);
        }
        inventory.setItem(4, sign);

        if(value.get(Material.STONE)) {
            inventory.setItem(9, stoneActive);
        } else {
            inventory.setItem(9, stoneDeactivated);
        }

        if(value.get(Material.GRAVEL)) {
            inventory.setItem(10, gravilActive);
        } else {
            inventory.setItem(10, gravilDeactivated);
        }

        if(value.get(Material.COAL_ORE)) {
            inventory.setItem(11, coalActive);
        } else {
            inventory.setItem(11, coalDeactivated);
        }

        if(value.get(Material.BRICK)) {
            inventory.setItem(12, brickActive);
        } else {
            inventory.setItem(12, brickDeactivated);
        }

        if(value.get(Material.IRON_ORE)) {
            inventory.setItem(13, ironActive);
        } else {
            inventory.setItem(13, ironDeactivated);
        }

        if(value.get(Material.QUARTZ_ORE)) {
            inventory.setItem(14, quarzActive);
        } else {
            inventory.setItem(14, quarzDeactivated);
        }

        if(value.get(Material.REDSTONE_ORE)) {
            inventory.setItem(15, redstoneActive);
        } else {
            inventory.setItem(15, redstoneDeactivated);
        }

        if(value.get(Material.LAPIS_ORE)) {
            inventory.setItem(16, lapisActive);
        } else {
            inventory.setItem(16, lapisDeactivated);
        }

        if(value.get(Material.PRISMARINE)) {
            inventory.setItem(17, prismarinActive);
        } else {
            inventory.setItem(17, prismarinDeactivated);
        }

        if(value.get(Material.GOLD_ORE)) {
            inventory.setItem(18, goldActive);
        } else {
            inventory.setItem(18, goldDeactivated);
        }

        if(value.get(Material.DIAMOND_ORE)) {
            inventory.setItem(19, diamondActive);
        } else {
            inventory.setItem(19, diamondDeactivated);
        }

        if(value.get(Material.NETHER_BRICK)) {
            inventory.setItem(20, netherbrickActive);
        } else {
            inventory.setItem(20, netherbrickDeactivated);
        }

        if(value.get(Material.EMERALD_ORE)) {
            inventory.setItem(21, emeraldActive);
        } else {
            inventory.setItem(21, emeraldDeactivated);
        }

        if(value.get(Material.COAL_BLOCK)) {
            inventory.setItem(22, coalblockActive);
        } else {
            inventory.setItem(22, coalblockDeactivated);
        }

        if(value.get(Material.RED_SANDSTONE)) {
            inventory.setItem(23, sandstoneActive);
        } else {
            inventory.setItem(23, sandstoneDeactivated);
        }

        if(value.get(Material.QUARTZ_BLOCK)) {
            inventory.setItem(24, quarzblockActive);
        } else {
            inventory.setItem(24, quarzblockDeactivated);
        }

        if(value.get(Material.ICE)) {
            inventory.setItem(25, iceActive);
        } else {
            inventory.setItem(25, iceDeactivated);
        }

        if(value.get(Material.NETHERRACK)) {
            inventory.setItem(26, netherrackActive);
        } else {
            inventory.setItem(26, netherrackDeactivated);
        }

        if(value.get(Material.IRON_BLOCK)) {
            inventory.setItem(27, ironblockActive);
        } else {
            inventory.setItem(27, ironblockDeactivated);
        }

        if(value.get(Material.PACKED_ICE)) {
            inventory.setItem(28, packediceActive);
        } else {
            inventory.setItem(28, packediceDeactivated);
        }

        if(value.get(Material.SEA_LANTERN)) {
            inventory.setItem(29, sealaternActive);
        } else {
            inventory.setItem(29, sealaternActive);
        }

        if(value.get(Material.ENDER_STONE)) {
            inventory.setItem(30, endstoneActive);
        } else {
            inventory.setItem(30, endstoneDeactivated);
        }

        if(value.get(Material.REDSTONE_BLOCK)) {
            inventory.setItem(31, redstoneblockActive);
        } else {
            inventory.setItem(31, redstoneblockDeactivated);
        }

        if(value.get(Material.LAPIS_BLOCK)) {
            inventory.setItem(32, lapisblockActive);
        } else {
            inventory.setItem(32, lapisblockDeactivated);
        }

        if(value.get(Material.GOLD_BLOCK)) {
            inventory.setItem(33, goldblockActive);
        } else {
            inventory.setItem(33, goldblockDeactivated);
        }

        if(value.get(Material.DIAMOND_BLOCK)) {
            inventory.setItem(34, diamantblockActive);
        } else {
            inventory.setItem(34, diamantblockDeactivated);
        }

        if(value.get(Material.EMERALD_BLOCK)) {
            inventory.setItem(35, emeraldblockActive);
        } else {
            inventory.setItem(35, emeraldblockDeactivated);
        }


        /*
        returning the Inventory
         */
        return inventory;
    }

    /*
        create Inventory Items
         */
    String doppelPfeil = "§8» ";
    String statusActive = "§a§laktiviert";
    String statusDeactivated = "§c§ldeaktiviert";

    ItemStack glass = new ItemBuilder(Material.STAINED_GLASS_PANE).setDisplayname(" ").build();
    ItemStack glassBlack = new ItemBuilder(Material.STAINED_GLASS_PANE,(short) 15).setDisplayname(" ").build();

    ItemStack sign = new ItemBuilder(Material.SIGN).setDisplayname("§8§l» §6§lMinensettings").setLore("§6§l▶ §7Hier kannst du auswählen, welche","§6§l▶ §&§lItems §7du beim abbauen von Blöcken","§6§l▶ §7in der §6§lMine §7erhälst.").build();

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

    //Diamond
    ItemStack diamondActive = new ItemBuilder(Material.DIAMOND_ORE).setDisplayname("§7Diamant").addEnchant(Enchantment.ARROW_INFINITE, 10, false).setLore(doppelPfeil + "§7Derzeitiger Status: " + statusActive).build();
    ItemStack diamondDeactivated = new ItemBuilder(Material.DIAMOND_ORE).setDisplayname("§7Diamant").setLore(doppelPfeil + "§7Derzeitiger Status: " + statusDeactivated).build();

    //Netherbricks
    ItemStack netherbrickActive = new ItemBuilder(Material.NETHER_BRICK).setDisplayname("§7Netherziegel").addEnchant(Enchantment.ARROW_INFINITE, 10, false).setLore(doppelPfeil + "§7Derzeitiger Status: " + statusActive).build();
    ItemStack netherbrickDeactivated = new ItemBuilder(Material.NETHER_BRICK).setDisplayname("§7Netherziegel").setLore(doppelPfeil + "§7Derzeitiger Status: " + statusDeactivated).build();

    //emerald
    ItemStack emeraldActive = new ItemBuilder(Material.EMERALD_ORE).setDisplayname("§7Smaragd").addEnchant(Enchantment.ARROW_INFINITE, 10, false).setLore(doppelPfeil + "§7Derzeitiger Status: " + statusActive).build();
    ItemStack emeraldDeactivated = new ItemBuilder(Material.EMERALD_ORE).setDisplayname("§7Smaragd").setLore(doppelPfeil + "§7Derzeitiger Status: " + statusDeactivated).build();

    //coalblock
    ItemStack coalblockActive = new ItemBuilder(Material.COAL_BLOCK).setDisplayname("§7Kohleblock").addEnchant(Enchantment.ARROW_INFINITE, 10, false).setLore(doppelPfeil + "§7Derzeitiger Status: " + statusActive).build();
    ItemStack coalblockDeactivated = new ItemBuilder(Material.COAL_BLOCK).setDisplayname("§7Kohleblock").setLore(doppelPfeil + "§7Derzeitiger Status: " + statusDeactivated).build();

    //sandstone
    ItemStack sandstoneActive = new ItemBuilder(Material.RED_SANDSTONE).setDisplayname("§7roter Sandstein").addEnchant(Enchantment.ARROW_INFINITE, 10, false).setLore(doppelPfeil + "§7Derzeitiger Status: " + statusActive).build();
    ItemStack sandstoneDeactivated = new ItemBuilder(Material.RED_SANDSTONE).setDisplayname("§7roter Sandstein").setLore(doppelPfeil + "§7Derzeitiger Status: " + statusDeactivated).build();

    //quarzblock
    ItemStack quarzblockActive = new ItemBuilder(Material.QUARTZ_BLOCK).setDisplayname("§7Quarzblock").addEnchant(Enchantment.ARROW_INFINITE, 10, false).setLore(doppelPfeil + "§7Derzeitiger Status: " + statusActive).build();
    ItemStack quarzblockDeactivated = new ItemBuilder(Material.QUARTZ_BLOCK).setDisplayname("§7Quarzblock").setLore(doppelPfeil + "§7Derzeitiger Status: " + statusDeactivated).build();

    //ice
    ItemStack iceActive = new ItemBuilder(Material.ICE).setDisplayname("§7Eis").addEnchant(Enchantment.ARROW_INFINITE, 10, false).setLore(doppelPfeil + "§7Derzeitiger Status: " + statusActive).build();
    ItemStack iceDeactivated = new ItemBuilder(Material.ICE).setDisplayname("§7Eis").setLore(doppelPfeil + "§7Derzeitiger Status: " + statusDeactivated).build();

    //netherrack
    ItemStack netherrackActive = new ItemBuilder(Material.NETHERRACK).setDisplayname("§7Netherstein").addEnchant(Enchantment.ARROW_INFINITE, 10, false).setLore(doppelPfeil + "§7Derzeitiger Status: " + statusActive).build();
    ItemStack netherrackDeactivated = new ItemBuilder(Material.NETHERRACK).setDisplayname("§7Netherstein").setLore(doppelPfeil + "§7Derzeitiger Status: " + statusDeactivated).build();

    //ironblock
    ItemStack ironblockActive = new ItemBuilder(Material.IRON_BLOCK).setDisplayname("§7Eisenblock").addEnchant(Enchantment.ARROW_INFINITE, 10, false).setLore(doppelPfeil + "§7Derzeitiger Status: " + statusActive).build();
    ItemStack ironblockDeactivated = new ItemBuilder(Material.IRON_BLOCK).setDisplayname("§7Eisenblock").setLore(doppelPfeil + "§7Derzeitiger Status: " + statusDeactivated).build();

    //packedice
    ItemStack packediceActive = new ItemBuilder(Material.PACKED_ICE).setDisplayname("§7Packeis").addEnchant(Enchantment.ARROW_INFINITE, 10, false).setLore(doppelPfeil + "§7Derzeitiger Status: " + statusActive).build();
    ItemStack packediceDeactivated = new ItemBuilder(Material.PACKED_ICE).setDisplayname("§7Packeis").setLore(doppelPfeil + "§7Derzeitiger Status: " + statusDeactivated).build();

    //sealatern
    ItemStack sealaternActive = new ItemBuilder(Material.SEA_LANTERN).setDisplayname("§7Seelaterne").addEnchant(Enchantment.ARROW_INFINITE, 10, false).setLore(doppelPfeil + "§7Derzeitiger Status: " + statusActive).build();
    ItemStack sealaternDeactivated = new ItemBuilder(Material.SEA_LANTERN).setDisplayname("§7Seelaterne").setLore(doppelPfeil + "§7Derzeitiger Status: " + statusDeactivated).build();

    //endstone
    ItemStack endstoneActive = new ItemBuilder(Material.ENDER_STONE).setDisplayname("§7Endstein").addEnchant(Enchantment.ARROW_INFINITE, 10, false).setLore(doppelPfeil + "§7Derzeitiger Status: " + statusActive).build();
    ItemStack endstoneDeactivated = new ItemBuilder(Material.ENDER_STONE).setDisplayname("§7Endstein").setLore(doppelPfeil + "§7Derzeitiger Status: " + statusDeactivated).build();

    //redstoneblock
    ItemStack redstoneblockActive = new ItemBuilder(Material.REDSTONE_BLOCK).setDisplayname("§7Redstoneblock").addEnchant(Enchantment.ARROW_INFINITE, 10, false).setLore(doppelPfeil + "§7Derzeitiger Status: " + statusActive).build();
    ItemStack redstoneblockDeactivated = new ItemBuilder(Material.REDSTONE_BLOCK).setDisplayname("§7Redstoneblock").setLore(doppelPfeil + "§7Derzeitiger Status: " + statusDeactivated).build();

    //lapisblock
    ItemStack lapisblockActive = new ItemBuilder(Material.LAPIS_BLOCK).setDisplayname("§7Lapisblock").addEnchant(Enchantment.ARROW_INFINITE, 10, false).setLore(doppelPfeil + "§7Derzeitiger Status: " + statusActive).build();
    ItemStack lapisblockDeactivated = new ItemBuilder(Material.LAPIS_BLOCK).setDisplayname("§7Lapisblock").setLore(doppelPfeil + "§7Derzeitiger Status: " + statusDeactivated).build();

    //goldblock
    ItemStack goldblockActive = new ItemBuilder(Material.GOLD_BLOCK).setDisplayname("§7Goldblock").addEnchant(Enchantment.ARROW_INFINITE, 10, false).setLore(doppelPfeil + "§7Derzeitiger Status: " + statusActive).build();
    ItemStack goldblockDeactivated = new ItemBuilder(Material.GOLD_BLOCK).setDisplayname("§7Goldblock").setLore(doppelPfeil + "§7Derzeitiger Status: " + statusDeactivated).build();

    //diamantblock
    ItemStack diamantblockActive = new ItemBuilder(Material.DIAMOND_BLOCK).setDisplayname("§7Diamantblock").addEnchant(Enchantment.ARROW_INFINITE, 10, false).setLore(doppelPfeil + "§7Derzeitiger Status: " + statusActive).build();
    ItemStack diamantblockDeactivated = new ItemBuilder(Material.DIAMOND_BLOCK).setDisplayname("§7Diamantblock").setLore(doppelPfeil + "§7Derzeitiger Status: " + statusDeactivated).build();

    //emeraldblock
    ItemStack emeraldblockActive = new ItemBuilder(Material.EMERALD_BLOCK).setDisplayname("§7Smaragdblock").addEnchant(Enchantment.ARROW_INFINITE, 10, false).setLore(doppelPfeil + "§7Derzeitiger Status: " + statusActive).build();
    ItemStack emeraldblockDeactivated = new ItemBuilder(Material.EMERALD_BLOCK).setDisplayname("§7Smaragdblock").setLore(doppelPfeil + "§7Derzeitiger Status: " + statusDeactivated).build();
}
