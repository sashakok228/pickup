package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class activity_regestr extends AppCompatActivity {
    DatabaseReference data;
    Boolean p2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regestr);
        p2=true;
        Intent g=getIntent();
        Boolean naz=g.getBooleanExtra("start",false);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) EditText mailEDT=findViewById(R.id.mail2);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) EditText nameEDT=findViewById(R.id.name2);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) EditText passEDT=findViewById(R.id.pass2);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) EditText passEDT1=findViewById(R.id.pass22);
        Button btn_reg=findViewById(R.id.reg);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) TextView btn_auth=findViewById(R.id.auth22);
        Button btn_nazad=findViewById(R.id.nazad234);
        data= FirebaseDatabase.getInstance().getReference("users");
        btn_auth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getApplicationContext(), loginActivity.class);
                startActivity(i);
                finish();
            }
        });
        btn_nazad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    Intent nazad = new Intent(getApplicationContext(), StartaActivity.class);
                    startActivity(nazad);
                    finish();
            }
        });
        btn_reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name=nameEDT.getText().toString();
                String mail=mailEDT.getText().toString();
                String pass=passEDT.getText().toString();
                String pass1=passEDT1.getText().toString();
                if (name.isEmpty() || mail.isEmpty() || pass.isEmpty() || pass1.isEmpty()) {
                    Toast.makeText(getApplicationContext(),"Заполните поля",Toast.LENGTH_LONG).show();
                }else {
                    if(pass.equals(pass1)){
                        if( Patterns.EMAIL_ADDRESS.matcher(mail).matches()){
                            String[] nameE = {null};
                            String[] mailE = {null};
                            boolean[] prover={true};
                            boolean[] prover1={true};
                            int[] kol={0};
                            int[] kol1={0};

                            data.addListenerForSingleValueEvent(new ValueEventListener() {
                                @Override
                                public void onDataChange(@NonNull DataSnapshot snapshot) {
                                    for (DataSnapshot da: snapshot.getChildren()){
                                        kol[0]++;
                                    }
                                }

                                @Override
                                public void onCancelled(@NonNull DatabaseError error) {

                                }
                            });
                            data.addListenerForSingleValueEvent(new ValueEventListener() {
                                @Override
                                public void onDataChange(@NonNull DataSnapshot snapshot) {
                                    for (DataSnapshot ds : snapshot.getChildren()){
                                        Users user=ds.getValue(Users.class);
                                        nameE[0] =user.getName();
                                        mailE[0] =user.getMail();

                                        if(nameE[0].equals(name)){
                                            prover[0]=false;
                                        }
                                        if(mailE[0].equals(mail)){
                                            prover1[0]=false;
                                        }
                                        kol1[0]++;
                                        if(kol[0]==kol1[0]){
                                            prover(prover[0],prover1[0],p2,name,mail,pass);
                                            break;
                                        }
                                    }
                                }
                                @Override
                                public void onCancelled(@NonNull DatabaseError error) {

                                }
                            });
                        }else{
                            Toast.makeText(getApplicationContext(), "Такой email невозможен", Toast.LENGTH_SHORT).show();
                        }
                    }else {
                        Toast.makeText(getApplicationContext(),"Пароли не одинаковые",Toast.LENGTH_LONG).show();
                    }
                }


            }
        });
    }
    void prover(Boolean p,Boolean p1,Boolean p2,String name, String mail, String pass){
        if (p2==true) {
            if (p == true) {
                if (p1 == true) {
                    saveDatabase(name, mail, pass);
                } else {
                    Toast.makeText(getApplicationContext(), "Уже есть профиль с таким номером телефоном", Toast.LENGTH_LONG).show();
                }
            } else {
                Toast.makeText(getApplicationContext(), "Уже есть профиль с таким именем", Toast.LENGTH_LONG).show();
            }
        }
    }
    void saveDatabase(String name, String mail, String pass){
        String id=data.push().getKey();
        Users user=new Users(id,name, mail, pass);
        data.child(id).setValue(user);
        p2=false;
        Intent i1=new Intent(getApplicationContext(),loginActivity.class);
        startActivity(i1);
        finish();
    }
}