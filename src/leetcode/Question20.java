package leetcode;

import java.util.Stack;

public class Question20 {

    public static void main(String[] args) {
        String str = "[";
        System.out.println(new Solution().isValid(str));
    }

    static class Solution {
        public boolean isValid(String s) {
            char c1 = '(';
            char c2 = ')';
            char c3 = '[';
            char c4 = ']';
            char c5 = '{';
            char c6 = '}';
            char[] str = s.toCharArray();
            Stack<Character> stack = new Stack<>();
            for(char c : str){
                if(c == c1){
                    stack.push(c1);
                    continue;
                }else if(c == c3){
                    stack.push(c3);
                    continue;
                }else if(c == c5){
                    stack.push(c5);
                    continue;
                }
                if(c == c2){
                    char ch = stack.empty() ? ' ':stack.pop();
                    if(ch == ' ' || c1 != ch){
                        return false;
                    }
                }else if(c == c4){
                    char ch = stack.empty() ? ' ':stack.pop();
                    if(ch == ' ' || c3 != ch){
                        return false;
                    }
                }else if(c == c6){
                    char ch = stack.empty() ? ' ':stack.pop();
                    if(ch == ' ' || c5 != ch){
                        return false;
                    }
                }
            }
            return stack.empty();
        }
    }
}
