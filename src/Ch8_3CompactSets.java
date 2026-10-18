import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/** Chapter 8.3: Compact sets: bit vectors and Bloom filters. */
public class Ch8_3CompactSets {

    // ==== EX 8.3.1 | A set as a boolean array | Core
    // PROMPT: Write `static class BoolArraySet` for integers 0..universe-1 backed by a `boolean[]`, with `add`, `remove`, `contains` and `size`.
    // EXAMPLE: universe 10: add 3, add 7, remove 3 -> `contains(7)` is `true`, `contains(3)` is `false`, `size()` is `1`
    // BIGO: O(1) per operation, but a whole byte per possible value: the JVM does not pack `boolean[]` into bits.
    static class BoolArraySet {
        private final boolean[] flags;
        private int count;

        BoolArraySet(int universe) { throw new UnsupportedOperationException(); }

        void add(int x) {
            throw new UnsupportedOperationException();
        }

        void remove(int x) {
            throw new UnsupportedOperationException();
        }

        boolean contains(int x) { throw new UnsupportedOperationException(); }

        int size() { throw new UnsupportedOperationException(); }
    }
    // ==== END

    // ==== EX 8.3.2 | A bit vector with masks | Core
    // PROMPT: Write `static class BitVector` on a `long[] words` of ceil(size / 64) words. Value x lives in word `x >>> 6`, bit `x & 63`. Implement `add` (OR with the mask), `remove` (AND with the inverted mask) and `contains` (AND, then test).
    // EXAMPLE: `BitVector bv = new BitVector(100); bv.add(42)` -> `bv.contains(42)` is `true`; `bv.words[0]` is `4398046511104` (bit 42 of word 0)
    // BIGO: O(1) per operation, and 1 bit per possible value: 8 times less than a `boolean[]`.
    // NOTE: The mask must be `1L << (x & 63)`. With `1 << ...` the shift is done in `int` and silently wraps for bits 32 to 63.
    static class BitVector {
        final int size;
        long[] words;

        BitVector(int size) {
            throw new UnsupportedOperationException();
        }

        void add(int x) { throw new UnsupportedOperationException(); }

        void remove(int x) { throw new UnsupportedOperationException(); }

        boolean contains(int x) { throw new UnsupportedOperationException(); }
        // ==== END

        // ==== EX 8.3.3 | Count the members | Core | class=BitVector
        // PROMPT: Add `int count()` that counts set bits across all words with `Long.bitCount`.
        // EXAMPLE: add 1, 5, 99 -> `count()` is `3`
        // BIGO: O(size / 64), and `bitCount` is a single CPU instruction. Keep a running counter instead if you need O(1).
        int count() {
            throw new UnsupportedOperationException();
        }
        // ==== END

        // ==== EX 8.3.4 | Union, intersection and difference | Core | class=BitVector
        // PROMPT: Add `union`, `intersection` and `difference`, each returning a new `BitVector` of the same size by combining the words with `|`, `&` and `& ~`.
        // EXAMPLE: {1, 2, 3} and {2, 3, 4} -> union `{1, 2, 3, 4}`, intersection `{2, 3}`, difference `{1}`
        // BIGO: O(size / 64): sixty-four set members combined per word operation.
        BitVector union(BitVector other) {
            throw new UnsupportedOperationException();
        }

        BitVector intersection(BitVector other) {
            throw new UnsupportedOperationException();
        }

        BitVector difference(BitVector other) {
            throw new UnsupportedOperationException();
        }
        // ==== END

        // ==== EX 8.3.5 | Iterate over members | Core | class=BitVector
        // PROMPT: Add `List<Integer> members()` returning members in increasing order, skipping zero words entirely and peeling off the lowest set bit with `Long.numberOfTrailingZeros` and `w & (w - 1)`.
        // EXAMPLE: add 9, 2, 63 -> `members()` is `[2, 9, 63]`
        // BIGO: O(size / 64 + members).
        List<Integer> members() {
            throw new UnsupportedOperationException();
        }
        // ==== END
    }

