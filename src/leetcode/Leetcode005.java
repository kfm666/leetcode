package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 最长回文子串
 * https://leetcode-cn.com/problems/longest-palindromic-substring/
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 *
 * 示例 1：
 *
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * 示例 2：
 *
 * 输入: "cbbd"
 * 输出: "bb"
 */
public class Leetcode005 {
    public static void main(String[] args) {
        System.out.println("babab--->"+longestPalindrome("babab"));
        System.out.println("baab--->"+longestPalindrome("baab"));
        System.out.println("baad--->"+longestPalindrome("baad"));
    }
    public static String longestPalindrome(String s) {
        if(s == null || s.length() == 0){
            return null;
        }
        int length = 0;
        int startPos = 0;
        int endPos = 0;
        // 遍历字符串
        for(int pos = 0; pos < s.length(); pos++){
            int start = pos - 1;
            int end = pos + 1;
            // 从后往前遍历，看是否相邻字符是否和当前字符相等
            while (start >= 0 && s.charAt(pos) == s.charAt(start)){
                --start;
            }
            // 往两边遍历
            while (start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)){
                --start;
                ++end;
            }
            if (length < (end - start - 1)){
                length = end - start -1;
                startPos = start +1;
                endPos = end -1;
            }
        }
        return s.substring(startPos,endPos+1);
    }

}


