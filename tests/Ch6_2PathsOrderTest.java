import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/** Chapter 6.2 tests, one class per exercise. */
final class Ch6_2PathsOrderTest {
    private Ch6_2PathsOrderTest() {}

    static Map<String, List<String>> graph(String... pairs) {
        Map<String, List<String>> g = new LinkedHashMap<>();
        for (String p : pairs) {
            String[] kv = p.split(":", -1);
            g.put(kv[0], kv[1].isEmpty() ? new ArrayList<>() : new ArrayList<>(List.of(kv[1].split(","))));
        }
        return g;
    }
}

class Ex6_2_1Test {
    public static void run() {
        Map<String, List<String>> sp = Ch6_2PathsOrderTest.graph("A:B,C", "B:A,D", "C:A,D", "D:B,C,E", "E:D");
        Check.eq(Ch6_2PathsOrder.shortestPath(sp, "A", "E"), List.of("A", "B", "D", "E"));
        Check.eq(Ch6_2PathsOrder.shortestPath(Ch6_2PathsOrderTest.graph("A:", "B:"), "A", "B"), null);
    }
}

class Ex6_2_2Test {
    public static void run() {
        Map<String, Map<String, Integer>> routes = new LinkedHashMap<>();
        routes.put("Ames", Map.of("Bern", 4, "Cork", 2));
        routes.put("Bern", Map.of("Dover", 5));
        routes.put("Cork", Map.of("Bern", 1, "Dover", 8, "Eden", 10));
        routes.put("Dover", Map.of("Eden", 2));
        Check.eq(Ch6_2PathsOrder.dijkstra(routes, "Ames", "Eden").toString(), "Trip[cost=10, path=[Ames, Cork, Bern, Dover, Eden]]");
        Check.eq(Ch6_2PathsOrder.dijkstra(routes, "Ames", "Dover").toString(), "Trip[cost=8, path=[Ames, Cork, Bern, Dover]]");
        Check.eq(Ch6_2PathsOrder.dijkstra(routes, "Eden", "Ames"), null);
    }
}

class Ex6_2_3Test {
    public static void run() {
        Check.eq(Ch6_2PathsOrder.topologicalOrder(Ch6_2PathsOrderTest.graph("wake:shower,coffee", "shower:dress", "coffee:dress", "dress:")),
                List.of("wake", "shower", "coffee", "dress"));
        Check.eq(Ch6_2PathsOrder.topologicalOrder(Ch6_2PathsOrderTest.graph("a:b", "b:a")), null);
    }
}

class Ex6_2_4Test {
    public static void run() {
        int inf = Integer.MAX_VALUE;
        Check.eq(Ch6_2PathsOrder.bellmanFord(4, new int[][] {{0, 1, 4}, {0, 2, 1}, {2, 1, -2}, {1, 3, 1}}, 0), new int[] {0, -1, 1, 0});
        Check.eq(Ch6_2PathsOrder.bellmanFord(3, new int[][] {{0, 1, 5}}, 0), new int[] {0, 5, inf});
        Check.eq(Ch6_2PathsOrder.bellmanFord(1, new int[0][], 0), new int[] {0});
        Check.eq(Ch6_2PathsOrder.bellmanFord(3, new int[][] {{0, 1, 1}, {1, 2, -1}, {2, 1, -1}}, 0), null);
        Check.eq(Ch6_2PathsOrder.bellmanFord(3, new int[][] {{1, 2, -1}, {2, 1, -1}}, 0), new int[] {0, inf, inf});
    }
}

class Ex6_2_5Test {
    public static void run() {
        Check.yes(Ch6_2PathsOrder.hasProfitableLoop(new double[][] {{1, 0.9, 0.8}, {1.2, 1, 0.7}, {1.3, 1.4, 1}}));
        Check.no(Ch6_2PathsOrder.hasProfitableLoop(new double[][] {{1, 0.5}, {1.9, 1}}));
        Check.no(Ch6_2PathsOrder.hasProfitableLoop(new double[][] {{1, 2}, {0.5, 1}}));
        Check.no(Ch6_2PathsOrder.hasProfitableLoop(new double[][] {{1}}));
        Check.yes(Ch6_2PathsOrder.hasProfitableLoop(new double[][] {{1, 2, 0.1}, {0.4, 1, 3}, {0.2, 0.1, 1}}));
    }
}

class Ex6_2_6Test {
    public static void run() {
        String[] grid = {"....#", ".##.#", "....."};
        Check.eq(Ch6_2PathsOrder.gridPathLength(grid, new int[] {0, 0}, new int[] {2, 4}), 6);
        Check.eq(Ch6_2PathsOrder.gridPathLength(grid, new int[] {0, 0}, new int[] {0, 0}), 0);
        Check.eq(Ch6_2PathsOrder.gridPathLength(grid, new int[] {0, 3}, new int[] {2, 4}), 3);
        Check.eq(Ch6_2PathsOrder.gridPathLength(new String[] {".#.", ".#.", "..."}, new int[] {0, 0}, new int[] {0, 2}), 6);
        Check.eq(Ch6_2PathsOrder.gridPathLength(new String[] {".#", "#."}, new int[] {0, 0}, new int[] {1, 1}), -1);
    }
}
