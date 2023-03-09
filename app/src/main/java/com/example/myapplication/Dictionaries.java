package com.example.myapplication;

public class Dictionaries {
    public String id,id_user,name;
    public Dictionaries(){

    }
    Dictionaries(String id, String id_user, String name){
        this.id=id;
        this.id_user=id_user;
        this.name=name;
    }
    String getid(){
        return id;
    }
    String getiduser(){
        return id_user;
    }
    String getname(){return  name;}
}
