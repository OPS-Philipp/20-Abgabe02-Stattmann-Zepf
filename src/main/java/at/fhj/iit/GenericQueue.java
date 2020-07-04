package at.fhj.iit;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * Generic StringQueue for all datatypes
 * It makes it possible to create a Queue with any kind of datatype
 *
 * @author Lukas Zepf
 * @author Philipp Stattmann
 * @version %I%, %G%
 * @since 1.1
 */

public class GenericQueue<T> implements IQueue<T> {

    /**
     * List to save the elements of the queue
     */
    private List<T> elements = new ArrayList<T>();
    private int maxSize = 5;
    /**
     * Integer to give the maximum amount of elements to put into the queue
     */
    public GenericQueue(int maxsize) {
        maxSize = maxsize;
    }
    /**
     * Adding the given element (obj) to the queue
     *
     * @param obj object, we want to add to the queue
     * return true, if its possible to add the object, otherwise false
     */
    @Override
    public boolean offer(T obj) {
        if (elements.size() != maxSize)
            elements.add(obj);
        else
            return false;

        return true;
    }
    /**
     * giving the first element of the queue and deleting it
     * if the queue is empty, returning null
     *
     * @return first element of the queue, if its not empty
     */
    @Override
    public T poll() {
        T element = peek();

        if (elements.size() != 0) {
            elements.remove(0);
        }

        return element;
    }
    /**
     * Does the same thing like poll, but throws NoSuchElementException if the queue is empty
     *
     * @return first element if its not empty
     * @throws NoSuchElementException if queue is empty
     */
    @Override
    public T remove() {
        T element = poll();
        if (element == null)
            throw new NoSuchElementException("there's no element any more");

        return element;
    }
    /**
     * Returns the first element of the queue without deleting it
     * Returns null if the queue is empty
     *
     * @return first element of the queue, if its empty then null
     */
    @Override
    public T peek() {
        T element;
        if (elements.size() > 0)
            element = elements.get(0);
        else
            element = null;

        return element;
    }
    /**
     * Same as peek() but no deleting, throws exception in case of empty queue
     *
     * @return first element of the queue if not empty
     * @throws NoSuchElementException if the queue is empty
     */
    @Override
    public T element() {
        T element = peek();
        if (element == null)
            throw new NoSuchElementException("there's no element any more");

        return element;
    }
}