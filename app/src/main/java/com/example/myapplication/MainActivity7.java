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
    ArrayAdapter<String> adapter;
    ListView ls;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main7);
        Intent i =getIntent();
        int bal=i.getIntExtra("ball",0);
        int kol=i.getIntExtra("kol1",0);
        String[] vp=i.getStringArrayExtra("vop");
        String[] ot=i.getStringArrayExtra("ot");
        String[] otprav=i.getStringArrayExtra("otprav");
        String name=i.getStringExtra("name");
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) TextView names=findViewById(R.id.NAMESLOVAR);
        names.setText("Словарь: "+name);
       @SuppressLint({"MissingInflatedId", "LocalSuppress"}) TextView txt=findViewById(R.id.textfin);
     @SuppressLint({"MissingInflatedId", "LocalSuppress"}) Button btn=findViewById(R.id.nazad3);
       txt.setText("Ваш результат:\n"+bal+"/"+kol);
       int l=1;
       int l1=0;
       int l2=0;
       String ot1=" ваш ответ: ";
       String vp1=" Слово: ";
       String otprav1=" правильный ответ: ";
       String [] slov=new String[vp.length];
        while (l2!=kol){
                slov[l1]=l+")"+vp1+vp[kol-1]+ot1+ot[kol-1]+otprav1+otprav[kol-1];
               kol--;
                 l++;
                 l1++;
            }
        adapter=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,slov){
            @Override
            public View getView(int p, View con, ViewGroup parent) {
                View view = super.getView(p, con, parent);
                TextView textView = (TextView) view.findViewById(android.R.id.text1);
                textView.setTextColor(Color.WHITE);
                return view;
            }
        };
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