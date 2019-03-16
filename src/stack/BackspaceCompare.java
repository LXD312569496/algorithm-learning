package stack;

import java.util.Stack;

/**
 * 844
 * 给定 S 和 T 两个字符串，当它们分别被输入到空白的文本编辑器后，判断二者是否相等，并返回结果。 # 代表退格字符。
 *
 *
 *
 * 示例 1：
 *
 * 输入：S = "ab#c", T = "ad#c"
 * 输出：true
 * 解释：S 和 T 都会变成 “ac”。
 * 示例 2：
 *
 * 输入：S = "ab##", T = "c#d#"
 * 输出：true
 * 解释：S 和 T 都会变成 “”。
 * 示例 3：
 *
 * 输入：S = "a##c", T = "#a#c"
 * 输出：true
 * 解释：S 和 T 都会变成 “c”。
 */
public class BackspaceCompare {

    public static void main(String[] args){

        String s="a#c";
        String t="ad#c";

        System.out.println(backspaceCompare(s,t));
    }

    /**
     * 用栈存储两个字符串，最后进行比较结果就可以了
     * @param S
     * @param T
     * @return
     */
    public static boolean backspaceCompare(String S, String T) {
        Stack<Character> stack1=new Stack<>();
        Stack<Character> stack2=new Stack<>();
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i)=='#'){
                if (!stack1.isEmpty()){
                    stack1.pop();
                }
            }else {
                stack1.push(S.charAt(i));
            }
        }

        for (int i = 0; i < T.length(); i++) {
            if (T.charAt(i)=='#'){
                if (!stack2.isEmpty()){
                    stack2.pop();
                }
            }else {
                stack2.push(T.charAt(i));
            }
        }

        return  stack1.equals(stack2);
    }

}
