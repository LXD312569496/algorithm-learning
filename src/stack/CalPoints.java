package stack;

import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 682
 * 你现在是棒球比赛记录员。
 * 给定一个字符串列表，每个字符串可以是以下四种类型之一：
 * 1.整数（一轮的得分）：直接表示您在本轮中获得的积分数。
 * 2. "+"（一轮的得分）：表示本轮获得的得分是前两轮有效 回合得分的总和。
 * 3. "D"（一轮的得分）：表示本轮获得的得分是前一轮有效 回合得分的两倍。
 * 4. "C"（一个操作，这不是一个回合的分数）：表示您获得的最后一个有效 回合的分数是无效的，应该被移除。
 * <p>
 * 每一轮的操作都是永久性的，可能会对前一轮和后一轮产生影响。
 * 你需要返回你在所有回合中得分的总和。
 * <p>
 * 示例 1:
 * <p>
 * 输入: ["5","2","C","D","+"]
 * 输出: 30
 * 解释:
 * 第1轮：你可以得到5分。总和是：5。
 * 第2轮：你可以得到2分。总和是：7。
 * 操作1：第2轮的数据无效。总和是：5。
 * 第3轮：你可以得到10分（第2轮的数据已被删除）。总数是：15。
 * 第4轮：你可以得到5 + 10 = 15分。总数是：30。
 * 示例 2:
 * <p>
 * 输入: ["5","-2","4","C","D","9","+","+"]
 * 输出: 27
 * 解释:
 * 第1轮：你可以得到5分。总和是：5。
 * 第2轮：你可以得到-2分。总数是：3。
 * 第3轮：你可以得到4分。总和是：7。
 * 操作1：第3轮的数据无效。总数是：3。
 * 第4轮：你可以得到-4分（第三轮的数据已被删除）。总和是：-1。
 * 第5轮：你可以得到9分。总数是：8。
 * 第6轮：你可以得到-4 + 9 = 5分。总数是13。
 * 第7轮：你可以得到9 + 5 = 14分。总数是27。
 */
public class CalPoints {
    public static void main(String args[]) {
        String[] strings = {"5", "2", "C", "D", "+"};

        System.out.println(calPoints(strings));

    }


    /**
     * 用栈处理，先判断是不是定义的操作符，再处理数字
     * 把每一轮的得分都push到栈中，有效的才push，无效的要pop掉
     * @param strings
     * @return
     */
    public static int calPoints(String[] strings) {
        int result = 0;
        Stack<Integer> numberStack = new Stack<>();

        for (int i = 0; i < strings.length; i++) {
            if (strings[i].equals("+")) {
                int number1 = numberStack.pop();
                int number2 = numberStack.peek();
                numberStack.push(number1);
                numberStack.push(number1 + number2);
                result = result + number1 + number2;
            } else if (strings[i].equals("D")) {
                int number = numberStack.peek() * 2;
                numberStack.push(number);
                result = result + number;
            } else if (strings[i].equals("C")) {
                int number = numberStack.pop();
                result = result - number;
            }  //遇到数字进栈
            else {
                //执行加法操作
                if (numberStack.isEmpty()) {
                    numberStack.push(Integer.valueOf(strings[i]));
                    result = Integer.valueOf(strings[i]);
                } else {
                    int number = Integer.valueOf(strings[i]);
                    result = result + number;
                    numberStack.push(number);
                }

            }
//            System.out.println(result);
        }

        return result;
    }


}
