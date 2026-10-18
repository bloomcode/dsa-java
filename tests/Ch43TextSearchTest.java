import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/** Chapter 43 tests, one class per exercise. */

final class Ch43TextSearchTest {
    private Ch43TextSearchTest() {}

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

class Ex43_1Test {
    public static void run() {
        Check.eq(Ch43TextSearch.bruteForceSearch("abracadabra", "abra"), List.of(0, 7));
        for (String needle : Ch43TextSearchTest.NEEDLES)
            Check.eq(Ch43TextSearch.bruteForceSearch(Ch43TextSearchTest.TEXT, needle), Ch43TextSearchTest.matches(Ch43TextSearchTest.TEXT, needle));
    }
}

class Ex43_2Test {
    public static void run() {
        Check.eq(Ch43TextSearch.windowSums(new int[]{1, 2, 3, 4, 5}, 3), new long[]{6, 9, 12});
    }
}

class Ex43_3Test {
    public static void run() {
        Check.eq(Ch43TextSearch.rollingHashes("abcd", 2), new long[]{1, 28, 55});
    }
}

class Ex43_4Test {
    public static void run() {
        Check.eq(Ch43TextSearch.rabinKarp("abracadabra", "abra", Ch43TextSearch.PRIME), List.of(0, 7));
        Check.eq(Ch43TextSearch.rabinKarp("aaaa", "aa", Ch43TextSearch.PRIME), List.of(0, 1, 2));
        Check.eq(Ch43TextSearch.rabinKarp("ab", "abc", Ch43TextSearch.PRIME), List.of());
        for (String needle : Ch43TextSearchTest.NEEDLES) {
            List<Integer> want = Ch43TextSearchTest.matches(Ch43TextSearchTest.TEXT, needle);
            Check.eq(Ch43TextSearch.rabinKarp(Ch43TextSearchTest.TEXT, needle, Ch43TextSearch.PRIME), want);
            Check.eq(Ch43TextSearch.rabinKarp(Ch43TextSearchTest.TEXT, needle, 7), want);
        }
    }
}

class Ex43_5Test {
    public static void run() {
        Check.yes(Ch43TextSearch.spuriousHits(Ch43TextSearchTest.TEXT, "abcde", 7) > 1000);
        Check.eq(Ch43TextSearch.spuriousHits(Ch43TextSearchTest.TEXT, "abcde", Ch43TextSearch.PRIME), 0);
    }
}

class Ex43_6Test {
    public static void run() {
        Check.eq(Ch43TextSearch.rabinKarpMonteCarlo("abracadabra", "abra", new Random(1)), List.of(0, 7));
        for (String needle : Ch43TextSearchTest.NEEDLES)
            Check.eq(Ch43TextSearch.rabinKarpMonteCarlo(Ch43TextSearchTest.TEXT, needle, new Random(needle.length())),
                    Ch43TextSearchTest.matches(Ch43TextSearchTest.TEXT, needle));
    }
}

class Ex43_7Test {
    public static void run() {
        Check.eq(Ch43TextSearch.findAny("thecatsatonthemat", List.of("cat", "mat", "dog")).toString(),
                "[Hit[index=3, needle=cat], Hit[index=14, needle=mat]]");
    }
}

class Ex43_8Test {
    public static void run() {
        Check.eq(Ch43TextSearch.longestRepeat("banana"), "ana");
        Check.eq(Ch43TextSearch.longestRepeat("abcd"), "");
        Check.eq(Ch43TextSearch.longestRepeat("abcabcxabc"), "abc");
        Check.eq(Ch43TextSearch.longestRepeat("aaaa"), "aaa");
    }
}

class Ex43_9Test {
    public static void run() {
        Check.eq(Ch43TextSearch.prefixTable("abacabab"), new int[] {0, 0, 1, 0, 1, 2, 3, 2});
        Check.eq(Ch43TextSearch.prefixTable("aaaa"), new int[] {0, 1, 2, 3});
        Check.eq(Ch43TextSearch.prefixTable(""), new int[0]);
        Check.eq(Ch43TextSearch.prefixTable("abcd"), new int[] {0, 0, 0, 0});
        Check.eq(Ch43TextSearch.prefixTable("aabaaab"), new int[] {0, 1, 0, 1, 2, 2, 3});
    }
}

class Ex43_10Test {
    public static void run() {
        Check.eq(Ch43TextSearch.prefixSearch("abababca", "abab"), List.of(0, 2));
        Check.eq(Ch43TextSearch.prefixSearch("aaaa", "aa"), List.of(0, 1, 2));
        Check.eq(Ch43TextSearch.prefixSearch("abc", "d"), List.of());
        Check.eq(Ch43TextSearch.prefixSearch("ab", "abc"), List.of());
        Check.eq(Ch43TextSearch.prefixSearch("xabcabcx", "abcx"), List.of(4));
        Check.eq(Ch43TextSearch.prefixSearch("", "a"), List.of());
    }
}
