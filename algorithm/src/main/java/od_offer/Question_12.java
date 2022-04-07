package od_offer;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Author: Amos
 * E-mail: amos@amoscloud.com
 * Date: 2020/11/13
 * Time: 17:15
 * Description:
 */
public class Question_12{
    private static int max = 0;
    private static char[][] chars;

    public static void main(String[] args) {
        /*
        3,4
        f,m,m,f
        f,m,m,f
        f,f,f,m
        3
         */
        Scanner in = new Scanner(System.in);
        String[] split = in.nextLine().split(",");
        int row = Integer.parseInt(split[0]);
        int col = Integer.parseInt(split[1]);
        chars = new char[row][col];
        for (int i = 0; i < row; i++) {
            char[] split1 = in.nextLine().replaceAll(",", "").toCharArray();
            for (int j = 0; j < col; j++) {
                chars[i][j] = split1[j];
            }
        }

        int i1 = find3(0, 1);
        if (i1 > max) max = i1;

        System.out.println(max);

        in.close();
    }

    private static int find1(int row, int col) {
        if (chars[row][col] != 'm') return 0;
        else return 1 + find1(row, col + 1);
    }

    private static int find2(int row, int col) {
        if (chars[row][col] != 'm') return 0;
        else return 1 + find2(row + 1, col);
    }

    private static int find3(int row, int col) {
        if (chars[row][col] != 'm') return 0;
        else return 1 + find3(row + 1, col + 1);
    }
}