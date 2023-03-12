package com.example.myapplication;

public class WordsCut {
    String word;
    String wordt;
    String idF;
    WordsCut(String word, String wordt, String idF){
        this.word=word;
        this.wordt=wordt;
        this.idF=idF;
    }
    public String getWord(){
        return word;
    }
    public String getWordT(){
        return wordt;
    }
    public String getIdF(){
        return idF;
    }
    public void setWord(String word){
        this.word=word;
    }
    public void setWordt(String wordt){
        this.wordt=wordt;
    }
    public void setIdF(String idF){
        this.idF=idF;
    }
}
