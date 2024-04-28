import java.util.HashMap;
import java.util.Map;

class Solution {
    public int solution(int K, int[] C, int[] D) {
        Map<Integer, Integer> cleanMap = new HashMap<Integer, Integer>();
        for (int s : C)
            cleanMap.put(s, cleanMap.getOrDefault(s, 0) + 1);
        Map<Integer, Integer> dirtyMap = new HashMap<Integer, Integer>();
        for (int s : D)
            dirtyMap.put(s, dirtyMap.getOrDefault(s, 0) + 1);
        int ans = 0;
        for (int key : cleanMap.keySet()) {
            int qty = cleanMap.get(key);
            if (qty > 1) {
                ans += qty / 2;
                cleanMap.put(key, qty % 2);
            }
            if (cleanMap.get(key) == 1 && K >= 1 && dirtyMap.keySet().contains(key)) {
                dirtyMap.put(key, dirtyMap.get(key) - 1);
                if (dirtyMap.get(key) == 0)
                    dirtyMap.remove(key);
                K -= 1;
                ans += 1;
            }
        }
        for (int d : dirtyMap.keySet()) {
            if (K < 2)
                break;
            int qty = dirtyMap.get(d);
            if (qty < 2)
                continue;
            int socksToClean = (K % 2 == 0) ? K : (K - 1);
            int socksAvailable = (qty % 2 == 0) ? qty : (qty - 1);
            int cleaned = Math.min(socksToClean, socksAvailable);
            ans += cleaned / 2;
            K -= cleaned;
        }
        return ans;
    }
}