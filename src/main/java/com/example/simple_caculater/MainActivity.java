package com.example.simple_caculater;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText number1;
    private EditText number2;
    private TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        number1 = findViewById(R.id.number1);
        number2 = findViewById(R.id.number2);
        Button addition = findViewById(R.id.addition);
        Button subtraction = findViewById(R.id.subtraction);
        Button multiplication = findViewById(R.id.multiplication);
        Button division = findViewById(R.id.division);
        result = findViewById(R.id.result);

        addition.setOnClickListener(v -> performOperation("+"));

        subtraction.setOnClickListener(v -> performOperation("-"));

        multiplication.setOnClickListener(v -> performOperation("*"));

        division.setOnClickListener(v -> performOperation("/"));
    }

    @SuppressLint("SetTextI18n")
    private void performOperation(String operation) {
        double num1 = Double.parseDouble(number1.getText().toString());
        double num2 = Double.parseDouble(number2.getText().toString());
        double resultValue = 0;

        switch (operation) {
            case "+":
                resultValue = num1 + num2;
                break;
            case "-":
                resultValue = num1 - num2;
                break;
            case "*":
                resultValue = num1 * num2;
                break;
            case "/":
                if (num2 != 0) {
                    resultValue = num1 / num2;
                } else {
                    result.setText("Cannot divide by zero");
                    return;
                }
                break;
        }

        result.setText(String.valueOf(resultValue));
    }
}