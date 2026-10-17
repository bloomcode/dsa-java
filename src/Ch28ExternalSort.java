import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Chapter 28: Sorting data larger than memory.
 * The simulations use arrays to stand in for disk. M is how many items fit in memory, B how many move per I/O.
 */
public class Ch28ExternalSort {

    // ==== EX 28.1 | Make sorted runs that fit in memory | Core
    // PROMPT: Write `static List<int[]> makeRuns(int[] data, int M)` that cuts the input into pieces of at most M items and sorts each piece in memory.
    // EXAMPLE: `makeRuns(new int[]{5, 1, 9, 3, 7, 2, 8}, 3)` -> `[[1, 5, 9], [2, 3, 7], [8]]`
    // BIGO: O(N log M) CPU, one read and one write pass over the data.
    static List<int[]> makeRuns(int[] data, int M) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 28.2 | Two-way external mergesort | Core
    // PROMPT: Write `record Sorted(int[] data, int passes)` and `static Sorted twoWaySort(int[] data, int M)` that makes runs, then merges runs in pairs, pass after pass, until one run is left. Count the run-making pass too.
    // EXAMPLE: `twoWaySort(16 down to 1, 2)` -> data `1..16`, passes `4`: 8 runs, then 4, 2, 1
    // BIGO: 1 + ceil(log2(N / M)) passes over the data, each costing O(N / B) I/Os.
    record Sorted(int[] data, int passes) {}

    static Sorted twoWaySort(int[] data, int M) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 28.3 | Merge K sorted arrays with a heap | Core
    // PROMPT: Write `static int[] kWayMerge(List<int[]> lists)` with a `PriorityQueue<int[]>` of `{value, listIndex, position}` entries.
    // EXAMPLE: `kWayMerge([[1, 4, 9], [2, 3], [0, 10]])` -> `[0, 1, 2, 3, 4, 9, 10]`
    // BIGO: O(N log K) for N total items in K lists.
    static int[] kWayMerge(List<int[]> lists) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 28.4 | M/B-way mergesort | Core
    // PROMPT: Write `static Sorted multiwaySort(int[] data, int M, int B)` that makes runs of M items and then merges up to `M / B - 1` runs at a time (one input block per run plus one output block).
    // EXAMPLE: N = 10,000, M = 100, B = 10 -> 100 runs merged 9 at a time: passes `4` (versus 8 for two-way)
    // BIGO: 1 + ceil(log_{M/B}(N / M)) passes. The wider the fan-in, the fewer passes over the disk.
    static Sorted multiwaySort(int[] data, int M, int B) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 28.5 | Predict the passes | Core
    // PROMPT: Write `static int passesTwoWay(long N, long M)` and `static int passesMultiway(long N, long M, long B)` from the formulas, and check them against 28.2 and 28.4.
    // EXAMPLE: `passesTwoWay(10_000, 100)` -> `8`; `passesMultiway(10_000, 100, 10)` -> `4`
    // BIGO: O(log) arithmetic. Count the halvings with integers instead of `Math.log`, which can land a hair off an exact power of two.
    static int passesTwoWay(long N, long M) {
        throw new UnsupportedOperationException();
    }

    static int passesMultiway(long N, long M, long B) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 28.6 | Count the I/Os of an external sort | Practice
    // PROMPT: Write `static long externalSortIos(long N, long M, long B)`: every pass reads and writes the whole data set, which is N / B blocks each way.
    // EXAMPLE: `externalSortIos(10_000, 100, 10)` -> `8000` (4 passes x 2 x 1000 blocks)
    // BIGO: O((N / B) log_{M/B}(N / M)) I/Os, the known optimum for sorting in external memory.
    static long externalSortIos(long N, long M, long B) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 28.7 | Sort a real file that "does not fit" | Practice
    // PROMPT: Write `static int sortFile(Path src, Path dst, int maxItems)` that sorts a file of one integer per line using at most `maxItems` numbers in memory: write sorted runs to temporary files, then stream them through a heap of one reader per run into dst. Return the number of runs.
    // EXAMPLE: a file of 1,000 shuffled numbers with `maxItems = 100` -> dst holds them sorted, via 10 temporary run files
    // BIGO: O(N log N) CPU, two passes over the disk. The same code sorts files far larger than RAM.
    // NOTE: Open readers in try-with-resources or a `finally` block, and delete the temporary files even if the merge throws.
    static int sortFile(Path src, Path dst, int maxItems) throws IOException {
        throw new UnsupportedOperationException();
    }
    // ==== END
}
