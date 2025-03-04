package pa1_template;

public class QuickSort {

    BubbleSort bubble = new BubbleSort();
    
    public int[] lemutoQuickSort(int[] ints, int low, int high){
        int partition;
        if (ints.length <= 1){
            return ints;
        }

        if (low < high) {
            partition = lemutoPartition(ints, low, high);
            lemutoQuickSort(ints, low, partition-1);
            lemutoQuickSort(ints, partition+1, high);
        }
        return ints;
    }

    public int[] hoareQuickSort(int[] ints, int low, int high){
        int partition;
        if (ints.length <= 1){
            return ints;
        }

        if (low < high) {
            partition = hoarePartition(ints, low, high);
            hoareQuickSort(ints, low, partition);
            hoareQuickSort(ints, partition+1, high);
        }
        return ints;
    }
    
    public int lemutoPartition(int[] ints, int low, int high){
        int i;
        int p;
        int firsthigh;

        p = high;
        firsthigh = low;
        for (i = low; i < high; i++){
            if(ints[i] < ints[p]){
                bubble.swap(ints, i, firsthigh);
                firsthigh++;
            }
        }

        bubble.swap(ints, p, firsthigh);

        return firsthigh;
    }

    public int hoarePartition(int[] ints, int low, int high){
        int pivot = ints[low];
        int i = low;
        int j = high;
        while (true){
            while (ints[i] < pivot){
                i++;
            }
            while (ints[j] > pivot){
                j--;
            }
            if (j <= i){
                return j;
            }
            bubble.swap(ints, i, j);

            i++;
            j--;
        }
    }
}
