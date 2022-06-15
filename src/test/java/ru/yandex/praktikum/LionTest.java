package ru.yandex.praktikum;

import com.example.Lion;
import com.example.Predator;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

public class LionTest {
    public final static int kittens = 3;
    public final static List<String> food = List.of("Животные", "Птицы", "Рыба");
    public static Predator predator;

    @BeforeClass
    public static void setup() throws Exception {
        predator = Mockito.mock(Predator.class);
        when(predator.getKittens()).thenReturn(kittens);
        when(predator.eatMeat()).thenReturn(food);
    }


    @Test
    public void checkDoesHaveManeTrue() throws Exception {
        Lion lion = new Lion("Самец",predator);
        boolean actual = lion.doesHaveMane();
        assertTrue(actual);
    }

    @Test
    public void checkDoesHaveManeFalse() throws Exception {
        Lion lion = new Lion("Самка", predator);
        boolean actual = lion.doesHaveMane();
        assertFalse(actual);
    }

    @Test
    public void checkGetKittens() throws Exception {
        Lion lion = new Lion("Самка", predator);
        int actual = lion.getKittens();
        assertEquals(kittens, actual);
    }

    @Test
    public void checkGetFood() throws Exception {
        Lion lion = new Lion("Самка", predator);
        List<String> actualFood = lion.getFood();
        assertEquals(food, actualFood);
    }

    @Test
    public void checkUnknownSex() {
        Exception e = assertThrows(
                Exception.class,
                () -> new Lion("Неводома зверушка", predator)
        );
        assertEquals(e.getMessage(), "Используйте допустимые значения пола животного - самец или самка");
    }
}