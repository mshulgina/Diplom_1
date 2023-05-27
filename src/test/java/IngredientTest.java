import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

public class IngredientTest {
    private Ingredient ingredient;
    private IngredientType ingredientType;
    private final String ingredientName;
    private final float ingredientPrice;
    private final IngredientType expectedIngredientType;
    private final String expectedIngredientName;
    private final float expectedIngredientPrice;

    public IngredientTest(IngredientType ingredientType, String ingredientName, float ingredientPrice,
                          IngredientType expectedIngredientType, String expectedIngredientName,
                          float expectedIngredientPrice) {
        this.ingredientType = ingredientType;
        this.ingredientName = ingredientName;
        this.ingredientPrice = ingredientPrice;
        this.expectedIngredientType = expectedIngredientType;
        this.expectedIngredientName = expectedIngredientName;
        this.expectedIngredientPrice = expectedIngredientPrice;
    }
    //параметризация для ингридиентов: тип, имя, цена, ожидаемый тип, ожидаемое имя, ожидаемая цена
    @Parameterized.Parameters
    public static Object[][] bunTestData() {
        return new Object[][] {
                {SAUCE, "соус", 360.20f, SAUCE, "соус", 360.20f},
                {FILLING, "", 0, FILLING, "", 0},
                {SAUCE, "(=^･ω･^=)", -120.50f, SAUCE, "(=^･ω･^=)", -120.50f},
                {FILLING, "filling", 226.10f, FILLING, "filling", 226.10f}
        };
    }

    @Before
    public void initialize() {
        ingredient = new Ingredient(ingredientType, ingredientName, ingredientPrice);
    }

    //тест на получение типа ингридиента
    @Test
    public void getTypeCorrectTest() {
        Assert.assertEquals("Неверный тип ингридиента", expectedIngredientType, ingredient.getType());
    }

    //тест на получение имени ингридиента
    @Test
    public void getNameCorrectTest() {
        Assert.assertEquals("Неверное имя ингридиента", expectedIngredientName, ingredient.getName());
    }

    //тест на получение цены ингридиента
    @Test
    public void getPriceCorrectTest() {
        Assert.assertEquals("Неверная цена ингридиента", expectedIngredientPrice, ingredient.getPrice(), 0.01);
    }
}
