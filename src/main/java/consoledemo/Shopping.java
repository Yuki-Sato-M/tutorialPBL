package consoledemo;

import payment.Basket;
import payment.Cashier;
import payment.ItemTable;


public class Shopping {
    private Cashier cashier;
    private Basket basket;

    Shopping() {
        cashier = new Cashier();
        basket = new Basket();
    }

    public void run() {
        //
        Input input = new Input();

        while (true) {
            displayMenu();
            input();
            calc();


        }
    }

    public void displayMenu() {
        System.out.println("====================");
        System.out.println("0 : 購入を終了する");
        for (ItemTable itemTable : ItemTable.values()) {
            System.out.println(itemTable);
        }

        System.out.println("====================");
    }

    public void input() {
        Input input = new Input();
        int itemNum = input.getInt("商品番号を入力してください");
        if (isEnd(itemNum)) {
            System.exit(0);
        }
        int itemAmount = input.getInt("購入個数を入力してください");
        //計算する
        addItem(itemNum, itemAmount);
    }

    public boolean isEnd(int itemNum) {
        if (itemNum == 0) {
            return true;
        } else {
            return false;
        }
    }

    public void addItem(int itemNum, int itemAmount) {
        for (ItemTable itemTable : ItemTable.values()) {
            if (itemNum == itemTable.getItem().getId()) {
                basket.add(itemTable, itemAmount);
                break;
            }
        }
    }

    public void calc() {
        //入力を求めて1 3(番号  個数)
        int totalPrice = cashier.calcTotalPrice(basket);
        System.out.println("合計金額: " + totalPrice);
    }

}