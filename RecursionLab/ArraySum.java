public class ArraySum {

    public ArraySum(){

    }

    public int sumOfArray (Integer[] a,int index){
        if(index >= a.length){
            return 0;
        }
        if(a[index] == null){
            return 0;
        }
        return a[index] + this.sumOfArray(a,index + 1);
    }

}
