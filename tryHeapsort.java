import java.util.Arrays;

public class tryHeapsort{
    public static void main(String[] args){
        String[] testing = {"gins", "are", "toxic", "you", "should", "never", "ever", "take", "them", "or", "consume", "them", "it", "ruins", "your", "health", "and", "damages", "your", "lungs"};
        long startforBottomUp = System.nanoTime();
        buildHeapBottomUp(testing);
        heapsort(testing);
        long endforBottomUp = System.nanoTime();
        System.out.println("Bottom up sorted: " + Arrays.toString(testing));
        System.out.println("Bottom up time: " + (endforBottomUp - startforBottomUp) + " ns");

        String[] testing2 = {"gins", "are", "toxic", "you", "should", "never", "ever", "take", "them", "or", "consume", "them", "it", "ruins", "your", "health", "and", "damages", "your", "lungs"};
        long startforTopDown = System.nanoTime();
        buildHeapTopDown(testing2);
        heapsort(testing2);
        long endforTopDown = System.nanoTime();
        System.out.println("Top down sorted: " + Arrays.toString(testing2));
        System.out.println("Top down time: " + (endforTopDown - startforTopDown) + " ns");
    }

    public static void buildHeapBottomUp(String[] arr){
        int n = arr.length;
        if(n== 0){return;}
        for(int i = n/2 - 1; i >= 0 ; i --){
            heapify(arr, n, i);
        }
    }
    public static void buildHeapTopDown(String[] arr){
        int size = 0;
        for(String word : arr){
            insert(arr, size, word);
            size++;
        }
        System.arraycopy(arr, 0, arr, 0, arr.length);
    }
    private static void insert(String[] heap, int size, String word){
        heap[size] = word;
        int i = size;
        while (i > 0 ){
            int parent = (i - 1)/2;
            if(heap[parent] != null && heap[i].compareTo(heap[parent]) < 0 ){
                swap(heap, i, parent);
                i = parent;
            }
            else{ break;}
        }
    }
    private static void heapify(String[] arr,int n, int i){
        int smallest = i;
        int left = 2*i+1;
        int right = 2*i + 2;
        if(left < n && arr[left].compareTo(arr[smallest]) < 0){
            smallest = left;
        }
        if(right < n && arr[right].compareTo(arr[smallest]) < 0){
            smallest = right;
        }
        if(smallest != i){
            swap(arr, i, smallest);
            heapify(arr, n, smallest);

        }
    }
    public static void heapsort(String[] arr){
        int n = arr.length;
        for(int i = n -1; i > 0 ; i--){
            swap(arr, 0, i);
            heapify(arr, i, 0);

        }
    }
    public static void swap(String[] arr, int i, int j){
        String temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;

    }

}

