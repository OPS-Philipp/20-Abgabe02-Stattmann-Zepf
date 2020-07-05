#20-Abgabe02-Stattmann-Zepf
This project is created by Philipp Stattmann and Lukas Zepf

A Queue is a Datastructure that works with the FIFO (first in first out) concept.

Queues are used in printers.

You can test it by using J-Unit.

~~~
 @Test
    @DisplayName("Testing Offer overflow")
    public void testOfferOverflow() {
        assertTrue(firstList.offer("Auto"), "Expected offer to return true");
        assertFalse(firstList.offer("Bahn"), "Expected offer to return false");
    }
~~~

Generic programming is a style of computer programming in which algorithms
are written in terms of types to-be-specified-later that are then instantiated
when needed for specific types provided as parameters.

Code Coverage / TestCoverage is the amount of the code covered by testcases.