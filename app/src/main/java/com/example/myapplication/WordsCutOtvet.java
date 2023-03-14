package com.example.myapplication;

public class WordsCutOtvet {
    String kol;
    String word;
    String wordot;
    String wordotp;
    WordsCutOtvet(String kol, String word, String wordot, String wordotp){
        this.kol=kol;
        this.word=word;
        this.wordot=wordot;
        this.wordotp=wordotp;
    }
    public String getKol(){
        return kol;
    }
    public String getWord(){
        return word;
    }
    public String getWordot(){return wordot;}
    public String getWordotp(){
        return wordotp;
    }


}
