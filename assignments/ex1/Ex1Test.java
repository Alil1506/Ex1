package assignments.ex1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * This JUnit class represents a very partial test class for assignments.ex1.Ex1.
 * Make sure you complete all the needed JUnits
 */

public class Ex1Test {
    @Test
    void computeNumberTest() {
        String s2 = "1011b2";
        int v = Ex1.number2Int(s2);
        assertEquals(v, 11);
        String s10 = "1011bA";
        v = Ex1.number2Int(s10);
        s2 = Ex1.int2Number(v, 2);
        int v2 = Ex1.number2Int(s2);
        assertEquals(v, v2);
        assertTrue(Ex1.equals(s10, s2));
    }

    @Test
    void isBasisNumberTest() {
        String[] good = {"01b2", "1b2", "1", "123bA", "ABbG", "0bA", "123456789bA","8976bA", "FFAbG", "7654b8", "333bA", "999bA",
        "897347bA", "DCBAbG", "1b2", "10010111b2", "DDDbF", "2289bA", "8765", "54321", "549832bF", "988799bD", "12343b8", "001101b4",
        "12345123b9", "965563bC"};
        for (int i = 0; i < good.length; i = i + 1) {
            boolean ok = Ex1.isNumber(good[i]);
            assertTrue(ok);
        }
        String[] not_good = {"b2", "2b2", "1G3bG", " BbG", "0bbA", "abB", "!@b2", "A", "1bb2", "F", "567b2", "10010b1",
                "976b8", "FFAbA", "98616b2", "0009b6", "87 bA", "1286bbA", "101bb2", "97698bbbA", "43261b3", "45687b4",
                " 85345b4", "ABCDbA"};
        for (int i = 0; i < not_good.length; i = i + 1) {
            boolean not_ok = Ex1.isNumber(not_good[i]);
            assertFalse(not_ok);
        }
    }

    @Test
    void int2NumberTest() {
        assertEquals("1011b2", Ex1.int2Number(11, 2));
        assertEquals("1372CbE", Ex1.int2Number(48060, 14));
        assertEquals("100b3", Ex1.int2Number(9, 3));
        assertEquals("1221b3", Ex1.int2Number(52, 3));
        assertEquals("21100b3", Ex1.int2Number(198, 3));
        assertEquals("213bB", Ex1.int2Number(256, 11));
        assertEquals("1CBbF", Ex1.int2Number(416, 15));
        assertEquals("100bG", Ex1.int2Number(256, 16));
        assertEquals("BBBCbG", Ex1.int2Number(48060, 16));
        assertEquals("41b6", Ex1.int2Number(25, 6));
    }

    @Test
    void maxIndexTest() {
        String[] arr0 = {"10bA", "2bA", "3bA", "20bA"};
        assertEquals(3, Ex1.maxIndex(arr0));
        String[] arr1 = {"1", "2", "3", "4"};
        assertEquals( 3,Ex1.maxIndex(arr1));
       String[] arr2 = {"1001b2", "001010b2", "10b2", "100b2"};
        assertEquals( 1,Ex1.maxIndex(arr2) );
        String[] arr3 = {"1bA", "2bF", "3bC", "4bD"};
        assertEquals(3, Ex1.maxIndex(arr3));
        String[] arr4 = {"101b2", "110b2", "111b2", "100b2"};
        assertEquals(2, Ex1.maxIndex(arr4));
        String[] arr5 = {"101b2", "10bA", "111b2", "1bF"};
        assertEquals (1, Ex1.maxIndex(arr5));
        String[] arr6 = {"101010b2", "111111b2", "110010b2", "100000b2"};
        assertEquals(1, Ex1.maxIndex(arr6));
        String[] arr7 = {"10", "10", "10", "10"};
        assertEquals(0, Ex1.maxIndex(arr7));
        String[] arr8 = {"101b2", "5", "111b2", "100b2"};
        assertEquals(2, Ex1.maxIndex(arr8));
        String[] arr9 = {"10bF", "1bA", "2bA", "3bF"};
        assertEquals(0, Ex1.maxIndex(arr9));
    }


    @Test
    void number2Inttest() {
        String s3 = "102b3";
        int a = Ex1.number2Int(s3);
        assertEquals(a, 11);

        String s2 = "1011b2";
        int b = Ex1.number2Int(s2);
        assertEquals(b, 11);

        String s4 = "110101b2";
        int c = Ex1.number2Int(s4);
        assertEquals(c, 53);

        String s5 = "21021";
        int d = Ex1.number2Int(s5);
        assertEquals(d, 21021);

        String s6 = "21021b3";
        int e = Ex1.number2Int(s6);
        assertEquals(e, 196);

        String s7 = "123487";
        int f = Ex1.number2Int(s7);
        assertEquals(f, 123487);

        String s8 = "1000005542";
        int g = Ex1.number2Int(s8);
        assertEquals(g, 1000005542);

        String s9 = "100045bA";
        int h = Ex1.number2Int(s9);
        assertEquals(h, 100045);

        String s10 = "876BCbD";
        int i = Ex1.number2Int(s10);
        assertEquals(i, 245036);

        String s11 = "B2B879bC";
        int j = Ex1.number2Int(s11);
        assertEquals(j, 2798877);

        String s12 = "EE451bF";
        int k = Ex1.number2Int(s10);
        assertEquals(k, 245036);
    }

}

