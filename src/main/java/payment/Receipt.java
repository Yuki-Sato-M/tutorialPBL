package payment;

import service.ServiceHandler;

import java.util.Map;

public class Receipt {
    private String content;

    public Receipt() {
    }

    public void init() {
        content = System.lineSeparator() + "【購入したもの】" + System.lineSeparator();
    }

    public void addItemLine(String name, int amount, Price price) {
        content += name + " x " + amount + "個" + " = " + price + System.lineSeparator();
    }

    public void addPriceLine(String preMessage, Price price) {
        content += preMessage + " : " + price + System.lineSeparator();
    }

    @Override
    public String toString() {
        return content;
    }
}
