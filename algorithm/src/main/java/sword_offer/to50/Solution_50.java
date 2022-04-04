package sword_offer.to50;


import java.util.HashMap;

public class Solution_50 {
    public char firstUniqChar(String s) {
        HashMap<Character, Integer> hashMap = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int count = hashMap.getOrDefault(c, 0) + 1;
            hashMap.put(c, count);
        }
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int count = hashMap.get(c);
            if (count == 1) {
                return c;
            }
        }
        return ' ';
    }
}