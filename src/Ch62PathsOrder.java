import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

/** Chapter 62: Shortest paths and ordering. */
public class Ch62PathsOrder {

    // ==== EX 62.1 | Shortest path, unweighted | Core
    // PROMPT: Write `static List<String> shortestPath(Map<String, List<String>> graph, String start, String end)` using BFS and a `previous` map, returning the list of vertices or `null`.
    // EXAMPLE: `{A=[B, C], B=[A, D], C=[A, D], D=[B, C, E], E=[D]}`, A to E -> `[A, B, D, E]`
    // BIGO: O(V + E). The first time BFS reaches a vertex is along a fewest-edges path.
    static List<String> shortestPath(Map<String, List<String>> graph, String start, String end) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 62.2 | Fastest route by travel time | Core
    // PROMPT: Write `static Trip dijkstra(Map<String, Map<String, Integer>> routes, String start, String end)` returning `record Trip(long cost, List<String> path)`, or `null` if `end` cannot be reached. Use a `PriorityQueue` to always visit the nearest known unvisited town next.
    // EXAMPLE: Ames->Bern 4, Ames->Cork 2, Bern->Dover 5, Cork->Bern 1, Cork->Dover 8, Cork->Eden 10, Dover->Eden 2 -> Ames to Eden is `Trip[cost=10, path=[Ames, Cork, Bern, Dover, Eden]]`
    // BIGO: O((V + E) log V) with a heap. Scanning an array for the cheapest unvisited city instead is O(V^2).
    // NOTE: Dijkstra requires non-negative weights. Java's `PriorityQueue` has no decrease-key, so push a new entry and skip stale ones when they come out.
    record Trip(long cost, List<String> path) {}

    private record Entry(long cost, String city) {}

    static Trip dijkstra(Map<String, Map<String, Integer>> routes, String start, String end) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 62.3 | Topological order of tasks | Stretch
    // PROMPT: Write `static List<String> topologicalOrder(Map<String, List<String>> deps)` for a directed graph `task -> tasks that depend on it` using Kahn's algorithm (repeatedly take tasks with no remaining prerequisites). Return `null` if there is a cycle.
    // EXAMPLE: `{wake=[shower, coffee], shower=[dress], coffee=[dress], dress=[]}` -> `[wake, shower, coffee, dress]`
    // BIGO: O(V + E).
    static List<String> topologicalOrder(Map<String, List<String>> deps) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 62.4 | Shortest paths with negative weights | Practice
    // PROMPT: Vertices are `0` to `n - 1`, and `edges` holds directed `{u, v, w}` with any integer weight. Write `static int[] bellmanFord(int n, int[][] edges, int source)` that returns the shortest distances from `source` (`Integer.MAX_VALUE` when unreachable), or `null` when a negative cycle can be reached. Relax every edge `n - 1` times, then check once more.
    // EXAMPLE: `4, [[0, 1, 4], [0, 2, 1], [2, 1, -2], [1, 3, 1]], 0` -> `[0, -1, 1, 0]`
    // BIGO: O(V * E) time, O(V) space: a shortest path uses at most V - 1 edges, so V - 1 rounds of relaxing every edge settle it, and any improvement after that means a negative cycle.
    // NOTE: This is the Bellman-Ford method. Dijkstra (62.2) is faster but wrong once a weight is negative, because a settled vertex can still get cheaper.
    static int[] bellmanFord(int n, int[][] edges, int source) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 62.5 | A profitable loop of exchanges | Stretch
    // PROMPT: `rates[i][j]` is how many units of currency `j` one unit of `i` buys. Write `static boolean hasProfitableLoop(double[][] rates)`: `true` when some cycle of exchanges ends with more than it started. Give edge `i -> j` the weight `-Math.log(rates[i][j])` and look for a negative cycle: start every distance at `0`, relax all edges `n - 1` times, then check once more (allow `1e-12` for rounding).
    // EXAMPLE: `[[1, 0.9, 0.8], [1.2, 1, 0.7], [1.3, 1.4, 1]]` -> `true` (0 -> 1 -> 0 turns 1 into 1.08)
    // BIGO: O(N^3) time for N currencies, O(N) space: logarithms turn a product above 1 into a sum below 0, so a profitable loop is a negative cycle.
    static boolean hasProfitableLoop(double[][] rates) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 62.6 | A* search on a grid | Stretch
    // PROMPT: `grid` holds strings, `.` open and `#` wall; a step moves to one of the 4 neighbouring open cells. Write `static int gridPathLength(String[] grid, int[] start, int[] goal)` (cells as `{row, col}`) that returns the fewest steps, or `-1`, using A*: a `PriorityQueue` ordered by steps so far plus the Manhattan distance to `goal`, and a table of the best known steps per cell.
    // EXAMPLE: `["....#", ".##.#", "....."], {0, 0}, {2, 4}` -> `6`
    // BIGO: O(R*C log(R*C)) worst case, usually much less: the Manhattan distance never overestimates, so the first time the goal leaves the queue its cost is optimal, and the estimate steers the search toward it.
    static int gridPathLength(String[] grid, int[] start, int[] goal) {
        throw new UnsupportedOperationException();
    }
    // ==== END
}
