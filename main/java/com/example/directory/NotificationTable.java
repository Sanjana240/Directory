package com.example.directory;

import android.database.sqlite.SQLiteDatabase;

public class NotificationTable {

    private String TableName = "NotificationTable";

    private String Title = "title";
    private String Description = "description";
    private String Summary = "summary";

    private String Domain = "domain";
    private String StartDate = "startdate";
    private String EndDate = "enddate";


    public NotificationTable(SQLiteDatabase sqLiteDatabase) {
        try {
            sqLiteDatabase.execSQL("CREATE TABLE " + TableName + "(" + "" +
                    "" + Title + " VARCHAR(30) PRIMARY KEY," + "" + Description + " VARCHAR(30)," + "" + Summary + " INTEGER(40)," + "" + Domain + " VARCHAR(30)," + "" + StartDate + " VARCHAR(30)," + "" + EndDate + " VARCHAR(30));");


        } catch (Exception e) {
            e.printStackTrace();
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
    }

    public NotificationTable() {

    }

    public NotificationTable(String Title, String Description, String Summary, String Domain, String StartDate, String EndDate) {

        this.Title = Title;
        this.Description = Description;
        this.Summary = Summary;
        this.Domain = Domain;
        this.StartDate = StartDate;
        this.EndDate = EndDate;


    }


    public String getTableName() {
        return TableName;
    }

    public void setTableName(String tableName) {
        TableName = tableName;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;

    }

    public String getSummary() {
        return Summary;
    }

    public void setSummary(String summary) {
        Summary = summary;
    }

    public String getDomain() {
        return Domain;
    }

    public void setDomain(String domain) {
        Domain = domain;
    }

    public String getStartDate() {
        return StartDate;
    }

    public void setStartDate(String startDate) {
        StartDate = startDate;
    }

    public String getEndDate() {
        return EndDate;
    }

    public void setEndDate(String endDate) {
        EndDate = endDate;
    }
}




