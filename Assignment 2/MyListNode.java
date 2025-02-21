public class MyListNode<T>{

    MyListNode next;
    MyListNode prev;
    T data;

    public MyListNode(T data){
        this.data = data;
    }

    public MyListNode(T data,MyListNode next,MyListNode prev){
        this.data = data;
        this.next = next;
        this.prev = prev;
    }
    public String toString(){
        return this.data.toString();
    }
}