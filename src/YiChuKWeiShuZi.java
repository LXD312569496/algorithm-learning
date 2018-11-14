import java.util.Stack;

/*
移除K位数字：
给定一个以字符串表示的非负整数 num，移除这个数中的 k 位数字，使得剩下的数字最小
 */
public class YiChuKWeiShuZi {

    public static void main(String args[]) {
        System.out.println(removeKdigits("1432219", 3));
        System.out.println(removeKdigits("10200", 1));
        System.out.println(removeKdigits("10", 1));
        System.out.println(removeKdigits("100", 1));
        System.out.println(removeKdigits("112", 1));
        System.out.println(removeKdigits("111", 1));
        System.out.println(removeKdigits("12345", 0));
        System.out.println(removeKdigits("1234567890", 9));
    }


    public static String removeKdigits(String num, int k) {
        //特殊情况
        if (num.length() <= k) {
            return "0";
        }
        int newLength = num.length() - k;

        //利用一个栈来存储临时的值
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < num.length() && k >= 0; i++) {
            //当前遍历到的位置
            char current = num.charAt(i);
            while (!stack.isEmpty() && stack.peek() > current && k > 0) {
                //把当前的字母删了
                k--;
                stack.pop();
            }
            stack.push(current);
        }
        System.out.println("栈的结果：" + stack + ",剩余" + k + "个还没删");

        //把栈中的对象取出来
        StringBuilder result = new StringBuilder();

        //左边连续0的个数,00100，在出栈的时候顺便进行统计
        int zeroCount = 0;
        while (!stack.isEmpty()) {
//            if (k>0){
//                k--;
//                stack.pop();
//                continue;
//            }
            if (stack.peek() == '0') {
                zeroCount++;
            } else {
                zeroCount = 0;
            }
            result.insert(0, stack.pop());
        }

//        //结果全都是00000的情况
        if (zeroCount == newLength) {
            return "0";
        } else {
            return result.substring(zeroCount, result.length() - k);
        }
    }
}
