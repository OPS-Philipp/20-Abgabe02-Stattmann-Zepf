package at.fhj.iit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

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
        //ToDo
    }
}