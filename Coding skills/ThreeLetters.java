import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.stream.Collectors;

class Solution {
    public String solution(int A, int B) {
        if (A == B)
            return "ab".repeat(A);
        if (A + B == 1) {
            return (A == 1) ? "a" : "b";
        }
        List<String> arr = new ArrayList<>();
        Map<String, Integer> loads = new HashMap<>();
        loads.put("a", A);
        loads.put("b", B);
        String l = loads.entrySet().stream().min((x, y) -> Integer.compare(x.getValue(), y.getValue()))
                .map(x -> x.getKey()).orElseThrow();
        String g = (l == "a") ? "b" : "a";
        for (int i = 0; i < loads.get(g) / 2 - 1; i++) {
            arr.add(g + g + l);
        }
        if (arr.size() < loads.get(l))
            arr.add(g + g + l);
        else
            arr.add(g + g);
        if (loads.get(g) % 2 != 0)
            arr.add(g);
        for (int i = 0; i < loads.get(l) - loads.get(g) / 2; i++)
            arr.add(i * 2, l);
        return arr.stream().collect(Collectors.joining());
    }
}
