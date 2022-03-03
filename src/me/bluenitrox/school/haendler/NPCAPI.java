package me.bluenitrox.school.haendler;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import me.bluenitrox.school.SchoolMode;
import me.bluenitrox.school.commands.School;
import me.bluenitrox.school.managers.LocationManager;
import net.minecraft.server.v1_8_R3.BlockPosition;
import net.minecraft.server.v1_8_R3.DataWatcher;
import net.minecraft.server.v1_8_R3.ItemStack;
import net.minecraft.server.v1_8_R3.MathHelper;
import net.minecraft.server.v1_8_R3.MobSpawnerAbstract.a;
import net.minecraft.server.v1_8_R3.PacketPlayOutAnimation;
import net.minecraft.server.v1_8_R3.PacketPlayOutBed;
import net.minecraft.server.v1_8_R3.PacketPlayOutEntity.PacketPlayOutEntityLook;
import net.minecraft.server.v1_8_R3.PacketPlayOutEntityDestroy;
import net.minecraft.server.v1_8_R3.PacketPlayOutEntityEquipment;
import net.minecraft.server.v1_8_R3.PacketPlayOutEntityHeadRotation;
import net.minecraft.server.v1_8_R3.PacketPlayOutEntityStatus;
import net.minecraft.server.v1_8_R3.PacketPlayOutEntityTeleport;
import net.minecraft.server.v1_8_R3.PacketPlayOutNamedEntitySpawn;
import net.minecraft.server.v1_8_R3.PacketPlayOutPlayerInfo;
import net.minecraft.server.v1_8_R3.WorldSettings.EnumGamemode;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.craftbukkit.v1_8_R3.util.CraftChatMessage;
import org.bukkit.entity.Player;

import com.mojang.authlib.GameProfile;
import com.mojang.authlib.properties.Property;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.scheduler.BukkitRunnable;

public class NPCAPI extends Reflections {

    public static NPCSkins skins = new NPCSkins();
    public static NPCAPI dailyreward = new NPCAPI("§6§lDailyReward", new LocationManager("NPCDailyreward").getLocation(), skins.VALUE_DAILYREWARD, skins.SIGNATURE_DAILYREWARD);
    public static NPCAPI Taxi = new NPCAPI("§6§lTaxi", new LocationManager("NPCTaxi").getLocation(), skins.VALUE_TAXI, skins.SIGNATURE_TAXI);
    public static NPCAPI Schmied = new NPCAPI("§6§lSchmied", new LocationManager("NPCSchmied").getLocation(), skins.VALUE_SCHMIED, skins.SIGNATURE_SCHMIED);
    public static NPCAPI Koch = new NPCAPI("§6§lKoch", new LocationManager("NPCKoch").getLocation(), skins.VALUE_KOCH, skins.SIGNATURE_KOCH);
    public static NPCAPI Abenteurer = new NPCAPI("§6§lAbenteurer", new LocationManager("NPCAbenteurer").getLocation(), skins.VALUE_ABENTEURER, skins.SIGNATURE_ABENTEURER);
    public static NPCAPI Bauarbeiter = new NPCAPI("§6§lBauarbeiter", new LocationManager("NPCBauarbeiter").getLocation(), skins.VALUE_BAUARBEITER, skins.SIGNATURE_BAUARBEITER);
    public static NPCAPI Bergmann = new NPCAPI("§6§lBergmann", new LocationManager("NPCBergmann").getLocation(), skins.VALUE_BERGMANN, skins.SIGNATURE_BERGMANN);
    public static NPCAPI Förster = new NPCAPI("§6§lFörster", new LocationManager("NPCFörster").getLocation(), skins.VALUE_FÖRSTER, skins.SIGNATURE_FÖRSTER);
    public static NPCAPI Gärtner = new NPCAPI("§6§lGärtner", new LocationManager("NPCGärtner").getLocation(), skins.VALUE_GÄRTNER, skins.SIGNATURE_GÄRTNER);
    public static NPCAPI Landwirt = new NPCAPI("§6§lLandwirt", new LocationManager("NPCLandwirt").getLocation(), skins.VALUE_LANDWIRT, skins.SIGNATURE_LANDWIRT);
    public static NPCAPI Künstlerin = new NPCAPI("§6§lKünstlerin", new LocationManager("NPCKünstlerin").getLocation(), skins.VALUE_KÜNSTLERIN, skins.SIGNATURE_KÜNSTLERIN);
    public static NPCAPI Magier = new NPCAPI("§6§lMagier", new LocationManager("NPCMagier").getLocation(), skins.VALUE_MAGIER, skins.SIGNATURE_MAGIER);
    public static NPCAPI Techniker = new NPCAPI("§6§lTechniker", new LocationManager("NPCTechniker").getLocation(), skins.VALUE_TECHNIKER, skins.SIGNATURE_TECHNIKER);
    public static NPCAPI Jäger = new NPCAPI("§6§lJäger", new LocationManager("NPCJäger").getLocation(), skins.VALUE_JÄGER, skins.SIGNATURE_JÄGER);
    public static NPCAPI Dungeon = new NPCAPI("§6§lDungeon", new LocationManager("NPCDungeon").getLocation(), skins.VALUE_DUNGEON, skins.SIGNATURE_DUNGEON);
    public static NPCAPI Mine = new NPCAPI("§6§lMinenhändler", new LocationManager("NPCMine").getLocation(), skins.VALUE_MINE, skins.SIGNATURE_MINE);
    public static NPCAPI Angelmine = new NPCAPI("§6§lFischer", new LocationManager("NPCAngelmine").getLocation(), skins.VALUE_ANGELMINE, skins.SIGNATURE_ANGELMINE);
    public static NPCAPI Minensettings = new NPCAPI("§6§lSettings", new LocationManager("NPCMinensettings").getLocation(), skins.VALUE_MINE, skins.SIGNATURE_MINE);


