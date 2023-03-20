package com.example.myapplication;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class loginActivity extends AppCompatActivity {
    EditText mail1,pass1;
    Button btn_reg,btn_nazad;
    DatabaseReference data,data1,data_ds,data_words;
    SharedPreferences user;

    Boolean pr;
    SQLiteDatabase db1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        pr=true;
        mail1=findViewById(R.id.mail222);
        pass1=findViewById(R.id.pass222);
        btn_reg=findViewById(R.id.auth);
        Intent g=getIntent();
        Boolean naz=g.getBooleanExtra("start",false);
        btn_nazad=findViewById(R.id.nazad2343);
        DBHelper sqlHelper1 = new DBHelper(getApplicationContext());
        db1 = sqlHelper1.getWritableDatabase();
        SQLiteDatabase db = sqlHelper1.getReadableDatabase();
        user=getSharedPreferences("user",MODE_PRIVATE);
        data= FirebaseDatabase.getInstance().getReference("users");
        data1= FirebaseDatabase.getInstance().getReference("users");
        data_ds= FirebaseDatabase.getInstance().getReference("dictionaries");
        data_words= FirebaseDatabase.getInstance().getReference("words");
        btn_reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String mail=mail1.getText().toString();
                String pass=pass1.getText().toString();
                data1.orderByChild("mail").equalTo(mail).addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        for (DataSnapshot us : snapshot.getChildren()){
                            Users users = us.getValue(Users.class);
                            if(pass.equals(users.getPass())){
                                Intent i1 = new Intent(getApplicationContext(),MainActivity.class);
                                String name=users.getName();
                                String id=users.getid();
                                String mail=users.getMail();
                                String pass=users.getPass();
                                SharedPreferences.Editor edituser=user.edit();
                                edituser.putString("id",id);
                                edituser.putString("name",name);
                                edituser.putString("mail",mail);
                                edituser.putString("pass",pass);
                                edituser.apply();
                                startActivity(i1);
                                finish();
                            }else {
                                Toast.makeText(loginActivity.this, "Не правильный пароль", Toast.LENGTH_SHORT).show();

                            }
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                    }
                });

            }
        });
        btn_nazad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    Intent i = new Intent(getApplicationContext(),StartaActivity.class);
                    startActivity(i);
                    finish();
            }
        });

        
    }
    void zap(String idF){
        DBHelper db=new DBHelper(this);
        SQLiteDatabase read = db.getReadableDatabase();
        String [] head = { DBHelper.COLUMN_NAME,DBHelper.COLUMN_ID,DBHelper.COLUMN_IDF};
        Cursor cr=read.query(DBHelper.TABLE_SLOVAR,head,null,null,null,null,null);
        int indexID=cr.getColumnIndex(DBHelper.COLUMN_ID);
        int indexIDF=cr.getColumnIndex(DBHelper.COLUMN_IDF);
        while (cr.moveToNext()){
            if(idF.equals(cr.getString(indexIDF))){
                String i=cr.getString(indexIDF);
                int i1=cr.getInt(indexID);
                data_words.orderByChild("id_ds").equalTo(i).addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        for (DataSnapshot d : snapshot.getChildren()){
                            Words word =d.getValue(Words.class);
                            ContentValues cv =new ContentValues();
                            cv.put(DBHelper.COLUMN_ID_SLOVAR,i1);
                            cv.put(DBHelper.COLUMN_IDF,word.getid());
                            cv.put(DBHelper.COLUMN_SLOVO,word.getword());
                            cv.put(DBHelper.COLUMN_SLOVO_TRANS,word.getwordt());
                            db1.insert(DBHelper.TABLE_SLOVAR1,null,cv);
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });

            }
        }
    }

}