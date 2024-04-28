import java.util.Deque;
import java.util.ArrayDeque;
import java.util.stream.Collectors;

class Solution {
    public int solution(String S) {
        Deque<Character> charDeque = S.chars().mapToObj(x -> (char) x)
                .collect(Collectors.toCollection(ArrayDeque::new));
        if (charDeque.size() % 2 == 0)
            return -1;
        int i = 0;
        while (charDeque.size() > 1) {
            if (charDeque.removeFirst() == charDeque.removeLast())
                i++;
            else
                return -1;
        }
        return i;
    }
}