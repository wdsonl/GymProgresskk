package com.example.gymprogress;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class PeitoActivity extends AppCompatActivity {

    private Button voltarBt;

    private EditText pesoJAVA;
    private static String arquivo_peso = "0";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_peito);

        pesoJAVA = findViewById(R.id.editTextPeso);
        voltarBt = findViewById(R.id.voltarBt);
        voltarBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences Peso = getSharedPreferences(arquivo_peso, 0);
                SharedPreferences.Editor pesoedit = Peso.edit();

                String Peso1 = pesoJAVA.getText().toString();
                pesoedit.putString("peso", Peso1);
                pesoedit.commit();
                pesoJAVA.setText(Peso1);

                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });

        SharedPreferences Peso = getSharedPreferences(arquivo_peso, 0);
        String Peso1 = Peso.getString("peso", "peso não definido");
        pesoJAVA.setText(Peso1);

    }
}