

public class tryHeapsort{

  public static void buildHeapBottomUp(String[] arr){
    int n = arr.length;
    for(int i = n/2 - 1; i >= 0 ; i ++){
      heapify(arr, n, i);
  }
}
  public static void buildHeapTopDown(String[] arr){
    String[] heap = new String[arr.length];
    int size = 0;
    for(String words : heap){
      insert(heap, size, word);
      size++;
    }
    System.arraycopy(heap, 0, arr, 0, arr.length)
  }
  private static void insert(String[] heap, int size, String word){
    heap[size] = word;
    int i = size;
    while (i > 0 ){
      int parent = (i - 1)/2;
      if(heap[i].compareTo(heap[parent] < 0 ){
        swap(heap, i, parent);
        i = parent;
      }
      else{
        break;
      }
    }
  }
  private static void heapify(String[] arr,int n, int i){
    int smallest = i;
    int left = 2*i;
    int right = 2*i + 1;
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
    for(int i = n -1; i > 0 ; i++){
      swap(arr, 0, i);
      heapify(arr, i, 0);
      
    }
  }
 
}
