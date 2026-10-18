import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/** Chapter 6.1 tests, one class per exercise. */

final class Ch6_1GraphsTest {
    private Ch6_1GraphsTest() {}

    /** graph("A:B,C", "B:") -> {A=[B, C], B=[]} in insertion order. */
    static Map<String, List<String>> graph(String... pairs) {
        Map<String, List<String>> g = new LinkedHashMap<>();
        for (String p : pairs) {
            String[] kv = p.split(":", -1);
            g.put(kv[0], kv[1].isEmpty() ? new ArrayList<>() : new ArrayList<>(List.of(kv[1].split(","))));
        }
        return g;
    }

    /** Ames - Bern, Ames - Cork, Bern - Dover, linked by hand so tests don't depend on addAdjacent. */
    static Ch6_1Graphs.Vertex[] towns() {
        Ch6_1Graphs.Vertex ames = new Ch6_1Graphs.Vertex("Ames"), bern = new Ch6_1Graphs.Vertex("Bern"),
                cork = new Ch6_1Graphs.Vertex("Cork"), dover = new Ch6_1Graphs.Vertex("Dover");
        ames.adjacent.addAll(List.of(bern, cork));
        bern.adjacent.addAll(List.of(ames, dover));
        cork.adjacent.add(ames);
        dover.adjacent.add(bern);
        return new Ch6_1Graphs.Vertex[]{ames, bern, cork, dover};
    }
}

class Ex6_1_1Test {
    public static void run() {
        Map<String, List<String>> g = new LinkedHashMap<>();
        Ch6_1Graphs.addEdge(g, "Ames", "Bern", false);
        Check.eq(g.toString(), "{Ames=[Bern], Bern=[Ames]}");
        Ch6_1Graphs.addEdge(g, "Ames", "Bern", false);
        Check.eq(g.get("Ames").size(), 1);
        Ch6_1Graphs.addEdge(g, "Bern", "Cork", true);
        Check.eq(g.toString(), "{Ames=[Bern], Bern=[Ames, Cork], Cork=[]}");
    }
}

class Ex6_1_2Test {
    public static void run() {
        Ch6_1Graphs.Vertex ames = new Ch6_1Graphs.Vertex("Ames"), bern = new Ch6_1Graphs.Vertex("Bern");
        ames.addAdjacent(bern);
        Check.yes(ames.adjacent.contains(bern) && bern.adjacent.contains(ames));
        ames.addAdjacent(bern);
        Check.eq(ames.adjacent.size(), 1);
        Check.eq(bern.adjacent.size(), 1);
    }
}

class Ex6_1_3Test {
    public static void run() {
        Check.eq(Ch6_1Graphs.dfsTraverse(Ch6_1GraphsTest.towns()[0], new HashSet<>()), List.of("Ames", "Bern", "Dover", "Cork"));
    }
}

class Ex6_1_4Test {
    public static void run() {
        Ch6_1Graphs.Vertex[] p = Ch6_1GraphsTest.towns();
        Check.yes(Ch6_1Graphs.dfsSearch(p[0], "Dover", new HashSet<>()) == p[3]);
        Check.eq(Ch6_1Graphs.dfsSearch(p[0], "Zed", new HashSet<>()), null);
    }
}

class Ex6_1_5Test {
    public static void run() {
        Check.eq(Ch6_1Graphs.bfsTraverse(Ch6_1GraphsTest.towns()[0]), List.of("Ames", "Bern", "Cork", "Dover"));
    }
}

class Ex6_1_6Test {
    public static void run() {
        Check.eq(Ch6_1Graphs.countComponents(Ch6_1GraphsTest.graph("a:b", "b:a", "c:", "d:e", "e:d")), 3);
    }
}

