package com.example.progrsofhifzstdnt;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;


public class DbHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "student.db";
    private static final String TABLE_NAME = "students";

    private static final String COLUMN_ID = "id";
    private static final String COLUMN_NAME = "name";
    private static final String COLUMN_AGE = "age";
    private static final String COLUMN_CLASS = "class";
    private static final String COLUMN_SABAQ_PARA = "sabaq_para";
    private static final String COLUMN_SABAQ_ST_VRS = "sabaq_st_vrs";
    private static final String COLUMN_SABAQ_FN_VRS = "sabaq_fn_vrs";
    private static final String COLUMN_SABAQI = "sabaqi";
    private static final String COLUMN_MANZIL = "manzil";



    public DbHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_NAME + " ("
                + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + COLUMN_NAME + " TEXT,"
                + COLUMN_AGE + " INTEGER,"
                + COLUMN_CLASS + " TEXT,"
                + COLUMN_SABAQ_PARA + " INTEGER,"
                + COLUMN_SABAQ_ST_VRS  +" INTEGER,"
                + COLUMN_SABAQ_FN_VRS+" INTEGER,"
                + COLUMN_SABAQI +" INTEGER,"
                +COLUMN_MANZIL+" TEXT)";

         Log.d("qd","here is msg"+query);

        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql = "DROP TABLE IF EXISTS " + TABLE_NAME;
        db.execSQL(sql);
        onCreate(db);
    }

    public void insertStudent(HafizStudent student) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME, student.getName());
        values.put(COLUMN_AGE, student.getAge());
        values.put(COLUMN_CLASS, student.getClas());
        values.put(COLUMN_SABAQ_PARA, student.getSabaqPara());
        values.put(COLUMN_SABAQ_ST_VRS, student.getSabaqStVrse());
        values.put(COLUMN_SABAQ_FN_VRS, student.getSabaqLsVrse());
        //COLUMN_SABAQI
        values.put(COLUMN_SABAQI, student.getSabaqi());
        values.put(COLUMN_MANZIL,student.getManzil());



        db.insert(TABLE_NAME, null, values);

        db.close();
    }

    /*public void updateStudent(HafizStudent student) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME, student.getName());
        values.put(COLUMN_ROLLNO, student.getRollNo());
        values.put(COLUMN_ENROLL, student.isEnroll());

        db.update(TABLE_NAME, values, COLUMN_ROLLNO + " = ?", new String[] {student.getRollNo()});
        db.close();
    }

    public void deleteStudent(String rollNo) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_NAME, COLUMN_ROLLNO + " = ?", new String[] {rollNo});
        db.close();
    }*/


    public List<HafizStudent> selectAllStudents() {
        List<HafizStudent> students = new ArrayList<>();

        String sql = "SELECT * FROM " + TABLE_NAME;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(sql, null);

        /*
        * if (cursorCourses.moveToFirst()) {
            do {

                studentArrayList.add(new StudentModel(cursorCourses.getString(1),
                      cursorCourses.getInt(2),
                        cursorCourses.getInt(3) == 1 ? true : false));
            } while (cursorCourses.moveToNext());

        }
        * */

        if (cursor.moveToFirst()) {
            do {
                @SuppressLint("Range") int id = cursor.getInt(cursor.getColumnIndex(COLUMN_ID));
                @SuppressLint("Range") String name = cursor.getString(cursor.getColumnIndex(COLUMN_NAME));
                @SuppressLint("Range") int age = cursor.getInt(cursor.getColumnIndex(COLUMN_AGE));
                @SuppressLint("Range") String clas = cursor.getString(cursor.getColumnIndex(COLUMN_CLASS));
                @SuppressLint("Range") int sbqPara = cursor.getInt(cursor.getColumnIndex(COLUMN_SABAQ_PARA));
                @SuppressLint("Range") int sbqStVrs = cursor.getInt(cursor.getColumnIndex(COLUMN_SABAQ_ST_VRS));
                @SuppressLint("Range") int sbqLsVrs = cursor.getInt(cursor.getColumnIndex(COLUMN_SABAQ_FN_VRS));
                @SuppressLint("Range") int sqbi = cursor.getInt(cursor.getColumnIndex(COLUMN_SABAQI));
                @SuppressLint("Range") String mnzl = cursor.getString(cursor.getColumnIndex(COLUMN_MANZIL));
                //@SuppressLint("Range")  String rollNo = cursor.getString(cursor.getColumnIndex(COLUMN_ROLLNO));
                //@SuppressLint("Range") boolean isEnroll = cursor.getInt(cursor.getColumnIndex(COLUMN_ENROLL))>0;
                HafizStudent hs = new HafizStudent(id,name,age,clas,sbqPara,sbqStVrs,sbqLsVrs);
                students.add(hs);

            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();

        return students;
    }
}