package me.bluenitrox.school.listener;

import me.bluenitrox.school.managers.ExpManager;
import me.bluenitrox.school.managers.MessageManager;
import me.bluenitrox.school.managers.PermissionsManager;
import me.bluenitrox.school.utils.GetDisplayColor;
import net.minecraft.server.v1_8_R3.*;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.craftbukkit.v1_8_R3.inventory.CraftItemStack;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;

import java.util.UUID;
import java.util.regex.Pattern;

public class AsyncPlayerChatEvent implements Listener {

    @EventHandler (priority = EventPriority.HIGHEST)
    public void onChat(final org.bukkit.event.player.AsyncPlayerChatEvent e){
        Player p = (Player)e.getPlayer();
        if(ExpManager.getLevel(p.getUniqueId()) >= 3){
        }else if(!p.hasPermission(PermissionsManager.CHAT)){
            e.setCancelled(true);
            p.sendMessage(MessageManager.PREFIX + "§7Du kannst erst ab Level 3 schreiben!");
            return;
        }

        String Message = e.getMessage();

         if(Message.contains("[item]")) {
            final ItemStack is = p.getItemInHand();
            if (!is.getType().equals((Object) Material.AIR)) {
                final net.minecraft.server.v1_8_R3.ItemStack b = CraftItemStack.asNMSCopy(is);
                final NBTTagCompound c = new NBTTagCompound();
                b.save(c);
                ChatComponentText d = null;
                String item = "§8[" + getColorByPrestige(e.getPlayer().getUniqueId()) + ExpManager.getLevel(e.getPlayer().getUniqueId()) + "§8]" + GetDisplayColor.getRankColor(GetDisplayColor.getIPermissionPlayer(p.getUniqueId())) + " " + p.getDisplayName() + "§8 » §7" + "§8[§7" + b.getName() + "§8]§7";
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
        }
    }

    private String getColorByPrestige(UUID uuid){
        String color = "";
        if(ExpManager.getPrestige(uuid) == 0){
            color = "§7";
        }else if(ExpManager.getPrestige(uuid) == 1){
            color = "§3";
        }else if(ExpManager.getPrestige(uuid) == 2){
            color = "§9";
        }else if(ExpManager.getPrestige(uuid) == 3){
            color = "§6";
        }
        return color;
    }


}
