package me.bluenitrox.school.commands;

import me.bluenitrox.school.managers.MessageManager;
import me.bluenitrox.school.managers.PlayerJoinManager;
import me.bluenitrox.school.utils.ItemBuilder;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GetLeveledBooks implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender cs, Command command, String s, String[] args) {
        Player p = (Player)cs;
        /*
        /getbooks [Type] [Verzauberung] [Level]
        Type:
        1 Schwert
        2 Rüssi
        3 Picken & co
        4 alles andere
         */
        if(args.length == 3){
            int type = Integer.parseInt(args[0]);
            String enchant = args[1];
            int level = Integer.parseInt(args[2]);

            if(type == 1){
                p.getInventory().addItem(new ItemBuilder(Material.ENCHANTED_BOOK).setDisplayname("§8» §6§lMagisches Buch").setLore("§c§l" + enchant + " " + getLevelByNumber(level)).build());
            }else if(type == 2){
                p.getInventory().addItem(new ItemBuilder(Material.ENCHANTED_BOOK).setDisplayname("§8» §6§lMagisches Buch").setLore("§a§l" + enchant + " "+ getLevelByNumber(level)).build());
            }else if(type == 3){
                p.getInventory().addItem(new ItemBuilder(Material.ENCHANTED_BOOK).setDisplayname("§8» §6§lMagisches Buch").setLore("§6§l" + enchant + " "+ getLevelByNumber(level)).build());
            }else if(type == 4){
                p.getInventory().addItem(new ItemBuilder(Material.ENCHANTED_BOOK).setDisplayname("§8» §6§lMagisches Buch").setLore("§f§l" + enchant+ " "+ getLevelByNumber(level)).build());
            }else {
                p.sendMessage(MessageManager.PREFIX + "        /getbooks [Type] [Verzauberung] [Level]\n" +
                        "        Type:\n" +
                        "        1 Schwert\n" +
                        "        2 Rüssi\n" +
                        "        3 Picken & co\n" +
                        "        4 alles andere");
            }
        }else {
            p.sendMessage(MessageManager.FALSECOMMAND(PlayerJoinManager.language));
            return true;
        }
        return false;
    }

    private String getLevelByNumber(int i){
        if(i == 1){
            return "I";
        }else if(i == 2){
            return "II";
        }else if(i == 3){
            return "III";
        }else if(i == 4){
            return "IV";
        }else if(i == 5){
            return "V";
        }else if(i == 6){
            return "VI";
        }else if(i == 7){
            return "VII";
        }else if(i == 8){
            return "VIII";
        }else if(i == 9){
            return "IX";
        }else if(i == 10){
            return "X";
        }
        return "I";
    }
}
