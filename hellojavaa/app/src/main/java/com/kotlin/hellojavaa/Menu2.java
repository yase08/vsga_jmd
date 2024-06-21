package com.kotlin.hellojavaa;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Menu2 extends AppCompatActivity {
    private EditText firstNumber, secondNumber;
    private Button plusButton, minusButton, timesButton, bagiButton, clearButton, modButton;
    private TextView resultNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu2);

        firstNumber = findViewById(R.id.firstNumber);
        secondNumber = findViewById(R.id.secondNumber);
        plusButton = findViewById(R.id.plusButton);
        minusButton = findViewById(R.id.minusButton);
        timesButton = findViewById(R.id.timesButton);
        modButton = findViewById(R.id.modButton);
        bagiButton = findViewById(R.id.bagiButton);
        resultNumber = findViewById(R.id.resultNumber);
        clearButton = findViewById(R.id.clearButton);

        clearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                firstNumber.setText("");
                secondNumber.setText("");
            }
        });

        minusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculate("-");
            }
        });

        timesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculate("*");
            }
        });

        bagiButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculate("/");
            }
        });

        plusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculate("+");
            }
        });

        modButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculate("%");
            }
        });
    }

    void calculate(String type) {
        if(firstNumber.getText().toString().isEmpty() || secondNumber.getText().toString().isEmpty()) {
            Toast.makeText(this, "first number or second number should'nt be empty", Toast.LENGTH_SHORT).show();
            return;
        }

        double result = 0.0;
        double num1 = Double.parseDouble(firstNumber.getText().toString());
        double num2 = Double.parseDouble(secondNumber.getText().toString());

        switch (type) {
            case "*":
                result = num1 * num2;
                break;
            case "+":
                result = num1 + num2;
                break;
            case "%":
                result = num1 % num2;
                break;
            case "/":
                if(num2 != 0) {
                    result = num1 / 2;
                } else {
                    Toast.makeText(this, "Cannot divided by zero", Toast.LENGTH_SHORT).show();
                }
                break;
            case "-":
                result = num1 - num2;
                break;
            default:
                Toast.makeText(this, "Invalid operation type", Toast.LENGTH_SHORT).show();
        }

        resultNumber.setText(String.valueOf(result));
    }
}
