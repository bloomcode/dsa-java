import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
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
}
