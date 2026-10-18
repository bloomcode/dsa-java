import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.stream.IntStream;

/** Chapter 4.2 tests, one class per exercise. */

final class Ch4_2HashFunctionsTest {
    private Ch4_2HashFunctionsTest() {}

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

class Ex4_2_1Test {
    public static void run() {
        Check.yes(Ch4_2HashFunctions.sumHash("stop", 101) == Ch4_2HashFunctions.sumHash("pots", 101)
                && Ch4_2HashFunctions.sumHash("pots", 101) == Ch4_2HashFunctions.sumHash("tops", 101));
        int h = Ch4_2HashFunctions.sumHash("anything", 7);
        Check.yes(h >= 0 && h < 7);
    }
}

class Ex4_2_2Test {
    public static void run() {
        Check.yes(Ch4_2HashFunctions.polyHash("stop", 1_000_000_007) != Ch4_2HashFunctions.polyHash("pots", 1_000_000_007));
        Check.eq(Ch4_2HashFunctions.polyHash("abc", Integer.MAX_VALUE), "abc".hashCode());
    }
}

class Ex4_2_3Test {
    public static void run() {
        Check.eq(Ch4_2HashFunctions.bucketsUsed(Ch4_2HashFunctionsTest.STEP8, 64, Ch4_2HashFunctions::divisionHash), 8);
        Check.eq(Ch4_2HashFunctions.bucketsUsed(Ch4_2HashFunctionsTest.STEP8, 61, Ch4_2HashFunctions::divisionHash), 61);
        Check.eq(Ch4_2HashFunctions.divisionHash(130, 64), 2);
    }
}

class Ex4_2_4Test {
    public static void run() {
        List<String> ws = Ch4_2HashFunctionsTest.words(10_000, new Random(1));
        int polyMax = Ch4_2HashFunctions.maxBucket(ws, 1000, Ch4_2HashFunctions::polyHash);
        int sumMax = Ch4_2HashFunctions.maxBucket(ws, 1000, Ch4_2HashFunctions::sumHash);
        Check.yes(polyMax >= 15 && polyMax <= 30);
        Check.yes(sumMax > 2 * polyMax);
    }
}

class Ex4_2_5Test {
    public static void run() {
        Ch4_2HashFunctions.UniversalHash u1 = new Ch4_2HashFunctions.UniversalHash(1000, new Random(1));
        Ch4_2HashFunctions.UniversalHash u2 = new Ch4_2HashFunctions.UniversalHash(1000, new Random(2));
        int differ = 0;
        for (int k = 0; k < 100; k++) {
            int x = u1.applyAsInt(k);
            Check.yes(x >= 0 && x < 1000);
            if (x != u2.applyAsInt(k)) differ++;
        }
        Check.yes(differ > 90);
        Random rmp = new Random(31);
        BigInteger p = BigInteger.valueOf(Ch4_2HashFunctions.P);
        for (int i = 0; i < 2000; i++) {
            long a = Math.floorMod(rmp.nextLong(), Ch4_2HashFunctions.P), b = Math.floorMod(rmp.nextLong(), Ch4_2HashFunctions.P);
            if (i == 0) a = b = Ch4_2HashFunctions.P - 1;
            Check.eq(Ch4_2HashFunctions.mulModP(a, b), BigInteger.valueOf(a).multiply(BigInteger.valueOf(b)).mod(p).longValue());
        }
    }
}

class Ex4_2_6Test {
    public static void run() {
        List<Integer> adv = Ch4_2HashFunctions.adversarialKeys(1000, 5000);
        Check.eq(adv.size(), 5000);
        Check.eq(Ch4_2HashFunctions.fullest(adv, k -> k % 1000), 5000);
        Check.yes(Ch4_2HashFunctions.fullest(adv, new Ch4_2HashFunctions.UniversalHash(1000, new Random(7))) <= 20);
    }
}

class Ex4_2_7Test {
    public static void run() {
        Ch4_2HashFunctions.RandomizedHashTable rt = new Ch4_2HashFunctions.RandomizedHashTable(new Random(3));
        List<Integer> adv2 = Ch4_2HashFunctions.adversarialKeys(1024, 10_000);
        for (int k : adv2) rt.put(k, "v" + k);
        rt.put(adv2.get(5), "changed");
        Check.eq(rt.size(), 10_000);
        Check.eq(rt.get(adv2.get(5)), "changed");
        for (int i = 0; i < adv2.size(); i += 97) if (i != 5) Check.eq(rt.get(adv2.get(i)), "v" + adv2.get(i));
        Check.eq(rt.get(-1), null);
        Check.yes(rt.longestChain() <= 12);
    }
}

class Ex4_2_8Test {
    public static void run() {
        Check.eq(Ch4_2HashFunctions.bucketsUsed(Ch4_2HashFunctionsTest.STEP8, 64, Ch4_2HashFunctions::multHash), 64);
        for (int k : Ch4_2HashFunctionsTest.STEP8) {
            int h = Ch4_2HashFunctions.multHash(k, 64);
            Check.yes(h >= 0 && h < 64);
        }
    }
}
