package sword_offer;

import java.util.HashMap;
import java.util.Map;

class Solution_10_1 {
    private Map<Integer,Integer> cacheMap = new HashMap<>();
    
    public int fib(int n) {
        Integer cache = cacheMap.get(n);
        if (cache != null) {
            return cache;
        }
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        int cacheNum = (fib(n - 1) + fib(n - 2)) % 1000000007;
        cacheMap.put(n,cacheNum);
        return cacheNum;
    }

    
}