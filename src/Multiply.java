public class Multiply {
    public static void main(String[] args) {

        System.out.println(multiply("123", "456"));
    }

    public static int[] toIntArray(String str) {
        char[] temp = str.toCharArray();
        int[] ints = new int[temp.length];
        for (int i = 0; i < temp.length; i++) {
            ints[i] = Integer.parseInt(temp[i] + "");
        }
        return ints;
    }

    public static String multiply(String num1, String num2) {
        int[] number1 = toIntArray(num1);
        int[] number2 = toIntArray(num2);
        int[] nums1 = number1.length >= number2.length ? number1 : number2;
        int[] nums2 = nums1 == number1 ? number2 : number1;
        int[] temp = new int[nums1.length + nums2.length + 1];
        int k;
        for (int i = 0; i < nums2.length; i++) {
            k = i;
            for (int j = nums1.length - 1; j >= 0; j--) {
                temp[k] += nums2[i] * nums1[j];
                k++;
            }
        }
        for (int i = 0; i < temp.length - 2; i++) {
            temp[i + 2] += temp[i] / 100;
            temp[i + 1] += temp[i] / 10 % 10;
            temp[i] = temp[i] % 10;
        }
        temp[temp.length - 1] += temp[temp.length - 2] / 10;
        temp[temp.length - 2] = temp[temp.length - 2] % 10;
        StringBuffer sb = new StringBuffer();
        for (int i = temp.length - 1; i >= 0; i--) {
            if (temp[i] != 0) {
                sb.append(temp[i]);
            }
        }
        return sb.toString();
    }
}
