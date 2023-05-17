package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Locale;


public class MainActivitygame extends AppCompatActivity {
    Button btnotvet1,btnotvet2,btnotvet3,btnotvet4,btnotvet5,btnslevslovo,btnstop,sluh,stop;
    TextView txtds;
    TextView txtnnslovo;
    TextView peres;
    TextView nadp;
    TextView podskaska;
    CountDownTimer timer;
    ProgressBar progressBar;
    EditText edttxt;
    LinearLayout lr1,lr2,lr3;
    String [] ds_o,ds_p,ds_uo,ds_otv,ds_vop;
    int dlina,hol,ball,i,df1;
    TextToSpeech tts;
    Boolean podskask;
    String name;

    int vidpod;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maingame);
        init();
        Intent arg = getIntent();
        name=arg.getStringExtra("name");
        df1=arg.getIntExtra("dif", 0);
        vidpod=1;
        podskask=arg.getBooleanExtra("pod", false);
        String [] ds_o=arg.getStringArrayExtra("vp");
        String [] ds_p=arg.getStringArrayExtra("ot");
        dlina=ds_o.length;
        ds_uo=new String[dlina];
        ds_otv=new String[dlina];
        ds_vop=new String[dlina];
        zapuck(df1,ds_o,ds_p);
        hol=0;
        ball=0;
        i=0;
        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i =new Intent(getApplicationContext(),MainActivity3.class);
                startActivity(i);
                finish();
            }
        });
        txtds.setText(name);
        tts=new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if(status== TextToSpeech.SUCCESS){
                    tts.setLanguage(Locale.ENGLISH);
                }
            }
        });
    }
    void init(){
        stop=findViewById(R.id.stop22);
        btnotvet1=findViewById(R.id.otv1);
        btnotvet2=findViewById(R.id.otv2);
        btnotvet3=findViewById(R.id.otv3);
        btnotvet4=findViewById(R.id.otv4);
        btnotvet5=findViewById(R.id.otv5);
        btnslevslovo=findViewById(R.id.dal);
        btnstop=findViewById(R.id.stop22);
        txtds=findViewById(R.id.nameds);
        txtnnslovo=findViewById(R.id.textZap);
        progressBar=findViewById(R.id.progressBar);
        peres=findViewById(R.id.peres);
        edttxt=findViewById(R.id.textvvod);
        lr1=findViewById(R.id.lri1);
        lr2=findViewById(R.id.lri2);
        lr3=findViewById(R.id.lri3);
        nadp=findViewById(R.id.nadp);
        sluh=findViewById(R.id.sluh);
        podskaska=findViewById(R.id.podskaska);
    }
    void zapuck( int df,String []ds1,String [] ds2){
        switch (df){
            case (1):
                i=3;
                switch (i){
                    case (1):
                        vidpod=1;
                        progressBar.setMax(50000);
                        progressBar.setProgress(50000);
                        int k =randomMOD();
                        StartTime(50000,df,k,ds1,ds2);
                        pokaz(1);
                        if(k==1){
                            txtnnslovo.setText(ds1[hol]);
                            btnslevslovo.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    ds_otv[hol]=ds2[hol];
                                    ds_vop[hol]=ds1[hol];
                                    if (edttxt.getText().toString().equals(ds2[hol])) {
                                        if ((dlina - 1) == hol) {
                                            ball++;
                                            ds_uo[hol]=edttxt.getText().toString();
                                            timer.cancel();
                                            per(name,ds_vop,ds_otv,hol,ball,ds_uo);
                                        } else {
                                            ds_uo[hol]=edttxt.getText().toString();
                                            ball++;
                                            hol++;
                                            timer.cancel();
                                            zapuck(df, ds1, ds2);
                                        }
                                    } else {
                                        if ((dlina - 1) == hol) {
                                            ds_uo[hol]=edttxt.getText().toString();
                                            timer.cancel();
                                            per(name,ds_vop,ds_otv,hol,ball,ds_uo);
                                        } else {
                                            timer.cancel();
                                            ds_uo[hol]=edttxt.getText().toString();
                                            hol++;
                                            zapuck(df, ds1, ds2);
                                        }
                                    }
                                    edttxt.setText("");
                                    podskaska.setVisibility(View.GONE);
                                }
                            });
                        }else {
                            txtnnslovo.setText(ds2[hol]);
                            btnslevslovo.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    ds_otv[hol]=ds2[hol];
                                    ds_vop[hol]=ds1[hol];
                                    if (edttxt.getText().toString().equals(ds1[hol])) {
                                        if ((dlina - 1) == hol) {
                                            ball++;
                                            timer.cancel();
                                            ds_uo[hol]=edttxt.getText().toString();
                                            per(name,ds_vop,ds_otv,hol,ball,ds_uo);
                                        } else {
                                            ball++;
                                            timer.cancel();
                                            ds_uo[hol]=edttxt.getText().toString();
                                            hol++;
                                            zapuck(df, ds1, ds2);
                                        }
                                    } else {
                                        if ((dlina - 1) == hol) {
                                            timer.cancel();
                                            per(name,ds_vop,ds_otv,hol,ball,ds_uo);
                                        } else {
                                            timer.cancel();
                                            ds_uo[hol]=edttxt.getText().toString();
                                            hol++;
                                            zapuck(df, ds1, ds2);
                                        }
                                    }
                                    edttxt.setText("");
                                    podskaska.setVisibility(View.GONE);
                                }
                            });
                        }
                        break;
                    case (2):
                        vidpod=2;
                        progressBar.setMax(40000);
                        progressBar.setProgress(40000);
                        k =randomMOD();
                        StartTime(40000,k,df,ds1,ds2);
                        int otvet=randomeasy();
                        pokaz(2);
                        if(k==1){
                            txtnnslovo.setText(ds1[hol]);
                            knopka(otvet,df,ds2[hol],k);
                            otvet(ds2[hol],df,ds1,ds2);
                            ds_otv[hol]=ds2[hol];
                            ds_vop[hol]=ds1[hol];
                        }else {
                            txtnnslovo.setText(ds2[hol]);
                            knopka(otvet,df,ds1[hol],k);
                            otvet(ds1[hol],df,ds1,ds2);
                            ds_otv[hol]=ds1[hol];
                            ds_vop[hol]=ds2[hol];
                        }
                        break;
                    case (3):
                        vidpod=1;
                        pokaz(3);
                        progressBar.setMax(40000);
                        progressBar.setProgress(40000);
                        StartTime(40000,df,0,ds1,ds2);
                        sluh.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                tts.speak(ds1[hol],TextToSpeech.QUEUE_FLUSH,null);
                            }
                        });
                        btnslevslovo.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                String otv=edttxt.getText().toString();
                                ds_otv[hol]=ds1[hol];
                                ds_vop[hol]=ds1[hol];
                                if(ds1[hol].equals(otv)){
                                    if ((dlina - 1) == hol) {
                                        timer.cancel();
                                        ball++;
                                        ds_uo[hol]=edttxt.getText().toString();
                                        per(name,ds_vop,ds_otv,hol,ball,ds_uo);
                                    } else {
                                        timer.cancel();
                                        ball++;
                                        ds_uo[hol]=edttxt.getText().toString();
                                        hol++;
                                        zapuck(df, ds1, ds2);
                                    }
                                }else {
                                    if ((dlina - 1) == hol) {
                                        timer.cancel();
                                        ds_uo[hol]=edttxt.getText().toString();
                                        per(name,ds_vop,ds_otv,hol,ball,ds_uo);
                                    } else {
                                        timer.cancel();
                                        ds_uo[hol]=edttxt.getText().toString();
                                        hol++;
                                        zapuck(df, ds1, ds2);
                                    }
                                }
                                podskaska.setVisibility(View.GONE);
                                edttxt.setText("");
                            }
                        });
                        break;
                }
                break;
            case (2):
                i=random();
                switch (i){
                    case (1):
                        vidpod=1;
                        progressBar.setMax(40000);
                        progressBar.setProgress(40000);
                        int k =randomMOD();
                        StartTime(40000,df,k,ds1,ds2);
                        pokaz(1);
                        if(k==1){
                            txtnnslovo.setText(ds1[hol]);
                            btnslevslovo.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    ds_otv[hol]=ds2[hol];
                                    ds_vop[hol]=ds1[hol];
                                    if (edttxt.getText().toString().equals(ds2[hol])) {
                                        if ((dlina - 1) == hol) {
                                            timer.cancel();
                                            ball++;
                                            ds_uo[hol]=edttxt.getText().toString();
                                            per(name,ds_vop,ds_otv,hol,ball,ds_uo);
                                        } else {
                                            timer.cancel();
                                            ds_uo[hol]=edttxt.getText().toString();
                                            ball++;
                                            hol++;
                                            zapuck(df, ds1, ds2);
                                        }
                                    } else {
                                        if ((dlina - 1) == hol) {
                                            timer.cancel();
                                            ds_uo[hol]=edttxt.getText().toString();
                                            per(name,ds_vop,ds_otv,hol,ball,ds_uo);
                                        } else {
                                            timer.cancel();
                                            ds_uo[hol]=edttxt.getText().toString();
                                            hol++;
                                            zapuck(df, ds1, ds2);
                                        }
                                    }
                                    podskaska.setVisibility(View.GONE);
                                    edttxt.setText("");
                                }
                            });
                        }else {
                            txtnnslovo.setText(ds2[hol]);
                            btnslevslovo.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    ds_otv[hol]=ds1[hol];
                                    ds_vop[hol]=ds2[hol];
                                    if (edttxt.getText().toString().equals(ds1[hol])) {
                                        if ((dlina - 1) == hol) {
                                            timer.cancel();
                                            ds_uo[hol]=edttxt.getText().toString();
                                            ball++;
                                            per(name,ds_vop,ds_otv,hol,ball,ds_uo);
                                        } else {
                                            timer.cancel();
                                            ds_uo[hol]=edttxt.getText().toString();
                                            ball++;
                                            hol++;
                                            zapuck(df, ds1, ds2);
                                        }
                                    } else {
                                        if ((dlina - 1) == hol) {
                                            timer.cancel();
                                            ds_uo[hol]=edttxt.getText().toString();
                                            per(name,ds_vop,ds_otv,hol,ball,ds_uo);
                                        } else {
                                            timer.cancel();
                                            ds_uo[hol]=edttxt.getText().toString();
                                            hol++;
                                            zapuck(df, ds1, ds2);
                                        }
                                    }
                                    podskaska.setVisibility(View.GONE);
                                    edttxt.setText("");
                                }
                            });
                        }
                        break;
                    case (2):
                        vidpod=2;
                        progressBar.setMax(30000);
                        progressBar.setProgress(30000);
                        k =randomMOD();
                        StartTime(30000,df,k,ds1,ds2);
                        int otvet=randomsrdn();
                        pokaz(2);
                        if(k==1){
                            txtnnslovo.setText(ds1[hol]);
                            knopka(otvet,df,ds2[hol],k);
                            otvet(ds2[hol],df,ds1,ds2);
                            ds_otv[hol]=ds2[hol];
                            ds_vop[hol]=ds1[hol];
                        }else {
                            txtnnslovo.setText(ds2[hol]);
                            knopka(otvet,df,ds1[hol],k);
                            otvet(ds1[hol],df,ds1,ds2);
                            ds_otv[hol]=ds1[hol];
                            ds_vop[hol]=ds2[hol];
                        }
                        break;
                    case (3):
                        vidpod=1;
                        pokaz(3);
                        progressBar.setMax(40000);
                        progressBar.setProgress(40000);
                        StartTime(40000,df,0,ds1,ds2);
                        sluh.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                tts.speak(ds1[hol],TextToSpeech.QUEUE_FLUSH,null);
                            }
                        });
                        btnslevslovo.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                ds_otv[hol]=ds1[hol];
                                ds_vop[hol]=ds1[hol];
                                String otv=edttxt.getText().toString();
                                if(ds1[hol].equals(otv)){
                                    if ((dlina - 1) == hol) {
                                        ds_uo[hol]=edttxt.getText().toString();
                                        timer.cancel();
                                        ball++;
                                        per(name,ds_vop,ds_otv,hol,ball,ds_uo);
                                    } else {
                                        ds_uo[hol]=edttxt.getText().toString();
                                        timer.cancel();
                                        ball++;
                                        hol++;
                                        zapuck(df, ds1, ds2);
                                    }
                                }else {
                                    if ((dlina - 1) == hol) {
                                        ds_uo[hol]=edttxt.getText().toString();
                                        timer.cancel();
                                        per(name,ds_vop,ds_otv,hol,ball,ds_uo);
                                    } else {
                                        ds_uo[hol]=edttxt.getText().toString();
                                        timer.cancel();
                                        hol++;
                                        zapuck(df, ds1, ds2);
                                    }
                                }
                                podskaska.setVisibility(View.GONE);
                                edttxt.setText("");

                            }
                        });
                        break;
                }
                break;
            case (3):
                i=random();
                switch (i){
                    case (1):
                        vidpod=1;
                        int k =randomMOD();
                        pokaz(1);
                        progressBar.setMax(30000);
                        progressBar.setProgress(30000);
                        StartTime(30000,df,k,ds1,ds2);
                        if(k==1){
                            txtnnslovo.setText(ds1[hol]);
                            btnslevslovo.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    ds_otv[hol]=ds2[hol];
                                    ds_vop[hol]=ds1[hol];
                                    if (edttxt.getText().toString().equals(ds2[hol])) {
                                        if ((dlina - 1) == hol) {
                                            ball++;
                                            ds_uo[hol]=edttxt.getText().toString();
                                            timer.cancel();
                                            per(name,ds_vop,ds_otv,hol,ball,ds_uo);
                                        } else {
                                            ds_uo[hol]=edttxt.getText().toString();
                                            timer.cancel();
                                            ball++;
                                            hol++;
                                            zapuck(df, ds1, ds2);
                                        }
                                    } else {
                                        if ((dlina - 1) == hol) {
                                            timer.cancel();
                                            ds_uo[hol]=edttxt.getText().toString();
                                            per(name,ds_vop,ds_otv,hol,ball,ds_uo);
                                        } else {
                                            timer.cancel();
                                            ds_uo[hol]=edttxt.getText().toString();
                                            hol++;
                                            zapuck(df, ds1, ds2);
                                        }
                                    }
                                    podskaska.setVisibility(View.GONE);
                                    edttxt.setText("");
                                }
                            });
                        }else {
                            txtnnslovo.setText(ds2[hol]);
                            btnslevslovo.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    ds_otv[hol]=ds1[hol];
                                    ds_vop[hol]=ds2[hol];
                                    if (edttxt.getText().toString().equals(ds1[hol])) {
                                        if ((dlina - 1) == hol) {
                                            timer.cancel();
                                            ds_uo[hol]=edttxt.getText().toString();
                                            ball++;
                                            per(name,ds_vop,ds_otv,hol,ball,ds_uo);
                                        } else {
                                            timer.cancel();
                                            ds_uo[hol]=edttxt.getText().toString();
                                            ball++;
                                            hol++;
                                            zapuck(df, ds1, ds2);
                                        }
                                    } else {
                                        if ((dlina - 1) == hol) {
                                            timer.cancel();
                                            ds_uo[hol]=edttxt.getText().toString();
                                            per(name,ds_vop,ds_otv,hol,ball,ds_uo);
                                        } else {
                                            timer.cancel();
                                            ds_uo[hol]=edttxt.getText().toString();
                                            hol++;
                                            zapuck(df, ds1, ds2);
                                        }
                                    }
                                    podskaska.setVisibility(View.GONE);
                                    edttxt.setText("");
                                }
                            });
                        }
                        break;
                    case (2):
                        vidpod=2;
                        k =randomMOD();
                        int otvet=randomhard();
                        progressBar.setMax(15000);
                        progressBar.setProgress(15000);
                        StartTime(15000,df,k,ds1,ds2);
                        pokaz(2);
                        if(k==1){
                            txtnnslovo.setText(ds1[hol]);
                            knopka(otvet,df,ds2[hol],k);
                            otvet(ds2[hol],df,ds1,ds2);
                            ds_otv[hol]=ds2[hol];
                            ds_vop[hol]=ds1[hol];
                        }else {
                            txtnnslovo.setText(ds2[hol]);
                            knopka(otvet,df,ds1[hol],k);
                            otvet(ds1[hol],df,ds1,ds2);
                            ds_otv[hol]=ds1[hol];
                            ds_vop[hol]=ds2[hol];                        }
                        break;
                    case (3):
                        vidpod=1;
                        pokaz(3);
                        progressBar.setMax(30000);
                        progressBar.setProgress(30000);
                        StartTime(30000,df,0,ds1,ds2);
                        sluh.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                tts.speak(ds1[hol],TextToSpeech.QUEUE_FLUSH,null);
                            }
                        });
                        btnslevslovo.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                ds_otv[hol]=ds1[hol];
                                ds_vop[hol]=ds1[hol];
                                String otv=edttxt.getText().toString();
                                edttxt.setText("");
                                if(ds1[hol].equals(otv)){
                                    if ((dlina - 1) == hol) {
                                        timer.cancel();
                                        ball++;
                                        ds_uo[hol]=edttxt.getText().toString();
                                        per(name,ds_vop,ds_otv,hol,ball,ds_uo);
                                    } else {
                                        timer.cancel();
                                        ball++;
                                        hol++;
                                        ds_uo[hol]=edttxt.getText().toString();
                                        zapuck(df, ds1, ds2);
                                    }
                                }else {
                                    if ((dlina - 1) == hol) {
                                        timer.cancel();
                                        ds_uo[hol]=edttxt.getText().toString();
                                        per(name,ds_vop,ds_otv,hol,ball,ds_uo);
                                    } else {
                                        timer.cancel();
                                        hol++;
                                        ds_uo[hol]=edttxt.getText().toString();
                                        zapuck(df, ds1, ds2);
                                    }
                                }
                                podskaska.setVisibility(View.GONE);
                                edttxt.setText("");
                            }
                        });
                        break;
                }
                break;
            case (4):
                i=random();
                switch (i){
                    case (1):
                        vidpod=1;
                        int k =randomMOD();
                        pokaz(1);
                        if(k==1){
                            txtnnslovo.setText(ds1[hol]);
                            btnslevslovo.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    ds_otv[hol]=ds2[hol];
                                    ds_vop[hol]=ds1[hol];
                                    if (edttxt.getText().toString().equals(ds2[hol])) {
                                        if ((dlina - 1) == hol) {
                                            ball++;
                                            ds_uo[hol]=edttxt.getText().toString();
                                            per(name,ds_vop,ds_otv,hol,ball,ds_uo);
                                        } else {
                                            ball++;
                                            hol++;
                                            ds_uo[hol]=edttxt.getText().toString();
                                            zapuck(df, ds1, ds2);
                                        }
                                    } else {
                                        if ((dlina - 1) == hol) {
                                            ds_uo[hol]=edttxt.getText().toString();
                                            per(name,ds_vop,ds_otv,hol,ball,ds_uo);
                                        } else {
                                            hol++;
                                            ds_uo[hol]=edttxt.getText().toString();
                                            zapuck(df, ds1, ds2);
                                        }
                                    }
                                    podskaska.setVisibility(View.GONE);
                                    edttxt.setText("");
                                }
                            });
                        }else {
                            txtnnslovo.setText(ds2[hol]);
                            btnslevslovo.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    ds_otv[hol]=ds1[hol];
                                    ds_vop[hol]=ds2[hol];
                                    if (edttxt.getText().toString().equals(ds1[hol])) {
                                        if ((dlina - 1) == hol) {
                                            ds_uo[hol]=edttxt.getText().toString();
                                            ball++;
                                            per(name,ds_vop,ds_otv,hol,ball,ds_uo);
                                        } else {
                                            ds_uo[hol]=edttxt.getText().toString();
                                            ball++;
                                            hol++;
                                            zapuck(df, ds1, ds2);
                                        }
                                    } else {
                                        if ((dlina - 1) == hol) {
                                            ds_uo[hol]=edttxt.getText().toString();
                                            per(name,ds_vop,ds_otv,hol,ball,ds_uo);
                                        } else {
                                            ds_uo[hol]=edttxt.getText().toString();
                                            hol++;
                                            zapuck(df, ds1, ds2);
                                        }
                                    }
                                    podskaska.setVisibility(View.GONE);
                                    edttxt.setText("");
                                }
                            });
                        }
                        break;
                    case (2):
                        vidpod=2;
                        k =randomMOD();
                        int otvet=randomeasy();
                        pokaz(2);
                        if(k==1){
                            txtnnslovo.setText(ds1[hol]);
                            knopka(otvet,df,ds2[hol],k);
                            otvet(ds2[hol],df,ds1,ds2);
                            ds_vop[hol]=ds1[hol];
                        }else {
                            txtnnslovo.setText(ds2[hol]);
                            knopka(otvet,df,ds1[hol],k);
                            otvet(ds1[hol],df,ds1,ds2);
                            ds_vop[hol]=ds2[hol];
                        }
                        break;
                    case (3):
                        vidpod=1;
                        pokaz(3);
                        sluh.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                tts.speak(ds1[hol],TextToSpeech.QUEUE_FLUSH,null);
                            }
                        });
                        btnslevslovo.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                ds_otv[hol]=ds1[hol];
                                ds_vop[hol]=ds1[hol];
                                String otv=edttxt.getText().toString();
                                if(ds1[hol].equals(otv)){
                                    if ((dlina - 1) == hol) {
                                        ball++;
                                        ds_uo[hol]=edttxt.getText().toString();
                                        per(name,ds_vop,ds_otv,hol,ball,ds_uo);
                                    } else {
                                        ds_uo[hol]=edttxt.getText().toString();
                                        ball++;
                                        hol++;
                                        zapuck(df, ds1, ds2);
                                    }
                                }else {
                                    if ((dlina - 1) == hol) {
                                        ds_uo[hol]=edttxt.getText().toString();
                                        per(name,ds_vop,ds_otv,hol,ball,ds_uo);
                                    } else {
                                        ds_uo[hol]=edttxt.getText().toString();
                                        hol++;
                                        zapuck(df, ds1, ds2);
                                    }
                                }
                                podskaska.setVisibility(View.GONE);
                                edttxt.setText("");
                            }
                        });
                        break;
                }
                break;
        }
    }
    int random(){
        int random=(int) (1+Math.random()*3);
        return random;
    }
    int randomMOD(){
        int random=(int) (1+Math.random()*2);
        return random;
    }

    int randomMODslovo(){
        int random=(int) (Math.random()*9);
        return random;
    }
    int randomeasy(){
        int random=(int) (1+Math.random()*3);
        return random;
    }
    int randomsrdn(){
        int random=(int) (1+Math.random()*4);
        return random;
    }
    int randomhard(){
        int random=(int) (1+Math.random()*5);
        return random;
    }
    void knopka(int k,int df,String slovo,int lan){
        String [] sps1={"seven", "his", "one", "have", "this", "from", "hot", "but ", "had", "which", "hello"};
        String [] sps2={"metal", "want", "also", "read", "act", "went", "mother", "world ", "father", "place", "tell"};
        String [] sps3={"whether", "each", "live", "also", "after", "back", "little ", "man", "show ", "give", "our",};
        String [] sps4={"push", "test", "record", "common", "gold", "also", "plane", "under", "dry", "ran", "game"};
        String [] sps1ru={"Ангел", "дагеротип", "Ева", "бабочница", "багер", "магнетизм", "обаятельность", "жаждущий ", "уберегать", "убывание", "Ваал"};
        String [] sps2ru={"Багет", "гав", "Габсбурги", "чудотворец", "заахать", "забава", "евангелист", "еда ", "кабанчик", "кабель", "Бампер"};
        String [] sps3ru={"Гольф", "Бензин", "Бикини", "Галифе", "Датчик", "Добыча", "Допить", "Ералаш ", "Жвачка", "Железа", "Жалкий"};
        String [] sps4ru={"Графа", "Злодей", "Истина", "Ириска", "Избыть", "Имбирь", "Играть", " Лететь ", "Молить", "Обушок", "Огниво"};
        switch (lan){
            case (1):
                switch (df){
                    case (1):
                        btnotvet4.setVisibility(View.GONE);
                        btnotvet5.setVisibility(View.GONE);
                        switch (k){
                            case (1):
                                btnotvet1.setText(slovo);
                                btnotvet2.setText(sps1ru[randomMODslovo()]);
                                btnotvet3.setText(sps2ru[randomMODslovo()]);
                                break;
                            case(2):
                                btnotvet1.setText(sps1ru[randomMODslovo()]);
                                btnotvet2.setText(slovo);
                                btnotvet3.setText(sps2ru[randomMODslovo()]);
                                break;
                            case(3):
                                btnotvet1.setText(sps1ru[randomMODslovo()]);
                                btnotvet2.setText(sps2ru[randomMODslovo()]);
                                btnotvet3.setText(slovo);
                                break;
                        }
                        break;
                    case (2):
                        btnotvet5.setVisibility(View.GONE);
                        switch (k){
                            case (1):
                                btnotvet1.setText(slovo);
                                btnotvet2.setText(sps1ru[randomMODslovo()]);
                                btnotvet3.setText(sps2ru[randomMODslovo()]);
                                btnotvet4.setText(sps3ru[randomMODslovo()]);
                                break;
                            case(2):
                                btnotvet1.setText(sps1ru[randomMODslovo()]);
                                btnotvet2.setText(slovo);
                                btnotvet3.setText(sps2ru[randomMODslovo()]);
                                btnotvet4.setText(sps3ru[randomMODslovo()]);
                                break;
                            case(3):
                                btnotvet1.setText(sps1ru[randomMODslovo()]);
                                btnotvet2.setText(sps2ru[randomMODslovo()]);
                                btnotvet3.setText(slovo);
                                btnotvet4.setText(sps3ru[randomMODslovo()]);
                                break;
                            case(4):
                                btnotvet1.setText(sps1ru[randomMODslovo()]);
                                btnotvet2.setText(sps2ru[randomMODslovo()]);
                                btnotvet3.setText(sps3ru[randomMODslovo()]);
                                btnotvet4.setText(slovo);
                                break;
                        }
                        break;
                    case (3):
                        switch (k){
                            case (1):
                                btnotvet1.setText(slovo);
                                btnotvet2.setText(sps1ru[randomMODslovo()]);
                                btnotvet3.setText(sps2ru[randomMODslovo()]);
                                btnotvet4.setText(sps3ru[randomMODslovo()]);
                                btnotvet5.setText(sps4ru[randomMODslovo()]);
                                break;
                            case(2):
                                btnotvet1.setText(sps1ru[randomMODslovo()]);
                                btnotvet2.setText(slovo);
                                btnotvet3.setText(sps2ru[randomMODslovo()]);
                                btnotvet4.setText(sps3ru[randomMODslovo()]);
                                btnotvet5.setText(sps4ru[randomMODslovo()]);
                                break;
                            case(3):
                                btnotvet1.setText(sps1ru[randomMODslovo()]);
                                btnotvet2.setText(sps2ru[randomMODslovo()]);
                                btnotvet3.setText(slovo);
                                btnotvet4.setText(sps3ru[randomMODslovo()]);
                                btnotvet5.setText(sps4ru[randomMODslovo()]);
                                break;
                            case(4):
                                btnotvet1.setText(sps1ru[randomMODslovo()]);
                                btnotvet2.setText(sps2ru[randomMODslovo()]);
                                btnotvet3.setText(sps3ru[randomMODslovo()]);
                                btnotvet4.setText(slovo);
                                btnotvet5.setText(sps4ru[randomMODslovo()]);
                                break;
                            case (5):
                                btnotvet1.setText(sps1ru[randomMODslovo()]);
                                btnotvet2.setText(sps2ru[randomMODslovo()]);
                                btnotvet3.setText(sps3ru[randomMODslovo()]);
                                btnotvet4.setText(sps4ru[randomMODslovo()]);
                                btnotvet5.setText(slovo);
                                break;
                        }
                        break;
                        }
                        break;
            case (2):
                switch (df){
                    case (1):
                        btnotvet4.setVisibility(View.GONE);
                        btnotvet5.setVisibility(View.GONE);
                        switch (k){
                            case (1):
                                btnotvet1.setText(slovo);
                                btnotvet2.setText(sps1[randomMODslovo()]);
                                btnotvet3.setText(sps2[randomMODslovo()]);
                                break;
                            case(2):
                                btnotvet1.setText(sps1[randomMODslovo()]);
                                btnotvet2.setText(slovo);
                                btnotvet3.setText(sps2[randomMODslovo()]);
                                break;
                            case(3):
                                btnotvet1.setText(sps1[randomMODslovo()]);
                                btnotvet2.setText(sps2[randomMODslovo()]);
                                btnotvet3.setText(slovo);
                                break;
                        }
                        break;
                    case (2):
                        btnotvet5.setVisibility(View.GONE);
                        switch (k){
                            case (1):
                                btnotvet1.setText(slovo);
                                btnotvet2.setText(sps1[randomMODslovo()]);
                                btnotvet3.setText(sps2[randomMODslovo()]);
                                btnotvet4.setText(sps3[randomMODslovo()]);
                                break;
                            case(2):
                                btnotvet1.setText(sps1[randomMODslovo()]);
                                btnotvet2.setText(slovo);
                                btnotvet3.setText(sps2[randomMODslovo()]);
                                btnotvet4.setText(sps3[randomMODslovo()]);
                                break;
                            case(3):
                                btnotvet1.setText(sps1[randomMODslovo()]);
                                btnotvet2.setText(sps2[randomMODslovo()]);
                                btnotvet3.setText(slovo);
                                btnotvet4.setText(sps3[randomMODslovo()]);
                                break;
                            case(4):
                                btnotvet1.setText(sps1[randomMODslovo()]);
                                btnotvet2.setText(sps2[randomMODslovo()]);
                                btnotvet3.setText(sps3[randomMODslovo()]);
                                btnotvet4.setText(slovo);
                                break;
                        }
                        break;
                    case (3):
                        switch (k){
                            case (1):
                                btnotvet1.setText(slovo);
                                btnotvet2.setText(sps1[randomMODslovo()]);
                                btnotvet3.setText(sps2[randomMODslovo()]);
                                btnotvet4.setText(sps3[randomMODslovo()]);
                                btnotvet5.setText(sps4[randomMODslovo()]);
                                break;
                            case(2):
                                btnotvet1.setText(sps1[randomMODslovo()]);
                                btnotvet2.setText(slovo);
                                btnotvet3.setText(sps2[randomMODslovo()]);
                                btnotvet4.setText(sps3[randomMODslovo()]);
                                btnotvet5.setText(sps4[randomMODslovo()]);
                                break;
                            case(3):
                                btnotvet1.setText(sps1[randomMODslovo()]);
                                btnotvet2.setText(sps2[randomMODslovo()]);
                                btnotvet3.setText(slovo);
                                btnotvet4.setText(sps3[randomMODslovo()]);
                                btnotvet5.setText(sps4[randomMODslovo()]);
                                break;
                            case(4):
                                btnotvet1.setText(sps1[randomMODslovo()]);
                                btnotvet2.setText(sps2[randomMODslovo()]);
                                btnotvet3.setText(sps3[randomMODslovo()]);
                                btnotvet4.setText(slovo);
                                btnotvet5.setText(sps4[randomMODslovo()]);
                                break;
                            case (5):
                                btnotvet1.setText(sps1[randomMODslovo()]);
                                btnotvet2.setText(sps2[randomMODslovo()]);
                                btnotvet3.setText(sps3[randomMODslovo()]);
                                btnotvet4.setText(sps4[randomMODslovo()]);
                                btnotvet5.setText(slovo);
                                break;
                        }
                        break;
                }
                break;
                }




    }
    void otvet(String otvet,int df,String [] ds1, String [] ds2){
        btnotvet1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ds_otv[hol]=btnotvet1.getText().toString();
                timer.cancel();
                if(btnotvet1.getText().toString().equals(otvet)){
                    if ((dlina - 1) == hol) {
                        ball++;
                        ds_uo[hol]=btnotvet1.getText().toString();
                        per(name,ds_vop,ds_otv,hol,ball,ds_uo);
                    } else {
                        ball++;
                        ds_uo[hol]=btnotvet1.getText().toString();
                        hol++;
                        zapuck(df, ds1, ds2);
                    }
                }else {
                    if ((dlina - 1) == hol) {
                        ds_uo[hol]=btnotvet1.getText().toString();
                        per(name,ds_vop,ds_otv,hol,ball,ds_uo);
                    } else {
                        ds_uo[hol]=btnotvet1.getText().toString();
                        hol++;
                        zapuck(df, ds1, ds2);
                    }
                }
            }
        });
        btnotvet2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ds_otv[hol]=btnotvet2.getText().toString();
                timer.cancel();
                if(btnotvet2.getText().toString().equals(otvet)){
                    if ((dlina - 1) == hol) {
                        ds_uo[hol]=btnotvet2.getText().toString();
                        ball++;
                        per(name,ds_vop,ds_otv,hol,ball,ds_uo);
                    } else {
                        ds_uo[hol]=btnotvet2.getText().toString();
                        ball++;
                        hol++;
                        zapuck(df, ds1, ds2);
                    }
                }else {
                    if ((dlina - 1) == hol) {
                        ds_uo[hol]=btnotvet2.getText().toString();
                        per(name,ds_vop,ds_otv,hol,ball,ds_uo);
                    } else {
                        ds_uo[hol]=btnotvet2.getText().toString();
                        hol++;
                        zapuck(df, ds1, ds2);
                    }
                }
            }
        });
        btnotvet3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ds_otv[hol]=btnotvet3.getText().toString();
                timer.cancel();
                if(btnotvet3.getText().toString().equals(otvet)){
                    if ((dlina - 1) == hol) {
                        ds_uo[hol]=btnotvet3.getText().toString();
                        ball++;
                        per(name,ds_vop,ds_otv,hol,ball,ds_uo);
                    } else {
                        ds_uo[hol]=btnotvet3.getText().toString();
                        ball++;
                        hol++;
                        zapuck(df, ds1, ds2);
                    }
                }else {
                    if ((dlina - 1) == hol) {
                        ds_uo[hol]=btnotvet3.getText().toString();
                        per(name,ds_vop,ds_otv,hol,ball,ds_uo);
                    } else {
                        ds_uo[hol]=btnotvet3.getText().toString();
                        hol++;
                        zapuck(df, ds1, ds2);
                    }
                }
            }
        });
        btnotvet4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ds_otv[hol]=btnotvet4.getText().toString();
                timer.cancel();
                if(btnotvet4.getText().toString().equals(otvet)){
                    if ((dlina - 1) == hol) {
                        ds_uo[hol]=btnotvet4.getText().toString();
                        ball++;
                        per(name,ds_vop,ds_otv,hol,ball,ds_uo);
                    } else {
                        ds_uo[hol]=btnotvet4.getText().toString();
                        ball++;
                        hol++;
                        zapuck(df, ds1, ds2);
                    }
                }else {
                    if ((dlina - 1) == hol) {
                        ds_uo[hol]=btnotvet4.getText().toString();
                        per(name,ds_vop,ds_otv,hol,ball,ds_uo);
                    } else {
                        ds_uo[hol]=btnotvet4.getText().toString();
                        hol++;
                        zapuck(df, ds1, ds2);
                    }
                }
            }
        });
        btnotvet5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ds_otv[hol]=btnotvet5.getText().toString();
                timer.cancel();
                if(btnotvet5.getText().toString().equals(otvet)){
                    if ((dlina - 1) == hol) {
                        ds_uo[hol]=btnotvet4.getText().toString();
                        ball++;
                        per(name,ds_vop,ds_otv,hol,ball,ds_uo);
                    } else {
                        ds_uo[hol]=btnotvet4.getText().toString();
                        ball++;
                        hol++;
                        zapuck(df, ds1, ds2);
                    }
                }else {
                    if ((dlina - 1) == hol) {
                        ds_uo[hol]=btnotvet4.getText().toString();
                        per(name,ds_vop,ds_otv,hol,ball,ds_uo);
                    } else {
                        ds_uo[hol]=btnotvet4.getText().toString();
                        hol++;
                        zapuck(df, ds1, ds2);
                    }
                }
            }
        });
    }
    void pokaz(int a){
        switch (a){
            case 1:
                txtnnslovo.setVisibility(View.VISIBLE);
                peres.setVisibility(View.VISIBLE);
                edttxt.setVisibility(View.VISIBLE);
                btnslevslovo.setVisibility(View.VISIBLE);
                //
                txtnnslovo.setVisibility(View.VISIBLE);
                lr1.setVisibility(View.GONE);
                lr2.setVisibility(View.GONE);
                lr3.setVisibility(View.GONE);
                //
                nadp.setVisibility(View.GONE);
                sluh.setVisibility(View.GONE);
                break;
            case 2:
                txtnnslovo.setVisibility(View.VISIBLE);
                peres.setVisibility(View.GONE);
                edttxt.setVisibility(View.GONE);
                btnslevslovo.setVisibility(View.GONE);
                //
                lr1.setVisibility(View.VISIBLE);
                lr2.setVisibility(View.VISIBLE);
                lr3.setVisibility(View.VISIBLE);
                //
                nadp.setVisibility(View.GONE);
                sluh.setVisibility(View.GONE);
                break;
            case 3:
                txtnnslovo.setVisibility(View.GONE);
                peres.setVisibility(View.GONE);
                edttxt.setVisibility(View.VISIBLE);
                btnslevslovo.setVisibility(View.VISIBLE);
                //
                lr1.setVisibility(View.GONE);
                lr2.setVisibility(View.GONE);
                lr3.setVisibility(View.GONE);
                //
                nadp.setVisibility(View.VISIBLE);
                sluh.setVisibility(View.VISIBLE);
                break;
        }
    }
    void StartTime(int time, int df,int k, String[] ds1, String[] ds2){
        timer=new CountDownTimer(time,1000) {
            @Override
            public void onTick(long l) {
                progressBar.setProgress((int)l);
                if (podskask == true & l / 1000 == ((time / 1000) / 2)) {
                    if(vidpod==1){
                        podskaska.setVisibility(View.VISIBLE);
                        if(k==1){
                            podskaska.setText("Подсказка: "+returnLenth(ds2[hol]));
                        }else {
                            podskaska.setText("Подсказка: "+returnLenth(ds1[hol]));
                        }
                    }else {
                        podskasknopka(df,k,ds1,ds2);
                    }

                }
            }

            @Override
            public void onFinish() {
                if ((dlina - 1) == hol) {
                   ds_uo[hol]="Нет ответа";
                } else {
                    hol++;
                    ds_uo[hol]="Нет ответа";
                    zapuck(df, ds1, ds2);
                }
                podskaska.setVisibility(View.GONE);
                edttxt.setText("");
            }
        }.start();
    }
    String returnLenth(String slovo){
        String slovoret="";
        String[] items = slovo.replaceAll("", "").replaceAll("", "").replaceAll("\\s", "").split("");
        int g= items.length/2;
        for(int j =0; j<=g;j++){
            slovoret=slovoret+items[j];
        }
        return slovoret;
    }
    void podskasknopka(int df,int k, String[] ds1, String[] ds2){
        int ran;
        if(k==1) {
            switch (df) {
                case (1):
                    ran = randomeasy();
                    switch (ran) {
                        case (1):
                            if (!btnotvet1.getText().toString().equals(ds2[hol])){
                                btnotvet1.setVisibility(View.GONE);
                            }else {
                                podskasknopka(df,k,ds1,ds2);
                            }
                                break;
                        case (2):
                            if (!btnotvet2.getText().toString().equals(ds2[hol])){
                                btnotvet2.setVisibility(View.GONE);
                            }else {
                                podskasknopka(df,k,ds1,ds2);
                            }
                            break;
                        case (3):
                            if (!btnotvet3.getText().toString().equals(ds2[hol])){
                                btnotvet3.setVisibility(View.GONE);
                            }else {
                                podskasknopka(df,k,ds1,ds2);
                            }
                            break;
                    }
                    break;
                case (2):
                    ran = randomsrdn();
                    switch (ran) {
                        case (1):
                            if (!btnotvet1.getText().toString().equals(ds2[hol])){
                                btnotvet1.setVisibility(View.GONE);
                            }else {
                                podskasknopka(df,k,ds1,ds2);
                            }
                            break;
                        case (2):
                            if (!btnotvet2.getText().toString().equals(ds2[hol])){
                                btnotvet2.setVisibility(View.GONE);
                            }else {
                                podskasknopka(df,k,ds1,ds2);
                            }
                            break;
                        case (3):
                            if (!btnotvet3.getText().toString().equals(ds2[hol])){
                                btnotvet3.setVisibility(View.GONE);
                            }else {
                                podskasknopka(df,k,ds1,ds2);
                            }
                        case (4):
                            if (!btnotvet4.getText().toString().equals(ds2[hol])){
                                btnotvet4.setVisibility(View.GONE);
                            }else {
                                podskasknopka(df,k,ds1,ds2);
                            }
                            break;
                    }
                    break;
                case (3):
                    ran = randomhard();
                    switch (ran) {
                        case (1):
                            if (!btnotvet1.getText().toString().equals(ds2[hol])){
                                btnotvet1.setVisibility(View.GONE);
                            }else {
                                podskasknopka(df,k,ds1,ds2);
                            }
                            break;
                        case (2):
                            if (!btnotvet2.getText().toString().equals(ds2[hol])){
                                btnotvet2.setVisibility(View.GONE);
                            }else {
                                podskasknopka(df,k,ds1,ds2);
                            }
                            break;
                        case (3):
                            if (!btnotvet3.getText().toString().equals(ds2[hol])){
                                btnotvet3.setVisibility(View.GONE);
                            }else {
                                podskasknopka(df,k,ds1,ds2);
                            }
                        case (4):
                            if (!btnotvet4.getText().toString().equals(ds2[hol])){
                                btnotvet4.setVisibility(View.GONE);
                            }else {
                                podskasknopka(df,k,ds1,ds2);
                            }
                            break;
                        case (5):
                            if (!btnotvet5.getText().toString().equals(ds2[hol])){
                                btnotvet5.setVisibility(View.GONE);
                            }else {
                                podskasknopka(df,k,ds1,ds2);
                            }
                            break;
                    }
                    break;
            }

        }else {
            switch (df) {
                case (1):
                    ran = randomeasy();
                    switch (ran) {
                        case (1):
                            if (!btnotvet1.getText().toString().equals(ds1[hol])){
                                btnotvet1.setVisibility(View.GONE);
                            }else {
                                podskasknopka(df,k,ds1,ds2);
                            }
                            break;
                        case (2):
                            if (!btnotvet2.getText().toString().equals(ds1[hol])){
                                btnotvet2.setVisibility(View.GONE);
                            }else {
                                podskasknopka(df,k,ds1,ds2);
                            }
                            break;
                        case (3):
                            if (!btnotvet3.getText().toString().equals(ds1[hol])){
                                btnotvet3.setVisibility(View.GONE);
                            }else {
                                podskasknopka(df,k,ds1,ds2);
                            }
                            break;
                    }
                    break;
                case (2):
                    ran = randomsrdn();
                    switch (ran) {
                        case (1):
                            if (!btnotvet1.getText().toString().equals(ds1[hol])){
                                btnotvet1.setVisibility(View.GONE);
                            }else {
                                podskasknopka(df,k,ds1,ds2);
                            }
                            break;
                        case (2):
                            if (!btnotvet2.getText().toString().equals(ds1[hol])){
                                btnotvet2.setVisibility(View.GONE);
                            }else {
                                podskasknopka(df,k,ds1,ds2);
                            }
                            break;
                        case (3):
                            if (!btnotvet3.getText().toString().equals(ds1[hol])){
                                btnotvet3.setVisibility(View.GONE);
                            }else {
                                podskasknopka(df,k,ds1,ds2);
                            }
                        case (4):
                            if (!btnotvet4.getText().toString().equals(ds1[hol])){
                                btnotvet4.setVisibility(View.GONE);
                            }else {
                                podskasknopka(df,k,ds1,ds2);
                            }
                            break;
                    }
                    break;
                case (3):
                    ran = randomhard();
                    switch (ran) {
                        case (1):
                            if (!btnotvet1.getText().toString().equals(ds1[hol])){
                                btnotvet1.setVisibility(View.GONE);
                            }else {
                                podskasknopka(df,k,ds1,ds2);
                            }
                            break;
                        case (2):
                            if (!btnotvet2.getText().toString().equals(ds1[hol])){
                                btnotvet2.setVisibility(View.GONE);
                            }else {
                                podskasknopka(df,k,ds1,ds2);
                            }
                            break;
                        case (3):
                            if (!btnotvet3.getText().toString().equals(ds1[hol])){
                                btnotvet3.setVisibility(View.GONE);
                            }else {
                                podskasknopka(df,k,ds1,ds2);
                            }
                        case (4):
                            if (!btnotvet4.getText().toString().equals(ds1[hol])){
                                btnotvet4.setVisibility(View.GONE);
                            }else {
                                podskasknopka(df,k,ds1,ds2);
                            }
                            break;
                        case (5):
                            if (!btnotvet5.getText().toString().equals(ds1[hol])){
                                btnotvet5.setVisibility(View.GONE);
                            }else {
                                podskasknopka(df,k,ds1,ds2);
                            }
                            break;
                    }
                    break;
            }
        }
    }
    void per(String name, String[] vop, String[] otvet, int hol, int ball,String[] otvetprav){
        Intent i = new Intent(getApplicationContext(),MainActivity7.class);
        i.putExtra("ball",ball);
        i.putExtra("kol1",dlina);
        i.putExtra("name",name);
        i.putExtra("vop",vop);
        i.putExtra("ot",otvet);
        i.putExtra("otprav",otvetprav);
        startActivity(i);
        finish();
    }
}