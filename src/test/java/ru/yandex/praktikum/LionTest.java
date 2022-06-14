package ru.yandex.praktikum;

import com.example.Feline;
import com.example.Lion;
import org.junit.Test;
import java.util.List;

import static org.junit.Assert.*;

public class LionTest {
    @Test
    public void checkDoesHaveManeTrue() throws Exception {
        Lion lion = new Lion("Самец", new Feline());
        boolean actual = lion.doesHaveMane();
        assertTrue(actual);
    }

    @Test
    public void checkDoesHaveManeFalse() throws Exception {
        Lion lion = new Lion("Самка", new Feline());
        boolean actual = lion.doesHaveMane();
        assertFalse(actual);
    }

    @Test
    public void checkGetKittens() throws Exception {
        Feline feline = new Feline();
        Lion lion = new Lion("Самка", feline);
        int actual = lion.getKittens();
        assertEquals(feline.getKittens(), actual);
    }

    @Test
    public void checkGetFood() throws Exception {
        Lion lion = new Lion("Самка", new Feline());
        List<String> actualFood = lion.getFood();
        assertEquals(List.of("Животные", "Птицы", "Рыба"), actualFood);
    }

    @Test
    public void checkUnknownSex() {
        Exception e = assertThrows(
                Exception.class,
                () -> new Lion("Неводома зверушка", new Feline())
        );
        assertEquals(e.getMessage(), "Используйте допустимые значения пола животного - самец или самка");
    }
}