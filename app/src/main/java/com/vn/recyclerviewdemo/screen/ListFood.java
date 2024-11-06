package com.vn.recyclerviewdemo.screen;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.vn.recyclerviewdemo.R;
import com.vn.recyclerviewdemo.adapter.FoodAdapter;
import com.vn.recyclerviewdemo.database.FoodDao;
import com.vn.recyclerviewdemo.model.Food;

import java.util.ArrayList;

public class ListFood extends AppCompatActivity {
    private RecyclerView recyclerView;
    ArrayList<Food> foods;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_list_food);

        recyclerView = findViewById(R.id.recyclefood);

        // Lấy danh sách món ăn từ database
        FoodDao foodDao = new FoodDao(ListFood.this);
        foods = (ArrayList<Food>) foodDao.getAllFood(); // Giả sử `getAllFood()` trả về một danh sách Food

        // Khởi tạo adapter và set lên RecyclerView
        FoodAdapter adapter = new FoodAdapter(ListFood.this, foods);
        LinearLayoutManager layoutManager = new LinearLayoutManager(ListFood.this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }

}