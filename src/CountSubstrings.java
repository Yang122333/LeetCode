/**
 * 647. 回文子串
 */
public class CountSubstrings {

    public static void main(String[] args) {
        CountSubstrings css = new CountSubstrings();
        System.out.println(css.countSubstrings("1232112321"));
    }

    public int countSubstrings(String s) {
        int count = 0;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < s.length() - i + 1; j++) {
                String temp = s.substring(j, j + i);
                if (isHuiwen(temp)) {
                    count++;
                }
            }
        }
        return count;
    }

    public int countSub(String chars, int number) {
        int count = 0;
        if (number < 0 || number > chars.length()) {
            return 0;
        }
        return count;
    }

    public boolean isHuiwen(String chars) {
        for (int i = 0; i < chars.length(); i++) {
            int end = chars.length() - 1 - i;
            if (i < end) {
                if (chars.charAt(i) != chars.charAt(end)) {
                    return false;
                }
            } else {
                return true;
            }
        }
        return true;
    }


    public int countSubstrings1(String s) {
          return 0;
    }
}
