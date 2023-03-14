package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity3 extends AppCompatActivity {

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        Button btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btn10;
        TextView txt1,txt2,txt3,txt4,txt5,txt6,txt7,txt8,txt9,txt10,txtgrust1;
        LinearLayout ln1,ln2,ln3,ln4,ln5,ln6,ln7,ln8,ln9,ln10;
        txtgrust1=findViewById(R.id.grust1);
        txt1=findViewById(R.id.txt1);
        txt2=findViewById(R.id.txt2);
        txt3=findViewById(R.id.txt3);
        txt4=findViewById(R.id.txt4);
        txt5=findViewById(R.id.txt5);
        txt6=findViewById(R.id.txt6);
        txt7=findViewById(R.id.txt7);
        txt8=findViewById(R.id.txt8);
        txt9=findViewById(R.id.txt9);
        txt10=findViewById(R.id.txt10);
        btn1=findViewById(R.id.btn1slov);
        btn2=findViewById(R.id.btn2slov);
        btn3=findViewById(R.id.btn3slov);
        btn4=findViewById(R.id.btn4slov);
        btn5=findViewById(R.id.btn5slov);
        btn6=findViewById(R.id.btn6slov);
        btn7=findViewById(R.id.btn7slov);
        btn8=findViewById(R.id.btn8slov);
        btn9=findViewById(R.id.btn9slov);
        btn10=findViewById(R.id.btn10slov);
        ln1=findViewById(R.id.ln1);
        ln2=findViewById(R.id.ln2);
        ln3=findViewById(R.id.ln3);
        ln4=findViewById(R.id.ln4);
        ln5=findViewById(R.id.ln5);
        ln6=findViewById(R.id.ln6);
        ln7=findViewById(R.id.ln7);
        ln8=findViewById(R.id.ln8);
        ln9=findViewById(R.id.ln9);
        ln10=findViewById(R.id.ln10);
        ln1.setVisibility(View.GONE);
        ln2.setVisibility(View.GONE);
        ln3.setVisibility(View.GONE);
        ln4.setVisibility(View.GONE);
        ln5.setVisibility(View.GONE);
        ln6.setVisibility(View.GONE);
        ln7.setVisibility(View.GONE);
        ln8.setVisibility(View.GONE);
        ln9.setVisibility(View.GONE);
        ln10.setVisibility(View.GONE);
        Boolean b1=false;
        Boolean b2=false;
        Boolean b3=false;
        Boolean b4=false;
        Boolean b5=false;
        Boolean b6=false;
        Boolean b7=false;
        Boolean b8=false;
        Boolean b9=false;
        Boolean b10=false;
        DBHelper db = new DBHelper(this);
        SQLiteDatabase read = db.getReadableDatabase();
        String[] head = {DBHelper.COLUMN_ID, DBHelper.COLUMN_NAME};
        Cursor cr = read.query(DBHelper.TABLE_SLOVAR, head, null, null, null, null, null);
        int indexID=cr.getColumnIndex(DBHelper.COLUMN_ID);
        int indexNAME=cr.getColumnIndex(DBHelper.COLUMN_NAME);
        txtgrust1.setVisibility(View.VISIBLE);
        while (cr.moveToNext()) {
            int kolsl=0;
            if (b1 == false) {
                txtgrust1.setVisibility(View.GONE);
                Boolean k=false;
                String n= cr.getString(indexNAME);
                String name="Словарь: "+n;
                int id = cr.getInt(indexID);
                SQLiteDatabase read1 = db.getReadableDatabase();
                String[] head1 = {DBHelper.COLUMN_ID_SLOVAR,DBHelper.COLUMN_SLOVO};
                Cursor cr1 = read1.query(DBHelper.TABLE_SLOVAR1, head1, null, null, null, null, null);
                int indexIDSL=cr1.getColumnIndex(DBHelper.COLUMN_ID_SLOVAR);
                int indexSLOVO=cr1.getColumnIndex(DBHelper.COLUMN_SLOVO);
                while (cr1.moveToNext()){
                    int idslov=cr1.getInt(indexIDSL);
                    String slov=cr1.getString(indexSLOVO);
                    if(id==idslov){
                        kolsl++;
                    }
                }
                if(kolsl!=0){
                    k=true;
                }
                String name1 = name + "\n Кол-во слов: " + kolsl;
                txt1.setText(name1);
                ln1.setVisibility(View.VISIBLE);
                if(k==true) {
                    btn1.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Intent i = new Intent(getApplicationContext(), MainActivity2.class);
                            i.putExtra("name", n);
                            startActivity(i);
                            finish();
                        }
                    });
                }else{
                    btn1.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Toast.makeText(getApplicationContext(),"В этом словаре нет слов",Toast.LENGTH_LONG).show();
                        }
                    });
                }
                b1=true;
            }else if(b2==false){
                Boolean k=false;
                String n= cr.getString(indexNAME);
                String name="Словарь: "+n;
                int id = cr.getInt(indexID);
                SQLiteDatabase read1 = db.getReadableDatabase();
                String[] head1 = {DBHelper.COLUMN_ID_SLOVAR,DBHelper.COLUMN_SLOVO};
                Cursor cr1 = read1.query(DBHelper.TABLE_SLOVAR1, head1, null, null, null, null, null);
                int indexIDSL=cr1.getColumnIndex(DBHelper.COLUMN_ID_SLOVAR);
                int indexSLOVO=cr1.getColumnIndex(DBHelper.COLUMN_SLOVO);
                while (cr1.moveToNext()){
                    int idslov=cr1.getInt(indexIDSL);
                    String slov=cr1.getString(indexSLOVO);
                    if(id==idslov){
                        kolsl++;
                    }
                }
                if(kolsl!=0){
                    k=true;
                }
                String name1 = name + "\n Кол-во слов: " + kolsl;
                txt2.setText(name1);
                ln2.setVisibility(View.VISIBLE);
                if(k==true) {
                    btn2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Intent i = new Intent(getApplicationContext(), MainActivity2.class);
                            i.putExtra("name", n);
                            startActivity(i);
                            finish();
                        }
                    });
                }else{
                    btn2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Toast.makeText(getApplicationContext(),"В этом словаре нет слов",Toast.LENGTH_LONG).show();
                        }
                    });
                }
                b2=true;
            }else if(b3==false){
                Boolean k=false;
                String n= cr.getString(indexNAME);
                String name="Словарь: "+n;
                int id = cr.getInt(indexID);
                SQLiteDatabase read1 = db.getReadableDatabase();
                String[] head1 = {DBHelper.COLUMN_ID_SLOVAR,DBHelper.COLUMN_SLOVO};
                Cursor cr1 = read1.query(DBHelper.TABLE_SLOVAR1, head1, null, null, null, null, null);
                int indexIDSL=cr1.getColumnIndex(DBHelper.COLUMN_ID_SLOVAR);
                int indexSLOVO=cr1.getColumnIndex(DBHelper.COLUMN_SLOVO);
                while (cr1.moveToNext()){
                    int idslov=cr1.getInt(indexIDSL);
                    String slov=cr1.getString(indexSLOVO);
                    if(id==idslov){
                        kolsl++;
                    }
                }
                if(kolsl!=0){
                    k=true;
                }
                String name1 = name + "\n Кол-во слов: " + kolsl;
                txt3.setText(name1);
                ln3.setVisibility(View.VISIBLE);
                if(k==true) {
                    btn3.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Intent i = new Intent(getApplicationContext(), MainActivity2.class);
                            i.putExtra("name", n);
                            startActivity(i);
                            finish();
                        }
                    });
                }else{
                    btn3.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Toast.makeText(getApplicationContext(),"В этом словаре нет слов",Toast.LENGTH_LONG).show();
                        }
                    });
                }
                b3=true;
            } else if(b4==false){
                Boolean k=false;
                String n= cr.getString(indexNAME);
                String name="Словарь: "+n;
                int id = cr.getInt(indexID);
                SQLiteDatabase read1 = db.getReadableDatabase();
                String[] head1 = {DBHelper.COLUMN_ID_SLOVAR,DBHelper.COLUMN_SLOVO};
                Cursor cr1 = read1.query(DBHelper.TABLE_SLOVAR1, head1, null, null, null, null, null);
                int indexIDSL=cr1.getColumnIndex(DBHelper.COLUMN_ID_SLOVAR);
                int indexSLOVO=cr1.getColumnIndex(DBHelper.COLUMN_SLOVO);
                while (cr1.moveToNext()){
                    int idslov=cr1.getInt(indexIDSL);
                    String slov=cr1.getString(indexSLOVO);
                    if(id==idslov){
                        kolsl++;
                    }
                }
                if(kolsl!=0){
                    k=true;
                }
                String name1 = name + "\n Кол-во слов: " + kolsl;
                txt4.setText(name1);
                ln4.setVisibility(View.VISIBLE);
                if(k==true) {
                    btn4.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Intent i = new Intent(getApplicationContext(), MainActivity2.class);
                            i.putExtra("name", n);
                            startActivity(i);
                            finish();
                        }
                    });
                }else{
                    btn4.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Toast.makeText(getApplicationContext(),"В этом словаре нет слов",Toast.LENGTH_LONG).show();
                        }
                    });
                }
                b4=true;
            }else if(b5==false){
                Boolean k=false;
                String n= cr.getString(indexNAME);
                String name="Словарь: "+n;
                int id = cr.getInt(indexID);
                SQLiteDatabase read1 = db.getReadableDatabase();
                String[] head1 = {DBHelper.COLUMN_ID_SLOVAR,DBHelper.COLUMN_SLOVO};
                Cursor cr1 = read1.query(DBHelper.TABLE_SLOVAR1, head1, null, null, null, null, null);
                int indexIDSL=cr1.getColumnIndex(DBHelper.COLUMN_ID_SLOVAR);
                int indexSLOVO=cr1.getColumnIndex(DBHelper.COLUMN_SLOVO);
                while (cr1.moveToNext()){
                    int idslov=cr1.getInt(indexIDSL);
                    String slov=cr1.getString(indexSLOVO);
                    if(id==idslov){
                        kolsl++;
                    }
                }
                if(kolsl!=0){
                    k=true;
                }
                String name1 = name + "\n Кол-во слов: " + kolsl;
                txt5.setText(name1);
                ln5.setVisibility(View.VISIBLE);
                if(k==true) {
                    btn5.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Intent i = new Intent(getApplicationContext(), MainActivity2.class);
                            i.putExtra("name", n);
                            startActivity(i);
                            finish();
                        }
                    });
                }else{
                    btn5.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Toast.makeText(getApplicationContext(),"В этом словаре нет слов",Toast.LENGTH_LONG).show();
                        }
                    });
                }
                b5=true;
            }else if(b6==false){
                Boolean k=false;
                String n= cr.getString(indexNAME);
                String name="Словарь: "+n;
                int id = cr.getInt(indexID);
                SQLiteDatabase read1 = db.getReadableDatabase();
                String[] head1 = {DBHelper.COLUMN_ID_SLOVAR,DBHelper.COLUMN_SLOVO};
                Cursor cr1 = read1.query(DBHelper.TABLE_SLOVAR1, head1, null, null, null, null, null);
                int indexIDSL=cr1.getColumnIndex(DBHelper.COLUMN_ID_SLOVAR);
                int indexSLOVO=cr1.getColumnIndex(DBHelper.COLUMN_SLOVO);
                while (cr1.moveToNext()){
                    int idslov=cr1.getInt(indexIDSL);
                    String slov=cr1.getString(indexSLOVO);
                    if(id==idslov){
                        kolsl++;
                    }
                }
                if(kolsl!=0){
                    k=true;
                }
                String name1 = name + "\n Кол-во слов: " + kolsl;
                txt6.setText(name1);
                ln6.setVisibility(View.VISIBLE);
                if(k==true) {
                    btn6.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Intent i = new Intent(getApplicationContext(), MainActivity2.class);
                            i.putExtra("name", n);
                            startActivity(i);
                            finish();
                        }
                    });
                }else{
                    btn6.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Toast.makeText(getApplicationContext(),"В этом словаре нет слов",Toast.LENGTH_LONG).show();
                        }
                    });
                }
                b6=true;
            }else if(b7==false){
                Boolean k=false;
                String n= cr.getString(indexNAME);
                String name="Словарь: "+n;
                int id = cr.getInt(indexID);
                SQLiteDatabase read1 = db.getReadableDatabase();
                String[] head1 = {DBHelper.COLUMN_ID_SLOVAR,DBHelper.COLUMN_SLOVO};
                Cursor cr1 = read1.query(DBHelper.TABLE_SLOVAR1, head1, null, null, null, null, null);
                int indexIDSL=cr1.getColumnIndex(DBHelper.COLUMN_ID_SLOVAR);
                int indexSLOVO=cr1.getColumnIndex(DBHelper.COLUMN_SLOVO);
                while (cr1.moveToNext()){
                    int idslov=cr1.getInt(indexIDSL);
                    String slov=cr1.getString(indexSLOVO);
                    if(id==idslov){
                        kolsl++;
                    }
                }
                if(kolsl!=0){
                    k=true;
                }
                String name1 = name + "\n Кол-во слов: " + kolsl;
                txt7.setText(name1);
                ln7.setVisibility(View.VISIBLE);
                if(k==true) {
                    btn7.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Intent i = new Intent(getApplicationContext(), MainActivity2.class);
                            i.putExtra("name",n);
                            startActivity(i);
                            finish();
                        }
                    });
                }else{
                    btn7.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Toast.makeText(getApplicationContext(),"В этом словаре нет слов",Toast.LENGTH_LONG).show();
                        }
                    });
                }
                b7=true;
            }else if(b8==false){
                Boolean k=false;
                String n= cr.getString(indexNAME);
                String name="Словарь: "+n;
                int id = cr.getInt(indexID);
                SQLiteDatabase read1 = db.getReadableDatabase();
                String[] head1 = {DBHelper.COLUMN_ID_SLOVAR,DBHelper.COLUMN_SLOVO};
                Cursor cr1 = read1.query(DBHelper.TABLE_SLOVAR1, head1, null, null, null, null, null);
                int indexIDSL=cr1.getColumnIndex(DBHelper.COLUMN_ID_SLOVAR);
                while (cr1.moveToNext()){
                    int idslov=cr1.getInt(indexIDSL);
                    if(id==idslov){
                        kolsl++;
                    }
                }
                if(kolsl!=0){
                    k=true;
                }
                String name1 = name + "\n Кол-во слов: " + kolsl;
                txt8.setText(name1);
                ln8.setVisibility(View.VISIBLE);
                if(k==true) {
                    btn8.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Intent i = new Intent(getApplicationContext(), MainActivity2.class);
                            i.putExtra("name", n);
                            startActivity(i);
                            finish();
                        }
                    });
                }else{
                    btn8.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Toast.makeText(getApplicationContext(),"В этом словаре нет слов",Toast.LENGTH_LONG).show();
                        }
                    });
                }
                b8=true;
            }else if(b9==false){
                Boolean k=false;
                String n= cr.getString(indexNAME);
                String name="Словарь: "+n;
                int id = cr.getInt(indexID);
                SQLiteDatabase read1 = db.getReadableDatabase();
                String[] head1 = {DBHelper.COLUMN_ID_SLOVAR,DBHelper.COLUMN_SLOVO};
                Cursor cr1 = read1.query(DBHelper.TABLE_SLOVAR1, head1, null, null, null, null, null);
                int indexIDSL=cr1.getColumnIndex(DBHelper.COLUMN_ID_SLOVAR);
                int indexSLOVO=cr1.getColumnIndex(DBHelper.COLUMN_SLOVO);
                while (cr1.moveToNext()){
                    int idslov=cr1.getInt(indexIDSL);
                    String slov=cr1.getString(indexSLOVO);
                    if(id==idslov){
                        kolsl++;
                    }
                }
                if(kolsl!=0){
                    k=true;
                }
                String name1 = name + "\n Кол-во слов: " + kolsl;
                txt9.setText(name1);
                ln9.setVisibility(View.VISIBLE);
                if(k==true) {
                    btn9.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Intent i = new Intent(getApplicationContext(), MainActivity2.class);
                            i.putExtra("name", n);
                            startActivity(i);
                            finish();
                        }
                    });
                }else{
                    btn9.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Toast.makeText(getApplicationContext(),"В этом словаре нет слов",Toast.LENGTH_LONG).show();
                        }
                    });
                }
                b9=true;
            }else if(b10==false){
                Boolean k=false;
                String n= cr.getString(indexNAME);
                String name="Словарь: "+n;
                int id = cr.getInt(indexID);
                SQLiteDatabase read1 = db.getReadableDatabase();
                String[] head1 = {DBHelper.COLUMN_ID_SLOVAR,DBHelper.COLUMN_SLOVO};
                Cursor cr1 = read1.query(DBHelper.TABLE_SLOVAR1, head1, null, null, null, null, null);
                int indexIDSL=cr1.getColumnIndex(DBHelper.COLUMN_ID_SLOVAR);
                int indexSLOVO=cr1.getColumnIndex(DBHelper.COLUMN_SLOVO);
                while (cr1.moveToNext()){
                    int idslov=cr1.getInt(indexIDSL);
                    String slov=cr1.getString(indexSLOVO);
                    if(id==idslov){
                        kolsl++;
                    }
                }
                if(kolsl!=0){
                    k=true;
                }
                String name1 = name + "\n Кол-во слов: " + kolsl;
                txt10.setText(name1);
                ln10.setVisibility(View.VISIBLE);
                if(k==true) {
                    btn10.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Intent i = new Intent(getApplicationContext(), MainActivity2.class);
                            i.putExtra("name",n);
                            startActivity(i);
                            finish();
                        }
                    });
                }else{
                    btn10.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Toast.makeText(getApplicationContext(),"В этом словаре нет слов",Toast.LENGTH_LONG).show();
                        }
                    });
                }
                b10=true;
            }
        }
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) Button btnnaz=findViewById(R.id.nazad243);
        Intent h=new Intent(this,MainActivity.class);
        btnnaz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(h);
                finish();
            }
        });
    }
}