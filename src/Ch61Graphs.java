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

/** Chapter 61: Graphs: representation and traversal. */
public class Ch61Graphs {

    // ==== EX 61.1 | Adjacency-list graph with a hash map | Core
    // PROMPT: Write `static void addEdge(Map<String, List<String>> graph, String a, String b, boolean directed)` for a graph stored as `vertex -> neighbours`. Add missing vertices automatically and avoid duplicate edges.
    // EXAMPLE: `g = new LinkedHashMap<>(); addEdge(g, "Ames", "Bern", false)` -> `{Ames=[Bern], Bern=[Ames]}`
    // BIGO: O(D) for the duplicate check, where D is the vertex's degree. A `Set` of neighbours would make it O(1).
    static void addEdge(Map<String, List<String>> graph, String a, String b, boolean directed) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 61.2 | Vertex objects with adjacency lists | Core
    // PROMPT: Create `static class Vertex` with a `String value`, an `adjacent` list and `addAdjacent(Vertex v)` that links both ways (friendship is mutual) without recursing forever.
    // EXAMPLE: `ames.addAdjacent(bern)` -> bern is in `ames.adjacent` and ames is in `bern.adjacent`
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

    // ==== EX 61.3 | Depth-first traversal | Core
    // PROMPT: Write `static List<String> dfsTraverse(Vertex vertex, Set<Vertex> visited)` returning vertex values in visit order. Mark each vertex visited before recursing into its neighbours.
    // EXAMPLE: Ames-Bern, Ames-Cork, Bern-Dover -> `[Ames, Bern, Dover, Cork]`
    // BIGO: O(V + E). Without the visited set, a cycle would loop forever.
    static List<String> dfsTraverse(Vertex vertex, Set<Vertex> visited) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 61.4 | Depth-first search | Core
    // PROMPT: Write `static Vertex dfsSearch(Vertex vertex, String target, Set<Vertex> visited)` returning the matching `Vertex` or `null`.
    // EXAMPLE: From Ames, search "Dover" -> the Dover vertex
    // BIGO: O(V + E) worst case.
    static Vertex dfsSearch(Vertex vertex, String target, Set<Vertex> visited) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 61.5 | Breadth-first traversal | Core
    // PROMPT: Write `static List<String> bfsTraverse(Vertex start)` using an `ArrayDeque` as the queue: mark the start visited, then repeatedly dequeue a vertex and enqueue its unvisited neighbours.
    // EXAMPLE: Same graph as 61.3 -> `[Ames, Bern, Cork, Dover]`
    // BIGO: O(V + E).
    // NOTE: BFS spreads out in rings, so it finds close vertices first; DFS dives deep first.
    static List<String> bfsTraverse(Vertex start) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 61.6 | Count connected groups | Practice
    // PROMPT: Write `static int countComponents(Map<String, List<String>> graph)` returning how many separate groups an undirected graph has, using an explicit stack.
    // EXAMPLE: `{a=[b], b=[a], c=[], d=[e], e=[d]}` -> `3`
    // BIGO: O(V + E): each vertex is explored once across all searches.
    static int countComponents(Map<String, List<String>> graph) {
        throw new UnsupportedOperationException();
    }
    // ==== END

}
