package sort;

/**
 * 计数排序
 * 缺陷：
 * 当数列最大值和最小值相差过大的时候，不适用计数排序
 * 当数列元素不是整数的时候，也不适用（此时可以用桶排序）
 */
public class JiShuSort {

    public static void main(String[] args) {
        int a[] = {2, 5, 4, 4, 6, 7, 9, 8,};

        sort1(a);
        System.out.println("排序结果：");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]);
        }

    }


    public static void sort1(int a[]) {
        int max = a[0];
        int min = a[0];
        //找出最大值和最小值
        for (int i = 0; i < a.length; i++) {
            if (a[i] > max) {
                max = a[i];
            }
            if (a[i] < min) {
                min = a[i];
            }
        }
        //创建一个相应的数组,偏移量是最大数和最小值的差值
        int newLength = max - min + 1;
        int temp[] = new int[newLength];
        //计数
        for (int i = 0; i < a.length; i++) {
            temp[a[i] - min] = temp[a[i] - min] + 1;
        }

        //输出计数后，桶的结果
        System.out.print("桶的结果：");
        for (int i = 0; i < temp.length; i++) {
            System.out.print(temp[i]);
        }
        System.out.println();

        //遍历统计数组，将桶的结果弄到原数组中
        int index = 0;
        for (int i = 0; i < temp.length; i++) {
            for (int j = 0; j < temp[i]; j++) {
                a[index++] = i + min;
            }
        }
    }

    /**
     * 优化变成稳定的排序
     */
    public static void sort2(int a[]) {

    }
}
