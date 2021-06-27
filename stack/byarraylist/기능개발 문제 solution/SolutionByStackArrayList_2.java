package Stack.ByArrayList;

public class SolutionByStackArrayList_2 {

    public int[] slice(int[ ] array,int s){
        int[] sliceArray = new int[s+1];
        for (int i = 0; i< s+1; i++){
            System.out.println(array[i]);
            sliceArray[i] = array[i];
        }
        return sliceArray;
    }


    public int[] solution(int[] progresses, int[] speeds) {
        stackByArrayList progressesStack = new stackByArrayList(progresses);
        stackByArrayList speedsStack = new stackByArrayList(speeds);
        int[] result = new int[100];
        int i =0;

        int day=(100-progressesStack.pop())/speedsStack.pop();
        if (day==0){
            day =1;
        }
        int r=1;
        while(!(progressesStack.isEmpty())){
            int progress = progressesStack.pop();
            int speed = speedsStack.pop();

            if (progress+day*speed>=100){
                r+=1;

            }
            else{
                result[i]=r;
                i++;
                day = (100-progress)/speed;
                r=1;
            }
        }
        result[i]=r;
        return slice(result,i);
    }
}
