package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity7 extends AppCompatActivity {
    WordAdapterOtvet adapter;
    ListView ls;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main7);
        Intent i =getIntent();
        int bal=i.getIntExtra("ball",0);
        int kol=i.getIntExtra("kol1",0);
        String[] vp=i.getStringArrayExtra("vop");
        String[] ot=i.getStringArrayExtra("otprav");
        String[] otprav=i.getStringArrayExtra("ot");
        String name=i.getStringExtra("name");
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) TextView names=findViewById(R.id.NAMESLOVAR);
        names.setText("Словарь: "+name);
       @SuppressLint({"MissingInflatedId", "LocalSuppress"}) TextView txt=findViewById(R.id.textfin);
     @SuppressLint({"MissingInflatedId", "LocalSuppress"}) Button btn=findViewById(R.id.nazad3);
       txt.setText("Ваш результат:\n"+bal+"/"+kol);
        int l=1;
       int l2=0;
       String pust="";
       WordsCutOtvet [] slov=new WordsCutOtvet[vp.length];
        while (l2!=kol){
            if(ot[kol-1].equals(pust)){
                ot[kol-1]="нет ответа";
            }
            WordsCutOtvet ot2 =new WordsCutOtvet(String.valueOf(l),vp[kol-1],ot[kol-1],otprav[kol-1]);
            slov[kol-1]=ot2;
            l++;
            kol--;
        }
        adapter=new WordAdapterOtvet(getApplicationContext(),slov);
        ls=findViewById(R.id.LISTVIEW22);
        ls.setAdapter(adapter);
        btn.setOnClickListener(new View.OnClickListener() {
           @Override
            public void onClick(View view) {
                Intent yt=new Intent(getApplicationContext(),MainActivity.class);
               startActivity(yt);
               finish();
            }
        });
    }
}