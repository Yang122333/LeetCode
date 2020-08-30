public class AnWeiYu {
    public static void main(String[] args) {
        System.out.println(rangeBitwiseAnd(16, 31));
    }

    public static int rangeBitwiseAnd(int m, int n) {
        int length =Integer.toBinaryString(n).length();
//        if(m < (1 << length -1)){
//            return 0;
//        }
        int temp = 0;
        for (int i = length -1; i > 0; i--) {
            temp += 1<<i;
            if(m < temp){
                return 1<< i;
            }
        }
        for (int i = m; i <= n; i++) {
            m &= i;
            if(i == n){
                break;
            }
        }
        return m;
    }

    public static void print(int m){
       int length = Integer.toBinaryString(m).length();
        System.out.println(Integer.toBinaryString(m));
        System.out.println(Integer.toBinaryString(1<<length -1));

    }
}
