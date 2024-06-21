package com.kotlin.hellojavaa;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Menu1 extends AppCompatActivity {

    private EditText inputName;
    private Button buttonSubmit;
    private TextView textResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu1);

        inputName = findViewById(R.id.inputname);
        textResult = findViewById(R.id.result);
        buttonSubmit = findViewById(R.id.submit);

        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                String name = inputName.getText().toString();

                if(name.equalsIgnoreCase("")) {
                    Toast.makeText(Menu1.this, "Input name is required", Toast.LENGTH_SHORT).show();
                } else {
                    textResult.setText("Your name is " + name);
                    inputName.setText("");
                    buttonSubmit.setBackgroundColor(Color.RED);
                }
            }
        });
    }
}
