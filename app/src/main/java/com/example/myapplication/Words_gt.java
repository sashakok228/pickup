package com.example.myapplication;

public class Words_gt {
    public String id,id_user,id_ds,word,wordt;
    public Words_gt(){

    }
    Words_gt(String id, String id_ds, String word, String wordt){
        this.id=id;
        this.id_ds=id_ds;
        this.word=word;
        this.wordt=wordt;
    }
    String getid(){
        return id;
    }
    String getid_ds(){return  id_ds;}
    String getword(){return  word;}
    String getwordt(){return  wordt;}
}
