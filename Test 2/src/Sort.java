public class Sort {

    public static void main(String[] args) {
        System.out.println();
    }


    private static void bubbleSort(int arr[]){

    boolean judge = true;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if(arr[j] > arr[j + 1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    judge = false;
                }
                if (judge) {
                    break;
                }
            }
        }
    }

    /**
     * Insert sort is get the number arr[i] inserted to the sorted series, which are from the 1 to number i-1;
     */
    private static void insertSort(int arr[]){
        for (int i = 1, len = arr.length; i < len; i++) {
            if (arr[i] < arr[i - 1]) {
                int temp = arr[i];
                int j;
                for (j = i - 1; j >= 0 && temp < arr[j]; j--) {
                    arr[j + 1] = arr[j];
                    // we move those number who larger than temp back one position
                }
                    arr[j + 1] = temp;
                // We put the temp at the right position, however, when we j--, we let j smaller than what we need
            }
        }
    }

    private static void shellSort(int[] arr) {		// 将数组分组
        for (int r = arr.length / 2; r >= 1; r /= 2) {
            // 这里的思路和插入排序的思路相同，通过找到前一个的数大于或者小于来进行插入
            for (int i = r; i < arr.length; i += r) {
                int temp = arr[i];
                int j = i - r;
                while (j >= 0 && temp < arr[j]) {
                    arr[j + r] = arr[j];
                    j -= r;
                }
                arr[j + r] = temp;
            }
        }

    }

    public static void selectSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i; // 用来记录最小值的索引位置，默认值为i
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j; // 遍历 i+1~length 的值，找到其中最小值的位置
                }
            }            // 交换当前索引 i 和最小值索引 minIndex 两处的值
            if (i != minIndex) {
                int temp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = temp;
            }            // 执行完一次循环，当前索引 i 处的值为最小值，直到循环结束即可完成排序
        }
    }

    static void  selectSort2(int arr[]){
        for (int i = 0; i < arr.length-1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if(arr[i] > arr[j]){
                    int temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                }
            }
        }
    }

    public static void heapSort(int[] arr) {
        // 1. 创建最大堆：从最后一个节点的父节点开始
        int lastIndex = arr.length - 1;
        int startIndex = (lastIndex - 1) / 2;
        for (int i = startIndex; i >= 0; i--) {
            maxHeap(arr, arr.length, i);    }
            // 2. 排序：末尾与头交换，逐一找出最大值，最终形成一个递增的有序序列
        for (int i = arr.length - 1; i > 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            maxHeap(arr, i, 0);
        }
    }

    private static void maxHeap(int[] data, int heapSize, int index)
    {    // 左子节点
        int leftChild = 2 * index + 1;    // 右子节点
        int rightChild = 2 * index + 2;    // 最大元素下标
        int largestIndex = index;    // 分别比较当前节点和左右子节点，找出最大值
        if (leftChild < heapSize && data[leftChild] > data[largestIndex])
        {
            largestIndex = leftChild;
        }
        if (rightChild < heapSize && data[rightChild] > data[largestIndex])
        {        largestIndex = rightChild;    }    // 如果最大值是子节点，则进行交换
        if (largestIndex != index) {
            int temp = data[index];
            data[index] = data[largestIndex];
            data[largestIndex] = temp;        // 交换后，其子节点可能就不是最大堆了，需要对交换的子节点重新调整
            maxHeap(data, heapSize, largestIndex);
        }
    }


    /**
     * we find all the number who are smaller the key and put them before the key,
     * similarly, we put all the number who are bigger than the key after the key.
     * @param arr
     * @param low
     * @param high
     */
    public void quickSort(int[] arr,int low,int high){
        int start = low;
        int end = high;
        int key = arr[low];


        while(end>start){
            //From the back, we find the number who is smaller than the key, and switch them
            while(end > start && arr[end] >= key)
                end--;
            if(arr[end]<=key){
                int temp = arr[end];
                arr[end] = arr[start];
                arr[start] = temp;
            }
            //From the front, we find the number who is bigger than the key and switch them
            while(end > start && arr[start] <= key)
                start++;
            if(arr[start] >= key){
                int temp = arr[start];
                arr[start] = arr[end];
                arr[end] = temp;
            }
        }
        //Call itself
        if(start>low) quickSort(arr,low,start-1);
        if(end<high) quickSort(arr,end+1,high);
    }

    private void mergeSort(int arr[], int l, int r){

    }


}
