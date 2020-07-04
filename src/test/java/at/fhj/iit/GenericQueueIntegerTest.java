package at.fhj.iit;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

public class GenericQueueIntegerTest {
    private GenericQueue<Integer> firstList;
    private GenericQueue<Integer> secondList;

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
        assertTrue(firstList.offer(1), "Expected offer to return true");
    }

    /**
     * Tests the offer method with an overflow
     */
    @Test
    @DisplayName("Testing Offer overflow")
    public void testOfferOverflow() {
        assertTrue(firstList.offer(1), "Expected offer to return true");
        assertFalse(firstList.offer(2), "Expected offer to return false");
    }

    /**
     * Tests the poll method
     */
    @Test
    @DisplayName("Testing Poll")
    public void testPoll() {
        assertTrue(secondList.offer(1), "Expected offer to return true");
        assertTrue(secondList.offer(2), "Expected offer to return true");
        assertTrue(secondList.offer(3), "Expected offer to return true");
        assertEquals(secondList.poll(), 1);
        assertEquals(secondList.poll(), 2);
        assertEquals(secondList.poll(), 3);
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
        assertTrue(secondList.offer(1), "Expected offer to return true");
        assertTrue(secondList.offer(2), "Expected offer to return true");
        assertTrue(secondList.offer(3), "Expected offer to return true");
        assertEquals(secondList.poll(), 1);
        assertEquals(secondList.poll(), 2);
        assertEquals(secondList.poll(), 3);
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
        assertTrue(firstList.offer(2), "Expected offer to return true");
        assertEquals(firstList.peek(), 2);
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
        secondList.offer(3);
        assertTrue(secondList.offer(2), "Expected offer to return true");
        assertEquals(secondList.peek(), 3);
        assertEquals(secondList.peek(), 3, "nothing gets removed");
    }

    /**
     * Tests the element method
     */
    @Test
    @DisplayName("Testing element")
    public void testElement() {
        assertTrue(secondList.offer(1), "Expected offer to return true");
        assertEquals(secondList.element(), 1);
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
