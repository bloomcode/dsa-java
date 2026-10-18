import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.function.IntUnaryOperator;
import java.util.function.ToIntBiFunction;

/** Chapter 4.2: Hash functions. */
public class Ch4_2HashFunctions {

    // ==== EX 4.2.1 | A naive string hash and its collisions | Core
    // PROMPT: Write `static int sumHash(String s, int m)` that adds the character codes and takes `% m`. Show that every anagram collides.
    // EXAMPLE: `sumHash("stop", 101) == sumHash("pots", 101) && sumHash("pots", 101) == sumHash("tops", 101)` -> `true`
    // BIGO: O(len(s)). Ignoring position throws away most of the information in the key.
    static int sumHash(String s, int m) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 4.2.2 | Polynomial string hashing | Core
    // PROMPT: Write `static int polyHash(String s, int m)` with base 31, computing `(c0 * 31^(L-1) + c1 * 31^(L-2) + ...) % m` with Horner's rule, so character order matters.
    // EXAMPLE: `polyHash("stop", 1_000_000_007) != polyHash("pots", 1_000_000_007)` -> `true`
    // BIGO: O(len(s)).
    // NOTE: `String.hashCode()` is this same polynomial with base 31, computed in `int` and left to overflow instead of taking a modulus.
    static int polyHash(String s, int m) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 4.2.3 | The division method and a bad table size | Core
    // PROMPT: Write `static int divisionHash(int k, int m)` = `k % m` and `static <K> int bucketsUsed(List<K> keys, int m, ToIntBiFunction<K, Integer> hashFn)`. Hash the keys 0, 8, 16, ..., 7992 into m = 64 and into m = 61 and count how many buckets each uses.
    // EXAMPLE: m = 64 -> only `8` buckets used; m = 61 (a prime) -> all `61` used
    // BIGO: O(1) per key. Keys that share a factor with m crowd into few buckets; a prime m not near a power of two avoids the most common patterns.
    static int divisionHash(int k, int m) {
        throw new UnsupportedOperationException();
    }

    static <K> int bucketsUsed(List<K> keys, int m, ToIntBiFunction<K, Integer> hashFn) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 4.2.4 | Measure a hash function's spread | Core
    // PROMPT: Write `static <K> int maxBucket(List<K> keys, int m, ToIntBiFunction<K, Integer> hashFn)` returning the size of the fullest bucket. A good function keeps it close to keys.size() / m.
    // EXAMPLE: 10,000 words into 1,000 buckets with `polyHash` -> a fullest bucket around 20 to 25; with `sumHash`, more than twice that, because letter sums crowd into a narrow band of values
    // BIGO: O(N). The fullest bucket bounds the worst lookup time with chaining.
    static <K> int maxBucket(List<K> keys, int m, ToIntBiFunction<K, Integer> hashFn) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 4.2.5 | Universal hashing | Core
    // PROMPT: Write `static class UniversalHash implements IntUnaryOperator` that picks random a in [1, p - 1] and b in [0, p - 1] once, with p = 2^61 - 1, and hashes an integer k as `((a * k + b) mod p) mod m`.
    // EXAMPLE: two instances with different seeds send the same key to different buckets; any fixed pair of keys collides with probability about 1 / m
    // BIGO: O(1) per key. Because the function is chosen at random after the keys are fixed, no input can be bad for most choices.
    // NOTE: `a * k` needs up to 92 bits. `Math.multiplyHigh` gives the top 64 bits of the product, and because 2^61 is 1 mod p, the reduction is a few shifts and adds: no `BigInteger` needed.
    static final long P = (1L << 61) - 1;

    static long mulModP(long a, long b) {
        throw new UnsupportedOperationException();
    }

    static class UniversalHash implements IntUnaryOperator {
        final int m;
        final long a, b;

        UniversalHash(int m, Random rng) {
            throw new UnsupportedOperationException();
        }

        public int applyAsInt(int k) {
            throw new UnsupportedOperationException();
        }
    }
    // ==== END

    // ==== EX 4.2.6 | Adversarial keys break a fixed function | Practice
    // PROMPT: Write `static List<Integer> adversarialKeys(int m, int count)` returning keys that all collide under `k % m` (multiples of m), and `static int fullest(List<Integer> keys, IntUnaryOperator fn)`. Compare the division method with `UniversalHash`.
    // EXAMPLE: m = 1,000, 5,000 keys -> division method `5000` in one bucket; universal hash about `15`
    // BIGO: Fixed function: O(N) per lookup on these keys. Universal: O(1 + N/m) expected on any keys.
    static List<Integer> adversarialKeys(int m, int count) {
        throw new UnsupportedOperationException();
    }

    static int fullest(List<Integer> keys, IntUnaryOperator fn) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 4.2.7 | A hash table that re-randomizes when it grows | Practice
    // PROMPT: Write `static class RandomizedHashTable` with chaining over `int` keys and `String` values: `put`, `get` (`null` when missing), `size` and `longestChain`. When the load factor passes 1, double the bucket count and draw a fresh `UniversalHash` before rehashing.
    // EXAMPLE: insert 10,000 adversarial keys -> every value is found and the fullest bucket stays small
    // BIGO: O(1) expected per operation, O(1) amortized for resizing.
    static class RandomizedHashTable {
        private record Entry(int key, String value) {}

        private final Random rng;
        private List<List<Entry>> buckets;
        private UniversalHash h;
        private int count;

        RandomizedHashTable(Random rng) {
            throw new UnsupportedOperationException();
        }

        private void newTable(int capacity) {
            throw new UnsupportedOperationException();
        }

        void put(int key, String value) {
            throw new UnsupportedOperationException();
        }

        String get(int key) {
            throw new UnsupportedOperationException();
        }

        int size() { throw new UnsupportedOperationException(); }

        int longestChain() {
            throw new UnsupportedOperationException();
        }
    }
    // ==== END

    // ==== EX 4.2.8 | The multiplication method | Stretch
    // PROMPT: Write `static int multHash(int k, int m)` = `floor(m * frac(k * A))` with A = 0.6180339887498949 (Knuth's golden-ratio choice). Unlike the division method it works well even when m is a power of two.
    // EXAMPLE: the keys 0, 8, ..., 7992 into m = 64 -> all `64` buckets used, where `k % 64` used only 8
    // BIGO: O(1).
    static int multHash(int k, int m) {
        throw new UnsupportedOperationException();
    }
    // ==== END
}
