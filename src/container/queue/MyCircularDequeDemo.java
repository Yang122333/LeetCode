package container.queue;

//use array
public class MyCircularDequeDemo {
    private int[] array;
    private int rear, front;

    /**
     * Initialize your data structure here. Set the size of the deque to be k.
     */
    public MyCircularDequeDemo(int k) {
        if(k <= 0){
            k = 1;
        }
        array = new int[k+1];
    }

    /**
     * Adds an item at the front of Deque. Return true if the operation is successful.
     */
    public boolean insertFront(int value) {
        if (isFull()) {
            return false;
        }
        front = (front - 1 +  array.length) %  array.length;
        array[front] = value;
        return true;
    }

    /**
     * Adds an item at the rear of Deque. Return true if the operation is successful.
     */
    public boolean insertLast(int value) {
        if (isFull()) {
            return false;
        }
        array[rear] = value;
        rear = (rear + 1) % array.length;
        return true;
    }

    /**
     * Deletes an item from the front of Deque. Return true if the operation is successful.
     */
    public boolean deleteFront() {
        if(isEmpty()){
            return false;
        }
        front = (front + 1) % array.length;
        return true;
    }

    /**
     * Deletes an item from the rear of Deque. Return true if the operation is successful.
     */
    public boolean deleteLast() {
        if(isEmpty()){
            return false;
        }
        rear = (rear - 1 + array.length) % array.length;
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
        if (rear == front) {
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