import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/** Chapter 81 tests, one class per exercise. */

class Ex81_1Test {
    public static void run() {
        Ch81Caching.LRUCache<String, Integer> lru = new Ch81Caching.LRUCache<>(2);
        lru.put("a", 1);
        lru.put("b", 2);
        Check.eq(lru.get("a"), 1);
        lru.put("c", 3);
        Check.eq(lru.get("b"), null);
        Check.eq(lru.get("a"), 1);
        Check.eq(lru.get("c"), 3);
        lru.put("a", 10);
        Check.eq(lru.get("a"), 10);
    }
}

class Ex81_2Test {
    public static void run() {
        Ch81Caching.LinkedLRU<String, Integer> ll = new Ch81Caching.LinkedLRU<>(2);
        ll.put("a", 1);
        ll.put("b", 2);
        Check.eq(ll.get("a"), 1);
        ll.put("c", 3);
        Check.eq(ll.get("b"), null);
        ll.put("a", 10);
        Check.eq(ll.get("a"), 10);
        Random rq = new Random(21);
        Ch81Caching.LRUCache<Integer, Integer> ref = new Ch81Caching.LRUCache<>(5);
        Ch81Caching.LinkedLRU<Integer, Integer> mine = new Ch81Caching.LinkedLRU<>(5);
        for (int i = 0; i < 5000; i++) {
            int k = rq.nextInt(12);
            if (rq.nextBoolean()) {
                ref.put(k, i);
                mine.put(k, i);
            } else Check.eq(mine.get(k), ref.get(k));
        }
    }
}

class Ex81_3Test {
    public static void run() {
        Check.near(Ch81Caching.hitRate(new Ch81Caching.LRUCache<>(2), List.of("a", "b", "a", "a", "c", "b")), 2.0 / 6, 1e-12);
    }
}

class Ex81_4Test {
    public static void run() {
        Ch81Caching.FIFOCache<String, Integer> f = new Ch81Caching.FIFOCache<>(2);
        f.put("a", 1);
        f.put("b", 2);
        f.get("a");
        f.put("c", 3);
        Check.eq(f.get("a"), null);
        Check.eq(f.get("b"), 2);
        List<Integer> hot = new ArrayList<>();
        Random rh = new Random(3);
        for (int i = 0; i < 5000; i++) hot.add(rh.nextInt(10) < 8 ? rh.nextInt(3) : 100 + rh.nextInt(1000));
        Check.yes(Ch81Caching.hitRate(new Ch81Caching.LRUCache<>(4), hot) > Ch81Caching.hitRate(new Ch81Caching.FIFOCache<>(4), hot));
    }
}

class Ex81_5Test {
    public static void run() {
        Ch81Caching.RandomCache<Integer, Boolean> rc = new Ch81Caching.RandomCache<>(3, new Random(1));
        for (int i = 0; i < 50; i++) {
            rc.put(i, true);
            Check.yes(rc.size() <= 3);
            Check.eq(rc.get(i), true);
        }
    }
}

class Ex81_6Test {
    public static void run() {
        List<Integer> cyc = Ch81Caching.cyclicRequests(10, 100);
        Check.eq(cyc.size(), 1100);
        Check.eq(Ch81Caching.hitRate(new Ch81Caching.LRUCache<>(10), cyc), 0.0);
        Check.yes(Ch81Caching.hitRate(new Ch81Caching.RandomCache<>(10, new Random(1)), cyc) > 0.5);
    }
}

class Ex81_7Test {
    public static void run() {
        int[] calls = new int[1];
        Ch81Caching.Memo<Integer, Integer> sq = new Ch81Caching.Memo<>(x -> {
            calls[0]++;
            return x * x;
        }, 8);
        Check.eq(sq.apply(1), 1);
        Check.eq(sq.apply(2), 4);
        Check.eq(sq.apply(1), 1);
        Check.eq(sq.hits, 1);
        Check.eq(sq.misses, 2);
        Check.eq(calls[0], 2);
        Ch81Caching.Memo<Integer, String> nul = new Ch81Caching.Memo<>(x -> null, 2);
        nul.apply(5);
        nul.apply(5);
        Check.eq(nul.hits, 1);
    }
}

class Ex81_8Test {
    public static void run() {
        int[][] g = {{1, 2}, {3, 4}};
        Check.eq(Ch81Caching.sumRowsFirst(g), 10L);
        Check.eq(Ch81Caching.sumColumnsFirst(g), 10L);
        Check.eq(Ch81Caching.blockedTranspose(new int[][]{{1, 2, 3}, {4, 5, 6}}, 2), new int[][]{{1, 4}, {2, 5}, {3, 6}});
        int[][] m = new int[5][7];
        int[][] want = new int[7][5];
        for (int r = 0; r < 5; r++) for (int c = 0; c < 7; c++) want[c][r] = m[r][c] = r * 7 + c;
        Check.eq(Ch81Caching.blockedTranspose(m, 3), want);
    }
}
