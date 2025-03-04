package pa1_template;

import java.util.ArrayDeque;
import java.util.Deque;

public class MergeSort {
    
    public int[] mergeSort(int[] ints, int low, int high){
        if (ints.length <= 1){
            return ints;
        }

        int midpoint;
        midpoint = (low + high)/2;
        if (low < high){
            mergeSort(ints, low, midpoint);
            mergeSort(ints, midpoint+1, high);
            merge(ints, low, midpoint, high);
        }
        return ints;
    }

    public int[] merge(int[] ints, int low, int middle, int high){
        int i;
        Deque<Integer> buffer1 = new ArrayDeque<>();
        Deque<Integer> buffer2 = new ArrayDeque<>();

        for (i = low; i <= middle; i++){
            buffer1.add(ints[i]);
        }
        for (i = middle+1; i <= high; i++){
            buffer2.add(ints[i]);
        }

        i = low;
        while(!(buffer1.isEmpty() || buffer2.isEmpty())){
            if (buffer1.peek() <= buffer2.peek()){
                ints[i++] = buffer1.remove();
            } else {
                ints[i++] = buffer2.remove();
            }
        }

        while(!buffer1.isEmpty()){
            ints[i++] = buffer1.remove();
        }
        
        while(!buffer2.isEmpty()){
            ints[i++] = buffer2.remove();
        }

        return ints;
    }
}
