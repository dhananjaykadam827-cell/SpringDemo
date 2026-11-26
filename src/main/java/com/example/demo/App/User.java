package com.example.demo.App;

public class User {
    private int id;
    private String name;
    private String email;
    private int number;

   public User(int id, String name,String email,int number){
        this.id = id;
        this.name = name;
        this.email = email;
        this.number = number;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
