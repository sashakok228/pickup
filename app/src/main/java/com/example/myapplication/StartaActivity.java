package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.Objects;

public class StartaActivity extends AppCompatActivity {
    SharedPreferences user;
    Intent i;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_starta);
        user=getSharedPreferences("user",MODE_PRIVATE);
        String id=user.getString("id","0");
        if(!id.equals("0")){
            i = new Intent(getApplicationContext(),MainActivity.class);
            startActivity(i);
            finish();
        }
        Button btn_reg=findViewById(R.id.reg);
        btn_reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 i = new Intent(getApplicationContext(),activity_regestr.class);
                i.putExtra("start",true);

                startActivity(i);
                finish();
            }
        });
        Button btn_auth=findViewById(R.id.ath);
        btn_auth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 i = new Intent(getApplicationContext(),loginActivity.class);
                i.putExtra("start",true);

                startActivity(i);
                finish();
            }
        });
        Button btn_goust=findViewById(R.id.goust);
        btn_goust.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                i = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(i);
                finish();
            }
        });
    }
}