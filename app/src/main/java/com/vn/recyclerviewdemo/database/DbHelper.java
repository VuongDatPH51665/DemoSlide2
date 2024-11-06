package com.vn.recyclerviewdemo.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DbHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "FOOD.db";
    public static final int DATABASE_VERSION = 3;

    public DbHelper(@Nullable Context context) {
        super(context,DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
    //Hàm chạy lần đầu tiên khi chưa có database
        //Sẽ tạo bảng ở đây
        String createtable = "CREATE TABLE food (" +
                "ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                "NAME TEXT," +
                "PRICE INTEGER," +
                "address TEXT," +  // Thêm dấu "," ở đây
                "Img INTEGER" +  // Đảm bảo Img có kiểu dữ liệu phù hợp
                ")";

        db.execSQL(createtable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    //Hàm này chạy khi version database thay đổi
        //Hàm này chúng ta sẽ dùng để update database
        String droptable="DROP TABLE IF EXISTS FOOD";
        db.execSQL(droptable);
        onCreate(db);
    }
}
