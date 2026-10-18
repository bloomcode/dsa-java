import java.util.List;

/** Chapter 25 tests, one class per exercise. */

class Ex25_1Test {
    public static void run() {
        char[] chars = "sun is up".toCharArray();
        Check.yes(Ch25Strings.reverseWords(chars) == chars);
        Check.eq(new String(chars), "up is sun");
        Check.eq(new String(Ch25Strings.reverseWords("solo".toCharArray())), "solo");
        Check.eq(new String(Ch25Strings.reverseWords("a b".toCharArray())), "b a");
        Check.eq(new String(Ch25Strings.reverseWords(new char[0])), "");
    }
}

class Ex25_2Test {
    public static void run() {
        Check.yes(Ch25Strings.oneEditApart("cart", "card"));
        Check.yes(Ch25Strings.oneEditApart("cart", "art"));
        Check.no(Ch25Strings.oneEditApart("cart", "cards"));
        Check.no(Ch25Strings.oneEditApart("cart", "cart"));
        Check.yes(Ch25Strings.oneEditApart("", "x"));
        Check.no(Ch25Strings.oneEditApart("ab", "ba"));
        Check.yes(Ch25Strings.oneEditApart("art", "cart"));
    }
}

class Ex25_3Test {
    public static void run() {
        Check.eq(Ch25Strings.firstUniqueIndex("abacabad"), 3);
        Check.eq(Ch25Strings.firstUniqueIndex("aabb"), -1);
        Check.eq(Ch25Strings.firstUniqueIndex(""), -1);
        Check.eq(Ch25Strings.firstUniqueIndex("z"), 0);
        Check.eq(Ch25Strings.firstUniqueIndex("xxyz"), 2);
    }
}

class Ex25_4Test {
    public static void run() {
        Check.eq(Ch25Strings.lettersNeeded(new String[]{"tool", "loot", "lot"}), "loot");
        Check.eq(Ch25Strings.lettersNeeded(new String[]{"a", "b"}), "ab");
        Check.eq(Ch25Strings.lettersNeeded(new String[]{"aa", "a"}), "aa");
        Check.eq(Ch25Strings.lettersNeeded(new String[]{}), "");
        Check.eq(Ch25Strings.lettersNeeded(new String[]{"abc", "cab", "cc"}), "abcc");
    }
}

class Ex25_5Test {
    public static void run() {
        Check.eq(Ch25Strings.reversedPairs(new String[]{"stop", "tops", "pots", "spot", "level"}), List.of(List.of("stop", "pots"), List.of("tops", "spot")));
        Check.eq(Ch25Strings.reversedPairs(new String[]{}), List.of());
        Check.eq(Ch25Strings.reversedPairs(new String[]{"noon", "abc"}), List.of());
        Check.eq(Ch25Strings.reversedPairs(new String[]{"ab", "ba"}), List.of(List.of("ab", "ba")));
    }
}

class Ex25_6Test {
    public static void run() {
        Check.eq(Ch25Strings.longestPalindrome("noonabcbad"), "abcba");
        Check.eq(Ch25Strings.longestPalindrome(""), "");
        Check.eq(Ch25Strings.longestPalindrome("x"), "x");
        Check.eq(Ch25Strings.longestPalindrome("ab"), "a");
        Check.eq(Ch25Strings.longestPalindrome("cbbd"), "bb");
        Check.eq(Ch25Strings.longestPalindrome("aaaa"), "aaaa");
    }
}

class Ex25_7Test {
    public static void run() {
        Check.eq(Ch25Strings.anagramStarts("tapatpta", "pat"), List.of(0, 2, 3, 5));
        Check.eq(Ch25Strings.anagramStarts("aaa", "aa"), List.of(0, 1));
        Check.eq(Ch25Strings.anagramStarts("ab", "abc"), List.of());
        Check.eq(Ch25Strings.anagramStarts("xyz", "q"), List.of());
    }
}

class Ex25_8Test {
    public static void run() {
        Check.eq(Ch25Strings.longestAfterChanges("aabcabb", 2), 5);
        Check.eq(Ch25Strings.longestAfterChanges("aabcabb", 0), 2);
        Check.eq(Ch25Strings.longestAfterChanges("", 3), 0);
        Check.eq(Ch25Strings.longestAfterChanges("abcd", 9), 4);
        Check.eq(Ch25Strings.longestAfterChanges("abab", 1), 3);
    }
}

class Ex25_9Test {
    public static void run() {
        Check.eq(Ch25Strings.underscoreMatches("lalala la", "la"), "_lalala_ _la_");
        Check.eq(Ch25Strings.underscoreMatches("aaa", "aa"), "_aaa_");
        Check.eq(Ch25Strings.underscoreMatches("abc", "x"), "abc");
        Check.eq(Ch25Strings.underscoreMatches("xx", "x"), "_xx_");
    }
}

class Ex25_10Test {
    public static void run() {
        Check.eq(Ch25Strings.smallestWindow("bxaxcaxb", "abc"), "caxb");
        Check.eq(Ch25Strings.smallestWindow("abxab", "aab"), "abxa");
        Check.eq(Ch25Strings.smallestWindow("abc", "d"), "");
        Check.eq(Ch25Strings.smallestWindow("a", "a"), "a");
        Check.eq(Ch25Strings.smallestWindow("aa", "aaa"), "");
        Check.eq(Ch25Strings.smallestWindow("xyz", ""), "");
    }
}
