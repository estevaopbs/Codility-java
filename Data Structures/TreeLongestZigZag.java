class Solution {
    int[] left = {0, 1};
    int[] right = {1, 0};
    int[] none = {0, 0};

    public int solution(Tree T) {
        return Math.max(explore(T, 0, this.none) - 1, 0);
    }

    public int explore(Tree T, int switches, int[] lastDirection) {
        if (T == null) {
            return switches;
        }
        int exploreLeft = explore(T.l, switches + lastDirection[0], this.left);
        int exploreRight = explore(T.r, switches + lastDirection[1], this.right);
        return Math.max(exploreLeft, exploreRight);
    }
}
