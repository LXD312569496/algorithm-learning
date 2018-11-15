import java.util.ArrayList;
import java.util.Collections;

/**
 * 桶排序
 */
public class TongSort {

    public static void main(String[] args) {
        double a[] = {2.2, 5.1, 4.2, 4.8, 6.5, 7.8, 9.5, 8.4,};

        sort(a);
        System.out.println("排序结果：");
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }


    public static void sort(double a[]) {
        double max = a[0];
        double min = a[0];
        //找出最大值和最小值
        for (int i = 0; i < a.length; i++) {
            if (max < a[i]) {
                max = a[i];
            }
            if (min > a[i]) {
                min = a[i];
            }
        }
        //划分区间,区间个数暂时默认跟数组长度一样
        ArrayList<ArrayList<Double>> temp = new ArrayList<>(a.length);
        for (int i = 0; i < a.length; i++) {
            temp.add(new ArrayList<>());
        }
        //每一个区间的大小
        int offset = (int) ((max - min) / (a.length - 1));
        //遍历数据，放入相应的桶中
        for (int i = 0; i < a.length; i++) {
            //所在的区间位置
            int index = (int) ((a[i] - min) / offset);
            temp.get(index).add(a[i]);
        }

        //对桶中的数字分别进行排序
        for (int i = 0; i < temp.size(); i++) {
            Collections.sort(temp.get(i));
        }

        //输出结果到原来的数组中
        int index = 0;
        for (int i = 0; i < temp.size(); i++) {
            for (int j = 0; j < temp.get(i).size(); j++) {
                a[index++] = temp.get(i).get(j);
            }
        }

    }

}
