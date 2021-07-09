public class Solution {
//deletion/insertion 사용이 많기 때문에 linkedlist로 구현하는 것이 편하다.4
//    enqueue, dequeue 다시 만들기
    private class Node{
        int e;
        int key;
        Node nextNode;

        public Node(int v, int k){
            this.e=v;
            this.key = k;
            this.nextNode = null;
            return;
        }

        public int getElement(){
            return this.e;
        }

        public int getKey(){
            return this.key;
        }

        public void setNextNode(Node n){
            this.nextNode = n;
            return;
        }

        public Node getNextNode(){
            return this.nextNode;
        }

    }

    Node frontNode = null;
    Node rearNode = null;
    int size = 0;

    public int size(){
        return this.size;
    }
//    o(1)
    public void enqueue(Node newNode){
        if (size()==0){
            frontNode = newNode;
            rearNode = newNode;
        }else {
            rearNode.setNextNode(newNode);
            rearNode = rearNode.getNextNode();
        }
        this.size++;
        return;
    }

//    o(1)
    public Node dequeue(){
        if(size()==0){
            return null;
        }
        Node removeNode = frontNode;
        int e = frontNode.getElement();
        int key = frontNode.getKey();
        if (size()==1){
            frontNode = null;
            rearNode = null;
        }else {
            frontNode = frontNode.getNextNode();
        }
        removeNode = null;
        this.size--;
        return new Node(e,key);
    }
//o(n)
    public Node findMax(){
        if (size()==0){
            return null;
        }
        else if (size()==1){
            return frontNode;
        }
        Node maxNode = dequeue();
        enqueue(maxNode);
        for (int i = 1;i<size();i++){
            Node nextNode = dequeue();
            if (maxNode.getElement()<nextNode.getElement()){
                maxNode = nextNode;
            }
            enqueue(nextNode);
        }
        return maxNode;
    }

    public int solution(int[] priorities, int location) {
        int answer = 0;
        this.size = 0;

//        o(n)
        for (int i = 0;i<priorities.length;i++){
           enqueue(new Node(priorities[i],i));
        }

//        o(n*n+n*n)=>o(n*n)
        while(findMax().getKey()!=location){
//            o(n)
            Node n = findMax();
//            o(n)
            for (int i = 0 ; i<size();i++){
                Node t = dequeue();
                if (n.getKey()==t.getKey()){
                    answer++;
                    break;
                }else {
                    enqueue(t);
                }
            }
        }
        answer++;
        return answer;
    }
}
