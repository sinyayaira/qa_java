package ru.yandex.praktikum;

import com.example.Cat;
import com.example.Feline;
import org.junit.Test;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CatTest {
    @Test
    public void checkGetSound() {
        Cat cat = new Cat(new Feline());
        String actualSound = cat.getSound();
        assertEquals("Мяу", actualSound);
    }

    @Test
    public void checkGetFood() throws Exception {
        Cat cat = new Cat(new Feline());
        List<String> actualFood = cat.getFood();
        assertEquals(List.of("Животные", "Птицы", "Рыба"), actualFood);
    }

    @Test
    public void checkExceptionUnknownAnimal() throws Exception {
        Feline mockFeline = mock(Feline.class);
        when(mockFeline.eatMeat())
                .thenThrow(new Exception("Неизвестный вид животного, используйте значение Травоядное или Хищник"));
        Exception e = assertThrows("Обнаружен неизвестний вид", Exception.class, () -> {
            Cat cat = new Cat(mockFeline);
            cat.getFood();
        });
        assertEquals(e.getMessage(), "Неизвестный вид животного, используйте значение Травоядное или Хищник");
    }

}
