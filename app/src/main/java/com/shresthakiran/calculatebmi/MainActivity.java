package com.shresthakiran.calculatebmi;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText etGender;
    EditText etAge;
    EditText etHeight;
    EditText etWeight;
    Button btnGetBMI;
    TextView tvBMIResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etGender = findViewById(R.id.etGender);
        etAge = findViewById(R.id.etAge);
        etHeight = findViewById(R.id.etHeight);
        etWeight = findViewById(R.id.etWeight);
        btnGetBMI = findViewById(R.id.btnGetBMI);
        tvBMIResult = findViewById(R.id.tvBMIResult);
        tvBMIResult.setVisibility(View.GONE);

        btnGetBMI.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {

                String gender, bmi_status = "";
                int age;
                double height = 0.0, weight = 0.0;

                if(etGender.getText().toString().isEmpty()){
                    Toast.makeText(MainActivity.this, "Gender cannot be empty", Toast.LENGTH_SHORT).show();
                }else{
                    gender = etGender.getText().toString();
                }
                if(etAge.getText().toString().isEmpty()){
                    Toast.makeText(MainActivity.this, "Age cannot be empty", Toast.LENGTH_SHORT).show();
                }else{
                    String sage = etAge.getText().toString();
                    age = Integer.parseInt(sage);
                }
                if(etHeight.getText().toString().isEmpty()){
                    Toast.makeText(MainActivity.this, "Height cannot be empty", Toast.LENGTH_SHORT).show();
                }else{
                    String sheight = etHeight.getText().toString();
                    height = Double.parseDouble(sheight);
                }
                if(etWeight.getText().toString().isEmpty()){
                    Toast.makeText(MainActivity.this, "Weight cannot be empty", Toast.LENGTH_SHORT).show();
                }else{
                    String sweight = etWeight.getText().toString();
                    weight = Double.parseDouble(sweight);
                }

                double bmi = weight/(height*height);
                if(bmi < 18.5){
                    bmi_status = "You are underweight.";
                }else if(bmi >= 18.5 && bmi<= 24.9){
                    bmi_status = "Your weight is suitable for your height.";
                }else if(bmi > 24.9 && bmi <=39.9){
                    bmi_status = "You are obese.";
                }else if(bmi > 39.9 && bmi>40){
                    bmi_status = "You are morbidly obese.";
                }
                tvBMIResult.setText("Your BMI is "+bmi+".\n"+bmi_status);
                tvBMIResult.setVisibility(View.VISIBLE);
            }
        });
    }
}
