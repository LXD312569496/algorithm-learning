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

    }

    public static int[][] merge(int[][] intervals) {
        List<Bean> list = new ArrayList<>();
        int[][] result = null;

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
            
        }

        return result;
    }

    static class Bean {
        int left;
        int right;

        public Bean(int left, int right) {
            this.left = left;
            this.right = right;
        }

        @Override
        public String toString() {
            return "Bean{" +
                    "left=" + left +
                    ", right=" + right +
                    '}';
        }
    }
}
