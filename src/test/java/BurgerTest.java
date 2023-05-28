import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.*;
import java.util.List;
import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    Database data = new Database();
    @Mock
    private Bun bun;
    @Mock
    private Ingredient ingredient;
    @Mock
    private Ingredient filling;
    private Burger burger;

    @Before
    public void createBurger() {
        burger = new Burger();
    }

    //тест на добавление булочки
    @Test
    public void setBunsTest() {
        burger.setBuns(bun);
        assertEquals("Неверно добавлена булочка", bun, burger.bun);
    }
    //тест на добавление ингредиента
    @Test
    public void addIngredientTest() {
        burger.addIngredient(ingredient);
        List<Ingredient> expect = List.of(ingredient);
        List<Ingredient> actual = burger.ingredients;

        assertEquals("Неверно добавлен ингредиент", expect, actual);
    }
    //тест на удаление ингредиента
    @Test
    public void removeIngredientTest() {
        burger.addIngredient(ingredient);
        burger.removeIngredient(0);
        List<Ingredient> actual = burger.ingredients;

        assertEquals("Неверно удален ингредиент", List.of(), actual);
    }
    //тест на перемещение ингредиента
    @Test
    public void moveIngredientTest() {
        burger.addIngredient(filling);
        burger.addIngredient(ingredient);
        burger.moveIngredient(0, 1);
        Ingredient actual = burger.ingredients.get(1);

        assertEquals("Неверно перемещен ингредиент", filling, actual);
    }

    //тест на установление цены
    @Test
    public void burgerGetPriceTest() {
        burger.setBuns(data.availableBuns().get(1));
        burger.addIngredient(data.availableIngredients().get(5));
        burger.addIngredient(data.availableIngredients().get(1));
        float actual = burger.getPrice();

        assertEquals("Неверно установлена цена", 900, actual, 0);
    }
    //тест на получение чека
    @Test
    public void burgerGetReceiptTest() {
        burger.addIngredient(data.availableIngredients().get(1));
        burger.addIngredient(data.availableIngredients().get(5));
        burger.addIngredient(data.availableIngredients().get(1));
        burger.setBuns(data.availableBuns().get(2));
        Bun bun = burger.bun;

        StringBuilder receipt = new StringBuilder(String.format("(==== %s ====)%n", bun.getName()));
        List<Ingredient> ingredients = burger.ingredients;
        for (Ingredient ingredient : ingredients) {
            receipt.append(String.format("= %s %s =%n", ingredient.getType().toString().toLowerCase(),
                    ingredient.getName()));
        }

        receipt.append(String.format("(==== %s ====)%n", bun.getName()));
        receipt.append(String.format("%nPrice: %f%n", burger.getPrice()));

        assertEquals("Неверно получен чек", receipt.toString(), burger.getReceipt());
    }
}
