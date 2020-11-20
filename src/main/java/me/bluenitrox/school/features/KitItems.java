package me.bluenitrox.school.features;

import me.bluenitrox.school.utils.ItemBuilder;
import net.minecraft.server.v1_8_R3.ItemBanner;
import org.bukkit.Material;
import org.bukkit.entity.Player;

public class KitItems {

    /*TODO
        Alle Kit Items wie unten aufgezeigt für jedes kit einzeln registieren
        "KITNAME" in der unteren Methode replacen
        BITTE ACHTE AUF RECHTSCHREIBUNG UND RICHTIGE BENNUNG DER ITEMS

        Wenn es ein Kit ist das nicht über Leveln sondern durch z.b. Gems
        freigeschalten werden soll schreibe bitte vor die Methode folgenden Text;

        //TODO **Art und weise wie man es freischält**

     */

    void addKITNAMEItems(Player p){
        p.getInventory().addItem(new ItemBuilder(Material.STONE).setDisplayname("TEST ITEM").build());
    }

}
