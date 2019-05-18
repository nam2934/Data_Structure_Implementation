class LinkedList{
    Node first;
    Node last;
    public LinkedList(){
        first = null;
        last = null;
    }
    public boolean isEmpty(){
        return (first==null);
    }
    public void append(int x){
        Node newnode = new Node(x);
        if(first == null){
            first = newnode;
            last = newnode;
            newnode.next = null;
        }
        else{
            last.next = newnode;
            last = newnode;
        }
    }

}