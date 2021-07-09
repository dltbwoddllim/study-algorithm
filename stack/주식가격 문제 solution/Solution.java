public class arrayListSolution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];

//        o(n*n)
        for(int i = 0; i< prices.length;i++){
            int r = 0;
            for (int j = i+1; j<prices.length;j++){
                r++;
                if (prices[i]>prices[j]){
                    break;
                }
            }
            answer[i]=r;
            System.out.println(i+" : "+answer[i]);
        }
        return answer;
    }
}
