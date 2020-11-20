package container;

public class LinkList<T> {
    class Node {
        T data;
        Node node;
        Node next;

        public Node(T data, Node node) {
            this.data = data;
            this.node = node;
        }
    }

    private Node list;
    private int size;

    //增删改查
    public void put(T data) {
        Node head = list;
        Node curNode = new Node(data, list);
        list = curNode;
        size++;
    }

    public void put(int index, T data) {
        enableIndex(index);
        if (index == 0) {
            put(data);
            return;
        } else {
            Node node = FindNode(index - 1);
            Node next = node.next;
            node.next = new Node(data, next);
        }
        size++;
    }

    public Node FindNode(int index) {
        enableIndex(index);
        Node curNode = list;
        for (int i = 0; i < index; i++) {
            curNode = curNode.next;
        }
        return curNode;
    }

    public void enableIndex(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
    }

    public T remove() {
        if (size == 0) {
            return null;
        }
        Node node = list;
        list = list.next;
        node.next = null;
        size--;
        return node.data;
    }

    public T remove(int index) {
        enableIndex(index);
        if (index == size) {
            throw new IndexOutOfBoundsException("数组越界");
        }
        T data;
        if (index == 0) {
            data = list.data;
            list = list.next;
        } else {
            Node node = FindNode(index - 1);
            Node removeNode = node.next;
            Node next = removeNode.next;
            data = removeNode.data;
            node.next = next;
        }
        size--;
        return data;
    }

    public T removeLast() {
//        return remove(size - 1);
        if(list != null){
            Node prev = list ,cur = list;
            while (cur.next != null){
                prev = cur;
                cur = cur.next;
            }
            prev.next = null;
            size --;
            return cur.data;
        }
        return null;
    }

    public void set(int index, T newData) {
        enableIndex(index);
        Node curNode = list;
        for (int i = 0; i < index; i++) {
            curNode = curNode.next;
        }
        curNode.data = newData;
    }

    public T getHead() {
        return list.data;
    }

    public T get(int index) {
        Node curNode = list;
        for (int i = 0; i < index; i++) {
            curNode = curNode.next;
        }
        return curNode.data ;
    }

}

class  LRUList<T> extends LinkList<T>{
    private int LRU_MAX = 5;
    private int maxCapacity;
    public LRUList(int maxCapacity){
       this.maxCapacity = maxCapacity;
    }
    public LRUList(){
        this.maxCapacity = LRU_MAX;
    }
    public void put(T data){

    }
}
