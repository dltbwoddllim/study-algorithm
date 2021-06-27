package Stack.ByArrayList;
//프로그래머스 스택/큐 1번 문제
//insertion, deletion이 많이 쓰이는 것은 아니기 때문에 arraylist로 구현하는 것도 괜찮다.
public class SolutionByStackArrayList_1 {
    public int pop(int[] array,int t){
        if (isEmpty(array)){
            return 0;
        }
        int e = array[t];
        array[t]=0;
        return e;
    }

    public boolean isEmpty(int [] array){
        return (array[array.length-1]==0);
    }
    public int[] slice(int[ ] array,int s){
        int[] sliceArray = new int[s+1];
        for (int i = 0; i< s+1; i++){
            System.out.println(array[i]);
            sliceArray[i] = array[i];
        }
        return sliceArray;
    }

    public int[] solution(int[] progresses, int[] speeds) {
        int t = 0;
        int[] result = new int[100];
        int i =0;

        int day=(100-pop(progresses,t))/pop(speeds,t);
        if (day==0){
            day=1;
        }

        t++;
        int r=1;

        while(!(isEmpty(progresses))){
            int progress = pop(progresses,t);
            int speed = pop(speeds,t);
            t++;
            if (progress+day*speed>=100){
                r+=1;
            }
            else{
                result[i] = r;
                i++;
                day = (100-progress)/speed;
                r=1;
            }
        }
        result[i] = r;
        return slice(result,i);
    }
}