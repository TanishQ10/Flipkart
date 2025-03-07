package models;

import java.util.List;

public interface Store {
    public int seedInventory(List<Item> items);
    public String registerUser(User user);
    public int viewInventory();
    public int buy(String user, List<BoughtItem> items, PaymentMethod paymentMethod, String purchaseDate);
    public int clearDues(String user, List<Integer> orderIds, String clearingDate);
    public int viewDues(String user, String date);
    public int orderStatus(String user);
    public Item getItemFromName(String name);
}

