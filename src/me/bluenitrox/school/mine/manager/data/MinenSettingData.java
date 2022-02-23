package me.bluenitrox.school.mine.manager.data;

import java.util.HashMap;
import java.util.UUID;

public class MinenSettingData {

    private static MinenSettingData instance;
    /*
    create Constructor for instance
     */
    public MinenSettingData() {
        instance = this;
    }

    /*
    create Hashmaps for all Mining items.
    get by SellManager
     */

    public HashMap<UUID, Boolean> stoneSettings = new HashMap<>();
    public HashMap<UUID, Boolean> gravelSettings = new HashMap<>();
    public HashMap<UUID, Boolean> coalSettings = new HashMap<>();
    public HashMap<UUID, Boolean> brickSettings = new HashMap<>();
    public HashMap<UUID, Boolean> ironSettings = new HashMap<>();
    public HashMap<UUID, Boolean> quarzSettings = new HashMap<>();
    public HashMap<UUID, Boolean> redstoneSettings = new HashMap<>();
    public HashMap<UUID, Boolean> lapisSettings = new HashMap<>();
    public HashMap<UUID, Boolean> prismarinSettings = new HashMap<>();
    public HashMap<UUID, Boolean> goldSettings = new HashMap<>();
    public HashMap<UUID, Boolean> diamondSettings = new HashMap<>();
    public HashMap<UUID, Boolean> netherBrickSettings = new HashMap<>();
    public HashMap<UUID, Boolean> emeraldSettings = new HashMap<>();
    public HashMap<UUID, Boolean> coalBlockSettings = new HashMap<>();
    public HashMap<UUID, Boolean> redSandstoneSettings = new HashMap<>();
    public HashMap<UUID, Boolean> quarzBlockSettings = new HashMap<>();
    public HashMap<UUID, Boolean> iceSettings = new HashMap<>();
    public HashMap<UUID, Boolean> netherRackSettings = new HashMap<>();
    public HashMap<UUID, Boolean> ironBlockSettings = new HashMap<>();
    public HashMap<UUID, Boolean> packedIceSettings = new HashMap<>();
    public HashMap<UUID, Boolean> seaLaternSettings = new HashMap<>();
    public HashMap<UUID, Boolean> endStoneSettings = new HashMap<>();
    public HashMap<UUID, Boolean> redstoneBlockSettings = new HashMap<>();
    public HashMap<UUID, Boolean> lapisBlockSettings = new HashMap<>();
    public HashMap<UUID, Boolean> goldBlockSettings = new HashMap<>();
    public HashMap<UUID, Boolean> diamondBlockSettings = new HashMap<>();
    public HashMap<UUID, Boolean> emeraldBlockSettings = new HashMap<>();

    /*
    Create Method to get instance
     */
    public static MinenSettingData getInstance() {
        return instance;
    }

    /*
    create getter for HashMaps
     */
    public boolean getStoneSettings(UUID uuid) {
        return stoneSettings.get(uuid);
    }
    public boolean getGravelSettings(UUID uuid) {
        return gravelSettings.get(uuid);
    }
    public boolean getCoalSettings(UUID uuid) {
        return coalSettings.get(uuid);
    }
    public boolean getBrickSettings(UUID uuid) {
        return brickSettings.get(uuid);
    }
    public boolean getIronSettings(UUID uuid) {
        return ironSettings.get(uuid);
    }
    public boolean getQuarzSettings(UUID uuid) {
        return quarzSettings.get(uuid);
    }
    public boolean getRedstoneSettings(UUID uuid) {
        return redstoneSettings.get(uuid);
    }
    public boolean getLapisSettings(UUID uuid) {
        return lapisSettings.get(uuid);
    }
    public boolean getPrismarinSettings(UUID uuid) {
        return prismarinSettings.get(uuid);
    }
    public boolean getGoldSettings(UUID uuid) {
        return goldSettings.get(uuid);
    }
    public boolean getDiamondSettings(UUID uuid) {
        return diamondSettings.get(uuid);
    }
    public boolean getNetherBrickSettings(UUID uuid) {
        return netherBrickSettings.get(uuid);
    }
    public boolean getEmeraldeSettings(UUID uuid) {
        return emeraldSettings.get(uuid);
    }
    public boolean getCoalBlockSettings(UUID uuid) {
        return coalBlockSettings.get(uuid);
    }
    public boolean getRedSandStoneSettings(UUID uuid) {
        return redSandstoneSettings.get(uuid);
    }
    public boolean getQuarzBlockSettings(UUID uuid) {
        return quarzBlockSettings.get(uuid);
    }
    public boolean getIceSettings(UUID uuid) {
        return iceSettings.get(uuid);
    }
    public boolean getNetherRackSettings(UUID uuid) {
        return netherRackSettings.get(uuid);
    }
    public boolean getIronBlockSettings(UUID uuid) {
        return ironBlockSettings.get(uuid);
    }
    public boolean getPackedIceSettings(UUID uuid) {
        return packedIceSettings.get(uuid);
    }
    public boolean getSeaLaternSettings(UUID uuid) {
        return seaLaternSettings.get(uuid);
    }
    public boolean getEndStoneSettings(UUID uuid) {
        return endStoneSettings.get(uuid);
    }
    public boolean getRedstoneBlockSettings(UUID uuid) {
        return redstoneBlockSettings.get(uuid);
    }
    public boolean getLapisBlockSettings(UUID uuid) {
        return lapisBlockSettings.get(uuid);
    }
    public boolean getGoldBlockSettings(UUID uuid) {
        return goldBlockSettings.get(uuid);
    }
    public boolean getDiamondBlockSettings(UUID uuid) {
        return diamondBlockSettings.get(uuid);
    }
    public boolean getEmeraldBlockSettings(UUID uuid) {
        return emeraldBlockSettings.get(uuid);
    }

