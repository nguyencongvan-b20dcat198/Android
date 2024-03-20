package adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.helloworld.R;

import java.util.ArrayList;

import model.MucBieuDoSSTC;

public class MucBieuDoSSTCAdapter extends ArrayAdapter<MucBieuDoSSTC> {
    private TextView barChartItemTime, barChartItemIncome, barChartItemExpense, barChartItemResidual;
    private Context context;
    private ArrayList<MucBieuDoSSTC> barChartItems;


    public MucBieuDoSSTCAdapter(@NonNull Context context, ArrayList<MucBieuDoSSTC> barChartItems) {
        super(context, R.layout.muc_bieu_do_sstc, barChartItems);
        this.context = context;
        this.barChartItems = barChartItems;
    }

    @SuppressLint("DefaultLocale")
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);
        @SuppressLint("ViewHolder") View view = inflater.inflate(R.layout.muc_bieu_do_sstc, null, true);

        barChartItemTime = view.findViewById(R.id.bar_chart_item_time_sstc);
        barChartItemIncome = view.findViewById(R.id.bar_chart_item_income_sstc);
        barChartItemExpense = view.findViewById(R.id.bar_chart_item_expense_sstc);
        barChartItemResidual = view.findViewById(R.id.bar_chart_item_residual_sstc);

        MucBieuDoSSTC m = barChartItems.get(position);

        barChartItemTime.setText(m.getTime());
        barChartItemIncome.setText(String.format("%.2f", m.getIncome()) + " vnđ");
        barChartItemExpense.setText(String.format("%.2f", m.getExpense()) + " vnđ");
        barChartItemResidual.setText(String.format("%.2f", m.getResidual()) + " vnđ");

        return view;
    }

    public MucBieuDoSSTC getItem(int position) {
        return barChartItems.get(position);
    }
}
