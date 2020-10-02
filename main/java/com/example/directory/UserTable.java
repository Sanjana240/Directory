package com.example.directory;

import android.database.sqlite.SQLiteDatabase;

import java.net.PasswordAuthentication;
import java.util.Date;

public class UserTable {
    private String tableName = "UserTable";

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

   public UserTable(SQLiteDatabase sqLiteDatabase){
        try {
            sqLiteDatabase.execSQL("CREATE TABLE " + tableName + "(" + "" +
                    "" + Firstname + " VARCHAR(30)," + "" + Lastname + " VARCHAR(30)," + "" + cus_id + " INTEGER(40) PRIMARY KEY AUTOINCREMENT ," + "" + Birthdate + " VARCHAR(30)," + "" + Branch + " VARCHAR(30)," + "" + Mobile + " VARCHAR(30)," +
                    "" + "" + Gender + " VARCHAR(30)," + "" + Address + " VARCHAR(30)," + "" + City + " VARCHAR(30)," + "" + Pincode + " VARCHAR(30)," + "" + Email + " VARCHAR(30)," + "" + Password + " VARCHAR(30));");


        }
        catch (Exception e){
           e.printStackTrace();
      }
    }
        //        sqLiteDatabase.execSQL("CREATE TABLE" + tableName + "(" + );
//        try {
//
//            sqLiteDatabase.execSQL("CREATE TABLE " + tableName + "(" + id + " INTEGER PRIMARY KEY AUTOINCREMENT," +
//                    email + " text NOT NULL," +
//                    name + " text NOT NULL," +
//                    mobile + " text NOT NULL," +
//                    password + " text NOT NULL," +
//                    enrollNumber + " text NOT NULL," +
//                    gender + " text NOT NULL," +
//                    dob + " text  NOT NULL)");
//
//        }catch (Exception e){
//            e.printStackTrace();
//        }
    
    public UserTable()
    {

    }
    public UserTable(String Firstname,String Lastname,String Birthdate,String Branch,String Mobile,String Gender,String Address,String City,String Pincode,String Email,String Password ) {

        this.Firstname = Firstname;
        this.Lastname = Lastname;
        this.cus_id = cus_id;
        this.Birthdate = Birthdate;
        this.Branch = Branch;
        this.Mobile = Mobile;
        this.Gender = Gender;
        this.Address = Address;
        this.City = City;
        this.Pincode = Pincode;
        this.Email = Email;
        this.Password = Password;

    }

//    public void setID(int id) {
//        this.studentID = id;
//    }
//    public int getID() {

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        this.Password = password;
    }

    public String getCity() {
        return City;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        this.Email = email;
    }

    public String getPincode() {
        return Pincode;
    }

    public void setPincode(String pincode) {
        this.Pincode = pincode;
    }

    public void setCity(String city) {
        this.City = city;
    }

    public String getGender() {
        return Gender;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        this.Address = address;
    }

    public void setGender(String gender) {
        this.Gender = gender;
    }

    public String getBranch() {
        return Branch;
    }

    public String getMobile() {
        return Mobile;
    }

    public void setMobile(String mobile) {
        this.Mobile = mobile;
    }

    public void setBranch(String branch) {
        this.Branch = branch;
    }
//        return this.studentID;
//    }


//    public UserTable(SQLiteDatabase sql) {
//        String sqlite = "CREATE TABLE" + tableName + "(" + "" + cus_id + " INTEGER PRIMARY KEY AUTO_INCREMENT," + "" + Firstname + "VARCHAR(100) NOT NULL," + "" + Lastname + "VARCHAR(100) NOT NULL," + "" + Birthdate + " NOT NULL," + "" + Branch + " VARCHAR(100) NOT NULL," + "" + Mobile + "INT(100) NOT NULL," + "" + Gender + "CHAR(1) NOT NULL," + "" + Address + "VARCHAR(200) NOT NULL," + "" + City + "VARCHAR(100) NOT NULL," + Email + "VARCHAR(100) NOT NULL," + "" + Password + "VARCHAR(100) NOT NULL," + ")";
//        sql.execSQL(sqlite);
//    }


    public String getTableName() {
        return tableName;
    }

    public String getBirthdate() {
        return Birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.Birthdate = birthdate;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getFirstname() {
        return Firstname;
    }

    public String getCus_id() {
        return cus_id;
    }

    public void setCus_id(String cus_id) {
        this.cus_id = cus_id;

    }

    public void setFirstname(String Firstname) {
        this.Firstname = Firstname;
    }

    public String getLastname() {
        return Lastname;
    }

    public void setLastname(String lastname) {
        Lastname = lastname;
    }
}


