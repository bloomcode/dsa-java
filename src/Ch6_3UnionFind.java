import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/** Chapter 6.3: Union-find and spanning trees. */
public class Ch6_3UnionFind {
    // ==== EX 6.3.1 | Union-find | Core
    // PROMPT: Build `static class DisjointSet` over elements `0` to `n - 1` with `DisjointSet(int n)`, `int find(int x)` (the root of x's group, pointing every node on the way straight at the root), `boolean union(int a, int b)` (merge two groups, hanging the smaller under the larger; `false` if already together), `int size(int x)` and an `int groups` count.
    // EXAMPLE: `new DisjointSet(5)`: `union(0, 1)` -> `true`; `union(1, 0)` -> `false`; `size(1)` -> `2`; `groups` is `4`
    // BIGO: O(alpha(N)) amortized per operation, effectively constant: union by size keeps the trees shallow, and path compression flattens every path that `find` walks.
    static class DisjointSet {
        int[] parent, sizes;
        int groups;

        DisjointSet(int n) {
            throw new UnsupportedOperationException();
        }

        int find(int x) {
            throw new UnsupportedOperationException();
        }

        boolean union(int a, int b) {
            throw new UnsupportedOperationException();
        }

        int size(int x) { throw new UnsupportedOperationException(); }
    }
    // ==== END

    // ==== EX 6.3.2 | How many groups after the merges? | Core
    // PROMPT: People `0` to `n - 1` start alone; each pair in `pairs` joins two people's groups. Write `static int groupCount(int n, int[][] pairs)` that returns how many groups remain, using your `DisjointSet` (6.3.1).
    // EXAMPLE: `5, [[0, 1], [1, 2], [3, 4]]` -> `2`
    // BIGO: O(N + M alpha(N)) for M pairs: one union per pair, and the set keeps the count.
    static int groupCount(int n, int[][] pairs) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 6.3.3 | Cycle in an undirected graph | Core
    // PROMPT: Write `static boolean hasCycleUndirected(int n, int[][] edges)` for vertices `0` to `n - 1` and undirected `{u, v}` edges (no repeats, no self-loops): `true` when the graph has a cycle. Add edges to a `DisjointSet` one at a time; an edge inside one group closes a cycle.
    // EXAMPLE: `4, [[0, 1], [1, 2], [2, 0], [2, 3]]` -> `true`; `4, [[0, 1], [1, 2], [2, 3]]` -> `false`
    // BIGO: O(N + E alpha(N)): an edge whose ends are already in one group closes a cycle.
    static boolean hasCycleUndirected(int n, int[][] edges) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 6.3.4 | Is the graph a tree? | Core
    // PROMPT: Write `static boolean isTree(int n, int[][] edges)` for `n >= 1` vertices and undirected `{u, v}` edges: `true` when the graph is connected and has no cycle. Check that there are exactly `n - 1` edges and that none of them closes a cycle in a `DisjointSet`.
    // EXAMPLE: `4, [[0, 1], [0, 2], [2, 3]]` -> `true`; `4, [[0, 1], [2, 3]]` -> `false`
    // BIGO: O(N + E alpha(N)): a tree on N vertices has exactly N - 1 edges and no cycle, and those two facts together also force it to be connected.
    static boolean isTree(int n, int[][] edges) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 6.3.5 | Minimum spanning tree, edge by edge | Practice
    // PROMPT: Write `static int kruskalCost(int n, int[][] edges)` for an undirected graph on `0` to `n - 1` with `{u, v, w}` edges: the total weight of a minimum spanning tree, or `-1` when the graph is not connected. Take edges cheapest first, keeping each one that joins two different groups of a `DisjointSet`.
    // EXAMPLE: `4, [[0, 1, 4], [1, 2, 2], [0, 2, 5], [2, 3, 1], [1, 3, 7]]` -> `7`
    // BIGO: O(E log E) for the sort, then O(E alpha(V)): the cheapest edge between two groups is always safe to take (the cut property).
    // NOTE: This is Kruskal's method; 6.3.6 grows the tree from one vertex instead.
    static int kruskalCost(int n, int[][] edges) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 6.3.6 | Minimum spanning tree, grown from one vertex | Practice
    // PROMPT: Write `static int primCost(int n, int[][] edges)` with the same input and answer as 6.3.5, but grow one tree from vertex `0`: keep a `PriorityQueue` of `{weight, vertex}` for edges leaving the tree, and add the cheapest one whose far end is not yet in the tree.
    // EXAMPLE: `4, [[0, 1, 4], [1, 2, 2], [0, 2, 5], [2, 3, 1], [1, 3, 7]]` -> `7`
    // BIGO: O(E log E) time, O(V + E) space: the heap always offers the cheapest edge leaving the tree built so far, and stale entries are skipped.
    // NOTE: This is Prim's method. It needs no union-find, and on dense graphs an array instead of a heap makes it O(V^2).
    static int primCost(int n, int[][] edges) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 6.3.7 | The one extra edge | Practice
    // PROMPT: `edges` connect vertices `0` to `n - 1`, where `n = edges.length`: a tree plus one extra edge, so there is exactly one cycle. Write `static int[] redundantEdge(int[][] edges)` that returns the edge you can remove, in order of the list, to leave a tree: the first one that joins two vertices already in one group.
    // EXAMPLE: `[[0, 1], [1, 2], [2, 3], [1, 3], [3, 4]]` -> `[1, 3]`
    // BIGO: O(N alpha(N)): add edges in order; the first one whose ends are already joined is the extra one.
    static int[] redundantEdge(int[][] edges) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 6.3.8 | When is everyone connected? | Practice
    // PROMPT: `logs` holds `{time, a, b}` entries, in any order, each saying people `a` and `b` became friends at `time`; friendship joins groups. Write `static int earliestConnected(int n, int[][] logs)` for `n >= 2` people that returns the earliest time everyone is in one group, or `-1`. Sort by time and merge until `groups` reaches one.
    // EXAMPLE: `4, [[7, 2, 3], [2, 0, 1], [5, 1, 2], [9, 0, 3]]` -> `7`
    // BIGO: O(M log M) for sorting M log entries, then O(M alpha(N)): the group count falls to one at exactly the answer.
    static int earliestConnected(int n, int[][] logs) {
        throw new UnsupportedOperationException();
    }
    // ==== END
}
