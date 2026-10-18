import java.util.List;

/** Chapter 53 tests, one class per exercise. */

final class Ch53TriesTest {
    private Ch53TriesTest() {}

    static Ch53Tries.Trie trie(String... words) {
        Ch53Tries.Trie t = new Ch53Tries.Trie();
        for (String w : words) t.insert(w);
        return t;
    }
}

class Ex53_1Test {
    public static void run() {
        Ch53Tries.Trie t = Ch53TriesTest.trie("pin", "pit");
        Check.eq(t.root.children.keySet().toString(), "[p]");
        Check.eq(t.root.children.get('p').children.get('i').children.keySet().toString(), "[n, t]");
        Check.yes(t.root.children.get('p').children.get('i').children.get('n').end);
        Check.no(t.root.children.get('p').children.get('i').end);
    }
}

class Ex53_2Test {
    public static void run() {
        Ch53Tries.Trie t = Ch53TriesTest.trie("pin", "pit");
        Check.yes(t.search("pi") != null);
        Check.eq(t.search("po"), null);
    }
}

class Ex53_3Test {
    public static void run() {
        Ch53Tries.Trie t = Ch53TriesTest.trie("pin", "pit");
        Check.yes(t.containsWord("pin"));
        Check.no(t.containsWord("pi"));
    }
}

class Ex53_4Test {
    public static void run() {
        Ch53Tries.Trie t = Ch53TriesTest.trie("pin", "pit", "sun");
        Check.eq(t.collectAllWords(t.root), List.of("pin", "pit", "sun"));
        Ch53Tries.Trie empty = new Ch53Tries.Trie();
        Check.eq(empty.collectAllWords(empty.root), List.of());
    }
}

class Ex53_5Test {
    public static void run() {
        Ch53Tries.Trie t = Ch53TriesTest.trie("pin", "pinch", "pit", "sun");
        Check.eq(t.autocomplete("pin"), List.of("pin", "pinch"));
        Check.eq(t.autocomplete("x"), List.of());
    }
}

class Ex53_6Test {
    public static void run() {
        Check.eq(Ch53TriesTest.trie("pie", "pin").allKeys(), List.of('p', 'i', 'e', 'n'));
    }
}

class Ex53_7Test {
    public static void run() {
        Check.eq(Ch53TriesTest.trie("pine", "pint", "pinto").longestCommonPrefix(), "pin");
        Check.eq(Ch53TriesTest.trie("pin", "pinch").longestCommonPrefix(), "pin");
        Check.eq(Ch53TriesTest.trie("sun").longestCommonPrefix(), "sun");
        Check.eq(Ch53TriesTest.trie("pin", "sun").longestCommonPrefix(), "");
        Check.eq(new Ch53Tries.Trie().longestCommonPrefix(), "");
    }
}

class Ex53_8Test {
    public static void run() {
        Ch53Tries.RankedTrie rt = new Ch53Tries.RankedTrie();
        rt.insert("pinch", 9);
        rt.insert("pin", 5);
        rt.insert("pinball", 7);
        Check.eq(rt.autocomplete("pin", 2), List.of("pinch", "pinball"));
        Check.eq(rt.autocomplete("pin", 9), List.of("pinch", "pinball", "pin"));
    }
}

