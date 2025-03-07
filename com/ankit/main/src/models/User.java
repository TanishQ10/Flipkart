package models;

public class User {
    private String name_;
    private float creditLimit_;

    public User(String name, float creditLimit){
        name_ = name;
        creditLimit_= creditLimit;
    }

    public float reduceCreditLimit(float buy){
        if(creditLimit_ < buy){
            return -1;
        }
        return creditLimit_ - buy;
    }
    public String getName(){
        return name_;
    }

    public float getBalance(){
        return creditLimit_;
    }
}
