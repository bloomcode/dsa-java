import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

/** Chapter 83 tests, one class per exercise. */

final class Ch83CompactSetsTest {
    private Ch83CompactSetsTest() {}

    static Ch83CompactSets.BitVector vector(int size, int... members) {
        Ch83CompactSets.BitVector bv = new Ch83CompactSets.BitVector(size);
        for (int x : members) bv.add(x);
        return bv;
    }


    /** 5000 distinct items, then 100 repeats of earlier ones. */
    static List<String> stream() {
        List<String> s = new ArrayList<>();
        for (int i = 0; i < 5000; i++) s.add("item-" + i);
        for (int i = 0; i < 100; i++) s.add("item-" + (i * 37));
        return s;
    }
}

class Ex83_1Test {
    public static void run() {
        Ch83CompactSets.BoolArraySet bs = new Ch83CompactSets.BoolArraySet(10);
        bs.add(3);
        bs.add(7);
        bs.add(7);
        bs.remove(3);
        Check.yes(bs.contains(7));
        Check.no(bs.contains(3));
        Check.eq(bs.size(), 1);
    }
}

class Ex83_2Test {
    public static void run() {
        Ch83CompactSets.BitVector bv = new Ch83CompactSets.BitVector(100);
        bv.add(42);
        Check.yes(bv.contains(42));
        Check.no(bv.contains(43));
        Check.eq(bv.words[0], 4398046511104L);
        bv.add(63);
        bv.add(64);
        Check.yes(bv.contains(63) && bv.contains(64));
        bv.remove(42);
        Check.no(bv.contains(42));
        bv.remove(42);
        Check.no(bv.contains(42));
    }
}

class Ex83_3Test {
    public static void run() {
        Ch83CompactSets.BitVector bv = Ch83CompactSetsTest.vector(100, 1, 5, 99);
        Check.eq(bv.count(), 3);
        bv.add(5);
        Check.eq(bv.count(), 3);
        Check.eq(new Ch83CompactSets.BitVector(10).count(), 0);
    }
}

class Ex83_4Test {
    public static void run() {
        Ch83CompactSets.BitVector a = Ch83CompactSetsTest.vector(10, 1, 2, 3), b = Ch83CompactSetsTest.vector(10, 2, 3, 4);
        Ch83CompactSets.BitVector u = a.union(b), i = a.intersection(b), d = a.difference(b);
        for (int x = 0; x < 10; x++) {
            Check.eq(u.contains(x), x >= 1 && x <= 4);
            Check.eq(i.contains(x), x == 2 || x == 3);
            Check.eq(d.contains(x), x == 1);
        }
    }
}

class Ex83_5Test {
    public static void run() {
        Check.eq(Ch83CompactSetsTest.vector(200, 9, 2, 63, 150).members(), List.of(2, 9, 63, 150));
        Random rng = new Random(3);
        TreeSet<Integer> members = new TreeSet<>();
        while (members.size() < 700) members.add(rng.nextInt(5000));
        Ch83CompactSets.BitVector big = Ch83CompactSetsTest.vector(5000, members.stream().mapToInt(Integer::intValue).toArray());
        Check.eq(big.members(), List.copyOf(members));
    }
}

class Ex83_6Test {
    public static void run() {
        var rep = Ch83CompactSets.spaceReport(1_000_000);
        Check.eq(rep.get("booleanArray"), 1000016L);
        Check.eq(rep.get("bitVector"), 125016L);
        Check.yes(rep.get("hashSet") > 50_000_000L && rep.get("hashSet") < 60_000_000L);
    }
}

class Ex83_7Test {
    public static void run() {
        Check.eq(Ch83CompactSets.firstDuplicate(new int[]{4, 9, 1, 9, 4}, 10), 9);
        Check.eq(Ch83CompactSets.firstDuplicate(new int[]{1, 2, 3}, 10), null);
    }
}

