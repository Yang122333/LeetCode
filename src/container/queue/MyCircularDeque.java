package container.queue;

//use array
class MyCircularDeque {
    private int[] array;
    private int size;
    private int rear, front;

//["MyCircularDeque","insertFront","getFront","isEmpty","deleteFront","insertLast","getRear","insertLast","insertFront","deleteLast","insertLast","isEmpty"]
//        [[8],[5],[],[],[],[3],[],[7],[7],[],[4],[]]
    //[null,true,5,false,true,true,3,true,true,true,true,false]
    public static void main(String[] args) {
        MyCircularDequeDemo queue = new MyCircularDequeDemo(3); // 设置容量大小为3
        queue.insertFront(8);
        queue.print();
        // 返回 true
        queue.deleteFront();
        queue.print();
        queue.insertLast(3);                    // 返回 true
        queue.print();
        queue.insertLast(7);                    // 返回 true
        queue.print();
        queue.insertFront(7);                // 返回 2
        queue.deleteLast();
        queue.print();
        queue.insertLast(4);
        queue.print();
    }

    /**
     * Initialize your data structure here. Set the size of the deque to be k.
     */
    public MyCircularDeque(int k) {
        array = new int[k];
    }

    /**
     * Adds an item at the front of Deque. Return true if the operation is successful.
     */
    public boolean insertFront(int value) {
        if (isFull()) {
            return false;
        }
        if (size != 0) {
            front = (front - 1 +  array.length) %  array.length;
        }
        array[front] = value;
        size++;
        return true;
    }

    /**
     * Adds an item at the rear of Deque. Return true if the operation is successful.
     */
    public boolean insertLast(int value) {
        if (isFull()) {
            return false;
        }
        if(size != 0){
            rear = (rear +1) % array.length;
        }
        array[rear] = value;
        size ++;
        return true;
    }

    /**
     * Deletes an item from the front of Deque. Return true if the operation is successful.
     */
    public boolean deleteFront() {
        if(isEmpty()){
            return false;
        }
        if(size != 1){
            front = (front + 1) % array.length;
        }
        size --;
        return true;
    }

    /**
     * Deletes an item from the rear of Deque. Return true if the operation is successful.
     */
    public boolean deleteLast() {
        if(isEmpty()){
            return false;
        }
        if(size != 1){
            rear = (rear - 1 + array.length) % array.length;
        }
        size --;
        return true;
    }

    public void print() {
        int index = front;
        while(index != rear){
            System.out.print(array[index] + " ");
            index = (index + 1)% array.length;
        }
        System.out.println(array[rear] + " ");
    }

    /**
     * Get the front item from the deque.
     */
    public int getFront() {
        if(isEmpty()){
            return -1;
        }
        return array[front];
    }

    /**
     * Get the last item from the deque.
     */
    public int getRear() {
        if(isEmpty()){
            return -1;
        }
        return array[rear];
    }

    /**
     * Checks whether the circular deque is empty or not.
     */
    public boolean isEmpty() {
        if (size == 0) {
            return true;
        }
        return false;
    }

    /**
     * Checks whether the circular deque is full or not.
     */
    public boolean isFull() {
        if ((rear + 1) % array.length == front) {
            return true;
        }
        return false;
    }
}