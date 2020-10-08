package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 22. 括号生成
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 *
 *  
 *
 * 示例：
 *
 * 输入：n = 3
 * 输出：[
 *        "((()))",
 *        "(()())",
 *        "(())()",
 *        "()(())",
 *        "()()()"
 *      ]
 */
public class Leetcode22 {

    public static void main(String[] args) {
        List<String> list = generateParenthesis(3);
        System.out.println(list);
        System.out.println(generateParenthesis(4));
        System.out.println(generateParenthesis(5));
    }

    public static List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        generate(list,"",n,0,0);
        return list;
    }

    public static void generate(List<String> list,String s,int n,int leftUsed,int rightUsed){
        if(s.length()> 0 && leftUsed <rightUsed){
            return;
        }
        if(n == leftUsed && n == rightUsed){
            list.add(s);
            return;
        }
        if(leftUsed < n){
            generate(list,s+"(",n,leftUsed + 1,rightUsed);
        }
        if(rightUsed < n){
            generate(list,s+")",n,leftUsed,rightUsed+1);
        }
    }
}
