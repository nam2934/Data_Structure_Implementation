class circular_queue{
    private int[] data;
    private int size;
    private int front;
    private int rear;

    public void Queue(int s){
        s++;
        data = new int[s];
        size = s;
        front = 0;
        rear = -1 + s;
    }
    public void enqueue(int x){
        if(!isFull()){
            rear = (rear + 1)% size;
            data[rear] = x;
        }
        else System.out.println("QUEUE IS FULL!");
    }
    public int dequeue(){
        int ret;
        if(!isEmpty()){
            ret = data[front];
            front = (front + 1)%size;
            return ret;
        }
        else{
            System.out.println("QUEUE IS EMPTY");
            return -1;
        } 
    }
    public boolean isEmpty(){
        return ((rear + 1)%size == front);
    }
    public boolean isFull(){
        return ((rear + 2)%size == front);
    }
    public void PrintAll(){
        if(isEmpty()){
            System.out.print("empty");
        }
        
        else if(front > rear){
            if(front == rear + 1) System.out.print(" ");
            else {
                for(int i=front; i<size ; i++){
                    if(i == front) System.out.print("*");
                    System.out.print(data[i] + " ");
                }
                for(int i=0; i<=rear ; i++){
                    if(i == front) System.out.print("*");
                    System.out.print(data[i] + " ");
                }
            }
        }
        else{
            for(int i=front; i<=rear ; i++){
                System.out.print(data[i] + " ");
            }
        }
        System.out.println("");
        //System.out.println(front);
    }
}

