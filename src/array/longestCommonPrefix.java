package array;

/**
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * <p>
 * 如果不存在公共前缀，返回空字符串 ""。
 * <p>
 * 示例 1:
 * <p>
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * 示例 2:
 * <p>
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 */
public class longestCommonPrefix {
    public static void main(String[] args) {
        String[] strings = new String[]{"c","acc","ccc"};

        System.out.println(longestCommonPrefix(strings));
    }

    public static String longestCommonPrefix(String[] strs) {
        if (strs.length==0){
            return "";
        }
        if (strs.length==1){
            return strs[0];
        }

        String result=strs[0];

        //从下一个开始遍历
        for (int i = 1; i <strs.length ; i++) {
            //利用startsWith来判断
            while (!strs[i].startsWith(result)){
                result=result.substring(0,result.length()-1);
            }
        }

        return result;
    }
}
