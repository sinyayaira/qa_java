package ru.yandex.praktikum;

import com.example.Cat;
import com.example.Feline;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class FelineTest {

    @Test
    public void checkGetFamily() {
        Feline feline = new Feline();
        String actualFamily = feline.getFamily();
        assertEquals("Кошачьи", actualFamily);
    }

    @Test
    public void checkGetKittens() {
        Feline feline = new Feline();
        assertEquals(1, feline.getKittens());
    }

    @Test
    public void checkGetKittensWithKittensCount() {
        int kittensCount = 11;
        Feline feline = new Feline() ;
        assertEquals(kittensCount, feline.getKittens(kittensCount)) ;
    }

    @Test
    public void checkEatMeat() throws Exception {
        Feline feline = new Feline();
        List<String> actual = feline.eatMeat();
        assertEquals(List.of("Животные", "Птицы", "Рыба"), actual);
    }

}
