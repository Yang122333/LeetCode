/**
 *  557 反转字符串
 */
public class ReversalString {
    public static void main(String[] args) {
        System.out.println(reverseWords("Let's take LeetCode contest"));
    }

    public static String reverseWords(String s) {
        String[] strs = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < strs.length; i++) {
            sb.append(reverse(strs[i]));
            if(i == strs.length -1){
                return sb.toString();
            }
            sb.append(" ");
        }
        return sb.toString();
    }

        public static String reverse(String str) {
            char[] chars = new char[str.length()];
            for (int i = 0; i <str.length(); i++) {
                chars[i] = str.charAt(str.length() - 1 - i);
            }
            return String.valueOf(chars);
        }
}
