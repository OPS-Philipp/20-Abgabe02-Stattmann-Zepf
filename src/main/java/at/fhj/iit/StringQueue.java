package at.fhj.iit;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

// there's some Bugs included, try to debug the code and fix the Bugs
// there are different Bugs, wrong implementation, typos, ...
// write Test-Cases (read Queue Interface for understanding methods) and use Debugging possibilies of your IDE

public class StringQueue implements IQueue<String> {

  private List<String> elements = new ArrayList<String>();
  private int maxSize = 5;

  /**
   * Constructor of the StringQueue.
   *
   * @param maxSize the maximal amount of elements the queue can hold
   */
  public StringQueue(int maxsize) {
    maxSize = maxsize;
  }

  /**
   * Offer adds an element to the queue
   *
   * @param obj is the element which is going to be added to the queue
   *
   * @return true if it is possible; false if there are to many elements
   */
  @Override
  public boolean offer(String obj) {
    if (elements.size() != maxSize)
      elements.add(obj);
    else
      return false;

    return true;
  }

  /**
   * Poll returns the first element in the queue and removes it from the queue
   *
   * @return next element of the queue
   */
  @Override
  public String poll() {
    String element = peek();

    if (elements.size() != 0) {
      elements.remove(0);
    }

    return element;
  }

  /**
   * Remove removes the first element from the queue
   *
   * @return returns removed element
   *
   * @throws NoSuchElementException if there are no elements left in the queue
   */
  @Override
  public String remove() {
    String element = poll();
    if (element == null)
      throw new NoSuchElementException("there's no element any more");

    return element;
  }

  /**
   * Peek returns the first element
   *
   * @return returns the first element of the queue; null if there are no elements left
   */
  @Override
  public String peek() {
    String element;
    if (elements.size() > 0)
      element = elements.get(0);
    else
      element = null;

    return element;
  }

  /**
   * Element returns the first element in the queue
   *
   * @return returns first element
   *
   * @throws NoSuchElementException if there are no elements left in the queue
   */
  @Override
  public String element() {
    String element = peek();
    if (element == null)
      throw new NoSuchElementException("there's no element any more");

    return element;
  }

}