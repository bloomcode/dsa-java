import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/** Chapter 64 tests, one class per exercise. */

class Ex64_1Test {
    public static void run() {
        Check.eq(Ch64ImplicitGraphs.countIslands(new String[] {"##..#", "#...#", "..#..", "....#"}), 4);
        Check.eq(Ch64ImplicitGraphs.countIslands(new String[0]), 0);
        Check.eq(Ch64ImplicitGraphs.countIslands(new String[] {"..."}), 0);
        Check.eq(Ch64ImplicitGraphs.countIslands(new String[] {"###", "#.#", "###"}), 1);
        Check.eq(Ch64ImplicitGraphs.countIslands(new String[] {"#.#", ".#.", "#.#"}), 5);
    }
}

class Ex64_2Test {
    public static void run() {
        Check.yes(Ch64ImplicitGraphs.twoColourable(4, new int[][] {{0, 1}, {1, 2}, {2, 3}, {3, 0}}));
        Check.no(Ch64ImplicitGraphs.twoColourable(3, new int[][] {{0, 1}, {1, 2}, {2, 0}}));
        Check.yes(Ch64ImplicitGraphs.twoColourable(5, new int[0][]));
        Check.no(Ch64ImplicitGraphs.twoColourable(6, new int[][] {{0, 1}, {3, 4}, {4, 5}, {5, 3}}));
        Check.yes(Ch64ImplicitGraphs.twoColourable(4, new int[][] {{0, 1}, {2, 3}}));
    }
}

class Ex64_3Test {
    public static void run() {
        List<Ch64ImplicitGraphs.GraphNode> ring = new ArrayList<>();
        for (int v = 1; v <= 4; v++) ring.add(new Ch64ImplicitGraphs.GraphNode(v));
        for (int i = 0; i < 4; i++) ring.get(i).neighbours = new ArrayList<>(List.of(ring.get((i + 1) % 4), ring.get((i + 3) % 4)));
        Ch64ImplicitGraphs.GraphNode copy = Ch64ImplicitGraphs.cloneGraph(ring.get(0));
        Set<Ch64ImplicitGraphs.GraphNode> seen = new HashSet<>(List.of(copy));
        Deque<Ch64ImplicitGraphs.GraphNode> stack = new ArrayDeque<>(List.of(copy));
        List<Integer> values = new ArrayList<>();
        while (!stack.isEmpty()) {
            Ch64ImplicitGraphs.GraphNode node = stack.pop();
            Check.no(ring.contains(node));
            values.add(node.value);
            for (Ch64ImplicitGraphs.GraphNode other : node.neighbours) if (seen.add(other)) stack.push(other);
        }
        Collections.sort(values);
        Check.eq(values, List.of(1, 2, 3, 4));
        Check.eq(new int[] {copy.neighbours.get(0).value, copy.neighbours.get(1).value}, new int[] {2, 4});
        Check.yes(copy.neighbours.get(0).neighbours.get(1) == copy);
        Check.yes(Ch64ImplicitGraphs.cloneGraph(null) == null);
        Ch64ImplicitGraphs.GraphNode alone = new Ch64ImplicitGraphs.GraphNode(7);
        alone.neighbours.add(alone);
        Ch64ImplicitGraphs.GraphNode twin = Ch64ImplicitGraphs.cloneGraph(alone);
        Check.yes(twin != alone && twin.neighbours.size() == 1 && twin.neighbours.get(0) == twin);
    }
}

class Ex64_4Test {
    public static void run() {
        Check.eq(Ch64ImplicitGraphs.largestIsland(new String[] {"##..#", "#...#", "..#..", "....#"}), 3);
        Check.eq(Ch64ImplicitGraphs.largestIsland(new String[0]), 0);
        Check.eq(Ch64ImplicitGraphs.largestIsland(new String[] {"..."}), 0);
        Check.eq(Ch64ImplicitGraphs.largestIsland(new String[] {"###", "#.#", "###"}), 8);
        Check.eq(Ch64ImplicitGraphs.largestIsland(new String[] {"#.#", ".#.", "#.#"}), 1);
        Check.eq(Ch64ImplicitGraphs.largestIsland(new String[] {"##.", "...", "###"}), 3);
    }
}

