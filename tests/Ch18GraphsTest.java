import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/** Chapter 18 tests, one class per exercise. */
final class Ch18GraphsTest {
    private Ch18GraphsTest() {}

    /** graph("A:B,C", "B:") -> {A=[B, C], B=[]} in insertion order. */
    static Map<String, List<String>> graph(String... pairs) {
        Map<String, List<String>> g = new LinkedHashMap<>();
        for (String p : pairs) {
            String[] kv = p.split(":", -1);
            g.put(kv[0], kv[1].isEmpty() ? new ArrayList<>() : new ArrayList<>(List.of(kv[1].split(","))));
        }
        return g;
    }

    /** Alice - Bob, Alice - Candy, Bob - Derek, linked by hand so tests don't depend on addAdjacent. */
    static Ch18Graphs.Vertex[] people() {
        Ch18Graphs.Vertex alice = new Ch18Graphs.Vertex("Alice"), bob = new Ch18Graphs.Vertex("Bob"),
                candy = new Ch18Graphs.Vertex("Candy"), derek = new Ch18Graphs.Vertex("Derek");
        alice.adjacent.addAll(List.of(bob, candy));
        bob.adjacent.addAll(List.of(alice, derek));
        candy.adjacent.add(alice);
        derek.adjacent.add(bob);
        return new Ch18Graphs.Vertex[]{alice, bob, candy, derek};
    }
}

class Ex18_1Test {
    public static void run() {
        Map<String, List<String>> g = new LinkedHashMap<>();
        Ch18Graphs.addEdge(g, "Alice", "Bob", false);
        Check.eq(g.toString(), "{Alice=[Bob], Bob=[Alice]}");
        Ch18Graphs.addEdge(g, "Alice", "Bob", false);
        Check.eq(g.get("Alice").size(), 1);
        Ch18Graphs.addEdge(g, "Bob", "Cy", true);
        Check.eq(g.toString(), "{Alice=[Bob], Bob=[Alice, Cy], Cy=[]}");
    }
}

class Ex18_2Test {
    public static void run() {
        Ch18Graphs.Vertex alice = new Ch18Graphs.Vertex("Alice"), bob = new Ch18Graphs.Vertex("Bob");
        alice.addAdjacent(bob);
        Check.yes(alice.adjacent.contains(bob) && bob.adjacent.contains(alice));
        alice.addAdjacent(bob);
        Check.eq(alice.adjacent.size(), 1);
        Check.eq(bob.adjacent.size(), 1);
    }
}

class Ex18_3Test {
    public static void run() {
        Check.eq(Ch18Graphs.dfsTraverse(Ch18GraphsTest.people()[0], new HashSet<>()), List.of("Alice", "Bob", "Derek", "Candy"));
    }
}

class Ex18_4Test {
    public static void run() {
        Ch18Graphs.Vertex[] p = Ch18GraphsTest.people();
        Check.yes(Ch18Graphs.dfsSearch(p[0], "Derek", new HashSet<>()) == p[3]);
        Check.eq(Ch18Graphs.dfsSearch(p[0], "Zed", new HashSet<>()), null);
    }
}

class Ex18_5Test {
    public static void run() {
        Check.eq(Ch18Graphs.bfsTraverse(Ch18GraphsTest.people()[0]), List.of("Alice", "Bob", "Candy", "Derek"));
    }
}

class Ex18_6Test {
    public static void run() {
        Map<String, List<String>> sp = Ch18GraphsTest.graph("A:B,C", "B:A,D", "C:A,D", "D:B,C,E", "E:D");
        Check.eq(Ch18Graphs.shortestPath(sp, "A", "E"), List.of("A", "B", "D", "E"));
        Check.eq(Ch18Graphs.shortestPath(Ch18GraphsTest.graph("A:", "B:"), "A", "B"), null);
    }
}

class Ex18_7Test {
    public static void run() {
        Check.eq(Ch18Graphs.countComponents(Ch18GraphsTest.graph("a:b", "b:a", "c:", "d:e", "e:d")), 3);
    }
}

class Ex18_8Test {
    public static void run() {
        Map<String, Map<String, Integer>> routes = new LinkedHashMap<>();
        routes.put("Atlanta", Map.of("Boston", 100, "Denver", 160));
        routes.put("Boston", Map.of("Chicago", 120, "Denver", 180));
        routes.put("Chicago", Map.of("El Paso", 80));
        routes.put("Denver", Map.of("Chicago", 40, "El Paso", 140));
        Check.eq(Ch18Graphs.dijkstra(routes, "Atlanta", "El Paso").toString(),
                "Trip[cost=280, path=[Atlanta, Denver, Chicago, El Paso]]");
        Check.eq(Ch18Graphs.dijkstra(routes, "El Paso", "Atlanta"), null);
    }
}

class Ex18_9Test {
    public static void run() {
        Check.eq(Ch18Graphs.topologicalOrder(Ch18GraphsTest.graph("wake:shower,coffee", "shower:dress", "coffee:dress", "dress:")),
                List.of("wake", "shower", "coffee", "dress"));
        Check.eq(Ch18Graphs.topologicalOrder(Ch18GraphsTest.graph("a:b", "b:a")), null);
    }
}
