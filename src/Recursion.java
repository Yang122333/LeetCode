import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

public class Recursion {


    public static void main(String[] args) {

        int[] arrays = {2, 3, 4, 1};
//        maoPao(arrays,0,arrays.length - 1);
//
//        for (int i = 0; i < arrays.length; i++) {
//            System.out.print(arrays[i]);
//        }
//        System.out.println(jiecheng(4));
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            arrayList.add(i);
        }
        ListIterator it = arrayList.listIterator();
        it.add(9999);
        it.next();
        for (int i = 0; i < arrayList.size(); i++) {
            System.out.print(arrayList.get(i));
        }
    }


    /**
     * 递归，找出数组最大的值
     *
     * @param arrays 数组
     * @param L      左边界，第一个数
     * @param R      右边界，数组的长度
     * @return
     */

    public static int findMax(int[] arrays, int L, int R) {

        //如果该数组只有一个数，那么最大的就是该数组第一个值了
        if (L == R) {
            return arrays[L];
        } else {

            int a = arrays[L];
            int b = findMax(arrays, L + 1, R);//找出整体的最大值

            if (a > b) {
                return a;
            } else {
                return b;
            }
        }
    }

    public static void maoPao(int[] array) {
        int temp;
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    temp = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = temp;
                }
            }
        }
    }

    public static void maoPao(int[] array, int L, int R) {
        if (L == R) {
            return;
        }
        int temp;
        for (int i = L; i < R; i++) {
            if (array[i] > array[i + 1]) {
                temp = array[i + 1];
                array[i + 1] = array[i];
                array[i] = temp;
            }
        }
        maoPao(array, L, R - 1);
    }

    //斐波那契数列
    public static int feibonq(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 0) {
            return 0;
        }
        return feibonq(n - 1) + feibonq(n - 2);
    }
    //阶乘  fn = fn-1  * n ，出口 n ==1 return 1;

    public static int jiecheng(int n) {
        if (n == 1) {
            return 1;
        }
        return jiecheng(n - 1) * n;
    }

}
