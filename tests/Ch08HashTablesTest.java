import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

/** Chapter 8 tests, one class per exercise. */
class Ex8_1Test {
    public static void run() {
        Ch08HashTables.HashTable<String, String> t = new Ch08HashTables.HashTable<>();
        t.put("bad", "evil");
        Check.eq(t.get("bad"), "evil");
        t.put("bad", "awful");
        Check.eq(t.get("bad"), "awful");
        Check.eq(t.size(), 1);
        Check.throwsEx(NoSuchElementException.class, () -> t.get("good"));
        Ch08HashTables.HashTable<Integer, Integer> big = new Ch08HashTables.HashTable<>(2);
        for (int i = -500; i < 500; i++) big.put(i, i * i);
        Check.eq(big.size(), 1000);
        Check.yes(big.bucketCount() >= 1000 / 0.75);
        Check.eq(big.get(-321), 103041);
        Check.yes(big.delete(-321));
        Check.no(big.delete(-321));
        Check.no(big.containsKey(-321));
        Check.eq(big.size(), 999);
    }
}

class Ex8_2Test {
    public static void run() {
        Check.yes(Ch08HashTables.isSubset(new String[]{"b", "d"}, new String[]{"a", "b", "c", "d"}));
        Check.no(Ch08HashTables.isSubset(new String[]{"b", "z"}, new String[]{"a", "b", "c", "d"}));
    }
}

class Ex8_3Test {
    public static void run() {
        Check.eq(Ch08HashTables.intersection(new int[]{1, 2, 3, 4, 5}, new int[]{0, 2, 4, 6, 8}), List.of(2, 4));
        Check.eq(Ch08HashTables.intersection(new int[]{2, 2, 4}, new int[]{2, 4}), List.of(2, 4));
    }
}

class Ex8_4Test {
    public static void run() {
        Check.eq(Ch08HashTables.firstDuplicate(new String[]{"a", "b", "c", "d", "c", "e", "f"}), "c");
        Check.eq(Ch08HashTables.firstDuplicate(new String[]{"a"}), null);
    }
}

class Ex8_5Test {
    public static void run() {
        Check.eq(Ch08HashTables.missingLetter("the quick brown box jumps over a lazy dog"), 'f');
    }
}

class Ex8_6Test {
    public static void run() {
        Check.eq(Ch08HashTables.firstUniqueChar("minimum"), 'n');
        Check.eq(Ch08HashTables.firstUniqueChar("aa"), null);
    }
}

class Ex8_7Test {
    public static void run() {
        Check.eq(Ch08HashTables.wordCounts("the cat and the hat").toString(), "{the=2, cat=1, and=1, hat=1}");
        Check.eq(Ch08HashTables.mostCommonWord("the cat and the hat"), "the");
    }
}

class Ex8_8Test {
    public static void run() {
        Check.eq(Ch08HashTables.groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}),
                List.of(List.of("eat", "tea", "ate"), List.of("tan", "nat"), List.of("bat")));
    }
}

class Ex8_9Test {
    public static void run() {
        Check.eq(Ch08HashTables.twoSumIndices(new int[]{2, 7, 11, 15}, 9), new int[]{0, 1});
        Check.eq(Ch08HashTables.twoSumIndices(new int[]{2, 7}, 4), null);
        Check.eq(Ch08HashTables.twoSumIndices(new int[]{3, 3}, 6), new int[]{0, 1});
    }
}

class Ex8_10Test {
    public static void run() {
        Map<String, Integer> menu = new LinkedHashMap<>();
        menu.put("fries", 2);
        menu.put("soda", 2);
        menu.put("burger", 5);
        Check.eq(Ch08HashTables.invert(menu).toString(), "{2=[fries, soda], 5=[burger]}");
    }
}
