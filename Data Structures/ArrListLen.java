class Solution {
    public int solution(int[] A) {
        int l = 1;
        for (int k = 0; A[k] != -1; k = A[k])
            l++;
        return l;
    }
}