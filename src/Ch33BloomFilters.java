import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Chapter 33: Bloom filters.
 * Hashes come from SHA-256 so results are the same on every run and every JVM.
 */
public class Ch33BloomFilters {

    static long[] twoHashes(String item) {
        try {
            byte[] d = MessageDigest.getInstance("SHA-256").digest(item.getBytes(StandardCharsets.UTF_8));
            ByteBuffer buf = ByteBuffer.wrap(d);
            return new long[]{buf.getLong(0), buf.getLong(8) | 1};
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalStateException(e);
        }
    }

    // ==== EX 33.1 | k hash functions from two | Core
    // PROMPT: Write `static int[] bitPositions(String item, int k, int m)` returning k bit positions in [0, m) using double hashing: `(h1 + i * h2) mod m` for i in 0..k-1, where h1 and h2 are the first two 8-byte words of one SHA-256 digest.
    // EXAMPLE: `bitPositions("cat", 3, 32)` -> three positions in 0..31, the same on every run
    // BIGO: O(k) after one hash computation. Kirsch and Mitzenmacher showed this behaves as well as k independent hashes.
    // NOTE: The words are signed `long`s and `h1 + i * h2` wraps around; `Long.remainderUnsigned` treats the bits as an unsigned number, so the result is never negative.
    static int[] bitPositions(String item, int k, int m) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 33.2 | A Bloom filter | Core
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

        // ==== EX 33.7 | Union of two filters | Practice | class=BloomFilter
        // PROMPT: Add `BloomFilter union(BloomFilter other)` returning a new filter whose bits are the OR of both, for filters built with the same m and k (throw `IllegalArgumentException` otherwise).
        // EXAMPLE: filter A holds "x", filter B holds "y" -> the union might contain both
        // BIGO: O(m / 64). Handy for merging filters built on separate machines.
        BloomFilter union(BloomFilter other) {
            throw new UnsupportedOperationException();
        }
        // ==== END
    }

    // ==== EX 33.3 | Predict the false-positive rate | Core
    // PROMPT: Write `static double falsePositiveRate(long n, long m, int k)` = `(1 - e^(-k n / m))^k`, the chance a never-added item looks present after n insertions.
    // EXAMPLE: `falsePositiveRate(1000, 10_000, 7)` -> about `0.0082` (under 1%)
    // BIGO: O(1).
    static double falsePositiveRate(long n, long m, int k) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 33.4 | Size a filter for a target error | Core
    // PROMPT: Write `static long[] optimalParams(long n, double p)` returning `{m, k}`: bits `m = ceil(-n ln p / (ln 2)^2)` and hash count `k = round((m / n) ln 2)`.
    // EXAMPLE: `optimalParams(1_000_000, 0.01)` -> `[9585059, 7]`: about 1.2 MB for a million items at 1% error
    // BIGO: O(1). Each tenfold cut in p costs only about 4.8 more bits per item.
    static long[] optimalParams(long n, double p) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 33.5 | Measure the real error | Core
    // PROMPT: Write `static double measuredFpRate(int n, int m, int k, int probes)`: add the strings "in-0" .. "in-{n-1}", then probe "out-0" .. "out-{probes-1}" (never added) and return the fraction reported present.
    // EXAMPLE: `measuredFpRate(1000, 10_000, 7, 20_000)` lands close to the 13.3 prediction (within about 0.005)
    // BIGO: O((n + probes) * k).
    static double measuredFpRate(int n, int m, int k, int probes) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 33.6 | Duplicate detection in a stream | Core
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

    // ==== EX 33.8 | A counting Bloom filter that can delete | Stretch
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
