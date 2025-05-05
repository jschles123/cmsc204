import java.util.*;
public class CarQueue{

    private Queue<Integer> queue;


    public void addNum(){
        this.queue.add((int)(Math.random()*4));
    }

    public CarQueue(){
        this.queue = new LinkedList<>();
        for(int i = 0; i < 6; i++){
            this.queue.add((int)(Math.random()*4));
        }
    }

    public void addToQueue() {
        class willRunIHope implements Runnable{
            public void run() {
                while(true){
                    if(queue.size() < 10) {
                        for (int i = 0; i < 5; i++) {
                            addNum();
                        }
                    }
                    try{
                        Thread.sleep(1000);
                    }catch(InterruptedException e){
                        e.printStackTrace();
                    }
                }
            }
        }
        Thread thread = new Thread(new willRunIHope());
        thread.start();
    }

    public void print(){
        System.out.println(this.queue);
    }

    public int deleteQueue() {
        System.out.println("here");
        return this.queue.poll();
    }

}
