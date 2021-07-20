import java.util.PriorityQueue;
public class heapSolution_4 {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue heap_1 = new PriorityQueue(scoville.length);
//o(nlogn)
        for (int i = 0; i<scoville.length;i++){
            heap_1.add(scoville[i]);
        }

//o(n*(logn+logn+logn))=>o(nlogn)
        for(int i = 0 ;i<scoville.length;i++){
            int e = (int) heap_1.remove();
            if (e >= K ) {
                break;
            }
            if (i == scoville.length-1){
                return -1;
            }
            e +=2*(int) heap_1.remove();
            answer++;
            heap_1.add(e);
        }
        return answer;
    }
}
