package com.example.tracker.database;

public class DBConst {
    /**
     * USER TABLE
     */
    public static final String TABLE_USER = "user";
    public static final String USER_COLUMN_ID = "id";
    public static final String USER_COLUMN_NAME = "name";
    public static final String USER_COLUMN_DATE = "date";
    public static final String USER_COLUMN_MONEY = "type_of_money";

    /**
     * ALLOCATION TABLE
     */
    public static final String TABLE_ALLOCATION = "allocation";
    public static final String ALLOCATION_COLUMN_ID = "id";
    public static final String ALLOCATION_COLUMN_RENT = "rent";
    public static final String ALLOCATION_COLUMN_INSTALLMENT = "installment";
    public static final String ALLOCATION_COLUMN_GROCERY = "grocery";
    public static final String ALLOCATION_COLUMN_BILLS = "bills";
    public static final String ALLOCATION_COLUMN_OTHERS = "others";
    public static final String ALLOCATION_COLUMN_AMOUNT = "input_amount";

    /**
     * SAVINGS TABLE
     */
    public static final String TABLE_SAVINGS = "savings";
    public static final String SAVINGS_COLUMN_ID = "savings_id";
    public static final String SAVINGS_COLUMN_CURRENT = "current_savings";
    public static final String SAVINGS_COLUMN_PREVIOUS = "previous_savings";

    /**
     * CREATE TABLE USER
     */
    public static final String CREATE_TABLE_USER =
            "CREATE TABLE " + TABLE_USER + " (" +
                    USER_COLUMN_ID + " INT AUTO_INCREMENT PRIMARY KEY, " +
                    USER_COLUMN_NAME + " VARCHAR(100) NOT NULL, " +
                    USER_COLUMN_DATE + " DATE NOT NULL, " +
                    USER_COLUMN_MONEY + " VARCHAR(50) NOT NULL" +
                    ");";

    /**
     * CREATE TABLE ALLOCATION
     */
    public static final String CREATE_TABLE_ALLOCATION =
            "CREATE TABLE " + TABLE_ALLOCATION + " (" +
                    ALLOCATION_COLUMN_ID + " INT AUTO_INCREMENT PRIMARY KEY, " +
                    ALLOCATION_COLUMN_RENT + " DECIMAL(10,2), " +
                    ALLOCATION_COLUMN_INSTALLMENT + " DECIMAL(10,2), " +
                    ALLOCATION_COLUMN_GROCERY + " DECIMAL(10,2), " +
                    ALLOCATION_COLUMN_BILLS + " DECIMAL(10,2), " +
                    ALLOCATION_COLUMN_OTHERS + " DECIMAL(10,2), " +
                    ALLOCATION_COLUMN_AMOUNT + " DECIMAL(10,2) NOT NULL" +
                    ");";

    /**
     * CREATE TABLE SAVINGS
     */
    public static final String CREATE_TABLE_SAVINGS =
            "CREATE TABLE " + TABLE_SAVINGS + " (" +
                    SAVINGS_COLUMN_ID + " int AUTO_INCREMENT PRIMARY KEY, " +
                    SAVINGS_COLUMN_CURRENT + " DECIMAL(10,2) , " +
                    SAVINGS_COLUMN_PREVIOUS + " DECIMAL(10,2)" +

                    ");";
}
