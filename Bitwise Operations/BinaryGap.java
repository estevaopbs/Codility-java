class Solution {
    public int solution(int N) {
        int gap = 0;
        int maxGap = 0;
        int binSize = Integer.SIZE - Integer.numberOfLeadingZeros(N);
        for (int i = binSize - 2; i >= 0; i--) {
            if (((N >> i) & 1) == 0) {
                gap++;
            } else {
                maxGap = Math.max(gap, maxGap);
                gap = 0;
            }
        }
        return maxGap;
    }
}