class Ex83_8Test {
    public static void run() {
        Check.eq(Ch83CompactSets.unionList(new int[]{1, 5}, new int[]{5, 7}), List.of(1, 5, 7));
        Check.eq(Ch83CompactSets.commonCount(new int[]{1, 5}, new int[]{5, 7}), 1);
    }
}

class Ex83_9Test {
    public static void run() {
        Check.eq(Ch83CompactSets.missing(new int[]{0, 3, 1, 6}, 7), List.of(2, 4, 5));
        Check.eq(Ch83CompactSets.missing(new int[]{0, 1, 2, 3, 4}, 5), List.of());
    }
}

class Ex83_10Test {
    public static void run() {
        int[] pos = Ch83CompactSets.bitPositions("cat", 3, 32);
        Check.eq(pos, Ch83CompactSets.bitPositions("cat", 3, 32));
        Check.eq(pos.length, 3);
        for (int p : pos) Check.yes(p >= 0 && p < 32);
        for (int i = 0; i < 1000; i++) for (int p : Ch83CompactSets.bitPositions("w" + i, 7, 1_000_003)) Check.yes(p >= 0 && p < 1_000_003);
    }
}

class Ex83_11Test {
    public static void run() {
        Ch83CompactSets.BloomFilter bf = new Ch83CompactSets.BloomFilter(1000, 5);
        bf.add("apple");
        bf.add("pear");
        Check.yes(bf.mightContain("apple"));
        Check.yes(bf.mightContain("pear"));
        Check.no(bf.mightContain("grape"));
        Ch83CompactSets.BloomFilter bf2 = new Ch83CompactSets.BloomFilter(5000, 4);
        for (int i = 0; i < 300; i++) bf2.add("w" + i);
        for (int i = 0; i < 300; i++) Check.yes(bf2.mightContain("w" + i));
    }
}

class Ex83_12Test {
    public static void run() {
        Check.near(Ch83CompactSets.falsePositiveRate(1000, 10_000, 7), 0.0082, 0.0002);
    }
}

class Ex83_13Test {
    public static void run() {
        Check.eq(Ch83CompactSets.optimalParams(1_000_000, 0.01), new long[]{9585059, 7});
    }
}

class Ex83_14Test {
    public static void run() {
        Check.near(Ch83CompactSets.measuredFpRate(1000, 10_000, 7, 20_000), 0.0082, 0.005);
    }
}

class Ex83_15Test {
    public static void run() {
        List<String> stream = Ch83CompactSetsTest.stream();
        List<String> reported = Ch83CompactSets.streamDuplicates(stream, 64_000, 6);
        Set<String> repSet = new HashSet<>(reported);
        for (int i = 0; i < 100; i++) Check.yes(repSet.contains("item-" + (i * 37)));
        int alarms = Ch83CompactSets.falseAlarms(stream, 64_000, 6);
        Check.yes(alarms <= 15);
        Check.eq(reported.size(), 100 + alarms);
    }
}

class Ex83_16Test {
    public static void run() {
        Ch83CompactSets.BloomFilter fx = new Ch83CompactSets.BloomFilter(500, 4), fy = new Ch83CompactSets.BloomFilter(500, 4);
        fx.add("x");
        fy.add("y");
        Ch83CompactSets.BloomFilter fu = fx.union(fy);
        Check.yes(fu.mightContain("x") && fu.mightContain("y"));
        Check.eq(fu.count, 2);
        Check.throwsEx(IllegalArgumentException.class, () -> fx.union(new Ch83CompactSets.BloomFilter(500, 3)));
    }
}

class Ex83_17Test {
    public static void run() {
        Ch83CompactSets.CountingBloomFilter cb = new Ch83CompactSets.CountingBloomFilter(1000, 4);
        cb.add("a");
        cb.add("b");
        Check.yes(cb.remove("a"));
        Check.no(cb.mightContain("a"));
        Check.yes(cb.mightContain("b"));
        Check.no(cb.remove("zzz"));
    }
}
