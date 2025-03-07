package models;

public class Item {
    private String name_;
    private int count_;
    private float price_;

    public Item(String name, int count, float price){
        count_ = count;
        name_ = name;
        price_ = price;
    }

    public int butItem(int buy){
        if(buy > count_){
            return -1;
        }
        count_ = count_-buy;
        return count_;
    }
    
    public String getName(){
        return name_;
    }

    public float getPrice(){
        return price_;
    }

    public int getCount(){
        return count_;
    }

    public String toString(){
       return new String("Item name : "+ name_+ " count: "+ count_ + " price: "+ price_);
    }
}
