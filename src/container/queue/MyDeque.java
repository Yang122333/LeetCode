package container.queue;

//use array
public class MyDeque {
    private int[] array;
    private int size = 0;
    private int frontSize = 0;

    //["MyCircularDeque","insertFront","getRear","insertFront","getRear","insertLast","getFront","getRear","getFront","insertLast","deleteLast","getFront"]
//[[3],[9],[],[9],[],[5],[],[],[],[8],[],[]]     [null,true,9,true,9,true,9,5,9,false,true,9]
    public static void main(String[] args) {
        MyDeque queue = new MyDeque(3); // 设置容量大小为3
        queue.insertFront(9);
        queue.print();
        // 返回 true
        queue.insertFront(9);                    // 返回 true
        queue.print();
        queue.insertLast(5);                    // 返回 true
        queue.print();
        queue.insertLast(8);                // 返回 2
        queue.deleteLast();
        queue.print();
    }

    /**
     * Initialize your data structure here. Set the size of the deque to be k.
     */
    public MyDeque(int k) {
        array = new int[k];
    }

    /**
     * Adds an item at the front of Deque. Return true if the operation is successful.
     */
    public boolean insertFront(int value) {
        if (size >= array.length) {
            return false;
        }
        System.arraycopy(array, 0, array, 1, frontSize);
        array[0] = value;
        frontSize++;
        size++;
        return true;
    }

    /**
     * Adds an item at the rear of Deque. Return true if the operation is successful.
     */
    public boolean insertLast(int value) {
        if (size >= array.length) {
            return false;
        }
        int rearSize = size - frontSize;
        System.arraycopy(array, array.length - rearSize, array, array.length - 1 - rearSize, rearSize);
        array[array.length - 1] = value;
        size++;
        return true;
    }

    /**
     * Deletes an item from the front of Deque. Return true if the operation is successful.
     */
    public boolean deleteFront() {
        if (frontSize <= 0) {
            return false;
        }
        System.arraycopy(array, 1, array, 0, frontSize - 1);
        frontSize--;
        size--;
        return true;
    }

    /**
     * Deletes an item from the rear of Deque. Return true if the operation is successful.
     */
    public boolean deleteLast() {
        if (size - frontSize <= 0) {
            return false;
        }
        int rearSize = size - frontSize;
        System.arraycopy(array, array.length - rearSize, array, array.length - rearSize + 1, rearSize - 1);
        size--;
        return true;
    }

    public void print() {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    /**
     * Get the front item from the deque.
     */
    public int getFront() {
        return array[0];
    }

    /**
     * Get the last item from the deque.
     */
    public int getRear() {
        return array[array.length - 1];
    }

    /**
     * Checks whether the circular deque is empty or not.
     */
    public boolean isEmpty() {
        if (size <= 0) {
            return true;
        }
        return false;
    }

    /**
     * Checks whether the circular deque is full or not.
     */
    public boolean isFull() {
        if (size == array.length) {
            return true;
        }
        return false;
    }
}