import java.util.Arrays;

class Solution {
    public int solution(String E, String L) {
        int[] e = Arrays.stream(E.split(":")).mapToInt(Integer::parseUnsignedInt).toArray();
        int[] l = Arrays.stream(L.split(":")).mapToInt(Integer::parseUnsignedInt).toArray();
        int hours = l[0] - e[0] + (int) Math.ceil((l[1] - e[1]) / 60f) - 1;
        return 5 + 4 * hours;
    }
}
