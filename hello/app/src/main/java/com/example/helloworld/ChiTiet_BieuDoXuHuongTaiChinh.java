package com.example.helloworld;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.formatter.PercentFormatter;

import java.util.ArrayList;
import java.util.List;

import adapter.MucBieuDoXHTCAdapter;
import model.MucBieuDoXHTC;

public class ChiTiet_BieuDoXuHuongTaiChinh extends AppCompatActivity {
    ListView describePieChartXHTC;
    PieChart pieChartXHTC;
    private ImageView back,home;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chi_tiet_bieu_do_xu_huong_tai_chinh);
        initView();
        handlePieChartXHTC();

        handleEvent();
    }

    private void handlePieChartXHTC() {
        List<PieEntry> pieEntries = new ArrayList<>();
        pieEntries.add(new PieEntry(30000f, "Giáo dục"));
        pieEntries.add(new PieEntry(20000f, "Sức khỏe"));
        pieEntries.add(new PieEntry(500000f, "Giải trí"));

        // Tính tổng của tất cả các giá trị trên biểu đồ
        float totalValue = 0;
        for (PieEntry entry : pieEntries) {
            totalValue += entry.getValue();
        }

        PieDataSet dataSet = new PieDataSet(pieEntries, "");
        dataSet.setColors(Color.RED, Color.GREEN, Color.BLUE); // Màu của các phần tử trong biểu đồ, màu TRANSPARENT cho phần tử tổng
        dataSet.setDrawValues(false);
        dataSet.setDrawIcons(false);

        PieData data = new PieData(dataSet);
        data.setValueFormatter(new PercentFormatter(pieChartXHTC)); // Hiển thị giá trị phần trăm

        // Tùy chỉnh các thuộc tính của biểu đồ Pie
        pieChartXHTC.getDescription().setEnabled(false);
        pieChartXHTC.setDrawHoleEnabled(true);
        pieChartXHTC.setHoleColor(Color.WHITE);
        pieChartXHTC.setTransparentCircleRadius(61f);
        pieChartXHTC.setCenterText(String.format("%.2f", totalValue) + " vnđ"); // Hiển thị giá trị tổng ở giữa biểu đồ
        pieChartXHTC.setCenterTextSize(20);
        pieChartXHTC.setDrawEntryLabels(false);

        // Tắt màu mô tả
        pieChartXHTC.getLegend().setEnabled(false);

        pieChartXHTC.setData(data);
        pieChartXHTC.animateY(1000); // Animation

        // Mổ tả biểu đồ xu hướng tài chính
        MucBieuDoXHTCAdapter adapter;
        ArrayList<MucBieuDoXHTC> pieChartItems = new ArrayList<>();

        for (int i = 0; i < pieEntries.size(); i++) {
            pieChartItems.add(new MucBieuDoXHTC(pieEntries.get(i).getLabel() ,(pieEntries.get(i).getValue()/totalValue)*100, pieEntries.get(i).getValue(), dataSet.getColor(i)));
        }

        adapter = new MucBieuDoXHTCAdapter(this, pieChartItems);
        describePieChartXHTC.setAdapter(adapter);

    }

    private void handleEvent() {
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ChiTiet_BieuDoXuHuongTaiChinh.this, BieuDoXuHuongTaiChinh.class);
                startActivity(intent);
            }
        });
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ChiTiet_BieuDoXuHuongTaiChinh.this, BieuDoXuHuongTaiChinh.class);
                startActivity(intent);
            }
        });
    }

    private void initView() {
        back = findViewById(R.id.back);
        home = findViewById(R.id.home);
        pieChartXHTC = findViewById(R.id.pie_chart_xhtc);
        describePieChartXHTC = findViewById(R.id.describe_pie_chart_xhtc);
    }
}