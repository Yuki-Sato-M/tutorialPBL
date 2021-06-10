package payment;

public class Price {
    private int value;

    public Price(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return String.format("%,3d",value) + "円";
    }
}
