package sword_offer.to75;


public class Solution_65 {

    public int add2(int a, int b) {
        while (b != 0) { // 当进位为 0 时跳出
            int c = (a & b) << 1;  // c = 进位
            a = a ^ b; // a = 非进位和
            b = c; // b = 进位
        }
        return a;
    }

    public int add(int a, int b) {
        if (b == 0) {
            return a;
        }
        // 转换成非进位和 + 进位 , 因为算出来的两个值, 位运算也会有进位
        return add(a ^ b, (a & b) << 1);
    }

}