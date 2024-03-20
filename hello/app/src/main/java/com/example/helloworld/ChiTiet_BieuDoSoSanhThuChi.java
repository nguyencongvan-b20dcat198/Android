package com.example.helloworld;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;

import java.util.ArrayList;

import adapter.MucBieuDoSSTCAdapter;
import adapter.MucBieuDoXHTCAdapter;
import model.MucBieuDoSSTC;
import model.MucBieuDoXHTC;

public class ChiTiet_BieuDoSoSanhThuChi extends AppCompatActivity {
    ListView describeBarChartSSTC;
    BarChart barChartSSTC;
    private ImageView back,home;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chi_tiet_bieu_do_so_sanh_thu_chi);
        initView();

        // Dummy data for the bar chart (three groups of bars)
        ArrayList<BarEntry> group1 = new ArrayList<>();
        group1.add(new BarEntry(1, 100));
        group1.add(new BarEntry(2, 200));
        group1.add(new BarEntry(3, 300));
        group1.add(new BarEntry(4, 150));
        group1.add(new BarEntry(5, 250));

        ArrayList<BarEntry> group2 = new ArrayList<>();
        group2.add(new BarEntry(6, 150));
        group2.add(new BarEntry(7, 250));
        group2.add(new BarEntry(8, 350));
        group2.add(new BarEntry(9, 200));
        group2.add(new BarEntry(10, 100));

        ArrayList<BarEntry> group3 = new ArrayList<>();
        group3.add(new BarEntry(11, 180));
        group3.add(new BarEntry(12, 280));
        group3.add(new BarEntry(13, 170));
        group3.add(new BarEntry(14, 140));
        group3.add(new BarEntry(15, 235));

        // Create a dataset for each group
        BarDataSet dataSet1 = new BarDataSet(group1, "Thu nhập");
        BarDataSet dataSet2 = new BarDataSet(group2, "Chi phí");
        BarDataSet dataSet3 = new BarDataSet(group3, "Còn dư");

        // Set colors for each group
        dataSet1.setColor(Color.BLUE);
        dataSet2.setColor(Color.RED);
        dataSet3.setColor(Color.GREEN);

        // Adjust spacing between groups
        float groupSpace = 0.4f; // Space between groups of bars
        float barSpace = 0f; // Space between each bar within a group
        float barWidth = 0.2f; // Width of each bar

        // Create a BarData object with the datasets
        BarData barData = new BarData(dataSet1, dataSet2, dataSet3);
        barData.setBarWidth(barWidth);

        // Set the data for the chart
        barChartSSTC.setData(barData);

        // Set description (optional)
        Description description = new Description();
        description.setText("");
        barChartSSTC.setDescription(description);

        // Set labels for X-axis (time descriptions for each group)
        String[] timeDescriptions = {"2020", "2021", "2022", "2023", "2024"};
        barChartSSTC.getXAxis().setValueFormatter(new IndexAxisValueFormatter(timeDescriptions));

        // Adjust x-axis
        barChartSSTC.getXAxis().setAxisMinimum(0);
        barChartSSTC.getXAxis().setAxisMaximum(6);
        barChartSSTC.getXAxis().setCenterAxisLabels(true);
        barChartSSTC.groupBars(0, groupSpace, barSpace);

        // Refresh chart
        barChartSSTC.invalidate();

        // Mổ tả biểu đồ so sánh thu nhập
        MucBieuDoSSTCAdapter adapter;
        ArrayList<MucBieuDoSSTC> barChartItems = new ArrayList<>();

        for (int i = 0; i < group1.size(); i++) {
            barChartItems.add(new MucBieuDoSSTC(timeDescriptions[i], group1.get(i).getY(), group2.get(i).getY(), group3.get(i).getY()));
        }

        adapter = new MucBieuDoSSTCAdapter(this, barChartItems);
        describeBarChartSSTC.setAdapter(adapter);

        handleEvent();
    }

    private void handleEvent() {
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ChiTiet_BieuDoSoSanhThuChi.this, BieuDoSoSanhThuChi.class);
                startActivity(intent);
            }
        });
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ChiTiet_BieuDoSoSanhThuChi.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    private void initView() {
        back = findViewById(R.id.back);
        home = findViewById(R.id.home);
        barChartSSTC = findViewById(R.id.bar_chart_sstc);
        describeBarChartSSTC = findViewById(R.id.describe_bar_chart_sstc);
    }
}