class Ex53_9Test {
    public static void run() {
        Ch53Tries.Trie t = Ch53TriesTest.trie("pin", "pinch");
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

class Ex53_10Test {
    public static void run() {
        Check.eq(Ch53Tries.prefixCounts(new String[] {"car", "card", "care", "dog"}, new String[] {"car", "ca", "d", "x"}), new int[] {3, 3, 1, 0});
        Check.eq(Ch53Tries.prefixCounts(new String[] {"a", "a", "ab"}, new String[] {"a", "ab", "abc", ""}), new int[] {3, 1, 0, 3});
        Check.eq(Ch53Tries.prefixCounts(new String[0], new String[] {"a"}), new int[] {0});
    }
}

class Ex53_11Test {
    public static void run() {
        Check.eq(Ch53Tries.trieSort(new String[] {"pear", "apple", "pea", "app"}), List.of("app", "apple", "pea", "pear"));
        Check.eq(Ch53Tries.trieSort(new String[0]), List.of());
        Check.eq(Ch53Tries.trieSort(new String[] {"b", "a", "b"}), List.of("a", "b", "b"));
        Check.eq(Ch53Tries.trieSort(new String[] {"ba", "b", "abc", "ab"}), List.of("ab", "abc", "b", "ba"));
    }
}

class Ex53_12Test {
    public static void run() {
        String[] words = {"bad", "bed", "bid", "bud", "bead", "bad"};
        Check.eq(Ch53Tries.wildcardMatches(words, "b.d"), List.of("bad", "bed", "bid", "bud"));
        Check.eq(Ch53Tries.wildcardMatches(words, ".."), List.of());
        Check.eq(Ch53Tries.wildcardMatches(words, "b..d"), List.of("bead"));
        Check.eq(Ch53Tries.wildcardMatches(words, "bad"), List.of("bad"));
        Check.eq(Ch53Tries.wildcardMatches(words, ".e."), List.of("bed"));
    }
}

class Ex53_13Test {
    public static void run() {
        Check.eq(Ch53Tries.substringChecks("banana", new String[] {"nan", "ana", "nab", ""}), new boolean[] {true, true, false, true});
        Check.eq(Ch53Tries.substringChecks("banana", new String[] {"banana", "bananas", "a"}), new boolean[] {true, false, true});
        Check.eq(Ch53Tries.substringChecks("", new String[] {""}), new boolean[] {true});
        Check.eq(Ch53Tries.substringChecks("", new String[] {"a"}), new boolean[] {false});
    }
}

class Ex53_14Test {
    public static void run() {
        Check.eq(Ch53Tries.shortestUniquePrefixes(new String[] {"zebra", "dog", "duck", "dove"}), List.of("z", "dog", "du", "dov"));
        Check.eq(Ch53Tries.shortestUniquePrefixes(new String[] {"a", "b"}), List.of("a", "b"));
        Check.eq(Ch53Tries.shortestUniquePrefixes(new String[] {"abc"}), List.of("a"));
        Check.eq(Ch53Tries.shortestUniquePrefixes(new String[] {"ab", "ac", "bd"}), List.of("ab", "ac", "b"));
        Check.eq(Ch53Tries.shortestUniquePrefixes(new String[0]), List.of());
    }
}

class Ex53_15Test {
    public static void run() {
        String[] words = {"good", "home", "gone", "hood", "hoof", "in"};
        Check.eq(Ch53Tries.keypadWords("4663", words), List.of("gone", "good", "home", "hood", "hoof"));
        Check.eq(Ch53Tries.keypadWords("46", words), List.of("in"));
        Check.eq(Ch53Tries.keypadWords("2", new String[] {"a", "b", "ab"}), List.of("a", "b"));
        Check.eq(Ch53Tries.keypadWords("", new String[] {"x"}), List.of());
        Check.eq(Ch53Tries.keypadWords("9", words), List.of());
    }
}

class Ex53_16Test {
    public static void run() {
        String[] words = {"car", "cat", "core", "tea", "rat", "bin", "rob", "cab", "tin", "ore", "rare"};
        Check.eq(Ch53Tries.boardWords(new String[] {"cat", "ore", "bin"}, words), List.of("bin", "car", "cat", "core", "ore", "rat", "rob", "tea"));
        Check.eq(Ch53Tries.boardWords(new String[] {"aa"}, new String[] {"aaa", "aa", "a"}), List.of("a", "aa"));
        Check.eq(Ch53Tries.boardWords(new String[0], new String[] {"a"}), List.of());
        Check.eq(Ch53Tries.boardWords(new String[] {"ab", "cd"}, new String[] {"abdc", "acdb", "adcb", "bad", "abca"}), List.of("abdc", "acdb", "adcb", "bad"));
    }
}