    /*
    create setter for HashMaps
     */

    public void setStoneSettings(UUID uuid, boolean value) {
        stoneSettings.put(uuid, value);
    }
    public void setGravelSettings(UUID uuid, boolean value) {
        gravelSettings.put(uuid, value);
    }
    public void setCoalSettings(UUID uuid, boolean value) {
        coalSettings.put(uuid, value);
    }
    public void setBrickSettings(UUID uuid, boolean value) {
        brickSettings.put(uuid, value);
    }
    public void setIronSettings(UUID uuid, boolean value) {
        ironSettings.put(uuid, value);
    }
    public void setQuarzSettings(UUID uuid, boolean value) {
        quarzSettings.put(uuid, value);
    }
    public void setRedstoneSettings(UUID uuid, boolean value) {
        redstoneSettings.put(uuid, value);
    }
    public void setLapisSettings(UUID uuid, boolean value) {
        lapisSettings.put(uuid, value);
    }
    public void setPrismarinSettings(UUID uuid, boolean value) {
        prismarinSettings.put(uuid, value);
    }
    public void setGoldSettings(UUID uuid, boolean value) {
        goldSettings.put(uuid, value);
    }
    public void setDiamondSettings(UUID uuid, boolean value) {
        diamondSettings.put(uuid, value);
    }
    public void setNetherBrickSettings(UUID uuid, boolean value) {
        netherBrickSettings.put(uuid, value);
    }
    public void setEmeraldSettings(UUID uuid, boolean value) {
        emeraldSettings.put(uuid, value);
    }
    public void setCoalBlockSettings(UUID uuid, boolean value) {
        coalBlockSettings.put(uuid, value);
    }
    public void setRedSandStoneSettings(UUID uuid, boolean value) {
        redSandstoneSettings.put(uuid, value);
    }
    public void setQuarzBlockSettings(UUID uuid, boolean value) {
        quarzBlockSettings.put(uuid, value);
    }
    public void setIceSettings(UUID uuid, boolean value) {
        iceSettings.put(uuid, value);
    }
    public void setNetherRackSettings(UUID uuid, boolean value) {
        netherRackSettings.put(uuid, value);
    }
    public void setIronBlockSettings(UUID uuid, boolean value) {
        ironBlockSettings.put(uuid, value);
    }
    public void setPackedIceSettings(UUID uuid, boolean value) {
        packedIceSettings.put(uuid, value);
    }
    public void setSeaLaternSettings(UUID uuid, boolean value) {
        seaLaternSettings.put(uuid, value);
    }
    public void setEndStoneSettings(UUID uuid, boolean value) {
        endStoneSettings.put(uuid, value);
    }
    public void setRedstoneBlockSettings(UUID uuid, boolean value) {
        redstoneBlockSettings.put(uuid, value);
    }
    public void setLapisBlockSettings(UUID uuid, boolean value) {
        lapisBlockSettings.put(uuid, value);
    }
    public void setGoldBlockSettings(UUID uuid, boolean value) {
        goldBlockSettings.put(uuid, value);
    }
    public void setDiamondBlockSettings(UUID uuid, boolean value) {
        diamondBlockSettings.put(uuid, value);
    }
    public void setEmeraldBlockSettings(UUID uuid, boolean value) {
        emeraldBlockSettings.put(uuid, value);
    }
}
