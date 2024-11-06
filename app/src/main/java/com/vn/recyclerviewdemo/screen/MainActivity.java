package com.vn.recyclerviewdemo.screen;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;


import com.vn.recyclerviewdemo.R;
import com.vn.recyclerviewdemo.database.FoodDao;
import com.vn.recyclerviewdemo.model.Food;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        EditText edtName=findViewById(R.id.edtName);
        EditText edtPrice=findViewById(R.id.edtPrice);
        EditText edtAddress=findViewById(R.id.edtAddress);
        Button btnInsert=findViewById(R.id.btnInsert);
        Button btnShow=findViewById(R.id.btnShow);

        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FoodDao foodDao=new FoodDao(MainActivity.this);
                Food food=new Food(
                edtName.getText().toString(),
                Integer.parseInt(edtPrice.getText().toString()),
                edtAddress.getText().toString(),
                R.drawable.ic_launcher_background);
               if(foodDao.insertFood(food)==true){
                   Toast.makeText(MainActivity.this, "OK", Toast.LENGTH_SHORT).show();
               }
               else {
                   Toast.makeText(MainActivity.this, "Cút", Toast.LENGTH_SHORT).show();
               };
            }
        });

        btnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this, ListFood.class);
                startActivity(intent);
            }
        });

    }
}