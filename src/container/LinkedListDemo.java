package container;

import java.util.Collection;

public class LinkedListDemo<T> {
    private class Node<T> {
        private T data;
        private Node<T> prev;
        private Node<T> next;

        public Node(Node<T> prev, T e, Node<T> next) {
            data = e;
            this.prev = prev;
            this.next = next;
        }
    }

    private Node<T> first;
    private Node<T> last;
    private int size;

    public LinkedListDemo() {
    }

    private void checkIndex(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException(index + "");
        }
    }

    public void add(T element) {
        Node<T> l = last;
        Node<T> newNode = new Node<T>(l, element, null);
        if (last == null) {
            first = newNode;
        } else {
            last.next = newNode;
            last = newNode;
        }
        size++;
    }

    public void addAll(int index, Collection<T> datas) {
        Object[] array = datas.toArray();
        Node<T> prev, succ;
        if (index == size) {
            succ = null;
            prev = last;
        } else {
            succ = findNode(index);
            prev = succ.prev;
        }
        for (Object o : array) {
            Node<T> node = new Node<T>(prev, (T)o, null);
            if(prev == null){
                first = node;
            } else {
                prev.next = node;
            }
            prev = node;
        }
        if(index == size){ //或者 succ
            last = prev;
        }else{
            prev.next = succ;
            succ.prev = prev; //忘记连接！！！
        }
        size += array.length;
    }

    public void remove(int index){
        checkIndex(index);
        Node<T> curNode = findNode(index);
        Node<T> prev = curNode.prev;
        Node<T> next = curNode.next;
       if(prev == null){
           first = next;
       } else{
           prev.next = next;
           curNode.prev = null;
       }
       if(next == null){
           last = prev;
       }else{
           next.prev = prev;
           curNode.next = null;
       }
       curNode.data = null;
       size --;
    }

    public Node<T> findNode(int index) {
        checkIndex(index);
        Node<T> curNode;
        if (index <= size >> 1) {
            curNode = first.next;
            for (int i = 0; i < index; i++) {
                curNode = curNode.next;
            }
        } else {
            curNode = last.prev;
            for (int i = size -1; i > index ; i--) {
                curNode = curNode.prev;
            }
        }
        return curNode;
    }
}
