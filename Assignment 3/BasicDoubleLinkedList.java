import java.util.*;

/**
 * My Double Linked List implementation
 * @author Joshua Schlesinger-Guevara
 */


public class BasicDoubleLinkedList<T>{

    protected Node<T> head;
    protected Node<T> tail;


    /**
     * default constructor
     */

    public BasicDoubleLinkedList(){}


    /**
     * Constructor with head
     * @param head
     */

    public BasicDoubleLinkedList(T head){
        this.head = new Node<T>(head);
    }


    /**
     * Adds to head of linked list
     * @param data
     */

    public void addToFront(T data){
        if(head == null){
            this.head = this.tail = new Node<T>(data);
        }else{
            Node<T> temp = new Node<T>(data,null,this.head);
            this.head.prev = temp;
            this.head = temp;
            if(this.getSize() == 2){
                this.head.next = this.tail;
            }
        }
    }

    /**
     * Adds to tail of linked list
     * @param data
     */

    public void addToEnd(T data){
        if(head == null){
            this.head = this.tail = new Node<>(data);
        }else{
            Node<T> temp = new Node<>(data,this.tail,null);
            this.tail.next = temp;
            this.tail = temp;
            if(this.getSize() == 2){
                this.tail.prev = this.head;
            }
       }
    }

    /**
     * Removes head from linked list
     * @return previous head
     * @throws UnderFlowException
     */

    public T removeFirst(){
        int size = this.getSize();
        Node<T> temp = this.head;
        if(size == 1){
            this.head = this.tail = null;
            return temp.getData();
        }else if(size == 0){
            throw new NullPointerException();
        }else if(size == 2){
            this.tail.next = this.tail.prev = null;
            this.head = this.tail;
            return temp.getData();
        }else if(size > 2){
            this.head = this.head.next;
            this.head.prev = null;
            return temp.getData();
        }else{
            throw new NullPointerException();
        }
    }

    /**
     * Removes tail from linked list
     * @return previous tail
     * @throws NullPointerException
     */


    public T removeLast() {
        int size = this.getSize();
        Node<T> temp = this.tail;
        if(size == 0){
            throw new NullPointerException();
        }else if(size == 1){
            this.head = this.tail = null;
            System.out.println(temp);
            return temp.getData();
        }else if(size == 2){
            this.head.next = null;
            this.tail = this.head;
            this.tail.prev = null;
            return temp.getData();
        }else if(size > 2){
            this.tail = this.tail.prev;
            this.tail.next = null;
            return temp.getData();
        }
        else{
            throw new NullPointerException();
        }
    }

    /**
     * This method removes an item from anywhere linked list without the index
     * @param data data this is being removed
     * @param comparator comparator class for data
     */

    public void remove(T data, Comparator<T> comparator) {
        if (head == null) return; // Empty list case

        Node current = head;
        while (current != null) {
            if (comparator.compare((T) current.data, data) == 0) {
                if (current == head) {
                    head = current.next;
                    if (head != null) {
                        head.prev = null;
                    }
                } else if (current == tail) {
                    tail = current.prev;
                    if (tail != null) {
                        tail.next = null;
                    }
                } else {
                    current.prev.next = current.next;
                    current.next.prev = current.prev;
                }
                return;
            }
            current = current.next;
        }
    }



    /**
     * Returns the data from head of linked list
     * @return head data
     */


    public T getFirst() {
        return head.getData();
    }

    /**
     * Returns Node object from head of linked list
     * @return head Node
     */
    public Node<T> getHead(){
        return this.head;
    }


    /**
     * Returns the data from tail of linked list
     * @return tail data
     */


    public T getLast() {
        return tail.getData();
    }

    /**
     * Returns Node object from tail of linked list
     * @return tail Node
     */

    public Node<T> getTail() {
        return tail;
    }

    /**
     * Converts linked list to string
     * @return linked list as string
     */

    public String toString(){
        Node<T> temp = this.getHead();
        String str = "";
        while(temp != null){
            str += temp.data + "";
            temp = temp.next;
        }
        return str;
    }

    /**
     *
     * @param delimiter
     * @return The original toString but with some delimiter in between each character
     */
    public String toString(String delimiter){
        Node<T> temp = this.getHead();
        String str = "";
        while(temp != null){
            str += temp.data + "" + delimiter;
            temp = temp.next;
        }
        if (str.length() > 1){
            str = str.substring(0, str.length() - 1);
        }
        return str;
    }

    /**
     * Returns current size of Linked List
     * @return current size of list
     */
    public int getSize(){
        Node<T> temp = this.head;
        int count = 0;
        while(true){
            if(temp == null){
                return count;
            }else{
                count++;
                temp = temp.next;
            }
        }
    }

    /**
     * Returns a ArrayList with Linked List data
     * @return ArrayList full of Linked List data
     */