    public static LinkedList<Integer> entityids = new LinkedList<>();
    public static LinkedList<NPCAPI> minenNpcs = new LinkedList<>();

    public static void setJoinNPC(PlayerJoinEvent e){
        new BukkitRunnable() {
            @Override
            public void run() {
                PacketReader pr = new PacketReader(e.getPlayer());
                pr.inject();

                new BukkitRunnable() {
                    @Override
                    public void run() {
                        summonAllNPCS(e.getPlayer());
                    }
                }.runTaskLater(SchoolMode.getInstance(), 40);
            }
        }.runTaskAsynchronously(SchoolMode.getInstance());
    }

    public static void setMinenhändlerNPC() {
        for(int i = 1; i <= 26; i++) {
            NPCAPI Minenhändler = new NPCAPI("§6§lMinenhändler", new LocationManager("NPCInMine" + i).getLocation(), skins.VALUE_MINE, skins.SIGNATURE_MINE);
            minenNpcs.add(Minenhändler);
        }
    }

    public static void updateNPCs(Player player){
        new BukkitRunnable() {
            @Override
            public void run() {
                NPCAPI.summonAllNPCS(player);
            }
        }.runTaskLaterAsynchronously(SchoolMode.getInstance(), 40);
    }

    public static void summonAllNPCS(Player player){
        dailyreward.rmvFromTablist();
        dailyreward.spawn(player);
        Taxi.rmvFromTablist();
        Taxi.spawn(player);
        Schmied.rmvFromTablist();
        Schmied.spawn(player);
        Koch.rmvFromTablist();
        Koch.spawn(player);
        Abenteurer.rmvFromTablist();
        Abenteurer.spawn(player);
        Bauarbeiter.rmvFromTablist();
        Bauarbeiter.spawn(player);
        Bergmann.rmvFromTablist();
        Bergmann.spawn(player);
        Förster.rmvFromTablist();
        Förster.spawn(player);
        Gärtner.rmvFromTablist();
        Gärtner.spawn(player);
        Landwirt.rmvFromTablist();
        Landwirt.spawn(player);
        Künstlerin.rmvFromTablist();
        Künstlerin.spawn(player);
        Magier.rmvFromTablist();
        Magier.spawn(player);
        Techniker.rmvFromTablist();
        Techniker.spawn(player);
        Jäger.rmvFromTablist();
        Jäger.spawn(player);
        Dungeon.rmvFromTablist();
        Dungeon.spawn(player);
        Mine.rmvFromTablist();
        Mine.spawn(player);
        Angelmine.rmvFromTablist();
        Angelmine.spawn(player);
        Minensettings.rmvFromTablist();
        Minensettings.spawn(player);

        for (int i = 0; i < minenNpcs.size(); i++) {
            NPCAPI npc = minenNpcs.get(i);
            npc.rmvFromTablist();
            npc.spawn(player);
        }
    }

