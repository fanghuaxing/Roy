package od_offer;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Author: Amos
 * E-mail: amos@amoscloud.com
 * Date: 2020/11/7
 * Time: 14:40
 * Description:
 */
public class Question_7{
    public static void main(String[] args) {
        /*
         小明今年升学到了小学1年纪
         来到新班级后，发现其他小朋友身高参差不齐
         然后就想基于各小朋友和自己的身高差，对他们进行排序
         请帮他实现排序
         输入描述
          第一行为正整数 h和n
          0<h<200 为小明的身高
          0<n<50 为新班级其他小朋友个数
          第二行为n各正整数
           h1 ~ hn分别是其他小朋友的身高
         取值范围0<hi<200
         且n个正整数各不相同

         输出描述
          输出排序结果，各正整数以空格分割
          和小明身高差绝对值最小的小朋友排在前面
          和小明身高差绝对值最大的小朋友排在后面
          如果两个小朋友和小明身高差一样
          则个子较小的小朋友排在前面

          示例一
          输入
          100 10
          95 96 97 98 99 101 102 103 104 105
          输出
           99 101 98 102 97 103 96 104 95 105

          说明  小明身高100
          班级学生10个  身高分别为
         */

        Scanner in = new Scanner(System.in);
        String[] split1 = in.nextLine().split(" ");
        int h = Integer.parseInt(split1[0]);
        String[] split2 = in.nextLine().split(" ");
        ArrayList<Integer> list = new ArrayList<>();
        for (String s : split2) {
            list.add(Integer.parseInt(s));
        }

        list.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer h1, Integer h2) {
                int d1 = h - h1;
                int d2 = h - h2;
               if ((d1 >0?d1:-d1)==(d2 >0?d2:-d2)){
                   return h1-h2;
               }else return (d1 >0?d1:-d1)-(d2 >0?d2:-d2);
            }
        });

        StringBuilder builder = new StringBuilder();
        for (Integer integer : list) {
            builder.append(integer).append(" ");
        }
        System.out.println(builder.toString().trim());

        in.close();
    }

}