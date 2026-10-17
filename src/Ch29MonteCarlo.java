import java.math.BigInteger;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/** Chapter 29: Monte Carlo and Las Vegas algorithms. */
public class Ch29MonteCarlo {

    // ==== EX 29.1 | Estimate pi by throwing darts | Core
    // PROMPT: Write `static double estimatePi(int samples, Random rng)`: pick random points in the unit square and return 4 times the fraction that land inside the quarter circle.
    // EXAMPLE: `estimatePi(100_000, new Random(0))` -> about `3.14` (within 0.02)
    // BIGO: O(S) samples; the error shrinks like 1 / sqrt(S), so 100 times more samples buy one more correct digit.
    static double estimatePi(int samples, Random rng) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 29.2 | Averages from a random sample | Core
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

    // ==== EX 29.3 | Monte Carlo versus Las Vegas | Core
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

    // ==== EX 29.4 | The trial-division baseline | Core
    // PROMPT: Write `static boolean isPrimeTrial(long n)` checking odd divisors up to sqrt(n). Time it on a 12-digit prime and note why it is too slow for 100-digit numbers.
    // EXAMPLE: `isPrimeTrial(999_999_000_001L)` -> `true` after about 500,000 divisions
    // BIGO: O(sqrt N): exponential in the number of digits.
    static boolean isPrimeTrial(long n) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 29.5 | Fermat's little theorem, one base | Core
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

    // ==== EX 29.6 | Fermat's primality test | Core
    // PROMPT: Write `static boolean fermatTest(long n, int k, Random rng)` trying k random bases in [2, n - 2] and answering "probably prime" (`true`) if none is a witness. Then show 561, a Carmichael number, fools every base coprime to it.
    // EXAMPLE: `fermatTest(1_000_000_007, 20, rng)` -> `true`; `fermatTest(1_000_000_007L * 998_244_353, 20, rng)` -> `false`; `fermatWitness(2, 561)` -> `false` although 561 = 3 x 11 x 17
    // BIGO: O(k log n). A Monte Carlo algorithm: "composite" is always right, "prime" can be wrong.
    static boolean fermatTest(long n, int k, Random rng) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 29.7 | Miller-Rabin, which Carmichael numbers cannot fool | Stretch
    // PROMPT: Write `static boolean millerRabin(long n)` with the bases 2, 3, 5, ..., 37 (the first 12 primes): write n - 1 = d x 2^s, and for each base check whether a^d is 1 or reaches n - 1 by repeated squaring. With these bases it is exact for every 64-bit n.
    // EXAMPLE: `millerRabin(561)` -> `false`; `millerRabin((1L << 61) - 1)` -> `true`
    // BIGO: O(k log^3 n) bit operations; effectively instant for 64-bit numbers.
    static final long[] BASES = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37};

    static boolean millerRabin(long n) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 29.8 | Simulate, then check against the formula | Practice
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
