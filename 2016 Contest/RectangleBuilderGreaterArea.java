import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;

class Solution {
    public int solution(int[] A, int X) {
        long ans = 0;
        Map<Integer, Integer> fenceCounts = new HashMap<>(A.length);
        List<Integer> fences = new ArrayList<>(A.length);
        for (int a : A) {
            fenceCounts.put(a, fenceCounts.getOrDefault(a, 0) + 1);
            int q = fenceCounts.get(a);
            if (q == 4 && Math.pow(a, 2) >= X)
                ans++;
            if (q == 2)
                fences.add(a);
        }
        fences.sort(null);
        int lowerIndex = 0;
        int upperIndex = fences.size() - 1;
        while (lowerIndex < fences.size() - 1) {
            while (lowerIndex < upperIndex && (long) fences.get(lowerIndex) * fences.get(upperIndex) >= X)
                upperIndex--;
            ans += fences.size() - upperIndex - 1;
            if (ans >= 1_000_000_000)
                return -1;
            lowerIndex++;
            upperIndex = Math.max(lowerIndex, upperIndex);
        }
        return (int) ans;
    }
}