import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

/** Chapter 41: Hash tables. */
public class Ch41HashTables {

    // ==== EX 41.1 | Build a hash table with chaining | Core
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

    // ==== EX 41.2 | Build a word from letter tiles | Core
    // PROMPT: Write `static boolean canBuild(String word, String tiles)`: each character of `tiles` can be used once. Count the tiles in a `HashMap`, then spend them on the word.
    // EXAMPLE: `"abba"`, `"aabbc"` -> `true`; `"abc"`, `"ab"` -> `false`
    // BIGO: O(N + M): count the tiles once, then spend them. Nested loops would be O(N * M).
    static boolean canBuild(String word, String tiles) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 41.3 | Values in exactly one list | Core
    // PROMPT: Write `static List<Integer> inExactlyOne(int[] a, int[] b)` returning the values that appear in one array but not the other: first those from `a` in `a`'s order, then those from `b` in `b`'s order, each once.
    // EXAMPLE: `{1, 2, 3}`, `{2, 3, 4}` -> `[1, 4]`
    // BIGO: O(N + M) with two sets, versus O(N * M) checking each value against the other list.
    static List<Integer> inExactlyOne(int[] a, int[] b) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 41.4 | Distinct visitors per day | Core
    // PROMPT: Visit `i` was on day `days[i]` by user `users[i]`. Write `static Map<Integer, Integer> distinctPerDay(int[] days, String[] users)` returning each day's number of different users.
    // EXAMPLE: `{1, 1, 1, 2}`, `{"ana", "bo", "ana", "ana"}` -> `{1=2, 2=1}`
    // BIGO: O(N): one set of visitors per day, one insert per visit.
    static Map<Integer, Integer> distinctPerDay(int[] days, String[] users) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 41.5 | Same letter pattern | Practice
    // PROMPT: Write `static boolean samePattern(String a, String b)`: `true` when the letters of `a` can be renamed one-to-one to give `b` (equal letters stay equal, different letters stay different).
    // EXAMPLE: `"egg"`, `"add"` -> `true`; `"foo"`, `"bar"` -> `false`
    // BIGO: O(N) with two lookup tables, one for each direction.
    static boolean samePattern(String a, String b) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 41.6 | Every position of each value | Core
    // PROMPT: Write `static Map<String, List<Integer>> positions(String[] items)` returning each value's indexes, in increasing order.
    // EXAMPLE: `{"a", "b", "a"}` -> `{a=[0, 2], b=[1]}`
    // BIGO: O(N): one append per item.
    static Map<String, List<Integer>> positions(String[] items) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 41.7 | Word frequency | Core
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

    // ==== EX 41.8 | Group anagrams | Practice
    // PROMPT: Write `static List<List<String>> groupAnagrams(String[] words)` returning lists of words that are anagrams of each other (groups in first-seen order).
    // EXAMPLE: `{"eat", "tea", "tan", "ate", "nat", "bat"}` -> `[[eat, tea, ate], [tan, nat], [bat]]`
    // BIGO: O(N * K log K) for N words of length K: the sorted letters are the hash key.
    static List<List<String>> groupAnagrams(String[] words) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 41.9 | Two sum with a lookup table | Core
    // PROMPT: Write `static int[] twoSumIndices(int[] nums, int target)` returning the indices `{i, j}` of two numbers that add to `target`, or `null`.
    // EXAMPLE: `{2, 7, 11, 15}`, target `9` -> `[0, 1]`
    // BIGO: O(N) time, O(N) space; nested loops would be O(N^2).
    static int[] twoSumIndices(int[] nums, int target) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 41.10 | Invert a lookup table | Practice
    // PROMPT: Write `static Map<Integer, List<String>> invert(Map<String, Integer> menu)` turning `{item: price}` into `{price: [items]}` so you can look up everything at a price in one step.
    // EXAMPLE: `{fries=2, soda=2, burger=5}` -> `{2=[fries, soda], 5=[burger]}`
    // BIGO: O(N) to build; every later lookup by price is O(1).
    // NOTE: A hash table is one-directional: fast from key to value, slow from value to key. Build a second table when you need both.
    static Map<Integer, List<String>> invert(Map<String, Integer> menu) {
        throw new UnsupportedOperationException();
    }
    // ==== END
}
