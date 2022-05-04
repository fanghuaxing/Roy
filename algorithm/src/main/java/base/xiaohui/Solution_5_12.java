package base.xiaohui;

/**
 * 在一个无序数组里有99个不重复的正整数， 范围是1～100， 唯独缺
 * 少1个1～100中的整数。 如何找出这个缺失的整数？
 */

public class Solution_5_12 {
    public  int queryNum(int[] args) {
        for (int i = 0; i < args.length; i++) {
            int index = args[i] % 101 - 1;
            args[index] += 101;
        }
        for (int i = 0; i < args.length; i++) {
            if (args[i] < 101) {
                return i+1;
            }
        }
        return -1;
    }
}
