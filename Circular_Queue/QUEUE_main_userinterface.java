import java.util.Scanner;

class QUEUE_main_userinterface{
    public static void main(String[] args) {
        circular_queue queue = new circular_queue();
        Scanner input = new Scanner(System.in);

        System.out.print("enter circular_queue size : ");
        int size = input.nextInt();
        
        queue.Queue(size); // make circular queue
        
    }
}