package com.etecmcm.calcularimc;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        inputPeso = findViewById(R.id.inputPeso);
        inputAltura = findViewById(R.id.inputAltura);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        Button btnCalcular = findViewById(R.id.calculaIMC);
        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                float peso = Double.parseDouble(inputPeso.getText().toString());
                float altura = Double.parseDouble(inputAltura.getText().toString());
                float imc = peso / (altura * altura);
                if (imc <= 18.5){
                    return "Abaixo do peso";
                } else if (imc >= 18.5 && imc <= 24.9) {
                    return "Peso normal";
                } else if (imc >= 25 && imc <=29.9) {
                    return "Sobrepeso";
                } else if (imc>=30) {
                    return "Obeso";
                }
            }


        });

    }

    static String calculaIMC(float inputPeso, float inputAltura){



    }
}