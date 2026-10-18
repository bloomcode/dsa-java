import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/** Chapter 4.3: Rolling hashes and text search. */
public class Ch4_3TextSearch {

    static final long BASE = 26;
    static final long PRIME = 1_000_000_007L;

    /** Map 'a'..'z' to 0..25 so base 26 is exact for lowercase text. */
    static int code(char ch) {
        return ch - 'a';
    }

    static long powMod(long b, long e, long m) {
        long r = 1 % m;
        b %= m;
        while (e > 0) {
            if ((e & 1) == 1) r = r * b % m;
            b = b * b % m;
            e >>= 1;
        }
        return r;
    }

    // ==== EX 4.3.1 | Brute-force substring search | Core
    // PROMPT: Write `static List<Integer> bruteForceSearch(String text, String needle)` returning every index where `needle` starts, comparing character by character at each position.
    // EXAMPLE: `bruteForceSearch("abracadabra", "abra")` -> `[0, 7]`
    // BIGO: O(N * M) worst case, e.g. text `"aaaa...a"` and needle `"aa...ab"`.
    static List<Integer> bruteForceSearch(String text, String needle) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 4.3.2 | Sliding a window in O(1) per step | Core
    // PROMPT: Write `static long[] windowSums(int[] arr, int k)` returning the sum of every window of k consecutive values, adding the entering value and subtracting the leaving one.
    // EXAMPLE: `windowSums(new int[]{1, 2, 3, 4, 5}, 3)` -> `[6, 9, 12]`
    // BIGO: O(N) instead of O(N * k). Rabin-Karp applies exactly this idea to a hash.
    static long[] windowSums(int[] arr, int k) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 4.3.3 | Rolling base-26 hashes | Core
    // PROMPT: Write `static long[] rollingHashes(String text, int m)` returning the hash of every length-m window, treating each window as a base-26 number mod PRIME. Roll with: remove the leading digit times 26^(m-1), multiply by 26, add the new digit.
    // EXAMPLE: `rollingHashes("abcd", 2)` -> `[1, 28, 55]` (ab = 0*26 + 1, bc = 1*26 + 2, cd = 2*26 + 3)
    // BIGO: O(N) for all windows.
    // NOTE: After subtracting the leading digit the value can go negative, and Java's `%` keeps the sign. Add PRIME (or use `Math.floorMod`) before reducing.
    static long[] rollingHashes(String text, int m) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 4.3.4 | Rabin-Karp, verified (Las Vegas) | Core
    // PROMPT: Write `static List<Integer> rabinKarp(String text, String needle, long prime)` that compares rolling hashes and confirms each hash match with a real comparison (`regionMatches`), so the answer is always correct.
    // EXAMPLE: `rabinKarp("abracadabra", "abra", PRIME)` -> `[0, 7]`
    // BIGO: O(N + M) expected; O(N * M) only if hash matches are spuriously frequent.
    static List<Integer> rabinKarp(String text, String needle, long prime) {
        throw new UnsupportedOperationException();
    }

    private static List<Integer> search(String text, String needle, long prime, boolean verify) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 4.3.5 | Spurious hits with a tiny modulus | Core
    // PROMPT: Write `static int spuriousHits(String text, String needle, long prime)` counting windows whose hash equals the needle's but whose text does not. Compare prime = 7 with prime = 10^9 + 7 on a long text.
    // EXAMPLE: 10,000 random letters, needle "abcde" -> prime 7 gives over a thousand spurious hits; 10^9 + 7 gives `0`
    // BIGO: O(N). Expected spurious hits are about N / prime, which is why the modulus is large.
    static int spuriousHits(String text, String needle, long prime) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 4.3.6 | Rabin-Karp without verification (Monte Carlo) | Practice
    // PROMPT: Write `static List<Integer> rabinKarpMonteCarlo(String text, String needle, Random rng)` that picks a random prime modulus between 10^9 and 2 x 10^9 for this run and reports every hash match without checking the text.
    // EXAMPLE: on ordinary text it returns the same indices as 3.1.4, in strictly O(N + M) time
    // BIGO: O(N + M) worst case, with a small chance of a false match. 3.1.4 trades that chance for a verification step.
    static boolean isPrime(long n) {
        throw new UnsupportedOperationException();
    }

    static List<Integer> rabinKarpMonteCarlo(String text, String needle, Random rng) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 4.3.7 | Many needles of one length | Practice
    // PROMPT: Write `record Hit(int index, String needle)` and `static List<Hit> findAny(String text, List<String> needles)` for needles that all share one length: put their hashes in a map and slide one rolling hash over the text.
    // EXAMPLE: `findAny("thecatsatonthemat", [cat, mat, dog])` -> `[Hit[index=3, needle=cat], Hit[index=14, needle=mat]]`
    // BIGO: O(N + K * M) for K needles, instead of K separate searches.
    record Hit(int index, String needle) {}

    static List<Hit> findAny(String text, List<String> needles) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 4.3.8 | Longest repeated substring | Stretch
    // PROMPT: Write `static String longestRepeat(String text)` returning the longest substring that occurs at least twice. Binary-search the length L; for each L, check for a repeated rolling hash (verifying matches).
    // EXAMPLE: `longestRepeat("banana")` -> `"ana"`; `longestRepeat("abcd")` -> `""`
    // BIGO: O(N log N) expected.
    static String longestRepeat(String text) {
        throw new UnsupportedOperationException();
    }

    private static String repeatOfLength(String text, int len) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 4.3.9 | The prefix table | Practice
    // PROMPT: Write `static int[] prefixTable(String pattern)` that returns an array where entry `i` is the length of the longest proper prefix of `pattern.substring(0, i + 1)` that is also its suffix. Keep the current match length `k`; on a mismatch fall back to `table[k - 1]` instead of starting over.
    // EXAMPLE: `"abacabab"` -> `[0, 0, 1, 0, 1, 2, 3, 2]`
    // BIGO: O(M) time and space: `k` rises by at most one per character and every fall-back lowers it, so the total work is linear.
    static int[] prefixTable(String pattern) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 4.3.10 | Search with the prefix table | Practice
    // PROMPT: Write `static List<Integer> prefixSearch(String text, String pattern)` that returns every start index of `pattern` (non-empty) in `text`, overlaps included, in O(N + M): build the prefix table of `pattern` (4.3.9), then walk `text` once, keeping the matched length `k` and falling back through the table on a mismatch or after a full match.
    // EXAMPLE: `"abababca", "abab"` -> `[0, 2]`
    // BIGO: O(N + M) worst case, O(M) space: the text pointer never moves back, and the table says how much of the match survives a mismatch.
    // NOTE: Unlike Rabin-Karp (4.3.4), this is linear even in the worst case and needs no hashing or verification.
    static List<Integer> prefixSearch(String text, String pattern) {
        throw new UnsupportedOperationException();
    }
    // ==== END
}
