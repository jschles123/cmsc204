
import java.util.ArrayList;
import java.util.EmptyStackException;

/**
 * My queue implementation
 * @author Joshua Schlesinger-Guevara
 */

class MyQueue <T> implements QueueInterface<T>{

    private MyLinkedList<T> queue;
    private int queueSize;

    /**
     * Default constructor
     */
    public MyQueue(){
        this.queueSize = 1000000;
        this.queue = new MyLinkedList<>();
    }

    public MyQueue(int queueSize){
        this.queueSize = queueSize;
        this.queue = new MyLinkedList<>();
    }

    /**
     * Checks if queue is empty
     * @return empty or not
     */

    public boolean isEmpty(){
        return queue.getFirst() == null;
    }

    /**
     * Checks is queue is full
     * @return full or not
     */

    public boolean isFull(){
        if(isEmpty()){
            return false;
        }
        return this.size() >= this.queueSize;
    }

    /**
     * Removes the first item from the queue
     * @return previous first item of queue
     * @throws QueueUnderflowException
     */

    public T dequeue() throws QueueUnderflowException{
        try {
            T temp = this.queue.getFirstData();
            this.queue.removeFirst();
            return temp;
        }catch (Exception e){
            throw new QueueUnderflowException();
        }
    }

    /**
     * Returns the size of the queue
     * @return queue size
     */

    public int size(){
        return this.queue.size();
    }

    /**
     * Adds data to the end of the queue
     * @param e the element to add to the end of the Queue
     * @return if successful or not
     * @throws QueueOverflowException
     */

    public boolean enqueue(T e) throws QueueOverflowException{
        if(this.isFull()){
            throw new QueueOverflowException();
        }
        this.queue.addLast(e);
        return true;
    }

    /**
     * Convers queue into a string
     * @return queue as a string
     */
    public String toString(){
        return this.queue.toString();
    }

    public String toString(String delimiter){
        return null;
    }


    /**
     * Fills queue with arraylist of data
     * @param list elements to be added to the Queue
     */

    public void fill(ArrayList<T> list){
        for (T i : list){
            this.queue.addLast(i);
        }
    }


}
