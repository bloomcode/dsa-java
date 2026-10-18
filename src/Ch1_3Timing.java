import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

/** Chapter 1.3: Timing real code. */
public class Ch1_3Timing {

    // ==== EX 1.3.1 | Time one call with a monotonic clock | Core
    // PROMPT: Write `record Timed<T>(T result, double seconds)` and `static <T> Timed<T> timeOnce(Supplier<T> fn)` that reads `System.nanoTime()` before and after the call.
    // EXAMPLE: `timeOnce(() -> LongStream.range(0, 1_000_000).sum())` -> `Timed[result=499999500000, seconds=0.00...]`
    // BIGO: O(1) overhead. `nanoTime` is a monotonic clock for measuring intervals; `System.currentTimeMillis` can jump when the system clock changes.
    record Timed<T>(T result, double seconds) {}

    static <T> Timed<T> timeOnce(Supplier<T> fn) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 1.3.2 | Repeat and keep the minimum | Core
    // PROMPT: Write `static double bench(Runnable task, int number, int repeat)` that first runs `task` a few thousand times untimed, then times `repeat` batches of `number` calls and returns the best time per call. Explain why the minimum, not the average, is the usual summary.
    // EXAMPLE: `bench(() -> Arrays.sort(data.clone()), 100, 5)` -> a few microseconds for 1,000 ints
    // BIGO: O(number * repeat) calls, plus the warm-up.
    // NOTE: The JVM interprets code first and compiles hot methods later, so the first runs are far slower. Background noise only ever adds time, so the fastest batch is closest to the true cost. For serious work, use JMH.
    static double bench(Runnable task, int number, int repeat) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 1.3.3 | The sort-the-same-array gotcha | Core
    // PROMPT: Write `static double benchSort(Consumer<int[]> sortFn, int[] data, int repeat)` that sorts a fresh copy of `data` on every run and times only the sort, not the copy. Then show what goes wrong if every run sorts the same array.
    // EXAMPLE: `benchSort(Arrays::sort, descending10k, 5)` returns a small positive number of seconds
    // BIGO: O(repeat * cost of sortFn).
    // NOTE: An in-place sort leaves the array sorted, so runs 2..n time an already sorted input and look far faster than they are.
    static double benchSort(Consumer<int[]> sortFn, int[] data, int repeat) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 1.3.4 | Read the Big O off a benchmark | Core
    // PROMPT: Write `static double growthExponent(Map<Integer, Double> timings)` that takes `n -> seconds` for several sizes and returns the slope of log(time) against log(n). A slope near 1 means O(N), near 2 means O(N^2).
    // EXAMPLE: `growthExponent({1000=0.01, 2000=0.04, 4000=0.16})` -> `2.0`
    // BIGO: O(K) for K sizes (least-squares fit).
    static double growthExponent(Map<Integer, Double> timings) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 1.3.5 | A sorting race | Practice
    // PROMPT: Write `static List<String> race(Map<String, UnaryOperator<int[]>> sorts, int[] data)` where each function returns a new sorted array; return names ordered fastest first, checking every result is correct.
    // EXAMPLE: `race({builtin=..., mergesort=...}, data)` -> `[builtin, mergesort]` on most machines
    // BIGO: Sum of each sort's cost.
    static List<String> race(Map<String, UnaryOperator<int[]>> sorts, int[] data) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 1.3.6 | Quicksort on a sorted array | Core
    // PROMPT: Write `static long quicksortComparisons(int[] arr)` counting pivot comparisons for the quicksort from Chapter 3.2 with the last element as pivot, using an explicit stack of ranges. Compare sorted input with shuffled input of the same size.
    // EXAMPLE: `quicksortComparisons` of `0..99` in order -> `4950`; a shuffled array of 100 needs far fewer
    // BIGO: O(N^2) on sorted input with a last-element pivot, O(N log N) on average. The explicit stack avoids a 100,000-deep recursion on sorted input.
    static long quicksortComparisons(int[] arr) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 1.3.7 | Why adaptive sorts love runs | Practice
    // PROMPT: Write `static int countRuns(int[] arr)` returning the number of maximal ascending runs. The TimSort behind `List.sort` merges existing runs, so data with few runs sorts in close to O(N).
    // EXAMPLE: `countRuns(new int[]{1, 2, 3, 2, 5, 6, 1})` -> `3`; a sorted array -> `1`
    // BIGO: O(N).
    static int countRuns(int[] arr) {
        throw new UnsupportedOperationException();
    }
    // ==== END
}
