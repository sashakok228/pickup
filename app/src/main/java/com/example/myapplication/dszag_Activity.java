package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class dszag_Activity extends AppCompatActivity {

    Button btnN,btnZ;
    WordAdapterMod adapter;
    DatabaseReference data_ds;
    DatabaseReference data_word;
    ListView slova;
    EditText gtds;
    SharedPreferences user;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dszag);
        btnN=findViewById(R.id.nazad10);
        slova=findViewById(R.id.list3);
        btnZ=findViewById(R.id.btnzggtds);
        user=getSharedPreferences("user",MODE_PRIVATE);
        data_word= FirebaseDatabase.getInstance().getReference("words");
        data_ds= FirebaseDatabase.getInstance().getReference("dictionaries");
        DBHelper sqlHelper = new DBHelper(this);
        SQLiteDatabase db = sqlHelper.getWritableDatabase();
        gtds=findViewById(R.id.name_SLOVARgdds);
        String id4=user.getString("id","0");
        btnN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent naz=new Intent(getApplicationContext(),GtdsActivity.class);
                startActivity(naz);
                finish();
            }
        });
        Intent get=getIntent();
        int i =get.getIntExtra("slovar",0);
        if(i==1){
            WordsCut[] cuts = {new WordsCut("go","идти","0"),new WordsCut("have","иметь что то","0"),new WordsCut("know","знать","0"),new WordsCut("try","пытаться","0"),
                    new WordsCut("see","видеть","0"),new WordsCut("come","приходить","0"),new WordsCut("want","хотеть","0"),new WordsCut("do","делать","0"),new WordsCut("say","сказать","0"),
                    new WordsCut("work","работать","0"),
            };
            adapter=new WordAdapterMod(getApplicationContext(),cuts);
            slova.setAdapter(adapter);
            btnZ.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Boolean prva=gtds.getText().toString().matches("[а-яёА-ЯЁa-zA-Z]+");
                    if (prva == true) {
                        String id2 = "0";
                        String nam=gtds.getText().toString();
                        if (!id4.equals("0")) {
                            id2 = data_ds.push().getKey();
                            Dictionaries dir = new Dictionaries(id2, id4, nam);
                            data_ds.child(id2).setValue(dir);
                        }
                        for (WordsCut h : cuts) {
                            String idf2 = "0";
                            if (!id4.equals("0")) {
                                idf2 = data_word.push().getKey();
                                Words word = new Words(idf2, id4, id2, h.getWord(), h.getWordT());
                                data_word.child(idf2).setValue(word);
                            }
                        }
                        Intent i = new Intent(getApplicationContext(), MainActivity.class);
                        Toast.makeText(getApplicationContext(), "Словар загружен", Toast.LENGTH_SHORT).show();
                        startActivity(i);
                        finish();
                    }else {
                        Toast.makeText(getApplicationContext(), "Вы не ввели имя словаря   ", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }else if(i==2){

            WordsCut[] cuts = {new WordsCut("age","возвраст","0"),new WordsCut("animal","животное","0"),new WordsCut("car","автомобиль","0"),new WordsCut("city","город","0"),
                    new WordsCut("country","странна","0"),new WordsCut("day","день","0"),new WordsCut("air","воздух","0"),new WordsCut("bank","банк","0"),new WordsCut("end","конец","0"),
                    new WordsCut("food","еда","0"),
            };
            adapter=new WordAdapterMod(getApplicationContext(),cuts);
            slova.setAdapter(adapter);
            btnZ.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Boolean prva = gtds.getText().toString().matches("[а-яёА-ЯЁa-zA-Z]+");
                    if (prva == true) {
                        String id2 = "0";
                        String nam=gtds.getText().toString();
                        if (!id4.equals("0")) {
                            id2 = data_ds.push().getKey();
                            Dictionaries dir = new Dictionaries(id2, id4, nam);
                            data_ds.child(id2).setValue(dir);
                        }
                        for (WordsCut h : cuts) {
                            String idf2 = "0";
                            if (!id4.equals("0")) {
                                idf2 = data_word.push().getKey();
                                Words word = new Words(idf2, id4, id2, h.getWord(), h.getWordT());
                                data_word.child(idf2).setValue(word);
                            }
                        }
                        Intent i = new Intent(getApplicationContext(), MainActivity.class);
                        Toast.makeText(getApplicationContext(), "Словар загружен", Toast.LENGTH_SHORT).show();
                        startActivity(i);
                        finish();
                    }else {
                        Toast.makeText(getApplicationContext(), "Вы не ввели имя словаря", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }
}