import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/** Chapter 5.5: B-trees and block storage. */
public class Ch5_5BTrees {

    // ==== EX 5.5.1 | Count I/Os, not steps | Core
    // PROMPT: Memory moves in blocks of B items. Write `static long scanIos(long n, int B)` for reading n items in order, and `static long randomReadsIos(long k)` for k reads that each land in a different block.
    // EXAMPLE: `scanIos(1000, 64)` -> `16`; `randomReadsIos(1000)` -> `1000`
    // BIGO: A scan costs O(N / B) I/Os; scattered access costs one I/O per item. On disk, I/Os dominate the running time.
    static long scanIos(long n, int B) {
        throw new UnsupportedOperationException();
    }

    static long randomReadsIos(long k) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 5.5.2 | Binary search over blocks | Core
    // PROMPT: Write `static class ExternalArray` whose `int[] readBlock(int i)` returns block i and counts one I/O, and `static int externalBinarySearch(ExternalArray ext, int target)` that binary-searches the blocks by their first item, then searches inside one block in memory.
    // EXAMPLE: 10,000 sorted items with B = 100 -> a lookup costs about 8 I/Os, versus about 14 for plain binary search touching one block per probe
    // BIGO: O(log(N / B)) I/Os, a small saving; the B-tree (5.5.4) does much better with O(log_B N).
    static class ExternalArray {
        final int[] data;
        final int B, blocks;
        int ios;

        ExternalArray(int[] data, int B) {
            throw new UnsupportedOperationException();
        }

        int[] readBlock(int i) {
            throw new UnsupportedOperationException();
        }
    }

    static int externalBinarySearch(ExternalArray ext, int target) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 5.5.3 | Lookups: BST versus B-tree | Core
    // PROMPT: Write `static int bstIos(long n)` (one I/O per level of a balanced binary tree, log2 N) and `static int btreeIos(long n, int B)` (log base B of N) and compare them for a billion keys.
    // EXAMPLE: `bstIos(1_000_000_000)` -> `30`; `btreeIos(1_000_000_000, 1000)` -> `3`
    // BIGO: O(log_2 N) versus O(log_B N) I/Os: a factor of log2 B fewer.
    // NOTE: Java has no log-to-any-base function: use `Math.log(n) / Math.log(B)`, and subtract a tiny epsilon before `Math.ceil` so an exact power such as 1000^3 does not round up to 4.
    static int bstIos(long n) {
        throw new UnsupportedOperationException();
    }

    static int btreeIos(long n, int B) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 5.5.4 | B-tree nodes and search | Core
    // PROMPT: Create `static class BTreeNode` with `boolean leaf`, sorted `List<Integer> keys` and `List<BTreeNode> children`, and `static class BTree` with minimum degree `t` and a `boolean search(int key)` that binary-searches each node's keys and descends into the right child.
    // EXAMPLE: in a B-tree holding 1..100 -> `search(42)` is `true`, `search(101)` is `false`
    // BIGO: O(log_t N) nodes visited, O(log t) comparisons in each.
    static class BTreeNode {
        final boolean leaf;
        List<Integer> keys = new ArrayList<>();
        List<BTreeNode> children = new ArrayList<>();

        BTreeNode(boolean leaf) { throw new UnsupportedOperationException(); }
    }

    static class BTree {
        final int t;
        BTreeNode root = new BTreeNode(true);

        BTree(int t) { throw new UnsupportedOperationException(); }

        /** First index whose key is >= key. */
        static int bisectLeft(List<Integer> keys, int key) {
            throw new UnsupportedOperationException();
        }

        boolean search(int key) {
            throw new UnsupportedOperationException();
        }
        // ==== END

