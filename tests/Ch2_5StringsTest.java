import java.util.List;

/** Chapter 2.5 tests, one class per exercise. */

class Ex2_5_1Test {
    public static void run() {
        char[] chars = "sun is up".toCharArray();
        Check.yes(Ch2_5Strings.reverseWords(chars) == chars);
        Check.eq(new String(chars), "up is sun");
        Check.eq(new String(Ch2_5Strings.reverseWords("solo".toCharArray())), "solo");
        Check.eq(new String(Ch2_5Strings.reverseWords("a b".toCharArray())), "b a");
        Check.eq(new String(Ch2_5Strings.reverseWords(new char[0])), "");
    }
}

class Ex2_5_2Test {
    public static void run() {
        Check.yes(Ch2_5Strings.oneEditApart("cart", "card"));
        Check.yes(Ch2_5Strings.oneEditApart("cart", "art"));
        Check.no(Ch2_5Strings.oneEditApart("cart", "cards"));
        Check.no(Ch2_5Strings.oneEditApart("cart", "cart"));
        Check.yes(Ch2_5Strings.oneEditApart("", "x"));
        Check.no(Ch2_5Strings.oneEditApart("ab", "ba"));
        Check.yes(Ch2_5Strings.oneEditApart("art", "cart"));
    }
}

class Ex2_5_3Test {
    public static void run() {
        Check.eq(Ch2_5Strings.firstUniqueIndex("abacabad"), 3);
        Check.eq(Ch2_5Strings.firstUniqueIndex("aabb"), -1);
        Check.eq(Ch2_5Strings.firstUniqueIndex(""), -1);
        Check.eq(Ch2_5Strings.firstUniqueIndex("z"), 0);
        Check.eq(Ch2_5Strings.firstUniqueIndex("xxyz"), 2);
    }
}

class Ex2_5_4Test {
    public static void run() {
        Check.eq(Ch2_5Strings.lettersNeeded(new String[]{"tool", "loot", "lot"}), "loot");
        Check.eq(Ch2_5Strings.lettersNeeded(new String[]{"a", "b"}), "ab");
        Check.eq(Ch2_5Strings.lettersNeeded(new String[]{"aa", "a"}), "aa");
        Check.eq(Ch2_5Strings.lettersNeeded(new String[]{}), "");
        Check.eq(Ch2_5Strings.lettersNeeded(new String[]{"abc", "cab", "cc"}), "abcc");
    }
}

class Ex2_5_5Test {
    public static void run() {
        Check.eq(Ch2_5Strings.reversedPairs(new String[]{"stop", "tops", "pots", "spot", "level"}), List.of(List.of("stop", "pots"), List.of("tops", "spot")));
        Check.eq(Ch2_5Strings.reversedPairs(new String[]{}), List.of());
        Check.eq(Ch2_5Strings.reversedPairs(new String[]{"noon", "abc"}), List.of());
        Check.eq(Ch2_5Strings.reversedPairs(new String[]{"ab", "ba"}), List.of(List.of("ab", "ba")));
    }
}

class Ex2_5_6Test {
    public static void run() {
        Check.eq(Ch2_5Strings.longestPalindrome("noonabcbad"), "abcba");
        Check.eq(Ch2_5Strings.longestPalindrome(""), "");
        Check.eq(Ch2_5Strings.longestPalindrome("x"), "x");
        Check.eq(Ch2_5Strings.longestPalindrome("ab"), "a");
        Check.eq(Ch2_5Strings.longestPalindrome("cbbd"), "bb");
        Check.eq(Ch2_5Strings.longestPalindrome("aaaa"), "aaaa");
    }
}

class Ex2_5_7Test {
    public static void run() {
        Check.eq(Ch2_5Strings.anagramStarts("tapatpta", "pat"), List.of(0, 2, 3, 5));
        Check.eq(Ch2_5Strings.anagramStarts("aaa", "aa"), List.of(0, 1));
        Check.eq(Ch2_5Strings.anagramStarts("ab", "abc"), List.of());
        Check.eq(Ch2_5Strings.anagramStarts("xyz", "q"), List.of());
    }
}

class Ex2_5_8Test {
    public static void run() {
        Check.eq(Ch2_5Strings.longestAfterChanges("aabcabb", 2), 5);
        Check.eq(Ch2_5Strings.longestAfterChanges("aabcabb", 0), 2);
        Check.eq(Ch2_5Strings.longestAfterChanges("", 3), 0);
        Check.eq(Ch2_5Strings.longestAfterChanges("abcd", 9), 4);
        Check.eq(Ch2_5Strings.longestAfterChanges("abab", 1), 3);
    }
}

class Ex2_5_9Test {
    public static void run() {
        Check.eq(Ch2_5Strings.underscoreMatches("lalala la", "la"), "_lalala_ _la_");
        Check.eq(Ch2_5Strings.underscoreMatches("aaa", "aa"), "_aaa_");
        Check.eq(Ch2_5Strings.underscoreMatches("abc", "x"), "abc");
        Check.eq(Ch2_5Strings.underscoreMatches("xx", "x"), "_xx_");
    }
}

class Ex2_5_10Test {
    public static void run() {
        Check.eq(Ch2_5Strings.smallestWindow("bxaxcaxb", "abc"), "caxb");
        Check.eq(Ch2_5Strings.smallestWindow("abxab", "aab"), "abxa");
        Check.eq(Ch2_5Strings.smallestWindow("abc", "d"), "");
        Check.eq(Ch2_5Strings.smallestWindow("a", "a"), "a");
        Check.eq(Ch2_5Strings.smallestWindow("aa", "aaa"), "");
        Check.eq(Ch2_5Strings.smallestWindow("xyz", ""), "");
    }
}
