class Solution {
    public int solution(int N) {
        int k = 0;
        while (N % Math.pow(2, k) == 0)
            k++;
        return k - 1;
    }
}
