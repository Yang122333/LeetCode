/**
 * * LCP 12. 小张刷题计划
 * * 2020/7/25 难度：中等
 */
public class minMaxDayTime {
    public static void main(String[] args) {
        System.out.println(minT(new int[]{1,2,3,3}, 2));
    }

    public static int minTime(int[] time, int m) {
        if (time.length == m) {
            return 0;
        }
        sort(time);
        int maxPos = time.length - 1 - m;
        if (time.length - m <= m) {
            return time[maxPos];
        }
        int count = 0;
        for (int i = 0; i < time.length; i++) {
            count += time[i];
        }
        double cover = count * 1.0 / m;
        if (cover <= time[maxPos]) {
            return time[maxPos];
        }
        return 0;
    }

    public static void sort(int[] times) {
        int temp;
        for (int i = 0; i < times.length - 1; i++) {
            for (int j = 0; j < times.length - 1 - i; j++) {
                if (times[j] > times[j + 1]) {
                    temp = times[j];
                    times[j] = times[j + 1];
                    times[j + 1] = temp;
                }
            }
        }
    }


    /*
     * LCP 12. 小张刷题计划
     * 2020/7/25 难度：中等
     */
    public static int minT(int[] time, int m) {
        //二分，最小的做题时间0，最大是做所有题目需要的时间
        int left = 0, right = 0;
        for (int i = 0; i < time.length; i++) {
            right += time[i];
        }

        while (left < right) {
            int mid = (right + left) >> 1;
            int count = 1, sum = 0, max = 0;
            // 贪心：每天的那次机会，不用白不用，所以每天肯定都要用一次求助，而且肯定用到开销最多的那道题
            for (int i = 0; i < time.length; i++) {
                max = Math.max(max, time[i]);
                sum += time[i];
                //如果已经减掉区间里的最大值，还是不满足条件的话，就把之前的数字划分开来
                if (sum - max > mid) {
                    max = time[i];
                    sum = time[i];
                    count++;
                }
            }
            if (count > m) { //如果做的太慢了
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;

    }


}
