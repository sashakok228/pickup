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
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.ml.common.modeldownload.FirebaseModelDownloadConditions;
import com.google.firebase.ml.naturallanguage.FirebaseNaturalLanguage;
import com.google.firebase.ml.naturallanguage.translate.FirebaseTranslateLanguage;
import com.google.firebase.ml.naturallanguage.translate.FirebaseTranslator;
import com.google.firebase.ml.naturallanguage.translate.FirebaseTranslatorOptions;

public class MainActivity5 extends AppCompatActivity {
    EditText perevod;
    SharedPreferences user;
    DatabaseReference data_ds;
    DatabaseReference data_word;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) Button nz = findViewById(R.id.nazad7);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) Button btndell = findViewById(R.id.btndell);
        Intent arg=getIntent();
        String id1 = arg.getStringExtra("id");
        int id = Integer.parseInt(id1);
        String name4=arg.getStringExtra("name");
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) EditText txtname=findViewById(R.id.name_slovo);
        txtname.setText(name4);
        DBHelper sqlHelper = new DBHelper(this);
        SQLiteDatabase db = sqlHelper.getWritableDatabase();
        DBHelper sqlHelper1 = new DBHelper(getApplicationContext());
        SQLiteDatabase db1 = sqlHelper1.getWritableDatabase();
        DBHelper sqlHelper2 = new DBHelper(getApplicationContext());
        SQLiteDatabase db2 = sqlHelper2.getReadableDatabase();
        String[] head = {DBHelper.COLUMN_ID,DBHelper.COLUMN_IDF, DBHelper.COLUMN_NAME};
        Cursor cr=db2.query(DBHelper.TABLE_SLOVAR,head,null,null,null,null,null);
        int indexID=cr.getColumnIndex(DBHelper.COLUMN_ID);
        int indexNAME=cr.getColumnIndex(DBHelper.COLUMN_NAME);
        int indexIDF=cr.getColumnIndex(DBHelper.COLUMN_IDF);
        String idfSLOV = null;
        while (cr.moveToNext()){
            String nameSLOV=cr.getString(indexNAME);
            String IDSLOV=cr.getString(indexID);
            if(id1.equals(IDSLOV) && name4.equals(nameSLOV)){
                idfSLOV=cr.getString(indexIDF);
            }
        }
        Intent i=new Intent(this,MainActivity32.class);
        EditText name223=findViewById(R.id.name_slovo);
        Intent del=new Intent(getApplicationContext(),MainActivity6.class);
        del.putExtra("id",id1);
        del.putExtra("name",name4);
        data_ds= FirebaseDatabase.getInstance().getReference("dictionaries");
        data_word= FirebaseDatabase.getInstance().getReference("words");
        user=getSharedPreferences("user",MODE_PRIVATE);
        String id4=user.getString("id","0");
        btndell.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(del);
                finish();
            }
        });
        String finalIdfSLOV = idfSLOV;
        nz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nameSLOV=name223.getText().toString();
                if(nameSLOV!=null) {
                    ContentValues val = new ContentValues();
                    val.put(DBHelper.COLUMN_NAME, nameSLOV);
                    if(!id4.equals("0")){
                        Dictionaries dr=new Dictionaries(finalIdfSLOV,id4,nameSLOV);
                        data_ds.child(finalIdfSLOV).setValue(dr);
                        val.put(DBHelper.COLUMN_NAME, nameSLOV);
                        db1.update(DBHelper.TABLE_SLOVAR, val, "id= ?", new String[]{String.valueOf(id)});

                    }
                    startActivity(i);
                    finish();
                    db.close();
                }else {
                    Toast.makeText(getApplicationContext(),"Заполните имя словоря",Toast.LENGTH_LONG).show();
                }
            }
        });
        perevod=findViewById(R.id.perevod);
        Button btntrans = findViewById(R.id.trans);
        final Boolean[] perevod2 = {true};
        final Boolean[] perevod3 = {true};
        btntrans.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (perevod3[0]==true) {
                    perevod2[0] = false;
                    perevod3[0] = false;
                    perevod.setVisibility(View.VISIBLE);
                    btntrans.setText("Использовать переводчик");
                }else {
                    perevod2[0] = true;
                    perevod3[0] = true;
                    perevod.setVisibility(View.GONE);
                    btntrans.setText("Ввести самому перевод слово");
                }
            }
        });
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) EditText edtwordADD=findViewById(R.id.wordADD);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) Button btnwordADD=findViewById(R.id.btnADDword);
        btnwordADD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String txt = edtwordADD.getText().toString();
                String trans = perevod.getText().toString();
                Boolean prva = txt.matches("[a-zA-Z]{1,30}+");
                Boolean prvatrans = trans.matches("[а-яёА-ЯЁ]{1,30}+");
                if (prva == true){
                if (perevod2[0] == true) {
                        edtwordADD.setText("");
                        int lan = FirebaseTranslateLanguage.EN;
                        int lan1 = FirebaseTranslateLanguage.RU;
                        FirebaseTranslatorOptions opt = new FirebaseTranslatorOptions.Builder().setSourceLanguage(lan).setTargetLanguage(lan1).build();
                        FirebaseTranslator trs = FirebaseNaturalLanguage.getInstance().getTranslator(opt);
                        FirebaseModelDownloadConditions con = new FirebaseModelDownloadConditions.Builder().build();
                        ContentValues cv = new ContentValues();
                        trs.downloadModelIfNeeded(con).addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void unused) {
                                trs.translate(txt).addOnSuccessListener(new OnSuccessListener<String>() {
                                    @Override
                                    public void onSuccess(String s) {
                                        Boolean prva = s.matches("[а-яёА-ЯЁ]{1,30}+");
                                        if(prva==true) {
                                            String idf2="0";
                                            cv.put(DBHelper.COLUMN_SLOVO_TRANS, s);
                                            cv.put(DBHelper.COLUMN_SLOVO, txt);
                                            cv.put(DBHelper.COLUMN_ID_SLOVAR, id);
                                            if(!id4.equals("0")){
                                                idf2=data_word.push().getKey();
                                                Words word=new Words(idf2,id4,finalIdfSLOV,txt,s);
                                                data_word.child(idf2).setValue(word);
                                            }
                                            cv.put(DBHelper.COLUMN_IDF, idf2);
                                            db.insert(DBHelper.TABLE_SLOVAR1, null, cv);
                                            Toast.makeText(getApplicationContext(),"Слово '"+txt+"' было добавлена",Toast.LENGTH_LONG).show();
                                        }else {
                                            Toast.makeText(getApplicationContext(),"Слово не переводится на русский",Toast.LENGTH_LONG).show();
                                        }
                                    }
                                });
                            }
                        });
                    }else{
                    if(prvatrans==true) {
                        edtwordADD.setText("");
                        perevod.setText("");
                        ContentValues cv = new ContentValues();
                        String idf2="0";
                        cv.put(DBHelper.COLUMN_SLOVO_TRANS, trans);
                        cv.put(DBHelper.COLUMN_SLOVO, txt);
                        cv.put(DBHelper.COLUMN_ID_SLOVAR, id);
                        cv.put(DBHelper.COLUMN_IDF, idf2);
                        if(!id4.equals("0")){
                            idf2=data_word.push().getKey();
                            Words word=new Words(idf2,id4,finalIdfSLOV,txt,trans);
                            data_word.child(idf2).setValue(word);
                        }
                        db.insert(DBHelper.TABLE_SLOVAR1, null, cv);
                    }else{
                        Toast.makeText(getApplicationContext(),"Введите в перевод одно целое слово на русском",Toast.LENGTH_LONG).show();
                    }
                    }
                }else{
                    Toast.makeText(getApplicationContext(),"Введите одно целое слово на английском",Toast.LENGTH_LONG).show();
                }
            }
        });


        Button btndelSLOVAR=findViewById(R.id.del);
        btndelSLOVAR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name12=name4;
                Intent i =new Intent(getApplicationContext(),MainActivity32.class);
                db1.delete(DBHelper.TABLE_SLOVAR,"name= ?",new String[]{String.valueOf(name12)});
                String [] head = {DBHelper.COLUMN_ID_SLOVAR, DBHelper.COLUMN_SLOVO,DBHelper.COLUMN_SLOVO_TRANS};
                Cursor cr2=db.query(DBHelper.TABLE_SLOVAR1,head,null,null,null,null,null);
                int indexID=cr2.getColumnIndex(DBHelper.COLUMN_ID_SLOVAR);
                while (cr2.moveToNext()){
                    int id2=cr2.getInt(indexID);
                    if(id==id2) {
                        db.delete(DBHelper.TABLE_SLOVAR,"id= ?",new String[]{String.valueOf(id)});
                    }
                }
                if(!id4.equals("0")){
                    data_ds.child(finalIdfSLOV).removeValue();
                    data_word.orderByChild("id_ds").equalTo(finalIdfSLOV).addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            for (DataSnapshot dt : snapshot.getChildren()){
                                dt.getRef().removeValue();
                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });
                }
                startActivity(i);
                finish();
                db1.close();
                db.close();
            }
        });
    }




}