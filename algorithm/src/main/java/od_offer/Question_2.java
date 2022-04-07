package od_offer;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * Author: Amos
 * E-mail: amos@amoscloud.com
 * Date: 2020/11/2
 * Time: 14:52
 * Description:
 */
public class Question_2{
    public static void main(String[] args) {
//        给定两个整数数组
        //array1 array2  数组元素按升序排列
        // 假设从arr1 arr2中分别取出一个元素，可构成一对元素
        // 现在需要取出k对元素，并对取出的所有元素求和
        // 计算和的最小值
        // 注意：两对元素对应arr1 arr2的下标是相同的
        //       视为同一对元素

        //输入描述
        //    输入两行数组arr1 arr2
        //    每行首个数字为数组大小size   0<size<=100
        //    arr1，2中的每个元素   0< <1000
        //    接下来一行  正整数k   0<k<=arr1.size * arr2.size
        // 输出描述
        //   满足要求的最小值

        // 例子

        //输入
        //   3 1 1 2
        //   3 1 2 3
        //   2

        //输出
        //   4

        //说明：用例中需要取两个元素，
        // 取第一个数组第0个元素与第二个数组第0个元素组成一个元素
        // [1,1]
        //取第一个数组第1个元素与第二个数组第0个元素组成一个元素
        // [1,1]

        //求和为1+1+1+1=4 ,满足要求最小

        Scanner in = new Scanner(System.in);

        int[] arr1 = getArray(in.nextLine());
        int[] arr2 = getArray(in.nextLine());
        int k = in.nextInt();

        int sum = 0;

        ArrayList<Integer> list = new ArrayList<>();

        for (int i : arr1) {
            for (int j : arr2) {
                list.add(i + j);
            }
        }

        Integer[] res = new Integer[list.size()];
        list.toArray(res);
        Arrays.sort(res);

        for (int i = 0; i < k; i++) {
            sum += res[i];
        }
        System.out.println(sum);

        in.close();

    }

    private static int[] getArray(String line1) {
        String[] split1 = line1.split("\\s+");
        int[] arr1 = new int[Integer.parseInt(split1[0])];

        for (int i = 1; i < split1.length; i++) {
            arr1[i - 1] = Integer.parseInt(split1[i]);
        }

        return arr1;
    }
}