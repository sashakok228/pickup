package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity31 extends AppCompatActivity {
    DatabaseReference data;
    SharedPreferences user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main31);
        Button btnN=findViewById(R.id.nazad);
        DBHelper sqlHelper = new DBHelper(this);
        SQLiteDatabase db = sqlHelper.getWritableDatabase();
        SQLiteDatabase dbRead = sqlHelper.getReadableDatabase();
        data= FirebaseDatabase.getInstance().getReference("dictionaries");
        user=getSharedPreferences("user",MODE_PRIVATE);
        String id4=user.getString("id","0");
        Intent naz = new Intent(getApplicationContext(), MainActivity32.class);
        btnN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(naz);
                finish();
            }
        });
        final Boolean[] haveslovar = {true};
        Button makeSlTofind= findViewById(R.id.sohr);
        EditText naSl= findViewById(R.id.name_SLOVAR);
        makeSlTofind.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ContentValues cv = new ContentValues();
                String ns=naSl.getText().toString();
                Boolean prva=ns.matches("[а-яёА-ЯЁa-zA-Z]+");
                String [] headprover={DBHelper.COLUMN_NAME};
                Cursor provercr=dbRead.query(DBHelper.TABLE_SLOVAR,headprover,null,null,null,null,null);
                int indexname=provercr.getColumnIndex(DBHelper.COLUMN_NAME);
                String nameprover="";
                while (provercr.moveToNext()){
                    nameprover=provercr.getString(indexname);
                     if(nameprover.equals(ns)){
                         haveslovar[0] =false;
                     }
                }
                if(haveslovar[0]==true) {
                    if (prva == true) {
                        String id2="0";
                        if(!id4.equals("0")){
                            id2=data.push().getKey();
                            Dictionaries dir = new Dictionaries(id2,id4,ns);
                            data.child(id2).setValue(dir);
                        }
                        cv.put(DBHelper.COLUMN_NAME, ns);
                        cv.put(DBHelper.COLUMN_IDF, id2);
                        db.insert(DBHelper.TABLE_SLOVAR, null, cv);
                        db.close();
                        SQLiteDatabase db = sqlHelper.getReadableDatabase();
                        String[] head = {DBHelper.COLUMN_ID, DBHelper.COLUMN_NAME};
                        Cursor cr = db.query(DBHelper.TABLE_SLOVAR, head, null, null, null, null, null);
                        int indexID = cr.getColumnIndex(DBHelper.COLUMN_ID);
                        int indexNAME = cr.getColumnIndex(DBHelper.COLUMN_NAME);
                        while (cr.moveToNext()) {
                            String id = cr.getString(indexID);
                            String name = cr.getString(indexNAME);
                            if (ns.equals(name)) {
                                Intent i2 = new Intent(getApplicationContext(), MainActivity5.class);
                                i2.putExtra("id", id);
                                i2.putExtra("name", name);
                                startActivity(i2);
                                finish();
                                db.close();
                            }
                        }
                    } else {
                        Toast.makeText(getApplicationContext(), "Введите одно целое слово", Toast.LENGTH_LONG).show();
                    }
                }else{
                    Toast.makeText(getApplicationContext(), "Такой словарь уже есть", Toast.LENGTH_LONG).show();
                }
                haveslovar[0]=true;
            }
        });

    }
}