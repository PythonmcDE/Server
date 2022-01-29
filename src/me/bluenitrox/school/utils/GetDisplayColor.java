package me.bluenitrox.school.utils;

import eu.thesimplecloud.api.CloudAPI;
import eu.thesimplecloud.api.player.ICloudPlayer;
import eu.thesimplecloud.api.player.IOfflineCloudPlayer;
import eu.thesimplecloud.clientserverapi.lib.promise.ICommunicationPromise;
import eu.thesimplecloud.module.permission.PermissionPool;
import eu.thesimplecloud.module.permission.player.IPermissionPlayer;
import eu.thesimplecloud.module.permission.player.PermissionPlayer;
import java.util.UUID;

public class GetDisplayColor {

    public static String getRankColor(IPermissionPlayer permissionPlayer) {

        if (permissionPlayer.getHighestPermissionGroup().getName().equalsIgnoreCase("Admin")) {
            return "§4";
        }
        if (permissionPlayer.getHighestPermissionGroup().getName().equalsIgnoreCase("Manager")) {
            return "§c";
        }
        if (permissionPlayer.getHighestPermissionGroup().getName().equalsIgnoreCase("Developer")) {
            return "§9";
        }
        if (permissionPlayer.getHighestPermissionGroup().getName().equalsIgnoreCase("SrModerator")) {
            return "§c";
        }
        if (permissionPlayer.getHighestPermissionGroup().getName().equalsIgnoreCase("Moderator")) {
            return "§c";
        }
        if (permissionPlayer.getHighestPermissionGroup().getName().equalsIgnoreCase("SrSupporter")) {
            return "§3";
        }
        if (permissionPlayer.getHighestPermissionGroup().getName().equalsIgnoreCase("Supporter")) {
            return "§3";
        }
        if (permissionPlayer.getHighestPermissionGroup().getName().equalsIgnoreCase("SrBuilder")) {
            return "§e";
        }
        if (permissionPlayer.getHighestPermissionGroup().getName().equalsIgnoreCase("Builder")) {
            return "§e";
        }
        if (permissionPlayer.getHighestPermissionGroup().getName().equalsIgnoreCase("Content")) {
            return "§a";
        }
        if (permissionPlayer.getHighestPermissionGroup().getName().equalsIgnoreCase("YoutuberPlus")) {
            return "§5";
        }
        if (permissionPlayer.getHighestPermissionGroup().getName().equalsIgnoreCase("Youtuber")) {
            return "§d";
        }
        if (permissionPlayer.getHighestPermissionGroup().getName().equalsIgnoreCase("PremiumPlus")) {
            return "§b";
        }
        if (permissionPlayer.getHighestPermissionGroup().getName().equalsIgnoreCase("Python")) {
            return "§a";
        }
        if (permissionPlayer.getHighestPermissionGroup().getName().equalsIgnoreCase("VIP")) {
            return "§6";
        } else {
            return "§7";
        }
    }

    public static IPermissionPlayer getIPermissionPlayer(UUID uuid) {

        IPermissionPlayer permissionPlayer = null;

        try {

            if (CloudAPI.getInstance().getCloudPlayerManager().getCachedCloudPlayer(uuid) == null) {

                ICommunicationPromise<IOfflineCloudPlayer> iOfflineCloudPlayer = CloudAPI.getInstance().getCloudPlayerManager().getOfflineCloudPlayer(uuid);
                permissionPlayer = (IPermissionPlayer) iOfflineCloudPlayer.getBlockingOrNull().getProperty(PermissionPlayer.PROPERTY_NAME).getValue();
            } else {

                permissionPlayer = PermissionPool.getInstance().getPermissionPlayerManager().getCachedPermissionPlayer(uuid);
            }
        } catch (NullPointerException ignored) {

        }

        return permissionPlayer;
    }
}