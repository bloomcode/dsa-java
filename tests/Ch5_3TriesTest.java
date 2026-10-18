import java.util.List;

/** Chapter 5.3 tests, one class per exercise. */

final class Ch5_3TriesTest {
    private Ch5_3TriesTest() {}

    static Ch5_3Tries.Trie trie(String... words) {
        Ch5_3Tries.Trie t = new Ch5_3Tries.Trie();
        for (String w : words) t.insert(w);
        return t;
    }
}

class Ex5_3_1Test {
    public static void run() {
        Ch5_3Tries.Trie t = Ch5_3TriesTest.trie("pin", "pit");
        Check.eq(t.root.children.keySet().toString(), "[p]");
        Check.eq(t.root.children.get('p').children.get('i').children.keySet().toString(), "[n, t]");
        Check.yes(t.root.children.get('p').children.get('i').children.get('n').end);
        Check.no(t.root.children.get('p').children.get('i').end);
    }
}

class Ex5_3_2Test {
    public static void run() {
        Ch5_3Tries.Trie t = Ch5_3TriesTest.trie("pin", "pit");
        Check.yes(t.search("pi") != null);
        Check.eq(t.search("po"), null);
    }
}

class Ex5_3_3Test {
    public static void run() {
        Ch5_3Tries.Trie t = Ch5_3TriesTest.trie("pin", "pit");
        Check.yes(t.containsWord("pin"));
        Check.no(t.containsWord("pi"));
    }
}

class Ex5_3_4Test {
    public static void run() {
        Ch5_3Tries.Trie t = Ch5_3TriesTest.trie("pin", "pit", "sun");
        Check.eq(t.collectAllWords(t.root), List.of("pin", "pit", "sun"));
        Ch5_3Tries.Trie empty = new Ch5_3Tries.Trie();
        Check.eq(empty.collectAllWords(empty.root), List.of());
    }
}

class Ex5_3_5Test {
    public static void run() {
        Ch5_3Tries.Trie t = Ch5_3TriesTest.trie("pin", "pinch", "pit", "sun");
        Check.eq(t.autocomplete("pin"), List.of("pin", "pinch"));
        Check.eq(t.autocomplete("x"), List.of());
    }
}

class Ex5_3_6Test {
    public static void run() {
        Check.eq(Ch5_3TriesTest.trie("pie", "pin").allKeys(), List.of('p', 'i', 'e', 'n'));
    }
}

class Ex5_3_7Test {
    public static void run() {
        Check.eq(Ch5_3TriesTest.trie("pine", "pint", "pinto").longestCommonPrefix(), "pin");
        Check.eq(Ch5_3TriesTest.trie("pin", "pinch").longestCommonPrefix(), "pin");
        Check.eq(Ch5_3TriesTest.trie("sun").longestCommonPrefix(), "sun");
        Check.eq(Ch5_3TriesTest.trie("pin", "sun").longestCommonPrefix(), "");
        Check.eq(new Ch5_3Tries.Trie().longestCommonPrefix(), "");
    }
}

class Ex5_3_8Test {
    public static void run() {
        Ch5_3Tries.RankedTrie rt = new Ch5_3Tries.RankedTrie();
        rt.insert("pinch", 9);
        rt.insert("pin", 5);
        rt.insert("pinball", 7);
        Check.eq(rt.autocomplete("pin", 2), List.of("pinch", "pinball"));
        Check.eq(rt.autocomplete("pin", 9), List.of("pinch", "pinball", "pin"));
    }
}

class Ex5_3_9Test {
    public static void run() {
        Ch5_3Tries.Trie t = Ch5_3TriesTest.trie("pin", "pinch");
        Check.yes(t.delete("pinch"));
        Check.yes(t.containsWord("pin"));
        Check.no(t.containsWord("pinch"));
        Check.yes(t.search("pin").children.isEmpty());
        Check.no(t.delete("sun"));
        Check.no(t.delete("pi"));
        Check.yes(t.delete("pin"));
        Check.yes(t.root.children.isEmpty());
    }
}

class Ex5_3_10Test {
    public static void run() {
        Check.eq(Ch5_3Tries.prefixCounts(new String[] {"car", "card", "care", "dog"}, new String[] {"car", "ca", "d", "x"}), new int[] {3, 3, 1, 0});
        Check.eq(Ch5_3Tries.prefixCounts(new String[] {"a", "a", "ab"}, new String[] {"a", "ab", "abc", ""}), new int[] {3, 1, 0, 3});
        Check.eq(Ch5_3Tries.prefixCounts(new String[0], new String[] {"a"}), new int[] {0});
    }
}

