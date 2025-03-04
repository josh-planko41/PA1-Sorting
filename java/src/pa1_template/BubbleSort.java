package pa1_template;

public class BubbleSort {


    public int[] bubbleSort(int[] ints){
        int n = ints.length;
        if (n <= 1){
            return ints;
        }
        for (int i = 0; i < n-1; i++){
            for (int j = 0; j < n-i-1; j++){
                if (ints[j] > ints[j+1]) {
                    swap(ints, j, j+1);
                }
            }
            
        }

        return ints;
    }

    public void swap(int[] A, int i, int j){
        int intermediate = A[j];
        A[j] = A[i];
        A[i] = intermediate;
    }
    
}