    // ==== EX 8.3.6 | Estimate the space | Core
    // PROMPT: Write `static Map<String, Long> spaceReport(int n)` estimating the bytes used by a `HashSet<Integer>` of 0..n-1 (about 32 bytes per entry, 16 per boxed Integer, plus a 4-byte slot per table bucket), a `boolean[n]`, and a `BitVector(n)` (each array has a 16-byte header).
    // EXAMPLE: n = 1,000,000 -> HashSet about 56 MB, `boolean[]` `1000016` bytes, bit vector `125016` bytes
    // BIGO: O(N) each, but the constants differ by a factor of about 450.
    // NOTE: The figures assume a 64-bit JVM with compressed pointers; tools such as JOL measure real object sizes. `java.util.BitSet` is the JDK's ready-made bit vector.
    static Map<String, Long> spaceReport(int n) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 8.3.7 | Find duplicates in a bounded range | Core
    // PROMPT: Write `static Integer firstDuplicate(int[] nums, int universe)` returning the first value seen twice, using a `BitVector` as the "seen" set, or `null`.
    // EXAMPLE: `firstDuplicate(new int[]{4, 9, 1, 9, 4}, 10)` -> `9`; no repeats -> `null`
    // BIGO: O(N) time, universe / 8 bytes of space, no matter how many numbers there are.
    static Integer firstDuplicate(int[] nums, int universe) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 8.3.8 | A built-in type as a growable bit set | Practice
    // PROMPT: Write `static List<Integer> unionList(int[] a, int[] b)` and `static int commonCount(int[] a, int[] b)` with `java.util.BitSet`: `set`, `or`, `and`, `cardinality`, and a `nextSetBit` loop to list members.
    // EXAMPLE: `a = {1, 5}`, `b = {5, 7}` -> `unionList` is `[1, 5, 7]`; `commonCount` is `1`
    // BIGO: Word-at-a-time operations, O(size / 64), and the set grows as needed.
    // NOTE: `or` and `and` modify the set they are called on, so clone first if you still need the original.
    static BitSet toBitSet(int[] items) {
        throw new UnsupportedOperationException();
    }

    static List<Integer> unionList(int[] a, int[] b) {
        throw new UnsupportedOperationException();
    }

    static int commonCount(int[] a, int[] b) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 8.3.9 | Missing numbers from a range | Practice
    // PROMPT: Write `static List<Integer> missing(int[] nums, int n)` returning every value in 0..n-1 that does not appear in `nums`, marking a `BitVector` and then scanning it.
    // EXAMPLE: `missing(new int[]{0, 3, 1, 6}, 7)` -> `[2, 4, 5]`
    // BIGO: O(N + n) time, n / 8 bytes of space.
    static List<Integer> missing(int[] nums, int n) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    static long[] twoHashes(String item) {
        try {
            byte[] d = MessageDigest.getInstance("SHA-256").digest(item.getBytes(StandardCharsets.UTF_8));
            ByteBuffer buf = ByteBuffer.wrap(d);
            return new long[]{buf.getLong(0), buf.getLong(8) | 1};
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalStateException(e);
        }
    }

    // ==== EX 8.3.10 | k hash functions from two | Core
    // PROMPT: Write `static int[] bitPositions(String item, int k, int m)` returning k bit positions in [0, m) using double hashing: `(h1 + i * h2) mod m` for i in 0..k-1, where h1 and h2 are the first two 8-byte words of one SHA-256 digest.
    // EXAMPLE: `bitPositions("cat", 3, 32)` -> three positions in 0..31, the same on every run
    // BIGO: O(k) after one hash computation. Kirsch and Mitzenmacher showed this behaves as well as k independent hashes.
    // NOTE: The words are signed `long`s and `h1 + i * h2` wraps around; `Long.remainderUnsigned` treats the bits as an unsigned number, so the result is never negative.
    static int[] bitPositions(String item, int k, int m) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 8.3.11 | A Bloom filter | Core
    // PROMPT: Write `static class BloomFilter` with an m-bit `long[]`, `add(String item)` setting the item's k bits, and `mightContain(String item)` returning `true` only if all k bits are set.
    // EXAMPLE: add "apple" and "pear" -> `mightContain("apple")` is `true`; `mightContain("grape")` is almost certainly `false`
    // BIGO: O(k) per operation; m bits of memory regardless of how large the items are.
    // NOTE: "No" is always right. "Yes" means "probably": other items may have set those same bits.
    static class BloomFilter {
        final int m, k;
        long[] bits;
        int count;

