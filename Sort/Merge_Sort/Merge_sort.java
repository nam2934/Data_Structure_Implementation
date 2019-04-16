class Merge_sort{
    public static void main(String[] args) {
        int[] a = {10,9,8,7,6,5,4,3,2,1};
        int n = 10;
        merge_sort(a, 10);
        for(int i=0; i<n; i++){
            System.out.println(a[i]);
        }
    }

    public static void merge_sort(int[] a, int n){
        int [] aux = new int[a.length];
        do_merge_sort(a,0,n-1,aux);
    }
    public static void do_merge_sort(int[] a, int left, int right, int[] aux){
        int mid;
        int i,j,k;

        if(left >= right) return;
        mid = (left+right)/2;
        do_merge_sort(a, left, mid, aux);
        do_merge_sort(a, mid+1, right, aux);
        for(i=left, j=mid+1, k=left; (i<=mid) && (j<=right);){
            if(a[i] <= a[j]) aux[k++] = a[i++];
            else aux[k++] = a[j++];
        }
        while(i<=mid) aux[k++] = a[i++];
        while(j<=right) aux[k++] = a[j++];
        for(i = left; i<=right; i++){
            a[i] = aux[i];
        }
    }
}