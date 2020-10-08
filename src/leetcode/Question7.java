package leetcode;

public class Question7 {
    public static void main(String[] args) {
//        System.out.println(new leetcode.Question7().new Solution().reverse(1));
        System.out.println(new Question7().new Solution().reverse(123));
//        System.out.println(new leetcode.Question7().new Solution().reverse(Integer.MAX_VALUE));
//        System.out.println(new leetcode.Question7().new Solution().reverse(Integer.MIN_VALUE));
    }

    class Solution {
        public int reverse(int x) {
            long result = 0;
            while (x != 0){
                result = result*10 + x%10;
                x /= 10;
            }
            return (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) ? 0:(int) result;
        }
    }
}
