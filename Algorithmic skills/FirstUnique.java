import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.List;

class Solution {
    public int solution(int[] A) {
        Map<Integer, Integer> occurrences = new LinkedHashMap<Integer, Integer>();
        for (int n : A)
            occurrences.put(n, occurrences.getOrDefault(n, 0) + 1);
        List<Integer> firstUnique = occurrences.entrySet().stream().filter(o -> o.getValue() == 1).limit(1)
                .map(Map.Entry::getKey).collect(Collectors.toList());
        return (firstUnique.size() == 1) ? firstUnique.get(0) : -1;
    }
}