        // ==== EX 5.5.5 | Insert with proactive splits | Core | class=BTree
        // PROMPT: Add `boolean insert(int key)`: if the root is full (2t - 1 keys), split it and grow a new root. Walk down, splitting any full child before entering it, so a leaf always has room.
        // EXAMPLE: t = 2, insert 1..10 -> `validate()` passes and every leaf sits at the same depth
        // BIGO: O(t log_t N) CPU, O(log_t N) node reads. The tree grows only at the root, which keeps it perfectly balanced.
        // NOTE: `subList` returns a view of the original list; wrap it in `new ArrayList<>(...)` before shortening the original, or the split corrupts both halves.
        void splitChild(BTreeNode parent, int i) {
            throw new UnsupportedOperationException();
        }

        boolean insert(int key) {
            throw new UnsupportedOperationException();
        }
        // ==== END

        // ==== EX 5.5.6 | Validate and walk in order | Core | class=BTree
        // PROMPT: Add `List<Integer> inorder()` returning all keys sorted, and `int validate()` that checks key counts per node, sorted keys, child counts, and that all leaves share one depth, throwing `IllegalStateException` on a violation. Return the height.
        // EXAMPLE: after random inserts and deletes -> `inorder()` equals the sorted set of keys and `validate()` returns the height
        // BIGO: O(N).
        List<Integer> inorder() {
            throw new UnsupportedOperationException();
        }

        private void walk(BTreeNode node, List<Integer> out) {
            throw new UnsupportedOperationException();
        }

        int validate() {
            throw new UnsupportedOperationException();
        }

        private void check(BTreeNode node, int depth, long lo, long hi, boolean isRoot, Set<Integer> depths) {
            throw new UnsupportedOperationException();
        }
        // ==== END

        // ==== EX 5.5.8 | Range queries, like a database index | Practice | class=BTree
        // PROMPT: Add `List<Integer> rangeQuery(int lo, int hi)` returning the keys in [lo, hi] in order, skipping whole subtrees that cannot contain them.
        // EXAMPLE: B-tree of 1..100 -> `rangeQuery(40, 45)` is `[40, 41, 42, 43, 44, 45]`
        // BIGO: O(log_t N + K / t) node visits for K results. This is why databases index with B-trees.
        List<Integer> rangeQuery(int lo, int hi) {
            throw new UnsupportedOperationException();
        }

        private void range(BTreeNode node, int lo, int hi, List<Integer> out) {
            throw new UnsupportedOperationException();
        }
        // ==== END

        // ==== EX 5.5.9 | Deletion | Stretch | class=BTree
        // PROMPT: Add `boolean delete(int key)`. Before descending into a child with only t - 1 keys, top it up by borrowing from a sibling or merging with one. Delete from a leaf directly; for an internal key, replace it with its predecessor or successor, or merge. Shrink the root when it empties.
        // EXAMPLE: t = 3, insert 1..200, delete the odd keys in shuffled order -> `validate()` passes and `inorder()` is the even keys
        // BIGO: O(log_t N) node visits.
        // NOTE: `keys.remove(i)` with an `int` removes by index; to remove a value from a `List<Integer>` you would need `remove(Integer.valueOf(x))`.
        boolean delete(int key) {
            throw new UnsupportedOperationException();
        }

        private void delete(BTreeNode node, int key) {
            throw new UnsupportedOperationException();
        }

        private void merge(BTreeNode node, int i) {
            throw new UnsupportedOperationException();
        }
        // ==== END
    }

    // ==== EX 5.5.7 | How tall can a B-tree get? | Core
    // PROMPT: Write `static int btreeHeightBound(long n, int t)` returning the most levels a B-tree of minimum degree t with n keys can have: 1 + floor(log_t((n + 1) / 2)). Check it against real trees.
    // EXAMPLE: `btreeHeightBound(1_000_000, 50)` -> `4`; a real tree of 1..10,000 with t = 3 stays within its bound of 8
    // BIGO: O(1). With t in the hundreds, a billion keys fit in 4 or 5 levels.
    static int btreeHeightBound(long n, int t) {
        throw new UnsupportedOperationException();
    }
    // ==== END
}
