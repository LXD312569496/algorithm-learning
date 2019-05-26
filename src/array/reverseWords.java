package array;

import java.util.Arrays;
import java.util.List;

/**
 * 给定一个字符串，逐个翻转字符串中的每个单词。
 * <p>
 * 示例 1：
 * <p>
 * 输入: "the sky is blue"
 * 输出: "blue is sky the"
 * 示例 2：
 * <p>
 * 输入: "  hello world!  "
 * 输出: "world! hello"
 * 解释: 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 * 示例 3：
 * <p>
 * 输入: "a good   example"
 * 输出: "example good a"
 * 解释: 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 */
public class reverseWords {


    public static void main(String[] args) {
        System.out.println(reverseWords(" "));
        System.out.println(reverseWords("  hello world!  "));
        System.out.println(reverseWords("a good   example"));
    }


    public static String reverseWords(String s) {
        if (s.isEmpty()||s.trim().isEmpty()) {
            return "";
        }
        StringBuilder builder = new StringBuilder();
        s.replaceAll("  ", " ");
        String[] strings = s.trim().split(" ");


//        System.out.println(Arrays.toString(strings));

        for (int i = strings.length - 1; i >= 0; i--) {
            if (strings[i].isEmpty()){
                continue;
            }
            if (i>0){
                builder.append(strings[i]);
                builder.append(" ");
            }else {
                builder.append(strings[i]);
            }
        }

        return builder.toString();
    }
}
