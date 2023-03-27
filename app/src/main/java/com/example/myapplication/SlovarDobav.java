package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class SlovarDobav extends AppCompatActivity {
    TextView txt;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slovar_dobav);
        txt=findViewById(R.id.nazvan);
        Intent arg=getIntent();
        int slov=arg.getIntExtra("slovar",0);
        switch (slov){
            case 1:
                txt.setText("Начальные глаголы");
                break;
            case 2:
                txt.setText("Начальные существительные");
                break;
        }
    }
}