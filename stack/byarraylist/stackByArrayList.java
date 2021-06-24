package Stack;

public class stackByArrayList {
    int[] array ;
    private int t = -1;

    public stackByArrayList(){
        this.array = new int[100];
    }
    public stackByArrayList(int capacity){
        array = (int[]) new int[capacity];
    }
    public stackByArrayList(int[] inputArray){
        array = inputArray;
        t+=array.length;
    }

    //O(1)
    public void push(int e){
        if (size() == array.length){
            return;
        }
        array[++t]=e;
        return;
    }

    //O(1)
    public int pop(){
        if (isEmpty()){
            return 0;
        }
        int e = array[t];
        array[t]=0;
        t--;
        return e;
    }

    //O(1)
    public int top(){
        if (isEmpty()){
            return 0;
        }
        return array[t];
    }

    //O(1)
    public boolean isEmpty(){
        return (t==-1);
    }

    //O(1)
    public int size(){
        return t+1;
    }
}