class Ex64_5Test {
    public static void run() {
        Check.eq(Ch64ImplicitGraphs.roundsToSpread(new String[] {"S..#", ".#..", "...S"}), 2);
        Check.eq(Ch64ImplicitGraphs.roundsToSpread(new String[] {"S#."}), -1);
        Check.eq(Ch64ImplicitGraphs.roundsToSpread(new String[] {"S#"}), 0);
        Check.eq(Ch64ImplicitGraphs.roundsToSpread(new String[] {"..."}), -1);
        Check.eq(Ch64ImplicitGraphs.roundsToSpread(new String[] {"S...."}), 4);
        Check.eq(Ch64ImplicitGraphs.roundsToSpread(new String[] {"S..", "#..", "..S"}), 2);
    }
}

class Ex64_6Test {
    public static void run() {
        Check.yes(Ch64ImplicitGraphs.hasCycleDirected(4, new int[][] {{0, 1}, {1, 2}, {2, 0}, {2, 3}}));
        Check.no(Ch64ImplicitGraphs.hasCycleDirected(3, new int[][] {{0, 1}, {0, 2}, {1, 2}}));
        Check.no(Ch64ImplicitGraphs.hasCycleDirected(3, new int[0][]));
        Check.yes(Ch64ImplicitGraphs.hasCycleDirected(2, new int[][] {{1, 1}}));
        Check.yes(Ch64ImplicitGraphs.hasCycleDirected(5, new int[][] {{0, 1}, {3, 4}, {4, 2}, {2, 3}}));
        Check.no(Ch64ImplicitGraphs.hasCycleDirected(4, new int[][] {{0, 1}, {2, 1}, {3, 2}, {3, 0}}));
    }
}

class Ex64_7Test {
    public static void run() {
        String[] words = {"cord", "card", "ward", "warm", "word", "worm"};
        Check.eq(Ch64ImplicitGraphs.ladderLength("cold", "warm", words), 5);
        Check.eq(Ch64ImplicitGraphs.ladderLength("cold", "cord", words), 2);
        Check.eq(Ch64ImplicitGraphs.ladderLength("cold", "warn", words), 0);
        Check.eq(Ch64ImplicitGraphs.ladderLength("ab", "cd", new String[] {"ad", "cd"}), 3);
        Check.eq(Ch64ImplicitGraphs.ladderLength("ab", "cd", new String[] {"xy", "cd"}), 0);
    }
}

class Ex64_8Test {
    public static void run() {
        Check.eq(Ch64ImplicitGraphs.knightDistance(8, new int[] {0, 0}, new int[] {7, 7}), 6);
        Check.eq(Ch64ImplicitGraphs.knightDistance(8, new int[] {0, 0}, new int[] {1, 2}), 1);
        Check.eq(Ch64ImplicitGraphs.knightDistance(8, new int[] {3, 3}, new int[] {3, 3}), 0);
        Check.eq(Ch64ImplicitGraphs.knightDistance(3, new int[] {0, 0}, new int[] {1, 1}), -1);
        Check.eq(Ch64ImplicitGraphs.knightDistance(8, new int[] {0, 0}, new int[] {1, 1}), 4);
        Check.eq(Ch64ImplicitGraphs.knightDistance(1, new int[] {0, 0}, new int[] {0, 0}), 0);
    }
}

class Ex64_9Test {
    public static void run() {
        Check.eq(Ch64ImplicitGraphs.longestRisingPath(new int[][] {{1, 2, 9}, {5, 3, 8}, {4, 6, 7}}), 7);
        Check.eq(Ch64ImplicitGraphs.longestRisingPath(new int[][] {{7}}), 1);
        Check.eq(Ch64ImplicitGraphs.longestRisingPath(new int[][] {{1, 1}, {1, 1}}), 1);
        Check.eq(Ch64ImplicitGraphs.longestRisingPath(new int[][] {{1, 2, 3, 4}}), 4);
        Check.eq(Ch64ImplicitGraphs.longestRisingPath(new int[][] {{5, 4}, {2, 3}}), 4);
    }
}
