package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class MainActivity6 extends AppCompatActivity {
    ListView ls;
    String[] deletwords2 = new String[100];
    AdapterView paren;
    String[] deletwords1;
    String[] idf;
    Button delt;
    SQLiteDatabase db2;
    WordAdapter adapter;
    DatabaseReference data_word;
    SharedPreferences user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);
        Intent arg = getIntent();
        String id1 = arg.getStringExtra("id");
        int id = Integer.parseInt(id1);
        String name = arg.getStringExtra("name");
        user = getSharedPreferences("user", MODE_PRIVATE);
        String id4 = user.getString("id", "0");
        data_word = FirebaseDatabase.getInstance().getReference("words");
        DBHelper sqlHelper2 = new DBHelper(this);
        db2 = sqlHelper2.getWritableDatabase();
        ls = findViewById(R.id.LISTVIEW);
        delt = findViewById(R.id.dellt);
        vivodwords(id);
        Button btnna = findViewById(R.id.nazad7);
        Intent in3 = new Intent(this, MainActivity5.class);
        in3.putExtra("id", id1);
        in3.putExtra("name", name);
        Button btndobav = findViewById(R.id.dobav);
        btndobav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(in3);
                finish();
            }
        });
        delt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String [] idF=adapter.getIdsF();
                String [] word=adapter.getWords_del();
                if(!id4.equals("0")){
                    for (String f : idF){
                        if(f!=null){
                            data_word.child(f).removeValue();
                        }
                    }
                }
                for (String f : word){
                    if(f!=null){
                        db2.delete(DBHelper.TABLE_SLOVAR1,"word= ?",new String[]{String.valueOf(f)});
                    }
                }
                vivodwords(id);
            }
        });
        btnna.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent o = new Intent(getApplicationContext(), MainActivity32.class);
                startActivity(o);
                finish();
            }
        });
    }

    public void vivodwords(int id) {
        int blut = 0;
        int blut1 = 0;
        DBHelper sqlHelper = new DBHelper(this);
        SQLiteDatabase db = sqlHelper.getReadableDatabase();
        String[] head = {DBHelper.COLUMN_ID_SLOVAR, DBHelper.COLUMN_SLOVO, DBHelper.COLUMN_SLOVO_TRANS,DBHelper.COLUMN_IDF};
        Cursor cr = db.query(DBHelper.TABLE_SLOVAR1, head, null, null, null, null, null);
        int indexNAME = cr.getColumnIndex(DBHelper.COLUMN_SLOVO);
        int indexID = cr.getColumnIndex(DBHelper.COLUMN_ID_SLOVAR);
        int indextran = cr.getColumnIndex(DBHelper.COLUMN_SLOVO_TRANS);
        int indexIDF = cr.getColumnIndex(DBHelper.COLUMN_IDF);
        while (cr.moveToNext()) {
            int id2 = cr.getInt(indexID);
            if (id == id2) {
                blut++;
            }
        }
        WordsCut[] cuts = new WordsCut[blut];
        Cursor cr1 = db.query(DBHelper.TABLE_SLOVAR1, head, null, null, null, null, null);
        while (cr1.moveToNext()) {
            int id3 = cr1.getInt(indexID);
            if (id == id3) {
                String slovo = cr1.getString(indexNAME);
                String slovo1 = cr1.getString(indextran);
                String slovoID = cr1.getString(indexIDF);
                WordsCut cut=new WordsCut(slovo,slovo1,slovoID);
                cuts[blut1]=cut;
                blut1++;
            }

        }
        adapter= new WordAdapter(getApplicationContext(),cuts);
        ls.setAdapter(adapter);
    }

}