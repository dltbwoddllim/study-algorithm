package Stack;
public class Main {

    //O(n)
    public static String solution(int[] progresses, int[] speeds) {
        stackByArrayList progressesStack = new stackByArrayList(progresses);
        stackByArrayList speedsStack = new stackByArrayList(speeds);
        int day=(100-progressesStack.pop())/speedsStack.pop();
        int r=1;
        String result = "[ ";
        while(!(progressesStack.isEmpty())){
            int progress = progressesStack.pop();
            int speed = speedsStack.pop();

            if (progress+day*speed>=100){
                r+=1;

            }
            else{
                result+=(r+", ");
                day = (100-progress)/speed;
                r=1;
            }
        }
        result +=(r+"]");
        return (result);
    }

    public static void main(String[] args) {
        int[] progresses_1 = {55, 30, 93 };
        int[] speeds_1 ={5, 30, 1};
        System.out.println(solution(progresses_1, speeds_1));
        int[] progresses_2 = {99,80,99,99,90,95};
        int[] speeds_2 ={1,1,1,1,1,1};
        System.out.println(solution(progresses_2, speeds_2));
    }
}
