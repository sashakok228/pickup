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

public class MainActivity32 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main32);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) Button nz = findViewById(R.id.nazad6);
        Intent t = new Intent(getApplicationContext(), MainActivity.class);
       nz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(t);
                finish();
            }
        });
        Intent t1 = new Intent(getApplicationContext(), MainActivity31.class);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) Button dobvslov = findViewById(R.id.dobaslov);
        dobvslov.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(t1);
                finish();

            }
        });
        int val = public_pole();
        if (val == 10) {
            dobvslov.setVisibility(View.GONE);
        }


    }

    public int public_pole() {
        DBHelper db = new DBHelper(this);
        SQLiteDatabase read = db.getReadableDatabase();
        String[] head = {DBHelper.COLUMN_ID, DBHelper.COLUMN_NAME};
        Cursor cr = read.query(DBHelper.TABLE_SLOVAR, head, null, null, null, null, null);
        Boolean p1 = true;
        Boolean p2 = true;
        Boolean p3 = true;
        Boolean p4 = true;
        Boolean p5 = true;
        Boolean p6 = true;
        Boolean p7 = true;
        Boolean p8 = true;
        Boolean p9 = true;
        Boolean p10 = true;
        TextView tx1, tx2, tx3, tx4, tx5, tx6, tx7, tx8, tx9, tx10, tx1KOL, tx2KOL, tx3KOL, tx4KOL, tx5KOL, tx6KOL, tx7KOL, tx8KOL, tx9KOL, tx10KOL;
        Button btv1, btv2, btv3, btv4, btv5, btv6, btv7, btv8, btv9, btv10;
        Button btd1, btd2, btd3, btd4, btd5, btd6, btd7, btd8, btd9, btd10;
        LinearLayout ln1, ln2, ln3, ln4, ln5, ln6, ln7, ln8, ln9, ln10;
        tx1KOL =findViewById(R.id.tx1KOL);
        tx2KOL =findViewById(R.id.tx2KOL);
        tx3KOL =findViewById(R.id.tx3KOL);
        tx4KOL =findViewById(R.id.tx4KOL);
        tx5KOL =findViewById(R.id.tx5KOL);
        tx6KOL =findViewById(R.id.tx6KOL);
        tx7KOL =findViewById(R.id.tx7KOL);
        tx8KOL =findViewById(R.id.tx8KOL);
        tx9KOL =findViewById(R.id.tx9KOL);
        tx10KOL =findViewById(R.id.tx10KOL);
        ln1 = findViewById(R.id.ln1);
        ln2 = findViewById(R.id.ln2);
        ln3 = findViewById(R.id.ln3);
        ln4 = findViewById(R.id.ln4);
        ln5 = findViewById(R.id.ln5);
        ln6 = findViewById(R.id.ln6);
        ln7 = findViewById(R.id.ln7);
        ln8 = findViewById(R.id.ln8);
        ln9 = findViewById(R.id.ln9);
        ln10 = findViewById(R.id.ln10);
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
        tx1 = findViewById(R.id.tx1);
        tx2 = findViewById(R.id.tx2);
        tx3 = findViewById(R.id.tx3);
        tx4 = findViewById(R.id.tx4);
        tx5 = findViewById(R.id.tx5);
        tx6 = findViewById(R.id.tx6);
        tx7 = findViewById(R.id.tx7);
        tx8 = findViewById(R.id.tx8);
        tx9 = findViewById(R.id.tx9);
        tx10 = findViewById(R.id.tx10);
        btv1 = findViewById(R.id.bt_v1);
        btv2 = findViewById(R.id.bt_v2);
        btv3 = findViewById(R.id.bt_v3);
        btv4 = findViewById(R.id.bt_v4);
        btv5 = findViewById(R.id.bt_v5);
        btv6 = findViewById(R.id.bt_v6);
        btv7 = findViewById(R.id.bt_v7);
        btv8 = findViewById(R.id.bt_v8);
        btv9 = findViewById(R.id.bt_v9);
        btv10 = findViewById(R.id.bt_v10);
        btd1 = findViewById(R.id.bt_d1);
        btd2 = findViewById(R.id.bt_d2);
        btd3 = findViewById(R.id.bt_d3);
        btd4 = findViewById(R.id.bt_d4);
        btd5 = findViewById(R.id.bt_d5);
        btd6 = findViewById(R.id.bt_d6);
        btd7 = findViewById(R.id.bt_d7);
        btd8 = findViewById(R.id.bt_d8);
        btd9 = findViewById(R.id.bt_d9);
        btd10 = findViewById(R.id.bt_d10);
        TextView grust=findViewById(R.id.grust);

        int INDEX_ID = cr.getColumnIndex(DBHelper.COLUMN_ID);
        int INDEX_NAME = cr.getColumnIndex(DBHelper.COLUMN_NAME);
        int value_r = 0;
        while (cr.moveToNext()) {
            ln1.setVisibility(View.VISIBLE);
            Intent i1 = new Intent(this, MainActivity32.class);
            int id = cr.getInt(INDEX_ID);
            String id1 = String.valueOf(id);
            String name = cr.getString(INDEX_NAME);
            if (p1 == true) {
                grust.setVisibility(View.GONE);
                tx1.setText("Словарь: "+name);
                p1 = false;
                int kolsl=0;
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
                tx1KOL.setText("Кол-во слов: "+kolsl);
                Intent sl1 = new Intent(this, MainActivity5.class);
                Intent slg1 = new Intent(this, MainActivity6.class);
                sl1.putExtra("id", id1);
                sl1.putExtra("name", name);
                slg1.putExtra("id", id1);
                slg1.putExtra("name", name);
                btv1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        startActivity(sl1);
                        finish();
                    }
                });
                btd1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        startActivity(slg1);
                        finish();
                    }
                });
            } else if (p2 == true) {
                ln2.setVisibility(View.VISIBLE);
                tx2.setText("Словарь: "+name);
                p2 = false;
                int kolsl=0;
                SQLiteDatabase read1 = db.getReadableDatabase();
                String[] head1 = {DBHelper.COLUMN_ID_SLOVAR};
                Cursor cr1 = read1.query(DBHelper.TABLE_SLOVAR1, head1, null, null, null, null, null);
                int indexIDSL=cr1.getColumnIndex(DBHelper.COLUMN_ID_SLOVAR);
                while (cr1.moveToNext()){
                    int idslov=cr1.getInt(indexIDSL);
                    if(id==idslov){
                        kolsl++;
                    }
                }
                tx2KOL.setText("Кол-во слов: "+kolsl);
                Intent sl2 = new Intent(this, MainActivity5.class);
                Intent slg2 = new Intent(this, MainActivity6.class);
                sl2.putExtra("id", id1);
                sl2.putExtra("name", name);
                slg2.putExtra("id", id1);
                slg2.putExtra("name", name);
                btv2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        startActivity(sl2);
                        finish();
                    }
                });
                btd2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        startActivity(slg2);
                        finish();
                    }
                });
            } else if (p3 == true) {
                ln3.setVisibility(View.VISIBLE);
                tx3.setText("Словарь: "+name);
                p3 = false;
                int kolsl=0;
                SQLiteDatabase read1 = db.getReadableDatabase();
                String[] head1 = {DBHelper.COLUMN_ID_SLOVAR};
                Cursor cr1 = read1.query(DBHelper.TABLE_SLOVAR1, head1, null, null, null, null, null);
                int indexIDSL=cr1.getColumnIndex(DBHelper.COLUMN_ID_SLOVAR);
                while (cr1.moveToNext()){
                    int idslov=cr1.getInt(indexIDSL);
                    if(id==idslov){
                        kolsl++;
                    }
                }
                tx3KOL.setText("Кол-во слов: "+kolsl);
                Intent sl3 = new Intent(this, MainActivity5.class);
                Intent slg3 = new Intent(this, MainActivity6.class);
                sl3.putExtra("id", id1);
                sl3.putExtra("name", name);
                slg3.putExtra("id", id1);
                slg3.putExtra("name", name);
                btv3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        startActivity(sl3);
                        finish();
                    }
                });
                btd3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        startActivity(slg3);
                        finish();
                    }
                });
            } else if (p4 == true) {
                ln4.setVisibility(View.VISIBLE);
                tx4.setText("Словарь: "+name);
                p4 = false;
                int kolsl=0;
                SQLiteDatabase read1 = db.getReadableDatabase();
                String[] head1 = {DBHelper.COLUMN_ID_SLOVAR};
                Cursor cr1 = read1.query(DBHelper.TABLE_SLOVAR1, head1, null, null, null, null, null);
                int indexIDSL=cr1.getColumnIndex(DBHelper.COLUMN_ID_SLOVAR);
                while (cr1.moveToNext()){
                    int idslov=cr1.getInt(indexIDSL);
                    if(id==idslov){
                        kolsl++;
                    }
                }
                tx4KOL.setText("Кол-во слов: "+kolsl);
                Intent sl4 = new Intent(this, MainActivity5.class);
                Intent slg4 = new Intent(this, MainActivity6.class);
                sl4.putExtra("id", id1);
                sl4.putExtra("name", name);
                slg4.putExtra("id", id1);
                slg4.putExtra("name", name);
                btv4.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        startActivity(sl4);
                        finish();
                    }
                });
                btd4.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        startActivity(slg4);
                        finish();
                    }
                });
            } else if (p5 == true) {
                ln5.setVisibility(View.VISIBLE);
                tx5.setText("Словарь: "+name);
                p5 = false;
                int kolsl=0;
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
                tx5KOL.setText("Кол-во слов: "+kolsl);
                Intent sl5 = new Intent(this, MainActivity5.class);
                Intent slg5 = new Intent(this, MainActivity6.class);
                sl5.putExtra("id", id1);
                sl5.putExtra("name", name);
                slg5.putExtra("id", id1);
                slg5.putExtra("name", name);
                btv5.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        startActivity(sl5);
                        finish();
                    }
                });
                btd5.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        startActivity(slg5);
                        finish();
                    }
                });
            } else if (p6 == true) {
                ln6.setVisibility(View.VISIBLE);
                tx6.setText("Словарь: "+name);
                p6 = false;
                int kolsl=0;
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
                tx6KOL.setText("Кол-во слов: "+kolsl);
                Intent sl6 = new Intent(this, MainActivity5.class);
                Intent slg6 = new Intent(this, MainActivity6.class);
                sl6.putExtra("id", id1);
                sl6.putExtra("name", name);
                slg6.putExtra("id", id1);
                slg6.putExtra("name", name);
                btv6.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        startActivity(sl6);
                        finish();
                    }
                });
                btd6.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        startActivity(slg6);
                        finish();
                    }
                });
            } else if (p7 == true) {
                ln7.setVisibility(View.VISIBLE);
                tx7.setText("Словарь: "+name);
                p7 = false;
                int kolsl=0;
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
                tx7KOL.setText("Кол-во слов: "+kolsl);
                Intent sl7 = new Intent(this, MainActivity5.class);
                Intent slg7 = new Intent(this, MainActivity6.class);
                sl7.putExtra("id", id1);
                sl7.putExtra("name", name);
                slg7.putExtra("id", id1);
                slg7.putExtra("name", name);
                btv7.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        startActivity(sl7);
                        finish();
                    }
                });
                btd7.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        startActivity(slg7);
                        finish();
                    }
                });
            } else if (p8 == true) {
                ln8.setVisibility(View.VISIBLE);
                tx8.setText("Словарь: "+name);
                p8 = false;
                int kolsl=0;
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
                tx8KOL.setText("Кол-во слов: "+kolsl);
                Intent sl8 = new Intent(this, MainActivity5.class);
                Intent slg8 = new Intent(this, MainActivity6.class);
                sl8.putExtra("id", id1);
                sl8.putExtra("name", name);
                slg8.putExtra("id", id1);
                slg8.putExtra("name", name);
                btv8.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        startActivity(sl8);
                        finish();
                    }
                });
                btd8.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        startActivity(slg8);
                        finish();
                    }
                });
            } else if (p9 == true) {
                ln9.setVisibility(View.VISIBLE);
                tx9.setText("Словарь: "+name);
                p9 = false;
                int kolsl=0;
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
                tx9KOL.setText("Кол-во слов: "+kolsl);
                Intent sl9 = new Intent(this, MainActivity5.class);
                Intent slg9 = new Intent(this, MainActivity6.class);
                sl9.putExtra("id", id1);
                sl9.putExtra("name", name);
                slg9.putExtra("id", id1);
                slg9.putExtra("name", name);
                btv9.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        startActivity(sl9);
                        finish();
                    }
                });
                btd9.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        startActivity(slg9);
                        finish();
                    }
                });
            } else if (p10 == true) {
                ln10.setVisibility(View.VISIBLE);
                tx10.setText("Словарь: "+name);
                p10 = false;
                int kolsl=0;
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
                tx10KOL.setText("Кол-во слов: "+kolsl);
                Intent sl10 = new Intent(this, MainActivity5.class);
                Intent slg10 = new Intent(this, MainActivity6.class);
                sl10.putExtra("id", id1);
                sl10.putExtra("name", name);
                slg10.putExtra("id", id1);
                slg10.putExtra("name", name);
                btv10.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        startActivity(sl10);
                        finish();
                    }
                });
                btd10.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        startActivity(slg10);
                        finish();
                    }
                });
            }
            value_r++;

        }
        return value_r;
    }

}