        BloomFilter(int m, int k) {
            throw new UnsupportedOperationException();
        }

        void add(String item) {
            throw new UnsupportedOperationException();
        }

        boolean mightContain(String item) {
            throw new UnsupportedOperationException();
        }
        // ==== END

        // ==== EX 8.3.16 | Union of two filters | Practice | class=BloomFilter
        // PROMPT: Add `BloomFilter union(BloomFilter other)` returning a new filter whose bits are the OR of both, for filters built with the same m and k (throw `IllegalArgumentException` otherwise).
        // EXAMPLE: filter A holds "x", filter B holds "y" -> the union might contain both
        // BIGO: O(m / 64). Handy for merging filters built on separate machines.
        BloomFilter union(BloomFilter other) {
            throw new UnsupportedOperationException();
        }
        // ==== END
    }

    // ==== EX 8.3.12 | Predict the false-positive rate | Core
    // PROMPT: Write `static double falsePositiveRate(long n, long m, int k)` = `(1 - e^(-k n / m))^k`, the chance a never-added item looks present after n insertions.
    // EXAMPLE: `falsePositiveRate(1000, 10_000, 7)` -> about `0.0082` (under 1%)
    // BIGO: O(1).
    static double falsePositiveRate(long n, long m, int k) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 8.3.13 | Size a filter for a target error | Core
    // PROMPT: Write `static long[] optimalParams(long n, double p)` returning `{m, k}`: bits `m = ceil(-n ln p / (ln 2)^2)` and hash count `k = round((m / n) ln 2)`.
    // EXAMPLE: `optimalParams(1_000_000, 0.01)` -> `[9585059, 7]`: about 1.2 MB for a million items at 1% error
    // BIGO: O(1). Each tenfold cut in p costs only about 4.8 more bits per item.
    static long[] optimalParams(long n, double p) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 8.3.14 | Measure the real error | Core
    // PROMPT: Write `static double measuredFpRate(int n, int m, int k, int probes)`: add the strings "in-0" .. "in-{n-1}", then probe "out-0" .. "out-{probes-1}" (never added) and return the fraction reported present.
    // EXAMPLE: `measuredFpRate(1000, 10_000, 7, 20_000)` lands close to the 1.3.3 prediction (within about 0.005)
    // BIGO: O((n + probes) * k).
    static double measuredFpRate(int n, int m, int k, int probes) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 8.3.15 | Duplicate detection in a stream | Core
    // PROMPT: Write `static List<String> streamDuplicates(List<String> items, int m, int k)` that reports items the filter says it has seen before. Then write `static int falseAlarms(List<String> items, int m, int k)` that double-checks each report against an exact `HashSet` and counts how many reports were false.
    // EXAMPLE: a stream of 5,000 unique items plus 100 repeats with m = 64,000, k = 6 -> all 100 repeats reported, and only a handful of false alarms
    // BIGO: O(N * k) time, m bits of space. Real systems (web crawlers, databases) use the filter to skip most exact lookups.
    static List<String> streamDuplicates(List<String> items, int m, int k) {
        throw new UnsupportedOperationException();
    }

    static int falseAlarms(List<String> items, int m, int k) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 8.3.17 | A counting Bloom filter that can delete | Stretch
    // PROMPT: Write `static class CountingBloomFilter` with an `int[]` of small counters instead of bits: `add` increments, `remove` decrements (only for items you added), and `mightContain` checks all counters are above zero.
    // EXAMPLE: add "a", add "b", remove "a" -> `mightContain("a")` is `false` (barring collisions), `mightContain("b")` is `true`
    // BIGO: O(k) per operation, at the cost of 4 to 8 bits per counter instead of 1 (here a full `int` for simplicity).
    static class CountingBloomFilter {
        final int m, k;
        final int[] counts;

        CountingBloomFilter(int m, int k) {
            throw new UnsupportedOperationException();
        }

        void add(String item) {
            throw new UnsupportedOperationException();
        }

        boolean remove(String item) {
            throw new UnsupportedOperationException();
        }

        boolean mightContain(String item) {
            throw new UnsupportedOperationException();
        }
    }
    // ==== END
}
