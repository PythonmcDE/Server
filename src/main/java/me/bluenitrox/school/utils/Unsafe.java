package me.bluenitrox.school.utils;

import org.bukkit.Bukkit;
import org.bukkit.inventory.ItemStack;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Unsafe {

    /** Do not access using this Field */
    protected final ReflectionUtils utils = new ReflectionUtils();

    /** Do not access using this Field */
    public static ItemBuilder builder;
     public Unsafe(ItemBuilder builder) {
        this.builder = builder;
    }

    /**
     * Sets a NBT Tag {@code String} into the NBT Tag Compound of the Item
     *
     * @param key   The Name on which the NBT Tag should be saved
     * @param value The Value that should be saved
     */
    public Unsafe setString(String key, String value) {
        builder.itemStack = utils.setString(builder.itemStack, key, value);
        return this;
    }

    /** Returns the String that is saved under the key */
    public String getString(String key) {
        return utils.getString(builder.itemStack, key);
    }

    /**
     * Sets a NBT Tag {@code Integer} into the NBT Tag Compound of the Item
     *
     * @param key   The Name on which the NBT Tag should be savbed
     * @param value The Value that should be saved
     */
    public Unsafe setInt(String key, int value) {
        builder.itemStack = utils.setInt(builder.itemStack, key, value);
        return this;
    }

    /** Returns the Integer that is saved under the key */
    public int getInt(String key) {
        return utils.getInt(builder.itemStack, key);
    }

    /**
     * Sets a NBT Tag {@code Double} into the NBT Tag Compound of the Item
     *
     * @param key   The Name on which the NBT Tag should be savbed
     * @param value The Value that should be saved
     */
    public Unsafe setDouble(String key, double value) {
        builder.itemStack = utils.setDouble(builder.itemStack, key, value);
        return this;
    }

    /** Returns the Double that is saved under the key */
    public double getDouble(String key) {
        return utils.getDouble(builder.itemStack, key);
    }

    /**
     * Sets a NBT Tag {@code Boolean} into the NBT Tag Compound of the Item
     *
     * @param key   The Name on which the NBT Tag should be savbed
     * @param value The Value that should be saved
     */
    public Unsafe setBoolean(String key, boolean value) {
        builder.itemStack = utils.setBoolean(builder.itemStack, key, value);
        return this;
    }

    /** Returns the Boolean that is saved under the key */
    public boolean getBoolean(String key) {
        return utils.getBoolean(builder.itemStack, key);
    }

    /** Returns a Boolean if the Item contains the NBT Tag named key */
    public boolean containsKey(String key) {
        return utils.hasKey(builder.itemStack, key);
    }

    /** Accesses back the ItemBuilder and exists the Unsafe Class */
    public ItemBuilder builder() {
        return builder;
    }

    /**
     * This Class contains highly sensitive NMS Code that should not be touched
     * unless you want to break the ItemBuilder
     */
    public class ReflectionUtils {

        public String getString(ItemStack item, String key) {
            Object compound = getNBTTagCompound(getItemAsNMSStack(item));
            if (compound == null) {
                compound = getNewNBTTagCompound();
            }
            try {
                return (String) compound.getClass().getMethod("getString", String.class).invoke(compound, key);
            } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException ex) {
                ex.printStackTrace();
            }
            return null;
        }

        public ItemStack setString(ItemStack item, String key, String value) {
            Object nmsItem = getItemAsNMSStack(item);
            Object compound = getNBTTagCompound(nmsItem);
            if (compound == null) {
                compound = getNewNBTTagCompound();
            }
            try {
                compound.getClass().getMethod("setString", String.class, String.class).invoke(compound, key, value);
                nmsItem = setNBTTag(compound, nmsItem);
            } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException ex) {
                ex.printStackTrace();
            }
            return getItemAsBukkitStack(nmsItem);
        }

        public int getInt(ItemStack item, String key) {
            Object compound = getNBTTagCompound(getItemAsNMSStack(item));
            if (compound == null) {
                compound = getNewNBTTagCompound();
            }
            try {
                return (Integer) compound.getClass().getMethod("getInt", String.class).invoke(compound, key);
            } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException ex) {
                ex.printStackTrace();
            }
            return -1;
        }

        public ItemStack setInt(ItemStack item, String key, int value) {
            Object nmsItem = getItemAsNMSStack(item);
            Object compound = getNBTTagCompound(nmsItem);
            if (compound == null) {
                compound = getNewNBTTagCompound();
            }
            try {
                compound.getClass().getMethod("setInt", String.class, Integer.class).invoke(compound, key, value);
                nmsItem = setNBTTag(compound, nmsItem);
            } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException ex) {
                ex.printStackTrace();
            }
            return getItemAsBukkitStack(nmsItem);
        }

        public double getDouble(ItemStack item, String key) {
            Object compound = getNBTTagCompound(getItemAsNMSStack(item));
            if (compound == null) {
                compound = getNewNBTTagCompound();
            }
            try {
                return (Double) compound.getClass().getMethod("getDouble", String.class).invoke(compound, key);
            } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException ex) {
                ex.printStackTrace();
            }
            return Double.NaN;
        }

        public ItemStack setDouble(ItemStack item, String key, double value) {
            Object nmsItem = getItemAsNMSStack(item);
            Object compound = getNBTTagCompound(nmsItem);
            if (compound == null) {
                compound = getNewNBTTagCompound();
            }
            try {
                compound.getClass().getMethod("setDouble", String.class, Double.class).invoke(compound, key, value);
                nmsItem = setNBTTag(compound, nmsItem);
            } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException ex) {
                ex.printStackTrace();
            }
            return getItemAsBukkitStack(nmsItem);
        }

        public boolean getBoolean(ItemStack item, String key) {
            Object compound = getNBTTagCompound(getItemAsNMSStack(item));
            if (compound == null) {
                compound = getNewNBTTagCompound();
            }
            try {
                return (Boolean) compound.getClass().getMethod("getBoolean", String.class).invoke(compound, key);
            } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException ex) {
                ex.printStackTrace();
            }
            return false;
        }

        public ItemStack setBoolean(ItemStack item, String key, boolean value) {
            Object nmsItem = getItemAsNMSStack(item);
            Object compound = getNBTTagCompound(nmsItem);
            if (compound == null) {
                compound = getNewNBTTagCompound();
            }
            try {
                compound.getClass().getMethod("setBoolean", String.class, Boolean.class).invoke(compound, key,
                        value);
                nmsItem = setNBTTag(compound, nmsItem);
            } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException ex) {
                ex.printStackTrace();
            }
            return getItemAsBukkitStack(nmsItem);
        }

        public boolean hasKey(ItemStack item, String key) {
            Object compound = getNBTTagCompound(getItemAsNMSStack(item));
            if (compound == null) {
                compound = getNewNBTTagCompound();
            }
            try {
                return (Boolean) compound.getClass().getMethod("hasKey", String.class).invoke(compound, key);
            } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
                e.printStackTrace();
            }
            return false;
        }

        public Object getNewNBTTagCompound() {
            String ver = Bukkit.getServer().getClass().getPackage().getName().split(".")[3];
            try {
                return Class.forName("net.minecraft.server." + ver + ".NBTTagCompound").newInstance();
            } catch (ClassNotFoundException | IllegalAccessException | InstantiationException ex) {
                ex.printStackTrace();
            }
            return null;
        }

        public Object setNBTTag(Object tag, Object item) {
            try {
                item.getClass().getMethod("setTag", item.getClass()).invoke(item, tag);
                return item;
            } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException ex) {
                ex.printStackTrace();
            }
            return null;
        }

        public Object getNBTTagCompound(Object nmsStack) {
            try {
                return nmsStack.getClass().getMethod("getTag").invoke(nmsStack);
            } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException ex) {
                ex.printStackTrace();
            }
            return null;
        }

        public Object getItemAsNMSStack(ItemStack item) {
            try {
                Method m = getCraftItemStackClass().getMethod("asNMSCopy", ItemStack.class);
                return m.invoke(getCraftItemStackClass(), item);
            } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException ex) {
                ex.printStackTrace();
            }
            return null;
        }

        public ItemStack getItemAsBukkitStack(Object nmsStack) {
            try {
                Method m = getCraftItemStackClass().getMethod("asCraftMirror", nmsStack.getClass());
                return (ItemStack) m.invoke(getCraftItemStackClass(), nmsStack);
            } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException ex) {
                ex.printStackTrace();
            }
            return null;
        }

        public Class<?> getCraftItemStackClass() {
            String ver = Bukkit.getServer().getClass().getPackage().getName().split(".")[3];
            try {
                return Class.forName("org.bukkit.craftbukkit." + ver + ".inventory.CraftItemStack");
            } catch (ClassNotFoundException ex) {
                ex.printStackTrace();
            }
            return null;
        }
    }
}