    public static void destroyAllNPCS(Player player) {
        dailyreward.destroy(player);
        Taxi.destroy(player);
        Schmied.destroy(player);
        Koch.destroy(player);
        Abenteurer.destroy(player);
        Bauarbeiter.destroy(player);
        Bergmann.destroy(player);
        Förster.destroy(player);
        Gärtner.destroy(player);
        Landwirt.destroy(player);
        Künstlerin.destroy(player);
        Magier.destroy(player);
        Techniker.destroy(player);
        Jäger.destroy(player);
        Dungeon.destroy(player);
        Mine.destroy(player);
        Angelmine.destroy(player);
        Minensettings.destroy(player);

        for (int i = 0; i < minenNpcs.size(); i++) {
            minenNpcs.get(i).destroy(player);
        }
    }


    private int entityID;
    private Player localplayer;
    private Location location;
    private GameProfile gameprofile;


    public NPCAPI(String name,Location location, String value, String signature){
        Random r = new Random();
        entityID = r.nextInt(1400000000);
        gameprofile = new GameProfile(UUID.randomUUID(), name);
        changeSkin(value, signature);
        this.location = location.clone();
    }

    public void changeSkin(String value, String signature){
        gameprofile.getProperties().put("textures", new Property("textures", value, signature));
    }


    public void animation(int animation){
        PacketPlayOutAnimation packet = new PacketPlayOutAnimation();
        setValue(packet, "a", entityID);
        setValue(packet, "b", (byte)animation);
        sendPacket(packet, localplayer);
    }

    public void status(int status){
        PacketPlayOutEntityStatus packet = new PacketPlayOutEntityStatus();
        setValue(packet, "a", entityID);
        setValue(packet, "b", (byte)status);
        sendPacket(packet, localplayer);
    }

    public void equip(int slot,ItemStack itemstack){
        PacketPlayOutEntityEquipment packet = new PacketPlayOutEntityEquipment();
        setValue(packet, "a", entityID);
        setValue(packet, "b", slot);
        setValue(packet, "c", itemstack);
        sendPacket(packet, localplayer);
    }

    public void sleep(boolean state){
        if(state){
            Location bedLocation = new Location(location.getWorld(), 1, 1, 1);
            PacketPlayOutBed packet = new PacketPlayOutBed();
            setValue(packet, "a", entityID);
            setValue(packet, "b", new BlockPosition(bedLocation.getX(),bedLocation.getY(),bedLocation.getZ()));

            for(Player pl : Bukkit.getOnlinePlayers()){
                pl.sendBlockChange(bedLocation, Material.BED_BLOCK, (byte)0);
            }

            sendPacket(packet, localplayer);
            teleport(location.clone().add(0,0.3,0));
        }else{
            animation(2);
            teleport(location.clone().subtract(0,0.3,0));
        }
    }

    public void spawn(Player player){
        PacketPlayOutNamedEntitySpawn packet = new PacketPlayOutNamedEntitySpawn();

        localplayer = player;

        entityids.add(entityID);
        setValue(packet, "a", entityID);
        setValue(packet, "b", gameprofile.getId());
        setValue(packet, "c", getFixLocation(location.getX()));
        setValue(packet, "d", getFixLocation(location.getY()));
        setValue(packet, "e", getFixLocation(location.getZ()));
        setValue(packet, "f", getFixRotation(location.getYaw()));
        setValue(packet, "g", getFixRotation(location.getPitch()));
        setValue(packet, "h", 0);
        DataWatcher w = new DataWatcher(null);
        w.a(6,(float)20);
        w.a(10,(byte)127);
        setValue(packet, "i", w);
        addToTablist();
        sendPacket(packet, localplayer);
        headRotation(location.getYaw(), location.getPitch());
    }

    public void teleport(Location location){
        PacketPlayOutEntityTeleport packet = new PacketPlayOutEntityTeleport();
        setValue(packet, "a", entityID);
        setValue(packet, "b", getFixLocation(location.getX()));
        setValue(packet, "c", getFixLocation(location.getY()));
        setValue(packet, "d", getFixLocation(location.getZ()));
        setValue(packet, "e", getFixRotation(location.getYaw()));
        setValue(packet, "f", getFixRotation(location.getPitch()));

        sendPacket(packet, localplayer);
        headRotation(location.getYaw(), location.getPitch());
        this.location = location.clone();
    }

