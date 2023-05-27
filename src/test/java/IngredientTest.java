import praktikum.Ingredient;
import praktikum.IngredientType;

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
}
