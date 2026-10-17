import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.function.Function;

/** Chapter 24: Caches and eviction policies. */
public class Ch24Caching {

    // ==== EX 24.1 | LRU cache from the standard library | Core
    // PROMPT: Write `interface Cache<K, V>` with `V get(K key)` (returns `null` on a miss) and `void put(K key, V value)`, then `static class LRUCache<K, V>` that evicts the least recently used key. Back it with a `LinkedHashMap` built with `accessOrder = true`, evicting `keySet().iterator().next()` when over capacity.
    // EXAMPLE: capacity 2: put a, put b, get a, put c -> b is evicted; get b is `null`
    // BIGO: O(1) per operation.
    // NOTE: With `accessOrder = true`, every `get` moves the key to the end, so the first key in iteration order is always the least recently used.
    interface Cache<K, V> {
        V get(K key);

        void put(K key, V value);
    }

    static class LRUCache<K, V> implements Cache<K, V> {
        private final int capacity;
        private final LinkedHashMap<K, V> data = new LinkedHashMap<>(16, 0.75f, true);

        LRUCache(int capacity) { throw new UnsupportedOperationException(); }

        public V get(K key) { throw new UnsupportedOperationException(); }

        public void put(K key, V value) {
            throw new UnsupportedOperationException();
        }
    }
    // ==== END

    // ==== EX 24.2 | LRU from a hash table and a doubly linked list | Core
    // PROMPT: Build `static class LinkedLRU<K, V> implements Cache<K, V>` without LinkedHashMap: a `HashMap` from key to node, plus a doubly linked list with head and tail sentinels. Most recent sits next to head; evict from next to tail.
    // EXAMPLE: Same behaviour as 24.1
    // BIGO: O(1) per get and put: the map finds the node, the links let it move without shifting.
    // NOTE: Sentinel nodes remove every "is the list empty?" special case from insert and unlink. This is how `LinkedHashMap` itself works.
    static class LinkedLRU<K, V> implements Cache<K, V> {
        private static final class Node<K, V> {
            K key;
            V value;
            Node<K, V> prev, next;
        }

        private final int capacity;
        private final Map<K, Node<K, V>> map = new HashMap<>();
        private final Node<K, V> head = new Node<>(), tail = new Node<>();

        LinkedLRU(int capacity) {
            throw new UnsupportedOperationException();
        }

        private void unlink(Node<K, V> n) {
            throw new UnsupportedOperationException();
        }

        private void pushFront(Node<K, V> n) {
            throw new UnsupportedOperationException();
        }

        public V get(K key) {
            throw new UnsupportedOperationException();
        }

        public void put(K key, V value) {
            throw new UnsupportedOperationException();
        }
    }
    // ==== END

    // ==== EX 24.3 | Measure a hit rate | Core
    // PROMPT: Write `static <K> double hitRate(Cache<K, Boolean> cache, List<K> requests)` that, for each requested key, counts a hit when `get` finds it and otherwise `put`s it. Return hits / requests.
    // EXAMPLE: `hitRate(new LRUCache<>(2), [a, b, a, a, c, b])` -> `0.333...` (2 hits in 6)
    // BIGO: O(R) for R requests.
    static <K> double hitRate(Cache<K, Boolean> cache, List<K> requests) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 24.4 | FIFO eviction for comparison | Core
    // PROMPT: Write `static class FIFOCache<K, V> implements Cache<K, V>` that evicts the oldest inserted key regardless of use. Compare its hit rate with LRU on a stream that reuses a few hot keys.
    // EXAMPLE: hot keys reused constantly -> LRU's hit rate is higher than FIFO's
    // BIGO: O(1) per operation with an `ArrayDeque` of insertion order.
    static class FIFOCache<K, V> implements Cache<K, V> {
        private final int capacity;
        private final Map<K, V> data = new HashMap<>();
        private final Deque<K> order = new ArrayDeque<>();

