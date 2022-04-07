package od_offer;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Author: Amos
 * E-mail: amos@amoscloud.com
 * Date: 2020/11/11
 * Time: 11:09
 * Description:
 */
public class Question_8{
    public static void main(String[] args) {
        /*
        输入一个英文文章片段
        翻转指定区域的单词顺序
        标点符号和普通字母一样处理
        例如输入字符串 I am a developer.
        [0,3]
        则输出 developer. a am I

        输入描述
         使用换行隔开3个参数
         第一个参数为文章内容 即英文字符串
         第二个参数为翻转起始单词下标，下标从0开始
         第三个参数为结束单词下标

         输出描述

         翻转后英文文章片段每个单词之间以一个半角空格分割输出

         例子

          输入
           I am a developer.
           0
           3
          输出
           I a am developer.

          输入
            hello world!
          0
          3
          输出
          world! hello

输入字符串可以在前面或者后面包含多个空格
但是翻转后的字符不能包括

指定反转区间只有一个单词
或无有效单词
则输出EMPTY

         */

        Scanner in = new Scanner(System.in);
        String[] words = in.nextLine().trim().split("\\s+");
        int start = Integer.parseInt(in.nextLine());
        int end = Integer.parseInt(in.nextLine());

        int i = 0;
        int j = end;

        StringBuilder builder = new StringBuilder();

        String res = "EMPTY";
        if (end - start > 0
                && start >= 0 && start < words.length
                && end >= 0 && end < words.length) {
            while (i < words.length) {
                if (i < start || i > end) {
                    builder.append(words[i++]).append(" ");
                } else if (i >= start && i <= end) {
                    builder.append(words[j--]).append(" ");
                    i++;
                } else if (j == start) i = end + 1;
            }
            res = builder.toString();
        }

        System.out.println(res.trim());

        in.close();
    }
}