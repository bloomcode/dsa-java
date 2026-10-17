import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PrimitiveIterator;
import java.util.Random;
import java.util.Set;
import java.util.TreeMap;
import java.util.function.IntSupplier;

/** Chapter 74: Randomized algorithms. */
public class Ch74Randomized {

    // ==== EX 74.1 | Randomized quicksort | Core
    // PROMPT: Write `static List<Integer> randomQuicksort(List<Integer> arr, Random rng)` returning a new sorted list, choosing each pivot uniformly at random and splitting into less, equal and more.
    // EXAMPLE: `randomQuicksort(0..9 in order, new Random(1))` -> `[0, 1, 2, 3, 4, 5, 6, 7, 8, 9]`
    // BIGO: O(N log N) expected on every input, including sorted ones. The worst case still exists but needs extraordinarily bad luck.
    static List<Integer> randomQuicksort(List<Integer> arr, Random rng) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 74.2 | Reproducible randomness with seeds | Core
    // PROMPT: Write `static List<Integer> sampleWithSeed(long seed, List<Integer> population, int k)` that returns the same k-item sample every time for the same seed, using its own `new Random(seed)` and a partial shuffle of a copy.
    // EXAMPLE: `sampleWithSeed(42, 0..99, 3).equals(sampleWithSeed(42, 0..99, 3))` -> `true`
    // BIGO: O(N) to copy, O(k) swaps.
    // NOTE: A private `Random` instance keeps results reproducible even when other code also draws random numbers. `Math.random()` shares one global generator.
    static List<Integer> sampleWithSeed(long seed, List<Integer> population, int k) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 74.3 | A linear congruential generator | Core
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

    // ==== EX 74.4 | Fisher-Yates shuffle | Core
    // PROMPT: Write `static int[] fisherYates(int[] arr, Random rng)` that shuffles in place: for i from the last index down to 1, swap arr[i] with arr[j] for a random j in 0..i.
    // EXAMPLE: `fisherYates(new int[]{1, 2, 3, 4, 5}, new Random(7))` returns some ordering of 1..5, the same one every time for seed 7
    // BIGO: O(N) time, O(1) extra space, and every permutation is equally likely.
    // NOTE: `rng.nextInt(i + 1)` returns 0..i. Using `nextInt(i)` instead (never swapping an item with itself) is a classic bug that rules out some orders.
    static int[] fisherYates(int[] arr, Random rng) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 74.5 | Prove the naive shuffle is biased | Practice
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

    // ==== EX 74.6 | Randomize before building a BST | Core
    // PROMPT: Write `static int bstHeight(int[] keys)` that inserts keys in order into a plain BST (iteratively, so sorted input cannot overflow the stack) and returns its height. Compare sorted keys with the same keys shuffled.
    // EXAMPLE: `bstHeight(0..199 in order)` -> `200`; shuffled with `new Random(3)` -> about 15 to 20
    // BIGO: Height O(N) for sorted input, O(log N) expected after shuffling.
    static int bstHeight(int[] keys) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 74.7 | Reservoir sampling | Practice
    // PROMPT: Write `static int[] reservoir(PrimitiveIterator.OfInt stream, int k, Random rng)` that picks k items uniformly from a stream of unknown length in one pass: keep the first k, then replace a random slot with item i (0-based) with probability k / (i + 1).
    // EXAMPLE: `reservoir(IntStream.range(0, 1_000_000).iterator(), 3, new Random(0))` -> 3 values, each equally likely to be any of the million
    // BIGO: O(N) time, O(k) memory.
    static int[] reservoir(PrimitiveIterator.OfInt stream, int k, Random rng) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 74.8 | Load balancing with random choices | Core
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

    // ==== EX 74.9 | Weighted random choice | Practice
    // PROMPT: Write `static IntSupplier makeWeightedPicker(double[] weights, Random rng)` that precomputes prefix sums and returns a function picking index i with probability weights[i] / total, by binary-searching for the first prefix sum greater than `rng.nextDouble() * total`.
    // EXAMPLE: weights `{1, 3, 6}` -> over 10,000 picks index 2 comes up about 60% of the time
    // BIGO: O(N) setup, O(log N) per pick.
    static IntSupplier makeWeightedPicker(double[] weights, Random rng) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 74.10 | Estimate pi by throwing darts | Core
    // PROMPT: Write `static double estimatePi(int samples, Random rng)`: pick random points in the unit square and return 4 times the fraction that land inside the quarter circle.
    // EXAMPLE: `estimatePi(100_000, new Random(0))` -> about `3.14` (within 0.02)
    // BIGO: O(S) samples; the error shrinks like 1 / sqrt(S), so 100 times more samples buy one more correct digit.
    static double estimatePi(int samples, Random rng) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 74.11 | Averages from a random sample | Core
    // PROMPT: Write `static double sampledMean(int[] data, int k, Random rng)` estimating the mean of a huge array from k random positions (with replacement), and `static double exactMean(int[] data)` for comparison.
    // EXAMPLE: one million values, k = 2,000 -> the estimate lands within about 2% of the true mean
    // BIGO: O(k) instead of O(N); accuracy depends on k and the data's spread, not on N.
    static double sampledMean(int[] data, int k, Random rng) {
        throw new UnsupportedOperationException();
    }