        FIFOCache(int capacity) { throw new UnsupportedOperationException(); }

        public V get(K key) { throw new UnsupportedOperationException(); }

        public void put(K key, V value) {
            throw new UnsupportedOperationException();
        }
    }
    // ==== END

    // ==== EX 24.5 | Random eviction in O(1) | Core
    // PROMPT: Write `static class RandomCache<K, V> implements Cache<K, V>` that evicts a uniformly random key. Keep keys in an `ArrayList` plus a map of key to index; remove by moving the last key into the victim's slot.
    // EXAMPLE: capacity 3 never holds more than 3 keys; which key goes depends on the seed
    // BIGO: O(1) per operation.
    static class RandomCache<K, V> implements Cache<K, V> {
        private final int capacity;
        private final Random rng;
        private final Map<K, V> data = new HashMap<>();
        private final List<K> keys = new ArrayList<>();
        private final Map<K, Integer> pos = new HashMap<>();

        RandomCache(int capacity, Random rng) {
            throw new UnsupportedOperationException();
        }

        int size() { throw new UnsupportedOperationException(); }

        public V get(K key) { throw new UnsupportedOperationException(); }

        public void put(K key, V value) {
            throw new UnsupportedOperationException();
        }
    }
    // ==== END

    // ==== EX 24.6 | LRU's worst case, fixed by randomness | Practice
    // PROMPT: Write `static List<Integer> cyclicRequests(int capacity, int rounds)` that cycles through capacity + 1 keys. Show LRU's hit rate on it is 0, while `RandomCache` keeps a healthy share of hits.
    // EXAMPLE: capacity 10, 100 rounds -> LRU `0.0`; random eviction (seed 1) well above `0.5`
    // BIGO: O(R). Every request evicts the very key that will be needed next, the textbook LRU pathology.
    static List<Integer> cyclicRequests(int capacity, int rounds) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 24.7 | A bounded memoizing wrapper | Practice
    // PROMPT: Write `static class Memo<A, R> implements Function<A, R>` that wraps a function, caches results in your `LRUCache` capped at `maxsize`, and counts `hits` and `misses`.
    // EXAMPLE: wrap a slow `square(x)`, call it with 1, 2, 1 -> hits `1`, misses `2`
    // BIGO: O(1) bookkeeping per call; memory is capped at maxsize entries, unlike an unbounded `HashMap` memo.
    // NOTE: Store results wrapped in an `Optional` so a function that returns `null` still counts as a hit next time.
    static class Memo<A, R> implements Function<A, R> {
        private final Function<A, R> fn;
        private final LRUCache<A, java.util.Optional<R>> cache;
        int hits, misses;

        Memo(Function<A, R> fn, int maxsize) {
            throw new UnsupportedOperationException();
        }

        public R apply(A arg) {
            throw new UnsupportedOperationException();
        }
    }
    // ==== END

    // ==== EX 24.8 | Cache-friendly traversal order | Core
    // PROMPT: Write `static long sumRowsFirst(int[][] grid)` and `static long sumColumnsFirst(int[][] grid)`, then `static int[][] blockedTranspose(int[][] m, int block)` that copies the matrix tile by tile. All must give correct results; time them on a 4000 by 4000 grid.
    // EXAMPLE: both sums of `{{1, 2}, {3, 4}}` -> `10`; `blockedTranspose({{1, 2, 3}, {4, 5, 6}}, 2)` -> `[[1, 4], [2, 5], [3, 6]]`
    // BIGO: All O(R * C) steps. Row-first walks each `int[]` row in order (spatial locality); column-first jumps to a different row array on every step and is often several times slower in Java.
    static long sumRowsFirst(int[][] grid) {
        throw new UnsupportedOperationException();
    }

    static long sumColumnsFirst(int[][] grid) {
        throw new UnsupportedOperationException();
    }

    static int[][] blockedTranspose(int[][] m, int block) {
        throw new UnsupportedOperationException();
    }
    // ==== END
}
