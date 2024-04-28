import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public int solution(Tree T) {
        Deque<Tree> nodes = new ArrayDeque<>();
        nodes.add(T);
        int depth = -1;
        while (nodes.size() > 0) {
            Deque<Tree> newLayer = new ArrayDeque<>();
            while (nodes.size() > 0) {
                Tree node = nodes.remove();
                if (node.l != null)
                    newLayer.add(node.l);
                if (node.r != null)
                    newLayer.add(node.r);
            }
            nodes = newLayer;
            depth++;
        }
        return depth;
    }
}