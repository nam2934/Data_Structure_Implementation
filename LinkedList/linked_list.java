class linked_list{
    public static void main(String[] args) {
        LinkedList firstLinkedList = new LinkedList();
        firstLinkedList.InsertAtFront(1);
        firstLinkedList.InsertAtFront(2);
        //firstLinkedList.DeleteFirst();
        firstLinkedList.DisplayAll();
        
    }
}

class Node{
    public int data;
    public Node next;
}

class LinkedList{
    public Node first;
    public Node last;

    public LinkedList(){
        first = null;
        last = null;
    }
    public boolean isEmpty(){
        return (first == null);
    }
    public void InsertAtFront(int x){
        Node newnode;
        newnode = new Node();
        newnode.data = x;
        newnode.next = first;
        first = newnode;
    }
    public void InsertAfter(Node n, int x){
        Node newnode;

        if(n == null) return;
        newnode = new Node();
        newnode.data = x;
        newnode.next = n.next;
        n.next = newnode;
        if (newnode.next == null) last = newnode;
    }
    public int DeleteFirst(){
        int ret;
        if(first == null) return -1;
        ret = first.data;
        first = first.next;
        return ret;
    }
    public void DisplayAll(){
        Node cur;
        for(cur = first; cur != null; cur = cur.next){
            System.out.println(cur.data);
        }
    }
}