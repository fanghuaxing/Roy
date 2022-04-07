package od_offer;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * Author: Amos
 * E-mail: amos@amoscloud.com
 * Date: 2020/11/13
 * Time: 15:54
 * Description:
 */
public class Question_10{
    public static void main(String[] args) {
        /*
        给定两个字符串
        从字符串2中找出字符串1中的所有字符
        去重并按照ASCII码值从小到大排列
        输入字符串1长度不超过1024
        字符串2长度不超过100

        字符范围满足ASCII编码要求，按照ASCII由小到大排序

        输入描述：
         bach
         bbaaccddfg
         输出
          abc

          2
          输入
          fach
          bbaaccedfg
          输出
          acf

         */

        Scanner in = new Scanner(System.in);
        TreeSet<String> res = new TreeSet<>();
        String[] split = in.nextLine().split("");
        String str2 = in.nextLine();
        for (String s : split) {
            if (str2.contains(s)) res.add(s);
        }
        for (String re : res) System.out.print(re);
        in.close();
    }
}