package sword_offer;

//请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
public class Solution_05 {
    public String replaceSpace(String s) {
        String replace = s.replace(" ", "%20");
        return replace;
    }
}