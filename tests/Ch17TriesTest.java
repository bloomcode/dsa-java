import java.util.List;

/** Chapter 17 tests, one class per exercise. */
final class Ch17TriesTest {
    private Ch17TriesTest() {}

    static Ch17Tries.Trie trie(String... words) {
        Ch17Tries.Trie t = new Ch17Tries.Trie();
        for (String w : words) t.insert(w);
        return t;
    }
}

class Ex17_1Test {
    public static void run() {
        Ch17Tries.Trie t = Ch17TriesTest.trie("cat", "cab");
        Check.eq(t.root.children.keySet().toString(), "[c]");
        Check.eq(t.root.children.get('c').children.get('a').children.keySet().toString(), "[t, b]");
        Check.yes(t.root.children.get('c').children.get('a').children.get('t').end);
        Check.no(t.root.children.get('c').children.get('a').end);
    }
}

class Ex17_2Test {
    public static void run() {
        Ch17Tries.Trie t = Ch17TriesTest.trie("cat", "cab");
        Check.yes(t.search("ca") != null);
        Check.eq(t.search("co"), null);
    }
}

class Ex17_3Test {
    public static void run() {
        Ch17Tries.Trie t = Ch17TriesTest.trie("cat", "cab");
        Check.yes(t.containsWord("cat"));
        Check.no(t.containsWord("ca"));
    }
}

class Ex17_4Test {
    public static void run() {
        Ch17Tries.Trie t = Ch17TriesTest.trie("cat", "cab", "dog");
        Check.eq(t.collectAllWords(t.root), List.of("cat", "cab", "dog"));
        Ch17Tries.Trie empty = new Ch17Tries.Trie();
        Check.eq(empty.collectAllWords(empty.root), List.of());
    }
}

class Ex17_5Test {
    public static void run() {
        Ch17Tries.Trie t = Ch17TriesTest.trie("cat", "catnip", "cab", "dog");
        Check.eq(t.autocomplete("cat"), List.of("cat", "catnip"));
        Check.eq(t.autocomplete("x"), List.of());
    }
}

class Ex17_6Test {
    public static void run() {
        Check.eq(Ch17TriesTest.trie("can", "cat").allKeys(), List.of('c', 'a', 'n', 't'));
    }
}

class Ex17_7Test {
    public static void run() {
        Ch17Tries.Trie t = Ch17TriesTest.trie("cat", "catnap", "catnip");
        Check.eq(t.autocorrect("catnar"), "catnap");
        Check.eq(t.autocorrect("cat"), "cat");
        Check.eq(t.autocorrect("zebra"), "cat");
    }
}

class Ex17_8Test {
    public static void run() {
        Ch17Tries.RankedTrie rt = new Ch17Tries.RankedTrie();
        rt.insert("catnip", 9);
        rt.insert("cat", 5);
        rt.insert("catalog", 7);
        Check.eq(rt.autocomplete("cat", 2), List.of("catnip", "catalog"));
        Check.eq(rt.autocomplete("cat", 9), List.of("catnip", "catalog", "cat"));
    }
}

class Ex17_9Test {
    public static void run() {
        Ch17Tries.Trie t = Ch17TriesTest.trie("cat", "catnip");
        Check.yes(t.delete("catnip"));
        Check.yes(t.containsWord("cat"));
        Check.no(t.containsWord("catnip"));
        Check.yes(t.search("cat").children.isEmpty());
        Check.no(t.delete("dog"));
        Check.no(t.delete("ca"));
        Check.yes(t.delete("cat"));
        Check.yes(t.root.children.isEmpty());
    }
}
