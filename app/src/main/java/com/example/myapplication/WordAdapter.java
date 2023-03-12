package com.example.myapplication;

import android.content.Context;
import android.speech.tts.TextToSpeech;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class WordAdapter extends ArrayAdapter<WordsCut> {
    private Context con;
    private WordsCut[] words;
    private TextToSpeech tts;
    private String [] idsF;
    private String [] words_del;
    public WordAdapter(Context con, WordsCut[] words){
        super(con,R.layout.item,words);
        this.con=con;
        this.words=words;
        idsF=new String[words.length];
        words_del=new String[words.length];
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater= (LayoutInflater) con.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view= inflater.inflate(R.layout.item,parent,false);
        final Boolean[] l = {true};
        TextView word=view.findViewById(R.id.word);
        word.setText(this.words[position].getWord());
        TextView wordt=view.findViewById(R.id.wordt);
        wordt.setText(this.words[position].getWordT());
        Button btn=view.findViewById(R.id.mic);
        tts = new TextToSpeech(con.getApplicationContext(),null);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tts.speak(words[position].getWord(),TextToSpeech.QUEUE_ADD,null);
            }
        });
        CheckBox cg=view.findViewById(R.id.check);
        cg.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(l[0] ==true){
                    idsF[position]=words[position].getIdF();
                    words_del[position]=words[position].getWord();
                    l[0] =false;
                }else {
                    idsF[position]=null;
                    words_del[position]=null;
                    l[0] =true;
                }
            }
        });
        return view;
    }
    public String[] getIdsF(){
        return idsF;
    }
    public String[] getWords_del(){
        return words_del;
    }
}
