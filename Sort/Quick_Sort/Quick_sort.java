import java.util.Random;

class Quick_sort{
    public static void main(String[] args) {
        int[] a = {10,9,8,7,6,5,4,3,2,1};
        int left = 0;
        int right = 10 - 1;

        quickSort(a, left, right);

        for(int i=0; i<=9; i++){
            System.out.println(a[i]);
        }
    }
    
    public static void quickSort(int[] a, int left, int right){
        int pivot, tmp;
        int i,j;
        Random rnd = new Random();

        if(left>=right) return;

        j = rnd.nextInt(right - left + 1) + left;

        tmp = a[j];
        a[j] = a[left];
        a[left] = tmp;

        pivot = a[left];

        i = left;
        for(j = left+1; j<=right; j++){
            if(a[j] < pivot){
                i++;
                tmp = a[i];
                a[i] = a[j];
                a[j] = tmp;
            }
        }
        tmp = a[left];
        a[left] = a[i];
        a[i] = tmp;

        quickSort(a, left, i-1);
        quickSort(a, i+1, right);
    }

}