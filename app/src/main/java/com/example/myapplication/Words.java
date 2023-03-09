package com.example.myapplication;

public class Words {
    public String id,id_user,id_ds,word,wordt;
    public Words(){

    }
    Words(String id, String id_user, String id_ds, String word, String wordt){
        this.id=id;
        this.id_user=id_user;
        this.id_ds=id_ds;
        this.word=word;
        this.wordt=wordt;
    }
    String getid(){
        return id;
    }
    String getiduser(){return id_user;}
    String getid_ds(){return  id_ds;}
    String getword(){return  word;}
    String getwordt(){return  wordt;}
}
