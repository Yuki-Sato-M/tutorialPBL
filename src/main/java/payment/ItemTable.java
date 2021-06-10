package payment;

public enum ItemTable {

    APPLE (new ItemExcludedTax(1, "りんご", 100)),
    ORANGE (new ItemExcludedTax(2, "みかん", 40)),
    GRAPE (new ItemExcludedTax(3, "ぶどう", 150)),
    NORIBEN (new ItemExcludedTax(4, "のり弁", 350)),
    SYAKEBEN (new ItemExcludedTax(5, "しゃけ弁", 400)),
    CIGARETTES (new ItemIncludedTax(6, "タバコ", 420)),
    MENSOLE_CIGARETTES(new ItemIncludedTax(7, "メンソールタバコ", 440)),
    LIGHTER (new ItemExcludedTax(8, "ライター", 100)),
    TEA (new ItemExcludedTax(9, "お茶", 801)),
    COFFEE (new ItemExcludedTax(10, "コーヒー", 100));


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
