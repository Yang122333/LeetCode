package container.heap;


import sun.security.util.Length;

import java.util.ArrayList;

public class HeapSort {
    public static void main(String[] args) {
        int[] array = new int[]{5, 2, 7, 2, 0, 6, 3, 1, 6, 5, 10};

        heapSort(array);
//        for (int i = array.length - 1; i > 0; i--) {
//            int temp = array[0];
//            array[0] = array[i];
//            array[i] = temp;
//            heapSort1(array,0,i);
//        }
        printArray(array);
        System.out.println();
        System.out.println(array.length + " " + modCount);
    }

    private static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }

    private static int modCount = 0;

    //n 为 待排序的最后一个 mytest
    public static void heapSort(int[] source, int index, int heapSize) {
        if (index < 0) {
            return;
        }
        //子节点
        int leftChild = index * 2 + 1;
        int rightChild = index * 2 + 2;
        if (leftChild < heapSize && source[index] < source[leftChild]) {
            int temp = source[index];
            source[index] = source[leftChild];
            source[leftChild] = temp;
        }
        if (rightChild < heapSize && source[index] < source[rightChild]) {
            int temp = source[index];
            source[index] = source[rightChild];
            source[rightChild] = temp;
        }

        if (index == 0) {
            int temp = source[0];
            source[0] = source[heapSize - 1];
            source[heapSize - 1] = temp;
        }
        modCount++;
        heapSort(source, index - 1, heapSize);
    }

    private static void heapSort(int[] data) {
        for (int i = data.length/2 -1; i >=0 ; i--) {
            maxHeapify(data, data.length, i);
        }
        //末尾与头交换，交换后调整最大堆
        for (int i = data.length - 1; i > 0; i--) {
            int temp = data[0];
            data[0] = data[i];
            data[i] = temp;
            maxHeapify(data, i, 0);
        }
    }

    public static void maxHeapify(int[] source, int heapSize, int index) {
        //子节点
        int leftChild = index * 2 + 1;
        int rightChild = index * 2 + 2;
        int largest = index;
        if (leftChild < heapSize && source[index] < source[leftChild]) {
            largest = leftChild;
        }
        if (rightChild < heapSize && source[largest] < source[rightChild]) {
            largest = rightChild;
        }
        modCount++;
        if (index != largest) {
            int temp = source[largest];
            source[largest] = source[index];
            source[index] = temp;
            maxHeapify(source, largest, heapSize);//太蠢！！！  //（只需要继续把改变后的节点拿出去继续调节）
        }

    }


    public static void sort(int[] arr) {
        //1.构建大顶堆
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            //从第一个非叶子结点从下至上，从右至左调整结构
            adjustHeap(arr, i, arr.length);
        }
        //2.调整堆结构+交换堆顶元素与末尾元素
        for (int j = arr.length - 1; j > 0; j--) {
            swap(arr, 0, j);//将堆顶元素与末尾元素进行交换
            adjustHeap(arr, 0, j);//重新对堆进行调整
        }

    }

    /**
     * 调整大顶堆（仅是调整过程，建立在大顶堆已构建的基础上）
     *
     * @param arr
     * @param i
     * @param length
     */
    public static void adjustHeap(int[] arr, int i, int length) {
        int temp = arr[i];//先取出当前元素i
        for (int k = i * 2 + 1; k < length; k = k * 2 + 1) {//从i结点的左子结点开始，也就是2i+1处开始
            if (k + 1 < length && arr[k] < arr[k + 1]) {//如果左子结点小于右子结点，k指向右子结点
                k++;
            }
            if (arr[k] > temp) {//如果子节点大于父节点，将子节点值赋给父节点（不用进行交换）
                arr[i] = arr[k];
                i = k;
            } else {
                break;
            }
            modCount++;
        }
        arr[i] = temp;//将temp值放到最终的位置
    }

    /**
     * 交换元素
     *
     * @param arr
     * @param a
     * @param b
     */
    public static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
