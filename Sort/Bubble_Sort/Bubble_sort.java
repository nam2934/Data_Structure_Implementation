class Bubble_sort{
    public static void main(String[] args) {
        int n = 10;
        int[] a = {10,9,8,7,6,5,4,3,2,1};
        bubble_sort(a, n);
        for(int i=0; i<n; i++){
            System.out.println(a[i]);
        }
    }

    public static void bubble_sort(int[] a, int n){
        boolean sort;
        int temp;
        do{
            sort = true;
            for(int i = 0; i < n - 1; i++){
                if(a[i] >  a[i+1]){
                    temp = a[i];
                    a[i] = a[i+1];
                    a[i+1] = temp;
                    sort = false;
                }
            }
        }while(!sort);
    }
}