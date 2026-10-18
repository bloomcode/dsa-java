/** Chapter 63 tests, one class per exercise. */

class Ex63_1Test {
    public static void run() {
        Ch63UnionFind.DisjointSet ds = new Ch63UnionFind.DisjointSet(5);
        Check.yes(ds.union(0, 1));
        Check.no(ds.union(1, 0));
        Check.eq(ds.size(1), 2);
        Check.eq(ds.groups, 4);
        ds = new Ch63UnionFind.DisjointSet(6);
        Check.yes(ds.union(0, 1) && ds.union(2, 1));
        Check.no(ds.union(0, 2));
        Check.eq(ds.find(2), ds.find(0));
        Check.eq(ds.size(2), 3);
        int root = ds.find(0);
        Check.yes(ds.union(3, 0));
        Check.eq(ds.find(3), root);
        Check.eq(ds.size(3), 4);
        Check.eq(ds.groups, 3);
        Ch63UnionFind.DisjointSet chain = new Ch63UnionFind.DisjointSet(4);
        chain.parent = new int[] {0, 0, 1, 2};
        Check.eq(chain.find(3), 0);
        Check.eq(chain.parent, new int[] {0, 0, 0, 0});
    }
}

class Ex63_2Test {
    public static void run() {
        Check.eq(Ch63UnionFind.groupCount(5, new int[][] {{0, 1}, {1, 2}, {3, 4}}), 2);
        Check.eq(Ch63UnionFind.groupCount(3, new int[0][]), 3);
        Check.eq(Ch63UnionFind.groupCount(4, new int[][] {{0, 1}, {1, 0}, {2, 3}, {3, 1}}), 1);
    }
}

class Ex63_3Test {
    public static void run() {
        Check.yes(Ch63UnionFind.hasCycleUndirected(4, new int[][] {{0, 1}, {1, 2}, {2, 0}, {2, 3}}));
        Check.no(Ch63UnionFind.hasCycleUndirected(4, new int[][] {{0, 1}, {1, 2}, {2, 3}}));
        Check.no(Ch63UnionFind.hasCycleUndirected(3, new int[0][]));
        Check.yes(Ch63UnionFind.hasCycleUndirected(5, new int[][] {{3, 4}, {0, 1}, {1, 3}, {4, 0}}));
    }
}

class Ex63_4Test {
    public static void run() {
        Check.yes(Ch63UnionFind.isTree(4, new int[][] {{0, 1}, {0, 2}, {2, 3}}));
        Check.no(Ch63UnionFind.isTree(4, new int[][] {{0, 1}, {2, 3}}));
        Check.yes(Ch63UnionFind.isTree(1, new int[0][]));
        Check.no(Ch63UnionFind.isTree(4, new int[][] {{0, 1}, {1, 2}, {2, 0}}));
        Check.no(Ch63UnionFind.isTree(3, new int[][] {{0, 1}, {1, 2}, {2, 0}}));
    }
}

class Ex63_5Test {
    public static void run() {
        Check.eq(Ch63UnionFind.kruskalCost(4, new int[][] {{0, 1, 4}, {1, 2, 2}, {0, 2, 5}, {2, 3, 1}, {1, 3, 7}}), 7);
        Check.eq(Ch63UnionFind.kruskalCost(1, new int[0][]), 0);
        Check.eq(Ch63UnionFind.kruskalCost(3, new int[][] {{0, 1, 3}}), -1);
        Check.eq(Ch63UnionFind.kruskalCost(3, new int[][] {{0, 1, -2}, {1, 2, 6}, {0, 2, 6}}), 4);
    }
}

class Ex63_6Test {
    public static void run() {
        Check.eq(Ch63UnionFind.primCost(4, new int[][] {{0, 1, 4}, {1, 2, 2}, {0, 2, 5}, {2, 3, 1}, {1, 3, 7}}), 7);
        Check.eq(Ch63UnionFind.primCost(1, new int[0][]), 0);
        Check.eq(Ch63UnionFind.primCost(3, new int[][] {{0, 1, 3}}), -1);
        Check.eq(Ch63UnionFind.primCost(3, new int[][] {{0, 1, -2}, {1, 2, 6}, {0, 2, 6}}), 4);
        Check.eq(Ch63UnionFind.primCost(5, new int[][] {{0, 1, 9}, {0, 2, 3}, {1, 2, 1}, {1, 3, 8}, {2, 3, 7}, {3, 4, 2}, {2, 4, 6}}), 12);
    }
}

class Ex63_7Test {
    public static void run() {
        Check.eq(Ch63UnionFind.redundantEdge(new int[][] {{0, 1}, {1, 2}, {2, 3}, {1, 3}, {3, 4}}), new int[] {1, 3});
        Check.eq(Ch63UnionFind.redundantEdge(new int[][] {{0, 1}, {1, 2}, {0, 2}}), new int[] {0, 2});
        Check.eq(Ch63UnionFind.redundantEdge(new int[][] {{2, 3}, {0, 1}, {1, 3}, {0, 2}}), new int[] {0, 2});
    }
}

class Ex63_8Test {
    public static void run() {
        Check.eq(Ch63UnionFind.earliestConnected(4, new int[][] {{7, 2, 3}, {2, 0, 1}, {5, 1, 2}, {9, 0, 3}}), 7);
        Check.eq(Ch63UnionFind.earliestConnected(3, new int[][] {{1, 0, 1}}), -1);
        Check.eq(Ch63UnionFind.earliestConnected(2, new int[][] {{4, 1, 0}, {3, 0, 1}}), 3);
        Check.eq(Ch63UnionFind.earliestConnected(3, new int[][] {{5, 0, 1}, {6, 1, 0}, {8, 2, 1}}), 8);
    }
}
