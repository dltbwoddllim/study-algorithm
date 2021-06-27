package Stack;

public class StackBylinkedList {
    private class Node{
        int e;
        Node nextNode;

        public Node(int v){
            this.e=v;
            this.nextNode = null;
            return;
        }

        public int getElement(){
                return this.e;
        }

        public void setNextNode(Node n){
            this.nextNode = n;
            return;
        }

        public Node getNextNode(){
            return this.nextNode;
        }
    }
    
    Node top;
    int size;

    public StackBylinkedList(){
        this.top = null;
        this.size = 0;
    }
    public void push(int n){
        Node newNode = new Node(n);
        if (size() != 0) {
            newNode.nextNode = top();
        }
        this.top = newNode;
        size++;
        return;
    }
    public int pop(){
        if (size()==0){
            return 0;
        }
        Node removeNode = top();
        int removeE = removeNode.e;
        this.top = removeNode.getNextNode();
        removeNode = null;
        size--;
        return removeE;
    }
    public Node top(){
        return this.top;
    }
    public int size(){
        return this.size;
    }
    public boolean isEmpthy(){
        if (size()==0){
            return true;
        }
        return false;
    }
}
