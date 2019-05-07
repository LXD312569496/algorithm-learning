package array;

import sun.util.resources.cldr.rof.CurrencyNames_rof;

import java.util.HashMap;

/**
 * 给定两个字符串 s1 和 s2，写一个函数来判断 s2 是否包含 s1 的排列。
 * <p>
 * 换句话说，第一个字符串的排列之一是第二个字符串的子串。
 * <p>
 * 示例1:
 * <p>
 * 输入: s1 = "ab" s2 = "eidbaooo"
 * 输出: True
 * 解释: s2 包含 s1 的排列之一 ("ba").
 * <p>
 * <p>
 * 示例2:
 * <p>
 * 输入: s1= "ab" s2 = "eidboaoo"
 * 输出: False
 */
public class checkInclusion {

    public static void main(String[] args) {
        System.out.println(checkInclusion("ab", "eidbaooo"));
        System.out.println(checkInclusion("ab", "eidboaoo"));
    }

    public static boolean checkInclusion(String s1, String s2) {
        //key为字母，value为对应的次数
        HashMap<Character, Integer> map1 = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            Character c = s1.charAt(i);
            if (map1.containsKey(c)) {
                map1.put(c, map1.get(c) + 1);
            } else {
                map1.put(c, 1);
            }
        }

        for (int i = 0; i <= s2.length() - s1.length(); i++) {
            HashMap<Character, Integer> map2 = new HashMap<>();

            String string = s2.substring(i, i + s1.length());

//            System.out.println(string);
            for (int j = 0; j < string.length(); j++) {
                Character c = string.charAt(j);
                if (map2.containsKey(c)) {
                    map2.put(c, map2.get(c) + 1);
                } else {
                    map2.put(c, 1);
                }
            }
//            System.out.println(map2);
            if (map1.equals(map2)) {
                return true;
            }
        }
        return false;
    }
}
