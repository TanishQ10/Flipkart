package models;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class StoreImpl implements Store {
    private int currentOrderId = 1;
    private Map<String, Item> allItems = new TreeMap<>();
    private Map<Integer, Order> allOrders = new TreeMap<>();
    private Map<String, User> allUsers = new TreeMap<>();
    @Override
    public int seedInventory(List<Item> items) {
        
        for(Item i: items){
            allItems.put(i.getName(), i);
        }
        return allItems.size();
    }
    @Override
    public String registerUser(User user) {
        allUsers.put(user.getName(), user);
        return user.getName();
    }
    @Override
    public int viewInventory() {
        Item value;
        for(Map.Entry<String, Item> i: allItems.entrySet()){
            value = i.getValue();
            System.out.println(i.toString());
            
       }
       return allItems.size();
    }
    @Override
    public int buy(String user, List<BoughtItem> items, PaymentMethod paymentMethod, String purchaseDate) {
        allOrders.put(currentOrderId, new Order(currentOrderId, items, paymentMethod, purchaseDate, user));
        float totalOrderValue = 0;
        for(BoughtItem item: items){
            item.getItem().butItem(item.getQty());
            totalOrderValue+=(item.getQty()*item.getItem().getPrice());
        }
        
        for(Map.Entry<String, User> u: allUsers.entrySet()){
            String key = u.getKey();
            User iUser = u.getValue();
            if(paymentMethod.equals(PaymentMethod.BNPL)){
                iUser.reduceCreditLimit(totalOrderValue);
            }
        }
        return currentOrderId++;
    }
    @Override
    public int clearDues(String user, List<Integer> orderIds, String clearingDate) {
        for(Map.Entry<Integer, Order> e: allOrders.entrySet()){
            Order curr = e.getValue();
            if(curr.getUser().equals(user) && !curr.isCleared()){
                curr.clearDue();
            }            
            
        }
        return -1;
    }
    @Override
    public int viewDues(String user, String date) {
        for(Map.Entry<Integer, Order> e: allOrders.entrySet()){
            Order curr = e.getValue();
            if(curr.getUser().equals(user) && date.compareTo(curr.getDate())>0 && !curr.isCleared()){
                System.out.println(curr.toString());
            }
            System.out.println();            
            
        }
        return -1;
    }
    @Override
    public int orderStatus(String user) {
        System.out.println("Balance: "+ allUsers.get(user).getBalance());
        for(Map.Entry<Integer, Order> e: allOrders.entrySet()){
            Order curr = e.getValue();
            System.out.println(curr.toString());
            if(curr.getUser().equals(user) ){
                System.out.println(curr.toString());
            }            
            
        }
        return -1;
    }
    @Override
    public Item getItemFromName(String name) {
       return allItems.get(name);
    }

}
