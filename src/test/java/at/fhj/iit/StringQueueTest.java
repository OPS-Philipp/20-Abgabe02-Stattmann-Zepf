package at.fhj.iit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

class StringQueueTest {
    private StringQueue firstList;
    private StringQueue secondList;

    @BeforeEach
    void setup() {
        // SETUP PHASE
        firstList = new StringQueue(1);
        secondList = new StringQueue(6);
    }

    @Test
    @DisplayName("Testing Offer")
    public void testOffer() {
        assertTrue(firstList.offer("Auto"), "Expected offer to return true");
    }

    @Test
    @DisplayName("Testing Offer overflow")
    public void testOfferOverflow() {
        assertTrue(firstList.offer("Auto"), "Expected offer to return true");
        assertFalse(firstList.offer("Bahn"), "Expected offer to return false");
    }

    @Test
    @DisplayName("Testing Poll")
    public void testPoll() {
        assertTrue(secondList.offer("Auto"), "Expected offer to return true");
        assertTrue(secondList.offer("Bahn"), "Expected offer to return true");
        assertTrue(secondList.offer("Bus"), "Expected offer to return true");
        assertEquals(secondList.poll(), "Auto");
        assertEquals(secondList.poll(), "Bahn");
        assertEquals(secondList.poll(), "Bus");
    }

    @Test
    @DisplayName("Testing Poll without element")
    public void testEmptyPoll() {
        assertNull(firstList.poll(), "Null expectet because List is empty");
    }

    @Test
    @DisplayName("Testing Remove")
    public void testRemove() {
        assertTrue(secondList.offer("Auto"), "Expected offer to return true");
        assertTrue(secondList.offer("Bahn"), "Expected offer to return true");
        assertTrue(secondList.offer("Bus"), "Expected offer to return true");
        assertEquals(secondList.poll(), "Auto");
        assertEquals(secondList.poll(), "Bahn");
        assertEquals(secondList.poll(), "Bus");
    }

    @Test
    @DisplayName("Testing Remove Exception")
    public void testRemoveException() {
        assertThrows(NoSuchElementException.class, () -> {
           firstList.remove();
        });
    }

    @Test
    @DisplayName("Testing Peek")
    public void testPeek() {
        assertTrue(firstList.offer("Bus"), "Expected offer to return true");
        assertEquals(firstList.peek(), "Bus");
    }

    @Test
    @DisplayName("Testing Peek without elements")
    public void testEmptyPeek() {
        assertNull(firstList.peek(), "Expected peek to return Null");
    }

    @Test
    @DisplayName("Testing Peek with more elements")
    public void testPeekMoreElements() {
        secondList.offer("Bycicle");
        assertTrue(secondList.offer("Bus"), "Expected offer to return true");
        assertEquals(secondList.peek(), "Bycicle");
        assertEquals(secondList.peek(), "Bycicle", "nothing gets removed");
    }

    @Test
    @DisplayName("Testing element")
    public void testElement() {
        assertTrue(secondList.offer("Auto"), "Expected offer to return true");
        assertEquals(secondList.element(), "Auto");
    }

    @Test
    @DisplayName("Testing element without element")
    public void testEmptyElement() {
        assertThrows(NoSuchElementException.class, () -> {
            firstList.element();
        });
    }
}