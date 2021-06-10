package payment;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PriceTest {

    @Test
    @DisplayName("価格1000のときに1,000円を表示する")
    public void 価格1000のときに1カンマ000円を表示する() {
        Price price = new Price(1000);
        assertEquals("1,000円",price.toString());
    }

    @Test
    @DisplayName("価格1000000のときに1,000,000円を表示する")
    public void 価格1000000のときに1カンマ000カンマ000円を表示する() {
        Price price = new Price(1000000);
        assertEquals("1,000,000円",price.toString());
    }

}