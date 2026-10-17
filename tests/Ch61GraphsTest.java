import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/** Chapter 61 tests, one class per exercise. */

final class Ch61GraphsTest {
    private Ch61GraphsTest() {}

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
    static Ch61Graphs.Vertex[] towns() {
        Ch61Graphs.Vertex ames = new Ch61Graphs.Vertex("Ames"), bern = new Ch61Graphs.Vertex("Bern"),
                cork = new Ch61Graphs.Vertex("Cork"), dover = new Ch61Graphs.Vertex("Dover");
        ames.adjacent.addAll(List.of(bern, cork));
        bern.adjacent.addAll(List.of(ames, dover));
        cork.adjacent.add(ames);
        dover.adjacent.add(bern);
        return new Ch61Graphs.Vertex[]{ames, bern, cork, dover};
    }
}

class Ex61_1Test {
    public static void run() {
        Map<String, List<String>> g = new LinkedHashMap<>();
        Ch61Graphs.addEdge(g, "Ames", "Bern", false);
        Check.eq(g.toString(), "{Ames=[Bern], Bern=[Ames]}");
        Ch61Graphs.addEdge(g, "Ames", "Bern", false);
        Check.eq(g.get("Ames").size(), 1);
        Ch61Graphs.addEdge(g, "Bern", "Cork", true);
        Check.eq(g.toString(), "{Ames=[Bern], Bern=[Ames, Cork], Cork=[]}");
    }
}

class Ex61_2Test {
    public static void run() {
        Ch61Graphs.Vertex ames = new Ch61Graphs.Vertex("Ames"), bern = new Ch61Graphs.Vertex("Bern");
        ames.addAdjacent(bern);
        Check.yes(ames.adjacent.contains(bern) && bern.adjacent.contains(ames));
        ames.addAdjacent(bern);
        Check.eq(ames.adjacent.size(), 1);
        Check.eq(bern.adjacent.size(), 1);
    }
}

class Ex61_3Test {
    public static void run() {
        Check.eq(Ch61Graphs.dfsTraverse(Ch61GraphsTest.towns()[0], new HashSet<>()), List.of("Ames", "Bern", "Dover", "Cork"));
    }
}

class Ex61_4Test {
    public static void run() {
        Ch61Graphs.Vertex[] p = Ch61GraphsTest.towns();
        Check.yes(Ch61Graphs.dfsSearch(p[0], "Dover", new HashSet<>()) == p[3]);
        Check.eq(Ch61Graphs.dfsSearch(p[0], "Zed", new HashSet<>()), null);
    }
}

class Ex61_5Test {
    public static void run() {
        Check.eq(Ch61Graphs.bfsTraverse(Ch61GraphsTest.towns()[0]), List.of("Ames", "Bern", "Cork", "Dover"));
    }
}

class Ex61_6Test {
    public static void run() {
        Check.eq(Ch61Graphs.countComponents(Ch61GraphsTest.graph("a:b", "b:a", "c:", "d:e", "e:d")), 3);
    }
}

