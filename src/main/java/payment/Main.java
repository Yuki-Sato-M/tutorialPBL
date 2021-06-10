package payment;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println("====================");
        for (ItemTable itemTable : ItemTable.values()) {
            System.out.println(itemTable);
        }
        System.out.println("====================");

        //入力を求めて1 3(番号  個数)
        System.out.println("商品番号と購入個数を入力してください: りんご4個を購入する例) 1 4");
        Scanner sc = new Scanner(System.in);
        int itemNum = sc.nextInt();
        int itemAmount = sc.nextInt();
        //計算する
        Basket basket = new Basket();
        for (ItemTable itemTable : ItemTable.values()) {
            if (itemNum == itemTable.getItem().getId()) {
                basket.add(itemTable, itemAmount);
                break;
            }
        }
        Cashier cashier = new Cashier();
        Price totalPrice = cashier.calcTotalPrice(basket);
        System.out.println("合計金額: " + totalPrice);
    }
}