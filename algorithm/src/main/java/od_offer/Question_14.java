package od_offer;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Author: Amos
 * E-mail: amos@amoscloud.com
 * Date: 2020/11/18
 * Time: 15:29
 * Description:
 */
public class Question_14{
    public static void main(String[] args) {
        /*
        一辆运送快递的货车
        运送的快递放在大小不等的长方体快递盒中
        为了能够装载更多的快递同时不能让货车超载
        需要计算最多能装多少个快递
        注：快递的体积不受限制
        快递数最多1000个
        货车载重最大50000
        输入描述
         第一行输入每个快递的重量
         用英文逗号隔开
         如 5,10,2,11
         第二行输入货车的载重量
          如 20
        输出描述
         输出最多能装多少个快递
         如 3
         示例一
          输入
          5,10,2,11
          20
          输出
          3
         */

        Scanner in = new Scanner(System.in);
        String[] split = in.nextLine().split(",");
        int num = Integer.parseInt(in.nextLine());
        int[] ints = new int[split.length];
        for (int i = 0; i < split.length; i++) {
            ints[i] = Integer.parseInt(split[i]);
        }
        Arrays.sort(ints);
        int sum = 0;
        for (int i = 0; i < ints.length; i++) {
            sum += ints[i];
            if (sum > num) {
                System.out.println(i);
                break;
            }
        }

        in.close();
    }
}