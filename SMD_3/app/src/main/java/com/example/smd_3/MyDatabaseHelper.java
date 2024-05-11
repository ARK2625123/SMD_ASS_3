package com.example.smd_3;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.util.ArrayList;


public class MyDatabaseHelper {

    private final String DATABASE_NAME = "AlohaDB";
    private final int DATABASE_VERSION = 5;

    private final String LTABLE = "Login_Table";
    private final String KEY_LUSER = "_luser";
    private final String KEY_LNAME = "_lname";
    private final String KEY_LPASS = "_lpass";
    private final String PTABLE = "Login_Table";
    private final String KEY_PUSER = "_puser";
    private final String KEY_PPASS = "_ppass";
    private final String KEY_PURL = "_purl";
    private final String KEY_FUSER = "_fuser";
    private String login="";


    CreateDataBase helper;
    SQLiteDatabase database;
    Context context;

    public MyDatabaseHelper(Context context) {
        this.context = context;

    }

    //    public void updateContact(int id, String newName, String newPhone)
//    {
//        ContentValues cv = new ContentValues();
//        cv.put(KEY_NAME, newName);
//        cv.put(KEY_PHONE, newPhone);
//
//        int records = database.update(TABLE_NAME, cv, KEY_ID+"=?", new String[]{id+""});
//        if(records>0)
//        {
//            Toast.makeText(context, "Contact updated", Toast.LENGTH_SHORT).show();
//        }
//        else
//        {
//            Toast.makeText(context, "Contact not updated", Toast.LENGTH_SHORT).show();
//        }
//    }
//
    public boolean loggedin(String un,String p)
    {


        Cursor c=database.rawQuery("SELECT "+KEY_LPASS+" FROM "+ LTABLE + " WHERE " + KEY_LUSER + " = ?", new String[]{un});
        String pass=c.getString(2);
        if (pass==p)
        {
            login=un;
            return true;
        }
        else
        {
            return false;
        }
    }
    public boolean checkUsernameExists(String username) {

        Cursor cursor = database.rawQuery("SELECT * FROM " + LTABLE + " WHERE " + KEY_LUSER + " = ?", new String[]{username});
        boolean exists = cursor.getCount() != 0;
        cursor.close();
        return exists;
    }


    public void signup(String name, String user,String pass)
        {
        ContentValues cv = new ContentValues();
        cv.put(KEY_LNAME,name);
        cv.put(KEY_LUSER,user);
        cv.put(KEY_LPASS,pass);

        long records = database.insert(LTABLE, null, cv);
        if (records>=0)
        {
            Toast.makeText(context, "Signed up", Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(context, "Failed to signup", Toast.LENGTH_SHORT).show();
        }
}
//    public void deleteContact(int id)
//    {
//
//        int rows = database.delete(TABLE_NAME, KEY_ID+"=?", new String[]{id+""});
//        if(rows>0)
//        {
//            Toast.makeText(context, "Contact deleted", Toast.LENGTH_SHORT).show();
//        }
//        else
//        {
//            Toast.makeText(context, "Contact not deleted", Toast.LENGTH_SHORT).show();
//        }
//    }
//
//    public void insert(String name, String phone)
//    {
//        ContentValues cv = new ContentValues();
//        cv.put(KEY_NAME,name);
//        cv.put(KEY_PHONE,phone);
//
//        long records = database.insert(TABLE_NAME, null, cv);
//        if(records == -1)
//        {
//            Toast.makeText(context, "Data not inserted", Toast.LENGTH_SHORT).show();
//        }
//        else
//        {
//            Toast.makeText(context, "Total "+records+" contacts added", Toast.LENGTH_SHORT).show();
//        }
//    }
//
//    public ArrayList<Contact> readAllContacts()
//    {
//        ArrayList<Contact> records = new ArrayList<>();
//        Cursor cursor = database.rawQuery("SELECT * FROM "+TABLE_NAME, null);
//        int id_Index = cursor.getColumnIndex(KEY_ID);
//        int name_Index = cursor.getColumnIndex(KEY_NAME);
//        int phone_Index = cursor.getColumnIndex(KEY_PHONE);
//
//        if(cursor.moveToFirst())
//        {
//            do{
//                Contact c = new Contact();
//
//                c.setId(cursor.getInt(id_Index));
//                c.setName(cursor.getString(name_Index));
//                c.setPhone(cursor.getString(phone_Index));
//
//                records.add(c);
//            }while(cursor.moveToNext());
//        }
//
//        cursor.close();
//
//        return records;
//    }


    public void open()
    {

        helper = new CreateDataBase(context, DATABASE_NAME, null, DATABASE_VERSION);
        database = helper.getWritableDatabase();
    }

    public void close()
    {
        database.close();
        helper.close();
    }

    private class CreateDataBase extends SQLiteOpenHelper
    {
        public CreateDataBase(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
            super(context, name, factory, version);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            String query = "CREATE TABLE " + LTABLE + "(" +
                    KEY_LUSER + " TEXT PRIMARY KEY ," +
                    KEY_LNAME + " TEXT NOT NULL," +
                    KEY_LPASS + " TEXT NOT NULL" +
                    ");";

            String query2="CREATE TABLE " + PTABLE + "(" +

                    KEY_PPASS + " TEXT NOT NULL," +
                    KEY_PUSER + " TEXT PRIMARY KEY ," +
                    KEY_PURL + " TEXT NOT NULL," +
                    KEY_FUSER +"TEXT NOT NULL,"+
                    " FOREIGN KEY(" + KEY_FUSER + ") REFERENCES "+ LTABLE+" ( "+ KEY_LUSER +" ) " +
                    ");";
            String query3="INSERT INTO "+ LTABLE +" (" +KEY_LUSER + "," +KEY_LNAME+","+ KEY_LPASS + ")  VALUES (aaon,aaon ,aaon);";


            db.execSQL(query);
            db.execSQL(query2);
            db.execSQL(query3);
            Toast.makeText(context, "success", Toast.LENGTH_SHORT).show();

        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            // backup code here
            if(newVersion==5)
            {
                db.execSQL("DROP TABLE " + LTABLE  + " IF EXISTS");
                db.execSQL("DROP TABLE " +  PTABLE + " IF EXISTS");
                onCreate(db);
            }

        }
    }
}