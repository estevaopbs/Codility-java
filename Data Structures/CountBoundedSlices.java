import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.Collections;

class Solution {
    public int solution(int K, int[] A) {
        List<Integer> listA = Arrays.stream(A).boxed().collect(Collectors.toCollection(ArrayList::new));
        return Math.min(getBoundedSlices(listA, K), 1_000_000_000);
    }

    public int getBoundedSlices(List<Integer> listA, int K) {
        int ans = 0;
        if (Collections.max(listA) - Collections.min(listA) <= K)
            return (int) ((Math.pow(listA.size(), 2) + listA.size()) / 2);
        if (listA.size() >= 2)
            ans += exploreLeft(listA.subList(1, listA.size()), K)
                    + getBoundedSlices(listA.subList(0, listA.size() - 1), K);
        return ans;
    }

    public int exploreLeft(List<Integer> listA, int K) {
        int ans = 0;
        if (Collections.max(listA) - Collections.min(listA) <= K)
            return listA.size();
        if (listA.size() >= 2)
            ans += exploreLeft(listA.subList(1, listA.size()), K);
        return ans;
    }
}
