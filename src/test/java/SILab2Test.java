import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import org.example.Item;
import org.example.SILab2;

public class SILab2Test {

    String cardNumber = "0123456789012345";

    @Test
    void EveryStatementMinimal() {
        // Test 1: Items list is null
        assertThrows(RuntimeException.class, () -> SILab2.checkCart(null, "Invalid"));
        System.out.println("Test 1 Passed");

        // Test 2: Item with null name
        assertThrows(RuntimeException.class, () -> SILab2.checkCart(List.of(new Item(null, 1, 100, 0)), "Invalid"));
        System.out.println("Test 2 Passed");

        // Test 3: Valid Items
        double expectedResult = (400 * 0.9 * 10) - 30;
        List<Item> Test3 = List.of(new Item("Item", 10, 400, 0.1));

        assertEquals(expectedResult, SILab2.checkCart(Test3, cardNumber), 0.001);
        System.out.println("Test 3 Passed");


        // Test 4: Invalid Card Number
        assertThrows(RuntimeException.class,() -> SILab2.checkCart(List.of(new Item("Item", 1, 100, 0)), "Invalid"));
        System.out.println("Test 4 Passed");
    }

    @Test
    void MultipleCondition() {
        // TXX
        double expectedResult_TXX = (350 * 5) - 30;
        List<Item> tff = List.of(new Item("Item1", 5, 350, 0));

        assertEquals(expectedResult_TXX, SILab2.checkCart(tff, cardNumber), 0.001);

        // FTX
        double expectedResult_FTX = (200* 0.9 * 5) - 30;
        List<Item> ftf = List.of(new Item("Item2", 5, 200, 0.1));

        assertEquals(expectedResult_FTX, SILab2.checkCart(ftf, cardNumber), 0.001);

        // FFT
        double expectedResult_FFT = (200 * 15) - 30;
        List<Item> fft = List.of(new Item("Item3", 15, 200, 0));

        assertEquals(expectedResult_FFT, SILab2.checkCart(fft, cardNumber), 0.001);

        // FFF
        double expectedResult_FFF = 200 * 5;
        List<Item> fff = List.of(new Item("Item4", 5, 200, 0));

        assertEquals(expectedResult_FFF, SILab2.checkCart(fff, cardNumber), 0.001);
    }

}