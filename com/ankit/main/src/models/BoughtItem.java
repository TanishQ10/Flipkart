package models;

public class BoughtItem {
    private Item item_;
    private int qty_;

    public BoughtItem(Item item, int qty){
        qty_ = qty;
        item_ = item;
    }

    public Item getItem(){
        return item_;
    }

    public int getQty(){
        return qty_;
    }

    public String toString(){
        return new String(" Item: "+ item_.toString()+ " quantity: "+ qty_);
    }
}
