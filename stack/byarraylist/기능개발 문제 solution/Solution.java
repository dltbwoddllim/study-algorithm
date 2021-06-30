package Stack.ByArrayList;
//프로그래머스 스택/큐 1번 문제
//insertion, deletion이 많이 쓰이는 것은 아니기 때문에 arraylist로 구현하는 것도 괜찮다.
public class Solution {
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

    public int[] slice(int[ ] array,int e){
        int[] sliceArray = new int[e+1];
        for (int i = 0; i< e+1; i++){
            sliceArray[i] = array[i];
        }
        return sliceArray;
    }

    public int[] solution(int[] progresses, int[] speeds) {
        int t = 0;
        int i =0;
        int r=0;
        int[] result = new int[100];

        int day=1;

        while(!(isEmpty(progresses))){
            int progress = pop(progresses,t);
            int speed = pop(speeds,t);
            t++;
            if (progress+day*speed>=100){
                r+=1;
            }
            else{
                if (r>0){
                    result[i] = r;
                    i++;
                }
                if((100-progress)%speed==0){
                    day = (100-progress)/speed;
                }else {
                    day = (100-progress)/speed+1;

                }
                r=1;
            }
        }
        result[i] = r;
        return slice(result,i);
    }
}