    public ArrayList<T> toArrayList() {
        Node<T> temp = this.head;
        ArrayList<T> list = new ArrayList<>();
        while(temp != null){
            list.add(temp.getData());
            temp = temp.next;
        }
        return list;
    }

    /**
     * Creates a new Iterator for this Linked List reference
     * @return new List Iterator
     */

    public ListIterator<T> iterator(){
        return new DoubleLinkedListIterator<T>(this.head);
    }

    /**
     * Removes the tail Node from Linked List and returns its data
     * @return Last items data
     */

    public T retrieveLastElement() {
        T temp = this.tail.getData();
        this.removeLast();
        return temp;
    }

    /**
     * Removes the head NOde from Linked List and returns its data
     * @return First items data
     */

    public T retrieveFirstElement() {
        T temp = this.head.getData();
        this.removeFirst();
        return temp;
    }

    /**
     * Node class used by Linked List
     * @param <T>
     */

    protected class Node<T>{

        Node<T> next;
        Node<T> prev;
        T data;

        /**
         *Default constructor
         * @param data
         */


        public Node(T data){
            this.data = data;
        }

        /**
         * Constructor with pointers
         * @param data
         * @param next
         * @param prev
         */
        public Node(T data, Node prev, Node next){
            this.data = data;
            this.next = next;
            this.prev = prev;
        }


        public String toString(){
            return this.data.toString();
        }

        /**
         * Gets data from list node
         * @return data
         */
        public T getData(){
            return this.data;
        }

    }

    protected class DoubleLinkedListIterator<T> implements ListIterator<T> {


        /**
         * curr is current list node of linked list, is initialized to head of linked list
         * prev is the previous node when doing an operation (next(), previous())
         * lastOperation is a int that represents the last command done (-1 = none, 0 = next(), 1 = previous())
         */
        private Node<T> curr;
        private Node<T> prev;
        private int lastOperation;

        /**
         * Constructor
         * @param head Head of Linked List
         */

        DoubleLinkedListIterator(Node<T> head){
            this.curr = head;
            this.prev = null;
            this.lastOperation = -1;
        }

        /**
         * Checks if there is a next node in the linked list including edge case where the current is null but you have just preformed a prev operation
         * @return if there is a next element
         */

        @Override
        public boolean hasNext() {
            if(curr == null){
                //checks if prev() was last operation
                if(lastOperation == 1){
                    return prev != null;
                }
                return false;
            }else{
                return curr != null;
            }
        }

        /**
         * Moves the iterator over 1 position and returns the nodes data it skipped over
         * @return Next nodes data
         */
        @Override
        public T next() {
            if(!this.hasNext()){
                throw new NoSuchElementException();
            }
            //checks if last operation is prev()
            if(lastOperation == 1){
                lastOperation = 0;
                curr = prev;
                prev = null;
                return curr.getData();
            }else{
                lastOperation = 0;
                prev = curr;
                curr = curr.next;
                return prev.getData();
            }
        }


        /**
         * Checks if there is a prev node in the linked list including edge case where the current is null but you have just preformed a next operation
         * @return if there is a prev element
         */

        @Override
        public boolean hasPrevious() {
            if(curr == null){
                //checks if last operation is next()
                if(lastOperation == 0){
                    return prev != null;
                }
                return false;
            }else{
                return curr != null;
            }
        }

        /**
         * Moves the iterator over 1 position and returns the nodes data it skipped over
         * @return Prev nodes data
         */

        @Override
        public T previous() {
            if(!this.hasPrevious()){
                throw new NoSuchElementException();
            }
            //checks if last operation is next()
            if(lastOperation == 0){
                lastOperation = 1;
                curr = prev.prev;
                prev = curr.next;
                return prev.getData();
            }else{
                lastOperation = 1;
                prev = curr;
                curr = curr.prev;
                return prev.getData();
            }
        }

        /**
         * Unsupported operation
         * @return
         * @throws UnsupportedOperationException
         */

        @Override
        public int nextIndex() throws UnsupportedOperationException {
            throw new UnsupportedOperationException();

        }
        /**
         * Unsupported operation
         * @return
         * @throws UnsupportedOperationException
         */
        @Override
        public int previousIndex() throws UnsupportedOperationException {
            throw new UnsupportedOperationException();

        }
        /**
         * Unsupported operation
         * @return
         * @throws UnsupportedOperationException
         */
        @Override
        public void remove() throws UnsupportedOperationException {
            throw new UnsupportedOperationException();
        }
        /**
         * Unsupported operation
         * @return
         * @throws UnsupportedOperationException
         */
        @Override
        public void set(T t) throws UnsupportedOperationException {
            throw new UnsupportedOperationException();

        }
        /**
         * Unsupported operation
         * @return
         * @throws UnsupportedOperationException
         */
        @Override
        public void add(T t) throws UnsupportedOperationException {
            throw new UnsupportedOperationException();

        }
    }

}


