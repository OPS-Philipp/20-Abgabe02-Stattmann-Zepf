package at.fhj.iit;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

public class GenericQueueStringTest {

    private GenericQueue<String> firstList;
    private GenericQueue<String> secondList;

    /**
     * inits Queues before each Test
     */
    @BeforeEach
    void setup() {
        // SETUP PHASE
        firstList = new GenericQueue(1);
        secondList = new GenericQueue(6);
    }

    /**
     * Tests the offer method
     */
    @Test
    @DisplayName("Testing Offer")
    public void testOffer() {
        assertTrue(firstList.offer("Auto"), "Expected offer to return true");
    }

    /**
     * Tests the offer method with an overflow
     */
    @Test
    @DisplayName("Testing Offer overflow")
    public void testOfferOverflow() {
        assertTrue(firstList.offer("Auto"), "Expected offer to return true");
        assertFalse(firstList.offer("Bahn"), "Expected offer to return false");
    }

    /**
     * Tests the poll method
     */
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

    /**
     * Tests the poll method without an element
     */
    @Test
    @DisplayName("Testing Poll without element")
    public void testEmptyPoll() {
        assertNull(firstList.poll(), "Null expectet because List is empty");
    }

    /**
     * Tests the remove method
     */
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

    /**
     * Tests the remove method without an element
     */
    @Test
    @DisplayName("Testing Remove Exception")
    public void testRemoveException() {
        assertThrows(NoSuchElementException.class, () -> {
            firstList.remove();
        });
    }

    /**
     * Tests the peek method
     */
    @Test
    @DisplayName("Testing Peek")
    public void testPeek() {
        assertTrue(firstList.offer("Bus"), "Expected offer to return true");
        assertEquals(firstList.peek(), "Bus");
    }

    /**
     * Tests the peek method without elements to get null as result
     */
    @Test
    @DisplayName("Testing Peek without elements")
    public void testEmptyPeek() {
        assertNull(firstList.peek(), "Expected peek to return Null");
    }

    /**
     * Tests the peek method with more than one element
     */
    @Test
    @DisplayName("Testing Peek with more elements")
    public void testPeekMoreElements() {
        secondList.offer("Bycicle");
        assertTrue(secondList.offer("Bus"), "Expected offer to return true");
        assertEquals(secondList.peek(), "Bycicle");
        assertEquals(secondList.peek(), "Bycicle", "nothing gets removed");
    }

    /**
     * Tests the element method
     */
    @Test
    @DisplayName("Testing element")
    public void testElement() {
        assertTrue(secondList.offer("Auto"), "Expected offer to return true");
        assertEquals(secondList.element(), "Auto");
    }

    /**
     * Tests the element method without an elemnet to get an exception
     */
    @Test
    @DisplayName("Testing element without element")
    public void testEmptyElement() {
        assertThrows(NoSuchElementException.class, () -> {
            firstList.element();
        });
    }
}
