package SevenSegment;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SegmentTest {

    @Test
    public void testSegment8() {
        char[][] expected = {
                {'#','#','#','#'},
                {'#',' ',' ','#'},
                {'#','#','#','#'},
                {'#',' ',' ','#'},
                {'#','#','#','#'}
        };
        char[][] actual = SevenSegmentDisplay.getSevenSegmentDisplay(8);
        assertEquals(expected.length, actual.length);
        for (int index = 0; index < expected.length; index++) assertArrayEquals(expected[index], actual[index]);
    }

    @Test
    public void testSegment1() {
        char[][] expected = {
                {' ', ' ', ' ', ' '},
                {' ', ' ', ' ', '#'},
                {' ', ' ', ' ', ' '},
                {' ', ' ', ' ', '#'},
                {' ', ' ', ' ', ' '}
        };
        char[][] actual = SevenSegmentDisplay.getSevenSegmentDisplay(1);
        assertEquals(expected.length, actual.length);
        for (int index = 0; index < expected.length; index++) assertArrayEquals(expected[index], actual[index]);
    }

    @Test
    public void testSegment2() {
        char[][] expected = {
                {'#', '#', '#', '#'},
                {' ', ' ', ' ', '#'},
                {'#', '#', '#', '#'},
                {'#', ' ', ' ', ' '},
                {'#', '#', '#', '#'}
        };
        char[][] actual = SevenSegmentDisplay.getSevenSegmentDisplay(2);
        assertEquals(expected.length, actual.length);
        for (int index = 0; index < expected.length; index++) assertArrayEquals(expected[index], actual[index]);
    }

    @Test
    public void testSegment3() {
        char[][] expected = {
                {'#', '#', '#', '#'},
                {' ', ' ', ' ', '#'},
                {'#', '#', '#', '#'},
                {' ', ' ', ' ', '#'},
                {'#', '#', '#', '#'}
        };
        char[][] actual = SevenSegmentDisplay.getSevenSegmentDisplay(3);
        assertEquals(expected.length, actual.length);
        for (int index = 0; index < expected.length; index++) assertArrayEquals(expected[index], actual[index]);
    }

    @Test
    public void testSegment4() {
        char[][] expected = {
                {' ', ' ', ' ', ' '},
                {'#', ' ', ' ', '#'},
                {'#', '#', '#', '#'},
                {' ', ' ', ' ', '#'},
                {' ', ' ', ' ', ' '}
        };
        char[][] actual = SevenSegmentDisplay.getSevenSegmentDisplay(4);
        assertEquals(expected.length, actual.length);
        for (int index = 0; index < expected.length; index++) assertArrayEquals(expected[index], actual[index]);
    }

    @Test
    public void testSegment5() {
        char[][] expected = {
                {'#', '#', '#', '#'},
                {'#', ' ', ' ', ' '},
                {'#', '#', '#', '#'},
                {' ', ' ', ' ', '#'},
                {'#', '#', '#', '#'}
        };
        char[][] actual = SevenSegmentDisplay.getSevenSegmentDisplay(5);
        assertEquals(expected.length, actual.length);
        for (int index = 0; index < expected.length; index++) assertArrayEquals(expected[index], actual[index]);
    }

    @Test
    public void testSegment6() {
        char[][] expected = {
                {'#', '#', '#', '#'},
                {'#', ' ', ' ', ' '},
                {'#', '#', '#', '#'},
                {'#', ' ', ' ', '#'},
                {'#', '#', '#', '#'}
        };
        char[][] actual = SevenSegmentDisplay.getSevenSegmentDisplay(6);
        assertEquals(expected.length, actual.length);
        for (int index = 0; index < expected.length; index++) assertArrayEquals(expected[index], actual[index]);
    }

    @Test
    public void testSegment7() {
        char[][] expected = {
                {'#', '#', '#', '#'},
                {' ', ' ', ' ', '#'},
                {' ', ' ', ' ', ' '},
                {' ', ' ', ' ', '#'},
                {' ', ' ', ' ', '#'}
        };
        char[][] actual = SevenSegmentDisplay.getSevenSegmentDisplay(7);
        assertEquals(expected.length, actual.length);
        for (int index = 0; index < expected.length; index++) assertArrayEquals(expected[index], actual[index]);
    }

    @Test
    public void testSegment9() {
        char[][] expected = {
                {'#', '#', '#', '#'},
                {'#', ' ', ' ', '#'},
                {'#', '#', '#', '#'},
                {' ', ' ', ' ', '#'},
                {'#', '#', '#', '#'}
        };
        char[][] actual = SevenSegmentDisplay.getSevenSegmentDisplay(9);
        assertEquals(expected.length, actual.length);
        for (int index = 0; index < expected.length; index++) assertArrayEquals(expected[index], actual[index]);
    }
}