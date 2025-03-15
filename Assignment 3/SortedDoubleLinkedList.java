import java.util.Comparator;

class SortedDoubleLinkedList<T> extends BasicDoubleLinkedList<T> {
    private Comparator<T> comparator;

    public SortedDoubleLinkedList(Comparator<T> comparator) {
        super();
        this.comparator = comparator;
    }

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

    public T retrieveLastElement(){
        return tail.getData();
    }

    public void addToFront(T data) throws UnsupportedOperationException{
        throw new UnsupportedOperationException("Invalid operation for sorted list");
    }

    public void addToEnd(T data) throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Invalid operation for sorted list");
    }

    public void remove(T data) throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Invalid operation for sorted list");
    }


}