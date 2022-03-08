package me.bluenitrox.school.aufgabensystem;

import de.Herbystar.TTA.TTA_Methods;
import me.bluenitrox.school.managers.MessageManager;
import me.bluenitrox.school.managers.PlayerJoinManager;
import me.bluenitrox.school.utils.ItemBuilder;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.BaseComponent;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.UUID;

public class AufgabenCMD implements CommandExecutor {


    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {
        Player player = (Player) commandSender;
        UUID uuid = player.getUniqueId();

        switch (args.length) {
            case 0:
                if(AufgabenManager.getToggle(uuid) == 1) {
                    AufgabenManager.setToggle(uuid, 0);
                    player.sendMessage(MessageManager.PREFIX + "§7Dir werden §awieder §6Aufgaben §7angezeigt.");
                } else {
                    AufgabenManager.setToggle(uuid, 1);
                    player.sendMessage(MessageManager.PREFIX + "§7Dir werden nun §ckeine §6Aufgaben §7mehr angezeigt.");
                    TTA_Methods.sendActionBar(player, "", 20);

                }
                break;
            default:
                player.sendMessage(MessageManager.FALSECOMMAND(PlayerJoinManager.language));

        }
        return false;
    }
}
