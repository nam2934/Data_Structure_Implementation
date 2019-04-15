class Selection_sort{
    public static void main(String[] args) {
        int size = 10;
        int[] a = {10,9,8,7,6,5,4,3,2,1};
        selection_sort(size, a);

        for(int i = 0; i < size; i++){
            System.out.println(a[i]);
        }
        
    }
    public static void selection_sort(int n, int[] a){
        int i,j,k,temp;

        for(i = 0; i < n-1; i++){
            j = i;
            for(k = i+1; k < n; k++){
                if(a[j] > a[k]) j = k;
            }
            temp = a[i];
            a[i] = a[j];
            a[j] = temp;
        }

    }
}