package com.vn.recyclerviewdemo.screen;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;


import com.vn.recyclerviewdemo.R;
import com.vn.recyclerviewdemo.model.Food;

public class UpdateScreen extends AppCompatActivity {
    private Food food;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(com.vn.recyclerviewdemo.R.layout.activity_update_screen);

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            food= (Food) bundle.getSerializable("foodobj");
        }
        EditText edtName = findViewById(R.id.edtName);
        EditText edtPrice = findViewById(R.id.edtPrice);
        EditText edtAddress = findViewById(R.id.edtAddress);
        Button btnUpdate = findViewById(R.id.btnUpdate);

        edtName.setText(food.getName());
        edtPrice.setText(String.valueOf(food.getPrice()));
        edtAddress.setText(food.getAddress());

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}