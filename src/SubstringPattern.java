import java.util.ArrayList;

/**
 * 459. 重复的子字符串
 */
public class SubstringPattern {
    public static void main(String[] args) {
        System.out.println(repeatedSubstringPattern("abacababacab"));
    }

    public static  boolean repeatedSubstringPattern(String s) {
        char[] strs = s.toCharArray();
        ArrayList<Character> simall = new ArrayList<>();
        ArrayList<Character> temp = new ArrayList<>();
        simall.add(strs[0]);
        temp.add(strs[0]);
        int j = 0;
        for (int i = 1; i < strs.length; i++) {
            temp.add(strs[i]);
            if (strs[i] != simall.get(j)) {
                if (temp.size() > strs.length / 2) {
                    return false;
                }
                j = 0;
                simall = new ArrayList<>(temp);
            } else {
                j++;
                if(i == strs.length -1 && j == simall.size()){
                    return true;
                }
                if (j > simall.size() - 1) {
                    j = 0;
                }
            }

        }
        return false;
    }
}
