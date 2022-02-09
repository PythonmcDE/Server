package me.bluenitrox.school.mine.commands;

import me.bluenitrox.school.SchoolMode;
import me.bluenitrox.school.aufgabensystem.AufgabenManager;
import me.bluenitrox.school.boost.Moneybooster;
import me.bluenitrox.school.managers.MessageManager;
import me.bluenitrox.school.managers.MoneyManager;
import me.bluenitrox.school.managers.PermissionsManager;
import me.bluenitrox.school.managers.PlayerJoinManager;
import me.bluenitrox.school.mine.manager.SellManager;
import me.bluenitrox.school.utils.ValuetoString;
import me.bluenitrox.school.warzone.CombatAPI;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;
import java.util.UUID;

public class Sell implements CommandExecutor {

    public HashMap<UUID, Integer> task6 = new HashMap<>();

    @Override
    public boolean onCommand(CommandSender cs, Command c, String s, String[] args) {
        if (!(cs instanceof Player)) {
            cs.sendMessage(MessageManager.NOPLAYER);
            return true;
        }


        Player p = (Player) cs;
        if (!p.hasPermission(PermissionsManager.SELL) || !p.hasPermission(PermissionsManager.ALLPERMS)) {
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
            int alles = 0;
            for (int i = 0; i <= p.getInventory().getSize(); i++) {
                if (p.getInventory().getItem(i) != null) {
                    if (SellManager.Preise.getByName(p.getInventory().getItem(i).getType().toString()) != null) {
                        int amount = p.getInventory().getItem(i).getAmount();
                        float preis = SellManager.getPriceByMaterial(p.getInventory().getItem(i).getType().toString(), p);
                        preis = preis*amount;
                        if(AufgabenManager.getTask(p.getUniqueId()) == 6) {
                            if(p.getInventory().getItem(i).getType() == Material.STONE) {
                                if(amount >= 50) {
                                    AufgabenManager.getPrice(p, 6);
                                } else {
                                    if(task6 != null) {
                                        if(task6.containsKey(p.getUniqueId())) {
                                            int stone = task6.get(p.getUniqueId()) + amount;
                                            if(stone >= 50) {
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
                        if(preis != 0) {
                            if (MoneyManager.updateMoney(p.getUniqueId(), preis, false, true, false)) {
                                ItemStack air = new ItemStack(Material.AIR);
                                p.getInventory().setItem(i,air);
                                alles = (int) (alles + preis);
                                preis = 0;
                            }
                        }
                    }
                }
            }
            if(alles == 0) {
                p.sendMessage(MessageManager.PREFIX + "§7Du hast §ckeine §7verkaufbaren Items im Inventar");
                p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1L, 1L);
            }else {
                Moneybooster money = new Moneybooster();
                if (SchoolMode.getInstance().getBoostermanager().getAktivboost().stream().anyMatch((b -> b.getName().equals(money.getName())))) {
                    p.playSound(p.getLocation(), Sound.VILLAGER_YES, 1L, 1L);
                    p.sendMessage(MessageManager.PREFIX + "§7Du hast §a+" + ValuetoString.valueToString(alles*2) + " §7bekommen");
                    return true;
                }
                p.playSound(p.getLocation(), Sound.VILLAGER_YES, 1L, 1L);
                p.sendMessage(MessageManager.PREFIX + "§7Du hast §a+" + ValuetoString.valueToString(alles) + " §7bekommen");
            }
        }
        return false;
    }
}
