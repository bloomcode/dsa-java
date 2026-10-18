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

    // ==== EX 41.11 | Longest consecutive run | Practice
    // PROMPT: Write `static int longestConsecutive(int[] nums)` that returns the length of the longest run of consecutive integers found anywhere in `nums` (any order, repeats allowed), in O(N): put the values in a `HashSet` and count upward only from values whose predecessor is missing.
    // EXAMPLE: `[10, 4, 20, 1, 3, 2, 11]` -> `4` (1, 2, 3, 4)
    // BIGO: O(N) expected time and space: only a value with no predecessor starts a count, so every value is stepped over at most twice.
    static int longestConsecutive(int[] nums) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 41.12 | Does a stretch sum to zero? | Core
    // PROMPT: Write `static boolean hasZeroSumRun(int[] nums)`: `true` when some non-empty run of consecutive values sums to `0`. Keep a set of the prefix sums seen so far, starting with `0`; a repeated prefix sum means the values between the two sum to zero.
    // EXAMPLE: `[4, 2, -3, 1, 6]` -> `true` (`2, -3, 1`); `[4, 2, 1]` -> `false`
    // BIGO: O(N) expected time and space: a stretch sums to zero exactly when two prefix sums are equal, and a set spots the repeat.
    static boolean hasZeroSumRun(int[] nums) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 41.13 | Count stretches summing to k | Practice
    // PROMPT: Write `static int countSumRuns(int[] nums, int k)` that counts the non-empty runs of consecutive values summing to `k` (values may be negative), in O(N). Keep a map from each prefix sum to how often it has occurred, starting with `{0: 1}`; at each step add the count of `total - k`.
    // EXAMPLE: `[1, 2, 3, -2, 2], 3` -> `4` (`1, 2`; `3`; `2, 3, -2`; `3, -2, 2`)
    // BIGO: O(N) expected time and space: each prefix sum `p` pairs with every earlier prefix sum `p - k`, and a count table answers that in O(1).
    static int countSumRuns(int[] nums, int k) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 41.14 | Symmetric pairs | Core
    // PROMPT: `pairs` holds distinct pairs `{a, b}` with `a != b`. Write `static int[][] symmetricPairs(int[][] pairs)` that returns every pair whose reverse `{b, a}` also appears, once per couple: report the pair that came first, in the order the second one arrives.
    // EXAMPLE: `[[1, 2], [3, 4], [5, 6], [4, 3], [2, 1]]` -> `[[3, 4], [1, 2]]`
    // BIGO: O(N) expected time and space: one pass, checking each pair's reverse against the pairs already seen.
    static int[][] symmetricPairs(int[][] pairs) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 41.15 | Trace a journey from its tickets | Practice
    // PROMPT: `tickets` are `{origin, destination}` legs of one journey that visits no place twice, in shuffled order. Write `static List<String> traceJourney(String[][] tickets)` that returns the places in travel order (empty for no tickets). Map each origin to its destination; the start is the one origin that is nobody's destination.
    // EXAMPLE: `[["MAA", "BOM"], ["DEL", "MAA"], ["BOM", "GOI"]]` -> `["DEL", "MAA", "BOM", "GOI"]`
    // BIGO: O(N) expected time and space: one map from each origin to its destination, one set of destinations to find the start, then one walk.
    static List<String> traceJourney(String[][] tickets) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 41.16 | Do two arrays share a value? | Core
    // PROMPT: Write `static boolean disjoint(int[] a, int[] b)`: `true` when no value appears in both `a` and `b`. Build a `HashSet` from `a` and check each value of `b` against it.
    // EXAMPLE: `[1, 5, 9], [2, 6]` -> `true`; `[1, 5], [5]` -> `false`
    // BIGO: O(N + M) expected time, O(N) space: build a set from one array and probe it with the other.
    static boolean disjoint(int[] a, int[] b) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 41.17 | Most points on one line | Stretch
    // PROMPT: `points` are `{x, y}` integer pairs, possibly repeated. Write `static int mostOnALine(int[][] points)` that returns the largest number of them on one straight line. For each anchor point, count the other points by direction `(dx, dy)` reduced by their gcd with a fixed sign; copies of the anchor count on every line through it.
    // EXAMPLE: `[[0, 0], [1, 1], [2, 2], [3, 1], [0, 3]]` -> `3`
    // BIGO: O(N^2) expected time, O(N) space: for each anchor point, every other point's direction, reduced by the gcd, is a hash key for the line through both.
    // NOTE: Reducing `(dx, dy)` by their gcd and fixing the sign gives an exact key; a floating-point slope would make nearly equal slopes collide or differ.
    static int mostOnALine(int[][] points) {
        throw new UnsupportedOperationException();
    }

    static int gcd(int a, int b) { throw new UnsupportedOperationException(); }
    // ==== END
}
