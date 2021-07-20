import java.util.Stack;
//빅오 분석하기.
public class heapSolution_3 {
    private class heap{
        private class Node {
            private int data;
            private Node parent;
            private Node left;
            private Node right;

            public Node(int d) {
                parent = null;
                left = null;
                right = null;
                data = d;
            }

            public int getData() {
                return data;
            }

            public Node getParent() {
                return parent;
            }

            public Node getLeft() {
                return left;
            }

            public Node getRight() {
                return right;
            }

            public void setData(int data) {
                this.data = data;
            }

            public void setParent(Node n) {
                parent = n;
            }

            public void setLeft(Node n) {
                left = n;
            }

            public void setRight(Node n) {
                right = n;
            }
        }


        private Node root;
        private int size;
        Stack<Integer> s = new Stack<>();

        public heap() {
            root = null;
            size = 0;
        }

        public int size() {
            return size;
        }

        public Node getRoot() {
            return root;
        }

//        o(logn)
        public Node getNodeByIndex(int idx) {
            Node n = getRoot();

            s.clear();
            while (idx > 1) {
                s.push(idx % 2);
                idx /= 2;
            }
            while (!s.isEmpty()) {
                if (s.pop() == 1) {
                    n = n.getRight();
                } else {
                    n = n.getLeft();
                }
            }

            return n;
        }

//        swapup(o(logn))+getNodeByIndex(o(logn))=>o(logn)
        public void add(int data) {
            Node addNode = new Node(data);
            if(size()==0){
                this.root = addNode;
            }else if(size()==1){
                root.setLeft(addNode);
                addNode.setParent(root);
            } else if (size()%2==0){
                Node addParentNode = getNodeByIndex(size());
                addNode.setParent(addParentNode.getParent());
                addParentNode.getParent().setRight(addNode);
            }else {
                Node addParentNode = getNodeByIndex((size-3)/2+2);
                addNode.setParent(addParentNode);
                addParentNode.setLeft(addNode);
            }
            size++;
            swapUp(addNode);
            return;

        }


//swapup(o(logn))
        public void swapUp(Node n) {
            if (n == this.getRoot()){
                return;
            }
            Node p = n.getParent();
            if (n.getData()<p.getData()){
                int temp = n.getData();
                n.setData(p.getData());
                p.setData(temp);
                swapUp(p);
            }
        }

//        swapDown(o(logn))+getNodeByIndex(o(logn))=>o(logn)
        public int remove() {
            if(this.size()==0){
                return -1;
            }
            int removeData = this.getRoot().data;
            this.getRoot().setData(getNodeByIndex(size()).getData());
            this.getNodeByIndex(size()).setData(this.getRoot().getData());
            if (size()%2==0){
                this.getNodeByIndex(size()).getParent().setLeft(null);
            }else {
                if(size()==1){
                    this.root = null;
                }
                else {
                    this.getNodeByIndex(size()).getParent().setRight(null);
                }
            }
            swapDown(this.getRoot());
            size--;
            return removeData;
        }

        public void swapDown(Node n) {
            Node p;
            if (n == null){
                return;
            }
            if (n.getLeft()!=null && n.getRight()!=null){
                if(n.getLeft().getData()<n.getRight().getData()){
                    p = n.getLeft();
                }
                else {
                    p = n.getRight();
                }
            }else if(n.getLeft()!=null){
                p = n.getLeft();
            }else {
                return;
            }
            if (n.getData()>p.getData()){
                int temp = n.getData();
                n.setData(p.getData());
                p.setData(temp);
                swapDown(p);
            }
        }
    }
    public int solution(int[] scoville, int K) {
        int answer = 0;
        heap heap_1 = new heap();
//o(nlogn)
        for (int i = 0; i<scoville.length;i++){
            heap_1.add(scoville[i]);
        }
//o(n*(logn+logn+logn))=>o(nlogn)
        for(int i = 0 ;i<scoville.length;i++){
            int e = heap_1.remove();
            if (e >= K ) {
                break;
            }
            if (i == scoville.length-1){
                return -1;
            }
            e +=2*heap_1.remove();
            answer++;
            heap_1.add(e);
        }
        return answer;
    }
}
