package com.example.helloworld;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.icu.util.Calendar;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class BieuDoSoSanhThuChi extends AppCompatActivity {
    TextView editTextDateSSTC1, editTextDateSSTC2;
    private ImageView back,home;
    private Button buttonSSTC1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bieu_do_so_sanh_thu_chi);
        initView();

        handleEvent();
    }

    private void handleEvent() {
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BieuDoSoSanhThuChi.this, MainActivity.class);
                startActivity(intent);
            }
        });
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BieuDoSoSanhThuChi.this, MainActivity.class);
                startActivity(intent);
            }
        });
        buttonSSTC1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BieuDoSoSanhThuChi.this, ChiTiet_BieuDoSoSanhThuChi.class);
                startActivity(intent);
            }
        });
    }

    public void showDatePickerDialogStart(View v) {
        DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                String selectedDate = String.format("%d-%02d-%02d", year, monthOfYear + 1, dayOfMonth);
                editTextDateSSTC1.setText(selectedDate);
            }
        };
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        DatePickerDialog datePickerDialog = new DatePickerDialog(this, dateSetListener, year, month, day);
        datePickerDialog.show();
    }
    public void showDatePickerDialogEnd(View v) {
        DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                String selectedDate = String.format("%d-%02d-%02d", year, monthOfYear + 1, dayOfMonth);
                editTextDateSSTC2.setText(selectedDate);
            }
        };
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        DatePickerDialog datePickerDialog = new DatePickerDialog(this, dateSetListener, year, month, day);
        datePickerDialog.show();
    }

    private void initView() {
        back = findViewById(R.id.back);
        home = findViewById(R.id.home);
        buttonSSTC1 = findViewById(R.id.button_sstc1);
        editTextDateSSTC1 = findViewById(R.id.edit_text_date_sstc1);
        editTextDateSSTC2 = findViewById(R.id.edit_text_date_sstc2);
    }
}