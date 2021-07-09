public class number4solution {
    private static class Stack{
        int[] array ;
        private int t = -1;

        public Stack(){
            this.array = new int[100];
        }
        public Stack(int capacity){
            array = (int[]) new int[capacity];
        }
        public Stack(int[] inputArray){
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

    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        Stack pricesStack = new Stack(prices.length);

//        o(n*n)
        for(int i = 0; i< prices.length;i++){
            for (int j = i+1; j<prices.length;j++){
                pricesStack.push(prices[j]);
                if (prices[i]>prices[j]){
                    break;
                }
            }
            answer[i] = pricesStack.size();
            while (!pricesStack.isEmpty()){
                pricesStack.pop();
            }
            System.out.println(i+" : "+answer[i]);
        }
        return answer;
    }
}
