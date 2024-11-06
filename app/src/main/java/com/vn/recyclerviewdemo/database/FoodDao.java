package com.vn.recyclerviewdemo.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.vn.recyclerviewdemo.model.Food;

import java.util.ArrayList;
import java.util.List;

public class FoodDao {
    DbHelper dbHelper;
    private SQLiteDatabase db;

    public FoodDao(Context context) {
        dbHelper = new DbHelper(context);
        db = dbHelper.getWritableDatabase();
    }

    public boolean insertFood(Food obj) {
        ContentValues values = new ContentValues();
        values.put("name", obj.getName());
        values.put("price", obj.getPrice());
        values.put("address", obj.getAddress());
        values.put("img",obj.getImg());
        long check = db.insert("food", null, values);
        return check != -1;
    }
    //getAll
    public List<Food> getAllFood() {
        List<Food> list = new ArrayList<>();
        Cursor cursor = db.rawQuery("SELECT * FROM food", null);
        if (cursor.getCount() > 0) {
            cursor.moveToFirst();
            do {
                Food food = new Food();
                food.setId(cursor.getInt(0)); // Cột ID
                food.setName(cursor.getString(1)); // Cột NAME
                food.setPrice(cursor.getInt(2)); // Cột PRICE
                food.setAddress(cursor.getString(3)); // Cột address
                food.setImg(cursor.getInt(4)); // Cột Img (thêm cột này vào SQL)
                list.add(food);
            } while (cursor.moveToNext());
        }
        cursor.close(); // Đóng cursor sau khi sử dụng
        return list;
    }

    public boolean DeleteFood(int id){
        int check= db.delete("food","id=?",new String[]{String.valueOf(id)});
        return check != -1;
    }
    public boolean UpdateFood(Food obj){
        ContentValues values = new ContentValues();
        values.put("name", obj.getName());
        values.put("price", obj.getPrice());
        values.put("address", obj.getAddress());
        values.put("img",obj.getImg());
        int check=db.update("food",values,"id=?",new String[]{String.valueOf(obj.getId())});
        return check != -1;
    }
}