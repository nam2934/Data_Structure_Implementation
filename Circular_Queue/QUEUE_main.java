class QUEUE_main{
    public static void main(String[] args) {
        circular_queue queue = new circular_queue();
        queue.Queue(5); // make circular queue
        System.out.println("QUEUE IS EMPTY? : " + queue.isEmpty());
        System.out.println("QUEUE IS FULL? : " + queue.isFull());
        System.out.println("---------------------------------------");

        queue.enqueue(1);
        queue.PrintAll();
        queue.enqueue(2);
        queue.PrintAll();
        queue.enqueue(3);
        queue.PrintAll();
        queue.enqueue(4);
        queue.PrintAll();
        queue.enqueue(5);
        queue.PrintAll();
        System.out.println("---------------------------------------");

        queue.enqueue(6); // full!
        System.out.println("---------------------------------------");

        queue.dequeue();
        queue.PrintAll();
        queue.dequeue();
        queue.PrintAll();
        queue.dequeue();
        queue.PrintAll();
        queue.dequeue();
        queue.PrintAll();
        queue.dequeue();
        queue.PrintAll();
        System.out.println("QUEUE IS EMPTY? : " + queue.isEmpty());
        System.out.println("QUEUE IS FULL? : " + queue.isFull());
        System.out.println("---------------------------------------");

        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);
        queue.PrintAll();
        System.out.println("---------------------------------------");

        queue.dequeue();
        queue.PrintAll();
        queue.dequeue();
        queue.PrintAll();
        queue.enqueue(6);
        queue.PrintAll();
        queue.enqueue(7);
        queue.PrintAll();
        queue.enqueue(8);
        queue.PrintAll();

        System.out.println("---------------------------------------");

        queue.dequeue();
        queue.PrintAll();
        queue.dequeue();
        queue.PrintAll();
        queue.dequeue();
        queue.PrintAll();
        queue.dequeue();
        queue.PrintAll();
        queue.dequeue();
        queue.PrintAll();
        System.out.println("QUEUE IS EMPTY? : " + queue.isEmpty());
        System.out.println("QUEUE IS FULL? : " + queue.isFull());
        System.out.println("---------------------------------------");
    }
}