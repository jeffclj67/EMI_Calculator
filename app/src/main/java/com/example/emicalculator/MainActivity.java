package com.example.emicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btn;
    RadioGroup radioGroup;
    //RadioButton rd1, rd2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //RadioGroup rg = (RadioGroup) findViewById(R.id.radioGroup);

        btn = findViewById(R.id.btn_calculate);
        radioGroup = findViewById(R.id.radioGroup);

        final EditText principle = findViewById(R.id.input_principle);
        final EditText amortization = findViewById(R.id.input_amortization);

        final EditText outPutMonthly = findViewById(R.id.output_monthly_amount);
        final EditText outPutTotal = findViewById(R.id.output_total_amount);


        btn.setOnClickListener(view -> {
            double rate1 = 0;
            double monthly = 0;
            double total = 0;
            String p = principle.getText().toString();
            String year = amortization.getText().toString();

            int selectId = radioGroup.getCheckedRadioButtonId();
            if (selectId == 2131231196){
                rate1 = 0.0224;
            }else if (selectId == 2131231197){
                rate1 = 0.0229;
            }

            Toast.makeText(this,
                    String.valueOf(rate1), Toast.LENGTH_SHORT).show();

            double prin = Float.parseFloat(p);
            double yr = Float.parseFloat(year);
            double monthly_rate = rate1 / 12;
            double n = yr * 12;
            double exponent = Math.pow((1+monthly_rate), n);
            monthly = prin*(monthly_rate * exponent / (exponent - 1));
            total = monthly * yr * 12;


            outPutMonthly.setText(String.valueOf(String.format("%.2f", monthly)));
            outPutTotal.setText(String.valueOf(String.format("%.2f", total)));
        });
    }

}