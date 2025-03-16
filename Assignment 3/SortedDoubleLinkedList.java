/**
 * My Sorted Double Linked List Implementation
 * @author Joshua Schlesinger-Guevara
 */

import java.util.Comparator;

class SortedDoubleLinkedList<T> extends BasicDoubleLinkedList<T> {
    private Comparator<T> comparator;



    public SortedDoubleLinkedList(Comparator<T> comparator) {
        super();
        this.comparator = comparator;
    }

    /**
     * Inserts data into the correctly ordered position
     * @param data Data that is being added
     */

    public void add(T data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = tail = newNode;
        } else if (comparator.compare(data, head.data) <= 0) {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null && comparator.compare(data, (T) current.next.getData()) > 0) {
                current = current.next;
            }
            newNode.next = current.next;
            if (current.next != null) {
                current.next.prev = newNode;
            } else {
                tail = newNode;
            }
            current.next = newNode;
            newNode.prev = current;
        }
    }

    /**
     * Modifies original method as it is unsupported for this class
     * @param data
     * @throws UnsupportedOperationException
     */

    public void addToFront(T data) throws UnsupportedOperationException{
        throw new UnsupportedOperationException("Invalid operation for sorted list");
    }

    /**
     * Modifies original method as it is unsupported for this class
     * @param data
     * @throws UnsupportedOperationException
     */

    public void addToEnd(T data) throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Invalid operation for sorted list");
    }

    /**
     * Modifies original method as it is unsupported for this class
     * @param data
     * @throws UnsupportedOperationException
     */

    public void remove(T data) throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Invalid operation for sorted list");
    }


}