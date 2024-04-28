class Solution {
    public int solution(int[] A) {
        int highestPeak = 0;
        int lowestValley = 0;
        int maxDepth = 0;
        for (int h : A) {
            if (h > highestPeak) {
                maxDepth = Math.max(highestPeak - lowestValley, maxDepth);
                highestPeak = h;
                lowestValley = h;
            } else if (h < lowestValley) {
                lowestValley = h;
            } else {
                maxDepth = Math.max(h - lowestValley, maxDepth);
            }
        }
        return maxDepth;
    }
}
