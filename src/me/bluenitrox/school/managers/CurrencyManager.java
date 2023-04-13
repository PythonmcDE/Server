package me.casper.manager;

import org.bukkit.Bukkit;

import java.util.UUID;

public class CurrencyManager {

    private final UUID uuid;
    private final Currency type;

    public CurrencyManager(UUID uuid, Currency type){
        this.uuid = uuid;
        this.type = type;
    }

    public void addCurrency(long amount){

        /**
         * -------------------- IMPORTANT --------------------
         *
         *          ONLY ADD POSITIVE NUMBERS
         *
         * -------------------- IMPORTANT --------------------
         */

        DatabaseManager databaseManager = new DatabaseManager();
        long balance = databaseManager.getDatabaseValue(getTableByCurrency(type), getStringByType(type), uuid);
        balance = balance + amount;
        databaseManager.updateDatabaseValue(getTableByCurrency(type), getStringByType(type), uuid,balance);
    }

    public void removeCurrency(long amount){

        /**
         * -------------------- IMPORTANT --------------------
         *
         *          ONLY ADD POSITIVE NUMBERS
         *
         * -------------------- IMPORTANT --------------------
         */

        DatabaseManager databaseManager = new DatabaseManager();
        long balance = databaseManager.getDatabaseValue(getTableByCurrency(type), getStringByType(type), uuid);
        balance = balance - amount;
        databaseManager.updateDatabaseValue(getTableByCurrency(type), getStringByType(type), uuid,balance);
    }

    public void setCurrency(long amount){
        DatabaseManager databaseManager = new DatabaseManager();
        databaseManager.updateDatabaseValue(getTableByCurrency(type), getStringByType(type), uuid,amount);
    }

    public long getCurrency(){
        long amount = 1;
        DatabaseManager databaseManager = new DatabaseManager();
        amount = databaseManager.getDatabaseValue(getTableByCurrency(type), getStringByType(type), uuid);
        return amount;
    }

    private String getStringByType(Currency type){
        switch (type){
            case MONEY: return "money";
            case EXP: return "exp";
        }
        return null;
    }

    private String getTableByCurrency(Currency type){
        switch (type){
            default: return "userdata";
        }
    }





    /**
     *  MONEY ADD
     *  new CurrencyManager(uuid,type).addCurrency(amount);
     *
     */

}
