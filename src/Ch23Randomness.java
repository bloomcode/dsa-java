import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PrimitiveIterator;
import java.util.Random;
import java.util.TreeMap;
import java.util.function.IntSupplier;

/**
 * Chapter 23: Randomness as a tool.
 * Every method that needs randomness takes a `java.util.Random`, so results are reproducible in tests.
 */
public class Ch23Randomness {

    // ==== EX 23.1 | Randomized quicksort | Core
    // PROMPT: Write `static List<Integer> randomQuicksort(List<Integer> arr, Random rng)` returning a new sorted list, choosing each pivot uniformly at random and splitting into less, equal and more.
    // EXAMPLE: `randomQuicksort(0..9 in order, new Random(1))` -> `[0, 1, 2, 3, 4, 5, 6, 7, 8, 9]`
    // BIGO: O(N log N) expected on every input, including sorted ones. The worst case still exists but needs extraordinarily bad luck.
    static List<Integer> randomQuicksort(List<Integer> arr, Random rng) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 23.2 | Reproducible randomness with seeds | Core
    // PROMPT: Write `static List<Integer> sampleWithSeed(long seed, List<Integer> population, int k)` that returns the same k-item sample every time for the same seed, using its own `new Random(seed)` and a partial shuffle of a copy.
    // EXAMPLE: `sampleWithSeed(42, 0..99, 3).equals(sampleWithSeed(42, 0..99, 3))` -> `true`
    // BIGO: O(N) to copy, O(k) swaps.
    // NOTE: A private `Random` instance keeps results reproducible even when other code also draws random numbers. `Math.random()` shares one global generator.
    static List<Integer> sampleWithSeed(long seed, List<Integer> population, int k) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 23.3 | A linear congruential generator | Core
    // PROMPT: Write `static class Lcg` with a `long next()` that applies `x = (a * x + c) % m` (defaults a = 1103515245, c = 12345, m = 2^31). Then write `static int lcgPeriod(long seed, long a, long c, long m)` and find the period of the tiny generator a = 5, c = 3, m = 16.
    // EXAMPLE: first three values of `new Lcg(1, 5, 3, 16)` -> `8, 11, 10`; its period is `16`
    // BIGO: O(1) per number. This is a PRNG: fully determined by the seed, which is why it is reproducible and why it is not secure.
    // NOTE: With x below 2^31 and a below 2^31, `a * x` stays below 2^62, so `long` is safe. `java.util.Random` is itself an LCG, with m = 2^48.
    static class Lcg {
        private final long a, c, m;
        private long x;

        Lcg(long seed, long a, long c, long m) {
            throw new UnsupportedOperationException();
        }

        Lcg(long seed) { this(seed, 1103515245L, 12345L, 1L << 31); throw new UnsupportedOperationException(); }

        long next() {
            throw new UnsupportedOperationException();
        }
    }

    static int lcgPeriod(long seed, long a, long c, long m) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 23.4 | Fisher-Yates shuffle | Core
    // PROMPT: Write `static int[] fisherYates(int[] arr, Random rng)` that shuffles in place: for i from the last index down to 1, swap arr[i] with arr[j] for a random j in 0..i.
    // EXAMPLE: `fisherYates(new int[]{1, 2, 3, 4, 5}, new Random(7))` returns some ordering of 1..5, the same one every time for seed 7
    // BIGO: O(N) time, O(1) extra space, and every permutation is equally likely.
    // NOTE: `rng.nextInt(i + 1)` returns 0..i. Using `nextInt(i)` instead (never swapping an item with itself) is a classic bug that rules out some orders.
    static int[] fisherYates(int[] arr, Random rng) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 23.5 | Prove the naive shuffle is biased | Practice
    // PROMPT: The naive shuffle swaps each position with any position 0..n-1. Write `static Map<String, Integer> naiveDistribution(int n)` and `fisherYatesDistribution(int n)` that enumerate every possible sequence of random choices (recursively) and count the resulting permutations.
    // EXAMPLE: For n = 3: Fisher-Yates gives each of the 6 permutations exactly once; naive spreads 27 outcomes as `{012=4, 021=5, 102=5, 120=5, 201=4, 210=4}`
    // BIGO: O(n^n) and O(n!) sequences: exact enumeration, no randomness needed.
    // NOTE: 27 equally likely outcomes cannot split evenly over 6 permutations, so the naive shuffle must be biased.
    static Map<String, Integer> naiveDistribution(int n) {
        throw new UnsupportedOperationException();
    }

    static Map<String, Integer> fisherYatesDistribution(int n) {
        throw new UnsupportedOperationException();
    }

    private static int[] identity(int n) {
        throw new UnsupportedOperationException();
    }

    private static void naive(int[] a, int i, Map<String, Integer> counts) {
        throw new UnsupportedOperationException();
    }

    private static void fy(int[] a, int i, Map<String, Integer> counts) {
        throw new UnsupportedOperationException();
    }

    private static String key(int[] a) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 23.6 | Randomize before building a BST | Core
    // PROMPT: Write `static int bstHeight(int[] keys)` that inserts keys in order into a plain BST (iteratively, so sorted input cannot overflow the stack) and returns its height. Compare sorted keys with the same keys shuffled.
    // EXAMPLE: `bstHeight(0..199 in order)` -> `200`; shuffled with `new Random(3)` -> about 15 to 20
    // BIGO: Height O(N) for sorted input, O(log N) expected after shuffling.
    static int bstHeight(int[] keys) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 23.7 | Reservoir sampling | Practice
    // PROMPT: Write `static int[] reservoir(PrimitiveIterator.OfInt stream, int k, Random rng)` that picks k items uniformly from a stream of unknown length in one pass: keep the first k, then replace a random slot with item i (0-based) with probability k / (i + 1).
    // EXAMPLE: `reservoir(IntStream.range(0, 1_000_000).iterator(), 3, new Random(0))` -> 3 values, each equally likely to be any of the million
    // BIGO: O(N) time, O(k) memory.
    static int[] reservoir(PrimitiveIterator.OfInt stream, int k, Random rng) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 23.8 | Load balancing with random choices | Core
    // PROMPT: Write `static int maxLoadRandom(int jobs, int servers, Random rng)` assigning each job to a random server, and `static int maxLoadTwoChoices(int jobs, int servers, Random rng)` picking two random servers and using the less loaded one. Return the busiest server's load.
    // EXAMPLE: With 10,000 jobs on 1,000 servers and seed 5, two choices gives a clearly lower maximum than one choice
    // BIGO: O(J) for J jobs. The "power of two choices" drops the expected maximum excess from about log N / log log N to log log N.
    static int maxLoadRandom(int jobs, int servers, Random rng) {
        throw new UnsupportedOperationException();
    }

    static int maxLoadTwoChoices(int jobs, int servers, Random rng) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 23.9 | Weighted random choice | Practice
    // PROMPT: Write `static IntSupplier makeWeightedPicker(double[] weights, Random rng)` that precomputes prefix sums and returns a function picking index i with probability weights[i] / total, by binary-searching for the first prefix sum greater than `rng.nextDouble() * total`.
    // EXAMPLE: weights `{1, 3, 6}` -> over 10,000 picks index 2 comes up about 60% of the time
    // BIGO: O(N) setup, O(log N) per pick.
    static IntSupplier makeWeightedPicker(double[] weights, Random rng) {
        throw new UnsupportedOperationException();
    }
    // ==== END
}
