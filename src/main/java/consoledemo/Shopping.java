package consoledemo;

import payment.*;


public class Shopping {
    private Cashier cashier;
    private Basket basket;

    Shopping() {
        cashier = new Cashier();
        basket = new Basket();
    }

    public void run() {
        while (true) {
            System.out.println("====================");
            displayMenu();
            input();
            printReceipt();
            System.out.println("====================");
            System.out.println();

        }
    }

    public void displayMenu() {
        System.out.println("0 : 購入を終了する");
        for (ItemTable itemTable : ItemTable.values()) {
            System.out.println(itemTable);
        }
    }

    public void input() {
        Input input = new Input();
        int itemNum = input.getInt("商品番号を入力してください");
        if (isEnd(itemNum)) {
            printReceipt();
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
        Price totalPrice = cashier.calcTotalPrice(basket);
        System.out.println("割引後金額 : "+ totalPrice);
    }

    public void printReceipt() {
        Receipt receipt = cashier.getReceipt(basket);
        System.out.println(receipt);
    }

}