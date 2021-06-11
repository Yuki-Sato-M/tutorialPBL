package payment;

public class Price {
    private int value;

    public Price(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return String.format("%,3d", value) + "円";
    }

    public Price add(Price price) {
        return new Price(this.getValue() + price.getValue());
    }
    //使用方法
    //Price total
    //total　= total.add(計算結果)

    public Price mul(int times) {
        return new Price(this.getValue() * times);
    }

    public Price mul(double times) {
        return new Price((int)(this.getValue() * times));
    }

    public int getValue() {
        return value;
    }
}
