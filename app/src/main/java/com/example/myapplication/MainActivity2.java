package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Button btn_nazad= findViewById(R.id.nazad);
        Intent arg=getIntent();
        String nameSLOVAR=arg.getStringExtra("name");
        Intent menu= new Intent(getApplicationContext(), MainActivity3.class);
        btn_nazad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                startActivity(menu);
            }
        });
        DBHelper db=new DBHelper(this);
        SQLiteDatabase read = db.getReadableDatabase();
        String [] head = { DBHelper.COLUMN_NAME};
        Cursor cr=read.query(DBHelper.TABLE_SLOVAR,head,null,null,null,null,null);
        int index=cr.getColumnIndex(DBHelper.COLUMN_NAME);
        int i =0;
        while (cr.moveToNext()){
            i++;
        }
        String[] s={""};
        s[0]=arg.getStringExtra("name");
        final int[] dif = {0};
        TextView e1=findViewById(R.id.ea1);
        TextView e2=findViewById(R.id.ea2);
        TextView sr1=findViewById(R.id.sr1);
        TextView sr2=findViewById(R.id.sr2);
        TextView t1=findViewById(R.id.t1);
        TextView t2=findViewById(R.id.t2);
        TextView p1=findViewById(R.id.p1);
        TextView p2=findViewById(R.id.p2);
        LinearLayout eas=findViewById(R.id.easy);
        LinearLayout srd=findViewById(R.id.sredn);
        LinearLayout d=findViewById(R.id.difcl);
        LinearLayout prac=findViewById(R.id.practic);
        eas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dif[0]=1;
                e1.setVisibility(View.GONE);
                e2.setVisibility(View.VISIBLE);
                sr1.setVisibility(View.VISIBLE);
                sr2.setVisibility(View.GONE);
                t1.setVisibility(View.VISIBLE);
                t2.setVisibility(View.GONE);
                p1.setVisibility(View.VISIBLE);
                p2.setVisibility(View.GONE);
            }
        });
        srd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dif[0]=2;
                e1.setVisibility(View.VISIBLE);
                e2.setVisibility(View.GONE);
                sr1.setVisibility(View.GONE);
                sr2.setVisibility(View.VISIBLE);
                t1.setVisibility(View.VISIBLE);
                t2.setVisibility(View.GONE);
                p1.setVisibility(View.VISIBLE);
                p2.setVisibility(View.GONE);
            }
        });
        d.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dif[0]=3;
                e1.setVisibility(View.VISIBLE);
                e2.setVisibility(View.GONE);
                sr1.setVisibility(View.VISIBLE);
                sr2.setVisibility(View.GONE);
                t1.setVisibility(View.GONE);
                t2.setVisibility(View.VISIBLE);
                p1.setVisibility(View.VISIBLE);
                p2.setVisibility(View.GONE);
            }
        });
        prac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dif[0]=4;
                e1.setVisibility(View.VISIBLE);
                e2.setVisibility(View.GONE);
                sr1.setVisibility(View.VISIBLE);
                sr2.setVisibility(View.GONE);
                t1.setVisibility(View.VISIBLE);
                t2.setVisibility(View.GONE);
                p1.setVisibility(View.GONE);
                p2.setVisibility(View.VISIBLE);
            }
        });
        final Boolean[] pods = {false};
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) SwitchCompat pod=findViewById(R.id.pod);
        pod.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b==true){
                pods[0] =b;
                }else{
                    pods[0] =b;
                }
            }
        });
        DBHelper sqlHelper = new DBHelper(this);
         @SuppressLint({"MissingInflatedId", "LocalSuppress"}) Button start=findViewById(R.id.start2);

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Boolean ds=false;
                if (dif[0]!=0){
                    ds=true;
                }
                if (ds == true){
                    Boolean kolslov = false;
                SQLiteDatabase db = sqlHelper.getReadableDatabase();
                String[] head = {DBHelper.COLUMN_ID, DBHelper.COLUMN_NAME};
                Cursor cr = db.query(DBHelper.TABLE_SLOVAR, head, null, null, null, null, null);
                int idindex = cr.getColumnIndex(DBHelper.COLUMN_ID);
                int nameindex = cr.getColumnIndex(DBHelper.COLUMN_NAME);
                int id = 0;
                while (cr.moveToNext()) {
                    String name = cr.getString(nameindex);
                    if (s[0].equals(name)) {
                        id = cr.getInt(idindex);
                    }
                }
                String[] head1 = {DBHelper.COLUMN_ID_SLOVAR, DBHelper.COLUMN_SLOVO, DBHelper.COLUMN_SLOVO_TRANS};
                cr = db.query(DBHelper.TABLE_SLOVAR1, head1, null, null, null, null, null);
                int wordindex = cr.getColumnIndex(DBHelper.COLUMN_SLOVO);
                int transindex = cr.getColumnIndex(DBHelper.COLUMN_SLOVO_TRANS);
                int idslovar = cr.getColumnIndex(DBHelper.COLUMN_ID_SLOVAR);
                int l = 0;
                while (cr.moveToNext()) {
                    int u = cr.getInt(idslovar);
                    if (id == u) {
                        l++;
                        kolslov = true;
                    }
                }

                String[] word = new String[l];
                String[] wordtransl = new String[l];
                int h = 0;
                cr = db.query(DBHelper.TABLE_SLOVAR1, head1, null, null, null, null, null);

                while (cr.moveToNext()) {
                    int u = cr.getInt(idslovar);
                    if (id == u) {
                        word[h] = cr.getString(wordindex);
                        wordtransl[h] = cr.getString(transindex);
                        h++;
                    }
                }
                String [] vopros=new String[l];
                String [] otvet=new String[l];
                String [] otvetprav=new String[l];
                int ball = 0;
                int ran = (int) (Math.random() * 4) + 1;
                if (kolslov == true) {
                    if (ran == 1) {
                        Intent sl = new Intent(getApplicationContext(), MainActivity61.class);
                        sl.putExtra("name", nameSLOVAR);
                        sl.putExtra("dif", dif[0]);
                        sl.putExtra("pod", pods[0]);
                        sl.putExtra("words", word);
                        sl.putExtra("transl", wordtransl);
                        sl.putExtra("dl", l);
                        sl.putExtra("dl1", l);
                        sl.putExtra("ball", ball);
                        sl.putExtra("vp",vopros);
                        sl.putExtra("ot",otvet);
                        sl.putExtra("otprav",otvetprav);
                        startActivity(sl);
                        finish();
                    } else if (ran == 2) {
                        Intent sl = new Intent(getApplicationContext(), MainActivity62.class);
                        sl.putExtra("name", nameSLOVAR);
                        sl.putExtra("slovar", s[0]);
                        sl.putExtra("dif", dif[0]);
                        sl.putExtra("pod", pods[0]);
                        sl.putExtra("words", word);
                        sl.putExtra("transl", wordtransl);
                        sl.putExtra("dl", l);
                        sl.putExtra("dl1", l);
                        sl.putExtra("ball", ball);
                        sl.putExtra("vp",vopros);
                        sl.putExtra("ot",otvet);
                        sl.putExtra("otprav",otvetprav);
                        startActivity(sl);
                        finish();
                    } else if (ran == 3) {
                        Intent sl = new Intent(getApplicationContext(), MainActivity63.class);
                        sl.putExtra("name", nameSLOVAR);
                        sl.putExtra("dif", dif[0]);
                        sl.putExtra("pod", pods[0]);
                        sl.putExtra("words", word);
                        sl.putExtra("transl", wordtransl);
                        sl.putExtra("dl", l);
                        sl.putExtra("dl1", l);
                        sl.putExtra("ball", ball);
                        sl.putExtra("vp",vopros);
                        sl.putExtra("ot",otvet);
                        sl.putExtra("otprav",otvetprav);
                        startActivity(sl);
                        finish();
                    } else if (ran == 4) {
                        Intent sl = new Intent(getApplicationContext(), MainActivity64.class);
                        sl.putExtra("name", nameSLOVAR);
                        sl.putExtra("dif", dif[0]);
                        sl.putExtra("pod", pods[0]);
                        sl.putExtra("words", word);
                        sl.putExtra("transl", wordtransl);
                        sl.putExtra("dl", l);
                        sl.putExtra("dl1", l);
                        sl.putExtra("ball", ball);
                        sl.putExtra("vp",vopros);
                        sl.putExtra("ot",otvet);
                        sl.putExtra("otprav",otvetprav);
                        startActivity(sl);
                        finish();
                    }
                    db.close();
                } else {
                    Toast.makeText(getApplicationContext(), "В этом словаре не слов!", Toast.LENGTH_LONG).show();
                }
            }else {
                    Toast.makeText(getApplicationContext(), "Выберите сложность", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}