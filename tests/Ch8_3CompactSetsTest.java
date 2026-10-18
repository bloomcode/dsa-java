import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

/** Chapter 8.3 tests, one class per exercise. */

final class Ch8_3CompactSetsTest {
    private Ch8_3CompactSetsTest() {}

    static Ch8_3CompactSets.BitVector vector(int size, int... members) {
        Ch8_3CompactSets.BitVector bv = new Ch8_3CompactSets.BitVector(size);
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

class Ex8_3_1Test {
    public static void run() {
        Ch8_3CompactSets.BoolArraySet bs = new Ch8_3CompactSets.BoolArraySet(10);
        bs.add(3);
        bs.add(7);
        bs.add(7);
        bs.remove(3);
        Check.yes(bs.contains(7));
        Check.no(bs.contains(3));
        Check.eq(bs.size(), 1);
    }
}

class Ex8_3_2Test {
    public static void run() {
        Ch8_3CompactSets.BitVector bv = new Ch8_3CompactSets.BitVector(100);
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

class Ex8_3_3Test {
    public static void run() {
        Ch8_3CompactSets.BitVector bv = Ch8_3CompactSetsTest.vector(100, 1, 5, 99);
        Check.eq(bv.count(), 3);
        bv.add(5);
        Check.eq(bv.count(), 3);
        Check.eq(new Ch8_3CompactSets.BitVector(10).count(), 0);
    }
}

class Ex8_3_4Test {
    public static void run() {
        Ch8_3CompactSets.BitVector a = Ch8_3CompactSetsTest.vector(10, 1, 2, 3), b = Ch8_3CompactSetsTest.vector(10, 2, 3, 4);
        Ch8_3CompactSets.BitVector u = a.union(b), i = a.intersection(b), d = a.difference(b);
        for (int x = 0; x < 10; x++) {
            Check.eq(u.contains(x), x >= 1 && x <= 4);
            Check.eq(i.contains(x), x == 2 || x == 3);
            Check.eq(d.contains(x), x == 1);
        }
    }
}

class Ex8_3_5Test {
    public static void run() {
        Check.eq(Ch8_3CompactSetsTest.vector(200, 9, 2, 63, 150).members(), List.of(2, 9, 63, 150));
        Random rng = new Random(3);
        TreeSet<Integer> members = new TreeSet<>();
        while (members.size() < 700) members.add(rng.nextInt(5000));
        Ch8_3CompactSets.BitVector big = Ch8_3CompactSetsTest.vector(5000, members.stream().mapToInt(Integer::intValue).toArray());
        Check.eq(big.members(), List.copyOf(members));
    }
}

class Ex8_3_6Test {
    public static void run() {
        var rep = Ch8_3CompactSets.spaceReport(1_000_000);
        Check.eq(rep.get("booleanArray"), 1000016L);
        Check.eq(rep.get("bitVector"), 125016L);
        Check.yes(rep.get("hashSet") > 50_000_000L && rep.get("hashSet") < 60_000_000L);
    }
}

class Ex8_3_7Test {
    public static void run() {
        Check.eq(Ch8_3CompactSets.firstDuplicate(new int[]{4, 9, 1, 9, 4}, 10), 9);
        Check.eq(Ch8_3CompactSets.firstDuplicate(new int[]{1, 2, 3}, 10), null);
    }
}

class Ex8_3_8Test {
    public static void run() {
        Check.eq(Ch8_3CompactSets.unionList(new int[]{1, 5}, new int[]{5, 7}), List.of(1, 5, 7));
        Check.eq(Ch8_3CompactSets.commonCount(new int[]{1, 5}, new int[]{5, 7}), 1);
    }
}

class Ex8_3_9Test {
    public static void run() {
        Check.eq(Ch8_3CompactSets.missing(new int[]{0, 3, 1, 6}, 7), List.of(2, 4, 5));
        Check.eq(Ch8_3CompactSets.missing(new int[]{0, 1, 2, 3, 4}, 5), List.of());
    }
}

class Ex8_3_10Test {
    public static void run() {
        int[] pos = Ch8_3CompactSets.bitPositions("cat", 3, 32);
        Check.eq(pos, Ch8_3CompactSets.bitPositions("cat", 3, 32));
        Check.eq(pos.length, 3);
        for (int p : pos) Check.yes(p >= 0 && p < 32);
        for (int i = 0; i < 1000; i++) for (int p : Ch8_3CompactSets.bitPositions("w" + i, 7, 1_000_003)) Check.yes(p >= 0 && p < 1_000_003);
    }
}

class Ex8_3_11Test {
    public static void run() {
        Ch8_3CompactSets.BloomFilter bf = new Ch8_3CompactSets.BloomFilter(1000, 5);
        bf.add("apple");
        bf.add("pear");
        Check.yes(bf.mightContain("apple"));
        Check.yes(bf.mightContain("pear"));
        Check.no(bf.mightContain("grape"));
        Ch8_3CompactSets.BloomFilter bf2 = new Ch8_3CompactSets.BloomFilter(5000, 4);
        for (int i = 0; i < 300; i++) bf2.add("w" + i);
        for (int i = 0; i < 300; i++) Check.yes(bf2.mightContain("w" + i));
    }
}

class Ex8_3_12Test {
    public static void run() {
        Check.near(Ch8_3CompactSets.falsePositiveRate(1000, 10_000, 7), 0.0082, 0.0002);
    }
}

class Ex8_3_13Test {
    public static void run() {
        Check.eq(Ch8_3CompactSets.optimalParams(1_000_000, 0.01), new long[]{9585059, 7});
    }
}

class Ex8_3_14Test {
    public static void run() {
        Check.near(Ch8_3CompactSets.measuredFpRate(1000, 10_000, 7, 20_000), 0.0082, 0.005);
    }
}

class Ex8_3_15Test {
    public static void run() {
        List<String> stream = Ch8_3CompactSetsTest.stream();
        List<String> reported = Ch8_3CompactSets.streamDuplicates(stream, 64_000, 6);
        Set<String> repSet = new HashSet<>(reported);
        for (int i = 0; i < 100; i++) Check.yes(repSet.contains("item-" + (i * 37)));
        int alarms = Ch8_3CompactSets.falseAlarms(stream, 64_000, 6);
        Check.yes(alarms <= 15);
        Check.eq(reported.size(), 100 + alarms);
    }
}

class Ex8_3_16Test {
    public static void run() {
        Ch8_3CompactSets.BloomFilter fx = new Ch8_3CompactSets.BloomFilter(500, 4), fy = new Ch8_3CompactSets.BloomFilter(500, 4);
        fx.add("x");
        fy.add("y");
        Ch8_3CompactSets.BloomFilter fu = fx.union(fy);
        Check.yes(fu.mightContain("x") && fu.mightContain("y"));
        Check.eq(fu.count, 2);
        Check.throwsEx(IllegalArgumentException.class, () -> fx.union(new Ch8_3CompactSets.BloomFilter(500, 3)));
    }
}

class Ex8_3_17Test {
    public static void run() {
        Ch8_3CompactSets.CountingBloomFilter cb = new Ch8_3CompactSets.CountingBloomFilter(1000, 4);
        cb.add("a");
        cb.add("b");
        Check.yes(cb.remove("a"));
        Check.no(cb.mightContain("a"));
        Check.yes(cb.mightContain("b"));
        Check.no(cb.remove("zzz"));
    }
}