    static double exactMean(int[] data) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 74.12 | Monte Carlo versus Las Vegas | Core
    // PROMPT: In an array where half the entries are 1, write `static int lasVegasFindOne(int[] arr, Random rng)` (probe random positions until a 1 appears; always right, time varies) and `static int monteCarloFindOne(int[] arr, Random rng, int tries)` (give up after `tries` probes and return -1; time fixed, may fail).
    // EXAMPLE: both return an index holding 1; Monte Carlo with 20 tries fails with probability (1/2)^20, about one in a million
    // BIGO: Las Vegas: 2 probes expected. Monte Carlo: exactly `tries` probes at most.
    static int lasVegasFindOne(int[] arr, Random rng) {
        throw new UnsupportedOperationException();
    }

    static int monteCarloFindOne(int[] arr, Random rng, int tries) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 74.13 | The trial-division baseline | Core
    // PROMPT: Write `static boolean isPrimeTrial(long n)` checking odd divisors up to sqrt(n). Time it on a 12-digit prime and note why it is too slow for 100-digit numbers.
    // EXAMPLE: `isPrimeTrial(999_999_000_001L)` -> `true` after about 500,000 divisions
    // BIGO: O(sqrt N): exponential in the number of digits.
    static boolean isPrimeTrial(long n) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 74.14 | Fermat's little theorem, one base | Core
    // PROMPT: If n is prime, a^(n-1) mod n is 1 for every a not divisible by n. Write `static long powMod(long a, long e, long n)` by repeated squaring and `static boolean fermatWitness(long a, long n)` returning `true` when a proves n composite.
    // EXAMPLE: `fermatWitness(2, 15)` -> `true` (15 is composite); `fermatWitness(2, 13)` -> `false`
    // BIGO: O(log n) multiplications.
    // NOTE: For n near 10^18, `a * b % n` overflows a long. `mulMod` goes through `BigInteger` here; `BigInteger.modPow` would do the whole job in one call.
    static long mulMod(long a, long b, long n) {
        throw new UnsupportedOperationException();
    }

    static long powMod(long a, long e, long n) {
        throw new UnsupportedOperationException();
    }

    static boolean fermatWitness(long a, long n) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 74.15 | Fermat's primality test | Core
    // PROMPT: Write `static boolean fermatTest(long n, int k, Random rng)` trying k random bases in [2, n - 2] and answering "probably prime" (`true`) if none is a witness. Then show 561, a Carmichael number, fools every base coprime to it.
    // EXAMPLE: `fermatTest(1_000_000_007, 20, rng)` -> `true`; `fermatTest(1_000_000_007L * 998_244_353, 20, rng)` -> `false`; `fermatWitness(2, 561)` -> `false` although 561 = 3 x 11 x 17
    // BIGO: O(k log n). A Monte Carlo algorithm: "composite" is always right, "prime" can be wrong.
    static boolean fermatTest(long n, int k, Random rng) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 74.16 | Miller-Rabin, which Carmichael numbers cannot fool | Stretch
    // PROMPT: Write `static boolean millerRabin(long n)` with the bases 2, 3, 5, ..., 37 (the first 12 primes): write n - 1 = d x 2^s, and for each base check whether a^d is 1 or reaches n - 1 by repeated squaring. With these bases it is exact for every 64-bit n.
    // EXAMPLE: `millerRabin(561)` -> `false`; `millerRabin((1L << 61) - 1)` -> `true`
    // BIGO: O(k log^3 n) bit operations; effectively instant for 64-bit numbers.
    static final long[] BASES = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37};

    static boolean millerRabin(long n) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 74.17 | Simulate, then check against the formula | Practice
    // PROMPT: Write `static double birthdaySimulation(int people, int trials, Random rng)` estimating the chance that two of `people` share a birthday (365 days), and `static double birthdayExact(int people)` from the product formula.
    // EXAMPLE: 23 people -> exact `0.507...`; 20,000 simulated trials land within 0.02 of it
    // BIGO: O(trials x people). When no formula exists, simulation is how you get the number.
    static double birthdaySimulation(int people, int trials, Random rng) {
        throw new UnsupportedOperationException();
    }

    static double birthdayExact(int people) {
        throw new UnsupportedOperationException();
    }
    // ==== END
}
