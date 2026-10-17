import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.stream.IntStream;

/** Chapter 30 tests, one class per exercise. */
final class Ch30HashingTest {
    private Ch30HashingTest() {}

    static final List<Integer> STEP8 = IntStream.range(0, 1000).map(i -> 8 * i).boxed().toList();

    static List<String> words(int n, Random rng) {
        List<String> out = new ArrayList<>();
        Set<String> seen = new HashSet<>();
        while (out.size() < n) {
            StringBuilder sb = new StringBuilder();
            int len = 3 + rng.nextInt(6);
            for (int i = 0; i < len; i++) sb.append((char) ('a' + rng.nextInt(26)));
            if (seen.add(sb.toString())) out.add(sb.toString());
        }
        return out;
    }
}

class Ex30_1Test {
    public static void run() {
        Check.yes(Ch30Hashing.sumHash("stop", 101) == Ch30Hashing.sumHash("pots", 101)
                && Ch30Hashing.sumHash("pots", 101) == Ch30Hashing.sumHash("tops", 101));
        int h = Ch30Hashing.sumHash("anything", 7);
        Check.yes(h >= 0 && h < 7);
    }
}

class Ex30_2Test {
    public static void run() {
        Check.yes(Ch30Hashing.polyHash("stop", 1_000_000_007) != Ch30Hashing.polyHash("pots", 1_000_000_007));
        Check.eq(Ch30Hashing.polyHash("abc", Integer.MAX_VALUE), "abc".hashCode());
    }
}

class Ex30_3Test {
    public static void run() {
        Check.eq(Ch30Hashing.bucketsUsed(Ch30HashingTest.STEP8, 64, Ch30Hashing::divisionHash), 8);
        Check.eq(Ch30Hashing.bucketsUsed(Ch30HashingTest.STEP8, 61, Ch30Hashing::divisionHash), 61);
        Check.eq(Ch30Hashing.divisionHash(130, 64), 2);
    }
}

class Ex30_4Test {
    public static void run() {
        List<String> ws = Ch30HashingTest.words(10_000, new Random(1));
        int polyMax = Ch30Hashing.maxBucket(ws, 1000, Ch30Hashing::polyHash);
        int sumMax = Ch30Hashing.maxBucket(ws, 1000, Ch30Hashing::sumHash);
        Check.yes(polyMax >= 15 && polyMax <= 30);
        Check.yes(sumMax > 2 * polyMax);
    }
}

class Ex30_5Test {
    public static void run() {
        Ch30Hashing.UniversalHash u1 = new Ch30Hashing.UniversalHash(1000, new Random(1));
        Ch30Hashing.UniversalHash u2 = new Ch30Hashing.UniversalHash(1000, new Random(2));
        int differ = 0;
        for (int k = 0; k < 100; k++) {
            int x = u1.applyAsInt(k);
            Check.yes(x >= 0 && x < 1000);
            if (x != u2.applyAsInt(k)) differ++;
        }
        Check.yes(differ > 90);
        Random rmp = new Random(31);
        BigInteger p = BigInteger.valueOf(Ch30Hashing.P);
        for (int i = 0; i < 2000; i++) {
            long a = Math.floorMod(rmp.nextLong(), Ch30Hashing.P), b = Math.floorMod(rmp.nextLong(), Ch30Hashing.P);
            if (i == 0) a = b = Ch30Hashing.P - 1;
            Check.eq(Ch30Hashing.mulModP(a, b), BigInteger.valueOf(a).multiply(BigInteger.valueOf(b)).mod(p).longValue());
        }
    }
}

class Ex30_6Test {
    public static void run() {
        List<Integer> adv = Ch30Hashing.adversarialKeys(1000, 5000);
        Check.eq(adv.size(), 5000);
        Check.eq(Ch30Hashing.fullest(adv, k -> k % 1000), 5000);
        Check.yes(Ch30Hashing.fullest(adv, new Ch30Hashing.UniversalHash(1000, new Random(7))) <= 20);
    }
}

class Ex30_7Test {
    public static void run() {
        Ch30Hashing.RandomizedHashTable rt = new Ch30Hashing.RandomizedHashTable(new Random(3));
        List<Integer> adv2 = Ch30Hashing.adversarialKeys(1024, 10_000);
        for (int k : adv2) rt.put(k, "v" + k);
        rt.put(adv2.get(5), "changed");
        Check.eq(rt.size(), 10_000);
        Check.eq(rt.get(adv2.get(5)), "changed");
        for (int i = 0; i < adv2.size(); i += 97) if (i != 5) Check.eq(rt.get(adv2.get(i)), "v" + adv2.get(i));
        Check.eq(rt.get(-1), null);
        Check.yes(rt.longestChain() <= 12);
    }
}

class Ex30_8Test {
    public static void run() {
        Check.eq(Ch30Hashing.bucketsUsed(Ch30HashingTest.STEP8, 64, Ch30Hashing::multHash), 64);
        for (int k : Ch30HashingTest.STEP8) {
            int h = Ch30Hashing.multHash(k, 64);
            Check.yes(h >= 0 && h < 64);
        }
    }
}
