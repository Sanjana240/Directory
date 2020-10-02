package com.example.directory;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "memberdirectory.db";
    private SQLiteDatabase myWritableDb;
    /*public static final String TABLE_NAME = "login";
    public static final String COL_1 = "e_mail";
    public static final String COL_2 = "password";
    */
    private static DatabaseHelper databaseHelper;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        new NotificationTable(db);
        new UserTable(db);
    }

    public static DatabaseHelper getInstance(Context context) {
        if (databaseHelper == null) {
            return databaseHelper = new DatabaseHelper(context);
        } else
            return databaseHelper;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    public  boolean addUserData(UserTable userTable) {
        UserTable keyU = new UserTable();
        try {
            SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
            ContentValues contentValues = new ContentValues();
            contentValues.put(keyU.getCus_id(), userTable.getCus_id());
            contentValues.put(keyU.getAddress(), userTable.getAddress());
            contentValues.put(keyU.getFirstname(), userTable.getFirstname());
            contentValues.put(keyU.getLastname(), userTable.getLastname());
            contentValues.put(keyU.getBirthdate(), userTable.getBirthdate());
            contentValues.put(keyU.getBranch(), userTable.getBranch());
            contentValues.put(keyU.getEmail(), userTable.getEmail());
            contentValues.put(keyU.getMobile(), userTable.getMobile());
            contentValues.put(keyU.getCity(), userTable.getCity());
            contentValues.put(keyU.getGender(), userTable.getGender());
            contentValues.put(keyU.getPassword(), userTable.getPassword());
            contentValues.put(keyU.getPincode(), userTable.getPincode());
            sqLiteDatabase.insert(keyU.getTableName(), null, contentValues);
            sqLiteDatabase.close();
            return true;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    public boolean addUserDataNoti(NotificationTable notificationTable)
    {
        NotificationTable keyU = new NotificationTable();
        try {
            SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
            ContentValues contentValues = new ContentValues();
            contentValues.put(keyU.getTitle(),notificationTable.getTitle());
            contentValues.put(keyU.getDescription(),notificationTable.getDescription());
            contentValues.put(keyU.getSummary(),notificationTable.getSummary());
            contentValues.put(keyU.getDomain(),notificationTable.getDomain());
            contentValues.put(keyU.getStartDate(),notificationTable.getStartDate());
            contentValues.put(keyU.getEndDate(),notificationTable.getEndDate());

            sqLiteDatabase.insert(keyU.getTableName(), null, contentValues);
            sqLiteDatabase.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    //public boolean addNotificationdata()




    public Cursor getlogin(){
        SQLiteDatabase db = this.getMyWritableDatabase();
        Cursor cursor = db.rawQuery("select * from UserTable", null);
        return cursor;

    }

    public SQLiteDatabase getMyWritableDatabase() { // geting permission to write database
        if ((myWritableDb == null) || (!myWritableDb.isOpen())) {
            myWritableDb = this.getWritableDatabase();
        }

        return myWritableDb;
    }
}
