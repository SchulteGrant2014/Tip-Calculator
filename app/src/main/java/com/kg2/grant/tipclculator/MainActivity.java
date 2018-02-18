package com.kg2.grant.tipclculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView newTotalCostView;
    TextView tipView;
    EditText totalCostEdit;
    EditText percentEdit;
    Button calculateButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        newTotalCostView = findViewById(R.id.newTotalCostView);
        tipView = findViewById(R.id.tipView);
        totalCostEdit = findViewById(R.id.totalCostEdit);
        percentEdit = findViewById(R.id.percentEdit);
        calculateButton = findViewById(R.id.calculateButton);

        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double total = Double.parseDouble(totalCostEdit.getText().toString());
                double percent = Double.parseDouble(percentEdit.getText().toString());
                double tip = calculateTip(percent, total);
                double newTotal = calculateNewTotal(tip, total);

                tipView.setText("Tip: $" + Double.toString(tip));
                newTotalCostView.setText("New Total: $" + Double.toString(newTotal));
            }
        });
    }

    protected double calculateTip(double percent, double total) {
        return total * percent;
    }

    protected double calculateNewTotal(double tip, double total) {
        return tip + total;
    }

}
