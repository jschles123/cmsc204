class Main{
    public static void main(String[] args) {
        MyLinkedList<Integer> a = new MyLinkedList<>();
        for(int i = 0; i < 2; i++){
            a.addFirst(i);
        }
        System.out.println(a);
        try {
            a.removeFirst();
            a.removeFirst();
        }catch(Exception e){
            System.out.println("here");
        }
        System.out.println(a.getFirst());
    }
}