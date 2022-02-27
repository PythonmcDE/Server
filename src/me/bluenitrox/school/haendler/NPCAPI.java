package me.bluenitrox.school.haendler;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

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

public class NPCAPI extends Reflections {

    public static NPCAPI dailyreward = new NPCAPI("§6§lDailyReward", new LocationManager("NPCDailyreward").getLocation());
    public static NPCAPI Taxi = new NPCAPI("§6§lTaxi", new LocationManager("NPCTaxi").getLocation());
    public static LinkedList<Integer> entityids = new LinkedList<>();

    public static void summonAllNPCS(){
        dailyreward.rmvFromTablist();
        dailyreward.spawn();
        Taxi.rmvFromTablist();
        Taxi.spawn();
    }

    public static void destroyAllNPCS() {
        dailyreward.destroy();
        Taxi.destroy();
    }


    private int entityID;
    private Location location;
    private GameProfile gameprofile;


    public NPCAPI(String name,Location location){
        Random r = new Random();
        entityID = r.nextInt(1400000000);
        gameprofile = new GameProfile(UUID.randomUUID(), name);
        changeSkin();
        this.location = location.clone();
    }

    public void changeSkin(){
        String value = "ewogICJ0aW1lc3RhbXAiIDogMTY0NTk5OTc1MDM1NSwKICAicHJvZmlsZUlkIiA6ICJiNmVlNGYwNTc2ZTk0ZTI5YTYxODYxYzI4YTNiNGNhMCIsCiAgInByb2ZpbGVOYW1lIiA6ICIxQmx1ZU5pdHJveCIsCiAgInNpZ25hdHVyZVJlcXVpcmVkIiA6IHRydWUsCiAgInRleHR1cmVzIiA6IHsKICAgICJTS0lOIiA6IHsKICAgICAgInVybCIgOiAiaHR0cDovL3RleHR1cmVzLm1pbmVjcmFmdC5uZXQvdGV4dHVyZS8xOGQ5Njg2ZDAwYzdkZDBjZTJmZTQzNTM0NWNjMTA0ZjYyYTFhMWJlMjIzNjhlNjgxY2YxN2U5ZTZhOGQ0NDZjIgogICAgfQogIH0KfQ==";
        String signature = "Xr1vwlhrxprXyjop1d+X1h3KKYfK9mgZVK0cEQaujD3z5yDJV/VDSFpOZvERnzgfLNxwtrD8KDH4N/jRgeOgW0/NY3pbZoNiY2zlO9Gpo4z/jhDoKGxnLmM0G779jZP9oyNE1f4w+vk/P18Fw2zuOtz6SP0sEmRFEY9B8+MGnBY9E4uEAlWf2J3GAAcf/TlX6XZFw42SC33jqYtlGO2wWKXbEuJ3mImawJvi/dVpCuQoQ/mpasICjTsxApHlGx/5Okx9d4gvPjumZclgrmzZPEF8CLS0LW8Q2mADIkpmBaw0p3pR+RL43AfZykX0cDiK9FtjBUbdKr1c03EKn+c+wf72aLLLwPBdHDxDdixJeLmJZVK5BWGBjSnpOEdYd7NvAEj3IHWNmmjXXsDjB7ZdQPcGDo8ewQhgOW4wsq9UZDDbAbFkg4LHuZ7W+2GP0Ocp1vnVhQBIvmaZWMSkN+pMazrIlgOOw9Js2I46Y+dQHgEpqV/jikNFhtuTiGdJp7OygC56KKupOzqMi2ID/jA03ornIbp9qRz5vGTyol7wqN5ueheQsc1q0QJkV6Al363hRoXQj7J6GjR6xE3Vhc1ezotShLUraR6sgyAhB1YUhgcQS74gLt6kJPcbu3GPq6+ojI//8rs8hmAfcoIeq4e3pgnEbCLO7gdHpTOCaVjlBqQ=/b9jrLFDfQrdqX3dGm1cKjYbvOXL9BO2WIOEJLTDCgUQJC4/n/3PZHEG2mVADc4v125MFYMfjzkznkA6zbs7w6z8f7pny9eCWNXPOQklstcdc1h/LvflnR+E4TUuxCf0jVsdT5AZsUYIsJa6fvr0+vItUXUdQ3pps0zthObPEnBdLYMtNY3G6ZLGVKcSGa/KRK2D/k69fmu/uTKbjAWtniFB/sdO0VNhLuvyr/PcZVXB78l1SfBR88ZMiW6XSaVqNnSP+MEfRkxgkJWUG+aiRRLE8G5083EQ8vhIle5GxzK68ZR48IrEX/JwFjALslCLXAGR05KrtuTD3xyq2Nut12GCaooBEhb46sipWLq4AXI9IpJORLOW8+GvY+FcDwMqXYN94juDQtbJGCQo8PX670YjbmVx7+IeFjLJJTZotemXu1wiQmDmtAAmug4U5jgMYIJryXMitD7r5pEop/cw42JbCO2u0b5NB7sI/mr4OhBKEesyC5usiARzuk6e/4aJUvwQ9nsiXfeYxZz8L/mh6e8YPJMyhVkFtblbt/4jPe0bs3xSUXO9XrDyhy9INC0jlLT22QjNzrDkD8aiGAopVvfnTTAug=";
        gameprofile.getProperties().put("textures", new Property("textures", value, signature));
    }


