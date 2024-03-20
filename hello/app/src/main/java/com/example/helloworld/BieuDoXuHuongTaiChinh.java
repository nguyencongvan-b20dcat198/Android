package com.example.helloworld;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

public class BieuDoXuHuongTaiChinh extends AppCompatActivity {
    Spinner spinnerXHTC1, spinnerXHTC2;
    private ImageView back,home;
    private Button buttonXHTC1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bieu_do_xu_huong_tai_chinh);
        initView();
        handleSpinner();

        handleEvent();
    }

    private void handleSpinner() {
        String[] months = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"};
        String[] years = {"2024", "2023", "2022", "2021", "2020", "2019", "2018", "2017", "2016"};

        ArrayAdapter<String> monthAdapter = new ArrayAdapter<>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, months);
        ArrayAdapter<String> yearAdapter = new ArrayAdapter<>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, years);

        spinnerXHTC1.setAdapter(monthAdapter);
        spinnerXHTC2.setAdapter(yearAdapter);
    }

    private void handleEvent() {
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BieuDoXuHuongTaiChinh.this, MainActivity.class);
                startActivity(intent);
            }
        });
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BieuDoXuHuongTaiChinh.this, MainActivity.class);
                startActivity(intent);
            }
        });
        buttonXHTC1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BieuDoXuHuongTaiChinh.this, ChiTiet_BieuDoXuHuongTaiChinh.class);
                startActivity(intent);
            }
        });
    }

    private void initView() {
        back = findViewById(R.id.back);
        home = findViewById(R.id.home);
        buttonXHTC1 = findViewById(R.id.button_xhtc1);
        spinnerXHTC1 = findViewById(R.id.spinner_xhtc1);
        spinnerXHTC2 = findViewById(R.id.spinner_xhtc2);
    }
}