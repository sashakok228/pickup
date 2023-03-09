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

public class MainActivity6 extends AppCompatActivity {
    ListView ls;
    String[] deletwords2 = new String[100];
    AdapterView paren;
    String[] deletwords1;
    String[] idf;
    Button delt;
    SQLiteDatabase db2;
    ArrayAdapter<String> adapter;
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
        deletwords1 = vivodwords(id);
        idf = vivodwords22(id);
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
        ls.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                paren = adapterView;
            }
        });
        delt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (paren != null) {
                    SparseBooleanArray chosen = ((ListView) paren).getCheckedItemPositions();
                    for (int i = 0; i < chosen.size(); i++) {
                        if (chosen.valueAt(i)) {
                            String deletword = deletwords1[chosen.keyAt(i)];
                            db2.delete(DBHelper.TABLE_SLOVAR1, "word = ?", new String[]{String.valueOf(deletword)});
                            if (!id4.equals("0")) {
                                String deletword1 = idf[chosen.keyAt(i)];
                                data_word.child(deletword1).removeValue();
                            }
                        }
                    }
                    deletwords1 = vivodwords(id);
                    idf = vivodwords22(id);
                    paren = null;
                } else {
                    Toast.makeText(getApplicationContext(), "Вы не выбрали слова", Toast.LENGTH_LONG).show();
                }
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

    public String[] vivodwords(int id) {
        String txt = "Слово: ";
        String txt1 = "Перевод: ";
        int blut = 0;
        int blut1 = 0;
        DBHelper sqlHelper = new DBHelper(this);
        SQLiteDatabase db = sqlHelper.getReadableDatabase();
        String[] head = {DBHelper.COLUMN_ID_SLOVAR, DBHelper.COLUMN_SLOVO, DBHelper.COLUMN_SLOVO_TRANS};
        Cursor cr = db.query(DBHelper.TABLE_SLOVAR1, head, null, null, null, null, null);
        int indexNAME = cr.getColumnIndex(DBHelper.COLUMN_SLOVO);
        int indexID = cr.getColumnIndex(DBHelper.COLUMN_ID_SLOVAR);
        int indextran = cr.getColumnIndex(DBHelper.COLUMN_SLOVO_TRANS);
        while (cr.moveToNext()) {
            int id2 = cr.getInt(indexID);
            if (id == id2) {
                blut++;
            }
        }
        String[] slova = new String[blut];
        String[] slova1 = new String[blut];
        Cursor cr1 = db.query(DBHelper.TABLE_SLOVAR1, head, null, null, null, null, null);
        while (cr1.moveToNext()) {
            int id3 = cr1.getInt(indexID);
            if (id == id3) {
                String slovo = cr1.getString(indexNAME);
                String slovo1 = cr1.getString(indextran);
                String txt3 = txt + slovo + " " + txt1 + slovo1;
                slova1[blut1] = slovo;
                slova[blut1] = txt3;
                blut1++;
            }

        }
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_multiple_choice, slova) {
            @Override
            public View getView(int p, View con, ViewGroup parent) {
                View view = super.getView(p, con, parent);
                TextView textView = view.findViewById(android.R.id.text1);
                textView.setTextColor(Color.WHITE);
                return view;
            }
        };
        ls.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        ls.setAdapter(adapter);
        return slova1;
    }

    public String[] vivodwords22(int id) {
        DBHelper sqlHelper = new DBHelper(this);
        int blut = 0;
        int blut1 = 0;
        SQLiteDatabase db = sqlHelper.getReadableDatabase();
        String[] head = {DBHelper.COLUMN_ID_SLOVAR, DBHelper.COLUMN_IDF, DBHelper.COLUMN_SLOVO_TRANS};
        Cursor cr = db.query(DBHelper.TABLE_SLOVAR1, head, null, null, null, null, null);
        int indexID = cr.getColumnIndex(DBHelper.COLUMN_ID_SLOVAR);
        while (cr.moveToNext()) {
            int id2 = cr.getInt(indexID);
            if (id == id2) {
                blut++;
            }
        }
        String[] idf = new String[blut];
        Cursor cr1 = db.query(DBHelper.TABLE_SLOVAR1, head, null, null, null, null, null);
        int indexIDF = cr1.getColumnIndex(DBHelper.COLUMN_IDF);
        while (cr1.moveToNext()) {
            int id3 = cr1.getInt(indexID);
            if (id == id3) {
                idf[blut1] = cr1.getString(indexIDF);
                blut1++;
            }
        }
        return idf;
    }
}