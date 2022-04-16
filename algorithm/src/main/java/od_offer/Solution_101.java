package od_offer;

import java.util.HashMap;
import java.util.Stack;

public class Solution_101 {
    public static void main(String[] args) {
        System.out.println(isRight("[>"));
        System.out.println(isRight("({})"));
        System.out.println(isRight("({[<>]})"));
        System.out.println(isRight("()"));
    }

    private static HashMap<Character, Character> map;

    static {
        map = new HashMap() {
            {
                char part1_r = ')';
                Character part1_l = '(';
                put(part1_l, part1_r);
                char part2_r = '}';
                Character part2_l = '{';
                put(part2_l, part2_r);
                char part3_r = ']';
                Character part3_l = '[';
                put(part3_l, part3_r);
                char part4_r = '>';
                Character part4_l = '<';
                put(part4_l, part4_r);
            }
        };
    }


    private static boolean isRight(String word) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < word.length(); i++) {
            char w = word.charAt(i);
            if (map.containsKey(w)) {
                stack.push(w);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                Character c = stack.pop();
                if (!isMatch(w, c)) {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean isMatch(char now, Character c) {
        return now == map.get(c);
    }
}