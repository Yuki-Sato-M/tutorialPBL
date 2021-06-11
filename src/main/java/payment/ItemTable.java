package payment;

public enum ItemTable {

    APPLE (new ItemExcludedTax(1, "りんご", new Price(100))),
    ORANGE (new ItemExcludedTax(2, "みかん", new Price(40))),
    GRAPE (new ItemExcludedTax(3, "ぶどう", new Price(150))),
    NORIBEN (new ItemExcludedTax(4, "のり弁", new Price(350))),
    SYAKEBEN (new ItemExcludedTax(5, "しゃけ弁", new Price(400))),
    CIGARETTES (new ItemIncludedTax(6, "タバコ", new Price(420))),
    MENSOLE_CIGARETTES(new ItemIncludedTax(7, "メンソールタバコ", new Price(440))),
    LIGHTER (new ItemExcludedTax(8, "ライター", new Price(100))),
    TEA (new ItemExcludedTax(9, "お茶", new Price(80))),
    COFFEE (new ItemExcludedTax(10, "コーヒー", new Price(100)));


    private Item item;

    ItemTable (Item item) {
        this.item = item;
    }

    public Item getItem() {
        return item;
    }

    @Override
    public String toString() {
        return item.toString();
    }
}
