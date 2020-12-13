package me.bluenitrox.school.listener;

import me.bluenitrox.school.managers.ExpManager;
import me.bluenitrox.school.managers.MessageManager;
import me.bluenitrox.school.managers.PermissionsManager;
import net.minecraft.server.v1_8_R3.*;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.craftbukkit.v1_8_R3.inventory.CraftItemStack;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.messaging.PluginMessageListener;

import java.util.regex.Pattern;

public class AsyncPlayerChatEvent implements Listener {

    @EventHandler
    public void onChat(final org.bukkit.event.player.AsyncPlayerChatEvent e){
        Player p = (Player)e.getPlayer();
        if(ExpManager.getLevel(p.getUniqueId()) >= 3){
        }else if(!p.hasPermission(PermissionsManager.CHAT)){
            e.setCancelled(true);
            p.sendMessage(MessageManager.PREFIX + "§7Du kannst erst ab Level 3 schreiben!");
            return;
        }

        String Message = e.getMessage();
        if (e.getMessage().contains("%")) {
            e.setCancelled(true);
            p.sendMessage(MessageManager.PREFIX + "§7Du kannst keine %-Zeichen schreiben!");
        }

        if (Message.equals("[item]")) {
            final ItemStack is = p.getItemInHand();
            if (!is.getType().equals((Object) Material.AIR)) {
                final net.minecraft.server.v1_8_R3.ItemStack b = CraftItemStack.asNMSCopy(is);
                final NBTTagCompound c = new NBTTagCompound();
                b.save(c);
                ChatComponentText d = null;
                String item = "§8[§7" + ExpManager.getLevel(p.getUniqueId()) + "§8] " + p.getDisplayName() + "§8 » §7" + "§8[§7" + b.getName() + "§8]§7";
                Message = Message.replaceFirst(Pattern.quote("[item]"), item);
                d = new ChatComponentText(Message);
                final ChatModifier g = d.getChatModifier();
                g.setChatHoverable(new ChatHoverable(ChatHoverable.EnumHoverAction.SHOW_ITEM, (IChatBaseComponent) new ChatComponentText(c.toString())));
                d.setChatModifier(g);
                final PlayerList h = MinecraftServer.getServer().getPlayerList();
                for (final Player i : Bukkit.getOnlinePlayers()) {
                    h.getPlayer(i.getName()).sendMessage((IChatBaseComponent) d);
                    e.setCancelled(true);
                }
            }
        }else if(Message.contains("[item]")){
            p.sendMessage(MessageManager.PREFIX + "§7Du kannst §8[item] §7nicht in kombination mit einer Nachricht schreiben!");
            p.playSound(p.getLocation(), Sound.ANVIL_BREAK, 1L , 1L);
            e.setCancelled(true);
        }

        e.setFormat("§8[§7" + ExpManager.getLevel(e.getPlayer().getUniqueId()) + "§8] " + e.getPlayer().getDisplayName() + " §8» §7" + e.getMessage());
    }

}
