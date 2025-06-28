import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * A simple implementation of a singly linked list that supports insertion,
 * deletion, and iteration.
 */
public class CustomLinkedList implements Iterable<Integer> {
    private Node head;

    /**
     * Inserts a new element at the end of the list.
     *
     * @param data the value to insert
     */
    public void insert(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
    }

    /**
     * Deletes the first occurrence of the specified element from the list.
     *
     * @param data the value to delete
     */
    public void delete(int data) {
        if (head == null) return;

        if (head.data == data) {
            head = head.next;
            return;
        }

        Node current = head;
        while (current.next != null && current.next.data != data) {
            current = current.next;
        }

        if (current.next != null) {
            current.next = current.next.next;
        }
    }

    /**
     * Checks whether the list is empty.
     *
     * @return true if the list has no elements
     */
    public boolean isEmpty() {
        return head == null;
    }

    /**
     * Checks if the list contains a specific value.
     *
     * @param data the value to search for
     * @return true if found, false otherwise
     */
    public boolean contains(int data) {
        Node current = head;
        while (current != null) {
            if (current.data == data) return true;
            current = current.next;
        }
        return false;
    }

    /**
     * Returns a string representation of the linked list.
     *
     * @return the list in string format
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        Node current = head;
        while (current != null) {
            sb.append(current.data);
            if (current.next != null) sb.append(", ");
            current = current.next;
        }
        sb.append("]");
        return sb.toString();
    }

    /**
     * Returns an iterator over elements of type {@code Integer}.
     *
     * @return an Iterator.
     */
    @Override
    public Iterator<Integer> iterator() {
        return new LinkedListIterator();
    }

    // Node class representing an element in the list
    private class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    // Internal iterator class
    private class LinkedListIterator implements Iterator<Integer> {
        private Node current = head;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Integer next() {
            if (!hasNext()) {
                throw new NoSuchElementException("No more elements in the list.");
            }
            int value = current.data;
            current = current.next;
            return value;
        }
    }
}
