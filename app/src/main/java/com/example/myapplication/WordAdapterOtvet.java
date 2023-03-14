package com.example.myapplication;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class WordAdapterOtvet extends ArrayAdapter<WordsCutOtvet> {
    private Context con;
    private WordsCutOtvet[] words;
    public WordAdapterOtvet(Context con, WordsCutOtvet[] words){
        super(con, R.layout.item1,words);
        this.con=con;
        this.words=words;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater= (LayoutInflater) con.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view= inflater.inflate(R.layout.item1,parent,false);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) TextView kol=view.findViewById(R.id.kol);
        TextView word=view.findViewById(R.id.word);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) TextView wordot=view.findViewById(R.id.wordot);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) TextView wordotp=view.findViewById(R.id.wordotp);
        kol.setText(this.words[position].getKol()+")");
        word.setText(this.words[position].getWord());
        wordot.setText(this.words[position].getWordot());
        wordotp.setText(this.words[position].getWordotp());
        return view;
    }
}
