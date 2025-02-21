
/**
 * My Linked List implementation
 * @author Joshua Schlesinger-Guevara
 */


public class MyLinkedList<T>{

    private MyListNode<T> head;
    private MyListNode<T> tail;


    /**
     * default constructor
     */

    public MyLinkedList(){}


    /**
     * Constructor with head
     * @param head
     */

    public MyLinkedList(T head){
        this.head = new MyListNode<T>(head);
    }

    /**
     * Adds to head of linked list
     * @param data
     */

    public void addFirst(T data){
        if(head == null){
            this.head = this.tail = new MyListNode<T>(data);
        }else{
            MyListNode<T> temp = new MyListNode<T>(data,null,this.head);
            this.head.prev = temp;
            this.head = temp;
            if(this.size() == 2){
                this.head.next = this.tail;
            }
        }
    }

    /**
     * Adds to tail of linked list
     * @param data
     */

    public void addLast(T data){
        if(head == null){
            this.head = this.tail = new MyListNode<>(data);
        }else{
            MyListNode<T> temp = new MyListNode<>(data,this.tail,null);
            this.tail.next = temp;
            this.tail = temp;
            if(this.size() == 2){
                this.tail.prev = this.head;
            }
        }
    }

    /**
     * Removes head from linked list
     * @return previous head
     * @throws UnderFlowException
     */

    public T removeFirst() throws UnderFlowException {
        int size = this.size();
        MyListNode<T> temp = this.head;
        if(size == 1){
            this.head = this.tail = null;
            return temp.getData();
        }else if(size == 0){
            throw new UnderFlowException("why no workie");
        }else if(size == 2){
            this.tail.next = this.tail.prev = null;
            this.head = this.tail;
            return temp.getData();
        }else if(size > 2){
            this.head = this.head.next;
            this.head.prev = null;
            return temp.getData();
        }else{
            throw new UnderFlowException("sizie no workie");
        }
    }

    /**
     * Removes tail from linked list
     * @return previous tail
     * @throws UnderFlowException
     */


    public T removeLast() throws UnderFlowException{
        int size = this.size();
        MyListNode<T> temp = this.tail;
        if(size == 0){
            throw new UnderFlowException("why no workie");
        }else if(size == 1){
            this.head = this.tail = null;
            return temp.getData();
        }else if(size == 2){
            this.head.next = null;
            this.tail = this.head;
            return temp.getData();
        }else if(size > 2){
            this.tail = this.tail.prev;
            this.tail.next = null;
            return temp.getData();
        }
        else{
            throw new UnderFlowException("sizie no workie");
        }
    }

    /**
     * Gets the head of linked list
     * @return head
     */


    public MyListNode<T> getFirst() {
        return head;
    }

    public T getFirstData() {
        return head.getData();
    }


    /**
     * Gets tail of linked list
     * @return tail
     */


    public MyListNode<T> getLast() {
        return tail;
    }

    public T getLastData() {
        return tail.getData();
    }

    /**
     * Converts linked list to string
     * @return linked list as string
     */

    public String toString(){
        MyListNode<T> temp = this.getFirst();
        String str = "";
        while(temp != null){
            str += temp.data + "";
            temp = temp.next;
        }
        return str;
    }

    public int size(){
        MyListNode<T> temp = this.head;
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

    private class MyListNode<T>{

        MyListNode<T> next;
        MyListNode<T> prev;
        T data;

        /**
         *Default constructor
         * @param data
         */


        public MyListNode(T data){
            this.data = data;
        }

        /**
         * Constructor with pointers
         * @param data
         * @param next
         * @param prev
         */
        public MyListNode(T data, MyListNode prev, MyListNode next){
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
}

