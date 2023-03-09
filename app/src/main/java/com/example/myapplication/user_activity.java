package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class user_activity extends AppCompatActivity {
    Button btn_exit,btn_nazad;
    TextView user_name,user_mail;
    SharedPreferences user;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        user=getSharedPreferences("user",MODE_PRIVATE);
        btn_exit=findViewById(R.id.exit_user);
        btn_nazad=findViewById(R.id.nazad23433);
        user_mail=findViewById(R.id.mail_user);
        user_name=findViewById(R.id.name_user);
        DBHelper sqlHelper1 = new DBHelper(getApplicationContext());
        SQLiteDatabase db1 = sqlHelper1.getWritableDatabase();
        user_mail.setText(user.getString("mail","Ошибка"));
        user_name.setText(user.getString("name","Ошибка"));
        btn_nazad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(i);
                finish();
            }
        });
        btn_exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor edt=user.edit();
                edt.remove("id").commit();
                edt.remove("name").commit();
                edt.remove("mail").commit();
                edt.remove("pass").commit();
                String [] head = {DBHelper.COLUMN_ID};
                Cursor cr1=db1.query(DBHelper.TABLE_SLOVAR,head,null,null,null,null,null);
                int indexID=cr1.getColumnIndex(DBHelper.COLUMN_ID);
                Cursor cr2=db1.query(DBHelper.TABLE_SLOVAR1,head,null,null,null,null,null);
                int indexID1=cr2.getColumnIndex(DBHelper.COLUMN_ID);
                while (cr1.moveToNext()){
                    int id=cr1.getInt(indexID);
                    db1.delete(DBHelper.TABLE_SLOVAR,"id= ?",new String[]{String.valueOf(id)});
                }
                while (cr2.moveToNext()){
                    int id=cr2.getInt(indexID1);
                    db1.delete(DBHelper.TABLE_SLOVAR1,"id= ?",new String[]{String.valueOf(id)});
                }
                Intent i=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(i);
                finish();
            }
        });
    }
}