package me.bluenitrox.school.utils;

import org.bukkit.Material;
import org.bukkit.entity.Player;

public class ArmorUtil {

    public static void setArmorNull(Player p){
        if(p.getInventory().getHelmet() != null){
            p.getInventory().setHelmet(new ItemBuilder(Material.AIR).build());
        }
        if(p.getInventory().getChestplate() != null){
            p.getInventory().setChestplate(new ItemBuilder(Material.AIR).build());
        }
        if(p.getInventory().getLeggings() != null){
            p.getInventory().setLeggings(new ItemBuilder(Material.AIR).build());
        }
        if(p.getInventory().getBoots() != null){
            p.getInventory().setBoots(new ItemBuilder(Material.AIR).build());
        }
    }

    public boolean hasHelmetWithEnchant(Player p){
        if(p.getInventory().getHelmet() != null){
            if(p.getInventory().getHelmet().getItemMeta() != null){
                if(p.getInventory().getHelmet().getItemMeta().getLore() != null){
                    return true;
                }
            }
        }
        return false;
    }
    public boolean hasChestplateWithEnchant(Player p){
        if(p.getInventory().getChestplate() != null){
            if(p.getInventory().getChestplate().getItemMeta() != null){
                if(p.getInventory().getChestplate().getItemMeta().getLore() != null){
                    return true;
                }
            }
        }
        return false;
    }
    public boolean hasLegginsWithEnchant(Player p){
        if(p.getInventory().getLeggings() != null){
            if(p.getInventory().getLeggings().getItemMeta() != null){
                if(p.getInventory().getLeggings().getItemMeta().getLore() != null){
                    return true;
                }
            }
        }
        return false;
    }
    public boolean hasBootsWithEnchant(Player p){
        if(p.getInventory().getBoots() != null){
            if(p.getInventory().getBoots().getItemMeta() != null){
                if(p.getInventory().getBoots().getItemMeta().getLore() != null){
                    return true;
                }
            }
        }
        return false;
    }

}
