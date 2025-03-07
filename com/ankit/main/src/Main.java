import java.util.ArrayList;
import java.util.List;

import models.BoughtItem;
import models.Item;
import models.PaymentMethod;
import models.Store;
import models.StoreImpl;
import models.User;

public class Main {
    public static void main(String[] args){

        List<Item> seedInventory = new ArrayList<>();
        seedInventory.add(new Item("Shoes", 5, 200.0f));
        seedInventory.add(new Item("Watch", 10, 1000.0f));
        seedInventory.add(new Item("T-Shirt", 14, 2000.0f));
        // seedInventory.add(new Item("item4", 10, 400.0f));
        // seedInventory.add(new Item("item5", 10, 500.0f));
        Store store = new StoreImpl();
        System.out.println("Inventory before adding items: ");
        store.viewInventory();


        store.seedInventory(seedInventory);
        System.out.println("After adding items : ");
        store.viewInventory();

        store.registerUser(new User("Akshay", 5000));
        List<BoughtItem> items = new ArrayList();
        Item item1 = store.getItemFromName("Shoes");
        items.add(new BoughtItem(item1, 2));
        item1 = store.getItemFromName("Watch");
        items.add(new BoughtItem(item1, 1));
        store.viewInventory();

        store.buy("Akshay", items, PaymentMethod.BNPL, "20211020");


        store.orderStatus("Akshay");
        store.viewInventory();

        System.out.println("View Dues");
        store.viewDues("Akshay", "20211119");

        List<Integer> orders = new ArrayList<Integer>();
        orders.add(1);
        store.clearDues("Akshay", orders, "20211119");

        System.out.println("View Dues");
        store.viewDues("Akshay", "20211120");
    }
}

