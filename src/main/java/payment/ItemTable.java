package payment;

public enum ItemTable {

    APPLE (new ItemExcludedTax(1, "りんご", 100, "果物")),
    ORANGE (new ItemExcludedTax(2, "みかん", 40, "果物")),
    GRAPE (new ItemExcludedTax(3, "ぶどう", 150, "果物")),
    NORIBEN (new ItemExcludedTax(4, "のり弁", 350, "弁当")),
    SYAKEBEN (new ItemExcludedTax(5, "しゃけ弁", 400, "弁当")),
    CIGARETTES (new ItemIncludedTax(6, "タバコ", 420, "タバコ")),
    MENSOLE_CIGARETTES(new ItemIncludedTax(7, "メンソールタバコ", 440, "タバコ")),
    LIGHTER (new ItemExcludedTax(8, "ライター", 100, "ライター")),
    TEA (new ItemExcludedTax(9, "お茶", 80, "飲み物")),
    COFFEE (new ItemExcludedTax(10, "コーヒー", 100, "飲み物"));

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
