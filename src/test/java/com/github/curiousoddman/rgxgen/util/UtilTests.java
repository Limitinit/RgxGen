package com.github.curiousoddman.rgxgen.util;

import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.*;

public class UtilTests {

    @Test
    public void splitTest() {
        String[] abcs = Util.stringToCharsSubstrings("abc");
        assertArrayEquals(new String[]{"a", "b", "c"}, abcs);
    }

    @Test
    public void multiplicateTest() {
        assertEquals("", Util.multiplicate(' ', -1));
        assertEquals("   ", Util.multiplicate(' ', 3));
        assertEquals("XX", Util.multiplicate('X', 2));
    }

    @Test
    public void randomStringTest() {
        Random rnd1 = new Random(10);
        Random rnd2 = new Random(10);
        assertEquals(Util.randomString(rnd1, "asdf"), Util.randomString(rnd2, "asdf"));
    }

    @Test
    public void randomChangeCaseTest() {
        boolean lower = false;
        boolean upper = false;
        for (int i = 0; i < 100; i++) {
            char result = Util.randomlyChangeCase(new Random(), "a")
                              .charAt(0);
            if (Character.isLowerCase(result)) {
                lower = true;
            } else if (Character.isUpperCase(result)) {
                upper = true;
            }

            if (lower && upper) {
                break;
            }
        }

        assertTrue("Generated both - upper and lower case letter", lower && upper);
    }

    @Test
    public void randomChangeCaseDigitTest() {
        boolean lower = false;
        boolean upper = false;
        for (int i = 0; i < 100; i++) {
            char result = Util.randomlyChangeCase(new Random(), "1")
                              .charAt(0);
            assertEquals('1', result);
            if (Character.isLowerCase(result)) {
                lower = true;
            } else if (Character.isUpperCase(result)) {
                upper = true;
            }

            if (lower && upper) {
                break;
            }
        }

        assertFalse("Digit case did not change.", lower || upper);
    }

    @Test
    public void countCaseInsensitiveVariationsTest() {
        assertEquals(1, Util.countCaseInsensitiveVariations("1234")
                            .intValue());
        assertEquals(2, Util.countCaseInsensitiveVariations("a")
                            .intValue());
        assertEquals(2, Util.countCaseInsensitiveVariations("a1")
                            .intValue());
        assertEquals(2, Util.countCaseInsensitiveVariations("1a")
                            .intValue());
        assertEquals(4, Util.countCaseInsensitiveVariations("ab")
                            .intValue());
        assertEquals(4, Util.countCaseInsensitiveVariations("AB")
                            .intValue());
        assertEquals(8, Util.countCaseInsensitiveVariations("abc")
                            .intValue());
    }
}

