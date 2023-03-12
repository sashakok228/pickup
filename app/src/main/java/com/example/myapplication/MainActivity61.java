package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity61 extends AppCompatActivity {
    CountDownTimer time22;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main61);
        Intent arg = getIntent();
        String nameSLOVAR=arg.getStringExtra("name");
        String []vop=arg.getStringArrayExtra("vp");
        String []ot=arg.getStringArrayExtra("ot");
        String []otprav=arg.getStringArrayExtra("otprav");
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) TextView nameSLOVAR1=findViewById(R.id.NAMESLOVAR);
        nameSLOVAR1.setText("Словарь: "+nameSLOVAR);
        final int[] kol = {arg.getIntExtra("dl", 0)};
        int kol1 = arg.getIntExtra("dl1", 0);
        int dif = arg.getIntExtra("dif", 0);
        final int[] ball = {arg.getIntExtra("ball", 0)};
        Boolean pod = arg.getBooleanExtra("pod", false);
        String[] words = arg.getStringArrayExtra("words");
        String[] transl = arg.getStringArrayExtra("transl");

        if (kol[0] != 0) {
            int random = randomSlOVO(words, kol1);
            String word_g = words[random];
            vop[kol[0]-1]=word_g;
            String word_gs = transl[random];
            otprav[kol[0]-1]=word_gs;
            words[random] = null;
            transl[random] = null;
            TextView txtGL = findViewById(R.id.txy22);
            txtGL.setText(word_g);
            EditText edtGL = findViewById(R.id.edtGL);
            ProgressBar ber = findViewById(R.id.progressBar);
            TextView timer = findViewById(R.id.timer);
            int time = 60000;
            if(dif==4){
                ber.setVisibility(View.GONE);
                timer.setText("Режим практики");
            }
            if (dif == 1) {
                time = 40000;
                ber.setMax(40);
            } else if (dif == 2) {
                time = 30000;
                ber.setMax(30);
            } else if (dif == 3) {
                time = 20000;
                ber.setMax(20);
            }
            String[] items = word_gs.replaceAll("", "").replaceAll("", "").replaceAll("\\s", "").split("");
            int g = items.length / 2;
            String podskask = "";
            for (int j = 0; j < g; j++) {
                podskask = podskask + items[j];
            }
            TextView podskas = findViewById(R.id.podskaska);
            int finalTime = time;
            String finalPodskask = podskask;
            if(dif!=4) {
                time22 = new CountDownTimer(finalTime, 1000) {

                    @Override
                    public void onTick(long l) {
                        timer.setText("" + l / 1000);
                        ber.setProgress((int) (l / 1000));
                        if (pod == true & l / 1000 == ((finalTime / 1000) / 2)) {
                            podskas.setText("Половина слова: " + finalPodskask);
                        }
                    }

                    @Override
                    public void onFinish() {
                        kol[0]--;
                        ot[kol[0]] = "Не ответил";
                        perexod(dif, nameSLOVAR, pod, words, transl, kol[0], kol1, ball[0], vop, ot, otprav);
                    }
                }.start();
            }
            Button stop=findViewById(R.id.stop);
            stop.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent i =new Intent(getApplicationContext(),MainActivity3.class);
                    startActivity(i);
                    if(dif!=4){
                        time22.cancel();
                    }
                    finish();
                }
            });

            Button btnSTART = findViewById(R.id.start23);
            btnSTART.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String text = edtGL.getText().toString();
                    ot[kol[0]-1]=text;
                    edtGL.setText("");

                    if (word_gs.equals(text)) {
                        ball[0]++;
                        kol[0]--;
                        if(dif!=4){
                            time22.cancel();
                        }
                        perexod(dif,nameSLOVAR,pod,words,transl,kol[0],kol1,ball[0],vop,ot,otprav);
                    }else {
                        kol[0]--;
                        if(dif!=4){
                            time22.cancel();
                        }
                        perexod(dif,nameSLOVAR,pod,words,transl,kol[0],kol1,ball[0],vop,ot,otprav);
                    }
                }
            });
        } else {
            Intent i = new Intent(this, MainActivity7.class);
            i.putExtra("ball",ball[0]);
            i.putExtra("name", nameSLOVAR);
            i.putExtra("kol1",kol1);
            i.putExtra("vop",vop);
            i.putExtra("ot",ot);
            i.putExtra("otprav",otprav);
            startActivity(i);
            finish();
        }

    }

    int randomSlOVO(String[] w, int kol) {
        Boolean h = true;
        int random = 0;
        while (h == true) {
            random = (int) (Math.random() * kol);
            if (w[random] != null) {
                h = false;
            }
        }
        return random;
    }

    void perexod(int dif,String name, Boolean pod, String[] words, String[] transl, int kol, int kol1, int ball, String[]vopros,String[]otvet,String[] otvetprav) {
        int ran = (int) (Math.random() * 4) + 1;
        if (ran == 1) {
            Intent sl = new Intent(getApplicationContext(), MainActivity61.class);
            sl.putExtra("dif", dif);
            sl.putExtra("name", name);
            sl.putExtra("pod", pod);
            sl.putExtra("words", words);
            sl.putExtra("transl", transl);
            sl.putExtra("dl", kol);
            sl.putExtra("dl1", kol1);
            sl.putExtra("ball", ball);
            sl.putExtra("vp",vopros);
            sl.putExtra("ot",otvet);
            sl.putExtra("otprav",otvetprav);
            startActivity(sl);
            finish();
        } else if (ran == 2) {
            Intent sl = new Intent(getApplicationContext(), MainActivity62.class);
            sl.putExtra("dif", dif);
            sl.putExtra("name", name);
            sl.putExtra("pod", pod);
            sl.putExtra("words", words);
            sl.putExtra("transl", transl);
            sl.putExtra("dl", kol);
            sl.putExtra("dl1", kol1);
            sl.putExtra("ball", ball);
            sl.putExtra("vp",vopros);
            sl.putExtra("ot",otvet);
            sl.putExtra("otprav",otvetprav);
            startActivity(sl);
            finish();
        }else if(ran==3){
            Intent sl = new Intent(getApplicationContext(), MainActivity63.class);
            sl.putExtra("dif", dif);
            sl.putExtra("name", name);
            sl.putExtra("pod", pod);
            sl.putExtra("words", words);
            sl.putExtra("transl", transl);
            sl.putExtra("dl", kol);
            sl.putExtra("dl1", kol1);
            sl.putExtra("ball", ball);
            sl.putExtra("vp",vopros);
            sl.putExtra("ot",otvet);
            sl.putExtra("otprav",otvetprav);
            startActivity(sl);
            finish();
        }
        else if (ran == 4) {
            Intent sl = new Intent(getApplicationContext(), MainActivity64.class);
            sl.putExtra("dif", dif);
            sl.putExtra("name", name);
            sl.putExtra("pod", pod);
            sl.putExtra("words", words);
            sl.putExtra("transl", transl);
            sl.putExtra("dl", kol);
            sl.putExtra("dl1", kol1);
            sl.putExtra("ball", ball);
            sl.putExtra("vp",vopros);
            sl.putExtra("ot",otvet);
            sl.putExtra("otprav",otvetprav);
            startActivity(sl);
            finish();
        }
    }
}