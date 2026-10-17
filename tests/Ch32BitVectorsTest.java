import java.util.List;
import java.util.Random;
import java.util.TreeSet;

/** Chapter 32 tests, one class per exercise. */
final class Ch32BitVectorsTest {
    private Ch32BitVectorsTest() {}

    static Ch32BitVectors.BitVector vector(int size, int... members) {
        Ch32BitVectors.BitVector bv = new Ch32BitVectors.BitVector(size);
        for (int x : members) bv.add(x);
        return bv;
    }
}

class Ex32_1Test {
    public static void run() {
        Ch32BitVectors.BoolArraySet bs = new Ch32BitVectors.BoolArraySet(10);
        bs.add(3);
        bs.add(7);
        bs.add(7);
        bs.remove(3);
        Check.yes(bs.contains(7));
        Check.no(bs.contains(3));
        Check.eq(bs.size(), 1);
    }
}

class Ex32_2Test {
    public static void run() {
        Ch32BitVectors.BitVector bv = new Ch32BitVectors.BitVector(100);
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

class Ex32_3Test {
    public static void run() {
        Ch32BitVectors.BitVector bv = Ch32BitVectorsTest.vector(100, 1, 5, 99);
        Check.eq(bv.count(), 3);
        bv.add(5);
        Check.eq(bv.count(), 3);
        Check.eq(new Ch32BitVectors.BitVector(10).count(), 0);
    }
}

class Ex32_4Test {
    public static void run() {
        Ch32BitVectors.BitVector a = Ch32BitVectorsTest.vector(10, 1, 2, 3), b = Ch32BitVectorsTest.vector(10, 2, 3, 4);
        Ch32BitVectors.BitVector u = a.union(b), i = a.intersection(b), d = a.difference(b);
        for (int x = 0; x < 10; x++) {
            Check.eq(u.contains(x), x >= 1 && x <= 4);
            Check.eq(i.contains(x), x == 2 || x == 3);
            Check.eq(d.contains(x), x == 1);
        }
    }
}

class Ex32_5Test {
    public static void run() {
        Check.eq(Ch32BitVectorsTest.vector(200, 9, 2, 63, 150).members(), List.of(2, 9, 63, 150));
        Random rng = new Random(3);
        TreeSet<Integer> members = new TreeSet<>();
        while (members.size() < 700) members.add(rng.nextInt(5000));
        Ch32BitVectors.BitVector big = Ch32BitVectorsTest.vector(5000, members.stream().mapToInt(Integer::intValue).toArray());
        Check.eq(big.members(), List.copyOf(members));
    }
}

class Ex32_6Test {
    public static void run() {
        var rep = Ch32BitVectors.spaceReport(1_000_000);
        Check.eq(rep.get("booleanArray"), 1000016L);
        Check.eq(rep.get("bitVector"), 125016L);
        Check.yes(rep.get("hashSet") > 50_000_000L && rep.get("hashSet") < 60_000_000L);
    }
}

class Ex32_7Test {
    public static void run() {
        Check.eq(Ch32BitVectors.firstDuplicate(new int[]{4, 9, 1, 9, 4}, 10), 9);
        Check.eq(Ch32BitVectors.firstDuplicate(new int[]{1, 2, 3}, 10), null);
    }
}

class Ex32_8Test {
    public static void run() {
        Check.eq(Ch32BitVectors.unionList(new int[]{1, 5}, new int[]{5, 7}), List.of(1, 5, 7));
        Check.eq(Ch32BitVectors.commonCount(new int[]{1, 5}, new int[]{5, 7}), 1);
    }
}

class Ex32_9Test {
    public static void run() {
        Check.eq(Ch32BitVectors.missing(new int[]{0, 3, 1, 6}, 7), List.of(2, 4, 5));
        Check.eq(Ch32BitVectors.missing(new int[]{0, 1, 2, 3, 4}, 5), List.of());
    }
}
