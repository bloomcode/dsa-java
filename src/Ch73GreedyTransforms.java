import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/** Chapter 73: Greedy choices and problem transforms. */
public class Ch73GreedyTransforms {

    // ==== EX 73.1 | Pair with a given difference | Core
    // PROMPT: Write `static boolean hasPairWithDifference(int[] nums, int d)` for `d >= 0`: is there a pair of positions whose values differ by exactly `d`? Keep a set of values seen so far and check `x + d` and `x - d` before adding `x`.
    // EXAMPLE: `{1, 8, 4, 11}, 3` -> `true`; `{1, 5}, 3` -> `false`
    // BIGO: O(N): one pass with O(1) set lookups, instead of O(N^2) for every pair.
    static boolean hasPairWithDifference(int[] nums, int d) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 73.2 | Window with a target sum | Practice
    // PROMPT: For non-negative numbers, write `static int[] windowWithSum(int[] nums, int target)` returning `{i, j}` for the first run `nums[i..j]` (inclusive) that adds up to `target`, or `null`. Slide a window: grow it on the right, and shrink it from the left while its sum is too big.
    // EXAMPLE: `{2, 4, 3, 5, 1}, 8` -> `[2, 3]`; `{1, 2}, 7` -> `null`
    // BIGO: O(N): each index enters the window once and leaves it at most once.
    static int[] windowWithSum(int[] nums, int target) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 73.3 | Can you reach the end? | Core
    // PROMPT: From index `i` you may jump forward up to `jumps[i]` places. Write `static boolean canReachEnd(int[] jumps)` for a non-empty array: can you get from index 0 to the last index? Track the furthest index you could reach; if you ever stand beyond it, you are stuck.
    // EXAMPLE: `{2, 3, 1, 1, 4}` -> `true`; `{3, 2, 1, 0, 4}` -> `false`
    // BIGO: O(N): one pass keeping the furthest index reachable so far.
    static boolean canReachEnd(int[] jumps) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 73.4 | Rooms needed for meetings | Practice
    // PROMPT: Write `static int roomsNeeded(int[][] meetings)` for `{start, end}` pairs: the fewest rooms so no two meetings in one room overlap (a room is free again at its meeting's end time). Sort the starts and the ends separately and sweep through the starts.
    // EXAMPLE: `{{9, 11}, {10, 12}, {11, 13}, {9, 10}}` -> `2`
    // BIGO: O(N log N) for the two sorts, then one linear sweep.
    // NOTE: Sorting starts and ends separately loses which end belongs to which meeting, and that is fine: the count of rooms only depends on how many meetings are running at once.
    static int roomsNeeded(int[][] meetings) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 73.5 | Most meetings in one room | Core
    // PROMPT: Write `static int maxMeetings(int[][] meetings)` for `{start, end}` pairs: the largest number that fit in one room without overlapping (one may start when another ends). Sort by end time and keep each meeting that starts no earlier than the last one kept ends.
    // EXAMPLE: `{{1, 4}, {3, 5}, {0, 6}, {5, 7}, {8, 9}, {5, 9}}` -> `3`
    // BIGO: O(N log N): sort by end time, then one greedy pass.
    // NOTE: Taking the meeting that ends first always leaves the most time for the rest; taking the shortest, or the earliest to start, does not.
    static int maxMeetings(int[][] meetings) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 73.6 | Range totals after one pass | Core
    // PROMPT: Build `static class RangeSum` with a constructor `RangeSum(int[] nums)` that precomputes running totals, so `long total(int i, int j)` returns `nums[i] + ... + nums[j]` (inclusive) without a loop.
    // EXAMPLE: `new RangeSum(new int[]{3, 1, 4, 1, 5}).total(1, 3)` -> `6`
    // BIGO: O(N) once to build, then O(1) per query instead of O(N) per query.
    static class RangeSum {
        private final long[] prefix;

        RangeSum(int[] nums) {
            throw new UnsupportedOperationException();
        }

        long total(int i, int j) {
            throw new UnsupportedOperationException();
        }
    }
    // ==== END

