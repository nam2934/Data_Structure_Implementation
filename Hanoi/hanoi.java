class hanoi{
    public static void Hanoi(int n, int from, int to){
        if(n<=0) return;
        int aux;
        aux = 6 - from - to;
        Hanoi(n-1,from, aux);
        System.out.println("Move a disk from rod " + from +" to rod " + to);
        Hanoi(n-1, aux, to);
    }
    public static void main(String[] args) {
        Hanoi(8, 1, 3);
    }
}
