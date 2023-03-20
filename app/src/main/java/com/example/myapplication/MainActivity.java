package com.example.myapplication;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {
    SharedPreferences user;
    DatabaseReference data_words,data_ds,data_ds_gt,data_word_gt;
    SQLiteDatabase db1;

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) Button btn_play =findViewById(R.id.play);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) Button btn_edtSlovar=findViewById(R.id.slovar_redakt);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) Button btn_exit =findViewById(R.id.exit);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) Button btn_reg =findViewById(R.id.reg);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) Button btn_user =findViewById(R.id.profil);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) Button btn_dob =findViewById(R.id.dobav);
        data_ds_gt=FirebaseDatabase.getInstance().getReference("dictionaries_gt");
        data_word_gt=FirebaseDatabase.getInstance().getReference("words_gt");
        btn_dob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String id=data_ds_gt.push().getKey();
                Dictionaries_gt gt=new Dictionaries_gt(id,"");
                data_ds_gt.child(id).setValue(gt);
                int i=0;
                while (i!=10){
                    String id1=data_word_gt.push().getKey();
                    Words_gt gt1=new Words_gt(id1,id,"","");
                    data_word_gt.child(id1).setValue(gt1);
                    i++;
                }
            }
        });
        user=getSharedPreferences("user",MODE_PRIVATE);
        Boolean board=user.getBoolean("board",false);
        if(board==false){
            Intent k = new Intent(getApplicationContext(),OnBoardActivity.class);
            startActivity(k);
            finish();
        }
        String id=user.getString("id","0");
        if(!id.equals("0")) {
            DBHelper sqlHelper1 = new DBHelper(getApplicationContext());
            db1 = sqlHelper1.getWritableDatabase();
            data_words = FirebaseDatabase.getInstance().getReference("words");
            String[] head = {DBHelper.COLUMN_ID};
            Cursor cr1 = db1.query(DBHelper.TABLE_SLOVAR, head, null, null, null, null, null);
            int indexID = cr1.getColumnIndex(DBHelper.COLUMN_ID);
            Cursor cr2 = db1.query(DBHelper.TABLE_SLOVAR1, head, null, null, null, null, null);
            int indexID1 = cr2.getColumnIndex(DBHelper.COLUMN_ID);
            while (cr1.moveToNext()) {
                int id2 = cr1.getInt(indexID);
                db1.delete(DBHelper.TABLE_SLOVAR, "id= ?", new String[]{String.valueOf(id2)});
            }
            while (cr2.moveToNext()) {
                int id2 = cr2.getInt(indexID1);
                db1.delete(DBHelper.TABLE_SLOVAR1, "id= ?", new String[]{String.valueOf(id2)});
            }

            ContentValues cv = new ContentValues();
            data_ds = FirebaseDatabase.getInstance().getReference("dictionaries");
            data_ds.orderByChild("id_user").equalTo(id).addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    for (DataSnapshot hy : snapshot.getChildren()) {
                        Dictionaries dst = hy.getValue(Dictionaries.class);
                        cv.put(DBHelper.COLUMN_NAME, dst.getname());
                        cv.put(DBHelper.COLUMN_IDF, dst.getid());
                        db1.insert(DBHelper.TABLE_SLOVAR, null, cv);
                        zap(dst.getid());
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }
            });
        }
        //Intent reg = new Intent(getApplicationContext(), activity_regestr.class);
        //btn_reg.setOnClickListener(new View.OnClickListener() {
        //    @Override
        //    public void onClick(View view) {
        //        startActivity(reg);
        //        finish();
        //    }
        //});
        Intent play=new Intent(getApplicationContext(),MainActivity3.class);
        btn_play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            startActivity(play);

            }
        });
        Intent edtSlovar=new Intent(getApplicationContext(),MainActivity32.class);
        btn_edtSlovar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                startActivity(edtSlovar);
            }
        });
        //btn_user.setOnClickListener(new View.OnClickListener() {
        //    @Override
        //    public void onClick(View view) {
        //        Intent it=new Intent(getApplicationContext(),user_activity.class);
        //        startActivity(it);
        //        finish();
        //    }
        //});
        btn_exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(id.equals("0")){
                    Intent o=new Intent(getApplicationContext(),StartaActivity.class);
                    startActivity(o);
                    finish();
                }else {
                    Intent o=new Intent(getApplicationContext(),StartaActivity.class);
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
                    startActivity(o);
                    finish();
                }
            }
        });
        //if(id=="0"){
        //    btn_reg.setVisibility(View.VISIBLE);
        //    btn_user.setVisibility(View.GONE);
        //}else {
        //    btn_reg.setVisibility(View.GONE);
        //    btn_user.setVisibility(View.VISIBLE);
        //}

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