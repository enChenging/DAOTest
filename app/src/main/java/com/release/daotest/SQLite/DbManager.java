package com.release.daotest.SQLite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by corleone on 2018/3/8.
 */

public class DbManager {
    DatabaseHelper readerOpenHelper;

    private static DbManager instance;

    public static synchronized DbManager getDbManager(Context context) {
        if (instance == null){
            synchronized (DatabaseHelper.class){
                if (instance == null){
                    instance = new DbManager(context);
                }
            }
        }
        return instance;
    }

    private DbManager(Context context) {
        readerOpenHelper = DatabaseHelper.getHelper(context);
    }

    public int getVersion() {
        SQLiteDatabase db = null;
        int version = 0;
        try {
            db = readerOpenHelper.getWritableDatabase();
            version = db.getVersion();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            db.close();
        }
        return version;
    }

    /**
     * private int id;
     * private String name;
     * private int phone;
     * private int age;
     */
    public void addPersonSQL(Person person) {
        SQLiteDatabase db = null;
        try {
            db = readerOpenHelper.getWritableDatabase();
            ContentValues values = new ContentValues();
            values.put("id", person.getId());
            values.put("name", person.getName());
            values.put("age", person.getAge());
            values.put("phone", person.getPhone());
            db.insert("persons", null, values);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            db.close();
        }
    }


    public List<Person> selectPersonSQL() {
        List<Person> list = new ArrayList<>();
        SQLiteDatabase db = null;
        Cursor cursor = null;
        try {
            db = readerOpenHelper.getReadableDatabase();
            cursor = db.query("persons", null, null, null, null, null, null);
            Person person = null;
            while (cursor.moveToNext()) {
                person = new Person();
                person.setId(cursor.getInt(cursor.getColumnIndex("id")));
                person.setName(cursor.getString(cursor.getColumnIndex("name")));
                person.setAge(cursor.getInt(cursor.getColumnIndex("age")));
                person.setPhone(cursor.getInt(cursor.getColumnIndex("phone")));
                list.add(person);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            cursor.close();
            db.close();
        }

        return list;
    }

    public Person selectPersonSQLId(int id) {
        Person person = null;
        SQLiteDatabase db = null;
        Cursor cursor = null;
        try {
            db = readerOpenHelper.getReadableDatabase();
            cursor = db.query("persons", null, "id=" + id, null, null, null, null);
            while (cursor.moveToNext()) {
                person = new Person();
                person.setId(cursor.getInt(cursor.getColumnIndex("id")));
                person.setName(cursor.getString(cursor.getColumnIndex("name")));
                person.setAge(cursor.getInt(cursor.getColumnIndex("age")));
                person.setPhone(cursor.getInt(cursor.getColumnIndex("phone")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            cursor.close();
            db.close();
        }
        return person;
    }

    public void updatePersonData(Person person) {
        SQLiteDatabase db = null;
        try {
            db = readerOpenHelper.getWritableDatabase();
            ContentValues values = new ContentValues();
            values.put("name", person.getName());
            values.put("age", person.getAge());
            values.put("phone", person.getPhone());
            db.update("persons", values, "id=" + person.getId(), null);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            db.close();
        }
    }

    public void deletePersonSQL(final long id) {
        SQLiteDatabase db = null;
        try {
            db = readerOpenHelper.getWritableDatabase();
            db.delete("persons", "id=" + id, null);
        } catch (Exception e) {

        } finally {
            db.close();
        }
    }

    public void deleteTableDataSQL(String tableName) {
        SQLiteDatabase db = null;
        try {
            db = readerOpenHelper.getWritableDatabase();
            db.delete(tableName, "", null);
        } catch (Exception e) {

        } finally {
            db.close();
        }
    }

}
