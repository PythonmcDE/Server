package me.bluenitrox.school.mine.angelmine;

import com.sun.xml.internal.ws.wsdl.writer.document.Part;
import me.bluenitrox.school.aufgabensystem.AufgabenManager;
import me.bluenitrox.school.commands.Kopfgeld;
import me.bluenitrox.school.listener.PlayerInteractEvent;
import me.bluenitrox.school.utils.ItemBuilder;
import me.bluenitrox.school.utils.KopfUtil;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerFishEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;
import java.util.Random;

public class AngelListener implements Listener {

    @EventHandler
    public void onInteract(final PlayerFishEvent e){
        if(!AngelminenManager.isinAngelmine(e.getPlayer())){
            e.setCancelled(true);
        }
        if(e.getState() == PlayerFishEvent.State.FAILED_ATTEMPT){
            int line = 0;
            int spins = 0;
            int doe = 0;
            for(int i = 0; i<PartikelManager.locations.size(); i++){
                if(spins == 0) {
                    if (e.getHook().getLocation().distanceSquared(PartikelManager.locations.get(i)) <= 3 ||
                            e.getHook().getLocation().add(0, 1, 0).distanceSquared(PartikelManager.locations.get(i)) <= 3 ||
                            e.getHook().getLocation().subtract(0, 1, 0).distanceSquared(PartikelManager.locations.get(i)) <= 3 ||
                            e.getHook().getLocation().subtract(0, 2, 0).distanceSquared(PartikelManager.locations.get(i)) <= 3 ||
                            e.getHook().getLocation().subtract(0, 3, 0).distanceSquared(PartikelManager.locations.get(i)) <= 3 ||
                            e.getHook().getLocation().subtract(0, 4, 0).distanceSquared(PartikelManager.locations.get(i)) <= 3 ||
                            e.getHook().getLocation().subtract(0, 5, 0).distanceSquared(PartikelManager.locations.get(i)) <= 3 ||
                            e.getHook().getLocation().subtract(0, 6, 0).distanceSquared(PartikelManager.locations.get(i)) <= 3 ||
                            e.getHook().getLocation().add(0, 2, 0).distanceSquared(PartikelManager.locations.get(i)) <= 3 ||
                            e.getHook().getLocation().add(0, 3, 0).distanceSquared(PartikelManager.locations.get(i)) <= 3 ||
                            e.getHook().getLocation().add(0, 4, 0).distanceSquared(PartikelManager.locations.get(i)) <= 3 ||
                            e.getHook().getLocation().add(0, 5, 0).distanceSquared(PartikelManager.locations.get(i)) <= 3 ||
                            e.getHook().getLocation().add(0, 6, 0).distanceSquared(PartikelManager.locations.get(i)) <= 3) {
                        line = i;
                        spins += 10;
                        doe +=10;
                        addPlayerItem(e.getPlayer());
                        e.getPlayer().playSound(e.getPlayer().getLocation(), Sound.NOTE_BASS, 1L, 1L);
                    } else {
                    }
                }
            }
            if(doe >= 10) {
                PartikelManager.locations.remove(line);
                if(AufgabenManager.getTask(e.getPlayer().getUniqueId()) == 20) {
                    AufgabenManager.onComplete(e.getPlayer().getUniqueId(), 20);
                }
            }
        }
    }