class Ex5_3_11Test {
    public static void run() {
        Check.eq(Ch5_3Tries.trieSort(new String[] {"pear", "apple", "pea", "app"}), List.of("app", "apple", "pea", "pear"));
        Check.eq(Ch5_3Tries.trieSort(new String[0]), List.of());
        Check.eq(Ch5_3Tries.trieSort(new String[] {"b", "a", "b"}), List.of("a", "b", "b"));
        Check.eq(Ch5_3Tries.trieSort(new String[] {"ba", "b", "abc", "ab"}), List.of("ab", "abc", "b", "ba"));
    }
}

class Ex5_3_12Test {
    public static void run() {
        String[] words = {"bad", "bed", "bid", "bud", "bead", "bad"};
        Check.eq(Ch5_3Tries.wildcardMatches(words, "b.d"), List.of("bad", "bed", "bid", "bud"));
        Check.eq(Ch5_3Tries.wildcardMatches(words, ".."), List.of());
        Check.eq(Ch5_3Tries.wildcardMatches(words, "b..d"), List.of("bead"));
        Check.eq(Ch5_3Tries.wildcardMatches(words, "bad"), List.of("bad"));
        Check.eq(Ch5_3Tries.wildcardMatches(words, ".e."), List.of("bed"));
    }
}

class Ex5_3_13Test {
    public static void run() {
        Check.eq(Ch5_3Tries.substringChecks("banana", new String[] {"nan", "ana", "nab", ""}), new boolean[] {true, true, false, true});
        Check.eq(Ch5_3Tries.substringChecks("banana", new String[] {"banana", "bananas", "a"}), new boolean[] {true, false, true});
        Check.eq(Ch5_3Tries.substringChecks("", new String[] {""}), new boolean[] {true});
        Check.eq(Ch5_3Tries.substringChecks("", new String[] {"a"}), new boolean[] {false});
    }
}

class Ex5_3_14Test {
    public static void run() {
        Check.eq(Ch5_3Tries.shortestUniquePrefixes(new String[] {"zebra", "dog", "duck", "dove"}), List.of("z", "dog", "du", "dov"));
        Check.eq(Ch5_3Tries.shortestUniquePrefixes(new String[] {"a", "b"}), List.of("a", "b"));
        Check.eq(Ch5_3Tries.shortestUniquePrefixes(new String[] {"abc"}), List.of("a"));
        Check.eq(Ch5_3Tries.shortestUniquePrefixes(new String[] {"ab", "ac", "bd"}), List.of("ab", "ac", "b"));
        Check.eq(Ch5_3Tries.shortestUniquePrefixes(new String[0]), List.of());
    }
}

class Ex5_3_15Test {
    public static void run() {
        String[] words = {"good", "home", "gone", "hood", "hoof", "in"};
        Check.eq(Ch5_3Tries.keypadWords("4663", words), List.of("gone", "good", "home", "hood", "hoof"));
        Check.eq(Ch5_3Tries.keypadWords("46", words), List.of("in"));
        Check.eq(Ch5_3Tries.keypadWords("2", new String[] {"a", "b", "ab"}), List.of("a", "b"));
        Check.eq(Ch5_3Tries.keypadWords("", new String[] {"x"}), List.of());
        Check.eq(Ch5_3Tries.keypadWords("9", words), List.of());
    }
}

class Ex5_3_16Test {
    public static void run() {
        String[] words = {"car", "cat", "core", "tea", "rat", "bin", "rob", "cab", "tin", "ore", "rare"};
        Check.eq(Ch5_3Tries.boardWords(new String[] {"cat", "ore", "bin"}, words), List.of("bin", "car", "cat", "core", "ore", "rat", "rob", "tea"));
        Check.eq(Ch5_3Tries.boardWords(new String[] {"aa"}, new String[] {"aaa", "aa", "a"}), List.of("a", "aa"));
        Check.eq(Ch5_3Tries.boardWords(new String[0], new String[] {"a"}), List.of());
        Check.eq(Ch5_3Tries.boardWords(new String[] {"ab", "cd"}, new String[] {"abdc", "acdb", "adcb", "bad", "abca"}), List.of("abdc", "acdb", "adcb", "bad"));
    }
}
