package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Z 字形变换
 * https://leetcode-cn.com/problems/zigzag-conversion
 * 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
 *
 * 比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
 *
 * L   C   I   R
 * E T O E S I I G
 * E   D   H   N
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。
 *
 * 请你实现这个将字符串进行指定行数变换的函数：
 *
 * string convert(string s, int numRows);
 * 示例 1:
 *
 * 输入: s = "LEETCODEISHIRING", numRows = 3
 * 输出: "LCIRETOESIIGEDHN"
 * 示例 2:
 *
 * 输入: s = "LEETCODEISHIRING", numRows = 4
 * 输出: "LDREOEIIECIHNTSG"
 * 解释:
 *
 * L     D     R
 * E   O E   I I
 * E C   I H   N
 * T     S     G
 *
 */
public class Leetcode006 {
    public static void main(String[] args) {
        System.out.println(convert("LEETCODEISHIRING",3));
    }

    public static String convert(String s, int numRows) {
        if(numRows == 1){
            return s;
        }
        List<StringBuilder> list = new ArrayList<>();
        for(int i = 0; i< numRows ;i++){
            list.add(new StringBuilder());
        }
        // flag是遍历方向，row是行号
        // 用flag记录当前的行号是从后往前还是从前往后
        int flag = 1,row = 0;
        for(int i = 0; i< s.length();i++){
            list.get(row).append(s.charAt(i));
            row += flag;
            // 遍历到第1行或者最后一行，改变方向
            if(row == numRows-1 || row == 0 ){
                flag = -flag;
            }
        }
        final StringBuilder result = new StringBuilder();
        list.forEach(result::append);
        return result.toString();
    }
}
