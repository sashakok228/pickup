package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class GtdsActivity extends AppCompatActivity {
    LinearLayout zg1,zg2;
    TextView btnzg1,btnzg2;
    Button btnN;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gtds);
        zg1=findViewById(R.id.zg1);
        zg2=findViewById(R.id.zg2);
        btnzg1=findViewById(R.id.btn_gt1);
        btnzg2=findViewById(R.id.btn_gt2);
        btnN=findViewById(R.id.nazad72424);
        btnN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i =new Intent(getApplicationContext(),MainActivity31.class);
                startActivity(i);
                finish();
            }
        });
        btnzg1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),dszag_Activity.class);
                i.putExtra("slovar",1);
                startActivity(i);
            }
        });
        zg1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),dszag_Activity.class);
                i.putExtra("slovar",1);
                startActivity(i);
            }
        });
        zg2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),dszag_Activity.class);
                i.putExtra("slovar",2);
                startActivity(i);
            }
        });
        btnzg2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),dszag_Activity.class);
                i.putExtra("slovar",2);
                startActivity(i);
            }
        });
    }
}