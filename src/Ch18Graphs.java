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

/** Chapter 18: Graphs: traversal and cheapest paths. */
public class Ch18Graphs {

    // ==== EX 18.1 | Adjacency-list graph with a hash map | Core
    // PROMPT: Write `static void addEdge(Map<String, List<String>> graph, String a, String b, boolean directed)` for a graph stored as `vertex -> neighbours`. Add missing vertices automatically and avoid duplicate edges.
    // EXAMPLE: `g = new LinkedHashMap<>(); addEdge(g, "Alice", "Bob", false)` -> `{Alice=[Bob], Bob=[Alice]}`
    // BIGO: O(D) for the duplicate check, where D is the vertex's degree. A `Set` of neighbours would make it O(1).
    static void addEdge(Map<String, List<String>> graph, String a, String b, boolean directed) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 18.2 | Object-oriented vertex | Core
    // PROMPT: Create `static class Vertex` with a `String value`, an `adjacent` list and `addAdjacent(Vertex v)` that links both ways (friendship is mutual) without recursing forever.
    // EXAMPLE: `alice.addAdjacent(bob)` -> bob is in `alice.adjacent` and alice is in `bob.adjacent`
    // BIGO: O(D) per link because of the membership check.
    // NOTE: `Vertex` does not override `equals` or `hashCode`, so `contains` and a `HashSet<Vertex>` compare by identity, which is exactly what a graph needs.
    static class Vertex {
        final String value;
        final List<Vertex> adjacent = new ArrayList<>();

        Vertex(String value) { throw new UnsupportedOperationException(); }

        void addAdjacent(Vertex vertex) {
            throw new UnsupportedOperationException();
        }
    }
    // ==== END

    // ==== EX 18.3 | Depth-first traversal | Core
    // PROMPT: Write `static List<String> dfsTraverse(Vertex vertex, Set<Vertex> visited)` returning vertex values in visit order. Mark each vertex visited before recursing into its neighbours.
    // EXAMPLE: Alice-Bob, Alice-Candy, Bob-Derek -> `[Alice, Bob, Derek, Candy]`
    // BIGO: O(V + E). Without the visited set, a cycle would loop forever.
    static List<String> dfsTraverse(Vertex vertex, Set<Vertex> visited) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 18.4 | Depth-first search | Core
    // PROMPT: Write `static Vertex dfsSearch(Vertex vertex, String target, Set<Vertex> visited)` returning the matching `Vertex` or `null`.
    // EXAMPLE: From Alice, search "Derek" -> the Derek vertex
    // BIGO: O(V + E) worst case.
    static Vertex dfsSearch(Vertex vertex, String target, Set<Vertex> visited) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 18.5 | Breadth-first traversal | Core
    // PROMPT: Write `static List<String> bfsTraverse(Vertex start)` using an `ArrayDeque` as the queue: mark the start visited, then repeatedly dequeue a vertex and enqueue its unvisited neighbours.
    // EXAMPLE: Same graph as 18.3 -> `[Alice, Bob, Candy, Derek]`
    // BIGO: O(V + E).
    // NOTE: BFS spreads out in rings, so it finds close vertices first; DFS dives deep first.
    static List<String> bfsTraverse(Vertex start) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 18.6 | Shortest path, unweighted | Core
    // PROMPT: Write `static List<String> shortestPath(Map<String, List<String>> graph, String start, String end)` using BFS and a `previous` map, returning the list of vertices or `null`.
    // EXAMPLE: `{A=[B, C], B=[A, D], C=[A, D], D=[B, C, E], E=[D]}`, A to E -> `[A, B, D, E]`
    // BIGO: O(V + E). The first time BFS reaches a vertex is along a fewest-edges path.
    static List<String> shortestPath(Map<String, List<String>> graph, String start, String end) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 18.7 | Count connected groups | Practice
    // PROMPT: Write `static int countComponents(Map<String, List<String>> graph)` returning how many separate groups an undirected graph has, using an explicit stack.
    // EXAMPLE: `{a=[b], b=[a], c=[], d=[e], e=[d]}` -> `3`
    // BIGO: O(V + E): each vertex is explored once across all searches.
    static int countComponents(Map<String, List<String>> graph) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 18.8 | Dijkstra's algorithm: cheapest flight | Core
    // PROMPT: Write `static Trip dijkstra(Map<String, Map<String, Integer>> routes, String start, String end)` returning `record Trip(long cost, List<String> path)`, or `null` if `end` cannot be reached. Use a `PriorityQueue` to always visit the cheapest known unvisited city next.
    // EXAMPLE: Atlanta->Boston 100, Atlanta->Denver 160, Boston->Chicago 120, Boston->Denver 180, Chicago->El Paso 80, Denver->Chicago 40, Denver->El Paso 140 -> Atlanta to El Paso is `Trip[cost=280, path=[Atlanta, Denver, Chicago, El Paso]]`
    // BIGO: O((V + E) log V) with a heap. Scanning an array for the cheapest unvisited city instead is O(V^2).
    // NOTE: Dijkstra requires non-negative weights. Java's `PriorityQueue` has no decrease-key, so push a new entry and skip stale ones when they come out.
    record Trip(long cost, List<String> path) {}

    private record Entry(long cost, String city) {}

    static Trip dijkstra(Map<String, Map<String, Integer>> routes, String start, String end) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 18.9 | Topological order of tasks | Stretch
    // PROMPT: Write `static List<String> topologicalOrder(Map<String, List<String>> deps)` for a directed graph `task -> tasks that depend on it` using Kahn's algorithm (repeatedly take tasks with no remaining prerequisites). Return `null` if there is a cycle.
    // EXAMPLE: `{wake=[shower, coffee], shower=[dress], coffee=[dress], dress=[]}` -> `[wake, shower, coffee, dress]`
    // BIGO: O(V + E).
    static List<String> topologicalOrder(Map<String, List<String>> deps) {
        throw new UnsupportedOperationException();
    }
    // ==== END
}
