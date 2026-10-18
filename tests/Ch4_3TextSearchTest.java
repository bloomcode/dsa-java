import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/** Chapter 4.3 tests, one class per exercise. */

final class Ch4_3TextSearchTest {
    private Ch4_3TextSearchTest() {}

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

class Ex4_3_1Test {
    public static void run() {
        Check.eq(Ch4_3TextSearch.bruteForceSearch("abracadabra", "abra"), List.of(0, 7));
        for (String needle : Ch4_3TextSearchTest.NEEDLES)
            Check.eq(Ch4_3TextSearch.bruteForceSearch(Ch4_3TextSearchTest.TEXT, needle), Ch4_3TextSearchTest.matches(Ch4_3TextSearchTest.TEXT, needle));
    }
}

class Ex4_3_2Test {
    public static void run() {
        Check.eq(Ch4_3TextSearch.windowSums(new int[]{1, 2, 3, 4, 5}, 3), new long[]{6, 9, 12});
    }
}

class Ex4_3_3Test {
    public static void run() {
        Check.eq(Ch4_3TextSearch.rollingHashes("abcd", 2), new long[]{1, 28, 55});
    }
}

class Ex4_3_4Test {
    public static void run() {
        Check.eq(Ch4_3TextSearch.rabinKarp("abracadabra", "abra", Ch4_3TextSearch.PRIME), List.of(0, 7));
        Check.eq(Ch4_3TextSearch.rabinKarp("aaaa", "aa", Ch4_3TextSearch.PRIME), List.of(0, 1, 2));
        Check.eq(Ch4_3TextSearch.rabinKarp("ab", "abc", Ch4_3TextSearch.PRIME), List.of());
        for (String needle : Ch4_3TextSearchTest.NEEDLES) {
            List<Integer> want = Ch4_3TextSearchTest.matches(Ch4_3TextSearchTest.TEXT, needle);
            Check.eq(Ch4_3TextSearch.rabinKarp(Ch4_3TextSearchTest.TEXT, needle, Ch4_3TextSearch.PRIME), want);
            Check.eq(Ch4_3TextSearch.rabinKarp(Ch4_3TextSearchTest.TEXT, needle, 7), want);
        }
    }
}

class Ex4_3_5Test {
    public static void run() {
        Check.yes(Ch4_3TextSearch.spuriousHits(Ch4_3TextSearchTest.TEXT, "abcde", 7) > 1000);
        Check.eq(Ch4_3TextSearch.spuriousHits(Ch4_3TextSearchTest.TEXT, "abcde", Ch4_3TextSearch.PRIME), 0);
    }
}

class Ex4_3_6Test {
    public static void run() {
        Check.eq(Ch4_3TextSearch.rabinKarpMonteCarlo("abracadabra", "abra", new Random(1)), List.of(0, 7));
        for (String needle : Ch4_3TextSearchTest.NEEDLES)
            Check.eq(Ch4_3TextSearch.rabinKarpMonteCarlo(Ch4_3TextSearchTest.TEXT, needle, new Random(needle.length())),
                    Ch4_3TextSearchTest.matches(Ch4_3TextSearchTest.TEXT, needle));
    }
}

class Ex4_3_7Test {
    public static void run() {
        Check.eq(Ch4_3TextSearch.findAny("thecatsatonthemat", List.of("cat", "mat", "dog")).toString(),
                "[Hit[index=3, needle=cat], Hit[index=14, needle=mat]]");
    }
}

class Ex4_3_8Test {
    public static void run() {
        Check.eq(Ch4_3TextSearch.longestRepeat("banana"), "ana");
        Check.eq(Ch4_3TextSearch.longestRepeat("abcd"), "");
        Check.eq(Ch4_3TextSearch.longestRepeat("abcabcxabc"), "abc");
        Check.eq(Ch4_3TextSearch.longestRepeat("aaaa"), "aaa");
    }
}

class Ex4_3_9Test {
    public static void run() {
        Check.eq(Ch4_3TextSearch.prefixTable("abacabab"), new int[] {0, 0, 1, 0, 1, 2, 3, 2});
        Check.eq(Ch4_3TextSearch.prefixTable("aaaa"), new int[] {0, 1, 2, 3});
        Check.eq(Ch4_3TextSearch.prefixTable(""), new int[0]);
        Check.eq(Ch4_3TextSearch.prefixTable("abcd"), new int[] {0, 0, 0, 0});
        Check.eq(Ch4_3TextSearch.prefixTable("aabaaab"), new int[] {0, 1, 0, 1, 2, 2, 3});
    }
}

class Ex4_3_10Test {
    public static void run() {
        Check.eq(Ch4_3TextSearch.prefixSearch("abababca", "abab"), List.of(0, 2));
        Check.eq(Ch4_3TextSearch.prefixSearch("aaaa", "aa"), List.of(0, 1, 2));
        Check.eq(Ch4_3TextSearch.prefixSearch("abc", "d"), List.of());
        Check.eq(Ch4_3TextSearch.prefixSearch("ab", "abc"), List.of());
        Check.eq(Ch4_3TextSearch.prefixSearch("xabcabcx", "abcx"), List.of(4));
        Check.eq(Ch4_3TextSearch.prefixSearch("", "a"), List.of());
    }
}
