import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/** Chapter 31 tests, one class per exercise. */
final class Ch31RabinKarpTest {
    private Ch31RabinKarpTest() {}

    static final String TEXT = randomText();
    static final String[] NEEDLES = {"ab", "xyz", "q", "abcde"};

    private static String randomText() {
        StringBuilder sb = new StringBuilder();
        Random rt = new Random(1);
        for (int i = 0; i < 10_000; i++) sb.append((char) ('a' + rt.nextInt(26)));
        return sb.toString();
    }

    /** Every match by String.startsWith, independent of the exercises. */
    static List<Integer> matches(String text, String needle) {
        List<Integer> out = new ArrayList<>();
        for (int i = 0; i + needle.length() <= text.length(); i++) if (text.startsWith(needle, i)) out.add(i);
        return out;
    }
}

class Ex31_1Test {
    public static void run() {
        Check.eq(Ch31RabinKarp.bruteForceSearch("abracadabra", "abra"), List.of(0, 7));
        for (String needle : Ch31RabinKarpTest.NEEDLES)
            Check.eq(Ch31RabinKarp.bruteForceSearch(Ch31RabinKarpTest.TEXT, needle), Ch31RabinKarpTest.matches(Ch31RabinKarpTest.TEXT, needle));
    }
}

class Ex31_2Test {
    public static void run() {
        Check.eq(Ch31RabinKarp.windowSums(new int[]{1, 2, 3, 4, 5}, 3), new long[]{6, 9, 12});
    }
}

class Ex31_3Test {
    public static void run() {
        Check.eq(Ch31RabinKarp.rollingHashes("abcd", 2), new long[]{1, 28, 55});
    }
}

class Ex31_4Test {
    public static void run() {
        Check.eq(Ch31RabinKarp.rabinKarp("abracadabra", "abra", Ch31RabinKarp.PRIME), List.of(0, 7));
        Check.eq(Ch31RabinKarp.rabinKarp("aaaa", "aa", Ch31RabinKarp.PRIME), List.of(0, 1, 2));
        Check.eq(Ch31RabinKarp.rabinKarp("ab", "abc", Ch31RabinKarp.PRIME), List.of());
        for (String needle : Ch31RabinKarpTest.NEEDLES) {
            List<Integer> want = Ch31RabinKarpTest.matches(Ch31RabinKarpTest.TEXT, needle);
            Check.eq(Ch31RabinKarp.rabinKarp(Ch31RabinKarpTest.TEXT, needle, Ch31RabinKarp.PRIME), want);
            Check.eq(Ch31RabinKarp.rabinKarp(Ch31RabinKarpTest.TEXT, needle, 7), want);
        }
    }
}

class Ex31_5Test {
    public static void run() {
        Check.yes(Ch31RabinKarp.spuriousHits(Ch31RabinKarpTest.TEXT, "abcde", 7) > 1000);
        Check.eq(Ch31RabinKarp.spuriousHits(Ch31RabinKarpTest.TEXT, "abcde", Ch31RabinKarp.PRIME), 0);
    }
}

class Ex31_6Test {
    public static void run() {
        Check.eq(Ch31RabinKarp.rabinKarpMonteCarlo("abracadabra", "abra", new Random(1)), List.of(0, 7));
        for (String needle : Ch31RabinKarpTest.NEEDLES)
            Check.eq(Ch31RabinKarp.rabinKarpMonteCarlo(Ch31RabinKarpTest.TEXT, needle, new Random(needle.length())),
                    Ch31RabinKarpTest.matches(Ch31RabinKarpTest.TEXT, needle));
    }
}

class Ex31_7Test {
    public static void run() {
        Check.eq(Ch31RabinKarp.findAny("thecatsatonthemat", List.of("cat", "mat", "dog")).toString(),
                "[Hit[index=3, needle=cat], Hit[index=14, needle=mat]]");
    }
}

class Ex31_8Test {
    public static void run() {
        Check.eq(Ch31RabinKarp.longestRepeat("banana"), "ana");
        Check.eq(Ch31RabinKarp.longestRepeat("abcd"), "");
        Check.eq(Ch31RabinKarp.longestRepeat("abcabcxabc"), "abc");
        Check.eq(Ch31RabinKarp.longestRepeat("aaaa"), "aaa");
    }
}
