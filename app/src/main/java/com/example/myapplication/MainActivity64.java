package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity64 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main64);
        Intent arg = getIntent();

        String nameSLOVAR=arg.getStringExtra("name");
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) TextView nameSLOVAR1=findViewById(R.id.NAMESLOVAR);
        nameSLOVAR1.setText("Словарь: "+nameSLOVAR);
        final int[] kol = {arg.getIntExtra("dl", 0)};
        int kol1 = arg.getIntExtra("dl1", 0);
        int dif = arg.getIntExtra("dif", 0);
        final int[] ball = {arg.getIntExtra("ball", 0)};
        Boolean pod = arg.getBooleanExtra("pod", false);
        String[] words = arg.getStringArrayExtra("words");
        String[] transl = arg.getStringArrayExtra("transl");
        String []otprav=arg.getStringArrayExtra("otprav");
        String []vop=arg.getStringArrayExtra("vp");
        String []ot=arg.getStringArrayExtra("ot");
        if (kol[0] != 0) {
            int random=randomSlOVO(words,kol1);
            String word_g=words[random];
            String word_gs=transl[random];
            words[random]=null;
            transl[random]=null;
            vop[kol[0]-1]=word_g;
            otprav[kol[0]-1]=word_gs;
            TextView txtGL=findViewById(R.id.txy22223);
            txtGL.setText(word_g);
            ProgressBar ber=findViewById(R.id.progressBar4);
            TextView timer=findViewById(R.id.timer4);
            Button r1=findViewById(R.id.b11);
            Button r2=findViewById(R.id.b22);
            Button r3=findViewById(R.id.b33);
            Button r4=findViewById(R.id.b44);
            Button r5=findViewById(R.id.b55);
            int time=60000;
            if(dif==1){
                time=30000;
                ber.setMax(30);
            }else if(dif==2){
                time=20000;
                ber.setMax(20);
                r4.setVisibility(View.VISIBLE);
            }else if(dif==3){
                time=10000;
                ber.setMax(10);
                r4.setVisibility(View.VISIBLE);
                r5.setVisibility(View.VISIBLE);
            }

            int finalTime = time;

            String [] sps1={"","дагеротип","Ева","бабочница","багер","магнетизм","обаятельность","жаждущий ","уберегать","убывание","Ваал"};
            String [] sps2={"","гав","Габсбурги","чудотворец","заахать","забава","евангелист","еда ","кабанчик","кабель","Бампер"};
            String [] sps3={"","Бензин","Бикини","Галифе","Датчик","Добыча","Допить","Ералаш ","Жвачка","Железа","Жалкийz"};
            String [] sps4={"","Злодей","Истина","Ириска","Избыть","Имбирь","Играть"," Лететь ","Молить","Обушок","Огниво"};
            int y=0;
            int ran= (int) ((Math.random()*3)+1);;

           if(dif==1) {
               if (ran == 1) {
                   ran = (int) ((Math.random() * 9) + 1);
                   if (sps1[ran].equals(word_gs)) {
                       ran = (int) ((Math.random() * 9) + 1);
                       r1.setText(sps1[ran]);
                   } else {
                       r1.setText(sps1[ran]);
                   }
                   if (sps2[ran].equals(word_gs)) {
                       ran = (int) ((Math.random() * 9) + 1);
                       r2.setText(sps2[ran]);
                   } else {
                       r2.setText(sps2[ran]);
                   }
                   r3.setText(word_gs);
                   y = 3;
               } else if (ran == 2) {
                   ran = (int) ((Math.random() * 9) + 1);
                   if (sps1[ran].equals(word_gs)) {
                       ran = (int) ((Math.random() * 9) + 1);
                       r2.setText(sps1[ran]);
                   } else {
                       r2.setText(sps1[ran]);
                   }
                   if (sps2[ran].equals(word_gs)) {
                       ran = (int) ((Math.random() * 9) + 1);
                       r3.setText(sps2[ran]);
                   } else {
                       r3.setText(sps2[ran]);
                   }
                   r1.setText(word_gs);
                   y = 1;
               } else if (ran == 3) {
                   ran = (int) ((Math.random() * 9) + 1);
                   if (sps1[ran].equals(word_gs)) {
                       ran = (int) ((Math.random() * 9) + 1);
                       r1.setText(sps1[ran]);
                   } else {
                       r1.setText(sps1[ran]);
                   }
                   if (sps2[ran].equals(word_gs)) {
                       ran = (int) ((Math.random() * 9) + 1);
                       r3.setText(sps2[ran]);
                   } else {
                       r3.setText(sps2[ran]);
                   }
                   r2.setText(word_gs);
                   y = 2;
               }
           }else if(dif==2){
               if (ran == 1) {
                   ran = (int) ((Math.random() * 9) + 1);
                   if (sps1[ran].equals(word_gs)) {
                       ran = (int) ((Math.random() * 9) + 1);
                       r1.setText(sps1[ran]);
                   } else {
                       r1.setText(sps1[ran]);
                   }
                   ran = (int) ((Math.random() * 9) + 1);
                   if (sps2[ran].equals(word_gs)) {
                       ran = (int) ((Math.random() * 9) + 1);
                       r2.setText(sps2[ran]);
                   } else {
                       r2.setText(sps2[ran]);
                   }
                   ran = (int) ((Math.random() * 9) + 1);
                   if(sps3[ran].equals(word_gs)){
                       ran = (int) ((Math.random() * 9) + 1);
                       r4.setText(sps3[ran]);
                   }else {
                       r4.setText(sps3[ran]);
                   }
                   r3.setText(word_gs);
                   y = 3;
               } else if (ran == 2) {
                   ran = (int) ((Math.random() * 9) + 1);
                   if (sps1[ran].equals(word_gs)) {
                       ran = (int) ((Math.random() * 9) + 1);
                       r2.setText(sps1[ran]);
                   } else {
                       r2.setText(sps1[ran]);
                   }
                   ran = (int) ((Math.random() * 9) + 1);
                   if (sps2[ran].equals(word_gs)) {
                       ran = (int) ((Math.random() * 9) + 1);
                       r3.setText(sps2[ran]);
                   } else {
                       r3.setText(sps2[ran]);
                   }
                   if(sps3[ran].equals(word_gs)){
                       ran = (int) ((Math.random() * 9) + 1);
                       r4.setText(sps3[ran]);
                   }else {
                       r4.setText(sps3[ran]);
                   }
                   r1.setText(word_gs);
                   y = 1;
               } else if (ran == 3) {
                   ran = (int) ((Math.random() * 9) + 1);
                   if (sps1[ran].equals(word_gs)) {
                       ran = (int) ((Math.random() * 9) + 1);
                       r1.setText(sps1[ran]);
                   } else {
                       r1.setText(sps1[ran]);
                   }
                   ran = (int) ((Math.random() * 9) + 1);
                   if (sps2[ran].equals(word_gs)) {
                       ran = (int) ((Math.random() * 9) + 1);
                       r3.setText(sps2[ran]);
                   } else {
                       r3.setText(sps2[ran]);
                   }
                   if(sps3[ran].equals(word_gs)){
                       ran = (int) ((Math.random() * 9) + 1);
                       r4.setText(sps3[ran]);
                   }else {
                       r4.setText(sps3[ran]);
                   }
                   r2.setText(word_gs);
                   y = 2;
               }
           }else if(dif==3){
               if (ran == 1) {
                   ran = (int) ((Math.random() * 9) + 1);
                   if (sps1[ran].equals(word_gs)) {
                       ran = (int) ((Math.random() * 9) + 1);
                       r1.setText(sps1[ran]);
                   } else {
                       r1.setText(sps1[ran]);
                   }
                   ran = (int) ((Math.random() * 9) + 1);
                   if (sps2[ran].equals(word_gs)) {
                       ran = (int) ((Math.random() * 9) + 1);
                       r2.setText(sps2[ran]);
                   } else {
                       r2.setText(sps2[ran]);
                   }
                   ran = (int) ((Math.random() * 9) + 1);
                   if(sps3[ran].equals(word_gs)){
                       ran = (int) ((Math.random() * 9) + 1);
                       r4.setText(sps3[ran]);
                   }else {
                       r4.setText(sps3[ran]);
                   }
                   ran = (int) ((Math.random() * 9) + 1);
                   if(sps4[ran].equals(word_gs)){
                       ran = (int) ((Math.random() * 9) + 1);
                       r5.setText(sps4[ran]);
                   }else {
                       r5.setText(sps4[ran]);
                   }
                   r3.setText(word_gs);
                   y = 3;
               } else if (ran == 2) {
                   ran = (int) ((Math.random() * 9) + 1);
                   if (sps1[ran].equals(word_gs)) {
                       ran = (int) ((Math.random() * 9) + 1);
                       r2.setText(sps1[ran]);
                   } else {
                       r2.setText(sps1[ran]);
                   }
                   ran = (int) ((Math.random() * 9) + 1);
                   if (sps2[ran].equals(word_gs)) {
                       ran = (int) ((Math.random() * 9) + 1);
                       r3.setText(sps2[ran]);
                   } else {
                       r3.setText(sps2[ran]);
                   }
                   if(sps3[ran].equals(word_gs)){
                       ran = (int) ((Math.random() * 9) + 1);
                       r4.setText(sps3[ran]);
                   }else {
                       r4.setText(sps3[ran]);
                   }
                   ran = (int) ((Math.random() * 9) + 1);
                   if(sps4[ran].equals(word_gs)){
                       ran = (int) ((Math.random() * 9) + 1);
                       r5.setText(sps4[ran]);
                   }else {
                       r5.setText(sps4[ran]);
                   }
                   r1.setText(word_gs);
                   y = 1;
               } else if (ran == 3) {
                   ran = (int) ((Math.random() * 9) + 1);
                   if (sps1[ran].equals(word_gs)) {
                       ran = (int) ((Math.random() * 9) + 1);
                       r1.setText(sps1[ran]);
                   } else {
                       r1.setText(sps1[ran]);
                   }
                   ran = (int) ((Math.random() * 9) + 1);
                   if (sps2[ran].equals(word_gs)) {
                       ran = (int) ((Math.random() * 9) + 1);
                       r3.setText(sps2[ran]);
                   } else {
                       r3.setText(sps2[ran]);
                   }
                   if(sps3[ran].equals(word_gs)){
                       ran = (int) ((Math.random() * 9) + 1);
                       r4.setText(sps3[ran]);
                   }else {
                       r4.setText(sps3[ran]);
                   }
                   ran = (int) ((Math.random() * 9) + 1);
                   if(sps4[ran].equals(word_gs)){
                       ran = (int) ((Math.random() * 9) + 1);
                       r5.setText(sps4[ran]);
                   }else {
                       r5.setText(sps4[ran]);
                   }
                   r2.setText(word_gs);
                   y = 2;
               }
           }
            int finalY1 = y;
            CountDownTimer time22=new CountDownTimer(finalTime,1000){
                @Override
                public void onTick(long l) {


                    timer.setText(""+l/1000);
                    ber.setProgress((int) (l/1000));
                    if(pod==true & l/1000==((finalTime/1000) /2)){
                        int ranf=0;
                        if(dif==1){
                            ranf= (int) ((Math.random()*3)+1);
                            while (ranf==finalY1){
                                ranf= (int) ((Math.random()*3)+1);
                            }
                        }else if(dif==2){
                            ranf= (int) ((Math.random()*4)+1);
                            while (ranf==finalY1){
                                ranf= (int) ((Math.random()*4)+1);
                            }
                        }else if(dif==3){
                            ranf= (int) ((Math.random()*5)+1);
                            while (ranf==finalY1){
                                ranf= (int) ((Math.random()*5)+1);
                            }
                        }
                        if(ranf==1){
                            r1.setVisibility(View.GONE);
                        }else if(ranf==2){
                            r2.setVisibility(View.GONE);
                        }else if(ranf==3){
                            r3.setVisibility(View.GONE);
                        }else if(ranf==4){
                            r4.setVisibility(View.GONE);
                        }else if(ranf==5){
                            r3.setVisibility(View.GONE);
                        }
                    }
                }

                @Override
                public void onFinish() {
                    ot[kol[0]-1]="Не ответил";
                    kol[0]--;
                    perexod(dif,nameSLOVAR, pod, words, transl, kol[0], kol1, ball[0],vop,ot,otprav);
                }
            }.start();
            Button stop=findViewById(R.id.stop);
            stop.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent i =new Intent(getApplicationContext(),MainActivity3.class);
                    startActivity(i);
                    time22.cancel();
                    finish();
                }
            });

            int finalY = y;
            r1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String text=r1.getText().toString();
                    ot[kol[0]-1]=text;
                    if(word_gs.equals(text)){
                        ball[0]++;
                        kol[0]--;
                        time22.cancel();
                        perexod(dif,nameSLOVAR, pod, words, transl, kol[0], kol1, ball[0],vop,ot,otprav);
                    }else {
                        kol[0]--;
                        time22.cancel();
                        perexod(dif,nameSLOVAR, pod, words, transl, kol[0], kol1, ball[0],vop,ot,otprav);
                    }

                }
            });
            r2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String text=r2.getText().toString();
                    ot[kol[0]-1]=text;
                    if(word_gs.equals(text)){
                        ball[0]++;
                        kol[0]--;
                        time22.cancel();
                        perexod(dif,nameSLOVAR, pod, words, transl, kol[0], kol1, ball[0],vop,ot,otprav);
                    }else {
                        kol[0]--;
                        time22.cancel();
                        perexod(dif,nameSLOVAR, pod, words, transl, kol[0], kol1, ball[0],vop,ot,otprav);
                    }
                }
            });
            r3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String text=r3.getText().toString();
                    ot[kol[0]-1]=text;
                    if(word_gs.equals(text)){
                        ball[0]++;
                        kol[0]--;
                        time22.cancel();
                        perexod(dif,nameSLOVAR, pod, words, transl, kol[0], kol1, ball[0],vop,ot,otprav);
                    }else {
                        kol[0]--;
                        time22.cancel();
                        perexod(dif,nameSLOVAR, pod, words, transl, kol[0], kol1, ball[0],vop,ot,otprav);
                    }
                }
            });
            r4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String text=r4.getText().toString();
                    ot[kol[0]-1]=text;
                    if(word_gs.equals(text)){
                        ball[0]++;
                        kol[0]--;
                        time22.cancel();
                        perexod(dif,nameSLOVAR, pod, words, transl, kol[0], kol1, ball[0],vop,ot,otprav);
                    }else {
                        kol[0]--;
                        time22.cancel();
                        perexod(dif,nameSLOVAR, pod, words, transl, kol[0], kol1, ball[0],vop,ot,otprav);
                    }
                }
            });
            r5.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String text=r5.getText().toString();
                    ot[kol[0]-1]=text;
                    if(word_gs.equals(text)){
                        ball[0]++;
                        kol[0]--;
                        time22.cancel();
                        perexod(dif,nameSLOVAR, pod, words, transl, kol[0], kol1, ball[0],vop,ot,otprav);
                    }else {
                        kol[0]--;
                        time22.cancel();
                        perexod(dif,nameSLOVAR, pod, words, transl, kol[0], kol1, ball[0],vop,ot,otprav);
                    }
                }
            });

        }
        else{
            Intent i=new Intent(this, MainActivity7.class);
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
    void perexod ( int dif,String name, Boolean pod, String[] words, String[] transl, int kol, int kol1, int ball, String[]vopros,String[]otvet,String[] otvetprav){
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
        } else if (ran == 3) {
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
        }else if (ran == 4) {
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