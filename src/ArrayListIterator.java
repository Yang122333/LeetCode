import java.util.ArrayList;
import java.util.LinkedList;

public class ArrayListIterator {
    private  static int size;
    private static int[] nums;
    private int prevpos = 0, curpos = 1;

    public static void main(String[] args) {
        ArrayListIterator ali = new ArrayListIterator();
        int[] a = new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        ali.searchInsert(a, 3);
        for (int i = 0; i < size; i++) {
            System.out.println(nums[i]);
        }
    }

    public int removeDuplicates(int[] nums) {
        size = nums.length;
        if (size <= 1) {
            return size;
        }
        this.nums = nums;
        while (hasNext()) {
            if (nums[prevpos] == nums[curpos]) {
                iterateRemove();
            } else {
                next();
            }
        }
        return size;
    }

    public int searchInsert(int[] nums, int target) {
        this.nums = nums;
        this.size = nums.length;
        int index = 0;
        for (int i = 0; i < size; i++) {
            if (target < nums[i]) {
                index = i;
                break;
            } else {
                index = i + 1;
            }
        }
        add(index, target);
        return index;
    }


    private boolean hasNext() {
        return curpos != size;
    }

    private int next() {
        int i = curpos;
        curpos++;
        return nums[prevpos = i];
    }

    private void iterateRemove() {

        remove(curpos);
    }

    private void remove(int index) {
        if (index >= size || index < 0) {
            return;
        }
        int offsetLength = size - index - 1;
        System.arraycopy(nums, index + 1, nums, index, offsetLength);
        nums[--size] = 0;
    }

    public void add(int index, int e) {
        if (index > size || index < 0) {
            return;
        }
        enableCapacity(size + 1);
        int moveLength = size - index;
        System.arraycopy(nums,index,nums,index+1,moveLength);
        nums[index] = e;
        size ++;
    }

    private void enableCapacity(int minLength) {
        if (minLength > nums.length) {
            grow(minLength);
        }
    }

    private void grow(int minLength) {
        int oldLength = nums.length;
        int newLength = oldLength + oldLength >> 2;
        newLength = Math.max(newLength, minLength);
        int[] temp = new int[newLength];
        System.arraycopy(nums, 0, temp, 0, nums.length);
        nums = temp;
    }
}
