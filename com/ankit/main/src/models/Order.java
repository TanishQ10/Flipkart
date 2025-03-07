package models;

import java.util.List;

public class Order {
    private int orderId_;
    private String currDate = "20250330";
    private List<BoughtItem> itemsBought_;
    private PaymentMethod paymentMethod_;
    private String purchaseDate_;
    private boolean duesCleared_;
    private String user_;
    
    public Order(int orderId, List<BoughtItem> itemsBought, PaymentMethod paymentMethod, String purchaseDate, String user){
        orderId_=orderId;
        itemsBought_ = itemsBought;
        paymentMethod_=paymentMethod;
        purchaseDate_ = purchaseDate;
        user_ = user;
        if(paymentMethod == PaymentMethod.BNPL) {
            duesCleared_ = false;
        } else duesCleared_ = true;
    }

    public boolean clearDue(){
        duesCleared_ = true;
        return duesCleared_;
    }

    public String toString(){
        return new String("id = "+ orderId_+" items: "+ itemsBought_.toString() + " paymentMethod "+ paymentMethod_+ " purchaseDate: "+ purchaseDate_+ " user: "+ user_) ;
    }

    public String getUser(){
        return user_;
    }
    public String getDate(){
        return purchaseDate_;
    }

    public boolean isCleared(){
        return duesCleared_;
    }
}
