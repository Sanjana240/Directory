package com.example.directory;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.view.View;

public class SQLitehHelper extends SQLiteOpenHelper {

    public static final String dbName="Registration.db";
    private final String tableName = "UserTable";

    private String Firstname = "firstname";
    private String Lastname = "lastname";
    private String cus_id = "id";

    private String Birthdate = "birthdate";
    private String Branch = "branch";
    private String Mobile = "mobile";
    private String Gender = "gender";
    private String Address = "address";
    private String City = "city";
    private String Pincode = "pincode";
    private String Email = "email";
    private String Password = "password";

    private SQLiteDatabase myWritableDb;
    private static SQLitehHelper sqLitehHelper;
    public SQLitehHelper(Context context) {

        super(context, dbName, null, 1);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {

        new UserTable(db);

    }
    public static SQLitehHelper getInstance(Context context)
    {
        if(sqLitehHelper==null)
        {
            return sqLitehHelper = new SQLitehHelper(context);

        }
        else
        {
            return sqLitehHelper;
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
     db.execSQL("DROP TABLE IF EXISTS"+" "+tableName);
     onCreate(db);
    }

    public boolean addUserData(UserTable userTable) {
        UserTable keyU = new UserTable();
        SQLiteDatabase sql = this.getMyWritableDb();
            try {
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
                sql.insert(keyU.getTableName(), null, contentValues);
                return true;
            }
            catch (Exception e)
            {
                e.printStackTrace();
                return false;
            }


    }
    public boolean addLoginData(LoginTable logintable) {
        LoginTable keyU = new LoginTable();
        SQLiteDatabase sql = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(keyU.getUsername(), logintable.getUsername());
        contentValues.put(keyU.getPassword(),logintable.getPassword());

        long result = sql.insert(keyU.getTable_Name(), null,contentValues );

        if(result == -1)
        {
            sql.close();
            return false;
        }else
        {
            sql.close();
            return true;
        }


    }

//    private void checkDataBase()
//    {
//        Cursor cursor = sqLitehHelper.getMyWritableDb();
//        cursor.moveToFirst();
//        do{
//            String email = cursor.getString(1);
//            String pas = cursor.getString(4);
//        }
//        if(username.get)
//    }

//    public Cursor getDataFromUser()
//    {
//        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
//        UserTable userTable = new UserTable();
//        return sqLiteDatabase.rawQuery("select * from "+userTable.getTableName())
//    }

    public Cursor getDataFromUser()
    {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        UserTable userTable = new UserTable();
         Cursor cursor = sqLiteDatabase.rawQuery("select * from " +userTable.getTableName(),null);
        return cursor;
    }

    public SQLiteDatabase getMyWritableDb(){// geting permission to write database
        if ((myWritableDb == null)) {
            myWritableDb = this.getWritableDatabase();
        }

        return myWritableDb;
    }

    public void close()
    {
        super.close();
        if(myWritableDb!=null)
        {
            myWritableDb.close();
            myWritableDb=null;
        }
    }
}
