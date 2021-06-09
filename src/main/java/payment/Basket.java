package payment;

import java.util.HashMap;
import java.util.Map;

public class Basket {
    private final Map<ItemTable, Integer> itemList;

    public Basket() {
        itemList = new HashMap<>();
        for (ItemTable itemTable : ItemTable.values()) {
            itemList.put(itemTable, 0);
        }
    }

    public void add(ItemTable itemTable) {
        itemList.put(itemTable, itemList.get(itemTable) + 1);
    }

    public void add(ItemTable itemTable, int num) {
        itemList.put(itemTable, itemList.get(itemTable) + num);
    }

    public Map<ItemTable, Integer> lookInside() {
        return itemList;
    }
}
