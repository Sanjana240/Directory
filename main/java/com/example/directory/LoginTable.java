package com.example.directory;

import android.database.sqlite.SQLiteDatabase;

public class LoginTable {

    private String Table_Name = "LoginTable";

    private String Username = "username";
    private String Password = "password";
    public LoginTable(SQLiteDatabase sqLiteDatabase){
        sqLiteDatabase.execSQL("CREATE TABLE "+Table_Name+"("+""+ ""+Username+" VARCHAR(30) PRIMARY KEY,"+""+Password+" VARCHAR(30)"+")");
    }
    public LoginTable()
    {

    }
    public LoginTable(String Username,String Password ) {

        this.Username = Password;
        this.Password = Password;

    }

    public String getTable_Name() {
        return Table_Name;
    }

    public void setTable_Name(String table_Name) {
        Table_Name = table_Name;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }
}
