package sword_offer.to75;


public class Solution_58_2 {
    public String reverseLeftWords(String s, int n) {
        String sub = s.substring(0, n);
        String after = s.substring(n);
        return after + sub;
    }

}