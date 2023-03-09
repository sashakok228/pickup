package com.example.myapplication;

public class Users {
    public String id,name,mail,pass;
    public Users(){

    }
    public Users(String id, String name, String mail, String pass){
        this.id=id;
        this.name=name;
        this.mail=mail;
        this.pass=pass;
    }
    String getid(){
        return id;
    }
    String getName(){
        return name;
    }
    String getMail(){return mail;}
    String getPass(){
        return pass;
    }
}