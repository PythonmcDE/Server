package me.bluenitrox.school.utils;

import java.util.concurrent.Executors;
import java.util.HashMap;
import java.lang.reflect.Type;
import com.google.gson.GsonBuilder;
import java.io.Reader;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.HttpURLConnection;
import java.util.function.Consumer;
import java.util.concurrent.ExecutorService;
import java.util.UUID;
import java.util.Map;
import com.google.gson.Gson;

public class UUIDFetcherWithName
{
    public static final long FEBRUARY_2015 = 1422748800000L;
    private static Gson gson;
    private static final String UUID_URL = "https://api.mojang.com/users/profiles/minecraft/%s?at=%d";
    private static final String NAME_URL = "https://api.mojang.com/user/profiles/%s/names";
    private static Map<String, UUID> uuidCache;
    private static Map<UUID, String> nameCache;
    private static ExecutorService pool;
    private String name;
    private UUID id;

    public static void getUUID(final String name, final Consumer<UUID> action) {
        UUIDFetcherWithName.pool.execute(() -> action.accept(getUUID(name)));
    }

    public static UUID getUUID(final String name) {
        return getUUIDAt(name, System.currentTimeMillis());
    }

    public static void getUUIDAt(final String name, final long timestamp, final Consumer<UUID> action) {
        UUIDFetcherWithName.pool.execute(() -> action.accept(getUUIDAt(name, timestamp)));
    }

    public static UUID getUUIDAt(String name, final long timestamp) {
        name = name.toLowerCase();
        if (UUIDFetcherWithName.uuidCache.containsKey(name)) {
            return UUIDFetcherWithName.uuidCache.get(name);
        }
        try {
            final HttpURLConnection connection = (HttpURLConnection)new URL(String.format("https://api.mojang.com/users/profiles/minecraft/%s?at=%d", name, timestamp / 1000L)).openConnection();
            connection.setReadTimeout(5000);
            final UUIDFetcherWithName data = (UUIDFetcherWithName)UUIDFetcherWithName.gson.fromJson((Reader)new BufferedReader(new InputStreamReader(connection.getInputStream())), (Class)UUIDFetcherWithName.class);
            UUIDFetcherWithName.uuidCache.put(name, data.id);
            UUIDFetcherWithName.nameCache.put(data.id, data.name);
            return data.id;
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void getName(final UUID uuid, final Consumer<String> action) {
        UUIDFetcherWithName.pool.execute(() -> action.accept(getName(uuid)));
    }

    public static String getName(final UUID uuid) {
        if (UUIDFetcherWithName.nameCache.containsKey(uuid)) {
            return UUIDFetcherWithName.nameCache.get(uuid);
        }
        try {
            final HttpURLConnection connection = (HttpURLConnection)new URL(String.format("https://api.mojang.com/user/profiles/%s/names", UUIDTypeAdapter.fromUUID(uuid))).openConnection();
            connection.setReadTimeout(5000);
            final UUIDFetcherWithName[] nameHistory = (UUIDFetcherWithName[])UUIDFetcherWithName.gson.fromJson((Reader)new BufferedReader(new InputStreamReader(connection.getInputStream())), (Class)UUIDFetcherWithName[].class);
            final UUIDFetcherWithName currentNameData = nameHistory[nameHistory.length - 1];
            UUIDFetcherWithName.uuidCache.put(currentNameData.name.toLowerCase(), uuid);
            UUIDFetcherWithName.nameCache.put(uuid, currentNameData.name);
            return currentNameData.name;
        }
        catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    static {
        UUIDFetcherWithName.gson = new GsonBuilder().registerTypeAdapter((Type)UUID.class, (Object)new UUIDTypeAdapter()).create();
        UUIDFetcherWithName.uuidCache = new HashMap<String, UUID>();
        UUIDFetcherWithName.nameCache = new HashMap<UUID, String>();
        UUIDFetcherWithName.pool = Executors.newCachedThreadPool();
    }
}
