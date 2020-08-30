import java.util.ArrayList;
import java.util.List;

public class LongestIncreasingSubsequence {
    public static void main(String[] args) {
        System.out.println(find());
    }

    public List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        int end = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = 1; j < nums.length; j++) {
                if(nums[i] <= nums[j]){
                    List<Integer> ints = new ArrayList<>();
                    ints.add(nums[i]);
                    ints.add(nums[j]);
                    lists.add(ints);
                    end = lists.size();
                }
            }
        }
return  null;
    }

    public int find(List<List<Integer>> lists, int[] nums,int startPosition){
return 0;    }

    public static boolean find(){
        List<List<Integer>> lists = new ArrayList<>();
        ArrayList<Integer> ints = new ArrayList<>();
        ints.add(1);
        ints.add(1);
        lists.add(ints);
        ArrayList<Integer> ints1 = new ArrayList<>();
        ints.add(1);
        ints.add(1);
       return lists.contains(ints1);
    }
}
