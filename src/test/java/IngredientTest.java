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
    //параметризация для ингредиентов: тип, имя, цена, ожидаемый тип, ожидаемое имя, ожидаемая цена
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

    //тест на получение типа ингредиента
    @Test
    public void getTypeCorrectTest() {
        Assert.assertEquals("Неверный тип ингредиента", expectedIngredientType, ingredient.getType());
    }

    //тест на получение имени ингредиента
    @Test
    public void getNameCorrectTest() {
        Assert.assertEquals("Неверное имя ингредиента", expectedIngredientName, ingredient.getName());
    }

    //тест на получение цены ингредиента
    @Test
    public void getPriceCorrectTest() {
        Assert.assertEquals("Неверная цена ингредиента", expectedIngredientPrice, ingredient.getPrice(), 0.01);
    }
}
