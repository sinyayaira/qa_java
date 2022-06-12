package ru.yandex.praktikum;

import com.example.Feline;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class FelineGetFoodTest {

    protected Feline feline = new Feline();

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                { "Травоядное", List.of("Трава", "Различные растения") },
                { "Хищник", List.of("Животные", "Птицы", "Рыба") }
        });
    }

    @Parameterized.Parameter(0)
    public String animalKind;

    @Parameterized.Parameter(1)
    public List<String> expectedFood;

    @Test
    public void test() throws Exception {
        List<String> actualFood = feline.getFood(animalKind);
        assertEquals(expectedFood, actualFood);
    }

}