    // ==== EX 73.7 | Most frequent words with buckets | Practice
    // PROMPT: Write `static List<String> topKFrequent(String[] words, int k)` returning the `k` most frequent words, most frequent first; words with equal counts keep the order in which they first appeared. Put each word into bucket number `count` and read the buckets from the top.
    // EXAMPLE: `{"b", "a", "b", "c", "a", "b"}, 2` -> `[b, a]`
    // BIGO: O(N): count once, then drop each word into a bucket indexed by its count instead of sorting.
    static List<String> topKFrequent(String[] words, int k) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 73.8 | The value without a partner | Core
    // PROMPT: Every value in `nums` appears exactly twice except one. Write `static int loneValue(int[] nums)` returning it in one pass with no extra memory, by combining everything with XOR (`^`).
    // EXAMPLE: `{4, 1, 2, 1, 2}` -> `4`
    // BIGO: O(N) time, O(1) space: `x ^ x` is 0 and `x ^ 0` is x, so every pair cancels out.
    static int loneValue(int[] nums) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 73.9 | Longest stretch without a repeat | Stretch
    // PROMPT: Write `static int longestUniqueRun(String s)` returning the length of the longest stretch of consecutive characters with no character repeated. Slide a window and remember where each character was last seen; on a repeat inside the window, move the start just past that earlier position.
    // EXAMPLE: `"abcadbe"` -> `5`; `"aaaa"` -> `1`
    // BIGO: O(N): each index enters the window once, and a table of last positions moves the start forward in one jump.
    static int longestUniqueRun(String s) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 73.10 | Least total waiting time | Core
    // PROMPT: One server handles jobs one at a time; each job waits for every job served before it. Write `static long leastTotalWaiting(int[] durations)` that returns the smallest possible sum of waiting times, choosing the order. Serve the shortest jobs first.
    // EXAMPLE: `[3, 2, 1, 2, 6]` -> `17`
    // BIGO: O(N log N) for the sort: a job's duration is waited for by every job after it, so the shortest should go first (swapping any out-of-order pair helps).
    static long leastTotalWaiting(int[] durations) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 73.11 | Pair tasks to finish soonest | Core
    // PROMPT: `tasks` has an even number of durations; each of `tasks.length / 2` workers does exactly two, one after the other. Write `static int pairFinishTime(int[] tasks)` that returns the smallest possible time for all workers to finish. Sort, then pair the shortest with the longest, inward.
    // EXAMPLE: `[5, 2, 1, 6, 4, 4]` -> `8`
    // BIGO: O(N log N) for the sort: pairing the shortest left with the longest left keeps every pair's total as close to the average as possible.
    static int pairFinishTime(int[] tasks) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 73.12 | Two-row photo | Practice
    // PROMPT: `red` and `blue` list the heights of two equal-sized teams. For a photo, one whole team stands in the back row and the other in front, and each back-row person must be strictly taller than the person in front of them. Write `static boolean canTakePhoto(int[] red, int[] blue)`. Sort both; the team with the tallest person goes in back; then compare column by column.
    // EXAMPLE: `[5, 8, 1, 3, 4], [6, 9, 2, 4, 5]` -> `true`
    // BIGO: O(N log N) for the sorts: if any arrangement works, putting both rows in height order works, so one comparison per column decides.
    static boolean canTakePhoto(int[] red, int[] blue) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 73.13 | Pairing riders for the fastest or slowest total | Practice
    // PROMPT: `red` and `blue` list the speeds of two equal-sized teams; each tandem has one rider from each and rides at the faster rider's speed. Write `static int tandemTotal(int[] red, int[] blue, boolean fastest)` that returns the largest possible sum of tandem speeds when `fastest` is `true`, and the smallest when it is `false`. Sort `red` ascending and `blue` descending (largest) or ascending (smallest), then pair by position.
    // EXAMPLE: `[5, 5, 3, 9, 2], [3, 6, 7, 2, 1], true` -> `32`; with `false` -> `25`
    // BIGO: O(N log N) for the sorts: a tandem bike goes at its faster rider's speed, so to raise the total pair fast with slow; to lower it, pair fast with fast.
    static int tandemTotal(int[] red, int[] blue, boolean fastest) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 73.14 | Where to start a loop | Practice
    // PROMPT: Stops `0` to `n - 1` sit on a loop. At stop `i` you take on `fuel[i]`, and driving to the next stop burns `cost[i]`. Write `static int loopStart(int[] fuel, int[] cost)` that returns the stop from which a car with an empty tank can drive all the way round (there is at most one), or `-1`. If the total fuel covers the total cost, the answer is the stop after the last point where the running tank went negative.
    // EXAMPLE: `[1, 5, 3, 3, 1], [3, 2, 4, 1, 1]` -> `1`
    // BIGO: O(N) time, O(1) space: if the tank runs dry going from a to b, no stop between a and b can be the start either, so the next candidate is b + 1.
    static int loopStart(int[] fuel, int[] cost) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 73.15 | Fewest rewards | Practice
    // PROMPT: People stand in a line with `scores`. Everyone gets at least one reward, and anyone scoring higher than a neighbour gets more rewards than that neighbour. Write `static int fewestRewards(int[] scores)` that returns the smallest total. Sweep left to right, then right to left, raising counts where a score beats its neighbour.
    // EXAMPLE: `[4, 2, 6, 3, 3, 1]` -> `9`
    // BIGO: O(N) time and space: one pass fixes every rising step from the left, a second fixes every rising step from the right, and taking the larger keeps both.
    static int fewestRewards(int[] scores) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 73.16 | Jobs with deadlines | Stretch
    // PROMPT: Each job `{deadline, profit}` takes one time slot and pays only if done in a slot `1` to `deadline`. Write `static int bestScheduleProfit(int[][] jobs)` that returns the largest total profit. Take jobs from most to least profitable and put each in the latest free slot on or before its deadline, skipping it if there is none.
    // EXAMPLE: `[[2, 50], [1, 10], [2, 40], [1, 30], [3, 20]]` -> `110`
    // BIGO: O(N log N + N * D) for the sort and the slot search (union-find over slots brings it to near O(N log N)): placing each job as late as its deadline allows leaves earlier slots for jobs with tighter deadlines.
    static int bestScheduleProfit(int[][] jobs) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 73.17 | Stable matching | Stretch
    // PROMPT: `proposerPrefs[p]` ranks acceptors `0` to `n - 1` for proposer `p`, best first, and `acceptorPrefs[a]` ranks proposers for acceptor `a`. Write `static int[] stableMatching(int[][] proposerPrefs, int[][] acceptorPrefs)` that returns `match`, where `match[p]` is p's acceptor, such that no proposer and acceptor both prefer each other to their partners. Free proposers propose down their lists; an acceptor keeps the best offer so far and frees the one it drops.
    // EXAMPLE: `[[0, 1, 2], [0, 2, 1], [1, 0, 2]], [[1, 0, 2], [0, 1, 2], [0, 1, 2]]` -> `[1, 0, 2]`
    // BIGO: O(N^2) time and space: each proposer proposes to each acceptor at most once, and a rank table answers 'who is preferred' in O(1).
    // NOTE: This is deferred acceptance: the result is the matching every proposer likes best among all stable ones, whatever order the proposals come in.
    static int[] stableMatching(int[][] proposerPrefs, int[][] acceptorPrefs) {
        throw new UnsupportedOperationException();
    }
    // ==== END
}
