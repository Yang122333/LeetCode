/**
 * 判断输入的符号是否合法
 */

import java.util.HashMap;
import java.util.Stack;

public class Parentheses {
    public static void main(String[] args) {
        System.out.println(isValids("()"));
    }

    public static boolean isValid(String s) {
        char[] array = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < array.length; i++) {
            if (array[i] == '}') {
                if (!stack.isEmpty() && stack.peek() == '{') {
                    stack.pop();
                } else {
                    stack.push(array[i]);
                }
            } else if (array[i] == ')') {
                if (!stack.isEmpty() && stack.peek() == '(') {
                    stack.pop();
                } else {
                    stack.push(array[i]);
                }
            } else if (array[i] == ']') {
                if (!stack.isEmpty() && stack.peek() == '[') {
                    stack.pop();
                } else {
                    stack.push(array[i]);
                }
            } else {
                stack.push(array[i]);
            }
        }
        if (stack.isEmpty()) {
            return true;
        }
        return false;

    }

    public static boolean isValids(String s) {
        if (s.length() % 2 == 1) {
            return false;
        }
        HashMap<Character, Character> dictionary = new HashMap<>();
        dictionary.put(']', '[');
        dictionary.put(')', '(');
        dictionary.put('}', '{');
        Stack<Character> stack = new Stack<>();
        for (char ch : s.toCharArray()) {
            if (dictionary.get(ch) != null) {
                if (stack.isEmpty() || stack.peek() != dictionary.get(ch)) {
                    return false;
                } else {
                    stack.pop();
                }
            } else {
                stack.push(ch);
            }
        }
        return stack.isEmpty();
    }
}