    public void animation(int animation){
        PacketPlayOutAnimation packet = new PacketPlayOutAnimation();
        setValue(packet, "a", entityID);
        setValue(packet, "b", (byte)animation);
        sendPacket(packet);
    }

    public void status(int status){
        PacketPlayOutEntityStatus packet = new PacketPlayOutEntityStatus();
        setValue(packet, "a", entityID);
        setValue(packet, "b", (byte)status);
        sendPacket(packet);
    }

    public void equip(int slot,ItemStack itemstack){
        PacketPlayOutEntityEquipment packet = new PacketPlayOutEntityEquipment();
        setValue(packet, "a", entityID);
        setValue(packet, "b", slot);
        setValue(packet, "c", itemstack);
        sendPacket(packet);
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

            sendPacket(packet);
            teleport(location.clone().add(0,0.3,0));
        }else{
            animation(2);
            teleport(location.clone().subtract(0,0.3,0));
        }
    }

    public void spawn(){
        PacketPlayOutNamedEntitySpawn packet = new PacketPlayOutNamedEntitySpawn();

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
        sendPacket(packet);
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

        sendPacket(packet);
        headRotation(location.getYaw(), location.getPitch());
        this.location = location.clone();
    }

    public void headRotation(float yaw,float pitch){
        PacketPlayOutEntityLook packet = new PacketPlayOutEntityLook(entityID, getFixRotation(yaw),getFixRotation(pitch) , true);
        PacketPlayOutEntityHeadRotation packetHead = new PacketPlayOutEntityHeadRotation();
        setValue(packetHead, "a", entityID);
        setValue(packetHead, "b", getFixRotation(yaw));


        sendPacket(packet);
        sendPacket(packetHead);
    }

    public void destroy(){
        PacketPlayOutEntityDestroy packet = new PacketPlayOutEntityDestroy(new int[] {entityID});
        rmvFromTablist();
        sendPacket(packet);
    }

    public void addToTablist(){
        PacketPlayOutPlayerInfo packet = new PacketPlayOutPlayerInfo();
        PacketPlayOutPlayerInfo.PlayerInfoData data = packet.new PlayerInfoData(gameprofile, 1, EnumGamemode.NOT_SET, CraftChatMessage.fromString(gameprofile.getName())[0]);
        @SuppressWarnings("unchecked")
        List<PacketPlayOutPlayerInfo.PlayerInfoData> players = (List<PacketPlayOutPlayerInfo.PlayerInfoData>) getValue(packet, "b");
        players.add(data);

        setValue(packet, "a", PacketPlayOutPlayerInfo.EnumPlayerInfoAction.ADD_PLAYER);
        setValue(packet, "b", players);

        sendPacket(packet);
    }

    public void rmvFromTablist(){
        PacketPlayOutPlayerInfo packet = new PacketPlayOutPlayerInfo();
        PacketPlayOutPlayerInfo.PlayerInfoData data = packet.new PlayerInfoData(gameprofile, 1, EnumGamemode.NOT_SET, CraftChatMessage.fromString(gameprofile.getName())[0]);
        @SuppressWarnings("unchecked")
        List<PacketPlayOutPlayerInfo.PlayerInfoData> players = (List<PacketPlayOutPlayerInfo.PlayerInfoData>) getValue(packet, "b");
        players.add(data);

        setValue(packet, "a", PacketPlayOutPlayerInfo.EnumPlayerInfoAction.REMOVE_PLAYER);
        setValue(packet, "b", players);

        sendPacket(packet);
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