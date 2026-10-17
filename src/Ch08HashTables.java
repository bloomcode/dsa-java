import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

/** Chapter 8: Hash tables and constant-time lookup. */
public class Ch08HashTables {

    // ==== EX 8.1 | Build a hash table with chaining | Core
    // PROMPT: Build `static class HashTable<K, V>` on a list of buckets, each a list of key-value entries. Implement `put`, `get` (throw `NoSuchElementException` if missing), `delete`, `containsKey` and `size`. Double the bucket count when the load factor passes 0.75.
    // EXAMPLE: `t.put("bad", "evil"); t.get("bad")` -> `"evil"`; putting the same key again overwrites it
    // BIGO: O(1) average for put, get and delete; O(N) worst case if every key collides into one bucket. A resize is O(N), but rare, so O(1) amortized.
    // NOTE: Use `Math.floorMod(key.hashCode(), buckets.size())`: `hashCode()` can be negative, and `%` would then give a negative index.
    static class HashTable<K, V> {
        private static final class Entry<K, V> {
            final K key;
            V value;

            Entry(K key, V value) {
                throw new UnsupportedOperationException();
            }
        }

        private List<List<Entry<K, V>>> buckets;
        private int count;

        HashTable() { this(8); throw new UnsupportedOperationException(); }

        HashTable(int capacity) { throw new UnsupportedOperationException(); }

        private static <K, V> List<List<Entry<K, V>>> emptyBuckets(int n) {
            throw new UnsupportedOperationException();
        }

        private List<Entry<K, V>> bucket(K key) {
            throw new UnsupportedOperationException();
        }

        void put(K key, V value) {
            throw new UnsupportedOperationException();
        }

        V get(K key) {
            throw new UnsupportedOperationException();
        }

        boolean delete(K key) {
            throw new UnsupportedOperationException();
        }

        boolean containsKey(K key) {
            throw new UnsupportedOperationException();
        }

        int size() { throw new UnsupportedOperationException(); }

        int bucketCount() { throw new UnsupportedOperationException(); }

        private void resize() {
            throw new UnsupportedOperationException();
        }
    }
    // ==== END

    // ==== EX 8.2 | Is one array a subset of another? | Core
    // PROMPT: Write `static boolean isSubset(String[] small, String[] big)` returning `true` if every value in `small` appears in `big`.
    // EXAMPLE: `{"b", "d"}`, `{"a", "b", "c", "d"}` -> `true`
    // BIGO: O(N + M) with a hash table, versus O(N * M) with nested loops.
    static boolean isSubset(String[] small, String[] big) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 8.3 | Intersection in linear time | Core
    // PROMPT: Write `static List<Integer> intersection(int[] a, int[] b)` returning values present in both, in the order they appear in `a`, each once.
    // EXAMPLE: `{1, 2, 3, 4, 5}`, `{0, 2, 4, 6, 8}` -> `[2, 4]`
    // BIGO: O(N + M). Compare with 6.3's O(N * M).
    static List<Integer> intersection(int[] a, int[] b) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 8.4 | First duplicate string | Core
    // PROMPT: Write `static String firstDuplicate(String[] words)` returning the first word seen a second time, or `null`.
    // EXAMPLE: `{"a", "b", "c", "d", "c", "e", "f"}` -> `"c"`
    // BIGO: O(N).
    static String firstDuplicate(String[] words) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 8.5 | The missing letter | Practice
    // PROMPT: A string contains every letter a-z except one. Write `static Character missingLetter(String s)` to find it.
    // EXAMPLE: `"the quick brown box jumps over a lazy dog"` -> `'f'`
    // BIGO: O(N): one pass to record letters, then a fixed 26 checks.
    // NOTE: For lowercase letters a `boolean[26]` indexed by `ch - 'a'` is a perfect hash table: no hashing, no boxing.
    static Character missingLetter(String s) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 8.6 | First non-repeated character | Core
    // PROMPT: Write `static Character firstUniqueChar(String s)` returning the first character that appears exactly once, or `null`.
    // EXAMPLE: `"minimum"` -> `'n'`
    // BIGO: O(N): two passes, counting then checking.
    static Character firstUniqueChar(String s) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 8.7 | Word frequency | Core
    // PROMPT: Write `static Map<String, Integer> wordCounts(String text)` mapping each lowercase word to its count, and `static String mostCommonWord(String text)`.
    // EXAMPLE: `"the cat and the hat"` -> `{the=2, cat=1, and=1, hat=1}`, most common `"the"`
    // BIGO: O(N) in the number of words.
    static Map<String, Integer> wordCounts(String text) {
        throw new UnsupportedOperationException();
    }

    static String mostCommonWord(String text) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 8.8 | Group anagrams | Practice
    // PROMPT: Write `static List<List<String>> groupAnagrams(String[] words)` returning lists of words that are anagrams of each other (groups in first-seen order).
    // EXAMPLE: `{"eat", "tea", "tan", "ate", "nat", "bat"}` -> `[[eat, tea, ate], [tan, nat], [bat]]`
    // BIGO: O(N * K log K) for N words of length K: the sorted letters are the hash key.
    static List<List<String>> groupAnagrams(String[] words) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 8.9 | Two sum with a lookup table | Core
    // PROMPT: Write `static int[] twoSumIndices(int[] nums, int target)` returning the indices `{i, j}` of two numbers that add to `target`, or `null`.
    // EXAMPLE: `{2, 7, 11, 15}`, target `9` -> `[0, 1]`
    // BIGO: O(N) time, O(N) space; nested loops would be O(N^2).
    static int[] twoSumIndices(int[] nums, int target) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 8.10 | Invert a lookup table | Practice
    // PROMPT: Write `static Map<Integer, List<String>> invert(Map<String, Integer> menu)` turning `{item: price}` into `{price: [items]}` so you can look up everything at a price in one step.
    // EXAMPLE: `{fries=2, soda=2, burger=5}` -> `{2=[fries, soda], 5=[burger]}`
    // BIGO: O(N) to build; every later lookup by price is O(1).
    // NOTE: A hash table is one-directional: fast from key to value, slow from value to key. Build a second table when you need both.
    static Map<Integer, List<String>> invert(Map<String, Integer> menu) {
        throw new UnsupportedOperationException();
    }
    // ==== END
}
