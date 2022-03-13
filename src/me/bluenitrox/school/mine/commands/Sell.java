package me.bluenitrox.school.mine.commands;

import me.bluenitrox.school.SchoolMode;
import me.bluenitrox.school.aufgabensystem.AufgabenManager;
import me.bluenitrox.school.boost.booster.Gembooster;
import me.bluenitrox.school.managers.MessageManager;
import me.bluenitrox.school.managers.MoneyManager;
import me.bluenitrox.school.managers.PermissionsManager;
import me.bluenitrox.school.managers.PlayerJoinManager;
import me.bluenitrox.school.managers.GemLimitManager;
import me.bluenitrox.school.mine.manager.SellManager;
import me.bluenitrox.school.mine.minensettings.SellOptions;
import me.bluenitrox.school.utils.ItemBuilder;
import me.bluenitrox.school.utils.ValuetoString;
import me.bluenitrox.school.warzone.CombatAPI;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;
import java.util.Objects;
import java.util.UUID;

public class Sell implements CommandExecutor {

    public static HashMap<UUID, Integer> task6 = new HashMap<>();

    public static void onInterAct(Player p) {
        int alles = 0;
        int lapispreis = 0;
        for (int i = 0; i <= p.getInventory().getSize(); i++) {
            if (p.getInventory().getItem(i) != null) {
                HashMap<Material, Boolean> blocks = SellOptions.getInstance().getMinenSellOptions().get(p.getUniqueId());
                if(!blocks.containsKey(p.getInventory().getItem(i).getType())) return;
                if(blocks.get(p.getInventory().getItem(i).getType())) {
                    if (SellManager.Preise.getByName(p.getInventory().getItem(i).getType().toString()) != null) {
                        int amount = p.getInventory().getItem(i).getAmount();
                        float preis = SellManager.getPriceByMaterial(p.getInventory().getItem(i).getType().toString());
                        preis = preis * amount;
                        if (AufgabenManager.getTask(p.getUniqueId()) == 6) {
                            if (p.getInventory().getItem(i).getType() == Material.STONE) {
                                if (amount >= 50) {
                                    AufgabenManager.getPrice(p, 6);
                                } else {
                                    if (task6 != null) {
                                        if (task6.containsKey(p.getUniqueId())) {
                                            int stone = task6.get(p.getUniqueId()) + amount;
                                            if (stone >= 50) {
                                                AufgabenManager.getPrice(p, 6);
                                            } else {
                                                task6.put(p.getUniqueId(), task6.get(p.getUniqueId()) + stone);
                                            }
                                        } else {
                                            task6.put(p.getUniqueId(), amount);
                                        }
                                    }
                                }
                            }
                        }

                        if (preis != 0) {
                            GemLimitManager gemLimit = new GemLimitManager(p.getUniqueId());
                            if (MoneyManager.updateMoney(p.getUniqueId(), preis, false, true, false)) {
                                ItemStack air = new ItemStack(Material.AIR);
                                p.getInventory().setItem(i, air);
                                alles = (int) (alles + preis);
                                preis = 0;
                            }
                        }
                    }
                }
                GemLimitManager gemLimit = new GemLimitManager(p.getUniqueId());
                if(p.getInventory().getItem(i) != null) {
                    if (Objects.equals(p.getInventory().getItem(i), new ItemStack(Material.INK_SACK, p.getInventory().getItem(i).getAmount(), (short) 4))) {
                        lapispreis += SellManager.pricelapis * p.getInventory().getItem(i).getAmount();
                        if(gemLimit.getRestGemLimit() > lapispreis) {
                            ItemStack air = new ItemStack(Material.AIR);
                            p.getInventory().setItem(i, air);
                        }
                    }
                }
            }
        }

        MoneyManager.updateMoney(p.getUniqueId(), lapispreis, false, true, false);
        alles += lapispreis;
        if(alles == 0) {
            p.sendMessage(MessageManager.PREFIX + "§7Ich kann dir derzeit §cleider nichts §7abkaufen.");
            p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1L, 1L);
        }
        else {
            Gembooster money = new Gembooster();
            if (SchoolMode.getInstance().getBoostermanager().getAktivboost().stream().anyMatch((b -> b.getName().equals(money.getName())))) {
                p.playSound(p.getLocation(), Sound.VILLAGER_YES, 1L, 1L);
                p.sendMessage(MessageManager.PREFIX + "§7Du hast §a+§6§l" + ValuetoString.valueToString(alles) + " Gems §7erhalten");
                p.sendMessage(MessageManager.PREFIX + "§a+§6§l" +  ValuetoString.valueToString(alles) + " Gems §8(§6Double-Gem Booster§8)");
            } else {
                p.playSound(p.getLocation(), Sound.VILLAGER_YES, 1L, 1L);
                p.sendMessage(MessageManager.PREFIX + "§7Du hast §a+§6§l" + ValuetoString.valueToString(alles) + " Gems §7erhalten");
            }
        }
    }

    @Override
    public boolean onCommand(CommandSender cs, Command c, String s, String[] args) {
        if (!(cs instanceof Player)) {
            cs.sendMessage(MessageManager.NOPLAYER);
            return true;
        }


        Player p = (Player) cs;
        if (!p.hasPermission(PermissionsManager.python) || !p.hasPermission(PermissionsManager.ALLPERMS)) {
            p.sendMessage(MessageManager.NOPERMISSIONS(PlayerJoinManager.language));
            return true;
        }

        if(CombatAPI.fight != null) {
            if (CombatAPI.fight.containsKey(p)) {
                p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1L, 1L);
                p.sendMessage(MessageManager.CANTDOINFIGHT);
                return true;
            }
        }

        if (args.length == 0) {
            HashMap<Material, Boolean> blocks = SellOptions.getInstance().getMinenSellOptions().get(p.getUniqueId());
            int alles = 0;
            int lapispreis = 0;
            for (int i = 0; i <= p.getInventory().getSize(); i++) {
                if (p.getInventory().getItem(i) != null) {
                    if(!blocks.containsKey(p.getInventory().getItem(i).getType())) return true;
                    if(blocks.get(p.getInventory().getItem(i).getType())) {
                        if (SellManager.Preise.getByName(p.getInventory().getItem(i).getType().toString()) != null) {
                            int amount = p.getInventory().getItem(i).getAmount();
                            float preis = SellManager.getPriceByMaterial(p.getInventory().getItem(i).getType().toString());
                            preis = preis * amount;

                        if (AufgabenManager.getTask(p.getUniqueId()) == 6) {
                            if (p.getInventory().getItem(i).getType() == Material.STONE) {
                                if (amount >= 50) {
                                    AufgabenManager.getPrice(p, 6);
                                } else {
                                    if (task6 != null) {
                                        if (task6.containsKey(p.getUniqueId())) {
                                            int stone = task6.get(p.getUniqueId()) + amount;
                                            if (stone >= 50) {
                                                AufgabenManager.getPrice(p, 6);
                                            } else {
                                                task6.put(p.getUniqueId(), task6.get(p.getUniqueId()) + stone);
                                            }
                                        } else {
                                            task6.put(p.getUniqueId(), amount);
                                        }
                                    }
                                }
                            }
                        }
                        if (preis != 0) {
                            if (MoneyManager.updateMoney(p.getUniqueId(), preis, false, true, false)) {
                                ItemStack air = new ItemStack(Material.AIR);
                                p.getInventory().setItem(i, air);
                                alles = (int) (alles + preis);
                                preis = 0;
                            }
                        }
                    }
                    }
                    if(p.getInventory().getItem(i) != null) {
                        if (Objects.equals(p.getInventory().getItem(i), new ItemStack(Material.INK_SACK, p.getInventory().getItem(i).getAmount(), (short) 4))) {
                            if (blocks.get(Material.INK_SACK)) {
                                lapispreis += SellManager.pricelapis * p.getInventory().getItem(i).getAmount();
                                ItemStack air = new ItemStack(Material.AIR);
                                p.getInventory().setItem(i, air);
                            }
                        }
                    }
                }
            }
            MoneyManager.updateMoney(p.getUniqueId(), lapispreis, false, true, false);
            alles += lapispreis;
            if(alles == 0) {
                p.sendMessage(MessageManager.PREFIX + "§7Du hast §ckeine §7verkaufbaren Items im Inventar");
                p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1L, 1L);
            }else {
                Gembooster money = new Gembooster();
                if (SchoolMode.getInstance().getBoostermanager().getAktivboost().stream().anyMatch((b -> b.getName().equals(money.getName())))) {
                    p.playSound(p.getLocation(), Sound.VILLAGER_YES, 1L, 1L);
                    p.sendMessage(MessageManager.PREFIX + "§7Du hast §a+" + ValuetoString.valueToString(alles*2) + " Gems §7bekommen");
                    return true;
                }
                p.playSound(p.getLocation(), Sound.VILLAGER_YES, 1L, 1L);
                p.sendMessage(MessageManager.PREFIX + "§7Du hast §a+" + ValuetoString.valueToString(alles) + " Gems §7bekommen");
            }
        } else {
            p.sendMessage(MessageManager.PREFIX + "§7Benutze §6/sell§7!");
        }
        return false;
    }
}
