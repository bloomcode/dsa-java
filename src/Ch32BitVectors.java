import java.util.ArrayList;
import java.util.BitSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/** Chapter 32: Bit vectors: one bit per member. */
public class Ch32BitVectors {

    // ==== EX 32.1 | A set as a boolean array | Core
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

    // ==== EX 32.2 | A bit vector with masks | Core
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

        // ==== EX 32.3 | Count the members | Core | class=BitVector
        // PROMPT: Add `int count()` that counts set bits across all words with `Long.bitCount`.
        // EXAMPLE: add 1, 5, 99 -> `count()` is `3`
        // BIGO: O(size / 64), and `bitCount` is a single CPU instruction. Keep a running counter instead if you need O(1).
        int count() {
            throw new UnsupportedOperationException();
        }
        // ==== END

        // ==== EX 32.4 | Union, intersection and difference | Core | class=BitVector
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

        // ==== EX 32.5 | Iterate over members | Core | class=BitVector
        // PROMPT: Add `List<Integer> members()` returning members in increasing order, skipping zero words entirely and peeling off the lowest set bit with `Long.numberOfTrailingZeros` and `w & (w - 1)`.
        // EXAMPLE: add 9, 2, 63 -> `members()` is `[2, 9, 63]`
        // BIGO: O(size / 64 + members).
        List<Integer> members() {
            throw new UnsupportedOperationException();
        }
        // ==== END
    }

    // ==== EX 32.6 | Estimate the space | Core
    // PROMPT: Write `static Map<String, Long> spaceReport(int n)` estimating the bytes used by a `HashSet<Integer>` of 0..n-1 (about 32 bytes per entry, 16 per boxed Integer, plus a 4-byte slot per table bucket), a `boolean[n]`, and a `BitVector(n)` (each array has a 16-byte header).
    // EXAMPLE: n = 1,000,000 -> HashSet about 56 MB, `boolean[]` `1000016` bytes, bit vector `125016` bytes
    // BIGO: O(N) each, but the constants differ by a factor of about 450.
    // NOTE: The figures assume a 64-bit JVM with compressed pointers; tools such as JOL measure real object sizes. `java.util.BitSet` is the JDK's ready-made bit vector.
    static Map<String, Long> spaceReport(int n) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 32.7 | Find duplicates in a bounded range | Core
    // PROMPT: Write `static Integer firstDuplicate(int[] nums, int universe)` returning the first value seen twice, using a `BitVector` as the "seen" set, or `null`.
    // EXAMPLE: `firstDuplicate(new int[]{4, 9, 1, 9, 4}, 10)` -> `9`; no repeats -> `null`
    // BIGO: O(N) time, universe / 8 bytes of space, no matter how many numbers there are.
    static Integer firstDuplicate(int[] nums, int universe) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 32.8 | A built-in type as a growable bit set | Practice
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

    // ==== EX 32.9 | Missing numbers from a range | Practice
    // PROMPT: Write `static List<Integer> missing(int[] nums, int n)` returning every value in 0..n-1 that does not appear in `nums`, marking a `BitVector` and then scanning it.
    // EXAMPLE: `missing(new int[]{0, 3, 1, 6}, 7)` -> `[2, 4, 5]`
    // BIGO: O(N + n) time, n / 8 bytes of space.
    static List<Integer> missing(int[] nums, int n) {
        throw new UnsupportedOperationException();
    }
    // ==== END
}
