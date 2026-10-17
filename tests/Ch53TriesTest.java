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
