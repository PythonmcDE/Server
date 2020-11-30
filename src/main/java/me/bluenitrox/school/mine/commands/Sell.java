package me.bluenitrox.school.mine.commands;

import me.bluenitrox.school.SchoolMode;
import me.bluenitrox.school.managers.MessageManager;
import me.bluenitrox.school.managers.MoneyManager;
import me.bluenitrox.school.managers.PermissionsManager;
import me.bluenitrox.school.managers.PlayerJoinManager;
import me.bluenitrox.school.mine.manager.SellManager;
import me.bluenitrox.school.utils.ValuetoString;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Sell implements CommandExecutor {

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

        if (args.length == 0) {
            long total = 0;
            for (int i = 0; i <= p.getInventory().getSize(); i++) {
                if (p.getInventory().getItem(i) != null) {
                    if (SellManager.Preise.getByName(p.getInventory().getItem(i).getType().toString()) != null) {
                        int amount = p.getInventory().getItem(i).getAmount();
                        float preis = SellManager.getPriceByMaterial(p.getInventory().getItem(i).getType().toString(), p);
                        preis = preis * amount;
                        total += preis;
                        p.getInventory().removeItem(p.getInventory().getItem(i));
                    }
                }
            }
            if(total == 0) {
                p.sendMessage(MessageManager.PREFIX + "§7Du hast §ckeine §7verkaufbaren Items im Inventar");
                p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1L, 1L);
            }else {
                p.playSound(p.getLocation(), Sound.VILLAGER_YES, 1L, 1L);
                p.sendMessage(MessageManager.PREFIX + "§7Du hast §a+" + ValuetoString.valueToString(total) + " §7bekommen");
                MoneyManager.updateMoney(p.getUniqueId(), total, false, true);
            }
        }
        return false;
    }
}
