public class queueByLinkedList {
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
        if (size()==1){
            frontNode = null;
            rearNode = null;
        }else {
            frontNode = frontNode.getNextNode();
        }
        removeNode = null;
        this.size--;
        return new Node(e);
    }
}