    public void addPlayerItem(Player p){
        int angelmine = AngelminenManager.playerangelmine.get(p);
        p.getInventory().addItem(getItemforPartikel(angelmine));
    }
    private ItemStack getItemforPartikel(int angelmine){
        ItemStack is = null;
        if(angelmine == 1){
            is = new ItemBuilder(Material.RAW_FISH).setDisplayname("§7Roher Fisch").build();
        }else if(angelmine == 2){
            Random r = new Random();
            int z = r.nextInt(2);
            switch (z){
                case 0:
                    is = new ItemBuilder(Material.RAW_FISH).setDisplayname("§7Roher Fisch").build();
                    break;
                case 1:
                    is = new ItemBuilder(Material.RAW_FISH, (short) 1).setDisplayname("§7Roher Lachs").build();
                    break;
            }
        }else if(angelmine == 3){
            Random r = new Random();
            int z = r.nextInt(3);
            switch (z){
                case 0:
                    is = new ItemBuilder(Material.RAW_FISH).setDisplayname("§7Roher Fisch").build();
                    break;
                case 1:
                    is = new ItemBuilder(Material.RAW_FISH, (short) 1).setDisplayname("§7Roher Lachs").build();
                    break;
                case 2:
                    is = new ItemBuilder(Material.RAW_FISH,(short)3).setDisplayname("§7Kugelfisch").build();
                    break;
            }
        }else if(angelmine == 4){
            Random r = new Random();
            int z = r.nextInt(4);
            switch (z){
                case 0:
                    is = new ItemBuilder(Material.RAW_FISH).setDisplayname("§7Roher Fisch").build();
                    break;
                case 1:
                    is = new ItemBuilder(Material.RAW_FISH, (short) 1).setDisplayname("§7Roher Lachs").build();
                    break;
                case 2:
                    is = new ItemBuilder(Material.RAW_FISH,(short)3).setDisplayname("§7Kugelfisch").build();
                    break;
                case 3:
                    is = new ItemBuilder(Material.RAW_FISH,(short)2).setDisplayname("§7Clownfisch").build();
                    break;
            }
        }else if(angelmine == 5){
            Random r = new Random();
            int z = r.nextInt(5);
            switch (z){
                case 0:
                    is = new ItemBuilder(Material.RAW_FISH).setDisplayname("§7Roher Fisch").build();
                    break;
                case 1:
                    is = new ItemBuilder(Material.RAW_FISH, (short) 1).setDisplayname("§7Roher Lachs").build();
                    break;
                case 2:
                    is = new ItemBuilder(Material.RAW_FISH,(short)3).setDisplayname("§7Kugelfisch").build();
                    break;
                case 3:
                    is = new ItemBuilder(Material.RAW_FISH,(short)2).setDisplayname("§7Clownfisch").build();
                    break;
                case 4:
                    is = new ItemBuilder(Material.VINE).setDisplayname("§7Alge").build();
                    break;
            }
        }else if(angelmine == 6){
            Random r = new Random();
            int z = r.nextInt(6);
            switch (z){
                case 0:
                    is = new ItemBuilder(Material.RAW_FISH).setDisplayname("§7Roher Fisch").build();
                    break;
                case 1:
                    is = new ItemBuilder(Material.RAW_FISH, (short) 1).setDisplayname("§7Roher Lachs").build();
                    break;
                case 2:
                    is = new ItemBuilder(Material.RAW_FISH,(short)3).setDisplayname("§7Kugelfisch").build();
                    break;
                case 3:
                    is = new ItemBuilder(Material.RAW_FISH,(short)2).setDisplayname("§7Clownfisch").build();
                    break;
                case 4:
                    is = new ItemBuilder(Material.VINE).setDisplayname("§7Alge").build();
                    break;
                case 5:
                    is = new ItemBuilder(Material.INK_SACK).setDisplayname("§7Tintenbeutel").build();
                    break;
            }
        }else if(angelmine == 7){
            Random r = new Random();
            int z = r.nextInt(7);
            switch (z){
                case 0:
                    is = new ItemBuilder(Material.RAW_FISH).setDisplayname("§7Roher Fisch").build();
                    break;
                case 1:
                    is = new ItemBuilder(Material.RAW_FISH, (short) 1).setDisplayname("§7Roher Lachs").build();
                    break;
                case 2:
                    is = new ItemBuilder(Material.RAW_FISH,(short)3).setDisplayname("§7Kugelfisch").build();
                    break;
                case 3:
                    is = new ItemBuilder(Material.RAW_FISH,(short)2).setDisplayname("§7Clownfisch").build();
                    break;
                case 4:
                    is = new ItemBuilder(Material.VINE).setDisplayname("§7Alge").build();
                    break;
                case 5:
                    is = new ItemBuilder(Material.INK_SACK).setDisplayname("§7Tintenbeutel").build();
                    break;
                case 6:
                    is = new ItemBuilder(Material.WATER_LILY).setDisplayname("§7Seerose").build();
                    break;
            }
        }else if(angelmine == 8){
            Random r = new Random();
            int z = r.nextInt(8);
            switch (z){
                case 0:
                    is = new ItemBuilder(Material.RAW_FISH).setDisplayname("§7Roher Fisch").build();
                    break;
                case 1:
                    is = new ItemBuilder(Material.RAW_FISH, (short) 1).setDisplayname("§7Roher Lachs").build();
                    break;
                case 2:
                    is = new ItemBuilder(Material.RAW_FISH,(short)3).setDisplayname("§7Kugelfisch").build();
                    break;
                case 3:
                    is = new ItemBuilder(Material.RAW_FISH,(short)2).setDisplayname("§7Clownfisch").build();
                    break;
                case 4:
                    is = new ItemBuilder(Material.VINE).setDisplayname("§7Alge").build();
                    break;
                case 5:
                    is = new ItemBuilder(Material.INK_SACK).setDisplayname("§7Tintenbeutel").build();
                    break;
                case 6:
                    is = new ItemBuilder(Material.WATER_LILY).setDisplayname("§7Seerose").build();
                    break;
                case 7:
                    is = new ItemBuilder(Material.EYE_OF_ENDER).setDisplayname("§7Wächterauge").build();
                    break;
            }
        }else if(angelmine == 9){
            Random r = new Random();
            int z = r.nextInt(9);
            switch (z){
                case 0:
                    is = new ItemBuilder(Material.RAW_FISH).setDisplayname("§7Roher Fisch").build();
                    break;
                case 1:
                    is = new ItemBuilder(Material.RAW_FISH, (short) 1).setDisplayname("§7Roher Lachs").build();
                    break;
                case 2:
                    is = new ItemBuilder(Material.RAW_FISH,(short)3).setDisplayname("§7Kugelfisch").build();
                    break;
                case 3:
                    is = new ItemBuilder(Material.RAW_FISH,(short)2).setDisplayname("§7Clownfisch").build();
                    break;
                case 4:
                    is = new ItemBuilder(Material.VINE).setDisplayname("§7Alge").build();
                    break;
                case 5:
                    is = new ItemBuilder(Material.INK_SACK).setDisplayname("§7Tintenbeutel").build();
                    break;
                case 6:
                    is = new ItemBuilder(Material.WATER_LILY).setDisplayname("§7Seerose").build();
                    break;
                case 7:
                    is = new ItemBuilder(Material.EYE_OF_ENDER).setDisplayname("§7Wächterauge").build();
                    break;
                case 8:
                    ItemStack kopf = KopfUtil.createSkull("AgentPerry1337", "§bGroßer Fisch");
                    is = kopf;
                    break;
            }
        }else if(angelmine == 10){
            Random r = new Random();
            int z = r.nextInt(10);
            switch (z){
                case 0:
                    is = new ItemBuilder(Material.RAW_FISH).setDisplayname("§7Roher Fisch").build();
                    break;
                case 1:
                    is = new ItemBuilder(Material.RAW_FISH, (short) 1).setDisplayname("§7Roher Lachs").build();
                    break;
                case 2:
                    is = new ItemBuilder(Material.RAW_FISH,(short)3).setDisplayname("§7Kugelfisch").build();
                    break;
                case 3:
                    is = new ItemBuilder(Material.RAW_FISH,(short)2).setDisplayname("§7Clownfisch").build();
                    break;
                case 4:
                    is = new ItemBuilder(Material.VINE).setDisplayname("§7Alge").build();
                    break;
                case 5:
                    is = new ItemBuilder(Material.INK_SACK).setDisplayname("§7Tintenbeutel").build();
                    break;
                case 6:
                    is = new ItemBuilder(Material.WATER_LILY).setDisplayname("§7Seerose").build();
                    break;
                case 7:
                    is = new ItemBuilder(Material.EYE_OF_ENDER).setDisplayname("§7Wächterauge").build();
                    break;
                case 8:
                    ItemStack kopf = KopfUtil.createSkull("AgentPerry1337", "§bGroßer Fisch");
                    is = kopf;
                    break;
                case 9:
                    is = new ItemBuilder(Material.ENDER_CHEST).setDisplayname("§bSchatzkiste").build();
                    break;
            }
        }
        assert is != null;
        ItemMeta im = is.getItemMeta();
        im.setLore(Arrays.asList("§6§l▶ §7Dieses Item stammt aus der §bAngelmine§7!"));
        is.setItemMeta(im);
        return is;
    }
}
