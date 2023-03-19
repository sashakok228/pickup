package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class OnBoardActivity extends AppCompatActivity {
    SharedPreferences user;
    int i;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_on_board);
        user=getSharedPreferences("user",MODE_PRIVATE);
        SharedPreferences.Editor edituser=user.edit();
        i =0;
        LinearLayout ln = findViewById(R.id.vpe);
        LinearLayout ln3 = findViewById(R.id.ln2);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) ImageView ln1=findViewById(R.id.vpee);
        ln1.setImageResource(R.drawable.imgboard);
        TextView txt=findViewById(R.id.prop);
        ImageView imgshar=findViewById(R.id.shar);
        imgshar.setImageResource(R.drawable.shar1_3);
        ln.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(i==0){
                    ln1.setImageResource(R.drawable.imgboard1);
                    imgshar.setImageResource(R.drawable.shar2_3);
                    i++;
                }else if(i==1){
                    ln1.setImageResource(R.drawable.imgboard2);
                    imgshar.setImageResource(R.drawable.shar3_3);
                    i++;
                }else {
                    Intent p = new Intent(getApplicationContext(),MainActivity.class);
                    startActivity(p);
                    finish();
                    edituser.putBoolean("board",true);
                    edituser.apply();
                }
            }
        });
        ln1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(i==0){
                    ln1.setImageResource(R.drawable.imgboard1);
                    imgshar.setImageResource(R.drawable.shar2_3);
                    i++;
                }else if(i==1){
                    ln1.setImageResource(R.drawable.imgboard2);
                    imgshar.setImageResource(R.drawable.shar3_3);
                    i++;
                }else {
                    Intent p = new Intent(getApplicationContext(),MainActivity.class);
                    edituser.putBoolean("board",true);
                    edituser.apply();
                    startActivity(p);
                    finish();
                }
            }
        });
        ln3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(i==0){
                    ln1.setImageResource(R.drawable.imgboard1);
                    imgshar.setImageResource(R.drawable.shar2_3);
                    i++;
                }else if(i==1){
                    ln1.setImageResource(R.drawable.imgboard2);
                    imgshar.setImageResource(R.drawable.shar3_3);
                    i++;
                }else{
                    Intent p = new Intent(getApplicationContext(),MainActivity.class);
                    edituser.putBoolean("board",true);
                    edituser.apply();
                    startActivity(p);
                    finish();

                }
            }
        });
        txt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent p = new Intent(getApplicationContext(),MainActivity.class);
                edituser.putBoolean("board",true);
                edituser.apply();
                startActivity(p);
                finish();
            }
        });
    }
}