import java.util.ArrayList;

/**
 * My Stack implementation
 * @author Joshua Schlesinger-Guevara
 */

public class MyStack<T> implements StackInterface<T> {

    MyLinkedList<T> stack;
    int stackSize;

    /**
     * Default constructor
     */
    public MyStack() {
        this.stackSize = 100000;
        this.stack = new MyLinkedList<>();
    }

    public MyStack(int stackSize) {
        this.stackSize = stackSize;
        this.stack = new MyLinkedList<>();
    }

    /**
     * Checks if stack is empty
     * @return empty or not
     */

    public boolean isEmpty() {
        return stack.getLast() == null;
    }

    /**
     * Checks if stack is full
     * @return full or not
     */

    public boolean isFull() {
        return this.size() >= this.stackSize;
    }


    /**
     * Removes top of stack
     * @return previous top
     * @throws StackUnderflowException
     */

    public T pop() throws StackUnderflowException {
        try{
            T temp =  this.stack.removeLast();
            return temp;
        }catch(Exception e){
            throw new StackUnderflowException();
        }
    }

    /**
     * Returns top of stack
     * @return current top
     * @throws StackUnderflowException
     */

    public T top() throws StackUnderflowException {
        return this.stack.getLastData();
    }


    /**
     * Gets size of stack
     * @return size
     */

    public int size(){
        return this.stack.size();
    }

    /**
     * Adds to top of stack
     * @param e the element to add to the top of the Stack
     * @return if successful or not
     * @throws StackOverflowException
     */
    public boolean push(T e) throws StackOverflowException {
        if(this.isFull()){
            throw new StackOverflowException();
        }else {
            stack.addLast(e);
            return true;
        }
    }

    public String toString(String delimiter) {
        return "";
    }

    /**
     * Fills stack with array list of data
     * @param list elements to be added to the Stack from bottom to top
     */
    public void fill(ArrayList<T> list) {
        for (T i : list) {
            this.stack.addLast(i);
        }
    }

    @Override
    public String toString() {
        return this.stack.toString();
    }
}
