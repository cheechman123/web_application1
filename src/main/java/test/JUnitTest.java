package test;

import main.First;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static java.time.Duration.ofMillis;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by Денис on 20.11.2018.
 */
public class JUnitTest {
    @DisplayName("fuckoff")
    @Test
    void testAdd() throws InterruptedException {
        System.out.println("add");
        int a = 1;
        int b = 1;
        int expResult = 2;

        Assertions.assertTimeout(ofMillis(100), () -> {
            int result = First.add(a, b);
            assertEquals(expResult, result);
            assertArrayEquals(new int[] {1,2}, new int[] {1,2});
        });

    }
}
