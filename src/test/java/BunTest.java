import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;

@RunWith(Parameterized.class)
public class BunTest {
    private Bun bun;

    private final String bunName;
    private final float bunPrice;
    private final String expectedBunName;
    private final float expectedBunPrice;

    public BunTest(String bunName, float bunPrice, String expectedBunName, float expectedBunPrice) {
        this.bunName = bunName;
        this.bunPrice = bunPrice;
        this.expectedBunName = expectedBunName;
        this.expectedBunPrice = expectedBunPrice;
    }
    //параметризация для булочки: название, цена, ожидаемое название, ожидаемая цена
    @Parameterized.Parameters
    public static Object[][] bunTestData() {
        return new Object[][] {
                {"superBun", 360.20f, "superBun", 360.20f},
                {"", 0, "", 0},
                {"(=^･ω･^=)", -120.50f, "(=^･ω･^=)", -120.50f},
                {"Супер Булочка", 226.10f, "Супер Булочка", 226.10f},
        };
    }
    @Before
    public void getNewBun() {
        bun = new Bun(bunName, bunPrice);
    }
    //тест на сравнение имени булочки
    @Test
    public void getNameBunCorrect() {
        Assert.assertEquals("Неверное имя булочки", expectedBunName, bun.getName());
    }
    //тест на сравнение цены булочки
    @Test
    public void getPriceBunCorrect() {
        Assert.assertEquals("Неверная цена булочки", expectedBunPrice, bun.getPrice(), 0.01 );
    }

}
