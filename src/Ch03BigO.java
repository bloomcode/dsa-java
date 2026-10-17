/** Chapter 3: Big O: how the step count grows. */
public class Ch03BigO {

    // ==== EX 3.1 | An O(1) algorithm | Core
    // PROMPT: Write `static boolean isLeapYear(int year)`. Explain why its step count does not depend on the input's size.
    // EXAMPLE: `isLeapYear(2024)` -> `true`; `1900` -> `false`; `2000` -> `true`
    // BIGO: O(1). At most three checks, whatever the year.
    static boolean isLeapYear(int year) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 3.2 | An O(N) algorithm | Core
    // PROMPT: Write `static long arraySum(int[] arr)` with a loop (no streams), and say how many steps it takes for N elements.
    // EXAMPLE: `{1, 2, 3, 4}` -> `10`, 4 loop steps
    // BIGO: O(N). One step per element. Return `long`: a million ints near 2^31 overflow an `int` total.
    static long arraySum(int[] arr) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 3.3 | An O(log N) algorithm | Core
    // PROMPT: Write `static int halvingSteps(long n)` returning how many times you can halve `n` (integer division) before it reaches 1.
    // EXAMPLE: `halvingSteps(8)` -> `3`; `halvingSteps(1024)` -> `10`; `halvingSteps(1)` -> `0`
    // BIGO: O(log N). This is the definition of log2 N for powers of two.
    static int halvingSteps(long n) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 3.4 | Doubling: grains on a chessboard | Practice
    // PROMPT: One grain on square 1, two on square 2, four on square 3, and so on. Write `static int squaresNeeded(long grains)` returning which square first holds at least `grains`.
    // EXAMPLE: `squaresNeeded(1)` -> `1`; `squaresNeeded(16)` -> `5`; `squaresNeeded(17)` -> `6`
    // BIGO: O(log N). The loop doubles a counter until it reaches N, the mirror image of halving.
    // NOTE: Square 64 holds 2^63 grains, one more than `Long.MAX_VALUE`, so a `long` counter overflows on the last square.
    static int squaresNeeded(long grains) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 3.5 | Count nested-loop steps | Practice
    // PROMPT: Write `static long allPairsSteps(int n)` (inner loop runs N times per outer step) and `static long uniquePairsSteps(int n)` (inner loop starts at `i + 1`). Both return the number of inner-loop iterations. Classify both.
    // EXAMPLE: `allPairsSteps(4)` -> `16`; `uniquePairsSteps(4)` -> `6`
    // BIGO: Both O(N^2). Unique pairs is N(N-1)/2, about half, and Big O ignores the 1/2.
    static long allPairsSteps(int n) {
        throw new UnsupportedOperationException();
    }

    static long uniquePairsSteps(int n) {
        throw new UnsupportedOperationException();
    }
    // ==== END
}
