class Insertion_sort{
    public static void main(String[] args) {
        int size = 10;
        int[] a = {10,9,8,7,6,5,4,3,2,1};
        insertion_sort(size, a);

        for(int i = 0; i < size; i++){
            System.out.println(a[i]);
        }
    }
    public static void insertion_sort(int n, int[] a){
        int i,j,temp;
        for(i=0; i<n; i++){
            temp = a[i];
            for(j=i-1; j>=0; j--){
                if(a[j] <= temp) break; // temp로 비교하는 이유 : a[i]의 값이 바뀌기 때문에!
                a[j+1] = a[j];
            }
            a[j+1] = temp;
        }
    }
}