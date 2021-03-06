package container.List;

public class LRU {
    /**
     * 三级缓存：内存、数据库（外存）、网络
     * 淘汰机制 FIFO （first in first out）
     * LFU (Least frequently used)
     * LRU (Least Recently used)
     */
    public static void main(String[] args) {
        LRUList<Integer> list = new LRUList<>();
        for (int i = 0; i < 10; i++) {
            list.put(i);
        }
        list.getNode(5);
        list.print();
    }

}
