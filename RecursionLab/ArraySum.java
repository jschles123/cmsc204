public class ArraySum {

    public ArraySum(){

    }

    public int sumOfArray (Integer[] a,int index){
        if(index < 0 || index >= a.length || a == null || a[index] == null){
            return 0;
        }
        return a[index] + this.sumOfArray(a,index -1);
    }

}
