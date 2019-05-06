package array;

import java.util.*;

/**
 * 给出一个区间的集合，请合并所有重叠的区间。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [[1,3],[2,6],[8,10],[15,18]]
 * 输出: [[1,6],[8,10],[15,18]]
 * 解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 * 示例 2:
 * <p>
 * 输入: [[1,4],[4,5]]
 * 输出: [[1,5]]
 * 解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。
 */
public class merge {

    public static void main(String[] args) {
        int[][] a = new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        merge(a);
        merge(new int[][]{{1, 4}, {4, 5}});
    }

    public static int[][] merge(int[][] intervals) {
        List<Bean> list = new ArrayList<>();
        int size = intervals.length;

        for (int i = 0; i < intervals.length; i++) {
            System.out.println(Arrays.toString(intervals[i]));
            list.add(new Bean(intervals[i][0], intervals[i][1]));
        }
        //升序排列
        Collections.sort(list, new Comparator<Bean>() {
            @Override
            public int compare(Bean o1, Bean o2) {
                return o1.left - o2.left;
            }
        });

        for (int i = 1; i < list.size(); i++) {
            //可以合并区间
            if (list.get(i - 1).right >= list.get(i).left) {
                list.get(i).left = list.get(i - 1).left;
                if (list.get(i).right < list.get(i - 1).right) {
                    list.get(i).right = list.get(i - 1).right;
                }
                list.get(i - 1).flag = true;
                size--;
            }
        }

        int[][] result = new int[size][];
        int j = 0;

        for (int i = 0; i < list.size(); i++) {
            Bean bean = list.get(i);
            if (!bean.flag) {
                result[j++] = new int[]{bean.left, bean.right};
            }
        }

        System.out.println(list.toString());


        return result;
    }

    static class Bean {
        int left;
        int right;
        boolean flag;//标志位，方便后面移除,true要移除

        public Bean(int left, int right) {
            this.left = left;
            this.right = right;
        }

        @Override
        public String toString() {
            return "Bean{" +
                    "left=" + left +
                    ", right=" + right +
                    ", flag=" + flag +
                    '}';
        }
    }
}
