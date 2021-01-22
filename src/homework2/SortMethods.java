package homework2;

import java.util.Arrays;

public class SortMethods {
    private final int[] a;
    private final int elems;

    public SortMethods(int[] a) {
        this.a = Arrays.copyOf(a, a.length);
        elems = a.length;
    }

    public void bubbleSort(){
        for(int i = elems - 1; i >= 1; i--){
            for (int j = 0; j < i; j++){
                if(a[j] > a[j+1]){
                    swapM(j, j + 1);
                }
            }
        }
    }

    public void selectionMethod(){
        for(int i = 0; i < a.length - 1; i++){
            int min = i;
            for (int j = i + 1; j < a.length; j++ ){
                if(a[j] < a[min]) {
                    min = j;
                }
            }
            swapM(i, min);
        }
    }

    public void insertMethod(){
        int in;
        for(int i = 1; i < a.length; i++){
            int buff = a[i];
            in = i;
            while (in > 0 && a[in - 1] >= buff){
                a[in] = a[in - 1];
                --in;
            }
            a[in] = buff;
        }
    }

    private void swapM(int first, int last) {
        int buff = a[first];
        a[first] = a[last];
        a[last] = buff;
    }

    public int[] getA() {
        return a;
    }
}
