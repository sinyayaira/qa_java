package ru.yandex.praktikum;

import com.example.Feline;
import com.example.Lion;
import com.example.Predator;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.withSettings;

public class LionTest {
    @Test
    public void checkDoesHaveManeTrue() {
        Lion lion = Mockito.mock(Lion.class, withSettings()
                .useConstructor("Самец", new Feline()).defaultAnswer(Mockito.CALLS_REAL_METHODS));
        boolean actual = lion.doesHaveMane();
        assertTrue(actual);
    }

    @Test
    public void checkDoesHaveManeFalse() {
        Lion lion = Mockito.mock(Lion.class, withSettings()
                .useConstructor("Самка", new Feline()).defaultAnswer(Mockito.CALLS_REAL_METHODS));
        boolean actual = lion.doesHaveMane();
        assertFalse(actual);
    }

    @Test
    public void checkGetKittens() {
        Feline feline = new Feline();
        Lion lion = Mockito.mock(Lion.class, withSettings()
                .useConstructor("Самка", new Feline()).defaultAnswer(Mockito.CALLS_REAL_METHODS));
        int actual = lion.getKittens();
        assertEquals(feline.getKittens(), actual);
    }

    @Test
    public void checkGetFood() throws Exception {
        Lion lion = Mockito.mock(Lion.class, withSettings()
                .useConstructor("Самка", new Feline()).defaultAnswer(Mockito.CALLS_REAL_METHODS));
        List<String> actualFood = lion.getFood();
        assertEquals(List.of("Животные", "Птицы", "Рыба"), actualFood);
    }

    @Test
    public void checkUnknownSex() {
        Exception e = assertThrows(Exception.class, () -> {
            Lion lion = new LionMock("Неводома зверушка", new Feline());
        });
        assertEquals(e.getMessage(), "Используйте допустимые значения пола животного - самец или самка");
    }

    public class LionMock extends Lion {

        public LionMock(String sex, Predator predator) throws Exception {
            super(sex, predator);
        }

        @Override
        public List<String> eatMeat() throws Exception {
            return null;
        }
    }

}