    public void headRotation(float yaw,float pitch){
        PacketPlayOutEntityLook packet = new PacketPlayOutEntityLook(entityID, getFixRotation(yaw),getFixRotation(pitch) , true);
        PacketPlayOutEntityHeadRotation packetHead = new PacketPlayOutEntityHeadRotation();
        setValue(packetHead, "a", entityID);
        setValue(packetHead, "b", getFixRotation(yaw));


        sendPacket(packet, localplayer);
        sendPacket(packetHead, localplayer);
    }

    public void destroy(Player player){
        PacketPlayOutEntityDestroy packet = new PacketPlayOutEntityDestroy(new int[] {entityID});
        rmvFromTablist();
        sendPacket(packet, player);
    }

    public void addToTablist(){
        PacketPlayOutPlayerInfo packet = new PacketPlayOutPlayerInfo();
        PacketPlayOutPlayerInfo.PlayerInfoData data = packet.new PlayerInfoData(gameprofile, 1, EnumGamemode.NOT_SET, CraftChatMessage.fromString(gameprofile.getName())[0]);
        @SuppressWarnings("unchecked")
        List<PacketPlayOutPlayerInfo.PlayerInfoData> players = (List<PacketPlayOutPlayerInfo.PlayerInfoData>) getValue(packet, "b");
        players.add(data);

        setValue(packet, "a", PacketPlayOutPlayerInfo.EnumPlayerInfoAction.ADD_PLAYER);
        setValue(packet, "b", players);

        sendPacket(packet, localplayer);
    }

    public void rmvFromTablist(){
        PacketPlayOutPlayerInfo packet = new PacketPlayOutPlayerInfo();
        PacketPlayOutPlayerInfo.PlayerInfoData data = packet.new PlayerInfoData(gameprofile, 1, EnumGamemode.NOT_SET, CraftChatMessage.fromString(gameprofile.getName())[0]);
        @SuppressWarnings("unchecked")
        List<PacketPlayOutPlayerInfo.PlayerInfoData> players = (List<PacketPlayOutPlayerInfo.PlayerInfoData>) getValue(packet, "b");
        players.add(data);

        setValue(packet, "a", PacketPlayOutPlayerInfo.EnumPlayerInfoAction.REMOVE_PLAYER);
        setValue(packet, "b", players);


        new BukkitRunnable() {
            @Override
            public void run() {
                sendPacket(packet, localplayer);
            }
        }.runTaskLaterAsynchronously(SchoolMode.getInstance(), 20*2);
    }

    public int getFixLocation(double pos){
        return (int)MathHelper.floor(pos * 32.0D);
    }

    public int getEntityID() {
        return entityID;
    }

    public byte getFixRotation(float yawpitch){
        return (byte) ((int) (yawpitch * 256.0F / 360.0F));
    }

}







/*
    public static void setNPCAll(Location location, String playername, Player p){
        MinecraftServer nmsServer = ((CraftServer) Bukkit.getServer()).getServer();
        WorldServer nmsWorld = ((CraftWorld)Bukkit.getWorld(location.getWorld().getName())).getHandle(); // Change "world" to the world the NPC should be spawned in.
        GameProfile gameProfile = new GameProfile(UUID.randomUUID(), playername); // Change "playername" to the name the NPC should have, max 16 characters.
        EntityPlayer npc = new EntityPlayer(nmsServer, nmsWorld, gameProfile, new PlayerInteractManager(nmsWorld)); // This will be the EntityPlayer (NPC) we send with the sendNPCPacket method.
        npc.setLocation(location.getX(), location.getY(), location.getZ(), location.getYaw(), location.getPitch());
        new BukkitRunnable() {
            @Override
            public void run() {
                addNPCPacketAllPlayer(npc, p);
            }
        }.runTaskLaterAsynchronously(SchoolMode.getInstance(), 20*2);
    }

    public static void addNPCPacketAllPlayer(EntityPlayer npc, Player p) {
        PlayerConnection connection = ((CraftPlayer) p).getHandle().playerConnection;
        connection.sendPacket(new PacketPlayOutPlayerInfo(PacketPlayOutPlayerInfo.EnumPlayerInfoAction.ADD_PLAYER, npc)); // "Adds the player data for the client to use when spawning a player" - https://wiki.vg/Protocol#Spawn_Player
        connection.sendPacket(new PacketPlayOutNamedEntitySpawn(npc)); // Spawns the NPC for the player client.
        connection.sendPacket(new PacketPlayOutEntityHeadRotation(npc, (byte) (npc.yaw * 256 / 360))); // Correct head rotation when spawned in player look direction.
    }
*/